package xxrexraptorxx.bedrockminer.world;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import xxrexraptorxx.bedrockminer.main.References;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ModLootTables {
    public static final ResourceLocation LOOT_TABLE_BASIC = RegistrationHandler.register("dungeon_loot");


    public static void registerLootTables() {
    }

    public static class RegistrationHandler {
        private static final Method REGISTER = ObfuscationReflectionHelper.findMethod(LootTables.class, "func_186375_a" /* register */, ResourceLocation.class);

        public static ResourceLocation register(final String name) {
            final ResourceLocation id = new ResourceLocation(References.MODID, name);

            try {
                return (ResourceLocation) REGISTER.invoke(null, id);
            } catch (final IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Failed to register loot table " + id, e);
            }
        }
    }
}