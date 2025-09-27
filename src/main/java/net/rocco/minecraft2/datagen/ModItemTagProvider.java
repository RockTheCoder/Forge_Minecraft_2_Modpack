package net.rocco.minecraft2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rocco.minecraft2.Minecraft2;
import net.rocco.minecraft2.item.ModItems;
import net.rocco.minecraft2.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Minecraft2.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMATIVE_ITEMS)
                .add(ModItems.Sapphire.get())
                .add(Items.NETHERITE_INGOT)
                .add(ModItems.RUBY.get())
                .add(Items.DIAMOND)
                .add(Items.GOLD_INGOT);
    }
}
