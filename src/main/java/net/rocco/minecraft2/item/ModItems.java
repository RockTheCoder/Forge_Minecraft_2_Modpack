package net.rocco.minecraft2.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rocco.minecraft2.Minecraft2;
import net.rocco.minecraft2.item.custom.ChiselItem;
import net.rocco.minecraft2.item.custom.FuelItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Minecraft2.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Sapphire = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> RED_ONION = ITEMS.register("red_onion",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RED_ONION)));
    public static final RegistryObject<Item> OIL = ITEMS.register("oil",
            () -> new FuelItem(new Item.Properties().craftRemainder(Items.BUCKET), 22000));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
