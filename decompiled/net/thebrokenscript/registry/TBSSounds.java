/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.sounds.SoundEvent
 *  net.thebrokenscript.brokencore.api.registry.builders.SoundBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.SoundFileBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.brokencore.api.registry.builders.SoundBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.SoundFileBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b{\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010s\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010z\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0081\u0001"}, d2={"Lnet/thebrokenscript/registry/TBSSounds;", "", "<init>", "()V", "ALPHA3", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/sounds/SoundEvent;", "TREVOGA", "SILUET_CHASE", "NULL_CHASE", "HIM_SPAWN", "NULL_FLEE", "WHITE_NOISE", "RANDOM_SONG", "HEARTBEAT", "GLITCH_SOUND_1", "NULL_KILLS_PLAYER", "PHANTOM_DISAPPEAR", "BABY_DISAPPEAR", "FARD_DISAPPEAR", "NULL_SOUND_2", "TEXT_MADNESS_1", "NULL_DIM_AMBIENT", "NULL_SAD", "BSOD", "INTEGRITY_WATCHING", "NULL_JUMPSCARE_LOUD", "FOLLOW_CHASE_LOOP", "CCB_AMBIENT", "FALSE_CALM_2", "FEVER_WIND", "FEVER_WING", "THE_END_IS_NEAR", "RECORD_14", "RECORD_15_BETRAY", "RECORD_17_SILENCED", "NULL_IS_HERE_LOOP", "MAZE_SFX", "WOOD_SFX", "YOU_KNOW_NOTHING", "ONE_OF_US", "CURVED_TRANSFORM", "CURVED_NOTICE1", "CURVED_NOTICE2", "CURVED_NOTICE3", "CURVED_NOTICE4", "CURVED_NOTICE5", "CURVED_NOTICE6", "CURVED_DEATH", "CURVED_HURT", "CURVED_IDLE", "CURVED_STEP1", "CURVED_STEP2", "CURVED_STEP3", "CURVED_STEP4", "CURVED_STEP5", "OBLITERATION_SPEECH", "RECORD_16_YOU_CANT", "YOU_WILL_REGRET_THAT", "CIRCUIT_DECEIVE", "MOON_GLITCH", "INTEGRITY_DIES", "PURGATORY_AMBIENCE", "CIRCUIT_JUMPSCARE", "THE_BROKEN_END_CHASE", "TBE_INTRO", "CIRCUIT_INTRO", "CIRCUIT_CHASE", "MAZE_CHASE", "FALSE_SUBWOOFER_LULLABY", "CURVED_SPAWN", "INSTABILITY", "INSTABILITYV2", "INSTABILITYV3", "INSTABILITY_MUSIC_BOX", "LILLY_THEME", "LILLY_THEME_V2", "QUIT_BUTTON_BREAK", "BAD_SUN_SIREN", "GORE_BREAK", "GORE_DIG", "TAPE_HISS", "TAPE_SCRATCH", "HALLUCINATION_POOF", "TBE_SPAWN1", "TBE_SPAWN2", "TBE_SPAWN3", "TRAVEL", "TRAVEL_GLITCHED", "CREDITS", "GLITCH_OVERLAY", "MENU_MUSIC", "DAY_A_AMBIENCE", "LUCID_AMBIENCE", "FLESH_TUNNEL_AMBIENCE", "STONE_FLOOR_AMBIENCE", "LIBRARY_AMBIENCE", "NOWHERE", "LIMBO", "CONCRETE", "INF_STAIRS", "KERFUR_MEOW", "MURDERFUR_PHASE_1", "MURDERFUR_PHASE_2", "MURDERFUR_PHASE_3", "MOON_CRACK", "PSST", "JIMMY_STEP", "JIMMY_STUN", "JIMMY_ROAR", "JIMMY_SPAWN", "NOTHING_AMBIENCE", "JON_HELLO", "JON_PLAY", "TICK", "TOCK", "REEL", "SPIDER_WALK", "SPIDER_NOISE", "CHORD_DEATH", "CHORD_SHOOT", "CHORD_SPAWN", "JIMBOB_LOOP", "JIMBOB_INTRO", "JIMBOB_FULL", "MOONRISE_P1", "MOONRISE_P2", "MOONRISE_P3", "TEKKIT_GUN_SFX", "thebrokenscript-common"})
public final class TBSSounds {
    @NotNull
    public static final TBSSounds INSTANCE = new TBSSounds();
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> ALPHA3 = TBSReg.INSTANCE.sound("video/alpha3", TBSSounds::ALPHA3$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TREVOGA = TBSReg.INSTANCE.sound("trevoga", TBSSounds::TREVOGA$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> SILUET_CHASE = TBSReg.INSTANCE.sound("siluet_chase", TBSSounds::SILUET_CHASE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NULL_CHASE = TBSReg.INSTANCE.sound("null_chase", TBSSounds::NULL_CHASE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> HIM_SPAWN = TBSReg.INSTANCE.sound("rare_thing_spawn", TBSSounds::HIM_SPAWN$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NULL_FLEE = TBSReg.INSTANCE.sound("null_flee", TBSSounds::NULL_FLEE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> WHITE_NOISE = TBSReg.INSTANCE.sound("white_noise", TBSSounds::WHITE_NOISE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> RANDOM_SONG = TBSReg.INSTANCE.sound("random_song", TBSSounds::RANDOM_SONG$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> HEARTBEAT = TBSReg.INSTANCE.sound("heartbeat", TBSSounds::HEARTBEAT$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> GLITCH_SOUND_1 = TBSReg.INSTANCE.sound("glitch_sound_1", TBSSounds::GLITCH_SOUND_1$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NULL_KILLS_PLAYER = TBSReg.INSTANCE.sound("kills_player", TBSSounds::NULL_KILLS_PLAYER$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> PHANTOM_DISAPPEAR = TBSReg.INSTANCE.sound("phantom", TBSSounds::PHANTOM_DISAPPEAR$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> BABY_DISAPPEAR = TBSReg.INSTANCE.sound("baby", TBSSounds::BABY_DISAPPEAR$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> FARD_DISAPPEAR = TBSReg.INSTANCE.sound("fardaway", TBSSounds::FARD_DISAPPEAR$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NULL_SOUND_2 = TBSReg.INSTANCE.sound("null_sound_2", TBSSounds::NULL_SOUND_2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TEXT_MADNESS_1 = TBSReg.INSTANCE.sound("text_madness_1", TBSSounds::TEXT_MADNESS_1$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NULL_DIM_AMBIENT = TBSReg.INSTANCE.sound("null_dimension_ambient", TBSSounds::NULL_DIM_AMBIENT$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NULL_SAD = TBSReg.INSTANCE.sound("null_sad", TBSSounds::NULL_SAD$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> BSOD = TBSReg.INSTANCE.sound("bsod", TBSSounds::BSOD$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> INTEGRITY_WATCHING = TBSReg.INSTANCE.sound("integrity_watching", TBSSounds::INTEGRITY_WATCHING$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NULL_JUMPSCARE_LOUD = TBSReg.INSTANCE.sound("null_jumpscare_notloudanymore", TBSSounds::NULL_JUMPSCARE_LOUD$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> FOLLOW_CHASE_LOOP = TBSReg.INSTANCE.sound("follow_chase_loop", TBSSounds::FOLLOW_CHASE_LOOP$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CCB_AMBIENT = TBSReg.INSTANCE.sound("ccb_ambient", TBSSounds::CCB_AMBIENT$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> FALSE_CALM_2 = TBSReg.INSTANCE.sound("false_calm_2", TBSSounds::FALSE_CALM_2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> FEVER_WIND = TBSReg.INSTANCE.sound("fever.wind", TBSSounds::FEVER_WIND$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> FEVER_WING = TBSReg.INSTANCE.sound("fever.wing", TBSSounds::FEVER_WING$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> THE_END_IS_NEAR = TBSReg.INSTANCE.sound("the_end_is_near", TBSSounds::THE_END_IS_NEAR$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> RECORD_14 = TBSReg.INSTANCE.sound("record14", TBSSounds::RECORD_14$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> RECORD_15_BETRAY = TBSReg.INSTANCE.sound("disc15_betray", TBSSounds::RECORD_15_BETRAY$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> RECORD_17_SILENCED = TBSReg.INSTANCE.sound("disc17", TBSSounds::RECORD_17_SILENCED$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NULL_IS_HERE_LOOP = TBSReg.INSTANCE.sound("null_is_here_loop", TBSSounds::NULL_IS_HERE_LOOP$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MAZE_SFX = TBSReg.INSTANCE.sound("mazesfx", TBSSounds::MAZE_SFX$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> WOOD_SFX = TBSReg.INSTANCE.sound("woodsfx", TBSSounds::WOOD_SFX$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> YOU_KNOW_NOTHING = TBSReg.INSTANCE.sound("you_know_nothing", TBSSounds::YOU_KNOW_NOTHING$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> ONE_OF_US = TBSReg.INSTANCE.sound("one_of_us", TBSSounds::ONE_OF_US$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_TRANSFORM = TBSReg.INSTANCE.sound("transform", TBSSounds::CURVED_TRANSFORM$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_NOTICE1 = TBSReg.INSTANCE.sound("curved/curved_notice1", TBSSounds::CURVED_NOTICE1$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_NOTICE2 = TBSReg.INSTANCE.sound("curved/curved_notice2", TBSSounds::CURVED_NOTICE2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_NOTICE3 = TBSReg.INSTANCE.sound("curved/curved_notice3", TBSSounds::CURVED_NOTICE3$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_NOTICE4 = TBSReg.INSTANCE.sound("curved/curved_notice4", TBSSounds::CURVED_NOTICE4$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_NOTICE5 = TBSReg.INSTANCE.sound("curved/curved_notice5", TBSSounds::CURVED_NOTICE5$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_NOTICE6 = TBSReg.INSTANCE.sound("curved/curved_notice6", TBSSounds::CURVED_NOTICE6$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_DEATH = TBSReg.INSTANCE.sound("c_death", TBSSounds::CURVED_DEATH$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_HURT = TBSReg.INSTANCE.sound("curved/curved_hurt", TBSSounds::CURVED_HURT$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_IDLE = TBSReg.INSTANCE.sound("curved/curved_idle", TBSSounds::CURVED_IDLE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_STEP1 = TBSReg.INSTANCE.sound("curved/curved_step_1", TBSSounds::CURVED_STEP1$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_STEP2 = TBSReg.INSTANCE.sound("curved/curved_step_2", TBSSounds::CURVED_STEP2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_STEP3 = TBSReg.INSTANCE.sound("curved/curved_step_3", TBSSounds::CURVED_STEP3$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_STEP4 = TBSReg.INSTANCE.sound("curved/curved_step_4", TBSSounds::CURVED_STEP4$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_STEP5 = TBSReg.INSTANCE.sound("curved/curved_step_5", TBSSounds::CURVED_STEP5$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> OBLITERATION_SPEECH = TBSReg.INSTANCE.sound("oblit/obliterationspeech", TBSSounds::OBLITERATION_SPEECH$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> RECORD_16_YOU_CANT = TBSReg.INSTANCE.sound("disc16_youcant", TBSSounds::RECORD_16_YOU_CANT$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> YOU_WILL_REGRET_THAT = TBSReg.INSTANCE.sound("you_will_regret_that", TBSSounds::YOU_WILL_REGRET_THAT$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CIRCUIT_DECEIVE = TBSReg.INSTANCE.sound("circuit_deceive", TBSSounds::CIRCUIT_DECEIVE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MOON_GLITCH = TBSReg.INSTANCE.sound("moon_glitch", TBSSounds::MOON_GLITCH$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> INTEGRITY_DIES = TBSReg.INSTANCE.sound("integrity_dies", TBSSounds::INTEGRITY_DIES$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> PURGATORY_AMBIENCE = TBSReg.INSTANCE.sound("purgatory_ambience", TBSSounds::PURGATORY_AMBIENCE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CIRCUIT_JUMPSCARE = TBSReg.INSTANCE.sound("circuit_jumpscare_sound", TBSSounds::CIRCUIT_JUMPSCARE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> THE_BROKEN_END_CHASE = TBSReg.INSTANCE.sound("the_broken_end_chase", TBSSounds::THE_BROKEN_END_CHASE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TBE_INTRO = TBSReg.INSTANCE.sound("tbe_intro", TBSSounds::TBE_INTRO$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CIRCUIT_INTRO = TBSReg.INSTANCE.sound("circuit_intro", TBSSounds::CIRCUIT_INTRO$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CIRCUIT_CHASE = TBSReg.INSTANCE.sound("circuit_chase", TBSSounds::CIRCUIT_CHASE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MAZE_CHASE = TBSReg.INSTANCE.sound("maze_chase", TBSSounds::MAZE_CHASE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> FALSE_SUBWOOFER_LULLABY = TBSReg.INSTANCE.sound("false_subwoofer_lullaby", TBSSounds::FALSE_SUBWOOFER_LULLABY$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CURVED_SPAWN = TBSReg.INSTANCE.sound("curved_spawn", TBSSounds::CURVED_SPAWN$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> INSTABILITY = TBSReg.INSTANCE.sound("instability", TBSSounds::INSTABILITY$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> INSTABILITYV2 = TBSReg.INSTANCE.sound("instability_v2", TBSSounds::INSTABILITYV2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> INSTABILITYV3 = TBSReg.INSTANCE.sound("instability_v3", TBSSounds::INSTABILITYV3$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> INSTABILITY_MUSIC_BOX = TBSReg.INSTANCE.sound("instability_music_box", TBSSounds::INSTABILITY_MUSIC_BOX$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> LILLY_THEME = TBSReg.INSTANCE.sound("lilly_theme", TBSSounds::LILLY_THEME$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> LILLY_THEME_V2 = TBSReg.INSTANCE.sound("lilly_theme_v2", TBSSounds::LILLY_THEME_V2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> QUIT_BUTTON_BREAK = TBSReg.INSTANCE.sound("button_break", TBSSounds::QUIT_BUTTON_BREAK$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> BAD_SUN_SIREN = TBSReg.INSTANCE.sound("bad_sun_siren", TBSSounds::BAD_SUN_SIREN$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> GORE_BREAK = TBSReg.INSTANCE.sound("gore_break", TBSSounds::GORE_BREAK$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> GORE_DIG = TBSReg.INSTANCE.sound("gore_dig", TBSSounds::GORE_DIG$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TAPE_HISS = TBSReg.INSTANCE.sound("tape_hiss", TBSSounds::TAPE_HISS$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TAPE_SCRATCH = TBSReg.INSTANCE.sound("vhs_scratch", TBSSounds::TAPE_SCRATCH$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> HALLUCINATION_POOF = TBSReg.INSTANCE.sound("hallucination_fade", TBSSounds::HALLUCINATION_POOF$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TBE_SPAWN1 = TBSReg.INSTANCE.sound("tbespawn1", TBSSounds::TBE_SPAWN1$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TBE_SPAWN2 = TBSReg.INSTANCE.sound("tbespawn2", TBSSounds::TBE_SPAWN2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TBE_SPAWN3 = TBSReg.INSTANCE.sound("tbespawn3", TBSSounds::TBE_SPAWN3$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TRAVEL = TBSReg.INSTANCE.sound("travel", TBSSounds::TRAVEL$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TRAVEL_GLITCHED = TBSReg.INSTANCE.sound("travel_broken", TBSSounds::TRAVEL_GLITCHED$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CREDITS = TBSReg.INSTANCE.sound("credits", TBSSounds::CREDITS$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> GLITCH_OVERLAY = TBSReg.INSTANCE.sound("glitch_overlay", TBSSounds::GLITCH_OVERLAY$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MENU_MUSIC = TBSReg.INSTANCE.sound("menu_music", TBSSounds::MENU_MUSIC$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> DAY_A_AMBIENCE = TBSReg.INSTANCE.sound("cursed_music", TBSSounds::DAY_A_AMBIENCE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> LUCID_AMBIENCE = TBSReg.INSTANCE.sound("lucid_blocks", TBSSounds::LUCID_AMBIENCE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> FLESH_TUNNEL_AMBIENCE = TBSReg.INSTANCE.sound("ambience/flesh_tunnel", TBSSounds::FLESH_TUNNEL_AMBIENCE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> STONE_FLOOR_AMBIENCE = TBSReg.INSTANCE.sound("ambience/stone", TBSSounds::STONE_FLOOR_AMBIENCE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> LIBRARY_AMBIENCE = TBSReg.INSTANCE.sound("library", TBSSounds::LIBRARY_AMBIENCE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NOWHERE = TBSReg.INSTANCE.sound("nowhere_amb", TBSSounds::NOWHERE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> LIMBO = TBSReg.INSTANCE.sound("limbo_amb", TBSSounds::LIMBO$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CONCRETE = TBSReg.INSTANCE.sound("concrete_amb", TBSSounds::CONCRETE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> INF_STAIRS = TBSReg.INSTANCE.sound("inf_stairs_ambience", TBSSounds::INF_STAIRS$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> KERFUR_MEOW = TBSReg.INSTANCE.sound("kerfur_meow", TBSSounds::KERFUR_MEOW$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MURDERFUR_PHASE_1 = TBSReg.INSTANCE.sound("murderfur_phase_1", TBSSounds::MURDERFUR_PHASE_1$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MURDERFUR_PHASE_2 = TBSReg.INSTANCE.sound("murderfur_phase_2", TBSSounds::MURDERFUR_PHASE_2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MURDERFUR_PHASE_3 = TBSReg.INSTANCE.sound("murderfur_phase_3", TBSSounds::MURDERFUR_PHASE_3$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MOON_CRACK = TBSReg.INSTANCE.sound("moon_crack", TBSSounds::MOON_CRACK$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> PSST = TBSReg.INSTANCE.sound("psst", TBSSounds::PSST$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> JIMMY_STEP = TBSReg.INSTANCE.sound("jimmy.step", TBSSounds::JIMMY_STEP$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> JIMMY_STUN = TBSReg.INSTANCE.sound("jimmy.stun", TBSSounds::JIMMY_STUN$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> JIMMY_ROAR = TBSReg.INSTANCE.sound("jimmy.roar", TBSSounds::JIMMY_ROAR$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> JIMMY_SPAWN = TBSReg.INSTANCE.sound("jimmy.spawn", TBSSounds::JIMMY_SPAWN$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> NOTHING_AMBIENCE = TBSReg.INSTANCE.sound("ambience.nothing", TBSSounds::NOTHING_AMBIENCE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> JON_HELLO = TBSReg.INSTANCE.sound("jon.hello", TBSSounds::JON_HELLO$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> JON_PLAY = TBSReg.INSTANCE.sound("jon.play", TBSSounds::JON_PLAY$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TICK = TBSReg.INSTANCE.sound("tick", TBSSounds::TICK$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TOCK = TBSReg.INSTANCE.sound("tock", TBSSounds::TOCK$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> REEL = TBSReg.INSTANCE.sound("reel", TBSSounds::REEL$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> SPIDER_WALK = TBSReg.INSTANCE.sound("spider_walk", TBSSounds::SPIDER_WALK$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> SPIDER_NOISE = TBSReg.INSTANCE.sound("spider_noise", TBSSounds::SPIDER_NOISE$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CHORD_DEATH = TBSReg.INSTANCE.sound("chord.death", TBSSounds::CHORD_DEATH$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CHORD_SHOOT = TBSReg.INSTANCE.sound("chord.shoot", TBSSounds::CHORD_SHOOT$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> CHORD_SPAWN = TBSReg.INSTANCE.sound("chord.spawn", TBSSounds::CHORD_SPAWN$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> JIMBOB_LOOP = TBSReg.INSTANCE.sound("jimbob.loop", TBSSounds::JIMBOB_LOOP$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> JIMBOB_INTRO = TBSReg.INSTANCE.sound("jimbob.intro", TBSSounds::JIMBOB_INTRO$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> JIMBOB_FULL = TBSReg.INSTANCE.sound("jimbob.full", TBSSounds::JIMBOB_FULL$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MOONRISE_P1 = TBSReg.INSTANCE.sound("jimmy.moonrise.p1", TBSSounds::MOONRISE_P1$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MOONRISE_P2 = TBSReg.INSTANCE.sound("jimmy.moonrise.p2", TBSSounds::MOONRISE_P2$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> MOONRISE_P3 = TBSReg.INSTANCE.sound("jimmy.moonrise.p3", TBSSounds::MOONRISE_P3$lambda$0);
    @JvmField
    @NotNull
    public static final RegistryEntry<SoundEvent, SoundEvent> TEKKIT_GUN_SFX = TBSReg.INSTANCE.sound("tekkit.gun", TBSSounds::TEKKIT_GUN_SFX$lambda$0);

    private TBSSounds() {
    }

    private static final void ALPHA3$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void TREVOGA$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "[][][]";
    }

    private static final void SILUET_CHASE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void NULL_CHASE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("null/instance", arg_0 -> TBSSounds.NULL_CHASE$lambda$0$0($this$sound, arg_0));
        $this$sound.noSubtitle();
    }

    private static final Unit NULL_CHASE$lambda$0$0(SoundBuilder $this_sound, SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        SoundBuilder.simple$default((SoundBuilder)$this_sound, (boolean)false, (int)1, null);
        $this$file.volume = Float.valueOf(0.85f);
        return Unit.INSTANCE;
    }

    private static final void HIM_SPAWN$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void NULL_FLEE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void WHITE_NOISE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void RANDOM_SONG$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void HEARTBEAT$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void GLITCH_SOUND_1$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void NULL_KILLS_PLAYER$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("null_kills_player", TBSSounds::NULL_KILLS_PLAYER$lambda$0$0);
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final Unit NULL_KILLS_PLAYER$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(0.035f);
        return Unit.INSTANCE;
    }

    private static final void PHANTOM_DISAPPEAR$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("phantom_disappear", TBSSounds::PHANTOM_DISAPPEAR$lambda$0$0);
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final Unit PHANTOM_DISAPPEAR$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(0.15f);
        return Unit.INSTANCE;
    }

    private static final void BABY_DISAPPEAR$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("baby_disappear", TBSSounds::BABY_DISAPPEAR$lambda$0$0);
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final Unit BABY_DISAPPEAR$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(1.0f);
        return Unit.INSTANCE;
    }

    private static final void FARD_DISAPPEAR$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("funny/fardaway", TBSSounds::FARD_DISAPPEAR$lambda$0$0);
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final Unit FARD_DISAPPEAR$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(1.0f);
        return Unit.INSTANCE;
    }

    private static final void NULL_SOUND_2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void TEXT_MADNESS_1$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void NULL_DIM_AMBIENT$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void NULL_SAD$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void BSOD$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void INTEGRITY_WATCHING$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void NULL_JUMPSCARE_LOUD$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("null_jumpscare_loud", TBSSounds::NULL_JUMPSCARE_LOUD$lambda$0$0);
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final Unit NULL_JUMPSCARE_LOUD$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(0.01f);
        return Unit.INSTANCE;
    }

    private static final void FOLLOW_CHASE_LOOP$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CCB_AMBIENT$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void FALSE_CALM_2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void FEVER_WIND$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void FEVER_WING$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"fever/wing1", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"fever/wing2", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"fever/wing3", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"fever/wing4", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void THE_END_IS_NEAR$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("the_end_is_near", TBSSounds::THE_END_IS_NEAR$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit THE_END_IS_NEAR$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = false;
        $this$file.volume = Float.valueOf(0.45f);
        return Unit.INSTANCE;
    }

    private static final void RECORD_14$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void RECORD_15_BETRAY$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void RECORD_17_SILENCED$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("disc17_silenced", TBSSounds::RECORD_17_SILENCED$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit RECORD_17_SILENCED$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = false;
        $this$file.volume = Float.valueOf(0.6f);
        return Unit.INSTANCE;
    }

    private static final void NULL_IS_HERE_LOOP$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void MAZE_SFX$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("sfx/mazesfx1", arg_0 -> TBSSounds.MAZE_SFX$lambda$0$0($this$sound, arg_0));
        $this$sound.file("sfx/mazesfx2", arg_0 -> TBSSounds.MAZE_SFX$lambda$0$1($this$sound, arg_0));
        $this$sound.noSubtitle();
    }

    private static final Unit MAZE_SFX$lambda$0$0(SoundBuilder $this_sound, SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this_sound.simple(false);
        return Unit.INSTANCE;
    }

    private static final Unit MAZE_SFX$lambda$0$1(SoundBuilder $this_sound, SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this_sound.simple(false);
        return Unit.INSTANCE;
    }

    private static final void WOOD_SFX$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("sfx/woodsfx1", arg_0 -> TBSSounds.WOOD_SFX$lambda$0$0($this$sound, arg_0));
        $this$sound.file("sfx/woodsfx2", arg_0 -> TBSSounds.WOOD_SFX$lambda$0$1($this$sound, arg_0));
        $this$sound.noSubtitle();
    }

    private static final Unit WOOD_SFX$lambda$0$0(SoundBuilder $this_sound, SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this_sound.simple(false);
        return Unit.INSTANCE;
    }

    private static final Unit WOOD_SFX$lambda$0$1(SoundBuilder $this_sound, SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this_sound.simple(false);
        return Unit.INSTANCE;
    }

    private static final void YOU_KNOW_NOTHING$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void ONE_OF_US$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CURVED_TRANSFORM$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("curved/curved_transform", TBSSounds::CURVED_TRANSFORM$lambda$0$0);
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final Unit CURVED_TRANSFORM$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(0.05f);
        return Unit.INSTANCE;
    }

    private static final void CURVED_NOTICE1$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "Hello?";
    }

    private static final void CURVED_NOTICE2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "Who is there?";
    }

    private static final void CURVED_NOTICE3$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "Who are you?";
    }

    private static final void CURVED_NOTICE4$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "What did you do?";
    }

    private static final void CURVED_NOTICE5$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "I hear you.";
    }

    private static final void CURVED_NOTICE6$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "Is that you?";
    }

    private static final void CURVED_DEATH$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("curved/curved_death", TBSSounds::CURVED_DEATH$lambda$0$0);
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final Unit CURVED_DEATH$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(0.9f);
        return Unit.INSTANCE;
    }

    private static final void CURVED_HURT$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CURVED_IDLE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void CURVED_STEP1$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CURVED_STEP2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CURVED_STEP3$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CURVED_STEP4$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CURVED_STEP5$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void OBLITERATION_SPEECH$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void RECORD_16_YOU_CANT$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void YOU_WILL_REGRET_THAT$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CIRCUIT_DECEIVE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void MOON_GLITCH$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "integrity.curious";
    }

    private static final void INTEGRITY_DIES$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void PURGATORY_AMBIENCE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CIRCUIT_JUMPSCARE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("circuit_jumpscare", TBSSounds::CIRCUIT_JUMPSCARE$lambda$0$0);
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final Unit CIRCUIT_JUMPSCARE$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(0.2f);
        return Unit.INSTANCE;
    }

    private static final void THE_BROKEN_END_CHASE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void TBE_INTRO$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CIRCUIT_INTRO$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CIRCUIT_CHASE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void MAZE_CHASE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void FALSE_SUBWOOFER_LULLABY$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CURVED_SPAWN$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void INSTABILITY$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void INSTABILITYV2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void INSTABILITYV3$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void INSTABILITY_MUSIC_BOX$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void LILLY_THEME$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void LILLY_THEME_V2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void QUIT_BUTTON_BREAK$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void BAD_SUN_SIREN$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void GORE_BREAK$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"gore_break_0", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"gore_break_1", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"gore_break_2", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void GORE_DIG$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"gore_dig_0", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"gore_dig_1", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void TAPE_HISS$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void TAPE_SCRATCH$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void HALLUCINATION_POOF$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void TBE_SPAWN1$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void TBE_SPAWN2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void TBE_SPAWN3$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void TRAVEL$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void TRAVEL_GLITCHED$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void CREDITS$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "Credits Music";
    }

    private static final void GLITCH_OVERLAY$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.subtitle = "$#*&!)%(*@?";
    }

    private static final void MENU_MUSIC$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("music/menu1", TBSSounds::MENU_MUSIC$lambda$0$0);
        $this$sound.file("music/menu2", TBSSounds::MENU_MUSIC$lambda$0$1);
        $this$sound.file("music/menu3", TBSSounds::MENU_MUSIC$lambda$0$2);
        $this$sound.file("music/menu4", TBSSounds::MENU_MUSIC$lambda$0$3);
        $this$sound.subtitle = "Menu Music";
    }

    private static final Unit MENU_MUSIC$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        $this$file.volume = Float.valueOf(0.3f);
        return Unit.INSTANCE;
    }

    private static final Unit MENU_MUSIC$lambda$0$1(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        $this$file.volume = Float.valueOf(0.3f);
        return Unit.INSTANCE;
    }

    private static final Unit MENU_MUSIC$lambda$0$2(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        $this$file.volume = Float.valueOf(0.3f);
        return Unit.INSTANCE;
    }

    private static final Unit MENU_MUSIC$lambda$0$3(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        $this$file.volume = Float.valueOf(0.3f);
        return Unit.INSTANCE;
    }

    private static final void DAY_A_AMBIENCE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("ambience/sweden", TBSSounds::DAY_A_AMBIENCE$lambda$0$0);
        $this$sound.file("ambience/living_mice", TBSSounds::DAY_A_AMBIENCE$lambda$0$1);
        $this$sound.file("ambience/haggstrom", TBSSounds::DAY_A_AMBIENCE$lambda$0$2);
        $this$sound.file("ambience/minecraft", TBSSounds::DAY_A_AMBIENCE$lambda$0$3);
        $this$sound.file("ambience/excuse", TBSSounds::DAY_A_AMBIENCE$lambda$0$4);
        $this$sound.noSubtitle();
    }

    private static final Unit DAY_A_AMBIENCE$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final Unit DAY_A_AMBIENCE$lambda$0$1(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final Unit DAY_A_AMBIENCE$lambda$0$2(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final Unit DAY_A_AMBIENCE$lambda$0$3(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final Unit DAY_A_AMBIENCE$lambda$0$4(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final void LUCID_AMBIENCE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("lucid_blocks_easteregg/lucid_fever", TBSSounds::LUCID_AMBIENCE$lambda$0$0);
    }

    private static final Unit LUCID_AMBIENCE$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final void FLESH_TUNNEL_AMBIENCE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void STONE_FLOOR_AMBIENCE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.simple(true);
        $this$sound.noSubtitle();
    }

    private static final void LIBRARY_AMBIENCE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("ambience/library", TBSSounds::LIBRARY_AMBIENCE$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit LIBRARY_AMBIENCE$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        $this$file.volume = Float.valueOf(0.45f);
        return Unit.INSTANCE;
    }

    private static final void NOWHERE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("ambience/nowhere", TBSSounds::NOWHERE$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit NOWHERE$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final void LIMBO$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("ambience/limbo", TBSSounds::LIMBO$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit LIMBO$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final void CONCRETE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("ambience/concrete", TBSSounds::CONCRETE$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit CONCRETE$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final void INF_STAIRS$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("ambience/infinite_stairs", TBSSounds::INF_STAIRS$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit INF_STAIRS$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final void KERFUR_MEOW$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"e/kerfur_meow_1", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"e/kerfur_meow_2", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"e/kerfur_meow_3", null, (int)2, null);
        $this$sound.subtitle = "Kerfur Meows";
    }

    private static final void MURDERFUR_PHASE_1$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"e/murderfur_phase_1", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void MURDERFUR_PHASE_2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"e/murderfur_phase_2", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void MURDERFUR_PHASE_3$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"e/murderfur_phase_3", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void MOON_CRACK$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("the_moon", arg_0 -> TBSSounds.MOON_CRACK$lambda$0$0($this$sound, arg_0));
        $this$sound.noSubtitle();
    }

    private static final Unit MOON_CRACK$lambda$0$0(SoundBuilder $this_sound, SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        SoundBuilder.simple$default((SoundBuilder)$this_sound, (boolean)false, (int)1, null);
        $this$file.volume = Float.valueOf(1.0f);
        return Unit.INSTANCE;
    }

    private static final void PSST$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("psst", TBSSounds::PSST$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit PSST$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(1.0f);
        $this$file.stream = false;
        return Unit.INSTANCE;
    }

    private static final void JIMMY_STEP$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"jimmy/step1", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"jimmy/step2", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"jimmy/step3", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"jimmy/step4", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void JIMMY_STUN$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"jimmy/stun", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void JIMMY_ROAR$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"jimmy/roar", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void JIMMY_SPAWN$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"jimmy/spawn", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void NOTHING_AMBIENCE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"ambience/nothing", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void JON_HELLO$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"jon/hello", null, (int)2, null);
        $this$sound.subtitle = "hello!";
    }

    private static final void JON_PLAY$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"jon/play", null, (int)2, null);
        $this$sound.subtitle = "let's play minecraft!";
    }

    private static final void TICK$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void TOCK$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default((SoundBuilder)$this$sound, (boolean)false, (int)1, null);
        $this$sound.noSubtitle();
    }

    private static final void REEL$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"reel", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void SPIDER_WALK$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"spider_walk", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void SPIDER_NOISE$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"spider_noise", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void CHORD_DEATH$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_death_1", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_death_2", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_death_3", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_death_4", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void CHORD_SHOOT$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_shoot_1", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_shoot_2", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_shoot_3", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_shoot_4", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void CHORD_SPAWN$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_spawn_1", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_spawn_2", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_spawn_3", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"chords/chord_spawn_4", null, (int)2, null);
        $this$sound.noSubtitle();
    }

    private static final void JIMBOB_LOOP$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("boss/jimbob_loop", TBSSounds::JIMBOB_LOOP$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit JIMBOB_LOOP$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(0.65f);
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final void JIMBOB_INTRO$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("boss/jimbob_intro", TBSSounds::JIMBOB_INTRO$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit JIMBOB_INTRO$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(0.65f);
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final void JIMBOB_FULL$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("boss/jimbob_full", TBSSounds::JIMBOB_FULL$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit JIMBOB_FULL$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.volume = Float.valueOf(0.4f);
        $this$file.stream = true;
        return Unit.INSTANCE;
    }

    private static final void MOONRISE_P1$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("jimmy/moonrise_p1", TBSSounds::MOONRISE_P1$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit MOONRISE_P1$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.preload = true;
        return Unit.INSTANCE;
    }

    private static final void MOONRISE_P2$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("jimmy/moonrise_p2", TBSSounds::MOONRISE_P2$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit MOONRISE_P2$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.preload = true;
        return Unit.INSTANCE;
    }

    private static final void MOONRISE_P3$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        $this$sound.file("jimmy/moonrise_p3", TBSSounds::MOONRISE_P3$lambda$0$0);
        $this$sound.noSubtitle();
    }

    private static final Unit MOONRISE_P3$lambda$0$0(SoundFileBuilder $this$file) {
        Intrinsics.checkNotNullParameter((Object)$this$file, (String)"$this$file");
        $this$file.preload = true;
        return Unit.INSTANCE;
    }

    private static final void TEKKIT_GUN_SFX$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/bang_1", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/bang_2", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/bang_3", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/bang_4", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/bang_5", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/pew_1", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/pew_2", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/pew_3", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/pew_4", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/pew_5", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/pew_5", null, (int)2, null);
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)"tekkit/pow", null, (int)2, null);
        $this$sound.noSubtitle();
    }
}

