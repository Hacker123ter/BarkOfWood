package org.dw363.barkofwood.util;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class StripMappings {
    private static final Map<Material, Material> STRIPPED_TO_NORMAL = new HashMap<>();

    static {
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_OAK_LOG, Material.OAK_LOG);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_SPRUCE_LOG, Material.SPRUCE_LOG);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_BIRCH_LOG, Material.BIRCH_LOG);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_JUNGLE_LOG, Material.JUNGLE_LOG);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_ACACIA_LOG, Material.ACACIA_LOG);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_DARK_OAK_LOG, Material.DARK_OAK_LOG);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_CRIMSON_STEM, Material.CRIMSON_STEM);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_WARPED_STEM, Material.WARPED_STEM);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_OAK_WOOD, Material.OAK_WOOD);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_SPRUCE_WOOD, Material.SPRUCE_WOOD);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_BIRCH_WOOD, Material.BIRCH_WOOD);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_JUNGLE_WOOD, Material.JUNGLE_WOOD);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_ACACIA_WOOD, Material.ACACIA_WOOD);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_DARK_OAK_WOOD, Material.DARK_OAK_WOOD);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_CRIMSON_HYPHAE, Material.CRIMSON_HYPHAE);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_WARPED_HYPHAE, Material.WARPED_HYPHAE);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_BAMBOO_BLOCK, Material.BAMBOO_BLOCK);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_CHERRY_LOG, Material.CHERRY_LOG);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_CHERRY_WOOD, Material.CHERRY_WOOD);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_MANGROVE_LOG, Material.MANGROVE_LOG);
        STRIPPED_TO_NORMAL.put(Material.STRIPPED_MANGROVE_WOOD, Material.MANGROVE_WOOD);
    }

    public static Material getOriginalFromStripped(Material stripped) {
        return STRIPPED_TO_NORMAL.get(stripped);
    }
}