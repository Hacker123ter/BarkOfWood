package org.dw363.barkofwood;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class BarkOfWood extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        ItemStack item = event.getItem();
        if (item == null || item.getType() != Material.BONE_MEAL) {
            return;
        }

        Block block = event.getClickedBlock();
        if (block == null) {
            return;
        }

        Material blockType = block.getType();
        Material newBlockType = null;
        boolean isStrippedWood = false;

        switch (blockType) {
            case STRIPPED_OAK_LOG:
                newBlockType = Material.OAK_LOG;
                isStrippedWood = true;
                break;
            case STRIPPED_SPRUCE_LOG:
                newBlockType = Material.SPRUCE_LOG;
                isStrippedWood = true;
                break;
            case STRIPPED_BIRCH_LOG:
                newBlockType = Material.BIRCH_LOG;
                isStrippedWood = true;
                break;
            case STRIPPED_JUNGLE_LOG:
                newBlockType = Material.JUNGLE_LOG;
                isStrippedWood = true;
                break;
            case STRIPPED_ACACIA_LOG:
                newBlockType = Material.ACACIA_LOG;
                isStrippedWood = true;
                break;
            case STRIPPED_DARK_OAK_LOG:
                newBlockType = Material.DARK_OAK_LOG;
                isStrippedWood = true;
                break;
            case STRIPPED_CRIMSON_STEM:
                newBlockType = Material.CRIMSON_STEM;
                isStrippedWood = true;
                break;
            case STRIPPED_WARPED_STEM:
                newBlockType = Material.WARPED_STEM;
                isStrippedWood = true;
                break;

            case STRIPPED_OAK_WOOD:
                newBlockType = Material.OAK_WOOD;
                isStrippedWood = true;
                break;
            case STRIPPED_SPRUCE_WOOD:
                newBlockType = Material.SPRUCE_WOOD;
                isStrippedWood = true;
                break;
            case STRIPPED_BIRCH_WOOD:
                newBlockType = Material.BIRCH_WOOD;
                isStrippedWood = true;
                break;
            case STRIPPED_JUNGLE_WOOD:
                newBlockType = Material.JUNGLE_WOOD;
                isStrippedWood = true;
                break;
            case STRIPPED_ACACIA_WOOD:
                newBlockType = Material.ACACIA_WOOD;
                isStrippedWood = true;
                break;
            case STRIPPED_DARK_OAK_WOOD:
                newBlockType = Material.DARK_OAK_WOOD;
                isStrippedWood = true;
                break;
            case STRIPPED_CRIMSON_HYPHAE:
                newBlockType = Material.CRIMSON_HYPHAE;
                isStrippedWood = true;
                break;
            case STRIPPED_WARPED_HYPHAE:
                newBlockType = Material.WARPED_HYPHAE;
                isStrippedWood = true;
                break;
            case STRIPPED_BAMBOO_BLOCK:
                newBlockType = Material.BAMBOO_BLOCK;
                isStrippedWood = true;
                break;
            case STRIPPED_CHERRY_LOG:
                newBlockType = Material.CHERRY_LOG;
                isStrippedWood = true;
                break;
            case STRIPPED_CHERRY_WOOD:
                newBlockType = Material.CHERRY_WOOD;
                isStrippedWood = true;
                break;
            case STRIPPED_MANGROVE_LOG:
                newBlockType = Material.MANGROVE_LOG;
                isStrippedWood = true;
                break;
            case STRIPPED_MANGROVE_WOOD:
                newBlockType = Material.MANGROVE_WOOD;
                isStrippedWood = true;
                break;

            default:
                break;
        }

        if (newBlockType != null) {
            block.setType(newBlockType);
            item.setAmount(item.getAmount() - 1);

            if (isStrippedWood) {
                block.getWorld().spawnParticle(Particle.HAPPY_VILLAGER, block.getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, 0.1);
                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_WOOD_PLACE, 1.0f, 1.0f);
            }

            event.setCancelled(true);
        }
    }
}