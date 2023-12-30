package pl.karol.onlineshop.admin.product.service;

import com.github.slugify.Slugify;
import org.apache.commons.io.FilenameUtils;

// Removed public because this should be used in this service catalog
class UploadedFilesNameUtils {

    public static String slugifyFileName(String filename) {
        String name = FilenameUtils.getBaseName(filename);
        Slugify slugify = Slugify.builder().build();
        String changedName = slugify.slugify(name);

        return changedName + "." + FilenameUtils.getExtension(filename);

    }
}
