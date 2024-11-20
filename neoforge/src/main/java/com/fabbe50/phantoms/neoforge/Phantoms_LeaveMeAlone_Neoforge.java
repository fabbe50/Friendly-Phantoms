package com.fabbe50.phantoms.neoforge;

import com.fabbe50.phantoms.Phantoms_LeaveMeAlone_;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Phantoms_LeaveMeAlone_.MOD_ID)
public class Phantoms_LeaveMeAlone_Neoforge {
    public Phantoms_LeaveMeAlone_Neoforge(IEventBus bus) {
        Phantoms_LeaveMeAlone_.init();
    }
}
