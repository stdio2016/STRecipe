package com.stdio2016.strecipemod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashSet;
import java.util.List;
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
        OreDictionary.registerOre("listAllmilk", Items.MILK_BUCKET);
        most();
        if (Loader.isModLoaded("ic2")) {
            System.out.println("IIIIII CCCCCC 222222");
            ic();
        }
        if (Loader.isModLoaded("buildcraftbuilders")) {
            System.out.println("BBBBB CCCCC");
            //tooNewRecipes();
        }
        //woolRecolor();
        //ddd();
        System.out.println("STRecipeMod loaded successfully. Enjoy!");
    }

    private final static ItemStack
            ink = new ItemStack(Items.DYE, 1, 0),
            red = new ItemStack(Items.DYE, 1, 1),
            green = new ItemStack(Items.DYE, 1, 2),
            cocoa = new ItemStack(Items.DYE, 1, 3),
            lapis = new ItemStack(Items.DYE, 1, 4),
            purple = new ItemStack(Items.DYE, 1, 5),
            cyan = new ItemStack(Items.DYE, 1, 6),
            lightGray = new ItemStack(Items.DYE, 1, 7),
            gray = new ItemStack(Items.DYE, 1, 8),
            pink = new ItemStack(Items.DYE, 1, 9),
            lime = new ItemStack(Items.DYE, 1, 10),
            yellow = new ItemStack(Items.DYE, 1, 11),
            lightBlue = new ItemStack(Items.DYE, 1, 12),
            magenta = new ItemStack(Items.DYE, 1, 13),
            orange = new ItemStack(Items.DYE, 1, 14),
            boneMeal = new ItemStack(Items.DYE, 1, 15);

    private final static ItemStack
            whiteWool = new ItemStack(Blocks.WOOL, 1, 0),
            orangeWool = new ItemStack(Blocks.WOOL, 1, 1),
            magentaWool = new ItemStack(Blocks.WOOL, 1, 2),
            lightBlueWool = new ItemStack(Blocks.WOOL, 1, 3),
            yellowWool = new ItemStack(Blocks.WOOL, 1, 4),
            limeWool = new ItemStack(Blocks.WOOL, 1, 5),
            pinkWool = new ItemStack(Blocks.WOOL, 1, 6),
            grayWool = new ItemStack(Blocks.WOOL, 1, 7),
            lightGrayWool = new ItemStack(Blocks.WOOL, 1, 8),
            cyanWool =  new ItemStack(Blocks.WOOL, 1, 9),
            purpleWool = new ItemStack(Blocks.WOOL, 1, 10),
            brownWool = new ItemStack(Blocks.WOOL, 1, 12),
            greenWool = new ItemStack(Blocks.WOOL, 1, 13),
            redWool = new ItemStack(Blocks.WOOL, 1, 14),
            blackWool = new ItemStack(Blocks.WOOL, 1, 15);

    private final static ItemStack podzol = new ItemStack(Blocks.DIRT, 1, 2);

    private synchronized void most() {
        // coal
        helpAddShapedRecipe("copycoal",new ItemStack(Blocks.COAL_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(Items.COAL, 1, 0) // coal
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

    private void ic() {
        Item ore = Item.getByNameOrId("ic2:resource");
        Item ingot = Item.getByNameOrId("ic2:ingot");
        final int COPPER_ORE_META = 1, COPPER_INGOT_META = 2;
        if (ore == null || ingot == null) {
            throw new RuntimeException("Unable to get item from id");
        }
        helpAddShapelessRecipe("make_copperore", new ItemStack(ore, 1, COPPER_ORE_META),
                orange, orange,
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe("copycopper", new ItemStack(ore, 5, COPPER_ORE_META),
                "SmS", "mSm", "SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(ingot, 1, COPPER_INGOT_META)
        );
        final int TIN_ORE_META = 3, TIN_INGOT_META = 6;
        helpAddShapelessRecipe("make_tinore", new ItemStack(ore, 1, TIN_ORE_META),
                boneMeal,
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe("copytin", new ItemStack(ore, 5, TIN_ORE_META),
                "SmS", "mSm", "SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(ingot, 1, TIN_INGOT_META)
        );
        final int LEAD_ORE_META = 2, LEAD_INGOT_META = 3;
        helpAddShapelessRecipe("make_leadore", new ItemStack(ore, 1, LEAD_ORE_META),
                gray, gray, gray, gray,
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe("copylead", new ItemStack(ore, 5, LEAD_ORE_META),
                "SmS", "mSm", "SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(ingot, 1, LEAD_INGOT_META)
        );
        Item nuclear = Item.getByNameOrId("ic2:nuclear");
        if (nuclear == null) {
            throw new RuntimeException("Unable to get item from id");
        }
        final int URANIUM_ORE_META = 4, U235_TINY_PILE_META = 5, U238_META = 2;
        helpAddShapelessRecipe("make_uraniumore", new ItemStack(ore, 1, URANIUM_ORE_META),
                lime, lime, lime, lime,
                lime, lime, lime, lime,
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe("copyuranium", new ItemStack(ore, 1, URANIUM_ORE_META),
                "SmS", "mcm", "SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(nuclear, 1, U238_META),
                'c', new ItemStack(nuclear, 1, U235_TINY_PILE_META)
        );
        Item misc_resource = Item.getByNameOrId("ic2:misc_resource");
        if (misc_resource == null) {
            throw new RuntimeException("Unable to get item from id");
        }
        final int IRIDIUM_SHARD_META = 2;
        helpAddShapelessRecipe("make_iridium_shard", new ItemStack(misc_resource, 1, IRIDIUM_SHARD_META),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                Blocks.COBBLESTONE
        );
        // slime + cocoa -> sticky resins
        final int STICKY_RESIN_META = 4;
        helpAddShapelessRecipe("sticky_resin", new ItemStack(misc_resource, 1, STICKY_RESIN_META),
                Items.SLIME_BALL,
                cocoa
        );
    }

    synchronized private void tooNewRecipes() {
        // new in 2017/7/3
        Item blueprint = Item.getByNameOrId("buildcraftbuilders:snapshot");
        final int BLUEPRINT_META = 2;
        helpAddShapelessRecipe("blueprint", new ItemStack(blueprint, 1, BLUEPRINT_META),
                new ItemStack(Blocks.WOOL, 1, 11) // blue
        );
        // new in 2017/7/15
        Item diamondGear = Item.getByNameOrId("buildcraftcore:gear_diamond");
        Item goldGear = Item.getByNameOrId("buildcraftcore:gear_gold");
        Block landmark = Block.getBlockFromName("buildcraftcore:marker_volume");
        ItemStack yellow = new ItemStack(Items.DYE, 1, 11);
        ItemStack black = new ItemStack(Items.DYE, 1, 0);

        Block builder = Block.getBlockFromName("buildcraftbuilders:builder");
        Block filler = Block.getBlockFromName("buildcraftbuilders:filler");

        Block architectTable = Block.getBlockFromName("buildcraftbuilders:architect");
        Block blueprintLibrary = Block.getBlockFromName("buildcraftbuilders:library");
        helpAddShapedRecipe("builder", new ItemStack(builder),
                "kLk","yTy","gCg",
                'k', black, 'L', landmark, 'y', yellow, 'T', Blocks.CRAFTING_TABLE,
                'g', diamondGear, 'C', Blocks.CHEST);
        helpAddShapedRecipe("filler", new ItemStack(filler),
                "kLk","yTy","gCg",
                'k', black, 'L', landmark, 'y', yellow, 'T', Blocks.CRAFTING_TABLE,
                'g', goldGear, 'C', Blocks.CHEST);
        helpAddShapedRecipe("architect", new ItemStack(architectTable),
                "kLk","yTy","gpg",
                'k', black, 'L', landmark, 'y', yellow, 'T', Blocks.CRAFTING_TABLE,
                'g', diamondGear, 'p', new ItemStack(blueprint, 1, BLUEPRINT_META));
        helpAddShapedRecipe("library", new ItemStack(blueprintLibrary),
                "ppp","pSp","ppp",
                'p', new ItemStack(blueprint, 1, BLUEPRINT_META), 'S', Blocks.BOOKSHELF);

        // new in 2017/8/28
        Item emzuliPipe = Item.getByNameOrId("buildcrafttransport:pipe_emzuli_item");
        helpAddShapedRecipe("emzuli_pipe", new ItemStack(emzuliPipe, 8),
                "lge",
                'l', Blocks.LAPIS_BLOCK, 'g', Blocks.GLASS, 'e', Items.EMERALD);
        Item stripedPipe = Item.getByNameOrId("buildcrafttransport:pipe_stripes_item");
        helpAddShapedRecipe("striped_pipe", new ItemStack(stripedPipe, 8),
                "ege",
                'e', goldGear, 'g', Blocks.GLASS);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}