package net.rocco.minecraft2.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rocco.minecraft2.Minecraft2;
import net.rocco.minecraft2.block.custom.MagicBlock;
import net.rocco.minecraft2.block.custom.RubyLampBlock;
import net.rocco.minecraft2.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Minecraft2.MOD_ID);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> RED_GRASS_BLOCK = registerBlock("red_grass_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).sound(SoundType.GRASS)));

    public static final RegistryObject<Block> RED_SPRUCE_LOG = registerBlock("red_spruce_log",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> RED_SPRUCE_LEAVES = registerBlock("red_spruce_leaves",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f).sound(SoundType.CHERRY_LEAVES).noOcclusion()));

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,8), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ROSE_QUARTZ_ORE = registerBlock("rose_quartz_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,6), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)));

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> ROSE_QUARTZ_BLOCK = registerBlock("rose_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));
    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().noLootTable()));
    public static final RegistryObject<Block> RED_SPRUCE_PLANK = registerBlock("red_spruce_plank",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<StairBlock> RED_SPRUCE_STAIRS = registerBlock("red_spruce_stairs",
            () -> new StairBlock(ModBlocks.RED_SPRUCE_PLANK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<SlabBlock> RED_SPRUCE_SLAB = registerBlock("red_spruce_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<DoorBlock> RED_SPRUCE_DOOR = registerBlock("red_spruce_door",
            () -> new DoorBlock(BlockSetType.SPRUCE,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f).noOcclusion()));
    public static final RegistryObject<ButtonBlock> RED_SPRUCE_BUTTON = registerBlock("red_spruce_button",
            () -> new ButtonBlock(BlockSetType.SPRUCE, 15,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD).noCollission()));

    public static final RegistryObject<FenceBlock> RED_SPRUCE_FENCE = registerBlock("red_spruce_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).sound(SoundType.WOOD)));

    public static final RegistryObject<PressurePlateBlock> RED_SPRUCE_PRESSURE_PLATE = registerBlock("red_spruce_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.SPRUCE, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryObject<FenceGateBlock> RED_SPRUCE_FENCE_GATE = registerBlock("red_spruce_fence_gate",
            () -> new FenceGateBlock(WoodType.SPRUCE, BlockBehaviour.Properties.of().strength(3f).sound(SoundType.WOOD)));
    public static final RegistryObject<TrapDoorBlock> RED_SPRUCE_TRAPDOOR = registerBlock("red_spruce_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.SPRUCE,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f).noOcclusion()));
    public static final RegistryObject<Block> RUBY_LAMP = registerBlock("ruby_lamp",
            () -> new RubyLampBlock(BlockBehaviour.Properties.of().strength(3f)
                    .lightLevel(state -> state.getValue(RubyLampBlock.CLICKED) ? 15 : 0)));

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
