/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntRange
 *  net.minecraft.core.Holder
 *  net.minecraft.world.entity.EntityType
 *  net.thebrokenscript.brokencore.api.registry.objects.EntityEntry
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.thebrokenscript.brokencore.api.registry.objects.EntityEntry;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001f B;\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001e\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/boss/integrity/Stage2Floor;", "", "yLevels", "Lkotlin/ranges/IntRange;", "spawnY", "", "spawns", "", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/entity/EntityType;", "bounds", "Lnet/thebrokenscript/boss/integrity/Stage2Floor$SpawnBounds;", "<init>", "(Ljava/lang/String;ILkotlin/ranges/IntRange;ILjava/util/List;Lnet/thebrokenscript/boss/integrity/Stage2Floor$SpawnBounds;)V", "getYLevels", "()Lkotlin/ranges/IntRange;", "getSpawnY", "()I", "getSpawns", "()Ljava/util/List;", "getBounds", "()Lnet/thebrokenscript/boss/integrity/Stage2Floor$SpawnBounds;", "FLOOR_1", "FLOOR_2", "FLOOR_3", "FLOOR_4", "FLOOR_5", "FLOOR_6", "FLOOR_6_INTEG", "FLOOR_7", "pickSpawnY", "Companion", "SpawnBounds", "thebrokenscript-common"})
public final class Stage2Floor
extends Enum<Stage2Floor> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final IntRange yLevels;
    private final int spawnY;
    @NotNull
    private final List<Holder<EntityType<?>>> spawns;
    @NotNull
    private final SpawnBounds bounds;
    public static final /* enum */ Stage2Floor FLOOR_1;
    public static final /* enum */ Stage2Floor FLOOR_2;
    public static final /* enum */ Stage2Floor FLOOR_3;
    public static final /* enum */ Stage2Floor FLOOR_4;
    public static final /* enum */ Stage2Floor FLOOR_5;
    public static final /* enum */ Stage2Floor FLOOR_6;
    public static final /* enum */ Stage2Floor FLOOR_6_INTEG;
    public static final /* enum */ Stage2Floor FLOOR_7;
    private static final /* synthetic */ Stage2Floor[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private Stage2Floor(IntRange yLevels, int spawnY, List<? extends Holder<EntityType<?>>> spawns, SpawnBounds bounds) {
        this.yLevels = yLevels;
        this.spawnY = spawnY;
        this.spawns = spawns;
        this.bounds = bounds;
    }

    /* synthetic */ Stage2Floor(String string, int n, IntRange intRange, int n2, List list, SpawnBounds spawnBounds, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 8) != 0) {
            spawnBounds = new SpawnBounds(32);
        }
        this(intRange, n2, list, spawnBounds);
    }

    @NotNull
    public final IntRange getYLevels() {
        return this.yLevels;
    }

    public final int getSpawnY() {
        return this.spawnY;
    }

    @NotNull
    public final List<Holder<EntityType<?>>> getSpawns() {
        return this.spawns;
    }

    @NotNull
    public final SpawnBounds getBounds() {
        return this.bounds;
    }

    public final int pickSpawnY() {
        return this.spawnY;
    }

    public static Stage2Floor[] values() {
        return (Stage2Floor[])$VALUES.clone();
    }

    public static Stage2Floor valueOf(String value) {
        return Enum.valueOf(Stage2Floor.class, value);
    }

    @NotNull
    public static EnumEntries<Stage2Floor> getEntries() {
        return $ENTRIES;
    }

    static {
        Object[] objectArray = new EntityEntry[]{TBSEntities.TETHER, TBSEntities.INTEGRITY_PHASE_2};
        FLOOR_1 = new Stage2Floor(new IntRange(249, 300), 254, CollectionsKt.listOf((Object[])objectArray), new SpawnBounds(48));
        FLOOR_2 = new Stage2Floor(new IntRange(230, 248), 235, CollectionsKt.listOf(TBSEntities.TETHER), new SpawnBounds(32));
        FLOOR_3 = new Stage2Floor(new IntRange(214, 229), 219, CollectionsKt.listOf(TBSEntities.TETHER), new SpawnBounds(16));
        FLOOR_4 = new Stage2Floor("FLOOR_4", 3, new IntRange(206, 213), 209, CollectionsKt.listOf(TBSEntities.TETHER), null, 8, null);
        FLOOR_5 = new Stage2Floor("FLOOR_5", 4, new IntRange(200, 205), 203, CollectionsKt.listOf(TBSEntities.TETHER), null, 8, null);
        FLOOR_6 = new Stage2Floor(new IntRange(160, 199), 163, CollectionsKt.listOf(TBSEntities.TETHER), new SpawnBounds(8));
        FLOOR_6_INTEG = new Stage2Floor("FLOOR_6_INTEG", 6, new IntRange(160, 180), 163, CollectionsKt.emptyList(), null, 8, null);
        FLOOR_7 = new Stage2Floor(new IntRange(Integer.MIN_VALUE, 159), 104, CollectionsKt.listOf(TBSEntities.TETHER), new SpawnBounds(28));
        $VALUES = stage2FloorArray = new Stage2Floor[]{Stage2Floor.FLOOR_1, Stage2Floor.FLOOR_2, Stage2Floor.FLOOR_3, Stage2Floor.FLOOR_4, Stage2Floor.FLOOR_5, Stage2Floor.FLOOR_6, Stage2Floor.FLOOR_6_INTEG, Stage2Floor.FLOOR_7};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/boss/integrity/Stage2Floor$Companion;", "", "<init>", "()V", "fromY", "Lnet/thebrokenscript/boss/integrity/Stage2Floor;", "y", "", "thebrokenscript-common"})
    @SourceDebugExtension(value={"SMAP\nStage2Floor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Stage2Floor.kt\nnet/thebrokenscript/boss/integrity/Stage2Floor$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,33:1\n295#2,2:34\n*S KotlinDebug\n*F\n+ 1 Stage2Floor.kt\nnet/thebrokenscript/boss/integrity/Stage2Floor$Companion\n*L\n29#1:34,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Stage2Floor fromY(int y) {
            Object v1;
            block1: {
                Iterable $this$firstOrNull$iv = (Iterable)Stage2Floor.getEntries();
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    Stage2Floor it = (Stage2Floor)((Object)element$iv);
                    boolean bl = false;
                    IntRange intRange = it.getYLevels();
                    int n = intRange.getFirst();
                    boolean bl2 = y <= intRange.getLast() ? n <= y : false;
                    if (!bl2) continue;
                    v1 = element$iv;
                    break block1;
                }
                v1 = null;
            }
            return v1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/boss/integrity/Stage2Floor$SpawnBounds;", "", "minDistance", "", "<init>", "(I)V", "getMinDistance", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "thebrokenscript-common"})
    public static final class SpawnBounds {
        private final int minDistance;

        public SpawnBounds(int minDistance) {
            this.minDistance = minDistance;
        }

        public /* synthetic */ SpawnBounds(int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 1) != 0) {
                n = 2;
            }
            this(n);
        }

        public final int getMinDistance() {
            return this.minDistance;
        }

        public final int component1() {
            return this.minDistance;
        }

        @NotNull
        public final SpawnBounds copy(int minDistance) {
            return new SpawnBounds(minDistance);
        }

        public static /* synthetic */ SpawnBounds copy$default(SpawnBounds spawnBounds, int n, int n2, Object object) {
            if ((n2 & 1) != 0) {
                n = spawnBounds.minDistance;
            }
            return spawnBounds.copy(n);
        }

        @NotNull
        public String toString() {
            return "SpawnBounds(minDistance=" + this.minDistance + ")";
        }

        public int hashCode() {
            return Integer.hashCode(this.minDistance);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpawnBounds)) {
                return false;
            }
            SpawnBounds spawnBounds = (SpawnBounds)other;
            return this.minDistance == spawnBounds.minDistance;
        }

        public SpawnBounds() {
            this(0, 1, null);
        }
    }
}

