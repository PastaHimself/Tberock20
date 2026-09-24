/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.responses.ChatResponse
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.responses.nullent;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.util.FindNearbyNullStructureKt;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/responses/nullent/NullStructurePositiveResponse;", "Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "<init>", "()V", "triggers", "", "", "getTriggers", "()Ljava/util/List;", "ignorePunctuation", "", "getIgnorePunctuation", "()Z", "respond", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "thebrokenscript-common"})
public final class NullStructurePositiveResponse
extends ChatResponse {
    @NotNull
    private final List<String> triggers;

    public NullStructurePositiveResponse() {
        Object[] objectArray = new String[]{"Oo", "Ooo", "Oooo", "Cool", "Sick", "Nice"};
        this.triggers = CollectionsKt.listOf((Object[])objectArray);
    }

    @NotNull
    public List<String> getTriggers() {
        return this.triggers;
    }

    public boolean getIgnorePunctuation() {
        return true;
    }

    protected void respond(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        if (FindNearbyNullStructureKt.findNearbyNullStructure$default(level, sender, 15, null, true, false, 40, null)) {
            RepUtilKt.applyRep((Player)sender, RepTier.GAIN_MINOR);
        }
    }
}

