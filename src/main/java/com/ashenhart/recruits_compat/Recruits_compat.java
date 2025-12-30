package com.ashenhart.recruits_compat;

import com.ashenhart.recruits_compat.gameassets.RecruitAnimations;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Recruits_compat.MODID)
public class Recruits_compat {
    public static final String MODID = "recruits_compat";
    public Recruits_compat(FMLJavaModLoadingContext eventBus) {
        IEventBus bus = eventBus.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(RecruitAnimations::registerAnimations);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
