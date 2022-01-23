package net.prelaw.mc.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static FoodComponent ORANGE = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build();
    public static FoodComponent BANANA = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build();
    public static FoodComponent COCONUT_OPENED = new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build();
    public static FoodComponent PINEAPPLE = new FoodComponent.Builder().hunger(5).saturationModifier(3.0f).build();
    public static FoodComponent HONEY_GLAZED_APPLE = new FoodComponent.Builder().hunger(8).saturationModifier(3.6f).build();
    public static FoodComponent JEWELED_APPLE = new FoodComponent.Builder().hunger(6).saturationModifier(1.2f).build();
    public static FoodComponent SWEET_BERRY_JUICE = new FoodComponent.Builder().hunger(6).saturationModifier(0.1f).build();
    public static FoodComponent ORANGE_JUICE = new FoodComponent.Builder().hunger(6).saturationModifier(0.1f).build();
    public static FoodComponent SWEET_BERRY_DISH = new FoodComponent.Builder().hunger(6).saturationModifier(0.1f).build();
}
