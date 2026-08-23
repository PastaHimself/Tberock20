/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.client.multiplayer.PlayerInfo
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.fake;

import com.mojang.authlib.GameProfile;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0007R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/fake/ClientCustomPlayerManager;", "", "<init>", "()V", "playerInfos", "", "Ljava/util/UUID;", "Lnet/minecraft/client/multiplayer/PlayerInfo;", "getByName", "name", "", "getByUUID", "uuid", "add", "", "profile", "Lcom/mojang/authlib/GameProfile;", "remove", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nClientCustomPlayerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientCustomPlayerManager.kt\nnet/thebrokenscript/brokencore/api/fake/ClientCustomPlayerManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,27:1\n295#2,2:28\n*S KotlinDebug\n*F\n+ 1 ClientCustomPlayerManager.kt\nnet/thebrokenscript/brokencore/api/fake/ClientCustomPlayerManager\n*L\n15#1:28,2\n*E\n"})
public final class ClientCustomPlayerManager {
    @NotNull
    public static final ClientCustomPlayerManager INSTANCE = new ClientCustomPlayerManager();
    @JvmField
    @NotNull
    public static final Map<UUID, PlayerInfo> playerInfos = new LinkedHashMap();

    private ClientCustomPlayerManager() {
    }

    @JvmStatic
    @Nullable
    public static final PlayerInfo getByName(@NotNull String name) {
        Object v0;
        block1: {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Iterable $this$firstOrNull$iv = playerInfos.values();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                PlayerInfo it = (PlayerInfo)element$iv;
                boolean bl = false;
                if (!StringsKt.equals((String)it.getProfile().getName(), (String)name, (boolean)true)) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    @JvmStatic
    @Nullable
    public static final PlayerInfo getByUUID(@NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        return playerInfos.get(uuid);
    }

    @JvmStatic
    public static final void add(@NotNull GameProfile profile) {
        Intrinsics.checkNotNullParameter((Object)profile, (String)"profile");
        playerInfos.put(profile.getId(), new PlayerInfo(profile, false));
    }

    @JvmStatic
    @Nullable
    public static final PlayerInfo remove(@NotNull UUID uuid) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        return playerInfos.remove(uuid);
    }
}

