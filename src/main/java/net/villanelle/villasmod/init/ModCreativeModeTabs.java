package net.villanelle.villasmod.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.villanelle.villasmod.VillasMod;
import net.villanelle.villasmod.block.ModBlocks;
import net.villanelle.villasmod.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VillasMod.MOD_ID);

    public static final Supplier<CreativeModeTab> MOD_INGREDIENTS_TAB = CREATIVE_MODE_TAB.register("mod_ingredients_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.JADE.get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.translatable("creativetab.villasmod.mod_ingredients_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.JADE);
                        output.accept(ModItems.RAW_JADE);
                    }).build());

    public static final Supplier<CreativeModeTab> MOD_NATURAL_BLOCKS_TAB = CREATIVE_MODE_TAB.register("mod_natural_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.DEEPSLATE_JADE_ORE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(VillasMod.MOD_ID, "mod_ingredients_tab"))
                    .title(Component.translatable("creativetab.villasmod.mod_natural_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.DEEPSLATE_JADE_ORE);
                    }).build());

    public static final Supplier<CreativeModeTab> MOD_BUILDING_BLOCKS_TAB = CREATIVE_MODE_TAB.register("mod_building_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.JADE_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(VillasMod.MOD_ID, "mod_natural_blocks_tab"))
                    .title(Component.translatable("creativetab.villasmod.mod_building_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.JADE_BLOCK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
