package xxrexraptorxx.bedrockminer.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.bedrockminer.blocks.BlockBedrockBreaker;
import xxrexraptorxx.bedrockminer.blocks.BlockFakeBedrock;
import xxrexraptorxx.bedrockminer.main.References;

import java.util.function.Function;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(References.MODID);

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }


    public static final DeferredBlock<Block> BEDROCK_INFUSED_OBSIDIAN = registerBlock("bedrock_infused_obsidian", properties -> new Block(properties
            .strength(100, 4000)
            .sound(SoundType.STONE)
            .mapColor(MapColor.COLOR_BLACK)
            .pushReaction(PushReaction.BLOCK)
    ));

    public static final DeferredBlock<BlockBedrockBreaker> BEDROCK_BREAKER = registerBlock("bedrock_breaker", properties -> new BlockBedrockBreaker(properties
            .strength(5, 10)
            .sound(SoundType.STONE)
            .mapColor(MapColor.COLOR_GRAY)
    ));

    public static final DeferredBlock<BlockFakeBedrock> FAKE_BEDROCK = registerBlock("fake_bedrock", properties -> new BlockFakeBedrock(properties
            .strength(150.0F, 3600000.0F)
            .sound(SoundType.STONE)
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .pushReaction(PushReaction.BLOCK)
            .isValidSpawn((state, level, pos, value) -> false)
            .requiresCorrectToolForDrops()
    ));


    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> blockCreator) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, () -> blockCreator.apply(BlockBehaviour.Properties.of().setId(blockId(name))));
        registerBlockItems(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ModItems.itemId(name)).useBlockDescriptionPrefix()));
    }

    public static ResourceKey<Block> blockId(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(References.MODID, name));
    }

}
