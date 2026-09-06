/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.client.shader.PostShaderManager
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.FontManagerExtKt;
import net.thebrokenscript.brokencore.api.client.shader.PostShaderManager;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSDataAttachments;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/PlayerVarsSyncPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/data/PlayerVariables;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class PlayerVarsSyncPacket
extends EndecPacket<PlayerVarsSyncPacket, PlayerVariables> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("player_vars_sync");

    public PlayerVarsSyncPacket() {
        super(PlayerVariables.ENDEC);
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull PlayerVariables data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> PlayerVarsSyncPacket.handle$lambda$0(data));
    }

    private static final void handle$lambda$0(PlayerVariables $data) {
        block0: {
            PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/aberration.json"), $data.getCheckedAberrationEnabled());
            PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/vhs.json"), $data.getCheckedVhsEnabled());
            PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/pixelate.json"), $data.getPixelateEnabled());
            PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/glitches.json"), $data.getCheckedGlitchesEnabled());
            PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/dream.json"), $data.getCheckedDreamEnabled());
            PostShaderManager.INSTANCE.setEnabled(TBSConstants.id("shaders/post/void_box.json"), $data.getCheckedVoidBoxEnabled());
            ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)"shaders/post/invert.json");
            Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
            PostShaderManager.INSTANCE.setEnabled(resourceLocation, $data.getCheckedInvertEnabled());
            FontManagerExtKt.resetBoxes(FontManagerExtKt.getFontManager(ClientDSLKt.getMC()), Float.valueOf($data.getTextGlitchStrength()));
            LocalPlayer localPlayer = Minecraft.getInstance().player;
            if (localPlayer == null) break block0;
            EntityUtil.setData((Entity)((Entity)localPlayer), TBSDataAttachments.PLAYER_VARIABLES, (Object)$data);
        }
    }
}

