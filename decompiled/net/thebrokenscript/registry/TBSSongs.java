/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.world.item.JukeboxSong
 *  net.thebrokenscript.brokencore.api.registry.builders.JukeboxSongBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.world.item.JukeboxSong;
import net.thebrokenscript.brokencore.api.registry.builders.JukeboxSongBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/registry/TBSSongs;", "", "<init>", "()V", "DISC_14", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/item/JukeboxSong;", "DISC_15_BETRAY", "DISC_16_YOUCANT", "DISC_17_SILENCED", "INSTABILITY", "INSTABILITYV2", "INSTABILITYV3", "INSTABILITY_MUSIC_BOX", "CREDITS", "LILLY_THEME", "LILLY_THEME_V2", "JIMBOB", "thebrokenscript-common"})
public final class TBSSongs {
    @NotNull
    public static final TBSSongs INSTANCE = new TBSSongs();
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> DISC_14 = TBSReg.INSTANCE.jukeboxSong("record14", (Holder)TBSSounds.RECORD_14, 61, TBSSongs::DISC_14$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> DISC_15_BETRAY = TBSReg.INSTANCE.jukeboxSong("disc15.betray", (Holder)TBSSounds.RECORD_15_BETRAY, 78, TBSSongs::DISC_15_BETRAY$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> DISC_16_YOUCANT = TBSReg.INSTANCE.jukeboxSong("disc16.youcant", (Holder)TBSSounds.RECORD_16_YOU_CANT, 98, TBSSongs::DISC_16_YOUCANT$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> DISC_17_SILENCED = TBSReg.INSTANCE.jukeboxSong("disc17.silenced", (Holder)TBSSounds.RECORD_17_SILENCED, 63.5, TBSSongs::DISC_17_SILENCED$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> INSTABILITY = TBSReg.INSTANCE.jukeboxSong("instability", (Holder)TBSSounds.INSTABILITY, 233.5, TBSSongs::INSTABILITY$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> INSTABILITYV2 = TBSReg.INSTANCE.jukeboxSong("instability_v2", (Holder)TBSSounds.INSTABILITYV2, 239, TBSSongs::INSTABILITYV2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> INSTABILITYV3 = TBSReg.INSTANCE.jukeboxSong("instability_v3", (Holder)TBSSounds.INSTABILITYV3, 278, TBSSongs::INSTABILITYV3$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> INSTABILITY_MUSIC_BOX = TBSReg.INSTANCE.jukeboxSong("instability_music_box", (Holder)TBSSounds.INSTABILITY_MUSIC_BOX, 179, TBSSongs::INSTABILITY_MUSIC_BOX$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> CREDITS = TBSReg.INSTANCE.jukeboxSong("credits", (Holder)TBSSounds.CREDITS, 165, TBSSongs::CREDITS$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> LILLY_THEME = TBSReg.INSTANCE.jukeboxSong("lilly_theme", (Holder)TBSSounds.LILLY_THEME, 208, TBSSongs::LILLY_THEME$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> LILLY_THEME_V2 = TBSReg.INSTANCE.jukeboxSong("lilly_theme_v2", (Holder)TBSSounds.LILLY_THEME_V2, 204, TBSSongs::LILLY_THEME_V2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<JukeboxSong, JukeboxSong> JIMBOB = TBSReg.INSTANCE.jukeboxSong("attribute_mutilation", (Holder)TBSSounds.JIMBOB_FULL, 157, TBSSongs::JIMBOB$lambda$0);

    private TBSSongs() {
    }

    private static final void DISC_14$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "14";
    }

    private static final void DISC_15_BETRAY$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "(15) Betray";
    }

    private static final void DISC_16_YOUCANT$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "(16) You can't";
    }

    private static final void DISC_17_SILENCED$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "(17) Silenced";
    }

    private static final void INSTABILITY$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "L0V3M1ST - Instability";
    }

    private static final void INSTABILITYV2$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "L0V3M1ST - Instability V2";
    }

    private static final void INSTABILITYV3$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "L0V3M1ST - Instability V3";
    }

    private static final void INSTABILITY_MUSIC_BOX$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "L0V3M1ST - Instability (Music Box)";
    }

    private static final void CREDITS$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "RedstoneWizard08 - A Story Fractured";
    }

    private static final void LILLY_THEME$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "L0V3M1ST - Lilly's Theme";
    }

    private static final void LILLY_THEME_V2$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "L0V3M1ST - Lilly's Theme V2";
    }

    private static final void JIMBOB$lambda$0(JukeboxSongBuilder $this$jukeboxSong) {
        Intrinsics.checkNotNullParameter((Object)$this$jukeboxSong, (String)"$this$jukeboxSong");
        $this$jukeboxSong.description = "TornadicPolarity - Attribute Mutilation";
    }
}

