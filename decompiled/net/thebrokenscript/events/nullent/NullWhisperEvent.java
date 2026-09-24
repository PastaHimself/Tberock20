/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.nullent;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.NullEvent;
import net.thebrokenscript.misc.GameProfiles;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J \u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/events/nullent/NullWhisperEvent;", "Lnet/thebrokenscript/api/event/NullEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "sendSystemWhisper", "targetPlayer", "senderName", "Lnet/minecraft/network/chat/Component;", "message", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNullWhisperEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullWhisperEvent.kt\nnet/thebrokenscript/events/nullent/NullWhisperEvent\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,27:1\n15#2:28\n57#2:29\n29#2:30\n24#2:31\n*S KotlinDebug\n*F\n+ 1 NullWhisperEvent.kt\nnet/thebrokenscript/events/nullent/NullWhisperEvent\n*L\n17#1:28\n24#1:29\n24#1:30\n24#1:31\n*E\n"})
public final class NullWhisperEvent
extends NullEvent {
    public NullWhisperEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        String $this$c$iv = GameProfiles.NULL_GAME_PROFILE.getName();
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        this.sendSystemWhisper(player, component, (Component)CollectionsKt.random((Collection)TBSLang.INSTANCE.getNULL_MESSAGES(), (Random)((Random)Random.Default)));
    }

    /*
     * WARNING - void declaration
     */
    private final void sendSystemWhisper(ServerPlayer targetPlayer, Component senderName, Component message) {
        void $this$with$iv$iv;
        void $this$italic$iv;
        Object[] objectArray = new Object[]{senderName, message};
        MutableComponent mutableComponent = Component.translatable((String)"commands.message.display.incoming", (Object[])objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
        Component component = (Component)mutableComponent;
        boolean $i$f$getItalic = false;
        void var6_7 = $this$italic$iv;
        ChatFormatting other$iv$iv = ChatFormatting.ITALIC;
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
        targetPlayer.sendSystemMessage((Component)mutableComponent4.withColor(0xAAAAAA));
    }
}

