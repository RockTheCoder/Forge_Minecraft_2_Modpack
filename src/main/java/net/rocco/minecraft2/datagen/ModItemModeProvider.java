package net.rocco.minecraft2.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rocco.minecraft2.Minecraft2;
import net.rocco.minecraft2.item.ModItems;

public class ModItemModeProvider extends ItemModelProvider {
    public ModItemModeProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Minecraft2.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.Sapphire.get());
        basicItem(ModItems.OIL.get());
        basicItem(ModItems.RED_ONION.get());
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.ROSE_QUARTZ.get());
    }
}
