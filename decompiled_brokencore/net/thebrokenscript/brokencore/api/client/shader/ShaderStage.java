/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.shader;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/client/shader/ShaderStage;", "", "<init>", "(Ljava/lang/String;I)V", "LEVEL", "WORLD", "OVERLAY", "brokencore-common"})
public final class ShaderStage
extends Enum<ShaderStage> {
    public static final /* enum */ ShaderStage LEVEL = new ShaderStage();
    public static final /* enum */ ShaderStage WORLD = new ShaderStage();
    public static final /* enum */ ShaderStage OVERLAY = new ShaderStage();
    private static final /* synthetic */ ShaderStage[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static ShaderStage[] values() {
        return (ShaderStage[])$VALUES.clone();
    }

    public static ShaderStage valueOf(String value) {
        return Enum.valueOf(ShaderStage.class, value);
    }

    @NotNull
    public static EnumEntries<ShaderStage> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = shaderStageArray = new ShaderStage[]{ShaderStage.LEVEL, ShaderStage.WORLD, ShaderStage.OVERLAY};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

