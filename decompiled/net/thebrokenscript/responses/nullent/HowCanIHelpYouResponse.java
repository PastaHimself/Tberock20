/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.responses.ChatResponse
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.responses.nullent;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/responses/nullent/HowCanIHelpYouResponse;", "Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "<init>", "()V", "delay", "", "getDelay", "()J", "isFullMessage", "", "()Z", "triggers", "", "", "getTriggers", "()Ljava/util/List;", "caseSensitive", "getCaseSensitive", "shouldExecute", "level", "Lnet/minecraft/server/level/ServerLevel;", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "respond", "", "thebrokenscript-common"})
public final class HowCanIHelpYouResponse
extends ChatResponse {
    private final long delay;
    private final boolean isFullMessage;
    @NotNull
    private final List<String> triggers = CollectionsKt.listOf((Object)"How can I help you?");
    private final boolean caseSensitive;

    public HowCanIHelpYouResponse() {
        this.delay = 100L;
        this.isFullMessage = true;
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

    protected boolean shouldExecute(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        return super.shouldExecute(level, sender) && LevelExt.INSTANCE.getVars((LevelAccessor)level).isNullHere();
    }

    protected void respond(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        ChatUtil.chat$default((LevelAccessor)((LevelAccessor)level), (Component)((Component)TBSLang.INSTANCE.getMSG_HELP()), (boolean)false, (int)2, null);
    }
}

