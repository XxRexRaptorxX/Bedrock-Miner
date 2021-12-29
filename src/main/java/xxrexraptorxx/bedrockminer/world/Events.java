package xxrexraptorxx.bedrockminer.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import xxrexraptorxx.bedrockminer.main.ModItems;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.utils.Config;
import xxrexraptorxx.bedrockminer.utils.UpdateChecker;

public class Events {

    // Update-Checker //

    private boolean hasShownUp = false;


    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (Config.UPDATE_CHECKER.get()) {
            if (UpdateChecker.isNewVersionAvailable() && !hasShownUp && Minecraft.getInstance().currentScreen == null) {

                ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, References.URL);
                Style clickableChatStyle = new Style().setClickEvent(versionCheckChatClickEvent);
                Minecraft.getInstance().player.sendMessage(new StringTextComponent(TextFormatting.BLUE + "A newer version of " + TextFormatting.YELLOW + References.NAME + TextFormatting.BLUE + " is available!"));
                StringTextComponent versionWarningChatComponent = new StringTextComponent(TextFormatting.GRAY + "Click here to update!");
                versionWarningChatComponent.setStyle(clickableChatStyle);
                Minecraft.getInstance().player.sendMessage(versionWarningChatComponent);

                hasShownUp = true;
            }
        }
    }



    // Dungeon loot //

    @SubscribeEvent
    public static void lootTableLoad(final LootTableLoadEvent event) {
        if (Config.LOOT_GENERATION.get()) {
            if (event.getName().equals(LootTables.CHESTS_STRONGHOLD_CORRIDOR)) {
                event.getTable().addPool(
                        LootPool.builder()
                                .name(ModLootTables.LOOT_TABLE_BASIC.toString())
                                .rolls(new RandomValueRange(0, 1))
                                .bonusRolls(0, 1)
                                .addEntry(
                                        TableLootEntry.builder(ModLootTables.LOOT_TABLE_BASIC)
                                )
                                .build()
                );
            }
            if (event.getName().equals(LootTables.CHESTS_STRONGHOLD_CROSSING)) {
                event.getTable().addPool(
                        LootPool.builder()
                                .name(ModLootTables.LOOT_TABLE_BASIC.toString())
                                .rolls(new RandomValueRange(0, 1))
                                .bonusRolls(0, 1)
                                .addEntry(
                                        TableLootEntry.builder(ModLootTables.LOOT_TABLE_BASIC)
                                )
                                .build()
                );
            }
        }
    }



    // Bedrock mining //

    @SubscribeEvent
    public void onPlayerMineBlock(PlayerInteractEvent.LeftClickBlock event) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        BlockState blockstate = world.getBlockState(pos);
        Block block = world.getBlockState(pos).getBlock();
        PlayerEntity player = event.getPlayer();

        if (player.inventory.getCurrentItem() == null){
            block.getBlock().getHarvestLevel.; setHardness(-1.0F);

        }
        else if(block == Blocks.BEDROCK || block == Blocks.END_PORTAL_FRAME) {
            event.setUseItem(event.getUseItem().ALLOW);
            event.setUseBlock(event.getUseBlock().ALLOW);

            if(player.inventory.getCurrentItem().getItem() == ModItems.BEDROCK_PICKAXE) {

                block.setHardness(ConfigGeneral.bedrockHardness);

                player.inventory.getCurrentItem().getItem();



            } else if(player.inventory.getCurrentItem().getItem() != ModItems.BEDROCK_PICKAXE) {
                block.setHardness(-1.0F);
            }
        }
    }


    @SubscribeEvent
    public void bedrockHarvestEvent(BlockEvent.HarvestDropsEvent event) {
        World world = event.getWorld().getWorld();
        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        PlayerEntity player = event.getHarvester();
        ItemEntity entityitem = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Blocks.BEDROCK));

        if(state.getBlock() == Blocks.BEDROCK){
            if(world.getBlockState(pos.down()).getBlock() == Blocks.AIR) {
                player.entityDropItem(new ItemStack(Blocks.BEDROCK), 1);
            } else {
                world.addEntity(entityitem);
            }

        }
    }


    @SubscribeEvent
    public void specialHarvestEvent(BlockEvent.HarvestDropsEvent event) {
        World world = event.getWorld().getWorld();
        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        PlayerEntity player = event.getHarvester();
        ItemEntity entityitem = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Blocks.END_PORTAL_FRAME));

        if(state.getBlock() == Blocks.END_PORTAL_FRAME){
            if(world.getBlockState(pos.down()).getBlock() == Blocks.AIR) {
                player.entityDropItem(new ItemStack(Blocks.END_PORTAL_FRAME), 1);
            } else {
                world.addEntity(entityitem);
            }

        }
    }


}
