/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.sounds.SoundEvent
 *  net.thebrokenscript.brokencore.api.registry.builders.SoundBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.integrity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.brokencore.api.registry.builders.SoundBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/boss/integrity/IntegrityBossTracks;", "", "<init>", "()V", "TRACK_INTRO", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/sounds/SoundEvent;", "getTRACK_INTRO", "()Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "TRACK_PART_1", "getTRACK_PART_1", "TRACK_PART_1_BRIDGE", "getTRACK_PART_1_BRIDGE", "TRACK_PART_2", "getTRACK_PART_2", "TRACK_PART_2_BRIDGE", "getTRACK_PART_2_BRIDGE", "TRACK_PART_3", "getTRACK_PART_3", "TRACK_END", "getTRACK_END", "thebrokenscript-common"})
public final class IntegrityBossTracks {
    @NotNull
    public static final IntegrityBossTracks INSTANCE = new IntegrityBossTracks();
    @NotNull
    private static final RegistryEntry<SoundEvent, SoundEvent> TRACK_INTRO = TBSReg.INSTANCE.sound("integrity.integrity_intro", IntegrityBossTracks::TRACK_INTRO$lambda$0);
    @NotNull
    private static final RegistryEntry<SoundEvent, SoundEvent> TRACK_PART_1 = TBSReg.INSTANCE.sound("integrity.boss_p1", IntegrityBossTracks::TRACK_PART_1$lambda$0);
    @NotNull
    private static final RegistryEntry<SoundEvent, SoundEvent> TRACK_PART_1_BRIDGE = TBSReg.INSTANCE.sound("integrity.boss_p1_bridge", IntegrityBossTracks::TRACK_PART_1_BRIDGE$lambda$0);
    @NotNull
    private static final RegistryEntry<SoundEvent, SoundEvent> TRACK_PART_2 = TBSReg.INSTANCE.sound("integrity.boss_p2", IntegrityBossTracks::TRACK_PART_2$lambda$0);
    @NotNull
    private static final RegistryEntry<SoundEvent, SoundEvent> TRACK_PART_2_BRIDGE = TBSReg.INSTANCE.sound("integrity.boss_p2_bridge", IntegrityBossTracks::TRACK_PART_2_BRIDGE$lambda$0);
    @NotNull
    private static final RegistryEntry<SoundEvent, SoundEvent> TRACK_PART_3 = TBSReg.INSTANCE.sound("integrity.boss_p3", IntegrityBossTracks::TRACK_PART_3$lambda$0);
    @NotNull
    private static final RegistryEntry<SoundEvent, SoundEvent> TRACK_END = TBSReg.INSTANCE.sound("integrity.boss_end", IntegrityBossTracks::TRACK_END$lambda$0);

    private IntegrityBossTracks() {
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> getTRACK_INTRO() {
        return TRACK_INTRO;
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> getTRACK_PART_1() {
        return TRACK_PART_1;
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> getTRACK_PART_1_BRIDGE() {
        return TRACK_PART_1_BRIDGE;
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> getTRACK_PART_2() {
        return TRACK_PART_2;
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> getTRACK_PART_2_BRIDGE() {
        return TRACK_PART_2_BRIDGE;
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> getTRACK_PART_3() {
        return TRACK_PART_3;
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> getTRACK_END() {
        return TRACK_END;
    }

    private static final void TRACK_INTRO$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "";
    }

    private static final void TRACK_PART_1$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "";
    }

    private static final void TRACK_PART_1_BRIDGE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "";
    }

    private static final void TRACK_PART_2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "";
    }

    private static final void TRACK_PART_2_BRIDGE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "";
    }

    private static final void TRACK_PART_3$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "";
    }

    private static final void TRACK_END$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "";
    }
}

