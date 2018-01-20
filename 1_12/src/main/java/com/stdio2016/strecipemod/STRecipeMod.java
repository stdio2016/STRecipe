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
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * This mod adds only recipes
 */
@Mod(modid = STRecipeMod.MODID, version = STRecipeMod.VERSION)
public class STRecipeMod
{
    public static final String MODID = "strecipemod";
    public static final String VERSION = "3.0";
    // recipe ID counter
    private int recipeId;

    private void helpAddShapedRecipe(ItemStack resultStack, Object...inputs) {
        RecipeConverter recipe = new RecipeConverter(inputs);
        NonNullList<Ingredient> ingredients = NonNullList.create();
        for (Object input : recipe.inputs) {
            ingredients.add(CraftingHelper.getIngredient(input));
        }
        String name = MODID + ":" + resultStack.getUnlocalizedName() + ".LaJi" + String.valueOf(recipeId);
        IRecipe recipeFluid = new ShapedRecipes(name, recipe.width, recipe.height, ingredients, resultStack);
        recipeFluid.setRegistryName(new ResourceLocation(name));
        ForgeRegistries.RECIPES.register(recipeFluid);
    }

    private void helpAddShapelessRecipe(ItemStack resultStack, Object...inputs) {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        for (Object input : inputs) {
            ingredients.add(CraftingHelper.getIngredient(input));
        }
        String name = MODID + ":" + resultStack.getUnlocalizedName() + ".LaJi" + String.valueOf(recipeId);
        IRecipe recipeFluid = new ShapelessRecipes(name, resultStack, ingredients);
        recipeFluid.setRegistryName(new ResourceLocation(name));
        ForgeRegistries.RECIPES.register(recipeFluid);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        most();
    }

    private synchronized void most() {
        // coal
        recipeId = 0;
        helpAddShapedRecipe(new ItemStack(Blocks.COAL_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.COAL
        );

        // iron
        recipeId = 0;
        helpAddShapelessRecipe(new ItemStack(Blocks.IRON_ORE, 1),
                new ItemStack(Items.DYE, 1, 15), // bone meal
                new ItemStack(Items.DYE, 1, 15),
                new ItemStack(Items.DYE, 1, 15),
                Blocks.COBBLESTONE
        );
        recipeId = 1;
        helpAddShapedRecipe(new ItemStack(Blocks.IRON_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.IRON_INGOT
        );

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());

    }
}
