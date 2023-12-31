package pl.karol.onlineshop.utils;


import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

import java.util.function.Function;

public class JsoupUtilFunction implements Function<String, String> {

    @Override
    public String apply(String text) {
        return Jsoup.clean(text, Safelist.none());
    }
}
