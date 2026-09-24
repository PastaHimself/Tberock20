/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.learner.rooms;

import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom;
import net.thebrokenscript.brokencore.api.learner.rooms.RoomType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012.\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\t\u00a2\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\n\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u001f\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010!\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010#\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010%\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0011\u0010'\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016R\u0011\u0010)\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u0011\u0010+\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0016R\u0011\u0010-\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0016\u00a8\u0006/"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/rooms/CraftingRoom;", "Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom;", "shape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "pois", "Ljava/util/HashMap;", "", "", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "Lkotlin/collections/HashMap;", "<init>", "(Lnet/minecraft/world/phys/shapes/VoxelShape;Ljava/util/HashMap;)V", "tag", "Lnet/minecraft/nbt/CompoundTag;", "(Lnet/minecraft/nbt/CompoundTag;)V", "type", "Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "getType", "()Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "hasFurnace", "", "getHasFurnace", "()Z", "hasSmoker", "getHasSmoker", "hasContainer", "getHasContainer", "hasCauldron", "getHasCauldron", "hasBlastFurnace", "getHasBlastFurnace", "hasAnvil", "getHasAnvil", "hasGrindstone", "getHasGrindstone", "hasEnchantingTable", "getHasEnchantingTable", "hasLoom", "getHasLoom", "hasSmithingTable", "getHasSmithingTable", "hasStonecutter", "getHasStonecutter", "hasCartographyTable", "getHasCartographyTable", "hasBrewingStand", "getHasBrewingStand", "brokencore-common"})
public final class CraftingRoom
extends AbstractRoom {
    @NotNull
    private final RoomType type;
    private final boolean hasFurnace;
    private final boolean hasSmoker;
    private final boolean hasContainer;
    private final boolean hasCauldron;
    private final boolean hasBlastFurnace;
    private final boolean hasAnvil;
    private final boolean hasGrindstone;
    private final boolean hasEnchantingTable;
    private final boolean hasLoom;
    private final boolean hasSmithingTable;
    private final boolean hasStonecutter;
    private final boolean hasCartographyTable;
    private final boolean hasBrewingStand;

    public CraftingRoom(@Nullable VoxelShape shape, @NotNull HashMap<String, List<RoomPoi>> pois) {
        Intrinsics.checkNotNullParameter(pois, (String)"pois");
        super(shape, pois);
        this.type = RoomType.CRAFTING;
        this.hasFurnace = pois.keySet().contains("furnace");
        this.hasSmoker = pois.keySet().contains("smoker");
        this.hasContainer = pois.keySet().contains("container");
        this.hasCauldron = pois.keySet().contains("cauldron");
        this.hasBlastFurnace = pois.keySet().contains("blast_furnace");
        this.hasAnvil = pois.keySet().contains("anvil");
        this.hasGrindstone = pois.keySet().contains("grindstone");
        this.hasEnchantingTable = pois.keySet().contains("enchanting_table");
        this.hasLoom = pois.keySet().contains("loom");
        this.hasSmithingTable = pois.keySet().contains("smithing_table");
        this.hasStonecutter = pois.keySet().contains("stonecutter");
        this.hasCartographyTable = pois.keySet().contains("cartography_table");
        this.hasBrewingStand = pois.keySet().contains("brewing_stand");
    }

    @Override
    @NotNull
    public RoomType getType() {
        return this.type;
    }

    public final boolean getHasFurnace() {
        return this.hasFurnace;
    }

    public final boolean getHasSmoker() {
        return this.hasSmoker;
    }

    public final boolean getHasContainer() {
        return this.hasContainer;
    }

    public final boolean getHasCauldron() {
        return this.hasCauldron;
    }

    public final boolean getHasBlastFurnace() {
        return this.hasBlastFurnace;
    }

    public final boolean getHasAnvil() {
        return this.hasAnvil;
    }

    public final boolean getHasGrindstone() {
        return this.hasGrindstone;
    }

    public final boolean getHasEnchantingTable() {
        return this.hasEnchantingTable;
    }

    public final boolean getHasLoom() {
        return this.hasLoom;
    }

    public final boolean getHasSmithingTable() {
        return this.hasSmithingTable;
    }

    public final boolean getHasStonecutter() {
        return this.hasStonecutter;
    }

    public final boolean getHasCartographyTable() {
        return this.hasCartographyTable;
    }

    public final boolean getHasBrewingStand() {
        return this.hasBrewingStand;
    }

    public CraftingRoom(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        this(AbstractRoom.Companion.getShape$brokencore_common(tag), AbstractRoom.Companion.getPois$brokencore_common(tag));
    }
}

