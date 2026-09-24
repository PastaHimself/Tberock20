/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.boss.integrity.Stage2Floor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/boss/integrity/Phase2Floors;", "", "stage2Floor", "Lnet/thebrokenscript/boss/integrity/Stage2Floor;", "<init>", "(Ljava/lang/String;ILnet/thebrokenscript/boss/integrity/Stage2Floor;)V", "getStage2Floor", "()Lnet/thebrokenscript/boss/integrity/Stage2Floor;", "Floor1", "Floor2", "Floor3", "Floor4", "Floor5", "Floor6", "Floor7", "level", "", "getLevel", "()I", "Companion", "thebrokenscript-common"})
public final class Phase2Floors
extends Enum<Phase2Floors> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Stage2Floor stage2Floor;
    public static final /* enum */ Phase2Floors Floor1;
    public static final /* enum */ Phase2Floors Floor2;
    public static final /* enum */ Phase2Floors Floor3;
    public static final /* enum */ Phase2Floors Floor4;
    public static final /* enum */ Phase2Floors Floor5;
    public static final /* enum */ Phase2Floors Floor6;
    public static final /* enum */ Phase2Floors Floor7;
    private static final /* synthetic */ Phase2Floors[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private Phase2Floors(Stage2Floor stage2Floor) {
        this.stage2Floor = stage2Floor;
    }

    @NotNull
    public final Stage2Floor getStage2Floor() {
        return this.stage2Floor;
    }

    public final int getLevel() {
        return this.ordinal() + 1;
    }

    public static Phase2Floors[] values() {
        return (Phase2Floors[])$VALUES.clone();
    }

    public static Phase2Floors valueOf(String value) {
        return Enum.valueOf(Phase2Floors.class, value);
    }

    @NotNull
    public static EnumEntries<Phase2Floors> getEntries() {
        return $ENTRIES;
    }

    static {
        Floor1 = new Phase2Floors(Stage2Floor.FLOOR_1);
        Floor2 = new Phase2Floors(Stage2Floor.FLOOR_2);
        Floor3 = new Phase2Floors(Stage2Floor.FLOOR_3);
        Floor4 = new Phase2Floors(Stage2Floor.FLOOR_4);
        Floor5 = new Phase2Floors(Stage2Floor.FLOOR_5);
        Floor6 = new Phase2Floors(Stage2Floor.FLOOR_6_INTEG);
        Floor7 = new Phase2Floors(Stage2Floor.FLOOR_7);
        $VALUES = phase2FloorsArray = new Phase2Floors[]{Phase2Floors.Floor1, Phase2Floors.Floor2, Phase2Floors.Floor3, Phase2Floors.Floor4, Phase2Floors.Floor5, Phase2Floors.Floor6, Phase2Floors.Floor7};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/boss/integrity/Phase2Floors$Companion;", "", "<init>", "()V", "fromY", "Lnet/thebrokenscript/boss/integrity/Phase2Floors;", "y", "", "thebrokenscript-common"})
    @SourceDebugExtension(value={"SMAP\nPhase2Floors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Phase2Floors.kt\nnet/thebrokenscript/boss/integrity/Phase2Floors$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,18:1\n295#2,2:19\n*S KotlinDebug\n*F\n+ 1 Phase2Floors.kt\nnet/thebrokenscript/boss/integrity/Phase2Floors$Companion\n*L\n16#1:19,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Phase2Floors fromY(int y) {
            Object v0;
            block1: {
                Iterable $this$firstOrNull$iv = (Iterable)Phase2Floors.getEntries();
                boolean $i$f$firstOrNull = false;
                for (Object element$iv : $this$firstOrNull$iv) {
                    Phase2Floors it = (Phase2Floors)((Object)element$iv);
                    boolean bl = false;
                    if (!it.getStage2Floor().getYLevels().contains(y)) continue;
                    v0 = element$iv;
                    break block1;
                }
                v0 = null;
            }
            return v0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

