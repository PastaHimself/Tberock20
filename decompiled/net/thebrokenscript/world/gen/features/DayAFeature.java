/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.StringTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$StructureBlockInfo
 *  net.thebrokenscript.brokencore.api.dsl.ArrayUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.world.gen.features;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.ArrayUtil;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.world.dimension.boss.stage2.Stage2Generator;
import net.thebrokenscript.world.dimension.clan_void.ClanVoidGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/world/gen/features/DayAFeature;", "Lnet/minecraft/world/level/levelgen/feature/Feature;", "Lnet/minecraft/world/level/levelgen/feature/configurations/NoneFeatureConfiguration;", "<init>", "()V", "template", "Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureTemplate;", "structureList", "", "Lnet/minecraft/resources/ResourceLocation;", "place", "", "cx", "Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;", "ChestLootProcessor", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nDayAFeature.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DayAFeature.kt\nnet/thebrokenscript/world/gen/features/DayAFeature\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,235:1\n1761#2,3:236\n1563#2:239\n1634#2,3:240\n1761#2,3:243\n1563#2:246\n1634#2,3:247\n*S KotlinDebug\n*F\n+ 1 DayAFeature.kt\nnet/thebrokenscript/world/gen/features/DayAFeature\n*L\n154#1:236,3\n158#1:239\n158#1:240,3\n160#1:243,3\n164#1:246\n164#1:247,3\n*E\n"})
public final class DayAFeature
extends Feature<NoneFeatureConfiguration> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private StructureTemplate template;
    @NotNull
    private final List<ResourceLocation> structureList;
    @NotNull
    private static final Codec<NoneFeatureConfiguration> CODEC;

    public DayAFeature() {
        super(CODEC);
        Object[] objectArray = new ResourceLocation[]{TBSConstants.id("fieldbedrocktree"), TBSConstants.id("fieldhouse"), TBSConstants.id("fieldpillar"), TBSConstants.id("fieldtree"), TBSConstants.id("fieldtree2"), TBSConstants.id("fieldtree3"), TBSConstants.id("daya_360"), TBSConstants.id("daya_castle"), TBSConstants.id("daya_door"), TBSConstants.id("daya_house"), TBSConstants.id("daya_pillars"), TBSConstants.id("daya_watch"), TBSConstants.id("daya_starter"), TBSConstants.id("daya_observatory"), TBSConstants.id("daya_signs"), TBSConstants.id("daya_tower_redo"), TBSConstants.id("daya_blacksmith"), TBSConstants.id("daya_blacksmith2"), TBSConstants.id("daya_cobblestone_pyramid"), TBSConstants.id("daya_tree")};
        this.structureList = CollectionsKt.listOf((Object[])objectArray);
    }

    /*
     * WARNING - void declaration
     */
    public boolean place(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> cx) {
        Intrinsics.checkNotNullParameter(cx, (String)"cx");
        RandomSource random = cx.random();
        ChunkGenerator generator = cx.level().getLevel().getChunkSource().getGenerator();
        ServerLevel serverLevel = cx.level().getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        MapVariables vars = LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel);
        ResourceLocation structure = this.structureList.get(random.nextInt(3, 6));
        if ((double)random.nextFloat() < 0.02) {
            Collection collection = this.structureList;
            Intrinsics.checkNotNull((Object)random);
            structure = (ResourceLocation)ArrayUtil.random((Collection)collection, (RandomSource)random);
        }
        this.template = cx.level().getLevel().getStructureManager().getOrCreate(structure);
        Mirror mirror = random.nextBoolean() ? Mirror.FRONT_BACK : Mirror.NONE;
        Rotation rotation = (Rotation)EntriesMappings.entries$0.get(random.nextInt(0, 4));
        if (!Intrinsics.areEqual((Object)cx.level().getLevel().dimension(), TBSDimensions.CLAN_VOID) && !Intrinsics.areEqual((Object)cx.level().getLevel().dimension(), TBSDimensions.STAGE2)) {
            return false;
        }
        StructureTemplate structureTemplate = this.template;
        Intrinsics.checkNotNull((Object)structureTemplate);
        Vec3i size = structureTemplate.getSize();
        int centerX = cx.origin().getX() - size.getX() / 2;
        int centerZ = cx.origin().getZ() - size.getZ() / 2;
        Pair pair = switch (WhenMappings.$EnumSwitchMapping$0[rotation.ordinal()]) {
            case 1, 2 -> new Pair((Object)size.getZ(), (Object)size.getX());
            default -> new Pair((Object)size.getX(), (Object)size.getZ());
        };
        int effectiveSizeX = ((Number)pair.component1()).intValue();
        int effectiveSizeZ = ((Number)pair.component2()).intValue();
        BoundingBox boundingBox = new BoundingBox(centerX - 16, cx.level().getMinBuildHeight(), centerZ - 16, centerX + effectiveSizeX + 16, cx.level().getMaxBuildHeight(), centerZ + effectiveSizeZ + 16);
        StructurePlaceSettings settings = new StructurePlaceSettings().setIgnoreEntities(false).setRotation(rotation).setMirror(mirror).setBoundingBox(boundingBox);
        if (Intrinsics.areEqual((Object)structure.getPath(), (Object)"daya_starter") && !Intrinsics.areEqual((Object)cx.level().getLevel().dimension(), TBSDimensions.STAGE2)) {
            ServerLevel serverLevel2 = cx.level().getLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
            int n = LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel2).getDayAX();
            ServerLevel serverLevel3 = cx.level().getLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevel3, (String)"getLevel(...)");
            v7 = settings.addProcessor((StructureProcessor)new ChestLootProcessor(n, LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel3).getDayAZ(), random.nextInt(0, 2)));
        } else {
            v7 = settings.addProcessor((StructureProcessor)BlockIgnoreProcessor.STRUCTURE_AND_AIR);
        }
        BlockPos centeredOrigin = !Intrinsics.areEqual((Object)cx.level().getLevel().dimension(), TBSDimensions.STAGE2) ? new BlockPos(centerX, cx.origin().getY(), centerZ) : new BlockPos(centerX, 254, centerZ);
        StructureTemplate structureTemplate2 = this.template;
        BlockPos transformedOrigin = structureTemplate2 != null ? structureTemplate2.getZeroPositionWithTransform(centeredOrigin, mirror, rotation) : null;
        int regionMinX = new ChunkPos(centeredOrigin).getMinBlockX() - 16;
        int regionMaxX = new ChunkPos(centeredOrigin).getMaxBlockX() + 16;
        int regionMinZ = new ChunkPos(centeredOrigin).getMinBlockZ() - 16;
        int regionMaxZ = new ChunkPos(centeredOrigin).getMaxBlockZ() + 16;
        if (transformedOrigin != null) {
            if (transformedOrigin.getX() < regionMinX || transformedOrigin.getX() + effectiveSizeX > regionMaxX || transformedOrigin.getZ() < regionMinZ || transformedOrigin.getZ() + effectiveSizeZ > regionMaxZ) {
                return false;
            }
            Object[] objectArray = new ChunkPos[]{new ChunkPos(new BlockPos(transformedOrigin.getX(), 0, transformedOrigin.getZ())), new ChunkPos(new BlockPos(transformedOrigin.getX() + effectiveSizeX, 0, transformedOrigin.getZ())), new ChunkPos(new BlockPos(transformedOrigin.getX(), 0, transformedOrigin.getZ() + effectiveSizeZ)), new ChunkPos(new BlockPos(transformedOrigin.getX() + effectiveSizeX, 0, transformedOrigin.getZ() + effectiveSizeZ))};
            List corners = CollectionsKt.listOf((Object[])objectArray);
            if (!Intrinsics.areEqual((Object)cx.level().getLevel().dimension(), TBSDimensions.STAGE2)) {
                if (transformedOrigin.getX() < vars.getDayAX() + 16 && transformedOrigin.getX() + effectiveSizeX > vars.getDayAX() && transformedOrigin.getZ() < vars.getDayAZ() + 16 && transformedOrigin.getZ() + effectiveSizeZ > vars.getDayAZ()) {
                    return false;
                }
                if (transformedOrigin.getX() < 1008 && transformedOrigin.getX() + effectiveSizeX > 992 && transformedOrigin.getZ() < 1008 && transformedOrigin.getZ() + effectiveSizeZ > 992) {
                    return false;
                }
            }
            if (Intrinsics.areEqual((Object)cx.level().getLevel().dimension(), TBSDimensions.STAGE2)) {
                int minX = transformedOrigin.getX() - 16;
                int maxX = transformedOrigin.getX() + effectiveSizeX + 16;
                int minZ = transformedOrigin.getZ() - 16;
                int maxZ = transformedOrigin.getZ() + effectiveSizeZ + 16;
                if (minX < 16 || maxX > 160 || minZ < 16 || maxZ > 160) {
                    return false;
                }
            }
            if (generator instanceof ClanVoidGenerator) {
                void $this$mapTo$iv$iv;
                boolean bl;
                block27: {
                    $this$any$iv = corners;
                    $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl = false;
                    } else {
                        for (Object element$iv : $this$any$iv) {
                            ChunkPos it = (ChunkPos)element$iv;
                            boolean bl2 = false;
                            if (!((ClanVoidGenerator)generator).getOccupiedChunks().contains(it.toLong())) continue;
                            bl = true;
                            break block27;
                        }
                        bl = false;
                    }
                }
                if (bl) {
                    return false;
                }
                $this$any$iv = corners;
                Set<Long> set = ((ClanVoidGenerator)generator).getOccupiedChunks();
                $i$f$map = false;
                void minZ = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    void it;
                    ChunkPos chunkPos = (ChunkPos)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    boolean bl3 = false;
                    collection.add(it.toLong());
                }
                set.addAll((List)destination$iv$iv);
            } else if (generator instanceof Stage2Generator) {
                boolean bl;
                block28: {
                    $this$any$iv = corners;
                    $i$f$any = false;
                    if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                        bl = false;
                    } else {
                        for (Object element$iv : $this$any$iv) {
                            ChunkPos it = (ChunkPos)element$iv;
                            boolean bl4 = false;
                            if (!((Stage2Generator)generator).getOccupiedChunks().contains(it.toLong())) continue;
                            bl = true;
                            break block28;
                        }
                        bl = false;
                    }
                }
                if (bl) {
                    return false;
                }
                $this$any$iv = corners;
                Set<Long> set = ((Stage2Generator)generator).getOccupiedChunks();
                $i$f$map = false;
                void $this$mapTo$iv$iv = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    ChunkPos it = (ChunkPos)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    boolean bl5 = false;
                    collection.add(it.toLong());
                }
                set.addAll((List)destination$iv$iv);
            }
            StructureTemplate structureTemplate3 = this.template;
            Intrinsics.checkNotNull((Object)structureTemplate3);
            structureTemplate3.placeInWorld((ServerLevelAccessor)cx.level(), transformedOrigin, transformedOrigin, settings, cx.random(), 2);
            return true;
        }
        return false;
    }

    static {
        Codec codec2 = NoneFeatureConfiguration.CODEC;
        Intrinsics.checkNotNullExpressionValue((Object)codec2, (String)"CODEC");
        CODEC = codec2;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J8\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\f\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0014R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/world/gen/features/DayAFeature$ChestLootProcessor;", "Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureProcessor;", "dayaX", "", "dayaZ", "randomInt", "<init>", "(III)V", "getRandomInt", "()I", "text", "", "", "getText", "()Ljava/util/List;", "processBlock", "Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureTemplate$StructureBlockInfo;", "level", "Lnet/minecraft/world/level/LevelReader;", "offset", "Lnet/minecraft/core/BlockPos;", "pos", "blockInfo", "relativeBlockInfo", "settings", "Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructurePlaceSettings;", "getType", "Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureProcessorType;", "thebrokenscript-common"})
    public static final class ChestLootProcessor
    extends StructureProcessor {
        private final int randomInt;
        @NotNull
        private final List<String> text;

        public ChestLootProcessor(int dayaX, int dayaZ, int randomInt) {
            this.randomInt = randomInt;
            Object[] objectArray = new String[]{"X: " + dayaX + "\n\nY: 252\n\nZ: " + dayaZ, "\u00a7c* Invalid book tag *"};
            this.text = CollectionsKt.listOf((Object[])objectArray);
        }

        public final int getRandomInt() {
            return this.randomInt;
        }

        @NotNull
        public final List<String> getText() {
            return this.text;
        }

        @NotNull
        public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader level, @NotNull BlockPos offset, @NotNull BlockPos pos, @NotNull StructureTemplate.StructureBlockInfo blockInfo, @NotNull StructureTemplate.StructureBlockInfo relativeBlockInfo, @NotNull StructurePlaceSettings settings) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)offset, (String)"offset");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)blockInfo, (String)"blockInfo");
            Intrinsics.checkNotNullParameter((Object)relativeBlockInfo, (String)"relativeBlockInfo");
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            CompoundTag nbt = relativeBlockInfo.nbt();
            if (nbt != null && Intrinsics.areEqual((Object)nbt.getString("id"), (Object)"minecraft:chest")) {
                CompoundTag modifiedNbt = nbt.copy();
                CompoundTag bookNbt = new CompoundTag();
                bookNbt.putString("id", "minecraft:written_book");
                bookNbt.putByte("Count", (byte)1);
                CompoundTag components = new CompoundTag();
                CompoundTag content = new CompoundTag();
                content.putString("author", "Unknown Writer");
                content.putString("title", "Unknown");
                ListTag pages = new ListTag();
                JsonObject json = new JsonObject();
                json.addProperty("text", this.text.get(this.randomInt));
                pages.add((Object)StringTag.valueOf((String)json.toString()));
                content.put("pages", (Tag)pages);
                content.putBoolean("resolved", true);
                components.put("minecraft:written_book_content", (Tag)content);
                bookNbt.put("components", (Tag)components);
                bookNbt.putByte("Slot", (byte)5);
                ListTag listTag = modifiedNbt.getList("Items", 10).copy();
                Intrinsics.checkNotNull((Object)listTag, (String)"null cannot be cast to non-null type net.minecraft.nbt.ListTag");
                ListTag items = listTag;
                items.add((Object)bookNbt);
                modifiedNbt.put("Items", (Tag)items);
                return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos(), relativeBlockInfo.state(), modifiedNbt);
            }
            return relativeBlockInfo;
        }

        @NotNull
        protected StructureProcessorType<?> getType() {
            StructureProcessorType structureProcessorType = StructureProcessorType.BLOCK_IGNORE;
            Intrinsics.checkNotNullExpressionValue((Object)structureProcessorType, (String)"BLOCK_IGNORE");
            return structureProcessorType;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/gen/features/DayAFeature$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/Codec;", "Lnet/minecraft/world/level/levelgen/feature/configurations/NoneFeatureConfiguration;", "getCODEC", "()Lcom/mojang/serialization/Codec;", "thebrokenscript-common"})
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

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Rotation.values().length];
            try {
                nArray[Rotation.CLOCKWISE_90.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

