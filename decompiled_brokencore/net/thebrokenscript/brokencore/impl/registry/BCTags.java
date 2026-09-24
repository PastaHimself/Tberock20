/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.thebrokenscript.brokencore.api.BCApi;
import net.thebrokenscript.brokencore.api.platform.PlatformTags;
import net.thebrokenscript.brokencore.api.registry.util.TagBuilder;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import net.thebrokenscript.brokencore.impl.registry.BCReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/impl/registry/BCTags;", "", "<init>", "()V", "ANY_BIOME", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/biome/Biome;", "ICE", "Lnet/minecraft/world/level/block/Block;", "kotlin.jvm.PlatformType", "TRANSPARENT", "brokencore-common"})
public final class BCTags {
    @NotNull
    public static final BCTags INSTANCE = new BCTags();
    @JvmField
    @NotNull
    public static final TagKey<Biome> ANY_BIOME;
    @JvmField
    @NotNull
    public static final TagKey<Block> ICE;
    @JvmField
    @NotNull
    public static final TagKey<Block> TRANSPARENT;

    private BCTags() {
    }

    private static final void ICE$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Block[] blockArray = new Block[4];
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.ICE, (String)"ICE");
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.PACKED_ICE, (String)"PACKED_ICE");
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.FROSTED_ICE, (String)"FROSTED_ICE");
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.BLUE_ICE, (String)"BLUE_ICE");
        $this$tag.plusAssign((T[])blockArray);
    }

    private static final void TRANSPARENT$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        TagKey[] tagKeyArray = new TagKey[6];
        tagKeyArray[0] = PlatformTags.Companion.getGlassBlocks();
        tagKeyArray[1] = PlatformTags.Companion.getGlassPanes();
        tagKeyArray[2] = PlatformTags.Companion.getFences();
        tagKeyArray[3] = PlatformTags.Companion.getFenceGates();
        tagKeyArray[4] = ICE;
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.LEAVES, (String)"LEAVES");
        $this$tag.plusAssign(tagKeyArray);
    }

    static {
        TagKey tagKey = TagKey.create((ResourceKey)Registries.BIOME, (ResourceLocation)BCApi.id("any"));
        Intrinsics.checkNotNullExpressionValue((Object)tagKey, (String)"create(...)");
        ANY_BIOME = tagKey;
        ResourceKey resourceKey = Registries.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"BLOCK");
        ICE = BCReg.INSTANCE.tag(resourceKey, "ice", BCTags::ICE$lambda$0);
        ResourceKey resourceKey2 = Registries.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"BLOCK");
        TRANSPARENT = BCReg.INSTANCE.tag(resourceKey2, "transparent", BCTags::TRANSPARENT$lambda$0);
    }
}

