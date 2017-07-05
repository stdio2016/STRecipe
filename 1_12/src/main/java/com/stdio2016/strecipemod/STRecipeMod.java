package com.stdio2016.strecipemod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * This mod adds only recipes
 */
@Mod(modid = STRecipeMod.MODID, version = STRecipeMod.VERSION)
public class STRecipeMod
{
    public static final String MODID = "strecipemod";
    public static final String VERSION = "0.1";
    // recipe ID counter
    private int r;

    private void helpAddRecipe(ItemStack resultStack, int width, int height, Object[] inputs) {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        for (Object input : inputs) {
            ingredients.add(CraftingHelper.getIngredient(input));
        }
        String name = MODID + ":" + resultStack.getUnlocalizedName() + ".LaJi" + String.valueOf(r);
        IRecipe recipeFluid = new ShapedRecipes(name, width, height, ingredients, resultStack);
        recipeFluid.setRegistryName(new ResourceLocation(name));
        ForgeRegistries.RECIPES.register(recipeFluid);
    }

    private void helpAddShapelessRecipe(ItemStack resultStack, Object[] inputs) {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        for (Object input : inputs) {
            ingredients.add(CraftingHelper.getIngredient(input));
        }
        String name = MODID + ":" + resultStack.getUnlocalizedName() + ".LaJi" + String.valueOf(r);
        IRecipe recipeFluid = new ShapelessRecipes(name, resultStack, ingredients);
        recipeFluid.setRegistryName(new ResourceLocation(name));
        ForgeRegistries.RECIPES.register(recipeFluid);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        r=0;
        Object cobble = Blocks.COBBLESTONE, coal = Items.COAL;
        r=0;
        helpAddRecipe(new ItemStack(Blocks.COAL_ORE, 5), 3, 3, new Object[] {
                cobble, coal, cobble,
                coal, cobble, coal,
                cobble, coal, cobble
        });
        Object water = Items.WATER_BUCKET, lava = Items.LAVA_BUCKET, none = Items.AIR;
        r=1;
        helpAddRecipe(new ItemStack(Blocks.COAL_ORE, 5), 3, 1, new Object[] {
                water, none, lava,
        });
        r=1;
        helpAddShapelessRecipe(new ItemStack(Blocks.IRON_ORE, 1), new Object[]{
                new ItemStack(Items.DYE, /* amount */1, /* meta */ 15), // bone mill
                new ItemStack(Items.DYE, /* amount */1, /* meta */ 15), // bone mill
                new ItemStack(Blocks.COBBLESTONE, 1)
        });
        r=2;
        Object iron = Items.IRON_INGOT;
        helpAddRecipe(new ItemStack(Blocks.IRON_ORE, 5), 3, 3, new Object[] {
                cobble, iron, cobble,
                iron, cobble, iron,
                cobble, iron, cobble
        });
        r=3;
        helpAddShapelessRecipe(new ItemStack(Blocks.GOLD_ORE, 1), new Object[]{
                new ItemStack(Items.DYE, /* amount */1, /* meta */ 14), // orange
                new ItemStack(Items.DYE, /* amount */1, /* meta */ 14), // orange
                new ItemStack(Blocks.COBBLESTONE, 1)
        });
        r=4;
        Object gold = Items.GOLD_INGOT;
        helpAddRecipe(new ItemStack(Blocks.GOLD_ORE, 5), 3, 3, new Object[] {
                cobble, gold, cobble,
                gold, cobble, gold,
                cobble, gold, cobble
        });
        r=5;
        helpAddShapelessRecipe(new ItemStack(Blocks.DIAMOND_ORE, 1), new Object[]{
                new ItemStack(Items.DYE, /* amount */1, /* meta */ 4), // lapis
                new ItemStack(Items.DYE, /* amount */1, /* meta */ 4), // lapis
                new ItemStack(Blocks.COBBLESTONE, 1)
        });
        r=6;
        Object diamond = Items.DIAMOND;
        helpAddRecipe(new ItemStack(Blocks.DIAMOND_ORE, 5), 3, 3, new Object[] {
                cobble, diamond, cobble,
                diamond, cobble, diamond,
                cobble, diamond, cobble
        });
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());

    }
}
