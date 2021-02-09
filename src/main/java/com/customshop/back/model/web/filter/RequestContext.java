package com.customshop.back.model.web.filter;

import java.util.HashMap;
import java.util.Map;

public class RequestContext {
    public static final String AUTH_TOKEN = "Authorization";

    private static final ThreadLocal<Map<String, Object>> reqCtx = new ThreadLocal<>();

    private RequestContext() {

    }

    public static Map<String, Object> getRequestContext() {
        return reqCtx.get();
    }

    public static Object get(String key) {
        Map<String, Object> contextMap = reqCtx.get();
        return contextMap != null ? contextMap.get(key) : "";
    }

    public static void put(String key, Object value) {
        Map<String, Object> contextData = reqCtx.get();
        if (contextData == null)
            reqCtx.set(new HashMap<String, Object>());
        reqCtx.get().put(key, value);
    }

    public static void clear() {
        if (reqCtx.get() != null)
            reqCtx.get().clear();
    }

}
