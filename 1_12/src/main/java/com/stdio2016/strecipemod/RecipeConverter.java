package com.stdio2016.strecipemod;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.CraftingHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 2018/1/20.
 */
public class RecipeConverter {
    public final int width;
    public final int height;
    public Ingredient[] inputs;

    public RecipeConverter(Object... param){
        int h = 0;
        while (param[h] instanceof String) {
            h++;
        }
        this.height = h;
        this.width = ((String) param[0]).length();
        Map<Character, Object> ing = new HashMap<>();
        for (int i = h; i < param.length; i+=2) {
            ing.put((Character) param[i], param[i+1]);
        }
        inputs = new Ingredient[this.height * this.width];
        for (int i = 0; i < this.height; i++) {
            String row = (String) param[i];
            for (int j = 0; j < this.width; j++) {
                Character ch = row.charAt(j);
                inputs[i * this.height + j] = CraftingHelper.getIngredient(ing.get(ch));
            }
        }
    }
}
