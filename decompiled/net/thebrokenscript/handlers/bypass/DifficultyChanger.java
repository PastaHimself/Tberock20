/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.world.Difficulty
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.bypass;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Difficulty;
import net.thebrokenscript.handlers.subs.ServerTickSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/bypass/DifficultyChanger;", "", "<init>", "()V", "onServerTick", "", "server", "Lnet/minecraft/server/MinecraftServer;", "thebrokenscript-common"})
public final class DifficultyChanger {
    @NotNull
    public static final DifficultyChanger INSTANCE = new DifficultyChanger();

    private DifficultyChanger() {
    }

    private final void onServerTick(MinecraftServer server) {
        if (server.getWorldData().getDifficulty() == Difficulty.PEACEFUL) {
            server.setDifficulty(Difficulty.EASY, true);
        }
    }

    static {
        ServerTickSubscriber.INSTANCE.add((Function1<? super MinecraftServer, Unit>)((Function1)new Function1<MinecraftServer, Unit>((Object)INSTANCE){

            public final void invoke(MinecraftServer p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((DifficultyChanger)this.receiver).onServerTick(p0);
            }
        }));
    }
}

