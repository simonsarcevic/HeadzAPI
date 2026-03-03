package de.verdox.headzAPI.cache;

import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SkullCache {

    private static final Map<String, CachedSkull> CACHE = new ConcurrentHashMap<>();

    private static final long DEFAULT_TTL = 10 * 60 * 1000;

    public static ItemStack get(String texture){
        CachedSkull cached = CACHE.get(texture);

        if (cached == null){
            return null;
        }

        if (cached.isExpired()){
            CACHE.remove(texture);
            return null;
        }

        return cached.getItem().clone();
    }

    public static void put(String texture, ItemStack item){
        CACHE.put(texture, new CachedSkull(item, DEFAULT_TTL));
    }

    public static void clear(){
        CACHE.clear();
    }

    public static int size(){
        return CACHE.size();
    }

    public static void cleanUp(){
        CACHE.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }
}
