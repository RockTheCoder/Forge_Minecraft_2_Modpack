package net.rocco.minecraft2.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rocco.minecraft2.Minecraft2;
import net.rocco.minecraft2.block.ModBlocks;
import net.rocco.minecraft2.block.custom.RubyLampBlock;

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
        blockItem(ModBlocks.RED_SPRUCE_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.RED_SPRUCE_PRESSURE_PLATE);
        blockItem(ModBlocks.RED_SPRUCE_FENCE_GATE);

        pressurePlateBlock(ModBlocks.RED_SPRUCE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()));
        fenceBlock(ModBlocks.RED_SPRUCE_FENCE.get(), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()));
        buttonBlock(ModBlocks.RED_SPRUCE_BUTTON.get(), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()));
        fenceGateBlock(ModBlocks.RED_SPRUCE_FENCE_GATE.get(), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()));
        trapdoorBlockWithRenderType(ModBlocks.RED_SPRUCE_TRAPDOOR.get(), modLoc("block/red_spruce_trapdoor"), true, "cutout");
        doorBlockWithRenderType(ModBlocks.RED_SPRUCE_DOOR.get(), modLoc("block/red_spruce_door_bottom"), modLoc("block/red_spruce_door_top"), "cutout");
        slabBlock(ModBlocks.RED_SPRUCE_SLAB.get(), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()));
        stairsBlock((StairBlock) ModBlocks.RED_SPRUCE_STAIRS.get(), blockTexture(ModBlocks.RED_SPRUCE_PLANK.get()));
        blockItem(ModBlocks.RED_SPRUCE_STAIRS);
        blockItem(ModBlocks.RED_SPRUCE_SLAB);
        customLamp();

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
    private void customLamp() {
        getVariantBuilder(ModBlocks.RUBY_LAMP.get()).forAllStates(state -> {
            if(state.getValue(RubyLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ruby_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(Minecraft2.MOD_ID, "block/" + "ruby_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ruby_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(Minecraft2.MOD_ID, "block/" + "ruby_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.RUBY_LAMP.get(), models().cubeAll("ruby_lamp_on",
                ResourceLocation.fromNamespaceAndPath(Minecraft2.MOD_ID, "block/" + "ruby_lamp_on")));
    }
}
