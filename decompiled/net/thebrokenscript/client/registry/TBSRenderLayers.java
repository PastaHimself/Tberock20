/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.Holder
 *  net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayerBuilder
 *  net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.client.registry;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayerBuilder;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.registry.TBSRenderTypes;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@SideOnly(side=Side.CLIENT)
@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/client/registry/TBSRenderLayers;", "", "<init>", "()V", "thebrokenscript-common"})
public final class TBSRenderLayers {
    @NotNull
    public static final TBSRenderLayers INSTANCE = new TBSRenderLayers();

    private TBSRenderLayers() {
    }

    private static final Unit _init_$lambda$0(BlockRenderLayerBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.setId(TBSConstants.id("flesh"));
        $this$register.setRenderType((RenderType)TBSRenderTypes.FLESH_SHADER);
        $this$register.block((Holder)TBSBlocks.FLESH);
        $this$register.getUniforms().vector3f("cameraPos", TBSRenderLayers::lambda$0$0);
        return Unit.INSTANCE;
    }

    private static final Vector3fc lambda$0$0() {
        Camera cam = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        return (Vector3fc)new Vector3f(-((float)cam.getPosition().x), (float)cam.getPosition().y, -((float)cam.getPosition().z));
    }

    private static final Unit _init_$lambda$1(BlockRenderLayerBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.setId(TBSConstants.id("window"));
        $this$register.setRenderType((RenderType)TBSRenderTypes.WINDOW_SHADER);
        if (!PlatformUtil.Companion.isModLoaded("sodium")) {
            $this$register.block((Holder)TBSBlocks.INSTANCE.getGLASS_BORDER_BLOCK());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(BlockRenderLayerBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.setId(TBSConstants.id("name_missing"));
        $this$register.setRenderType((RenderType)TBSRenderTypes.NAME_MISSING_SHADER);
        $this$register.block((Holder)TBSBlocks.NAME_MISSING);
        $this$register.block((Holder)TBSBlocks.VISCERA);
        return Unit.INSTANCE;
    }

    static {
        BlockRenderLayers.INSTANCE.register(TBSRenderLayers::_init_$lambda$0);
        BlockRenderLayers.INSTANCE.register(TBSRenderLayers::_init_$lambda$1);
        BlockRenderLayers.INSTANCE.register(TBSRenderLayers::_init_$lambda$2);
    }
}

