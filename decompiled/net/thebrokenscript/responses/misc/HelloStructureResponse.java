/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.chat.Style
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.responses.ChatResponse
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.responses.misc;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.util.FindNearbyNullStructureKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/responses/misc/HelloStructureResponse;", "Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "<init>", "()V", "triggers", "", "", "getTriggers", "()Ljava/util/List;", "caseSensitive", "", "getCaseSensitive", "()Z", "isFullMessage", "delay", "", "getDelay", "()J", "shouldExecute", "level", "Lnet/minecraft/server/level/ServerLevel;", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "respond", "", "thebrokenscript-common"})
public final class HelloStructureResponse
extends ChatResponse {
    @NotNull
    private final List<String> triggers;
    private final boolean caseSensitive;
    private final boolean isFullMessage;
    private final long delay;

    public HelloStructureResponse() {
        Object[] objectArray = new String[]{"Hello", "Hi?", "Hey", "Hallo", "Hullo", "Heya", "Heyo", "Welcome", "What's up", "How's it goin?", "How's it going?", "Wassup", "Yo", "Yo wassup", "Hey there", "Hiya", "Heyyo", "Sup", "Ello", "Yo waddup", "Hai", "Hewwo :3", "Hewwo", "Yello", "Morning", "Good morning", "Afternoon", "Good afternoon", "Evening", "Good evening", "wsg", "hihi", "Hey man", "Hey bro", "yo", "hilo", "greetings"};
        this.triggers = CollectionsKt.listOf((Object[])objectArray);
        this.isFullMessage = true;
        this.delay = 100L;
    }

    @NotNull
    public List<String> getTriggers() {
        return this.triggers;
    }

    public boolean getCaseSensitive() {
        return this.caseSensitive;
    }

    public boolean isFullMessage() {
        return this.isFullMessage;
    }

    public long getDelay() {
        return this.delay;
    }

    protected boolean shouldExecute(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        return super.shouldExecute(level, sender) && LevelExt.INSTANCE.getVars((LevelAccessor)level).isNullHere() && FindNearbyNullStructureKt.findNearbyNullStructure$default(level, sender, 0, "watching", false, true, 20, null);
    }

    protected void respond(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        int souls = 45;
        for (int loop1 = 0; loop1 < 5; ++loop1) {
            for (int loop2 = 0; loop2 < souls; ++loop2) {
                long tick = loop1 * souls + loop2;
                TheBrokenScript.serverWorkQueue.add(tick, () -> HelloStructureResponse.respond$lambda$0(level, loop2, sender));
            }
        }
        super.respond(level, sender);
    }

    private static final Unit respond$lambda$0(ServerLevel $level, int $loop2, ServerPlayer $sender) {
        LevelAccessor levelAccessor = (LevelAccessor)$level;
        MutableComponent mutableComponent = TBSLang.INSTANCE.getUNKNOWN_RESPONSE_MESSAGES().get($loop2).withStyle(Style.EMPTY.withFont(TBSConstants.id("shake")));
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"withStyle(...)");
        ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
        Player player = (Player)$sender;
        SoundEvent soundEvent = SoundEvents.GHAST_HURT;
        Intrinsics.checkNotNullExpressionValue((Object)soundEvent, (String)"GHAST_HURT");
        PlayerUtil.trySendSound$default((Player)player, (SoundEvent)soundEvent, (float)0.9f, (float)(1.0f + (float)Math.random() * 2.0f), (SoundSource)SoundSource.PLAYERS, null, (long)0L, (int)48, null);
        return Unit.INSTANCE;
    }
}

