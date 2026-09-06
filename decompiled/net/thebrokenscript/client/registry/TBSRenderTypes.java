/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.DefaultVertexFormat
 *  com.mojang.blaze3d.vertex.VertexFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.RenderStateShard$OutputStateShard
 *  net.minecraft.client.renderer.RenderStateShard$ShaderStateShard
 *  net.minecraft.client.renderer.RenderType$CompositeRenderType
 *  net.minecraft.client.renderer.RenderType$CompositeState
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.client.shader.ShaderInfo
 *  net.thebrokenscript.brokencore.api.platform.PlatformRendering
 *  net.thebrokenscript.brokencore.api.render.BufferStateShard
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client.registry;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.client.shader.ShaderInfo;
import net.thebrokenscript.brokencore.api.platform.PlatformRendering;
import net.thebrokenscript.brokencore.api.render.BufferStateShard;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.mixins.client.features.vfx.RenderTypeCtors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u0010\u0010\"\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020#\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0010\u0010+\u001a\u00020,8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020,8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020,8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u000200\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u00103\u001a\u00020,8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020,8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00105\u001a\u00020,8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2={"Lnet/thebrokenscript/client/registry/TBSRenderTypes;", "", "<init>", "()V", "customEndGatewayShader", "Lnet/minecraft/client/renderer/ShaderInstance;", "getCustomEndGatewayShader", "()Lnet/minecraft/client/renderer/ShaderInstance;", "setCustomEndGatewayShader", "(Lnet/minecraft/client/renderer/ShaderInstance;)V", "exitShader", "getExitShader", "setExitShader", "fleshShader", "getFleshShader", "setFleshShader", "nameMissingShader", "getNameMissingShader", "setNameMissingShader", "window", "getWindow", "setWindow", "windowPassthrough", "getWindowPassthrough", "setWindowPassthrough", "spaceSkyShader", "getSpaceSkyShader", "setSpaceSkyShader", "limboSkyShader", "getLimboSkyShader", "setLimboSkyShader", "voidSkyShader", "getVoidSkyShader", "setVoidSkyShader", "RENDERTYPE_EXIT_SHADER", "Lnet/minecraft/client/renderer/RenderStateShard$ShaderStateShard;", "RENDERTYPE_FLESH_SHADER", "RENDERTYPE_CUSTOM_END_GATEWAY_SHADER", "RENDERTYPE_WINDOW_BUFFER_SHADER", "RENDERTYPE_NAME_MISSING_SHADER", "RENDERTYPE_WINDOW_SHADER", "getRENDERTYPE_WINDOW_SHADER", "()Lnet/minecraft/client/renderer/RenderStateShard$ShaderStateShard;", "CUSTOM_END_GATEWAY", "Lnet/minecraft/client/renderer/RenderType$CompositeRenderType;", "EXIT_SHADER", "NAME_MISSING_SHADER", "WINDOW_BUFFER_SHARD", "Lnet/thebrokenscript/brokencore/api/render/BufferStateShard;", "getWINDOW_BUFFER_SHARD", "()Lnet/thebrokenscript/brokencore/api/render/BufferStateShard;", "WINDOW_SHADER", "WINDOW_PASSTHROUGH_SHADER", "FLESH_SHADER", "thebrokenscript-common"})
public final class TBSRenderTypes {
    @NotNull
    public static final TBSRenderTypes INSTANCE = new TBSRenderTypes();
    @Nullable
    private static ShaderInstance customEndGatewayShader;
    @Nullable
    private static ShaderInstance exitShader;
    @Nullable
    private static ShaderInstance fleshShader;
    @Nullable
    private static ShaderInstance nameMissingShader;
    @Nullable
    private static ShaderInstance window;
    @Nullable
    private static ShaderInstance windowPassthrough;
    @Nullable
    private static ShaderInstance spaceSkyShader;
    @Nullable
    private static ShaderInstance limboSkyShader;
    @Nullable
    private static ShaderInstance voidSkyShader;
    @JvmField
    @NotNull
    public static final RenderStateShard.ShaderStateShard RENDERTYPE_EXIT_SHADER;
    @JvmField
    @NotNull
    public static final RenderStateShard.ShaderStateShard RENDERTYPE_FLESH_SHADER;
    @JvmField
    @NotNull
    public static final RenderStateShard.ShaderStateShard RENDERTYPE_CUSTOM_END_GATEWAY_SHADER;
    @JvmField
    @NotNull
    public static final RenderStateShard.ShaderStateShard RENDERTYPE_WINDOW_BUFFER_SHADER;
    @JvmField
    @NotNull
    public static final RenderStateShard.ShaderStateShard RENDERTYPE_NAME_MISSING_SHADER;
    @NotNull
    private static final RenderStateShard.ShaderStateShard RENDERTYPE_WINDOW_SHADER;
    @JvmField
    @NotNull
    public static final RenderType.CompositeRenderType CUSTOM_END_GATEWAY;
    @JvmField
    @NotNull
    public static final RenderType.CompositeRenderType EXIT_SHADER;
    @JvmField
    @NotNull
    public static final RenderType.CompositeRenderType NAME_MISSING_SHADER;
    @NotNull
    private static final BufferStateShard WINDOW_BUFFER_SHARD;
    @JvmField
    @NotNull
    public static final RenderType.CompositeRenderType WINDOW_SHADER;
    @JvmField
    @NotNull
    public static final RenderType.CompositeRenderType WINDOW_PASSTHROUGH_SHADER;
    @JvmField
    @NotNull
    public static final RenderType.CompositeRenderType FLESH_SHADER;

    private TBSRenderTypes() {
    }

    @Nullable
    public final ShaderInstance getCustomEndGatewayShader() {
        return customEndGatewayShader;
    }

    public final void setCustomEndGatewayShader(@Nullable ShaderInstance shaderInstance) {
        customEndGatewayShader = shaderInstance;
    }

    @Nullable
    public final ShaderInstance getExitShader() {
        return exitShader;
    }

    public final void setExitShader(@Nullable ShaderInstance shaderInstance) {
        exitShader = shaderInstance;
    }

    @Nullable
    public final ShaderInstance getFleshShader() {
        return fleshShader;
    }

    public final void setFleshShader(@Nullable ShaderInstance shaderInstance) {
        fleshShader = shaderInstance;
    }

    @Nullable
    public final ShaderInstance getNameMissingShader() {
        return nameMissingShader;
    }

    public final void setNameMissingShader(@Nullable ShaderInstance shaderInstance) {
        nameMissingShader = shaderInstance;
    }

    @Nullable
    public final ShaderInstance getWindow() {
        return window;
    }

    public final void setWindow(@Nullable ShaderInstance shaderInstance) {
        window = shaderInstance;
    }

    @Nullable
    public final ShaderInstance getWindowPassthrough() {
        return windowPassthrough;
    }

    public final void setWindowPassthrough(@Nullable ShaderInstance shaderInstance) {
        windowPassthrough = shaderInstance;
    }

    @Nullable
    public final ShaderInstance getSpaceSkyShader() {
        return spaceSkyShader;
    }

    public final void setSpaceSkyShader(@Nullable ShaderInstance shaderInstance) {
        spaceSkyShader = shaderInstance;
    }

    @Nullable
    public final ShaderInstance getLimboSkyShader() {
        return limboSkyShader;
    }

    public final void setLimboSkyShader(@Nullable ShaderInstance shaderInstance) {
        limboSkyShader = shaderInstance;
    }

    @Nullable
    public final ShaderInstance getVoidSkyShader() {
        return voidSkyShader;
    }

    public final void setVoidSkyShader(@Nullable ShaderInstance shaderInstance) {
        voidSkyShader = shaderInstance;
    }

    @NotNull
    public final RenderStateShard.ShaderStateShard getRENDERTYPE_WINDOW_SHADER() {
        return RENDERTYPE_WINDOW_SHADER;
    }

    @NotNull
    public final BufferStateShard getWINDOW_BUFFER_SHARD() {
        return WINDOW_BUFFER_SHARD;
    }

    private static final void _init_$lambda$0(ShaderInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        customEndGatewayShader = it;
    }

    private static final void _init_$lambda$1(ShaderInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        exitShader = it;
    }

    private static final void _init_$lambda$2(ShaderInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        fleshShader = it;
    }

    private static final void _init_$lambda$3(ShaderInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        nameMissingShader = it;
    }

    private static final void _init_$lambda$4(ShaderInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        window = it;
    }

    private static final void _init_$lambda$5(ShaderInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        windowPassthrough = it;
    }

    private static final void _init_$lambda$6(ShaderInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        spaceSkyShader = it;
    }

    private static final void _init_$lambda$7(ShaderInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        limboSkyShader = it;
    }

    private static final void _init_$lambda$8(ShaderInstance it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        voidSkyShader = it;
    }

    private static final ShaderInstance RENDERTYPE_EXIT_SHADER$lambda$0() {
        return exitShader;
    }

    private static final ShaderInstance RENDERTYPE_FLESH_SHADER$lambda$0() {
        return fleshShader;
    }

    private static final ShaderInstance RENDERTYPE_CUSTOM_END_GATEWAY_SHADER$lambda$0() {
        return customEndGatewayShader;
    }

    private static final ShaderInstance RENDERTYPE_WINDOW_BUFFER_SHADER$lambda$0() {
        return windowPassthrough;
    }

    private static final ShaderInstance RENDERTYPE_NAME_MISSING_SHADER$lambda$0() {
        return nameMissingShader;
    }

    private static final ShaderInstance RENDERTYPE_WINDOW_SHADER$lambda$0() {
        return window;
    }

    static {
        ResourceLocation resourceLocation = TBSConstants.id("custom_end_gateway");
        VertexFormat vertexFormat = DefaultVertexFormat.POSITION;
        Intrinsics.checkNotNullExpressionValue((Object)vertexFormat, (String)"POSITION");
        PlatformRendering.Companion.registerShader(new ShaderInfo(resourceLocation, vertexFormat), TBSRenderTypes::_init_$lambda$0);
        ResourceLocation resourceLocation2 = TBSConstants.id("exit");
        VertexFormat vertexFormat2 = DefaultVertexFormat.POSITION;
        Intrinsics.checkNotNullExpressionValue((Object)vertexFormat2, (String)"POSITION");
        PlatformRendering.Companion.registerShader(new ShaderInfo(resourceLocation2, vertexFormat2), TBSRenderTypes::_init_$lambda$1);
        ResourceLocation resourceLocation3 = TBSConstants.id("flesh");
        VertexFormat vertexFormat3 = DefaultVertexFormat.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)vertexFormat3, (String)"BLOCK");
        PlatformRendering.Companion.registerShader(new ShaderInfo(resourceLocation3, vertexFormat3), TBSRenderTypes::_init_$lambda$2);
        ResourceLocation resourceLocation4 = TBSConstants.id("name_missing");
        VertexFormat vertexFormat4 = DefaultVertexFormat.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)vertexFormat4, (String)"BLOCK");
        PlatformRendering.Companion.registerShader(new ShaderInfo(resourceLocation4, vertexFormat4), TBSRenderTypes::_init_$lambda$3);
        ResourceLocation resourceLocation5 = TBSConstants.id("window");
        VertexFormat vertexFormat5 = DefaultVertexFormat.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)vertexFormat5, (String)"BLOCK");
        PlatformRendering.Companion.registerShader(new ShaderInfo(resourceLocation5, vertexFormat5), TBSRenderTypes::_init_$lambda$4);
        ResourceLocation resourceLocation6 = TBSConstants.id("window_passthrough");
        VertexFormat vertexFormat6 = DefaultVertexFormat.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)vertexFormat6, (String)"BLOCK");
        PlatformRendering.Companion.registerShader(new ShaderInfo(resourceLocation6, vertexFormat6), TBSRenderTypes::_init_$lambda$5);
        ResourceLocation resourceLocation7 = TBSConstants.id("space_sky");
        VertexFormat vertexFormat7 = DefaultVertexFormat.POSITION;
        Intrinsics.checkNotNullExpressionValue((Object)vertexFormat7, (String)"POSITION");
        PlatformRendering.Companion.registerShader(new ShaderInfo(resourceLocation7, vertexFormat7), TBSRenderTypes::_init_$lambda$6);
        ResourceLocation resourceLocation8 = TBSConstants.id("limbo_sky");
        VertexFormat vertexFormat8 = DefaultVertexFormat.POSITION;
        Intrinsics.checkNotNullExpressionValue((Object)vertexFormat8, (String)"POSITION");
        PlatformRendering.Companion.registerShader(new ShaderInfo(resourceLocation8, vertexFormat8), TBSRenderTypes::_init_$lambda$7);
        ResourceLocation resourceLocation9 = TBSConstants.id("vortex_sky");
        VertexFormat vertexFormat9 = DefaultVertexFormat.POSITION;
        Intrinsics.checkNotNullExpressionValue((Object)vertexFormat9, (String)"POSITION");
        PlatformRendering.Companion.registerShader(new ShaderInfo(resourceLocation9, vertexFormat9), TBSRenderTypes::_init_$lambda$8);
        RENDERTYPE_EXIT_SHADER = new RenderStateShard.ShaderStateShard(TBSRenderTypes::RENDERTYPE_EXIT_SHADER$lambda$0);
        RENDERTYPE_FLESH_SHADER = new RenderStateShard.ShaderStateShard(TBSRenderTypes::RENDERTYPE_FLESH_SHADER$lambda$0);
        RENDERTYPE_CUSTOM_END_GATEWAY_SHADER = new RenderStateShard.ShaderStateShard(TBSRenderTypes::RENDERTYPE_CUSTOM_END_GATEWAY_SHADER$lambda$0);
        RENDERTYPE_WINDOW_BUFFER_SHADER = new RenderStateShard.ShaderStateShard(TBSRenderTypes::RENDERTYPE_WINDOW_BUFFER_SHADER$lambda$0);
        RENDERTYPE_NAME_MISSING_SHADER = new RenderStateShard.ShaderStateShard(TBSRenderTypes::RENDERTYPE_NAME_MISSING_SHADER$lambda$0);
        RENDERTYPE_WINDOW_SHADER = new RenderStateShard.ShaderStateShard(TBSRenderTypes::RENDERTYPE_WINDOW_SHADER$lambda$0);
        RenderType.CompositeRenderType compositeRenderType = RenderTypeCtors.tbs$create("custom_end_gateway", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 1536, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_CUSTOM_END_GATEWAY_SHADER).createCompositeState(false));
        Intrinsics.checkNotNullExpressionValue((Object)compositeRenderType, (String)"tbs$create(...)");
        CUSTOM_END_GATEWAY = compositeRenderType;
        RenderType.CompositeRenderType compositeRenderType2 = RenderTypeCtors.tbs$create("exit_shader", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 1536, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_EXIT_SHADER).createCompositeState(true));
        Intrinsics.checkNotNullExpressionValue((Object)compositeRenderType2, (String)"tbs$create(...)");
        EXIT_SHADER = compositeRenderType2;
        RenderType.CompositeRenderType compositeRenderType3 = RenderTypeCtors.tbs$create("name_missing_shader", DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 1536, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_NAME_MISSING_SHADER).createCompositeState(true));
        Intrinsics.checkNotNullExpressionValue((Object)compositeRenderType3, (String)"tbs$create(...)");
        NAME_MISSING_SHADER = compositeRenderType3;
        WINDOW_BUFFER_SHARD = new BufferStateShard("window_buffer", false, 2, null);
        RenderType.CompositeRenderType compositeRenderType4 = RenderTypeCtors.tbs$create("window_shader", DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 786432, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_WINDOW_SHADER).createCompositeState(true));
        Intrinsics.checkNotNullExpressionValue((Object)compositeRenderType4, (String)"tbs$create(...)");
        WINDOW_SHADER = compositeRenderType4;
        compositeRenderType4 = RenderTypeCtors.tbs$create("cutout_passthrough_shader", DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 786432, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_WINDOW_BUFFER_SHADER).setOutputState((RenderStateShard.OutputStateShard)WINDOW_BUFFER_SHARD).createCompositeState(false));
        Intrinsics.checkNotNullExpressionValue((Object)compositeRenderType4, (String)"tbs$create(...)");
        WINDOW_PASSTHROUGH_SHADER = compositeRenderType4;
        RenderType.CompositeRenderType compositeRenderType5 = RenderTypeCtors.tbs$create("flesh_shader", DefaultVertexFormat.BLOCK, VertexFormat.Mode.QUADS, 1536, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_FLESH_SHADER).createCompositeState(true));
        Intrinsics.checkNotNullExpressionValue((Object)compositeRenderType5, (String)"tbs$create(...)");
        FLESH_SHADER = compositeRenderType5;
    }
}

