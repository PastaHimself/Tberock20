/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.GameRules$BooleanValue
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.PacketUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.fake.CustomPlayerManager
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import com.mojang.authlib.GameProfile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.PacketUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.fake.CustomPlayerManager;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.handlers.subs.ServerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.misc.GameProfiles;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/ServerDataTicker;", "", "<init>", "()V", "onServerTick", "", "server", "Lnet/minecraft/server/MinecraftServer;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nServerDataTicker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerDataTicker.kt\nnet/thebrokenscript/handlers/ServerDataTicker\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,180:1\n51#2:181\n29#2:182\n24#2:183\n*S KotlinDebug\n*F\n+ 1 ServerDataTicker.kt\nnet/thebrokenscript/handlers/ServerDataTicker\n*L\n44#1:181\n44#1:182\n44#1:183\n*E\n"})
public final class ServerDataTicker {
    @NotNull
    public static final ServerDataTicker INSTANCE = new ServerDataTicker();

    private ServerDataTicker() {
    }

    /*
     * WARNING - void declaration
     */
    private final void onServerTick(MinecraftServer server) {
        int phase;
        boolean hasPlayers;
        boolean bl = hasPlayers = server.getPlayerCount() > 0;
        if (!hasPlayers) {
            return;
        }
        ServerLevel level = server.overworld();
        Intrinsics.checkNotNull((Object)level);
        MapVariables vars = LevelExt.INSTANCE.getVars((LevelAccessor)level);
        if (vars.getFirstJoinTimer() > 0L) {
            long l = vars.getFirstJoinTimer();
            vars.setFirstJoinTimer(l + -1L);
            if (vars.getFirstJoinTimer() <= 0L && !vars.getScheduled()) {
                void $this$with$iv$iv;
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$0));
                LevelAccessor levelAccessor = (LevelAccessor)level;
                Object[] objectArray = new Object[]{TBSLang.INSTANCE.getUSER_NULL()};
                MutableComponent mutableComponent = Component.translatable((String)"multiplayer.player.joined", (Object[])objectArray);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
                Component $this$yellow$iv = (Component)mutableComponent;
                boolean $i$f$getYellow = false;
                Component component = $this$yellow$iv;
                ChatFormatting other$iv$iv = ChatFormatting.YELLOW;
                boolean $i$f$with = false;
                void $this$mut$iv$iv$iv = $this$with$iv$iv;
                boolean $i$f$mut = false;
                MutableComponent mutableComponent2 = (MutableComponent)$this$mut$iv$iv$iv;
                if (mutableComponent2 == null) {
                    MutableComponent mutableComponent3 = $this$mut$iv$iv$iv.copy();
                    mutableComponent2 = mutableComponent3;
                    Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"copy(...)");
                }
                MutableComponent mutableComponent4 = mutableComponent2.withStyle(other$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent4, (String)"withStyle(...)");
                ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent4), (boolean)false, (int)2, null);
                PacketUtil.tryBroadcastPacket((LevelAccessor)((LevelAccessor)level), (Packet)((Packet)new ClientboundStopSoundPacket(null, null)));
                LevelAccessor levelAccessor2 = (LevelAccessor)level;
                Holder.Reference reference = SoundEvents.AMBIENT_CAVE;
                Intrinsics.checkNotNullExpressionValue((Object)reference, (String)"AMBIENT_CAVE");
                SoundUtil.tryBroadcastSound$default((LevelAccessor)levelAccessor2, (Holder)((Holder)reference), (float)10.0f, (float)0.0f, null, (int)8, null);
                CustomPlayerManager.add((ServerLevel)level, (GameProfile)GameProfiles.NULL_GAME_PROFILE);
            }
        }
        if (vars.getCircuitInhabitedDelay() > 0) {
            int $this$yellow$iv = vars.getCircuitInhabitedDelay();
            vars.setCircuitInhabitedDelay($this$yellow$iv + -1);
            if ((long)vars.getCircuitInhabitedDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$1));
            }
        }
        if (vars.getEntitySpawnDelay() > 0) {
            int $this$yellow$iv = vars.getEntitySpawnDelay();
            vars.setEntitySpawnDelay($this$yellow$iv + -1);
            if ((long)vars.getEntitySpawnDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$2));
            }
        }
        if (vars.getRareSpawnDelay() > 0) {
            int $this$yellow$iv = vars.getRareSpawnDelay();
            vars.setRareSpawnDelay($this$yellow$iv + -1);
            if ((long)vars.getRareSpawnDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$3));
            }
        }
        if (vars.getNullSpawnDelay() > 0) {
            int $this$yellow$iv = vars.getNullSpawnDelay();
            vars.setNullSpawnDelay($this$yellow$iv + -1);
            if ((long)vars.getNullSpawnDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$4));
            }
        }
        if (vars.getCurvedSpawnDelay() > 0) {
            int $this$yellow$iv = vars.getCurvedSpawnDelay();
            vars.setCurvedSpawnDelay($this$yellow$iv + -1);
            if ((long)vars.getCurvedSpawnDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$5));
            }
        }
        if (vars.getEerieNoiseDelay() > 0) {
            int $this$yellow$iv = vars.getEerieNoiseDelay();
            vars.setEerieNoiseDelay($this$yellow$iv + -1);
            if ((long)vars.getEerieNoiseDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$6));
            }
        }
        if (vars.getHerobrineDelay() > 0) {
            int $this$yellow$iv = vars.getHerobrineDelay();
            vars.setHerobrineDelay($this$yellow$iv + -1);
            if ((long)vars.getHerobrineDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$7));
            }
        }
        if (vars.getOblitSpawnDelay() > 0) {
            int $this$yellow$iv = vars.getOblitSpawnDelay();
            vars.setOblitSpawnDelay($this$yellow$iv + -1);
            if ((long)vars.getOblitSpawnDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$8));
            }
        }
        if (vars.getTbeSpawnDelay() > 0) {
            int $this$yellow$iv = vars.getTbeSpawnDelay();
            vars.setTbeSpawnDelay($this$yellow$iv + -1);
            if ((long)vars.getTbeSpawnDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$9));
            }
        }
        if (vars.getCircuitSpawnDelay() > 0) {
            int $this$yellow$iv = vars.getCircuitSpawnDelay();
            vars.setCircuitSpawnDelay($this$yellow$iv + -1);
            if ((long)vars.getCircuitSpawnDelay() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$10));
            }
        }
        if (vars.getDaylightCycleEventTimer() > 0L) {
            long $this$yellow$iv = vars.getDaylightCycleEventTimer();
            vars.setDaylightCycleEventTimer($this$yellow$iv + -1L);
            if (vars.getDaylightCycleEventTimer() <= 0L) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$11));
                GameRules.BooleanValue rule = (GameRules.BooleanValue)level.getLevelData().getGameRules().getRule(GameRules.RULE_DAYLIGHT);
                rule.set(true, level.getServer());
            }
        }
        if (vars.getMoonStage() != 0 && !vars.getHasMoonCorrupted()) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$12));
        }
        if (level.getGameTime() % (long)420 == 0L && (phase = level.getMoonPhase() + 1) == 8 && !LevelExt.INSTANCE.getVars((LevelAccessor)level).getMoonShouldChange() && level.isNight()) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)ServerDataTicker::onServerTick$lambda$13));
        }
    }

    private static final Unit onServerTick$lambda$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setFirstJoinTimer(0L);
        $this$updateVars.setFirstJoin(false);
        $this$updateVars.setNullHere(true);
        $this$updateVars.setScheduled(true);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$1(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCircuitInhabitedDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$2(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setEntitySpawnDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$3(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setRareSpawnDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$4(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setNullSpawnDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$5(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCurvedSpawnDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$6(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setEerieNoiseDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$7(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHerobrineDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$8(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setOblitSpawnDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$9(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setTbeSpawnDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$10(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCircuitSpawnDelay(0);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$11(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setDaylightCycle(true);
        $this$updateVars.setDaylightCycleEventTimer(0L);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$12(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasMoonCorrupted(true);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$13(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setMoonShouldChange(true);
        return Unit.INSTANCE;
    }

    static {
        ServerTickSubscriber.INSTANCE.add((Function1<? super MinecraftServer, Unit>)((Function1)new Function1<MinecraftServer, Unit>((Object)INSTANCE){

            public final void invoke(MinecraftServer p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((ServerDataTicker)this.receiver).onServerTick(p0);
            }
        }));
    }
}

