/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.fake.CustomPlayerManager
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.impl.registry.BCPackets
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.api.ext.StringExt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.fake.CustomPlayerManager;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import net.thebrokenscript.client.overlay.IntegBossBarUpdate;
import net.thebrokenscript.client.overlay.JimmyBossBarUpdate;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.PlayerLoggedInSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.misc.GameProfiles;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/player/PlayerJoinHandler;", "", "<init>", "()V", "onPlayerLoggedIn", "", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class PlayerJoinHandler {
    @NotNull
    public static final PlayerJoinHandler INSTANCE = new PlayerJoinHandler();

    private PlayerJoinHandler() {
    }

    public final void onPlayerLoggedIn(@NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        PlayerUtil.trySendCustomPacket((Player)player, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.UPDATE_INTEG_BOSS_BAR.of(new IntegBossBarUpdate(0.0f, false))));
        PlayerUtil.trySendCustomPacket((Player)player, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.UPDATE_JIMMY_BOSS_BAR.of(new JimmyBossBarUpdate(0.0f, false))));
        PlayerUtil.stopAllSounds((Player)player);
        Level level = player.level();
        if (PlayerExt.INSTANCE.getVars(player).getShowCoords()) {
            PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)((Function1)PlayerJoinHandler::onPlayerLoggedIn$lambda$0));
        }
        if (PlayerExt.INSTANCE.getVars(player).getMusicCausedByTBS()) {
            PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)((Function1)PlayerJoinHandler::onPlayerLoggedIn$lambda$1));
        }
        if (PlayerExt.INSTANCE.getVars(player).getGlitchesEnabled()) {
            PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)((Function1)PlayerJoinHandler::onPlayerLoggedIn$lambda$2));
        }
        Intrinsics.checkNotNull((Object)level);
        if (LevelExt.INSTANCE.getVars((LevelAccessor)level).isNullHere()) {
            CustomPlayerManager.add((ServerLevel)((ServerLevel)level), (GameProfile)GameProfiles.NULL_GAME_PROFILE);
            return;
        }
        LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> PlayerJoinHandler.onPlayerLoggedIn$lambda$3(level, arg_0)));
        if (LevelExt.INSTANCE.getVars((LevelAccessor)level).isFirstJoin()) {
            if (LevelExt.INSTANCE.getVars((LevelAccessor)level).getFirstJoinTimer() == 0L && !LevelExt.INSTANCE.getVars((LevelAccessor)level).getJoinTimerTicking()) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> PlayerJoinHandler.onPlayerLoggedIn$lambda$4(player, arg_0)));
                PacketSender.INSTANCE.sendToAllPlayers((CustomPacketPayload)BCPackets.FAKE_TIME_OF_DAY.of((Number)0, false), new CustomPacketPayload[0]);
            }
            PlayerVariables playerVars = PlayerExt.INSTANCE.getVars(player);
            playerVars.setDesync(false);
            playerVars.syncTo(player);
        }
    }

    private static final Unit onPlayerLoggedIn$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setShowCoords(false);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerLoggedIn$lambda$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setMusicCausedByTBS(false);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerLoggedIn$lambda$2(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setGlitchesEnabled(false);
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerLoggedIn$lambda$3(Level $level, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasCircuitSpawned(false);
        $this$updateVars.setHasSiluetSpawned(false);
        $this$updateVars.setHasNullSpawned(false);
        $this$updateVars.setHasVoidSpawned(false);
        if ($level instanceof ServerLevel) {
            UUID uUID = GameProfiles.NULL_GAME_PROFILE.getId();
            Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"getId(...)");
            CustomPlayerManager.remove((UUID)uUID);
        }
        return Unit.INSTANCE;
    }

    private static final Unit onPlayerLoggedIn$lambda$4(Player $player, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setFirstJoinTimer(18000L);
        $this$updateVars.setJoinTimerTicking(true);
        $this$updateVars.setClanVoidX($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setClanVoidZ($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setMazeFloorX($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setMazeFloorZ($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setWoodenFloorX($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setWoodenFloorZ($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setStoneFloorX($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setStoneFloorZ($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setDayAX($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setDayAZ($player.getRandom().nextInt(0, 26) * 16 * ($player.getRandom().nextBoolean() ? -1 : 1));
        $this$updateVars.setCode(StringExt.nextString$default(StringExt.INSTANCE, (Random)Random.Default, Random.Default.nextInt(6, 13), null, 2, null));
        return Unit.INSTANCE;
    }

    static {
        PlayerLoggedInSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((PlayerJoinHandler)this.receiver).onPlayerLoggedIn(p0);
            }
        }));
    }
}

