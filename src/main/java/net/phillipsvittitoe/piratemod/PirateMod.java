package net.phillipsvittitoe.piratemod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.phillipsvittitoe.piratemod.item.ModItems;
import org.slf4j.Logger;

@Mod(PirateMod.MOD_ID)
public final class PirateMod {
    public static final String MOD_ID = "piratemod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PirateMod(FMLJavaModLoadingContext context) {
        // Register DeferredRegister with BusGroup
        var busGroup = context.getModBusGroup();
        ModItems.ITEMS.register(busGroup);

        // Register common setup using the proper bus
        FMLCommonSetupEvent.getBus(busGroup).addListener(this::commonSetup);

        // Creative tab listener (use global bus)
        BuildCreativeModeTabContentsEvent.BUS.addListener(event -> {
            if (event.getTabKey().equals(CreativeModeTabs.INGREDIENTS)) {
                event.accept(ModItems.RUBY.get());
            }
        });

        // Config
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) { }

    @Mod.EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) { }
    }
}
