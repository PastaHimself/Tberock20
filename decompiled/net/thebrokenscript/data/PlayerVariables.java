/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KMutableProperty
 *  kotlin.reflect.KProperty1
 *  kotlin.reflect.full.KClasses
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.data.NbtSerializable
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.ext.EndecExt
 *  net.thebrokenscript.brokencore.api.util.serde.KClassEndec
 *  net.thebrokenscript.brokencore.api.util.serde.WrappedBlockPosList
 *  net.thebrokenscript.brokencore.api.util.serde.WrappedUUIDSet
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.data;

import io.wispforest.endec.Endec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.data.NbtSerializable;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.ext.EndecExt;
import net.thebrokenscript.brokencore.api.util.serde.KClassEndec;
import net.thebrokenscript.brokencore.api.util.serde.WrappedBlockPosList;
import net.thebrokenscript.brokencore.api.util.serde.WrappedUUIDSet;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.data.CameraMode;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\b\u009c\u0001\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00e6\u00012\u00020\u0001:\u0002\u00e6\u0001B\u00b7\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\b\b\u0002\u0010'\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u0012\b\b\u0002\u0010+\u001a\u00020\u0003\u0012\b\b\u0002\u0010,\u001a\u00020\u0012\u0012\b\b\u0002\u0010-\u001a\u00020\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0007\u0012\b\b\u0002\u00100\u001a\u00020\u0003\u0012\b\b\u0002\u00101\u001a\u00020\u0007\u0012\b\b\u0002\u00102\u001a\u00020\u0012\u0012\b\b\u0002\u00103\u001a\u00020\u0003\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\b\b\u0002\u00105\u001a\u00020\u0003\u0012\b\b\u0002\u00106\u001a\u00020\u0003\u0012\b\b\u0002\u00107\u001a\u00020\u0007\u0012\b\b\u0002\u00108\u001a\u00020\n\u0012\b\b\u0002\u00109\u001a\u00020:\u0012\b\b\u0002\u0010;\u001a\u00020\u0007\u0012\b\b\u0002\u0010<\u001a\u00020\u0003\u0012\b\b\u0002\u0010=\u001a\u00020>\u0012\b\b\u0002\u0010?\u001a\u00020\u0007\u0012\b\b\u0002\u0010@\u001a\u00020\u0007\u0012\b\b\u0002\u0010A\u001a\u00020\u0007\u0012\b\b\u0002\u0010B\u001a\u00020\u0007\u0012\b\b\u0002\u0010C\u001a\u00020\u0007\u0012\b\b\u0002\u0010D\u001a\u00020\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0012\u0010\u00da\u0001\u001a\u00030\u00db\u00012\b\u0010\u00dc\u0001\u001a\u00030\u00dd\u0001J\u0014\u0010\u00de\u0001\u001a\u00030\u00df\u00012\b\u0010\u00e0\u0001\u001a\u00030\u00e1\u0001H\u0016J\u001e\u0010\u00e2\u0001\u001a\u00030\u00db\u00012\b\u0010\u00e0\u0001\u001a\u00030\u00e1\u00012\b\u0010\u00e3\u0001\u001a\u00030\u00df\u0001H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010H\"\u0004\bT\u0010JR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010H\"\u0004\bZ\u0010JR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010P\"\u0004\b\\\u0010RR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010P\"\u0004\b^\u0010RR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010P\"\u0004\b`\u0010RR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010f\"\u0004\bj\u0010hR\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010P\"\u0004\bl\u0010RR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010P\"\u0004\bm\u0010RR\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010P\"\u0004\bo\u0010RR\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010V\"\u0004\bq\u0010XR\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010b\"\u0004\bs\u0010dR\u001a\u0010\u0019\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010P\"\u0004\bu\u0010RR\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010P\"\u0004\bw\u0010RR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010f\"\u0004\b}\u0010hR\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b~\u0010P\"\u0004\b\u007f\u0010RR\u001e\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010!\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010P\"\u0005\b\u0085\u0001\u0010RR\u001e\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010$\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010P\"\u0005\b\u008b\u0001\u0010RR\u001c\u0010%\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010P\"\u0005\b\u008d\u0001\u0010RR\u001c\u0010&\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010H\"\u0005\b\u008f\u0001\u0010JR\u001c\u0010'\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010H\"\u0005\b\u0091\u0001\u0010JR\u001c\u0010(\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010P\"\u0005\b\u0093\u0001\u0010RR\u001c\u0010)\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010f\"\u0005\b\u0095\u0001\u0010hR\u001c\u0010*\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010f\"\u0005\b\u0097\u0001\u0010hR\u001c\u0010+\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010H\"\u0005\b\u0099\u0001\u0010JR\u001c\u0010,\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010f\"\u0005\b\u009b\u0001\u0010hR\u001c\u0010-\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010H\"\u0005\b\u009d\u0001\u0010JR\u001c\u0010.\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010H\"\u0005\b\u009f\u0001\u0010JR\u001c\u0010/\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a0\u0001\u0010P\"\u0005\b\u00a1\u0001\u0010RR\u001c\u00100\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a2\u0001\u0010H\"\u0005\b\u00a3\u0001\u0010JR\u001c\u00101\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a4\u0001\u0010P\"\u0005\b\u00a5\u0001\u0010RR\u001c\u00102\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a6\u0001\u0010f\"\u0005\b\u00a7\u0001\u0010hR\u001c\u00103\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a8\u0001\u0010H\"\u0005\b\u00a9\u0001\u0010JR\u001c\u00104\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00aa\u0001\u0010H\"\u0005\b\u00ab\u0001\u0010JR\u001c\u00105\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ac\u0001\u0010H\"\u0005\b\u00ad\u0001\u0010JR\u001c\u00106\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ae\u0001\u0010H\"\u0005\b\u00af\u0001\u0010JR\u001c\u00107\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b0\u0001\u0010P\"\u0005\b\u00b1\u0001\u0010RR\u001c\u00108\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b2\u0001\u0010V\"\u0005\b\u00b3\u0001\u0010XR\u001e\u00109\u001a\u00020:X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001\"\u0006\b\u00b6\u0001\u0010\u00b7\u0001R\u001c\u0010;\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b8\u0001\u0010P\"\u0005\b\u00b9\u0001\u0010RR\u001c\u0010<\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ba\u0001\u0010H\"\u0005\b\u00bb\u0001\u0010JR\u0013\u0010=\u001a\u00020>\u00a2\u0006\n\n\u0000\u001a\u0006\b\u00bc\u0001\u0010\u00bd\u0001R\u001c\u0010?\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00be\u0001\u0010P\"\u0005\b\u00bf\u0001\u0010RR\u001c\u0010@\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c0\u0001\u0010P\"\u0005\b\u00c1\u0001\u0010RR\u001c\u0010A\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c2\u0001\u0010P\"\u0005\b\u00c3\u0001\u0010RR\u001c\u0010B\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c4\u0001\u0010P\"\u0005\b\u00c5\u0001\u0010RR\u001c\u0010C\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c6\u0001\u0010P\"\u0005\b\u00c7\u0001\u0010RR\u001c\u0010D\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c8\u0001\u0010P\"\u0005\b\u00c9\u0001\u0010RR\u0013\u0010\u00ca\u0001\u001a\u00020\u00078F\u00a2\u0006\u0007\u001a\u0005\b\u00cb\u0001\u0010PR\u0013\u0010\u00cc\u0001\u001a\u00020\u00078F\u00a2\u0006\u0007\u001a\u0005\b\u00cd\u0001\u0010PR\u0013\u0010\u00ce\u0001\u001a\u00020\u00078F\u00a2\u0006\u0007\u001a\u0005\b\u00cf\u0001\u0010PR\u0013\u0010\u00d0\u0001\u001a\u00020\u00078F\u00a2\u0006\u0007\u001a\u0005\b\u00d1\u0001\u0010PR\u0013\u0010\u00d2\u0001\u001a\u00020\u00078F\u00a2\u0006\u0007\u001a\u0005\b\u00d3\u0001\u0010PR\u0013\u0010\u00d4\u0001\u001a\u00020\u00078F\u00a2\u0006\u0007\u001a\u0005\b\u00d5\u0001\u0010PR(\u0010\u00d7\u0001\u001a\u00020\u00072\u0007\u0010\u00d6\u0001\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d8\u0001\u0010P\"\u0005\b\u00d9\u0001\u0010RR\u0013\u0010\u00e4\u0001\u001a\u00020\u00078F\u00a2\u0006\u0007\u001a\u0005\b\u00e5\u0001\u0010P\u00a8\u0006\u00e7\u0001"}, d2={"Lnet/thebrokenscript/data/PlayerVariables;", "Lnet/thebrokenscript/brokencore/api/data/NbtSerializable;", "dataVersion", "", "spawnPos", "Lnet/minecraft/core/BlockPos;", "hasPlayedCreepyDisc", "", "entityReputation", "lastRepInteraction", "", "noWayOutFrame", "vhsEnabled", "pixelateEnabled", "aberrationEnabled", "moonGlitchDuration", "", "ticksUntilExit", "", "syncTimer", "showCoords", "isDesync", "lookedAtOblit", "titleName", "fov", "ban", "fixPos", "textGlitchStrength", "", "aberrationTimer", "enableCustomSky", "customSkyColor", "Lnet/minecraft/world/phys/Vec3;", "showSkyBlue", "cameraMode", "Lnet/thebrokenscript/data/CameraMode;", "skipFallDamage", "enableScreenDupe", "teleportCounter", "musicTimer", "despawnEntitySwitch", "lastTeleport", "lastClanVoidTeleport", "nullFlyRepGainTimer", "screenDupeTimer", "triangleKickTimer", "baseRescanCooldown", "musicCausedByTBS", "feverMessageProgression", "invertEnabled", "invertTimer", "lastX", "lastZ", "currentX", "currentZ", "sawTxtHint", "userDir", "doors", "Lnet/thebrokenscript/brokencore/api/util/serde/WrappedBlockPosList;", "isolationActive", "isolationTimer", "isolationAllowedUsers", "Lnet/thebrokenscript/brokencore/api/util/serde/WrappedUUIDSet;", "forceMetaParanoia", "loadingPhase2", "loadingPhase3", "glitchesEnabled", "dreamEnabled", "voidBox", "<init>", "(ILnet/minecraft/core/BlockPos;ZILjava/lang/String;IZZZDJJZZZLjava/lang/String;DZZFJZLnet/minecraft/world/phys/Vec3;ZLnet/thebrokenscript/data/CameraMode;ZZIIZJJIJIIZIZJIIIIZLjava/lang/String;Lnet/thebrokenscript/brokencore/api/util/serde/WrappedBlockPosList;ZILnet/thebrokenscript/brokencore/api/util/serde/WrappedUUIDSet;ZZZZZZ)V", "getDataVersion", "()I", "setDataVersion", "(I)V", "getSpawnPos", "()Lnet/minecraft/core/BlockPos;", "setSpawnPos", "(Lnet/minecraft/core/BlockPos;)V", "getHasPlayedCreepyDisc", "()Z", "setHasPlayedCreepyDisc", "(Z)V", "getEntityReputation", "setEntityReputation", "getLastRepInteraction", "()Ljava/lang/String;", "setLastRepInteraction", "(Ljava/lang/String;)V", "getNoWayOutFrame", "setNoWayOutFrame", "getVhsEnabled", "setVhsEnabled", "getPixelateEnabled", "setPixelateEnabled", "getAberrationEnabled", "setAberrationEnabled", "getMoonGlitchDuration", "()D", "setMoonGlitchDuration", "(D)V", "getTicksUntilExit", "()J", "setTicksUntilExit", "(J)V", "getSyncTimer", "setSyncTimer", "getShowCoords", "setShowCoords", "setDesync", "getLookedAtOblit", "setLookedAtOblit", "getTitleName", "setTitleName", "getFov", "setFov", "getBan", "setBan", "getFixPos", "setFixPos", "getTextGlitchStrength", "()F", "setTextGlitchStrength", "(F)V", "getAberrationTimer", "setAberrationTimer", "getEnableCustomSky", "setEnableCustomSky", "getCustomSkyColor", "()Lnet/minecraft/world/phys/Vec3;", "setCustomSkyColor", "(Lnet/minecraft/world/phys/Vec3;)V", "getShowSkyBlue", "setShowSkyBlue", "getCameraMode", "()Lnet/thebrokenscript/data/CameraMode;", "setCameraMode", "(Lnet/thebrokenscript/data/CameraMode;)V", "getSkipFallDamage", "setSkipFallDamage", "getEnableScreenDupe", "setEnableScreenDupe", "getTeleportCounter", "setTeleportCounter", "getMusicTimer", "setMusicTimer", "getDespawnEntitySwitch", "setDespawnEntitySwitch", "getLastTeleport", "setLastTeleport", "getLastClanVoidTeleport", "setLastClanVoidTeleport", "getNullFlyRepGainTimer", "setNullFlyRepGainTimer", "getScreenDupeTimer", "setScreenDupeTimer", "getTriangleKickTimer", "setTriangleKickTimer", "getBaseRescanCooldown", "setBaseRescanCooldown", "getMusicCausedByTBS", "setMusicCausedByTBS", "getFeverMessageProgression", "setFeverMessageProgression", "getInvertEnabled", "setInvertEnabled", "getInvertTimer", "setInvertTimer", "getLastX", "setLastX", "getLastZ", "setLastZ", "getCurrentX", "setCurrentX", "getCurrentZ", "setCurrentZ", "getSawTxtHint", "setSawTxtHint", "getUserDir", "setUserDir", "getDoors", "()Lnet/thebrokenscript/brokencore/api/util/serde/WrappedBlockPosList;", "setDoors", "(Lnet/thebrokenscript/brokencore/api/util/serde/WrappedBlockPosList;)V", "getIsolationActive", "setIsolationActive", "getIsolationTimer", "setIsolationTimer", "getIsolationAllowedUsers", "()Lnet/thebrokenscript/brokencore/api/util/serde/WrappedUUIDSet;", "getForceMetaParanoia", "setForceMetaParanoia", "getLoadingPhase2", "setLoadingPhase2", "getLoadingPhase3", "setLoadingPhase3", "getGlitchesEnabled", "setGlitchesEnabled", "getDreamEnabled", "setDreamEnabled", "getVoidBox", "setVoidBox", "checkedVhsEnabled", "getCheckedVhsEnabled", "checkedAberrationEnabled", "getCheckedAberrationEnabled", "checkedGlitchesEnabled", "getCheckedGlitchesEnabled", "checkedDreamEnabled", "getCheckedDreamEnabled", "checkedVoidBoxEnabled", "getCheckedVoidBoxEnabled", "checkedInvertEnabled", "getCheckedInvertEnabled", "value", "enableMoonGlitch", "getEnableMoonGlitch", "setEnableMoonGlitch", "syncTo", "", "player", "Lnet/minecraft/world/entity/player/Player;", "serializeNbt", "Lnet/minecraft/nbt/Tag;", "provider", "Lnet/minecraft/core/HolderLookup$Provider;", "deserializeNbt", "tag", "metaParanoia", "getMetaParanoia", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPlayerVariables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayerVariables.kt\nnet/thebrokenscript/data/PlayerVariables\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 KClassEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/KClassEndecKt\n+ 5 KClassEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/KClassEndec\n*L\n1#1,146:1\n808#2,11:147\n1869#2:158\n1870#2:160\n1#3:159\n14#4:161\n90#5:162\n*S KotlinDebug\n*F\n+ 1 PlayerVariables.kt\nnet/thebrokenscript/data/PlayerVariables\n*L\n127#1:147,11\n127#1:158\n127#1:160\n143#1:161\n143#1:162\n*E\n"})
public final class PlayerVariables
implements NbtSerializable {
    @NotNull
    public static final Companion Companion;
    private int dataVersion;
    @NotNull
    private BlockPos spawnPos;
    private boolean hasPlayedCreepyDisc;
    private int entityReputation;
    @NotNull
    private String lastRepInteraction;
    private int noWayOutFrame;
    private boolean vhsEnabled;
    private boolean pixelateEnabled;
    private boolean aberrationEnabled;
    private double moonGlitchDuration;
    private long ticksUntilExit;
    private long syncTimer;
    private boolean showCoords;
    private boolean isDesync;
    private boolean lookedAtOblit;
    @NotNull
    private String titleName;
    private double fov;
    private boolean ban;
    private boolean fixPos;
    private float textGlitchStrength;
    private long aberrationTimer;
    private boolean enableCustomSky;
    @NotNull
    private Vec3 customSkyColor;
    private boolean showSkyBlue;
    @NotNull
    private CameraMode cameraMode;
    private boolean skipFallDamage;
    private boolean enableScreenDupe;
    private int teleportCounter;
    private int musicTimer;
    private boolean despawnEntitySwitch;
    private long lastTeleport;
    private long lastClanVoidTeleport;
    private int nullFlyRepGainTimer;
    private long screenDupeTimer;
    private int triangleKickTimer;
    private int baseRescanCooldown;
    private boolean musicCausedByTBS;
    private int feverMessageProgression;
    private boolean invertEnabled;
    private long invertTimer;
    private int lastX;
    private int lastZ;
    private int currentX;
    private int currentZ;
    private boolean sawTxtHint;
    @NotNull
    private String userDir;
    @NotNull
    private WrappedBlockPosList doors;
    private boolean isolationActive;
    private int isolationTimer;
    @NotNull
    private final WrappedUUIDSet isolationAllowedUsers;
    private boolean forceMetaParanoia;
    private boolean loadingPhase2;
    private boolean loadingPhase3;
    private boolean glitchesEnabled;
    private boolean dreamEnabled;
    private boolean voidBox;
    public static final double MOON_GLITCH_DURATION_SECS = 80.0;
    @JvmField
    @NotNull
    public static final Endec<PlayerVariables> ENDEC;

    public PlayerVariables(int dataVersion, @NotNull BlockPos spawnPos, boolean hasPlayedCreepyDisc, int entityReputation, @NotNull String lastRepInteraction, int noWayOutFrame, boolean vhsEnabled, boolean pixelateEnabled, boolean aberrationEnabled, double moonGlitchDuration, long ticksUntilExit, long syncTimer, boolean showCoords, boolean isDesync, boolean lookedAtOblit, @NotNull String titleName, double fov, boolean ban, boolean fixPos, float textGlitchStrength, long aberrationTimer, boolean enableCustomSky, @NotNull Vec3 customSkyColor, boolean showSkyBlue, @NotNull CameraMode cameraMode, boolean skipFallDamage, boolean enableScreenDupe, int teleportCounter, int musicTimer, boolean despawnEntitySwitch, long lastTeleport, long lastClanVoidTeleport, int nullFlyRepGainTimer, long screenDupeTimer, int triangleKickTimer, int baseRescanCooldown, boolean musicCausedByTBS, int feverMessageProgression, boolean invertEnabled, long invertTimer, int lastX, int lastZ, int currentX, int currentZ, boolean sawTxtHint, @NotNull String userDir, @NotNull WrappedBlockPosList doors, boolean isolationActive, int isolationTimer, @NotNull WrappedUUIDSet isolationAllowedUsers, boolean forceMetaParanoia, boolean loadingPhase2, boolean loadingPhase3, boolean glitchesEnabled, boolean dreamEnabled, boolean voidBox) {
        Intrinsics.checkNotNullParameter((Object)spawnPos, (String)"spawnPos");
        Intrinsics.checkNotNullParameter((Object)lastRepInteraction, (String)"lastRepInteraction");
        Intrinsics.checkNotNullParameter((Object)titleName, (String)"titleName");
        Intrinsics.checkNotNullParameter((Object)customSkyColor, (String)"customSkyColor");
        Intrinsics.checkNotNullParameter((Object)((Object)cameraMode), (String)"cameraMode");
        Intrinsics.checkNotNullParameter((Object)userDir, (String)"userDir");
        Intrinsics.checkNotNullParameter((Object)doors, (String)"doors");
        Intrinsics.checkNotNullParameter((Object)isolationAllowedUsers, (String)"isolationAllowedUsers");
        this.dataVersion = dataVersion;
        this.spawnPos = spawnPos;
        this.hasPlayedCreepyDisc = hasPlayedCreepyDisc;
        this.entityReputation = entityReputation;
        this.lastRepInteraction = lastRepInteraction;
        this.noWayOutFrame = noWayOutFrame;
        this.vhsEnabled = vhsEnabled;
        this.pixelateEnabled = pixelateEnabled;
        this.aberrationEnabled = aberrationEnabled;
        this.moonGlitchDuration = moonGlitchDuration;
        this.ticksUntilExit = ticksUntilExit;
        this.syncTimer = syncTimer;
        this.showCoords = showCoords;
        this.isDesync = isDesync;
        this.lookedAtOblit = lookedAtOblit;
        this.titleName = titleName;
        this.fov = fov;
        this.ban = ban;
        this.fixPos = fixPos;
        this.textGlitchStrength = textGlitchStrength;
        this.aberrationTimer = aberrationTimer;
        this.enableCustomSky = enableCustomSky;
        this.customSkyColor = customSkyColor;
        this.showSkyBlue = showSkyBlue;
        this.cameraMode = cameraMode;
        this.skipFallDamage = skipFallDamage;
        this.enableScreenDupe = enableScreenDupe;
        this.teleportCounter = teleportCounter;
        this.musicTimer = musicTimer;
        this.despawnEntitySwitch = despawnEntitySwitch;
        this.lastTeleport = lastTeleport;
        this.lastClanVoidTeleport = lastClanVoidTeleport;
        this.nullFlyRepGainTimer = nullFlyRepGainTimer;
        this.screenDupeTimer = screenDupeTimer;
        this.triangleKickTimer = triangleKickTimer;
        this.baseRescanCooldown = baseRescanCooldown;
        this.musicCausedByTBS = musicCausedByTBS;
        this.feverMessageProgression = feverMessageProgression;
        this.invertEnabled = invertEnabled;
        this.invertTimer = invertTimer;
        this.lastX = lastX;
        this.lastZ = lastZ;
        this.currentX = currentX;
        this.currentZ = currentZ;
        this.sawTxtHint = sawTxtHint;
        this.userDir = userDir;
        this.doors = doors;
        this.isolationActive = isolationActive;
        this.isolationTimer = isolationTimer;
        this.isolationAllowedUsers = isolationAllowedUsers;
        this.forceMetaParanoia = forceMetaParanoia;
        this.loadingPhase2 = loadingPhase2;
        this.loadingPhase3 = loadingPhase3;
        this.glitchesEnabled = glitchesEnabled;
        this.dreamEnabled = dreamEnabled;
        this.voidBox = voidBox;
    }

    public /* synthetic */ PlayerVariables(int n, BlockPos blockPos, boolean bl, int n2, String string, int n3, boolean bl2, boolean bl3, boolean bl4, double d, long l, long l2, boolean bl5, boolean bl6, boolean bl7, String string2, double d2, boolean bl8, boolean bl9, float f, long l3, boolean bl10, Vec3 vec3, boolean bl11, CameraMode cameraMode, boolean bl12, boolean bl13, int n4, int n5, boolean bl14, long l4, long l5, int n6, long l6, int n7, int n8, boolean bl15, int n9, boolean bl16, long l7, int n10, int n11, int n12, int n13, boolean bl17, String string3, WrappedBlockPosList wrappedBlockPosList, boolean bl18, int n14, WrappedUUIDSet wrappedUUIDSet, boolean bl19, boolean bl20, boolean bl21, boolean bl22, boolean bl23, boolean bl24, int n15, int n16, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n15 & 1) != 0) {
            n = 2;
        }
        if ((n15 & 2) != 0) {
            blockPos = new BlockPos(0, 0, 0);
        }
        if ((n15 & 4) != 0) {
            bl = false;
        }
        if ((n15 & 8) != 0) {
            n2 = 50;
        }
        if ((n15 & 0x10) != 0) {
            string = "";
        }
        if ((n15 & 0x20) != 0) {
            n3 = 0;
        }
        if ((n15 & 0x40) != 0) {
            bl2 = false;
        }
        if ((n15 & 0x80) != 0) {
            bl3 = false;
        }
        if ((n15 & 0x100) != 0) {
            bl4 = false;
        }
        if ((n15 & 0x200) != 0) {
            d = 0.0;
        }
        if ((n15 & 0x400) != 0) {
            l = 0L;
        }
        if ((n15 & 0x800) != 0) {
            l2 = 0L;
        }
        if ((n15 & 0x1000) != 0) {
            bl5 = false;
        }
        if ((n15 & 0x2000) != 0) {
            bl6 = false;
        }
        if ((n15 & 0x4000) != 0) {
            bl7 = false;
        }
        if ((n15 & 0x8000) != 0) {
            string2 = "";
        }
        if ((n15 & 0x10000) != 0) {
            d2 = 0.0;
        }
        if ((n15 & 0x20000) != 0) {
            bl8 = false;
        }
        if ((n15 & 0x40000) != 0) {
            bl9 = false;
        }
        if ((n15 & 0x80000) != 0) {
            f = 0.0f;
        }
        if ((n15 & 0x100000) != 0) {
            l3 = 0L;
        }
        if ((n15 & 0x200000) != 0) {
            bl10 = false;
        }
        if ((n15 & 0x400000) != 0) {
            vec3 = new Vec3(0.0, 0.0, 0.0);
        }
        if ((n15 & 0x800000) != 0) {
            bl11 = false;
        }
        if ((n15 & 0x1000000) != 0) {
            cameraMode = CameraMode.FIRST_PERSON;
        }
        if ((n15 & 0x2000000) != 0) {
            bl12 = false;
        }
        if ((n15 & 0x4000000) != 0) {
            bl13 = false;
        }
        if ((n15 & 0x8000000) != 0) {
            n4 = 0;
        }
        if ((n15 & 0x10000000) != 0) {
            n5 = 0;
        }
        if ((n15 & 0x20000000) != 0) {
            bl14 = false;
        }
        if ((n15 & 0x40000000) != 0) {
            l4 = 0L;
        }
        if ((n15 & Integer.MIN_VALUE) != 0) {
            l5 = 0L;
        }
        if ((n16 & 1) != 0) {
            n6 = 0;
        }
        if ((n16 & 2) != 0) {
            l6 = 0L;
        }
        if ((n16 & 4) != 0) {
            n7 = 0;
        }
        if ((n16 & 8) != 0) {
            n8 = 0;
        }
        if ((n16 & 0x10) != 0) {
            bl15 = false;
        }
        if ((n16 & 0x20) != 0) {
            n9 = 0;
        }
        if ((n16 & 0x40) != 0) {
            bl16 = false;
        }
        if ((n16 & 0x80) != 0) {
            l7 = 0L;
        }
        if ((n16 & 0x100) != 0) {
            n10 = 0;
        }
        if ((n16 & 0x200) != 0) {
            n11 = 0;
        }
        if ((n16 & 0x400) != 0) {
            n12 = 0;
        }
        if ((n16 & 0x800) != 0) {
            n13 = 0;
        }
        if ((n16 & 0x1000) != 0) {
            bl17 = false;
        }
        if ((n16 & 0x2000) != 0) {
            string3 = "";
        }
        if ((n16 & 0x4000) != 0) {
            wrappedBlockPosList = new WrappedBlockPosList((Set)new LinkedHashSet());
        }
        if ((n16 & 0x8000) != 0) {
            bl18 = false;
        }
        if ((n16 & 0x10000) != 0) {
            n14 = 0;
        }
        if ((n16 & 0x20000) != 0) {
            wrappedUUIDSet = new WrappedUUIDSet((Set)new LinkedHashSet());
        }
        if ((n16 & 0x40000) != 0) {
            bl19 = false;
        }
        if ((n16 & 0x80000) != 0) {
            bl20 = false;
        }
        if ((n16 & 0x100000) != 0) {
            bl21 = false;
        }
        if ((n16 & 0x200000) != 0) {
            bl22 = false;
        }
        if ((n16 & 0x400000) != 0) {
            bl23 = false;
        }
        if ((n16 & 0x800000) != 0) {
            bl24 = true;
        }
        this(n, blockPos, bl, n2, string, n3, bl2, bl3, bl4, d, l, l2, bl5, bl6, bl7, string2, d2, bl8, bl9, f, l3, bl10, vec3, bl11, cameraMode, bl12, bl13, n4, n5, bl14, l4, l5, n6, l6, n7, n8, bl15, n9, bl16, l7, n10, n11, n12, n13, bl17, string3, wrappedBlockPosList, bl18, n14, wrappedUUIDSet, bl19, bl20, bl21, bl22, bl23, bl24);
    }

    public final int getDataVersion() {
        return this.dataVersion;
    }

    public final void setDataVersion(int n) {
        this.dataVersion = n;
    }

    @NotNull
    public final BlockPos getSpawnPos() {
        return this.spawnPos;
    }

    public final void setSpawnPos(@NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"<set-?>");
        this.spawnPos = blockPos;
    }

    public final boolean getHasPlayedCreepyDisc() {
        return this.hasPlayedCreepyDisc;
    }

    public final void setHasPlayedCreepyDisc(boolean bl) {
        this.hasPlayedCreepyDisc = bl;
    }

    public final int getEntityReputation() {
        return this.entityReputation;
    }

    public final void setEntityReputation(int n) {
        this.entityReputation = n;
    }

    @NotNull
    public final String getLastRepInteraction() {
        return this.lastRepInteraction;
    }

    public final void setLastRepInteraction(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.lastRepInteraction = string;
    }

    public final int getNoWayOutFrame() {
        return this.noWayOutFrame;
    }

    public final void setNoWayOutFrame(int n) {
        this.noWayOutFrame = n;
    }

    public final boolean getVhsEnabled() {
        return this.vhsEnabled;
    }

    public final void setVhsEnabled(boolean bl) {
        this.vhsEnabled = bl;
    }

    public final boolean getPixelateEnabled() {
        return this.pixelateEnabled;
    }

    public final void setPixelateEnabled(boolean bl) {
        this.pixelateEnabled = bl;
    }

    public final boolean getAberrationEnabled() {
        return this.aberrationEnabled;
    }

    public final void setAberrationEnabled(boolean bl) {
        this.aberrationEnabled = bl;
    }

    public final double getMoonGlitchDuration() {
        return this.moonGlitchDuration;
    }

    public final void setMoonGlitchDuration(double d) {
        this.moonGlitchDuration = d;
    }

    public final long getTicksUntilExit() {
        return this.ticksUntilExit;
    }

    public final void setTicksUntilExit(long l) {
        this.ticksUntilExit = l;
    }

    public final long getSyncTimer() {
        return this.syncTimer;
    }

    public final void setSyncTimer(long l) {
        this.syncTimer = l;
    }

    public final boolean getShowCoords() {
        return this.showCoords;
    }

    public final void setShowCoords(boolean bl) {
        this.showCoords = bl;
    }

    public final boolean isDesync() {
        return this.isDesync;
    }

    public final void setDesync(boolean bl) {
        this.isDesync = bl;
    }

    public final boolean getLookedAtOblit() {
        return this.lookedAtOblit;
    }

    public final void setLookedAtOblit(boolean bl) {
        this.lookedAtOblit = bl;
    }

    @NotNull
    public final String getTitleName() {
        return this.titleName;
    }

    public final void setTitleName(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.titleName = string;
    }

    public final double getFov() {
        return this.fov;
    }

    public final void setFov(double d) {
        this.fov = d;
    }

    public final boolean getBan() {
        return this.ban;
    }

    public final void setBan(boolean bl) {
        this.ban = bl;
    }

    public final boolean getFixPos() {
        return this.fixPos;
    }

    public final void setFixPos(boolean bl) {
        this.fixPos = bl;
    }

    public final float getTextGlitchStrength() {
        return this.textGlitchStrength;
    }

    public final void setTextGlitchStrength(float f) {
        this.textGlitchStrength = f;
    }

    public final long getAberrationTimer() {
        return this.aberrationTimer;
    }

    public final void setAberrationTimer(long l) {
        this.aberrationTimer = l;
    }

    public final boolean getEnableCustomSky() {
        return this.enableCustomSky;
    }

    public final void setEnableCustomSky(boolean bl) {
        this.enableCustomSky = bl;
    }

    @NotNull
    public final Vec3 getCustomSkyColor() {
        return this.customSkyColor;
    }

    public final void setCustomSkyColor(@NotNull Vec3 vec3) {
        Intrinsics.checkNotNullParameter((Object)vec3, (String)"<set-?>");
        this.customSkyColor = vec3;
    }

    public final boolean getShowSkyBlue() {
        return this.showSkyBlue;
    }

    public final void setShowSkyBlue(boolean bl) {
        this.showSkyBlue = bl;
    }

    @NotNull
    public final CameraMode getCameraMode() {
        return this.cameraMode;
    }

    public final void setCameraMode(@NotNull CameraMode cameraMode) {
        Intrinsics.checkNotNullParameter((Object)((Object)cameraMode), (String)"<set-?>");
        this.cameraMode = cameraMode;
    }

    public final boolean getSkipFallDamage() {
        return this.skipFallDamage;
    }

    public final void setSkipFallDamage(boolean bl) {
        this.skipFallDamage = bl;
    }

    public final boolean getEnableScreenDupe() {
        return this.enableScreenDupe;
    }

    public final void setEnableScreenDupe(boolean bl) {
        this.enableScreenDupe = bl;
    }

    public final int getTeleportCounter() {
        return this.teleportCounter;
    }

    public final void setTeleportCounter(int n) {
        this.teleportCounter = n;
    }

    public final int getMusicTimer() {
        return this.musicTimer;
    }

    public final void setMusicTimer(int n) {
        this.musicTimer = n;
    }

    public final boolean getDespawnEntitySwitch() {
        return this.despawnEntitySwitch;
    }

    public final void setDespawnEntitySwitch(boolean bl) {
        this.despawnEntitySwitch = bl;
    }

    public final long getLastTeleport() {
        return this.lastTeleport;
    }

    public final void setLastTeleport(long l) {
        this.lastTeleport = l;
    }

    public final long getLastClanVoidTeleport() {
        return this.lastClanVoidTeleport;
    }

    public final void setLastClanVoidTeleport(long l) {
        this.lastClanVoidTeleport = l;
    }

    public final int getNullFlyRepGainTimer() {
        return this.nullFlyRepGainTimer;
    }

    public final void setNullFlyRepGainTimer(int n) {
        this.nullFlyRepGainTimer = n;
    }

    public final long getScreenDupeTimer() {
        return this.screenDupeTimer;
    }

    public final void setScreenDupeTimer(long l) {
        this.screenDupeTimer = l;
    }

    public final int getTriangleKickTimer() {
        return this.triangleKickTimer;
    }

    public final void setTriangleKickTimer(int n) {
        this.triangleKickTimer = n;
    }

    public final int getBaseRescanCooldown() {
        return this.baseRescanCooldown;
    }

    public final void setBaseRescanCooldown(int n) {
        this.baseRescanCooldown = n;
    }

    public final boolean getMusicCausedByTBS() {
        return this.musicCausedByTBS;
    }

    public final void setMusicCausedByTBS(boolean bl) {
        this.musicCausedByTBS = bl;
    }

    public final int getFeverMessageProgression() {
        return this.feverMessageProgression;
    }

    public final void setFeverMessageProgression(int n) {
        this.feverMessageProgression = n;
    }

    public final boolean getInvertEnabled() {
        return this.invertEnabled;
    }

    public final void setInvertEnabled(boolean bl) {
        this.invertEnabled = bl;
    }

    public final long getInvertTimer() {
        return this.invertTimer;
    }

    public final void setInvertTimer(long l) {
        this.invertTimer = l;
    }

    public final int getLastX() {
        return this.lastX;
    }

    public final void setLastX(int n) {
        this.lastX = n;
    }

    public final int getLastZ() {
        return this.lastZ;
    }

    public final void setLastZ(int n) {
        this.lastZ = n;
    }

    public final int getCurrentX() {
        return this.currentX;
    }

    public final void setCurrentX(int n) {
        this.currentX = n;
    }

    public final int getCurrentZ() {
        return this.currentZ;
    }

    public final void setCurrentZ(int n) {
        this.currentZ = n;
    }

    public final boolean getSawTxtHint() {
        return this.sawTxtHint;
    }

    public final void setSawTxtHint(boolean bl) {
        this.sawTxtHint = bl;
    }

    @NotNull
    public final String getUserDir() {
        return this.userDir;
    }

    public final void setUserDir(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.userDir = string;
    }

    @NotNull
    public final WrappedBlockPosList getDoors() {
        return this.doors;
    }

    public final void setDoors(@NotNull WrappedBlockPosList wrappedBlockPosList) {
        Intrinsics.checkNotNullParameter((Object)wrappedBlockPosList, (String)"<set-?>");
        this.doors = wrappedBlockPosList;
    }

    public final boolean getIsolationActive() {
        return this.isolationActive;
    }

    public final void setIsolationActive(boolean bl) {
        this.isolationActive = bl;
    }

    public final int getIsolationTimer() {
        return this.isolationTimer;
    }

    public final void setIsolationTimer(int n) {
        this.isolationTimer = n;
    }

    @NotNull
    public final WrappedUUIDSet getIsolationAllowedUsers() {
        return this.isolationAllowedUsers;
    }

    public final boolean getForceMetaParanoia() {
        return this.forceMetaParanoia;
    }

    public final void setForceMetaParanoia(boolean bl) {
        this.forceMetaParanoia = bl;
    }

    public final boolean getLoadingPhase2() {
        return this.loadingPhase2;
    }

    public final void setLoadingPhase2(boolean bl) {
        this.loadingPhase2 = bl;
    }

    public final boolean getLoadingPhase3() {
        return this.loadingPhase3;
    }

    public final void setLoadingPhase3(boolean bl) {
        this.loadingPhase3 = bl;
    }

    public final boolean getGlitchesEnabled() {
        return this.glitchesEnabled;
    }

    public final void setGlitchesEnabled(boolean bl) {
        this.glitchesEnabled = bl;
    }

    public final boolean getDreamEnabled() {
        return this.dreamEnabled;
    }

    public final void setDreamEnabled(boolean bl) {
        this.dreamEnabled = bl;
    }

    public final boolean getVoidBox() {
        return this.voidBox;
    }

    public final void setVoidBox(boolean bl) {
        this.voidBox = bl;
    }

    public final boolean getCheckedVhsEnabled() {
        return this.vhsEnabled && TBSConfigs.INSTANCE.getClient().getEnableVhsOverlay();
    }

    public final boolean getCheckedAberrationEnabled() {
        return this.aberrationEnabled && TBSConfigs.INSTANCE.getClient().getAccessibility().getEnableAberration();
    }

    public final boolean getCheckedGlitchesEnabled() {
        return this.glitchesEnabled;
    }

    public final boolean getCheckedDreamEnabled() {
        return this.dreamEnabled;
    }

    public final boolean getCheckedVoidBoxEnabled() {
        return this.voidBox;
    }

    public final boolean getCheckedInvertEnabled() {
        return this.invertEnabled;
    }

    public final boolean getEnableMoonGlitch() {
        return this.moonGlitchDuration > 0.0;
    }

    public final void setEnableMoonGlitch(boolean value) {
        this.moonGlitchDuration = value ? 1600.0 : 0.0;
    }

    public final void syncTo(@NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        PlayerUtil.trySendCustomPacket((Player)player, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.PLAYER_VARS_SYNC.of(this)));
    }

    @NotNull
    public Tag serializeNbt(@NotNull HolderLookup.Provider provider2) {
        Intrinsics.checkNotNullParameter((Object)provider2, (String)"provider");
        return EndecExt.INSTANCE.encodeNbtOrThrow(ENDEC, (Object)this);
    }

    /*
     * WARNING - void declaration
     */
    public void deserializeNbt(@NotNull HolderLookup.Provider provider2, @NotNull Tag tag) {
        void $this$forEach$iv;
        void $this$filterIsInstanceTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)provider2, (String)"provider");
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        PlayerVariables data = (PlayerVariables)EndecExt.INSTANCE.decodeNbtOrThrow(ENDEC, tag);
        Iterable $this$filterIsInstance$iv = KClasses.getMemberProperties((KClass)Reflection.getOrCreateKotlinClass(this.getClass()));
        boolean $i$f$filterIsInstance = false;
        Iterable iterable = $this$filterIsInstance$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterIsInstanceTo = false;
        for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
            if (!(element$iv$iv instanceof KMutableProperty)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $this$filterIsInstance$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Object value;
            Object object;
            Object v0;
            KMutableProperty property;
            block5: {
                property = (KMutableProperty)element$iv;
                boolean bl = false;
                Iterable iterable2 = KClasses.getMemberProperties((KClass)Reflection.getOrCreateKotlinClass(data.getClass()));
                for (Object t : iterable2) {
                    KProperty1 it = (KProperty1)t;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)it.getName(), (Object)property.getName())) continue;
                    v0 = t;
                    break block5;
                }
                v0 = null;
            }
            KProperty1 kProperty1 = v0;
            if (kProperty1 != null) {
                Object[] objectArray = new Object[]{data};
                object = kProperty1.call(objectArray);
            } else {
                object = null;
            }
            if ((value = object) == null) continue;
            Object[] objectArray = new Object[]{this, value};
            property.getSetter().call(objectArray);
        }
    }

    public final boolean getMetaParanoia() {
        return this.forceMetaParanoia || this.isDesync || this.lookedAtOblit;
    }

    public PlayerVariables() {
        this(0, null, false, 0, null, 0, false, false, false, 0.0, 0L, 0L, false, false, false, null, 0.0, false, false, 0.0f, 0L, false, null, false, null, false, false, 0, 0, false, 0L, 0L, 0, 0L, 0, 0, false, 0, false, 0L, 0, 0, 0, 0, false, null, null, false, 0, null, false, false, false, false, false, false, -1, 0xFFFFFF, null);
    }

    /*
     * WARNING - void declaration
     */
    static {
        void this_$iv;
        Companion = new Companion(null);
        KClass $this$endec$iv = Reflection.getOrCreateKotlinClass(PlayerVariables.class);
        boolean $i$f$getEndec = false;
        $this$endec$iv = new KClassEndec($this$endec$iv);
        Endec endec2 = Endec.forEnum(CameraMode.class);
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"forEnum(...)");
        Endec endec$iv = endec2;
        boolean $i$f$withEndec = false;
        ENDEC = (Endec)this_$iv.withEndec(Reflection.getOrCreateKotlinClass(CameraMode.class), endec$iv);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/data/PlayerVariables$Companion;", "", "<init>", "()V", "MOON_GLITCH_DURATION_SECS", "", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/data/PlayerVariables;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

