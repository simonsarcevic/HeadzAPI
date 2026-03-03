package de.verdox.headzAPI;

import de.verdox.headzAPI.cache.SkullCache;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeadzAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, SkullCache::cleanUp, 20L * 60, 20L * 60);
    }
}
