package net.zuperz.neotech.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProoerties {
    public static final FoodProperties STEEL_GEAR = new FoodProperties.Builder().nutrition(4).saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600), 0.1f).build();


}
