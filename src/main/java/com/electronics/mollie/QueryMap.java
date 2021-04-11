package com.electronics.mollie;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.StringJoiner;

public class QueryMap extends HashMap<String, String> {
    public static QueryMap NONE = new QueryMap();

    /**
     * Generate query url.
     * @return Query url
     */
    public String toQueryUrl() {
        if (isEmpty()) {
            return "";
        }

        StringJoiner stringJoiner = new StringJoiner("&", "?", "");
        forEach((key, value) -> stringJoiner.add(key + "=" + URLEncoder.encode(value, StandardCharsets.UTF_8)));
        return stringJoiner.toString();
    }
}
