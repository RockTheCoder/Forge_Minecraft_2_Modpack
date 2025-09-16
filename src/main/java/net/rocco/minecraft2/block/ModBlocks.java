package net.rocco.minecraft2.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rocco.minecraft2.Minecraft2;
import net.rocco.minecraft2.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Minecraft2.MOD_ID);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> RED_GRASS_BLOCK = registerBlock("red_grass_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> RED_SPRUCE_LOG = registerBlock("red_spruce_log",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> RED_SPRUCE_LEAVES = registerBlock("red_spruce_leaves",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CHERRY_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ROSE_QUARTZ_BLOCK = registerBlock("rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
