package net.villanelle.villasmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.villanelle.villasmod.VillasMod;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VillasMod.MOD_ID);

    public static final DeferredItem<Item> JADE  = ITEMS.register("jade", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_JADE  = ITEMS.register("raw_jade", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
