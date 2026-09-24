/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/util/KeepInventoryRules;", "", "<init>", "()V", "shouldKeepInventory", "", "player", "Lnet/minecraft/server/level/ServerPlayer;", "thebrokenscript-common"})
public final class KeepInventoryRules {
    @NotNull
    public static final KeepInventoryRules INSTANCE = new KeepInventoryRules();

    private KeepInventoryRules() {
    }

    @JvmStatic
    public static final boolean shouldKeepInventory(@NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        if (!TBSConfigs.INSTANCE.getServer().getEnableKeepInventory()) {
            return false;
        }
        return TBSDimensions.ALL.contains(player.level().dimension());
    }
}

