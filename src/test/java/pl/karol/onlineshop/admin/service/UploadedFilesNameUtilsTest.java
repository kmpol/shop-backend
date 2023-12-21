package pl.karol.onlineshop.admin.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UploadedFilesNameUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "test test.png, test-test.png",
            "ąćęłńóśźż.png, acelnoszz.png",
            "Product 1.png, product-1.png"
    })
    void shouldSlugifyFileName(String in, String out) {
        String result = UploadedFilesNameUtils.slugifyFileName(in);
        assertEquals(result, out);
    }

}