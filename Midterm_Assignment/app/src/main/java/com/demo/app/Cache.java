package com.demo.app;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
class Cache implements CacheService{
    private static long avg;
    private static long count;
    private static long created;
    private static long max;
    private static long min;
    private static Map<Map<String, List<Air>>, Long> map = new HashMap<Map<String, List<Air>>, Long>();

    public Cache() {
        created = System.nanoTime();
        this.min = 10000000000L;
        this.max = 10000000000L;
        avg = (min + max) / 2;
    }


    public Cache(long min, long max) {
        created = System.nanoTime();
        this.min = min;
        this.max = max;
        avg = (min + max) / 2;
    }

    public static boolean add(Map<String, List<Air>> e) {
        String city = null;
        for (Iterator<Map.Entry<String, List<Air>>> it = e.entrySet().iterator(); it.hasNext();) {
            city = it.next().getKey();
        }

        boolean result = false;

        if(!Cache.contains(city) && city!=null) {
            map.put(e, Long.valueOf(System.nanoTime()));
            if(Cache.contains(city))
                result=true;
        }
        onAccess();
        return result;
    }

    public static boolean contains(String city) {
        for (Iterator<Map.Entry<Map<String, List<Air>>, Long>> it = map.entrySet().iterator(); it.hasNext();) {
            Map<String, List<Air>> resultados = it.next().getKey();
            for(String i: resultados.keySet()){
                if(i.equals(city))
                    return true;
            }
        }

        return false;
    }

    public List<Air> getValue(String city){
        onAccess();
        if(Cache.contains(city)){
            for (Iterator<Map.Entry<Map<String, List<Air>>, Long>> it = map.entrySet().iterator(); it.hasNext();) {
                Map<String, List<Air>> resultados = it.next().getKey();
                for(String i: resultados.keySet()){
                    if(i.equals(city))
                        return resultados.get(i);
                }
            }
        }
        return null;


    }

    private static void onAccess() {
        count++;
        long now = System.nanoTime();
        for (Iterator<Map.Entry<Map<String, List<Air>>, Long>> it = map.entrySet().iterator(); it.hasNext();) {
            long t = it.next().getValue();
            if (now > t + min && (now > t + max || now + (now - created) / count > t + avg)) {
                it.remove();
            }
        }
    }

    @Override
    public String toString() {
        onAccess();
        return "Cache{"  + map.toString() + "}";
    }
}
