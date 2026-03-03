package de.verdox.headzAPI.builder;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.UUID;

public class SkullBuilder {

    private final ItemStack item;
    private final SkullMeta meta;

    private SkullBuilder(){
        item = new ItemStack(Material.PLAYER_HEAD);
        meta = (SkullMeta) item.getItemMeta();
    }

    public static SkullBuilder create(){
        return new SkullBuilder();
    }

    public SkullBuilder texture(String texture){
        PlayerProfile profile = Bukkit.createProfile(UUID.randomUUID());
        profile.setProperty(new ProfileProperty("textures", texture));
        meta.setPlayerProfile(profile);
        return this;
    }

    public SkullBuilder lore(String... lore){
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemStack build(){
        item.setItemMeta(meta);
        return item;
    }
}
