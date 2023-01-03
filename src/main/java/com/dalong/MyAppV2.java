package com.dalong;

import nginx.clojure.java.*;
import nginx.clojure.java.NginxJavaHeaderFilter;
import org.hashids.Hashids;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class MyAppV2 implements NginxJavaHeaderFilter {
    static  Hashids hashids = new Hashids("this is my salt");
    @Override
    public Object[] doFilter(int i, Map<String, Object> map, Map<String, Object> responseHeaders) throws IOException {
        String hash = hashids.encode(UUID.randomUUID().hashCode());
        System.out.println(hash);
        responseHeaders.remove("Content-Type");
        responseHeaders.put("Content-Type", "text/html");
        responseHeaders.put("Xfeep-Header", "Hello2!");
        responseHeaders.put("MYKEY",hash);
        responseHeaders.put("Server", "My-Test-Server");
        return Constants.PHASE_DONE;
    }
}
