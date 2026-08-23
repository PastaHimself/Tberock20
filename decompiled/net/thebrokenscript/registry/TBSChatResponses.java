/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.thebrokenscript.brokencore.api.registry.BrokenReg
 *  net.thebrokenscript.brokencore.api.registry.builders.ChatResponseBuilder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.ChatResponseBuilder;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/registry/TBSChatResponses;", "", "<init>", "()V", "thebrokenscript-common"})
public final class TBSChatResponses {
    @NotNull
    public static final TBSChatResponses INSTANCE = new TBSChatResponses();

    private TBSChatResponses() {
    }

    private static final void _init_$lambda$0(ChatResponseBuilder $this$chatResponse) {
        Intrinsics.checkNotNullParameter((Object)$this$chatResponse, (String)"$this$chatResponse");
        $this$chatResponse.lang = "Entity303";
    }

    private static final void _init_$lambda$1(ChatResponseBuilder $this$chatResponse) {
        Intrinsics.checkNotNullParameter((Object)$this$chatResponse, (String)"$this$chatResponse");
        $this$chatResponse.lang = "Nothingiswatching";
    }

    private static final void _init_$lambda$2(ChatResponseBuilder $this$chatResponse) {
        Intrinsics.checkNotNullParameter((Object)$this$chatResponse, (String)"$this$chatResponse");
        $this$chatResponse.lang = "xXram2dieXx";
    }

    static {
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"can_you_see_me", (Function0)1.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"circuit", (Function0)2.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"clan_build", (Function0)3.INSTANCE, null, (int)4, null);
        TBSReg.INSTANCE.chatResponse("entity_303", 4.INSTANCE, TBSChatResponses::_init_$lambda$0);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"follow", (Function0)6.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"friend", (Function0)7.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"fuck_you", (Function0)8.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"hello", (Function0)9.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"herobrine", (Function0)10.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"how_can_i_help_you", (Function0)11.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"integrity", (Function0)12.INSTANCE, null, (int)4, null);
        TBSReg.INSTANCE.chatResponse("niw", 13.INSTANCE, TBSChatResponses::_init_$lambda$1);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"null", (Function0)15.INSTANCE, null, (int)4, null);
        TBSReg.INSTANCE.chatResponse("ram2die", 16.INSTANCE, TBSChatResponses::_init_$lambda$2);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"revuxor", (Function0)18.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"steve", (Function0)19.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"the_broken_end", (Function0)20.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"void", (Function0)21.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"what_do_you_want", (Function0)22.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"who_are_you", (Function0)23.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"i_am_scared", (Function0)24.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"blackout", (Function0)25.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"cal", (Function0)26.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"catfish", (Function0)27.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"overlord", (Function0)28.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"whyer", (Function0)29.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"dyexd", (Function0)30.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"null_structure_positive", (Function0)31.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"null_structure_negative", (Function0)32.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"sorry", (Function0)33.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"lucid", (Function0)34.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"clanbase_curved", (Function0)35.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"hello_structure", (Function0)36.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"fever_hello", (Function0)37.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"fever_where", (Function0)38.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"fever_what", (Function0)39.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"fever_who", (Function0)40.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"fever_insult", (Function0)41.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"fever_want", (Function0)42.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"fever_sky", (Function0)43.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"fever_homes", (Function0)44.INSTANCE, null, (int)4, null);
        BrokenReg.chatResponse$default((BrokenReg)TBSReg.INSTANCE, (String)"freebird", (Function0)45.INSTANCE, null, (int)4, null);
    }
}

