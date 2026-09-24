/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.mixins.features.sounds.BlockBehaviourAccessor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/api/ext/AccessorExt;", "", "<init>", "()V", "getSoundType", "Lnet/minecraft/world/level/block/SoundType;", "Lnet/minecraft/world/level/block/state/BlockBehaviour;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "thebrokenscript-common"})
public final class AccessorExt {
    @NotNull
    public static final AccessorExt INSTANCE = new AccessorExt();

    private AccessorExt() {
    }

    @NotNull
    public final SoundType getSoundType(@NotNull BlockBehaviour $this$getSoundType, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)$this$getSoundType, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        SoundType soundType = ((BlockBehaviourAccessor)$this$getSoundType).tbs$getSoundType(state);
        Intrinsics.checkNotNullExpressionValue((Object)soundType, (String)"tbs$getSoundType(...)");
        return soundType;
    }
}

