/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.PackOutput$Target
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.PackType
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.VisibleForTesting
 */
package compat.net.neoforged.neoforge.client.model.generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import compat.net.neoforged.neoforge.client.model.generators.ModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ModelFile;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.thebrokenscript.brokencore.api.BCApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\bj\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u0098\u0001*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0002\u0098\u0001B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fBC\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u0012J\b\u0010\u001d\u001a\u00020\u001eH&J\u0013\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\t\u00a2\u0006\u0002\u0010!J\u0017\u0010\u001f\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0002J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\tJ\u000e\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\tJ\u001f\u0010(\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0007\u00a2\u0006\u0002\u0010*J\u001f\u0010(\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+JG\u0010,\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00103J'\u00104\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0002\u00a2\u0006\u0002\u00106J'\u00104\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J/\u00104\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0002\u00a2\u0006\u0002\u00109J/\u00104\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00072\u0006\u00108\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010:J\u001f\u0010;\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J'\u0010<\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J7\u0010?\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0002\u00a2\u0006\u0002\u0010AJ7\u0010?\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0002\u00a2\u0006\u0002\u0010BJ/\u0010C\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010DJ'\u0010E\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010G\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010H\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J7\u0010J\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010BJ/\u0010K\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010DJ\u001f\u0010L\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010L\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010M\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010M\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010N\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010O\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J/\u0010P\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010DJ/\u0010Q\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010DJ/\u0010R\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010DJ3\u0010S\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010DJ/\u0010T\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010DJ3\u0010U\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010DJ/\u0010V\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010DJ\u001f\u0010W\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010X\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010Y\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010Z\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010[\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010\\\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010]\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010^\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010_\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010`\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010a\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010b\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010c\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010d\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010f\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010g\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010h\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J/\u0010i\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010i\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0002\u00a2\u0006\u0002\u0010kJ'\u0010l\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010i\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010m\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010i\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010n\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010i\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J\u001f\u0010o\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010i\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010p\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010i\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J/\u0010q\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010r\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0002\u00a2\u0006\u0002\u0010kJ'\u0010s\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010t\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010u\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010v\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010w\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010x\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010y\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J'\u0010z\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u00107J\u001f\u0010{\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010|\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010}\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010~\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\u001f\u0010\u007f\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J \u0010\u0080\u0001\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J!\u0010\u0081\u0001\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0007\u0010\u0081\u0001\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J!\u0010\u0082\u0001\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0007\u0010\u0081\u0001\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J!\u0010\u0083\u0001\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J \u0010\u0085\u0001\u001a\u00028\u00002\b\b\u0002\u0010&\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010+J\r\u0010\u0086\u0001\u001a\u00028\u0000\u00a2\u0006\u0003\u0010\u0087\u0001J\u0010\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u0010 \u001a\u00020\u0007J\u0007\u0010\u008a\u0001\u001a\u00020\u001eJ\u0018\u0010\u008b\u0001\u001a\u0007\u0012\u0002\b\u00030\u008c\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0016J\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030\u0091\u00010\u0090\u0001J\u0016\u0010\u0092\u0001\u001a\u0007\u0012\u0002\b\u00030\u008c\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001J\u0018\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0006\u0010r\u001a\u00028\u0000H\u0004\u00a2\u0006\u0003\u0010\u0095\u0001J\u0017\u0010\u0096\u0001\u001a\u00020\t2\u0006\u0010r\u001a\u00028\u0000H\u0004\u00a2\u0006\u0003\u0010\u0097\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0085\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u000bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u001a8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u0099\u0001"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelProvider;", "T", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "Lnet/minecraft/data/DataProvider;", "output", "Lnet/minecraft/data/PackOutput;", "id", "Lnet/minecraft/resources/ResourceLocation;", "folder", "", "factory", "Lkotlin/Function1;", "existingFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/minecraft/resources/ResourceLocation;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "builderFromModId", "Lkotlin/Function2;", "(Lnet/minecraft/data/PackOutput;Lnet/minecraft/resources/ResourceLocation;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;)V", "getOutput", "()Lnet/minecraft/data/PackOutput;", "getFolder", "()Ljava/lang/String;", "getFactory", "()Lkotlin/jvm/functions/Function1;", "generatedModels", "", "getGeneratedModels", "()Ljava/util/Map;", "registerModels", "", "getBuilder", "path", "(Ljava/lang/String;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "(Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "extendWithFolder", "rl", "modLoc", "name", "mcLoc", "withExistingParent", "parent", "(Ljava/lang/String;Ljava/lang/String;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "cube", "down", "up", "north", "south", "east", "west", "(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "singleTexture", "texture", "(Ljava/lang/String;Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "textureKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "cubeAll", "cubeTop", "side", "top", "sideBottomTop", "bottom", "(Ljava/lang/String;Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "cubeBottomTop", "(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "cubeColumn", "end", "cubeColumnHorizontal", "orientableVertical", "front", "orientableWithBottom", "orientable", "crop", "cross", "flowerPot", "plant", "stairs", "stairsOuter", "stairsInner", "slab", "slabTop", "verticalSlab", "verticalSlabRight", "button", "buttonPressed", "buttonInventory", "pressurePlate", "pressurePlateDown", "sign", "fencePost", "fenceSide", "fenceInventory", "fenceGate", "fenceGateOpen", "fenceGateWall", "fenceGateWallOpen", "wallPost", "wall", "wallSide", "wallSideTall", "wallInventory", "pane", "edge", "(Ljava/lang/String;Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "panePost", "paneSide", "paneSideAlt", "paneNoSide", "paneNoSideAlt", "door", "model", "doorBottomLeft", "doorBottomLeftOpen", "doorBottomRight", "doorBottomRightOpen", "doorTopLeft", "doorTopLeftOpen", "doorTopRight", "doorTopRightOpen", "trapdoorBottom", "trapdoorTop", "trapdoorOpen", "trapdoorOrientableBottom", "trapdoorOrientableTop", "trapdoorOrientableOpen", "torch", "torchWall", "carpet", "wool", "leaves", "nested", "()Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;", "getExistingFile", "Lcompat/net/neoforged/neoforge/client/model/generators/ModelFile$ExistingModelFile;", "clear", "run", "Ljava/util/concurrent/CompletableFuture;", "cache", "Lnet/minecraft/data/CachedOutput;", "getJsons", "", "Lcom/google/gson/JsonElement;", "generateAll", "getPath", "Ljava/nio/file/Path;", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;)Ljava/nio/file/Path;", "getStringPath", "(Lcompat/net/neoforged/neoforge/client/model/generators/ModelBuilder;)Ljava/lang/String;", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nModelProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelProvider.kt\ncompat/net/neoforged/neoforge/client/model/generators/ModelProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,446:1\n1563#2:447\n1634#2,3:448\n37#3,2:451\n*S KotlinDebug\n*F\n+ 1 ModelProvider.kt\ncompat/net/neoforged/neoforge/client/model/generators/ModelProvider\n*L\n404#1:447\n404#1:448,3\n404#1:451,2\n*E\n"})
public abstract class ModelProvider<T extends ModelBuilder<T>>
implements DataProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final PackOutput output;
    @JvmField
    @NotNull
    protected final ResourceLocation id;
    @NotNull
    private final String folder;
    @NotNull
    private final Function1<ResourceLocation, T> factory;
    @JvmField
    @VisibleForTesting
    @NotNull
    public final ExistingFileHelper existingFileHelper;
    @VisibleForTesting
    @NotNull
    private final Map<ResourceLocation, T> generatedModels;
    @NotNull
    public static final String BLOCK_FOLDER = "block";
    @NotNull
    public static final String ITEM_FOLDER = "item";
    @JvmField
    @NotNull
    public static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
    @JvmField
    @NotNull
    public static final ExistingFileHelper.ResourceType MODEL = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".json", "models");
    @JvmField
    @NotNull
    public static final ExistingFileHelper.ResourceType MODEL_WITH_EXTENSION = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, "", "models");
    @NotNull
    private static final Gson GSON;

    public ModelProvider(@NotNull PackOutput output, @NotNull ResourceLocation id, @NotNull String folder, @NotNull Function1<? super ResourceLocation, ? extends T> factory2, @NotNull ExistingFileHelper existingFileHelper) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)folder, (String)"folder");
        Intrinsics.checkNotNullParameter(factory2, (String)"factory");
        Intrinsics.checkNotNullParameter((Object)existingFileHelper, (String)"existingFileHelper");
        this.output = output;
        this.id = id;
        this.folder = folder;
        this.factory = factory2;
        this.existingFileHelper = existingFileHelper;
        this.generatedModels = new LinkedHashMap();
    }

    @NotNull
    protected final PackOutput getOutput() {
        return this.output;
    }

    @NotNull
    protected final String getFolder() {
        return this.folder;
    }

    @NotNull
    protected final Function1<ResourceLocation, T> getFactory() {
        return this.factory;
    }

    @NotNull
    public final Map<ResourceLocation, T> getGeneratedModels() {
        return this.generatedModels;
    }

    public abstract void registerModels();

    public ModelProvider(@NotNull PackOutput output, @NotNull ResourceLocation id, @NotNull String folder, @NotNull Function2<? super ResourceLocation, ? super ExistingFileHelper, ? extends T> builderFromModId, @NotNull ExistingFileHelper existingFileHelper) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)folder, (String)"folder");
        Intrinsics.checkNotNullParameter(builderFromModId, (String)"builderFromModId");
        Intrinsics.checkNotNullParameter((Object)existingFileHelper, (String)"existingFileHelper");
        this(output, id, folder, arg_0 -> ModelProvider._init_$lambda$0(builderFromModId, existingFileHelper, arg_0), existingFileHelper);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final T getBuilder(@NotNull String path) {
        void it;
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        ResourceLocation resourceLocation = StringsKt.contains$default((CharSequence)path, (CharSequence)":", (boolean)false, (int)2, null) ? ResourceLocation.parse((String)path) : this.id.withPath(path);
        Intrinsics.checkNotNull((Object)resourceLocation);
        ResourceLocation resourceLocation2 = resourceLocation = this.extendWithFolder(resourceLocation);
        Map<ResourceLocation, T> map = this.generatedModels;
        boolean bl = false;
        this.existingFileHelper.trackGenerated((ResourceLocation)it, MODEL);
        ModelBuilder modelBuilder = map.computeIfAbsent(resourceLocation, arg_0 -> ModelProvider.getBuilder$lambda$1(this.factory, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)modelBuilder, (String)"computeIfAbsent(...)");
        return (T)modelBuilder;
    }

    /*
     * WARNING - void declaration
     */
    @JvmOverloads
    @NotNull
    public final T getBuilder(@NotNull ResourceLocation id) {
        void it;
        ResourceLocation resourceLocation;
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        ResourceLocation resourceLocation2 = resourceLocation = this.extendWithFolder(id);
        Map<ResourceLocation, T> map = this.generatedModels;
        boolean bl = false;
        this.existingFileHelper.trackGenerated((ResourceLocation)it, MODEL);
        ModelBuilder modelBuilder = map.computeIfAbsent(resourceLocation, arg_0 -> ModelProvider.getBuilder$lambda$3(this.factory, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)modelBuilder, (String)"computeIfAbsent(...)");
        return (T)modelBuilder;
    }

    public static /* synthetic */ ModelBuilder getBuilder$default(ModelProvider modelProvider, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBuilder");
        }
        if ((n & 1) != 0) {
            resourceLocation = modelProvider.id;
        }
        return modelProvider.getBuilder(resourceLocation);
    }

    private final ResourceLocation extendWithFolder(ResourceLocation rl) {
        String string = rl.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        if (StringsKt.contains$default((CharSequence)string, (CharSequence)"/", (boolean)false, (int)2, null)) {
            return rl;
        }
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)rl.getNamespace(), (String)(this.folder + "/" + rl.getPath()));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
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

    @JvmOverloads
    @NotNull
    public final T withExistingParent(@NotNull String name, @NotNull String parent) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        return this.withExistingParent(name, this.mcLoc(parent));
    }

    public static /* synthetic */ ModelBuilder withExistingParent$default(ModelProvider modelProvider, String string, String string2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withExistingParent");
        }
        if ((n & 1) != 0) {
            String string3 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getPath(...)");
            string = string3;
        }
        return modelProvider.withExistingParent(string, string2);
    }

    @JvmOverloads
    @NotNull
    public final T withExistingParent(@NotNull String name, @NotNull ResourceLocation parent) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        return ((ModelBuilder)this.getBuilder(name)).parent(this.getExistingFile(parent));
    }

    public static /* synthetic */ ModelBuilder withExistingParent$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withExistingParent");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.withExistingParent(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T cube(@NotNull String name, @NotNull ResourceLocation down, @NotNull ResourceLocation up, @NotNull ResourceLocation north, @NotNull ResourceLocation south, @NotNull ResourceLocation east, @NotNull ResourceLocation west) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)down, (String)"down");
        Intrinsics.checkNotNullParameter((Object)up, (String)"up");
        Intrinsics.checkNotNullParameter((Object)north, (String)"north");
        Intrinsics.checkNotNullParameter((Object)south, (String)"south");
        Intrinsics.checkNotNullParameter((Object)east, (String)"east");
        Intrinsics.checkNotNullParameter((Object)west, (String)"west");
        return ((ModelBuilder)((ModelBuilder)((ModelBuilder)((ModelBuilder)((ModelBuilder)((ModelBuilder)this.withExistingParent(name, "cube")).texture("down", down)).texture("up", up)).texture("north", north)).texture("south", south)).texture("east", east)).texture("west", west);
    }

    public static /* synthetic */ ModelBuilder cube$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, ResourceLocation resourceLocation5, ResourceLocation resourceLocation6, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cube");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.cube(string, resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4, resourceLocation5, resourceLocation6);
    }

    private final T singleTexture(String name, String parent, ResourceLocation texture) {
        return this.singleTexture(name, this.mcLoc(parent), texture);
    }

    static /* synthetic */ ModelBuilder singleTexture$default(ModelProvider modelProvider, String string, String string2, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: singleTexture");
        }
        if ((n & 1) != 0) {
            String string3 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getPath(...)");
            string = string3;
        }
        return modelProvider.singleTexture(string, string2, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T singleTexture(@NotNull String name, @NotNull ResourceLocation parent, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, parent, "texture", texture);
    }

    public static /* synthetic */ ModelBuilder singleTexture$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: singleTexture");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.singleTexture(string, resourceLocation, resourceLocation2);
    }

    private final T singleTexture(String name, String parent, String textureKey, ResourceLocation texture) {
        return this.singleTexture(name, this.mcLoc(parent), textureKey, texture);
    }

    static /* synthetic */ ModelBuilder singleTexture$default(ModelProvider modelProvider, String string, String string2, String string3, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: singleTexture");
        }
        if ((n & 1) != 0) {
            String string4 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"getPath(...)");
            string = string4;
        }
        return modelProvider.singleTexture(string, string2, string3, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T singleTexture(@NotNull String name, @NotNull ResourceLocation parent, @NotNull String textureKey, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)textureKey, (String)"textureKey");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return ((ModelBuilder)this.withExistingParent(name, parent)).texture(textureKey, texture);
    }

    public static /* synthetic */ ModelBuilder singleTexture$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, String string2, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: singleTexture");
        }
        if ((n & 1) != 0) {
            String string3 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getPath(...)");
            string = string3;
        }
        return modelProvider.singleTexture(string, resourceLocation, string2, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T cubeAll(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/cube_all", "all", texture);
    }

    public static /* synthetic */ ModelBuilder cubeAll$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cubeAll");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.cubeAll(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T cubeTop(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return ((ModelBuilder)((ModelBuilder)this.withExistingParent(name, "block/cube_top")).texture("side", side)).texture("top", top);
    }

    public static /* synthetic */ ModelBuilder cubeTop$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cubeTop");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.cubeTop(string, resourceLocation, resourceLocation2);
    }

    private final T sideBottomTop(String name, String parent, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        return ((ModelBuilder)((ModelBuilder)((ModelBuilder)this.withExistingParent(name, parent)).texture("side", side)).texture("bottom", bottom)).texture("top", top);
    }

    static /* synthetic */ ModelBuilder sideBottomTop$default(ModelProvider modelProvider, String string, String string2, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sideBottomTop");
        }
        if ((n & 1) != 0) {
            String string3 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getPath(...)");
            string = string3;
        }
        return modelProvider.sideBottomTop(string, string2, resourceLocation, resourceLocation2, resourceLocation3);
    }

    private final T sideBottomTop(String name, ResourceLocation parent, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        return ((ModelBuilder)((ModelBuilder)((ModelBuilder)this.withExistingParent(name, parent)).texture("side", side)).texture("bottom", bottom)).texture("top", top);
    }

    static /* synthetic */ ModelBuilder sideBottomTop$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sideBottomTop");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.sideBottomTop(string, resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4);
    }

    @JvmOverloads
    @NotNull
    public final T cubeBottomTop(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.sideBottomTop(name, "block/cube_bottom_top", side, bottom, top);
    }

    public static /* synthetic */ ModelBuilder cubeBottomTop$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cubeBottomTop");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.cubeBottomTop(string, resourceLocation, resourceLocation2, resourceLocation3);
    }

    @JvmOverloads
    @NotNull
    public final T cubeColumn(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation end) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return ((ModelBuilder)((ModelBuilder)this.withExistingParent(name, "block/cube_column")).texture("side", side)).texture("end", end);
    }

    public static /* synthetic */ ModelBuilder cubeColumn$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cubeColumn");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.cubeColumn(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T cubeColumnHorizontal(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation end) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return ((ModelBuilder)((ModelBuilder)this.withExistingParent(name, "block/cube_column_horizontal")).texture("side", side)).texture("end", end);
    }

    public static /* synthetic */ ModelBuilder cubeColumnHorizontal$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cubeColumnHorizontal");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.cubeColumnHorizontal(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T orientableVertical(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation front) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)front, (String)"front");
        return ((ModelBuilder)((ModelBuilder)this.withExistingParent(name, "block/orientable_vertical")).texture("side", side)).texture("front", front);
    }

    public static /* synthetic */ ModelBuilder orientableVertical$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: orientableVertical");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.orientableVertical(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T orientableWithBottom(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation front, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)front, (String)"front");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return ((ModelBuilder)((ModelBuilder)((ModelBuilder)((ModelBuilder)this.withExistingParent(name, "block/orientable_with_bottom")).texture("side", side)).texture("front", front)).texture("bottom", bottom)).texture("top", top);
    }

    public static /* synthetic */ ModelBuilder orientableWithBottom$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: orientableWithBottom");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.orientableWithBottom(string, resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4);
    }

    @JvmOverloads
    @NotNull
    public final T orientable(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation front, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)front, (String)"front");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return ((ModelBuilder)((ModelBuilder)((ModelBuilder)this.withExistingParent(name, "block/orientable")).texture("side", side)).texture("front", front)).texture("top", top);
    }

    public static /* synthetic */ ModelBuilder orientable$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: orientable");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.orientable(string, resourceLocation, resourceLocation2, resourceLocation3);
    }

    @JvmOverloads
    @NotNull
    public final T crop(@NotNull String name, @NotNull ResourceLocation crop) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)crop, (String)"crop");
        return this.singleTexture(name, "block/crop", "crop", crop);
    }

    public static /* synthetic */ ModelBuilder crop$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: crop");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.crop(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T cross(@NotNull String name, @NotNull ResourceLocation cross) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)cross, (String)"cross");
        return this.singleTexture(name, "block/cross", "cross", cross);
    }

    public static /* synthetic */ ModelBuilder cross$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cross");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.cross(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T flowerPot(@NotNull String name, @NotNull ResourceLocation plant) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)plant, (String)"plant");
        return this.singleTexture(name, "block/flower_pot_cross", "plant", plant);
    }

    public static /* synthetic */ ModelBuilder flowerPot$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowerPot");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.flowerPot(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T stairs(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.sideBottomTop(name, "block/stairs", side, bottom, top);
    }

    public static /* synthetic */ ModelBuilder stairs$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stairs");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.stairs(string, resourceLocation, resourceLocation2, resourceLocation3);
    }

    @JvmOverloads
    @NotNull
    public final T stairsOuter(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.sideBottomTop(name, "block/outer_stairs", side, bottom, top);
    }

    public static /* synthetic */ ModelBuilder stairsOuter$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stairsOuter");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.stairsOuter(string, resourceLocation, resourceLocation2, resourceLocation3);
    }

    @JvmOverloads
    @NotNull
    public final T stairsInner(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.sideBottomTop(name, "block/inner_stairs", side, bottom, top);
    }

    public static /* synthetic */ ModelBuilder stairsInner$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stairsInner");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.stairsInner(string, resourceLocation, resourceLocation2, resourceLocation3);
    }

    @JvmOverloads
    @NotNull
    public final T slab(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.sideBottomTop(name, "block/slab", side, bottom, top);
    }

    public static /* synthetic */ ModelBuilder slab$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slab");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        if ((n & 4) != 0) {
            resourceLocation2 = resourceLocation;
        }
        if ((n & 8) != 0) {
            resourceLocation3 = resourceLocation;
        }
        return modelProvider.slab(string, resourceLocation, resourceLocation2, resourceLocation3);
    }

    @JvmOverloads
    @NotNull
    public final T slabTop(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.sideBottomTop(name, "block/slab_top", side, bottom, top);
    }

    public static /* synthetic */ ModelBuilder slabTop$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slabTop");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.slabTop(string, resourceLocation, resourceLocation2, resourceLocation3);
    }

    @JvmOverloads
    @NotNull
    public final T verticalSlab(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.sideBottomTop(name, BCApi.id("block/vertical_slab"), side, bottom, top);
    }

    public static /* synthetic */ ModelBuilder verticalSlab$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verticalSlab");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        if ((n & 4) != 0) {
            resourceLocation2 = resourceLocation;
        }
        if ((n & 8) != 0) {
            resourceLocation3 = resourceLocation;
        }
        return modelProvider.verticalSlab(string, resourceLocation, resourceLocation2, resourceLocation3);
    }

    @JvmOverloads
    @NotNull
    public final T verticalSlabRight(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.sideBottomTop(name, BCApi.id("block/vertical_slab_right"), side, bottom, top);
    }

    public static /* synthetic */ ModelBuilder verticalSlabRight$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verticalSlabRight");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.verticalSlabRight(string, resourceLocation, resourceLocation2, resourceLocation3);
    }

    @JvmOverloads
    @NotNull
    public final T button(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/button", texture);
    }

    public static /* synthetic */ ModelBuilder button$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: button");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.button(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T buttonPressed(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/button_pressed", texture);
    }

    public static /* synthetic */ ModelBuilder buttonPressed$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buttonPressed");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.buttonPressed(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T buttonInventory(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/button_inventory", texture);
    }

    public static /* synthetic */ ModelBuilder buttonInventory$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buttonInventory");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.buttonInventory(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T pressurePlate(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/pressure_plate_up", texture);
    }

    public static /* synthetic */ ModelBuilder pressurePlate$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pressurePlate");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.pressurePlate(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T pressurePlateDown(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/pressure_plate_down", texture);
    }

    public static /* synthetic */ ModelBuilder pressurePlateDown$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pressurePlateDown");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.pressurePlateDown(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T sign(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return ((ModelBuilder)this.getBuilder(name)).texture("particle", texture);
    }

    public static /* synthetic */ ModelBuilder sign$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sign");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.sign(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T fencePost(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/fence_post", texture);
    }

    public static /* synthetic */ ModelBuilder fencePost$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fencePost");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.fencePost(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T fenceSide(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/fence_side", texture);
    }

    public static /* synthetic */ ModelBuilder fenceSide$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fenceSide");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.fenceSide(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T fenceInventory(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/fence_inventory", texture);
    }

    public static /* synthetic */ ModelBuilder fenceInventory$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fenceInventory");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.fenceInventory(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T fenceGate(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_fence_gate", texture);
    }

    public static /* synthetic */ ModelBuilder fenceGate$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fenceGate");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.fenceGate(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T fenceGateOpen(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_fence_gate_open", texture);
    }

    public static /* synthetic */ ModelBuilder fenceGateOpen$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fenceGateOpen");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.fenceGateOpen(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T fenceGateWall(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_fence_gate_wall", texture);
    }

    public static /* synthetic */ ModelBuilder fenceGateWall$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fenceGateWall");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.fenceGateWall(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T fenceGateWallOpen(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_fence_gate_wall_open", texture);
    }

    public static /* synthetic */ ModelBuilder fenceGateWallOpen$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fenceGateWallOpen");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.fenceGateWallOpen(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T wallPost(@NotNull String name, @NotNull ResourceLocation wall) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)wall, (String)"wall");
        return this.singleTexture(name, "block/template_wall_post", "wall", wall);
    }

    public static /* synthetic */ ModelBuilder wallPost$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wallPost");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.wallPost(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T wallSide(@NotNull String name, @NotNull ResourceLocation wall) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)wall, (String)"wall");
        return this.singleTexture(name, "block/template_wall_side", "wall", wall);
    }

    public static /* synthetic */ ModelBuilder wallSide$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wallSide");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.wallSide(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T wallSideTall(@NotNull String name, @NotNull ResourceLocation wall) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)wall, (String)"wall");
        return this.singleTexture(name, "block/template_wall_side_tall", "wall", wall);
    }

    public static /* synthetic */ ModelBuilder wallSideTall$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wallSideTall");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.wallSideTall(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T wallInventory(@NotNull String name, @NotNull ResourceLocation wall) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)wall, (String)"wall");
        return this.singleTexture(name, "block/wall_inventory", "wall", wall);
    }

    public static /* synthetic */ ModelBuilder wallInventory$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wallInventory");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.wallInventory(string, resourceLocation);
    }

    private final T pane(String name, String parent, ResourceLocation pane, ResourceLocation edge) {
        return ((ModelBuilder)((ModelBuilder)this.withExistingParent(name, "block/" + parent)).texture("pane", pane)).texture("edge", edge);
    }

    static /* synthetic */ ModelBuilder pane$default(ModelProvider modelProvider, String string, String string2, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pane");
        }
        if ((n & 1) != 0) {
            String string3 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getPath(...)");
            string = string3;
        }
        return modelProvider.pane(string, string2, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T panePost(@NotNull String name, @NotNull ResourceLocation pane, @NotNull ResourceLocation edge) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        return this.pane(name, "template_glass_pane_post", pane, edge);
    }

    public static /* synthetic */ ModelBuilder panePost$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: panePost");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.panePost(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T paneSide(@NotNull String name, @NotNull ResourceLocation pane, @NotNull ResourceLocation edge) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        return this.pane(name, "template_glass_pane_side", pane, edge);
    }

    public static /* synthetic */ ModelBuilder paneSide$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paneSide");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.paneSide(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T paneSideAlt(@NotNull String name, @NotNull ResourceLocation pane, @NotNull ResourceLocation edge) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        return this.pane(name, "template_glass_pane_side_alt", pane, edge);
    }

    public static /* synthetic */ ModelBuilder paneSideAlt$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paneSideAlt");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.paneSideAlt(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T paneNoSide(@NotNull String name, @NotNull ResourceLocation pane) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        return this.singleTexture(name, "block/template_glass_pane_noside", "pane", pane);
    }

    public static /* synthetic */ ModelBuilder paneNoSide$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paneNoSide");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.paneNoSide(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T paneNoSideAlt(@NotNull String name, @NotNull ResourceLocation pane) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        return this.singleTexture(name, "block/template_glass_pane_noside_alt", "pane", pane);
    }

    public static /* synthetic */ ModelBuilder paneNoSideAlt$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paneNoSideAlt");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.paneNoSideAlt(string, resourceLocation);
    }

    private final T door(String name, String model, ResourceLocation bottom, ResourceLocation top) {
        return ((ModelBuilder)((ModelBuilder)this.withExistingParent(name, "block/" + model)).texture("bottom", bottom)).texture("top", top);
    }

    static /* synthetic */ ModelBuilder door$default(ModelProvider modelProvider, String string, String string2, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: door");
        }
        if ((n & 1) != 0) {
            String string3 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getPath(...)");
            string = string3;
        }
        return modelProvider.door(string, string2, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T doorBottomLeft(@NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.door(name, "door_bottom_left", bottom, top);
    }

    public static /* synthetic */ ModelBuilder doorBottomLeft$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doorBottomLeft");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.doorBottomLeft(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T doorBottomLeftOpen(@NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.door(name, "door_bottom_left_open", bottom, top);
    }

    public static /* synthetic */ ModelBuilder doorBottomLeftOpen$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doorBottomLeftOpen");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.doorBottomLeftOpen(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T doorBottomRight(@NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.door(name, "door_bottom_right", bottom, top);
    }

    public static /* synthetic */ ModelBuilder doorBottomRight$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doorBottomRight");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.doorBottomRight(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T doorBottomRightOpen(@NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.door(name, "door_bottom_right_open", bottom, top);
    }

    public static /* synthetic */ ModelBuilder doorBottomRightOpen$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doorBottomRightOpen");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.doorBottomRightOpen(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T doorTopLeft(@NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.door(name, "door_top_left", bottom, top);
    }

    public static /* synthetic */ ModelBuilder doorTopLeft$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doorTopLeft");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.doorTopLeft(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T doorTopLeftOpen(@NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.door(name, "door_top_left_open", bottom, top);
    }

    public static /* synthetic */ ModelBuilder doorTopLeftOpen$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doorTopLeftOpen");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.doorTopLeftOpen(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T doorTopRight(@NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.door(name, "door_top_right", bottom, top);
    }

    public static /* synthetic */ ModelBuilder doorTopRight$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doorTopRight");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.doorTopRight(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T doorTopRightOpen(@NotNull String name, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return this.door(name, "door_top_right_open", bottom, top);
    }

    public static /* synthetic */ ModelBuilder doorTopRightOpen$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doorTopRightOpen");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.doorTopRightOpen(string, resourceLocation, resourceLocation2);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorBottom(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_trapdoor_bottom", texture);
    }

    public static /* synthetic */ ModelBuilder trapdoorBottom$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trapdoorBottom");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.trapdoorBottom(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorTop(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_trapdoor_top", texture);
    }

    public static /* synthetic */ ModelBuilder trapdoorTop$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trapdoorTop");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.trapdoorTop(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorOpen(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_trapdoor_open", texture);
    }

    public static /* synthetic */ ModelBuilder trapdoorOpen$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trapdoorOpen");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.trapdoorOpen(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorOrientableBottom(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_orientable_trapdoor_bottom", texture);
    }

    public static /* synthetic */ ModelBuilder trapdoorOrientableBottom$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trapdoorOrientableBottom");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.trapdoorOrientableBottom(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorOrientableTop(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_orientable_trapdoor_top", texture);
    }

    public static /* synthetic */ ModelBuilder trapdoorOrientableTop$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trapdoorOrientableTop");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.trapdoorOrientableTop(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorOrientableOpen(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/template_orientable_trapdoor_open", texture);
    }

    public static /* synthetic */ ModelBuilder trapdoorOrientableOpen$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trapdoorOrientableOpen");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.trapdoorOrientableOpen(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T torch(@NotNull String name, @NotNull ResourceLocation torch) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)torch, (String)"torch");
        return this.singleTexture(name, "block/template_torch", "torch", torch);
    }

    public static /* synthetic */ ModelBuilder torch$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: torch");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.torch(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T torchWall(@NotNull String name, @NotNull ResourceLocation torch) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)torch, (String)"torch");
        return this.singleTexture(name, "block/template_torch_wall", "torch", torch);
    }

    public static /* synthetic */ ModelBuilder torchWall$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: torchWall");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.torchWall(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T carpet(@NotNull String name, @NotNull ResourceLocation wool) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)wool, (String)"wool");
        return this.singleTexture(name, "block/carpet", "wool", wool);
    }

    public static /* synthetic */ ModelBuilder carpet$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: carpet");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.carpet(string, resourceLocation);
    }

    @JvmOverloads
    @NotNull
    public final T leaves(@NotNull String name, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return this.singleTexture(name, "block/leaves", "all", texture);
    }

    public static /* synthetic */ ModelBuilder leaves$default(ModelProvider modelProvider, String string, ResourceLocation resourceLocation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: leaves");
        }
        if ((n & 1) != 0) {
            String string2 = modelProvider.id.getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
            string = string2;
        }
        return modelProvider.leaves(string, resourceLocation);
    }

    @NotNull
    public final T nested() {
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)"dummy", (String)"dummy");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return (T)((ModelBuilder)this.factory.invoke((Object)resourceLocation));
    }

    @NotNull
    public final ModelFile.ExistingModelFile getExistingFile(@NotNull ResourceLocation path) {
        ModelFile.ExistingModelFile existingModelFile;
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        ModelFile.ExistingModelFile it = existingModelFile = new ModelFile.ExistingModelFile(this.extendWithFolder(path), this.existingFileHelper);
        boolean bl = false;
        if (!Intrinsics.areEqual((Object)it.getLocation().getNamespace(), (Object)"brokencore")) {
            it.assertExistence();
        }
        return existingModelFile;
    }

    public final void clear() {
        this.generatedModels.clear();
    }

    @NotNull
    public CompletableFuture<?> run(@NotNull CachedOutput cache) {
        Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
        this.clear();
        this.registerModels();
        return this.generateAll(cache);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final Map<String, JsonElement> getJsons() {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = this.generatedModels.values();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ModelBuilder modelBuilder = (ModelBuilder)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(TuplesKt.to((Object)this.getStringPath(it), (Object)it.toJson()));
        }
        Collection $this$toTypedArray$iv = (List)destination$iv$iv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Pair[] pairArray = thisCollection$iv.toArray(new Pair[0]);
        return MapsKt.mapOf((Pair[])Arrays.copyOf(pairArray, pairArray.length));
    }

    @NotNull
    public final CompletableFuture<?> generateAll(@NotNull CachedOutput cache) {
        Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
        CompletableFuture[] futures = new CompletableFuture[this.generatedModels.size()];
        int i = 0;
        for (ModelBuilder model : this.generatedModels.values()) {
            futures[i++] = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)model.toJson()), (Path)this.getPath(model));
        }
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(Arrays.copyOf(futures, futures.length));
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"allOf(...)");
        return completableFuture;
    }

    @NotNull
    protected final Path getPath(@NotNull T model) {
        Intrinsics.checkNotNullParameter(model, (String)"model");
        Path path = this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(((ModelFile)model).getLocation().getNamespace()).resolve("models").resolve(((ModelFile)model).getLocation().getPath() + ".json");
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"resolve(...)");
        return path;
    }

    @NotNull
    protected final String getStringPath(@NotNull T model) {
        Intrinsics.checkNotNullParameter(model, (String)"model");
        return "assets/" + ((ModelFile)model).getLocation().getNamespace() + "/models/" + ((ModelFile)model).getLocation().getPath() + ".json";
    }

    @JvmOverloads
    @NotNull
    public final T getBuilder() {
        return (T)ModelProvider.getBuilder$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T withExistingParent(@NotNull String parent) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        return (T)ModelProvider.withExistingParent$default(this, null, parent, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T withExistingParent(@NotNull ResourceLocation parent) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        return (T)ModelProvider.withExistingParent$default(this, null, parent, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T cube(@NotNull ResourceLocation down, @NotNull ResourceLocation up, @NotNull ResourceLocation north, @NotNull ResourceLocation south, @NotNull ResourceLocation east, @NotNull ResourceLocation west) {
        Intrinsics.checkNotNullParameter((Object)down, (String)"down");
        Intrinsics.checkNotNullParameter((Object)up, (String)"up");
        Intrinsics.checkNotNullParameter((Object)north, (String)"north");
        Intrinsics.checkNotNullParameter((Object)south, (String)"south");
        Intrinsics.checkNotNullParameter((Object)east, (String)"east");
        Intrinsics.checkNotNullParameter((Object)west, (String)"west");
        return (T)ModelProvider.cube$default(this, null, down, up, north, south, east, west, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T singleTexture(@NotNull ResourceLocation parent, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.singleTexture$default(this, null, parent, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T singleTexture(@NotNull ResourceLocation parent, @NotNull String textureKey, @NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)textureKey, (String)"textureKey");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.singleTexture$default(this, null, parent, textureKey, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T cubeAll(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.cubeAll$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T cubeTop(@NotNull ResourceLocation side, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.cubeTop$default(this, null, side, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T cubeBottomTop(@NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.cubeBottomTop$default(this, null, side, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T cubeColumn(@NotNull ResourceLocation side, @NotNull ResourceLocation end) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return (T)ModelProvider.cubeColumn$default(this, null, side, end, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T cubeColumnHorizontal(@NotNull ResourceLocation side, @NotNull ResourceLocation end) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return (T)ModelProvider.cubeColumnHorizontal$default(this, null, side, end, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T orientableVertical(@NotNull ResourceLocation side, @NotNull ResourceLocation front) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)front, (String)"front");
        return (T)ModelProvider.orientableVertical$default(this, null, side, front, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T orientableWithBottom(@NotNull ResourceLocation side, @NotNull ResourceLocation front, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)front, (String)"front");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.orientableWithBottom$default(this, null, side, front, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T orientable(@NotNull ResourceLocation side, @NotNull ResourceLocation front, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)front, (String)"front");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.orientable$default(this, null, side, front, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T crop(@NotNull ResourceLocation crop) {
        Intrinsics.checkNotNullParameter((Object)crop, (String)"crop");
        return (T)ModelProvider.crop$default(this, null, crop, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T cross(@NotNull ResourceLocation cross) {
        Intrinsics.checkNotNullParameter((Object)cross, (String)"cross");
        return (T)ModelProvider.cross$default(this, null, cross, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T flowerPot(@NotNull ResourceLocation plant) {
        Intrinsics.checkNotNullParameter((Object)plant, (String)"plant");
        return (T)ModelProvider.flowerPot$default(this, null, plant, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T stairs(@NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.stairs$default(this, null, side, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T stairsOuter(@NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.stairsOuter$default(this, null, side, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T stairsInner(@NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.stairsInner$default(this, null, side, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T slab(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        return (T)ModelProvider.slab$default(this, name, side, bottom, null, 8, null);
    }

    @JvmOverloads
    @NotNull
    public final T slab(@NotNull String name, @NotNull ResourceLocation side) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        return (T)ModelProvider.slab$default(this, name, side, null, null, 12, null);
    }

    @JvmOverloads
    @NotNull
    public final T slab(@NotNull ResourceLocation side) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        return (T)ModelProvider.slab$default(this, null, side, null, null, 13, null);
    }

    @JvmOverloads
    @NotNull
    public final T slabTop(@NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.slabTop$default(this, null, side, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T verticalSlab(@NotNull String name, @NotNull ResourceLocation side, @NotNull ResourceLocation bottom) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        return (T)ModelProvider.verticalSlab$default(this, name, side, bottom, null, 8, null);
    }

    @JvmOverloads
    @NotNull
    public final T verticalSlab(@NotNull String name, @NotNull ResourceLocation side) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        return (T)ModelProvider.verticalSlab$default(this, name, side, null, null, 12, null);
    }

    @JvmOverloads
    @NotNull
    public final T verticalSlab(@NotNull ResourceLocation side) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        return (T)ModelProvider.verticalSlab$default(this, null, side, null, null, 13, null);
    }

    @JvmOverloads
    @NotNull
    public final T verticalSlabRight(@NotNull ResourceLocation side, @NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)side, (String)"side");
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.verticalSlabRight$default(this, null, side, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T button(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.button$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T buttonPressed(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.buttonPressed$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T buttonInventory(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.buttonInventory$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T pressurePlate(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.pressurePlate$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T pressurePlateDown(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.pressurePlateDown$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T sign(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.sign$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T fencePost(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.fencePost$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T fenceSide(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.fenceSide$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T fenceInventory(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.fenceInventory$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T fenceGate(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.fenceGate$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T fenceGateOpen(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.fenceGateOpen$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T fenceGateWall(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.fenceGateWall$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T fenceGateWallOpen(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.fenceGateWallOpen$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T wallPost(@NotNull ResourceLocation wall) {
        Intrinsics.checkNotNullParameter((Object)wall, (String)"wall");
        return (T)ModelProvider.wallPost$default(this, null, wall, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T wallSide(@NotNull ResourceLocation wall) {
        Intrinsics.checkNotNullParameter((Object)wall, (String)"wall");
        return (T)ModelProvider.wallSide$default(this, null, wall, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T wallSideTall(@NotNull ResourceLocation wall) {
        Intrinsics.checkNotNullParameter((Object)wall, (String)"wall");
        return (T)ModelProvider.wallSideTall$default(this, null, wall, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T wallInventory(@NotNull ResourceLocation wall) {
        Intrinsics.checkNotNullParameter((Object)wall, (String)"wall");
        return (T)ModelProvider.wallInventory$default(this, null, wall, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T panePost(@NotNull ResourceLocation pane, @NotNull ResourceLocation edge) {
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        return (T)ModelProvider.panePost$default(this, null, pane, edge, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T paneSide(@NotNull ResourceLocation pane, @NotNull ResourceLocation edge) {
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        return (T)ModelProvider.paneSide$default(this, null, pane, edge, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T paneSideAlt(@NotNull ResourceLocation pane, @NotNull ResourceLocation edge) {
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        Intrinsics.checkNotNullParameter((Object)edge, (String)"edge");
        return (T)ModelProvider.paneSideAlt$default(this, null, pane, edge, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T paneNoSide(@NotNull ResourceLocation pane) {
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        return (T)ModelProvider.paneNoSide$default(this, null, pane, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T paneNoSideAlt(@NotNull ResourceLocation pane) {
        Intrinsics.checkNotNullParameter((Object)pane, (String)"pane");
        return (T)ModelProvider.paneNoSideAlt$default(this, null, pane, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T doorBottomLeft(@NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.doorBottomLeft$default(this, null, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T doorBottomLeftOpen(@NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.doorBottomLeftOpen$default(this, null, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T doorBottomRight(@NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.doorBottomRight$default(this, null, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T doorBottomRightOpen(@NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.doorBottomRightOpen$default(this, null, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T doorTopLeft(@NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.doorTopLeft$default(this, null, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T doorTopLeftOpen(@NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.doorTopLeftOpen$default(this, null, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T doorTopRight(@NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.doorTopRight$default(this, null, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T doorTopRightOpen(@NotNull ResourceLocation bottom, @NotNull ResourceLocation top) {
        Intrinsics.checkNotNullParameter((Object)bottom, (String)"bottom");
        Intrinsics.checkNotNullParameter((Object)top, (String)"top");
        return (T)ModelProvider.doorTopRightOpen$default(this, null, bottom, top, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorBottom(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.trapdoorBottom$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorTop(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.trapdoorTop$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorOpen(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.trapdoorOpen$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorOrientableBottom(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.trapdoorOrientableBottom$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorOrientableTop(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.trapdoorOrientableTop$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T trapdoorOrientableOpen(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.trapdoorOrientableOpen$default(this, null, texture, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T torch(@NotNull ResourceLocation torch) {
        Intrinsics.checkNotNullParameter((Object)torch, (String)"torch");
        return (T)ModelProvider.torch$default(this, null, torch, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T torchWall(@NotNull ResourceLocation torch) {
        Intrinsics.checkNotNullParameter((Object)torch, (String)"torch");
        return (T)ModelProvider.torchWall$default(this, null, torch, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T carpet(@NotNull ResourceLocation wool) {
        Intrinsics.checkNotNullParameter((Object)wool, (String)"wool");
        return (T)ModelProvider.carpet$default(this, null, wool, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final T leaves(@NotNull ResourceLocation texture) {
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return (T)ModelProvider.leaves$default(this, null, texture, 1, null);
    }

    private static final ModelBuilder _init_$lambda$0(Function2 $builderFromModId, ExistingFileHelper $existingFileHelper, ResourceLocation it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return (ModelBuilder)$builderFromModId.invoke((Object)it, (Object)$existingFileHelper);
    }

    private static final ModelBuilder getBuilder$lambda$1(Function1 $tmp0, Object p0) {
        return (ModelBuilder)$tmp0.invoke(p0);
    }

    private static final ModelBuilder getBuilder$lambda$3(Function1 $tmp0, Object p0) {
        return (ModelBuilder)$tmp0.invoke(p0);
    }

    static {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Intrinsics.checkNotNullExpressionValue((Object)gson, (String)"create(...)");
        GSON = gson;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lcompat/net/neoforged/neoforge/client/model/generators/ModelProvider$Companion;", "", "<init>", "()V", "BLOCK_FOLDER", "", "ITEM_FOLDER", "TEXTURE", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper$ResourceType;", "MODEL", "MODEL_WITH_EXTENSION", "GSON", "Lcom/google/gson/Gson;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

