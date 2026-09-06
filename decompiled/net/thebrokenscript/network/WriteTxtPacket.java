/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.HexExtensionsKt
 *  kotlin.text.HexFormat
 *  kotlin.text.StringsKt
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.client.server.IntegratedServer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.files.UserDirs
 *  net.thebrokenscript.brokencore.api.network.ActionPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlin.text.StringsKt;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.files.UserDirs;
import net.thebrokenscript.brokencore.api.network.ActionPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/network/WriteTxtPacket;", "Lnet/thebrokenscript/brokencore/api/network/ActionPacket;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class WriteTxtPacket
extends ActionPacket<WriteTxtPacket> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("write");

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(WriteTxtPacket::handle$lambda$0);
    }

    private static final void handle$lambda$0() {
        ClientLevel clientLevel = ClientDSLKt.getMC().level;
        if (clientLevel == null) {
            return;
        }
        ClientLevel level = clientLevel;
        int cx = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)level).getMazeFloorX(), 16) * 16 + 8;
        int cz = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)level).getMazeFloorZ(), 16) * 16 + 8;
        String content = "=) \n\nX: " + HexExtensionsKt.toHexString((int)cx, (HexFormat)HexFormat.Companion.getUpperCase()) + " \n\nZ: " + HexExtensionsKt.toHexString((int)cz, (HexFormat)HexFormat.Companion.getUpperCase()) + " \n\n CV";
        String levelName = null;
        if (ClientDSLKt.getMC().isLocalServer()) {
            IntegratedServer integratedServer = ClientDSLKt.getMC().getSingleplayerServer();
            Intrinsics.checkNotNull((Object)integratedServer);
            String string = integratedServer.getWorldData().getLevelName();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getLevelName(...)");
            levelName = string;
        } else {
            ServerData serverData = ClientDSLKt.getMC().getCurrentServer();
            Intrinsics.checkNotNull((Object)serverData);
            String string = serverData.name;
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"name");
            levelName = string;
        }
        String name = HexExtensionsKt.toHexString((byte[])StringsKt.encodeToByteArray((String)"Floor2"), (HexFormat)HexFormat.Companion.getUpperCase()) + " " + levelName;
        try {
            File directory = FilesKt.resolve((File)UserDirs.Companion.home(), (String)"Unknown");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            FilesKt.writeText$default((File)FilesKt.resolve((File)directory, (String)name), (String)content, null, (int)2, null);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

