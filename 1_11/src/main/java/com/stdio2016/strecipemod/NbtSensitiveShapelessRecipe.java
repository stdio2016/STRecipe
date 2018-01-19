package com.stdio2016.strecipemod;

import com.google.common.collect.Lists;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by User on 2018/1/19.
 */
public class NbtSensitiveShapelessRecipe extends ShapelessRecipes {
    public NbtSensitiveShapelessRecipe(ItemStack output, List<ItemStack> input) {
        super(output, input);
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        List<ItemStack> rem = Lists.newArrayList(this.recipeItems);
        for (int i = 0; i < inv.getHeight(); i++) {
            for (int j = 0; j < inv.getWidth(); j++) {
                ItemStack it = inv.getStackInRowAndColumn(i,j);
                if (!it.isEmpty()) {
                    boolean has = false;
                    for (ItemStack me : rem) {
                        if (isSameItem(me, it)) {
                            has = true;
                            rem.remove(me);
                            break;
                        }
                    }
                    if (!has) return false;
                }
            }
        }
        return rem.isEmpty();
    }

    public boolean isSameItem(ItemStack formula, ItemStack input) {
        if (formula.getItem() != input.getItem()) return false;
        if (formula.getMetadata() != input.getMetadata() && formula.getMetadata() != 32767) return false;
        if (formula.hasTagCompound()) {
            if (!input.hasTagCompound()) return false;
            if (formula.getTagCompound().equals(input.getTagCompound())) return true;
            return false;
        }
        return true;
    }
}
