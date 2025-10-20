package xxrexraptorxx.bedrockminer.world;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.registry.ModBlocks;
import xxrexraptorxx.bedrockminer.registry.ModItems;
import xxrexraptorxx.bedrockminer.utils.Config;
import xxrexraptorxx.magmacore.content.BlockHelper;
import xxrexraptorxx.magmacore.utils.FormattingHelper;

import java.util.List;

@EventBusSubscriber(modid = References.MODID, bus = EventBusSubscriber.Bus.GAME)
public class Events {

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        if (Config.getWanderingTrades()) {
            List<VillagerTrades.ItemListing> trades = event.getRareTrades();
            ItemCost cost = new ItemCost(Items.EMERALD, 6);

            trades.add(((trader, random) -> new MerchantOffer(cost, new ItemStack(ModItems.BEDROCK_CHUNK.get()), 3, 1, 0.05F)));
        }
    }


    @SubscribeEvent
    public static void ReplaceBedrock(PlayerInteractEvent.LeftClickBlock event) {
        Item item = event.getItemStack().getItem();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Block block = level.getBlockState(pos).getBlock();

        if (!level.isClientSide) {
            if (block == Blocks.BEDROCK && item == ModItems.BEDROCK_PICKAXE.get()) {
                level.setBlock(pos, ModBlocks.FAKE_BEDROCK.get().defaultBlockState(), 2);
            }
            if (block == ModBlocks.FAKE_BEDROCK.get() && item != ModItems.BEDROCK_PICKAXE.get()) {
                level.setBlock(pos, Blocks.BEDROCK.defaultBlockState(), 2);
            }
        }
    }


    @SubscribeEvent
    public static void addingToolTips(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        List<Component> list = event.getToolTip();

        if (BlockHelper.isMatching(ModBlocks.BEDROCK_BREAKER.get(), item)) {
            list.add(FormattingHelper.setModLangComponent("message", References.MODID, "bedrock_breaker.desc", ChatFormatting.GRAY));
        }
    }

}
