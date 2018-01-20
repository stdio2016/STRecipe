package com.stdio2016.strecipemod;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mod(modid = STRecipeMod.MODID, version = STRecipeMod.VERSION)
public class STRecipeMod
{
    public static final String MODID = "strecipemod";
    public static final String VERSION = "3.0";

    @NetworkCheckHandler
    public boolean check(Map<String, String> something, Side side) {
        // this mod does not depend on any other mod
        // on server multi player, clients don't need to install this mod
        if (something.containsKey(MODID)) {
            System.out.println("YAY!!! Somebody installed stdio2016's mod.");
            String s = something.get(MODID);
            if (s.compareTo(VERSION) != 0) {
                // different version of my mod, may cause problems
                return false;
            }
        }
        return true;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        OreDictionary.registerOre("listAllmilk", Items.MILK_BUCKET);
    }
    
    private void helpAddShapedRecipe(ItemStack output, Object... params) {
        GameRegistry.addShapedRecipe(output, params);
    }

    private void helpAddShapelessRecipe(ItemStack output, Object...inputs) {
        GameRegistry.addShapelessRecipe(output, inputs);
    }

    private synchronized void most() {
        // coal
        helpAddShapedRecipe(new ItemStack(Blocks.COAL_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.COAL
        );

        // iron
        helpAddShapelessRecipe(new ItemStack(Blocks.IRON_ORE, 1),
                new ItemStack(Items.DYE, 1, 15), // bone meal
                new ItemStack(Items.DYE, 1, 15),
                new ItemStack(Items.DYE, 1, 15),
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe(new ItemStack(Blocks.IRON_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.IRON_INGOT
        );

        // gold
        // UPDATE: need 4 orange dye instead of 3
        helpAddShapelessRecipe(new ItemStack(Blocks.GOLD_ORE, 1),
                new ItemStack(Items.DYE, 1, 14), // orange
                new ItemStack(Items.DYE, 1, 14),
                new ItemStack(Items.DYE, 1, 14),
                new ItemStack(Items.DYE, 1, 14),
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe(new ItemStack(Blocks.GOLD_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.GOLD_INGOT
        );

        // diamond
        // UPDATE: need 4 lapis
        helpAddShapelessRecipe(new ItemStack(Blocks.DIAMOND_ORE, 1),
                new ItemStack(Items.DYE, 1, 4), // lapis
                new ItemStack(Items.DYE, 1, 4),
                new ItemStack(Items.DYE, 1, 4),
                new ItemStack(Items.DYE, 1, 4),
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe(new ItemStack(Blocks.DIAMOND_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.STONEBRICK,
                'm', Items.DIAMOND
        );

        // redstone
        // UPDATE: need 2 red dye instead of 1
        helpAddShapelessRecipe(new ItemStack(Items.REDSTONE, 1),
                new ItemStack(Items.DYE, 1, 1), // red
                new ItemStack(Items.DYE, 1, 1), // red
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe(new ItemStack(Blocks.REDSTONE_ORE, 2),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', Items.REDSTONE
        );

        // lapis
        // UPDATE: tweak clone ability
        helpAddShapelessRecipe(new ItemStack(Items.DYE, 1, 4), // lapis
                new ItemStack(Blocks.STONE, 1, 3), // diorite
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET
        );
        helpAddShapedRecipe(new ItemStack(Blocks.LAPIS_ORE, 1),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(Items.DYE, 1, 4) // lapis
        );

        // emerald
        helpAddShapelessRecipe(new ItemStack(Blocks.EMERALD_ORE, 1),
                new ItemStack(Items.DYE, 1, 2), // cactus green
                new ItemStack(Items.DYE, 1, 2), // cactus green
                new ItemStack(Items.DYE, 1, 2), // cactus green
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe(new ItemStack(Blocks.EMERALD_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.STONEBRICK,
                'm', Items.EMERALD
        );

        // lots of strange recipes with cobblestone
        helpAddShapedRecipe(new ItemStack(Blocks.OBSIDIAN, 1),
        "ii","Si",
                'S', Blocks.COBBLESTONE,
                'i', new ItemStack(Items.DYE, 1, 0) // ink sac
        );
        // rose red -> redstone
        // cactus green -> emerald
        // cocoa bean formula new in 2018/1/17
        helpAddShapelessRecipe(new ItemStack(Blocks.DIRT, 16),
                new ItemStack(Items.DYE, 1, 3), // cocoa bean
                Blocks.COBBLESTONE
        );
        // lapis -> clone lapis
        helpAddShapelessRecipe(new ItemStack(Items.ENDER_PEARL, 1),
                new ItemStack(Items.DYE, 1, 5), // purple
                new ItemStack(Items.DYE, 1, 5), // purple
                Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe(new ItemStack(Blocks.SNOW, 8),
                new ItemStack(Items.DYE, 1, 6), // cyan
                Blocks.COBBLESTONE, Blocks.COBBLESTONE,
                Blocks.COBBLESTONE, Blocks.COBBLESTONE,
                Blocks.COBBLESTONE, Blocks.COBBLESTONE,
                Blocks.COBBLESTONE, Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe(new ItemStack(Blocks.CLAY, 2),
                new ItemStack(Items.DYE, 1, 7), // light gray
                Blocks.COBBLESTONE, Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe(new ItemStack(Items.GUNPOWDER, 1),
                new ItemStack(Items.DYE, 1, 8), // gray
                Blocks.COBBLESTONE
        );
        // update in 2018/1/17: expensive
        helpAddShapelessRecipe(new ItemStack(Blocks.CHORUS_FLOWER, 1),
                new ItemStack(Items.DYE, 1, 9), // pink
                new ItemStack(Items.DYE, 1, 9), // pink
                new ItemStack(Items.DYE, 1, 9), // pink
                new ItemStack(Items.DYE, 1, 9), // pink
                new ItemStack(Items.DYE, 1, 9), // pink
                new ItemStack(Items.DYE, 1, 9), // pink
                new ItemStack(Items.DYE, 1, 9), // pink
                new ItemStack(Items.DYE, 1, 9), // pink
                Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe(new ItemStack(Blocks.SLIME_BLOCK, 1),
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                Blocks.COBBLESTONE
        );
        // UPDATE: need 2 yellow dye instead of 1
        helpAddShapelessRecipe(new ItemStack(Items.GLOWSTONE_DUST, 1),
                new ItemStack(Items.DYE, 1, 11), // yellow
                new ItemStack(Items.DYE, 1, 11), // yellow
                Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe(new ItemStack(Items.PRISMARINE_SHARD, 1),
                new ItemStack(Items.DYE, 1, 12), // light blue
                Blocks.COBBLESTONE
        );
        helpAddShapelessRecipe(new ItemStack(Blocks.END_STONE, 1),
                new ItemStack(Items.DYE, 1, 13), // magenta
                new ItemStack(Items.DYE, 1, 13), // magenta
                new ItemStack(Items.DYE, 1, 13), // magenta
                new ItemStack(Items.DYE, 1, 13), // magenta
                Blocks.COBBLESTONE
        );
        // orange -> gold
        // bone meal -> iron

        // water + cobblestone*6 -> gravel*6
        helpAddShapelessRecipe(new ItemStack(Blocks.GRAVEL, 6),
                Items.WATER_BUCKET,
                Blocks.COBBLESTONE,Blocks.COBBLESTONE,Blocks.COBBLESTONE,
                Blocks.COBBLESTONE,Blocks.COBBLESTONE,Blocks.COBBLESTONE
        );
        // water + gravel*6 -> sand*6
        helpAddShapelessRecipe(new ItemStack(Blocks.SAND, 6),
                Items.WATER_BUCKET,
                Blocks.GRAVEL,Blocks.GRAVEL,Blocks.GRAVEL,
                Blocks.GRAVEL,Blocks.GRAVEL,Blocks.GRAVEL
        );
        // water + sand*6 -> dirt
        helpAddShapelessRecipe(new ItemStack(Blocks.DIRT, 6),
                Items.WATER_BUCKET,
                Blocks.SAND,Blocks.SAND,Blocks.SAND,
                Blocks.SAND,Blocks.SAND,Blocks.SAND
        );

        // podzol
        helpAddShapedRecipe(new ItemStack(Blocks.DIRT, 5, 2),
                "dgd","gdg","dgd",
                'd', Blocks.DIRT,
                'g', Blocks.TALLGRASS
        );

        // sponge
        helpAddShapedRecipe(new ItemStack(Blocks.SPONGE),
                ".i.","iyi",".i.",
                'i', new ItemStack(Items.DYE, 1, 0), // ink sac
                'y', new ItemStack(Blocks.WOOL, 1, 4) // yellow wool
        );

        // water + lava
        helpAddShapedRecipe(new ItemStack(Blocks.COBBLESTONE, 6),
                "W.L",
                'W', Items.WATER_BUCKET,
                'L',Items.LAVA_BUCKET
        );
        helpAddShapedRecipe(new ItemStack(Blocks.OBSIDIAN, 2),
                ".W.","...","LSL",
                'W', Items.WATER_BUCKET,
                'L',Items.LAVA_BUCKET,
                'S', Blocks.STONE
        );

        // nether quartz
        helpAddShapedRecipe(new ItemStack(Blocks.QUARTZ_ORE, 5),
                "SmS","mSm","SmS",
                'S', Blocks.NETHERRACK,
                'm', Items.QUARTZ
        );

        // lava
        helpAddShapelessRecipe(new ItemStack(Blocks.MAGMA, 4),
                Blocks.STONE,Blocks.STONE,
                Blocks.STONE,
                Items.LAVA_BUCKET
        );
        helpAddShapelessRecipe(new ItemStack(Items.LAVA_BUCKET, 1),
                Blocks.MAGMA,Blocks.MAGMA,Blocks.MAGMA,
                Items.BUCKET
        );

        // soul sand
        helpAddShapedRecipe(new ItemStack(Blocks.SOUL_SAND, 4),
                "SmS","mSm","SmS",
                'S', Blocks.SAND,
                'm', Blocks.SAPLING
        );

        // oak sapling
        helpAddShapedRecipe(new ItemStack(Blocks.SAPLING, 1),
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
        helpAddShapedRecipe(new ItemStack(Blocks.GLOWSTONE, 2),
                "GgG","gGg","GgG",
                'G', Blocks.GLASS,
                'g', Items.GLOWSTONE_DUST
        );
        // grass
        helpAddShapelessRecipe(new ItemStack(Blocks.TALLGRASS, 4, 1),
                Items.WHEAT_SEEDS,
                new ItemStack(Blocks.DIRT, 1, OreDictionary.WILDCARD_VALUE)
        );

        // wood
        // meta is 0~5
        for (int i=0; i<6; i++) {
            Block log = i<4?Blocks.LOG:Blocks.LOG2;
            helpAddShapedRecipe(new ItemStack(log, 6, i&3),
                    "W", "b", "s",
                    'W', Items.WATER_BUCKET,
                    'b', new ItemStack(Items.DYE, 1, 15), // bone meal
                    's', new ItemStack(Blocks.SAPLING, 1, i)
            );
        }

        // end stone -> bone block
        GameRegistry.addSmelting(Blocks.END_STONE, new ItemStack(Blocks.BONE_BLOCK), 0.1f);

        // charcoal + ink sac -> coal
        helpAddShapelessRecipe(new ItemStack(Items.COAL, 1, 0), // coal
                new ItemStack(Items.COAL, 1, 1), // charcoal
                new ItemStack(Items.DYE, 1, 0) // ink sac
        );

        // wash andesite to get quartz
        helpAddShapelessRecipe(new ItemStack(Items.QUARTZ, 1), // quartz
                new ItemStack(Blocks.STONE, 1, 5), // andesite
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET,
                Items.WATER_BUCKET
        );

        // new in 2017/7/3
        helpAddShapelessRecipe(new ItemStack(Items.SHULKER_SHELL, 1),
                new ItemStack(Blocks.WOOL, 1, 6), // pink
                new ItemStack(Blocks.WOOL, 1, 6), // pink
                new ItemStack(Blocks.WOOL, 1, 6), // pink
                new ItemStack(Blocks.WOOL, 1, 6), // pink
                new ItemStack(Blocks.WOOL, 1, 3), // light blue
                new ItemStack(Blocks.WOOL, 1, 3), // light blue
                new ItemStack(Blocks.WOOL, 1, 3), // light blue
                new ItemStack(Blocks.WOOL, 1, 3) // light blue
        );
        helpAddShapelessRecipe(new ItemStack(Items.MAGMA_CREAM,3),
                Blocks.MAGMA);
        helpAddShapedRecipe(new ItemStack(Blocks.PACKED_ICE),
                "ii","ii", 'i', Blocks.ICE);
        helpAddShapelessRecipe(new ItemStack(Blocks.NETHERRACK),
                new ItemStack(Blocks.STONE, 1, 1), // granite
                Items.WATER_BUCKET);
        helpAddShapelessRecipe(new ItemStack(Blocks.MYCELIUM),
                new ItemStack(Blocks.WOOL, 1, 7), // gray
                new ItemStack(Blocks.WOOL, 1, 7), // gray
                new ItemStack(Blocks.WOOL, 1, 7), // gray
                new ItemStack(Blocks.WOOL, 1, 7), // gray
                new ItemStack(Blocks.WOOL, 1, 10), // purple
                new ItemStack(Blocks.WOOL, 1, 10), // purple
                new ItemStack(Blocks.WOOL, 1, 10), // purple
                new ItemStack(Blocks.WOOL, 1, 10) // purple
        );
        helpAddShapelessRecipe(new ItemStack(Items.ELYTRA),
                new ItemStack(Blocks.WOOL, 1, 8), // light gray
                new ItemStack(Blocks.WOOL, 1, 8), // light gray
                new ItemStack(Blocks.WOOL, 1, 8), // light gray
                new ItemStack(Blocks.WOOL, 1, 8), // light gray
                new ItemStack(Blocks.WOOL, 1, 2), //  magenta
                new ItemStack(Blocks.WOOL, 1, 2), //  magenta
                new ItemStack(Blocks.WOOL, 1, 2), //  magenta
                new ItemStack(Blocks.WOOL, 1, 2) //  magenta
        );
        helpAddShapelessRecipe(new ItemStack(Items.RABBIT_FOOT),
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Blocks.WOOL, 1, 0), // white
                new ItemStack(Blocks.WOOL, 1, 0), // white
                new ItemStack(Blocks.WOOL, 1, 0), // white
                new ItemStack(Blocks.WOOL, 1, 0) // white
        );
        helpAddShapedRecipe(new ItemStack(Blocks.WEB),
                "sss","sss","sss",'s',Items.STRING);
        helpAddShapelessRecipe(new ItemStack(Items.STRING, 4),
                Blocks.WEB);
        helpAddShapelessRecipe(new ItemStack(Items.BLAZE_ROD),
                Items.GLOWSTONE_DUST, Items.GUNPOWDER, Items.STICK);
        helpAddShapedRecipe(new ItemStack(Items.NETHER_STAR),
                "gqg","qdq","gqg",
                'g', Items.GLOWSTONE_DUST,
                'q', Items.QUARTZ,
                'd', Items.DIAMOND);
        helpAddShapelessRecipe(new ItemStack(Items.FEATHER, 4),
                Items.STRING,
                new ItemStack(Items.DYE, 1, 15) // bone meal
        );
        helpAddShapelessRecipe(new ItemStack(Blocks.SAND, 1, 1), // red sand
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 14), // red
                Blocks.SAND
        );
        helpAddShapelessRecipe(new ItemStack(Items.FISH, 1, 2), // clownfish
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 0) // white
        );
        helpAddShapelessRecipe(new ItemStack(Blocks.PUMPKIN),
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 12) // brown
        );
        helpAddShapelessRecipe(new ItemStack(Items.FISH, 1, 1), // salmon
                new ItemStack(Blocks.WOOL, 1, 1), // orange
                new ItemStack(Blocks.WOOL, 1, 14), // red
                new ItemStack(Blocks.WOOL, 1, 14) // red
        );
        helpAddShapelessRecipe(new ItemStack(Items.FISH, 1, 3), // pufferfish
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                Items.POISONOUS_POTATO
        );
        helpAddShapelessRecipe(new ItemStack(Blocks.ICE),
                new ItemStack(Blocks.WOOL, 1, 9), // cyan
                Blocks.GLASS
        );
        helpAddShapelessRecipe(new ItemStack(Blocks.MELON_BLOCK),
                new ItemStack(Blocks.WOOL, 1, 5), // lime
                new ItemStack(Blocks.WOOL, 1, 13) // green
        );
        helpAddShapelessRecipe(new ItemStack(Blocks.CACTUS),
                new ItemStack(Blocks.WOOL, 1, 13), // green
                new ItemStack(Blocks.WOOL, 1, 15) // black
        );

        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new ItemStack(Items.POTIONITEM, 1, 0), // water bottle
                new ItemStack(Blocks.WOOL, 1, 4), // yellow
                new ItemStack(Items.EXPERIENCE_BOTTLE)
        ));
        helpAddShapelessRecipe(new ItemStack(Items.SPAWN_EGG),
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
        helpAddShapedRecipe(new ItemStack(Items.PAPER),
                "xxx", 'x', Items.STICK);
        helpAddShapedRecipe(new ItemStack(Items.STRING),
                "x","x","x", 'x', Items.STICK);
        // new in 2018/1/17
        helpAddShapelessRecipe(new ItemStack(Blocks.COAL_ORE),
                Blocks.COBBLESTONE,
                new ItemStack(Items.DYE, 1, 0), // ink sac
                new ItemStack(Items.DYE, 1, 0)
        );
        helpAddShapelessRecipe(new ItemStack(Items.DYE, 3), // cocoa bean
                Items.WHEAT_SEEDS,
                new ItemStack(Blocks.DIRT, 1, 2), // podzol
                new ItemStack(Blocks.DIRT, 1, 2),
                new ItemStack(Blocks.DIRT, 1, 2),
                new ItemStack(Blocks.DIRT, 1, 2),
                new ItemStack(Blocks.DIRT, 1, 2),
                new ItemStack(Blocks.DIRT, 1, 2),
                new ItemStack(Blocks.DIRT, 1, 2),
                new ItemStack(Blocks.DIRT, 1, 2)
        );
    }

    private void ic() {
        Item ore =  Item.getByNameOrId("ic2:resource");
        Item ingot = Item.getByNameOrId("ic2:ingot");
        final int COPPER_ORE_META = 1, COPPER_INGOT_META = 2;
        helpAddShapelessRecipe(new ItemStack(ore, 1, COPPER_ORE_META),
                new ItemStack(Items.DYE, 1, 14), // orange
                new ItemStack(Items.DYE, 1, 14), // orange
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe(new ItemStack(ore, 5, COPPER_ORE_META),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(ingot, 1, COPPER_INGOT_META)
        );
        final int TIN_ORE_META = 3, TIN_INGOT_META = 6;
        helpAddShapelessRecipe(new ItemStack(ore, 1, TIN_ORE_META),
                new ItemStack(Items.DYE, 1, 15), // bone mill
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe(new ItemStack(ore, 5, TIN_ORE_META),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(ingot, 1, TIN_INGOT_META)
        );
        final int LEAD_ORE_META = 2, LEAD_INGOT_META = 3;
        helpAddShapelessRecipe(new ItemStack(ore, 1, LEAD_ORE_META),
                new ItemStack(Items.DYE, 1, 8), // gray
                new ItemStack(Items.DYE, 1, 8),
                new ItemStack(Items.DYE, 1, 8),
                new ItemStack(Items.DYE, 1, 8),
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe(new ItemStack(ore, 5, LEAD_ORE_META),
                "SmS","mSm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(ingot, 1, LEAD_INGOT_META)
        );
        Item nuclear = Item.getByNameOrId("ic2:nuclear");
        final int URANIUM_ORE_META = 4, U235_TINY_PILE_META = 5, U238_META = 2;
        helpAddShapelessRecipe(new ItemStack(ore, 1, URANIUM_ORE_META),
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                new ItemStack(Items.DYE, 1, 10), // lime
                Blocks.COBBLESTONE
        );
        helpAddShapedRecipe(new ItemStack(ore, 1, URANIUM_ORE_META),
                "SmS","mcm","SmS",
                'S', Blocks.COBBLESTONE,
                'm', new ItemStack(nuclear, 1, U238_META),
                'c', new ItemStack(nuclear, 1, U235_TINY_PILE_META)
        );
        Item misc_resource = Item.getByNameOrId("ic2:misc_resource");
        final int IRIDIUM_SHARD_META = 2;
        helpAddShapelessRecipe(new ItemStack(misc_resource, 1, IRIDIUM_SHARD_META),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                new ItemStack(Blocks.BONE_BLOCK, 1), new ItemStack(Blocks.BONE_BLOCK, 1),
                Blocks.COBBLESTONE
        );
        // slime + cocoa -> sticky resins
        final int STICKY_RESIN_META = 4;
        helpAddShapelessRecipe(new ItemStack(misc_resource, 1, STICKY_RESIN_META),
                Items.SLIME_BALL,
                new ItemStack(Items.DYE, 1, 3) // cocoa bean
        );

        // new in 2017/7/3
        Item sapling = Item.getByNameOrId("ic2:sapling");
        helpAddShapelessRecipe(new ItemStack(sapling, 1), // rubber tree
                new ItemStack(Blocks.SAPLING, 1, 3), // jungle tree sapling
                new ItemStack(Blocks.WOOL, 1, 12) // brown
        );
    }

    synchronized private void tooNewRecipes() {
        // new in 2017/7/3
        Item blueprint = Item.getByNameOrId("buildcraftbuilders:snapshot");
        final int BLUEPRINT_META = 2;
        helpAddShapelessRecipe(new ItemStack(blueprint, 1, BLUEPRINT_META),
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
        helpAddShapedRecipe(new ItemStack(builder),
                "kLk","yTy","gCg",
                'k', black, 'L', landmark, 'y', yellow, 'T', Blocks.CRAFTING_TABLE,
                'g', diamondGear, 'C', Blocks.CHEST);
        helpAddShapedRecipe(new ItemStack(filler),
                "kLk","yTy","gCg",
                'k', black, 'L', landmark, 'y', yellow, 'T', Blocks.CRAFTING_TABLE,
                'g', goldGear, 'C', Blocks.CHEST);
        helpAddShapedRecipe(new ItemStack(architectTable),
                "kLk","yTy","gpg",
                'k', black, 'L', landmark, 'y', yellow, 'T', Blocks.CRAFTING_TABLE,
                'g', diamondGear, 'p', new ItemStack(blueprint, 1, BLUEPRINT_META));
        helpAddShapedRecipe(new ItemStack(blueprintLibrary),
                "ppp","pSp","ppp",
                'p', new ItemStack(blueprint, 1, BLUEPRINT_META), 'S', Blocks.BOOKSHELF);

        // new in 2017/8/28
        Item emzuliPipe = Item.getByNameOrId("buildcrafttransport:pipe_emzuli_item");
        helpAddShapedRecipe(new ItemStack(emzuliPipe, 8),
                "lge",
                'l', Blocks.LAPIS_BLOCK, 'g', Blocks.GLASS, 'e', Items.EMERALD);
        Item stripedPipe = Item.getByNameOrId("buildcrafttransport:pipe_stripes_item");
        helpAddShapedRecipe(new ItemStack(stripedPipe, 8),
                "ege",
                'e', goldGear, 'g', Blocks.GLASS);
        List<ItemStack> inputs = Lists.newArrayList();
        Item bucket = Item.getByNameOrId("forge:bucketfilled");
        ItemStack fossil = new ItemStack(bucket);
        fossil.setTagInfo("FluidName", new NBTTagString("oil"));
        fossil.setTagInfo("Amount", new NBTTagInt(1000));
        inputs.add(fossil);
        for (int i = 0; i < 8; i++) {
            inputs.add(new ItemStack(Items.WHEAT_SEEDS));
        }
        IRecipe re = new NbtSensitiveShapelessRecipe(
                new ItemStack(Items.DYE,8,3), // cocoa bean
                inputs
        );
        GameRegistry.addRecipe(re);

        inputs = Lists.newArrayList(fossil, new ItemStack(Blocks.COBBLESTONE));
        re = new NbtSensitiveShapelessRecipe(
                new ItemStack(Blocks.COBBLESTONE, 64),
                inputs
        );
        GameRegistry.addRecipe(re);
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
            helpAddShapedRecipe(new ItemStack(Blocks.WOOL, 8, i),
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
