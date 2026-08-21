package cmdcube.grimoire;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;

public class CGrmoireItems {
    public static final Item GRIMOIRE = register("grimoire", Item::new, new Item.Properties().stacksTo(1));
    public static final Item ASH_DUST = register("ash_dust", Item::new, new Item.Properties());
    public static final Item CINERIFER = register("cinerifer", Item::new, new Item.Properties().stacksTo(1));
    public static final Item TORTURAM_ELIMINANS = register("torturam_eliminans", Item::new, new Item.Properties().stacksTo(1));

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
            // Create the item key.
            ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CGrimoire.MOD_ID, name));

            // Create the item instance.
            T item = itemFactory.apply(settings.setId(itemKey));

            // Register the item.
            Registry.register(BuiltInRegistries.ITEM, itemKey, item);

            return item;
    }

    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(CGrimoire.MOD_ID, "creative_tab")
    );
    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CGrmoireItems.GRIMOIRE))
            .title(Component.translatable("itemGroup.cgrimoire"))
            .displayItems((params, output) -> {
                output.accept(CGrmoireItems.GRIMOIRE);
                output.accept(CGrmoireItems.ASH_DUST);
                output.accept(CGrimoireBlocks.ASH);
                output.accept(CGrmoireItems.CINERIFER);
                output.accept(CGrmoireItems.TORTURAM_ELIMINANS);
            })
            .build();

    public static void init() {

        // Register the group.
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);

    }
}
