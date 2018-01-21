package com.stdio2016.strecipemod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashSet;
import java.util.Set;

/**
 * This mod adds only recipes
 */
@Mod(modid = STRecipeMod.MODID, version = STRecipeMod.VERSION)
public class STRecipeMod
{
    public static final String MODID = "strecipemod";
    public static final String VERSION = "3.0";
    private static final Set<String> uniqueNames = new HashSet<>();

    private void uniqueNameCheck(String uniqueName) {
        if (uniqueNames.contains(uniqueName)) {
            throw new IllegalArgumentException("Craft recipe unique name clash");
        }
        uniqueNames.add(uniqueName);
    }

    private void helpAddShapedRecipe(String uniqueName,ItemStack resultStack, Object...inputs) {
        uniqueNameCheck(uniqueName);
        RecipeConverter recipe = new RecipeConverter(inputs);
        NonNullList<Ingredient> ingredients = NonNullList.create();
        for (Object input : recipe.inputs) {
            if (input == null) { // empty sot
                ingredients.add(Ingredient.EMPTY);
            }
            else
                ingredients.add(CraftingHelper.getIngredient(input));
        }
        String name = MODID + ":" + uniqueName;
        IRecipe recipeFluid = new ShapedRecipes(name, recipe.width, recipe.height, ingredients, resultStack);
        recipeFluid.setRegistryName(new ResourceLocation(name));
        ForgeRegistries.RECIPES.register(recipeFluid);
    }

    private void helpAddShapelessRecipe(String uniqueName,ItemStack resultStack, Object...inputs) {
        uniqueNameCheck(uniqueName);
        NonNullList<Ingredient> ingredients = NonNullList.create();
        for (Object input : inputs) {
            ingredients.add(CraftingHelper.getIngredient(input));
        }
        String name = MODID + ":" + uniqueName;
        IRecipe recipeFluid = new ShapelessRecipes(name, resultStack, ingredients);
        recipeFluid.setRegistryName(new ResourceLocation(name));
        ForgeRegistries.RECIPES.register(recipeFluid);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        most();
    }

    private synchronized void most() {
        ItemStack ink = new ItemStack(Items.DYE, 1, 0);
        ItemStack red = new ItemStack(Items.DYE, 1, 1);
        ItemStack green = new ItemStack(Items.DYE, 1, 2);
        ItemStack cocoa = new ItemStack(Items.DYE, 1, 3);
        ItemStack lapis = new ItemStack(Items.DYE, 1, 4);
        ItemStack purple = new ItemStack(Items.DYE, 1, 5);
        ItemStack cyan = new ItemStack(Items.DYE, 1, 6);
        ItemStack lightGray = new ItemStack(Items.DYE, 1, 7);
        ItemStack gray = new ItemStack(Items.DYE, 1, 8);
        ItemStack pink = new ItemStack(Items.DYE, 1, 9);
        ItemStack lime = new ItemStack(Items.DYE, 1, 10);
        ItemStack yellow = new ItemStack(Items.DYE, 1, 11);
        ItemStack lightBlue = new ItemStack(Items.DYE, 1, 12);
        ItemStack magenta = new ItemStack(Items.DYE, 1, 13);
        ItemStack orange = new ItemStack(Items.DYE, 1, 14);
        ItemStack boneMeal = new ItemStack(Items.DYE, 1, 15);

        ItemStack whiteWool = new ItemStack(Blocks.WOOL, 1, 0);
        ItemStack orangeWool = new ItemStack(Blocks.WOOL, 1, 1);
        ItemStack magentaWool = new ItemStack(Blocks.WOOL, 1, 2);
        ItemStack lightBlueWool = new ItemStack(Blocks.WOOL, 1, 3);
        ItemStack yellowWool = new ItemStack(Blocks.WOOL, 1, 4);
        ItemStack limeWool = new ItemStack(Blocks.WOOL, 1, 5);
        ItemStack pinkWool = new ItemStack(Blocks.WOOL, 1, 6);
        ItemStack grayWool = new ItemStack(Blocks.WOOL, 1, 7);
        ItemStack lightGrayWool = new ItemStack(Blocks.WOOL, 1, 8);
        ItemStack cyanWool =  new ItemStack(Blocks.WOOL, 1, 9);
        ItemStack purpleWool = new ItemStack(Blocks.WOOL, 1, 10);
        ItemStack brownWool = new ItemStack(Blocks.WOOL, 1, 12);
        ItemStack greenWool = new ItemStack(Blocks.WOOL, 1, 13);
        ItemStack redWool = new ItemStack(Blocks.WOOL, 1, 14);
        ItemStack blackWool = new ItemStack(Blocks.WOOL, 1, 15);

        ItemStack podzol = new ItemStack(Blocks.DIRT, 1, 2);
        // coal
        helpAddShapedRecipe("copycoal",new ItemStack(Blocks.COAL_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.COAL
        );

        // iron
        helpAddShapelessRecipe("make_ironore", new ItemStack(Blocks.IRON_ORE, 1),
                boneMeal, boneMeal, boneMeal,
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe("copyiron", new ItemStack(Blocks.IRON_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.IRON_INGOT
        );

        // gold
        // UPDATE: need 4 orange dye instead of 3
        helpAddShapelessRecipe("make_goleore", new ItemStack(Blocks.GOLD_ORE, 1),
                orange, orange, orange, orange,
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe("copygold", new ItemStack(Blocks.GOLD_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.GOLD_INGOT
        );

        // diamond
        // UPDATE: need 4 lapis
        helpAddShapelessRecipe("make_diamondore", new ItemStack(Blocks.DIAMOND_ORE, 1),
                lapis, lapis, lapis, lapis,
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe("copydiamond", new ItemStack(Blocks.DIAMOND_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.STONEBRICK,
                'm', Items.DIAMOND
        );

        // redstone
        // UPDATE: need 2 red dye instead of 1
        helpAddShapelessRecipe("make_redstone", new ItemStack(Items.REDSTONE, 1),
                red, red,
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe("copyredstone", new ItemStack(Blocks.REDSTONE_ORE, 2),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.REDSTONE
        );

        // lapis
        // UPDATE: tweak clone ability
        helpAddShapelessRecipe("make_lapis", new ItemStack(Items.DYE, 1, 4), // lapis
                new ItemStack(Blocks.STONE, 1, 3), // diorite
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET
        );
        helpAddShapedRecipe("copylapis", new ItemStack(Blocks.LAPIS_ORE, 1),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', lapis
        );

        // emerald
        helpAddShapelessRecipe("make_emeraldore", new ItemStack(Blocks.EMERALD_ORE, 1),
                green, green, green,
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe("copyemerald", new ItemStack(Blocks.EMERALD_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.STONEBRICK,
                'm', Items.EMERALD
        );

        // lots of strange recipes with cobblestone
        helpAddShapedRecipe("obsidian_by_ink", new ItemStack(Blocks.OBSIDIAN, 1),
                "ii","Si",
                'S', Blocks.COBBLESTONE,
                'i', ink
        );
        // rose red -> redstone
        // cactus green -> emerald
        // cocoa bean formula new in 2018/1/17
        helpAddShapelessRecipe("dirt_by_coccoa", new ItemStack(Blocks.DIRT, 16),
                cocoa,
                Blocks.COBBLESTONE
        );
        // lapis -> clone lapis
        helpAddShapelessRecipe("ender_pearl_by_purple", new ItemStack(Items.ENDER_PEARL, 1),
                purple, purple,
                Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe("snow_by_cyan", new ItemStack(Blocks.SNOW, 8),
                cyan,
                Blocks.COBBLESTONE, Blocks.COBBLESTONE,
                Blocks.COBBLESTONE, Blocks.COBBLESTONE,
                Blocks.COBBLESTONE, Blocks.COBBLESTONE,
                Blocks.COBBLESTONE, Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe("clay_by_lightgray", new ItemStack(Blocks.CLAY, 2),
                lightGray,
                Blocks.COBBLESTONE, Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe("gunpowder_by_gray", new ItemStack(Items.GUNPOWDER, 1),
                gray,
                Blocks.COBBLESTONE
        );
        // update in 2018/1/17: expensive
        helpAddShapelessRecipe("chorus_flower_by_pink", new ItemStack(Blocks.CHORUS_FLOWER, 1),
                pink, pink, pink, pink,
                pink, pink, pink, pink,
                Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe("slime_by_lime", new ItemStack(Blocks.SLIME_BLOCK, 1),
                lime, lime, lime,
                Blocks.COBBLESTONE
        );
        // UPDATE: need 2 yellow dye instead of 1
        helpAddShapelessRecipe("glowstone_by_yellow", new ItemStack(Items.GLOWSTONE_DUST, 1),
                yellow, yellow,
                Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe("prismarine_shard_by_lightblue", new ItemStack(Items.PRISMARINE_SHARD, 1),
                lightBlue,
                Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe("end_stone_by_magenta", new ItemStack(Blocks.END_STONE, 1),
                magenta, magenta, magenta, magenta,
                Blocks.COBBLESTONE
        );
        // orange -> gold
        // bone meal -> iron

        // water + cobblestone*6 -> gravel*6
        helpAddShapelessRecipe("gravel_by_wash", new ItemStack(Blocks.GRAVEL, 6),
                Items.WATER_BUCKET,
                Blocks.COBBLESTONE,Blocks.COBBLESTONE,Blocks.COBBLESTONE,
                Blocks.COBBLESTONE,Blocks.COBBLESTONE,Blocks.COBBLESTONE
        );
        // water + gravel*6 -> sand*6
        helpAddShapelessRecipe("sand_by_wash", new ItemStack(Blocks.SAND, 6),
                Items.WATER_BUCKET,
                Blocks.GRAVEL,Blocks.GRAVEL,Blocks.GRAVEL,
                Blocks.GRAVEL,Blocks.GRAVEL,Blocks.GRAVEL
        );
        // water + sand*6 -> dirt
        helpAddShapelessRecipe("dirt_by_wash", new ItemStack(Blocks.DIRT, 6),
                Items.WATER_BUCKET,
                Blocks.SAND,Blocks.SAND,Blocks.SAND,
                Blocks.SAND,Blocks.SAND,Blocks.SAND
        );

        // podzol
        helpAddShapedRecipe("podzel", new ItemStack(Blocks.DIRT, 5, 2),
                "dgd","gdg","dgd",
                'd', Blocks.DIRT,
                'g', Blocks.TALLGRASS
        );

        // sponge
        helpAddShapedRecipe("sponge", new ItemStack(Blocks.SPONGE),
                ".i.","iyi",".i.",
                'i', ink, // ink sac
                'y', yellowWool // yellow wool
        );

        // water + lava
        helpAddShapedRecipe("water_and_lava_cobble", new ItemStack(Blocks.COBBLESTONE, 6),
                "W.L",
                'W', Items.WATER_BUCKET,
                'L',Items.LAVA_BUCKET
        );
        helpAddShapedRecipe("water_and_lava_obsidian", new ItemStack(Blocks.OBSIDIAN, 2),
                ".W.","...","LSL",
                'W', Items.WATER_BUCKET,
                'L',Items.LAVA_BUCKET,
                'S', Blocks.STONE
        );

        // nether quartz
        helpAddShapedRecipe("copyquartz", new ItemStack(Blocks.QUARTZ_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.NETHERRACK,
                'm', Items.QUARTZ
        );

        // lava
        helpAddShapelessRecipe("lava_to_magma", new ItemStack(Blocks.MAGMA, 4),
                Blocks.STONE,Blocks.STONE,
                Blocks.STONE,
                Items.LAVA_BUCKET
        );
        helpAddShapelessRecipe("magma_to_lava", new ItemStack(Items.LAVA_BUCKET, 1),
                Blocks.MAGMA,Blocks.MAGMA,Blocks.MAGMA,
                Items.BUCKET
        );

        // soul sand
        helpAddShapedRecipe("soul_sand", new ItemStack(Blocks.SOUL_SAND, 4),
                "SmS","mSm","SmS",
                'S', Blocks.SAND,
                'm', Blocks.SAPLING
        );

        // oak sapling
        helpAddShapedRecipe("oak_sapling", new ItemStack(Blocks.SAPLING, 1),
                ".g.","gsg",".s.",
                'g', Blocks.TALLGRASS,
                's', Items.STICK
        );

        // burn crafting table
        GameRegistry.addSmelting(Blocks.CRAFTING_TABLE, new ItemStack(Items.COAL, 1,1), 0.1f);

        // prismarine crystal
        GameRegistry.addSmelting(Items.PRISMARINE_SHARD, new ItemStack(Items.PRISMARINE_CRYSTALS), 0.1f);

        // new recipes!
        // glowstone
        helpAddShapedRecipe("copyglowstone", new ItemStack(Blocks.GLOWSTONE, 2),
                "GgG","gGg","GgG",
                'G', Blocks.GLASS,
                'g', Items.GLOWSTONE_DUST
        );
        // grass
        helpAddShapelessRecipe("make_grass", new ItemStack(Blocks.TALLGRASS, 4, 1),
                Items.WHEAT_SEEDS,
                new ItemStack(Blocks.DIRT, 1, OreDictionary.WILDCARD_VALUE)
        );

        // wood
        // meta is 0~5
        for (int i=0; i<6; i++) {
            Block log = i<4?Blocks.LOG:Blocks.LOG2;
            helpAddShapedRecipe("grow_wood_quickly_"+i, new ItemStack(log, 6, i&3),
                    "W", "b", "s",
                    'W', Items.WATER_BUCKET,
                    'b', boneMeal,
                    's', new ItemStack(Blocks.SAPLING, 1, i)
            );
        }

        // end stone -> bone block
        GameRegistry.addSmelting(Blocks.END_STONE, new ItemStack(Blocks.BONE_BLOCK), 0.1f);

        // charcoal + ink sac -> coal
        helpAddShapelessRecipe("charcoal_to_coal", new ItemStack(Items.COAL, 1, 0), // coal
                new ItemStack(Items.COAL, 1, 1), // charcoal
                ink
        );

        // wash andesite to get quartz
        helpAddShapelessRecipe("quartz_by_wash", new ItemStack(Items.QUARTZ, 1), // quartz
                new ItemStack(Blocks.STONE, 1, 5), // andesite
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET
        );

        // new in 2017/7/3
        helpAddShapelessRecipe("shulker_shell", new ItemStack(Items.SHULKER_SHELL, 1),
                pinkWool,pinkWool, pinkWool, pinkWool,
                lightBlueWool, lightBlueWool, lightBlueWool, lightBlueWool
        );
        helpAddShapelessRecipe("magma_cream", new ItemStack(Items.MAGMA_CREAM,3),
                Blocks.MAGMA);
        helpAddShapedRecipe("packed_ice", new ItemStack(Blocks.PACKED_ICE),
                "ii","ii", 'i', Blocks.ICE);
        helpAddShapelessRecipe("netherrack", new ItemStack(Blocks.NETHERRACK),
                new ItemStack(Blocks.STONE, 1, 1), // granite
                Items.WATER_BUCKET);
        helpAddShapelessRecipe("mycelium", new ItemStack(Blocks.MYCELIUM),
                grayWool, grayWool, grayWool, grayWool,
                purpleWool, purpleWool, purpleWool, purpleWool
        );
        helpAddShapelessRecipe("elytra", new ItemStack(Items.ELYTRA),
                lightGrayWool, lightGrayWool, lightGrayWool, lightGrayWool,
                magentaWool, magentaWool, magentaWool, magentaWool
        );
        helpAddShapelessRecipe("rabbit_foot", new ItemStack(Items.RABBIT_FOOT),
                yellowWool, yellowWool, yellowWool, yellowWool,
                whiteWool, whiteWool, whiteWool, whiteWool
        );
        helpAddShapedRecipe("web", new ItemStack(Blocks.WEB),
                "sss","sss","sss",'s',Items.STRING);
        helpAddShapelessRecipe("string", new ItemStack(Items.STRING, 4),
                Blocks.WEB);
        helpAddShapelessRecipe("blaze_rod", new ItemStack(Items.BLAZE_ROD),
                Items.GLOWSTONE_DUST, Items.GUNPOWDER, Items.STICK);
        helpAddShapedRecipe("nether_star", new ItemStack(Items.NETHER_STAR),
                "gqg","qdq","gqg",
                'g', Items.GLOWSTONE_DUST,
                'q', Items.QUARTZ,
                'd', Items.DIAMOND);
        helpAddShapelessRecipe("feather", new ItemStack(Items.FEATHER, 4),
                Items.STRING,
                boneMeal
        );
        helpAddShapelessRecipe("red_sand", new ItemStack(Blocks.SAND, 1, 1), // red sand
                orangeWool, redWool,
                Blocks.SAND
        );
        helpAddShapelessRecipe("crown_fish", new ItemStack(Items.FISH, 1, 2), // clownfish
                orangeWool, orangeWool, whiteWool
        );
        helpAddShapelessRecipe("pumpkin", new ItemStack(Blocks.PUMPKIN),
                orangeWool, brownWool
        );
        helpAddShapelessRecipe("salmon", new ItemStack(Items.FISH, 1, 1), // salmon
                orangeWool, redWool, redWool
        );
        helpAddShapelessRecipe("puffer_fish", new ItemStack(Items.FISH, 1, 3), // pufferfish
                yellowWool,
                Items.POISONOUS_POTATO
        );
        helpAddShapelessRecipe("ice", new ItemStack(Blocks.ICE),
                cyanWool,
                Blocks.GLASS
        );
        helpAddShapelessRecipe("melon_block", new ItemStack(Blocks.MELON_BLOCK),
                limeWool, greenWool
        );
        helpAddShapelessRecipe("cactus", new ItemStack(Blocks.CACTUS),
                greenWool, blackWool
        );

        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new ItemStack(Items.POTIONITEM, 1, 0), // water bottle
                yellowWool,
                new ItemStack(Items.EXPERIENCE_BOTTLE)
        ));
        helpAddShapelessRecipe("useless_spawn_egg", new ItemStack(Items.SPAWN_EGG),
                boneMeal,
                Items.EGG
        );
        helpAddShapelessRecipe("diorite_by_milk_wash",
                new ItemStack(Blocks.STONE, 1, 3), // diorite
                new ItemStack(Blocks.COBBLESTONE, 1), // stone
                "listAllmilk"
        );
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new ItemStack(Items.POTIONITEM, 1, 0), // water bottle
                new ItemStack(Items.SPAWN_EGG, 1),
                new ItemStack(Items.EXPERIENCE_BOTTLE)
        ));
        // NEW IN 2017/8/15
        helpAddShapedRecipe("make_paper_by_stick", new ItemStack(Items.PAPER),
                "xxx", 'x', Items.STICK);
        helpAddShapedRecipe("make_string_by_stick", new ItemStack(Items.STRING),
                "x","x","x", 'x', Items.STICK);
        // new in 2018/1/17
        helpAddShapelessRecipe("make_coalore", new ItemStack(Blocks.COAL_ORE),
                Blocks.COBBLESTONE,
                ink, ink
        );
        helpAddShapelessRecipe("cocoa_bean", new ItemStack(Items.DYE, 3), // cocoa bean
                Items.WHEAT_SEEDS,
                podzol, podzol, podzol, podzol,
                podzol, podzol, podzol, podzol
        );
        helpAddShapelessRecipe("chorus_fruit_to_apple", new ItemStack(Items.APPLE),
                red,
                Items.CHORUS_FRUIT
        );
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());

    }
}