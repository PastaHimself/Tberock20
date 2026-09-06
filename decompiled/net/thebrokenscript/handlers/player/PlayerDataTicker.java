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
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.learner.util.UnfinalizedPlayerBase
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.learner.util.UnfinalizedPlayerBase;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.data.PlayerVarsSyncer;
import net.thebrokenscript.handlers.subs.ServerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.PlayerDesyncManager;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/player/PlayerDataTicker;", "", "<init>", "()V", "onServerTick", "", "server", "Lnet/minecraft/server/MinecraftServer;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlayerDataTicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerDataTicker.kt\nnet/thebrokenscript/handlers/player/PlayerDataTicker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,184:1\n1869#2,2:185\n*S KotlinDebug\n*F\n+ 1 PlayerDataTicker.kt\nnet/thebrokenscript/handlers/player/PlayerDataTicker\n*L\n175#1:185,2\n*E\n"})
public final class PlayerDataTicker {
    @NotNull
    public static final PlayerDataTicker INSTANCE = new PlayerDataTicker();

    private PlayerDataTicker() {
    }

    private final void onServerTick(MinecraftServer server) {
        for (ServerPlayer player : server.getPlayerList().getPlayers()) {
            Intrinsics.checkNotNull((Object)player);
            PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
            if (vars.getMoonGlitchDuration() > 0.0) {
                double d = vars.getMoonGlitchDuration();
                vars.setMoonGlitchDuration(d + -1.0);
                if (vars.getMoonGlitchDuration() <= 0.0) {
                    vars.syncTo((Player)player);
                }
            }
            if (vars.getIsolationTimer() > 0) {
                int n = vars.getIsolationTimer();
                vars.setIsolationTimer(n + -1);
                if (vars.getIsolationTimer() <= 0) {
                    vars.syncTo((Player)player);
                }
            } else {
                vars.setIsolationActive(false);
                vars.getIsolationAllowedUsers().getEntries().clear();
            }
            if (vars.getAberrationTimer() > 0L) {
                long l = vars.getAberrationTimer();
                vars.setAberrationTimer(l + -1L);
                if (vars.getAberrationTimer() <= 0L) {
                    vars.setAberrationEnabled(false);
                    vars.syncTo((Player)player);
                }
            }
            if (vars.getScreenDupeTimer() > 0L) {
                long l = vars.getScreenDupeTimer();
                vars.setScreenDupeTimer(l + -1L);
                if (vars.getScreenDupeTimer() <= 0L) {
                    vars.setEnableScreenDupe(false);
                    vars.syncTo((Player)player);
                }
            }
            if (vars.getInvertTimer() > 0L) {
                long l = vars.getInvertTimer();
                vars.setInvertTimer(l + -1L);
                if (vars.getInvertTimer() <= 0L) {
                    vars.setInvertEnabled(false);
                    vars.syncTo((Player)player);
                }
            }
            if (vars.getSyncTimer() > 0L) {
                long l = vars.getSyncTimer();
                vars.setSyncTimer(l + -1L);
                if (vars.getSyncTimer() <= 0L) {
                    vars.syncTo((Player)player);
                    PlayerExt.INSTANCE.tryStopLoopingSound((Player)player, (SoundEvent)TBSSounds.TAPE_HISS.get());
                    PlayerExt.INSTANCE.getVars((Player)player).setVhsEnabled(!PlayerExt.INSTANCE.getVars((Player)player).getVhsEnabled());
                    PlayerExt.INSTANCE.getVars((Player)player).syncTo((Player)player);
                    if (player.getRandom().nextFloat() <= 0.2f) {
                        PlayerDesyncManager.resync(player);
                        Player player2 = (Player)player;
                        String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_TITLE()));
                        Intrinsics.checkNotNull((Object)string);
                        String string2 = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_ERR_PLAYER()));
                        Intrinsics.checkNotNull((Object)string2);
                        PlayerUtil.tryShowAlert((Player)player2, (String)string, (String)string2);
                        PlayerUtil.tryCrash((Player)((Player)player));
                    } else if (player.getRandom().nextFloat() <= 0.5f) {
                        PlayerDesyncManager.resync(player);
                    } else if (player.getRandom().nextFloat() <= 0.05f) {
                        PlayerDesyncManager.resync(player);
                        if (!TBSConfigs.INSTANCE.getServer().getDisableBanning()) {
                            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)PlayerDataTicker::onServerTick$lambda$0));
                        }
                    } else {
                        PlayerDesyncManager.resync(player);
                        MutableComponent mutableComponent = Component.literal((String)"");
                        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"literal(...)");
                        PlayerUtil.kick((ServerPlayer)player, (Component)((Component)mutableComponent));
                        Player player3 = (Player)player;
                        String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_TITLE()));
                        Intrinsics.checkNotNull((Object)string);
                        String string3 = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_ERR_PLAYER()));
                        Intrinsics.checkNotNull((Object)string3);
                        PlayerUtil.tryShowAlert((Player)player3, (String)string, (String)string3);
                    }
                }
            }
            if (vars.getTicksUntilExit() > 0L) {
                long l = vars.getTicksUntilExit();
                vars.setTicksUntilExit(l + -1L);
                if (vars.getTicksUntilExit() <= 0L && TBSDimensions.ALL.contains(player.level().dimension())) {
                    BlockPos blockPos = PlayerExt.INSTANCE.getInteractionTracker((Player)player).getLastBedInteraction();
                    if (blockPos != null && (TBSDimensions.NIGHTMARES.contains(player.level().dimension()) || Intrinsics.areEqual((Object)player.level().dimension(), TBSDimensions.NULL_TORTURE))) {
                        PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)PlayerDataTicker::onServerTick$lambda$1));
                        Player player4 = (Player)player;
                        ResourceKey resourceKey = Level.OVERWORLD;
                        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"OVERWORLD");
                        PlayerUtil.sendTo((Player)player4, (ResourceKey)resourceKey);
                        v9 = TheBrokenScript.serverWorkQueue.add(15L, () -> PlayerDataTicker.onServerTick$lambda$2(player, blockPos));
                    } else {
                        PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)PlayerDataTicker::onServerTick$lambda$3));
                        Player player5 = (Player)player;
                        ResourceKey resourceKey = Level.OVERWORLD;
                        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"OVERWORLD");
                        v9 = PlayerUtil.sendTo((Player)player5, (ResourceKey)resourceKey);
                    }
                }
            }
            if (vars.getNullFlyRepGainTimer() > 0) {
                int blockPos = vars.getNullFlyRepGainTimer();
                vars.setNullFlyRepGainTimer(blockPos + -1);
                if (vars.getNullFlyRepGainTimer() <= 0) {
                    vars.syncTo((Player)player);
                }
            }
            if (vars.getDespawnEntitySwitch() && player.getRandom().nextFloat() < 0.001f) {
                PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)PlayerDataTicker::onServerTick$lambda$4));
            }
            if (vars.getSkipFallDamage() && player.serverLevel().getGameTime() % (long)120 == 0L && !player.level().getBlockState(player.blockPosition().below()).isAir()) {
                PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)PlayerDataTicker::onServerTick$lambda$5));
            }
            if (vars.getBan() && !TBSConfigs.INSTANCE.getServer().getDisableBanning()) {
                MutableComponent mutableComponent = Component.translatable((String)"multiplayer.disconnect.banned");
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
                PlayerUtil.kick((ServerPlayer)player, (Component)((Component)mutableComponent));
            }
            List toRemove = new ArrayList();
            Iterable $this$forEach$iv = PlayerVarsSyncer.INSTANCE.getUnfinalizedBases$thebrokenscript_common();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                UnfinalizedPlayerBase it = (UnfinalizedPlayerBase)element$iv;
                boolean bl = false;
                it.tick();
                if (!it.getDone()) continue;
                Intrinsics.checkNotNull((Object)it);
                toRemove.add(it);
            }
            toRemove.removeAll(toRemove);
            vars.setBaseRescanCooldown(Math.max(vars.getBaseRescanCooldown() - 1, 0));
        }
    }

    private static final Unit onServerTick$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setBan(true);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        $this$updateVars.setSkipFallDamage(true);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$2(ServerPlayer $player, BlockPos $blockPos) {
        EntityUtil.teleport((Entity)((Entity)$player), (BlockPos)$blockPos);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$3(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        $this$updateVars.setSkipFallDamage(true);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$4(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setDespawnEntitySwitch(false);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$5(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setSkipFallDamage(false);
        return Unit.INSTANCE;
    }

    static {
        ServerTickSubscriber.INSTANCE.add((Function1<? super MinecraftServer, Unit>)((Function1)new Function1<MinecraftServer, Unit>((Object)INSTANCE){

            public final void invoke(MinecraftServer p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((PlayerDataTicker)this.receiver).onServerTick(p0);
            }
        }));
    }
}

