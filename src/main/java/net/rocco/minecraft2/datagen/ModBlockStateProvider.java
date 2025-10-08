package net.rocco.minecraft2.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rocco.minecraft2.Minecraft2;
import net.rocco.minecraft2.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Minecraft2.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.ROSE_QUARTZ_BLOCK);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.ROSE_QUARTZ_ORE);
        blockWithItem(ModBlocks.RED_SPRUCE_PLANK);


        buttonBlock(ModBlocks.RED_SPRUCE_BUTTON.get(), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()));
        doorBlockWithRenderType(ModBlocks.RED_SPRUCE_DOOR.get(), modLoc("block/red_spruce_door_bottom"), modLoc("block/red_spruce_door_top"), "cutout");
        slabBlock(ModBlocks.RED_SPRUCE_SLAB.get(), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()));
        stairsBlock((StairBlock) ModBlocks.RED_SPRUCE_STAIRS.get(), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()));
        blockItem(ModBlocks.RED_SPRUCE_STAIRS);
        blockItem(ModBlocks.RED_SPRUCE_SLAB);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("minecraft_2:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("minecraft_2:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
