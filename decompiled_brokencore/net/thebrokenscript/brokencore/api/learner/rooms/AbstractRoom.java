/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.nbt.Tag
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.learner.rooms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.rooms.RoomType;
import net.thebrokenscript.brokencore.api.util.VoxelShapeTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012.\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR9\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom;", "", "shape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "pois", "Ljava/util/HashMap;", "", "", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "Lkotlin/collections/HashMap;", "<init>", "(Lnet/minecraft/world/phys/shapes/VoxelShape;Ljava/util/HashMap;)V", "getShape", "()Lnet/minecraft/world/phys/shapes/VoxelShape;", "getPois", "()Ljava/util/HashMap;", "type", "Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "getType", "()Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "toNbt", "Lnet/minecraft/nbt/CompoundTag;", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nAbstractRoom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractRoom.kt\nnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n216#2:57\n217#2:60\n1869#3,2:58\n*S KotlinDebug\n*F\n+ 1 AbstractRoom.kt\nnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom\n*L\n19#1:57\n19#1:60\n21#1:58,2\n*E\n"})
public abstract class AbstractRoom {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final VoxelShape shape;
    @NotNull
    private final HashMap<String, List<RoomPoi>> pois;

    public AbstractRoom(@Nullable VoxelShape shape, @NotNull HashMap<String, List<RoomPoi>> pois) {
        Intrinsics.checkNotNullParameter(pois, (String)"pois");
        this.shape = shape;
        this.pois = pois;
    }

    @Nullable
    public final VoxelShape getShape() {
        return this.shape;
    }

    @NotNull
    public final HashMap<String, List<RoomPoi>> getPois() {
        return this.pois;
    }

    @NotNull
    public abstract RoomType getType();

    @NotNull
    public CompoundTag toNbt() {
        CompoundTag compound = new CompoundTag();
        CompoundTag poiCompound = new CompoundTag();
        VoxelShape voxelShape = this.shape;
        if (voxelShape == null) {
            voxelShape = Shapes.empty();
        }
        VoxelShape voxelShape2 = voxelShape;
        Intrinsics.checkNotNull((Object)voxelShape2);
        VoxelShapeTag shape = new VoxelShapeTag(voxelShape2);
        Map $this$forEach$iv = this.pois;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator.next();
            boolean bl = false;
            ListTag list = new ListTag();
            Iterable $this$forEach$iv2 = (Iterable)entry.getValue();
            boolean $i$f$forEach2 = false;
            for (Object element$iv2 : $this$forEach$iv2) {
                RoomPoi it = (RoomPoi)element$iv2;
                boolean bl2 = false;
                list.add((Object)it.toNbt());
            }
            poiCompound.put((String)entry.getKey(), (Tag)list);
        }
        compound.put("shape", (Tag)shape);
        compound.putInt("type", this.getType().ordinal());
        compound.put("pois", (Tag)poiCompound);
        return compound;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u00a2\u0006\u0002\b\bJi\u0010\t\u001aV\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e \f*\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\r0\nj*\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e \f*\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\r`\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u00a2\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom$Companion;", "", "<init>", "()V", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "tag", "Lnet/minecraft/nbt/CompoundTag;", "getShape$brokencore_common", "getPois", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "Lkotlin/collections/HashMap;", "getPois$brokencore_common", "fromNbt", "Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nAbstractRoom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractRoom.kt\nnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n1869#2,2:57\n*S KotlinDebug\n*F\n+ 1 AbstractRoom.kt\nnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom$Companion\n*L\n42#1:57,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final VoxelShape getShape$brokencore_common(@NotNull CompoundTag tag) {
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            long[] longs = tag.getLongArray("shape");
            if (longs.length < 6) {
                return null;
            }
            Intrinsics.checkNotNull((Object)longs);
            return new VoxelShapeTag(longs).getShape();
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final HashMap<String, List<RoomPoi>> getPois$brokencore_common(@NotNull CompoundTag tag) {
            Map map;
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            Map $this$getPois_u24lambda_u240 = map = MapsKt.createMapBuilder();
            boolean bl = false;
            CompoundTag compound = tag.getCompound("pois");
            for (String string : compound.getAllKeys()) {
                List list;
                ListTag shapes = compound.getList(string, 10);
                List list2 = list = CollectionsKt.createListBuilder();
                String string2 = string;
                Map map2 = $this$getPois_u24lambda_u240;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)shapes);
                Iterable $this$forEach$iv = (Iterable)shapes;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    void $this$getPois_u24lambda_u240_u240;
                    Tag it = (Tag)element$iv;
                    boolean bl3 = false;
                    Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type net.minecraft.nbt.CompoundTag");
                    long[] lArray = ((CompoundTag)it).getLongArray("shape");
                    Intrinsics.checkNotNullExpressionValue((Object)lArray, (String)"getLongArray(...)");
                    VoxelShape shape = new VoxelShapeTag(lArray).getShape();
                    Object t = NbtUtils.readBlockPos((CompoundTag)((CompoundTag)it), (String)"pos").get();
                    Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
                    BlockPos pos = (BlockPos)t;
                    String type = ((CompoundTag)it).getString("type");
                    Intrinsics.checkNotNull((Object)type);
                    $this$getPois_u24lambda_u240_u240.add(new RoomPoi(shape, pos, type));
                }
                Unit unit = Unit.INSTANCE;
                map2.put(string2, CollectionsKt.build((List)list));
            }
            Map map3 = MapsKt.build((Map)map);
            return new HashMap<String, List<RoomPoi>>(map3);
        }

        @NotNull
        public final AbstractRoom fromNbt(@NotNull CompoundTag tag) {
            Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
            return (AbstractRoom)((RoomType)((Object)RoomType.getEntries().get(tag.getInt("type")))).getCtor().invoke((Object)tag);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

