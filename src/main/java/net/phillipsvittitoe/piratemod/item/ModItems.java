package net.phillipsvittitoe.piratemod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phillipsvittitoe.piratemod.PirateMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PirateMod.MOD_ID);

    // Create a ResourceKey for the item using the static factory
    private static final ResourceLocation RUBY_LOC =
            ResourceLocation.fromNamespaceAndPath(PirateMod.MOD_ID, "ruby");

    private static final ResourceKey<Item> RUBY_KEY =
            ResourceKey.create(Registries.ITEM, RUBY_LOC);

    public static final RegistryObject<Item> RUBY =
            ITEMS.register("ruby", () -> new Item(
                    new Item.Properties().setId(RUBY_KEY)
            ));
}
