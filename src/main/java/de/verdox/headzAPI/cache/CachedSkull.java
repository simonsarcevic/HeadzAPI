package de.verdox.headzAPI.cache;

import org.bukkit.inventory.ItemStack;

public class CachedSkull {

    private final ItemStack item;
    private final long expireAt;

    public CachedSkull(ItemStack item, long ttl){
        this.item = item.clone();
        this.expireAt = System.currentTimeMillis() + ttl;
    }

    public boolean isExpired(){
        return System.currentTimeMillis() > expireAt;
    }

    public ItemStack getItem(){
        return item;
    }
}
