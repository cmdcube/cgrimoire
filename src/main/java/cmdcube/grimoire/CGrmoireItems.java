package cmdcube.grimoire;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class CGrmoireItems {
    public static final Item GRIMOIRE = register("grimoire", Item::new, new Item.Properties());

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
            // Create the item key.
            ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CGrimoire.MOD_ID, name));

            // Create the item instance.
            T item = itemFactory.apply(settings.setId(itemKey));

            // Register the item.
            Registry.register(BuiltInRegistries.ITEM, itemKey, item);

            return item;
    }

    public static void init() {}
}
