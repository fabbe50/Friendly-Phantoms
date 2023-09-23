package com.fabbe50.phantoms.phantoms.forge;

import dev.architectury.platform.forge.EventBuses;
import com.fabbe50.phantoms.phantoms.Phantoms_LeaveMeAlone_;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Phantoms_LeaveMeAlone_.MOD_ID)
public class Phantoms_LeaveMeAlone_Forge {
    public Phantoms_LeaveMeAlone_Forge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Phantoms_LeaveMeAlone_.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Phantoms_LeaveMeAlone_.init();
    }
}