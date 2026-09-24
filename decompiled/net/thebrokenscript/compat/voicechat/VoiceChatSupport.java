/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.maxhenkel.voicechat.voice.client.GroupChatManager
 *  de.maxhenkel.voicechat.voice.common.PlayerState
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.compat.voicechat;

import de.maxhenkel.voicechat.voice.client.GroupChatManager;
import de.maxhenkel.voicechat.voice.common.PlayerState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005H\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/compat/voicechat/VoiceChatSupport;", "", "<init>", "()V", "getGroupMembers", "", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nVoiceChatSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceChatSupport.kt\nnet/thebrokenscript/compat/voicechat/VoiceChatSupport\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,12:1\n1563#2:13\n1634#2,3:14\n*S KotlinDebug\n*F\n+ 1 VoiceChatSupport.kt\nnet/thebrokenscript/compat/voicechat/VoiceChatSupport\n*L\n10#1:13\n10#1:14,3\n*E\n"})
public final class VoiceChatSupport {
    @NotNull
    public static final VoiceChatSupport INSTANCE = new VoiceChatSupport();

    private VoiceChatSupport() {
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    @SideOnly(side=Side.CLIENT)
    @NotNull
    public static final List<UUID> getGroupMembers() {
        void var3_3;
        void $this$mapTo$iv$iv;
        List list = GroupChatManager.getGroupMembers();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getGroupMembers(...)");
        Iterable $this$map$iv = list;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            PlayerState playerState = (PlayerState)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getUuid());
        }
        return (List)var3_3;
    }
}

