package pl.karol.onlineshop.admin.product.service;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;

// Removed public because this should be used in this service catalog

class ExistingFileRenameUtils {
    public static String renameIfExists(Path uploadDir, String filename) {
        if (Files.exists(uploadDir.resolve(filename))) {
            return renameAndCheck(uploadDir, filename);
        }
        return filename;
    }

    private static String renameAndCheck(Path uploadDir, String filename) {
        String newName = renameFileName(filename);
        if(Files.exists(uploadDir.resolve(newName))) {
            newName = renameAndCheck(uploadDir, newName);
        }

        return newName;
    }

    private static String renameFileName(String filename) {
        String baseName = FilenameUtils.getBaseName(filename);
        String[] splittedFileName = baseName.split("-(?=[0-9]+$)");
        int counter = splittedFileName.length > 1 ? Integer.parseInt(splittedFileName[1]) + 1 : 1;
        return splittedFileName[0] + "-" + counter + "." + FilenameUtils.getExtension(filename);

    }
}
