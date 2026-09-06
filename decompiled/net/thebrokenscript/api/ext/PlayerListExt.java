/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.ext;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/api/ext/PlayerListExt;", "", "<init>", "()V", "trySetWindowTitle", "", "T", "Lnet/minecraft/world/entity/player/Player;", "", "title", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlayerListExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerListExt.kt\nnet/thebrokenscript/api/ext/PlayerListExt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,8:1\n1869#2,2:9\n*S KotlinDebug\n*F\n+ 1 PlayerListExt.kt\nnet/thebrokenscript/api/ext/PlayerListExt\n*L\n7#1:9,2\n*E\n"})
public final class PlayerListExt {
    @NotNull
    public static final PlayerListExt INSTANCE = new PlayerListExt();

    private PlayerListExt() {
    }

    public final <T extends Player> void trySetWindowTitle(@NotNull List<? extends T> $this$trySetWindowTitle, @NotNull String title) {
        Intrinsics.checkNotNullParameter($this$trySetWindowTitle, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Iterable $this$forEach$iv = $this$trySetWindowTitle;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player it = (Player)element$iv;
            boolean bl = false;
            PlayerExt.INSTANCE.trySetWindowTitle(it, title);
        }
    }
}

