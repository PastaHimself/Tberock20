/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.fake;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.fake.FakePlayer;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.impl.registry.BCPackets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tH\u0007\u00a2\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0006H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0006H\u0007R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/fake/CustomPlayerManager;", "", "<init>", "()V", "customPlayers", "", "Ljava/util/UUID;", "Lnet/minecraft/server/level/ServerPlayer;", "names", "", "", "kotlin.jvm.PlatformType", "()[Ljava/lang/String;", "getByName", "name", "getByUUID", "uuid", "add", "Lnet/thebrokenscript/brokencore/api/fake/FakePlayer;", "level", "Lnet/minecraft/server/level/ServerLevel;", "profile", "Lcom/mojang/authlib/GameProfile;", "remove", "", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCustomPlayerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomPlayerManager.kt\nnet/thebrokenscript/brokencore/api/fake/CustomPlayerManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,35:1\n1563#2:36\n1634#2,3:37\n295#2,2:42\n37#3,2:40\n*S KotlinDebug\n*F\n+ 1 CustomPlayerManager.kt\nnet/thebrokenscript/brokencore/api/fake/CustomPlayerManager\n*L\n15#1:36\n15#1:37,3\n19#1:42,2\n15#1:40,2\n*E\n"})
public final class CustomPlayerManager {
    @NotNull
    public static final CustomPlayerManager INSTANCE = new CustomPlayerManager();
    @JvmField
    @NotNull
    public static final Map<UUID, ServerPlayer> customPlayers = new LinkedHashMap();

    private CustomPlayerManager() {
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    @NotNull
    public static final String[] names() {
        void var3_3;
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = customPlayers.values();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ServerPlayer serverPlayer = (ServerPlayer)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getGameProfile().getName());
        }
        Collection $this$toTypedArray$iv = (List)var3_3;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        return thisCollection$iv.toArray(new String[0]);
    }

    @JvmStatic
    @Nullable
    public static final ServerPlayer getByName(@NotNull String name) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Iterable $this$firstOrNull$iv = customPlayers.values();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                ServerPlayer it = (ServerPlayer)element$iv;
                boolean bl = false;
                if (!StringsKt.equals((String)it.getGameProfile().getName(), (String)name, (boolean)true)) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    @JvmStatic
    @Nullable
    public static final ServerPlayer getByUUID(@NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        return customPlayers.get(uuid);
    }

    @JvmStatic
    @NotNull
    public static final FakePlayer add(@NotNull ServerLevel level, @NotNull GameProfile profile) {
        FakePlayer fakePlayer;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)profile, (String)"profile");
        FakePlayer it = fakePlayer = new FakePlayer(level, profile);
        boolean bl = false;
        customPlayers.put(profile.getId(), it);
        PacketSender.INSTANCE.sendToAllPlayers((CustomPacketPayload)BCPackets.ADD_FAKE_PLAYER.of(profile), new CustomPacketPayload[0]);
        return fakePlayer;
    }

    @JvmStatic
    public static final void remove(@NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        ServerPlayer serverPlayer = customPlayers.remove(uuid);
        if (serverPlayer != null) {
            serverPlayer.discard();
        }
        PacketSender.INSTANCE.sendToAllPlayers((CustomPacketPayload)BCPackets.REMOVE_FAKE_PLAYER.of(uuid), new CustomPacketPayload[0]);
    }
}

