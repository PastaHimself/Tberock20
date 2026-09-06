/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.world.gen.features;

import com.mojang.serialization.Codec;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/world/gen/features/MoonChunkFeature;", "Lnet/minecraft/world/level/levelgen/feature/Feature;", "Lnet/minecraft/world/level/levelgen/feature/configurations/NoneFeatureConfiguration;", "<init>", "()V", "template", "Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureTemplate;", "structureList", "", "Lnet/minecraft/resources/ResourceLocation;", "place", "", "cx", "Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;", "Companion", "thebrokenscript-common"})
public final class MoonChunkFeature
extends Feature<NoneFeatureConfiguration> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private StructureTemplate template;
    @NotNull
    private final List<ResourceLocation> structureList;
    @NotNull
    private static final Codec<NoneFeatureConfiguration> CODEC;

    public MoonChunkFeature() {
        super(CODEC);
        Object[] objectArray = new ResourceLocation[]{TBSConstants.id("moon_chunk"), TBSConstants.id("moon_sphere2"), TBSConstants.id("moon_void1"), TBSConstants.id("moon_void2"), TBSConstants.id("moon_void3"), TBSConstants.id("moon_crown"), TBSConstants.id("moon_corrupt_crown"), TBSConstants.id("moon_corrupt_overhang"), TBSConstants.id("moon_strangle"), TBSConstants.id("moon_spire"), TBSConstants.id("moon_pyramid"), TBSConstants.id("moonfloatyrock1"), TBSConstants.id("moonfloatyrock2"), TBSConstants.id("moon_cliff"), TBSConstants.id("moon_introck"), TBSConstants.id("moon_spike"), TBSConstants.id("moon_spikeball"), TBSConstants.id("moon_tendrilstrangle1"), TBSConstants.id("moon_helix"), TBSConstants.id("moon_tree_of_life"), TBSConstants.id("moon_void_tree_one"), TBSConstants.id("moon_void_tree_two"), TBSConstants.id("moon_mushroomrock3"), TBSConstants.id("the_tower")};
        this.structureList = CollectionsKt.listOf((Object[])objectArray);
    }

    public boolean place(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> cx) {
        int burialDepth;
        int lowestStructureY;
        int cornerSurfaceY;
        StructurePlaceSettings settings;
        BlockPos adjustedOrigin;
        ResourceLocation structure;
        RandomSource random;
        block14: {
            block13: {
                block12: {
                    block11: {
                        Intrinsics.checkNotNullParameter(cx, (String)"cx");
                        if (!Intrinsics.areEqual((Object)cx.level().getLevel().dimension(), TBSDimensions.CORRUPTED_MOON)) {
                            return false;
                        }
                        random = cx.random();
                        structure = this.structureList.get(random.nextInt(this.structureList.size()));
                        if (Intrinsics.areEqual((Object)structure, (Object)TBSConstants.id("the_tower")) && !random.nextBoolean()) {
                            structure = this.structureList.get(random.nextInt(this.structureList.size()));
                        }
                        this.template = cx.level().getLevel().getStructureManager().getOrCreate(structure);
                        Mirror mirror = random.nextBoolean() ? Mirror.FRONT_BACK : Mirror.NONE;
                        Rotation rotation = (Rotation)EntriesMappings.entries$0.get(random.nextInt(4));
                        ChunkPos chunkPos = new ChunkPos(cx.origin());
                        BoundingBox regionBox = new BoundingBox(chunkPos.getMinBlockX() - 16, cx.level().getMinBuildHeight(), chunkPos.getMinBlockZ() - 16, chunkPos.getMaxBlockX() + 16, cx.level().getMaxBuildHeight(), chunkPos.getMaxBlockZ() + 16);
                        StructureTemplate structureTemplate = this.template;
                        if (structureTemplate == null || (structureTemplate = structureTemplate.getZeroPositionWithTransform(cx.origin(), mirror, rotation)) == null) {
                            return false;
                        }
                        StructureTemplate transformedOrigin = structureTemplate;
                        StructureTemplate structureTemplate2 = this.template;
                        Intrinsics.checkNotNull((Object)structureTemplate2);
                        BoundingBox structureBB = structureTemplate2.getBoundingBox((BlockPos)transformedOrigin, rotation, BlockPos.ZERO, mirror);
                        int overX = Math.max(0, structureBB.maxX() - regionBox.maxX());
                        int underX = Math.min(0, structureBB.minX() - regionBox.minX());
                        int overZ = Math.max(0, structureBB.maxZ() - regionBox.maxZ());
                        int underZ = Math.min(0, structureBB.minZ() - regionBox.minZ());
                        adjustedOrigin = transformedOrigin.offset(-overX - underX, 0, -overZ - underZ);
                        settings = new StructurePlaceSettings().addProcessor((StructureProcessor)new BlockIgnoreProcessor(CollectionsKt.listOf((Object)Blocks.STRUCTURE_BLOCK))).setIgnoreEntities(false).setRotation(rotation).setMirror(mirror).setBoundingBox(regionBox);
                        StructureTemplate structureTemplate3 = this.template;
                        Intrinsics.checkNotNull((Object)structureTemplate3);
                        BoundingBox adjustedBB = structureTemplate3.getBoundingBox(adjustedOrigin, rotation, BlockPos.ZERO, mirror);
                        Object[] objectArray = new Integer[]{cx.level().getHeight(Heightmap.Types.WORLD_SURFACE_WG, adjustedBB.minX(), adjustedBB.minZ()), cx.level().getHeight(Heightmap.Types.WORLD_SURFACE_WG, adjustedBB.minX(), adjustedBB.maxZ()), cx.level().getHeight(Heightmap.Types.WORLD_SURFACE_WG, adjustedBB.maxX(), adjustedBB.minZ()), cx.level().getHeight(Heightmap.Types.WORLD_SURFACE_WG, adjustedBB.maxX(), adjustedBB.maxZ())};
                        cornerSurfaceY = ((Number)((Object)CollectionsKt.minOrThrow((Iterable)CollectionsKt.listOf((Object[])objectArray)))).intValue();
                        lowestStructureY = adjustedBB.minY();
                        burialDepth = random.nextInt(3, 8);
                        String string = structure.getPath();
                        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
                        if (StringsKt.endsWith$default((String)string, (String)"moon_pyramid", (boolean)false, (int)2, null)) break block11;
                        String string2 = structure.getPath();
                        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
                        if (!StringsKt.endsWith$default((String)string2, (String)"moon_void3", (boolean)false, (int)2, null)) break block12;
                    }
                    burialDepth = 0;
                }
                String string = structure.getPath();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
                if (StringsKt.contains$default((CharSequence)string, (CharSequence)"moon_sphere", (boolean)false, (int)2, null)) break block13;
                String string3 = structure.getPath();
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getPath(...)");
                if (!StringsKt.contains$default((CharSequence)string3, (CharSequence)"moon_floaty", (boolean)false, (int)2, null)) break block14;
            }
            burialDepth = random.nextInt(20, 35) * -1;
        }
        String string = structure.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        if (StringsKt.contains$default((CharSequence)string, (CharSequence)"moon_spikeball", (boolean)false, (int)2, null)) {
            burialDepth = random.nextInt(55, 100) * -1;
        }
        int yShift = cornerSurfaceY - lowestStructureY - burialDepth;
        BlockPos finalOrigin = new BlockPos(adjustedOrigin.getX(), RangesKt.coerceIn((int)(adjustedOrigin.getY() + yShift), (int)cx.level().getMinBuildHeight(), (int)cx.level().getMaxBuildHeight()), adjustedOrigin.getZ());
        if (finalOrigin.getY() < 0) {
            return false;
        }
        StructureTemplate structureTemplate = this.template;
        Intrinsics.checkNotNull((Object)structureTemplate);
        structureTemplate.placeInWorld((ServerLevelAccessor)cx.level(), finalOrigin, finalOrigin, settings, cx.random(), 2);
        return true;
    }

    static {
        Codec codec2 = NoneFeatureConfiguration.CODEC;
        Intrinsics.checkNotNullExpressionValue((Object)codec2, (String)"CODEC");
        CODEC = codec2;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/gen/features/MoonChunkFeature$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/Codec;", "Lnet/minecraft/world/level/levelgen/feature/configurations/NoneFeatureConfiguration;", "getCODEC", "()Lcom/mojang/serialization/Codec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Codec<NoneFeatureConfiguration> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Rotation> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Rotation.values()));
        }
    }
}

