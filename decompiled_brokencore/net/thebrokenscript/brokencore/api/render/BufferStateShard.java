/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.TextureTarget
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.RenderStateShard$OutputStateShard
 *  net.minecraft.client.renderer.ShaderInstance
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.render;

import com.mojang.blaze3d.pipeline.TextureTarget;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.ShaderInstance;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B/\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/render/BufferStateShard;", "Lnet/minecraft/client/renderer/RenderStateShard$OutputStateShard;", "name", "", "buffer", "Lcom/mojang/blaze3d/pipeline/TextureTarget;", "userProvided", "", "clear", "<init>", "(Ljava/lang/String;Lcom/mojang/blaze3d/pipeline/TextureTarget;ZZ)V", "(Ljava/lang/String;Lcom/mojang/blaze3d/pipeline/TextureTarget;Z)V", "(Ljava/lang/String;Z)V", "setDiffuseSampler", "", "shaderInstance", "Lnet/minecraft/client/renderer/ShaderInstance;", "setDepthSampler", "Companion", "brokencore-common"})
public final class BufferStateShard
extends RenderStateShard.OutputStateShard {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final TextureTarget buffer;
    @NotNull
    private static final List<Function2<Integer, Integer, Unit>> shards = new ArrayList();

    private BufferStateShard(String name, TextureTarget buffer, boolean userProvided, boolean clear) {
        super(name, () -> BufferStateShard._init_$lambda$0(buffer, clear), () -> BufferStateShard._init_$lambda$1(buffer));
        this.buffer = buffer;
        if (!userProvided) {
            shards.add((Function2<Integer, Integer, Unit>)((Function2)(arg_0, arg_1) -> BufferStateShard._init_$lambda$2(buffer, arg_0, arg_1)));
        }
    }

    /* synthetic */ BufferStateShard(String string, TextureTarget textureTarget, boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            bl = false;
        }
        if ((n & 8) != 0) {
            bl2 = true;
        }
        this(string, textureTarget, bl, bl2);
    }

    public BufferStateShard(@NotNull String name, @NotNull TextureTarget buffer, boolean clear) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        this(name, buffer, true, clear);
    }

    public /* synthetic */ BufferStateShard(String string, TextureTarget textureTarget, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            bl = true;
        }
        this(string, textureTarget, bl);
    }

    public BufferStateShard(@NotNull String name, boolean clear) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        int x = PlatformUtil.Companion.isDataGen() ? 1 : ClientDSLKt.getMC().getWindow().getWidth();
        int y = PlatformUtil.Companion.isDataGen() ? 1 : ClientDSLKt.getMC().getWindow().getHeight();
        this(name, PlatformUtil.Companion.isDataGen() ? null : new TextureTarget(x, y, true, true), false, clear);
    }

    public /* synthetic */ BufferStateShard(String string, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = true;
        }
        this(string, bl);
    }

    public final void setDiffuseSampler(@NotNull String name, @NotNull ShaderInstance shaderInstance) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)shaderInstance, (String)"shaderInstance");
        TextureTarget textureTarget = this.buffer;
        Intrinsics.checkNotNull((Object)textureTarget);
        shaderInstance.setSampler(name, (Object)textureTarget.getColorTextureId());
    }

    public final void setDepthSampler(@NotNull String name, @NotNull ShaderInstance shaderInstance) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)shaderInstance, (String)"shaderInstance");
        TextureTarget textureTarget = this.buffer;
        Intrinsics.checkNotNull((Object)textureTarget);
        shaderInstance.setSampler(name, (Object)textureTarget.getDepthTextureId());
    }

    private static final void _init_$lambda$0(TextureTarget $buffer, boolean $clear) {
        block1: {
            TextureTarget textureTarget = $buffer;
            if (textureTarget == null) break block1;
            TextureTarget it = textureTarget;
            boolean bl = false;
            if ($clear) {
                $buffer.clear(true);
            }
            $buffer.bindWrite(false);
            $buffer.bindRead();
        }
    }

    private static final void _init_$lambda$1(TextureTarget $buffer) {
        block0: {
            TextureTarget textureTarget = $buffer;
            if (textureTarget == null) break block0;
            TextureTarget it = textureTarget;
            boolean bl = false;
            $buffer.unbindRead();
            $buffer.unbindWrite();
            ClientDSLKt.getMC().getMainRenderTarget().bindWrite(true);
        }
    }

    private static final Unit _init_$lambda$2(TextureTarget $buffer, int w, int h) {
        block1: {
            if (w == 0 || h == 0) break block1;
            TextureTarget textureTarget = $buffer;
            if (textureTarget != null) {
                textureTarget.resize(w, h, true);
            }
        }
        return Unit.INSTANCE;
    }

    @ForceRuntimeInit
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003RJ\u0010\u0004\u001a8\u00124\u00122\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/render/BufferStateShard$Companion;", "", "<init>", "()V", "shards", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "w", "h", "", "getShards$brokencore_common", "()Ljava/util/List;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List<Function2<Integer, Integer, Unit>> getShards$brokencore_common() {
            return shards;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

