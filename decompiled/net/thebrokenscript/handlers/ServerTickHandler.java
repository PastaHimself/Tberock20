/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import java.lang.invoke.LambdaMetafactory;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.handlers.subs.ServerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.util.FindNearbyNullStructureKt;
import net.thebrokenscript.util.NecrosisDeconstructTask;
import net.thebrokenscript.util.SeedSwapper;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/handlers/ServerTickHandler;", "", "<init>", "()V", "changed", "", "getChanged", "()Z", "setChanged", "(Z)V", "musicEnabledByStructure", "getMusicEnabledByStructure", "setMusicEnabledByStructure", "onServerTick", "", "server", "Lnet/minecraft/server/MinecraftServer;", "EXEC_TIME", "", "thebrokenscript-common"})
public final class ServerTickHandler {
    @NotNull
    public static final ServerTickHandler INSTANCE = new ServerTickHandler();
    private static boolean changed;
    private static boolean musicEnabledByStructure;
    private static final int EXEC_TIME = 72000;

    private ServerTickHandler() {
    }

    public final boolean getChanged() {
        return changed;
    }

    public final void setChanged(boolean bl) {
        changed = bl;
    }

    public final boolean getMusicEnabledByStructure() {
        return musicEnabledByStructure;
    }

    public final void setMusicEnabledByStructure(boolean bl) {
        musicEnabledByStructure = bl;
    }

    /*
     * Unable to fully structure code
     */
    private final void onServerTick(MinecraftServer server) {
        v0 = server.getPlayerList().getPlayers();
        Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"getPlayers(...)");
        v1 = (ServerPlayer)CollectionsKt.randomOrNull((Collection)v0, (Random)((Random)Random.Default));
        if (v1 == null) {
            return;
        }
        player = v1;
        level = player.serverLevel();
        NecrosisDeconstructTask.INSTANCE.tick();
        if (!level.isFlat()) ** GOTO lbl-1000
        Intrinsics.checkNotNull((Object)level);
        if (!LevelExt.INSTANCE.getVars((LevelAccessor)level).isFlat()) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, onServerTick$lambda$0(net.thebrokenscript.data.MapVariables ), (Lnet/thebrokenscript/data/MapVariables;)Lkotlin/Unit;)());
        } else if (!level.isFlat()) {
            Intrinsics.checkNotNull((Object)level);
            if (LevelExt.INSTANCE.getVars((LevelAccessor)level).isFlat()) {
                LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, onServerTick$lambda$1(net.thebrokenscript.data.MapVariables ), (Lnet/thebrokenscript/data/MapVariables;)Lkotlin/Unit;)());
            }
        }
        if (!TBSConfigs.INSTANCE.getServer().getWorld().getDisableSeedChanger()) {
            if (server.overworld().getDayTime() % (long)72000 == 0L && server.overworld().getDayTime() > 0L && !ServerTickHandler.changed) {
                v2 = server.overworld();
                Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"overworld(...)");
                SeedSwapper.swapSeed(v2, server.overworld().random.nextLong());
                ServerTickHandler.changed = true;
            }
            if (server.overworld().getDayTime() % (long)72000 != 0L && ServerTickHandler.changed) {
                ServerTickHandler.changed = false;
            }
        } else if (ServerTickHandler.changed) {
            ServerTickHandler.changed = false;
        }
        if (level.getGameTime() % 20L == 0L) {
            Intrinsics.checkNotNull((Object)level);
            if (FindNearbyNullStructureKt.findNearbyNullStructure$default(level, player, 10, "wrong_tree", false, false, 48, null)) {
                ServerTickHandler.musicEnabledByStructure = true;
                PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, onServerTick$lambda$2(net.thebrokenscript.data.PlayerVariables ), (Lnet/thebrokenscript/data/PlayerVariables;)Lkotlin/Unit;)());
            } else if (!FindNearbyNullStructureKt.findNearbyNullStructure$default(level, player, 10, "wrong_tree", false, false, 48, null) && ServerTickHandler.musicEnabledByStructure) {
                ServerTickHandler.musicEnabledByStructure = false;
                PlayerUtil.stopAllSounds((Player)((Player)player));
                PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, onServerTick$lambda$3(net.thebrokenscript.data.PlayerVariables ), (Lnet/thebrokenscript/data/PlayerVariables;)Lkotlin/Unit;)());
            }
        }
    }

    private static final Unit onServerTick$lambda$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setFlat(true);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$1(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setFlat(false);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$2(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setMusicCausedByTBS(true);
        return Unit.INSTANCE;
    }

    private static final Unit onServerTick$lambda$3(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setMusicCausedByTBS(false);
        return Unit.INSTANCE;
    }

    static {
        ServerTickSubscriber.INSTANCE.add((Function1<? super MinecraftServer, Unit>)((Function1)new Function1<MinecraftServer, Unit>((Object)INSTANCE){

            public final void invoke(MinecraftServer p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((ServerTickHandler)this.receiver).onServerTick(p0);
            }
        }));
    }
}

