/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.event;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/client/event/RenderStage;", "", "<init>", "(Ljava/lang/String;I)V", "AFTER_SKY", "AFTER_SOLID_BLOCKS", "AFTER_CUTOUT_MIPPED_BLOCKS_BLOCKS", "AFTER_CUTOUT_BLOCKS", "AFTER_ENTITIES", "AFTER_BLOCK_ENTITIES", "AFTER_TRANSLUCENT_BLOCKS", "AFTER_TRIPWIRE_BLOCKS", "AFTER_PARTICLES", "AFTER_WEATHER", "AFTER_LEVEL", "brokencore-common"})
public final class RenderStage
extends Enum<RenderStage> {
    public static final /* enum */ RenderStage AFTER_SKY = new RenderStage();
    public static final /* enum */ RenderStage AFTER_SOLID_BLOCKS = new RenderStage();
    public static final /* enum */ RenderStage AFTER_CUTOUT_MIPPED_BLOCKS_BLOCKS = new RenderStage();
    public static final /* enum */ RenderStage AFTER_CUTOUT_BLOCKS = new RenderStage();
    public static final /* enum */ RenderStage AFTER_ENTITIES = new RenderStage();
    public static final /* enum */ RenderStage AFTER_BLOCK_ENTITIES = new RenderStage();
    public static final /* enum */ RenderStage AFTER_TRANSLUCENT_BLOCKS = new RenderStage();
    public static final /* enum */ RenderStage AFTER_TRIPWIRE_BLOCKS = new RenderStage();
    public static final /* enum */ RenderStage AFTER_PARTICLES = new RenderStage();
    public static final /* enum */ RenderStage AFTER_WEATHER = new RenderStage();
    public static final /* enum */ RenderStage AFTER_LEVEL = new RenderStage();
    private static final /* synthetic */ RenderStage[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static RenderStage[] values() {
        return (RenderStage[])$VALUES.clone();
    }

    public static RenderStage valueOf(String value) {
        return Enum.valueOf(RenderStage.class, value);
    }

    @NotNull
    public static EnumEntries<RenderStage> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = renderStageArray = new RenderStage[]{RenderStage.AFTER_SKY, RenderStage.AFTER_SOLID_BLOCKS, RenderStage.AFTER_CUTOUT_MIPPED_BLOCKS_BLOCKS, RenderStage.AFTER_CUTOUT_BLOCKS, RenderStage.AFTER_ENTITIES, RenderStage.AFTER_BLOCK_ENTITIES, RenderStage.AFTER_TRANSLUCENT_BLOCKS, RenderStage.AFTER_TRIPWIRE_BLOCKS, RenderStage.AFTER_PARTICLES, RenderStage.AFTER_WEATHER, RenderStage.AFTER_LEVEL};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

