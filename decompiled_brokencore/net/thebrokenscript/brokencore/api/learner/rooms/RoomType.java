/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  net.minecraft.nbt.CompoundTag
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.learner.rooms;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import net.minecraft.nbt.CompoundTag;
import net.thebrokenscript.brokencore.api.learner.rooms.AbstractRoom;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B,\b\u0002\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0004\b\t\u0010\nR,\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/rooms/RoomType;", "", "ctor", "Lkotlin/Function1;", "Lnet/minecraft/nbt/CompoundTag;", "Lkotlin/ParameterName;", "name", "tag", "Lnet/thebrokenscript/brokencore/api/learner/rooms/AbstractRoom;", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getCtor", "()Lkotlin/jvm/functions/Function1;", "EMPTY", "LIVING_ROOM", "CRAFTING", "GENERIC", "KITCHEN", "STORAGE", "BEDROOM", "brokencore-common"})
public final class RoomType
extends Enum<RoomType> {
    @NotNull
    private final Function1<CompoundTag, AbstractRoom> ctor;
    public static final /* enum */ RoomType EMPTY = new RoomType((Function1<? super CompoundTag, ? extends AbstractRoom>)((Function1)1.INSTANCE));
    public static final /* enum */ RoomType LIVING_ROOM = new RoomType((Function1<? super CompoundTag, ? extends AbstractRoom>)((Function1)2.INSTANCE));
    public static final /* enum */ RoomType CRAFTING = new RoomType((Function1<? super CompoundTag, ? extends AbstractRoom>)((Function1)3.INSTANCE));
    public static final /* enum */ RoomType GENERIC = new RoomType((Function1<? super CompoundTag, ? extends AbstractRoom>)((Function1)4.INSTANCE));
    public static final /* enum */ RoomType KITCHEN = new RoomType((Function1<? super CompoundTag, ? extends AbstractRoom>)((Function1)5.INSTANCE));
    public static final /* enum */ RoomType STORAGE = new RoomType((Function1<? super CompoundTag, ? extends AbstractRoom>)((Function1)6.INSTANCE));
    public static final /* enum */ RoomType BEDROOM = new RoomType((Function1<? super CompoundTag, ? extends AbstractRoom>)((Function1)7.INSTANCE));
    private static final /* synthetic */ RoomType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private RoomType(Function1<? super CompoundTag, ? extends AbstractRoom> ctor) {
        this.ctor = ctor;
    }

    @NotNull
    public final Function1<CompoundTag, AbstractRoom> getCtor() {
        return this.ctor;
    }

    public static RoomType[] values() {
        return (RoomType[])$VALUES.clone();
    }

    public static RoomType valueOf(String value) {
        return Enum.valueOf(RoomType.class, value);
    }

    @NotNull
    public static EnumEntries<RoomType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = roomTypeArray = new RoomType[]{RoomType.EMPTY, RoomType.LIVING_ROOM, RoomType.CRAFTING, RoomType.GENERIC, RoomType.KITCHEN, RoomType.STORAGE, RoomType.BEDROOM};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

