/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.EntityTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.LivingEntity$Fallsounds
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.misc;

import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Player.class})
public abstract class PlayerMixin {
    @Shadow
    public abstract void playSound(SoundEvent var1, float var2, float var3);

    @Shadow
    public abstract LivingEntity.Fallsounds getFallSounds();

    @Shadow
    public abstract boolean hurt(DamageSource var1, float var2);

    @Unique
    private static Set<ResourceKey<Level>> tbs$getDimsWithNoFallDamage() {
        return Set.of(TBSDimensions.CORRUPTED_MOON, TBSDimensions.LIBRARY, TBSDimensions.STAGE2, TBSDimensions.CONCRETE, TBSDimensions.LUCID, TBSDimensions.PROTECTED_VOID);
    }

    @Inject(method={"getAttackStrengthScale"}, at={@At(value="HEAD")}, cancellable=true)
    private void tbs$removeCooldown(CallbackInfoReturnable<Float> ci) {
        if (TBSConfigs.INSTANCE.getServer().getDanger().getDisableAttackCooldown()) {
            ci.setReturnValue((Object)Float.valueOf(1.0f));
        }
    }

    @Inject(method={"causeFallDamage"}, at={@At(value="HEAD")}, cancellable=true)
    private void tbs$skipFallDamage(float fallDistance, float multiplier, DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        Player player = (Player)this;
        if (PlayerMixin.tbs$getDimsWithNoFallDamage().contains(player.level().dimension())) {
            cir.cancel();
            return;
        }
        if (((PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player)).getSkipFallDamage() || player.level().dimension().equals(TBSDimensions.NOWHERE)) {
            cir.cancel();
            ((PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player)).setSkipFallDamage(false);
            PlayerExt.INSTANCE.syncVars(player);
            int height = (int)fallDistance;
            int calc = this.tbs$calculateFallDamage(fallDistance, multiplier, player);
            if (calc > 0 && !player.getAbilities().mayfly) {
                this.playSound(this.tbs$getFallDamageSound(height), 1.0f, 1.0f);
                if (player.level() != null) {
                    this.tbs$playBlockFallSound(player.getBlockX(), player.getBlockY(), player.getBlockZ(), player.level());
                }
                this.hurt(source, 0.001f);
            }
        }
    }

    @Unique
    private SoundEvent tbs$getFallDamageSound(int height) {
        return height > 4 ? this.getFallSounds().big() : this.getFallSounds().small();
    }

    @Unique
    protected void tbs$playBlockFallSound(int x, int y, int z, Level level) {
        int k;
        int j;
        int i;
        BlockState blockState;
        if (!((LivingEntity)this).isSilent() && !(blockState = level.getBlockState(new BlockPos(i = Mth.floor((float)x), j = Mth.floor((double)((double)y - (double)0.2f)), k = Mth.floor((float)z)))).isAir()) {
            SoundType soundType = blockState.getSoundType();
            this.playSound(soundType.getFallSound(), soundType.getVolume() * 0.5f, soundType.getPitch() * 0.75f);
        }
    }

    @Unique
    protected int tbs$calculateFallDamage(float fallDistance, float damageMultiplier, Player player) {
        if (((Player)this).getType().is(EntityTypeTags.FALL_DAMAGE_IMMUNE)) {
            return 0;
        }
        float f = (float)player.getAttributeValue(Attributes.SAFE_FALL_DISTANCE);
        float g = fallDistance - f;
        return Mth.ceil((double)((double)(g * damageMultiplier) * player.getAttributeValue(Attributes.FALL_DAMAGE_MULTIPLIER)));
    }

    @Inject(method={"attack"}, at={@At(value="HEAD")}, cancellable=true)
    protected void cancelAttack(Entity target, CallbackInfo ci) {
        boolean isDragon;
        Player player = (Player)this;
        boolean discard = ((PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player)).getDespawnEntitySwitch();
        boolean isVanilla = BuiltInRegistries.ENTITY_TYPE.getKey((Object)target.getType()).getNamespace().equals("minecraft");
        boolean bl = isDragon = target.getType() == EntityType.ENDER_DRAGON;
        if (discard && isVanilla && !isDragon && !(target instanceof Player)) {
            target.discard();
            ((PlayerVariables)TBSDataAttachments.PLAYER_VARIABLES.get((Entity)player)).setDespawnEntitySwitch(false);
            PlayerExt.INSTANCE.syncVars(player);
            ci.cancel();
        }
    }
}

