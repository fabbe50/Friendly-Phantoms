package com.fabbe50.phantoms.mixin;

import com.fabbe50.phantoms.ModGameRules;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Phantom.class)
public class MixinPhantom extends FlyingMob {
    @Shadow
    BlockPos anchorPoint;

    protected MixinPhantom(EntityType<? extends FlyingMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean canAttack(LivingEntity livingEntity) {
        MinecraftServer server = livingEntity.getServer();
        if (server != null) {
            if (server.getGameRules().getBoolean(ModGameRules.PHANTOMS_ATTACK)) {
                return super.canAttack(livingEntity);
            } else {
                if (super.canAttack(livingEntity)) {
                    this.anchorPoint = livingEntity.blockPosition().above(20 + this.random.nextInt(20));
                    if (this.anchorPoint.getY() < this.level().getSeaLevel()) {
                        this.anchorPoint = new BlockPos(this.anchorPoint.getX(), this.level().getSeaLevel() + 1, this.anchorPoint.getZ());
                    }
                }
                return false;
            }
        } else {
            return super.canAttack(livingEntity);
        }
    }
}
