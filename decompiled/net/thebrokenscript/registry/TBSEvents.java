/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.thebrokenscript.brokencore.api.registry.BrokenReg
 *  net.thebrokenscript.brokencore.api.registry.builders.EventBuilder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.EventBuilder;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/registry/TBSEvents;", "", "<init>", "()V", "thebrokenscript-common"})
public final class TBSEvents {
    @NotNull
    public static final TBSEvents INSTANCE = new TBSEvents();

    private TBSEvents() {
    }

    private static final void _init_$lambda$0(EventBuilder $this$event) {
        Intrinsics.checkNotNullParameter((Object)$this$event, (String)"$this$event");
        $this$event.lang = "BSOD";
    }

    private static final void _init_$lambda$1(EventBuilder $this$event) {
        Intrinsics.checkNotNullParameter((Object)$this$event, (String)"$this$event");
        $this$event.lang = "No-op (Does nothing)";
    }

    private static final void _init_$lambda$2(EventBuilder $this$event) {
        Intrinsics.checkNotNullParameter((Object)$this$event, (String)"$this$event");
        $this$event.lang = "Text (in chat)";
    }

    private static final void _init_$lambda$3(EventBuilder $this$event) {
        Intrinsics.checkNotNullParameter((Object)$this$event, (String)"$this$event");
        $this$event.lang = "Window Title Change Event";
    }

    private static final void _init_$lambda$4(EventBuilder $this$event) {
        Intrinsics.checkNotNullParameter((Object)$this$event, (String)"$this$event");
        $this$event.lang = "Chromatic Aberration";
    }

    static {
        TBSReg.INSTANCE.event("bsod", 1.INSTANCE, TBSEvents::_init_$lambda$0);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"can_someone_hear_me", (Function0)3.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"close_menu", (Function0)4.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"damage", (Function0)5.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"doors", (Function0)6.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"explode_base", (Function0)7.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"eyes", (Function0)8.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"false_villager", (Function0)9.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"giift", (Function0)10.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"give_disc_11", (Function0)11.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"heartbeat", (Function0)12.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"hungry", (Function0)13.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"jframe_1", (Function0)14.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"jframe_2", (Function0)15.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"jframe_3", (Function0)16.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"jframe_4", (Function0)17.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"jframe_5", (Function0)18.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"lava_cast", (Function0)19.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"look_and_damage", (Function0)20.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"madness_1", (Function0)21.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"moon_glitch", (Function0)22.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"moon_phase", (Function0)23.INSTANCE, null, (int)4, null);
        TBSReg.INSTANCE.event("noop", 24.INSTANCE, TBSEvents::_init_$lambda$1);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"null_book", (Function0)26.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"nulled_gui", (Function0)27.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"null_interface_trigger", (Function0)28.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"null_invade_base", (Function0)29.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"nullnullnull_advancement", (Function0)30.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"null_particle", (Function0)31.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"null_scare", (Function0)32.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"null_title", (Function0)33.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"obfuscated_sign", (Function0)34.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"opengl_error", (Function0)35.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"paranoia", (Function0)36.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_all_dead", (Function0)37.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_bedrock", (Function0)38.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_cave_air", (Function0)39.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_empty", (Function0)40.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_flowing_water", (Function0)41.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_hello", (Function0)42.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_lava", (Function0)43.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_netherrack", (Function0)44.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_oak_sign", (Function0)45.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_redstone_torch", (Function0)46.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"place_water", (Function0)47.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"play_sound", (Function0)48.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"push", (Function0)49.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"random_song", (Function0)50.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"reset_rotation", (Function0)51.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"set_do_daylight_cycle", (Function0)52.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"set_on_fire", (Function0)53.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"set_random_time_of_day", (Function0)54.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"set_time", (Function0)55.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"shadow_bug", (Function0)56.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"strike_lightning", (Function0)57.INSTANCE, null, (int)4, null);
        TBSReg.INSTANCE.event("text", 58.INSTANCE, TBSEvents::_init_$lambda$2);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"why_cant_you_leave", (Function0)60.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"wrong_overlay", (Function0)61.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"hallucination", (Function0)62.INSTANCE, null, (int)4, null);
        TBSReg.INSTANCE.event("title_event", 63.INSTANCE, TBSEvents::_init_$lambda$3);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"experience", (Function0)65.INSTANCE, null, (int)4, null);
        TBSReg.INSTANCE.event("aberration", 66.INSTANCE, TBSEvents::_init_$lambda$4);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"breathe", (Function0)68.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"keep_playing", (Function0)69.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"null_whisper", (Function0)70.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"behind_you", (Function0)71.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"run", (Function0)72.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"cave", (Function0)73.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"null_is_near", (Function0)74.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"stare_at_player", (Function0)75.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"psst_event", (Function0)76.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"gamma", (Function0)77.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"null_getting_achievement", (Function0)78.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"rejoin", (Function0)79.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"sky_blue", (Function0)80.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"txt", (Function0)81.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"inventory_corruption", (Function0)82.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"door", (Function0)83.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"tbe_curious", (Function0)84.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"entity_discard", (Function0)85.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"stick", (Function0)86.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"coord", (Function0)87.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"screen_dupe", (Function0)88.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"isolation", (Function0)89.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"fake_disconnect", (Function0)90.INSTANCE, null, (int)4, null);
        BrokenReg.event$default((BrokenReg)TBSReg.INSTANCE, (String)"collinlock", (Function0)91.INSTANCE, null, (int)4, null);
    }
}

