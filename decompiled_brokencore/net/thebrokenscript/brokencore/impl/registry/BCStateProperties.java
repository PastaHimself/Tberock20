/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.registry;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.thebrokenscript.brokencore.impl.block.VerticalSlabType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/impl/registry/BCStateProperties;", "", "<init>", "()V", "VERTICAL_SLAB_TYPE", "Lnet/minecraft/world/level/block/state/properties/EnumProperty;", "Lnet/thebrokenscript/brokencore/impl/block/VerticalSlabType;", "getVERTICAL_SLAB_TYPE", "()Lnet/minecraft/world/level/block/state/properties/EnumProperty;", "brokencore-common"})
public final class BCStateProperties {
    @NotNull
    public static final BCStateProperties INSTANCE = new BCStateProperties();
    @NotNull
    private static final EnumProperty<VerticalSlabType> VERTICAL_SLAB_TYPE;

    private BCStateProperties() {
    }

    @NotNull
    public final EnumProperty<VerticalSlabType> getVERTICAL_SLAB_TYPE() {
        return VERTICAL_SLAB_TYPE;
    }

    static {
        EnumProperty enumProperty = EnumProperty.create((String)"type", VerticalSlabType.class);
        Intrinsics.checkNotNullExpressionValue((Object)enumProperty, (String)"create(...)");
        VERTICAL_SLAB_TYPE = enumProperty;
    }
}

