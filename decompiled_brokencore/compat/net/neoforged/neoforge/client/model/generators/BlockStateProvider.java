/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableSet
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.PackOutput$Target
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.ButtonBlock
 *  net.minecraft.world.level.block.CeilingHangingSignBlock
 *  net.minecraft.world.level.block.CrossCollisionBlock
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.FenceBlock
 *  net.minecraft.world.level.block.FenceGateBlock
 *  net.minecraft.world.level.block.IronBarsBlock
 *  net.minecraft.world.level.block.PipeBlock
 *  net.minecraft.world.level.block.PressurePlateBlock
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.block.SlabBlock
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.block.StandingSignBlock
 *  net.minecraft.world.level.block.TrapDoorBlock
 *  net.minecraft.world.level.block.WallBlock
 *  net.minecraft.world.level.block.WallHangingSignBlock
 *  net.minecraft.world.level.block.WallSignBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.AttachFace
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.DoorHingeSide
 *  net.minecraft.world.level.block.state.properties.DoubleBlockHalf
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.Half
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.block.state.properties.SlabType
 *  net.minecraft.world.level.block.state.properties.StairsShape
 *  net.minecraft.world.level.block.state.properties.WallSide
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.VisibleForTesting
 */
package compat.net.neoforged.neoforge.client.model.generators;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import compat.net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import compat.net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import compat.net.neoforged.neoforge.client.model.generators.IGeneratedBlockState;
import compat.net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import compat.net.neoforged.neoforge.client.model.generators.ModelFile;
import compat.net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import compat.net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.thebrokenscript.brokencore.impl.block.VerticalSlabBlock;
import net.thebrokenscript.brokencore.impl.block.VerticalSlabType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00bc\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00b6\u00012\u00020\u0001:\u0004\u00b5\u0001\u00b6\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H&J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"J\u000e\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\fJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\"H\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\fJ(\u0010,\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0018\u0010-\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.J\u001a\u0010,\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\b\b\u0002\u00101\u001a\u00020+H\u0007J\u0016\u00102\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u00101\u001a\u00020+J\u0016\u00103\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u00101\u001a\u00020+J'\u0010,\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002000/\"\u000200\u00a2\u0006\u0002\u00104J\u000e\u00105\u001a\u00020\u00192\u0006\u0010%\u001a\u000206J\u001a\u00107\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\b\b\u0002\u00108\u001a\u00020\u0005H\u0007J\u001e\u00107\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005J\u0016\u0010;\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u0010<\u001a\u00020\"J\u0016\u0010=\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u0010<\u001a\u00020\"J\u001e\u0010;\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u00108\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J&\u0010;\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J\u0016\u0010;\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u0010<\u001a\u00020\u0005J\u0016\u0010=\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u0010<\u001a\u00020\u0005J\u001e\u0010;\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u00108\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J&\u0010;\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J\u001e\u00107\u001a\u00020\u00192\u0006\u0010%\u001a\u0002062\u0006\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020+J&\u0010@\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005J\"\u0010@\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u00101\u001a\u00020+2\b\b\u0002\u0010C\u001a\u00020DH\u0007J.\u0010@\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020+0.2\b\b\u0002\u0010C\u001a\u00020DH\u0007J\"\u0010G\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u00101\u001a\u00020+2\b\b\u0002\u0010C\u001a\u00020DH\u0007J.\u0010G\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020+0.2\b\b\u0002\u0010C\u001a\u00020DH\u0007J\"\u0010H\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u00101\u001a\u00020+2\b\b\u0002\u0010C\u001a\u00020DH\u0007J.\u0010H\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020+0.2\b\b\u0002\u0010C\u001a\u00020DH\u0007J\u0016\u0010I\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010I\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u0005J&\u0010I\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u00109\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005J.\u0010I\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010!\u001a\u00020\"2\u0006\u00109\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005J\u001e\u0010M\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J&\u0010M\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J.\u0010M\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u00109\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J6\u0010M\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010!\u001a\u00020\"2\u0006\u00109\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J\u001e\u0010M\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J&\u0010M\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J.\u0010M\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u00109\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J6\u0010M\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010!\u001a\u00020\"2\u0006\u00109\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J0\u0010N\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J8\u0010O\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J&\u0010I\u001a\u00020\u00192\u0006\u0010%\u001a\u00020J2\u0006\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020+J\u0016\u0010S\u001a\u00020\u00192\u0006\u0010%\u001a\u00020T2\u0006\u0010K\u001a\u00020\u0005J.\u0010S\u001a\u00020\u00192\u0006\u0010%\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005J&\u0010S\u001a\u00020\u00192\u0006\u0010%\u001a\u00020T2\u0006\u0010L\u001a\u00020+2\u0006\u0010B\u001a\u00020+2\u0006\u0010V\u001a\u00020+J\u0016\u0010W\u001a\u00020\u00192\u0006\u0010%\u001a\u00020X2\u0006\u0010K\u001a\u00020\u0005J.\u0010W\u001a\u00020\u00192\u0006\u0010%\u001a\u00020X2\u0006\u0010U\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0005J&\u0010W\u001a\u00020\u00192\u0006\u0010%\u001a\u00020X2\u0006\u0010Z\u001a\u00020+2\u0006\u0010Y\u001a\u00020+2\u0006\u0010V\u001a\u00020+J\u0016\u0010[\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\\2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010[\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\\2\u0006\u0010]\u001a\u00020+2\u0006\u0010^\u001a\u00020+J\u0016\u0010_\u001a\u00020\u00192\u0006\u0010%\u001a\u00020`2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010_\u001a\u00020\u00192\u0006\u0010%\u001a\u00020`2\u0006\u0010a\u001a\u00020+2\u0006\u0010b\u001a\u00020+J\u001e\u0010c\u001a\u00020\u00192\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010c\u001a\u00020\u00192\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020+J\u001e\u0010h\u001a\u00020\u00192\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010h\u001a\u00020\u00192\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020+J\u001e\u0010m\u001a\u00020\u00192\u0006\u0010%\u001a\u00020n2\u0006\u0010o\u001a\u00020+2\u0006\u00109\u001a\u00020+J\u0016\u0010p\u001a\u00020\u00192\u0006\u0010q\u001a\u00020\u001e2\u0006\u00109\u001a\u00020+J\u0016\u0010r\u001a\u00020\u00192\u0006\u0010%\u001a\u00020s2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010r\u001a\u00020\u00192\u0006\u0010%\u001a\u00020s2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010t\u001a\u00020\u00192\u0006\u0010%\u001a\u00020s2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J&\u0010t\u001a\u00020\u00192\u0006\u0010%\u001a\u00020s2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J\u001e\u0010t\u001a\u00020\u00192\u0006\u0010%\u001a\u00020s2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J&\u0010t\u001a\u00020\u00192\u0006\u0010%\u001a\u00020s2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J\u0016\u0010u\u001a\u00020\u00192\u0006\u0010%\u001a\u00020v2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010u\u001a\u00020\u00192\u0006\u0010%\u001a\u00020v2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010w\u001a\u00020\u00192\u0006\u0010%\u001a\u00020v2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J&\u0010w\u001a\u00020\u00192\u0006\u0010%\u001a\u00020v2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J\u001e\u0010w\u001a\u00020\u00192\u0006\u0010%\u001a\u00020v2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J&\u0010w\u001a\u00020\u00192\u0006\u0010%\u001a\u00020v2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J \u0010x\u001a\u00020\u00192\u0006\u0010%\u001a\u00020v2\u0006\u00108\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u0005H\u0002J(\u0010y\u001a\u00020\u00192\u0006\u0010%\u001a\u00020v2\u0006\u00108\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J.\u0010u\u001a\u00020\u00192\u0006\u0010%\u001a\u00020v2\u0006\u0010z\u001a\u00020+2\u0006\u0010{\u001a\u00020+2\u0006\u0010|\u001a\u00020+2\u0006\u0010}\u001a\u00020+J\u0016\u0010~\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u007f2\u0006\u0010K\u001a\u00020\u0005J\u001e\u0010~\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u007f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u0005J\u001f\u0010\u0080\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u007f2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J'\u0010\u0080\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u007f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J\u001f\u0010\u0080\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u007f2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J'\u0010\u0080\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u007f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J!\u0010\u0081\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u007f2\u0006\u00108\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u0005H\u0002J)\u0010\u0082\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u007f2\u0006\u00108\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J'\u0010~\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u007f2\u0006\u0010o\u001a\u00020+2\u0006\u00109\u001a\u00020+2\u0007\u0010\u0083\u0001\u001a\u00020+JB\u0010\u0084\u0001\u001a\u00020\u00192\u0006\u0010q\u001a\u00020\u001e2\u0006\u00101\u001a\u00020+2\u001d\u0010\u0085\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0087\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0089\u00010\u0088\u00010\u0086\u00012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0002J\"\u0010\u008b\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u00052\u0007\u0010\u008e\u0001\u001a\u00020\u0005J*\u0010\u008b\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u008c\u00012\u0006\u0010!\u001a\u00020\"2\u0007\u0010\u008d\u0001\u001a\u00020\u00052\u0007\u0010\u008e\u0001\u001a\u00020\u0005J*\u0010\u008f\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u00052\u0007\u0010\u008e\u0001\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J2\u0010\u008f\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u008c\u00012\u0006\u0010!\u001a\u00020\"2\u0007\u0010\u008d\u0001\u001a\u00020\u00052\u0007\u0010\u008e\u0001\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J*\u0010\u008f\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u00052\u0007\u0010\u008e\u0001\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J2\u0010\u008f\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u008c\u00012\u0006\u0010!\u001a\u00020\"2\u0007\u0010\u008d\u0001\u001a\u00020\u00052\u0007\u0010\u008e\u0001\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J,\u0010\u0090\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u008c\u00012\u0006\u00108\u001a\u00020\"2\u0007\u0010\u008d\u0001\u001a\u00020\u00052\u0007\u0010\u008e\u0001\u001a\u00020\u0005H\u0002J4\u0010\u0091\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u008c\u00012\u0006\u00108\u001a\u00020\"2\u0007\u0010\u008d\u0001\u001a\u00020\u00052\u0007\u0010\u008e\u0001\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J;\u0010\u008b\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u008c\u00012\u0006\u0010o\u001a\u00020+2\u0006\u00109\u001a\u00020+2\u0007\u0010\u0092\u0001\u001a\u00020+2\u0007\u0010\u0093\u0001\u001a\u00020+2\u0007\u0010\u0094\u0001\u001a\u00020+J \u0010\u0095\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u0096\u00012\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005J(\u0010\u0095\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u0096\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005J(\u0010\u0097\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u0096\u00012\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J0\u0010\u0097\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u0096\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\"J(\u0010\u0097\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u0096\u00012\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J0\u0010\u0097\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u0096\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J*\u0010\u0098\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u0096\u00012\u0006\u00108\u001a\u00020\"2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J2\u0010\u0099\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u0096\u00012\u0006\u00108\u001a\u00020\"2\u0006\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002JX\u0010\u0095\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u0096\u00012\u0007\u0010\u009a\u0001\u001a\u00020+2\u0007\u0010\u009b\u0001\u001a\u00020+2\u0007\u0010\u009c\u0001\u001a\u00020+2\u0007\u0010\u009d\u0001\u001a\u00020+2\u0007\u0010\u009e\u0001\u001a\u00020+2\u0007\u0010\u009f\u0001\u001a\u00020+2\u0007\u0010\u00a0\u0001\u001a\u00020+2\u0007\u0010\u00a1\u0001\u001a\u00020+J\"\u0010\u00a2\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u00a3\u00012\u0006\u0010K\u001a\u00020\u00052\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u0001J*\u0010\u00a2\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u00a3\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u0001J*\u0010\u00a6\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u00a3\u00012\u0006\u0010K\u001a\u00020\u00052\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\u0006\u0010<\u001a\u00020\"J2\u0010\u00a6\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u00a3\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\u0006\u0010<\u001a\u00020\"J*\u0010\u00a6\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u00a3\u00012\u0006\u0010K\u001a\u00020\u00052\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\u0006\u0010<\u001a\u00020\u0005J2\u0010\u00a6\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u00a3\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\u0006\u0010<\u001a\u00020\u0005J,\u0010\u00a7\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u00a3\u00012\u0006\u00108\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u0001H\u0002J4\u0010\u00a8\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u00a3\u00012\u0006\u00108\u001a\u00020\"2\u0006\u0010K\u001a\u00020\u00052\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\u0006\u0010<\u001a\u00020\u0005H\u0002J3\u0010\u00a2\u0001\u001a\u00020\u00192\u0007\u0010%\u001a\u00030\u00a3\u00012\u0006\u0010L\u001a\u00020+2\u0006\u0010B\u001a\u00020+2\u0007\u0010\u00a9\u0001\u001a\u00020+2\b\u0010\u00a4\u0001\u001a\u00030\u00a5\u0001J\u0017\u0010\u00aa\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u0005J\u0017\u0010\u00aa\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u00101\u001a\u00020+J\u0017\u0010\u00ab\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u0005J\u0017\u0010\u00ab\u0001\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\f2\u0006\u00101\u001a\u00020+J(\u0010\u00ac\u0001\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u00ad\u0001\u001a\u00030\u00ae\u00012\u0007\u0010\u00af\u0001\u001a\u00020\fH\u0002J\u0015\u0010\u00b0\u0001\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0005\u0012\u00030\u00b2\u00010\u00b1\u0001J\u0011\u0010\u00b3\u0001\u001a\u00020\"2\u0006\u0010%\u001a\u00020\fH\u0004J\t\u0010\u00b4\u0001\u001a\u00020\"H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0004X\u0085\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00b7\u0001"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider;", "Lnet/minecraft/data/DataProvider;", "output", "Lnet/minecraft/data/PackOutput;", "id", "Lnet/minecraft/resources/ResourceLocation;", "exFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/minecraft/resources/ResourceLocation;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "registeredBlocks", "", "Lnet/minecraft/world/level/block/Block;", "Lcompat/net/neoforged/neoforge/client/model/generators/IGeneratedBlockState;", "getRegisteredBlocks", "()Ljava/util/Map;", "blockModels", "Lcompat/net/neoforged/neoforge/client/model/generators/BlockModelProvider;", "itemModels", "Lcompat/net/neoforged/neoforge/client/model/generators/ItemModelProvider;", "run", "Ljava/util/concurrent/CompletableFuture;", "cache", "Lnet/minecraft/data/CachedOutput;", "registerStatesAndModels", "", "getVariantBuilder", "Lcompat/net/neoforged/neoforge/client/model/generators/VariantBlockStateBuilder;", "b", "getMultipartBuilder", "Lcompat/net/neoforged/neoforge/client/model/generators/MultiPartBlockStateBuilder;", "models", "modLoc", "name", "", "mcLoc", "key", "block", "blockTexture", "extend", "rl", "suffix", "cubeAll", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile;", "simpleBlock", "expander", "Ljava/util/function/Function;", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "model", "simpleBlockItem", "simpleBlockWithItem", "(Lnet/minecraft/world/level/block/Block;[Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;)V", "logBlock", "Lnet/minecraft/world/level/block/RotatedPillarBlock;", "axisBlock", "baseName", "side", "end", "axisBlockWithRenderType", "renderType", "logBlockWithRenderType", "vertical", "horizontal", "horizontalBlock", "front", "top", "angleOffset", "", "modelFunc", "Lnet/minecraft/world/level/block/state/BlockState;", "horizontalFaceBlock", "directionalBlock", "stairsBlock", "Lnet/minecraft/world/level/block/StairBlock;", "texture", "bottom", "stairsBlockWithRenderType", "stairsBlockInternal", "stairsBlockInternalWithRenderType", "stairs", "stairsInner", "stairsOuter", "slabBlock", "Lnet/minecraft/world/level/block/SlabBlock;", "doubleTexture", "double", "verticalSlabBlock", "Lnet/thebrokenscript/brokencore/impl/block/VerticalSlabBlock;", "left", "right", "buttonBlock", "Lnet/minecraft/world/level/block/ButtonBlock;", "button", "buttonPressed", "pressurePlateBlock", "Lnet/minecraft/world/level/block/PressurePlateBlock;", "pressurePlate", "pressurePlateDown", "signBlock", "Lnet/minecraft/world/level/block/StandingSignBlock;", "wallSignBlock", "Lnet/minecraft/world/level/block/WallSignBlock;", "sign", "hangingSignBlock", "Lnet/minecraft/world/level/block/CeilingHangingSignBlock;", "wallHangingSignBlock", "Lnet/minecraft/world/level/block/WallHangingSignBlock;", "hangingSign", "fourWayBlock", "Lnet/minecraft/world/level/block/CrossCollisionBlock;", "post", "fourWayMultipart", "builder", "fenceBlock", "Lnet/minecraft/world/level/block/FenceBlock;", "fenceBlockWithRenderType", "fenceGateBlock", "Lnet/minecraft/world/level/block/FenceGateBlock;", "fenceGateBlockWithRenderType", "fenceGateBlockInternal", "fenceGateBlockInternalWithRenderType", "gate", "gateOpen", "gateWall", "gateWallOpen", "wallBlock", "Lnet/minecraft/world/level/block/WallBlock;", "wallBlockWithRenderType", "wallBlockInternal", "wallBlockInternalWithRenderType", "sideTall", "wallSidePart", "entry", "", "Lnet/minecraft/core/Direction;", "Lnet/minecraft/world/level/block/state/properties/Property;", "Lnet/minecraft/world/level/block/state/properties/WallSide;", "height", "paneBlock", "Lnet/minecraft/world/level/block/IronBarsBlock;", "pane", "edge", "paneBlockWithRenderType", "paneBlockInternal", "paneBlockInternalWithRenderType", "sideAlt", "noSide", "noSideAlt", "doorBlock", "Lnet/minecraft/world/level/block/DoorBlock;", "doorBlockWithRenderType", "doorBlockInternal", "doorBlockInternalWithRenderType", "bottomLeft", "bottomLeftOpen", "bottomRight", "bottomRightOpen", "topLeft", "topLeftOpen", "topRight", "topRightOpen", "trapdoorBlock", "Lnet/minecraft/world/level/block/TrapDoorBlock;", "orientable", "", "trapdoorBlockWithRenderType", "trapdoorBlockInternal", "trapdoorBlockInternalWithRenderType", "open", "crossBlock", "pottedFlowerBlock", "saveBlockState", "stateJson", "Lcom/google/gson/JsonObject;", "owner", "getStateJsons", "", "Lcom/google/gson/JsonElement;", "getStringPath", "getName", "ConfiguredModelList", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBlockStateProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockStateProvider.kt\ncompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1195:1\n1869#2,2:1196\n1563#2:1198\n1634#2,3:1199\n37#3,2:1202\n1#4:1204\n*S KotlinDebug\n*F\n+ 1 BlockStateProvider.kt\ncompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider\n*L\n830#1:1196,2\n1142#1:1198\n1142#1:1199,3\n1142#1:1202,2\n*E\n"})
public abstract class BlockStateProvider
implements DataProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final PackOutput output;
    @NotNull
    private final ResourceLocation id;
    @VisibleForTesting
    @NotNull
    private final Map<Block, IGeneratedBlockState> registeredBlocks;
    @NotNull
    private final BlockModelProvider blockModels;
    @NotNull
    private final ItemModelProvider itemModels;
    @NotNull
    private static final Logger LOGGER;
    @NotNull
    private static final Gson GSON;
    private static final int DEFAULT_ANGLE_OFFSET = 180;
    @NotNull
    private static final ImmutableMap<Direction, Property<WallSide>> WALL_PROPS;

    public BlockStateProvider(@NotNull PackOutput output, @NotNull ResourceLocation id, @NotNull ExistingFileHelper exFileHelper) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)exFileHelper, (String)"exFileHelper");
        this.output = output;
        this.id = id;
        this.registeredBlocks = new LinkedHashMap();
        PackOutput packOutput = this.output;
        ResourceLocation resourceLocation = this.id;
        this.blockModels = new BlockModelProvider(exFileHelper, packOutput, resourceLocation){

            public CompletableFuture<?> run(CachedOutput cache) {
                Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
                CompletableFuture<Void> completableFuture = CompletableFuture.allOf(new CompletableFuture[0]);
                Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"allOf(...)");
                return completableFuture;
            }

            public void registerModels() {
            }
        };
        packOutput = this.output;
        resourceLocation = this.id;
        ExistingFileHelper existingFileHelper = this.blockModels.existingFileHelper;
        this.itemModels = new ItemModelProvider(packOutput, resourceLocation, existingFileHelper){

            public void registerModels() {
            }

            public CompletableFuture<?> run(CachedOutput cache) {
                Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
                CompletableFuture<Void> completableFuture = CompletableFuture.allOf(new CompletableFuture[0]);
                Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"allOf(...)");
                return completableFuture;
            }
        };
    }

    @NotNull
    protected final Map<Block, IGeneratedBlockState> getRegisteredBlocks() {
        return this.registeredBlocks;
    }

    @NotNull
    public CompletableFuture<?> run(@NotNull CachedOutput cache) {
        Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
        this.models().clear();
        this.itemModels().clear();
        this.registeredBlocks.clear();
        this.registerStatesAndModels();
        CompletableFuture[] futures = new CompletableFuture[2 + this.registeredBlocks.size()];
        int i = 0;
        futures[i++] = this.models().generateAll(cache);
        futures[i++] = this.itemModels().generateAll(cache);
        for (Map.Entry<Block, IGeneratedBlockState> entry : this.registeredBlocks.entrySet()) {
            futures[i++] = this.saveBlockState(cache, entry.getValue().toJson(), entry.getKey());
        }
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(Arrays.copyOf(futures, futures.length));
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"allOf(...)");
        return completableFuture;
    }

    public abstract void registerStatesAndModels();

    @NotNull
    public final VariantBlockStateBuilder getVariantBuilder(@NotNull Block b) {
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        if (this.registeredBlocks.containsKey(b)) {
            IGeneratedBlockState old = this.registeredBlocks.get(b);
            Preconditions.checkState((boolean)(old instanceof VariantBlockStateBuilder));
            Intrinsics.checkNotNull((Object)old, (String)"null cannot be cast to non-null type compat.net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder");
            return (VariantBlockStateBuilder)old;
        }
        VariantBlockStateBuilder ret = new VariantBlockStateBuilder(b);
        this.registeredBlocks.put(b, ret);
        return ret;
    }

    @NotNull
    public final MultiPartBlockStateBuilder getMultipartBuilder(@NotNull Block b) {
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        if (this.registeredBlocks.containsKey(b)) {
            IGeneratedBlockState old = this.registeredBlocks.get(b);
            Preconditions.checkState((boolean)(old instanceof MultiPartBlockStateBuilder));
            Intrinsics.checkNotNull((Object)old, (String)"null cannot be cast to non-null type compat.net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder");
            return (MultiPartBlockStateBuilder)old;
        }
        MultiPartBlockStateBuilder ret = new MultiPartBlockStateBuilder(b);
        this.registeredBlocks.put(b, ret);
        return ret;
    }

    @NotNull
    public final BlockModelProvider models() {
        return this.blockModels;
    }

    @NotNull
    public final ItemModelProvider itemModels() {
        return this.itemModels;
    }

    @NotNull
    public final ResourceLocation modLoc(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ResourceLocation resourceLocation = this.id.withPath(name);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withPath(...)");
        return resourceLocation;
    }

    @NotNull
    public final ResourceLocation mcLoc(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ResourceLocation resourceLocation = ResourceLocation.parse((String)name);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"parse(...)");
        return resourceLocation;
    }

    @NotNull
    public final ResourceLocation key(@NotNull Block block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey((Object)block2);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"getKey(...)");
        return resourceLocation;
    }

    @NotNull
    public final String name(@NotNull Block block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        String string = this.key(block2).getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        return string;
    }

    @NotNull
    public final ResourceLocation blockTexture(@NotNull Block block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)this.key(block2).getNamespace(), (String)("block/" + this.key(block2).getPath()));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    @NotNull
    public final ResourceLocation blockTexture(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)this.id.getNamespace(), (String)("block/" + name));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    private final ResourceLocation extend(ResourceLocation rl, String suffix) {
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)rl.getNamespace(), (String)(rl.getPath() + suffix));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    @NotNull
    public final ModelFile cubeAll(@NotNull Block block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        return (ModelFile)this.models().cubeAll(this.name(block2), this.blockTexture(block2));
    }

    public final void simpleBlock(@NotNull Block block2, @NotNull Function<ModelFile, ConfiguredModel[]> expander) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter(expander, (String)"expander");
        ConfiguredModel[] configuredModelArray = expander.apply(this.cubeAll(block2));
        this.simpleBlock(block2, Arrays.copyOf(configuredModelArray, configuredModelArray.length));
    }

    @JvmOverloads
    public final void simpleBlock(@NotNull Block block2, @NotNull ModelFile model) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        ConfiguredModel[] configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(model, 0, 0, false, 0, 30, null)};
        this.simpleBlock(block2, configuredModelArray);
    }

    public static /* synthetic */ void simpleBlock$default(BlockStateProvider blockStateProvider, Block block2, ModelFile modelFile, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: simpleBlock");
        }
        if ((n & 2) != 0) {
            modelFile = blockStateProvider.cubeAll(block2);
        }
        blockStateProvider.simpleBlock(block2, modelFile);
    }

    public final void simpleBlockItem(@NotNull Block block2, @NotNull ModelFile model) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        ItemModelProvider itemModelProvider = this.itemModels();
        String string = this.key(block2).getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        ((ItemModelBuilder)itemModelProvider.getBuilder(string)).parent(model);
    }

    public final void simpleBlockWithItem(@NotNull Block block2, @NotNull ModelFile model) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        this.simpleBlock(block2, model);
        this.simpleBlockItem(block2, model);
    }

    public final void simpleBlock(@NotNull Block block2, ConfiguredModel ... models) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)models, (String)"models");
        this.getVariantBuilder(block2).partialState().setModels(Arrays.copyOf(models, models.length));
    }

    public final void logBlock(@NotNull RotatedPillarBlock block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        this.axisBlock(block2, this.blockTexture((Block)block2), this.extend(this.blockTexture((Block)block2), "_top"));
    }

    @JvmOverloads
    public final void axisBlock(@NotNull RotatedPillarBlock block2, @NotNull ResourceLocation baseName) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)baseName, (String)"baseName");
        this.axisBlock(block2, this.extend(baseName, "_side"), this.extend(baseName, "_end"));
    }

    public static /* synthetic */ void axisBlock$default(BlockStateProvider blockStateProvider, RotatedPillarBlock rotatedPillarBlock, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: axisBlock");
        }
        if ((n & 2) != 0) {
            resourceLocation = blockStateProvider.blockTexture((Block)rotatedPillarBlock);
        }
        blockStateProvider.axisBlock(rotatedPillarBlock, resourceLocation);
    }

    public final void axisBlock(@NotNull RotatedPillarBlock block2, @NotNull ResourceLocation side, @NotNull ResourceLocation end) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        this.axisBlock(block2, (ModelFile)this.models().cubeColumn(this.name((Block)block2), side, end), (ModelFile)this.models().cubeColumnHorizontal(this.name((Block)block2) + "_horizontal", side, end));
    }

    public final void axisBlockWithRenderType(@NotNull RotatedPillarBlock block2, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.axisBlockWithRenderType(block2, this.blockTexture((Block)block2), renderType);
    }

    public final void logBlockWithRenderType(@NotNull RotatedPillarBlock block2, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.axisBlockWithRenderType(block2, this.blockTexture((Block)block2), this.extend(this.blockTexture((Block)block2), "_top"), renderType);
    }

    public final void axisBlockWithRenderType(@NotNull RotatedPillarBlock block2, @NotNull ResourceLocation baseName, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)baseName, (String)"baseName");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.axisBlockWithRenderType(block2, this.extend(baseName, "_side"), this.extend(baseName, "_end"), renderType);
    }

    public final void axisBlockWithRenderType(@NotNull RotatedPillarBlock block2, @NotNull ResourceLocation side, @NotNull ResourceLocation end, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.axisBlock(block2, (ModelFile)((BlockModelBuilder)this.models().cubeColumn(this.name((Block)block2), side, end)).renderType(renderType), (ModelFile)((BlockModelBuilder)this.models().cubeColumnHorizontal(this.name((Block)block2) + "_horizontal", side, end)).renderType(renderType));
    }

    public final void axisBlockWithRenderType(@NotNull RotatedPillarBlock block2, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.axisBlockWithRenderType(block2, this.blockTexture((Block)block2), renderType);
    }

    public final void logBlockWithRenderType(@NotNull RotatedPillarBlock block2, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.axisBlockWithRenderType(block2, this.blockTexture((Block)block2), this.extend(this.blockTexture((Block)block2), "_top"), renderType);
    }

    public final void axisBlockWithRenderType(@NotNull RotatedPillarBlock block2, @NotNull ResourceLocation baseName, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)baseName, (String)"baseName");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.axisBlockWithRenderType(block2, this.extend(baseName, "_side"), this.extend(baseName, "_end"), renderType);
    }

    public final void axisBlockWithRenderType(@NotNull RotatedPillarBlock block2, @NotNull ResourceLocation side, @NotNull ResourceLocation end, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.axisBlock(block2, (ModelFile)((BlockModelBuilder)this.models().cubeColumn(this.name((Block)block2), side, end)).renderType(renderType), (ModelFile)((BlockModelBuilder)this.models().cubeColumnHorizontal(this.name((Block)block2) + "_horizontal", side, end)).renderType(renderType));
    }

    public final void axisBlock(@NotNull RotatedPillarBlock block2, @NotNull ModelFile vertical, @NotNull ModelFile horizontal) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)vertical, (String)"vertical");
        Intrinsics.checkNotNullParameter((Object)horizontal, (String)"horizontal");
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate = this.getVariantBuilder((Block)block2).partialState();
        EnumProperty enumProperty = RotatedPillarBlock.AXIS;
        Intrinsics.checkNotNullExpressionValue((Object)enumProperty, (String)"AXIS");
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate2 = partialBlockstate.with((Property)enumProperty, (Comparable)Direction.Axis.Y).modelForState().modelFile(vertical).addModel().partialState();
        EnumProperty enumProperty2 = RotatedPillarBlock.AXIS;
        Intrinsics.checkNotNullExpressionValue((Object)enumProperty2, (String)"AXIS");
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate3 = partialBlockstate2.with((Property)enumProperty2, (Comparable)Direction.Axis.Z).modelForState().modelFile(horizontal).rotationX(90).addModel().partialState();
        EnumProperty enumProperty3 = RotatedPillarBlock.AXIS;
        Intrinsics.checkNotNullExpressionValue((Object)enumProperty3, (String)"AXIS");
        partialBlockstate3.with((Property)enumProperty3, (Comparable)Direction.Axis.X).modelForState().modelFile(horizontal).rotationX(90).rotationY(90).addModel();
    }

    public final void horizontalBlock(@NotNull Block block2, @NotNull ResourceLocation side, @NotNull ResourceLocation front, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)front, (String)"front");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        BlockStateProvider.horizontalBlock$default(this, block2, (ModelFile)this.models().orientable(this.name(block2), side, front, top), 0, 4, null);
    }

    @JvmOverloads
    public final void horizontalBlock(@NotNull Block block2, @NotNull ModelFile model, int angleOffset) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        this.horizontalBlock(block2, arg_0 -> BlockStateProvider.horizontalBlock$lambda$0(model, arg_0), angleOffset);
    }

    public static /* synthetic */ void horizontalBlock$default(BlockStateProvider blockStateProvider, Block block2, ModelFile modelFile, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: horizontalBlock");
        }
        if ((n2 & 4) != 0) {
            n = 180;
        }
        blockStateProvider.horizontalBlock(block2, modelFile, n);
    }

    @JvmOverloads
    public final void horizontalBlock(@NotNull Block block2, @NotNull Function<BlockState, ModelFile> modelFunc, int angleOffset) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter(modelFunc, (String)"modelFunc");
        this.getVariantBuilder(block2).forAllStates(arg_0 -> BlockStateProvider.horizontalBlock$lambda$1(modelFunc, angleOffset, arg_0));
    }

    public static /* synthetic */ void horizontalBlock$default(BlockStateProvider blockStateProvider, Block block2, Function function, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: horizontalBlock");
        }
        if ((n2 & 4) != 0) {
            n = 180;
        }
        blockStateProvider.horizontalBlock(block2, function, n);
    }

    @JvmOverloads
    public final void horizontalFaceBlock(@NotNull Block block2, @NotNull ModelFile model, int angleOffset) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        this.horizontalFaceBlock(block2, arg_0 -> BlockStateProvider.horizontalFaceBlock$lambda$0(model, arg_0), angleOffset);
    }

    public static /* synthetic */ void horizontalFaceBlock$default(BlockStateProvider blockStateProvider, Block block2, ModelFile modelFile, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: horizontalFaceBlock");
        }
        if ((n2 & 4) != 0) {
            n = 180;
        }
        blockStateProvider.horizontalFaceBlock(block2, modelFile, n);
    }

    @JvmOverloads
    public final void horizontalFaceBlock(@NotNull Block block2, @NotNull Function<BlockState, ModelFile> modelFunc, int angleOffset) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter(modelFunc, (String)"modelFunc");
        this.getVariantBuilder(block2).forAllStates(arg_0 -> BlockStateProvider.horizontalFaceBlock$lambda$1(modelFunc, angleOffset, arg_0));
    }

    public static /* synthetic */ void horizontalFaceBlock$default(BlockStateProvider blockStateProvider, Block block2, Function function, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: horizontalFaceBlock");
        }
        if ((n2 & 4) != 0) {
            n = 180;
        }
        blockStateProvider.horizontalFaceBlock(block2, function, n);
    }

    @JvmOverloads
    public final void directionalBlock(@NotNull Block block2, @NotNull ModelFile model, int angleOffset) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        this.directionalBlock(block2, arg_0 -> BlockStateProvider.directionalBlock$lambda$0(model, arg_0), angleOffset);
    }

    public static /* synthetic */ void directionalBlock$default(BlockStateProvider blockStateProvider, Block block2, ModelFile modelFile, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: directionalBlock");
        }
        if ((n2 & 4) != 0) {
            n = 180;
        }
        blockStateProvider.directionalBlock(block2, modelFile, n);
    }

    @JvmOverloads
    public final void directionalBlock(@NotNull Block block2, @NotNull Function<BlockState, ModelFile> modelFunc, int angleOffset) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter(modelFunc, (String)"modelFunc");
        this.getVariantBuilder(block2).forAllStates(arg_0 -> BlockStateProvider.directionalBlock$lambda$1(modelFunc, angleOffset, arg_0));
    }

    public static /* synthetic */ void directionalBlock$default(BlockStateProvider blockStateProvider, Block block2, Function function, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: directionalBlock");
        }
        if ((n2 & 4) != 0) {
            n = 180;
        }
        blockStateProvider.directionalBlock(block2, function, n);
    }

    public final void stairsBlock(@NotNull StairBlock block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.stairsBlock(block2, texture, texture, texture);
    }

    public final void stairsBlock(@NotNull StairBlock block2, @NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.stairsBlock(block2, name, texture, texture, texture);
    }

    public final void stairsBlock(@NotNull StairBlock block2, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.stairsBlockInternal(block2, string, side, bottom, top);
    }

    public final void stairsBlock(@NotNull StairBlock block2, @NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        this.stairsBlockInternal(block2, name + "_stairs", side, bottom, top);
    }

    public final void stairsBlockWithRenderType(@NotNull StairBlock block2, @NotNull ResourceLocation texture, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.stairsBlockWithRenderType(block2, texture, texture, texture, renderType);
    }

    public final void stairsBlockWithRenderType(@NotNull StairBlock block2, @NotNull String name, @NotNull ResourceLocation texture, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.stairsBlockWithRenderType(block2, name, texture, texture, texture, renderType);
    }

    public final void stairsBlockWithRenderType(@NotNull StairBlock block2, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.stairsBlockInternalWithRenderType(block2, string, side, bottom, top, resourceLocation);
    }

    public final void stairsBlockWithRenderType(@NotNull StairBlock block2, @NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = name + "_stairs";
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.stairsBlockInternalWithRenderType(block2, string, side, bottom, top, resourceLocation);
    }

    public final void stairsBlockWithRenderType(@NotNull StairBlock block2, @NotNull ResourceLocation texture, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.stairsBlockWithRenderType(block2, texture, texture, texture, renderType);
    }

    public final void stairsBlockWithRenderType(@NotNull StairBlock block2, @NotNull String name, @NotNull ResourceLocation texture, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.stairsBlockWithRenderType(block2, name, texture, texture, texture, renderType);
    }

    public final void stairsBlockWithRenderType(@NotNull StairBlock block2, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.stairsBlockInternalWithRenderType(block2, string, side, bottom, top, renderType);
    }

    public final void stairsBlockWithRenderType(@NotNull StairBlock block2, @NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.stairsBlockInternalWithRenderType(block2, name + "_stairs", side, bottom, top, renderType);
    }

    private final void stairsBlockInternal(StairBlock block2, String baseName, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        ModelFile stairs = (ModelFile)this.models().stairs(baseName, side, bottom, top);
        ModelFile stairsInner = (ModelFile)this.models().stairsInner(baseName + "_inner", side, bottom, top);
        ModelFile stairsOuter = (ModelFile)this.models().stairsOuter(baseName + "_outer", side, bottom, top);
        this.stairsBlock(block2, stairs, stairsInner, stairsOuter);
    }

    private final void stairsBlockInternalWithRenderType(StairBlock block2, String baseName, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
        ModelFile stairs = (ModelFile)((BlockModelBuilder)this.models().stairs(baseName, side, bottom, top)).renderType(renderType);
        ModelFile stairsInner = (ModelFile)((BlockModelBuilder)this.models().stairsInner(baseName + "_inner", side, bottom, top)).renderType(renderType);
        ModelFile stairsOuter = (ModelFile)((BlockModelBuilder)this.models().stairsOuter(baseName + "_outer", side, bottom, top)).renderType(renderType);
        this.stairsBlock(block2, stairs, stairsInner, stairsOuter);
    }

    public final void stairsBlock(@NotNull StairBlock block2, @NotNull ModelFile stairs, @NotNull ModelFile stairsInner, @NotNull ModelFile stairsOuter) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)stairs, (String)"stairs");
        Intrinsics.checkNotNullParameter((Object)stairsInner, (String)"stairsInner");
        Intrinsics.checkNotNullParameter((Object)stairsOuter, (String)"stairsOuter");
        VariantBlockStateBuilder variantBlockStateBuilder = this.getVariantBuilder((Block)block2);
        Function<BlockState, ConfiguredModel[]> function = arg_0 -> BlockStateProvider.stairsBlock$lambda$0(stairs, stairsInner, stairsOuter, arg_0);
        Property[] propertyArray = new Property[1];
        Intrinsics.checkNotNullExpressionValue((Object)StairBlock.WATERLOGGED, (String)"WATERLOGGED");
        variantBlockStateBuilder.forAllStatesExcept(function, propertyArray);
    }

    public final void slabBlock(@NotNull SlabBlock block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.slabBlock(block2, texture, texture, texture, texture);
    }

    public final void slabBlock(@NotNull SlabBlock block2, @NotNull ResourceLocation doubleTexture, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)doubleTexture, (String)"doubleTexture");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        this.slabBlock(block2, (ModelFile)this.models().slab(this.name((Block)block2), side, bottom, top), (ModelFile)this.models().slabTop(this.name((Block)block2) + "_top", side, bottom, top), (ModelFile)this.models().cubeAll(this.name((Block)block2) + "_double", doubleTexture));
    }

    public final void slabBlock(@NotNull SlabBlock block2, @NotNull ModelFile bottom, @NotNull ModelFile top, @NotNull ModelFile modelFile) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)modelFile, (String)"double");
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate = this.getVariantBuilder((Block)block2).partialState();
        EnumProperty enumProperty = SlabBlock.TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)enumProperty, (String)"TYPE");
        ConfiguredModel[] configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(bottom, 0, 0, false, 0, 30, null)};
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate2 = partialBlockstate.with((Property)enumProperty, (Comparable)SlabType.BOTTOM).addModels(configuredModelArray).partialState();
        EnumProperty enumProperty2 = SlabBlock.TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)enumProperty2, (String)"TYPE");
        configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(top, 0, 0, false, 0, 30, null)};
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate3 = partialBlockstate2.with((Property)enumProperty2, (Comparable)SlabType.TOP).addModels(configuredModelArray).partialState();
        EnumProperty enumProperty3 = SlabBlock.TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)enumProperty3, (String)"TYPE");
        configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(modelFile, 0, 0, false, 0, 30, null)};
        partialBlockstate3.with((Property)enumProperty3, (Comparable)SlabType.DOUBLE).addModels(configuredModelArray);
    }

    public final void verticalSlabBlock(@NotNull VerticalSlabBlock block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)((Object)block2), (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.verticalSlabBlock(block2, texture, texture, texture, texture);
    }

    public final void verticalSlabBlock(@NotNull VerticalSlabBlock block2, @NotNull ResourceLocation doubleTexture, @NotNull ResourceLocation side, @NotNull ResourceLocation left, @NotNull ResourceLocation right) {
        Intrinsics.checkNotNullParameter((Object)((Object)block2), (String)"block");
        Intrinsics.checkNotNullParameter((Object)doubleTexture, (String)"doubleTexture");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)left, (String)"left");
        Intrinsics.checkNotNullParameter((Object)right, (String)"right");
        this.verticalSlabBlock(block2, (ModelFile)this.models().verticalSlab(this.name(block2), side, left, right), (ModelFile)this.models().verticalSlabRight(this.name(block2) + "_right", side, left, right), (ModelFile)this.models().cubeAll(this.name(block2) + "_double", doubleTexture));
    }

    public final void verticalSlabBlock(@NotNull VerticalSlabBlock block2, @NotNull ModelFile right, @NotNull ModelFile left, @NotNull ModelFile modelFile) {
        Intrinsics.checkNotNullParameter((Object)((Object)block2), (String)"block");
        Intrinsics.checkNotNullParameter((Object)right, (String)"right");
        Intrinsics.checkNotNullParameter((Object)left, (String)"left");
        Intrinsics.checkNotNullParameter((Object)modelFile, (String)"double");
        ConfiguredModel[] configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(left, 0, 0, false, 0, 30, null)};
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate = this.getVariantBuilder(block2).partialState().with((Property)VerticalSlabBlock.Companion.getTYPE(), (Comparable)((Object)VerticalSlabType.LEFT)).addModels(configuredModelArray).partialState().with((Property)VerticalSlabBlock.Companion.getTYPE(), (Comparable)((Object)VerticalSlabType.RIGHT));
        configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(right, 0, 0, false, 0, 30, null)};
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate2 = partialBlockstate.addModels(configuredModelArray).partialState().with((Property)VerticalSlabBlock.Companion.getTYPE(), (Comparable)((Object)VerticalSlabType.DOUBLE));
        configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(modelFile, 0, 0, false, 0, 30, null)};
        partialBlockstate2.addModels(configuredModelArray);
    }

    public final void buttonBlock(@NotNull ButtonBlock block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        ModelFile button = (ModelFile)this.models().button(this.name((Block)block2), texture);
        ModelFile buttonPressed = (ModelFile)this.models().buttonPressed(this.name((Block)block2) + "_pressed", texture);
        this.buttonBlock(block2, button, buttonPressed);
    }

    public final void buttonBlock(@NotNull ButtonBlock block2, @NotNull ModelFile button, @NotNull ModelFile buttonPressed) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)button, (String)"button");
        Intrinsics.checkNotNullParameter((Object)buttonPressed, (String)"buttonPressed");
        this.getVariantBuilder((Block)block2).forAllStates(arg_0 -> BlockStateProvider.buttonBlock$lambda$0(buttonPressed, button, arg_0));
    }

    public final void pressurePlateBlock(@NotNull PressurePlateBlock block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        ModelFile pressurePlate = (ModelFile)this.models().pressurePlate(this.name((Block)block2), texture);
        ModelFile pressurePlateDown = (ModelFile)this.models().pressurePlateDown(this.name((Block)block2) + "_down", texture);
        this.pressurePlateBlock(block2, pressurePlate, pressurePlateDown);
    }

    public final void pressurePlateBlock(@NotNull PressurePlateBlock block2, @NotNull ModelFile pressurePlate, @NotNull ModelFile pressurePlateDown) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)pressurePlate, (String)"pressurePlate");
        Intrinsics.checkNotNullParameter((Object)pressurePlateDown, (String)"pressurePlateDown");
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate = this.getVariantBuilder((Block)block2).partialState();
        BooleanProperty booleanProperty = PressurePlateBlock.POWERED;
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty, (String)"POWERED");
        ConfiguredModel[] configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(pressurePlateDown, 0, 0, false, 0, 30, null)};
        VariantBlockStateBuilder.PartialBlockstate partialBlockstate2 = partialBlockstate.with((Property)booleanProperty, true).addModels(configuredModelArray).partialState();
        BooleanProperty booleanProperty2 = PressurePlateBlock.POWERED;
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty2, (String)"POWERED");
        configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(pressurePlate, 0, 0, false, 0, 30, null)};
        partialBlockstate2.with((Property)booleanProperty2, false).addModels(configuredModelArray);
    }

    public final void signBlock(@NotNull StandingSignBlock signBlock, @NotNull WallSignBlock wallSignBlock, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)signBlock, (String)"signBlock");
        Intrinsics.checkNotNullParameter((Object)wallSignBlock, (String)"wallSignBlock");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        ModelFile sign = (ModelFile)this.models().sign(this.name((Block)signBlock), texture);
        this.signBlock(signBlock, wallSignBlock, sign);
    }

    public final void signBlock(@NotNull StandingSignBlock signBlock, @NotNull WallSignBlock wallSignBlock, @NotNull ModelFile sign) {
        Intrinsics.checkNotNullParameter((Object)signBlock, (String)"signBlock");
        Intrinsics.checkNotNullParameter((Object)wallSignBlock, (String)"wallSignBlock");
        Intrinsics.checkNotNullParameter((Object)sign, (String)"sign");
        this.simpleBlock((Block)signBlock, sign);
        this.simpleBlock((Block)wallSignBlock, sign);
    }

    public final void hangingSignBlock(@NotNull CeilingHangingSignBlock hangingSignBlock, @NotNull WallHangingSignBlock wallHangingSignBlock, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)hangingSignBlock, (String)"hangingSignBlock");
        Intrinsics.checkNotNullParameter((Object)wallHangingSignBlock, (String)"wallHangingSignBlock");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        ModelFile hangingSign = (ModelFile)this.models().sign(this.name((Block)hangingSignBlock), texture);
        this.hangingSignBlock(hangingSignBlock, wallHangingSignBlock, hangingSign);
    }

    public final void hangingSignBlock(@NotNull CeilingHangingSignBlock hangingSignBlock, @NotNull WallHangingSignBlock wallHangingSignBlock, @NotNull ModelFile hangingSign) {
        Intrinsics.checkNotNullParameter((Object)hangingSignBlock, (String)"hangingSignBlock");
        Intrinsics.checkNotNullParameter((Object)wallHangingSignBlock, (String)"wallHangingSignBlock");
        Intrinsics.checkNotNullParameter((Object)hangingSign, (String)"hangingSign");
        this.simpleBlock((Block)hangingSignBlock, hangingSign);
        this.simpleBlock((Block)wallHangingSignBlock, hangingSign);
    }

    public final void fourWayBlock(@NotNull CrossCollisionBlock block2, @NotNull ModelFile post, @NotNull ModelFile side) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)post, (String)"post");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder((Block)block2).part().modelFile(post).addModel().end();
        this.fourWayMultipart(builder, side);
    }

    public final void fourWayMultipart(@NotNull MultiPartBlockStateBuilder builder, @NotNull ModelFile side) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        PipeBlock.PROPERTY_BY_DIRECTION.entrySet().forEach(arg_0 -> BlockStateProvider.fourWayMultipart$lambda$0(builder, side, arg_0));
    }

    public final void fenceBlock(@NotNull FenceBlock block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String baseName = string;
        this.fourWayBlock((CrossCollisionBlock)block2, (ModelFile)this.models().fencePost(baseName + "_post", texture), (ModelFile)this.models().fenceSide(baseName + "_side", texture));
    }

    public final void fenceBlock(@NotNull FenceBlock block2, @NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.fourWayBlock((CrossCollisionBlock)block2, (ModelFile)this.models().fencePost(name + "_fence_post", texture), (ModelFile)this.models().fenceSide(name + "_fence_side", texture));
    }

    public final void fenceBlockWithRenderType(@NotNull FenceBlock block2, @NotNull ResourceLocation texture, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String baseName = string;
        this.fourWayBlock((CrossCollisionBlock)block2, (ModelFile)((BlockModelBuilder)this.models().fencePost(baseName + "_post", texture)).renderType(renderType), (ModelFile)((BlockModelBuilder)this.models().fenceSide(baseName + "_side", texture)).renderType(renderType));
    }

    public final void fenceBlockWithRenderType(@NotNull FenceBlock block2, @NotNull String name, @NotNull ResourceLocation texture, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.fourWayBlock((CrossCollisionBlock)block2, (ModelFile)((BlockModelBuilder)this.models().fencePost(name + "_fence_post", texture)).renderType(renderType), (ModelFile)((BlockModelBuilder)this.models().fenceSide(name + "_fence_side", texture)).renderType(renderType));
    }

    public final void fenceBlockWithRenderType(@NotNull FenceBlock block2, @NotNull ResourceLocation texture, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String baseName = string;
        this.fourWayBlock((CrossCollisionBlock)block2, (ModelFile)((BlockModelBuilder)this.models().fencePost(baseName + "_post", texture)).renderType(renderType), (ModelFile)((BlockModelBuilder)this.models().fenceSide(baseName + "_side", texture)).renderType(renderType));
    }

    public final void fenceBlockWithRenderType(@NotNull FenceBlock block2, @NotNull String name, @NotNull ResourceLocation texture, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.fourWayBlock((CrossCollisionBlock)block2, (ModelFile)((BlockModelBuilder)this.models().fencePost(name + "_fence_post", texture)).renderType(renderType), (ModelFile)((BlockModelBuilder)this.models().fenceSide(name + "_fence_side", texture)).renderType(renderType));
    }

    public final void fenceGateBlock(@NotNull FenceGateBlock block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.fenceGateBlockInternal(block2, string, texture);
    }

    public final void fenceGateBlock(@NotNull FenceGateBlock block2, @NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.fenceGateBlockInternal(block2, name + "_fence_gate", texture);
    }

    public final void fenceGateBlockWithRenderType(@NotNull FenceGateBlock block2, @NotNull ResourceLocation texture, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.fenceGateBlockInternalWithRenderType(block2, string, texture, resourceLocation);
    }

    public final void fenceGateBlockWithRenderType(@NotNull FenceGateBlock block2, @NotNull String name, @NotNull ResourceLocation texture, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = name + "_fence_gate";
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.fenceGateBlockInternalWithRenderType(block2, string, texture, resourceLocation);
    }

    public final void fenceGateBlockWithRenderType(@NotNull FenceGateBlock block2, @NotNull ResourceLocation texture, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.fenceGateBlockInternalWithRenderType(block2, string, texture, renderType);
    }

    public final void fenceGateBlockWithRenderType(@NotNull FenceGateBlock block2, @NotNull String name, @NotNull ResourceLocation texture, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.fenceGateBlockInternalWithRenderType(block2, name + "_fence_gate", texture, renderType);
    }

    private final void fenceGateBlockInternal(FenceGateBlock block2, String baseName, ResourceLocation texture) {
        ModelFile gate = (ModelFile)this.models().fenceGate(baseName, texture);
        ModelFile gateOpen = (ModelFile)this.models().fenceGateOpen(baseName + "_open", texture);
        ModelFile gateWall = (ModelFile)this.models().fenceGateWall(baseName + "_wall", texture);
        ModelFile gateWallOpen = (ModelFile)this.models().fenceGateWallOpen(baseName + "_wall_open", texture);
        this.fenceGateBlock(block2, gate, gateOpen, gateWall, gateWallOpen);
    }

    private final void fenceGateBlockInternalWithRenderType(FenceGateBlock block2, String baseName, ResourceLocation texture, ResourceLocation renderType) {
        ModelFile gate = (ModelFile)((BlockModelBuilder)this.models().fenceGate(baseName, texture)).renderType(renderType);
        ModelFile gateOpen = (ModelFile)((BlockModelBuilder)this.models().fenceGateOpen(baseName + "_open", texture)).renderType(renderType);
        ModelFile gateWall = (ModelFile)((BlockModelBuilder)this.models().fenceGateWall(baseName + "_wall", texture)).renderType(renderType);
        ModelFile gateWallOpen = (ModelFile)((BlockModelBuilder)this.models().fenceGateWallOpen(baseName + "_wall_open", texture)).renderType(renderType);
        this.fenceGateBlock(block2, gate, gateOpen, gateWall, gateWallOpen);
    }

    public final void fenceGateBlock(@NotNull FenceGateBlock block2, @NotNull ModelFile gate, @NotNull ModelFile gateOpen, @NotNull ModelFile gateWall, @NotNull ModelFile gateWallOpen) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)gate, (String)"gate");
        Intrinsics.checkNotNullParameter((Object)gateOpen, (String)"gateOpen");
        Intrinsics.checkNotNullParameter((Object)gateWall, (String)"gateWall");
        Intrinsics.checkNotNullParameter((Object)gateWallOpen, (String)"gateWallOpen");
        VariantBlockStateBuilder variantBlockStateBuilder = this.getVariantBuilder((Block)block2);
        Function<BlockState, ConfiguredModel[]> function = arg_0 -> BlockStateProvider.fenceGateBlock$lambda$0(gate, gateWall, gateWallOpen, gateOpen, arg_0);
        Property[] propertyArray = new Property[1];
        Intrinsics.checkNotNullExpressionValue((Object)FenceGateBlock.POWERED, (String)"POWERED");
        variantBlockStateBuilder.forAllStatesExcept(function, propertyArray);
    }

    public final void wallBlock(@NotNull WallBlock block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.wallBlockInternal(block2, string, texture);
    }

    public final void wallBlock(@NotNull WallBlock block2, @NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.wallBlockInternal(block2, name + "_wall", texture);
    }

    public final void wallBlockWithRenderType(@NotNull WallBlock block2, @NotNull ResourceLocation texture, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.wallBlockInternalWithRenderType(block2, string, texture, resourceLocation);
    }

    public final void wallBlockWithRenderType(@NotNull WallBlock block2, @NotNull String name, @NotNull ResourceLocation texture, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = name + "_wall";
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.wallBlockInternalWithRenderType(block2, string, texture, resourceLocation);
    }

    public final void wallBlockWithRenderType(@NotNull WallBlock block2, @NotNull ResourceLocation texture, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.wallBlockInternalWithRenderType(block2, string, texture, renderType);
    }

    public final void wallBlockWithRenderType(@NotNull WallBlock block2, @NotNull String name, @NotNull ResourceLocation texture, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.wallBlockInternalWithRenderType(block2, name + "_wall", texture, renderType);
    }

    private final void wallBlockInternal(WallBlock block2, String baseName, ResourceLocation texture) {
        this.wallBlock(block2, (ModelFile)this.models().wallPost(baseName + "_post", texture), (ModelFile)this.models().wallSide(baseName + "_side", texture), (ModelFile)this.models().wallSideTall(baseName + "_side_tall", texture));
    }

    private final void wallBlockInternalWithRenderType(WallBlock block2, String baseName, ResourceLocation texture, ResourceLocation renderType) {
        this.wallBlock(block2, (ModelFile)((BlockModelBuilder)this.models().wallPost(baseName + "_post", texture)).renderType(renderType), (ModelFile)((BlockModelBuilder)this.models().wallSide(baseName + "_side", texture)).renderType(renderType), (ModelFile)((BlockModelBuilder)this.models().wallSideTall(baseName + "_side_tall", texture)).renderType(renderType));
    }

    public final void wallBlock(@NotNull WallBlock block2, @NotNull ModelFile post, @NotNull ModelFile side, @NotNull ModelFile sideTall) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)post, (String)"post");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)sideTall, (String)"sideTall");
        BooleanProperty booleanProperty = WallBlock.UP;
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty, (String)"UP");
        Boolean[] booleanArray = new Boolean[]{true};
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder((Block)block2).part().modelFile(post).addModel().condition((Property)booleanProperty, booleanArray).end();
        ((ImmutableSet)WALL_PROPS.entrySet()).stream().filter(arg_0 -> BlockStateProvider.wallBlock$lambda$1(BlockStateProvider::wallBlock$lambda$0, arg_0)).forEach(arg_0 -> BlockStateProvider.wallBlock$lambda$3(arg_0 -> BlockStateProvider.wallBlock$lambda$2(this, builder, side, sideTall, arg_0), arg_0));
    }

    private final void wallSidePart(MultiPartBlockStateBuilder builder, ModelFile model, Map.Entry<Direction, Property<WallSide>> entry, WallSide height) {
        WallSide[] wallSideArray = new WallSide[]{height};
        builder.part().modelFile(model).rotationY(((int)entry.getKey().toYRot() + 180) % 360).uvLock(true).addModel().condition(entry.getValue(), (Comparable[])wallSideArray);
    }

    public final void paneBlock(@NotNull IronBarsBlock block2, @NotNull ResourceLocation pane, @NotNull ResourceLocation edge) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.paneBlockInternal(block2, string, pane, edge);
    }

    public final void paneBlock(@NotNull IronBarsBlock block2, @NotNull String name, @NotNull ResourceLocation pane, @NotNull ResourceLocation edge) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        this.paneBlockInternal(block2, name + "_pane", pane, edge);
    }

    public final void paneBlockWithRenderType(@NotNull IronBarsBlock block2, @NotNull ResourceLocation pane, @NotNull ResourceLocation edge, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.paneBlockInternalWithRenderType(block2, string, pane, edge, resourceLocation);
    }

    public final void paneBlockWithRenderType(@NotNull IronBarsBlock block2, @NotNull String name, @NotNull ResourceLocation pane, @NotNull ResourceLocation edge, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = name + "_pane";
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.paneBlockInternalWithRenderType(block2, string, pane, edge, resourceLocation);
    }

    public final void paneBlockWithRenderType(@NotNull IronBarsBlock block2, @NotNull ResourceLocation pane, @NotNull ResourceLocation edge, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.paneBlockInternalWithRenderType(block2, string, pane, edge, renderType);
    }

    public final void paneBlockWithRenderType(@NotNull IronBarsBlock block2, @NotNull String name, @NotNull ResourceLocation pane, @NotNull ResourceLocation edge, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.paneBlockInternalWithRenderType(block2, name + "_pane", pane, edge, renderType);
    }

    private final void paneBlockInternal(IronBarsBlock block2, String baseName, ResourceLocation pane, ResourceLocation edge) {
        ModelFile post = (ModelFile)this.models().panePost(baseName + "_post", pane, edge);
        ModelFile side = (ModelFile)this.models().paneSide(baseName + "_side", pane, edge);
        ModelFile sideAlt = (ModelFile)this.models().paneSideAlt(baseName + "_side_alt", pane, edge);
        ModelFile noSide = (ModelFile)this.models().paneNoSide(baseName + "_noside", pane);
        ModelFile noSideAlt = (ModelFile)this.models().paneNoSideAlt(baseName + "_noside_alt", pane);
        this.paneBlock(block2, post, side, sideAlt, noSide, noSideAlt);
    }

    private final void paneBlockInternalWithRenderType(IronBarsBlock block2, String baseName, ResourceLocation pane, ResourceLocation edge, ResourceLocation renderType) {
        ModelFile post = (ModelFile)((BlockModelBuilder)this.models().panePost(baseName + "_post", pane, edge)).renderType(renderType);
        ModelFile side = (ModelFile)((BlockModelBuilder)this.models().paneSide(baseName + "_side", pane, edge)).renderType(renderType);
        ModelFile sideAlt = (ModelFile)((BlockModelBuilder)this.models().paneSideAlt(baseName + "_side_alt", pane, edge)).renderType(renderType);
        ModelFile noSide = (ModelFile)((BlockModelBuilder)this.models().paneNoSide(baseName + "_noside", pane)).renderType(renderType);
        ModelFile noSideAlt = (ModelFile)((BlockModelBuilder)this.models().paneNoSideAlt(baseName + "_noside_alt", pane)).renderType(renderType);
        this.paneBlock(block2, post, side, sideAlt, noSide, noSideAlt);
    }

    public final void paneBlock(@NotNull IronBarsBlock block2, @NotNull ModelFile post, @NotNull ModelFile side, @NotNull ModelFile sideAlt, @NotNull ModelFile noSide, @NotNull ModelFile noSideAlt) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)post, (String)"post");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)sideAlt, (String)"sideAlt");
        Intrinsics.checkNotNullParameter((Object)noSide, (String)"noSide");
        Intrinsics.checkNotNullParameter((Object)noSideAlt, (String)"noSideAlt");
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder((Block)block2).part().modelFile(post).addModel().end();
        Iterable $this$forEach$iv = PipeBlock.PROPERTY_BY_DIRECTION.entrySet();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry e = (Map.Entry)element$iv;
            boolean bl = false;
            Direction dir = (Direction)e.getKey();
            if (!dir.getAxis().isHorizontal()) continue;
            boolean alt = dir == Direction.SOUTH;
            ConfiguredModel.Builder<MultiPartBlockStateBuilder.PartBuilder> builder2 = builder.part().modelFile(alt || dir == Direction.WEST ? sideAlt : side);
            int n = dir.getAxis() == Direction.Axis.X ? 90 : 0;
            Object v = e.getValue();
            Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
            Boolean[] booleanArray = new Boolean[]{true};
            ConfiguredModel.Builder<MultiPartBlockStateBuilder.PartBuilder> builder3 = builder2.rotationY(n).addModel().condition((Property)v, booleanArray).end().part().modelFile(alt || dir == Direction.EAST ? noSideAlt : noSide);
            int n2 = dir == Direction.WEST ? 270 : (dir == Direction.SOUTH ? 90 : 0);
            Object v2 = e.getValue();
            Intrinsics.checkNotNullExpressionValue(v2, (String)"<get-value>(...)");
            booleanArray = new Boolean[]{false};
            builder3.rotationY(n2).addModel().condition((Property)v2, booleanArray);
        }
    }

    public final void doorBlock(@NotNull DoorBlock block2, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.doorBlockInternal(block2, string, bottom, top);
    }

    public final void doorBlock(@NotNull DoorBlock block2, @NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        this.doorBlockInternal(block2, name + "_door", bottom, top);
    }

    public final void doorBlockWithRenderType(@NotNull DoorBlock block2, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.doorBlockInternalWithRenderType(block2, string, bottom, top, resourceLocation);
    }

    public final void doorBlockWithRenderType(@NotNull DoorBlock block2, @NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = name + "_door";
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.doorBlockInternalWithRenderType(block2, string, bottom, top, resourceLocation);
    }

    public final void doorBlockWithRenderType(@NotNull DoorBlock block2, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.doorBlockInternalWithRenderType(block2, string, bottom, top, renderType);
    }

    public final void doorBlockWithRenderType(@NotNull DoorBlock block2, @NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.doorBlockInternalWithRenderType(block2, name + "_door", bottom, top, renderType);
    }

    private final void doorBlockInternal(DoorBlock block2, String baseName, ResourceLocation bottom, ResourceLocation top) {
        ModelFile bottomLeft = (ModelFile)this.models().doorBottomLeft(baseName + "_bottom_left", bottom, top);
        ModelFile bottomLeftOpen = (ModelFile)this.models().doorBottomLeftOpen(baseName + "_bottom_left_open", bottom, top);
        ModelFile bottomRight = (ModelFile)this.models().doorBottomRight(baseName + "_bottom_right", bottom, top);
        ModelFile bottomRightOpen = (ModelFile)this.models().doorBottomRightOpen(baseName + "_bottom_right_open", bottom, top);
        ModelFile topLeft = (ModelFile)this.models().doorTopLeft(baseName + "_top_left", bottom, top);
        ModelFile topLeftOpen = (ModelFile)this.models().doorTopLeftOpen(baseName + "_top_left_open", bottom, top);
        ModelFile topRight = (ModelFile)this.models().doorTopRight(baseName + "_top_right", bottom, top);
        ModelFile topRightOpen = (ModelFile)this.models().doorTopRightOpen(baseName + "_top_right_open", bottom, top);
        this.doorBlock(block2, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen);
    }

    private final void doorBlockInternalWithRenderType(DoorBlock block2, String baseName, ResourceLocation bottom, ResourceLocation top, ResourceLocation renderType) {
        ModelFile bottomLeft = (ModelFile)((BlockModelBuilder)this.models().doorBottomLeft(baseName + "_bottom_left", bottom, top)).renderType(renderType);
        ModelFile bottomLeftOpen = (ModelFile)((BlockModelBuilder)this.models().doorBottomLeftOpen(baseName + "_bottom_left_open", bottom, top)).renderType(renderType);
        ModelFile bottomRight = (ModelFile)((BlockModelBuilder)this.models().doorBottomRight(baseName + "_bottom_right", bottom, top)).renderType(renderType);
        ModelFile bottomRightOpen = (ModelFile)((BlockModelBuilder)this.models().doorBottomRightOpen(baseName + "_bottom_right_open", bottom, top)).renderType(renderType);
        ModelFile topLeft = (ModelFile)((BlockModelBuilder)this.models().doorTopLeft(baseName + "_top_left", bottom, top)).renderType(renderType);
        ModelFile topLeftOpen = (ModelFile)((BlockModelBuilder)this.models().doorTopLeftOpen(baseName + "_top_left_open", bottom, top)).renderType(renderType);
        ModelFile topRight = (ModelFile)((BlockModelBuilder)this.models().doorTopRight(baseName + "_top_right", bottom, top)).renderType(renderType);
        ModelFile topRightOpen = (ModelFile)((BlockModelBuilder)this.models().doorTopRightOpen(baseName + "_top_right_open", bottom, top)).renderType(renderType);
        this.doorBlock(block2, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen);
    }

    public final void doorBlock(@NotNull DoorBlock block2, @NotNull ModelFile bottomLeft, @NotNull ModelFile bottomLeftOpen, @NotNull ModelFile bottomRight, @NotNull ModelFile bottomRightOpen, @NotNull ModelFile topLeft, @NotNull ModelFile topLeftOpen, @NotNull ModelFile topRight, @NotNull ModelFile topRightOpen) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)bottomLeft, (String)"bottomLeft");
        Intrinsics.checkNotNullParameter((Object)bottomLeftOpen, (String)"bottomLeftOpen");
        Intrinsics.checkNotNullParameter((Object)bottomRight, (String)"bottomRight");
        Intrinsics.checkNotNullParameter((Object)bottomRightOpen, (String)"bottomRightOpen");
        Intrinsics.checkNotNullParameter((Object)topLeft, (String)"topLeft");
        Intrinsics.checkNotNullParameter((Object)topLeftOpen, (String)"topLeftOpen");
        Intrinsics.checkNotNullParameter((Object)topRight, (String)"topRight");
        Intrinsics.checkNotNullParameter((Object)topRightOpen, (String)"topRightOpen");
        VariantBlockStateBuilder variantBlockStateBuilder = this.getVariantBuilder((Block)block2);
        Function<BlockState, ConfiguredModel[]> function = arg_0 -> BlockStateProvider.doorBlock$lambda$0(bottomRightOpen, bottomLeftOpen, bottomRight, bottomLeft, topRightOpen, topLeftOpen, topRight, topLeft, arg_0);
        Property[] propertyArray = new Property[1];
        Intrinsics.checkNotNullExpressionValue((Object)DoorBlock.POWERED, (String)"POWERED");
        variantBlockStateBuilder.forAllStatesExcept(function, propertyArray);
    }

    public final void trapdoorBlock(@NotNull TrapDoorBlock block2, @NotNull ResourceLocation texture, boolean orientable) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.trapdoorBlockInternal(block2, string, texture, orientable);
    }

    public final void trapdoorBlock(@NotNull TrapDoorBlock block2, @NotNull String name, @NotNull ResourceLocation texture, boolean orientable) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.trapdoorBlockInternal(block2, name + "_trapdoor", texture, orientable);
    }

    public final void trapdoorBlockWithRenderType(@NotNull TrapDoorBlock block2, @NotNull ResourceLocation texture, boolean orientable, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.trapdoorBlockInternalWithRenderType(block2, string, texture, orientable, resourceLocation);
    }

    public final void trapdoorBlockWithRenderType(@NotNull TrapDoorBlock block2, @NotNull String name, @NotNull ResourceLocation texture, boolean orientable, @NotNull String renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = name + "_trapdoor";
        ResourceLocation resourceLocation = ResourceLocation.tryParse((String)renderType);
        Intrinsics.checkNotNull((Object)resourceLocation);
        this.trapdoorBlockInternalWithRenderType(block2, string, texture, orientable, resourceLocation);
    }

    public final void trapdoorBlockWithRenderType(@NotNull TrapDoorBlock block2, @NotNull ResourceLocation texture, boolean orientable, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        String string = this.key((Block)block2).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        this.trapdoorBlockInternalWithRenderType(block2, string, texture, orientable, renderType);
    }

    public final void trapdoorBlockWithRenderType(@NotNull TrapDoorBlock block2, @NotNull String name, @NotNull ResourceLocation texture, boolean orientable, @NotNull ResourceLocation renderType) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        Intrinsics.checkNotNullParameter((Object)renderType, (String)"renderType");
        this.trapdoorBlockInternalWithRenderType(block2, name + "_trapdoor", texture, orientable, renderType);
    }

    private final void trapdoorBlockInternal(TrapDoorBlock block2, String baseName, ResourceLocation texture, boolean orientable) {
        ModelFile bottom = orientable ? (ModelFile)this.models().trapdoorOrientableBottom(baseName + "_bottom", texture) : (ModelFile)this.models().trapdoorBottom(baseName + "_bottom", texture);
        ModelFile top = orientable ? (ModelFile)this.models().trapdoorOrientableTop(baseName + "_top", texture) : (ModelFile)this.models().trapdoorTop(baseName + "_top", texture);
        ModelFile open = orientable ? (ModelFile)this.models().trapdoorOrientableOpen(baseName + "_open", texture) : (ModelFile)this.models().trapdoorOpen(baseName + "_open", texture);
        this.trapdoorBlock(block2, bottom, top, open, orientable);
    }

    private final void trapdoorBlockInternalWithRenderType(TrapDoorBlock block2, String baseName, ResourceLocation texture, boolean orientable, ResourceLocation renderType) {
        ModelFile bottom = orientable ? (ModelFile)((BlockModelBuilder)this.models().trapdoorOrientableBottom(baseName + "_bottom", texture)).renderType(renderType) : (ModelFile)((BlockModelBuilder)this.models().trapdoorBottom(baseName + "_bottom", texture)).renderType(renderType);
        ModelFile top = orientable ? (ModelFile)((BlockModelBuilder)this.models().trapdoorOrientableTop(baseName + "_top", texture)).renderType(renderType) : (ModelFile)((BlockModelBuilder)this.models().trapdoorTop(baseName + "_top", texture)).renderType(renderType);
        ModelFile open = orientable ? (ModelFile)((BlockModelBuilder)this.models().trapdoorOrientableOpen(baseName + "_open", texture)).renderType(renderType) : (ModelFile)((BlockModelBuilder)this.models().trapdoorOpen(baseName + "_open", texture)).renderType(renderType);
        this.trapdoorBlock(block2, bottom, top, open, orientable);
    }

    public final void trapdoorBlock(@NotNull TrapDoorBlock block2, @NotNull ModelFile bottom, @NotNull ModelFile top, @NotNull ModelFile open, boolean orientable) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        Intrinsics.checkNotNullParameter((Object)open, (String)"open");
        VariantBlockStateBuilder variantBlockStateBuilder = this.getVariantBuilder((Block)block2);
        Function<BlockState, ConfiguredModel[]> function = arg_0 -> BlockStateProvider.trapdoorBlock$lambda$0(orientable, open, top, bottom, arg_0);
        Property[] propertyArray = new Property[2];
        Intrinsics.checkNotNullExpressionValue((Object)TrapDoorBlock.POWERED, (String)"POWERED");
        Intrinsics.checkNotNullExpressionValue((Object)TrapDoorBlock.WATERLOGGED, (String)"WATERLOGGED");
        variantBlockStateBuilder.forAllStatesExcept(function, propertyArray);
    }

    public final void crossBlock(@NotNull Block block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.crossBlock(block2, (ModelFile)((BlockModelBuilder)this.models().cross(this.name(block2), texture)).renderType("cutout"));
    }

    public final void crossBlock(@NotNull Block block2, @NotNull ModelFile model) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        ConfiguredModel[] configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(model, 0, 0, false, 0, 30, null)};
        this.getVariantBuilder(block2).partialState().addModels(configuredModelArray);
    }

    public final void pottedFlowerBlock(@NotNull Block block2, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        this.pottedFlowerBlock(block2, (ModelFile)((BlockModelBuilder)this.models().flowerPot(this.name(block2), texture)).renderType("cutout"));
    }

    public final void pottedFlowerBlock(@NotNull Block block2, @NotNull ModelFile model) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        ConfiguredModel[] configuredModelArray = new ConfiguredModel[]{new ConfiguredModel(model, 0, 0, false, 0, 30, null)};
        this.getVariantBuilder(block2).partialState().addModels(configuredModelArray);
    }

    private final CompletableFuture<?> saveBlockState(CachedOutput cache, JsonObject stateJson, Block owner) {
        ResourceLocation blockName = (ResourceLocation)Preconditions.checkNotNull((Object)this.key(owner));
        Path outputPath = this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(blockName.getNamespace()).resolve("blockstates").resolve(blockName.getPath() + ".json");
        CompletableFuture completableFuture = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)stateJson), (Path)outputPath);
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"saveStable(...)");
        return completableFuture;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Map<String, JsonElement> getStateJsons() {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this.registeredBlocks.entrySet();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Map.Entry entry = (Map.Entry)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(TuplesKt.to((Object)this.getStringPath((Block)it.getKey()), (Object)((IGeneratedBlockState)it.getValue()).toJson()));
        }
        Collection $this$toTypedArray$iv = (List)destination$iv$iv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Pair[] pairArray = thisCollection$iv.toArray(new Pair[0]);
        return MapsKt.mapOf((Pair[])Arrays.copyOf(pairArray, pairArray.length));
    }

    @NotNull
    protected final String getStringPath(@NotNull Block block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        ResourceLocation it = this.key(block2);
        boolean bl = false;
        return "assets/" + it.getNamespace() + "/blockstates/" + it.getPath() + ".json";
    }

    @NotNull
    public String getName() {
        return "Block States: " + this.id;
    }

    @JvmOverloads
    public final void simpleBlock(@NotNull Block block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        BlockStateProvider.simpleBlock$default(this, block2, null, 2, null);
    }

    @JvmOverloads
    public final void axisBlock(@NotNull RotatedPillarBlock block2) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        BlockStateProvider.axisBlock$default(this, block2, null, 2, null);
    }

    @JvmOverloads
    public final void horizontalBlock(@NotNull Block block2, @NotNull ModelFile model) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        BlockStateProvider.horizontalBlock$default(this, block2, model, 0, 4, null);
    }

    @JvmOverloads
    public final void horizontalBlock(@NotNull Block block2, @NotNull Function<BlockState, ModelFile> modelFunc) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter(modelFunc, (String)"modelFunc");
        BlockStateProvider.horizontalBlock$default(this, block2, modelFunc, 0, 4, null);
    }

    @JvmOverloads
    public final void horizontalFaceBlock(@NotNull Block block2, @NotNull ModelFile model) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        BlockStateProvider.horizontalFaceBlock$default(this, block2, model, 0, 4, null);
    }

    @JvmOverloads
    public final void horizontalFaceBlock(@NotNull Block block2, @NotNull Function<BlockState, ModelFile> modelFunc) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter(modelFunc, (String)"modelFunc");
        BlockStateProvider.horizontalFaceBlock$default(this, block2, modelFunc, 0, 4, null);
    }

    @JvmOverloads
    public final void directionalBlock(@NotNull Block block2, @NotNull ModelFile model) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter((Object)model, (String)"model");
        BlockStateProvider.directionalBlock$default(this, block2, model, 0, 4, null);
    }

    @JvmOverloads
    public final void directionalBlock(@NotNull Block block2, @NotNull Function<BlockState, ModelFile> modelFunc) {
        Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
        Intrinsics.checkNotNullParameter(modelFunc, (String)"modelFunc");
        BlockStateProvider.directionalBlock$default(this, block2, modelFunc, 0, 4, null);
    }

    private static final ModelFile horizontalBlock$lambda$0(ModelFile $model, BlockState it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return $model;
    }

    private static final ConfiguredModel[] horizontalBlock$lambda$1(Function $modelFunc, int $angleOffset, BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        ConfiguredModel.Builder<?> builder = ConfiguredModel.Companion.builder();
        Object r = $modelFunc.apply(state);
        Intrinsics.checkNotNullExpressionValue(r, (String)"apply(...)");
        return builder.modelFile((ModelFile)r).rotationY(((int)((Direction)state.getValue((Property)BlockStateProperties.HORIZONTAL_FACING)).toYRot() + $angleOffset) % 360).build();
    }

    private static final ModelFile horizontalFaceBlock$lambda$0(ModelFile $model, BlockState it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return $model;
    }

    private static final ConfiguredModel[] horizontalFaceBlock$lambda$1(Function $modelFunc, int $angleOffset, BlockState it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ConfiguredModel.Builder<?> builder = ConfiguredModel.Companion.builder();
        Object r = $modelFunc.apply(it);
        Intrinsics.checkNotNullExpressionValue(r, (String)"apply(...)");
        return builder.modelFile((ModelFile)r).rotationX(((AttachFace)it.getValue((Property)BlockStateProperties.ATTACH_FACE)).ordinal() * 90).rotationY(((int)((Direction)it.getValue((Property)BlockStateProperties.HORIZONTAL_FACING)).toYRot() + $angleOffset + (it.getValue((Property)BlockStateProperties.ATTACH_FACE) == AttachFace.CEILING ? 180 : 0)) % 360).build();
    }

    private static final ModelFile directionalBlock$lambda$0(ModelFile $model, BlockState it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return $model;
    }

    private static final ConfiguredModel[] directionalBlock$lambda$1(Function $modelFunc, int $angleOffset, BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Direction dir = (Direction)state.getValue((Property)BlockStateProperties.FACING);
        ConfiguredModel.Builder<?> builder = ConfiguredModel.Companion.builder();
        Object r = $modelFunc.apply(state);
        Intrinsics.checkNotNullExpressionValue(r, (String)"apply(...)");
        return builder.modelFile((ModelFile)r).rotationX(dir == Direction.DOWN ? 180 : (dir.getAxis().isHorizontal() ? 90 : 0)).rotationY(dir.getAxis().isVertical() ? 0 : ((int)dir.toYRot() + $angleOffset) % 360).build();
    }

    private static final ConfiguredModel[] stairsBlock$lambda$0(ModelFile $stairs, ModelFile $stairsInner, ModelFile $stairsOuter, BlockState it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Direction facing = (Direction)it.getValue((Property)StairBlock.FACING);
        Half half = (Half)it.getValue((Property)StairBlock.HALF);
        StairsShape shape = (StairsShape)it.getValue((Property)StairBlock.SHAPE);
        int yRot = (int)facing.getClockWise().toYRot();
        if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) {
            yRot += 270;
        }
        if (shape != StairsShape.STRAIGHT && half == Half.TOP) {
            yRot += 90;
        }
        boolean uvlock = (yRot %= 360) != 0 || half == Half.TOP;
        return ConfiguredModel.Companion.builder().modelFile(shape == StairsShape.STRAIGHT ? $stairs : (shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? $stairsInner : $stairsOuter)).rotationX(half == Half.BOTTOM ? 0 : 180).rotationY(yRot).uvLock(uvlock).build();
    }

    private static final ConfiguredModel[] buttonBlock$lambda$0(ModelFile $buttonPressed, ModelFile $button, BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Direction facing = (Direction)state.getValue((Property)ButtonBlock.FACING);
        AttachFace face2 = (AttachFace)state.getValue((Property)ButtonBlock.FACE);
        Boolean powered = (Boolean)state.getValue((Property)ButtonBlock.POWERED);
        return ConfiguredModel.Companion.builder().modelFile(powered != false ? $buttonPressed : $button).rotationX(face2 == AttachFace.FLOOR ? 0 : (face2 == AttachFace.WALL ? 90 : 180)).rotationY((int)(face2 == AttachFace.CEILING ? facing : facing.getOpposite()).toYRot()).uvLock(face2 == AttachFace.WALL).build();
    }

    private static final void fourWayMultipart$lambda$0(MultiPartBlockStateBuilder $builder, ModelFile $side, Map.Entry e) {
        Intrinsics.checkNotNullParameter((Object)e, (String)"e");
        Direction dir = (Direction)e.getKey();
        if (dir.getAxis().isHorizontal()) {
            Boolean[] booleanArray = new Boolean[]{true};
            $builder.part().modelFile($side).rotationY(((int)dir.toYRot() + 180) % 360).uvLock(true).addModel().condition((Property)e.getValue(), booleanArray);
        }
    }

    private static final ConfiguredModel[] fenceGateBlock$lambda$0(ModelFile $gate, ModelFile $gateWall, ModelFile $gateWallOpen, ModelFile $gateOpen, BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        ModelFile model = $gate;
        if (((Boolean)state.getValue((Property)FenceGateBlock.IN_WALL)).booleanValue()) {
            model = $gateWall;
        }
        if (((Boolean)state.getValue((Property)FenceGateBlock.OPEN)).booleanValue()) {
            model = model == $gateWall ? $gateWallOpen : $gateOpen;
        }
        return ConfiguredModel.Companion.builder().modelFile(model).rotationY((int)((Direction)state.getValue((Property)FenceGateBlock.FACING)).toYRot()).uvLock(true).build();
    }

    private static final boolean wallBlock$lambda$0(Map.Entry it) {
        return ((Direction)it.getKey()).getAxis().isHorizontal();
    }

    private static final boolean wallBlock$lambda$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final Unit wallBlock$lambda$2(BlockStateProvider this$0, MultiPartBlockStateBuilder $builder, ModelFile $side, ModelFile $sideTall, Map.Entry it) {
        Map.Entry entry = it;
        Intrinsics.checkNotNull((Object)entry);
        this$0.wallSidePart($builder, $side, entry, WallSide.LOW);
        this$0.wallSidePart($builder, $sideTall, it, WallSide.TALL);
        return Unit.INSTANCE;
    }

    private static final void wallBlock$lambda$3(Function1 $tmp0, Object p0) {
        $tmp0.invoke(p0);
    }

    private static final ConfiguredModel[] doorBlock$lambda$0(ModelFile $bottomRightOpen, ModelFile $bottomLeftOpen, ModelFile $bottomRight, ModelFile $bottomLeft, ModelFile $topRightOpen, ModelFile $topLeftOpen, ModelFile $topRight, ModelFile $topLeft, BlockState state) {
        boolean lower;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        int yRot = (int)((Direction)state.getValue((Property)DoorBlock.FACING)).toYRot() + 90;
        boolean right = state.getValue((Property)DoorBlock.HINGE) == DoorHingeSide.RIGHT;
        Boolean open = (Boolean)state.getValue((Property)DoorBlock.OPEN);
        boolean bl = lower = state.getValue((Property)DoorBlock.HALF) == DoubleBlockHalf.LOWER;
        if (open.booleanValue()) {
            yRot += 90;
        }
        if (right && open.booleanValue()) {
            yRot += 180;
        }
        yRot %= 360;
        ModelFile model = null;
        if (lower && right && open.booleanValue()) {
            model = $bottomRightOpen;
        } else if (lower && !right && open.booleanValue()) {
            model = $bottomLeftOpen;
        }
        if (lower && right && !open.booleanValue()) {
            model = $bottomRight;
        } else if (lower && !right && !open.booleanValue()) {
            model = $bottomLeft;
        }
        if (!lower && right && open.booleanValue()) {
            model = $topRightOpen;
        } else if (!lower && !right && open.booleanValue()) {
            model = $topLeftOpen;
        }
        if (!lower && right && !open.booleanValue()) {
            model = $topRight;
        } else if (!(lower || right || open.booleanValue())) {
            model = $topLeft;
        }
        ConfiguredModel.Builder<?> builder = ConfiguredModel.Companion.builder();
        ModelFile modelFile = model;
        Intrinsics.checkNotNull((Object)modelFile);
        return builder.modelFile(modelFile).rotationY(yRot).build();
    }

    private static final ConfiguredModel[] trapdoorBlock$lambda$0(boolean $orientable, ModelFile $open, ModelFile $top, ModelFile $bottom, BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        int xRot = 0;
        int yRot = (int)((Direction)state.getValue((Property)TrapDoorBlock.FACING)).toYRot() + 180;
        Boolean isOpen = (Boolean)state.getValue((Property)TrapDoorBlock.OPEN);
        if ($orientable && isOpen.booleanValue() && state.getValue((Property)TrapDoorBlock.HALF) == Half.TOP) {
            xRot += 180;
            yRot += 180;
        }
        if (!$orientable && !isOpen.booleanValue()) {
            yRot = 0;
        }
        return ConfiguredModel.Companion.builder().modelFile(isOpen != false ? $open : (state.getValue((Property)TrapDoorBlock.HALF) == Half.TOP ? $top : $bottom)).rotationX(xRot).rotationY(yRot %= 360).build();
    }

    static {
        Logger logger = LogManager.getLogger();
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        LOGGER = logger;
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        Intrinsics.checkNotNullExpressionValue((Object)gson, (String)"create(...)");
        GSON = gson;
        ImmutableMap immutableMap = ImmutableMap.builder().put((Object)Direction.EAST, (Object)BlockStateProperties.EAST_WALL).put((Object)Direction.NORTH, (Object)BlockStateProperties.NORTH_WALL).put((Object)Direction.SOUTH, (Object)BlockStateProperties.SOUTH_WALL).put((Object)Direction.WEST, (Object)BlockStateProperties.WEST_WALL).build();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"build(...)");
        WALL_PROPS = immutableMap;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider$Companion;", "", "<init>", "()V", "LOGGER", "Lorg/apache/logging/log4j/Logger;", "GSON", "Lcom/google/gson/Gson;", "DEFAULT_ANGLE_OFFSET", "", "WALL_PROPS", "Lcom/google/common/collect/ImmutableMap;", "Lnet/minecraft/core/Direction;", "Lnet/minecraft/world/level/block/state/properties/Property;", "Lnet/minecraft/world/level/block/state/properties/WallSide;", "getWALL_PROPS", "()Lcom/google/common/collect/ImmutableMap;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ImmutableMap<Direction, Property<WallSide>> getWALL_PROPS() {
            return WALL_PROPS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\bB\u001d\b\u0016\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\t\"\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u001f\u0010\r\u001a\u00020\u00002\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\t\"\u00020\u0004\u00a2\u0006\u0002\u0010\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider$ConfiguredModelList;", "", "models", "", "Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;", "<init>", "(Ljava/util/List;)V", "model", "(Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;)V", "", "([Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;)V", "toJSON", "Lcom/google/gson/JsonElement;", "append", "([Lcompat/net/neoforged/neoforge/client/model/generators/ConfiguredModel;)Lcompat/net/neoforged/neoforge/client/model/generators/BlockStateProvider$ConfiguredModelList;", "brokencore-common"})
    public static final class ConfiguredModelList {
        @NotNull
        private final List<ConfiguredModel> models;

        private ConfiguredModelList(List<ConfiguredModel> models) {
            Preconditions.checkArgument((!models.isEmpty() ? 1 : 0) != 0);
            this.models = models;
        }

        public ConfiguredModelList(@NotNull ConfiguredModel model) {
            Intrinsics.checkNotNullParameter((Object)model, (String)"model");
            ImmutableList immutableList = ImmutableList.of((Object)model);
            Intrinsics.checkNotNullExpressionValue((Object)immutableList, (String)"of(...)");
            this((List)immutableList);
        }

        public ConfiguredModelList(ConfiguredModel ... models) {
            Intrinsics.checkNotNullParameter((Object)models, (String)"models");
            this(CollectionsKt.mutableListOf((Object[])Arrays.copyOf(models, models.length)));
        }

        @NotNull
        public final JsonElement toJSON() {
            if (this.models.size() == 1) {
                return (JsonElement)this.models.get(0).toJSON(false);
            }
            JsonArray ret = new JsonArray();
            for (ConfiguredModel m : this.models) {
                ret.add((JsonElement)m.toJSON(true));
            }
            return (JsonElement)ret;
        }

        @NotNull
        public final ConfiguredModelList append(ConfiguredModel ... models) {
            Intrinsics.checkNotNullParameter((Object)models, (String)"models");
            ImmutableList immutableList = ImmutableList.builder().addAll((Iterable)this.models).add((Object[])Arrays.copyOf(models, models.length)).build();
            Intrinsics.checkNotNullExpressionValue((Object)immutableList, (String)"build(...)");
            return new ConfiguredModelList((List)immutableList);
        }
    }
}

