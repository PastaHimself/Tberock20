/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KFunction
 *  net.minecraft.client.model.PlayerModel
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType$Builder
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobCategory
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.thebrokenscript.brokencore.api.client.renderer.BasicTexturedRenderer
 *  net.thebrokenscript.brokencore.api.client.renderer.BasicTexturedRenderer$Companion
 *  net.thebrokenscript.brokencore.api.dsl.AttributeUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeBuilderExt
 *  net.thebrokenscript.brokencore.api.registry.builders.EntityBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.EntityEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseFeverEntity;
import net.thebrokenscript.api.entity.ai.anomaly2.SubAnomaly2Ai;
import net.thebrokenscript.brokencore.api.client.renderer.BasicTexturedRenderer;
import net.thebrokenscript.brokencore.api.dsl.AttributeUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.EntityTypeBuilderExt;
import net.thebrokenscript.brokencore.api.registry.builders.EntityBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.EntityEntry;
import net.thebrokenscript.client.renderer.entity.entnull.NullRenderer;
import net.thebrokenscript.entity.DeceiverEntity;
import net.thebrokenscript.entity.FarawayEntity;
import net.thebrokenscript.entity.HerobrineEntity;
import net.thebrokenscript.entity.NameTagEntity;
import net.thebrokenscript.entity.NoTextureEntity;
import net.thebrokenscript.entity.NullCodEntity;
import net.thebrokenscript.entity.StareEntity;
import net.thebrokenscript.entity.anomaly.sa1.SubAnomaly1Entity;
import net.thebrokenscript.entity.anomaly.sa2.SubAnomaly2Entity;
import net.thebrokenscript.entity.boss.ChordEntity;
import net.thebrokenscript.entity.boss.ChordProjectileEntity;
import net.thebrokenscript.entity.boss.TetherEntity;
import net.thebrokenscript.entity.boss.VoidTentacleEntity;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import net.thebrokenscript.entity.circuit.CircuitMineshaftFleeEntity;
import net.thebrokenscript.entity.circuit.CircuitMineshaftStareEntity;
import net.thebrokenscript.entity.circuit.CircuitMineshaftWalkEntity;
import net.thebrokenscript.entity.circuit.CircuitStalkEntity;
import net.thebrokenscript.entity.circuit.CircuitStareEntity;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.entity.fractured.FracturedRoamEntity;
import net.thebrokenscript.entity.fractured.RockEntity;
import net.thebrokenscript.entity.integrity.IntegrityCuriousEntity;
import net.thebrokenscript.entity.integrity.phase1.IntegrityPhase1Entity;
import net.thebrokenscript.entity.integrity.phase2.IntegrityPhase2Entity;
import net.thebrokenscript.entity.integrity.phase3.IntegFireballEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityP3GroundArmEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import net.thebrokenscript.entity.maze.MazeShadowsEntity;
import net.thebrokenscript.entity.misc.BanEntity;
import net.thebrokenscript.entity.misc.CaveSoundEntity;
import net.thebrokenscript.entity.misc.ChunkRemoverEntity;
import net.thebrokenscript.entity.misc.CorruptionEntity;
import net.thebrokenscript.entity.misc.JonEntity;
import net.thebrokenscript.entity.misc.MurderfurEntity;
import net.thebrokenscript.entity.misc.NothingWatcherEntity;
import net.thebrokenscript.entity.niw.NothingIsWatchingChaseEntity;
import net.thebrokenscript.entity.niw.NothingIsWatchingEntity;
import net.thebrokenscript.entity.nullent.NullChaseEntity;
import net.thebrokenscript.entity.nullent.NullEndgameEntity;
import net.thebrokenscript.entity.nullent.NullFlyingEntity;
import net.thebrokenscript.entity.nullent.NullInvadeBaseEntity;
import net.thebrokenscript.entity.nullent.NullIsHereEntity;
import net.thebrokenscript.entity.nullent.NullMazeEntity;
import net.thebrokenscript.entity.nullent.NullMiningEntity;
import net.thebrokenscript.entity.nullent.NullScareEntity;
import net.thebrokenscript.entity.nullent.NullUnbeatableBossfightEntity;
import net.thebrokenscript.entity.nullent.NullWatchingEntity;
import net.thebrokenscript.entity.nullent.Xxram2dieEntity;
import net.thebrokenscript.entity.oblit.Obliteration2Entity;
import net.thebrokenscript.entity.oblit.ObliterationEntity;
import net.thebrokenscript.entity.players.CurvedEntity;
import net.thebrokenscript.entity.players.HetzerEntity;
import net.thebrokenscript.entity.players.PhantomPlayerEntity;
import net.thebrokenscript.entity.siluet.HeChaseEntity;
import net.thebrokenscript.entity.siluet.HeEntity;
import net.thebrokenscript.entity.siluet.HeHallucinationEntity;
import net.thebrokenscript.entity.siluet.SiluetChaseEntity;
import net.thebrokenscript.entity.siluet.SiluetEntity;
import net.thebrokenscript.entity.siluet.SiluetHallucinationEntity;
import net.thebrokenscript.entity.siluet.SiluetStareEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndAmbushEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndCuriousEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndStalkEntity;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSMobCategories;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.registry.TBSSpawnConditions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00e6\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0005\"\b\b\u0000\u0010\t*\u00020\n\"\b\b\u0001\u0010\b*\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u00070\u0005H\u0002J.\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0005\"\b\b\u0000\u0010\b*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0002J:\u0010\u009b\u0001\u001a\u00030\u009c\u0001\"\u000b\b\u0000\u0010\b\u0018\u0001*\u00030\u009d\u0001*\t\u0012\u0004\u0012\u0002H\b0\u009e\u00012\n\b\u0002\u0010\u009f\u0001\u001a\u00030\u00a0\u00012\t\b\u0002\u0010\u00a1\u0001\u001a\u00020\u000fH\u0086\bR\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010d\u001a\b\u0012\u0004\u0012\u00020e0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010h\u001a\b\u0012\u0004\u0012\u00020i0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010l\u001a\b\u0012\u0004\u0012\u00020m0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010n\u001a\b\u0012\u0004\u0012\u00020o0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010p\u001a\b\u0012\u0004\u0012\u00020q0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010r\u001a\b\u0012\u0004\u0012\u00020s0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010t\u001a\b\u0012\u0004\u0012\u00020u0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010v\u001a\b\u0012\u0004\u0012\u00020w0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010z\u001a\b\u0012\u0004\u0012\u00020{0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010|\u001a\b\u0012\u0004\u0012\u00020}0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0080\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u008c\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0093\u0001\u001a\t\u0012\u0005\u0012\u00030\u0094\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0098\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00a2\u0001"}, d2={"Lnet/thebrokenscript/registry/TBSEntities;", "", "<init>", "()V", "extendo", "Lkotlin/Function1;", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "Lnet/minecraft/client/renderer/entity/EntityRenderer;", "T", "B", "Lnet/minecraft/world/entity/Entity;", "ctor", "invis", "Lnet/minecraft/world/entity/Mob;", "offset", "", "makeCommonAttrs", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "kotlin.jvm.PlatformType", "CIRCUIT", "Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "Lnet/thebrokenscript/entity/circuit/CircuitEntity;", "CIRCUIT_MINESHAFT_WALK", "Lnet/thebrokenscript/entity/circuit/CircuitMineshaftWalkEntity;", "CIRCUIT_MINESHAFT_FLEE", "Lnet/thebrokenscript/entity/circuit/CircuitMineshaftFleeEntity;", "CIRCUIT_MINESHAFT_STARE", "Lnet/thebrokenscript/entity/circuit/CircuitMineshaftStareEntity;", "CIRCUIT_STALK", "Lnet/thebrokenscript/entity/circuit/CircuitStalkEntity;", "CIRCUIT_STARE", "Lnet/thebrokenscript/entity/circuit/CircuitStareEntity;", "FAKE_PLAYER", "Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "NULL_CHASE", "Lnet/thebrokenscript/entity/nullent/NullChaseEntity;", "NULL_MAZE", "Lnet/thebrokenscript/entity/nullent/NullMazeEntity;", "NULL_SCARE", "Lnet/thebrokenscript/entity/nullent/NullScareEntity;", "NULL_FLYING", "Lnet/thebrokenscript/entity/nullent/NullFlyingEntity;", "NULL_WATCHING", "Lnet/thebrokenscript/entity/nullent/NullWatchingEntity;", "NULL_ENDGAME", "Lnet/thebrokenscript/entity/nullent/NullEndgameEntity;", "FARAWAY", "Lnet/thebrokenscript/entity/FarawayEntity;", "NULL_INVADE_BASE", "Lnet/thebrokenscript/entity/nullent/NullInvadeBaseEntity;", "NULL_IS_HERE", "Lnet/thebrokenscript/entity/nullent/NullIsHereEntity;", "NULL_MINING", "Lnet/thebrokenscript/entity/nullent/NullMiningEntity;", "NULL_UNBEATABLE_BOSSFIGHT", "Lnet/thebrokenscript/entity/nullent/NullUnbeatableBossfightEntity;", "XXRAM_2DIE", "Lnet/thebrokenscript/entity/nullent/Xxram2dieEntity;", "SILUET", "Lnet/thebrokenscript/entity/siluet/SiluetEntity;", "SILUET_CHASE", "Lnet/thebrokenscript/entity/siluet/SiluetChaseEntity;", "SILUET_HALLUCINATION", "Lnet/thebrokenscript/entity/siluet/SiluetHallucinationEntity;", "HE_HALLUCINATION", "Lnet/thebrokenscript/entity/siluet/HeHallucinationEntity;", "SILUET_STARE", "Lnet/thebrokenscript/entity/siluet/SiluetStareEntity;", "HE", "Lnet/thebrokenscript/entity/siluet/HeEntity;", "HE_CHASE", "Lnet/thebrokenscript/entity/siluet/HeChaseEntity;", "NOTHING_IS_WATCHING", "Lnet/thebrokenscript/entity/niw/NothingIsWatchingEntity;", "NOTHING_IS_WATCHING_CHASE", "Lnet/thebrokenscript/entity/niw/NothingIsWatchingChaseEntity;", "THE_BROKEN_END", "Lnet/thebrokenscript/entity/tbe/TheBrokenEndEntity;", "THE_BROKEN_END_STALK", "Lnet/thebrokenscript/entity/tbe/TheBrokenEndStalkEntity;", "THE_BROKEN_END_CURIOUS", "Lnet/thebrokenscript/entity/tbe/TheBrokenEndCuriousEntity;", "THE_BROKEN_END_AMBUSH", "Lnet/thebrokenscript/entity/tbe/TheBrokenEndAmbushEntity;", "BAN", "Lnet/thebrokenscript/entity/misc/BanEntity;", "HETZER", "Lnet/thebrokenscript/entity/players/HetzerEntity;", "CURVED", "Lnet/thebrokenscript/entity/players/CurvedEntity;", "CORRUPTION", "Lnet/thebrokenscript/entity/misc/CorruptionEntity;", "EERIE_NOISE", "Lnet/thebrokenscript/entity/misc/CaveSoundEntity;", "CHUNK_REMOVER", "Lnet/thebrokenscript/entity/misc/ChunkRemoverEntity;", "FOLLOW", "Lnet/thebrokenscript/entity/NoTextureEntity;", "MAZE_SHADOWS", "Lnet/thebrokenscript/entity/maze/MazeShadowsEntity;", "STARE", "Lnet/thebrokenscript/entity/StareEntity;", "DECEIVER", "Lnet/thebrokenscript/entity/DeceiverEntity;", "HEROBRINE", "Lnet/thebrokenscript/entity/HerobrineEntity;", "THE_OBLITERATION", "Lnet/thebrokenscript/entity/oblit/ObliterationEntity;", "THE_OBLITERATION_2", "Lnet/thebrokenscript/entity/oblit/Obliteration2Entity;", "PHANTOM_PLAYER", "Lnet/thebrokenscript/entity/players/PhantomPlayerEntity;", "SUB_ANOMALY_1", "Lnet/thebrokenscript/entity/anomaly/sa1/SubAnomaly1Entity;", "SUB_ANOMALY_2", "Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity;", "MURDERFUR", "Lnet/thebrokenscript/entity/misc/MurderfurEntity;", "NULL_COD", "Lnet/thebrokenscript/entity/NullCodEntity;", "JON", "Lnet/thebrokenscript/entity/misc/JonEntity;", "NOTHING_WATCHER", "Lnet/thebrokenscript/entity/misc/NothingWatcherEntity;", "NAME_TAG", "Lnet/thebrokenscript/entity/NameTagEntity;", "INTEGRITY_PHASE_1", "Lnet/thebrokenscript/entity/integrity/phase1/IntegrityPhase1Entity;", "INTEGRITY_PHASE_2", "Lnet/thebrokenscript/entity/integrity/phase2/IntegrityPhase2Entity;", "INTEGRITY_PHASE_3", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "INTEGRITY_ARM", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityP3GroundArmEntity;", "INTEGRITY_CURIOUS", "Lnet/thebrokenscript/entity/integrity/IntegrityCuriousEntity;", "FRACTURED", "Lnet/thebrokenscript/entity/fractured/FracturedEntity;", "FRACTURED_ROAM", "Lnet/thebrokenscript/entity/fractured/FracturedRoamEntity;", "ROCK", "Lnet/thebrokenscript/entity/fractured/RockEntity;", "FEVER", "Lnet/thebrokenscript/api/entity/BaseFeverEntity;", "FEVER_STALK", "CHORD", "Lnet/thebrokenscript/entity/boss/ChordEntity;", "CHORD_PROJECTILE", "Lnet/thebrokenscript/entity/boss/ChordProjectileEntity;", "TETHER", "Lnet/thebrokenscript/entity/boss/TetherEntity;", "VOID_TENTACLE", "Lnet/thebrokenscript/entity/boss/VoidTentacleEntity;", "INTEG_FIREBALL", "Lnet/thebrokenscript/entity/integrity/phase3/IntegFireballEntity;", "nullRenderer", "", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/registry/builders/EntityBuilder;", "texturePath", "", "shadowRadius", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTBSEntities.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TBSEntities.kt\nnet/thebrokenscript/registry/TBSEntities\n*L\n1#1,1675:1\n1668#1,5:1676\n1668#1,5:1681\n1668#1,5:1686\n1668#1,5:1691\n1668#1,5:1696\n1668#1,5:1701\n1668#1,5:1706\n1668#1,5:1711\n1668#1,5:1716\n1668#1,5:1721\n1668#1,5:1726\n*S KotlinDebug\n*F\n+ 1 TBSEntities.kt\nnet/thebrokenscript/registry/TBSEntities\n*L\n258#1:1676,5\n285#1:1681,5\n311#1:1686,5\n329#1:1691,5\n350#1:1696,5\n370#1:1701,5\n434#1:1706,5\n452#1:1711,5\n477#1:1716,5\n502#1:1721,5\n520#1:1726,5\n*E\n"})
public final class TBSEntities {
    @NotNull
    public static final TBSEntities INSTANCE = new TBSEntities();
    @JvmField
    @NotNull
    public static final EntityEntry<CircuitEntity> CIRCUIT = TBSReg.INSTANCE.entity("circuit", CIRCUIT.1.INSTANCE, TBSEntities::CIRCUIT$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<CircuitMineshaftWalkEntity> CIRCUIT_MINESHAFT_WALK = TBSReg.INSTANCE.entity("circuit_mineshaft_walk", CIRCUIT_MINESHAFT_WALK.1.INSTANCE, TBSEntities::CIRCUIT_MINESHAFT_WALK$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<CircuitMineshaftFleeEntity> CIRCUIT_MINESHAFT_FLEE = TBSReg.INSTANCE.entity("circuit_mineshaft_flee", CIRCUIT_MINESHAFT_FLEE.1.INSTANCE, TBSEntities::CIRCUIT_MINESHAFT_FLEE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<CircuitMineshaftStareEntity> CIRCUIT_MINESHAFT_STARE = TBSReg.INSTANCE.entity("circuit_mineshaft_stare", CIRCUIT_MINESHAFT_STARE.1.INSTANCE, TBSEntities::CIRCUIT_MINESHAFT_STARE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<CircuitStalkEntity> CIRCUIT_STALK = TBSReg.INSTANCE.entity("circuit_stalk", CIRCUIT_STALK.1.INSTANCE, TBSEntities::CIRCUIT_STALK$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<CircuitStareEntity> CIRCUIT_STARE = TBSReg.INSTANCE.entity("circuit_stare", CIRCUIT_STARE.1.INSTANCE, TBSEntities::CIRCUIT_STARE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<FakePlayerEntity> FAKE_PLAYER = TBSReg.INSTANCE.entity("fake_player", FAKE_PLAYER.1.INSTANCE, TBSEntities::FAKE_PLAYER$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullChaseEntity> NULL_CHASE = TBSReg.INSTANCE.entity("nulll", NULL_CHASE.1.INSTANCE, TBSEntities::NULL_CHASE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullMazeEntity> NULL_MAZE = TBSReg.INSTANCE.entity("null_maze", NULL_MAZE.1.INSTANCE, TBSEntities::NULL_MAZE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullScareEntity> NULL_SCARE = TBSReg.INSTANCE.entity("null_scare", NULL_SCARE.1.INSTANCE, TBSEntities::NULL_SCARE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullFlyingEntity> NULL_FLYING = TBSReg.INSTANCE.entity("null_flying", NULL_FLYING.1.INSTANCE, TBSEntities::NULL_FLYING$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullWatchingEntity> NULL_WATCHING = TBSReg.INSTANCE.entity("null_watching", NULL_WATCHING.1.INSTANCE, TBSEntities::NULL_WATCHING$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullEndgameEntity> NULL_ENDGAME = TBSReg.INSTANCE.entity("null_endgame", NULL_ENDGAME.1.INSTANCE, TBSEntities::NULL_ENDGAME$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<FarawayEntity> FARAWAY = TBSReg.INSTANCE.entity("faraway", FARAWAY.1.INSTANCE, TBSEntities::FARAWAY$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullInvadeBaseEntity> NULL_INVADE_BASE = TBSReg.INSTANCE.entity("null_invade_base", NULL_INVADE_BASE.1.INSTANCE, TBSEntities::NULL_INVADE_BASE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullIsHereEntity> NULL_IS_HERE = TBSReg.INSTANCE.entity("null_is_here", NULL_IS_HERE.1.INSTANCE, TBSEntities::NULL_IS_HERE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullMiningEntity> NULL_MINING = TBSReg.INSTANCE.entity("null_mining", NULL_MINING.1.INSTANCE, TBSEntities::NULL_MINING$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullUnbeatableBossfightEntity> NULL_UNBEATABLE_BOSSFIGHT = TBSReg.INSTANCE.entity("null_unbeatable_bossfight", NULL_UNBEATABLE_BOSSFIGHT.1.INSTANCE, TBSEntities::NULL_UNBEATABLE_BOSSFIGHT$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<Xxram2dieEntity> XXRAM_2DIE = TBSReg.INSTANCE.entity("xxram_2die", XXRAM_2DIE.1.INSTANCE, TBSEntities::XXRAM_2DIE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<SiluetEntity> SILUET = TBSReg.INSTANCE.entity("siluet", SILUET.1.INSTANCE, TBSEntities::SILUET$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<SiluetChaseEntity> SILUET_CHASE = TBSReg.INSTANCE.entity("siluet_chase", SILUET_CHASE.1.INSTANCE, TBSEntities::SILUET_CHASE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<SiluetHallucinationEntity> SILUET_HALLUCINATION = TBSReg.INSTANCE.entity("siluet_hallucination", SILUET_HALLUCINATION.1.INSTANCE, TBSEntities::SILUET_HALLUCINATION$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<HeHallucinationEntity> HE_HALLUCINATION = TBSReg.INSTANCE.entity("he_hallucination", HE_HALLUCINATION.1.INSTANCE, TBSEntities::HE_HALLUCINATION$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<SiluetStareEntity> SILUET_STARE = TBSReg.INSTANCE.entity("siluet_stare", SILUET_STARE.1.INSTANCE, TBSEntities::SILUET_STARE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<HeEntity> HE = TBSReg.INSTANCE.entity("he", HE.1.INSTANCE, TBSEntities::HE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<HeChaseEntity> HE_CHASE = TBSReg.INSTANCE.entity("he_chase", HE_CHASE.1.INSTANCE, TBSEntities::HE_CHASE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NothingIsWatchingEntity> NOTHING_IS_WATCHING = TBSReg.INSTANCE.entity("nothingiswatching", NOTHING_IS_WATCHING.1.INSTANCE, TBSEntities::NOTHING_IS_WATCHING$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NothingIsWatchingChaseEntity> NOTHING_IS_WATCHING_CHASE = TBSReg.INSTANCE.entity("nothingiswatchingchase", NOTHING_IS_WATCHING_CHASE.1.INSTANCE, TBSEntities::NOTHING_IS_WATCHING_CHASE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<TheBrokenEndEntity> THE_BROKEN_END = TBSReg.INSTANCE.entity("the_broken_end", THE_BROKEN_END.1.INSTANCE, TBSEntities::THE_BROKEN_END$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<TheBrokenEndStalkEntity> THE_BROKEN_END_STALK = TBSReg.INSTANCE.entity("the_broken_end_stalk", THE_BROKEN_END_STALK.1.INSTANCE, TBSEntities::THE_BROKEN_END_STALK$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<TheBrokenEndCuriousEntity> THE_BROKEN_END_CURIOUS = TBSReg.INSTANCE.entity("the_broken_end_curious", THE_BROKEN_END_CURIOUS.1.INSTANCE, TBSEntities::THE_BROKEN_END_CURIOUS$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<TheBrokenEndAmbushEntity> THE_BROKEN_END_AMBUSH = TBSReg.INSTANCE.entity("the_broken_end_ambush", THE_BROKEN_END_AMBUSH.1.INSTANCE, TBSEntities::THE_BROKEN_END_AMBUSH$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<BanEntity> BAN = TBSReg.INSTANCE.entity("ban", BAN.1.INSTANCE, TBSEntities::BAN$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<HetzerEntity> HETZER = TBSReg.INSTANCE.entity("hetzer", HETZER.1.INSTANCE, TBSEntities::HETZER$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<CurvedEntity> CURVED = TBSReg.INSTANCE.entity("curved", CURVED.1.INSTANCE, TBSEntities::CURVED$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<CorruptionEntity> CORRUPTION = TBSReg.INSTANCE.entity("corruption", CORRUPTION.1.INSTANCE, TBSEntities::CORRUPTION$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<CaveSoundEntity> EERIE_NOISE = TBSReg.INSTANCE.entity("eerie_noise", EERIE_NOISE.1.INSTANCE, TBSEntities::EERIE_NOISE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<ChunkRemoverEntity> CHUNK_REMOVER = TBSReg.INSTANCE.entity("chunk_remover", CHUNK_REMOVER.1.INSTANCE, TBSEntities::CHUNK_REMOVER$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NoTextureEntity> FOLLOW = TBSReg.INSTANCE.entity("follow", FOLLOW.1.INSTANCE, TBSEntities::FOLLOW$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<MazeShadowsEntity> MAZE_SHADOWS = TBSReg.INSTANCE.entity("maze_shadows", MAZE_SHADOWS.1.INSTANCE, TBSEntities::MAZE_SHADOWS$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<StareEntity> STARE = TBSReg.INSTANCE.entity("stare", STARE.1.INSTANCE, TBSEntities::STARE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<DeceiverEntity> DECEIVER = TBSReg.INSTANCE.entity("deceiver", DECEIVER.1.INSTANCE, TBSEntities::DECEIVER$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<HerobrineEntity> HEROBRINE = TBSReg.INSTANCE.entity("herobrine", HEROBRINE.1.INSTANCE, TBSEntities::HEROBRINE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<ObliterationEntity> THE_OBLITERATION = TBSReg.INSTANCE.entity("the_obliteration", THE_OBLITERATION.1.INSTANCE, TBSEntities::THE_OBLITERATION$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<Obliteration2Entity> THE_OBLITERATION_2 = TBSReg.INSTANCE.entity("the_obliteration_2", THE_OBLITERATION_2.1.INSTANCE, TBSEntities::THE_OBLITERATION_2$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<PhantomPlayerEntity> PHANTOM_PLAYER = TBSReg.INSTANCE.entity("phantom_player", PHANTOM_PLAYER.1.INSTANCE, TBSEntities::PHANTOM_PLAYER$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<SubAnomaly1Entity> SUB_ANOMALY_1 = TBSReg.INSTANCE.entity("sub_anomaly_1", SUB_ANOMALY_1.1.INSTANCE, TBSEntities::SUB_ANOMALY_1$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<SubAnomaly2Entity> SUB_ANOMALY_2 = TBSReg.INSTANCE.entity("sub_anomaly_2", SUB_ANOMALY_2.1.INSTANCE, TBSEntities::SUB_ANOMALY_2$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<MurderfurEntity> MURDERFUR = TBSReg.INSTANCE.entity("murderfur", MURDERFUR.1.INSTANCE, TBSEntities::MURDERFUR$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NullCodEntity> NULL_COD = TBSReg.INSTANCE.entity("null_cod", NULL_COD.1.INSTANCE, TBSEntities::NULL_COD$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<JonEntity> JON = TBSReg.INSTANCE.entity("jon", JON.1.INSTANCE, TBSEntities::JON$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NothingWatcherEntity> NOTHING_WATCHER = TBSReg.INSTANCE.entity("nothing_watcher", NOTHING_WATCHER.1.INSTANCE, TBSEntities::NOTHING_WATCHER$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<NameTagEntity> NAME_TAG = TBSReg.INSTANCE.entity("name_tag", NAME_TAG.1.INSTANCE, TBSEntities::NAME_TAG$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<IntegrityPhase1Entity> INTEGRITY_PHASE_1 = TBSReg.INSTANCE.entity("integrity_phase_1", INTEGRITY_PHASE_1.1.INSTANCE, TBSEntities::INTEGRITY_PHASE_1$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<IntegrityPhase2Entity> INTEGRITY_PHASE_2 = TBSReg.INSTANCE.entity("integrity_phase_2", INTEGRITY_PHASE_2.1.INSTANCE, TBSEntities::INTEGRITY_PHASE_2$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<IntegrityPhase3Entity> INTEGRITY_PHASE_3 = TBSReg.INSTANCE.entity("integrity_phase_3", INTEGRITY_PHASE_3.1.INSTANCE, TBSEntities::INTEGRITY_PHASE_3$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<IntegrityP3GroundArmEntity> INTEGRITY_ARM = TBSReg.INSTANCE.entity("integrity_arm", INTEGRITY_ARM.1.INSTANCE, TBSEntities::INTEGRITY_ARM$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<IntegrityCuriousEntity> INTEGRITY_CURIOUS = TBSReg.INSTANCE.entity("integrity_curious", INTEGRITY_CURIOUS.1.INSTANCE, TBSEntities::INTEGRITY_CURIOUS$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<FracturedEntity> FRACTURED = TBSReg.INSTANCE.entity("fractured", FRACTURED.1.INSTANCE, TBSEntities::FRACTURED$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<FracturedRoamEntity> FRACTURED_ROAM = TBSReg.INSTANCE.entity("fractured_roam", FRACTURED_ROAM.1.INSTANCE, TBSEntities::FRACTURED_ROAM$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<RockEntity> ROCK = TBSReg.INSTANCE.entity("rock", ROCK.1.INSTANCE, TBSEntities::ROCK$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<BaseFeverEntity> FEVER = TBSReg.INSTANCE.entity("fever", FEVER.1.INSTANCE, TBSEntities::FEVER$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<BaseFeverEntity> FEVER_STALK = TBSReg.INSTANCE.entity("fever_stalk", FEVER_STALK.1.INSTANCE, TBSEntities::FEVER_STALK$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<ChordEntity> CHORD = TBSReg.INSTANCE.entity("chord", CHORD.1.INSTANCE, TBSEntities::CHORD$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<ChordProjectileEntity> CHORD_PROJECTILE = TBSReg.INSTANCE.entity("chord_projectile", CHORD_PROJECTILE.1.INSTANCE, TBSEntities::CHORD_PROJECTILE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<TetherEntity> TETHER = TBSReg.INSTANCE.entity("tether", TETHER.1.INSTANCE, TBSEntities::TETHER$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<VoidTentacleEntity> VOID_TENTACLE = TBSReg.INSTANCE.entity("void_tentacle", VOID_TENTACLE.1.INSTANCE, TBSEntities::VOID_TENTACLE$lambda$0);
    @JvmField
    @NotNull
    public static final EntityEntry<IntegFireballEntity> INTEG_FIREBALL = TBSReg.INSTANCE.entity("integ_fireball", INTEG_FIREBALL.1.INSTANCE, TBSEntities::INTEG_FIREBALL$lambda$0);

    private TBSEntities() {
    }

    private final <B extends Entity, T extends B> Function1<EntityRendererProvider.Context, EntityRenderer<T>> extendo(Function1<? super EntityRendererProvider.Context, ? extends EntityRenderer<B>> ctor) {
        return arg_0 -> TBSEntities.extendo$lambda$0(ctor, arg_0);
    }

    private final <T extends Mob> Function1<EntityRendererProvider.Context, EntityRenderer<T>> invis(float offset) {
        return BasicTexturedRenderer.Companion.textured(TBSConstants.id("textures/entities/gandoniovinvize.png"), offset);
    }

    static /* synthetic */ Function1 invis$default(TBSEntities tBSEntities, float f, int n, Object object) {
        if ((n & 1) != 0) {
            f = 0.5f;
        }
        return tBSEntities.invis(f);
    }

    private final AttributeSupplier.Builder makeCommonAttrs() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.MAX_HEALTH, 10.0).add(Attributes.ATTACK_DAMAGE, 3.0).add(Attributes.FOLLOW_RANGE, 16.0);
    }

    public final /* synthetic */ <T extends BaseMonster> void nullRenderer(EntityBuilder<T> $this$nullRenderer, String texturePath, float shadowRadius) {
        Intrinsics.checkNotNullParameter($this$nullRenderer, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)texturePath, (String)"texturePath");
        boolean $i$f$nullRenderer = false;
        Intrinsics.needClassReification();
        $this$nullRenderer.setRenderer(new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<T>>>(texturePath, shadowRadius){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<T>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                Intrinsics.needClassReification();
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<T>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<T> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        Intrinsics.needClassReification();
                        PlayerModel<T> model2 = new PlayerModel<T>(modelPart){

                            public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter(entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)((BaseMonster)entity).tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<T>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
    }

    public static /* synthetic */ void nullRenderer$default(TBSEntities $this, EntityBuilder $receiver, String texturePath, float shadowRadius, int n, Object object) {
        if ((n & 1) != 0) {
            texturePath = "textures/entities/null.png";
        }
        if ((n & 2) != 0) {
            shadowRadius = 0.5f;
        }
        Intrinsics.checkNotNullParameter((Object)$receiver, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)texturePath, (String)"texturePath");
        boolean $i$f$nullRenderer = false;
        Intrinsics.needClassReification();
        $receiver.setRenderer(new /* invalid duplicate definition of identical inner class */);
    }

    private static final EntityRenderer extendo$lambda$0(Function1 $ctor, EntityRendererProvider.Context it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Object object = $ctor.invoke((Object)it);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type net.minecraft.client.renderer.entity.EntityRenderer<T of net.thebrokenscript.registry.TBSEntities.extendo>");
        return (EntityRenderer)object;
    }

    private static final void CIRCUIT$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::CIRCUIT$lambda$0$0);
        $this$entity.props(TBSEntities::CIRCUIT$lambda$0$1);
        $this$entity.attrs((Function0)CIRCUIT.2.3.INSTANCE, TBSEntities::CIRCUIT$lambda$0$2);
    }

    private static final Function1 CIRCUIT$lambda$0$0() {
        return CIRCUIT.2.1.2.INSTANCE;
    }

    private static final void CIRCUIT$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(196);
        $this$props.fireImmune();
        $this$props.sized(0.8f, 1.4f);
    }

    private static final void CIRCUIT$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)64);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)Float.valueOf(2.4f));
    }

    private static final void CIRCUIT_MINESHAFT_WALK$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::CIRCUIT_MINESHAFT_WALK$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.CIRCUIT_MINESHAFT;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::CIRCUIT_MINESHAFT_WALK$lambda$0$1);
        $this$entity.attrs((Function0)CIRCUIT_MINESHAFT_WALK.2.3.INSTANCE, TBSEntities::CIRCUIT_MINESHAFT_WALK$lambda$0$2);
    }

    private static final Function1 CIRCUIT_MINESHAFT_WALK$lambda$0$0() {
        return CIRCUIT_MINESHAFT_WALK.2.1.2.INSTANCE;
    }

    private static final void CIRCUIT_MINESHAFT_WALK$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void CIRCUIT_MINESHAFT_WALK$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.3);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)80.6);
    }

    private static final void CIRCUIT_MINESHAFT_FLEE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::CIRCUIT_MINESHAFT_FLEE$lambda$0$0);
        $this$entity.props(TBSEntities::CIRCUIT_MINESHAFT_FLEE$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)INSTANCE){

            public final AttributeSupplier.Builder invoke() {
                return TBSEntities.access$makeCommonAttrs((TBSEntities)this.receiver);
            }
        }), null, (int)2, null);
    }

    private static final Function1 CIRCUIT_MINESHAFT_FLEE$lambda$0$0() {
        return CIRCUIT_MINESHAFT_FLEE.2.1.2.INSTANCE;
    }

    private static final void CIRCUIT_MINESHAFT_FLEE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void CIRCUIT_MINESHAFT_STARE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::CIRCUIT_MINESHAFT_STARE$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.CIRCUIT_MINESHAFT;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::CIRCUIT_MINESHAFT_STARE$lambda$0$1);
        $this$entity.attrs((Function0)CIRCUIT_MINESHAFT_STARE.2.3.INSTANCE, TBSEntities::CIRCUIT_MINESHAFT_STARE$lambda$0$2);
    }

    private static final Function1 CIRCUIT_MINESHAFT_STARE$lambda$0$0() {
        return CIRCUIT_MINESHAFT_STARE.2.1.2.INSTANCE;
    }

    private static final void CIRCUIT_MINESHAFT_STARE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void CIRCUIT_MINESHAFT_STARE$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
    }

    private static final void CIRCUIT_STALK$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::CIRCUIT_STALK$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.CIRCUIT_STALK;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::CIRCUIT_STALK$lambda$0$1);
        $this$entity.attrs((Function0)CIRCUIT_STALK.2.3.INSTANCE, TBSEntities::CIRCUIT_STALK$lambda$0$2);
    }

    private static final Function1 CIRCUIT_STALK$lambda$0$0() {
        return CIRCUIT_STALK.2.1.2.INSTANCE;
    }

    private static final void CIRCUIT_STALK$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 2.0f);
    }

    private static final void CIRCUIT_STALK$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.3);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)110);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)816);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
    }

    private static final void CIRCUIT_STARE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::CIRCUIT_STARE$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.CIRCUIT_STALK;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::CIRCUIT_STARE$lambda$0$1);
        $this$entity.attrs((Function0)CIRCUIT_STARE.2.3.INSTANCE, TBSEntities::CIRCUIT_STARE$lambda$0$2);
    }

    private static final Function1 CIRCUIT_STARE$lambda$0$0() {
        return CIRCUIT_STARE.2.1.2.INSTANCE;
    }

    private static final void CIRCUIT_STARE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 2.0f);
    }

    private static final void CIRCUIT_STARE$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)110);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)816);
    }

    private static final void FAKE_PLAYER$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Fake Player";
        $this$entity.setRenderer(TBSEntities::FAKE_PLAYER$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.ENTITY;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::FAKE_PLAYER$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)FakePlayerEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((FakePlayerEntity.Companion)this.receiver).createAttributes();
            }
        }), null, (int)2, null);
    }

    private static final KFunction FAKE_PLAYER$lambda$0$0() {
        return (KFunction)FAKE_PLAYER.2.1.1.INSTANCE;
    }

    private static final void FAKE_PLAYER$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_CHASE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "null";
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder $receiver$iv = $this$entity;
        String texturePath$iv = "textures/entities/null.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullChaseEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullChaseEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullChaseEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullChaseEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullChaseEntity> model2 = new PlayerModel<NullChaseEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullChaseEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.props(TBSEntities::NULL_CHASE$lambda$0$0);
        $this$entity.attrs((Function0)NULL_CHASE.2.2.INSTANCE, TBSEntities::NULL_CHASE$lambda$0$1);
    }

    private static final void NULL_CHASE$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_CHASE$lambda$0$1(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.3);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)80);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)5);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)20);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)416);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)0.3);
    }

    private static final void NULL_MAZE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "null maze chaser";
        $this$entity.spawns = (Holder)TBSSpawnConditions.MAZE_CHASER;
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder $receiver$iv = $this$entity;
        String texturePath$iv = "textures/entities/null.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullMazeEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullMazeEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullMazeEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullMazeEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullMazeEntity> model2 = new PlayerModel<NullMazeEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullMazeEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::NULL_MAZE$lambda$0$0);
        $this$entity.attrs((Function0)NULL_MAZE.2.2.INSTANCE, TBSEntities::NULL_MAZE$lambda$0$1);
    }

    private static final void NULL_MAZE$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_MAZE$lambda$0$1(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.3);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)75);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)416);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)1.6);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)0.3);
    }

    private static final void NULL_SCARE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder $receiver$iv = $this$entity;
        String texturePath$iv = "textures/entities/null.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullScareEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullScareEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullScareEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullScareEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullScareEntity> model2 = new PlayerModel<NullScareEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullScareEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.props(TBSEntities::NULL_SCARE$lambda$0$0);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)NullScareEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((NullScareEntity.Companion)this.receiver).createAttributes();
            }
        }), null, (int)2, null);
    }

    private static final void NULL_SCARE$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_FLYING$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "MobIsMissingID";
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder $receiver$iv = $this$entity;
        String texturePath$iv = "textures/entities/null.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullFlyingEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullFlyingEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullFlyingEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullFlyingEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullFlyingEntity> model2 = new PlayerModel<NullFlyingEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullFlyingEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.spawns = (Holder)TBSSpawnConditions.NULL_CONDITIONS;
        $this$entity.biomeSpawn(2, 1, 1);
        $this$entity.props(TBSEntities::NULL_FLYING$lambda$0$0);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)NullFlyingEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((NullFlyingEntity.Companion)this.receiver).createAttributes();
            }
        }), null, (int)2, null);
    }

    private static final void NULL_FLYING$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_WATCHING$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Null";
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder $receiver$iv = $this$entity;
        String texturePath$iv = "textures/entities/null.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullWatchingEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullWatchingEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullWatchingEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullWatchingEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullWatchingEntity> model2 = new PlayerModel<NullWatchingEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullWatchingEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.spawns = (Holder)TBSSpawnConditions.NULL_CONDITIONS;
        $this$entity.biomeSpawn(2, 1, 1);
        $this$entity.props(TBSEntities::NULL_WATCHING$lambda$0$0);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)NullWatchingEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((NullWatchingEntity.Companion)this.receiver).createAttributes();
            }
        }), null, (int)2, null);
    }

    private static final void NULL_WATCHING$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_ENDGAME$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "Null Endgame";
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder $receiver$iv = $this$entity;
        String texturePath$iv = "textures/entities/null.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullEndgameEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullEndgameEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullEndgameEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullEndgameEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullEndgameEntity> model2 = new PlayerModel<NullEndgameEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullEndgameEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.props(TBSEntities::NULL_ENDGAME$lambda$0$0);
        $this$entity.attrs((Function0)NULL_ENDGAME.2.2.INSTANCE, TBSEntities::NULL_ENDGAME$lambda$0$1);
    }

    private static final void NULL_ENDGAME$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_ENDGAME$lambda$0$1(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)80);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)6);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
    }

    private static final void FARAWAY$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::FARAWAY$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.FARAWAY;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::FARAWAY$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)FarawayEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((FarawayEntity.Companion)this.receiver).attributes();
            }
        }), null, (int)2, null);
    }

    private static final KFunction FARAWAY$lambda$0$0() {
        return (KFunction)FARAWAY.2.1.1.INSTANCE;
    }

    private static final void FARAWAY$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void NULL_INVADE_BASE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder $receiver$iv = $this$entity;
        String texturePath$iv = "textures/entities/null.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullInvadeBaseEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullInvadeBaseEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullInvadeBaseEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullInvadeBaseEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullInvadeBaseEntity> model2 = new PlayerModel<NullInvadeBaseEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullInvadeBaseEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.props(TBSEntities::NULL_INVADE_BASE$lambda$0$0);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)NullInvadeBaseEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((NullInvadeBaseEntity.Companion)this.receiver).createAttributes();
            }
        }), null, (int)2, null);
    }

    private static final void NULL_INVADE_BASE$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_IS_HERE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "Null";
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder $receiver$iv = $this$entity;
        String texturePath$iv = "textures/entities/null.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullIsHereEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullIsHereEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullIsHereEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullIsHereEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullIsHereEntity> model2 = new PlayerModel<NullIsHereEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullIsHereEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.props(TBSEntities::NULL_IS_HERE$lambda$0$0);
        $this$entity.attrs((Function0)NULL_IS_HERE.2.2.INSTANCE, TBSEntities::NULL_IS_HERE$lambda$0$1);
    }

    private static final void NULL_IS_HERE$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_IS_HERE$lambda$0$1(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)313);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setFlyingSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
    }

    /*
     * WARNING - void declaration
     */
    private static final void NULL_MINING$lambda$0(EntityBuilder $this$entity) {
        void $receiver$iv;
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "Null Mining";
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder entityBuilder = $this$entity;
        String texturePath$iv = "textures/entities/anomaly1new.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullMiningEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullMiningEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullMiningEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullMiningEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullMiningEntity> model2 = new PlayerModel<NullMiningEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullMiningEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.props(TBSEntities::NULL_MINING$lambda$0$0);
        $this$entity.attrs((Function0)NULL_MINING.2.2.INSTANCE, TBSEntities::NULL_MINING$lambda$0$1);
    }

    private static final void NULL_MINING$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NULL_MINING$lambda$0$1(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.2);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)80);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)5);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)10);
    }

    private static final void NULL_UNBEATABLE_BOSSFIGHT$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "[]";
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder $receiver$iv = $this$entity;
        String texturePath$iv = "textures/entities/null.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<NullUnbeatableBossfightEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<NullUnbeatableBossfightEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<NullUnbeatableBossfightEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<NullUnbeatableBossfightEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<NullUnbeatableBossfightEntity> model2 = new PlayerModel<NullUnbeatableBossfightEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<NullUnbeatableBossfightEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.props(TBSEntities::NULL_UNBEATABLE_BOSSFIGHT$lambda$0$0);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)NullUnbeatableBossfightEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((NullUnbeatableBossfightEntity.Companion)this.receiver).createAttributes();
            }
        }), null, (int)2, null);
    }

    private static final void NULL_UNBEATABLE_BOSSFIGHT$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    /*
     * WARNING - void declaration
     */
    private static final void XXRAM_2DIE$lambda$0(EntityBuilder $this$entity) {
        void $receiver$iv;
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "xXram2dieXx";
        TBSEntities tBSEntities = INSTANCE;
        EntityBuilder entityBuilder = $this$entity;
        String texturePath$iv = "textures/entities/xxram2diexx.png";
        float shadowRadius$iv = 0.5f;
        boolean $i$f$nullRenderer = false;
        $receiver$iv.setRenderer((Function0)new Function0<Function1<? super EntityRendererProvider.Context, ? extends NullRenderer<Xxram2dieEntity>>>(texturePath$iv, shadowRadius$iv){
            final /* synthetic */ String $texturePath;
            final /* synthetic */ float $shadowRadius;
            {
                this.$texturePath = $texturePath;
                this.$shadowRadius = $shadowRadius;
            }

            /*
             * WARNING - void declaration
             */
            public final Function1<EntityRendererProvider.Context, NullRenderer<Xxram2dieEntity>> invoke() {
                void texturePath$iv;
                String string = this.$texturePath;
                float shadowRadius$iv = this.$shadowRadius;
                boolean $i$f$createNullRenderer = false;
                return (Function1)new Function1<EntityRendererProvider.Context, NullRenderer<Xxram2dieEntity>>(shadowRadius$iv, (String)texturePath$iv){
                    final /* synthetic */ float $shadowRadius;
                    final /* synthetic */ String $texturePath;
                    {
                        this.$shadowRadius = $shadowRadius;
                        this.$texturePath = $texturePath;
                    }

                    public final NullRenderer<Xxram2dieEntity> invoke(EntityRendererProvider.Context context) {
                        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                        ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                        PlayerModel<Xxram2dieEntity> model2 = new PlayerModel<Xxram2dieEntity>(modelPart){

                            /*
                             * Ignored method signature, as it can't be verified against descriptor
                             */
                            public void setupAnim(BaseMonster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                                boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                                super.setupAnim((LivingEntity)entity, swimming ? ((float)entity.tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                            }
                        };
                        return new NullRenderer<Xxram2dieEntity>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
                    }
                };
            }
        });
        $this$entity.spawns = (Holder)TBSSpawnConditions.DEFAULT;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::XXRAM_2DIE$lambda$0$0);
        $this$entity.attrs((Function0)XXRAM_2DIE.2.2.INSTANCE, TBSEntities::XXRAM_2DIE$lambda$0$1);
    }

    private static final void XXRAM_2DIE$lambda$0$0(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void XXRAM_2DIE$lambda$0$1(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)710);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0.0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3.0);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
    }

    private static final void SILUET$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "r2";
        $this$entity.spawns = (Holder)TBSSpawnConditions.SILUET;
        $this$entity.setRenderer(TBSEntities::SILUET$lambda$0$0);
        $this$entity.biomeSpawn(25, 1, 1);
        $this$entity.props(TBSEntities::SILUET$lambda$0$1);
        $this$entity.attrs((Function0)SILUET.2.3.INSTANCE, TBSEntities::SILUET$lambda$0$2);
    }

    private static final KFunction SILUET$lambda$0$0() {
        return (KFunction)SILUET.2.1.1.INSTANCE;
    }

    private static final void SILUET$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(1.0f, 4.5f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void SILUET$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.2);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)590);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
    }

    private static final void SILUET_CHASE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "r2";
        $this$entity.setRenderer(TBSEntities::SILUET_CHASE$lambda$0$0);
        $this$entity.props(TBSEntities::SILUET_CHASE$lambda$0$1);
        $this$entity.attrs((Function0)SILUET_CHASE.2.3.INSTANCE, TBSEntities::SILUET_CHASE$lambda$0$2);
    }

    private static final KFunction SILUET_CHASE$lambda$0$0() {
        return (KFunction)SILUET_CHASE.2.1.1.INSTANCE;
    }

    private static final void SILUET_CHASE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.8f, 4.5f);
    }

    private static final void SILUET_CHASE$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)13);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)316);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
    }

    private static final void SILUET_HALLUCINATION$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "r2 hallucination";
        $this$entity.setRenderer(TBSEntities::SILUET_HALLUCINATION$lambda$0$0);
        $this$entity.props(TBSEntities::SILUET_HALLUCINATION$lambda$0$1);
        $this$entity.attrs((Function0)SILUET_HALLUCINATION.2.3.INSTANCE, TBSEntities::SILUET_HALLUCINATION$lambda$0$2);
    }

    private static final KFunction SILUET_HALLUCINATION$lambda$0$0() {
        return (KFunction)SILUET_HALLUCINATION.2.1.1.INSTANCE;
    }

    private static final void SILUET_HALLUCINATION$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.9f, 1.6f);
    }

    private static final void SILUET_HALLUCINATION$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)1);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)316);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
    }

    private static final void HE_HALLUCINATION$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "HIM hallucination";
        $this$entity.setRenderer(TBSEntities::HE_HALLUCINATION$lambda$0$0);
        $this$entity.props(TBSEntities::HE_HALLUCINATION$lambda$0$1);
        $this$entity.attrs((Function0)HE_HALLUCINATION.2.3.INSTANCE, TBSEntities::HE_HALLUCINATION$lambda$0$2);
    }

    private static final KFunction HE_HALLUCINATION$lambda$0$0() {
        return (KFunction)HE_HALLUCINATION.2.1.1.INSTANCE;
    }

    private static final void HE_HALLUCINATION$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.9f, 1.6f);
    }

    private static final void HE_HALLUCINATION$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)1);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)316);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
    }

    private static final void SILUET_STARE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Siluet";
        $this$entity.spawns = (Holder)TBSSpawnConditions.SILUET;
        $this$entity.setRenderer(TBSEntities::SILUET_STARE$lambda$0$0);
        $this$entity.biomeSpawn(25, 1, 1);
        $this$entity.props(TBSEntities::SILUET_STARE$lambda$0$1);
        $this$entity.attrs((Function0)SILUET_STARE.2.3.INSTANCE, TBSEntities::SILUET_STARE$lambda$0$2);
    }

    private static final KFunction SILUET_STARE$lambda$0$0() {
        return (KFunction)SILUET_STARE.2.1.1.INSTANCE;
    }

    private static final void SILUET_STARE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(1.0f, 4.5f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void SILUET_STARE$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)316);
    }

    private static final void HE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Him";
        $this$entity.setRenderer(TBSEntities::HE$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.SILUET;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::HE$lambda$0$1);
        $this$entity.attrs((Function0)HE.2.3.INSTANCE, TBSEntities::HE$lambda$0$2);
    }

    private static final KFunction HE$lambda$0$0() {
        return (KFunction)HE.2.1.1.INSTANCE;
    }

    private static final void HE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(0.8f, 4.5f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void HE$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0.0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)1.1);
    }

    private static final void HE_CHASE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "Him";
        $this$entity.setRenderer(TBSEntities::HE_CHASE$lambda$0$0);
        $this$entity.props(TBSEntities::HE_CHASE$lambda$0$1);
        $this$entity.attrs((Function0)HE_CHASE.2.3.INSTANCE, TBSEntities::HE_CHASE$lambda$0$2);
    }

    private static final KFunction HE_CHASE$lambda$0$0() {
        return (KFunction)HE_CHASE.2.1.1.INSTANCE;
    }

    private static final void HE_CHASE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(1.0f, 2.5f);
    }

    private static final void HE_CHASE$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)13);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)316);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
    }

    private static final void NOTHING_IS_WATCHING$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "\u00a7kNothingiswatching";
        $this$entity.setRenderer(TBSEntities::NOTHING_IS_WATCHING$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.NIW;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::NOTHING_IS_WATCHING$lambda$0$1);
        $this$entity.attrs((Function0)NOTHING_IS_WATCHING.2.3.INSTANCE, TBSEntities::NOTHING_IS_WATCHING$lambda$0$2);
    }

    private static final Function1 NOTHING_IS_WATCHING$lambda$0$0() {
        return TBSEntities.invis$default(INSTANCE, 0.0f, 1, null);
    }

    private static final void NOTHING_IS_WATCHING$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(1.6f, 4.5f);
    }

    private static final void NOTHING_IS_WATCHING$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.1);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)510);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)13);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
    }

    private static final void NOTHING_IS_WATCHING_CHASE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "Nothingiswatching";
        $this$entity.setRenderer(TBSEntities::NOTHING_IS_WATCHING_CHASE$lambda$0$0);
        $this$entity.props(TBSEntities::NOTHING_IS_WATCHING_CHASE$lambda$0$1);
        $this$entity.attrs((Function0)NOTHING_IS_WATCHING_CHASE.2.3.INSTANCE, TBSEntities::NOTHING_IS_WATCHING_CHASE$lambda$0$2);
    }

    private static final Function1 NOTHING_IS_WATCHING_CHASE$lambda$0$0() {
        return TBSEntities.invis$default(INSTANCE, 0.0f, 1, null);
    }

    private static final void NOTHING_IS_WATCHING_CHASE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(1.6f, 4.5f);
    }

    private static final void NOTHING_IS_WATCHING_CHASE$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)10.0);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0.0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3.0);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)416);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
    }

    private static final void THE_BROKEN_END$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::THE_BROKEN_END$lambda$0$0);
        $this$entity.props(TBSEntities::THE_BROKEN_END$lambda$0$1);
        $this$entity.attrs((Function0)THE_BROKEN_END.2.3.INSTANCE, TBSEntities::THE_BROKEN_END$lambda$0$2);
    }

    private static final KFunction THE_BROKEN_END$lambda$0$0() {
        return (KFunction)THE_BROKEN_END.2.1.1.INSTANCE;
    }

    private static final void THE_BROKEN_END$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 25.0f);
    }

    private static final void THE_BROKEN_END$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.45);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)1000);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)600);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)64);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)60);
        AttributeUtil.setAttackKnockback((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)25.6);
    }

    private static final void THE_BROKEN_END_STALK$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::THE_BROKEN_END_STALK$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.TBE;
        $this$entity.biomeSpawn(15, 1, 1);
        $this$entity.props(TBSEntities::THE_BROKEN_END_STALK$lambda$0$1);
        $this$entity.attrs((Function0)THE_BROKEN_END_STALK.2.3.INSTANCE, TBSEntities::THE_BROKEN_END_STALK$lambda$0$2);
    }

    private static final KFunction THE_BROKEN_END_STALK$lambda$0$0() {
        return (KFunction)THE_BROKEN_END_STALK.2.1.1.INSTANCE;
    }

    private static final void THE_BROKEN_END_STALK$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(4.5f, 25.0f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void THE_BROKEN_END_STALK$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)500);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)15);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)1916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setAttackKnockback((AttributeSupplier.Builder)$this$attrs, (Number)10);
    }

    private static final void THE_BROKEN_END_CURIOUS$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::THE_BROKEN_END_CURIOUS$lambda$0$0);
        $this$entity.props(TBSEntities::THE_BROKEN_END_CURIOUS$lambda$0$1);
        $this$entity.attrs((Function0)THE_BROKEN_END_CURIOUS.2.3.INSTANCE, TBSEntities::THE_BROKEN_END_CURIOUS$lambda$0$2);
    }

    private static final KFunction THE_BROKEN_END_CURIOUS$lambda$0$0() {
        return (KFunction)THE_BROKEN_END_CURIOUS.2.1.1.INSTANCE;
    }

    private static final void THE_BROKEN_END_CURIOUS$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 25.0f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void THE_BROKEN_END_CURIOUS$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)500);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)15);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)1916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setAttackKnockback((AttributeSupplier.Builder)$this$attrs, (Number)10);
    }

    private static final void THE_BROKEN_END_AMBUSH$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "The Broken End Ambush";
        $this$entity.setRenderer(TBSEntities::THE_BROKEN_END_AMBUSH$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.TBE_AMBUSH;
        $this$entity.biomeSpawn(5, 1, 1);
        $this$entity.props(TBSEntities::THE_BROKEN_END_AMBUSH$lambda$0$1);
        $this$entity.attrs((Function0)THE_BROKEN_END_AMBUSH.2.3.INSTANCE, TBSEntities::THE_BROKEN_END_AMBUSH$lambda$0$2);
    }

    private static final KFunction THE_BROKEN_END_AMBUSH$lambda$0$0() {
        return (KFunction)THE_BROKEN_END_AMBUSH.2.1.1.INSTANCE;
    }

    private static final void THE_BROKEN_END_AMBUSH$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void THE_BROKEN_END_AMBUSH$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.45);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)1000);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)600);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)2016);
    }

    private static final void BAN$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "corrupt world";
        $this$entity.setRenderer(TBSEntities::BAN$lambda$0$0);
        $this$entity.props(TBSEntities::BAN$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)BAN.2.3.INSTANCE, null, (int)2, null);
    }

    private static final Function1 BAN$lambda$0$0() {
        return BasicTexturedRenderer.Companion.textured$default((BasicTexturedRenderer.Companion)BasicTexturedRenderer.Companion, (ResourceLocation)TBSConstants.id("textures/entities/revuxor.png"), (float)0.0f, (int)2, null);
    }

    private static final void BAN$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 0.2f);
    }

    private static final void HETZER$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::HETZER$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.ENTITY;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::HETZER$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)HetzerEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((HetzerEntity.Companion)this.receiver).attributes();
            }
        }), null, (int)2, null);
    }

    private static final KFunction HETZER$lambda$0$0() {
        return (KFunction)HETZER.2.1.1.INSTANCE;
    }

    private static final void HETZER$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(2.0f, 2.0f);
    }

    private static final void CURVED$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "DyeXD412";
        $this$entity.setRenderer(TBSEntities::CURVED$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.CURVED_CONDITIONS;
        $this$entity.biomeSpawn(2, 1, 1);
        $this$entity.props(TBSEntities::CURVED$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)CurvedEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((CurvedEntity.Companion)this.receiver).createAttributes();
            }
        }), null, (int)2, null);
    }

    private static final KFunction CURVED$lambda$0$0() {
        return (KFunction)CURVED.2.1.1.INSTANCE;
    }

    private static final void CURVED$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void CORRUPTION$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Hole to the void";
        $this$entity.setRenderer(TBSEntities::CORRUPTION$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.CORRUPTION_CONDITIONS;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::CORRUPTION$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)INSTANCE){

            public final AttributeSupplier.Builder invoke() {
                return TBSEntities.access$makeCommonAttrs((TBSEntities)this.receiver);
            }
        }), null, (int)2, null);
    }

    private static final Function1 CORRUPTION$lambda$0$0() {
        return INSTANCE.invis(0.0f);
    }

    private static final void CORRUPTION$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 0.8f);
    }

    private static final void EERIE_NOISE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Eerie Noise";
        $this$entity.setRenderer(TBSEntities::EERIE_NOISE$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.EERIE;
        $this$entity.biomeSpawn(2, 1, 1);
        $this$entity.props(TBSEntities::EERIE_NOISE$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)INSTANCE){

            public final AttributeSupplier.Builder invoke() {
                return TBSEntities.access$makeCommonAttrs((TBSEntities)this.receiver);
            }
        }), null, (int)2, null);
    }

    private static final Function1 EERIE_NOISE$lambda$0$0() {
        return INSTANCE.invis(0.0f);
    }

    private static final void EERIE_NOISE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 0.8f);
    }

    private static final void CHUNK_REMOVER$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::CHUNK_REMOVER$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.CHUNK;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::CHUNK_REMOVER$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)INSTANCE){

            public final AttributeSupplier.Builder invoke() {
                return TBSEntities.access$makeCommonAttrs((TBSEntities)this.receiver);
            }
        }), null, (int)2, null);
    }

    private static final Function1 CHUNK_REMOVER$lambda$0$0() {
        return INSTANCE.invis(0.5f);
    }

    private static final void CHUNK_REMOVER$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void FOLLOW$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "No Texture";
        $this$entity.setRenderer(TBSEntities::FOLLOW$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.ENTITY;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::FOLLOW$lambda$0$1);
        $this$entity.attrs((Function0)FOLLOW.2.3.INSTANCE, TBSEntities::FOLLOW$lambda$0$2);
    }

    private static final KFunction FOLLOW$lambda$0$0() {
        return (KFunction)FOLLOW.2.1.1.INSTANCE;
    }

    private static final void FOLLOW$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void FOLLOW$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.2);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)510);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0.0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)13);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)516);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
    }

    private static final void MAZE_SHADOWS$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "Maze Shadow";
        $this$entity.spawns = (Holder)TBSSpawnConditions.MAZE_SHADOW;
        $this$entity.setRenderer(TBSEntities::MAZE_SHADOWS$lambda$0$0);
        $this$entity.biomeSpawn(5, 1, 1);
        $this$entity.props(TBSEntities::MAZE_SHADOWS$lambda$0$1);
        $this$entity.attrs((Function0)MAZE_SHADOWS.2.3.INSTANCE, TBSEntities::MAZE_SHADOWS$lambda$0$2);
    }

    private static final KFunction MAZE_SHADOWS$lambda$0$0() {
        return (KFunction)MAZE_SHADOWS.2.1.1.INSTANCE;
    }

    private static final void MAZE_SHADOWS$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void MAZE_SHADOWS$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.3);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)16);
    }

    private static final void STARE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::STARE$lambda$0$0);
        $this$entity.props(TBSEntities::STARE$lambda$0$1);
        $this$entity.attrs((Function0)new Function0<AttributeSupplier.Builder>((Object)INSTANCE){

            public final AttributeSupplier.Builder invoke() {
                return TBSEntities.access$makeCommonAttrs((TBSEntities)this.receiver);
            }
        }, TBSEntities::STARE$lambda$0$2);
    }

    private static final KFunction STARE$lambda$0$0() {
        return (KFunction)STARE.2.1.1.INSTANCE;
    }

    private static final void STARE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.001f, 0.001f);
    }

    private static final void STARE$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)0.6);
    }

    private static final void DECEIVER$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Null (Deceiver)";
        $this$entity.setRenderer(TBSEntities::DECEIVER$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.ENTITY;
        $this$entity.biomeSpawn(2, 1, 1);
        $this$entity.props(TBSEntities::DECEIVER$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)DeceiverEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((DeceiverEntity.Companion)this.receiver).createAttributes();
            }
        }), null, (int)2, null);
    }

    private static final Function1 DECEIVER$lambda$0$0() {
        return BasicTexturedRenderer.Companion.textured$default((BasicTexturedRenderer.Companion)BasicTexturedRenderer.Companion, (ResourceLocation)TBSConstants.id("textures/entities/anomaly1new.png"), (float)0.0f, (int)2, null);
    }

    private static final void DECEIVER$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void HEROBRINE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::HEROBRINE$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.HEROBRINE_CONDITIONS;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::HEROBRINE$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)HerobrineEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((HerobrineEntity.Companion)this.receiver).createAttributes();
            }
        }), null, (int)2, null);
    }

    private static final KFunction HEROBRINE$lambda$0$0() {
        return (KFunction)HEROBRINE.2.1.1.INSTANCE;
    }

    private static final void HEROBRINE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void THE_OBLITERATION$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Obliteration";
        $this$entity.setRenderer(TBSEntities::THE_OBLITERATION$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.OBLIT;
        $this$entity.biomeSpawn(2, 1, 1);
        $this$entity.props(TBSEntities::THE_OBLITERATION$lambda$0$1);
        $this$entity.attrs((Function0)THE_OBLITERATION.2.3.INSTANCE, TBSEntities::THE_OBLITERATION$lambda$0$2);
    }

    private static final KFunction THE_OBLITERATION$lambda$0$0() {
        return (KFunction)THE_OBLITERATION.2.1.1.INSTANCE;
    }

    private static final void THE_OBLITERATION$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(12.0f, 14.0f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void THE_OBLITERATION$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)1);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)1000);
        AttributeUtil.setFlyingSpeed((AttributeSupplier.Builder)$this$attrs, (Number)1);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)0.6);
    }

    private static final void THE_OBLITERATION_2$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Obliteration";
        $this$entity.setRenderer(TBSEntities::THE_OBLITERATION_2$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.OBLIT;
        $this$entity.biomeSpawn(2, 1, 1);
        $this$entity.props(TBSEntities::THE_OBLITERATION_2$lambda$0$1);
        $this$entity.attrs((Function0)THE_OBLITERATION_2.2.3.INSTANCE, TBSEntities::THE_OBLITERATION_2$lambda$0$2);
    }

    private static final KFunction THE_OBLITERATION_2$lambda$0$0() {
        return (KFunction)THE_OBLITERATION_2.2.1.1.INSTANCE;
    }

    private static final void THE_OBLITERATION_2$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(12.0f, 14.0f);
        $this$props.canSpawnFarFromPlayer();
    }

    private static final void THE_OBLITERATION_2$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)1);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)1000);
        AttributeUtil.setFlyingSpeed((AttributeSupplier.Builder)$this$attrs, (Number)1);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)0.6);
    }

    private static final void PHANTOM_PLAYER$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.lang = "Phantom Player (notexture)";
        $this$entity.setRenderer(TBSEntities::PHANTOM_PLAYER$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.DEFAULT;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::PHANTOM_PLAYER$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)INSTANCE){

            public final AttributeSupplier.Builder invoke() {
                return TBSEntities.access$makeCommonAttrs((TBSEntities)this.receiver);
            }
        }), null, (int)2, null);
    }

    private static final KFunction PHANTOM_PLAYER$lambda$0$0() {
        return (KFunction)PHANTOM_PLAYER.2.1.1.INSTANCE;
    }

    private static final void PHANTOM_PLAYER$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void SUB_ANOMALY_1$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::SUB_ANOMALY_1$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.ANOMALY;
        $this$entity.biomeSpawn(5, 1, 1);
        $this$entity.props(TBSEntities::SUB_ANOMALY_1$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)SubAnomaly1Entity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((SubAnomaly1Entity.Companion)this.receiver).attributes();
            }
        }), null, (int)2, null);
    }

    private static final KFunction SUB_ANOMALY_1$lambda$0$0() {
        return (KFunction)SUB_ANOMALY_1.2.1.1.INSTANCE;
    }

    private static final void SUB_ANOMALY_1$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 0.8f);
    }

    private static final void SUB_ANOMALY_2$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::SUB_ANOMALY_2$lambda$0$0);
        $this$entity.props(TBSEntities::SUB_ANOMALY_2$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)SubAnomaly2Entity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((SubAnomaly2Entity.Companion)this.receiver).attributes();
            }
        }), null, (int)2, null);
        $this$entity.brain(SubAnomaly2Ai.INSTANCE.getAi());
    }

    private static final KFunction SUB_ANOMALY_2$lambda$0$0() {
        return (KFunction)SUB_ANOMALY_2.2.1.1.INSTANCE;
    }

    private static final void SUB_ANOMALY_2$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 0.8f);
    }

    private static final void MURDERFUR$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::MURDERFUR$lambda$0$0);
        $this$entity.props(TBSEntities::MURDERFUR$lambda$0$1);
        $this$entity.attrs((Function0)MURDERFUR.2.3.INSTANCE, TBSEntities::MURDERFUR$lambda$0$2);
    }

    private static final KFunction MURDERFUR$lambda$0$0() {
        return (KFunction)MURDERFUR.2.1.1.INSTANCE;
    }

    private static final void MURDERFUR$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.sized(0.5f, 1.5f);
    }

    private static final void MURDERFUR$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)1000);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)400);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)1.5);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)1);
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.3);
    }

    private static final void NULL_COD$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.WATER_CREATURE;
        $this$entity.setRenderer(TBSEntities::NULL_COD$lambda$0$0);
        $this$entity.props(TBSEntities::NULL_COD$lambda$0$1);
        $this$entity.attrs((Function0)NULL_COD.2.3.INSTANCE, TBSEntities::NULL_COD$lambda$0$2);
    }

    private static final KFunction NULL_COD$lambda$0$0() {
        return (KFunction)NULL_COD.2.1.1.INSTANCE;
    }

    private static final void NULL_COD$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sized(0.5f, 0.25f);
    }

    private static final void NULL_COD$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)4);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
    }

    private static final void JON$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.CREATURE;
        $this$entity.setRenderer(TBSEntities::JON$lambda$0$0);
        $this$entity.props(TBSEntities::JON$lambda$0$1);
        $this$entity.attrs((Function0)JON.2.3.INSTANCE, TBSEntities::JON$lambda$0$2);
    }

    private static final KFunction JON$lambda$0$0() {
        return (KFunction)JON.2.1.1.INSTANCE;
    }

    private static final void JON$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sized(1.0f, 2.0f);
    }

    private static final void JON$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)20);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)400);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)1.5);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)1);
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.1);
    }

    private static final void NOTHING_WATCHER$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::NOTHING_WATCHER$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.NOTHING_WATCHER;
        $this$entity.props(TBSEntities::NOTHING_WATCHER$lambda$0$1);
        $this$entity.attrs((Function0)NOTHING_WATCHER.2.3.INSTANCE, TBSEntities::NOTHING_WATCHER$lambda$0$2);
    }

    private static final KFunction NOTHING_WATCHER$lambda$0$0() {
        return (KFunction)NOTHING_WATCHER.2.1.1.INSTANCE;
    }

    private static final void NOTHING_WATCHER$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sized(0.5f, 2.0f);
    }

    private static final void NOTHING_WATCHER$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
    }

    private static final void NAME_TAG$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.lang = "Name Tag";
        $this$entity.spawns = (Holder)TBSSpawnConditions.NAME_TAG;
        $this$entity.setRenderer(TBSEntities::NAME_TAG$lambda$0$0);
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::NAME_TAG$lambda$0$1);
        $this$entity.attrs((Function0)NAME_TAG.2.3.INSTANCE, TBSEntities::NAME_TAG$lambda$0$2);
    }

    private static final Function1 NAME_TAG$lambda$0$0() {
        return TBSEntities.invis$default(INSTANCE, 0.0f, 1, null);
    }

    private static final void NAME_TAG$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.6f, 1.8f);
    }

    private static final void NAME_TAG$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.3);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)3);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)16);
    }

    private static final void INTEGRITY_PHASE_1$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::INTEGRITY_PHASE_1$lambda$0$0);
        $this$entity.lang = "\u00a7k\u00a7cIntegrity\u00a7r";
        $this$entity.props(TBSEntities::INTEGRITY_PHASE_1$lambda$0$1);
        $this$entity.attrs((Function0)INTEGRITY_PHASE_1.2.3.INSTANCE, TBSEntities::INTEGRITY_PHASE_1$lambda$0$2);
    }

    private static final KFunction INTEGRITY_PHASE_1$lambda$0$0() {
        return (KFunction)INTEGRITY_PHASE_1.2.1.1.INSTANCE;
    }

    private static final void INTEGRITY_PHASE_1$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(1.0f, 10.0f);
    }

    private static final void INTEGRITY_PHASE_1$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)50);
    }

    private static final void INTEGRITY_PHASE_2$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::INTEGRITY_PHASE_2$lambda$0$0);
        $this$entity.lang = "\u00a7k\u00a7cIntegrity\u00a7r";
        $this$entity.props(TBSEntities::INTEGRITY_PHASE_2$lambda$0$1);
        $this$entity.attrs((Function0)INTEGRITY_PHASE_2.2.3.INSTANCE, TBSEntities::INTEGRITY_PHASE_2$lambda$0$2);
    }

    private static final KFunction INTEGRITY_PHASE_2$lambda$0$0() {
        return (KFunction)INTEGRITY_PHASE_2.2.1.1.INSTANCE;
    }

    private static final void INTEGRITY_PHASE_2$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.96f, 2.16f);
    }

    private static final void INTEGRITY_PHASE_2$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)25);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)5);
    }

    private static final void INTEGRITY_PHASE_3$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::INTEGRITY_PHASE_3$lambda$0$0);
        $this$entity.lang = "\u00a7k\u00a7cIntegrity\u00a7r";
        $this$entity.props(TBSEntities::INTEGRITY_PHASE_3$lambda$0$1);
        $this$entity.attrs((Function0)INTEGRITY_PHASE_3.2.3.INSTANCE, TBSEntities::INTEGRITY_PHASE_3$lambda$0$2);
    }

    private static final KFunction INTEGRITY_PHASE_3$lambda$0$0() {
        return (KFunction)INTEGRITY_PHASE_3.2.1.1.INSTANCE;
    }

    private static final void INTEGRITY_PHASE_3$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(5.0f, 32.0f);
    }

    private static final void INTEGRITY_PHASE_3$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)1024);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)5);
    }

    private static final void INTEGRITY_ARM$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::INTEGRITY_ARM$lambda$0$0);
        $this$entity.lang = "\u00a7k\u00a7cIntegrity\u00a7r";
        $this$entity.props(TBSEntities::INTEGRITY_ARM$lambda$0$1);
        $this$entity.attrs((Function0)INTEGRITY_ARM.2.3.INSTANCE, TBSEntities::INTEGRITY_ARM$lambda$0$2);
    }

    private static final KFunction INTEGRITY_ARM$lambda$0$0() {
        return (KFunction)INTEGRITY_ARM.2.1.1.INSTANCE;
    }

    private static final void INTEGRITY_ARM$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(2.0f, 5.0f);
        $this$props.noSave();
    }

    private static final void INTEGRITY_ARM$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)1024);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)50);
    }

    private static final void INTEGRITY_CURIOUS$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::INTEGRITY_CURIOUS$lambda$0$0);
        $this$entity.lang = "Integrity.Curious";
        $this$entity.props(TBSEntities::INTEGRITY_CURIOUS$lambda$0$1);
        $this$entity.attrs((Function0)INTEGRITY_CURIOUS.2.3.INSTANCE, TBSEntities::INTEGRITY_CURIOUS$lambda$0$2);
    }

    private static final KFunction INTEGRITY_CURIOUS$lambda$0$0() {
        return (KFunction)INTEGRITY_CURIOUS.2.1.1.INSTANCE;
    }

    private static final void INTEGRITY_CURIOUS$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(1.0f, 10.0f);
    }

    private static final void INTEGRITY_CURIOUS$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)50);
    }

    private static final void FRACTURED$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::FRACTURED$lambda$0$0);
        $this$entity.props(TBSEntities::FRACTURED$lambda$0$1);
        $this$entity.attrs((Function0)FRACTURED.2.3.INSTANCE, TBSEntities::FRACTURED$lambda$0$2);
    }

    private static final KFunction FRACTURED$lambda$0$0() {
        return (KFunction)FRACTURED.2.1.1.INSTANCE;
    }

    private static final void FRACTURED$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.clientTrackingRange(256);
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.sized(10.0f, 30.0f);
    }

    private static final void FRACTURED$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)1.5);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)12);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)1000);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)100);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)1.0);
    }

    private static final void FRACTURED_ROAM$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::FRACTURED_ROAM$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.FRACTURED_CONDITIONS;
        $this$entity.biomeSpawn(1, 1, 1);
        $this$entity.props(TBSEntities::FRACTURED_ROAM$lambda$0$1);
        $this$entity.attrs((Function0)FRACTURED_ROAM.2.3.INSTANCE, TBSEntities::FRACTURED_ROAM$lambda$0$2);
    }

    private static final KFunction FRACTURED_ROAM$lambda$0$0() {
        return (KFunction)FRACTURED_ROAM.2.1.1.INSTANCE;
    }

    private static final void FRACTURED_ROAM$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.sized(10.0f, 30.0f);
    }

    private static final void FRACTURED_ROAM$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)1.5);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)1000);
        AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)100);
    }

    private static final void ROCK$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MISC;
        $this$entity.setRenderer(TBSEntities::ROCK$lambda$0$0);
        $this$entity.props(TBSEntities::ROCK$lambda$0$1);
    }

    private static final KFunction ROCK$lambda$0$0() {
        return (KFunction)ROCK.2.1.1.INSTANCE;
    }

    private static final void ROCK$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(30.0f, 30.0f);
    }

    private static final void FEVER$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::FEVER$lambda$0$0);
        $this$entity.props(TBSEntities::FEVER$lambda$0$1);
        $this$entity.attrs((Function0)FEVER.2.3.INSTANCE, TBSEntities::FEVER$lambda$0$2);
    }

    private static final KFunction FEVER$lambda$0$0() {
        return (KFunction)FEVER.2.1.1.INSTANCE;
    }

    private static final void FEVER$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(1.0f, 10.0f);
    }

    private static final void FEVER$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)10);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setGravity((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFlyingSpeed((AttributeSupplier.Builder)$this$attrs, (Number)10);
    }

    private static final void FEVER_STALK$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::FEVER_STALK$lambda$0$0);
        $this$entity.spawns = (Holder)TBSSpawnConditions.FEVER_STALK_CONDITIONS;
        $this$entity.biomeSpawn(15, 1, 1);
        $this$entity.props(TBSEntities::FEVER_STALK$lambda$0$1);
        $this$entity.attrs((Function0)FEVER_STALK.2.3.INSTANCE, TBSEntities::FEVER_STALK$lambda$0$2);
    }

    private static final KFunction FEVER_STALK$lambda$0$0() {
        return (KFunction)FEVER_STALK.2.1.1.INSTANCE;
    }

    private static final void FEVER_STALK$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.clientTrackingRange(256);
        $this$props.fireImmune();
        $this$props.sized(1.0f, 10.0f);
    }

    private static final void FEVER_STALK$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)200);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setGravity((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFlyingSpeed((AttributeSupplier.Builder)$this$attrs, (Number)10);
    }

    private static final void CHORD$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MONSTER;
        $this$entity.setRenderer(TBSEntities::CHORD$lambda$0$0);
        $this$entity.props(TBSEntities::CHORD$lambda$0$1);
        $this$entity.attrs((Function0)CHORD.2.3.INSTANCE, TBSEntities::CHORD$lambda$0$2);
    }

    private static final KFunction CHORD$lambda$0$0() {
        return (KFunction)CHORD.2.1.1.INSTANCE;
    }

    private static final void CHORD$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(2.0f, 2.0f);
    }

    private static final void CHORD$lambda$0$2(AttributeSupplier.Builder $this$attrs) {
        Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
        AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)1);
        AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)32);
        AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)4);
        AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)50);
        AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setGravity((AttributeSupplier.Builder)$this$attrs, (Number)0);
        AttributeUtil.setFlyingSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.4);
    }

    private static final void CHORD_PROJECTILE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MISC;
        $this$entity.setRenderer(TBSEntities::CHORD_PROJECTILE$lambda$0$0);
        $this$entity.props(TBSEntities::CHORD_PROJECTILE$lambda$0$1);
    }

    private static final KFunction CHORD_PROJECTILE$lambda$0$0() {
        return (KFunction)CHORD_PROJECTILE.2.1.1.INSTANCE;
    }

    private static final void CHORD_PROJECTILE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(0.5f, 1.15f);
    }

    private static final void TETHER$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::TETHER$lambda$0$0);
        $this$entity.props(TBSEntities::TETHER$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)TetherEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((TetherEntity.Companion)this.receiver).attributes();
            }
        }), null, (int)2, null);
    }

    private static final KFunction TETHER$lambda$0$0() {
        return (KFunction)TETHER.2.1.1.INSTANCE;
    }

    private static final void TETHER$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.sized(1.0f, 3.0f);
    }

    private static final void VOID_TENTACLE$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = TBSMobCategories.MOBS;
        $this$entity.setRenderer(TBSEntities::VOID_TENTACLE$lambda$0$0);
        $this$entity.props(TBSEntities::VOID_TENTACLE$lambda$0$1);
        EntityBuilder.attrs$default((EntityBuilder)$this$entity, (Function0)((Function0)new Function0<AttributeSupplier.Builder>((Object)VoidTentacleEntity.Companion){

            public final AttributeSupplier.Builder invoke() {
                return ((VoidTentacleEntity.Companion)this.receiver).attributes();
            }
        }), null, (int)2, null);
    }

    private static final KFunction VOID_TENTACLE$lambda$0$0() {
        return (KFunction)VOID_TENTACLE.2.1.1.INSTANCE;
    }

    private static final void VOID_TENTACLE$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.sized(1.0f, 2.0f);
    }

    private static final void INTEG_FIREBALL$lambda$0(EntityBuilder $this$entity) {
        Intrinsics.checkNotNullParameter((Object)$this$entity, (String)"$this$entity");
        $this$entity.category = MobCategory.MISC;
        $this$entity.setRenderer(TBSEntities::INTEG_FIREBALL$lambda$0$0);
        $this$entity.props(TBSEntities::INTEG_FIREBALL$lambda$0$1);
    }

    private static final KFunction INTEG_FIREBALL$lambda$0$0() {
        return (KFunction)INTEG_FIREBALL.2.1.1.INSTANCE;
    }

    private static final void INTEG_FIREBALL$lambda$0$1(EntityType.Builder $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        EntityTypeBuilderExt.INSTANCE.setUpdateInterval($this$props, 3);
        $this$props.fireImmune();
        $this$props.sized(1.0f, 1.0f);
    }

    public static final /* synthetic */ AttributeSupplier.Builder access$makeCommonAttrs(TBSEntities $this) {
        return $this.makeCommonAttrs();
    }
}

