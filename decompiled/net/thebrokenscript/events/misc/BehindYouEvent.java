/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.overlay.OverlayQueue
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.misc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.brokencore.api.client.overlay.OverlayQueue;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/misc/BehindYouEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class BehindYouEvent
extends TBSEvent {
    public BehindYouEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        OverlayQueue queue = new OverlayQueue();
        queue.add(0L, TBSConstants.id("textures/screens/behindyou.png"), 3L);
        queue.add(7L, TBSConstants.id("textures/screens/behindyou.png"), 2L);
        queue.add(4L, TBSConstants.id("textures/screens/behindyou.png"), 2L);
        queue.add(8L, TBSConstants.id("textures/screens/behindyou.png"), 15L);
        ServerPlayer[] serverPlayerArray = new ServerPlayer[]{player};
        queue.send(serverPlayerArray);
        PlayerUtil.sendSound$default((ServerPlayer)player, (Holder)((Holder)TBSSounds.GLITCH_OVERLAY), (float)0.0f, (float)0.0f, null, null, (long)0L, (int)62, null);
    }
}

