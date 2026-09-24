/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  net.minecraft.util.StringRepresentable
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/impl/block/VerticalSlabType;", "Lnet/minecraft/util/StringRepresentable;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "LEFT", "RIGHT", "DOUBLE", "toString", "getSerializedName", "brokencore-common"})
public final class VerticalSlabType
extends Enum<VerticalSlabType>
implements StringRepresentable {
    @NotNull
    private final String id;
    public static final /* enum */ VerticalSlabType LEFT = new VerticalSlabType("left");
    public static final /* enum */ VerticalSlabType RIGHT = new VerticalSlabType("right");
    public static final /* enum */ VerticalSlabType DOUBLE = new VerticalSlabType("double");
    private static final /* synthetic */ VerticalSlabType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private VerticalSlabType(String id) {
        this.id = id;
    }

    @NotNull
    public String toString() {
        return this.id;
    }

    @NotNull
    public String getSerializedName() {
        return this.id;
    }

    public static VerticalSlabType[] values() {
        return (VerticalSlabType[])$VALUES.clone();
    }

    public static VerticalSlabType valueOf(String value) {
        return Enum.valueOf(VerticalSlabType.class, value);
    }

    @NotNull
    public static EnumEntries<VerticalSlabType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = verticalSlabTypeArray = new VerticalSlabType[]{VerticalSlabType.LEFT, VerticalSlabType.RIGHT, VerticalSlabType.DOUBLE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

