/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  compat.net.neoforged.neoforge.client.model.generators.BlockModelBuilder
 *  compat.net.neoforged.neoforge.client.model.generators.BlockStateProvider
 *  compat.net.neoforged.neoforge.client.model.generators.ItemModelBuilder
 *  compat.net.neoforged.neoforge.client.model.generators.ModelFile
 *  compat.net.neoforged.neoforge.client.model.generators.ModelFile$ExistingModelFile
 *  compat.net.neoforged.neoforge.client.model.generators.ModelProvider
 *  compat.net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder
 *  compat.net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder$PartBuilder
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.advancements.critereon.ItemPredicate$Builder
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.FenceBlock
 *  net.minecraft.world.level.block.FlowerPotBlock
 *  net.minecraft.world.level.block.HalfTransparentBlock
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.block.SlabBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.block.TallGrassBlock
 *  net.minecraft.world.level.block.TrapDoorBlock
 *  net.minecraft.world.level.block.VineBlock
 *  net.minecraft.world.level.block.WallBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockSetType
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.PushReaction
 *  net.minecraft.world.level.storage.loot.LootPool$Builder
 *  net.minecraft.world.level.storage.loot.LootTable$Builder
 *  net.minecraft.world.level.storage.loot.entries.LootItem
 *  net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer$Builder
 *  net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer$Builder
 *  net.minecraft.world.level.storage.loot.predicates.LootItemCondition$Builder
 *  net.minecraft.world.level.storage.loot.predicates.MatchTool
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.datagen.providers.BCBlockItemModelProvider
 *  net.thebrokenscript.brokencore.api.datagen.providers.BCBlockStateProvider
 *  net.thebrokenscript.brokencore.api.ext.PropertiesExt
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockItemBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder$FunctionalTagBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder$InteractableBlockTagBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder$MaterialTagsBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder$MaterialTagsBuilder$LogBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder$PartialBlockTagBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder$ToolTagsBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntry
 *  net.thebrokenscript.brokencore.api.registry.objects.ItemEntry
 *  net.thebrokenscript.brokencore.api.registry.util.LootBuildersKt
 *  net.thebrokenscript.brokencore.impl.block.VerticalSlabBlock
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import compat.net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import compat.net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ModelFile;
import compat.net.neoforged.neoforge.client.model.generators.ModelProvider;
import compat.net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.block.AllDeadBlock;
import net.thebrokenscript.block.ArenaBlock;
import net.thebrokenscript.block.BlockIsMissingIdBlock;
import net.thebrokenscript.block.CommandBlockGiverBlock;
import net.thebrokenscript.block.CorruptedCommandBlock;
import net.thebrokenscript.block.DisruptionBlock;
import net.thebrokenscript.block.EmptyBlock;
import net.thebrokenscript.block.ExitBlock;
import net.thebrokenscript.block.FleshBlock;
import net.thebrokenscript.block.HelloBlock;
import net.thebrokenscript.block.IntBlock;
import net.thebrokenscript.block.ItBlock;
import net.thebrokenscript.block.JimTriggerBlock;
import net.thebrokenscript.block.NameMissingBlock;
import net.thebrokenscript.block.NecrosisBlock;
import net.thebrokenscript.block.NewVeinBlock;
import net.thebrokenscript.block.NowhereBlock;
import net.thebrokenscript.block.NullStructureBlock;
import net.thebrokenscript.block.ObsidianBlock;
import net.thebrokenscript.block.OldBlock;
import net.thebrokenscript.block.PhysicalStacktraceBlock;
import net.thebrokenscript.block.ProtectedVoidBlock;
import net.thebrokenscript.block.ProtectedVoidLightBlock;
import net.thebrokenscript.block.ProtectedVoidStairsBlock;
import net.thebrokenscript.block.R3Block;
import net.thebrokenscript.block.ShadowBugBlock;
import net.thebrokenscript.block.SidewaysCobblestoneStairs;
import net.thebrokenscript.block.SidewaysFenceBlock;
import net.thebrokenscript.block.SidewaysFurnaceBlock;
import net.thebrokenscript.block.TeethBlock;
import net.thebrokenscript.block.TetherBloomBlock;
import net.thebrokenscript.block.UDDoorBlock;
import net.thebrokenscript.block.VoidBudBlock;
import net.thebrokenscript.block.VoidDoorBlock;
import net.thebrokenscript.block.VoidFlora;
import net.thebrokenscript.block.VoidRootBlock;
import net.thebrokenscript.block.VoidVineBlock;
import net.thebrokenscript.block.WhiteBlock;
import net.thebrokenscript.block.portal.PortalControllerBlock;
import net.thebrokenscript.block.portal.PortalExtenderBlock;
import net.thebrokenscript.brokencore.api.datagen.providers.BCBlockItemModelProvider;
import net.thebrokenscript.brokencore.api.datagen.providers.BCBlockStateProvider;
import net.thebrokenscript.brokencore.api.ext.PropertiesExt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.registry.builders.BlockBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockItemBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockTagsBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import net.thebrokenscript.brokencore.api.registry.util.LootBuildersKt;
import net.thebrokenscript.brokencore.impl.block.VerticalSlabBlock;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSCreativeTabs;
import net.thebrokenscript.registry.TBSItems;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.registry.TBSTags;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00fa\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u00b3\u0001\u001a\t\u0012\u0005\u0012\u00030\u00af\u00010\u00052\b\u0010\u00b4\u0001\u001a\u00030\u00b5\u0001H\u0002J$\u0010\u00c7\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00052\b\u0010\u00b4\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00c8\u0001\u001a\u00030\u00b5\u0001H\u0002J$\u0010\u00c9\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00052\b\u0010\u00b4\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00c8\u0001\u001a\u00030\u00b5\u0001H\u0002J$\u0010\u00ca\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00052\b\u0010\u00b4\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00c8\u0001\u001a\u00030\u00b5\u0001H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020+0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010K\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020+0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020=0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020+0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020=0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020+0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010W\u001a\b\u0012\u0004\u0012\u00020X0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010]\u001a\b\u0012\u0004\u0012\u00020^0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010_\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010d\u001a\b\u0012\u0004\u0012\u00020e0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010h\u001a\b\u0012\u0004\u0012\u00020i0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020i0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010k\u001a\b\u0012\u0004\u0012\u00020i0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010l\u001a\b\u0012\u0004\u0012\u00020i0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010m\u001a\b\u0012\u0004\u0012\u00020i0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010n\u001a\b\u0012\u0004\u0012\u00020o0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010p\u001a\u00020q\u00a2\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0011\u0010t\u001a\u00020q\u00a2\u0006\b\n\u0000\u001a\u0004\bu\u0010sR\u0011\u0010v\u001a\u00020q\u00a2\u0006\b\n\u0000\u001a\u0004\bw\u0010sR\u0016\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010z\u001a\b\u0012\u0004\u0012\u00020y0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010{\u001a\b\u0012\u0004\u0012\u00020y0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010|\u001a\b\u0012\u0004\u0012\u00020y0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010}\u001a\n\u0012\u0006\b\u0001\u0012\u00020~0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u007f\u001a\n\u0012\u0006\b\u0001\u0012\u00020~0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0080\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020~0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0081\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020~0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020+0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u008a\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u008b\u0001\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u008c\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u008d\u0001\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u008c\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u008e\u0001\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u008f\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0092\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0093\u0001\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u0094\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020y0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\n\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u0098\u0001R\u001d\u0010\u009b\u0001\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u009c\u00010\u0005\u00a2\u0006\n\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u0098\u0001R\u001a\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u0098\u0001R\u001a\u0010\u00a0\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00a1\u0001\u0010\u0098\u0001R\u001a\u0010\u00a2\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00a3\u0001\u0010\u0098\u0001R\u0017\u0010\u00a4\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u00a5\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u00a6\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u00a7\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u00a8\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u00a9\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u00aa\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u00ab\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00ac\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00ae\u0001\u001a\t\u0012\u0005\u0012\u00030\u00af\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00b0\u0001\u001a\t\u0012\u0005\u0012\u00030\u00af\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00b1\u0001\u001a\t\u0012\u0005\u0012\u00030\u00af\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00b2\u0001\u001a\t\u0012\u0005\u0012\u00030\u00af\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00b6\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00b8\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00b9\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00ba\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00bb\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00bc\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00bd\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00be\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00bf\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00c0\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00c1\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00c2\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00c3\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00c4\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00c5\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u00c6\u0001\u001a\t\u0012\u0005\u0012\u00030\u00b7\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00cb\u0001"}, d2={"Lnet/thebrokenscript/registry/TBSBlocks;", "", "<init>", "()V", "CORRUPTED_COMMAND_BLOCK", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "Lnet/thebrokenscript/block/CorruptedCommandBlock;", "DEVIATION", "Lnet/minecraft/world/level/block/Block;", "SEMIOTICS", "ALL_DEAD", "Lnet/thebrokenscript/block/AllDeadBlock;", "NAME_MISSING", "Lnet/thebrokenscript/block/NameMissingBlock;", "VISCERA", "FLESH", "Lnet/thebrokenscript/block/FleshBlock;", "OLDBLOCK", "Lnet/thebrokenscript/block/OldBlock;", "HELLO", "Lnet/thebrokenscript/block/HelloBlock;", "EMPTY", "Lnet/thebrokenscript/block/EmptyBlock;", "IT", "Lnet/thebrokenscript/block/ItBlock;", "EXIT", "Lnet/thebrokenscript/block/ExitBlock;", "A_FLOWER", "Lnet/thebrokenscript/block/TetherBloomBlock;", "DISRUPTION", "Lnet/thebrokenscript/block/DisruptionBlock;", "PROTECTED_VOID", "Lnet/thebrokenscript/block/ProtectedVoidBlock;", "CONCRETE", "INTENSE_PROJECTION", "VOID_DOOR", "Lnet/thebrokenscript/block/VoidDoorBlock;", "OBSIDIAN", "Lnet/thebrokenscript/block/ObsidianBlock;", "MONOCHROME_PLANKS", "MONOCHROME_STAIRS", "Lnet/minecraft/world/level/block/StairBlock;", "MONOCHROME_SLAB", "Lnet/minecraft/world/level/block/SlabBlock;", "MONOCHROME_BOOKSHELF", "WHITE", "Lnet/thebrokenscript/block/WhiteBlock;", "R_3", "Lnet/thebrokenscript/block/R3Block;", "INT", "Lnet/thebrokenscript/block/IntBlock;", "SHADOW_BUG", "Lnet/thebrokenscript/block/ShadowBugBlock;", "PORTAL_CONTROLLER", "Lnet/thebrokenscript/block/portal/PortalControllerBlock;", "PORTAL_EXTENDER", "Lnet/thebrokenscript/block/portal/PortalExtenderBlock;", "PROTECTED_VOID_STAIRS", "Lnet/thebrokenscript/block/ProtectedVoidStairsBlock;", "PROTECTED_VOID_SLAB", "PROTECTED_VOID_WALL", "Lnet/minecraft/world/level/block/WallBlock;", "PROTECTED_VOID_FENCE", "Lnet/minecraft/world/level/block/FenceBlock;", "PROTECTED_VOID_LIGHT", "Lnet/thebrokenscript/block/ProtectedVoidLightBlock;", "PHYSICAL_STACKTRACE", "Lnet/thebrokenscript/block/PhysicalStacktraceBlock;", "BLOCK_IS_MISSING_ID", "Lnet/thebrokenscript/block/BlockIsMissingIdBlock;", "NOWHERE_BLOCK", "Lnet/thebrokenscript/block/NowhereBlock;", "NULL", "MOON_STONE", "MOON_STONE_BRICKS", "MOON_STONE_BRICK_STAIRS", "MOON_STONE_BRICK_SLAB", "MOON_STONE_BRICK_WALL", "CORRUPTED_MOON_STONE_BRICKS", "CHISELED_MOON_STONE_BRICKS", "POLISHED_MOON_STONE", "POLISHED_MOON_STONE_STAIRS", "POLISHED_MOON_STONE_SLAB", "POLISHED_MOON_STONE_WALL", "LIMBO", "NOTHING", "SPRUCE_WOOD_SLAB", "SMOOTH_STONE_VERTICAL_SLAB", "Lnet/thebrokenscript/brokencore/impl/block/VerticalSlabBlock;", "UD_OAK_DOOR", "Lnet/thebrokenscript/block/UDDoorBlock;", "NEW_VEIN_BLOCK", "Lnet/thebrokenscript/block/NewVeinBlock;", "SIDEWAYS_FURNACE", "Lnet/thebrokenscript/block/SidewaysFurnaceBlock;", "SIDEWAYS_PANE", "SIDEWAYS_FENCE", "Lnet/thebrokenscript/block/SidewaysFenceBlock;", "SIDEWAYS_STAIRS", "Lnet/thebrokenscript/block/SidewaysCobblestoneStairs;", "NULL_STRUCTURE", "Lnet/thebrokenscript/block/NullStructureBlock;", "NECROSIS", "Lnet/thebrokenscript/block/NecrosisBlock;", "VOID_SPROUT", "Lnet/thebrokenscript/block/VoidBudBlock;", "VOID_BUD", "VOID_BUDDING", "VOID_BLOOM", "VOID_BLOSSOM", "VOID_VINE", "Lnet/thebrokenscript/block/VoidVineBlock;", "SHROOMY_BOX", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "getSHROOMY_BOX", "()Lnet/minecraft/world/phys/shapes/VoxelShape;", "SKINNY_SHROOMY_BOX", "getSKINNY_SHROOMY_BOX", "VOID_GRASS_BOX", "getVOID_GRASS_BOX", "VOID_SHROOM", "Lnet/thebrokenscript/block/VoidFlora;", "VOID_CAP", "VOID_BELL", "LILY_OF_THE_ABYSS", "POTTED_VOID_SHROOM", "Lnet/minecraft/world/level/block/FlowerPotBlock;", "POTTED_VOID_CAP", "POTTED_VOID_BELL", "POTTED_LILY_OF_THE_ABYSS", "TEETH", "Lnet/thebrokenscript/block/TeethBlock;", "VOID_LOG", "Lnet/minecraft/world/level/block/RotatedPillarBlock;", "VOID_WOOD", "VOID_PLANKS", "VOID_PLANK_SLAB", "INITIATOR", "VOID_PLANK_STAIRS", "VOID_PLANK_DOOR", "Lnet/minecraft/world/level/block/DoorBlock;", "VOID_LOG_DOOR", "VOID_WOOD_TRAPDOOR", "Lnet/minecraft/world/level/block/TrapDoorBlock;", "VOID_ROOTS", "Lnet/thebrokenscript/block/VoidRootBlock;", "VOID_ROOT", "VOID_GRASS", "Lnet/minecraft/world/level/block/TallGrassBlock;", "VOID_BUSH", "FLOOR_BORDER_BLOCK", "getFLOOR_BORDER_BLOCK", "()Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "DIRT_BORDER_BLOCK", "getDIRT_BORDER_BLOCK", "GLASS_BORDER_BLOCK", "Lnet/minecraft/world/level/block/HalfTransparentBlock;", "getGLASS_BORDER_BLOCK", "COBBLESTONE_BORDER_BLOCK", "getCOBBLESTONE_BORDER_BLOCK", "STONE_BORDER_BLOCK", "getSTONE_BORDER_BLOCK", "STONE_SLAB_BORDER_BLOCK", "getSTONE_SLAB_BORDER_BLOCK", "MOIST_CARPET", "CEILING_LIGHT", "CEILING_TILE", "UGLY_WALLPAPER", "RED_MOIST_CARPET", "RED_UGLY_WALLPAPER", "RED_CEILING_TILE", "RED_CEILING_LIGHT", "CORRUPTED_COMMAND_BLOCK_GIVER", "Lnet/thebrokenscript/block/CommandBlockGiverBlock;", "JIM_TRIGGER_1", "Lnet/thebrokenscript/block/JimTriggerBlock;", "JIM_TRIGGER_2", "JIM_TRIGGER_3", "JIM_TRIGGER_4", "jimTrigger", "name", "", "VOID_TEMPLATE_1", "Lnet/thebrokenscript/block/ArenaBlock;", "VOID_TEMPLATE_2", "VOID_TEMPLATE_3", "VOID_TEMPLATE_4", "VOID_TEMPLATE_5", "VOID_TEMPLATE_6", "VOID_TEMPLATE_7", "VOID_TEMPLATE_8", "VOID_TEMPLATE_9", "VOID_TEMPLATE_10", "VOID_TEMPLATE_11", "VOID_TEMPLATE_12", "VOID_TEMPLATE_13", "VOID_TEMPLATE_14", "VOID_TEMPLATE_15", "VOID_TEMPLATE_16", "templateBlock", "real", "templateBlockReal", "templateBlockLit", "thebrokenscript-common"})
public final class TBSBlocks {
    @NotNull
    public static final TBSBlocks INSTANCE = new TBSBlocks();
    @JvmField
    @NotNull
    public static final BlockEntry<CorruptedCommandBlock> CORRUPTED_COMMAND_BLOCK = TBSReg.INSTANCE.block("command", CORRUPTED_COMMAND_BLOCK.1.INSTANCE, TBSBlocks::CORRUPTED_COMMAND_BLOCK$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> DEVIATION = TBSReg.INSTANCE.defaultBlock("deviation", TBSBlocks::DEVIATION$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> SEMIOTICS = TBSReg.INSTANCE.defaultBlock("decomposed_semiotics", TBSBlocks::SEMIOTICS$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<AllDeadBlock> ALL_DEAD = TBSReg.INSTANCE.block("all_dead", ALL_DEAD.1.INSTANCE, TBSBlocks::ALL_DEAD$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<NameMissingBlock> NAME_MISSING = TBSReg.INSTANCE.block("name_missing", NAME_MISSING.1.INSTANCE, TBSBlocks::NAME_MISSING$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> VISCERA = TBSReg.INSTANCE.defaultBlock("viscera", TBSBlocks::VISCERA$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<FleshBlock> FLESH = TBSReg.INSTANCE.block("flesh", FLESH.1.INSTANCE, TBSBlocks::FLESH$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<OldBlock> OLDBLOCK = TBSReg.INSTANCE.block("oldblock", OLDBLOCK.1.INSTANCE, TBSBlocks::OLDBLOCK$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<HelloBlock> HELLO = TBSReg.INSTANCE.block("hello", HELLO.1.INSTANCE, TBSBlocks::HELLO$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<EmptyBlock> EMPTY = TBSReg.INSTANCE.block("empty", EMPTY.1.INSTANCE, TBSBlocks::EMPTY$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<ItBlock> IT = TBSReg.INSTANCE.block("it", IT.1.INSTANCE, TBSBlocks::IT$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<ExitBlock> EXIT = TBSReg.INSTANCE.block("exit", EXIT.1.INSTANCE, TBSBlocks::EXIT$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<TetherBloomBlock> A_FLOWER = TBSReg.INSTANCE.block("a_flower", A_FLOWER.1.INSTANCE, TBSBlocks::A_FLOWER$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<DisruptionBlock> DISRUPTION = TBSReg.INSTANCE.block("disruption", DISRUPTION.1.INSTANCE, TBSBlocks::DISRUPTION$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<ProtectedVoidBlock> PROTECTED_VOID = TBSReg.INSTANCE.block("protected_void", PROTECTED_VOID.1.INSTANCE, TBSBlocks::PROTECTED_VOID$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> CONCRETE = TBSReg.INSTANCE.block("concrete", CONCRETE.1.INSTANCE, TBSBlocks::CONCRETE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> INTENSE_PROJECTION = TBSReg.INSTANCE.block("intense_projection", INTENSE_PROJECTION.1.INSTANCE, TBSBlocks::INTENSE_PROJECTION$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<VoidDoorBlock> VOID_DOOR = TBSReg.INSTANCE.block("void_door", VOID_DOOR.1.INSTANCE, TBSBlocks::VOID_DOOR$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<ObsidianBlock> OBSIDIAN = TBSReg.INSTANCE.block("obsidian", OBSIDIAN.1.INSTANCE, TBSBlocks::OBSIDIAN$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> MONOCHROME_PLANKS = TBSReg.INSTANCE.defaultBlock("mono_planks", TBSBlocks::MONOCHROME_PLANKS$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<? extends StairBlock> MONOCHROME_STAIRS = TBSReg.INSTANCE.block("mono_stairs", TBSBlocks::MONOCHROME_STAIRS$lambda$0, TBSBlocks::MONOCHROME_STAIRS$lambda$1);
    @JvmField
    @NotNull
    public static final BlockEntry<SlabBlock> MONOCHROME_SLAB = TBSReg.INSTANCE.block("mono_slab", MONOCHROME_SLAB.1.INSTANCE, TBSBlocks::MONOCHROME_SLAB$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> MONOCHROME_BOOKSHELF = TBSReg.INSTANCE.defaultBlock("mono_library", TBSBlocks::MONOCHROME_BOOKSHELF$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<WhiteBlock> WHITE = TBSReg.INSTANCE.block("white", WHITE.1.INSTANCE, TBSBlocks::WHITE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<R3Block> R_3 = TBSReg.INSTANCE.block("r_3", R_3.1.INSTANCE, TBSBlocks::R_3$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<IntBlock> INT = TBSReg.INSTANCE.block("int", INT.1.INSTANCE, TBSBlocks::INT$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<ShadowBugBlock> SHADOW_BUG = TBSReg.INSTANCE.block("shadow_bug", SHADOW_BUG.1.INSTANCE, TBSBlocks::SHADOW_BUG$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<PortalControllerBlock> PORTAL_CONTROLLER = TBSReg.INSTANCE.block("portal_controller", PORTAL_CONTROLLER.1.INSTANCE, TBSBlocks::PORTAL_CONTROLLER$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<PortalExtenderBlock> PORTAL_EXTENDER = TBSReg.INSTANCE.block("portal_extender", PORTAL_EXTENDER.1.INSTANCE, TBSBlocks::PORTAL_EXTENDER$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<ProtectedVoidStairsBlock> PROTECTED_VOID_STAIRS = TBSReg.INSTANCE.block("protected_void_stairs", PROTECTED_VOID_STAIRS.1.INSTANCE, TBSBlocks::PROTECTED_VOID_STAIRS$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<SlabBlock> PROTECTED_VOID_SLAB = TBSReg.INSTANCE.block("protected_void_slab", PROTECTED_VOID_SLAB.1.INSTANCE, TBSBlocks::PROTECTED_VOID_SLAB$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<WallBlock> PROTECTED_VOID_WALL = TBSReg.INSTANCE.block("protected_void_wall", PROTECTED_VOID_WALL.1.INSTANCE, TBSBlocks::PROTECTED_VOID_WALL$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<FenceBlock> PROTECTED_VOID_FENCE = TBSReg.INSTANCE.block("protected_void_fence", PROTECTED_VOID_FENCE.1.INSTANCE, TBSBlocks::PROTECTED_VOID_FENCE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<ProtectedVoidLightBlock> PROTECTED_VOID_LIGHT = TBSReg.INSTANCE.block("protected_void_light", PROTECTED_VOID_LIGHT.1.INSTANCE, TBSBlocks::PROTECTED_VOID_LIGHT$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<PhysicalStacktraceBlock> PHYSICAL_STACKTRACE = TBSReg.INSTANCE.block("physical_stacktrace", PHYSICAL_STACKTRACE.1.INSTANCE, TBSBlocks::PHYSICAL_STACKTRACE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<BlockIsMissingIdBlock> BLOCK_IS_MISSING_ID = TBSReg.INSTANCE.block("block_is_missing_id", BLOCK_IS_MISSING_ID.1.INSTANCE, TBSBlocks::BLOCK_IS_MISSING_ID$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<NowhereBlock> NOWHERE_BLOCK = TBSReg.INSTANCE.block("nowhere_block", NOWHERE_BLOCK.1.INSTANCE, TBSBlocks::NOWHERE_BLOCK$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> NULL = TBSReg.INSTANCE.defaultBlock("null", TBSBlocks::NULL$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> MOON_STONE = TBSReg.INSTANCE.defaultBlock("moon_stone", TBSBlocks::MOON_STONE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> MOON_STONE_BRICKS = TBSReg.INSTANCE.defaultBlock("moon_stone_bricks", TBSBlocks::MOON_STONE_BRICKS$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<? extends StairBlock> MOON_STONE_BRICK_STAIRS = TBSReg.INSTANCE.block("moon_stone_brick_stairs", TBSBlocks::MOON_STONE_BRICK_STAIRS$lambda$0, TBSBlocks::MOON_STONE_BRICK_STAIRS$lambda$1);
    @JvmField
    @NotNull
    public static final BlockEntry<SlabBlock> MOON_STONE_BRICK_SLAB = TBSReg.INSTANCE.block("moon_stone_brick_slab", MOON_STONE_BRICK_SLAB.1.INSTANCE, TBSBlocks::MOON_STONE_BRICK_SLAB$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<WallBlock> MOON_STONE_BRICK_WALL = TBSReg.INSTANCE.block("moon_stone_brick_wall", MOON_STONE_BRICK_WALL.1.INSTANCE, TBSBlocks::MOON_STONE_BRICK_WALL$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> CORRUPTED_MOON_STONE_BRICKS = TBSReg.INSTANCE.defaultBlock("corrupted_moon_stone_bricks", TBSBlocks::CORRUPTED_MOON_STONE_BRICKS$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> CHISELED_MOON_STONE_BRICKS = TBSReg.INSTANCE.defaultBlock("chiseled_moon_stone_bricks", TBSBlocks::CHISELED_MOON_STONE_BRICKS$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> POLISHED_MOON_STONE = TBSReg.INSTANCE.defaultBlock("polished_moon_stone", TBSBlocks::POLISHED_MOON_STONE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<? extends StairBlock> POLISHED_MOON_STONE_STAIRS = TBSReg.INSTANCE.block("polished_moon_stone_stairs", TBSBlocks::POLISHED_MOON_STONE_STAIRS$lambda$0, TBSBlocks::POLISHED_MOON_STONE_STAIRS$lambda$1);
    @JvmField
    @NotNull
    public static final BlockEntry<SlabBlock> POLISHED_MOON_STONE_SLAB = TBSReg.INSTANCE.block("polished_moon_stone_slab", POLISHED_MOON_STONE_SLAB.1.INSTANCE, TBSBlocks::POLISHED_MOON_STONE_SLAB$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<WallBlock> POLISHED_MOON_STONE_WALL = TBSReg.INSTANCE.block("polished_moon_stone_wall", POLISHED_MOON_STONE_WALL.1.INSTANCE, TBSBlocks::POLISHED_MOON_STONE_WALL$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> LIMBO = TBSReg.INSTANCE.defaultBlock("limbo", TBSBlocks::LIMBO$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<Block> NOTHING = TBSReg.INSTANCE.defaultBlock("nothing", TBSBlocks::NOTHING$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<SlabBlock> SPRUCE_WOOD_SLAB = TBSReg.INSTANCE.block("spruce_wood_slab", SPRUCE_WOOD_SLAB.1.INSTANCE, TBSBlocks::SPRUCE_WOOD_SLAB$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<VerticalSlabBlock> SMOOTH_STONE_VERTICAL_SLAB = TBSReg.INSTANCE.block("smooth_stone_vertical_slab", SMOOTH_STONE_VERTICAL_SLAB.1.INSTANCE, TBSBlocks::SMOOTH_STONE_VERTICAL_SLAB$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<UDDoorBlock> UD_OAK_DOOR = TBSReg.INSTANCE.block("ud_oak_door", UD_OAK_DOOR.1.INSTANCE, TBSBlocks::UD_OAK_DOOR$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<NewVeinBlock> NEW_VEIN_BLOCK = TBSReg.INSTANCE.block("new_vein", NEW_VEIN_BLOCK.1.INSTANCE, TBSBlocks::NEW_VEIN_BLOCK$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<SidewaysFurnaceBlock> SIDEWAYS_FURNACE = TBSReg.INSTANCE.block("sideways_furnace", SIDEWAYS_FURNACE.1.INSTANCE, TBSBlocks::SIDEWAYS_FURNACE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<? extends Block> SIDEWAYS_PANE = TBSReg.INSTANCE.block("sideways_pane", TBSBlocks::SIDEWAYS_PANE$lambda$0, TBSBlocks::SIDEWAYS_PANE$lambda$1);
    @JvmField
    @NotNull
    public static final BlockEntry<SidewaysFenceBlock> SIDEWAYS_FENCE = TBSReg.INSTANCE.block("sideways_fence", SIDEWAYS_FENCE.1.INSTANCE, TBSBlocks::SIDEWAYS_FENCE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<SidewaysCobblestoneStairs> SIDEWAYS_STAIRS = TBSReg.INSTANCE.block("sideways_cobblestone_stairs", SIDEWAYS_STAIRS.1.INSTANCE, TBSBlocks::SIDEWAYS_STAIRS$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<NullStructureBlock> NULL_STRUCTURE = TBSReg.INSTANCE.block("null_structure", NULL_STRUCTURE.1.INSTANCE, TBSBlocks::NULL_STRUCTURE$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<NecrosisBlock> NECROSIS = TBSReg.INSTANCE.block("necrosis", NECROSIS.1.INSTANCE, TBSBlocks::NECROSIS$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<VoidBudBlock> VOID_SPROUT = TBSReg.INSTANCE.block("void_sprout", VOID_SPROUT.1.INSTANCE, TBSBlocks::VOID_SPROUT$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<VoidBudBlock> VOID_BUD = TBSReg.INSTANCE.block("void_bud", VOID_BUD.1.INSTANCE, TBSBlocks::VOID_BUD$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<VoidBudBlock> VOID_BUDDING = TBSReg.INSTANCE.block("void_budding", VOID_BUDDING.1.INSTANCE, TBSBlocks::VOID_BUDDING$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<VoidBudBlock> VOID_BLOOM = TBSReg.INSTANCE.block("void_bloom", VOID_BLOOM.1.INSTANCE, TBSBlocks::VOID_BLOOM$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<VoidBudBlock> VOID_BLOSSOM = TBSReg.INSTANCE.block("void_blossom", VOID_BLOSSOM.1.INSTANCE, TBSBlocks::VOID_BLOSSOM$lambda$0);
    @JvmField
    @NotNull
    public static final BlockEntry<VoidVineBlock> VOID_VINE = TBSReg.INSTANCE.block("void_vine", VOID_VINE.1.INSTANCE, TBSBlocks::VOID_VINE$lambda$0);
    @NotNull
    private static final VoxelShape SHROOMY_BOX;
    @NotNull
    private static final VoxelShape SKINNY_SHROOMY_BOX;
    @NotNull
    private static final VoxelShape VOID_GRASS_BOX;
    @JvmField
    @NotNull
    public static final BlockEntry<VoidFlora> VOID_SHROOM;
    @JvmField
    @NotNull
    public static final BlockEntry<VoidFlora> VOID_CAP;
    @JvmField
    @NotNull
    public static final BlockEntry<VoidFlora> VOID_BELL;
    @JvmField
    @NotNull
    public static final BlockEntry<VoidFlora> LILY_OF_THE_ABYSS;
    @JvmField
    @NotNull
    public static final BlockEntry<? extends FlowerPotBlock> POTTED_VOID_SHROOM;
    @JvmField
    @NotNull
    public static final BlockEntry<? extends FlowerPotBlock> POTTED_VOID_CAP;
    @JvmField
    @NotNull
    public static final BlockEntry<? extends FlowerPotBlock> POTTED_VOID_BELL;
    @JvmField
    @NotNull
    public static final BlockEntry<? extends FlowerPotBlock> POTTED_LILY_OF_THE_ABYSS;
    @JvmField
    @NotNull
    public static final BlockEntry<TeethBlock> TEETH;
    @JvmField
    @NotNull
    public static final BlockEntry<RotatedPillarBlock> VOID_LOG;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> VOID_WOOD;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> VOID_PLANKS;
    @JvmField
    @NotNull
    public static final BlockEntry<SlabBlock> VOID_PLANK_SLAB;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> INITIATOR;
    @JvmField
    @NotNull
    public static final BlockEntry<? extends StairBlock> VOID_PLANK_STAIRS;
    @JvmField
    @NotNull
    public static final BlockEntry<? extends DoorBlock> VOID_PLANK_DOOR;
    @JvmField
    @NotNull
    public static final BlockEntry<? extends DoorBlock> VOID_LOG_DOOR;
    @JvmField
    @NotNull
    public static final BlockEntry<? extends TrapDoorBlock> VOID_WOOD_TRAPDOOR;
    @JvmField
    @NotNull
    public static final BlockEntry<VoidRootBlock> VOID_ROOTS;
    @JvmField
    @NotNull
    public static final BlockEntry<VoidRootBlock> VOID_ROOT;
    @JvmField
    @NotNull
    public static final BlockEntry<? extends TallGrassBlock> VOID_GRASS;
    @JvmField
    @NotNull
    public static final BlockEntry<VoidFlora> VOID_BUSH;
    @NotNull
    private static final BlockEntry<Block> FLOOR_BORDER_BLOCK;
    @NotNull
    private static final BlockEntry<Block> DIRT_BORDER_BLOCK;
    @NotNull
    private static final BlockEntry<? extends HalfTransparentBlock> GLASS_BORDER_BLOCK;
    @NotNull
    private static final BlockEntry<Block> COBBLESTONE_BORDER_BLOCK;
    @NotNull
    private static final BlockEntry<Block> STONE_BORDER_BLOCK;
    @NotNull
    private static final BlockEntry<Block> STONE_SLAB_BORDER_BLOCK;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> MOIST_CARPET;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> CEILING_LIGHT;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> CEILING_TILE;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> UGLY_WALLPAPER;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> RED_MOIST_CARPET;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> RED_UGLY_WALLPAPER;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> RED_CEILING_TILE;
    @JvmField
    @NotNull
    public static final BlockEntry<Block> RED_CEILING_LIGHT;
    @JvmField
    @NotNull
    public static final BlockEntry<CommandBlockGiverBlock> CORRUPTED_COMMAND_BLOCK_GIVER;
    @JvmField
    @NotNull
    public static final BlockEntry<JimTriggerBlock> JIM_TRIGGER_1;
    @JvmField
    @NotNull
    public static final BlockEntry<JimTriggerBlock> JIM_TRIGGER_2;
    @JvmField
    @NotNull
    public static final BlockEntry<JimTriggerBlock> JIM_TRIGGER_3;
    @JvmField
    @NotNull
    public static final BlockEntry<JimTriggerBlock> JIM_TRIGGER_4;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_1;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_2;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_3;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_4;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_5;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_6;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_7;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_8;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_9;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_10;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_11;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_12;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_13;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_14;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_15;
    @JvmField
    @NotNull
    public static final BlockEntry<ArenaBlock> VOID_TEMPLATE_16;

    private TBSBlocks() {
    }

    @NotNull
    public final VoxelShape getSHROOMY_BOX() {
        return SHROOMY_BOX;
    }

    @NotNull
    public final VoxelShape getSKINNY_SHROOMY_BOX() {
        return SKINNY_SHROOMY_BOX;
    }

    @NotNull
    public final VoxelShape getVOID_GRASS_BOX() {
        return VOID_GRASS_BOX;
    }

    @NotNull
    public final BlockEntry<Block> getFLOOR_BORDER_BLOCK() {
        return FLOOR_BORDER_BLOCK;
    }

    @NotNull
    public final BlockEntry<Block> getDIRT_BORDER_BLOCK() {
        return DIRT_BORDER_BLOCK;
    }

    @NotNull
    public final BlockEntry<? extends HalfTransparentBlock> getGLASS_BORDER_BLOCK() {
        return GLASS_BORDER_BLOCK;
    }

    @NotNull
    public final BlockEntry<Block> getCOBBLESTONE_BORDER_BLOCK() {
        return COBBLESTONE_BORDER_BLOCK;
    }

    @NotNull
    public final BlockEntry<Block> getSTONE_BORDER_BLOCK() {
        return STONE_BORDER_BLOCK;
    }

    @NotNull
    public final BlockEntry<Block> getSTONE_SLAB_BORDER_BLOCK() {
        return STONE_SLAB_BORDER_BLOCK;
    }

    private final BlockEntry<JimTriggerBlock> jimTrigger(String name) {
        return TBSReg.INSTANCE.block(name, jimTrigger.1.INSTANCE, TBSBlocks::jimTrigger$lambda$0);
    }

    private final BlockEntry<ArenaBlock> templateBlock(String name, String real) {
        return TBSReg.INSTANCE.block(name, templateBlock.1.INSTANCE, arg_0 -> TBSBlocks.templateBlock$lambda$0(real, arg_0));
    }

    private final BlockEntry<ArenaBlock> templateBlockReal(String name, String real) {
        return TBSReg.INSTANCE.block(name, templateBlockReal.1.INSTANCE, arg_0 -> TBSBlocks.templateBlockReal$lambda$0(real, arg_0));
    }

    private final BlockEntry<ArenaBlock> templateBlockLit(String name, String real) {
        return TBSReg.INSTANCE.block(name, templateBlockLit.1.INSTANCE, arg_0 -> TBSBlocks.templateBlockLit$lambda$0(real, arg_0));
    }

    private static final void CORRUPTED_COMMAND_BLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Corrupted Command Block";
        $this$block.props(TBSBlocks::CORRUPTED_COMMAND_BLOCK$lambda$0$0);
        $this$block.item(arg_0 -> TBSBlocks.CORRUPTED_COMMAND_BLOCK$lambda$0$1($this$block, arg_0));
    }

    private static final void CORRUPTED_COMMAND_BLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void CORRUPTED_COMMAND_BLOCK$lambda$0$1(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        if (PlatformUtil.Companion.isProduction()) {
            $this$item.noTab();
        }
        $this$item.model(TBSBlocks::CORRUPTED_COMMAND_BLOCK$lambda$0$1$0);
    }

    private static final void CORRUPTED_COMMAND_BLOCK$lambda$0$1$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void DEVIATION$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::DEVIATION$lambda$0$0);
        $this$block.model(TBSBlocks::DEVIATION$lambda$0$1);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void DEVIATION$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.indestructible($this$props);
        $this$props.sound(SoundType.EMPTY);
        PropertiesExt.INSTANCE.nonConductive($this$props);
    }

    private static final void DEVIATION$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.simpleBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), null, (int)2, null);
    }

    private static final void SEMIOTICS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::SEMIOTICS$lambda$0$0);
        $this$block.model(TBSBlocks::SEMIOTICS$lambda$0$1);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void SEMIOTICS$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.indestructible($this$props);
        $this$props.sound(SoundType.EMPTY);
        PropertiesExt.INSTANCE.nonConductive($this$props);
    }

    private static final void SEMIOTICS$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.simpleBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), null, (int)2, null);
    }

    private static final void ALL_DEAD$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "431434";
        $this$block.props(TBSBlocks::ALL_DEAD$lambda$0$0);
        $this$block.tags(TBSBlocks::ALL_DEAD$lambda$0$1);
        $this$block.model(TBSBlocks::ALL_DEAD$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void ALL_DEAD$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        PropertiesExt.INSTANCE.indestructible($this$props);
        $this$props.noCollission();
    }

    private static final void ALL_DEAD$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.functional(TBSBlocks::ALL_DEAD$lambda$0$1$0);
    }

    private static final Unit ALL_DEAD$lambda$0$1$0(BlockTagsBuilder.FunctionalTagBuilder $this$functional) {
        Intrinsics.checkNotNullParameter((Object)$this$functional, (String)"$this$functional");
        $this$functional.replaceable();
        return Unit.INSTANCE;
    }

    private static final void ALL_DEAD$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("nullvoid"), (int)1, null)).renderType("cutout"));
    }

    private static final void NAME_MISSING$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "name.missing";
        $this$block.props(TBSBlocks::NAME_MISSING$lambda$0$0);
        $this$block.model(TBSBlocks::NAME_MISSING$lambda$0$1);
        $this$block.simpleItem();
    }

    private static final void NAME_MISSING$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(new SoundType(1.0f, 1.0f, (SoundEvent)TBSSounds.GORE_BREAK.invoke(), (SoundEvent)TBSSounds.GORE_DIG.invoke(), (SoundEvent)TBSSounds.GORE_BREAK.invoke(), (SoundEvent)TBSSounds.GORE_DIG.invoke(), (SoundEvent)TBSSounds.GORE_DIG.invoke()));
        $this$props.noCollission();
        $this$props.strength(0.5f);
    }

    private static final void NAME_MISSING$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.directionalBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), (ModelFile)((ModelFile)$this$model.models().getExistingFile(TBSConstants.id("block/name_missing"))), (int)0, (int)4, null);
    }

    private static final void VISCERA$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Viscera";
        $this$block.props(TBSBlocks::VISCERA$lambda$0$0);
        $this$block.model(TBSBlocks::VISCERA$lambda$0$1);
        $this$block.simpleItem();
    }

    private static final void VISCERA$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(new SoundType(1.0f, 1.0f, (SoundEvent)TBSSounds.GORE_BREAK.invoke(), (SoundEvent)TBSSounds.GORE_DIG.invoke(), (SoundEvent)TBSSounds.GORE_BREAK.invoke(), (SoundEvent)TBSSounds.GORE_DIG.invoke(), (SoundEvent)TBSSounds.GORE_DIG.invoke()));
        $this$props.strength(0.5f);
        $this$props.forceSolidOn();
        $this$props.noOcclusion();
    }

    private static final void VISCERA$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("nothing"), (int)1, null)).renderType(TBSConstants.id("name_missing")));
    }

    private static final void FLESH$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Flesh";
        $this$block.props(TBSBlocks::FLESH$lambda$0$0);
        $this$block.model(TBSBlocks::FLESH$lambda$0$1);
        $this$block.simpleItem();
    }

    private static final void FLESH$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.EMPTY);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void FLESH$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("nullvoid"), (int)1, null)).renderType(TBSConstants.id("flesh")));
    }

    private static final void OLDBLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "\"\u00a3!&!\"*$)$\"!*(\"_!)\"($!";
        $this$block.props(TBSBlocks::OLDBLOCK$lambda$0$0);
        $this$block.model(TBSBlocks::OLDBLOCK$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void OLDBLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WOOD);
        $this$props.strength(1.0f, 10.0f);
        $this$props.randomTicks();
        PropertiesExt.INSTANCE.postProcess($this$props);
        PropertiesExt.INSTANCE.emissive($this$props);
    }

    private static final void OLDBLOCK$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("errornotexture"), (int)1, null)).renderType("solid"));
    }

    private static final void HELLO$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::HELLO$lambda$0$0);
        $this$block.model(TBSBlocks::HELLO$lambda$0$1);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void HELLO$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        $this$props.strength(1.0f, 10.0f);
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.nonConductive($this$props);
    }

    private static final void HELLO$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("hi"), (int)1, null)).renderType("translucent"));
    }

    private static final void EMPTY$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::EMPTY$lambda$0$0);
        $this$block.model(TBSBlocks::EMPTY$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void EMPTY$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.EMPTY);
        $this$props.strength(3.0f, 0.5f);
    }

    private static final void EMPTY$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("dark"), (int)1, null)).renderType("solid"));
    }

    private static final void IT$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::IT$lambda$0$0);
        $this$block.model(TBSBlocks::IT$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void IT$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        PropertiesExt.INSTANCE.indestructible($this$props);
        $this$props.noCollission();
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.nonConductive($this$props);
    }

    private static final void IT$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("it"), (int)1, null)).renderType("cutout"));
    }

    private static final void EXIT$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "53135Exit6436";
        $this$block.props(TBSBlocks::EXIT$lambda$0$0);
        $this$block.model(TBSBlocks::EXIT$lambda$0$1);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void EXIT$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        PropertiesExt.INSTANCE.indestructible($this$props);
        PropertiesExt.INSTANCE.light($this$props, 15);
        $this$props.noCollission();
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.postProcess($this$props);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.nonConductive($this$props);
    }

    private static final void EXIT$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("exit"), (int)1, null)).renderType("translucent"));
    }

    private static final void A_FLOWER$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "A flower";
        $this$block.props(TBSBlocks::A_FLOWER$lambda$0$0);
        $this$block.model(TBSBlocks::A_FLOWER$lambda$0$1);
        $this$block.tags(TBSBlocks::A_FLOWER$lambda$0$2);
        $this$block.noLoot();
        $this$block.item(arg_0 -> TBSBlocks.A_FLOWER$lambda$0$3($this$block, arg_0));
    }

    private static final void A_FLOWER$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(-1.0f);
    }

    private static final void A_FLOWER$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), $this$model.cubeAll($this$model.getBlock()));
    }

    private static final void A_FLOWER$lambda$0$2(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.material(TBSBlocks::A_FLOWER$lambda$0$2$0);
    }

    private static final Unit A_FLOWER$lambda$0$2$0(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.smallFlower();
        $this$material.flower();
        return Unit.INSTANCE;
    }

    private static final void A_FLOWER$lambda$0$3(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        if (PlatformUtil.Companion.isProduction()) {
            $this$item.noTab();
        }
        $this$item.model(TBSBlocks::A_FLOWER$lambda$0$3$0);
    }

    private static final void A_FLOWER$lambda$0$3$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem((Item)$this$model.getItem());
    }

    private static final void DISRUPTION$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::DISRUPTION$lambda$0$0);
        $this$block.model(TBSBlocks::DISRUPTION$lambda$0$1);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void DISRUPTION$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.postProcess($this$props);
        PropertiesExt.INSTANCE.emissive($this$props);
    }

    private static final void DISRUPTION$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("old"), (int)1, null)).renderType("solid"));
    }

    private static final void PROTECTED_VOID$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::PROTECTED_VOID$lambda$0$0);
        $this$block.model(TBSBlocks::PROTECTED_VOID$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void PROTECTED_VOID$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.ANVIL);
        PropertiesExt.INSTANCE.indestructible($this$props);
        $this$props.pushReaction(PushReaction.PUSH_ONLY);
    }

    private static final void PROTECTED_VOID$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("protected_void"), (int)1, null)).renderType("solid"));
    }

    private static final void CONCRETE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::CONCRETE$lambda$0$0);
        $this$block.tags(TBSBlocks::CONCRETE$lambda$0$1);
        $this$block.model(TBSBlocks::CONCRETE$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void CONCRETE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        $this$props.pushReaction(PushReaction.PUSH_ONLY);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void CONCRETE$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::CONCRETE$lambda$0$1$0);
    }

    private static final Unit CONCRETE$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final void CONCRETE$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), $this$model.cubeAll($this$model.getBlock()));
    }

    private static final void INTENSE_PROJECTION$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::INTENSE_PROJECTION$lambda$0$0);
        $this$block.model(TBSBlocks::INTENSE_PROJECTION$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void INTENSE_PROJECTION$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.indestructible($this$props);
        $this$props.pushReaction(PushReaction.PUSH_ONLY);
    }

    private static final void INTENSE_PROJECTION$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), $this$model.cubeAll($this$model.getBlock()));
    }

    private static final void VOID_DOOR$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::VOID_DOOR$lambda$0$0);
        $this$block.model(TBSBlocks::VOID_DOOR$lambda$0$1);
        $this$block.tags(TBSBlocks::VOID_DOOR$lambda$0$2);
        $this$block.item(TBSBlocks::VOID_DOOR$lambda$0$3);
        $this$block.doorLoot();
    }

    private static final void VOID_DOOR$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.ANVIL);
        PropertiesExt.INSTANCE.indestructible($this$props);
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.nonConductive($this$props);
    }

    private static final void VOID_DOOR$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.doorBlockWithRenderType((DoorBlock)$this$model.getBlock(), $this$model.blockTexture("void_door_bottom"), $this$model.blockTexture("void_door_top"), "cutout");
    }

    private static final void VOID_DOOR$lambda$0$2(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.interactable(TBSBlocks::VOID_DOOR$lambda$0$2$0);
    }

    private static final Unit VOID_DOOR$lambda$0$2$0(BlockTagsBuilder.InteractableBlockTagBuilder $this$interactable) {
        Intrinsics.checkNotNullParameter((Object)$this$interactable, (String)"$this$interactable");
        $this$interactable.door();
        return Unit.INSTANCE;
    }

    private static final void VOID_DOOR$lambda$0$3(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::VOID_DOOR$lambda$0$3$0);
    }

    private static final void VOID_DOOR$lambda$0$3$0(BCBlockItemModelProvider $this$model) {
        ItemModelBuilder itemModelBuilder;
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        ItemModelBuilder $this$VOID_DOOR_u24lambda_u240_u243_u240_u240 = itemModelBuilder = $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated");
        boolean bl = false;
        $this$VOID_DOOR_u24lambda_u240_u243_u240_u240.texture("layer0", $this$model.modLoc("item/void_door"));
        $this$VOID_DOOR_u24lambda_u240_u243_u240_u240.renderType("cutout");
    }

    private static final void OBSIDIAN$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "ERR.INTEGRITY";
        $this$block.props(TBSBlocks::OBSIDIAN$lambda$0$0);
        $this$block.tags(TBSBlocks::OBSIDIAN$lambda$0$1);
        $this$block.model(TBSBlocks::OBSIDIAN$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void OBSIDIAN$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(50.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.light($this$props, 15);
        PropertiesExt.INSTANCE.postProcess($this$props);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.nonConductive($this$props);
    }

    private static final void OBSIDIAN$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::OBSIDIAN$lambda$0$1$0);
    }

    private static final Unit OBSIDIAN$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        $this$tool.needsDiamond();
        return Unit.INSTANCE;
    }

    private static final void OBSIDIAN$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("redobsidian"), (int)1, null)).renderType("solid"));
    }

    private static final void MONOCHROME_PLANKS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)Blocks.OAK_PLANKS));
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"ofFullCopy(...)");
        BlockBuilder.props$default((BlockBuilder)$this$block, (BlockBehaviour.Properties)properties, null, (int)2, null);
        $this$block.model(TBSBlocks::MONOCHROME_PLANKS$lambda$0$0);
        $this$block.tags(TBSBlocks::MONOCHROME_PLANKS$lambda$0$1);
        $this$block.simpleItem();
        $this$block.simpleLoot();
    }

    private static final void MONOCHROME_PLANKS$lambda$0$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("mono_planks"), (int)1, null)).renderType("solid"));
    }

    private static final void MONOCHROME_PLANKS$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::MONOCHROME_PLANKS$lambda$0$1$0);
        $this$tags.material(TBSBlocks::MONOCHROME_PLANKS$lambda$0$1$1);
    }

    private static final Unit MONOCHROME_PLANKS$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit MONOCHROME_PLANKS$lambda$0$1$1(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.planks();
        return Unit.INSTANCE;
    }

    private static final MONOCHROME_STAIRS.1.1 MONOCHROME_STAIRS$lambda$0(BlockBehaviour.Properties it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        BlockState blockState = Blocks.AIR.defaultBlockState();
        return new StairBlock(it, blockState){};
    }

    private static final void MONOCHROME_STAIRS$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)Blocks.OAK_PLANKS));
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"ofFullCopy(...)");
        BlockBuilder.props$default((BlockBuilder)$this$block, (BlockBehaviour.Properties)properties, null, (int)2, null);
        $this$block.model(TBSBlocks::MONOCHROME_STAIRS$lambda$1$0);
        $this$block.tags(TBSBlocks::MONOCHROME_STAIRS$lambda$1$1);
        $this$block.simpleItem();
        $this$block.simpleLoot();
    }

    private static final void MONOCHROME_STAIRS$lambda$1$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.stairsBlock((StairBlock)$this$model.getBlock(), $this$model.blockTexture("mono_planks"));
    }

    private static final void MONOCHROME_STAIRS$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::MONOCHROME_STAIRS$lambda$1$1$0);
        $this$tags.material(TBSBlocks::MONOCHROME_STAIRS$lambda$1$1$1);
    }

    private static final Unit MONOCHROME_STAIRS$lambda$1$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit MONOCHROME_STAIRS$lambda$1$1$1(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.planks();
        return Unit.INSTANCE;
    }

    private static final void MONOCHROME_SLAB$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)Blocks.OAK_SLAB));
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"ofFullCopy(...)");
        BlockBuilder.props$default((BlockBuilder)$this$block, (BlockBehaviour.Properties)properties, null, (int)2, null);
        $this$block.model(TBSBlocks::MONOCHROME_SLAB$lambda$0$0);
        $this$block.tags(TBSBlocks::MONOCHROME_SLAB$lambda$0$1);
        $this$block.simpleItem();
        $this$block.simpleLoot();
    }

    private static final void MONOCHROME_SLAB$lambda$0$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.slabBlock((SlabBlock)$this$model.getBlock(), $this$model.blockTexture("mono_planks"));
    }

    private static final void MONOCHROME_SLAB$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::MONOCHROME_SLAB$lambda$0$1$0);
        $this$tags.material(TBSBlocks::MONOCHROME_SLAB$lambda$0$1$1);
    }

    private static final Unit MONOCHROME_SLAB$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit MONOCHROME_SLAB$lambda$0$1$1(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.planks();
        return Unit.INSTANCE;
    }

    private static final void MONOCHROME_BOOKSHELF$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)Blocks.BOOKSHELF));
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"ofFullCopy(...)");
        BlockBuilder.props$default((BlockBuilder)$this$block, (BlockBehaviour.Properties)properties, null, (int)2, null);
        $this$block.model(TBSBlocks::MONOCHROME_BOOKSHELF$lambda$0$0);
        $this$block.tags(TBSBlocks::MONOCHROME_BOOKSHELF$lambda$0$1);
        $this$block.simpleItem();
        $this$block.simpleLoot();
    }

    private static final void MONOCHROME_BOOKSHELF$lambda$0$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeColumn$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("mono_library"), (ResourceLocation)$this$model.blockTexture("mono_planks"), (int)1, null)).renderType("solid"));
    }

    private static final void MONOCHROME_BOOKSHELF$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::MONOCHROME_BOOKSHELF$lambda$0$1$0);
    }

    private static final Unit MONOCHROME_BOOKSHELF$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final void WHITE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "OUTSIDE";
        $this$block.props(TBSBlocks::WHITE$lambda$0$0);
        $this$block.model(TBSBlocks::WHITE$lambda$0$1);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void WHITE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        $this$props.strength(50.0f, 1000.0f);
        $this$props.speedFactor(0.5f);
        $this$props.jumpFactor(0.5f);
        PropertiesExt.INSTANCE.postProcess($this$props);
        PropertiesExt.INSTANCE.emissive($this$props);
    }

    private static final void WHITE$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("exit"), (int)1, null)).renderType("solid"));
    }

    private static final void R_3$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::R_3$lambda$0$0);
        $this$block.model(TBSBlocks::R_3$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void R_3$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.METAL);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void R_3$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("dark"), (int)1, null)).renderType("solid"));
    }

    private static final void INT$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::INT$lambda$0$0);
        $this$block.model(TBSBlocks::INT$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void INT$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.noSound($this$props);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void INT$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("old"), (int)1, null)).renderType("translucent"));
    }

    private static final void SHADOW_BUG$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::SHADOW_BUG$lambda$0$0);
        $this$block.model(TBSBlocks::SHADOW_BUG$lambda$0$1);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void SHADOW_BUG$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.noSound($this$props);
        $this$props.strength(1.0f, 10.0f);
        $this$props.noCollission();
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.forceSolidOn();
    }

    private static final void SHADOW_BUG$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("barrier"), (int)1, null)).renderType("translucent"));
    }

    private static final void PORTAL_CONTROLLER$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::PORTAL_CONTROLLER$lambda$0$0);
        $this$block.model(TBSBlocks::PORTAL_CONTROLLER$lambda$0$1);
        $this$block.noLoot();
        $this$block.item(arg_0 -> TBSBlocks.PORTAL_CONTROLLER$lambda$0$2($this$block, arg_0));
    }

    private static final void PORTAL_CONTROLLER$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.noSound($this$props);
        $this$props.noCollission();
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.forceSolidOn();
        $this$props.strength(-1.0f, 3600000.0f);
    }

    private static final void PORTAL_CONTROLLER$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.models().cubeAll($this$model.name($this$model.getBlock()) + "_debug", $this$model.blockTexture($this$model.getBlock()));
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)$this$model.models().getBuilder($this$model.name($this$model.getBlock()))).texture("particle", $this$model.blockTexture($this$model.getBlock())));
    }

    private static final void PORTAL_CONTROLLER$lambda$0$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::PORTAL_CONTROLLER$lambda$0$2$0);
    }

    private static final void PORTAL_CONTROLLER$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Item item = (Item)$this$model.getItem();
        ResourceLocation resourceLocation = $this$model.key($this$model.getBlock()).withSuffix("_debug").withPrefix("block/");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withPrefix(...)");
        $this$model.withExistingParent(item, resourceLocation);
    }

    private static final void PORTAL_EXTENDER$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::PORTAL_EXTENDER$lambda$0$0);
        $this$block.model(TBSBlocks::PORTAL_EXTENDER$lambda$0$1);
        $this$block.noLoot();
        $this$block.item(arg_0 -> TBSBlocks.PORTAL_EXTENDER$lambda$0$2($this$block, arg_0));
    }

    private static final void PORTAL_EXTENDER$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.noSound($this$props);
        $this$props.noCollission();
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.forceSolidOn();
        $this$props.strength(-1.0f, 3600000.0f);
    }

    private static final void PORTAL_EXTENDER$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.models().cubeAll($this$model.name($this$model.getBlock()) + "_debug", $this$model.blockTexture($this$model.getBlock()));
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)$this$model.models().getBuilder($this$model.name($this$model.getBlock()))).texture("particle", $this$model.blockTexture($this$model.getBlock())));
    }

    private static final void PORTAL_EXTENDER$lambda$0$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::PORTAL_EXTENDER$lambda$0$2$0);
    }

    private static final void PORTAL_EXTENDER$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Item item = (Item)$this$model.getItem();
        ResourceLocation resourceLocation = $this$model.key($this$model.getBlock()).withSuffix("_debug").withPrefix("block/");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withPrefix(...)");
        $this$model.withExistingParent(item, resourceLocation);
    }

    private static final void PROTECTED_VOID_STAIRS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Protected Void";
        $this$block.props(TBSBlocks::PROTECTED_VOID_STAIRS$lambda$0$0);
        $this$block.tags(TBSBlocks::PROTECTED_VOID_STAIRS$lambda$0$1);
        $this$block.model(TBSBlocks::PROTECTED_VOID_STAIRS$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void PROTECTED_VOID_STAIRS$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.ANVIL);
        PropertiesExt.INSTANCE.indestructible($this$props);
        $this$props.strength(-1.0f, 3600000.0f);
    }

    private static final void PROTECTED_VOID_STAIRS$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.partialBlock(TBSBlocks::PROTECTED_VOID_STAIRS$lambda$0$1$0);
    }

    private static final Unit PROTECTED_VOID_STAIRS$lambda$0$1$0(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.stairs();
        return Unit.INSTANCE;
    }

    private static final void PROTECTED_VOID_STAIRS$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.stairsBlockWithRenderType((StairBlock)$this$model.getBlock(), $this$model.blockTexture("protected_void"), "solid");
    }

    private static final void PROTECTED_VOID_SLAB$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Protected Void";
        $this$block.props(TBSBlocks::PROTECTED_VOID_SLAB$lambda$0$0);
        $this$block.model(TBSBlocks::PROTECTED_VOID_SLAB$lambda$0$1);
        $this$block.slabLoot();
        $this$block.simpleItem();
    }

    private static final void PROTECTED_VOID_SLAB$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.ANVIL);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void PROTECTED_VOID_SLAB$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.slabBlock((SlabBlock)$this$model.getBlock(), $this$model.blockTexture("protected_void"));
    }

    private static final void PROTECTED_VOID_WALL$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Protected Void";
        $this$block.props(TBSBlocks::PROTECTED_VOID_WALL$lambda$0$0);
        $this$block.tags(TBSBlocks::PROTECTED_VOID_WALL$lambda$0$1);
        $this$block.model(TBSBlocks::PROTECTED_VOID_WALL$lambda$0$2);
        $this$block.simpleLoot();
    }

    private static final void PROTECTED_VOID_WALL$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.ANVIL);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void PROTECTED_VOID_WALL$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.partialBlock(TBSBlocks::PROTECTED_VOID_WALL$lambda$0$1$0);
    }

    private static final Unit PROTECTED_VOID_WALL$lambda$0$1$0(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.wall();
        return Unit.INSTANCE;
    }

    private static final void PROTECTED_VOID_WALL$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.wallBlock((WallBlock)$this$model.getBlock(), $this$model.blockTexture("protected_void"));
    }

    private static final void PROTECTED_VOID_FENCE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Protected Void";
        $this$block.props(TBSBlocks::PROTECTED_VOID_FENCE$lambda$0$0);
        $this$block.tags(TBSBlocks::PROTECTED_VOID_FENCE$lambda$0$1);
        $this$block.model(TBSBlocks::PROTECTED_VOID_FENCE$lambda$0$2);
        $this$block.simpleLoot();
    }

    private static final void PROTECTED_VOID_FENCE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.ANVIL);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void PROTECTED_VOID_FENCE$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.partialBlock(TBSBlocks::PROTECTED_VOID_FENCE$lambda$0$1$0);
    }

    private static final Unit PROTECTED_VOID_FENCE$lambda$0$1$0(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.fence();
        return Unit.INSTANCE;
    }

    private static final void PROTECTED_VOID_FENCE$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.fenceBlock((FenceBlock)$this$model.getBlock(), $this$model.blockTexture("protected_void"));
    }

    private static final void PROTECTED_VOID_LIGHT$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Void Light";
        $this$block.props(TBSBlocks::PROTECTED_VOID_LIGHT$lambda$0$0);
        $this$block.model(TBSBlocks::PROTECTED_VOID_LIGHT$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void PROTECTED_VOID_LIGHT$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        PropertiesExt.INSTANCE.indestructible($this$props);
        PropertiesExt.INSTANCE.light($this$props, 8);
    }

    private static final void PROTECTED_VOID_LIGHT$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("void_light"), (int)1, null)).renderType("solid"));
    }

    private static final void PHYSICAL_STACKTRACE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::PHYSICAL_STACKTRACE$lambda$0$0);
        $this$block.model(TBSBlocks::PHYSICAL_STACKTRACE$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void PHYSICAL_STACKTRACE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.ANVIL);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void PHYSICAL_STACKTRACE$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("stack_trace"), (int)1, null)).renderType("solid"));
    }

    private static final void BLOCK_IS_MISSING_ID$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::BLOCK_IS_MISSING_ID$lambda$0$0);
        $this$block.model(TBSBlocks::BLOCK_IS_MISSING_ID$lambda$0$1);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void BLOCK_IS_MISSING_ID$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.METAL);
        $this$props.strength(1.0f, 10.0f);
    }

    private static final void BLOCK_IS_MISSING_ID$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("dark"), (int)1, null)).renderType("solid"));
    }

    private static final void NOWHERE_BLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Nowhere Light";
        $this$block.props(TBSBlocks::NOWHERE_BLOCK$lambda$0$0);
        $this$block.model(TBSBlocks::NOWHERE_BLOCK$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void NOWHERE_BLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        PropertiesExt.INSTANCE.indestructible($this$props);
        PropertiesExt.INSTANCE.light($this$props, 15);
    }

    private static final void NOWHERE_BLOCK$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("exit"), (int)1, null)).renderType("solid"));
    }

    private static final void NULL$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "";
        $this$block.props(TBSBlocks::NULL$lambda$0$0);
        $this$block.item(arg_0 -> TBSBlocks.NULL$lambda$0$1($this$block, arg_0));
        $this$block.noLoot();
    }

    private static final void NULL$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void NULL$lambda$0$1(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
    }

    private static final void MOON_STONE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::MOON_STONE$lambda$0$0);
        $this$block.tags(TBSBlocks::MOON_STONE$lambda$0$1);
        $this$block.model(TBSBlocks::MOON_STONE$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void MOON_STONE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void MOON_STONE$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::MOON_STONE$lambda$0$1$0);
    }

    private static final Unit MOON_STONE$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final void MOON_STONE$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("moon_stone"), (int)1, null)).renderType("solid"));
    }

    private static final void MOON_STONE_BRICKS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::MOON_STONE_BRICKS$lambda$0$0);
        $this$block.tags(TBSBlocks::MOON_STONE_BRICKS$lambda$0$1);
        $this$block.model(TBSBlocks::MOON_STONE_BRICKS$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void MOON_STONE_BRICKS$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void MOON_STONE_BRICKS$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::MOON_STONE_BRICKS$lambda$0$1$0);
    }

    private static final Unit MOON_STONE_BRICKS$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final void MOON_STONE_BRICKS$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("moon_stone_bricks"), (int)1, null)).renderType("solid"));
    }

    private static final MOON_STONE_BRICK_STAIRS.1.1 MOON_STONE_BRICK_STAIRS$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        BlockState blockState = ((Block)MOON_STONE.get()).defaultBlockState();
        return new StairBlock(props, blockState){};
    }

    private static final void MOON_STONE_BRICK_STAIRS$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::MOON_STONE_BRICK_STAIRS$lambda$1$0);
        $this$block.tags(TBSBlocks::MOON_STONE_BRICK_STAIRS$lambda$1$1);
        $this$block.model(TBSBlocks::MOON_STONE_BRICK_STAIRS$lambda$1$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void MOON_STONE_BRICK_STAIRS$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void MOON_STONE_BRICK_STAIRS$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::MOON_STONE_BRICK_STAIRS$lambda$1$1$0);
        $this$tags.partialBlock(TBSBlocks::MOON_STONE_BRICK_STAIRS$lambda$1$1$1);
    }

    private static final Unit MOON_STONE_BRICK_STAIRS$lambda$1$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final Unit MOON_STONE_BRICK_STAIRS$lambda$1$1$1(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.stairs();
        return Unit.INSTANCE;
    }

    private static final void MOON_STONE_BRICK_STAIRS$lambda$1$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.stairsBlock((StairBlock)$this$model.getBlock(), $this$model.blockTexture("moon_stone_bricks"));
    }

    private static final void MOON_STONE_BRICK_SLAB$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::MOON_STONE_BRICK_SLAB$lambda$0$0);
        $this$block.tags(TBSBlocks::MOON_STONE_BRICK_SLAB$lambda$0$1);
        $this$block.model(TBSBlocks::MOON_STONE_BRICK_SLAB$lambda$0$2);
        $this$block.slabLoot();
        $this$block.simpleItem();
    }

    private static final void MOON_STONE_BRICK_SLAB$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void MOON_STONE_BRICK_SLAB$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::MOON_STONE_BRICK_SLAB$lambda$0$1$0);
        $this$tags.partialBlock(TBSBlocks::MOON_STONE_BRICK_SLAB$lambda$0$1$1);
    }

    private static final Unit MOON_STONE_BRICK_SLAB$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final Unit MOON_STONE_BRICK_SLAB$lambda$0$1$1(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.slab();
        return Unit.INSTANCE;
    }

    private static final void MOON_STONE_BRICK_SLAB$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.slabBlock((SlabBlock)$this$model.getBlock(), $this$model.blockTexture("moon_stone_bricks"));
    }

    private static final void MOON_STONE_BRICK_WALL$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::MOON_STONE_BRICK_WALL$lambda$0$0);
        $this$block.tags(TBSBlocks::MOON_STONE_BRICK_WALL$lambda$0$1);
        $this$block.model(TBSBlocks::MOON_STONE_BRICK_WALL$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.item(TBSBlocks::MOON_STONE_BRICK_WALL$lambda$0$3);
    }

    private static final void MOON_STONE_BRICK_WALL$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void MOON_STONE_BRICK_WALL$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::MOON_STONE_BRICK_WALL$lambda$0$1$0);
        $this$tags.partialBlock(TBSBlocks::MOON_STONE_BRICK_WALL$lambda$0$1$1);
    }

    private static final Unit MOON_STONE_BRICK_WALL$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final Unit MOON_STONE_BRICK_WALL$lambda$0$1$1(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.wall();
        return Unit.INSTANCE;
    }

    private static final void MOON_STONE_BRICK_WALL$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.wallBlock((WallBlock)$this$model.getBlock(), $this$model.blockTexture("moon_stone_bricks"));
    }

    private static final void MOON_STONE_BRICK_WALL$lambda$0$3(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::MOON_STONE_BRICK_WALL$lambda$0$3$0);
    }

    private static final void MOON_STONE_BRICK_WALL$lambda$0$3$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        ((ItemModelBuilder)$this$model.withExistingParent("moon_stone_brick_wall", "minecraft:block/wall_inventory")).texture("wall", TBSConstants.id("block/moon_stone_bricks"));
    }

    private static final void CORRUPTED_MOON_STONE_BRICKS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::CORRUPTED_MOON_STONE_BRICKS$lambda$0$0);
        $this$block.tags(TBSBlocks::CORRUPTED_MOON_STONE_BRICKS$lambda$0$1);
        $this$block.model(TBSBlocks::CORRUPTED_MOON_STONE_BRICKS$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void CORRUPTED_MOON_STONE_BRICKS$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void CORRUPTED_MOON_STONE_BRICKS$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::CORRUPTED_MOON_STONE_BRICKS$lambda$0$1$0);
    }

    private static final Unit CORRUPTED_MOON_STONE_BRICKS$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final void CORRUPTED_MOON_STONE_BRICKS$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("corrupted_moon_stone_bricks"), (int)1, null)).renderType("solid"));
    }

    private static final void CHISELED_MOON_STONE_BRICKS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::CHISELED_MOON_STONE_BRICKS$lambda$0$0);
        $this$block.tags(TBSBlocks::CHISELED_MOON_STONE_BRICKS$lambda$0$1);
        $this$block.model(TBSBlocks::CHISELED_MOON_STONE_BRICKS$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void CHISELED_MOON_STONE_BRICKS$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void CHISELED_MOON_STONE_BRICKS$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::CHISELED_MOON_STONE_BRICKS$lambda$0$1$0);
    }

    private static final Unit CHISELED_MOON_STONE_BRICKS$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final void CHISELED_MOON_STONE_BRICKS$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("chiseled_moon_stone_bricks"), (int)1, null)).renderType("solid"));
    }

    private static final void POLISHED_MOON_STONE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::POLISHED_MOON_STONE$lambda$0$0);
        $this$block.tags(TBSBlocks::POLISHED_MOON_STONE$lambda$0$1);
        $this$block.model(TBSBlocks::POLISHED_MOON_STONE$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void POLISHED_MOON_STONE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void POLISHED_MOON_STONE$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::POLISHED_MOON_STONE$lambda$0$1$0);
    }

    private static final Unit POLISHED_MOON_STONE$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final void POLISHED_MOON_STONE$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("polished_moon_stone"), (int)1, null)).renderType("solid"));
    }

    private static final POLISHED_MOON_STONE_STAIRS.1.1 POLISHED_MOON_STONE_STAIRS$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        BlockState blockState = ((Block)MOON_STONE.get()).defaultBlockState();
        return new StairBlock(props, blockState){};
    }

    private static final void POLISHED_MOON_STONE_STAIRS$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::POLISHED_MOON_STONE_STAIRS$lambda$1$0);
        $this$block.tags(TBSBlocks::POLISHED_MOON_STONE_STAIRS$lambda$1$1);
        $this$block.model(TBSBlocks::POLISHED_MOON_STONE_STAIRS$lambda$1$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void POLISHED_MOON_STONE_STAIRS$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void POLISHED_MOON_STONE_STAIRS$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::POLISHED_MOON_STONE_STAIRS$lambda$1$1$0);
        $this$tags.partialBlock(TBSBlocks::POLISHED_MOON_STONE_STAIRS$lambda$1$1$1);
    }

    private static final Unit POLISHED_MOON_STONE_STAIRS$lambda$1$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final Unit POLISHED_MOON_STONE_STAIRS$lambda$1$1$1(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.stairs();
        return Unit.INSTANCE;
    }

    private static final void POLISHED_MOON_STONE_STAIRS$lambda$1$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.stairsBlock((StairBlock)$this$model.getBlock(), $this$model.blockTexture("polished_moon_stone"));
    }

    private static final void POLISHED_MOON_STONE_SLAB$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::POLISHED_MOON_STONE_SLAB$lambda$0$0);
        $this$block.tags(TBSBlocks::POLISHED_MOON_STONE_SLAB$lambda$0$1);
        $this$block.model(TBSBlocks::POLISHED_MOON_STONE_SLAB$lambda$0$2);
        $this$block.slabLoot();
        $this$block.simpleItem();
    }

    private static final void POLISHED_MOON_STONE_SLAB$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void POLISHED_MOON_STONE_SLAB$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::POLISHED_MOON_STONE_SLAB$lambda$0$1$0);
        $this$tags.partialBlock(TBSBlocks::POLISHED_MOON_STONE_SLAB$lambda$0$1$1);
    }

    private static final Unit POLISHED_MOON_STONE_SLAB$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final Unit POLISHED_MOON_STONE_SLAB$lambda$0$1$1(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.slab();
        return Unit.INSTANCE;
    }

    private static final void POLISHED_MOON_STONE_SLAB$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.slabBlock((SlabBlock)$this$model.getBlock(), $this$model.blockTexture("polished_moon_stone"));
    }

    private static final void POLISHED_MOON_STONE_WALL$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::POLISHED_MOON_STONE_WALL$lambda$0$0);
        $this$block.tags(TBSBlocks::POLISHED_MOON_STONE_WALL$lambda$0$1);
        $this$block.model(TBSBlocks::POLISHED_MOON_STONE_WALL$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.item(TBSBlocks::POLISHED_MOON_STONE_WALL$lambda$0$3);
    }

    private static final void POLISHED_MOON_STONE_WALL$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(1.0f, 10.0f);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
    }

    private static final void POLISHED_MOON_STONE_WALL$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::POLISHED_MOON_STONE_WALL$lambda$0$1$0);
        $this$tags.partialBlock(TBSBlocks::POLISHED_MOON_STONE_WALL$lambda$0$1$1);
    }

    private static final Unit POLISHED_MOON_STONE_WALL$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.pickaxe();
        return Unit.INSTANCE;
    }

    private static final Unit POLISHED_MOON_STONE_WALL$lambda$0$1$1(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.wall();
        return Unit.INSTANCE;
    }

    private static final void POLISHED_MOON_STONE_WALL$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.wallBlock((WallBlock)$this$model.getBlock(), $this$model.blockTexture("polished_moon_stone"));
    }

    private static final void POLISHED_MOON_STONE_WALL$lambda$0$3(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::POLISHED_MOON_STONE_WALL$lambda$0$3$0);
    }

    private static final void POLISHED_MOON_STONE_WALL$lambda$0$3$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        ((ItemModelBuilder)$this$model.withExistingParent("polished_moon_stone_wall", "minecraft:block/wall_inventory")).texture("wall", TBSConstants.id("block/polished_moon_stone"));
    }

    private static final void LIMBO$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::LIMBO$lambda$0$0);
        $this$block.model(TBSBlocks::LIMBO$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void LIMBO$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.EMPTY);
        PropertiesExt.INSTANCE.indestructible($this$props);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noOcclusion();
    }

    private static final void LIMBO$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("limbo"), (int)1, null)).renderType("translucent"));
    }

    private static final void NOTHING$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::NOTHING$lambda$0$0);
        $this$block.model(TBSBlocks::NOTHING$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void NOTHING$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        PropertiesExt.INSTANCE.indestructible($this$props);
        PropertiesExt.INSTANCE.nonConductive($this$props);
    }

    private static final void NOTHING$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("nothing"), (int)1, null)).renderType("solid"));
    }

    private static final void SPRUCE_WOOD_SLAB$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)Blocks.SPRUCE_WOOD));
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"ofFullCopy(...)");
        BlockBuilder.props$default((BlockBuilder)$this$block, (BlockBehaviour.Properties)properties, null, (int)2, null);
        $this$block.model(TBSBlocks::SPRUCE_WOOD_SLAB$lambda$0$0);
        $this$block.tags(TBSBlocks::SPRUCE_WOOD_SLAB$lambda$0$1);
        $this$block.slabLoot();
        $this$block.simpleItem();
    }

    private static final void SPRUCE_WOOD_SLAB$lambda$0$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        SlabBlock slabBlock = (SlabBlock)$this$model.getBlock();
        Block block = Blocks.SPRUCE_LOG;
        Intrinsics.checkNotNullExpressionValue((Object)block, (String)"SPRUCE_LOG");
        $this$model.slabBlock(slabBlock, $this$model.blockTexture(block));
    }

    private static final void SPRUCE_WOOD_SLAB$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.partialBlock(TBSBlocks::SPRUCE_WOOD_SLAB$lambda$0$1$0);
    }

    private static final Unit SPRUCE_WOOD_SLAB$lambda$0$1$0(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.slab();
        return Unit.INSTANCE;
    }

    private static final void SMOOTH_STONE_VERTICAL_SLAB$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)Blocks.SMOOTH_STONE));
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"ofFullCopy(...)");
        BlockBuilder.props$default((BlockBuilder)$this$block, (BlockBehaviour.Properties)properties, null, (int)2, null);
        $this$block.model(TBSBlocks::SMOOTH_STONE_VERTICAL_SLAB$lambda$0$0);
        $this$block.slabLoot();
        $this$block.simpleItem();
    }

    private static final void SMOOTH_STONE_VERTICAL_SLAB$lambda$0$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        VerticalSlabBlock verticalSlabBlock = (VerticalSlabBlock)$this$model.getBlock();
        Block block = Blocks.SMOOTH_STONE;
        Intrinsics.checkNotNullExpressionValue((Object)block, (String)"SMOOTH_STONE");
        $this$model.verticalSlabBlock(verticalSlabBlock, $this$model.blockTexture(block));
    }

    private static final void UD_OAK_DOOR$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Upside Down Oak Door";
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)Blocks.OAK_DOOR));
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"ofFullCopy(...)");
        BlockBuilder.props$default((BlockBuilder)$this$block, (BlockBehaviour.Properties)properties, null, (int)2, null);
        $this$block.model(TBSBlocks::UD_OAK_DOOR$lambda$0$0);
        $this$block.doorLoot(TBSBlocks::UD_OAK_DOOR$lambda$0$1);
        $this$block.item(arg_0 -> TBSBlocks.UD_OAK_DOOR$lambda$0$2($this$block, arg_0));
    }

    private static final void UD_OAK_DOOR$lambda$0$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.doorBlockWithRenderType((DoorBlock)$this$model.getBlock(), $this$model.blockTexture("ud_oak_door_bottom"), $this$model.blockTexture("ud_oak_door"), "cutout");
    }

    private static final ItemLike UD_OAK_DOOR$lambda$0$1() {
        Item item = Items.OAK_DOOR;
        Intrinsics.checkNotNullExpressionValue((Object)item, (String)"OAK_DOOR");
        return (ItemLike)item;
    }

    private static final void UD_OAK_DOOR$lambda$0$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::UD_OAK_DOOR$lambda$0$2$0);
    }

    private static final void UD_OAK_DOOR$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem((Item)$this$model.getItem());
    }

    private static final void NEW_VEIN_BLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::NEW_VEIN_BLOCK$lambda$0$0);
        $this$block.lang = "Vein";
        $this$block.item(TBSBlocks::NEW_VEIN_BLOCK$lambda$0$1);
    }

    private static final void NEW_VEIN_BLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLOW_LICHEN);
        $this$props.replaceable();
        $this$props.noCollission();
        $this$props.strength(0.2f);
        $this$props.pushReaction(PushReaction.DESTROY);
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void NEW_VEIN_BLOCK$lambda$0$1(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::NEW_VEIN_BLOCK$lambda$0$1$0);
    }

    private static final void NEW_VEIN_BLOCK$lambda$0$1$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem((Item)$this$model.getItem());
    }

    private static final void SIDEWAYS_FURNACE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::SIDEWAYS_FURNACE$lambda$0$0);
        $this$block.model(TBSBlocks::SIDEWAYS_FURNACE$lambda$0$1);
        $this$block.lang = "Furnace";
        $this$block.simpleLoot(TBSBlocks::SIDEWAYS_FURNACE$lambda$0$2);
        $this$block.item(TBSBlocks::SIDEWAYS_FURNACE$lambda$0$3);
    }

    private static final void SIDEWAYS_FURNACE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        $this$props.strength(3.5f, 3.5f);
    }

    private static final void SIDEWAYS_FURNACE$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.horizontalBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), (ModelFile)((ModelFile)$this$model.models().getExistingFile($this$model.modLoc("block/sideways_furnace"))), (int)0, (int)4, null);
    }

    private static final ItemLike SIDEWAYS_FURNACE$lambda$0$2() {
        Block block = Blocks.FURNACE;
        Intrinsics.checkNotNullExpressionValue((Object)block, (String)"FURNACE");
        return (ItemLike)block;
    }

    private static final void SIDEWAYS_FURNACE$lambda$0$3(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::SIDEWAYS_FURNACE$lambda$0$3$0);
    }

    private static final void SIDEWAYS_FURNACE$lambda$0$3$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple().override().model((ModelFile)$this$model.getExistingFile($this$model.mcLoc("item/ender_eye")));
    }

    private static final SIDEWAYS_PANE.1.1 SIDEWAYS_PANE$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        BlockBehaviour.Properties properties = props.strength(0.5f, 0.1f);
        return new Block(properties){
            private final VoxelShape shape;
            {
                this.shape = Block.box((double)0.0, (double)7.0, (double)0.0, (double)16.0, (double)9.0, (double)16.0);
            }

            protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                VoxelShape voxelShape = this.shape;
                Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"shape");
                return voxelShape;
            }
        };
    }

    private static final void SIDEWAYS_PANE$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Pane";
        $this$block.simpleLoot(TBSBlocks::SIDEWAYS_PANE$lambda$1$0);
        $this$block.model(TBSBlocks::SIDEWAYS_PANE$lambda$1$1);
        $this$block.item(TBSBlocks::SIDEWAYS_PANE$lambda$1$2);
    }

    private static final ItemLike SIDEWAYS_PANE$lambda$1$0() {
        Block block = Blocks.GLASS_PANE;
        Intrinsics.checkNotNullExpressionValue((Object)block, (String)"GLASS_PANE");
        return (ItemLike)block;
    }

    private static final void SIDEWAYS_PANE$lambda$1$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)$this$model.models().getExistingFile($this$model.modLoc("block/sideways_pane")));
    }

    private static final void SIDEWAYS_PANE$lambda$1$2(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::SIDEWAYS_PANE$lambda$1$2$0);
    }

    private static final void SIDEWAYS_PANE$lambda$1$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple().override().model((ModelFile)$this$model.getExistingFile($this$model.mcLoc("item/birch_log")));
    }

    private static final void SIDEWAYS_FENCE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::SIDEWAYS_FENCE$lambda$0$0);
        $this$block.lang = "Fence";
        $this$block.simpleLoot(TBSBlocks::SIDEWAYS_FENCE$lambda$0$1);
        $this$block.model(TBSBlocks::SIDEWAYS_FENCE$lambda$0$2);
        $this$block.item(TBSBlocks::SIDEWAYS_FENCE$lambda$0$3);
    }

    private static final void SIDEWAYS_FENCE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        $this$props.strength(2.2f, 2.2f);
        $this$props.noOcclusion();
    }

    private static final ItemLike SIDEWAYS_FENCE$lambda$0$1() {
        Block block = Blocks.OAK_FENCE;
        Intrinsics.checkNotNullExpressionValue((Object)block, (String)"OAK_FENCE");
        return (ItemLike)block;
    }

    private static final void SIDEWAYS_FENCE$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.horizontalBlock($this$model.getBlock(), (ModelFile)$this$model.models().getExistingFile($this$model.modLoc("block/sideways_fence")), 90);
    }

    private static final void SIDEWAYS_FENCE$lambda$0$3(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::SIDEWAYS_FENCE$lambda$0$3$0);
    }

    private static final void SIDEWAYS_FENCE$lambda$0$3$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple().override().model((ModelFile)$this$model.getExistingFile(TBSItems.GORE.getId()));
    }

    private static final void SIDEWAYS_STAIRS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::SIDEWAYS_STAIRS$lambda$0$0);
        $this$block.lang = "Cobblestone Stairs";
        $this$block.simpleLoot(TBSBlocks::SIDEWAYS_STAIRS$lambda$0$1);
        $this$block.item(arg_0 -> TBSBlocks.SIDEWAYS_STAIRS$lambda$0$2($this$block, arg_0));
        $this$block.model(TBSBlocks::SIDEWAYS_STAIRS$lambda$0$3);
    }

    private static final void SIDEWAYS_STAIRS$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        $this$props.strength(2.2f, 2.2f);
        $this$props.noOcclusion();
    }

    private static final ItemLike SIDEWAYS_STAIRS$lambda$0$1() {
        Block block = Blocks.COBBLESTONE_STAIRS;
        Intrinsics.checkNotNullExpressionValue((Object)block, (String)"COBBLESTONE_STAIRS");
        return (ItemLike)block;
    }

    private static final void SIDEWAYS_STAIRS$lambda$0$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(arg_0 -> TBSBlocks.SIDEWAYS_STAIRS$lambda$0$2$0($this$item, $this_block, arg_0));
    }

    private static final void SIDEWAYS_STAIRS$lambda$0$2$0(BlockItemBuilder $this_item, BlockBuilder $this_block, BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this_item.lang = $this_block.lang;
    }

    private static final void SIDEWAYS_STAIRS$lambda$0$3(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.horizontalBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), (ModelFile)((ModelFile)$this$model.models().getExistingFile($this$model.modLoc("block/sideways_cobblestone_stairs_up"))), (int)0, (int)4, null);
    }

    private static final void NULL_STRUCTURE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::NULL_STRUCTURE$lambda$0$0);
        $this$block.model(TBSBlocks::NULL_STRUCTURE$lambda$0$1);
        $this$block.lang = "TBS Structure Trigger";
        $this$block.noLoot();
        $this$block.item(arg_0 -> TBSBlocks.NULL_STRUCTURE$lambda$0$2($this$block, arg_0));
    }

    private static final void NULL_STRUCTURE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.noSound($this$props);
        $this$props.noCollission();
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.forceSolidOn();
        $this$props.strength(-1.0f, 3600000.0f);
    }

    private static final void NULL_STRUCTURE$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.models().cubeAll($this$model.name($this$model.getBlock()) + "_debug", $this$model.blockTexture($this$model.getBlock()));
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)$this$model.models().getBuilder($this$model.name($this$model.getBlock()))).texture("particle", $this$model.blockTexture($this$model.getBlock())));
    }

    private static final void NULL_STRUCTURE$lambda$0$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::NULL_STRUCTURE$lambda$0$2$0);
    }

    private static final void NULL_STRUCTURE$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem((Item)$this$model.getItem());
    }

    private static final void NECROSIS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::NECROSIS$lambda$0$0);
        $this$block.model(TBSBlocks::NECROSIS$lambda$0$1);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void NECROSIS$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.METAL);
        PropertiesExt.INSTANCE.indestructible($this$props);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 2);
        PropertiesExt.INSTANCE.emissive($this$props);
    }

    private static final void NECROSIS$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("necrosis"), (int)1, null)).renderType("solid"));
    }

    private static final void VOID_SPROUT$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::VOID_SPROUT$lambda$0$0);
        $this$block.model(TBSBlocks::VOID_SPROUT$lambda$0$1);
        $this$block.simpleItem();
        $this$block.loot(TBSBlocks::VOID_SPROUT$lambda$0$2);
        $this$block.tags(TBSBlocks::VOID_SPROUT$lambda$0$3);
        $this$block.lang = "Ignorance";
    }

    private static final void VOID_SPROUT$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GRASS);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_SPROUT$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.directionalBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), (ModelFile)((ModelFile)$this$model.models().getExistingFile(TBSConstants.id("block/void_sprout"))), (int)0, (int)4, null);
    }

    private static final Unit VOID_SPROUT$lambda$0$2(LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"itemEntry");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"blockEntry");
        LootBuildersKt.pool((LootTable.Builder)$this$loot, arg_0 -> TBSBlocks.VOID_SPROUT$lambda$0$2$0(itemEntry, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit VOID_SPROUT$lambda$0$2$0(ItemEntry $itemEntry, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls((LootPool.Builder)$this$pool, (float)1.0f);
        LootItemCondition.Builder builder = MatchTool.toolMatches((ItemPredicate.Builder)ItemPredicate.Builder.item().of(TBSTags.CAN_BE_USED_FOR_VOID_FLORA));
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"toolMatches(...)");
        LootBuildersKt.condition$default((LootPool.Builder)$this$pool, (LootItemCondition.Builder)builder, null, (int)2, null);
        LootPoolSingletonContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$itemEntry.get()));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"lootTableItem(...)");
        LootBuildersKt.entry$default((LootPool.Builder)$this$pool, (LootPoolEntryContainer.Builder)((LootPoolEntryContainer.Builder)builder2), null, (int)2, null);
        return Unit.INSTANCE;
    }

    private static final void VOID_SPROUT$lambda$0$3(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.material(TBSBlocks::VOID_SPROUT$lambda$0$3$0);
    }

    private static final Unit VOID_SPROUT$lambda$0$3$0(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.flower();
        $this$material.smallFlower();
        return Unit.INSTANCE;
    }

    private static final void VOID_BUD$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::VOID_BUD$lambda$0$0);
        $this$block.model(TBSBlocks::VOID_BUD$lambda$0$1);
        $this$block.simpleItem();
        $this$block.loot(TBSBlocks::VOID_BUD$lambda$0$2);
        $this$block.tags(TBSBlocks::VOID_BUD$lambda$0$3);
        $this$block.lang = "Destitution";
    }

    private static final void VOID_BUD$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GRASS);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 3);
        PropertiesExt.INSTANCE.emissive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_BUD$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.directionalBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), (ModelFile)((ModelFile)$this$model.models().getExistingFile(TBSConstants.id("block/void_bud"))), (int)0, (int)4, null);
    }

    private static final Unit VOID_BUD$lambda$0$2(LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"itemEntry");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"blockEntry");
        LootBuildersKt.pool((LootTable.Builder)$this$loot, arg_0 -> TBSBlocks.VOID_BUD$lambda$0$2$0(itemEntry, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit VOID_BUD$lambda$0$2$0(ItemEntry $itemEntry, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls((LootPool.Builder)$this$pool, (float)1.0f);
        LootItemCondition.Builder builder = MatchTool.toolMatches((ItemPredicate.Builder)ItemPredicate.Builder.item().of(TBSTags.CAN_BE_USED_FOR_VOID_FLORA));
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"toolMatches(...)");
        LootBuildersKt.condition$default((LootPool.Builder)$this$pool, (LootItemCondition.Builder)builder, null, (int)2, null);
        LootPoolSingletonContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$itemEntry.get()));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"lootTableItem(...)");
        LootBuildersKt.entry$default((LootPool.Builder)$this$pool, (LootPoolEntryContainer.Builder)((LootPoolEntryContainer.Builder)builder2), null, (int)2, null);
        return Unit.INSTANCE;
    }

    private static final void VOID_BUD$lambda$0$3(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.material(TBSBlocks::VOID_BUD$lambda$0$3$0);
    }

    private static final Unit VOID_BUD$lambda$0$3$0(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.flower();
        $this$material.smallFlower();
        return Unit.INSTANCE;
    }

    private static final void VOID_BUDDING$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::VOID_BUDDING$lambda$0$0);
        $this$block.model(TBSBlocks::VOID_BUDDING$lambda$0$1);
        $this$block.simpleItem();
        $this$block.loot(TBSBlocks::VOID_BUDDING$lambda$0$2);
        $this$block.tags(TBSBlocks::VOID_BUDDING$lambda$0$3);
        $this$block.lang = "Usurpation";
    }

    private static final void VOID_BUDDING$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GRASS);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 4);
        PropertiesExt.INSTANCE.emissive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_BUDDING$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.directionalBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), (ModelFile)((ModelFile)$this$model.models().getExistingFile(TBSConstants.id("block/void_budding"))), (int)0, (int)4, null);
    }

    private static final Unit VOID_BUDDING$lambda$0$2(LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"itemEntry");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"blockEntry");
        LootBuildersKt.pool((LootTable.Builder)$this$loot, arg_0 -> TBSBlocks.VOID_BUDDING$lambda$0$2$0(itemEntry, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit VOID_BUDDING$lambda$0$2$0(ItemEntry $itemEntry, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls((LootPool.Builder)$this$pool, (float)1.0f);
        LootItemCondition.Builder builder = MatchTool.toolMatches((ItemPredicate.Builder)ItemPredicate.Builder.item().of(TBSTags.CAN_BE_USED_FOR_VOID_FLORA));
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"toolMatches(...)");
        LootBuildersKt.condition$default((LootPool.Builder)$this$pool, (LootItemCondition.Builder)builder, null, (int)2, null);
        LootPoolSingletonContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$itemEntry.get()));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"lootTableItem(...)");
        LootBuildersKt.entry$default((LootPool.Builder)$this$pool, (LootPoolEntryContainer.Builder)((LootPoolEntryContainer.Builder)builder2), null, (int)2, null);
        return Unit.INSTANCE;
    }

    private static final void VOID_BUDDING$lambda$0$3(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.material(TBSBlocks::VOID_BUDDING$lambda$0$3$0);
    }

    private static final Unit VOID_BUDDING$lambda$0$3$0(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.flower();
        $this$material.smallFlower();
        return Unit.INSTANCE;
    }

    private static final void VOID_BLOOM$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::VOID_BLOOM$lambda$0$0);
        $this$block.model(TBSBlocks::VOID_BLOOM$lambda$0$1);
        $this$block.simpleItem();
        $this$block.loot(TBSBlocks::VOID_BLOOM$lambda$0$2);
        $this$block.tags(TBSBlocks::VOID_BLOOM$lambda$0$3);
        $this$block.lang = "Reconstruction";
    }

    private static final void VOID_BLOOM$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GRASS);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 5);
        PropertiesExt.INSTANCE.emissive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_BLOOM$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.directionalBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), (ModelFile)((ModelFile)$this$model.models().getExistingFile(TBSConstants.id("block/void_bloom"))), (int)0, (int)4, null);
    }

    private static final Unit VOID_BLOOM$lambda$0$2(LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"itemEntry");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"blockEntry");
        LootBuildersKt.pool((LootTable.Builder)$this$loot, arg_0 -> TBSBlocks.VOID_BLOOM$lambda$0$2$0(itemEntry, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit VOID_BLOOM$lambda$0$2$0(ItemEntry $itemEntry, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls((LootPool.Builder)$this$pool, (float)1.0f);
        LootItemCondition.Builder builder = MatchTool.toolMatches((ItemPredicate.Builder)ItemPredicate.Builder.item().of(TBSTags.CAN_BE_USED_FOR_VOID_FLORA));
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"toolMatches(...)");
        LootBuildersKt.condition$default((LootPool.Builder)$this$pool, (LootItemCondition.Builder)builder, null, (int)2, null);
        LootPoolSingletonContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$itemEntry.get()));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"lootTableItem(...)");
        LootBuildersKt.entry$default((LootPool.Builder)$this$pool, (LootPoolEntryContainer.Builder)((LootPoolEntryContainer.Builder)builder2), null, (int)2, null);
        return Unit.INSTANCE;
    }

    private static final void VOID_BLOOM$lambda$0$3(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.material(TBSBlocks::VOID_BLOOM$lambda$0$3$0);
    }

    private static final Unit VOID_BLOOM$lambda$0$3$0(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.flower();
        $this$material.smallFlower();
        return Unit.INSTANCE;
    }

    private static final void VOID_BLOSSOM$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::VOID_BLOSSOM$lambda$0$0);
        $this$block.model(TBSBlocks::VOID_BLOSSOM$lambda$0$1);
        $this$block.simpleItem();
        $this$block.loot(TBSBlocks::VOID_BLOSSOM$lambda$0$2);
        $this$block.tags(TBSBlocks::VOID_BLOSSOM$lambda$0$3);
        $this$block.lang = "Perfection";
    }

    private static final void VOID_BLOSSOM$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GRASS);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 6);
        PropertiesExt.INSTANCE.emissive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_BLOSSOM$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        BlockStateProvider.directionalBlock$default((BlockStateProvider)((BlockStateProvider)$this$model), (Block)$this$model.getBlock(), (ModelFile)((ModelFile)$this$model.models().getExistingFile(TBSConstants.id("block/void_blossom"))), (int)0, (int)4, null);
    }

    private static final Unit VOID_BLOSSOM$lambda$0$2(LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"itemEntry");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"blockEntry");
        LootBuildersKt.pool((LootTable.Builder)$this$loot, arg_0 -> TBSBlocks.VOID_BLOSSOM$lambda$0$2$0(itemEntry, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit VOID_BLOSSOM$lambda$0$2$0(ItemEntry $itemEntry, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls((LootPool.Builder)$this$pool, (float)1.0f);
        LootItemCondition.Builder builder = MatchTool.toolMatches((ItemPredicate.Builder)ItemPredicate.Builder.item().of(TBSTags.CAN_BE_USED_FOR_VOID_FLORA));
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"toolMatches(...)");
        LootBuildersKt.condition$default((LootPool.Builder)$this$pool, (LootItemCondition.Builder)builder, null, (int)2, null);
        LootPoolSingletonContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$itemEntry.get()));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"lootTableItem(...)");
        LootBuildersKt.entry$default((LootPool.Builder)$this$pool, (LootPoolEntryContainer.Builder)((LootPoolEntryContainer.Builder)builder2), null, (int)2, null);
        return Unit.INSTANCE;
    }

    private static final void VOID_BLOSSOM$lambda$0$3(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.material(TBSBlocks::VOID_BLOSSOM$lambda$0$3$0);
    }

    private static final Unit VOID_BLOSSOM$lambda$0$3$0(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.flower();
        $this$material.smallFlower();
        return Unit.INSTANCE;
    }

    private static final void VOID_VINE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Tangled Vines";
        $this$block.props(TBSBlocks::VOID_VINE$lambda$0$0);
        $this$block.model(TBSBlocks::VOID_VINE$lambda$0$1);
        $this$block.loot(TBSBlocks::VOID_VINE$lambda$0$2);
        $this$block.tags(TBSBlocks::VOID_VINE$lambda$0$3);
        $this$block.item(arg_0 -> TBSBlocks.VOID_VINE$lambda$0$4($this$block, arg_0));
    }

    private static final void VOID_VINE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.VINE);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noOcclusion();
        $this$props.randomTicks();
        $this$props.strength(0.2f);
    }

    private static final void VOID_VINE$lambda$0$1(BCBlockStateProvider $this$model) {
        MultiPartBlockStateBuilder multiPartBlockStateBuilder;
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        ModelFile.ExistingModelFile model2 = $this$model.models().getExistingFile(TBSConstants.id("block/void_vine"));
        MultiPartBlockStateBuilder $this$VOID_VINE_u24lambda_u240_u241_u240 = multiPartBlockStateBuilder = $this$model.getMultipartBuilder($this$model.getBlock());
        boolean bl = false;
        MultiPartBlockStateBuilder.PartBuilder partBuilder = (MultiPartBlockStateBuilder.PartBuilder)$this$VOID_VINE_u24lambda_u240_u241_u240.part().modelFile((ModelFile)model2).addModel();
        BooleanProperty booleanProperty = VineBlock.NORTH;
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty, (String)"NORTH");
        Boolean[] booleanArray = new Boolean[]{true};
        partBuilder.condition((Property)booleanProperty, (Comparable[])booleanArray);
        MultiPartBlockStateBuilder.PartBuilder partBuilder2 = (MultiPartBlockStateBuilder.PartBuilder)$this$VOID_VINE_u24lambda_u240_u241_u240.part().modelFile((ModelFile)model2).rotationY(90).addModel();
        BooleanProperty booleanProperty2 = VineBlock.EAST;
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty2, (String)"EAST");
        booleanArray = new Boolean[]{true};
        partBuilder2.condition((Property)booleanProperty2, (Comparable[])booleanArray);
        MultiPartBlockStateBuilder.PartBuilder partBuilder3 = (MultiPartBlockStateBuilder.PartBuilder)$this$VOID_VINE_u24lambda_u240_u241_u240.part().modelFile((ModelFile)model2).rotationY(180).addModel();
        BooleanProperty booleanProperty3 = VineBlock.SOUTH;
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty3, (String)"SOUTH");
        booleanArray = new Boolean[]{true};
        partBuilder3.condition((Property)booleanProperty3, (Comparable[])booleanArray);
        MultiPartBlockStateBuilder.PartBuilder partBuilder4 = (MultiPartBlockStateBuilder.PartBuilder)$this$VOID_VINE_u24lambda_u240_u241_u240.part().modelFile((ModelFile)model2).rotationY(270).addModel();
        BooleanProperty booleanProperty4 = VineBlock.WEST;
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty4, (String)"WEST");
        booleanArray = new Boolean[]{true};
        partBuilder4.condition((Property)booleanProperty4, (Comparable[])booleanArray);
        MultiPartBlockStateBuilder.PartBuilder partBuilder5 = (MultiPartBlockStateBuilder.PartBuilder)$this$VOID_VINE_u24lambda_u240_u241_u240.part().modelFile((ModelFile)model2).rotationX(270).addModel();
        BooleanProperty booleanProperty5 = VineBlock.UP;
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty5, (String)"UP");
        booleanArray = new Boolean[]{true};
        partBuilder5.condition((Property)booleanProperty5, (Comparable[])booleanArray);
    }

    private static final Unit VOID_VINE$lambda$0$2(LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"itemEntry");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"blockEntry");
        LootBuildersKt.pool((LootTable.Builder)$this$loot, arg_0 -> TBSBlocks.VOID_VINE$lambda$0$2$0(itemEntry, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit VOID_VINE$lambda$0$2$0(ItemEntry $itemEntry, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls((LootPool.Builder)$this$pool, (float)1.0f);
        LootItemCondition.Builder builder = MatchTool.toolMatches((ItemPredicate.Builder)ItemPredicate.Builder.item().of(TBSTags.CAN_BE_USED_FOR_VOID_FLORA));
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"toolMatches(...)");
        LootBuildersKt.condition$default((LootPool.Builder)$this$pool, (LootItemCondition.Builder)builder, null, (int)2, null);
        LootPoolSingletonContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$itemEntry.get()));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"lootTableItem(...)");
        LootBuildersKt.entry$default((LootPool.Builder)$this$pool, (LootPoolEntryContainer.Builder)((LootPoolEntryContainer.Builder)builder2), null, (int)2, null);
        return Unit.INSTANCE;
    }

    private static final void VOID_VINE$lambda$0$3(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.functional(TBSBlocks::VOID_VINE$lambda$0$3$0);
    }

    private static final Unit VOID_VINE$lambda$0$3$0(BlockTagsBuilder.FunctionalTagBuilder $this$functional) {
        Intrinsics.checkNotNullParameter((Object)$this$functional, (String)"$this$functional");
        $this$functional.climbable();
        return Unit.INSTANCE;
    }

    private static final void VOID_VINE$lambda$0$4(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::VOID_VINE$lambda$0$4$0);
    }

    private static final void VOID_VINE$lambda$0$4$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated").texture("layer0", TBSConstants.id("block/void_vine"));
    }

    private static final VoidFlora VOID_SHROOM$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        return new VoidFlora(props, SHROOMY_BOX);
    }

    private static final void VOID_SHROOM$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Sliver of Pride";
        $this$block.props(TBSBlocks::VOID_SHROOM$lambda$1$0);
        $this$block.simpleLoot();
        $this$block.simpleItem();
        $this$block.model(TBSBlocks::VOID_SHROOM$lambda$1$1);
        $this$block.item(arg_0 -> TBSBlocks.VOID_SHROOM$lambda$1$2($this$block, arg_0));
    }

    private static final void VOID_SHROOM$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.CROP);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_SHROOM$lambda$1$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"block/void_shroom");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        $this$model.crossBlock(block, resourceLocation);
    }

    private static final void VOID_SHROOM$lambda$1$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::VOID_SHROOM$lambda$1$2$0);
    }

    private static final void VOID_SHROOM$lambda$1$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated").texture("layer0", TBSConstants.id("block/void_shroom"));
    }

    private static final VoidFlora VOID_CAP$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        return new VoidFlora(props, SHROOMY_BOX);
    }

    private static final void VOID_CAP$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Shameful Remorse";
        $this$block.props(TBSBlocks::VOID_CAP$lambda$1$0);
        $this$block.simpleLoot();
        $this$block.model(TBSBlocks::VOID_CAP$lambda$1$1);
        $this$block.item(arg_0 -> TBSBlocks.VOID_CAP$lambda$1$2($this$block, arg_0));
    }

    private static final void VOID_CAP$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.CROP);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_CAP$lambda$1$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"block/void_cap");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        $this$model.crossBlock(block, resourceLocation);
    }

    private static final void VOID_CAP$lambda$1$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::VOID_CAP$lambda$1$2$0);
    }

    private static final void VOID_CAP$lambda$1$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated").texture("layer0", TBSConstants.id("block/void_cap"));
    }

    private static final VoidFlora VOID_BELL$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        return new VoidFlora(props, SKINNY_SHROOMY_BOX);
    }

    private static final void VOID_BELL$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Validated Subjugation";
        $this$block.props(TBSBlocks::VOID_BELL$lambda$1$0);
        $this$block.simpleLoot();
        $this$block.model(TBSBlocks::VOID_BELL$lambda$1$1);
        $this$block.item(arg_0 -> TBSBlocks.VOID_BELL$lambda$1$2($this$block, arg_0));
    }

    private static final void VOID_BELL$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.CROP);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_BELL$lambda$1$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"block/void_bell");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        $this$model.crossBlock(block, resourceLocation);
    }

    private static final void VOID_BELL$lambda$1$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::VOID_BELL$lambda$1$2$0);
    }

    private static final void VOID_BELL$lambda$1$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated").texture("layer0", TBSConstants.id("block/void_bell"));
    }

    private static final VoidFlora LILY_OF_THE_ABYSS$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        return new VoidFlora(props, SHROOMY_BOX);
    }

    private static final void LILY_OF_THE_ABYSS$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::LILY_OF_THE_ABYSS$lambda$1$0);
        $this$block.simpleLoot();
        $this$block.model(TBSBlocks::LILY_OF_THE_ABYSS$lambda$1$1);
        $this$block.tags(TBSBlocks::LILY_OF_THE_ABYSS$lambda$1$2);
        $this$block.item(arg_0 -> TBSBlocks.LILY_OF_THE_ABYSS$lambda$1$3($this$block, arg_0));
    }

    private static final void LILY_OF_THE_ABYSS$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.CROP);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void LILY_OF_THE_ABYSS$lambda$1$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"block/lily_of_the_abyss");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        $this$model.crossBlock(block, resourceLocation);
    }

    private static final void LILY_OF_THE_ABYSS$lambda$1$2(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.material(TBSBlocks::LILY_OF_THE_ABYSS$lambda$1$2$0);
    }

    private static final Unit LILY_OF_THE_ABYSS$lambda$1$2$0(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.flower();
        $this$material.smallFlower();
        return Unit.INSTANCE;
    }

    private static final void LILY_OF_THE_ABYSS$lambda$1$3(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::LILY_OF_THE_ABYSS$lambda$1$3$0);
    }

    private static final void LILY_OF_THE_ABYSS$lambda$1$3$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated").texture("layer0", TBSConstants.id("block/lily_of_the_abyss"));
    }

    private static final POTTED_VOID_SHROOM.1.1 POTTED_VOID_SHROOM$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        VoidFlora voidFlora = (VoidFlora)((Object)VOID_SHROOM.get());
        return new FlowerPotBlock(props, voidFlora){

            public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool) {
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                Intrinsics.checkNotNullParameter((Object)tool, (String)"tool");
                ItemEntity pot = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.35, (double)pos.getZ() + 0.5, new ItemStack((ItemLike)Blocks.FLOWER_POT));
                ItemEntity flora = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.35, (double)pos.getZ() + 0.5, new ItemStack((ItemLike)TBSBlocks.VOID_SHROOM.get()));
                level.addFreshEntity((Entity)pot);
                level.addFreshEntity((Entity)flora);
            }
        };
    }

    private static final void POTTED_VOID_SHROOM$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.model(TBSBlocks::POTTED_VOID_SHROOM$lambda$1$0);
        $this$block.tags(TBSBlocks::POTTED_VOID_SHROOM$lambda$1$1);
        $this$block.noLoot();
    }

    private static final void POTTED_VOID_SHROOM$lambda$1$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"block/void_shroom");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        $this$model.pottedFlowerBlock(block, resourceLocation);
    }

    private static final void POTTED_VOID_SHROOM$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.interactable(TBSBlocks::POTTED_VOID_SHROOM$lambda$1$1$0);
    }

    private static final Unit POTTED_VOID_SHROOM$lambda$1$1$0(BlockTagsBuilder.InteractableBlockTagBuilder $this$interactable) {
        Intrinsics.checkNotNullParameter((Object)$this$interactable, (String)"$this$interactable");
        $this$interactable.flowerPot();
        return Unit.INSTANCE;
    }

    private static final POTTED_VOID_CAP.1.1 POTTED_VOID_CAP$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        VoidFlora voidFlora = (VoidFlora)((Object)VOID_CAP.get());
        return new FlowerPotBlock(props, voidFlora){

            public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool) {
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                Intrinsics.checkNotNullParameter((Object)tool, (String)"tool");
                ItemEntity pot = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.35, (double)pos.getZ() + 0.5, new ItemStack((ItemLike)Blocks.FLOWER_POT));
                ItemEntity flora = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.35, (double)pos.getZ() + 0.5, new ItemStack((ItemLike)TBSBlocks.VOID_CAP.get()));
                level.addFreshEntity((Entity)pot);
                level.addFreshEntity((Entity)flora);
            }
        };
    }

    private static final void POTTED_VOID_CAP$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.model(TBSBlocks::POTTED_VOID_CAP$lambda$1$0);
        $this$block.tags(TBSBlocks::POTTED_VOID_CAP$lambda$1$1);
        $this$block.noLoot();
    }

    private static final void POTTED_VOID_CAP$lambda$1$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"block/void_cap");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        $this$model.pottedFlowerBlock(block, resourceLocation);
    }

    private static final void POTTED_VOID_CAP$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.interactable(TBSBlocks::POTTED_VOID_CAP$lambda$1$1$0);
    }

    private static final Unit POTTED_VOID_CAP$lambda$1$1$0(BlockTagsBuilder.InteractableBlockTagBuilder $this$interactable) {
        Intrinsics.checkNotNullParameter((Object)$this$interactable, (String)"$this$interactable");
        $this$interactable.flowerPot();
        return Unit.INSTANCE;
    }

    private static final POTTED_VOID_BELL.1.1 POTTED_VOID_BELL$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        VoidFlora voidFlora = (VoidFlora)((Object)VOID_BELL.get());
        return new FlowerPotBlock(props, voidFlora){

            public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool) {
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                Intrinsics.checkNotNullParameter((Object)tool, (String)"tool");
                ItemEntity pot = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.35, (double)pos.getZ() + 0.5, new ItemStack((ItemLike)Blocks.FLOWER_POT));
                ItemEntity flora = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.35, (double)pos.getZ() + 0.5, new ItemStack((ItemLike)TBSBlocks.VOID_BELL.get()));
                level.addFreshEntity((Entity)pot);
                level.addFreshEntity((Entity)flora);
            }
        };
    }

    private static final void POTTED_VOID_BELL$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.model(TBSBlocks::POTTED_VOID_BELL$lambda$1$0);
        $this$block.tags(TBSBlocks::POTTED_VOID_BELL$lambda$1$1);
        $this$block.noLoot();
    }

    private static final void POTTED_VOID_BELL$lambda$1$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"block/void_bell");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        $this$model.pottedFlowerBlock(block, resourceLocation);
    }

    private static final void POTTED_VOID_BELL$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.interactable(TBSBlocks::POTTED_VOID_BELL$lambda$1$1$0);
    }

    private static final Unit POTTED_VOID_BELL$lambda$1$1$0(BlockTagsBuilder.InteractableBlockTagBuilder $this$interactable) {
        Intrinsics.checkNotNullParameter((Object)$this$interactable, (String)"$this$interactable");
        $this$interactable.flowerPot();
        return Unit.INSTANCE;
    }

    private static final POTTED_LILY_OF_THE_ABYSS.1.1 POTTED_LILY_OF_THE_ABYSS$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        VoidFlora voidFlora = (VoidFlora)((Object)LILY_OF_THE_ABYSS.get());
        return new FlowerPotBlock(props, voidFlora){

            public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool) {
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)player, (String)"player");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                Intrinsics.checkNotNullParameter((Object)tool, (String)"tool");
                ItemEntity pot = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.35, (double)pos.getZ() + 0.5, new ItemStack((ItemLike)Blocks.FLOWER_POT));
                ItemEntity flora = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.35, (double)pos.getZ() + 0.5, new ItemStack((ItemLike)TBSBlocks.LILY_OF_THE_ABYSS.get()));
                level.addFreshEntity((Entity)pot);
                level.addFreshEntity((Entity)flora);
            }
        };
    }

    private static final void POTTED_LILY_OF_THE_ABYSS$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.model(TBSBlocks::POTTED_LILY_OF_THE_ABYSS$lambda$1$0);
        $this$block.tags(TBSBlocks::POTTED_LILY_OF_THE_ABYSS$lambda$1$1);
        $this$block.noLoot();
    }

    private static final void POTTED_LILY_OF_THE_ABYSS$lambda$1$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"block/lily_of_the_abyss");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        $this$model.pottedFlowerBlock(block, resourceLocation);
    }

    private static final void POTTED_LILY_OF_THE_ABYSS$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.interactable(TBSBlocks::POTTED_LILY_OF_THE_ABYSS$lambda$1$1$0);
    }

    private static final Unit POTTED_LILY_OF_THE_ABYSS$lambda$1$1$0(BlockTagsBuilder.InteractableBlockTagBuilder $this$interactable) {
        Intrinsics.checkNotNullParameter((Object)$this$interactable, (String)"$this$interactable");
        $this$interactable.flowerPot();
        return Unit.INSTANCE;
    }

    private static final void TEETH$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::TEETH$lambda$0$0);
        $this$block.model(TBSBlocks::TEETH$lambda$0$1);
        $this$block.simpleItem();
    }

    private static final void TEETH$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        PropertiesExt.INSTANCE.indestructible($this$props);
        $this$props.requiresCorrectToolForDrops();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        PropertiesExt.INSTANCE.postProcess($this$props);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void TEETH$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.axisBlock((RotatedPillarBlock)$this$model.getBlock(), TBSConstants.id("block/teeth"), TBSConstants.id("block/teeth_end"));
    }

    private static final void VOID_LOG$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Chitin";
        $this$block.props(TBSBlocks::VOID_LOG$lambda$0$0);
        $this$block.tags(TBSBlocks::VOID_LOG$lambda$0$1);
        $this$block.model(TBSBlocks::VOID_LOG$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void VOID_LOG$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_LOG$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_LOG$lambda$0$1$0);
        $this$tags.material(TBSBlocks::VOID_LOG$lambda$0$1$1);
    }

    private static final Unit VOID_LOG$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit VOID_LOG$lambda$0$1$1(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.log(TBSBlocks::VOID_LOG$lambda$0$1$1$0);
        return Unit.INSTANCE;
    }

    private static final Unit VOID_LOG$lambda$0$1$1$0(BlockTagsBuilder.MaterialTagsBuilder.LogBuilder $this$log) {
        Intrinsics.checkNotNullParameter((Object)$this$log, (String)"$this$log");
        return Unit.INSTANCE;
    }

    private static final void VOID_LOG$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.axisBlock((RotatedPillarBlock)$this$model.getBlock(), TBSConstants.id("block/void_log_side"), TBSConstants.id("block/void_log_top"));
    }

    private static final void VOID_WOOD$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Compacted Chitin";
        $this$block.props(TBSBlocks::VOID_WOOD$lambda$0$0);
        $this$block.tags(TBSBlocks::VOID_WOOD$lambda$0$1);
        $this$block.model(TBSBlocks::VOID_WOOD$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void VOID_WOOD$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_WOOD$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_WOOD$lambda$0$1$0);
        $this$tags.material(TBSBlocks::VOID_WOOD$lambda$0$1$1);
    }

    private static final Unit VOID_WOOD$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit VOID_WOOD$lambda$0$1$1(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.log(TBSBlocks::VOID_WOOD$lambda$0$1$1$0);
        return Unit.INSTANCE;
    }

    private static final Unit VOID_WOOD$lambda$0$1$1$0(BlockTagsBuilder.MaterialTagsBuilder.LogBuilder $this$log) {
        Intrinsics.checkNotNullParameter((Object)$this$log, (String)"$this$log");
        return Unit.INSTANCE;
    }

    private static final void VOID_WOOD$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("void_log_side"), (int)1, null));
    }

    private static final void VOID_PLANKS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Chitinous Planks";
        $this$block.props(TBSBlocks::VOID_PLANKS$lambda$0$0);
        $this$block.tags(TBSBlocks::VOID_PLANKS$lambda$0$1);
        $this$block.model(TBSBlocks::VOID_PLANKS$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void VOID_PLANKS$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_PLANKS$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_PLANKS$lambda$0$1$0);
        $this$tags.material(TBSBlocks::VOID_PLANKS$lambda$0$1$1);
    }

    private static final Unit VOID_PLANKS$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit VOID_PLANKS$lambda$0$1$1(BlockTagsBuilder.MaterialTagsBuilder $this$material) {
        Intrinsics.checkNotNullParameter((Object)$this$material, (String)"$this$material");
        $this$material.planks();
        return Unit.INSTANCE;
    }

    private static final void VOID_PLANKS$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("void_planks"), (int)1, null));
    }

    private static final void VOID_PLANK_SLAB$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Chitinous Plank Slab";
        $this$block.props(TBSBlocks::VOID_PLANK_SLAB$lambda$0$0);
        $this$block.model(TBSBlocks::VOID_PLANK_SLAB$lambda$0$1);
        $this$block.tags(TBSBlocks::VOID_PLANK_SLAB$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void VOID_PLANK_SLAB$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_PLANK_SLAB$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.slabBlock((SlabBlock)$this$model.getBlock(), TBSConstants.id("block/void_planks"));
    }

    private static final void VOID_PLANK_SLAB$lambda$0$2(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_PLANK_SLAB$lambda$0$2$0);
        $this$tags.partialBlock(TBSBlocks::VOID_PLANK_SLAB$lambda$0$2$1);
    }

    private static final Unit VOID_PLANK_SLAB$lambda$0$2$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit VOID_PLANK_SLAB$lambda$0$2$1(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.woodenSlab();
        return Unit.INSTANCE;
    }

    private static final void INITIATOR$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::INITIATOR$lambda$0$0);
        $this$block.model(TBSBlocks::INITIATOR$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
        $this$block.lang = "Initiator";
    }

    private static final void INITIATOR$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void INITIATOR$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("bacon"), (int)1, null));
    }

    private static final VOID_PLANK_STAIRS.1.1 VOID_PLANK_STAIRS$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        BlockState blockState = ((Block)VOID_PLANKS.get()).defaultBlockState();
        return new StairBlock(props, blockState){};
    }

    private static final void VOID_PLANK_STAIRS$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Chitinous Plank Stairs";
        $this$block.props(TBSBlocks::VOID_PLANK_STAIRS$lambda$1$0);
        $this$block.tags(TBSBlocks::VOID_PLANK_STAIRS$lambda$1$1);
        $this$block.model(TBSBlocks::VOID_PLANK_STAIRS$lambda$1$2);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void VOID_PLANK_STAIRS$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_PLANK_STAIRS$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_PLANK_STAIRS$lambda$1$1$0);
        $this$tags.partialBlock(TBSBlocks::VOID_PLANK_STAIRS$lambda$1$1$1);
    }

    private static final Unit VOID_PLANK_STAIRS$lambda$1$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit VOID_PLANK_STAIRS$lambda$1$1$1(BlockTagsBuilder.PartialBlockTagBuilder $this$partialBlock) {
        Intrinsics.checkNotNullParameter((Object)$this$partialBlock, (String)"$this$partialBlock");
        $this$partialBlock.woodenStairs();
        return Unit.INSTANCE;
    }

    private static final void VOID_PLANK_STAIRS$lambda$1$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.stairsBlock((StairBlock)$this$model.getBlock(), TBSConstants.id("block/void_planks"));
    }

    private static final VOID_PLANK_DOOR.1.1 VOID_PLANK_DOOR$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        BlockSetType blockSetType = BlockSetType.OAK;
        return new DoorBlock(props, blockSetType){};
    }

    private static final void VOID_PLANK_DOOR$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Compacted Chitinous Door";
        $this$block.props(TBSBlocks::VOID_PLANK_DOOR$lambda$1$0);
        $this$block.tags(TBSBlocks::VOID_PLANK_DOOR$lambda$1$1);
        $this$block.model(TBSBlocks::VOID_PLANK_DOOR$lambda$1$2);
        $this$block.item(TBSBlocks::VOID_PLANK_DOOR$lambda$1$3);
        $this$block.doorLoot();
    }

    private static final void VOID_PLANK_DOOR$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_PLANK_DOOR$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_PLANK_DOOR$lambda$1$1$0);
        $this$tags.interactable(TBSBlocks::VOID_PLANK_DOOR$lambda$1$1$1);
    }

    private static final Unit VOID_PLANK_DOOR$lambda$1$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit VOID_PLANK_DOOR$lambda$1$1$1(BlockTagsBuilder.InteractableBlockTagBuilder $this$interactable) {
        Intrinsics.checkNotNullParameter((Object)$this$interactable, (String)"$this$interactable");
        $this$interactable.woodenDoor();
        $this$interactable.door();
        return Unit.INSTANCE;
    }

    private static final void VOID_PLANK_DOOR$lambda$1$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.doorBlockWithRenderType((DoorBlock)$this$model.getBlock(), $this$model.blockTexture("void_plank_door_bottom"), $this$model.blockTexture("void_plank_door_top"), "cutout");
    }

    private static final void VOID_PLANK_DOOR$lambda$1$3(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::VOID_PLANK_DOOR$lambda$1$3$0);
    }

    private static final void VOID_PLANK_DOOR$lambda$1$3$0(BCBlockItemModelProvider $this$model) {
        ItemModelBuilder itemModelBuilder;
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        ItemModelBuilder $this$VOID_PLANK_DOOR_u24lambda_u241_u243_u240_u240 = itemModelBuilder = $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated");
        boolean bl = false;
        $this$VOID_PLANK_DOOR_u24lambda_u241_u243_u240_u240.texture("layer0", $this$model.modLoc("block/void_plank_door"));
        $this$VOID_PLANK_DOOR_u24lambda_u241_u243_u240_u240.renderType("cutout");
    }

    private static final VOID_LOG_DOOR.1.1 VOID_LOG_DOOR$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        BlockSetType blockSetType = BlockSetType.OAK;
        return new DoorBlock(props, blockSetType){};
    }

    private static final void VOID_LOG_DOOR$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Chitinous Door";
        $this$block.props(TBSBlocks::VOID_LOG_DOOR$lambda$1$0);
        $this$block.tags(TBSBlocks::VOID_LOG_DOOR$lambda$1$1);
        $this$block.model(TBSBlocks::VOID_LOG_DOOR$lambda$1$2);
        $this$block.item(TBSBlocks::VOID_LOG_DOOR$lambda$1$3);
        $this$block.doorLoot();
    }

    private static final void VOID_LOG_DOOR$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_LOG_DOOR$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_LOG_DOOR$lambda$1$1$0);
        $this$tags.interactable(TBSBlocks::VOID_LOG_DOOR$lambda$1$1$1);
    }

    private static final Unit VOID_LOG_DOOR$lambda$1$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit VOID_LOG_DOOR$lambda$1$1$1(BlockTagsBuilder.InteractableBlockTagBuilder $this$interactable) {
        Intrinsics.checkNotNullParameter((Object)$this$interactable, (String)"$this$interactable");
        $this$interactable.woodenDoor();
        $this$interactable.door();
        return Unit.INSTANCE;
    }

    private static final void VOID_LOG_DOOR$lambda$1$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.doorBlockWithRenderType((DoorBlock)$this$model.getBlock(), $this$model.blockTexture("void_log_door_bottom"), $this$model.blockTexture("void_log_door_top"), "cutout");
    }

    private static final void VOID_LOG_DOOR$lambda$1$3(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::VOID_LOG_DOOR$lambda$1$3$0);
    }

    private static final void VOID_LOG_DOOR$lambda$1$3$0(BCBlockItemModelProvider $this$model) {
        ItemModelBuilder itemModelBuilder;
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        ItemModelBuilder $this$VOID_LOG_DOOR_u24lambda_u241_u243_u240_u240 = itemModelBuilder = $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated");
        boolean bl = false;
        $this$VOID_LOG_DOOR_u24lambda_u241_u243_u240_u240.texture("layer0", $this$model.modLoc("block/void_log_door"));
        $this$VOID_LOG_DOOR_u24lambda_u241_u243_u240_u240.renderType("cutout");
    }

    private static final VOID_WOOD_TRAPDOOR.1.1 VOID_WOOD_TRAPDOOR$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        BlockSetType blockSetType = BlockSetType.OAK;
        return new TrapDoorBlock(props, blockSetType){};
    }

    private static final void VOID_WOOD_TRAPDOOR$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Chitinous Trapdoor";
        $this$block.props(TBSBlocks::VOID_WOOD_TRAPDOOR$lambda$1$0);
        $this$block.tags(TBSBlocks::VOID_WOOD_TRAPDOOR$lambda$1$1);
        $this$block.model(TBSBlocks::VOID_WOOD_TRAPDOOR$lambda$1$2);
        $this$block.item(TBSBlocks::VOID_WOOD_TRAPDOOR$lambda$1$3);
        $this$block.simpleLoot();
    }

    private static final void VOID_WOOD_TRAPDOOR$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_WOOD_TRAPDOOR$lambda$1$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_WOOD_TRAPDOOR$lambda$1$1$0);
        $this$tags.interactable(TBSBlocks::VOID_WOOD_TRAPDOOR$lambda$1$1$1);
    }

    private static final Unit VOID_WOOD_TRAPDOOR$lambda$1$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final Unit VOID_WOOD_TRAPDOOR$lambda$1$1$1(BlockTagsBuilder.InteractableBlockTagBuilder $this$interactable) {
        Intrinsics.checkNotNullParameter((Object)$this$interactable, (String)"$this$interactable");
        $this$interactable.woodenTrapdoor();
        $this$interactable.trapdoor();
        return Unit.INSTANCE;
    }

    private static final void VOID_WOOD_TRAPDOOR$lambda$1$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.trapdoorBlockWithRenderType((TrapDoorBlock)$this$model.getBlock(), TBSConstants.id("block/void_wood_trapdoor"), true, "cutout");
    }

    private static final void VOID_WOOD_TRAPDOOR$lambda$1$3(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.model(TBSBlocks::VOID_WOOD_TRAPDOOR$lambda$1$3$0);
    }

    private static final void VOID_WOOD_TRAPDOOR$lambda$1$3$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.withExistingParent((Item)$this$model.getItem(), "thebrokenscript:block/void_wood_trapdoor_bottom");
    }

    private static final void VOID_ROOTS$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Dense Mycelial Webbing";
        $this$block.props(TBSBlocks::VOID_ROOTS$lambda$0$0);
        $this$block.tags(TBSBlocks::VOID_ROOTS$lambda$0$1);
        $this$block.model(TBSBlocks::VOID_ROOTS$lambda$0$2);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void VOID_ROOTS$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_ROOTS$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_ROOTS$lambda$0$1$0);
    }

    private static final Unit VOID_ROOTS$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final void VOID_ROOTS$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("void_roots"), (int)1, null)).renderType("solid"));
    }

    private static final void VOID_ROOT$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Mycelial Webbing";
        $this$block.props(TBSBlocks::VOID_ROOT$lambda$0$0);
        $this$block.tags(TBSBlocks::VOID_ROOT$lambda$0$1);
        $this$block.model(TBSBlocks::VOID_ROOT$lambda$0$2);
        $this$block.noLoot();
        $this$block.simpleItem();
    }

    private static final void VOID_ROOT$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.NETHER_WOOD);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.strength(2.0f);
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 1);
    }

    private static final void VOID_ROOT$lambda$0$1(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.tool(TBSBlocks::VOID_ROOT$lambda$0$1$0);
    }

    private static final Unit VOID_ROOT$lambda$0$1$0(BlockTagsBuilder.ToolTagsBuilder $this$tool) {
        Intrinsics.checkNotNullParameter((Object)$this$tool, (String)"$this$tool");
        $this$tool.axe();
        return Unit.INSTANCE;
    }

    private static final void VOID_ROOT$lambda$0$2(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("void_root"), (int)1, null)).renderType("solid"));
    }

    private static final VOID_GRASS.1.1 VOID_GRASS$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        return new TallGrassBlock(props){

            public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                return false;
            }

            protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                Vec3 newPos = state.getOffset(level, pos);
                VoxelShape voxelShape = TBSBlocks.INSTANCE.getVOID_GRASS_BOX().move(newPos.x, newPos.y, newPos.z);
                Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"move(...)");
                return voxelShape;
            }

            protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                return !state.is(Blocks.AIR) && !state.is(Blocks.CAVE_AIR);
            }
        };
    }

    private static final void VOID_GRASS$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Arteries";
        $this$block.props(TBSBlocks::VOID_GRASS$lambda$1$0);
        $this$block.model(TBSBlocks::VOID_GRASS$lambda$1$1);
        $this$block.loot(TBSBlocks::VOID_GRASS$lambda$1$2);
        $this$block.tags(TBSBlocks::VOID_GRASS$lambda$1$3);
        $this$block.item(arg_0 -> TBSBlocks.VOID_GRASS$lambda$1$4($this$block, arg_0));
    }

    private static final void VOID_GRASS$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WET_GRASS);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noCollission();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_GRASS$lambda$1$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.crossBlock($this$model.getBlock(), TBSConstants.id("block/void_grass"));
    }

    private static final Unit VOID_GRASS$lambda$1$2(LootTable.Builder $this$loot, ItemEntry itemEntry, BlockEntry blockEntry) {
        Intrinsics.checkNotNullParameter((Object)$this$loot, (String)"$this$loot");
        Intrinsics.checkNotNullParameter((Object)itemEntry, (String)"itemEntry");
        Intrinsics.checkNotNullParameter((Object)blockEntry, (String)"blockEntry");
        LootBuildersKt.pool((LootTable.Builder)$this$loot, arg_0 -> TBSBlocks.VOID_GRASS$lambda$1$2$0(itemEntry, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit VOID_GRASS$lambda$1$2$0(ItemEntry $itemEntry, LootPool.Builder $this$pool) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"$this$pool");
        LootBuildersKt.setRolls((LootPool.Builder)$this$pool, (float)1.0f);
        LootItemCondition.Builder builder = MatchTool.toolMatches((ItemPredicate.Builder)ItemPredicate.Builder.item().of(TBSTags.CAN_BE_USED_FOR_VOID_FLORA));
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"toolMatches(...)");
        LootBuildersKt.condition$default((LootPool.Builder)$this$pool, (LootItemCondition.Builder)builder, null, (int)2, null);
        LootPoolSingletonContainer.Builder builder2 = LootItem.lootTableItem((ItemLike)((ItemLike)$itemEntry.get()));
        Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"lootTableItem(...)");
        LootBuildersKt.entry$default((LootPool.Builder)$this$pool, (LootPoolEntryContainer.Builder)((LootPoolEntryContainer.Builder)builder2), null, (int)2, null);
        return Unit.INSTANCE;
    }

    private static final void VOID_GRASS$lambda$1$3(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.functional(TBSBlocks::VOID_GRASS$lambda$1$3$0);
    }

    private static final Unit VOID_GRASS$lambda$1$3$0(BlockTagsBuilder.FunctionalTagBuilder $this$functional) {
        Intrinsics.checkNotNullParameter((Object)$this$functional, (String)"$this$functional");
        $this$functional.replaceable();
        return Unit.INSTANCE;
    }

    private static final void VOID_GRASS$lambda$1$4(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::VOID_GRASS$lambda$1$4$0);
    }

    private static final void VOID_GRASS$lambda$1$4$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated").texture("layer0", TBSConstants.id("block/void_grass"));
    }

    private static final VoidFlora VOID_BUSH$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        return new VoidFlora(props, SHROOMY_BOX);
    }

    private static final void VOID_BUSH$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Aortic Growth";
        $this$block.props(TBSBlocks::VOID_BUSH$lambda$1$0);
        $this$block.noLoot();
        $this$block.model(TBSBlocks::VOID_BUSH$lambda$1$1);
        $this$block.tags(TBSBlocks::VOID_BUSH$lambda$1$2);
        $this$block.item(arg_0 -> TBSBlocks.VOID_BUSH$lambda$1$3($this$block, arg_0));
    }

    private static final void VOID_BUSH$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.CROP);
        $this$props.noCollission();
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noOcclusion();
        $this$props.instabreak();
        $this$props.offsetType(BlockBehaviour.OffsetType.XZ);
    }

    private static final void VOID_BUSH$lambda$1$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"block/void_bush");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        $this$model.crossBlock(block, resourceLocation);
    }

    private static final void VOID_BUSH$lambda$1$2(BlockTagsBuilder $this$tags) {
        Intrinsics.checkNotNullParameter((Object)$this$tags, (String)"$this$tags");
        $this$tags.functional(TBSBlocks::VOID_BUSH$lambda$1$2$0);
    }

    private static final Unit VOID_BUSH$lambda$1$2$0(BlockTagsBuilder.FunctionalTagBuilder $this$functional) {
        Intrinsics.checkNotNullParameter((Object)$this$functional, (String)"$this$functional");
        $this$functional.replaceable();
        return Unit.INSTANCE;
    }

    private static final void VOID_BUSH$lambda$1$3(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::VOID_BUSH$lambda$1$3$0);
    }

    private static final void VOID_BUSH$lambda$1$3$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.withExistingParent((Item)$this$model.getItem(), "item/generated").texture("layer0", TBSConstants.id("block/void_bush"));
    }

    private static final void FLOOR_BORDER_BLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::FLOOR_BORDER_BLOCK$lambda$0$0);
        $this$block.model(TBSBlocks::FLOOR_BORDER_BLOCK$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void FLOOR_BORDER_BLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WOOD);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void FLOOR_BORDER_BLOCK$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ModelProvider modelProvider = (ModelProvider)$this$model.models();
        Block block2 = Blocks.OAK_PLANKS;
        Intrinsics.checkNotNullExpressionValue((Object)block2, (String)"OAK_PLANKS");
        $this$model.simpleBlock(block, (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)modelProvider, null, (ResourceLocation)$this$model.blockTexture(block2), (int)1, null)).renderType("solid"));
    }

    private static final void DIRT_BORDER_BLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::DIRT_BORDER_BLOCK$lambda$0$0);
        $this$block.model(TBSBlocks::DIRT_BORDER_BLOCK$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void DIRT_BORDER_BLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GRAVEL);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void DIRT_BORDER_BLOCK$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ModelProvider modelProvider = (ModelProvider)$this$model.models();
        Block block2 = Blocks.DIRT;
        Intrinsics.checkNotNullExpressionValue((Object)block2, (String)"DIRT");
        $this$model.simpleBlock(block, (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)modelProvider, null, (ResourceLocation)$this$model.blockTexture(block2), (int)1, null)).renderType("solid"));
    }

    private static final GLASS_BORDER_BLOCK.1.1 GLASS_BORDER_BLOCK$lambda$0(BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        return new HalfTransparentBlock(props){};
    }

    private static final void GLASS_BORDER_BLOCK$lambda$1(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::GLASS_BORDER_BLOCK$lambda$1$0);
        $this$block.model(TBSBlocks::GLASS_BORDER_BLOCK$lambda$1$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void GLASS_BORDER_BLOCK$lambda$1$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        $this$props.noOcclusion();
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void GLASS_BORDER_BLOCK$lambda$1$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ModelProvider modelProvider = (ModelProvider)$this$model.models();
        Block block2 = Blocks.GLASS;
        Intrinsics.checkNotNullExpressionValue((Object)block2, (String)"GLASS");
        $this$model.simpleBlock(block, (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)modelProvider, null, (ResourceLocation)$this$model.blockTexture(block2), (int)1, null)).renderType(TBSConstants.id("window")));
    }

    private static final void COBBLESTONE_BORDER_BLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::COBBLESTONE_BORDER_BLOCK$lambda$0$0);
        $this$block.model(TBSBlocks::COBBLESTONE_BORDER_BLOCK$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void COBBLESTONE_BORDER_BLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void COBBLESTONE_BORDER_BLOCK$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ModelProvider modelProvider = (ModelProvider)$this$model.models();
        Block block2 = Blocks.COBBLESTONE;
        Intrinsics.checkNotNullExpressionValue((Object)block2, (String)"COBBLESTONE");
        $this$model.simpleBlock(block, (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)modelProvider, null, (ResourceLocation)$this$model.blockTexture(block2), (int)1, null)).renderType("solid"));
    }

    private static final void STONE_BORDER_BLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::STONE_BORDER_BLOCK$lambda$0$0);
        $this$block.model(TBSBlocks::STONE_BORDER_BLOCK$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void STONE_BORDER_BLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void STONE_BORDER_BLOCK$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ModelProvider modelProvider = (ModelProvider)$this$model.models();
        Block block2 = Blocks.STONE;
        Intrinsics.checkNotNullExpressionValue((Object)block2, (String)"STONE");
        $this$model.simpleBlock(block, (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)modelProvider, null, (ResourceLocation)$this$model.blockTexture(block2), (int)1, null)).renderType("solid"));
    }

    private static final void STONE_SLAB_BORDER_BLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::STONE_SLAB_BORDER_BLOCK$lambda$0$0);
        $this$block.model(TBSBlocks::STONE_SLAB_BORDER_BLOCK$lambda$0$1);
        $this$block.simpleLoot();
        $this$block.simpleItem();
    }

    private static final void STONE_SLAB_BORDER_BLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void STONE_SLAB_BORDER_BLOCK$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ModelProvider modelProvider = (ModelProvider)$this$model.models();
        Block block2 = Blocks.SMOOTH_STONE;
        Intrinsics.checkNotNullExpressionValue((Object)block2, (String)"SMOOTH_STONE");
        $this$model.simpleBlock(block, (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)modelProvider, null, (ResourceLocation)$this$model.blockTexture(block2), (int)1, null)).renderType("solid"));
    }

    private static final void MOIST_CARPET$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::MOIST_CARPET$lambda$0$0);
        $this$block.model(TBSBlocks::MOIST_CARPET$lambda$0$1);
        $this$block.item(TBSBlocks::MOIST_CARPET$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.lang = "Moist Carpet";
    }

    private static final void MOIST_CARPET$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WOOL);
        $this$props.strength(1.0f);
    }

    private static final void MOIST_CARPET$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("moist_carpet"), (int)1, null)).renderType("solid"));
    }

    private static final void MOIST_CARPET$lambda$0$2(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
        $this$item.model(TBSBlocks::MOIST_CARPET$lambda$0$2$0);
    }

    private static final void MOIST_CARPET$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void CEILING_LIGHT$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::CEILING_LIGHT$lambda$0$0);
        $this$block.model(TBSBlocks::CEILING_LIGHT$lambda$0$1);
        $this$block.item(TBSBlocks::CEILING_LIGHT$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.lang = "Ceiling Light";
    }

    private static final void CEILING_LIGHT$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        $this$props.strength(0.5f);
        $this$props.lightLevel(TBSBlocks::CEILING_LIGHT$lambda$0$0$0);
    }

    private static final int CEILING_LIGHT$lambda$0$0$0(BlockState it) {
        return 15;
    }

    private static final void CEILING_LIGHT$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("ceiling_light"), (int)1, null)).renderType("solid"));
    }

    private static final void CEILING_LIGHT$lambda$0$2(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
        $this$item.model(TBSBlocks::CEILING_LIGHT$lambda$0$2$0);
    }

    private static final void CEILING_LIGHT$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void CEILING_TILE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::CEILING_TILE$lambda$0$0);
        $this$block.model(TBSBlocks::CEILING_TILE$lambda$0$1);
        $this$block.item(TBSBlocks::CEILING_TILE$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.lang = "Ceiling Tile";
    }

    private static final void CEILING_TILE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WOOL);
        $this$props.strength(1.0f);
    }

    private static final void CEILING_TILE$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("ceiling_tile"), (int)1, null)).renderType("solid"));
    }

    private static final void CEILING_TILE$lambda$0$2(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
        $this$item.model(TBSBlocks::CEILING_TILE$lambda$0$2$0);
    }

    private static final void CEILING_TILE$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void UGLY_WALLPAPER$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::UGLY_WALLPAPER$lambda$0$0);
        $this$block.model(TBSBlocks::UGLY_WALLPAPER$lambda$0$1);
        $this$block.item(TBSBlocks::UGLY_WALLPAPER$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.lang = "Wallpaper";
    }

    private static final void UGLY_WALLPAPER$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WOOD);
        $this$props.strength(2.5f);
    }

    private static final void UGLY_WALLPAPER$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("ugly_wallpaper"), (int)1, null)).renderType("solid"));
    }

    private static final void UGLY_WALLPAPER$lambda$0$2(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
        $this$item.model(TBSBlocks::UGLY_WALLPAPER$lambda$0$2$0);
    }

    private static final void UGLY_WALLPAPER$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void RED_MOIST_CARPET$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::RED_MOIST_CARPET$lambda$0$0);
        $this$block.model(TBSBlocks::RED_MOIST_CARPET$lambda$0$1);
        $this$block.item(TBSBlocks::RED_MOIST_CARPET$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.lang = "Stained Carpet";
    }

    private static final void RED_MOIST_CARPET$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WOOL);
        $this$props.strength(1.0f);
    }

    private static final void RED_MOIST_CARPET$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("red_moist_carpet"), (int)1, null)).renderType("solid"));
    }

    private static final void RED_MOIST_CARPET$lambda$0$2(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
        $this$item.model(TBSBlocks::RED_MOIST_CARPET$lambda$0$2$0);
    }

    private static final void RED_MOIST_CARPET$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void RED_UGLY_WALLPAPER$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::RED_UGLY_WALLPAPER$lambda$0$0);
        $this$block.model(TBSBlocks::RED_UGLY_WALLPAPER$lambda$0$1);
        $this$block.item(TBSBlocks::RED_UGLY_WALLPAPER$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.lang = "Stained Wallpaper";
    }

    private static final void RED_UGLY_WALLPAPER$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WOOD);
        $this$props.strength(2.5f);
    }

    private static final void RED_UGLY_WALLPAPER$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("red_ugly_wallpaper"), (int)1, null)).renderType("solid"));
    }

    private static final void RED_UGLY_WALLPAPER$lambda$0$2(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
        $this$item.model(TBSBlocks::RED_UGLY_WALLPAPER$lambda$0$2$0);
    }

    private static final void RED_UGLY_WALLPAPER$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void RED_CEILING_TILE$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::RED_CEILING_TILE$lambda$0$0);
        $this$block.model(TBSBlocks::RED_CEILING_TILE$lambda$0$1);
        $this$block.item(TBSBlocks::RED_CEILING_TILE$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.lang = "Stained Ceiling Tile";
    }

    private static final void RED_CEILING_TILE$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WOOL);
        $this$props.strength(0.5f);
    }

    private static final void RED_CEILING_TILE$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("red_ceiling_tile"), (int)1, null)).renderType("solid"));
    }

    private static final void RED_CEILING_TILE$lambda$0$2(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
        $this$item.model(TBSBlocks::RED_CEILING_TILE$lambda$0$2$0);
    }

    private static final void RED_CEILING_TILE$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void RED_CEILING_LIGHT$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::RED_CEILING_LIGHT$lambda$0$0);
        $this$block.model(TBSBlocks::RED_CEILING_LIGHT$lambda$0$1);
        $this$block.item(TBSBlocks::RED_CEILING_LIGHT$lambda$0$2);
        $this$block.simpleLoot();
        $this$block.lang = "Stained Ceiling Light";
    }

    private static final void RED_CEILING_LIGHT$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.GLASS);
        $this$props.strength(0.5f);
        $this$props.lightLevel(TBSBlocks::RED_CEILING_LIGHT$lambda$0$0$0);
    }

    private static final int RED_CEILING_LIGHT$lambda$0$0$0(BlockState it) {
        return 15;
    }

    private static final void RED_CEILING_LIGHT$lambda$0$1(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("red_ceiling_light"), (int)1, null)).renderType("solid"));
    }

    private static final void RED_CEILING_LIGHT$lambda$0$2(BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
        $this$item.model(TBSBlocks::RED_CEILING_LIGHT$lambda$0$2$0);
    }

    private static final void RED_CEILING_LIGHT$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void CORRUPTED_COMMAND_BLOCK_GIVER$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.lang = "Corrupted Command Block Giver";
        $this$block.model(TBSBlocks::CORRUPTED_COMMAND_BLOCK_GIVER$lambda$0$0);
        $this$block.props(TBSBlocks::CORRUPTED_COMMAND_BLOCK_GIVER$lambda$0$1);
        $this$block.noLoot();
    }

    private static final void CORRUPTED_COMMAND_BLOCK_GIVER$lambda$0$0(BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)$this$model.blockTexture("command_block"), (int)1, null)).renderType("solid"));
    }

    private static final void CORRUPTED_COMMAND_BLOCK_GIVER$lambda$0$1(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.STONE);
        PropertiesExt.INSTANCE.indestructible($this$props);
        PropertiesExt.INSTANCE.light($this$props, 8);
    }

    private static final void jimTrigger$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::jimTrigger$lambda$0$0);
        $this$block.model(arg_0 -> TBSBlocks.jimTrigger$lambda$0$1($this$block, arg_0));
        $this$block.simpleLoot();
        $this$block.item(arg_0 -> TBSBlocks.jimTrigger$lambda$0$2($this$block, arg_0));
    }

    private static final void jimTrigger$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.EMPTY);
        PropertiesExt.INSTANCE.indestructible($this$props);
        PropertiesExt.INSTANCE.nonConductive($this$props);
        $this$props.noOcclusion();
    }

    private static final void jimTrigger$lambda$0$1(BlockBuilder $this_block, BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ModelProvider modelProvider = (ModelProvider)$this$model.models();
        String string = $this_block.getId().getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        $this$model.simpleBlock(block, (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)modelProvider, null, (ResourceLocation)$this$model.blockTexture(string), (int)1, null)).renderType("translucent"));
    }

    private static final void jimTrigger$lambda$0$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.noTab();
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::jimTrigger$lambda$0$2$0);
    }

    private static final void jimTrigger$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void templateBlock$lambda$0(String $real, BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::templateBlock$lambda$0$0);
        $this$block.model(arg_0 -> TBSBlocks.templateBlock$lambda$0$1($real, arg_0));
        $this$block.simpleLoot();
        $this$block.item(arg_0 -> TBSBlocks.templateBlock$lambda$0$2($this$block, arg_0));
    }

    private static final void templateBlock$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void templateBlock$lambda$0$1(String $real, BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        Block block = $this$model.getBlock();
        ModelProvider modelProvider = (ModelProvider)$this$model.models();
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)("block/" + $real));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
        $this$model.simpleBlock(block, (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)modelProvider, null, (ResourceLocation)resourceLocation, (int)1, null)).renderType("solid"));
    }

    private static final void templateBlock$lambda$0$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::templateBlock$lambda$0$2$0);
        $this$item.noTab();
    }

    private static final void templateBlock$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void templateBlockReal$lambda$0(String $real, BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::templateBlockReal$lambda$0$0);
        $this$block.model(arg_0 -> TBSBlocks.templateBlockReal$lambda$0$1($real, arg_0));
        $this$block.simpleLoot();
        $this$block.item(arg_0 -> TBSBlocks.templateBlockReal$lambda$0$2($this$block, arg_0));
    }

    private static final void templateBlockReal$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void templateBlockReal$lambda$0$1(String $real, BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)TBSConstants.id("block/" + $real), (int)1, null)).renderType("solid"));
    }

    private static final void templateBlockReal$lambda$0$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::templateBlockReal$lambda$0$2$0);
        $this$item.noTab();
    }

    private static final void templateBlockReal$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    private static final void templateBlockLit$lambda$0(String $real, BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSBlocks::templateBlockLit$lambda$0$0);
        $this$block.model(arg_0 -> TBSBlocks.templateBlockLit$lambda$0$1($real, arg_0));
        $this$block.simpleLoot();
        $this$block.item(arg_0 -> TBSBlocks.templateBlockLit$lambda$0$2($this$block, arg_0));
    }

    private static final void templateBlockLit$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.emissive($this$props);
        PropertiesExt.INSTANCE.light($this$props, 6);
        PropertiesExt.INSTANCE.indestructible($this$props);
    }

    private static final void templateBlockLit$lambda$0$1(String $real, BCBlockStateProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simpleBlock($this$model.getBlock(), (ModelFile)((BlockModelBuilder)ModelProvider.cubeAll$default((ModelProvider)((ModelProvider)$this$model.models()), null, (ResourceLocation)TBSConstants.id("block/" + $real), (int)1, null)).renderType("solid"));
    }

    private static final void templateBlockLit$lambda$0$2(BlockBuilder $this_block, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = $this_block.lang;
        $this$item.model(TBSBlocks::templateBlockLit$lambda$0$2$0);
        $this$item.noTab();
    }

    private static final void templateBlockLit$lambda$0$2$0(BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.simple();
    }

    static {
        VoxelShape voxelShape = Block.box((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)11.0, (double)12.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"box(...)");
        SHROOMY_BOX = voxelShape;
        VoxelShape voxelShape2 = Block.box((double)5.5, (double)0.0, (double)5.5, (double)10.5, (double)14.0, (double)10.5);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape2, (String)"box(...)");
        SKINNY_SHROOMY_BOX = voxelShape2;
        VoxelShape voxelShape3 = Block.box((double)2.75, (double)0.0, (double)2.75, (double)13.25, (double)11.0, (double)13.25);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape3, (String)"box(...)");
        VOID_GRASS_BOX = voxelShape3;
        VOID_SHROOM = TBSReg.INSTANCE.block("void_shroom", TBSBlocks::VOID_SHROOM$lambda$0, TBSBlocks::VOID_SHROOM$lambda$1);
        VOID_CAP = TBSReg.INSTANCE.block("void_cap", TBSBlocks::VOID_CAP$lambda$0, TBSBlocks::VOID_CAP$lambda$1);
        VOID_BELL = TBSReg.INSTANCE.block("void_bell", TBSBlocks::VOID_BELL$lambda$0, TBSBlocks::VOID_BELL$lambda$1);
        LILY_OF_THE_ABYSS = TBSReg.INSTANCE.block("lily_of_the_abyss", TBSBlocks::LILY_OF_THE_ABYSS$lambda$0, TBSBlocks::LILY_OF_THE_ABYSS$lambda$1);
        POTTED_VOID_SHROOM = TBSReg.INSTANCE.block("potted_void_shroom", TBSBlocks::POTTED_VOID_SHROOM$lambda$0, TBSBlocks::POTTED_VOID_SHROOM$lambda$1);
        POTTED_VOID_CAP = TBSReg.INSTANCE.block("potted_void_cap", TBSBlocks::POTTED_VOID_CAP$lambda$0, TBSBlocks::POTTED_VOID_CAP$lambda$1);
        POTTED_VOID_BELL = TBSReg.INSTANCE.block("potted_void_bell", TBSBlocks::POTTED_VOID_BELL$lambda$0, TBSBlocks::POTTED_VOID_BELL$lambda$1);
        POTTED_LILY_OF_THE_ABYSS = TBSReg.INSTANCE.block("potted_lily_of_the_abyss", TBSBlocks::POTTED_LILY_OF_THE_ABYSS$lambda$0, TBSBlocks::POTTED_LILY_OF_THE_ABYSS$lambda$1);
        TEETH = TBSReg.INSTANCE.block("teeth", TEETH.1.INSTANCE, TBSBlocks::TEETH$lambda$0);
        VOID_LOG = TBSReg.INSTANCE.block("void_log", VOID_LOG.1.INSTANCE, TBSBlocks::VOID_LOG$lambda$0);
        VOID_WOOD = TBSReg.INSTANCE.defaultBlock("void_wood", TBSBlocks::VOID_WOOD$lambda$0);
        VOID_PLANKS = TBSReg.INSTANCE.defaultBlock("void_planks", TBSBlocks::VOID_PLANKS$lambda$0);
        VOID_PLANK_SLAB = TBSReg.INSTANCE.block("void_plank_slab", VOID_PLANK_SLAB.1.INSTANCE, TBSBlocks::VOID_PLANK_SLAB$lambda$0);
        INITIATOR = TBSReg.INSTANCE.block("initiator", INITIATOR.1.INSTANCE, TBSBlocks::INITIATOR$lambda$0);
        VOID_PLANK_STAIRS = TBSReg.INSTANCE.block("void_plank_stairs", TBSBlocks::VOID_PLANK_STAIRS$lambda$0, TBSBlocks::VOID_PLANK_STAIRS$lambda$1);
        VOID_PLANK_DOOR = TBSReg.INSTANCE.block("void_plank_door", TBSBlocks::VOID_PLANK_DOOR$lambda$0, TBSBlocks::VOID_PLANK_DOOR$lambda$1);
        VOID_LOG_DOOR = TBSReg.INSTANCE.block("void_log_door", TBSBlocks::VOID_LOG_DOOR$lambda$0, TBSBlocks::VOID_LOG_DOOR$lambda$1);
        VOID_WOOD_TRAPDOOR = TBSReg.INSTANCE.block("void_wood_trapdoor", TBSBlocks::VOID_WOOD_TRAPDOOR$lambda$0, TBSBlocks::VOID_WOOD_TRAPDOOR$lambda$1);
        VOID_ROOTS = TBSReg.INSTANCE.block("void_roots", VOID_ROOTS.1.INSTANCE, TBSBlocks::VOID_ROOTS$lambda$0);
        VOID_ROOT = TBSReg.INSTANCE.block("void_root", VOID_ROOT.1.INSTANCE, TBSBlocks::VOID_ROOT$lambda$0);
        VOID_GRASS = TBSReg.INSTANCE.block("void_grass", TBSBlocks::VOID_GRASS$lambda$0, TBSBlocks::VOID_GRASS$lambda$1);
        VOID_BUSH = TBSReg.INSTANCE.block("void_bush", TBSBlocks::VOID_BUSH$lambda$0, TBSBlocks::VOID_BUSH$lambda$1);
        FLOOR_BORDER_BLOCK = TBSReg.INSTANCE.defaultBlock("border_block", TBSBlocks::FLOOR_BORDER_BLOCK$lambda$0);
        DIRT_BORDER_BLOCK = TBSReg.INSTANCE.defaultBlock("dirt_border_block", TBSBlocks::DIRT_BORDER_BLOCK$lambda$0);
        GLASS_BORDER_BLOCK = TBSReg.INSTANCE.block("glass_border_block", TBSBlocks::GLASS_BORDER_BLOCK$lambda$0, TBSBlocks::GLASS_BORDER_BLOCK$lambda$1);
        COBBLESTONE_BORDER_BLOCK = TBSReg.INSTANCE.defaultBlock("cobblestone_border_block", TBSBlocks::COBBLESTONE_BORDER_BLOCK$lambda$0);
        STONE_BORDER_BLOCK = TBSReg.INSTANCE.defaultBlock("stone_border_block", TBSBlocks::STONE_BORDER_BLOCK$lambda$0);
        STONE_SLAB_BORDER_BLOCK = TBSReg.INSTANCE.defaultBlock("stone_slab_border_block", TBSBlocks::STONE_SLAB_BORDER_BLOCK$lambda$0);
        MOIST_CARPET = TBSReg.INSTANCE.defaultBlock("moist_carpet", TBSBlocks::MOIST_CARPET$lambda$0);
        CEILING_LIGHT = TBSReg.INSTANCE.defaultBlock("ceiling_light", TBSBlocks::CEILING_LIGHT$lambda$0);
        CEILING_TILE = TBSReg.INSTANCE.defaultBlock("ceiling_tile", TBSBlocks::CEILING_TILE$lambda$0);
        UGLY_WALLPAPER = TBSReg.INSTANCE.defaultBlock("ugly_wallpaper", TBSBlocks::UGLY_WALLPAPER$lambda$0);
        RED_MOIST_CARPET = TBSReg.INSTANCE.defaultBlock("red_moist_carpet", TBSBlocks::RED_MOIST_CARPET$lambda$0);
        RED_UGLY_WALLPAPER = TBSReg.INSTANCE.defaultBlock("red_ugly_wallpaper", TBSBlocks::RED_UGLY_WALLPAPER$lambda$0);
        RED_CEILING_TILE = TBSReg.INSTANCE.defaultBlock("red_ceiling_tile", TBSBlocks::RED_CEILING_TILE$lambda$0);
        RED_CEILING_LIGHT = TBSReg.INSTANCE.defaultBlock("red_ceiling_light", TBSBlocks::RED_CEILING_LIGHT$lambda$0);
        CORRUPTED_COMMAND_BLOCK_GIVER = TBSReg.INSTANCE.block("command_block_giver", CORRUPTED_COMMAND_BLOCK_GIVER.1.INSTANCE, TBSBlocks::CORRUPTED_COMMAND_BLOCK_GIVER$lambda$0);
        JIM_TRIGGER_1 = INSTANCE.jimTrigger("jim_trigger_1");
        JIM_TRIGGER_2 = INSTANCE.jimTrigger("jim_trigger_2");
        JIM_TRIGGER_3 = INSTANCE.jimTrigger("jim_trigger_3");
        JIM_TRIGGER_4 = INSTANCE.jimTrigger("jim_trigger_4");
        VOID_TEMPLATE_1 = INSTANCE.templateBlock("void_template_1", "white_wool");
        VOID_TEMPLATE_2 = INSTANCE.templateBlockReal("void_template_2", "void_growth");
        VOID_TEMPLATE_3 = INSTANCE.templateBlockReal("void_template_3", "void_growth");
        VOID_TEMPLATE_4 = INSTANCE.templateBlock("void_template_4", "black_wool");
        VOID_TEMPLATE_5 = INSTANCE.templateBlock("void_template_5", "brown_wool");
        VOID_TEMPLATE_6 = INSTANCE.templateBlockLit("void_template_6", "void_shimmer");
        VOID_TEMPLATE_7 = INSTANCE.templateBlock("void_template_7", "orange_wool");
        VOID_TEMPLATE_8 = INSTANCE.templateBlock("void_template_8", "yellow_wool");
        VOID_TEMPLATE_9 = INSTANCE.templateBlock("void_template_9", "lime_wool");
        VOID_TEMPLATE_10 = INSTANCE.templateBlock("void_template_10", "green_wool");
        VOID_TEMPLATE_11 = INSTANCE.templateBlock("void_template_11", "cyan_wool");
        VOID_TEMPLATE_12 = INSTANCE.templateBlock("void_template_12", "light_blue_wool");
        VOID_TEMPLATE_13 = INSTANCE.templateBlock("void_template_13", "blue_wool");
        VOID_TEMPLATE_14 = INSTANCE.templateBlock("void_template_14", "purple_wool");
        VOID_TEMPLATE_15 = INSTANCE.templateBlock("void_template_15", "magenta_wool");
        VOID_TEMPLATE_16 = INSTANCE.templateBlock("void_template_16", "pink_wool");
    }
}

