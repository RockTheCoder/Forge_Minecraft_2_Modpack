package net.rocco.minecraft2.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rocco.minecraft2.Minecraft2;
import net.rocco.minecraft2.block.ModBlocks;
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
        fenceItem(ModBlocks.RED_SPRUCE_FENCE, ModBlocks.RED_SPRUCE_PLANK);
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.ROSE_QUARTZ.get());

        buttonItem(ModBlocks.RED_SPRUCE_BUTTON, ModBlocks.RED_SPRUCE_PLANK);
        simpleBlockItem(ModBlocks.RED_SPRUCE_DOOR);
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Minecraft2.MOD_ID,"item/" + item.getId().getPath()));
    }
    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Minecraft2.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Minecraft2.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
