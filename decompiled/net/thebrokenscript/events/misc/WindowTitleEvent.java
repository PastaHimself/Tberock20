/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.misc;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/misc/WindowTitleEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class WindowTitleEvent
extends TBSEvent {
    public WindowTitleEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if ((double)level.random.nextFloat() < 0.9) {
            if ((double)level.random.nextFloat() < 0.9) {
                Player player2 = (Player)player;
                String string = ComponentUtil.getTranslationKey((Component)((Component)CollectionsKt.random((Collection)TBSLang.INSTANCE.getNULL_TITLES(), (Random)((Random)Random.Default))));
                Intrinsics.checkNotNull((Object)string);
                PlayerExt.INSTANCE.trySetWindowTitle(player2, string);
            } else if (level.random.nextBoolean()) {
                Player player3 = (Player)player;
                String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getBECOME_VOID()));
                Intrinsics.checkNotNull((Object)string);
                PlayerExt.INSTANCE.trySetWindowTitle(player3, string);
            } else {
                Player player4 = (Player)player;
                String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getEYE()));
                Intrinsics.checkNotNull((Object)string);
                PlayerExt.INSTANCE.trySetWindowTitle(player4, string);
            }
        } else {
            PlayerExt.INSTANCE.trySetWindowTitle((Player)player, "");
        }
    }
}

