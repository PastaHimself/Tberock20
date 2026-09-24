/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.block.Block
 *  net.neoforged.neoforge.common.Tags$Blocks
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.thebrokenscript.brokencore.api.platform.PlatformTags;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformTagsImpl;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformTags;", "<init>", "()V", "ores", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "getOres", "()Lnet/minecraft/tags/TagKey;", "glassBlocks", "getGlassBlocks", "glassPanes", "getGlassPanes", "fences", "getFences", "fenceGates", "getFenceGates", "brokencore-neoforge"})
public final class PlatformTagsImpl
implements PlatformTags {
    @NotNull
    private final TagKey<Block> ores;
    @NotNull
    private final TagKey<Block> glassBlocks;
    @NotNull
    private final TagKey<Block> glassPanes;
    @NotNull
    private final TagKey<Block> fences;
    @NotNull
    private final TagKey<Block> fenceGates;

    public PlatformTagsImpl() {
        TagKey tagKey = Tags.Blocks.ORES;
        Intrinsics.checkNotNullExpressionValue((Object)tagKey, (String)"ORES");
        this.ores = tagKey;
        TagKey tagKey2 = Tags.Blocks.GLASS_BLOCKS;
        Intrinsics.checkNotNullExpressionValue((Object)tagKey2, (String)"GLASS_BLOCKS");
        this.glassBlocks = tagKey2;
        TagKey tagKey3 = Tags.Blocks.GLASS_PANES;
        Intrinsics.checkNotNullExpressionValue((Object)tagKey3, (String)"GLASS_PANES");
        this.glassPanes = tagKey3;
        TagKey tagKey4 = Tags.Blocks.FENCES;
        Intrinsics.checkNotNullExpressionValue((Object)tagKey4, (String)"FENCES");
        this.fences = tagKey4;
        TagKey tagKey5 = Tags.Blocks.FENCE_GATES;
        Intrinsics.checkNotNullExpressionValue((Object)tagKey5, (String)"FENCE_GATES");
        this.fenceGates = tagKey5;
    }

    @Override
    @NotNull
    public TagKey<Block> getOres() {
        return this.ores;
    }

    @Override
    @NotNull
    public TagKey<Block> getGlassBlocks() {
        return this.glassBlocks;
    }

    @Override
    @NotNull
    public TagKey<Block> getGlassPanes() {
        return this.glassPanes;
    }

    @Override
    @NotNull
    public TagKey<Block> getFences() {
        return this.fences;
    }

    @Override
    @NotNull
    public TagKey<Block> getFenceGates() {
        return this.fenceGates;
    }
}

