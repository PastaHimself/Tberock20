/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.dimensions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.PlayerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/handlers/dimensions/BecomeVoid;", "", "<init>", "()V", "sendToDim", "", "Lnet/minecraft/server/level/ServerPlayer;", "dim", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "onPlayerTick", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nBecomeVoid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BecomeVoid.kt\nnet/thebrokenscript/handlers/dimensions/BecomeVoid\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1869#2,2:154\n*S KotlinDebug\n*F\n+ 1 BecomeVoid.kt\nnet/thebrokenscript/handlers/dimensions/BecomeVoid\n*L\n69#1:154,2\n*E\n"})
public final class BecomeVoid {
    @NotNull
    public static final BecomeVoid INSTANCE = new BecomeVoid();

    private BecomeVoid() {
    }

    private final void sendToDim(ServerPlayer $this$sendToDim, ResourceKey<Level> dim) {
        if ($this$sendToDim.isPassenger()) {
            $this$sendToDim.stopRiding();
        }
        PlayerExt.INSTANCE.updateVars((Player)$this$sendToDim, (Function1<? super PlayerVariables, Unit>)((Function1)BecomeVoid::sendToDim$lambda$0));
        if (PlayerUtil.sendTo((Player)((Player)$this$sendToDim), dim)) {
            TheBrokenScript.serverWorkQueue.add(1L, () -> BecomeVoid.sendToDim$lambda$1($this$sendToDim));
        }
    }

    private final void onPlayerTick(Player player) {
        ServerPlayer serverPlayer = player instanceof ServerPlayer ? (ServerPlayer)player : null;
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player2 = serverPlayer;
        Level level = player2.level();
        ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
        if (serverLevel == null) {
            return;
        }
        ServerLevel level2 = serverLevel;
        ResourceKey resourceKey = level2.dimension();
        if (Intrinsics.areEqual((Object)resourceKey, (Object)Level.OVERWORLD)) {
            boolean canChange;
            boolean bl = canChange = player2.getY() < -78.0 && !player2.isChangingDimension() && !PlayerExt.INSTANCE.getVars((Player)player2).getFixPos();
            if (canChange) {
                if (LevelExt.INSTANCE.getVars((LevelAccessor)level2).getMoonStage() > 0) {
                    player2.displayClientMessage((Component)TBSLang.INSTANCE.getBECOME_VOID(), true);
                    player2.getAbilities().flying = true;
                    player2.getAbilities().mayfly = true;
                    player2.onUpdateAbilities();
                    player2.setDeltaMovement(Vec3.ZERO);
                    this.sendToDim(player2, TBSDimensions.CORRUPTED_MOON);
                } else if (LevelExt.INSTANCE.getVars((LevelAccessor)level2).getMoonStage() == 0) {
                    this.sendToDim(player2, TBSDimensions.NOWHERE);
                }
            }
        } else if (Intrinsics.areEqual((Object)resourceKey, TBSDimensions.STAGE2)) {
            if (player2.getY() <= 4.0 && !PlayerExt.INSTANCE.getVars((Player)player2).getFixPos()) {
                if (Arena.Companion.getInstance() != null) {
                    Arena arena = Arena.Companion.getInstance();
                    Intrinsics.checkNotNull((Object)arena);
                    Iterable $this$forEach$iv = arena.getPlayers();
                    boolean $i$f$forEach = false;
                    for (Object element$iv : $this$forEach$iv) {
                        ServerPlayer player3 = (ServerPlayer)element$iv;
                        boolean bl = false;
                        PlayerExt.INSTANCE.updateVars((Player)player3, (Function1<? super PlayerVariables, Unit>)((Function1)BecomeVoid::onPlayerTick$lambda$0$0));
                        PlayerUtil.sendTo((Player)((Player)player3), TBSDimensions.STAGE3);
                    }
                } else {
                    PlayerExt.INSTANCE.updateVars((Player)player2, (Function1<? super PlayerVariables, Unit>)((Function1)BecomeVoid::onPlayerTick$lambda$1));
                    PlayerUtil.sendTo((Player)((Player)player2), TBSDimensions.STAGE3);
                }
            }
        } else if (Intrinsics.areEqual((Object)resourceKey, TBSDimensions.CONCRETE)) {
            if (player2.getY() < -85.0 && !PlayerExt.INSTANCE.getVars((Player)player2).getFixPos()) {
                PlayerExt.INSTANCE.updateVars((Player)player2, (Function1<? super PlayerVariables, Unit>)((Function1)BecomeVoid::onPlayerTick$lambda$2));
                Player player4 = (Player)player2;
                ResourceKey resourceKey2 = Level.OVERWORLD;
                Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"OVERWORLD");
                PlayerUtil.sendTo((Player)player4, (ResourceKey)resourceKey2);
                BlockPos blockPos = PlayerExt.INSTANCE.getInteractionTracker((Player)player2).getLastBedInteraction();
                if (blockPos != null) {
                    TheBrokenScript.serverWorkQueue.add(5L, () -> BecomeVoid.onPlayerTick$lambda$3(player2, blockPos));
                }
            }
        } else if (Intrinsics.areEqual((Object)resourceKey, TBSDimensions.CORRUPTED_MOON)) {
            if (player2.getY() < -85.0 && !PlayerExt.INSTANCE.getVars((Player)player2).getFixPos()) {
                if (player2.isFallFlying()) {
                    player2.stopFallFlying();
                }
                ResourceKey resourceKey3 = Level.OVERWORLD;
                Intrinsics.checkNotNullExpressionValue((Object)resourceKey3, (String)"OVERWORLD");
                this.sendToDim(player2, (ResourceKey<Level>)resourceKey3);
            }
        } else if (Intrinsics.areEqual((Object)resourceKey, TBSDimensions.NOWHERE)) {
            if (player2.getY() < -100.0 && !PlayerExt.INSTANCE.getVars((Player)player2).getFixPos()) {
                this.sendToDim(player2, TBSDimensions.PROTECTED_VOID);
            }
        } else if (Intrinsics.areEqual((Object)resourceKey, TBSDimensions.CLAN_VOID)) {
            if (player2.getY() < 105.0 && player2.getY() > 98.0) {
                PlayerUtil.stopAllSounds((Player)((Player)player2));
                PlayerExt.INSTANCE.updateVars((Player)player2, (Function1<? super PlayerVariables, Unit>)((Function1)BecomeVoid::onPlayerTick$lambda$4));
                if (player2.isPassenger()) {
                    player2.stopRiding();
                }
                BlockPos blockPos = player2.blockPosition();
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"blockPosition(...)");
                Vec3 vec3 = PositionUtil.withY((BlockPos)blockPos, (Number)550).getBottomCenter();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getBottomCenter(...)");
                if (PlayerUtil.smoothTeleport((ServerPlayer)player2, (Vec3)vec3)) {
                    PlayerExt.tryPlaySound$default(PlayerExt.INSTANCE, (Player)player2, (SoundEvent)TBSSounds.TRAVEL_GLITCHED.invoke(), false, 0.0f, 0.0f, 0.0f, 30, null);
                    PlayerExt.INSTANCE.updateVars((Player)player2, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> BecomeVoid.onPlayerTick$lambda$5(player2, arg_0)));
                }
                player2.setDeltaMovement(Vec3.ZERO);
                player2.hasImpulse = true;
            } else if (player2.getY() < 251.0 && player2.getY() > 249.0) {
                PlayerExt.INSTANCE.updateVars((Player)player2, (Function1<? super PlayerVariables, Unit>)((Function1)BecomeVoid::onPlayerTick$lambda$6));
                PlayerUtil.stopAllSounds((Player)((Player)player2));
            } else if (player2.getY() < 231.0 && player2.getY() > 229.0) {
                PlayerExt.INSTANCE.updateVars((Player)player2, (Function1<? super PlayerVariables, Unit>)((Function1)BecomeVoid::onPlayerTick$lambda$7));
                PlayerUtil.stopAllSounds((Player)((Player)player2));
            }
        }
    }

    private static final Unit sendToDim$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }

    private static final Unit sendToDim$lambda$1(ServerPlayer $this_sendToDim) {
        PlayerExt.tryPlaySound$default(PlayerExt.INSTANCE, (Player)$this_sendToDim, (SoundEvent)TBSSounds.TRAVEL.invoke(), false, 0.0f, 0.0f, 0.0f, 30, null);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerTick$lambda$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerTick$lambda$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerTick$lambda$2(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        $this$updateVars.setSkipFallDamage(true);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerTick$lambda$3(ServerPlayer $player, BlockPos $blockPos) {
        EntityUtil.teleport((Entity)((Entity)$player), (BlockPos)$blockPos);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerTick$lambda$4(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setSkipFallDamage(true);
        $this$updateVars.setMusicTimer(65);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerTick$lambda$5(ServerPlayer $player, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setLastClanVoidTeleport($player.level().getGameTime());
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerTick$lambda$6(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setSkipFallDamage(true);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerTick$lambda$7(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setSkipFallDamage(true);
        return Unit.INSTANCE;
    }

    static {
        PlayerTickSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((BecomeVoid)this.receiver).onPlayerTick(p0);
            }
        }));
    }
}

