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
        // Регистрируем наш класс как слушателя событий
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Проверяем, что игрок использует основную руку (не левую)
        if (event.getHand() != EquipmentSlot.HAND) {
            return; // Если это не основная рука, ничего не делаем
        }

        // Получаем предмет в руке игрока
        ItemStack item = event.getItem();
        // Проверяем, что предмет существует и это костная мука
        if (item == null || item.getType() != Material.BONE_MEAL) {
            return; // Если это не костная мука, выходим из метода
        }

        // Получаем блок, по которому игрок кликнул
        Block block = event.getClickedBlock();
        // Проверяем, что блок существует
        if (block == null) {
            return; // Если блок не найден, выходим из метода
        }

        // Определяем тип блока
        Material blockType = block.getType();
        // Переменная для хранения нового типа блока
        Material newBlockType = null;
        // Флаг для определения, является ли древесина очищенной
        boolean isStrippedWood = false;

        // Проверяем тип блока и устанавливаем новый тип, если это очищенная древесина
        switch (blockType) {
            // Если блок очищенная древесина (древесина), заменяем на обычную древесину
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

            // Добавляем новые блоки для преобразования
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
                // Если тип блока не совпадает, ничего не делаем
                break;
        }

        // Если мы определили новый тип блока
        if (newBlockType != null) {
            // Меняем тип блока на новый
            block.setType(newBlockType);
            // Уменьшаем количество костной муки на 1
            item.setAmount(item.getAmount() - 1);

            // Если это очищенная древесина, добавляем эффекты
            if (isStrippedWood) {
                // Показываем зелёные частицы и проигрываем звук
                block.getWorld().spawnParticle(Particle.HAPPY_VILLAGER, block.getLocation().add(0.5, 0.5, 0.5), 30, 0.5, 0.5, 0.5, 0.1);
                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_WOOD_PLACE, 1.0f, 1.0f);
            }

            // Отменяем стандартное действие, чтобы предотвратить его выполнение
            event.setCancelled(true);
        }
    }
}