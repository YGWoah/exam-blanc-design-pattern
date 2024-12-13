package me.massoudi.utils;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object getFromCache(String key) {
        return cache.get(key);
    }

    public static void addToCache(String key, Object value) {
        cache.put(key, value);
    }

    public static boolean isInCache(String key) {
        return cache.containsKey(key);
    }
}
