package net.rocco.minecraft2.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.rocco.minecraft2.block.ModBlocks;
import net.rocco.minecraft2.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.RED_GRASS_BLOCK.get());
        dropSelf(ModBlocks.RED_SPRUCE_LOG.get());
        dropSelf(ModBlocks.RED_SPRUCE_LEAVES.get());
        dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        dropSelf(ModBlocks.ROSE_QUARTZ_BLOCK.get());
        dropSelf(ModBlocks.RED_SPRUCE_PLANK.get());
        dropSelf(ModBlocks.RED_SPRUCE_STAIRS.get());
        dropSelf(ModBlocks.RED_SPRUCE_BUTTON.get());
        this.add(ModBlocks.RED_SPRUCE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_SPRUCE_SLAB.get()));
        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.Sapphire.get(), 2,6));
        this.add(ModBlocks.ROSE_QUARTZ_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ROSE_QUARTZ_ORE.get(), ModItems.ROSE_QUARTZ.get(), 2,6));
        this.add(ModBlocks.RED_SPRUCE_DOOR.get(),
                block -> createDoorTable(ModBlocks.RED_SPRUCE_DOOR.get()));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }






    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
