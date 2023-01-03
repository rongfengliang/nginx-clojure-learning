package com.dalong;

import nginx.clojure.java.ArrayMap;
import nginx.clojure.java.NginxJavaRingHandler;

import java.io.IOException;
import java.util.Map;

import static nginx.clojure.MiniConstants.*;

public class MyApp implements NginxJavaRingHandler {
    @Override
    public Object[] invoke(Map<String, Object> map) throws IOException {
        return new Object[] {
                NGX_HTTP_OK, //http status 200
                ArrayMap.create(CONTENT_TYPE, "text/plain"), //headers map
                "Hello, Java & Nginx!"  //response body can be string, File or Array/Collection of string or File
        };
    }
}
