package net.rocco.minecraft2.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rocco.minecraft2.Minecraft2;
import net.rocco.minecraft2.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Minecraft2.MOD_ID);



    public static final RegistryObject<CreativeModeTab> NEW_ITEMS_TAB = CREATIVE_MODE_TABS.register("new_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab.minecraft_2.new_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.Sapphire.get());
                        output.accept(ModItems.ROSE_QUARTZ.get());
                        output.accept(ModItems.CHISEL.get());
                        output.accept(ModItems.RED_ONION.get());
                        output.accept(ModItems.OIL.get());
                    })

                    .build());

    public static final RegistryObject<CreativeModeTab> NEW_BLOCKS_TAB = CREATIVE_MODE_TABS.register("new_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RUBY_ORE.get()))
                    .withTabsBefore(NEW_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.minecraft_2.new_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.RED_SPRUCE_LOG.get());
                        output.accept(ModBlocks.RED_SPRUCE_LEAVES.get());
                        output.accept(ModBlocks.RED_GRASS_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.ROSE_QUARTZ_ORE.get());
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.ROSE_QUARTZ_BLOCK.get());
                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                        output.accept(ModBlocks.RED_SPRUCE_PLANK.get());
                        output.accept(ModBlocks.RED_SPRUCE_STAIRS.get());
                        output.accept(ModBlocks.RED_SPRUCE_SLAB.get());
                        output.accept(ModBlocks.RED_SPRUCE_DOOR.get());
                    })

                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
