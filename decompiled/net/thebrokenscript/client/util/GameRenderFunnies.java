/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderTarget
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.util;

import com.mojang.blaze3d.pipeline.RenderTarget;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.client.util.RenderTargetExtKt;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/client/util/GameRenderFunnies;", "", "<init>", "()V", "onPostRender", "", "thebrokenscript-common"})
public final class GameRenderFunnies {
    @NotNull
    public static final GameRenderFunnies INSTANCE = new GameRenderFunnies();

    private GameRenderFunnies() {
    }

    @JvmStatic
    public static final void onPostRender() {
        int xc;
        int x;
        Object object = ClientDSLKt.getMC().player;
        if (!(object != null && (object = PlayerExt.INSTANCE.getVars((Player)object)) != null ? ((PlayerVariables)object).getEnableScreenDupe() : false)) {
            return;
        }
        int w = ClientDSLKt.getMC().getWindow().getWidth();
        int h = ClientDSLKt.getMC().getWindow().getHeight();
        int xSize = 40;
        int ySize = 40;
        int n = w;
        int n2 = n / xSize;
        if ((n ^ xSize) < 0 && n2 * xSize != n) {
            --n2;
        }
        if ((x = 1) <= (xc = n2)) {
            while (true) {
                RenderTarget renderTarget = ClientDSLKt.getMC().getMainRenderTarget();
                Intrinsics.checkNotNullExpressionValue((Object)renderTarget, (String)"getMainRenderTarget(...)");
                RenderTargetExtKt.blitToScreenAt$default(renderTarget, x * xSize, -x * ySize, w, h, false, 16, null);
                if (x == xc) break;
                ++x;
            }
        }
    }
}

