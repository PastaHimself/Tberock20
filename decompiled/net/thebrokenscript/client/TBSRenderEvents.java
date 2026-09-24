/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.shaders.Uniform
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.client.renderer.PostChain
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents
 *  net.thebrokenscript.brokencore.api.client.event.RenderEvents$LevelStageData
 *  net.thebrokenscript.brokencore.api.client.event.RenderStage
 *  net.thebrokenscript.brokencore.api.client.shader.PostShaderManager
 *  net.thebrokenscript.brokencore.api.client.shader.PostShaderManager$PostShaderReloadListener
 *  net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge
 *  net.thebrokenscript.brokencore.api.client.util.ClientTickTimer
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.event.GameEvent
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents
 *  net.thebrokenscript.brokencore.api.event.game.PlayerEvents$BlockHitSoundEmit
 *  net.thebrokenscript.brokencore.api.ext.LevelExtKt
 *  net.thebrokenscript.brokencore.api.ext.MiscExt
 *  net.thebrokenscript.brokencore.api.render.BufferStateShard
 *  net.thebrokenscript.brokencore.api.util.PreciseBlockHitResult
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.client;

import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.client.event.RenderStage;
import net.thebrokenscript.brokencore.api.client.shader.PostShaderManager;
import net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge;
import net.thebrokenscript.brokencore.api.client.util.ClientTickTimer;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.event.game.PlayerEvents;
import net.thebrokenscript.brokencore.api.ext.LevelExtKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.render.BufferStateShard;
import net.thebrokenscript.brokencore.api.util.PreciseBlockHitResult;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.Stage2PreciseYLevels;
import net.thebrokenscript.client.registry.TBSRenderTypes;
import net.thebrokenscript.client.renderer.world.WindowRenderer;
import net.thebrokenscript.client.util.RenderUtil;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.entity.fractured.attacks.JimShockwaveType;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\u0015\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0000\u00a2\u0006\u0002\b-J%\u0010.\u001a\u00020)2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0010H\u0000\u00a2\u0006\u0002\b1J \u00102\u001a\u00020)2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0005H\u0002J \u00107\u001a\u00020)2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0005H\u0002J\u0018\u00108\u001a\u00020)2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0013H\u0002J\b\u00109\u001a\u00020)H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010>\u001a\u00020)2\u0006\u0010<\u001a\u00020=2\u0006\u0010?\u001a\u00020\u000eH\u0002J\u0010\u0010@\u001a\u00020\u00162\u0006\u0010<\u001a\u00020=H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR!\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010A\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2={"Lnet/thebrokenscript/client/TBSRenderEvents;", "", "<init>", "()V", "d", "", "ticks", "", "lastW", "lastH", "rippleTicks", "shockwaveTicks", "shockwaveRadius", "shouldUpdateRipple", "", "shockwaveType", "Lnet/thebrokenscript/entity/fractured/attacks/JimShockwaveType;", "shouldUpdateShockwave", "hitPos", "Lorg/joml/Vector3f;", "shockwavePos", "ripple", "Lnet/minecraft/client/renderer/PostChain;", "getRipple", "()Lnet/minecraft/client/renderer/PostChain;", "setRipple", "(Lnet/minecraft/client/renderer/PostChain;)V", "voidBox", "getVoidBox", "setVoidBox", "shockwave", "getShockwave", "setShockwave", "validUpdateBlocks", "", "Lnet/minecraft/world/level/block/Block;", "getValidUpdateBlocks", "()Ljava/util/List;", "validUpdateBlocks$delegate", "Lkotlin/Lazy;", "tick", "", "updateRipplePos", "pos", "Lnet/minecraft/world/phys/Vec3;", "updateRipplePos$thebrokenscript_common", "updateShockwavePos", "radius", "type", "updateShockwavePos$thebrokenscript_common", "updateRipple", "inverseMat", "Lorg/joml/Matrix4f;", "camPos", "partialTick", "updateShockwave", "updateVoidBox", "updateBufferSizes", "postId", "Lnet/minecraft/resources/ResourceLocation;", "name", "", "enabled", "v", "get", "RIPPLE_TIME", "SHOCKWAVE_TIME", "thebrokenscript-common"})
public final class TBSRenderEvents {
    @NotNull
    public static final TBSRenderEvents INSTANCE = new TBSRenderEvents();
    private static float d;
    private static int ticks;
    private static int lastW;
    private static int lastH;
    private static volatile float rippleTicks;
    private static volatile float shockwaveTicks;
    private static volatile float shockwaveRadius;
    private static volatile boolean shouldUpdateRipple;
    @NotNull
    private static volatile JimShockwaveType shockwaveType;
    private static volatile boolean shouldUpdateShockwave;
    @NotNull
    private static final Vector3f hitPos;
    @NotNull
    private static final Vector3f shockwavePos;
    public static PostChain ripple;
    public static PostChain voidBox;
    public static PostChain shockwave;
    @NotNull
    private static final Lazy validUpdateBlocks$delegate;
    public static final int RIPPLE_TIME = 4;
    public static final int SHOCKWAVE_TIME = 10;

    private TBSRenderEvents() {
    }

    @NotNull
    public final PostChain getRipple() {
        PostChain postChain = ripple;
        if (postChain != null) {
            return postChain;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"ripple");
        return null;
    }

    public final void setRipple(@NotNull PostChain postChain) {
        Intrinsics.checkNotNullParameter((Object)postChain, (String)"<set-?>");
        ripple = postChain;
    }

    @NotNull
    public final PostChain getVoidBox() {
        PostChain postChain = voidBox;
        if (postChain != null) {
            return postChain;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"voidBox");
        return null;
    }

    public final void setVoidBox(@NotNull PostChain postChain) {
        Intrinsics.checkNotNullParameter((Object)postChain, (String)"<set-?>");
        voidBox = postChain;
    }

    @NotNull
    public final PostChain getShockwave() {
        PostChain postChain = shockwave;
        if (postChain != null) {
            return postChain;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"shockwave");
        return null;
    }

    public final void setShockwave(@NotNull PostChain postChain) {
        Intrinsics.checkNotNullParameter((Object)postChain, (String)"<set-?>");
        shockwave = postChain;
    }

    private final List<Block> getValidUpdateBlocks() {
        Lazy lazy = validUpdateBlocks$delegate;
        return (List)lazy.getValue();
    }

    private final void tick() {
        ClientLevel clientLevel = ClientDSLKt.getMC().level;
        if (clientLevel == null) {
            TBSRenderEvents $this$tick_u24lambda_u240 = this;
            boolean bl = false;
            $this$tick_u24lambda_u240.enabled("ripple", false);
            return;
        }
        ClientLevel level = clientLevel;
        ResourceKey dim = level.dimension();
        this.enabled("ripple", Intrinsics.areEqual((Object)dim, TBSDimensions.CLAN_VOID));
        this.enabled("shockwave", !Intrinsics.areEqual((Object)dim, TBSDimensions.STAGE2));
        Object object = ClientDSLKt.getMC().player;
        this.enabled("void_box", (object != null && (object = PlayerExt.INSTANCE.getVars((Player)object)) != null ? ((PlayerVariables)object).getCheckedVoidBoxEnabled() : false) && Intrinsics.areEqual((Object)dim, TBSDimensions.STAGE2));
        int n = ticks;
        ticks = n + 1;
    }

    public final void updateRipplePos$thebrokenscript_common(@NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        rippleTicks = 4.0f;
        hitPos.set((Vector3fc)pos.toVector3f());
        shouldUpdateRipple = true;
    }

    public final void updateShockwavePos$thebrokenscript_common(@NotNull Vec3 pos, float radius, @NotNull JimShockwaveType type) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        shockwaveTicks = 10.0f;
        shockwavePos.set((Vector3fc)pos.toVector3f());
        shouldUpdateShockwave = true;
        shockwaveType = type;
        shockwaveRadius = radius * (float)2;
    }

    private final void updateRipple(Matrix4f inverseMat, Vector3f camPos, float partialTick) {
        MiscExt.setUniform((PostChain)this.getRipple(), (String)"InverseTransformMatrix", (Matrix4f)inverseMat);
        if (shouldUpdateRipple) {
            MiscExt.setUniform((PostChain)this.getRipple(), (String)"HitPos", (Vector3f)hitPos);
            shouldUpdateRipple = false;
        }
        MiscExt.setUniformF((PostChain)this.getRipple(), (String)"Time", (float)((float)ticks / 4.0f));
        MiscExt.setUniform((PostChain)this.getRipple(), (String)"CameraPos", (Vector3f)camPos);
        if (rippleTicks > 0.0f) {
            this.getRipple().setUniform("RippleDelta", 1.0f - rippleTicks / (float)4);
        } else {
            this.getRipple().setUniform("RippleDelta", 0.0f);
        }
    }

    private final void updateShockwave(Matrix4f inverseMat, Vector3f camPos, float partialTick) {
        MiscExt.setUniform((PostChain)this.getShockwave(), (String)"InverseTransformMatrix", (Matrix4f)inverseMat);
        if (shouldUpdateShockwave) {
            MiscExt.setUniform((PostChain)this.getShockwave(), (String)"HitPos", (Vector3f)shockwavePos);
            shouldUpdateShockwave = false;
            this.getShockwave().setUniform("Radius", shockwaveRadius);
        }
        this.getShockwave().setUniform("Time", (float)ticks / 4.0f);
        MiscExt.setUniform((PostChain)this.getShockwave(), (String)"CameraPos", (Vector3f)camPos);
        if (shockwaveTicks > 0.0f) {
            this.getShockwave().setUniform("RippleDelta", 1.0f - shockwaveTicks / (float)10);
        } else {
            this.getShockwave().setUniform("RippleDelta", 0.0f);
        }
    }

    private final void updateVoidBox(Matrix4f inverseMat, Vector3f camPos) {
        ClientLevel clientLevel = ClientDSLKt.getMC().level;
        if (Intrinsics.areEqual((Object)(clientLevel != null ? clientLevel.dimension() : null), TBSDimensions.STAGE2)) {
            MiscExt.setUniform((PostChain)this.getVoidBox(), (String)"InverseTransformMatrix", (Matrix4f)inverseMat);
            MiscExt.setUniformF((PostChain)this.getVoidBox(), (String)"T", (float)(d / 100.0f));
            MiscExt.setUniform((PostChain)this.getVoidBox(), (String)"CameraPos", (Vector3f)camPos);
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            Intrinsics.checkNotNull((Object)localPlayer);
            Stage2PreciseYLevels stage2PreciseYLevels = Stage2PreciseYLevels.Companion.fromY(localPlayer.getEyeY());
            if (stage2PreciseYLevels == null) {
                return;
            }
            Stage2PreciseYLevels floor = stage2PreciseYLevels;
            Vector3f minPos = new Vector3f(16.0f, (float)((Number)((Object)floor.getYRange().getStart())).doubleValue(), 16.0f);
            Vector3f maxPos = new Vector3f(160.0f, (float)((Number)((Object)floor.getYRange().getEndInclusive())).doubleValue(), 160.0f);
            MiscExt.setUniform((PostChain)this.getVoidBox(), (String)"MinBounds", (Vector3f)minPos);
            MiscExt.setUniform((PostChain)this.getVoidBox(), (String)"MaxBounds", (Vector3f)maxPos);
        }
    }

    private final void updateBufferSizes() {
        int w = ClientDSLKt.getMC().getWindow().getWidth();
        int h = ClientDSLKt.getMC().getWindow().getHeight();
        if (w != lastW || h != lastH) {
            this.getVoidBox().resize(w, h);
            this.getRipple().resize(w, h);
            this.getShockwave().resize(w, h);
            lastW = w;
            lastH = h;
        }
    }

    private final ResourceLocation postId(String name) {
        return TBSConstants.id("shaders/post/" + name + ".json");
    }

    private final void enabled(String name, boolean v) {
        PostShaderManager.INSTANCE.setEnabled(this.postId(name), v);
    }

    private final PostChain get(String name) {
        PostChain postChain = PostShaderManager.INSTANCE.get(this.postId(name));
        Intrinsics.checkNotNull((Object)postChain);
        return postChain;
    }

    private static final List validUpdateBlocks_delegate$lambda$0() {
        Object[] objectArray = new Block[]{TBSBlocks.INSTANCE.getCOBBLESTONE_BORDER_BLOCK().invoke(), TBSBlocks.INSTANCE.getFLOOR_BORDER_BLOCK().invoke(), TBSBlocks.INSTANCE.getSTONE_BORDER_BLOCK().invoke(), TBSBlocks.INSTANCE.getSTONE_SLAB_BORDER_BLOCK().invoke(), TBSBlocks.INSTANCE.getDIRT_BORDER_BLOCK().invoke()};
        return CollectionsKt.listOf((Object[])objectArray);
    }

    private static final Unit _init_$lambda$0() {
        INSTANCE.setRipple(INSTANCE.get("ripple"));
        INSTANCE.setVoidBox(INSTANCE.get("void_box"));
        INSTANCE.setShockwave(INSTANCE.get("shockwave"));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(int n, float f, Minecraft mc) {
        Intrinsics.checkNotNullParameter((Object)mc, (String)"mc");
        if (!mc.isPaused()) {
            INSTANCE.tick();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(PlayerEvents.BlockHitSoundEmit $this$on) {
        block1: {
            PreciseBlockHitResult precise;
            Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
            if (!INSTANCE.getValidUpdateBlocks().contains($this$on.getState().getBlock())) {
                return Unit.INSTANCE;
            }
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            Intrinsics.checkNotNull((Object)localPlayer);
            LocalPlayer player = localPlayer;
            Vec3 from = player.getEyePosition(ClientDSLKt.getMC().getTimer().getGameTimeDeltaPartialTick(false));
            Vector3f vector3f = new Vector3f((Vector3fc)ClientDSLKt.getMC().gameRenderer.getMainCamera().getLookVector()).mul((float)player.getAttributes().getValue(Attributes.BLOCK_INTERACTION_RANGE));
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"mul(...)");
            Vec3 to = PositionUtil.toVec3((Vector3fc)((Vector3fc)vector3f)).add(from);
            PreciseBlockHitResult preciseBlockHitResult = precise = LevelExtKt.clipPrecise((Level)$this$on.getLevel(), (ClipContext)new ClipContext(from, to, ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, (Entity)player));
            if (preciseBlockHitResult == null) break block1;
            PreciseBlockHitResult precise2 = preciseBlockHitResult;
            boolean bl = false;
            INSTANCE.updateRipplePos$thebrokenscript_common(precise2.getHitPos());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$3(RenderEvents.LevelStageData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        INSTANCE.updateBufferSizes();
        if ($this$on.getStage() == RenderStage.AFTER_LEVEL) {
            if (rippleTicks > 0.0f) {
                rippleTicks -= 20.0f / (float)ClientDSLKt.getMC().getFps();
            }
            if (shockwaveTicks > 0.0f) {
                shockwaveTicks -= 20.0f / (float)ClientDSLKt.getMC().getFps();
            }
        }
        float partialTick = ClientDSLKt.getMC().getTimer().getGameTimeDeltaPartialTick(false);
        Vector3f cameraPosition = ClientDSLKt.getMC().gameRenderer.getMainCamera().getPosition().toVector3f();
        Matrix4f inverseMat = RenderUtil.INSTANCE.getInverseTransformMatrix(new Matrix4f());
        Intrinsics.checkNotNull((Object)cameraPosition);
        INSTANCE.updateRipple(inverseMat, cameraPosition, partialTick);
        INSTANCE.updateVoidBox(inverseMat, cameraPosition);
        INSTANCE.updateShockwave(inverseMat, cameraPosition, partialTick);
        if ($this$on.getStage() == RenderStage.AFTER_CUTOUT_BLOCKS) {
            ShaderInstance shaderInstance = TBSRenderTypes.INSTANCE.getWindowPassthrough();
            Intrinsics.checkNotNull((Object)shaderInstance);
            shaderInstance.setSampler("Sampler0", (Object)ClientDSLKt.getMC().getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS).getId());
            PoseStack poseStack = $this$on.getPoseStack();
            MultiBufferSource.BufferSource bufferSource = $this$on.getBufs().bufferSource();
            Intrinsics.checkNotNullExpressionValue((Object)bufferSource, (String)"bufferSource(...)");
            WindowRenderer.INSTANCE.render(poseStack, (MultiBufferSource)bufferSource);
            BufferStateShard bufferStateShard = TBSRenderTypes.INSTANCE.getWINDOW_BUFFER_SHARD();
            ShaderInstance shaderInstance2 = TBSRenderTypes.INSTANCE.getWindow();
            Intrinsics.checkNotNull((Object)shaderInstance2);
            bufferStateShard.setDiffuseSampler("Passthrough", shaderInstance2);
            ShaderInstance shaderInstance3 = TBSRenderTypes.INSTANCE.getWindowPassthrough();
            Intrinsics.checkNotNull((Object)shaderInstance3);
            Uniform uniform = shaderInstance3.getUniform("ProjMat");
            Intrinsics.checkNotNull((Object)uniform);
            uniform.set(ClientMixinBridge.INSTANCE.getWorldProjectionMatrix(ClientDSLKt.getMC()));
            d += ClientDSLKt.getMC().getTimer().getGameTimeDeltaTicks();
        }
        return Unit.INSTANCE;
    }

    static {
        shockwaveRadius = 5.0f;
        shockwaveType = JimShockwaveType.STOMP;
        hitPos = new Vector3f(0.0f);
        shockwavePos = new Vector3f(0.0f);
        validUpdateBlocks$delegate = LazyKt.lazy(TBSRenderEvents::validUpdateBlocks_delegate$lambda$0);
        PostShaderManager.PostShaderReloadListener.INSTANCE.subscribe(TBSRenderEvents::_init_$lambda$0);
        ClientTickTimer timer = new ClientTickTimer();
        timer.loop = true;
        timer.start(1);
        timer.doOnTick(TBSRenderEvents::_init_$lambda$1);
        GameEvent.Companion.on(PlayerEvents.BLOCK_HITSOUND_EMIT, TBSRenderEvents::_init_$lambda$2);
        GameEvent.Companion.on(RenderEvents.LEVEL_STAGE, TBSRenderEvents::_init_$lambda$3);
    }
}

