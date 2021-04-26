package com.demo.app;

import java.util.List;
import java.util.Map;

public interface CacheService {

    public static boolean add(Map<String, List<Air>> e) {
        return false;
    }

    public static boolean contains(String city) {
        return false;
    }

    public List<Air> getValue(String city);
}
