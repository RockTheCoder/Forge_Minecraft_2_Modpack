package net.rocco.minecraft2.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RED_ONION = new FoodProperties.Builder().nutrition(2).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS,400),0.20f).build();
}
