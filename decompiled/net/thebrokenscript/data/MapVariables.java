/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.TuplesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.saveddata.SavedData
 *  net.thebrokenscript.brokencore.api.ext.EndecExt
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.util.serde.KClassEndec
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.data;

import io.wispforest.endec.Endec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.thebrokenscript.brokencore.api.ext.EndecExt;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.util.serde.KClassEndec;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00c5\u00012\u00020\u0001:\u0002\u00c5\u0001B\u00c1\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0003\u0012\b\b\u0002\u0010*\u001a\u00020\u0003\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\b\b\u0002\u0010,\u001a\u00020\u0003\u0012\b\b\u0002\u0010-\u001a\u00020\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0003\u0012\b\b\u0002\u00100\u001a\u00020\u0005\u0012\b\b\u0002\u00101\u001a\u00020\u0005\u0012\b\b\u0002\u00102\u001a\u00020\u0003\u0012\b\b\u0002\u00103\u001a\u00020\u0005\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u0012\b\b\u0002\u00106\u001a\u00020\u0003\u0012\b\b\u0002\u00107\u001a\u00020\u0003\u0012\b\b\u0002\u00108\u001a\u00020\u0003\u0012\b\b\u0002\u00109\u001a\u00020\u0003\u0012\b\b\u0002\u0010:\u001a\u00020\u0003\u0012\b\b\u0002\u0010;\u001a\u00020\u0003\u0012\b\b\u0002\u0010<\u001a\u00020\u0003\u0012\b\b\u0002\u0010=\u001a\u00020\u0003\u0012\b\b\u0002\u0010>\u001a\u00020?\u00a2\u0006\u0004\b@\u0010AJ\u001e\u0010\u00bb\u0001\u001a\u00030\u00bc\u00012\b\u0010\u00bd\u0001\u001a\u00030\u00bc\u00012\b\u0010\u00be\u0001\u001a\u00030\u00bf\u0001H\u0016J\u0019\u0010\u00c0\u0001\u001a\u00030\u00c1\u00012\u000f\u0010\u00c2\u0001\u001a\n\u0012\u0005\u0012\u00030\u00c4\u00010\u00c3\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010G\"\u0004\bK\u0010IR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010G\"\u0004\bL\u0010IR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010G\"\u0004\bN\u0010IR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010G\"\u0004\bP\u0010IR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010G\"\u0004\bR\u0010IR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010G\"\u0004\bT\u0010IR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010G\"\u0004\bV\u0010IR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010G\"\u0004\b\\\u0010IR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010G\"\u0004\b^\u0010IR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010G\"\u0004\b`\u0010IR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010G\"\u0004\ba\u0010IR\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010X\"\u0004\bc\u0010ZR\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010G\"\u0004\be\u0010IR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010G\"\u0004\bg\u0010IR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010G\"\u0004\bi\u0010IR\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010C\"\u0004\bk\u0010ER\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010G\"\u0004\bm\u0010IR\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010C\"\u0004\bo\u0010ER\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010G\"\u0004\bq\u0010IR\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010C\"\u0004\bs\u0010ER\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010G\"\u0004\bu\u0010IR\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010G\"\u0004\bw\u0010IR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010G\"\u0004\bx\u0010IR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010G\"\u0004\bz\u0010IR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u0010G\"\u0004\b|\u0010IR\u001b\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010#\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010G\"\u0005\b\u0082\u0001\u0010IR\u001c\u0010$\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010C\"\u0005\b\u0084\u0001\u0010ER\u001c\u0010%\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010C\"\u0005\b\u0086\u0001\u0010ER\u001c\u0010&\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010C\"\u0005\b\u0088\u0001\u0010ER\u001c\u0010'\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010C\"\u0005\b\u008a\u0001\u0010ER\u001c\u0010(\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010C\"\u0005\b\u008c\u0001\u0010ER\u001c\u0010)\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010C\"\u0005\b\u008e\u0001\u0010ER\u001c\u0010*\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010C\"\u0005\b\u0090\u0001\u0010ER\u001c\u0010+\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010C\"\u0005\b\u0092\u0001\u0010ER\u001c\u0010,\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010C\"\u0005\b\u0094\u0001\u0010ER\u001c\u0010-\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010C\"\u0005\b\u0096\u0001\u0010ER\u001c\u0010.\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010C\"\u0005\b\u0098\u0001\u0010ER\u001c\u0010/\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010C\"\u0005\b\u009a\u0001\u0010ER\u001c\u00100\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010G\"\u0005\b\u009c\u0001\u0010IR\u001c\u00101\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010G\"\u0005\b\u009e\u0001\u0010IR\u001c\u00102\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010C\"\u0005\b\u00a0\u0001\u0010ER\u001c\u00103\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a1\u0001\u0010G\"\u0005\b\u00a2\u0001\u0010IR\u001c\u00104\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a3\u0001\u0010C\"\u0005\b\u00a4\u0001\u0010ER\u001c\u00105\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a5\u0001\u0010C\"\u0005\b\u00a6\u0001\u0010ER\u001c\u00106\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a7\u0001\u0010C\"\u0005\b\u00a8\u0001\u0010ER\u001c\u00107\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a9\u0001\u0010C\"\u0005\b\u00aa\u0001\u0010ER\u001c\u00108\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ab\u0001\u0010C\"\u0005\b\u00ac\u0001\u0010ER\u001c\u00109\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010C\"\u0005\b\u00ae\u0001\u0010ER\u001c\u0010:\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00af\u0001\u0010C\"\u0005\b\u00b0\u0001\u0010ER\u001c\u0010;\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b1\u0001\u0010C\"\u0005\b\u00b2\u0001\u0010ER\u001c\u0010<\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b3\u0001\u0010C\"\u0005\b\u00b4\u0001\u0010ER\u001c\u0010=\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b5\u0001\u0010C\"\u0005\b\u00b6\u0001\u0010ER\u001e\u0010>\u001a\u00020?X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001\"\u0006\b\u00b9\u0001\u0010\u00ba\u0001\u00a8\u0006\u00c6\u0001"}, d2={"Lnet/thebrokenscript/data/MapVariables;", "Lnet/minecraft/world/level/saveddata/SavedData;", "dataVersion", "", "hasNullSpawned", "", "hasSiluetSpawned", "isFirstJoin", "hasGeneratedNullDimension", "hasCircuitSpawned", "hasTheBrokenEndSpawned", "hasGeneratedClanBuildDimension", "daylightCycle", "daylightCycleEventTimer", "", "hasTriggeredRam2Die", "hasRam2DieJoined", "hasVoidSpawned", "isNullHere", "firstJoinTimer", "scheduled", "joinTimerTicking", "hasBuiltHerobrineShrine", "moonStage", "moonShouldChange", "moonTextureIndex", "moonShouldCrack", "moonCrackIndex", "soundPlayed", "hasMoonCorrupted", "isFlat", "fracturedFightActive", "canFracturedSpawn", "code", "", "codeApplied", "bossStructX", "bossStructZ", "clanVoidX", "clanVoidZ", "mazeFloorX", "mazeFloorZ", "woodenFloorX", "woodenFloorZ", "stoneFloorX", "stoneFloorZ", "dayAX", "dayAZ", "placedStructure", "craftedPolaroid", "inventoryCorruption", "inventoryCorruptionProgressed", "entitySpawnDelay", "circuitSpawnDelay", "oblitSpawnDelay", "tbeSpawnDelay", "rareSpawnDelay", "nullSpawnDelay", "curvedSpawnDelay", "eerieNoiseDelay", "herobrineDelay", "circuitInhabitedDelay", "commandBlockLocation", "Lnet/minecraft/core/BlockPos;", "<init>", "(IZZZZZZZZJZZZZJZZZIZIZIZZZZZLjava/lang/String;ZIIIIIIIIIIIIZZIZIIIIIIIIIILnet/minecraft/core/BlockPos;)V", "getDataVersion", "()I", "setDataVersion", "(I)V", "getHasNullSpawned", "()Z", "setHasNullSpawned", "(Z)V", "getHasSiluetSpawned", "setHasSiluetSpawned", "setFirstJoin", "getHasGeneratedNullDimension", "setHasGeneratedNullDimension", "getHasCircuitSpawned", "setHasCircuitSpawned", "getHasTheBrokenEndSpawned", "setHasTheBrokenEndSpawned", "getHasGeneratedClanBuildDimension", "setHasGeneratedClanBuildDimension", "getDaylightCycle", "setDaylightCycle", "getDaylightCycleEventTimer", "()J", "setDaylightCycleEventTimer", "(J)V", "getHasTriggeredRam2Die", "setHasTriggeredRam2Die", "getHasRam2DieJoined", "setHasRam2DieJoined", "getHasVoidSpawned", "setHasVoidSpawned", "setNullHere", "getFirstJoinTimer", "setFirstJoinTimer", "getScheduled", "setScheduled", "getJoinTimerTicking", "setJoinTimerTicking", "getHasBuiltHerobrineShrine", "setHasBuiltHerobrineShrine", "getMoonStage", "setMoonStage", "getMoonShouldChange", "setMoonShouldChange", "getMoonTextureIndex", "setMoonTextureIndex", "getMoonShouldCrack", "setMoonShouldCrack", "getMoonCrackIndex", "setMoonCrackIndex", "getSoundPlayed", "setSoundPlayed", "getHasMoonCorrupted", "setHasMoonCorrupted", "setFlat", "getFracturedFightActive", "setFracturedFightActive", "getCanFracturedSpawn", "setCanFracturedSpawn", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getCodeApplied", "setCodeApplied", "getBossStructX", "setBossStructX", "getBossStructZ", "setBossStructZ", "getClanVoidX", "setClanVoidX", "getClanVoidZ", "setClanVoidZ", "getMazeFloorX", "setMazeFloorX", "getMazeFloorZ", "setMazeFloorZ", "getWoodenFloorX", "setWoodenFloorX", "getWoodenFloorZ", "setWoodenFloorZ", "getStoneFloorX", "setStoneFloorX", "getStoneFloorZ", "setStoneFloorZ", "getDayAX", "setDayAX", "getDayAZ", "setDayAZ", "getPlacedStructure", "setPlacedStructure", "getCraftedPolaroid", "setCraftedPolaroid", "getInventoryCorruption", "setInventoryCorruption", "getInventoryCorruptionProgressed", "setInventoryCorruptionProgressed", "getEntitySpawnDelay", "setEntitySpawnDelay", "getCircuitSpawnDelay", "setCircuitSpawnDelay", "getOblitSpawnDelay", "setOblitSpawnDelay", "getTbeSpawnDelay", "setTbeSpawnDelay", "getRareSpawnDelay", "setRareSpawnDelay", "getNullSpawnDelay", "setNullSpawnDelay", "getCurvedSpawnDelay", "setCurvedSpawnDelay", "getEerieNoiseDelay", "setEerieNoiseDelay", "getHerobrineDelay", "setHerobrineDelay", "getCircuitInhabitedDelay", "setCircuitInhabitedDelay", "getCommandBlockLocation", "()Lnet/minecraft/core/BlockPos;", "setCommandBlockLocation", "(Lnet/minecraft/core/BlockPos;)V", "save", "Lnet/minecraft/nbt/CompoundTag;", "nbt", "provider", "Lnet/minecraft/core/HolderLookup$Provider;", "syncData", "", "level", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nMapVariables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapVariables.kt\nnet/thebrokenscript/data/MapVariables\n+ 2 KClassEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/KClassEndecKt\n*L\n1#1,121:1\n14#2:122\n*S KotlinDebug\n*F\n+ 1 MapVariables.kt\nnet/thebrokenscript/data/MapVariables\n*L\n115#1:122\n*E\n"})
public final class MapVariables
extends SavedData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int dataVersion;
    private boolean hasNullSpawned;
    private boolean hasSiluetSpawned;
    private boolean isFirstJoin;
    private boolean hasGeneratedNullDimension;
    private boolean hasCircuitSpawned;
    private boolean hasTheBrokenEndSpawned;
    private boolean hasGeneratedClanBuildDimension;
    private boolean daylightCycle;
    private long daylightCycleEventTimer;
    private boolean hasTriggeredRam2Die;
    private boolean hasRam2DieJoined;
    private boolean hasVoidSpawned;
    private boolean isNullHere;
    private long firstJoinTimer;
    private boolean scheduled;
    private boolean joinTimerTicking;
    private boolean hasBuiltHerobrineShrine;
    private int moonStage;
    private boolean moonShouldChange;
    private int moonTextureIndex;
    private boolean moonShouldCrack;
    private int moonCrackIndex;
    private boolean soundPlayed;
    private boolean hasMoonCorrupted;
    private boolean isFlat;
    private boolean fracturedFightActive;
    private boolean canFracturedSpawn;
    @NotNull
    private String code;
    private boolean codeApplied;
    private int bossStructX;
    private int bossStructZ;
    private int clanVoidX;
    private int clanVoidZ;
    private int mazeFloorX;
    private int mazeFloorZ;
    private int woodenFloorX;
    private int woodenFloorZ;
    private int stoneFloorX;
    private int stoneFloorZ;
    private int dayAX;
    private int dayAZ;
    private boolean placedStructure;
    private boolean craftedPolaroid;
    private int inventoryCorruption;
    private boolean inventoryCorruptionProgressed;
    private int entitySpawnDelay;
    private int circuitSpawnDelay;
    private int oblitSpawnDelay;
    private int tbeSpawnDelay;
    private int rareSpawnDelay;
    private int nullSpawnDelay;
    private int curvedSpawnDelay;
    private int eerieNoiseDelay;
    private int herobrineDelay;
    private int circuitInhabitedDelay;
    @NotNull
    private BlockPos commandBlockLocation;
    @NotNull
    public static final String DATA_NAME = "thebrokenscript_mapvars";
    @JvmField
    @NotNull
    public static final Endec<MapVariables> ENDEC;
    @JvmField
    @NotNull
    public static Map<ResourceKey<Level>, MapVariables> CLIENT_VARS;

    public MapVariables(int dataVersion, boolean hasNullSpawned, boolean hasSiluetSpawned, boolean isFirstJoin, boolean hasGeneratedNullDimension, boolean hasCircuitSpawned, boolean hasTheBrokenEndSpawned, boolean hasGeneratedClanBuildDimension, boolean daylightCycle, long daylightCycleEventTimer, boolean hasTriggeredRam2Die, boolean hasRam2DieJoined, boolean hasVoidSpawned, boolean isNullHere, long firstJoinTimer, boolean scheduled, boolean joinTimerTicking, boolean hasBuiltHerobrineShrine, int moonStage, boolean moonShouldChange, int moonTextureIndex, boolean moonShouldCrack, int moonCrackIndex, boolean soundPlayed, boolean hasMoonCorrupted, boolean isFlat, boolean fracturedFightActive, boolean canFracturedSpawn, @NotNull String code, boolean codeApplied, int bossStructX, int bossStructZ, int clanVoidX, int clanVoidZ, int mazeFloorX, int mazeFloorZ, int woodenFloorX, int woodenFloorZ, int stoneFloorX, int stoneFloorZ, int dayAX, int dayAZ, boolean placedStructure, boolean craftedPolaroid, int inventoryCorruption, boolean inventoryCorruptionProgressed, int entitySpawnDelay, int circuitSpawnDelay, int oblitSpawnDelay, int tbeSpawnDelay, int rareSpawnDelay, int nullSpawnDelay, int curvedSpawnDelay, int eerieNoiseDelay, int herobrineDelay, int circuitInhabitedDelay, @NotNull BlockPos commandBlockLocation) {
        Intrinsics.checkNotNullParameter((Object)code, (String)"code");
        Intrinsics.checkNotNullParameter((Object)commandBlockLocation, (String)"commandBlockLocation");
        this.dataVersion = dataVersion;
        this.hasNullSpawned = hasNullSpawned;
        this.hasSiluetSpawned = hasSiluetSpawned;
        this.isFirstJoin = isFirstJoin;
        this.hasGeneratedNullDimension = hasGeneratedNullDimension;
        this.hasCircuitSpawned = hasCircuitSpawned;
        this.hasTheBrokenEndSpawned = hasTheBrokenEndSpawned;
        this.hasGeneratedClanBuildDimension = hasGeneratedClanBuildDimension;
        this.daylightCycle = daylightCycle;
        this.daylightCycleEventTimer = daylightCycleEventTimer;
        this.hasTriggeredRam2Die = hasTriggeredRam2Die;
        this.hasRam2DieJoined = hasRam2DieJoined;
        this.hasVoidSpawned = hasVoidSpawned;
        this.isNullHere = isNullHere;
        this.firstJoinTimer = firstJoinTimer;
        this.scheduled = scheduled;
        this.joinTimerTicking = joinTimerTicking;
        this.hasBuiltHerobrineShrine = hasBuiltHerobrineShrine;
        this.moonStage = moonStage;
        this.moonShouldChange = moonShouldChange;
        this.moonTextureIndex = moonTextureIndex;
        this.moonShouldCrack = moonShouldCrack;
        this.moonCrackIndex = moonCrackIndex;
        this.soundPlayed = soundPlayed;
        this.hasMoonCorrupted = hasMoonCorrupted;
        this.isFlat = isFlat;
        this.fracturedFightActive = fracturedFightActive;
        this.canFracturedSpawn = canFracturedSpawn;
        this.code = code;
        this.codeApplied = codeApplied;
        this.bossStructX = bossStructX;
        this.bossStructZ = bossStructZ;
        this.clanVoidX = clanVoidX;
        this.clanVoidZ = clanVoidZ;
        this.mazeFloorX = mazeFloorX;
        this.mazeFloorZ = mazeFloorZ;
        this.woodenFloorX = woodenFloorX;
        this.woodenFloorZ = woodenFloorZ;
        this.stoneFloorX = stoneFloorX;
        this.stoneFloorZ = stoneFloorZ;
        this.dayAX = dayAX;
        this.dayAZ = dayAZ;
        this.placedStructure = placedStructure;
        this.craftedPolaroid = craftedPolaroid;
        this.inventoryCorruption = inventoryCorruption;
        this.inventoryCorruptionProgressed = inventoryCorruptionProgressed;
        this.entitySpawnDelay = entitySpawnDelay;
        this.circuitSpawnDelay = circuitSpawnDelay;
        this.oblitSpawnDelay = oblitSpawnDelay;
        this.tbeSpawnDelay = tbeSpawnDelay;
        this.rareSpawnDelay = rareSpawnDelay;
        this.nullSpawnDelay = nullSpawnDelay;
        this.curvedSpawnDelay = curvedSpawnDelay;
        this.eerieNoiseDelay = eerieNoiseDelay;
        this.herobrineDelay = herobrineDelay;
        this.circuitInhabitedDelay = circuitInhabitedDelay;
        this.commandBlockLocation = commandBlockLocation;
    }

    public /* synthetic */ MapVariables(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, long l, boolean bl9, boolean bl10, boolean bl11, boolean bl12, long l2, boolean bl13, boolean bl14, boolean bl15, int n2, boolean bl16, int n3, boolean bl17, int n4, boolean bl18, boolean bl19, boolean bl20, boolean bl21, boolean bl22, String string, boolean bl23, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, boolean bl24, boolean bl25, int n17, boolean bl26, int n18, int n19, int n20, int n21, int n22, int n23, int n24, int n25, int n26, int n27, BlockPos blockPos, int n28, int n29, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n28 & 1) != 0) {
            n = 3;
        }
        if ((n28 & 2) != 0) {
            bl = false;
        }
        if ((n28 & 4) != 0) {
            bl2 = false;
        }
        if ((n28 & 8) != 0) {
            bl3 = true;
        }
        if ((n28 & 0x10) != 0) {
            bl4 = false;
        }
        if ((n28 & 0x20) != 0) {
            bl5 = false;
        }
        if ((n28 & 0x40) != 0) {
            bl6 = false;
        }
        if ((n28 & 0x80) != 0) {
            bl7 = false;
        }
        if ((n28 & 0x100) != 0) {
            bl8 = true;
        }
        if ((n28 & 0x200) != 0) {
            l = 0L;
        }
        if ((n28 & 0x400) != 0) {
            bl9 = false;
        }
        if ((n28 & 0x800) != 0) {
            bl10 = false;
        }
        if ((n28 & 0x1000) != 0) {
            bl11 = false;
        }
        if ((n28 & 0x2000) != 0) {
            bl12 = false;
        }
        if ((n28 & 0x4000) != 0) {
            l2 = 0L;
        }
        if ((n28 & 0x8000) != 0) {
            bl13 = false;
        }
        if ((n28 & 0x10000) != 0) {
            bl14 = false;
        }
        if ((n28 & 0x20000) != 0) {
            bl15 = false;
        }
        if ((n28 & 0x40000) != 0) {
            n2 = 0;
        }
        if ((n28 & 0x80000) != 0) {
            bl16 = false;
        }
        if ((n28 & 0x100000) != 0) {
            n3 = -1;
        }
        if ((n28 & 0x200000) != 0) {
            bl17 = false;
        }
        if ((n28 & 0x400000) != 0) {
            n4 = -1;
        }
        if ((n28 & 0x800000) != 0) {
            bl18 = false;
        }
        if ((n28 & 0x1000000) != 0) {
            bl19 = false;
        }
        if ((n28 & 0x2000000) != 0) {
            bl20 = false;
        }
        if ((n28 & 0x4000000) != 0) {
            bl21 = false;
        }
        if ((n28 & 0x8000000) != 0) {
            bl22 = false;
        }
        if ((n28 & 0x10000000) != 0) {
            string = "";
        }
        if ((n28 & 0x20000000) != 0) {
            bl23 = false;
        }
        if ((n28 & 0x40000000) != 0) {
            n5 = Integer.MAX_VALUE;
        }
        if ((n28 & Integer.MIN_VALUE) != 0) {
            n6 = Integer.MAX_VALUE;
        }
        if ((n29 & 1) != 0) {
            n7 = Integer.MAX_VALUE;
        }
        if ((n29 & 2) != 0) {
            n8 = Integer.MAX_VALUE;
        }
        if ((n29 & 4) != 0) {
            n9 = Integer.MAX_VALUE;
        }
        if ((n29 & 8) != 0) {
            n10 = Integer.MAX_VALUE;
        }
        if ((n29 & 0x10) != 0) {
            n11 = Integer.MAX_VALUE;
        }
        if ((n29 & 0x20) != 0) {
            n12 = Integer.MAX_VALUE;
        }
        if ((n29 & 0x40) != 0) {
            n13 = Integer.MAX_VALUE;
        }
        if ((n29 & 0x80) != 0) {
            n14 = Integer.MAX_VALUE;
        }
        if ((n29 & 0x100) != 0) {
            n15 = Integer.MAX_VALUE;
        }
        if ((n29 & 0x200) != 0) {
            n16 = Integer.MAX_VALUE;
        }
        if ((n29 & 0x400) != 0) {
            bl24 = false;
        }
        if ((n29 & 0x800) != 0) {
            bl25 = false;
        }
        if ((n29 & 0x1000) != 0) {
            n17 = 0;
        }
        if ((n29 & 0x2000) != 0) {
            bl26 = false;
        }
        if ((n29 & 0x4000) != 0) {
            n18 = 0;
        }
        if ((n29 & 0x8000) != 0) {
            n19 = 0;
        }
        if ((n29 & 0x10000) != 0) {
            n20 = 0;
        }
        if ((n29 & 0x20000) != 0) {
            n21 = 0;
        }
        if ((n29 & 0x40000) != 0) {
            n22 = 0;
        }
        if ((n29 & 0x80000) != 0) {
            n23 = 0;
        }
        if ((n29 & 0x100000) != 0) {
            n24 = 0;
        }
        if ((n29 & 0x200000) != 0) {
            n25 = 0;
        }
        if ((n29 & 0x400000) != 0) {
            n26 = 0;
        }
        if ((n29 & 0x800000) != 0) {
            n27 = 0;
        }
        if ((n29 & 0x1000000) != 0) {
            blockPos = new BlockPos(0, 0, 0);
        }
        this(n, bl, bl2, bl3, bl4, bl5, bl6, bl7, bl8, l, bl9, bl10, bl11, bl12, l2, bl13, bl14, bl15, n2, bl16, n3, bl17, n4, bl18, bl19, bl20, bl21, bl22, string, bl23, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, bl24, bl25, n17, bl26, n18, n19, n20, n21, n22, n23, n24, n25, n26, n27, blockPos);
    }

    public final int getDataVersion() {
        return this.dataVersion;
    }

    public final void setDataVersion(int n) {
        this.dataVersion = n;
    }

    public final boolean getHasNullSpawned() {
        return this.hasNullSpawned;
    }

    public final void setHasNullSpawned(boolean bl) {
        this.hasNullSpawned = bl;
    }

    public final boolean getHasSiluetSpawned() {
        return this.hasSiluetSpawned;
    }

    public final void setHasSiluetSpawned(boolean bl) {
        this.hasSiluetSpawned = bl;
    }

    public final boolean isFirstJoin() {
        return this.isFirstJoin;
    }

    public final void setFirstJoin(boolean bl) {
        this.isFirstJoin = bl;
    }

    public final boolean getHasGeneratedNullDimension() {
        return this.hasGeneratedNullDimension;
    }

    public final void setHasGeneratedNullDimension(boolean bl) {
        this.hasGeneratedNullDimension = bl;
    }

    public final boolean getHasCircuitSpawned() {
        return this.hasCircuitSpawned;
    }

    public final void setHasCircuitSpawned(boolean bl) {
        this.hasCircuitSpawned = bl;
    }

    public final boolean getHasTheBrokenEndSpawned() {
        return this.hasTheBrokenEndSpawned;
    }

    public final void setHasTheBrokenEndSpawned(boolean bl) {
        this.hasTheBrokenEndSpawned = bl;
    }

    public final boolean getHasGeneratedClanBuildDimension() {
        return this.hasGeneratedClanBuildDimension;
    }

    public final void setHasGeneratedClanBuildDimension(boolean bl) {
        this.hasGeneratedClanBuildDimension = bl;
    }

    public final boolean getDaylightCycle() {
        return this.daylightCycle;
    }

    public final void setDaylightCycle(boolean bl) {
        this.daylightCycle = bl;
    }

    public final long getDaylightCycleEventTimer() {
        return this.daylightCycleEventTimer;
    }

    public final void setDaylightCycleEventTimer(long l) {
        this.daylightCycleEventTimer = l;
    }

    public final boolean getHasTriggeredRam2Die() {
        return this.hasTriggeredRam2Die;
    }

    public final void setHasTriggeredRam2Die(boolean bl) {
        this.hasTriggeredRam2Die = bl;
    }

    public final boolean getHasRam2DieJoined() {
        return this.hasRam2DieJoined;
    }

    public final void setHasRam2DieJoined(boolean bl) {
        this.hasRam2DieJoined = bl;
    }

    public final boolean getHasVoidSpawned() {
        return this.hasVoidSpawned;
    }

    public final void setHasVoidSpawned(boolean bl) {
        this.hasVoidSpawned = bl;
    }

    public final boolean isNullHere() {
        return this.isNullHere;
    }

    public final void setNullHere(boolean bl) {
        this.isNullHere = bl;
    }

    public final long getFirstJoinTimer() {
        return this.firstJoinTimer;
    }

    public final void setFirstJoinTimer(long l) {
        this.firstJoinTimer = l;
    }

    public final boolean getScheduled() {
        return this.scheduled;
    }

    public final void setScheduled(boolean bl) {
        this.scheduled = bl;
    }

    public final boolean getJoinTimerTicking() {
        return this.joinTimerTicking;
    }

    public final void setJoinTimerTicking(boolean bl) {
        this.joinTimerTicking = bl;
    }

    public final boolean getHasBuiltHerobrineShrine() {
        return this.hasBuiltHerobrineShrine;
    }

    public final void setHasBuiltHerobrineShrine(boolean bl) {
        this.hasBuiltHerobrineShrine = bl;
    }

    public final int getMoonStage() {
        return this.moonStage;
    }

    public final void setMoonStage(int n) {
        this.moonStage = n;
    }

    public final boolean getMoonShouldChange() {
        return this.moonShouldChange;
    }

    public final void setMoonShouldChange(boolean bl) {
        this.moonShouldChange = bl;
    }

    public final int getMoonTextureIndex() {
        return this.moonTextureIndex;
    }

    public final void setMoonTextureIndex(int n) {
        this.moonTextureIndex = n;
    }

    public final boolean getMoonShouldCrack() {
        return this.moonShouldCrack;
    }

    public final void setMoonShouldCrack(boolean bl) {
        this.moonShouldCrack = bl;
    }

    public final int getMoonCrackIndex() {
        return this.moonCrackIndex;
    }

    public final void setMoonCrackIndex(int n) {
        this.moonCrackIndex = n;
    }

    public final boolean getSoundPlayed() {
        return this.soundPlayed;
    }

    public final void setSoundPlayed(boolean bl) {
        this.soundPlayed = bl;
    }

    public final boolean getHasMoonCorrupted() {
        return this.hasMoonCorrupted;
    }

    public final void setHasMoonCorrupted(boolean bl) {
        this.hasMoonCorrupted = bl;
    }

    public final boolean isFlat() {
        return this.isFlat;
    }

    public final void setFlat(boolean bl) {
        this.isFlat = bl;
    }

    public final boolean getFracturedFightActive() {
        return this.fracturedFightActive;
    }

    public final void setFracturedFightActive(boolean bl) {
        this.fracturedFightActive = bl;
    }

    public final boolean getCanFracturedSpawn() {
        return this.canFracturedSpawn;
    }

    public final void setCanFracturedSpawn(boolean bl) {
        this.canFracturedSpawn = bl;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final void setCode(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.code = string;
    }

    public final boolean getCodeApplied() {
        return this.codeApplied;
    }

    public final void setCodeApplied(boolean bl) {
        this.codeApplied = bl;
    }

    public final int getBossStructX() {
        return this.bossStructX;
    }

    public final void setBossStructX(int n) {
        this.bossStructX = n;
    }

    public final int getBossStructZ() {
        return this.bossStructZ;
    }

    public final void setBossStructZ(int n) {
        this.bossStructZ = n;
    }

    public final int getClanVoidX() {
        return this.clanVoidX;
    }

    public final void setClanVoidX(int n) {
        this.clanVoidX = n;
    }

    public final int getClanVoidZ() {
        return this.clanVoidZ;
    }

    public final void setClanVoidZ(int n) {
        this.clanVoidZ = n;
    }

    public final int getMazeFloorX() {
        return this.mazeFloorX;
    }

    public final void setMazeFloorX(int n) {
        this.mazeFloorX = n;
    }

    public final int getMazeFloorZ() {
        return this.mazeFloorZ;
    }

    public final void setMazeFloorZ(int n) {
        this.mazeFloorZ = n;
    }

    public final int getWoodenFloorX() {
        return this.woodenFloorX;
    }

    public final void setWoodenFloorX(int n) {
        this.woodenFloorX = n;
    }

    public final int getWoodenFloorZ() {
        return this.woodenFloorZ;
    }

    public final void setWoodenFloorZ(int n) {
        this.woodenFloorZ = n;
    }

    public final int getStoneFloorX() {
        return this.stoneFloorX;
    }

    public final void setStoneFloorX(int n) {
        this.stoneFloorX = n;
    }

    public final int getStoneFloorZ() {
        return this.stoneFloorZ;
    }

    public final void setStoneFloorZ(int n) {
        this.stoneFloorZ = n;
    }

    public final int getDayAX() {
        return this.dayAX;
    }

    public final void setDayAX(int n) {
        this.dayAX = n;
    }

    public final int getDayAZ() {
        return this.dayAZ;
    }

    public final void setDayAZ(int n) {
        this.dayAZ = n;
    }

    public final boolean getPlacedStructure() {
        return this.placedStructure;
    }

    public final void setPlacedStructure(boolean bl) {
        this.placedStructure = bl;
    }

    public final boolean getCraftedPolaroid() {
        return this.craftedPolaroid;
    }

    public final void setCraftedPolaroid(boolean bl) {
        this.craftedPolaroid = bl;
    }

    public final int getInventoryCorruption() {
        return this.inventoryCorruption;
    }

    public final void setInventoryCorruption(int n) {
        this.inventoryCorruption = n;
    }

    public final boolean getInventoryCorruptionProgressed() {
        return this.inventoryCorruptionProgressed;
    }

    public final void setInventoryCorruptionProgressed(boolean bl) {
        this.inventoryCorruptionProgressed = bl;
    }

    public final int getEntitySpawnDelay() {
        return this.entitySpawnDelay;
    }

    public final void setEntitySpawnDelay(int n) {
        this.entitySpawnDelay = n;
    }

    public final int getCircuitSpawnDelay() {
        return this.circuitSpawnDelay;
    }

    public final void setCircuitSpawnDelay(int n) {
        this.circuitSpawnDelay = n;
    }

    public final int getOblitSpawnDelay() {
        return this.oblitSpawnDelay;
    }

    public final void setOblitSpawnDelay(int n) {
        this.oblitSpawnDelay = n;
    }

    public final int getTbeSpawnDelay() {
        return this.tbeSpawnDelay;
    }

    public final void setTbeSpawnDelay(int n) {
        this.tbeSpawnDelay = n;
    }

    public final int getRareSpawnDelay() {
        return this.rareSpawnDelay;
    }

    public final void setRareSpawnDelay(int n) {
        this.rareSpawnDelay = n;
    }

    public final int getNullSpawnDelay() {
        return this.nullSpawnDelay;
    }

    public final void setNullSpawnDelay(int n) {
        this.nullSpawnDelay = n;
    }

    public final int getCurvedSpawnDelay() {
        return this.curvedSpawnDelay;
    }

    public final void setCurvedSpawnDelay(int n) {
        this.curvedSpawnDelay = n;
    }

    public final int getEerieNoiseDelay() {
        return this.eerieNoiseDelay;
    }

    public final void setEerieNoiseDelay(int n) {
        this.eerieNoiseDelay = n;
    }

    public final int getHerobrineDelay() {
        return this.herobrineDelay;
    }

    public final void setHerobrineDelay(int n) {
        this.herobrineDelay = n;
    }

    public final int getCircuitInhabitedDelay() {
        return this.circuitInhabitedDelay;
    }

    public final void setCircuitInhabitedDelay(int n) {
        this.circuitInhabitedDelay = n;
    }

    @NotNull
    public final BlockPos getCommandBlockLocation() {
        return this.commandBlockLocation;
    }

    public final void setCommandBlockLocation(@NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"<set-?>");
        this.commandBlockLocation = blockPos;
    }

    @NotNull
    public CompoundTag save(@NotNull CompoundTag nbt, @NotNull HolderLookup.Provider provider2) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        Intrinsics.checkNotNullParameter((Object)provider2, (String)"provider");
        nbt.put("data", EndecExt.INSTANCE.encodeNbtOrThrow(ENDEC, (Object)this));
        return nbt;
    }

    public final void syncData(@NotNull ResourceKey<Level> level) {
        Intrinsics.checkNotNullParameter(level, (String)"level");
        this.setDirty();
        PacketSender.INSTANCE.sendToAllPlayers((CustomPacketPayload)TBSPackets.MAP_VARS_SYNC.of(TuplesKt.to(level, (Object)((Object)this))), new CustomPacketPayload[0]);
    }

    public MapVariables() {
        this(0, false, false, false, false, false, false, false, false, 0L, false, false, false, false, 0L, false, false, false, 0, false, 0, false, 0, false, false, false, false, false, null, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, 0, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, -1, 0x1FFFFFF, null);
    }

    static {
        KClass $this$endec$iv = Reflection.getOrCreateKotlinClass(MapVariables.class);
        boolean $i$f$getEndec = false;
        ENDEC = (Endec)new KClassEndec($this$endec$iv);
        CLIENT_VARS = new ConcurrentHashMap();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/data/MapVariables$Companion;", "", "<init>", "()V", "DATA_NAME", "", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/data/MapVariables;", "CLIENT_VARS", "", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

