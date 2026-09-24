/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.advancements.Advancement
 *  net.minecraft.client.model.geom.ModelLayerLocation
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.Registry
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.core.component.DataComponentType$Builder
 *  net.minecraft.core.particles.ParticleType
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.PreparableReloadListener
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.CreativeModeTab
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.JukeboxSong
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.advancements.Advancement;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.data.DataAttachment;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.brokencore.api.event.RandomEvent;
import net.thebrokenscript.brokencore.api.event.StoryEvent;
import net.thebrokenscript.brokencore.api.platform.PlatformAttachments;
import net.thebrokenscript.brokencore.api.platform.PlatformRegistries;
import net.thebrokenscript.brokencore.api.registry.BCRegistries;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.biomeSpawns.IBiomeSpawns;
import net.thebrokenscript.brokencore.api.registry.builders.AdvancementBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockEntityBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockItemBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.ChatResponseBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.CreativeTabBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.DamageTypeBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.EntityBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.EventBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.ItemBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.JukeboxSongBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.MenuBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.ShapedRecipeBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.ShapelessRecipeBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.SimpleParticleBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.SoundBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.StoryEventBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.MenuConstructor;
import net.thebrokenscript.brokencore.api.registry.datagen.AdvancementGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.BlockModelGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.BlockStateGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.BuiltInTagGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.DamageTypeGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.DataManager;
import net.thebrokenscript.brokencore.api.registry.datagen.ItemModelGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.JukeboxSongGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.LangGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.LootTableGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.RecipeGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.SoundGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.TagGenerator;
import net.thebrokenscript.brokencore.api.registry.datagen.VanillaTagGenerator;
import net.thebrokenscript.brokencore.api.registry.handlers.ClientEntityHandler;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import net.thebrokenscript.brokencore.api.registry.objects.BuiltObject;
import net.thebrokenscript.brokencore.api.registry.objects.EntityEntry;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import net.thebrokenscript.brokencore.api.registry.objects.MenuEntry;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.api.registry.objects.TagObject;
import net.thebrokenscript.brokencore.api.registry.util.BuiltInTagBuilder;
import net.thebrokenscript.brokencore.api.registry.util.TagBuilder;
import net.thebrokenscript.brokencore.api.registry.util.VanillaTagBuilder;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.brokencore.api.util.InstanceConsumer;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.registry.RegistrationHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00ec\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00108\u001a\u0002092\u0006\u00108\u001a\u00020\u0003JL\u0010:\u001a\b\u0012\u0004\u0012\u0002H;0\u001d\"\u0004\b\u0000\u0010;\"\b\b\u0001\u0010<*\u0002H;\"\u0014\b\u0002\u0010=*\u000e\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002H<0>2\u0018\u0010?\u001a\u0014\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H=0\u001aJL\u0010@\u001a\u000e\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002H<0>\"\u0004\b\u0000\u0010;\"\b\b\u0001\u0010<*\u0002H;2\u0012\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H;0B0\u001d2\u0006\u0010C\u001a\u00020\u00032\f\u0010D\u001a\b\u0012\u0004\u0012\u0002H<0EJH\u0010F\u001a\b\u0012\u0004\u0012\u0002H<0\u0013\"\b\b\u0000\u0010<*\u00020\u00142\u0006\u0010C\u001a\u00020\u00032\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u0002H<0H2\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0K0\u0015J1\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010C\u001a\u00020\u00032\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140K0\u0015H\u0007\u00a2\u0006\u0002\bLJH\u0010M\u001a\b\u0012\u0004\u0012\u0002H<0N\"\b\b\u0000\u0010<*\u00020\u001f2\u0006\u0010C\u001a\u00020\u00032\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u0002H<0H2\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0P0\u0015J1\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001f0N2\u0006\u0010C\u001a\u00020\u00032\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0P0\u0015H\u0007\u00a2\u0006\u0002\bQJ4\u0010R\u001a\b\u0012\u0004\u0012\u00020S0N\"\b\b\u0000\u0010T*\u00020\u00142\u0006\u0010F\u001a\u00020\u00032\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HT0U0\u0015JZ\u0010V\u001a\b\u0012\u0004\u0012\u0002H<0W\"\b\b\u0000\u0010<*\u00020X2\u0006\u0010C\u001a\u00020\u00032$\u0010G\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0Z\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u0002H<0Y2\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0]0\u0015JT\u0010^\u001a\b\u0012\u0004\u0012\u0002H<0_\"\b\b\u0000\u0010<*\u00020`2\u0006\u0010C\u001a\u00020\u00032\u001e\u0010G\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0b\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u0002H<0a2\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0d0\u0015J*\u0010e\u001a\u000e\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020f0>2\u0006\u0010C\u001a\u00020\u00032\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020g0\u0015JH\u0010h\u001a\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u0002H<0>\"\b\b\u0000\u0010<*\u00020i2\u0006\u0010C\u001a\u00020\u00032\f\u0010G\u001a\b\u0012\u0004\u0012\u0002H<0E2\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0j0\u0015JH\u0010k\u001a\u000e\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u0002H<0>\"\b\b\u0000\u0010<*\u00020l2\u0006\u0010C\u001a\u00020\u00032\f\u0010G\u001a\b\u0012\u0004\u0012\u0002H<0E2\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0m0\u0015JH\u0010n\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u0002H<0>\"\b\b\u0000\u0010<*\u00020o2\u0006\u0010C\u001a\u00020\u00032\f\u0010G\u001a\b\u0012\u0004\u0012\u0002H<0E2\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0p0\u0015JF\u0010q\u001a\b\u0012\u0004\u0012\u0002H<0\u000b\"\u0004\b\u0000\u0010<2\u0014\u0010r\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H<0B0\u001d2\u0006\u0010C\u001a\u00020\u00032\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0s0\u0015JF\u0010t\u001a\b\u0012\u0004\u0012\u0002H<0\u000b\"\u0004\b\u0000\u0010<2\u0014\u0010r\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H<0B0\u001d2\u0006\u0010C\u001a\u00020\u00032\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0u0\u0015JF\u0010v\u001a\b\u0012\u0004\u0012\u0002H<0\u000b\"\u0004\b\u0000\u0010<2\u0014\u0010r\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H<0B0\u001d2\u0006\u0010C\u001a\u00020\u00032\u0014\b\u0002\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H<0w0\u0015J*\u0010x\u001a\u000e\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020y0>2\u0006\u0010C\u001a\u00020\u00032\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020z0\u0015J*\u0010x\u001a\u000e\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020y0>2\u0006\u0010C\u001a\u0002092\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020z0\u0015J0\u0010{\u001a\u00020|2\u0006\u0010C\u001a\u00020\u00032\u0006\u0010}\u001a\u0002092\b\b\u0002\u0010~\u001a\u00020\u007f2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020|0\u0015J3\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0006\u0010C\u001a\u00020\u00032\u0006\u0010}\u001a\u0002092\b\b\u0002\u0010~\u001a\u00020\u007f2\u000f\b\u0002\u0010J\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010\u0015J@\u0010\u0082\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0005\u0012\u00030\u0083\u00010>2\u0006\u0010C\u001a\u00020\u00032\u0006\u0010x\u001a\u00020y2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u000f\b\u0002\u0010J\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u0015JG\u0010\u0082\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0005\u0012\u00030\u0083\u00010>2\u0006\u0010C\u001a\u00020\u00032\r\u0010x\u001a\t\u0012\u0004\u0012\u00020y0\u0087\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u000f\b\u0002\u0010J\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u0015JK\u0010\u0088\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008a\u00010\u0089\u0001\"\n\b\u0000\u0010\u008a\u0001*\u00030\u008b\u00012\u0006\u0010C\u001a\u00020\u00032\u000e\u0010G\u001a\n\u0012\u0005\u0012\u0003H\u008a\u00010\u008c\u00012\u0016\b\u0002\u0010J\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u008a\u00010\u008d\u00010\u0015J+\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0>2\u0006\u0010C\u001a\u00020\u00032\u000f\b\u0002\u0010J\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\u0015J.\u0010\u008f\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0005\u0012\u00030\u0090\u00010>2\u0006\u0010C\u001a\u00020\u00032\u000f\b\u0002\u0010J\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010\u0015J2\u0010\u0092\u0001\u001a\u0014\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u0093\u0001\u0012\u0005\u0012\u00030\u0094\u00010>2\u0006\u0010C\u001a\u00020\u00032\u000f\b\u0002\u0010J\u001a\t\u0012\u0005\u0012\u00030\u0095\u00010\u0015J,\u0010\u0096\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0097\u0001\u0012\u0005\u0012\u00030\u0097\u00010>2\u0006\u0010C\u001a\u00020\u00032\r\u0010G\u001a\t\u0012\u0005\u0012\u00030\u0097\u00010EJ/\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u0002H<0\u0099\u0001\"\t\b\u0000\u0010<*\u00030\u009a\u00012\u0006\u00108\u001a\u00020\u00032\f\u0010G\u001a\b\u0012\u0004\u0012\u0002H<0EJP\u0010\u009b\u0001\u001a\u001a\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u009c\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002H<0\u009c\u00010>\"\u0004\b\u0000\u0010<2\u0006\u00108\u001a\u00020\u00032!\u0010\u009d\u0001\u001a\u001c\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002H<0\u009e\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002H<0\u009e\u00010HJ%\u0010\u009f\u0001\u001a\u00030\u00a0\u00012\b\u0010\u00a1\u0001\u001a\u00030\u00a2\u00012\u000f\u0010\u00a3\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a5\u00010\u00a4\u0001H\u0007J\u0011\u0010\u00a6\u0001\u001a\u00030\u00a0\u00012\u0007\u0010\u00a7\u0001\u001a\u00020-J\u0012\u0010\u00a8\u0001\u001a\u00030\u00a0\u00012\b\u0010\u00a9\u0001\u001a\u00030\u00aa\u0001J8\u0010\u00ab\u0001\u001a\u00030\u00a0\u00012\b\u0010\u00ac\u0001\u001a\u00030\u00ad\u00012\r\u0010&\u001a\t\u0012\u0004\u0012\u00020'0\u00ae\u00012\u0015\u0010\u00af\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u00b0\u0001\u0012\u0005\u0012\u00030\u00a0\u00010HR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007RX\u0010\b\u001aF\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\n0\tj\"\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\n`\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fRX\u0010\u0010\u001aF\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\n0\tj\"\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\n`\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fRT\u0010\u0012\u001aB\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00160\u00150\tj \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00160\u0015`\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR \u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001a0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\u001b\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001d0\u00190\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0017\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\"\u00103\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006\u00b1\u0001"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "", "modId", "", "<init>", "(Ljava/lang/String;)V", "getModId", "()Ljava/lang/String;", "vanillaTagKeys", "Ljava/util/LinkedHashMap;", "Lkotlin/Pair;", "Lnet/minecraft/tags/TagKey;", "Lnet/thebrokenscript/brokencore/api/registry/objects/TagObject;", "Lkotlin/collections/LinkedHashMap;", "getVanillaTagKeys$brokencore_common", "()Ljava/util/LinkedHashMap;", "builtInTagKeys", "getBuiltInTagKeys$brokencore_common", "vanillaBlockTags", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "Lnet/minecraft/world/level/block/Block;", "Lnet/thebrokenscript/brokencore/api/util/InstanceConsumer;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockTagsBuilder;", "getVanillaBlockTags$brokencore_common", "registrationQueue", "", "Lnet/thebrokenscript/brokencore/api/registry/objects/BuiltObject;", "creativeTabs", "", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/item/CreativeModeTab;", "Lnet/minecraft/world/item/Item;", "getCreativeTabs", "()Ljava/util/Map;", "data", "Lnet/thebrokenscript/brokencore/api/registry/datagen/DataManager;", "getData", "()Lnet/thebrokenscript/brokencore/api/registry/datagen/DataManager;", "registries", "Lnet/minecraft/core/HolderLookup$Provider;", "getRegistries", "()Lnet/minecraft/core/HolderLookup$Provider;", "setRegistries", "(Lnet/minecraft/core/HolderLookup$Provider;)V", "reloadListeners", "Lnet/minecraft/server/packs/resources/PreparableReloadListener;", "getReloadListeners", "()Ljava/util/List;", "biomeSpawns", "Lnet/thebrokenscript/brokencore/api/registry/biomeSpawns/IBiomeSpawns;", "getBiomeSpawns", "creativeTab", "getCreativeTab", "()Lnet/minecraft/resources/ResourceKey;", "setCreativeTab", "(Lnet/minecraft/resources/ResourceKey;)V", "id", "Lnet/minecraft/resources/ResourceLocation;", "accept", "R", "T", "E", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "built", "generic", "registry", "Lnet/minecraft/core/Registry;", "name", "getter", "Lkotlin/Function0;", "block", "ctor", "Lkotlin/Function1;", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "config", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockBuilder;", "defaultBlock", "item", "Lnet/thebrokenscript/brokencore/api/registry/objects/ItemEntry;", "Lnet/minecraft/world/item/Item$Properties;", "Lnet/thebrokenscript/brokencore/api/registry/builders/ItemBuilder;", "defaultItem", "blockItem", "Lnet/minecraft/world/item/BlockItem;", "B", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockItemBuilder;", "blockEntity", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntityEntry;", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "Lkotlin/Function3;", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "Lnet/minecraft/core/BlockPos;", "Lnet/minecraft/world/level/block/state/BlockState;", "Lnet/thebrokenscript/brokencore/api/registry/builders/BlockEntityBuilder;", "entity", "Lnet/thebrokenscript/brokencore/api/registry/objects/EntityEntry;", "Lnet/minecraft/world/entity/Entity;", "Lkotlin/Function2;", "Lnet/minecraft/world/entity/EntityType;", "Lnet/minecraft/world/level/Level;", "Lnet/thebrokenscript/brokencore/api/registry/builders/EntityBuilder;", "advancement", "Lnet/minecraft/advancements/Advancement;", "Lnet/thebrokenscript/brokencore/api/registry/builders/AdvancementBuilder;", "chatResponse", "Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "Lnet/thebrokenscript/brokencore/api/registry/builders/ChatResponseBuilder;", "event", "Lnet/thebrokenscript/brokencore/api/event/RandomEvent;", "Lnet/thebrokenscript/brokencore/api/registry/builders/EventBuilder;", "storyEvent", "Lnet/thebrokenscript/brokencore/api/event/StoryEvent;", "Lnet/thebrokenscript/brokencore/api/registry/builders/StoryEventBuilder;", "tag", "registryKey", "Lnet/thebrokenscript/brokencore/api/registry/util/TagBuilder;", "vanillaTag", "Lnet/thebrokenscript/brokencore/api/registry/util/VanillaTagBuilder;", "builtInTag", "Lnet/thebrokenscript/brokencore/api/registry/util/BuiltInTagBuilder;", "sound", "Lnet/minecraft/sounds/SoundEvent;", "Lnet/thebrokenscript/brokencore/api/registry/builders/SoundBuilder;", "shapedRecipe", "Lnet/thebrokenscript/brokencore/api/registry/builders/ShapedRecipeBuilder;", "result", "count", "", "shapelessRecipe", "Lnet/thebrokenscript/brokencore/api/registry/builders/ShapelessRecipeBuilder;", "jukeboxSong", "Lnet/minecraft/world/item/JukeboxSong;", "length", "", "Lnet/thebrokenscript/brokencore/api/registry/builders/JukeboxSongBuilder;", "Lnet/minecraft/core/Holder;", "menu", "Lnet/thebrokenscript/brokencore/api/registry/objects/MenuEntry;", "M", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/MenuConstructor;", "Lnet/thebrokenscript/brokencore/api/registry/builders/MenuBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/builders/CreativeTabBuilder;", "damageType", "Lnet/minecraft/world/damagesource/DamageType;", "Lnet/thebrokenscript/brokencore/api/registry/builders/DamageTypeBuilder;", "simpleParticle", "Lnet/minecraft/core/particles/ParticleType;", "Lnet/minecraft/core/particles/SimpleParticleType;", "Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleParticleBuilder;", "spawnConditions", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "dataAttachment", "Lnet/thebrokenscript/brokencore/api/data/DataAttachment;", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "dataComponent", "Lnet/minecraft/core/component/DataComponentType;", "builder", "Lnet/minecraft/core/component/DataComponentType$Builder;", "modelLayer", "", "loc", "Lnet/minecraft/client/model/geom/ModelLayerLocation;", "def", "Ljava/util/function/Supplier;", "Lnet/minecraft/client/model/geom/builders/LayerDefinition;", "reloadListener", "listener", "registerAll", "handler", "Lnet/thebrokenscript/brokencore/impl/registry/RegistrationHandler;", "registerDataGenerators", "output", "Lnet/minecraft/data/PackOutput;", "Ljava/util/concurrent/CompletableFuture;", "consumer", "Lnet/minecraft/data/DataProvider;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBrokenReg.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrokenReg.kt\nnet/thebrokenscript/brokencore/api/registry/BrokenReg\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,370:1\n1#2:371\n1869#3,2:372\n*S KotlinDebug\n*F\n+ 1 BrokenReg.kt\nnet/thebrokenscript/brokencore/api/registry/BrokenReg\n*L\n342#1:372,2\n*E\n"})
public class BrokenReg {
    @NotNull
    private final String modId;
    @NotNull
    private final LinkedHashMap<String, Pair<TagKey<?>, TagObject<?>>> vanillaTagKeys;
    @NotNull
    private final LinkedHashMap<String, Pair<TagKey<?>, TagObject<?>>> builtInTagKeys;
    @NotNull
    private final LinkedHashMap<BlockEntry<Block>, InstanceConsumer<BlockTagsBuilder<Block>>> vanillaBlockTags;
    @NotNull
    private final List<BuiltObject<?, ?, ?>> registrationQueue;
    @NotNull
    private final Map<ResourceKey<CreativeModeTab>, List<ResourceKey<Item>>> creativeTabs;
    @NotNull
    private final DataManager data;
    public HolderLookup.Provider registries;
    @NotNull
    private final List<PreparableReloadListener> reloadListeners;
    @NotNull
    private final List<IBiomeSpawns> biomeSpawns;
    @Nullable
    private ResourceKey<CreativeModeTab> creativeTab;

    public BrokenReg(@NotNull String modId) {
        Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
        this.modId = modId;
        this.vanillaTagKeys = new LinkedHashMap();
        this.builtInTagKeys = new LinkedHashMap();
        this.vanillaBlockTags = new LinkedHashMap();
        this.registrationQueue = new ArrayList();
        this.creativeTabs = new LinkedHashMap();
        this.data = new DataManager();
        this.reloadListeners = new ArrayList();
        this.biomeSpawns = new ArrayList();
        PlatformRegistries.Companion.getINSTANCE().setup(this);
    }

    @NotNull
    public final String getModId() {
        return this.modId;
    }

    @NotNull
    public final LinkedHashMap<String, Pair<TagKey<?>, TagObject<?>>> getVanillaTagKeys$brokencore_common() {
        return this.vanillaTagKeys;
    }

    @NotNull
    public final LinkedHashMap<String, Pair<TagKey<?>, TagObject<?>>> getBuiltInTagKeys$brokencore_common() {
        return this.builtInTagKeys;
    }

    @NotNull
    public final LinkedHashMap<BlockEntry<Block>, InstanceConsumer<BlockTagsBuilder<Block>>> getVanillaBlockTags$brokencore_common() {
        return this.vanillaBlockTags;
    }

    @NotNull
    public final Map<ResourceKey<CreativeModeTab>, List<ResourceKey<Item>>> getCreativeTabs() {
        return this.creativeTabs;
    }

    @NotNull
    public final DataManager getData() {
        return this.data;
    }

    @NotNull
    public final HolderLookup.Provider getRegistries() {
        HolderLookup.Provider provider = this.registries;
        if (provider != null) {
            return provider;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"registries");
        return null;
    }

    public final void setRegistries(@NotNull HolderLookup.Provider provider) {
        Intrinsics.checkNotNullParameter((Object)provider, (String)"<set-?>");
        this.registries = provider;
    }

    @NotNull
    public final List<PreparableReloadListener> getReloadListeners() {
        return this.reloadListeners;
    }

    @NotNull
    public final List<IBiomeSpawns> getBiomeSpawns() {
        return this.biomeSpawns;
    }

    @Nullable
    public final ResourceKey<CreativeModeTab> getCreativeTab() {
        return this.creativeTab;
    }

    public final void setCreativeTab(@Nullable ResourceKey<CreativeModeTab> resourceKey) {
        this.creativeTab = resourceKey;
    }

    @NotNull
    public final ResourceLocation id(@NotNull String id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)this.modId, (String)id);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    @NotNull
    public final <R, T extends R, E extends RegistryEntry<R, T>> ResourceKey<R> accept(@NotNull BuiltObject<R, T, E> built) {
        BuiltObject<R, T, E> builtObject2;
        Intrinsics.checkNotNullParameter(built, (String)"built");
        BuiltObject<R, T, E> it = builtObject2 = built;
        boolean bl = false;
        this.registrationQueue.add(it);
        return builtObject2.key();
    }

    @NotNull
    public final <R, T extends R> RegistryEntry<R, T> generic(@NotNull ResourceKey<Registry<R>> registry, @NotNull String name, @NotNull Function0<? extends T> getter) {
        Intrinsics.checkNotNullParameter(registry, (String)"registry");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        return new RegistryEntry(this.accept(new BuiltObject(registry, this.id(name), getter, BrokenReg::generic$lambda$0, generic.2.INSTANCE)));
    }

    @NotNull
    public final <T extends Block> BlockEntry<T> block(@NotNull String name, @NotNull Function1<? super BlockBehaviour.Properties, ? extends T> ctor, @NotNull InstanceConsumer<BlockBuilder<T>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return (BlockEntry)new BlockBuilder<T>(this, name, ctor).configure(config);
    }

    public static /* synthetic */ BlockEntry block$default(BrokenReg brokenReg, String string, Function1 function1, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: block");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::block$lambda$0;
        }
        return brokenReg.block(string, function1, instanceConsumer);
    }

    @JvmName(name="defaultBlock")
    @NotNull
    public final BlockEntry<Block> defaultBlock(@NotNull String name, @NotNull InstanceConsumer<BlockBuilder<Block>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return (BlockEntry)new BlockBuilder(this, name, block.3.INSTANCE).configure(config);
    }

    public static /* synthetic */ BlockEntry defaultBlock$default(BrokenReg brokenReg, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: block");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BrokenReg::block$lambda$1;
        }
        return brokenReg.defaultBlock(string, instanceConsumer);
    }

    @NotNull
    public final <T extends Item> ItemEntry<T> item(@NotNull String name, @NotNull Function1<? super Item.Properties, ? extends T> ctor, @NotNull InstanceConsumer<ItemBuilder<T>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return (ItemEntry)new ItemBuilder<T>(this, name, ctor).configure(config);
    }

    public static /* synthetic */ ItemEntry item$default(BrokenReg brokenReg, String string, Function1 function1, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::item$lambda$0;
        }
        return brokenReg.item(string, function1, instanceConsumer);
    }

    @JvmName(name="defaultItem")
    @NotNull
    public final ItemEntry<Item> defaultItem(@NotNull String name, @NotNull InstanceConsumer<ItemBuilder<Item>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return (ItemEntry)new ItemBuilder(this, name, item.3.INSTANCE).configure(config);
    }

    public static /* synthetic */ ItemEntry defaultItem$default(BrokenReg brokenReg, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BrokenReg::item$lambda$1;
        }
        return brokenReg.defaultItem(string, instanceConsumer);
    }

    @NotNull
    public final <B extends Block> ItemEntry<BlockItem> blockItem(@NotNull String block2, @NotNull InstanceConsumer<BlockItemBuilder<B>> config) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return (ItemEntry)new BlockItemBuilder(this, block2).configure(config);
    }

    public static /* synthetic */ ItemEntry blockItem$default(BrokenReg brokenReg, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blockItem");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BrokenReg::blockItem$lambda$0;
        }
        return brokenReg.blockItem(string, instanceConsumer);
    }

    @NotNull
    public final <T extends BlockEntity> BlockEntityEntry<T> blockEntity(@NotNull String name, @NotNull Function3<? super BlockEntityType<T>, ? super BlockPos, ? super BlockState, ? extends T> ctor, @NotNull InstanceConsumer<BlockEntityBuilder<T>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return (BlockEntityEntry)new BlockEntityBuilder<T>(this, name, ctor).configure(config);
    }

    public static /* synthetic */ BlockEntityEntry blockEntity$default(BrokenReg brokenReg, String string, Function3 function3, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blockEntity");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::blockEntity$lambda$0;
        }
        return brokenReg.blockEntity(string, function3, instanceConsumer);
    }

    @NotNull
    public final <T extends Entity> EntityEntry<T> entity(@NotNull String name, @NotNull Function2<? super EntityType<T>, ? super Level, ? extends T> ctor, @NotNull InstanceConsumer<EntityBuilder<T>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return (EntityEntry)new EntityBuilder<T>(this, name, ctor).configure(config);
    }

    public static /* synthetic */ EntityEntry entity$default(BrokenReg brokenReg, String string, Function2 function2, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: entity");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::entity$lambda$0;
        }
        return brokenReg.entity(string, function2, instanceConsumer);
    }

    @NotNull
    public final RegistryEntry<Advancement, Advancement> advancement(@NotNull String name, @NotNull InstanceConsumer<AdvancementBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new AdvancementBuilder(this, name).configure(config);
    }

    public static /* synthetic */ RegistryEntry advancement$default(BrokenReg brokenReg, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: advancement");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BrokenReg::advancement$lambda$0;
        }
        return brokenReg.advancement(string, instanceConsumer);
    }

    @NotNull
    public final <T extends ChatResponse> RegistryEntry<ChatResponse, T> chatResponse(@NotNull String name, @NotNull Function0<? extends T> ctor, @NotNull InstanceConsumer<ChatResponseBuilder<T>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new ChatResponseBuilder<T>(this, name, ctor).configure(config);
    }

    public static /* synthetic */ RegistryEntry chatResponse$default(BrokenReg brokenReg, String string, Function0 function0, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chatResponse");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::chatResponse$lambda$0;
        }
        return brokenReg.chatResponse(string, function0, instanceConsumer);
    }

    @NotNull
    public final <T extends RandomEvent> RegistryEntry<RandomEvent, T> event(@NotNull String name, @NotNull Function0<? extends T> ctor, @NotNull InstanceConsumer<EventBuilder<T>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new EventBuilder<T>(this, name, ctor).configure(config);
    }

    public static /* synthetic */ RegistryEntry event$default(BrokenReg brokenReg, String string, Function0 function0, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: event");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::event$lambda$0;
        }
        return brokenReg.event(string, function0, instanceConsumer);
    }

    @NotNull
    public final <T extends StoryEvent> RegistryEntry<StoryEvent, T> storyEvent(@NotNull String name, @NotNull Function0<? extends T> ctor, @NotNull InstanceConsumer<StoryEventBuilder<T>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new StoryEventBuilder<T>(this, name, ctor).configure(config);
    }

    public static /* synthetic */ RegistryEntry storyEvent$default(BrokenReg brokenReg, String string, Function0 function0, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: storyEvent");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::storyEvent$lambda$0;
        }
        return brokenReg.storyEvent(string, function0, instanceConsumer);
    }

    @NotNull
    public final <T> TagKey<T> tag(@NotNull ResourceKey<? extends Registry<T>> registryKey, @NotNull String name, @NotNull InstanceConsumer<TagBuilder<T>> config) {
        Intrinsics.checkNotNullParameter(registryKey, (String)"registryKey");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new TagBuilder<T>(this, registryKey, name).configure(config);
    }

    public static /* synthetic */ TagKey tag$default(BrokenReg brokenReg, ResourceKey resourceKey, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tag");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::tag$lambda$0;
        }
        return brokenReg.tag(resourceKey, string, instanceConsumer);
    }

    @NotNull
    public final <T> TagKey<T> vanillaTag(@NotNull ResourceKey<? extends Registry<T>> registryKey, @NotNull String name, @NotNull InstanceConsumer<VanillaTagBuilder<T>> config) {
        Intrinsics.checkNotNullParameter(registryKey, (String)"registryKey");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new VanillaTagBuilder<T>(this, registryKey, name).configure(config);
    }

    public static /* synthetic */ TagKey vanillaTag$default(BrokenReg brokenReg, ResourceKey resourceKey, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: vanillaTag");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::vanillaTag$lambda$0;
        }
        return brokenReg.vanillaTag(resourceKey, string, instanceConsumer);
    }

    @NotNull
    public final <T> TagKey<T> builtInTag(@NotNull ResourceKey<? extends Registry<T>> registryKey, @NotNull String name, @NotNull InstanceConsumer<BuiltInTagBuilder<T>> config) {
        Intrinsics.checkNotNullParameter(registryKey, (String)"registryKey");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        HashSet<String> hashSet = BuiltInTagGenerator.Companion.getValidBuiltInTags().get(registryKey);
        if (hashSet == null) {
            throw new IllegalArgumentException("No built in tags for registry '" + registryKey.location() + "'");
        }
        HashSet<String> entry = hashSet;
        if (!entry.contains(name)) {
            throw new IllegalArgumentException("No built in tag called '" + name + "' for registry '" + registryKey.location() + "'");
        }
        return new BuiltInTagBuilder<T>(this, registryKey, name).configure(config);
    }

    public static /* synthetic */ TagKey builtInTag$default(BrokenReg brokenReg, ResourceKey resourceKey, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: builtInTag");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::builtInTag$lambda$0;
        }
        return brokenReg.builtInTag(resourceKey, string, instanceConsumer);
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> sound(@NotNull String name, @NotNull InstanceConsumer<SoundBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new SoundBuilder(this, this.id(name)).configure(config);
    }

    public static /* synthetic */ RegistryEntry sound$default(BrokenReg brokenReg, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sound");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BrokenReg::sound$lambda$0;
        }
        return brokenReg.sound(string, instanceConsumer);
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> sound(@NotNull ResourceLocation name, @NotNull InstanceConsumer<SoundBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new SoundBuilder(this, name).configure(config);
    }

    public static /* synthetic */ RegistryEntry sound$default(BrokenReg brokenReg, ResourceLocation resourceLocation, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sound");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BrokenReg::sound$lambda$1;
        }
        return brokenReg.sound(resourceLocation, instanceConsumer);
    }

    @NotNull
    public final ShapedRecipeBuilder shapedRecipe(@NotNull String name, @NotNull ResourceLocation result, int count, @NotNull InstanceConsumer<ShapedRecipeBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new ShapedRecipeBuilder(this, name, result, count).configure(config);
    }

    public static /* synthetic */ ShapedRecipeBuilder shapedRecipe$default(BrokenReg brokenReg, String string, ResourceLocation resourceLocation, int n, InstanceConsumer instanceConsumer, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shapedRecipe");
        }
        if ((n2 & 4) != 0) {
            n = 1;
        }
        if ((n2 & 8) != 0) {
            instanceConsumer = BrokenReg::shapedRecipe$lambda$0;
        }
        return brokenReg.shapedRecipe(string, resourceLocation, n, instanceConsumer);
    }

    @NotNull
    public final ShapelessRecipeBuilder shapelessRecipe(@NotNull String name, @NotNull ResourceLocation result, int count, @NotNull InstanceConsumer<ShapelessRecipeBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)result, (String)"result");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new ShapelessRecipeBuilder(this, name, result, count).configure(config);
    }

    public static /* synthetic */ ShapelessRecipeBuilder shapelessRecipe$default(BrokenReg brokenReg, String string, ResourceLocation resourceLocation, int n, InstanceConsumer instanceConsumer, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shapelessRecipe");
        }
        if ((n2 & 4) != 0) {
            n = 1;
        }
        if ((n2 & 8) != 0) {
            instanceConsumer = BrokenReg::shapelessRecipe$lambda$0;
        }
        return brokenReg.shapelessRecipe(string, resourceLocation, n, instanceConsumer);
    }

    @NotNull
    public final RegistryEntry<JukeboxSong, JukeboxSong> jukeboxSong(@NotNull String name, @NotNull SoundEvent sound, @NotNull Number length, @NotNull InstanceConsumer<JukeboxSongBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)length, (String)"length");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Holder holder = Holder.direct((Object)sound);
        Intrinsics.checkNotNullExpressionValue((Object)holder, (String)"direct(...)");
        return this.jukeboxSong(name, (Holder<SoundEvent>)holder, length, config);
    }

    public static /* synthetic */ RegistryEntry jukeboxSong$default(BrokenReg brokenReg, String string, SoundEvent soundEvent, Number number, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: jukeboxSong");
        }
        if ((n & 8) != 0) {
            instanceConsumer = BrokenReg::jukeboxSong$lambda$0;
        }
        return brokenReg.jukeboxSong(string, soundEvent, number, instanceConsumer);
    }

    @NotNull
    public final RegistryEntry<JukeboxSong, JukeboxSong> jukeboxSong(@NotNull String name, @NotNull Holder<SoundEvent> sound, @NotNull Number length, @NotNull InstanceConsumer<JukeboxSongBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)length, (String)"length");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new JukeboxSongBuilder(this, name, sound, length).configure(config);
    }

    public static /* synthetic */ RegistryEntry jukeboxSong$default(BrokenReg brokenReg, String string, Holder holder, Number number, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: jukeboxSong");
        }
        if ((n & 8) != 0) {
            instanceConsumer = BrokenReg::jukeboxSong$lambda$1;
        }
        return brokenReg.jukeboxSong(string, (Holder<SoundEvent>)holder, number, instanceConsumer);
    }

    @NotNull
    public final <M extends AbstractContainerMenu> MenuEntry<M> menu(@NotNull String name, @NotNull MenuConstructor<M> ctor, @NotNull InstanceConsumer<MenuBuilder<M>> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return (MenuEntry)new MenuBuilder<M>(this, name, ctor).configure(config);
    }

    public static /* synthetic */ MenuEntry menu$default(BrokenReg brokenReg, String string, MenuConstructor menuConstructor, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menu");
        }
        if ((n & 4) != 0) {
            instanceConsumer = BrokenReg::menu$lambda$0;
        }
        return brokenReg.menu(string, menuConstructor, instanceConsumer);
    }

    @NotNull
    public final RegistryEntry<CreativeModeTab, CreativeModeTab> creativeTab(@NotNull String name, @NotNull InstanceConsumer<CreativeTabBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new CreativeTabBuilder(this, name).configure(config);
    }

    public static /* synthetic */ RegistryEntry creativeTab$default(BrokenReg brokenReg, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: creativeTab");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BrokenReg::creativeTab$lambda$0;
        }
        return brokenReg.creativeTab(string, instanceConsumer);
    }

    @NotNull
    public final RegistryEntry<DamageType, DamageType> damageType(@NotNull String name, @NotNull InstanceConsumer<DamageTypeBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        Object type = new DamageTypeBuilder(this, name).configure(config);
        return type;
    }

    public static /* synthetic */ RegistryEntry damageType$default(BrokenReg brokenReg, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: damageType");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BrokenReg::damageType$lambda$0;
        }
        return brokenReg.damageType(string, instanceConsumer);
    }

    @NotNull
    public final RegistryEntry<ParticleType<?>, SimpleParticleType> simpleParticle(@NotNull String name, @NotNull InstanceConsumer<SimpleParticleBuilder> config) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(config, (String)"config");
        return new SimpleParticleBuilder(this, name).configure(config);
    }

    public static /* synthetic */ RegistryEntry simpleParticle$default(BrokenReg brokenReg, String string, InstanceConsumer instanceConsumer, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: simpleParticle");
        }
        if ((n & 2) != 0) {
            instanceConsumer = BrokenReg::simpleParticle$lambda$0;
        }
        return brokenReg.simpleParticle(string, instanceConsumer);
    }

    @NotNull
    public final RegistryEntry<SpawnConditions, SpawnConditions> spawnConditions(@NotNull String name, @NotNull Function0<? extends SpawnConditions> ctor) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        return this.generic(BCRegistries.SPAWN_CONDITIONS_KEY, name, ctor);
    }

    @NotNull
    public final <T extends NbtSerializable> DataAttachment<T> dataAttachment(@NotNull String id, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        return PlatformAttachments.Companion.register(this, id, ctor);
    }

    @NotNull
    public final <T> RegistryEntry<DataComponentType<?>, DataComponentType<T>> dataComponent(@NotNull String id, @NotNull Function1<? super DataComponentType.Builder<T>, ? extends DataComponentType.Builder<T>> builder) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        ResourceKey resourceKey = Registries.DATA_COMPONENT_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"DATA_COMPONENT_TYPE");
        return this.generic(resourceKey, id, () -> BrokenReg.dataComponent$lambda$0(builder));
    }

    @SideOnly(side=Side.CLIENT)
    public final void modelLayer(@NotNull ModelLayerLocation loc, @NotNull Supplier<LayerDefinition> def) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter(def, (String)"def");
        ClientEntityHandler.INSTANCE.getLayers$brokencore_common().put(loc, def);
    }

    public final void reloadListener(@NotNull PreparableReloadListener listener) {
        Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
        this.reloadListeners.add(listener);
    }

    public final void registerAll(@NotNull RegistrationHandler handler) {
        Intrinsics.checkNotNullParameter((Object)handler, (String)"handler");
        Iterable $this$forEach$iv = this.registrationQueue;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            BuiltObject it = (BuiltObject)element$iv;
            boolean bl = false;
            it.accept(handler);
        }
    }

    public final void registerDataGenerators(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries, @NotNull Function1<? super DataProvider, Unit> consumer) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter(registries, (String)"registries");
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        HolderLookup.Provider provider = registries.join();
        Intrinsics.checkNotNullExpressionValue((Object)provider, (String)"join(...)");
        this.setRegistries(provider);
        consumer.invoke((Object)new AdvancementGenerator(output, this));
        consumer.invoke((Object)new BlockModelGenerator(output, this));
        consumer.invoke((Object)new BlockStateGenerator(output, this));
        consumer.invoke((Object)new ItemModelGenerator(output, this));
        consumer.invoke((Object)new JukeboxSongGenerator(output, this));
        consumer.invoke((Object)new LootTableGenerator(output, this));
        consumer.invoke((Object)new DamageTypeGenerator(output, this));
        consumer.invoke((Object)new LangGenerator(output, this));
        consumer.invoke((Object)new TagGenerator(output, this));
        consumer.invoke((Object)new VanillaTagGenerator(output, this));
        consumer.invoke((Object)new BuiltInTagGenerator(output, this));
        consumer.invoke((Object)new SoundGenerator(output, this));
        consumer.invoke((Object)new RecipeGenerator(output, this));
    }

    private static final Unit generic$lambda$0(RegistryEntry it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    private static final void block$lambda$0(BlockBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void block$lambda$1(BlockBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void item$lambda$0(ItemBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void item$lambda$1(ItemBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void blockItem$lambda$0(BlockItemBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void blockEntity$lambda$0(BlockEntityBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void entity$lambda$0(EntityBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void advancement$lambda$0(AdvancementBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void chatResponse$lambda$0(ChatResponseBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void event$lambda$0(EventBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void storyEvent$lambda$0(StoryEventBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void tag$lambda$0(TagBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void vanillaTag$lambda$0(VanillaTagBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void builtInTag$lambda$0(BuiltInTagBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void sound$lambda$0(SoundBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void sound$lambda$1(SoundBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void shapedRecipe$lambda$0(ShapedRecipeBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void shapelessRecipe$lambda$0(ShapelessRecipeBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void jukeboxSong$lambda$0(JukeboxSongBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void jukeboxSong$lambda$1(JukeboxSongBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void menu$lambda$0(MenuBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void creativeTab$lambda$0(CreativeTabBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void damageType$lambda$0(DamageTypeBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final void simpleParticle$lambda$0(SimpleParticleBuilder $this$InstanceConsumer) {
        Intrinsics.checkNotNullParameter((Object)$this$InstanceConsumer, (String)"$this$InstanceConsumer");
    }

    private static final DataComponentType dataComponent$lambda$0(Function1 $builder) {
        DataComponentType.Builder builder = DataComponentType.builder();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"builder(...)");
        DataComponentType dataComponentType = ((DataComponentType.Builder)$builder.invoke((Object)builder)).build();
        Intrinsics.checkNotNullExpressionValue((Object)dataComponentType, (String)"build(...)");
        return dataComponentType;
    }
}

