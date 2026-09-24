/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.blocks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000eJ&\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\u000f2\u0006\u0010\r\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0007R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/client/blocks/BlockRenderTypes;", "", "<init>", "()V", "map", "", "Lnet/minecraft/resources/ResourceLocation;", "Lnet/minecraft/client/renderer/RenderType;", "register", "", "B", "Lnet/minecraft/world/level/block/Block;", "block", "rt", "(Lnet/minecraft/world/level/block/Block;Lnet/minecraft/client/renderer/RenderType;)V", "Lnet/minecraft/core/Holder;", "brokencore-common"})
public final class BlockRenderTypes {
    @NotNull
    public static final BlockRenderTypes INSTANCE = new BlockRenderTypes();
    @JvmField
    @NotNull
    public static final Map<ResourceLocation, RenderType> map = new LinkedHashMap();

    private BlockRenderTypes() {
    }

    public final <B extends Block> void register(@NotNull B block2, @NotNull RenderType rt) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)rt, (String)"rt");
        map.put(block2.builtInRegistryHolder().key().location(), rt);
    }

    public final <B extends Block> void register(@NotNull Holder<B> block2, @NotNull RenderType rt) {
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)rt, (String)"rt");
        Map<ResourceLocation, RenderType> map = BlockRenderTypes.map;
        Optional optional = block2.unwrapKey();
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"unwrapKey(...)");
        Object object = OptionalsKt.getOrNull((Optional)optional);
        Intrinsics.checkNotNull((Object)object);
        map.put(((ResourceKey)object).location(), rt);
    }

    public final void register(@NotNull ResourceLocation block2, @NotNull RenderType rt) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)rt, (String)"rt");
        map.put(block2, rt);
    }
}

