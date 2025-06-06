package org.dw363.barkofwood.logic;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.dw363.barkofwood.util.StripMappings;

public class BarkRestorer {

    public boolean tryRestore(Block block) {
        Material original = block.getType();
        Material restored = StripMappings.getOriginalFromStripped(original);

        if (restored != null) {
            block.setType(restored);
            return true;
        }
        return false;
    }
}