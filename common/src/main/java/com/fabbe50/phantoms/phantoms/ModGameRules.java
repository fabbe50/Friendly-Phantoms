package com.fabbe50.phantoms.phantoms;

import net.minecraft.world.level.GameRules;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModGameRules {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final GameRules.Key<GameRules.BooleanValue> PHANTOMS_ATTACK;

    public static void init() {
    }

    static {
        PHANTOMS_ATTACK = GameRules.register("doPhantomsAttack", GameRules.Category.MOBS, GameRules.BooleanValue.create(false, (minecraftServer, booleanValue) -> LOGGER.info("set value to {}", booleanValue.get())));
    }
}
