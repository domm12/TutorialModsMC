package net.dom.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
        .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,
        50), 1).build();

    public static final FoodProperties LOW_QUALITY_MINOR_VITALITY_PILL =  new FoodProperties.Builder().alwaysEat().fast()
        .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1), 0.4f).build();
    public static final FoodProperties MID_QUALITY_MINOR_VITALITY_PILL =  new FoodProperties.Builder().alwaysEat().fast()
        .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1), 0.8f).build();
    public static final FoodProperties HIGH_QUALITY_MINOR_VITALITY_PILL =  new FoodProperties.Builder().alwaysEat().fast()
        .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1), 1f).build();
}
