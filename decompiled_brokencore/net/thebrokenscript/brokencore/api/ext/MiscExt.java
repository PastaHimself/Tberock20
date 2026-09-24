/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.RenderTarget
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.BufferBuilder
 *  com.mojang.blaze3d.vertex.BufferUploader
 *  com.mojang.blaze3d.vertex.DefaultVertexFormat
 *  com.mojang.blaze3d.vertex.MeshData
 *  com.mojang.blaze3d.vertex.Tesselator
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.renderer.EffectInstance
 *  net.minecraft.client.renderer.GameRenderer
 *  net.minecraft.client.renderer.ItemInHandRenderer
 *  net.minecraft.client.renderer.PostChain
 *  net.minecraft.client.renderer.PostPass
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.ShaderInstance
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.DefaultedRegistry
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.HolderGetter
 *  net.minecraft.core.HolderLookup
 *  net.minecraft.core.MappedRegistry
 *  net.minecraft.core.Registry
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.IntArrayTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.nbt.Tag
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.TagKey
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionfc
 *  org.joml.Vector2f
 *  org.joml.Vector2i
 *  org.joml.Vector3d
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.joml.Vector3i
 *  org.joml.Vector4f
 *  org.joml.Vector4i
 */
package net.thebrokenscript.brokencore.api.ext;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.PostPass;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.FastColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.util.VoxelShapeTag;
import net.thebrokenscript.brokencore.impl.mixin.client.features.post.PostChainPassesAccessor;
import net.thebrokenscript.brokencore.impl.mixin.client.features.post.PostPassAccessor;
import net.thebrokenscript.brokencore.impl.mixin.features.brain.RegistryAccessor;
import net.thebrokenscript.brokencore.impl.util.InstanceConsumerGlue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionfc;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector4f;
import org.joml.Vector4i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0098\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u0002\u00a2\u0006\u0002\u0010\u0003\u001a#\u0010\u0004\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\u00a2\u0006\u0002\u0010\u0007\u001a\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0007\u001a&\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a'\u0010\u000f\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u00a2\u0006\u0002\u0010\u0010\u001a\u0018\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0007\u001a\n\u0010\u0019\u001a\u00020\u001a*\u00020\u001b\u001aN\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001d\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010\u001f\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0 2\u001e\u0010!\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0#\u0012\u0004\u0012\u0002H\u00020\"\u001a$\u0010$\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00020%\u001a\n\u0010'\u001a\u00020(*\u00020)\u001a\u0012\u0010*\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010+\u001a\u00020\u001a\u001a\u0012\u0010,\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010-\u001a\u00020\u001a\u001a\u001a\u00103\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001b\u001a\u001a\u00103\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u000206\u001a\u001a\u00103\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u000207\u001a\u001a\u00103\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u000208\u001a\u001a\u00109\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020:\u001a\u001a\u00103\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020;\u001a\u001a\u00103\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u0015\u001a\u001a\u00103\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020<\u001a\u001a\u00103\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020=\u001a\u001a\u00103\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020>\u001a\"\u0010?\u001a\u00020\u0001*\u0002002\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0012\u001a\"\u0010?\u001a\u00020\u0001*\u00020B2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0012\u001a\n\u0010K\u001a\u00020L*\u00020H\u001a<\u0010M\u001a\u00020\u0001*\u00020N2\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020:2\u0006\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020:2\b\b\u0002\u0010T\u001a\u00020:\u001ab\u0010U\u001a\u00020\u0001*\u00020N2\u0006\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\u001b2\u0006\u0010Y\u001a\u00020:2\u0006\u0010Z\u001a\u00020:2\u0006\u0010[\u001a\u00020\u001b2\u0006\u0010\\\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b\u001aZ\u0010a\u001a\u00020\u0001*\u00020N2\u0006\u0010b\u001a\u00020:2\u0006\u0010c\u001a\u00020:2\u0006\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020:2\u0006\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020:2\u0006\u0010h\u001a\u00020:2\u0006\u0010i\u001a\u00020:2\u0006\u0010j\u001a\u00020:2\u0006\u0010k\u001a\u00020:\u001aZ\u0010l\u001a\u00020\u0001*\u00020N2\u0006\u0010b\u001a\u00020:2\u0006\u0010c\u001a\u00020:2\u0006\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020:2\u0006\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020:2\u0006\u0010h\u001a\u00020:2\u0006\u0010i\u001a\u00020:2\u0006\u0010j\u001a\u00020:2\u0006\u0010k\u001a\u00020:\u001ab\u0010m\u001a\u00020\u0001*\u00020N2\u0006\u0010b\u001a\u00020:2\u0006\u0010c\u001a\u00020:2\u0006\u0010n\u001a\u00020:2\u0006\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020:2\u0006\u0010o\u001a\u00020:2\u0006\u0010g\u001a\u00020:2\u0006\u0010h\u001a\u00020:2\u0006\u0010i\u001a\u00020:2\u0006\u0010j\u001a\u00020:2\u0006\u0010k\u001a\u00020:\u001a:\u0010p\u001a\u00020\u0001*\u00020N2\u0006\u0010q\u001a\u00020:2\u0006\u0010r\u001a\u00020:2\u0006\u0010s\u001a\u00020:2\u0006\u0010t\u001a\u00020:2\u0006\u0010f\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b\u001a\\\u0010u\u001a\u00020\u0001*\u00020N2\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020:2\u0006\u0010X\u001a\u00020:2\u0006\u0010[\u001a\u00020:2\u0006\u0010\\\u001a\u00020:2\u0006\u0010P\u001a\u00020:2\u0006\u0010Q\u001a\u00020:2\u0006\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020:2\b\b\u0002\u0010T\u001a\u00020:\u001a\u0012\u0010v\u001a\u00020w*\u00020x2\u0006\u00104\u001a\u00020\u001a\u001a\u001c\u0010y\u001a\u0004\u0018\u00010z*\u00020x2\u0006\u00104\u001a\u00020\u001a2\u0006\u0010{\u001a\u00020w\u001a\u001a\u0010|\u001a\u00020}*\u00020x2\u0006\u00104\u001a\u00020\u001a2\u0006\u0010~\u001a\u00020\u007f\u001a#\u0010|\u001a\u00020}*\u00020x2\u0006\u00104\u001a\u00020\u001a2\u000f\u0010\u0080\u0001\u001a\n\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u0001\u001a\u001e\u0010\u0083\u0001\u001a\u0004\u0018\u00010z*\u00020x2\u0006\u00104\u001a\u00020\u001a2\u0007\u0010\u0084\u0001\u001a\u00020}\u001a\u0014\u0010\u0085\u0001\u001a\u00030\u0086\u0001*\u00020x2\u0006\u00104\u001a\u00020\u001a\u001a\u001e\u0010\u0087\u0001\u001a\u00030\u0088\u0001*\u00020x2\u0006\u00104\u001a\u00020\u001a2\b\u0010\u0089\u0001\u001a\u00030\u0086\u0001\u001a\"\u0010\u008a\u0001\u001a\u00030\u0086\u0001*\u00030\u0086\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u001b\u001a'\u0010\u0092\u0001\u001a\u00020\u0001*\u00030\u0086\u00012\u0013\u0010!\u001a\u000f\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0004\u0012\u00020\u00010\"H\u0086\b\u00f8\u0001\u0000\u001a\u001f\u0010\u0093\u0001\u001a\u00020\u0012*\u00020}2\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u00030\u0082\u00010\u0095\u0001H\u0086\f\u001a%\u0010\u0093\u0001\u001a\u00020\u0012*\u00020}2\u0015\u0010\u0094\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0082\u00010\u0095\u00010%H\u0086\u0004\u001a\u001e\u0010\u0096\u0001\u001a\u00020\u0012*\u00020}2\u000e\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010%H\u0086\u0004\u001a\u0012\u0010\u0098\u0001\u001a\u00020w*\t\u0012\u0005\u0012\u00030\u0086\u00010%\"\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u001b\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u001d*\u0002008F\u00a2\u0006\u0006\u001a\u0004\b1\u00102\"\u0015\u0010C\u001a\u00020D*\u00020/8F\u00a2\u0006\u0006\u001a\u0004\bE\u0010F\"\u0015\u0010G\u001a\u00020=*\u00020H8F\u00a2\u0006\u0006\u001a\u0004\bI\u0010J\"\u0016\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\" \u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u001d*\u00030\u0086\u00018F\u00a2\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0099\u0001"}, d2={"void", "", "T", "(Ljava/lang/Object;)V", "gluedApply", "cons", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "(Ljava/lang/Object;Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;)Ljava/lang/Object;", "actualRegistry", "Lnet/minecraft/core/Registry;", "Lnet/minecraft/resources/ResourceKey;", "createKey", "Lnet/minecraft/core/DefaultedRegistry;", "location", "Lnet/minecraft/resources/ResourceLocation;", "getOrNull", "(Lnet/minecraft/core/DefaultedRegistry;Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object;", "isFrozen", "", "Lnet/minecraft/core/MappedRegistry;", "vector", "Lorg/joml/Vector3f;", "Lnet/minecraft/core/Direction$Axis;", "getVector", "(Lnet/minecraft/core/Direction$Axis;)Lorg/joml/Vector3f;", "binString", "", "", "compileEach", "", "K", "V", "", "consumer", "Lkotlin/Function1;", "", "containsAny", "", "collection", "toVector3d", "Lorg/joml/Vector3d;", "Lnet/minecraft/world/phys/Vec3;", "removeSuffix", "suffix", "removePrefix", "prefix", "passes", "Lnet/minecraft/client/renderer/PostPass;", "Lnet/minecraft/client/renderer/PostChain;", "getPasses", "(Lnet/minecraft/client/renderer/PostChain;)Ljava/util/List;", "setUniform", "name", "value", "Lorg/joml/Vector2i;", "Lorg/joml/Vector3i;", "Lorg/joml/Vector4i;", "setUniformF", "", "Lorg/joml/Vector2f;", "Lorg/joml/Vector4f;", "Lorg/joml/Matrix4f;", "", "setSampler", "Lcom/mojang/blaze3d/pipeline/RenderTarget;", "depth", "Lnet/minecraft/client/renderer/ShaderInstance;", "effect", "Lnet/minecraft/client/renderer/EffectInstance;", "getEffect", "(Lnet/minecraft/client/renderer/PostPass;)Lnet/minecraft/client/renderer/EffectInstance;", "projectionMatrix", "Lnet/minecraft/client/Minecraft;", "getProjectionMatrix", "(Lnet/minecraft/client/Minecraft;)Lorg/joml/Matrix4f;", "newEntityRenderContext", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "blitFullScreen", "Lnet/minecraft/client/gui/GuiGraphics;", "sprite", "uMin", "vMin", "uMax", "vMax", "zOffset", "blit", "atlasLocation", "x", "y", "uOffset", "vOffset", "width", "height", "textureWidth", "textureHeight", "blitOffset", "color", "line", "startX", "startY", "endX", "endY", "zIndex", "thickness", "r", "g", "b", "a", "directionalTriangle", "inWorldLine", "startZ", "endZ", "fill", "minX", "minY", "maxX", "maxY", "blitSprite", "getVoxelShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "Lnet/minecraft/nbt/CompoundTag;", "putVoxelShape", "Lnet/minecraft/nbt/Tag;", "shape", "getBlockState", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "getter", "Lnet/minecraft/core/HolderGetter;", "Lnet/minecraft/world/level/block/Block;", "putBlockState", "state", "getBlockPos", "Lnet/minecraft/core/BlockPos;", "putBlockPos", "Lnet/minecraft/nbt/IntArrayTag;", "pos", "offset", "dir", "Lnet/minecraft/core/Direction;", "amount", "encasingBlockOffsetsConstant", "encasingBlockOffsets", "getEncasingBlockOffsets", "(Lnet/minecraft/core/BlockPos;)Ljava/util/List;", "forEachEncasing", "of", "tag", "Lnet/minecraft/tags/TagKey;", "ofAny", "blocks", "toVoxelShape", "brokencore-common"})
@JvmName(name="MiscExt")
@SourceDebugExtension(value={"SMAP\nMiscExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiscExt.kt\nnet/thebrokenscript/brokencore/api/ext/MiscExt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,372:1\n1#2:373\n216#3,2:374\n1869#4,2:376\n1869#4,2:378\n1869#4,2:380\n1869#4,2:382\n1869#4,2:384\n1869#4,2:386\n1869#4,2:388\n1869#4,2:390\n1869#4,2:392\n1869#4,2:394\n1869#4,2:396\n1869#4,2:398\n1869#4,2:400\n1869#4,2:402\n*S KotlinDebug\n*F\n+ 1 MiscExt.kt\nnet/thebrokenscript/brokencore/api/ext/MiscExt\n*L\n94#1:374,2\n102#1:376,2\n129#1:378,2\n133#1:380,2\n137#1:382,2\n141#1:384,2\n145#1:386,2\n149#1:388,2\n153#1:390,2\n157#1:392,2\n161#1:394,2\n165#1:396,2\n169#1:398,2\n348#1:400,2\n367#1:402,2\n*E\n"})
public final class MiscExt {
    @NotNull
    private static final List<BlockPos> encasingBlockOffsetsConstant;

    public static final <T> void void(T $this$void) {
    }

    public static final <T> T gluedApply(T $this$gluedApply, @NotNull InstanceConsumer<T> cons) {
        T t;
        Intrinsics.checkNotNullParameter(cons, (String)"cons");
        T $this$gluedApply_u24lambda_u240 = t = $this$gluedApply;
        boolean bl = false;
        InstanceConsumerGlue.accept($this$gluedApply_u24lambda_u240, cons);
        return t;
    }

    @SideOnly(side=Side.SERVER)
    @NotNull
    public static final <T> Registry<T> actualRegistry(@NotNull ResourceKey<T> $this$actualRegistry) {
        Intrinsics.checkNotNullParameter($this$actualRegistry, (String)"<this>");
        Object object = BuiltInRegistries.REGISTRY.get($this$actualRegistry.registry());
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type net.minecraft.core.Registry<T of net.thebrokenscript.brokencore.api.ext.MiscExt.actualRegistry>");
        return (Registry)object;
    }

    @SideOnly(side=Side.SERVER)
    @NotNull
    public static final <T> ResourceKey<T> createKey(@NotNull DefaultedRegistry<T> $this$createKey, @NotNull ResourceLocation location) {
        Intrinsics.checkNotNullParameter($this$createKey, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        ResourceKey resourceKey = ResourceKey.create((ResourceKey)$this$createKey.key(), (ResourceLocation)location);
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"create(...)");
        return resourceKey;
    }

    @SideOnly(side=Side.SERVER)
    @Nullable
    public static final <T> T getOrNull(@NotNull DefaultedRegistry<T> $this$getOrNull, @NotNull ResourceLocation location) {
        Intrinsics.checkNotNullParameter($this$getOrNull, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        return (T)$this$getOrNull.get(MiscExt.createKey($this$getOrNull, location));
    }

    @SideOnly(side=Side.SERVER)
    public static final <T> boolean isFrozen(@NotNull MappedRegistry<T> $this$isFrozen) {
        Intrinsics.checkNotNullParameter($this$isFrozen, (String)"<this>");
        return ((RegistryAccessor)$this$isFrozen).bc$isFrozen();
    }

    @NotNull
    public static final Vector3f getVector(@NotNull Direction.Axis $this$vector) {
        Intrinsics.checkNotNullParameter((Object)$this$vector, (String)"<this>");
        return switch (WhenMappings.$EnumSwitchMapping$0[$this$vector.ordinal()]) {
            case 1 -> new Vector3f(1.0f, 0.0f, 0.0f);
            case 2 -> new Vector3f(0.0f, 1.0f, 0.0f);
            case 3 -> new Vector3f(0.0f, 0.0f, 1.0f);
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    @NotNull
    public static final String binString(int $this$binString) {
        if ($this$binString == 0) {
            return "0";
        }
        Object str = "";
        for (int i = $this$binString; i != 0; i >>= 1) {
            int value = i & 1;
            str = (String)str + value;
        }
        return ((Object)StringsKt.reversed((CharSequence)((CharSequence)str))).toString();
    }

    @NotNull
    public static final <K, V, T> List<T> compileEach(@NotNull Map<K, ? extends V> $this$compileEach, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends T> consumer) {
        Intrinsics.checkNotNullParameter($this$compileEach, (String)"<this>");
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        List list = new ArrayList();
        Map<K, V> $this$forEach$iv = $this$compileEach;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<K, V>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, ? extends V> element$iv;
            Map.Entry<K, ? extends V> it = element$iv = iterator.next();
            boolean bl = false;
            list.add(consumer.invoke(it));
        }
        return CollectionsKt.toList((Iterable)list);
    }

    public static final <T> boolean containsAny(@NotNull Collection<? extends T> $this$containsAny, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter($this$containsAny, (String)"<this>");
        Intrinsics.checkNotNullParameter(collection, (String)"collection");
        boolean passed = false;
        Iterable $this$forEach$iv = collection;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.iterator();
        while (iterator.hasNext()) {
            Object element$iv;
            Object it = element$iv = iterator.next();
            boolean bl = false;
            if (!$this$containsAny.contains(it)) continue;
            passed = true;
        }
        return passed;
    }

    @NotNull
    public static final Vector3d toVector3d(@NotNull Vec3 $this$toVector3d) {
        Intrinsics.checkNotNullParameter((Object)$this$toVector3d, (String)"<this>");
        return new Vector3d($this$toVector3d.x, $this$toVector3d.y, $this$toVector3d.z);
    }

    @NotNull
    public static final ResourceLocation removeSuffix(@NotNull ResourceLocation $this$removeSuffix, @NotNull String suffix) {
        Intrinsics.checkNotNullParameter((Object)$this$removeSuffix, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)suffix, (String)"suffix");
        String string = $this$removeSuffix.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        ResourceLocation resourceLocation = $this$removeSuffix.withPath(StringsKt.removeSuffix((String)string, (CharSequence)suffix));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withPath(...)");
        return resourceLocation;
    }

    @NotNull
    public static final ResourceLocation removePrefix(@NotNull ResourceLocation $this$removePrefix, @NotNull String prefix) {
        Intrinsics.checkNotNullParameter((Object)$this$removePrefix, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        String string = $this$removePrefix.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        ResourceLocation resourceLocation = $this$removePrefix.withPath(StringsKt.removePrefix((String)string, (CharSequence)prefix));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withPath(...)");
        return resourceLocation;
    }

    @NotNull
    public static final List<PostPass> getPasses(@NotNull PostChain $this$passes) {
        Intrinsics.checkNotNullParameter((Object)$this$passes, (String)"<this>");
        List<PostPass> list = ((PostChainPassesAccessor)$this$passes).brokencore$getPasses();
        Intrinsics.checkNotNullExpressionValue(list, (String)"brokencore$getPasses(...)");
        return list;
    }

    public static final void setUniform(@NotNull PostChain $this$setUniform, @NotNull String name, int value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniform);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value);
        }
    }

    public static final void setUniform(@NotNull PostChain $this$setUniform, @NotNull String name, @NotNull Vector2i value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniform);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value.x, value.y);
        }
    }

    public static final void setUniform(@NotNull PostChain $this$setUniform, @NotNull String name, @NotNull Vector3i value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniform);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value.x, value.y, value.z);
        }
    }

    public static final void setUniform(@NotNull PostChain $this$setUniform, @NotNull String name, @NotNull Vector4i value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniform);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value.x, value.y, value.z, value.w);
        }
    }

    public static final void setUniformF(@NotNull PostChain $this$setUniformF, @NotNull String name, float value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniformF, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniformF);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value);
        }
    }

    public static final void setUniform(@NotNull PostChain $this$setUniform, @NotNull String name, @NotNull Vector2f value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniform);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value.x, value.y);
        }
    }

    public static final void setUniform(@NotNull PostChain $this$setUniform, @NotNull String name, @NotNull Vector3f value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniform);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value.x, value.y, value.z);
        }
    }

    public static final void setUniform(@NotNull PostChain $this$setUniform, @NotNull String name, @NotNull Vector4f value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniform);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value.x, value.y, value.z, value.w);
        }
    }

    public static final void setUniform(@NotNull PostChain $this$setUniform, @NotNull String name, @NotNull Matrix4f value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniform);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value);
        }
    }

    public static final void setUniform(@NotNull PostChain $this$setUniform, @NotNull String name, @NotNull float[] value) {
        Intrinsics.checkNotNullParameter((Object)$this$setUniform, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setUniform);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().safeGetUniform(name).set(value);
        }
    }

    public static final void setSampler(@NotNull PostChain $this$setSampler, @NotNull String name, @NotNull RenderTarget value, boolean depth) {
        Intrinsics.checkNotNullParameter((Object)$this$setSampler, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Iterable $this$forEach$iv = MiscExt.getPasses($this$setSampler);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            PostPass it = (PostPass)element$iv;
            boolean bl = false;
            it.getEffect().setSampler(name, () -> MiscExt.setSampler$lambda$0$0(depth, value));
        }
    }

    public static final void setSampler(@NotNull ShaderInstance $this$setSampler, @NotNull String name, @NotNull RenderTarget value, boolean depth) {
        Intrinsics.checkNotNullParameter((Object)$this$setSampler, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        $this$setSampler.setSampler(name, (Object)(depth ? value.getDepthTextureId() : value.getColorTextureId()));
    }

    @NotNull
    public static final EffectInstance getEffect(@NotNull PostPass $this$effect) {
        Intrinsics.checkNotNullParameter((Object)$this$effect, (String)"<this>");
        EffectInstance effectInstance = ((PostPassAccessor)$this$effect).brokencore$getEffect();
        Intrinsics.checkNotNullExpressionValue((Object)effectInstance, (String)"brokencore$getEffect(...)");
        return effectInstance;
    }

    @NotNull
    public static final Matrix4f getProjectionMatrix(@NotNull Minecraft $this$projectionMatrix) {
        Intrinsics.checkNotNullParameter((Object)$this$projectionMatrix, (String)"<this>");
        return new Matrix4f((Matrix4fc)RenderSystem.getProjectionMatrix());
    }

    @NotNull
    public static final EntityRendererProvider.Context newEntityRenderContext(@NotNull Minecraft $this$newEntityRenderContext) {
        Intrinsics.checkNotNullParameter((Object)$this$newEntityRenderContext, (String)"<this>");
        return new EntityRendererProvider.Context(ClientDSLKt.getMC().getEntityRenderDispatcher(), ClientDSLKt.getMC().getItemRenderer(), ClientDSLKt.getMC().getBlockRenderer(), new ItemInHandRenderer(ClientDSLKt.getMC(), ClientDSLKt.getMC().getEntityRenderDispatcher(), ClientDSLKt.getMC().getItemRenderer()), ClientDSLKt.getMC().getResourceManager(), ClientDSLKt.getMC().getEntityModels(), ClientDSLKt.getMC().font);
    }

    public static final void blitFullScreen(@NotNull GuiGraphics $this$blitFullScreen, @NotNull ResourceLocation sprite, float uMin, float vMin, float uMax, float vMax, float zOffset) {
        Intrinsics.checkNotNullParameter((Object)$this$blitFullScreen, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        int window = ClientDSLKt.getMC().getWindow().getGuiScaledWidth();
        MiscExt.blitSprite($this$blitFullScreen, sprite, 0.0f, 0.0f, $this$blitFullScreen.guiWidth(), $this$blitFullScreen.guiHeight(), uMin, vMin, uMax, vMax, zOffset);
    }

    public static /* synthetic */ void blitFullScreen$default(GuiGraphics guiGraphics, ResourceLocation resourceLocation, float f, float f2, float f3, float f4, float f5, int n, Object object) {
        if ((n & 0x20) != 0) {
            f5 = 0.0f;
        }
        MiscExt.blitFullScreen(guiGraphics, resourceLocation, f, f2, f3, f4, f5);
    }

    public static final void blit(@NotNull GuiGraphics $this$blit, @NotNull ResourceLocation atlasLocation, int x, int y, float uOffset, float vOffset, int width, int height, int textureWidth, int textureHeight, int blitOffset, int color) {
        Intrinsics.checkNotNullParameter((Object)$this$blit, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)atlasLocation, (String)"atlasLocation");
        float minU = uOffset / (float)textureWidth;
        float minV = vOffset / (float)textureHeight;
        float maxU = (uOffset + (float)width) / (float)textureWidth;
        float maxV = (vOffset + (float)height) / (float)textureHeight;
        int x2 = x + width;
        int y2 = y + height;
        RenderSystem.enableBlend();
        RenderSystem.setShaderTexture((int)0, (ResourceLocation)atlasLocation);
        RenderSystem.setShader(MiscExt::blit$lambda$0);
        Matrix4f matrix4f = $this$blit.pose().last().pose();
        BufferBuilder buf = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        buf.addVertex(matrix4f, (float)x, (float)y, (float)blitOffset).setUv(minU, minV).setColor(color);
        buf.addVertex(matrix4f, (float)x, (float)y2, (float)blitOffset).setUv(minU, maxV).setColor(color);
        buf.addVertex(matrix4f, (float)x2, (float)y2, (float)blitOffset).setUv(maxU, maxV).setColor(color);
        buf.addVertex(matrix4f, (float)x2, (float)y, (float)blitOffset).setUv(maxU, minV).setColor(color);
        BufferUploader.drawWithShader((MeshData)buf.buildOrThrow());
        RenderSystem.disableBlend();
    }

    public static final void line(@NotNull GuiGraphics $this$line, float startX, float startY, float endX, float endY, int zIndex, float thickness, float r, float g, float b, float a) {
        Intrinsics.checkNotNullParameter((Object)$this$line, (String)"<this>");
        Vector2f vec = new Vector2f(startX, startY);
        float l = vec.distance(endX, endY);
        Matrix4f mat = new Matrix4f((Matrix4fc)$this$line.pose().last().pose());
        int color = FastColor.ARGB32.colorFromFloat((float)a, (float)r, (float)g, (float)b);
        VertexConsumer buf = $this$line.bufferSource().getBuffer(RenderType.gui());
        mat.translate(startX, startY, 0.0f);
        mat.rotate((Quaternionfc)Axis.ZP.rotation((float)Math.atan2(endY - startY, endX - startX)));
        float minY = thickness * -0.25f;
        float maxY = thickness * 0.25f;
        buf.addVertex(mat, 0.0f, minY, (float)zIndex).setColor(color);
        buf.addVertex(mat, 0.0f, maxY, (float)zIndex).setColor(color);
        buf.addVertex(mat, l, maxY, (float)zIndex).setColor(color);
        buf.addVertex(mat, l, minY, (float)zIndex).setColor(color);
        $this$line.bufferSource().endBatch(RenderType.gui());
    }

    public static final void directionalTriangle(@NotNull GuiGraphics $this$directionalTriangle, float startX, float startY, float endX, float endY, int zIndex, float thickness, float r, float g, float b, float a) {
        Intrinsics.checkNotNullParameter((Object)$this$directionalTriangle, (String)"<this>");
        Vector2f vec = new Vector2f(startX, startY);
        float l = vec.distance(endX, endY);
        Matrix4f mat = new Matrix4f((Matrix4fc)$this$directionalTriangle.pose().last().pose());
        int color = FastColor.ARGB32.colorFromFloat((float)a, (float)r, (float)g, (float)b);
        VertexConsumer buf = $this$directionalTriangle.bufferSource().getBuffer(RenderType.gui());
        mat.translate(startX, startY, 0.0f);
        mat.rotate((Quaternionfc)Axis.ZP.rotation((float)Math.atan2(endY - startY, endX - startX)));
        float minY = thickness * -0.25f;
        float maxY = thickness * 0.25f;
        buf.addVertex(mat, 0.0f, minY, (float)zIndex).setColor(color);
        buf.addVertex(mat, 0.0f, maxY, (float)zIndex).setColor(color);
        buf.addVertex(mat, l, maxY / 8.0f, (float)zIndex).setColor(color);
        buf.addVertex(mat, l, minY / 8.0f, (float)zIndex).setColor(color);
        $this$directionalTriangle.bufferSource().endBatch(RenderType.gui());
    }

    public static final void inWorldLine(@NotNull GuiGraphics $this$inWorldLine, float startX, float startY, float startZ, float endX, float endY, float endZ, float thickness, float r, float g, float b, float a) {
        Intrinsics.checkNotNullParameter((Object)$this$inWorldLine, (String)"<this>");
        Matrix4f mat = ClientMixinBridge.INSTANCE.getWorldModelMatrix(ClientDSLKt.getMC()).mul((Matrix4fc)ClientMixinBridge.INSTANCE.getWorldProjectionMatrix(ClientDSLKt.getMC()));
        int color = FastColor.ARGB32.colorFromFloat((float)a, (float)r, (float)g, (float)b);
        VertexConsumer buf = $this$inWorldLine.bufferSource().getBuffer(RenderType.lines());
        Vector3f start = new Vector3f(startX, startY, startZ);
        Vector3f end = new Vector3f(endX, endY, endZ);
        Vector3f normalStart = new Vector3f((Vector3fc)end).sub((Vector3fc)start).normalize();
        Vector3f normalEnd = new Vector3f((Vector3fc)start).sub((Vector3fc)end).normalize();
        float oldWidth = RenderSystem.getShaderLineWidth();
        RenderSystem.lineWidth((float)thickness);
        buf.addVertex(mat, startX, startY, startZ).setColor(color).setNormal(normalStart.x, normalStart.y, normalStart.z);
        buf.addVertex(mat, endX, endY, endZ).setColor(color).setNormal(normalEnd.x, normalEnd.y, normalEnd.z);
        $this$inWorldLine.bufferSource().endBatch();
        RenderSystem.lineWidth((float)oldWidth);
    }

    public static final void fill(@NotNull GuiGraphics $this$fill, float minX, float minY, float maxX, float maxY, int zIndex, int color) {
        Intrinsics.checkNotNullParameter((Object)$this$fill, (String)"<this>");
        Matrix4f mat = new Matrix4f((Matrix4fc)$this$fill.pose().last().pose());
        VertexConsumer buf = $this$fill.bufferSource().getBuffer(RenderType.gui());
        buf.addVertex(mat, minX, minY, (float)zIndex).setColor(color);
        buf.addVertex(mat, minX, maxY, (float)zIndex).setColor(color);
        buf.addVertex(mat, maxX, maxY, (float)zIndex).setColor(color);
        buf.addVertex(mat, maxX, minY, (float)zIndex).setColor(color);
        $this$fill.flush();
    }

    public static final void blitSprite(@NotNull GuiGraphics $this$blitSprite, @NotNull ResourceLocation sprite, float x, float y, float width, float height, float uMin, float vMin, float uMax, float vMax, float zOffset) {
        Intrinsics.checkNotNullParameter((Object)$this$blitSprite, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        float x2 = x + width;
        float y2 = y + height;
        TextureAtlasSprite spr = ClientDSLKt.getMC().getGuiSprites().getSprite(sprite);
        float uMin2 = spr.getU(uMin);
        float uMax2 = spr.getU(uMax);
        float vMin2 = spr.getV(vMin);
        float vMax2 = spr.getV(vMax);
        RenderSystem.setShaderTexture((int)0, (ResourceLocation)spr.atlasLocation());
        RenderSystem.setShader(MiscExt::blitSprite$lambda$0);
        Matrix4f matrix4f = $this$blitSprite.pose().last().pose();
        Intrinsics.checkNotNullExpressionValue((Object)matrix4f, (String)"pose(...)");
        Matrix4f matrix4f2 = matrix4f;
        BufferBuilder buff = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        buff.addVertex(matrix4f2, x, y, zOffset).setUv(uMin2, vMin2);
        buff.addVertex(matrix4f2, x, y2, zOffset).setUv(uMin2, vMax2);
        buff.addVertex(matrix4f2, x2, y2, zOffset).setUv(uMax2, vMax2);
        buff.addVertex(matrix4f2, x2, y, zOffset).setUv(uMax2, vMin2);
        BufferUploader.drawWithShader((MeshData)buff.buildOrThrow());
    }

    public static /* synthetic */ void blitSprite$default(GuiGraphics guiGraphics, ResourceLocation resourceLocation, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, Object object) {
        if ((n & 0x200) != 0) {
            f9 = 0.0f;
        }
        MiscExt.blitSprite(guiGraphics, resourceLocation, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    @NotNull
    public static final VoxelShape getVoxelShape(@NotNull CompoundTag $this$getVoxelShape, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)$this$getVoxelShape, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        long[] lArray = $this$getVoxelShape.getLongArray(name);
        Intrinsics.checkNotNullExpressionValue((Object)lArray, (String)"getLongArray(...)");
        return new VoxelShapeTag(lArray).getShape();
    }

    @Nullable
    public static final Tag putVoxelShape(@NotNull CompoundTag $this$putVoxelShape, @NotNull String name, @NotNull VoxelShape shape) {
        Intrinsics.checkNotNullParameter((Object)$this$putVoxelShape, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)shape, (String)"shape");
        return $this$putVoxelShape.put(name, (Tag)new VoxelShapeTag(shape));
    }

    @NotNull
    public static final BlockState getBlockState(@NotNull CompoundTag $this$getBlockState, @NotNull String name, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)$this$getBlockState, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        HolderLookup holderLookup = level.holderLookup(Registries.BLOCK);
        Intrinsics.checkNotNullExpressionValue((Object)holderLookup, (String)"holderLookup(...)");
        return MiscExt.getBlockState($this$getBlockState, name, (HolderGetter<Block>)((HolderGetter)holderLookup));
    }

    @NotNull
    public static final BlockState getBlockState(@NotNull CompoundTag $this$getBlockState, @NotNull String name, @NotNull HolderGetter<Block> getter) {
        Intrinsics.checkNotNullParameter((Object)$this$getBlockState, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        BlockState blockState = NbtUtils.readBlockState(getter, (CompoundTag)$this$getBlockState.getCompound(name));
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"readBlockState(...)");
        return blockState;
    }

    @Nullable
    public static final Tag putBlockState(@NotNull CompoundTag $this$putBlockState, @NotNull String name, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)$this$putBlockState, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return $this$putBlockState.put(name, (Tag)NbtUtils.writeBlockState((BlockState)state));
    }

    @NotNull
    public static final BlockPos getBlockPos(@NotNull CompoundTag $this$getBlockPos, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)$this$getBlockPos, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Object t = NbtUtils.readBlockPos((CompoundTag)$this$getBlockPos, (String)name).get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        return (BlockPos)t;
    }

    @NotNull
    public static final IntArrayTag putBlockPos(@NotNull CompoundTag $this$putBlockPos, @NotNull String name, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)$this$putBlockPos, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Tag tag = $this$putBlockPos.put(name, NbtUtils.writeBlockPos((BlockPos)pos));
        Intrinsics.checkNotNull((Object)tag, (String)"null cannot be cast to non-null type net.minecraft.nbt.IntArrayTag");
        return (IntArrayTag)tag;
    }

    @NotNull
    public static final BlockPos offset(@NotNull BlockPos $this$offset, @NotNull Direction dir, int amount) {
        Intrinsics.checkNotNullParameter((Object)$this$offset, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        BlockPos blockPos = $this$offset.offset(dir.getNormal().multiply(amount));
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
        return blockPos;
    }

    public static /* synthetic */ BlockPos offset$default(BlockPos blockPos, Direction direction, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 1;
        }
        return MiscExt.offset(blockPos, direction, n);
    }

    @NotNull
    public static final List<BlockPos> getEncasingBlockOffsets(@NotNull BlockPos $this$encasingBlockOffsets) {
        Intrinsics.checkNotNullParameter((Object)$this$encasingBlockOffsets, (String)"<this>");
        return encasingBlockOffsetsConstant;
    }

    public static final void forEachEncasing(@NotNull BlockPos $this$forEachEncasing, @NotNull Function1<? super BlockPos, Unit> consumer) {
        Intrinsics.checkNotNullParameter((Object)$this$forEachEncasing, (String)"<this>");
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        boolean $i$f$forEachEncasing = false;
        Iterable $this$forEach$iv = MiscExt.getEncasingBlockOffsets($this$forEachEncasing);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            BlockPos it = (BlockPos)element$iv;
            boolean bl = false;
            BlockPos blockPos = $this$forEachEncasing.offset((Vec3i)it);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
            consumer.invoke((Object)blockPos);
        }
    }

    public static final boolean of(@NotNull BlockState $this$of, @NotNull TagKey<Block> tag) {
        Intrinsics.checkNotNullParameter((Object)$this$of, (String)"<this>");
        Intrinsics.checkNotNullParameter(tag, (String)"tag");
        boolean $i$f$of = false;
        return $this$of.is(tag);
    }

    public static final boolean of(@NotNull BlockState $this$of, @NotNull Collection<TagKey<Block>> tag) {
        Intrinsics.checkNotNullParameter((Object)$this$of, (String)"<this>");
        Intrinsics.checkNotNullParameter(tag, (String)"tag");
        for (TagKey<Block> key : tag) {
            if (!$this$of.is(key)) continue;
            return true;
        }
        return false;
    }

    public static final boolean ofAny(@NotNull BlockState $this$ofAny, @NotNull Collection<? extends Block> blocks) {
        Intrinsics.checkNotNullParameter((Object)$this$ofAny, (String)"<this>");
        Intrinsics.checkNotNullParameter(blocks, (String)"blocks");
        for (Block block2 : blocks) {
            if (!$this$ofAny.is(block2)) continue;
            return true;
        }
        return false;
    }

    @NotNull
    public static final VoxelShape toVoxelShape(@NotNull Collection<? extends BlockPos> $this$toVoxelShape) {
        Intrinsics.checkNotNullParameter($this$toVoxelShape, (String)"<this>");
        VoxelShape shape = null;
        shape = Shapes.empty();
        Iterable $this$forEach$iv = $this$toVoxelShape;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            BlockPos it = (BlockPos)element$iv;
            boolean bl = false;
            shape = Shapes.or((VoxelShape)shape, (VoxelShape)Shapes.create((AABB)new AABB(it)));
        }
        VoxelShape voxelShape = shape;
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"element");
        return voxelShape;
    }

    private static final int setSampler$lambda$0$0(boolean $depth, RenderTarget $value) {
        return $depth ? $value.getDepthTextureId() : $value.getColorTextureId();
    }

    private static final ShaderInstance blit$lambda$0() {
        return GameRenderer.getPositionTexColorShader();
    }

    private static final ShaderInstance blitSprite$lambda$0() {
        return GameRenderer.getPositionTexShader();
    }

    static {
        Object[] objectArray = new BlockPos[]{new BlockPos(-1, -1, -1), new BlockPos(-1, -1, 0), new BlockPos(-1, -1, 1), new BlockPos(0, -1, -1), new BlockPos(0, -1, 0), new BlockPos(0, -1, 1), new BlockPos(1, -1, -1), new BlockPos(1, -1, 0), new BlockPos(1, -1, 1), new BlockPos(-1, 0, -1), new BlockPos(-1, 0, 0), new BlockPos(-1, 0, 1), new BlockPos(0, 0, -1), new BlockPos(0, 0, 1), new BlockPos(1, 0, -1), new BlockPos(1, 0, 0), new BlockPos(1, 0, 1), new BlockPos(-1, 1, -1), new BlockPos(-1, 1, 0), new BlockPos(-1, 1, 1), new BlockPos(0, 1, -1), new BlockPos(0, 1, 0), new BlockPos(0, 1, 1), new BlockPos(1, 1, -1), new BlockPos(1, 1, 0), new BlockPos(1, 1, 1)};
        encasingBlockOffsetsConstant = CollectionsKt.listOf((Object[])objectArray);
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Direction.Axis.values().length];
            try {
                nArray[Direction.Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

