package xxrexraptorxx.bedrockminer.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import xxrexraptorxx.bedrockminer.utils.CreativeTab;

public class ItemBasic extends Item {

    public ItemBasic() {
        super(new Properties()
                .tab(CreativeTab.MOD_TAB)
        );
    }

}