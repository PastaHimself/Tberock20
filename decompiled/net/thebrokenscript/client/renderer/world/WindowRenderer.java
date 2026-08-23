/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.block.BlockRenderDispatcher
 *  net.minecraft.client.renderer.block.model.BakedQuad
 *  net.minecraft.client.resources.model.BakedModel
 *  net.minecraft.core.Direction
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.SlabBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.block.state.properties.SlabType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.animation.value_animation.Easing
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.client.renderer.world;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.client.registry.TBSRenderTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/client/renderer/world/WindowRenderer;", "", "<init>", "()V", "initialized", "", "cubes", "", "Lnet/thebrokenscript/client/renderer/world/WindowRenderer$FloatingCube;", "[Lnet/thebrokenscript/client/renderer/world/WindowRenderer$FloatingCube;", "init", "", "isInitialized", "accum", "", "render", "stack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "provider", "Lnet/minecraft/client/renderer/MultiBufferSource;", "TickInterpolatedVector3f", "FloatingCube", "thebrokenscript-common"})
public final class WindowRenderer {
    @NotNull
    public static final WindowRenderer INSTANCE = new WindowRenderer();
    private static boolean initialized;
    private static FloatingCube[] cubes;
    private static float accum;

    private WindowRenderer() {
    }

    public final void init() {
        if (!initialized) {
            int n = 0;
            FloatingCube[] floatingCubeArray = new FloatingCube[200];
            while (n < 200) {
                int n2 = n++;
                floatingCubeArray[n2] = new FloatingCube();
            }
            cubes = floatingCubeArray;
            initialized = true;
        }
    }

    public final boolean isInitialized() {
        return initialized;
    }

    public final void render(@NotNull PoseStack stack, @NotNull MultiBufferSource provider2) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)provider2, (String)"provider");
        if (!initialized) {
            this.init();
        }
        FloatingCube[] floatingCubeArray = cubes;
        if (cubes == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"cubes");
            floatingCubeArray = null;
        }
        for (FloatingCube cube : floatingCubeArray) {
            cube.render(stack, provider2);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0014J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/client/renderer/world/WindowRenderer$FloatingCube;", "", "<init>", "()V", "rot", "Lorg/joml/Vector3f;", "pos", "scale", "Lnet/thebrokenscript/client/renderer/world/WindowRenderer$TickInterpolatedVector3f;", "maxScale", "vel", "rotVel", "life", "", "lifespan", "", "halfPoint", "type", "Lnet/thebrokenscript/client/renderer/world/WindowRenderer$FloatingCube$Type;", "isDead", "", "()Z", "randomize", "", "tick", "init", "render", "matrices", "Lcom/mojang/blaze3d/vertex/PoseStack;", "consumer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "Type", "thebrokenscript-common"})
    @SourceDebugExtension(value={"SMAP\nWindowRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowRenderer.kt\nnet/thebrokenscript/client/renderer/world/WindowRenderer$FloatingCube\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,270:1\n1869#2,2:271\n1869#2,2:273\n*S KotlinDebug\n*F\n+ 1 WindowRenderer.kt\nnet/thebrokenscript/client/renderer/world/WindowRenderer$FloatingCube\n*L\n258#1:271,2\n263#1:273,2\n*E\n"})
    private static final class FloatingCube {
        @NotNull
        private Vector3f rot = new Vector3f(0.0f);
        @NotNull
        private Vector3f pos = new Vector3f(0.0f);
        @NotNull
        private final TickInterpolatedVector3f scale = new TickInterpolatedVector3f(0, 0, 0);
        @Nullable
        private Vector3f maxScale;
        @Nullable
        private Vector3f vel;
        @Nullable
        private Vector3f rotVel;
        private float life;
        private int lifespan;
        private int halfPoint;
        @NotNull
        private final Type type = (Type)((Object)CollectionsKt.random((Collection)((Collection)Type.getEntries()), (Random)((Random)Random.Default)));

        public FloatingCube() {
            this.randomize();
            int n = 100;
            int n2 = 0;
            while (n2 < n) {
                int it = n2++;
                boolean bl = false;
                this.tick(true);
            }
        }

        public final boolean isDead() {
            return this.life >= (float)this.lifespan;
        }

        public final void randomize() {
            this.life = 0.0f;
            this.lifespan = Mth.nextInt((RandomSource)RandomSource.create(), (int)15, (int)20);
            this.halfPoint = this.lifespan / 2;
            Vector3f pPos = new Vector3f(0.0f, 0.0f, 0.0f);
            if (ClientDSLKt.getMC().player != null) {
                LocalPlayer localPlayer = ClientDSLKt.getMC().player;
                Intrinsics.checkNotNull((Object)localPlayer);
                Vector3f vector3f = localPlayer.position().toVector3f();
                Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"toVector3f(...)");
                pPos = vector3f;
            }
            float x = Mth.nextFloat((RandomSource)RandomSource.create(), (float)-0.25f, (float)0.25f);
            float y = Mth.nextFloat((RandomSource)RandomSource.create(), (float)-12.5f, (float)-12.25f);
            float z = Mth.nextFloat((RandomSource)RandomSource.create(), (float)-0.25f, (float)0.25f);
            float s = Mth.nextFloat((RandomSource)RandomSource.create(), (float)0.5f, (float)6.0f);
            float xr = Mth.nextFloat((RandomSource)RandomSource.create(), (float)-10.0f, (float)10.0f);
            float yr = Mth.nextFloat((RandomSource)RandomSource.create(), (float)-10.0f, (float)10.0f);
            float xp = Mth.nextFloat((RandomSource)RandomSource.create(), (float)((float)-100 + pPos.x), (float)((float)100 + pPos.x));
            float yp = 100.0f + pPos.y;
            float zp = Mth.nextFloat((RandomSource)RandomSource.create(), (float)((float)-100 + pPos.z), (float)((float)100 + pPos.z));
            float xri = Mth.nextFloat((RandomSource)RandomSource.create(), (float)0.0f, (float)360.0f);
            float yri = Mth.nextFloat((RandomSource)RandomSource.create(), (float)0.0f, (float)360.0f);
            float zri = Mth.nextFloat((RandomSource)RandomSource.create(), (float)0.0f, (float)360.0f);
            this.vel = new Vector3f(x, y, z);
            this.rotVel = new Vector3f(xr, yr, 0.0f);
            this.pos = new Vector3f(xp, yp, zp);
            this.rot = new Vector3f(xri, yri, zri);
            this.maxScale = new Vector3f(s, s, s);
        }

        public final void tick(boolean init) {
            float partial = init ? 1.0f : 1.0f / (float)ClientDSLKt.getMC().getFps();
            if (partial == 1.0f && !init) {
                partial = 0.0f;
            }
            if (this.isDead()) {
                this.randomize();
                this.life = 0.0f;
                return;
            }
            this.life += partial;
            this.rot.add((Vector3fc)new Vector3f((Vector3fc)this.rotVel).mul(partial));
            this.pos.add((Vector3fc)new Vector3f((Vector3fc)this.vel).mul(partial));
            if (this.life <= (float)this.halfPoint) {
                float eased = Easing.Companion.getSINE_OUT().ease(this.life, 0.0f, 1.0f, (float)this.halfPoint);
                Vec3 vec3 = new Vec3(0.0, 0.0, 0.0);
                Vector3f vector3f = this.maxScale;
                Intrinsics.checkNotNull((Object)vector3f);
                double d = vector3f.x;
                Vector3f vector3f2 = this.maxScale;
                Intrinsics.checkNotNull((Object)vector3f2);
                double d2 = vector3f2.y;
                Vector3f vector3f3 = this.maxScale;
                Intrinsics.checkNotNull((Object)vector3f3);
                Vec3 value = vec3.lerp(new Vec3(d, d2, (double)vector3f3.z), (double)eased);
                v6 = this.scale.set(value.x, value.y, value.z);
            } else {
                float eased = Easing.Companion.getSINE_IN().ease(this.life - (float)this.halfPoint, 0.0f, 1.0f, (float)this.halfPoint);
                Vector3f vector3f = this.maxScale;
                Intrinsics.checkNotNull((Object)vector3f);
                double d = vector3f.x;
                Vector3f vector3f4 = this.maxScale;
                Intrinsics.checkNotNull((Object)vector3f4);
                double d3 = vector3f4.y;
                Vector3f vector3f5 = this.maxScale;
                Intrinsics.checkNotNull((Object)vector3f5);
                Vec3 value = new Vec3(d, d3, (double)vector3f5.z).lerp(new Vec3(0.0, 0.0, 0.0), (double)eased);
                v6 = this.scale.set(value.x, value.y, value.z);
            }
        }

        public static /* synthetic */ void tick$default(FloatingCube floatingCube, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                bl = false;
            }
            floatingCube.tick(bl);
        }

        public final void render(@NotNull PoseStack matrices, @NotNull MultiBufferSource consumer) {
            Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
            Intrinsics.checkNotNullParameter((Object)consumer, (String)"consumer");
            FloatingCube.tick$default(this, false, 1, null);
            Vector3f pos = this.pos;
            Vector3f rot = this.rot;
            matrices.pushPose();
            if (ClientDSLKt.getMC().player == null) {
                String string = "Required value was null.";
                throw new IllegalStateException(string.toString());
            }
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            Intrinsics.checkNotNull((Object)localPlayer);
            Vec3 pPos = localPlayer.getPosition(ClientDSLKt.getMC().getTimer().getGameTimeDeltaPartialTick(false));
            float scalar = 0.25f;
            Vector3f ofs = new Vector3f((float)((double)(pos.x - this.scale.x() * scalar) - pPos.x), (float)((double)(pos.y - this.scale.y() * scalar) - pPos.y), (float)((double)(pos.z - this.scale.z() * scalar) - pPos.z));
            matrices.translate(ofs.x, ofs.y, ofs.z);
            matrices.mulPose(Axis.XP.rotationDegrees(rot.x));
            matrices.mulPose(Axis.YP.rotationDegrees(rot.y));
            matrices.mulPose(Axis.ZP.rotationDegrees(rot.z));
            matrices.translate(-0.5 * (double)this.scale.x(), -0.5 * (double)this.scale.x(), -0.5 * (double)this.scale.x());
            matrices.scale(this.scale.x(), this.scale.y(), this.scale.z());
            float lightDelta = (float)Math.sin((double)(1.0f - this.life / (float)this.lifespan) * Math.PI);
            VertexConsumer buf = consumer.getBuffer((RenderType)TBSRenderTypes.WINDOW_PASSTHROUGH_SHADER);
            BlockRenderDispatcher renderer = ClientDSLKt.getMC().getBlockRenderer();
            BakedModel model2 = renderer.getBlockModel(this.type.getState());
            for (Direction dir : EntriesMappings.entries$0) {
                List list = model2.getQuads(this.type.getState(), dir, RandomSource.create((long)42L));
                Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getQuads(...)");
                Iterable $this$forEach$iv = list;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    BakedQuad it = (BakedQuad)element$iv;
                    boolean bl = false;
                    buf.putBulkData(matrices.last(), it, lightDelta, lightDelta, lightDelta, 1.0f, 0xF000F0, 0);
                }
            }
            List list = model2.getQuads(this.type.getState(), null, RandomSource.create((long)42L));
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getQuads(...)");
            Iterable $this$forEach$iv = list;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                BakedQuad it = (BakedQuad)element$iv;
                boolean bl = false;
                buf.putBulkData(matrices.last(), it, lightDelta, lightDelta, lightDelta, 1.0f, 0xF000F0, 0);
            }
            matrices.popPose();
        }

        @Metadata(mv={2, 1, 0}, k=3, xi=48)
        public static final class EntriesMappings {
            public static final /* synthetic */ EnumEntries<Direction> entries$0;

            static {
                entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
            }
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3\u00a8\u00064"}, d2={"Lnet/thebrokenscript/client/renderer/world/WindowRenderer$FloatingCube$Type;", "", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "<init>", "(Ljava/lang/String;ILnet/minecraft/world/level/block/state/BlockState;)V", "getState", "()Lnet/minecraft/world/level/block/state/BlockState;", "STONE", "PLANKS", "COBBLESTONE", "COBBLESTONE_STAIRS", "PLANK_STAIRS", "COBBLESTONE_SLAB", "PLANK_SLAB", "TORCH", "LEVER", "BUTTON", "REDSTONE_TORCH", "PRESSURE_PLATE", "TRAPDOOR", "FURNACE", "CRAFTING_TABLE", "DIRT", "LOG", "STONE_SLAB", "STONE_SLAB_DOUBLE", "COAL_ORE", "DIAMOND_ORE", "IRON_ORE", "GOLD_ORE", "REDSTONE_ORE", "WOOL", "POPPY", "DANDELION", "IRON_BLOCK", "GOLD_BLOCK", "DIAMOND_BLOCK", "GRAVEL", "OBSIDIAN", "MOSS_STONE", "STONE_BRICK", "STONE_BRICK_SLAB", "STONE_BRICK_STAIRS", "SAND", "GLASS", "SANDSTONE", "NETHERRACK", "NETHER_BRICK", "FENCE", "FENCE_GATE", "RAIL", "thebrokenscript-common"})
        public static final class Type
        extends Enum<Type> {
            @NotNull
            private final BlockState state;
            public static final /* enum */ Type STONE;
            public static final /* enum */ Type PLANKS;
            public static final /* enum */ Type COBBLESTONE;
            public static final /* enum */ Type COBBLESTONE_STAIRS;
            public static final /* enum */ Type PLANK_STAIRS;
            public static final /* enum */ Type COBBLESTONE_SLAB;
            public static final /* enum */ Type PLANK_SLAB;
            public static final /* enum */ Type TORCH;
            public static final /* enum */ Type LEVER;
            public static final /* enum */ Type BUTTON;
            public static final /* enum */ Type REDSTONE_TORCH;
            public static final /* enum */ Type PRESSURE_PLATE;
            public static final /* enum */ Type TRAPDOOR;
            public static final /* enum */ Type FURNACE;
            public static final /* enum */ Type CRAFTING_TABLE;
            public static final /* enum */ Type DIRT;
            public static final /* enum */ Type LOG;
            public static final /* enum */ Type STONE_SLAB;
            public static final /* enum */ Type STONE_SLAB_DOUBLE;
            public static final /* enum */ Type COAL_ORE;
            public static final /* enum */ Type DIAMOND_ORE;
            public static final /* enum */ Type IRON_ORE;
            public static final /* enum */ Type GOLD_ORE;
            public static final /* enum */ Type REDSTONE_ORE;
            public static final /* enum */ Type WOOL;
            public static final /* enum */ Type POPPY;
            public static final /* enum */ Type DANDELION;
            public static final /* enum */ Type IRON_BLOCK;
            public static final /* enum */ Type GOLD_BLOCK;
            public static final /* enum */ Type DIAMOND_BLOCK;
            public static final /* enum */ Type GRAVEL;
            public static final /* enum */ Type OBSIDIAN;
            public static final /* enum */ Type MOSS_STONE;
            public static final /* enum */ Type STONE_BRICK;
            public static final /* enum */ Type STONE_BRICK_SLAB;
            public static final /* enum */ Type STONE_BRICK_STAIRS;
            public static final /* enum */ Type SAND;
            public static final /* enum */ Type GLASS;
            public static final /* enum */ Type SANDSTONE;
            public static final /* enum */ Type NETHERRACK;
            public static final /* enum */ Type NETHER_BRICK;
            public static final /* enum */ Type FENCE;
            public static final /* enum */ Type FENCE_GATE;
            public static final /* enum */ Type RAIL;
            private static final /* synthetic */ Type[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            private Type(BlockState state) {
                this.state = state;
            }

            @NotNull
            public final BlockState getState() {
                return this.state;
            }

            public static Type[] values() {
                return (Type[])$VALUES.clone();
            }

            public static Type valueOf(String value) {
                return Enum.valueOf(Type.class, value);
            }

            @NotNull
            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            static {
                BlockState blockState = Blocks.STONE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"defaultBlockState(...)");
                STONE = new Type(blockState);
                BlockState blockState2 = Blocks.OAK_PLANKS.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState2, (String)"defaultBlockState(...)");
                PLANKS = new Type(blockState2);
                BlockState blockState3 = Blocks.COBBLESTONE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState3, (String)"defaultBlockState(...)");
                COBBLESTONE = new Type(blockState3);
                BlockState blockState4 = Blocks.COBBLESTONE_STAIRS.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState4, (String)"defaultBlockState(...)");
                COBBLESTONE_STAIRS = new Type(blockState4);
                BlockState blockState5 = Blocks.OAK_STAIRS.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState5, (String)"defaultBlockState(...)");
                PLANK_STAIRS = new Type(blockState5);
                BlockState blockState6 = Blocks.COBBLESTONE_SLAB.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState6, (String)"defaultBlockState(...)");
                COBBLESTONE_SLAB = new Type(blockState6);
                BlockState blockState7 = Blocks.OAK_SLAB.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState7, (String)"defaultBlockState(...)");
                PLANK_SLAB = new Type(blockState7);
                BlockState blockState8 = Blocks.TORCH.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState8, (String)"defaultBlockState(...)");
                TORCH = new Type(blockState8);
                BlockState blockState9 = Blocks.LEVER.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState9, (String)"defaultBlockState(...)");
                LEVER = new Type(blockState9);
                BlockState blockState10 = Blocks.STONE_BUTTON.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState10, (String)"defaultBlockState(...)");
                BUTTON = new Type(blockState10);
                BlockState blockState11 = Blocks.REDSTONE_TORCH.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState11, (String)"defaultBlockState(...)");
                REDSTONE_TORCH = new Type(blockState11);
                BlockState blockState12 = Blocks.STONE_PRESSURE_PLATE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState12, (String)"defaultBlockState(...)");
                PRESSURE_PLATE = new Type(blockState12);
                BlockState blockState13 = Blocks.OAK_TRAPDOOR.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState13, (String)"defaultBlockState(...)");
                TRAPDOOR = new Type(blockState13);
                BlockState blockState14 = Blocks.FURNACE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState14, (String)"defaultBlockState(...)");
                FURNACE = new Type(blockState14);
                BlockState blockState15 = Blocks.CRAFTING_TABLE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState15, (String)"defaultBlockState(...)");
                CRAFTING_TABLE = new Type(blockState15);
                BlockState blockState16 = Blocks.DIRT.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState16, (String)"defaultBlockState(...)");
                DIRT = new Type(blockState16);
                BlockState blockState17 = Blocks.OAK_LOG.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState17, (String)"defaultBlockState(...)");
                LOG = new Type(blockState17);
                BlockState blockState18 = Blocks.SMOOTH_STONE_SLAB.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState18, (String)"defaultBlockState(...)");
                STONE_SLAB = new Type(blockState18);
                Object object = Blocks.SMOOTH_STONE_SLAB.defaultBlockState().setValue((Property)SlabBlock.TYPE, (Comparable)SlabType.DOUBLE);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
                STONE_SLAB_DOUBLE = new Type((BlockState)object);
                BlockState blockState19 = Blocks.COAL_ORE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState19, (String)"defaultBlockState(...)");
                COAL_ORE = new Type(blockState19);
                BlockState blockState20 = Blocks.DIAMOND_ORE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState20, (String)"defaultBlockState(...)");
                DIAMOND_ORE = new Type(blockState20);
                BlockState blockState21 = Blocks.IRON_ORE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState21, (String)"defaultBlockState(...)");
                IRON_ORE = new Type(blockState21);
                BlockState blockState22 = Blocks.GOLD_ORE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState22, (String)"defaultBlockState(...)");
                GOLD_ORE = new Type(blockState22);
                BlockState blockState23 = Blocks.REDSTONE_ORE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState23, (String)"defaultBlockState(...)");
                REDSTONE_ORE = new Type(blockState23);
                BlockState blockState24 = Blocks.WHITE_WOOL.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState24, (String)"defaultBlockState(...)");
                WOOL = new Type(blockState24);
                BlockState blockState25 = Blocks.POPPY.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState25, (String)"defaultBlockState(...)");
                POPPY = new Type(blockState25);
                BlockState blockState26 = Blocks.DANDELION.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState26, (String)"defaultBlockState(...)");
                DANDELION = new Type(blockState26);
                BlockState blockState27 = Blocks.IRON_BLOCK.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState27, (String)"defaultBlockState(...)");
                IRON_BLOCK = new Type(blockState27);
                BlockState blockState28 = Blocks.GOLD_BLOCK.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState28, (String)"defaultBlockState(...)");
                GOLD_BLOCK = new Type(blockState28);
                BlockState blockState29 = Blocks.DIAMOND_BLOCK.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState29, (String)"defaultBlockState(...)");
                DIAMOND_BLOCK = new Type(blockState29);
                BlockState blockState30 = Blocks.GRAVEL.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState30, (String)"defaultBlockState(...)");
                GRAVEL = new Type(blockState30);
                BlockState blockState31 = Blocks.OBSIDIAN.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState31, (String)"defaultBlockState(...)");
                OBSIDIAN = new Type(blockState31);
                BlockState blockState32 = Blocks.MOSSY_COBBLESTONE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState32, (String)"defaultBlockState(...)");
                MOSS_STONE = new Type(blockState32);
                BlockState blockState33 = Blocks.STONE_BRICKS.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState33, (String)"defaultBlockState(...)");
                STONE_BRICK = new Type(blockState33);
                BlockState blockState34 = Blocks.STONE_BRICK_SLAB.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState34, (String)"defaultBlockState(...)");
                STONE_BRICK_SLAB = new Type(blockState34);
                BlockState blockState35 = Blocks.STONE_BRICK_STAIRS.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState35, (String)"defaultBlockState(...)");
                STONE_BRICK_STAIRS = new Type(blockState35);
                BlockState blockState36 = Blocks.SAND.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState36, (String)"defaultBlockState(...)");
                SAND = new Type(blockState36);
                BlockState blockState37 = Blocks.GLASS.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState37, (String)"defaultBlockState(...)");
                GLASS = new Type(blockState37);
                BlockState blockState38 = Blocks.SANDSTONE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState38, (String)"defaultBlockState(...)");
                SANDSTONE = new Type(blockState38);
                BlockState blockState39 = Blocks.NETHERRACK.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState39, (String)"defaultBlockState(...)");
                NETHERRACK = new Type(blockState39);
                BlockState blockState40 = Blocks.NETHER_BRICKS.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState40, (String)"defaultBlockState(...)");
                NETHER_BRICK = new Type(blockState40);
                BlockState blockState41 = Blocks.OAK_FENCE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState41, (String)"defaultBlockState(...)");
                FENCE = new Type(blockState41);
                BlockState blockState42 = Blocks.OAK_FENCE_GATE.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState42, (String)"defaultBlockState(...)");
                FENCE_GATE = new Type(blockState42);
                BlockState blockState43 = Blocks.RAIL.defaultBlockState();
                Intrinsics.checkNotNullExpressionValue((Object)blockState43, (String)"defaultBlockState(...)");
                RAIL = new Type(blockState43);
                $VALUES = typeArray = new Type[]{Type.STONE, Type.PLANKS, Type.COBBLESTONE, Type.COBBLESTONE_STAIRS, Type.PLANK_STAIRS, Type.COBBLESTONE_SLAB, Type.PLANK_SLAB, Type.TORCH, Type.LEVER, Type.BUTTON, Type.REDSTONE_TORCH, Type.PRESSURE_PLATE, Type.TRAPDOOR, Type.FURNACE, Type.CRAFTING_TABLE, Type.DIRT, Type.LOG, Type.STONE_SLAB, Type.STONE_SLAB_DOUBLE, Type.COAL_ORE, Type.DIAMOND_ORE, Type.IRON_ORE, Type.GOLD_ORE, Type.REDSTONE_ORE, Type.WOOL, Type.POPPY, Type.DANDELION, Type.IRON_BLOCK, Type.GOLD_BLOCK, Type.DIAMOND_BLOCK, Type.GRAVEL, Type.OBSIDIAN, Type.MOSS_STONE, Type.STONE_BRICK, Type.STONE_BRICK_SLAB, Type.STONE_BRICK_STAIRS, Type.SAND, Type.GLASS, Type.SANDSTONE, Type.NETHERRACK, Type.NETHER_BRICK, Type.FENCE, Type.FENCE_GATE, Type.RAIL};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\b\u00a2\u0006\u0004\b\u0006\u0010\tJ#\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096\u0002J#\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\fH\u0096\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/client/renderer/world/WindowRenderer$TickInterpolatedVector3f;", "Lorg/joml/Vector3f;", "x", "", "y", "z", "<init>", "(FFF)V", "", "(III)V", "previous", "set", "", "add", "v", "Lorg/joml/Vector3fc;", "thebrokenscript-common"})
    private static final class TickInterpolatedVector3f
    extends Vector3f {
        @NotNull
        private final Vector3f previous;

        public TickInterpolatedVector3f(float x, float y, float z) {
            super(x, y, z);
            this.previous = new Vector3f(x, y, z);
        }

        public TickInterpolatedVector3f(int x, int y, int z) {
            super((float)x, (float)y, (float)z);
            this.previous = new Vector3f((float)x, (float)y, (float)z);
        }

        @Nullable
        public Vector3f set(float x, float y, float z) {
            this.previous.x = this.x;
            this.previous.y = this.y;
            this.previous.z = this.z;
            return super.set(x, y, z);
        }

        @Nullable
        public Vector3f set(double x, double y, double z) {
            this.previous.x = this.x;
            this.previous.y = this.y;
            this.previous.z = this.z;
            return super.set(x, y, z);
        }

        @Nullable
        public Vector3f add(@Nullable Vector3fc v) {
            this.previous.x = this.x;
            this.previous.y = this.y;
            this.previous.z = this.z;
            return super.add(v);
        }

        public float z() {
            return Mth.lerp((float)ClientDSLKt.getMC().getTimer().getGameTimeDeltaTicks(), (float)this.previous.z, (float)this.z);
        }

        public float y() {
            return Mth.lerp((float)ClientDSLKt.getMC().getTimer().getGameTimeDeltaTicks(), (float)this.previous.y, (float)this.y);
        }

        public float x() {
            return Mth.lerp((float)ClientDSLKt.getMC().getTimer().getGameTimeDeltaTicks(), (float)this.previous.x, (float)this.x);
        }
    }
}

