package pl.karol.onlineshop.admin.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ExistingFileRenameUtilsTest {

    @SneakyThrows
    @Test
    void shouldRenameExistingFile(@TempDir Path tempDir) {
        Files.createFile(tempDir.resolve("test.png"));
        String result = ExistingFileRenameUtils.renameIfExists(tempDir, "test.png");
        assertEquals("test-1.png", result);
    }

    @SneakyThrows
    @Test
    void shouldNotRenameExistingFile(@TempDir Path tempDir) {
        String result = ExistingFileRenameUtils.renameIfExists(tempDir, "test.png");
        assertEquals("test.png", result);
    }

    @SneakyThrows
    @Test
    void shouldRenameExistingFileFewTimes(@TempDir Path tempDir) {
        Files.createFile(tempDir.resolve("test.png"));
        Files.createFile(tempDir.resolve("test-1.png"));
        Files.createFile(tempDir.resolve("test-2.png"));
        Files.createFile(tempDir.resolve("test-3.png"));
        String result = ExistingFileRenameUtils.renameIfExists(tempDir, "test.png");
        assertEquals("test-4.png", result);
    }
}