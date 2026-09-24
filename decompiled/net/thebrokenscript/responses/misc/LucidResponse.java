/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.responses.ChatResponse
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.responses.misc;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/responses/misc/LucidResponse;", "Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "<init>", "()V", "delay", "", "getDelay", "()J", "isFullMessage", "", "()Z", "triggers", "", "", "getTriggers", "()Ljava/util/List;", "caseSensitive", "getCaseSensitive", "respond", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "thebrokenscript-common"})
public final class LucidResponse
extends ChatResponse {
    private final long delay;
    private final boolean isFullMessage;
    @NotNull
    private final List<String> triggers = CollectionsKt.listOf((Object)"Lucy B. Locks");
    private final boolean caseSensitive;

    public LucidResponse() {
        this.delay = 100L;
        this.isFullMessage = true;
        this.caseSensitive = true;
    }

    public long getDelay() {
        return this.delay;
    }

    public boolean isFullMessage() {
        return this.isFullMessage;
    }

    @NotNull
    public List<String> getTriggers() {
        return this.triggers;
    }

    public boolean getCaseSensitive() {
        return this.caseSensitive;
    }

    protected void respond(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        if (!sender.level().dimension().equals(TBSDimensions.LUCID)) {
            PlayerExt.INSTANCE.updateVars((Player)sender, (Function1<? super PlayerVariables, Unit>)((Function1)LucidResponse::respond$lambda$0));
            PlayerUtil.sendTo((Player)((Player)sender), TBSDimensions.LUCID);
        }
    }

    private static final Unit respond$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setTicksUntilExit(4200L);
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }
}

