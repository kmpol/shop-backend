package pl.karol.onlineshop.utils;

import com.github.slugify.Slugify;

import java.util.function.Function;

public class SlugifyUtilFunction implements Function<String, String> {

    @Override
    public String apply(String arg) {
        Slugify slug = Slugify
                .builder()
                .customReplacement("_", "-")
                .build();
        return slug.slugify(arg);
    }
}
