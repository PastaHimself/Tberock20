/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.platform;

import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformTags;", "", "ores", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "getOres", "()Lnet/minecraft/tags/TagKey;", "glassBlocks", "getGlassBlocks", "glassPanes", "getGlassPanes", "fences", "getFences", "fenceGates", "getFenceGates", "Companion", "brokencore-common"})
public interface PlatformTags {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.platform.PlatformTags$Companion.$$INSTANCE;

    @NotNull
    public TagKey<Block> getOres();

    @NotNull
    public TagKey<Block> getGlassBlocks();

    @NotNull
    public TagKey<Block> getGlassPanes();

    @NotNull
    public TagKey<Block> getFences();

    @NotNull
    public TagKey<Block> getFenceGates();

    @ForceRuntimeInit
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformTags$Companion;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformTags;", "<init>", "()V", "fenceGates", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "getFenceGates", "()Lnet/minecraft/tags/TagKey;", "fences", "getFences", "glassBlocks", "getGlassBlocks", "glassPanes", "getGlassPanes", "ores", "getOres", "brokencore-common"})
    public static final class Companion
    implements PlatformTags {
        static final /* synthetic */ Companion $$INSTANCE;
        private final /* synthetic */ PlatformTags $$delegate_0;

        private Companion() {
            ServiceLoader<PlatformTags> serviceLoader = ServiceLoader.load(PlatformTags.class);
            Intrinsics.checkNotNullExpressionValue(serviceLoader, (String)"load(...)");
            this.$$delegate_0 = (PlatformTags)CollectionsKt.first((Iterable)serviceLoader);
        }

        @Override
        @NotNull
        public TagKey<Block> getOres() {
            return this.$$delegate_0.getOres();
        }

        @Override
        @NotNull
        public TagKey<Block> getGlassBlocks() {
            return this.$$delegate_0.getGlassBlocks();
        }

        @Override
        @NotNull
        public TagKey<Block> getGlassPanes() {
            return this.$$delegate_0.getGlassPanes();
        }

        @Override
        @NotNull
        public TagKey<Block> getFences() {
            return this.$$delegate_0.getFences();
        }

        @Override
        @NotNull
        public TagKey<Block> getFenceGates() {
            return this.$$delegate_0.getFenceGates();
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

