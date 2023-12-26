package pl.karol.onlineshop.admin.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.karol.onlineshop.admin.controller.dto.AdminProductDto;
import pl.karol.onlineshop.admin.controller.dto.UploadResponse;
import pl.karol.onlineshop.admin.model.AdminProduct;
import pl.karol.onlineshop.admin.service.AdminProductImageService;
import pl.karol.onlineshop.admin.service.AdminProductService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/products")
public class AdminProductController {

    private final AdminProductService adminProductService;
    private final AdminProductImageService productImageService;

    @GetMapping
    public Page<AdminProduct> getProducts(Pageable pageable) {
        return adminProductService.getProducts(pageable);
    }

    @GetMapping(path = "{productId}")
    public AdminProduct getProduct(@PathVariable Long productId) {
        return adminProductService.getProduct(productId);
    }

    @PostMapping
    public AdminProduct saveProduct(@RequestBody @Valid AdminProductDto adminProductDto) {
        return adminProductService.createProduct(adminProductDto);
    }

    @PutMapping(path = "{productId}")
    public AdminProduct updateProduct(@RequestBody @Valid AdminProductDto updates, @PathVariable Long productId) {
        return adminProductService.updateProduct(updates, productId);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        adminProductService.deleteProduct(productId);
    }

    //TODO: Refactor this, create new controller in new package
    @PostMapping(path = "/upload-image")
    public UploadResponse uploadImage(@RequestParam("file") MultipartFile multipartFile) {
        try(InputStream inputStream = multipartFile.getInputStream()) {
            String savedFileName = productImageService.uploadImage(multipartFile.getOriginalFilename(), inputStream);
            return new UploadResponse(savedFileName);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong during file save", e);
        }
    }

    //TODO: Refactor this, create a new method in new controller in new package
    @GetMapping(path = "/files/{filename}")
    public ResponseEntity<Resource> serveFiles(@PathVariable String filename) throws IOException {
        Resource file = productImageService.serveFiles(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Path.of(filename)))
                .body(file);
    }
}
