package xxrexraptorxx.bedrockminer.registry;

import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import xxrexraptorxx.bedrockminer.main.References;
import xxrexraptorxx.bedrockminer.world.ChestLootEnhancerModifier;

public class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, References.MODID);

    public static void init(IEventBus eventBus) { LOOT_MODIFIER_SERIALIZERS.register(eventBus); }

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<ChestLootEnhancerModifier>> ADD_ITEM = LOOT_MODIFIER_SERIALIZERS.register("add_item", ChestLootEnhancerModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}