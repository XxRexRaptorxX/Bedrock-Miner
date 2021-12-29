package xxrexraptorxx.bedrockminer.utils;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import xxrexraptorxx.bedrockminer.main.ModItems;

public enum ToolMaterials implements IItemTier {

        bedrockTM   (3, Config.TOOL_DURABILITY.get(), Config.TOOL_EFFICIENCY.get().floatValue(), Config.TOOL_DAMAGE.get().floatValue(), Config.TOOL_ENCHANTABILITY.get(), ModItems.BEDROCK_CHUNK);


    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;


    private ToolMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, int enchantability, Item repairMaterial) {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }
}