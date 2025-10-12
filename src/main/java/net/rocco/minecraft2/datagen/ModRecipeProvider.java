package net.rocco.minecraft2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.rocco.minecraft2.block.ModBlocks;
import net.rocco.minecraft2.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                        .pattern("AAA")
                        .pattern("AAA")
                        .pattern("AAA")
                        .define('A', ModItems.Sapphire.get())
                        .unlockedBy(getHasName(ModItems.Sapphire.get()), has(ModBlocks.SAPPHIRE_BLOCK.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Sapphire.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIL.get())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('A', Items.CHARCOAL)
                .define('B',Items.BLAZE_POWDER)
                .define('C',Items.BUCKET)
                .unlockedBy(getHasName(Items.BLAZE_POWDER), has(Items.BLAZE_POWDER)).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.RED_SPRUCE_PLANK.get(), 4)
                .requires(ModBlocks.RED_SPRUCE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.RED_SPRUCE_LOG.get()), has(ModBlocks.RED_SPRUCE_LOG.get())).save(pRecipeOutput);
        stairBuilder(ModBlocks.RED_SPRUCE_STAIRS.get(), Ingredient.of(ModBlocks.RED_SPRUCE_PLANK.get())).group("red_spruce_plank")
                .unlockedBy(getHasName(ModBlocks.RED_SPRUCE_LEAVES.get()), has(ModBlocks.RED_SPRUCE_STAIRS.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_SPRUCE_SLAB.get(), ModBlocks.RED_SPRUCE_PLANK.get());
        doorBuilder(ModBlocks.RED_SPRUCE_DOOR.get(), Ingredient.of(ModBlocks.RED_SPRUCE_PLANK.get())).group("red_spruce_plank")
                .unlockedBy(getHasName(ModBlocks.RED_SPRUCE_PLANK.get()), has(ModBlocks.RED_SPRUCE_PLANK.get())).save(pRecipeOutput);

        buttonBuilder(ModBlocks.RED_SPRUCE_BUTTON.get(), Ingredient.of(ModBlocks.RED_SPRUCE_PLANK.get())).group("red_spruce_plank")
                .unlockedBy(getHasName(ModBlocks.RED_SPRUCE_PLANK.get()), has(ModBlocks.RED_SPRUCE_PLANK.get())).save(pRecipeOutput);
        fenceBuilder(ModBlocks.RED_SPRUCE_FENCE.get(), Ingredient.of(ModBlocks.RED_SPRUCE_PLANK.get())).group("red_spruce_plank")
                .unlockedBy(getHasName(ModBlocks.RED_SPRUCE_PLANK.get()), has(ModBlocks.RED_SPRUCE_PLANK.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.RED_SPRUCE_TRAPDOOR.get(), Ingredient.of(ModBlocks.RED_SPRUCE_PLANK.get())).group("red_spruce_plank")
                .unlockedBy(getHasName(ModBlocks.RED_SPRUCE_PLANK.get()), has(ModBlocks.RED_SPRUCE_PLANK.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.RED_SPRUCE_FENCE_GATE.get(), Ingredient.of(ModBlocks.RED_SPRUCE_PLANK.get())).group("red_spruce_plank")
                .unlockedBy(getHasName(ModBlocks.RED_SPRUCE_PLANK.get()), has(ModBlocks.RED_SPRUCE_PLANK.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.RED_SPRUCE_PRESSURE_PLATE.get(), ModBlocks.RED_SPRUCE_PLANK.get());

    }
}
