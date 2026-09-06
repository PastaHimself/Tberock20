/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function0
 *  net.minecraft.sounds.SoundEvent
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.kerfur;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/boss/kerfur/KerfBossMusicState;", "", "track", "Lkotlin/Function0;", "Lnet/minecraft/sounds/SoundEvent;", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "getTrack", "()Lkotlin/jvm/functions/Function0;", "PHASE_1", "PHASE_2", "PHASE_3", "thebrokenscript-common"})
public final class KerfBossMusicState
extends Enum<KerfBossMusicState> {
    @NotNull
    private final Function0<SoundEvent> track;
    public static final /* enum */ KerfBossMusicState PHASE_1 = new KerfBossMusicState((Function0<? extends SoundEvent>)((Function0)new Function0<SoundEvent>(TBSSounds.MURDERFUR_PHASE_1){

        public final SoundEvent invoke() {
            return (SoundEvent)((RegistryEntry)this.receiver).get();
        }
    }));
    public static final /* enum */ KerfBossMusicState PHASE_2 = new KerfBossMusicState((Function0<? extends SoundEvent>)((Function0)new Function0<SoundEvent>(TBSSounds.MURDERFUR_PHASE_2){

        public final SoundEvent invoke() {
            return (SoundEvent)((RegistryEntry)this.receiver).get();
        }
    }));
    public static final /* enum */ KerfBossMusicState PHASE_3 = new KerfBossMusicState((Function0<? extends SoundEvent>)((Function0)new Function0<SoundEvent>(TBSSounds.MURDERFUR_PHASE_3){

        public final SoundEvent invoke() {
            return (SoundEvent)((RegistryEntry)this.receiver).get();
        }
    }));
    private static final /* synthetic */ KerfBossMusicState[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private KerfBossMusicState(Function0<? extends SoundEvent> track) {
        this.track = track;
    }

    @NotNull
    public final Function0<SoundEvent> getTrack() {
        return this.track;
    }

    public static KerfBossMusicState[] values() {
        return (KerfBossMusicState[])$VALUES.clone();
    }

    public static KerfBossMusicState valueOf(String value) {
        return Enum.valueOf(KerfBossMusicState.class, value);
    }

    @NotNull
    public static EnumEntries<KerfBossMusicState> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = kerfBossMusicStateArray = new KerfBossMusicState[]{KerfBossMusicState.PHASE_1, KerfBossMusicState.PHASE_2, KerfBossMusicState.PHASE_3};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

