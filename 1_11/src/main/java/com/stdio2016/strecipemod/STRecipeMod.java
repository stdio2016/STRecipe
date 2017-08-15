package com.stdio2016.strecipemod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.Map;

@Mod(modid = STRecipeMod.MODID, version = STRecipeMod.VERSION)
public class STRecipeMod
{
    public static final String MODID = "strecipemod";
    public static final String VERSION = "2.2";

    @NetworkCheckHandler
    public boolean check(Map<String, String> something, Side side) {
        // this mod does not depend on any other mod
        // on server multi player, clients don't need to install this mod
        return true;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        OreDictionary.registerOre("listAllmilk", Items.MILK_BUCKET);
    }

    private synchronized void most() {
        // coal
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.COAL_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.COAL
        );

        // iron
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.IRON_ORE, 1),
                new ItemStack(Items.DYE, 1, 15), // bone meal
                new ItemStack(Items.DYE, 1, 15),
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.IRON_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.IRON_INGOT
        );

        // gold
        // UPDATE: need 3 orange dye instead of 1
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.GOLD_ORE, 1),
                new ItemStack(Items.DYE, 1, 14), // orange
                new ItemStack(Items.DYE, 1, 14),
                new ItemStack(Items.DYE, 1, 14),
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.GOLD_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.GOLD_INGOT
        );

        // diamond
        // UPDATE: need 3 lapis
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.DIAMOND_ORE, 1),
                new ItemStack(Items.DYE, 1, 4), // lapis
                new ItemStack(Items.DYE, 1, 4),
                new ItemStack(Items.DYE, 1, 4),
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.DIAMOND_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.STONEBRICK,
                'm', Items.DIAMOND
        );

        // redstone
        // UPDATE: need 2 red dye instead of 1
        GameRegistry.addShapelessRecipe(new ItemStack(Items.REDSTONE, 1),
                new ItemStack(Items.DYE, 1, 1), // red
                new ItemStack(Items.DYE, 1, 1), // red
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.REDSTONE_ORE, 2),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.REDSTONE
        );

        // lapis
        // UPDATE: tweak clone ability
        GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, 4), // lapis
                new ItemStack(Blocks.STONE, 1, 3), // diorite
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET
        );
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.LAPIS_ORE, 1),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(Items.DYE, 1, 4) // lapis
        );

        // emerald
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.EMERALD_ORE, 1),
                new ItemStack(Items.DYE, 1, 2), // cactus green
                new ItemStack(Items.DYE, 1, 2), // cactus green
                new ItemStack(Items.DYE, 1, 2), // cactus green
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.EMERALD_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.STONEBRICK,
                'm', Items.EMERALD
        );

        // lots of strange recipes with cobblestone
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.OBSIDIAN, 2),
        "ii","Si",
                'S', Blocks.COBBLESTONE,
                'i', new ItemStack(Items.DYE, 1, 0) // ink sac
        );
        // rose red -> redstone
        // cactus green -> emerald
        // cocoa bean no formula
        // lapis -> clone lapis
        GameRegistry.addShapelessRecipe(new ItemStack(Items.ENDER_PEARL, 1),
                new ItemStack(Items.DYE, 1, 5), // purple
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SNOW, 1),
                new ItemStack(Items.DYE, 1, 6), // cyan
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.CLAY, 1),
                new ItemStack(Items.DYE, 1, 7), // light gray
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.GUNPOWDER, 1),
                new ItemStack(Items.DYE, 1, 8), // gray
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.CHORUS_FLOWER, 1),
                new ItemStack(Items.DYE, 1, 9), // pink
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SLIME_BLOCK, 1),
                new ItemStack(Items.DYE, 1, 10), // lime
                Blocks.COBBLESTONE
        );
        // UPDATE: need 2 yellow dye instead of 1
        GameRegistry.addShapelessRecipe(new ItemStack(Items.GLOWSTONE_DUST, 1),
                new ItemStack(Items.DYE, 1, 11), // yellow
                new ItemStack(Items.DYE, 1, 11), // yellow
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.PRISMARINE_SHARD, 1),
                new ItemStack(Items.DYE, 1, 12), // light blue
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.END_STONE, 1),
                new ItemStack(Items.DYE, 1, 13), // magenta
                Blocks.COBBLESTONE
        );
        // orange -> gold
        // bone meal -> iron

        // water + cobblestone*6 -> gravel*6
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.GRAVEL, 6),
                Items.WATER_BUCKET,
                Blocks.COBBLESTONE,Blocks.COBBLESTONE,Blocks.COBBLESTONE,
                Blocks.COBBLESTONE,Blocks.COBBLESTONE,Blocks.COBBLESTONE
        );
        // water + gravel*6 -> sand*6
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SAND, 6),
                Items.WATER_BUCKET,
                Blocks.GRAVEL,Blocks.GRAVEL,Blocks.GRAVEL,
                Blocks.GRAVEL,Blocks.GRAVEL,Blocks.GRAVEL
        );
        // water + sand*6 -> dirt
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.DIRT, 6),
                Items.WATER_BUCKET,
                Blocks.SAND,Blocks.SAND,Blocks.SAND,
                Blocks.SAND,Blocks.SAND,Blocks.SAND
        );

        // podzol
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.DIRT, 5, 2),
                "dgd","gdg","dgd",
                'd', Blocks.DIRT,
                'g', Blocks.TALLGRASS
        );

        // sponge
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.SPONGE),
                ".i.","iyi",".i.",
                'i', new ItemStack(Items.DYE, 1, 0), // ink sac
                'y', new ItemStack(Blocks.WOOL, 1, 4) // yellow wool
        );

        // water + lava
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.COBBLESTONE, 6),
                "W.L",
                'W', Items.WATER_BUCKET,
                'L',Items.LAVA_BUCKET
        );
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.OBSIDIAN, 2),
                ".W.","...","LSL",
                'W', Items.WATER_BUCKET,
                'L',Items.LAVA_BUCKET,
                'S', Blocks.STONE
        );

        // nether quartz
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.QUARTZ_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.NETHERRACK,
                'm', Items.QUARTZ
        );

        // lava
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.MAGMA, 8),
                Blocks.STONE,Blocks.STONE,
                Blocks.STONE,Blocks.STONE,
                Blocks.STONE,Blocks.STONE,
                Blocks.STONE,Blocks.STONE,
                Items.LAVA_BUCKET
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.LAVA_BUCKET, 1),
                Blocks.MAGMA,Blocks.MAGMA,Blocks.MAGMA,
                Items.BUCKET
        );

        // soul sand
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.SOUL_SAND, 4),
                "SmS","mSm","SmS",
                'S', Blocks.SAND,
                'm', Blocks.SAPLING
        );

        // oak sapling
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.SAPLING, 1),
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
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.GLOWSTONE, 2),
                "GgG","gGg","GgG",
                'G', Blocks.GLASS,
                'g', Items.GLOWSTONE_DUST
        );
        // grass
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.TALLGRASS, 4, 1),
                Items.WHEAT_SEEDS,
                new ItemStack(Blocks.DIRT, 1, OreDictionary.WILDCARD_VALUE)
        );

        // wood
        // meta is 0~5
        for (int i=0; i<6; i++) {
            Block log = i<4?Blocks.LOG:Blocks.LOG2;
            GameRegistry.addShapedRecipe(new ItemStack(log, 6, i&3),
                    "W", "b", "s",
                    'W', Items.WATER_BUCKET,
                    'b', new ItemStack(Items.DYE, 1, 15), // bone meal
                    's', new ItemStack(Blocks.SAPLING, 1, i)
            );
        }

        // end stone -> bone block
        GameRegistry.addSmelting(Blocks.END_STONE, new ItemStack(Blocks.BONE_BLOCK), 0.1f);

        // charcoal + ink sac -> coal
        GameRegistry.addShapelessRecipe(new ItemStack(Items.COAL, 1, 0), // coal
                new ItemStack(Items.COAL, 1, 1), // charcoal
                new ItemStack(Items.DYE, 1, 0) // ink sac
        );

        // wash andesite to get quartz
        GameRegistry.addShapelessRecipe(new ItemStack(Items.QUARTZ, 1), // quartz
                new ItemStack(Blocks.STONE, 1, 5), // andesite
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET
        );

        // new in 2017/7/3
        GameRegistry.addShapelessRecipe(new ItemStack(Items.SHULKER_SHELL, 1),
                new ItemStack(Blocks.WOOL, 1, 6), // pink
                new ItemStack(Blocks.WOOL, 1, 6), // pink
                new ItemStack(Blocks.WOOL, 1, 6), // pink
                new ItemStack(Blocks.WOOL, 1, 6), // pink
                new ItemStack(Blocks.WOOL, 1, 3), // light blue
                new ItemStack(Blocks.WOOL, 1, 3), // light blue
                new ItemStack(Blocks.WOOL, 1, 3), // light blue
                new ItemStack(Blocks.WOOL, 1, 3) // light blue
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.MAGMA_CREAM,3),
                Blocks.MAGMA);
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.PACKED_ICE),
                "ii","ii", 'i', Blocks.ICE);
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.NETHERRACK),
                new ItemStack(Blocks.STONE, 1, 1), // granite
                Items.WATER_BUCKET);
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.MYCELIUM),
                new ItemStack(Blocks.WOOL, 1, 7), // gray
                new ItemStack(Blocks.WOOL, 1, 7), // gray
                new ItemStack(Blocks.WOOL, 1, 7), // gray
                new ItemStack(Blocks.WOOL, 1, 7), // gray
                new ItemStack(Blocks.WOOL, 1, 10), // purple
                new ItemStack(Blocks.WOOL, 1, 10), // purple
                new ItemStack(Blocks.WOOL, 1, 10), // purple
                new ItemStack(Blocks.WOOL, 1, 10) // purple
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.ELYTRA),
                new ItemStack(Blocks.WOOL, 1, 8), // light gray
                new ItemStack(Blocks.WOOL, 1, 8), // light gray
                new ItemStack(Blocks.WOOL, 1, 8), // light gray
                new ItemStack(Blocks.WOOL, 1, 8), // light gray
                new ItemStack(Blocks.WOOL, 1, 2), //  magenta
                new ItemStack(Blocks.WOOL, 1, 2), //  magenta
                new ItemStack(Blocks.WOOL, 1, 2), //  magenta
                new ItemStack(Blocks.WOOL, 1, 2) //  magenta
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.RABBIT_FOOT),
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Blocks.WOOL, 1, 0), // white
                new ItemStack(Blocks.WOOL, 1, 0), // white
                new ItemStack(Blocks.WOOL, 1, 0), // white
                new ItemStack(Blocks.WOOL, 1, 0) // white
        );
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.WEB),
                "sss","sss","sss",'s',Items.STRING);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.STRING, 4),
                Blocks.WEB);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.BLAZE_ROD),
                Items.GLOWSTONE_DUST, Items.GUNPOWDER, Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.NETHER_STAR),
                "gqg","qdq","gqg",
                'g', Items.GLOWSTONE_DUST,
                'q', Items.QUARTZ,
                'd', Items.DIAMOND);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.FEATHER, 4),
                Items.STRING,
                new ItemStack(Items.DYE, 1, 15) // bone meal
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SAND, 1, 1), // red sand
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 14), // red
                Blocks.SAND
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.FISH, 1, 2), // clownfish
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 0) // white
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PUMPKIN),
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 12) // brown
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.FISH, 1, 1), // salmon
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 14), // red
                new ItemStack(Blocks.WOOL, 1, 14) // red
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Items.FISH, 1, 3), // pufferfish
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                Items.POISONOUS_POTATO
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.ICE),
                new ItemStack(Blocks.WOOL, 1, 9), // cyan
                Blocks.GLASS
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.MELON_BLOCK),
                new ItemStack(Blocks.WOOL, 1, 5), // lime
                new ItemStack(Blocks.WOOL, 1, 13) // green
        );
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.CACTUS),
                new ItemStack(Blocks.WOOL, 1, 13), // green
                new ItemStack(Blocks.WOOL, 1, 15) // black
        );

        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new ItemStack(Items.POTIONITEM, 1, 0), // water bottle
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Items.EXPERIENCE_BOTTLE)
        ));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.SPAWN_EGG),
                new ItemStack(Items.DYE, 1, 15), // bone meal
                Items.EGG
        );
        GameRegistry.addRecipe(new ShapelessOreRecipe(
                new ItemStack(Blocks.STONE, 1, 3), // diorite
                new ItemStack(Blocks.COBBLESTONE, 1), // stone
                "listAllmilk"
        ));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new ItemStack(Items.POTIONITEM, 1, 0), // water bottle
                new ItemStack(Items.SPAWN_EGG, 1),
                new ItemStack(Items.EXPERIENCE_BOTTLE)
        ));
        // NEW IN 2017/8/15
        GameRegistry.addShapedRecipe(new ItemStack(Items.PAPER),
                "xxx", 'x', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(Items.STRING),
                "x","x","x", 'x', Items.STICK);
    }

    private void ic() {
        Item ore =  Item.getByNameOrId("ic2:resource");
        Item ingot = Item.getByNameOrId("ic2:ingot");
        final int COPPER_ORE_META = 1, COPPER_INGOT_META = 2;
        GameRegistry.addShapelessRecipe(new ItemStack(ore, 1, COPPER_ORE_META),
                new ItemStack(Items.DYE, 1, 14), // orange
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapedRecipe(new ItemStack(ore, 5, COPPER_ORE_META),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(ingot, 1, COPPER_INGOT_META)
        );
        final int TIN_ORE_META = 3, TIN_INGOT_META = 6;
        GameRegistry.addShapelessRecipe(new ItemStack(ore, 1, TIN_ORE_META),
                new ItemStack(Items.DYE, 1, 15), // bone mill
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapedRecipe(new ItemStack(ore, 5, TIN_ORE_META),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(ingot, 1, TIN_INGOT_META)
        );
        final int LEAD_ORE_META = 2, LEAD_INGOT_META = 3;
        GameRegistry.addShapelessRecipe(new ItemStack(ore, 1, LEAD_ORE_META),
                new ItemStack(Items.DYE, 1, 8), // gray
                new ItemStack(Items.DYE, 1, 8),
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapedRecipe(new ItemStack(ore, 5, LEAD_ORE_META),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(ingot, 1, LEAD_INGOT_META)
        );
        Item nuclear = Item.getByNameOrId("ic2:nuclear");
        final int URANIUM_ORE_META = 4, U235_TINY_PILE_META = 5, U238_META = 2;
        GameRegistry.addShapelessRecipe(new ItemStack(ore, 1, URANIUM_ORE_META),
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                Blocks.COBBLESTONE
        );
        GameRegistry.addShapedRecipe(new ItemStack(ore, 1, URANIUM_ORE_META),
                "SmS","mcm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(nuclear, 1, U238_META),
                'c', new ItemStack(nuclear, 1, U235_TINY_PILE_META)
        );
        Item misc_resource = Item.getByNameOrId("ic2:misc_resource");
        final int IRIDIUM_SHARD_META = 2;
        GameRegistry.addShapelessRecipe(new ItemStack(misc_resource, 1, IRIDIUM_SHARD_META),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                Blocks.COBBLESTONE
        );
        // slime + cocoa -> sticky resins
        final int STICKY_RESIN_META = 4;
        GameRegistry.addShapelessRecipe(new ItemStack(misc_resource, 1, STICKY_RESIN_META),
                Items.SLIME_BALL,
                new ItemStack(Items.DYE, 1, 3) // cocoa bean
        );

        // new in 2017/7/3
        Item sapling = Item.getByNameOrId("ic2:sapling");
        GameRegistry.addShapelessRecipe(new ItemStack(sapling, 1), // rubber tree
                new ItemStack(Blocks.SAPLING, 1, 3), // jungle tree sapling
                new ItemStack(Blocks.WOOL, 1, 12) // brown
        );
    }

    synchronized private void tooNewRecipes() {
        // new in 2017/7/3
        Item blueprint = Item.getByNameOrId("buildcraftbuilders:snapshot");
        final int BLUEPRINT_META = 2;
        GameRegistry.addShapelessRecipe(new ItemStack(blueprint, 1, BLUEPRINT_META),
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
        GameRegistry.addShapedRecipe(new ItemStack(builder),
                "kLk","yTy","gCg",
                'k', black, 'L', landmark, 'y', yellow, 'T', Blocks.CRAFTING_TABLE,
                'g', diamondGear, 'C', Blocks.CHEST);
        GameRegistry.addShapedRecipe(new ItemStack(filler),
                "kLk","yTy","gCg",
                'k', black, 'L', landmark, 'y', yellow, 'T', Blocks.CRAFTING_TABLE,
                'g', goldGear, 'C', Blocks.CHEST);
        GameRegistry.addShapedRecipe(new ItemStack(architectTable),
                "kLk","yTy","gpg",
                'k', black, 'L', landmark, 'y', yellow, 'T', Blocks.CRAFTING_TABLE,
                'g', diamondGear, 'p', new ItemStack(blueprint, 1, BLUEPRINT_META));
        GameRegistry.addShapedRecipe(new ItemStack(blueprintLibrary),
                "ppp","pSp","ppp",
                'p', new ItemStack(blueprint, 1, BLUEPRINT_META), 'S', Blocks.BOOKSHELF);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
        most();
        if (Loader.isModLoaded("ic2")) {
            System.out.println("IIIIII CCCCCC 222222");
            ic();
        }
        if (Loader.isModLoaded("buildcraftbuilders")) {
            System.out.println("BBBBB CCCCC");
            tooNewRecipes();
        }
        woolRecolor();
        ddd();
    }

    private void woolRecolor() {
        final int colorId[] = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        for (int i = 0; i < 16; i++) {
            GameRegistry.addShapedRecipe(new ItemStack(Blocks.WOOL, 8, i),
                    "www","wcw","www",
                    'w', Blocks.WOOL,
                    'c', new ItemStack(Items.DYE, 1, colorId[i])
            );
        }
    }

    private void ddd(){
        GameRegistry.registerFuelHandler(new IFuelHandler() {
            final Item cookingOil = Item.getByNameOrId("harvestcraft:oliveoilitem");
            @Override
            public int getBurnTime(ItemStack itemStack) {
                if (itemStack.getItem() == cookingOil) return 200*4;
                return 0;
            }
        });
    }
}
