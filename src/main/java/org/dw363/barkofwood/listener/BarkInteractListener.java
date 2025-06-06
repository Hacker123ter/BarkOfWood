package org.dw363.barkofwood.listener;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.dw363.barkofwood.logic.BarkRestorer;

public class BarkInteractListener implements Listener {

    private final BarkRestorer restorer = new BarkRestorer();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;

        ItemStack item = event.getItem();
        if (item == null || item.getType() != Material.BONE_MEAL) return;

        Block block = event.getClickedBlock();
        if (block == null) return;

        if (restorer.tryRestore(block)) {
            item.setAmount(item.getAmount() - 1);
            block.getWorld().spawnParticle(Particle.HAPPY_VILLAGER, block.getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, 0.1);
            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_WOOD_PLACE, 1.0f, 1.0f);
            event.setCancelled(true);
        }
    }
}