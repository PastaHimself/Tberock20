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
package net.thebrokenscript.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/data/CameraMode;", "Lnet/minecraft/util/StringRepresentable;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_PERSON", "THIRD_PERSON_FRONT", "THIRD_PERSON_BACK", "getSerializedName", "", "thebrokenscript-common"})
public final class CameraMode
extends Enum<CameraMode>
implements StringRepresentable {
    public static final /* enum */ CameraMode FIRST_PERSON = new CameraMode();
    public static final /* enum */ CameraMode THIRD_PERSON_FRONT = new CameraMode();
    public static final /* enum */ CameraMode THIRD_PERSON_BACK = new CameraMode();
    private static final /* synthetic */ CameraMode[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    @NotNull
    public String getSerializedName() {
        return this.name();
    }

    public static CameraMode[] values() {
        return (CameraMode[])$VALUES.clone();
    }

    public static CameraMode valueOf(String value) {
        return Enum.valueOf(CameraMode.class, value);
    }

    @NotNull
    public static EnumEntries<CameraMode> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = cameraModeArray = new CameraMode[]{CameraMode.FIRST_PERSON, CameraMode.THIRD_PERSON_FRONT, CameraMode.THIRD_PERSON_BACK};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

