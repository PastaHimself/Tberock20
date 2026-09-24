/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.random.RandomKt
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.learner.util;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import net.thebrokenscript.brokencore.api.debug.Debuggable;
import net.thebrokenscript.brokencore.api.debug.renderer.DebugTextDisplay;
import net.thebrokenscript.brokencore.api.ext.VoxelShapeExtKt;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.Bedroom;
import net.thebrokenscript.brokencore.api.learner.rooms.CraftingRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.EmptyRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.GenericRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.Kitchen;
import net.thebrokenscript.brokencore.api.learner.rooms.LivingRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.StorageRoom;
import net.thebrokenscript.brokencore.api.learner.util.UnfinalizedPlayerBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0017\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001d\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r0\u001fJ\u001a\u0010!\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\r0\u001fJ\u001a\u0010#\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u001fJ\u001a\u0010%\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r0\u001fJ\u001a\u0010'\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r0\u001fJ\u001a\u0010)\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r0\u001fJ\u001a\u0010+\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\r0\u001fJ\u001a\u0010-\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u001fJ\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\u0006\u00102\u001a\u000203H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u00065"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/util/PlayerBase;", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "Lnet/thebrokenscript/brokencore/api/debug/Debuggable;", "rooms", "", "Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom;", "<init>", "(Ljava/util/List;)V", "category", "", "getCategory", "()Ljava/lang/String;", "tickDebug", "", "value", "getRooms", "()Ljava/util/List;", "renderDebug", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "randomBottomPos", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/world/level/Level;", "randomPos", "toNbt", "Lnet/minecraft/nbt/ListTag;", "forEachBedroom", "consumer", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/learner/rooms/Bedroom;", "forEachKitchen", "Lnet/thebrokenscript/brokencore/api/learner/rooms/Kitchen;", "forEachEmptyRoom", "Lnet/thebrokenscript/brokencore/api/learner/rooms/EmptyRoom;", "forEachGenericRoom", "Lnet/thebrokenscript/brokencore/api/learner/rooms/GenericRoom;", "forEachStorageRoom", "Lnet/thebrokenscript/brokencore/api/learner/rooms/StorageRoom;", "forEachLivingRoom", "Lnet/thebrokenscript/brokencore/api/learner/rooms/LivingRoom;", "forEachCraftingRoom", "Lnet/thebrokenscript/brokencore/api/learner/rooms/CraftingRoom;", "forEachRoom", "serializeNbt", "provider", "Lnet/minecraft/core/HolderLookup$Provider;", "deserializeNbt", "tag", "Lnet/minecraft/nbt/Tag;", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nPlayerBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerBase.kt\nnet/thebrokenscript/brokencore/api/learner/util/PlayerBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,144:1\n1878#2,2:145\n1869#2,2:148\n1880#2:151\n1869#2,2:152\n1869#2,2:154\n1869#2,2:156\n1869#2,2:158\n1869#2,2:160\n1869#2,2:162\n1869#2,2:164\n1869#2,2:166\n216#3:147\n217#3:150\n*S KotlinDebug\n*F\n+ 1 PlayerBase.kt\nnet/thebrokenscript/brokencore/api/learner/util/PlayerBase\n*L\n40#1:145,2\n46#1:148,2\n40#1:151\n92#1:152,2\n93#1:154,2\n94#1:156,2\n95#1:158,2\n96#1:160,2\n97#1:162,2\n98#1:164,2\n99#1:166,2\n45#1:147\n45#1:150\n*E\n"})
public final class PlayerBase
implements NbtSerializable,
Debuggable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String category;
    @NotNull
    private List<? extends AbstractRoom> rooms;
    @NotNull
    private static final HashMap<UUID, PlayerBase> baseObjects = new HashMap();

    public PlayerBase(@NotNull List<? extends AbstractRoom> rooms) {
        Intrinsics.checkNotNullParameter(rooms, (String)"rooms");
        this.category = "player_base";
        this.rooms = rooms;
    }

    public /* synthetic */ PlayerBase(List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        this(list);
    }

    @Override
    @NotNull
    public String getCategory() {
        return this.category;
    }

    @Override
    public void tickDebug() {
    }

    @NotNull
    public final List<AbstractRoom> getRooms() {
        return this.rooms;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void renderDebug(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Iterable $this$forEachIndexed$iv = this.rooms;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            void room;
            int n;
            if ((n = index$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AbstractRoom abstractRoom = (AbstractRoom)item$iv;
            int index = n;
            boolean bl = false;
            float r = RandomKt.Random((int)(index + 1)).nextFloat();
            float g = RandomKt.Random((int)(index + 2)).nextFloat();
            float b = RandomKt.Random((int)(index + 3)).nextFloat();
            VoxelShape voxelShape = room.getShape();
            if (voxelShape != null) {
                VoxelShapeExtKt.renderLines(voxelShape, buffer, poseStack, r, g, b);
            }
            Map $this$forEach$iv = room.getPois();
            boolean $i$f$forEach = false;
            Iterator iterator = $this$forEach$iv.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry element$iv;
                Map.Entry poiType = element$iv = iterator.next();
                boolean bl2 = false;
                Iterable $this$forEach$iv2 = (Iterable)poiType.getValue();
                boolean $i$f$forEach2 = false;
                for (Object element$iv2 : $this$forEach$iv2) {
                    RoomPoi poi = (RoomPoi)element$iv2;
                    boolean bl3 = false;
                    VoxelShapeExtKt.renderLines(poi.getShape(), buffer, poseStack, 1.0f, 1.0f, 1.0f);
                    DebugTextDisplay.INSTANCE.render((String)poiType.getKey(), new Vec3((double)poi.getPos().getX(), (double)poi.getPos().getY(), (double)poi.getPos().getZ()), buffer, poseStack, 1.0f, 1.0f, 1.0f);
                }
            }
        }
    }

    @Nullable
    public final BlockPos randomBottomPos(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        int n = 256;
        for (int i = 0; i < n; ++i) {
            BlockPos it;
            BlockPos pos;
            int it2 = i;
            boolean bl = false;
            VoxelShape voxelShape = ((AbstractRoom)CollectionsKt.random((Collection)this.rooms, (Random)((Random)Random.Default))).getShape();
            Object object = pos = voxelShape != null ? VoxelShapeExtKt.randomBottomBlockPos(voxelShape) : null;
            if (pos == null) continue;
            boolean bl2 = false;
            if (!level.getBlockState(it).isAir()) continue;
            return pos;
        }
        return null;
    }

    @Nullable
    public final BlockPos randomPos(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        int n = 256;
        for (int i = 0; i < n; ++i) {
            BlockPos it;
            BlockPos pos;
            int it2 = i;
            boolean bl = false;
            VoxelShape voxelShape = ((AbstractRoom)CollectionsKt.random((Collection)this.rooms, (Random)((Random)Random.Default))).getShape();
            Object object = pos = voxelShape != null ? VoxelShapeExtKt.randomBlockPos(voxelShape) : null;
            if (pos == null) continue;
            boolean bl2 = false;
            if (!level.getBlockState(it).isAir()) continue;
            return pos;
        }
        return null;
    }

    @NotNull
    public final ListTag toNbt() {
        ListTag list = new ListTag();
        for (AbstractRoom abstractRoom : this.rooms) {
            list.add((Object)abstractRoom.toNbt());
        }
        return list;
    }

    public final void forEachBedroom(@NotNull Function1<? super Bedroom, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Iterable $this$forEach$iv = this.rooms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractRoom it = (AbstractRoom)element$iv;
            boolean bl = false;
            if (!(it instanceof Bedroom)) continue;
            consumer.invoke((Object)it);
        }
    }

    public final void forEachKitchen(@NotNull Function1<? super Kitchen, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Iterable $this$forEach$iv = this.rooms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractRoom it = (AbstractRoom)element$iv;
            boolean bl = false;
            if (!(it instanceof Kitchen)) continue;
            consumer.invoke((Object)it);
        }
    }

    public final void forEachEmptyRoom(@NotNull Function1<? super EmptyRoom, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Iterable $this$forEach$iv = this.rooms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractRoom it = (AbstractRoom)element$iv;
            boolean bl = false;
            if (!(it instanceof EmptyRoom)) continue;
            consumer.invoke((Object)it);
        }
    }

    public final void forEachGenericRoom(@NotNull Function1<? super GenericRoom, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Iterable $this$forEach$iv = this.rooms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractRoom it = (AbstractRoom)element$iv;
            boolean bl = false;
            if (!(it instanceof GenericRoom)) continue;
            consumer.invoke((Object)it);
        }
    }

    public final void forEachStorageRoom(@NotNull Function1<? super StorageRoom, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Iterable $this$forEach$iv = this.rooms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractRoom it = (AbstractRoom)element$iv;
            boolean bl = false;
            if (!(it instanceof StorageRoom)) continue;
            consumer.invoke((Object)it);
        }
    }

    public final void forEachLivingRoom(@NotNull Function1<? super LivingRoom, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Iterable $this$forEach$iv = this.rooms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractRoom it = (AbstractRoom)element$iv;
            boolean bl = false;
            if (!(it instanceof LivingRoom)) continue;
            consumer.invoke((Object)it);
        }
    }

    public final void forEachCraftingRoom(@NotNull Function1<? super CraftingRoom, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Iterable $this$forEach$iv = this.rooms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractRoom it = (AbstractRoom)element$iv;
            boolean bl = false;
            if (!(it instanceof CraftingRoom)) continue;
            consumer.invoke((Object)it);
        }
    }

    public final void forEachRoom(@NotNull Function1<? super AbstractRoom, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Iterable $this$forEach$iv = this.rooms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            AbstractRoom it = (AbstractRoom)element$iv;
            boolean bl = false;
            consumer.invoke((Object)it);
        }
    }

    @NotNull
    public ListTag serializeNbt(@NotNull HolderLookup.Provider provider) {
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        return this.toNbt();
    }

    @Override
    public void deserializeNbt(@NotNull HolderLookup.Provider provider, @NotNull Tag tag) {
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        this.rooms = PlayerBase.Companion.fromNbt((ListTag)((ListTag)tag)).rooms;
    }

    public PlayerBase() {
        this(null, 1, null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ9\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015JQ\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/util/PlayerBase$Companion;", "", "<init>", "()V", "baseObjects", "Ljava/util/HashMap;", "Ljava/util/UUID;", "Lnet/thebrokenscript/brokencore/api/learner/util/PlayerBase;", "Lkotlin/collections/HashMap;", "getBaseObjects", "()Ljava/util/HashMap;", "fromNbt", "listTag", "Lnet/minecraft/nbt/ListTag;", "scanAt", "Lnet/thebrokenscript/brokencore/api/learner/util/UnfinalizedPlayerBase;", "pos", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/world/level/Level;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "finalized", "", "floodFillRecursionDepth", "", "maxFlooderUpdatesPerTick", "minFlooderUpdatesForRecursionIncrement", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nPlayerBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerBase.kt\nnet/thebrokenscript/brokencore/api/learner/util/PlayerBase$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,144:1\n1869#2,2:145\n*S KotlinDebug\n*F\n+ 1 PlayerBase.kt\nnet/thebrokenscript/brokencore/api/learner/util/PlayerBase$Companion\n*L\n112#1:145,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashMap<UUID, PlayerBase> getBaseObjects() {
            return baseObjects;
        }

        @NotNull
        public final PlayerBase fromNbt(@NotNull ListTag listTag) {
            List list;
            Intrinsics.checkNotNullParameter((Object)listTag, (String)"listTag");
            List $this$fromNbt_u24lambda_u240 = list = CollectionsKt.createListBuilder();
            boolean bl = false;
            Iterable $this$forEach$iv = (Iterable)listTag;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Tag it = (Tag)element$iv;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type net.minecraft.nbt.CompoundTag");
                $this$fromNbt_u24lambda_u240.add(AbstractRoom.Companion.fromNbt((CompoundTag)it));
            }
            List list2 = CollectionsKt.build((List)list);
            return new PlayerBase(list2);
        }

        @NotNull
        public final UnfinalizedPlayerBase scanAt(@NotNull BlockPos pos, @NotNull Level level, @NotNull Function1<? super PlayerBase, Unit> callback) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter(callback, (String)"callback");
            return this.scanAt(pos, level, 64, 16, 16, callback);
        }

        @NotNull
        public final UnfinalizedPlayerBase scanAt(@NotNull BlockPos pos, @NotNull Level level, int floodFillRecursionDepth, int maxFlooderUpdatesPerTick, int minFlooderUpdatesForRecursionIncrement, @NotNull Function1<? super PlayerBase, Unit> callback) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter(callback, (String)"callback");
            return new UnfinalizedPlayerBase(pos, level, floodFillRecursionDepth, maxFlooderUpdatesPerTick, minFlooderUpdatesForRecursionIncrement, callback);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

