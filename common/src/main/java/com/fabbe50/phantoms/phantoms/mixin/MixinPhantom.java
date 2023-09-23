package com.fabbe50.phantoms.phantoms.mixin;

import com.fabbe50.phantoms.phantoms.ModGameRules;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Phantom.class)
public class MixinPhantom extends FlyingMob {
    protected MixinPhantom(EntityType<? extends FlyingMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean canAttack(LivingEntity livingEntity, TargetingConditions targetingConditions) {
        return livingEntity.level().getLevelData().getGameRules().getBoolean(ModGameRules.PHANTOMS_ATTACK);
    }
}
