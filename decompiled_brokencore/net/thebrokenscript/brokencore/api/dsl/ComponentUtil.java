/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.ComponentContents
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.chat.contents.TranslatableContents
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.dsl.StyleConfigurator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\n\u001a\u00020\b*\u00020\u0001H\u0086\b\u001a)\u0010\u000b\u001a\u00020\b*\u00020\u00012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\b\u000fH\u0086\f\u00f8\u0001\u0000\u001a)\u0010\u000b\u001a\u00020\b*\u00020\u00022\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\b\u000fH\u0086\f\u00f8\u0001\u0000\u001a\u0015\u0010\u000b\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0010H\u0086\f\u001a\u0015\u0010\u000b\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0010H\u0086\f\u001a\u001b\u0010\u000b\u001a\u00020\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u0011H\u0086\f\u001a\u001b\u0010\u000b\u001a\u00020\b*\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u0011H\u0086\f\u001a%\u0010J\u001a\u0004\u0018\u00010\b*\u00020\u00012\u0012\u0010K\u001a\n\u0012\u0006\b\u0001\u0012\u00020M0L\"\u00020M\u00a2\u0006\u0002\u0010N\u001a\u0017\u0010O\u001a\u0004\u0018\u00010\b*\u00020\u00012\u0006\u0010P\u001a\u00020MH\u0086\u0004\u001a\u001d\u0010O\u001a\u0004\u0018\u00010\b*\u00020\u00012\f\u0010P\u001a\b\u0012\u0004\u0012\u00020M0\u0011H\u0086\u0004\"\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0016\u0010\u0012\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0016\u0010\u0015\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0016\u0010\u0017\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014\"\u0016\u0010\u0019\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014\"\u0016\u0010\u001b\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014\"\u0016\u0010\u001d\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014\"\u0016\u0010\u001f\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0014\"\u0016\u0010!\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0014\"\u0016\u0010#\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u0014\"\u0016\u0010%\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0014\"\u0016\u0010'\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0014\"\u0016\u0010)\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u0014\"\u0016\u0010+\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u0014\"\u0016\u0010-\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u0014\"\u0016\u0010/\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u0014\"\u0016\u00101\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b2\u0010\u0014\"\u0016\u00103\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b4\u0010\u0014\"\u0016\u00105\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u0014\"\u0016\u00107\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b8\u0010\u0014\"\u0016\u00109\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b:\u0010\u0014\"\u0016\u0010;\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b<\u0010\u0014\"\u0016\u0010=\u001a\u00020\b*\u00020\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b>\u0010\u0014\"\u0016\u0010\u0012\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010?\"\u0016\u0010\u0015\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010?\"\u0016\u0010\u0017\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010?\"\u0016\u0010\u0019\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010?\"\u0016\u0010\u001b\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010?\"\u0016\u0010\u001d\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010?\"\u0016\u0010\u001f\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b \u0010?\"\u0016\u0010!\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\"\u0010?\"\u0016\u0010#\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b$\u0010?\"\u0016\u0010%\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b&\u0010?\"\u0016\u0010'\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b(\u0010?\"\u0016\u0010)\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b*\u0010?\"\u0016\u0010+\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b,\u0010?\"\u0016\u0010-\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b.\u0010?\"\u0016\u0010/\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b0\u0010?\"\u0016\u00101\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b2\u0010?\"\u0016\u00103\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b4\u0010?\"\u0016\u00105\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b6\u0010?\"\u0016\u00107\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b8\u0010?\"\u0016\u00109\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b:\u0010?\"\u0016\u0010;\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b<\u0010?\"\u0016\u0010=\u001a\u00020\b*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b>\u0010?\"\u0016\u0010\u0012\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010A\"\u0016\u0010\u0015\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010A\"\u0016\u0010\u0017\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010A\"\u0016\u0010\u0019\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010A\"\u0016\u0010\u001b\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010A\"\u0016\u0010\u001d\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010A\"\u0016\u0010\u001f\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b \u0010A\"\u0016\u0010!\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\"\u0010A\"\u0016\u0010#\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b$\u0010A\"\u0016\u0010%\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b&\u0010A\"\u0016\u0010'\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b(\u0010A\"\u0016\u0010)\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b*\u0010A\"\u0016\u0010+\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b,\u0010A\"\u0016\u0010-\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b.\u0010A\"\u0016\u0010/\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b0\u0010A\"\u0016\u00101\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b2\u0010A\"\u0016\u00103\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b4\u0010A\"\u0016\u00105\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b6\u0010A\"\u0016\u00107\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b8\u0010A\"\u0016\u00109\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b:\u0010A\"\u0016\u0010;\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b<\u0010A\"\u0016\u0010=\u001a\u00020\b*\u00020@8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b>\u0010A\"\u0016\u0010\u0012\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010C\"\u0016\u0010\u0015\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010C\"\u0016\u0010\u0017\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010C\"\u0016\u0010\u0019\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010C\"\u0016\u0010\u001b\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010C\"\u0016\u0010\u001d\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010C\"\u0016\u0010\u001f\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b \u0010C\"\u0016\u0010!\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\"\u0010C\"\u0016\u0010#\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b$\u0010C\"\u0016\u0010%\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b&\u0010C\"\u0016\u0010'\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b(\u0010C\"\u0016\u0010)\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b*\u0010C\"\u0016\u0010+\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b,\u0010C\"\u0016\u0010-\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b.\u0010C\"\u0016\u0010/\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b0\u0010C\"\u0016\u00101\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b2\u0010C\"\u0016\u00103\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b4\u0010C\"\u0016\u00105\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b6\u0010C\"\u0016\u00107\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b8\u0010C\"\u0016\u00109\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b:\u0010C\"\u0016\u0010;\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b<\u0010C\"\u0016\u0010=\u001a\u00020\b*\u00020B8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b>\u0010C\"\"\u0010\u0012\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010F\"\"\u0010\u0015\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010F\"\"\u0010\u0017\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010F\"\"\u0010\u0019\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010F\"\"\u0010\u001b\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010F\"\"\u0010\u001d\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010F\"\"\u0010\u001f\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b \u0010F\"\"\u0010!\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\"\u0010F\"\"\u0010#\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b$\u0010F\"\"\u0010%\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b&\u0010F\"\"\u0010'\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b(\u0010F\"\"\u0010)\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b*\u0010F\"\"\u0010+\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b,\u0010F\"\"\u0010-\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b.\u0010F\"\"\u0010/\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b0\u0010F\"\"\u00101\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b2\u0010F\"\"\u00103\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b4\u0010F\"\"\u00105\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b6\u0010F\"\"\u00107\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b8\u0010F\"\"\u00109\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b:\u0010F\"\"\u0010;\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b<\u0010F\"\"\u0010=\u001a\u00020\b\"\u0004\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E8\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b>\u0010F\"\u0017\u0010G\u001a\u0004\u0018\u00010\u0002*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\bH\u0010I\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006Q"}, d2={"c", "Lnet/minecraft/network/chat/Component;", "", "getC", "(Ljava/lang/String;)Lnet/minecraft/network/chat/Component;", "component", "getComponent", "plus", "Lnet/minecraft/network/chat/MutableComponent;", "other", "mut", "with", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/dsl/StyleConfigurator;", "", "Lkotlin/ExtensionFunctionType;", "Lnet/minecraft/ChatFormatting;", "", "black", "getBlack", "(Lnet/minecraft/network/chat/Component;)Lnet/minecraft/network/chat/MutableComponent;", "darkBlue", "getDarkBlue", "darkGreen", "getDarkGreen", "darkAqua", "getDarkAqua", "darkRed", "getDarkRed", "darkPurple", "getDarkPurple", "gold", "getGold", "gray", "getGray", "darkGray", "getDarkGray", "blue", "getBlue", "green", "getGreen", "aqua", "getAqua", "red", "getRed", "lightPurple", "getLightPurple", "yellow", "getYellow", "white", "getWhite", "obfuscated", "getObfuscated", "bold", "getBold", "strikethrough", "getStrikethrough", "underline", "getUnderline", "italic", "getItalic", "reset", "getReset", "(Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;", "Lnet/minecraft/resources/ResourceLocation;", "(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/network/chat/MutableComponent;", "", "(Ljava/lang/Number;)Lnet/minecraft/network/chat/MutableComponent;", "T", "Lnet/minecraft/resources/ResourceKey;", "(Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/network/chat/MutableComponent;", "translationKey", "getTranslationKey", "(Lnet/minecraft/network/chat/Component;)Ljava/lang/String;", "withReplacements", "values", "", "", "(Lnet/minecraft/network/chat/Component;[Ljava/lang/Object;)Lnet/minecraft/network/chat/MutableComponent;", "format", "value", "brokencore-common"})
@JvmName(name="ComponentUtil")
@SourceDebugExtension(value={"SMAP\nComponentDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n15#1:181\n24#1:182\n15#1,10:183\n24#1:193\n15#1,10:194\n24#1:204\n15#1,10:205\n24#1:215\n15#1,10:218\n29#1:230\n24#1:231\n29#1:232\n24#1:233\n29#1:234\n24#1:235\n29#1:236\n24#1:237\n29#1:238\n24#1:239\n29#1:240\n24#1:241\n29#1:242\n24#1:243\n29#1:244\n24#1:245\n29#1:246\n24#1:247\n29#1:248\n24#1:249\n29#1:250\n24#1:251\n29#1:252\n24#1:253\n29#1:254\n24#1:255\n29#1:256\n24#1:257\n29#1:258\n24#1:259\n29#1:260\n24#1:261\n29#1:262\n24#1:263\n29#1:264\n24#1:265\n29#1:266\n24#1:267\n29#1:268\n24#1:269\n29#1:270\n24#1:271\n29#1:272\n24#1:273\n15#1:274\n37#1:275\n29#1:276\n24#1:277\n15#1:278\n38#1:279\n29#1:280\n24#1:281\n15#1:282\n39#1:283\n29#1:284\n24#1:285\n15#1:286\n40#1:287\n29#1:288\n24#1:289\n15#1:290\n41#1:291\n29#1:292\n24#1:293\n15#1:294\n42#1:295\n29#1:296\n24#1:297\n15#1:298\n43#1:299\n29#1:300\n24#1:301\n15#1:302\n44#1:303\n29#1:304\n24#1:305\n15#1:306\n45#1:307\n29#1:308\n24#1:309\n15#1:310\n46#1:311\n29#1:312\n24#1:313\n15#1:314\n47#1:315\n29#1:316\n24#1:317\n15#1:318\n48#1:319\n29#1:320\n24#1:321\n15#1:322\n49#1:323\n29#1:324\n24#1:325\n15#1:326\n50#1:327\n29#1:328\n24#1:329\n15#1:330\n51#1:331\n29#1:332\n24#1:333\n15#1:334\n52#1:335\n29#1:336\n24#1:337\n15#1:338\n53#1:339\n29#1:340\n24#1:341\n15#1:342\n54#1:343\n29#1:344\n24#1:345\n15#1:346\n55#1:347\n29#1:348\n24#1:349\n15#1:350\n56#1:351\n29#1:352\n24#1:353\n15#1:354\n57#1:355\n29#1:356\n24#1:357\n15#1:358\n58#1:359\n29#1:360\n24#1:361\n60#1:362\n15#1:363\n37#1:364\n29#1:365\n24#1:366\n61#1:367\n15#1:368\n38#1:369\n29#1:370\n24#1:371\n62#1:372\n15#1:373\n39#1:374\n29#1:375\n24#1:376\n63#1:377\n15#1:378\n40#1:379\n29#1:380\n24#1:381\n64#1:382\n15#1:383\n41#1:384\n29#1:385\n24#1:386\n65#1:387\n15#1:388\n42#1:389\n29#1:390\n24#1:391\n66#1:392\n15#1:393\n43#1:394\n29#1:395\n24#1:396\n67#1:397\n15#1:398\n44#1:399\n29#1:400\n24#1:401\n68#1:402\n15#1:403\n45#1:404\n29#1:405\n24#1:406\n69#1:407\n15#1:408\n46#1:409\n29#1:410\n24#1:411\n70#1:412\n15#1:413\n47#1:414\n29#1:415\n24#1:416\n71#1:417\n15#1:418\n48#1:419\n29#1:420\n24#1:421\n72#1:422\n15#1:423\n49#1:424\n29#1:425\n24#1:426\n73#1:427\n15#1:428\n50#1:429\n29#1:430\n24#1:431\n74#1:432\n15#1:433\n51#1:434\n29#1:435\n24#1:436\n75#1:437\n15#1:438\n52#1:439\n29#1:440\n24#1:441\n76#1:442\n15#1:443\n53#1:444\n29#1:445\n24#1:446\n77#1:447\n15#1:448\n54#1:449\n29#1:450\n24#1:451\n78#1:452\n15#1:453\n55#1:454\n29#1:455\n24#1:456\n79#1:457\n15#1:458\n56#1:459\n29#1:460\n24#1:461\n80#1:462\n15#1:463\n57#1:464\n29#1:465\n24#1:466\n81#1:467\n15#1:468\n58#1:469\n29#1:470\n24#1:471\n60#1:472\n15#1:473\n37#1:474\n29#1:475\n24#1:476\n61#1:477\n15#1:478\n38#1:479\n29#1:480\n24#1:481\n62#1:482\n15#1:483\n39#1:484\n29#1:485\n24#1:486\n63#1:487\n15#1:488\n40#1:489\n29#1:490\n24#1:491\n64#1:492\n15#1:493\n41#1:494\n29#1:495\n24#1:496\n65#1:497\n15#1:498\n42#1:499\n29#1:500\n24#1:501\n66#1:502\n15#1:503\n43#1:504\n29#1:505\n24#1:506\n67#1:507\n15#1:508\n44#1:509\n29#1:510\n24#1:511\n68#1:512\n15#1:513\n45#1:514\n29#1:515\n24#1:516\n69#1:517\n15#1:518\n46#1:519\n29#1:520\n24#1:521\n70#1:522\n15#1:523\n47#1:524\n29#1:525\n24#1:526\n71#1:527\n15#1:528\n48#1:529\n29#1:530\n24#1:531\n72#1:532\n15#1:533\n49#1:534\n29#1:535\n24#1:536\n73#1:537\n15#1:538\n50#1:539\n29#1:540\n24#1:541\n74#1:542\n15#1:543\n51#1:544\n29#1:545\n24#1:546\n75#1:547\n15#1:548\n52#1:549\n29#1:550\n24#1:551\n76#1:552\n15#1:553\n53#1:554\n29#1:555\n24#1:556\n77#1:557\n15#1:558\n54#1:559\n29#1:560\n24#1:561\n78#1:562\n15#1:563\n55#1:564\n29#1:565\n24#1:566\n79#1:567\n15#1:568\n56#1:569\n29#1:570\n24#1:571\n80#1:572\n15#1:573\n57#1:574\n29#1:575\n24#1:576\n81#1:577\n15#1:578\n58#1:579\n29#1:580\n24#1:581\n83#1:582\n60#1:583\n15#1:584\n37#1:585\n29#1:586\n24#1:587\n84#1:588\n61#1:589\n15#1:590\n38#1:591\n29#1:592\n24#1:593\n85#1:594\n62#1:595\n15#1:596\n39#1:597\n29#1:598\n24#1:599\n86#1:600\n63#1:601\n15#1:602\n40#1:603\n29#1:604\n24#1:605\n87#1:606\n64#1:607\n15#1:608\n41#1:609\n29#1:610\n24#1:611\n88#1:612\n65#1:613\n15#1:614\n42#1:615\n29#1:616\n24#1:617\n89#1:618\n66#1:619\n15#1:620\n43#1:621\n29#1:622\n24#1:623\n90#1:624\n67#1:625\n15#1:626\n44#1:627\n29#1:628\n24#1:629\n91#1:630\n68#1:631\n15#1:632\n45#1:633\n29#1:634\n24#1:635\n92#1:636\n69#1:637\n15#1:638\n46#1:639\n29#1:640\n24#1:641\n93#1:642\n70#1:643\n15#1:644\n47#1:645\n29#1:646\n24#1:647\n94#1:648\n71#1:649\n15#1:650\n48#1:651\n29#1:652\n24#1:653\n95#1:654\n72#1:655\n15#1:656\n49#1:657\n29#1:658\n24#1:659\n96#1:660\n73#1:661\n15#1:662\n50#1:663\n29#1:664\n24#1:665\n97#1:666\n74#1:667\n15#1:668\n51#1:669\n29#1:670\n24#1:671\n98#1:672\n75#1:673\n15#1:674\n52#1:675\n29#1:676\n24#1:677\n99#1:678\n76#1:679\n15#1:680\n53#1:681\n29#1:682\n24#1:683\n100#1:684\n77#1:685\n15#1:686\n54#1:687\n29#1:688\n24#1:689\n101#1:690\n78#1:691\n15#1:692\n55#1:693\n29#1:694\n24#1:695\n102#1:696\n79#1:697\n15#1:698\n56#1:699\n29#1:700\n24#1:701\n103#1:702\n80#1:703\n15#1:704\n57#1:705\n29#1:706\n24#1:707\n104#1:708\n81#1:709\n15#1:710\n58#1:711\n29#1:712\n24#1:713\n37#2,2:216\n37#2,2:228\n37#2,2:715\n1#3:714\n*S KotlinDebug\n*F\n+ 1 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n16#1:181\n19#1:182\n22#1:183,10\n26#1:193\n27#1:194,10\n29#1:204\n30#1:205,10\n33#1:215\n35#1:218,10\n37#1:230\n37#1:231\n38#1:232\n38#1:233\n39#1:234\n39#1:235\n40#1:236\n40#1:237\n41#1:238\n41#1:239\n42#1:240\n42#1:241\n43#1:242\n43#1:243\n44#1:244\n44#1:245\n45#1:246\n45#1:247\n46#1:248\n46#1:249\n47#1:250\n47#1:251\n48#1:252\n48#1:253\n49#1:254\n49#1:255\n50#1:256\n50#1:257\n51#1:258\n51#1:259\n52#1:260\n52#1:261\n53#1:262\n53#1:263\n54#1:264\n54#1:265\n55#1:266\n55#1:267\n56#1:268\n56#1:269\n57#1:270\n57#1:271\n58#1:272\n58#1:273\n60#1:274\n60#1:275\n60#1:276\n60#1:277\n61#1:278\n61#1:279\n61#1:280\n61#1:281\n62#1:282\n62#1:283\n62#1:284\n62#1:285\n63#1:286\n63#1:287\n63#1:288\n63#1:289\n64#1:290\n64#1:291\n64#1:292\n64#1:293\n65#1:294\n65#1:295\n65#1:296\n65#1:297\n66#1:298\n66#1:299\n66#1:300\n66#1:301\n67#1:302\n67#1:303\n67#1:304\n67#1:305\n68#1:306\n68#1:307\n68#1:308\n68#1:309\n69#1:310\n69#1:311\n69#1:312\n69#1:313\n70#1:314\n70#1:315\n70#1:316\n70#1:317\n71#1:318\n71#1:319\n71#1:320\n71#1:321\n72#1:322\n72#1:323\n72#1:324\n72#1:325\n73#1:326\n73#1:327\n73#1:328\n73#1:329\n74#1:330\n74#1:331\n74#1:332\n74#1:333\n75#1:334\n75#1:335\n75#1:336\n75#1:337\n76#1:338\n76#1:339\n76#1:340\n76#1:341\n77#1:342\n77#1:343\n77#1:344\n77#1:345\n78#1:346\n78#1:347\n78#1:348\n78#1:349\n79#1:350\n79#1:351\n79#1:352\n79#1:353\n80#1:354\n80#1:355\n80#1:356\n80#1:357\n81#1:358\n81#1:359\n81#1:360\n81#1:361\n83#1:362\n83#1:363\n83#1:364\n83#1:365\n83#1:366\n84#1:367\n84#1:368\n84#1:369\n84#1:370\n84#1:371\n85#1:372\n85#1:373\n85#1:374\n85#1:375\n85#1:376\n86#1:377\n86#1:378\n86#1:379\n86#1:380\n86#1:381\n87#1:382\n87#1:383\n87#1:384\n87#1:385\n87#1:386\n88#1:387\n88#1:388\n88#1:389\n88#1:390\n88#1:391\n89#1:392\n89#1:393\n89#1:394\n89#1:395\n89#1:396\n90#1:397\n90#1:398\n90#1:399\n90#1:400\n90#1:401\n91#1:402\n91#1:403\n91#1:404\n91#1:405\n91#1:406\n92#1:407\n92#1:408\n92#1:409\n92#1:410\n92#1:411\n93#1:412\n93#1:413\n93#1:414\n93#1:415\n93#1:416\n94#1:417\n94#1:418\n94#1:419\n94#1:420\n94#1:421\n95#1:422\n95#1:423\n95#1:424\n95#1:425\n95#1:426\n96#1:427\n96#1:428\n96#1:429\n96#1:430\n96#1:431\n97#1:432\n97#1:433\n97#1:434\n97#1:435\n97#1:436\n98#1:437\n98#1:438\n98#1:439\n98#1:440\n98#1:441\n99#1:442\n99#1:443\n99#1:444\n99#1:445\n99#1:446\n100#1:447\n100#1:448\n100#1:449\n100#1:450\n100#1:451\n101#1:452\n101#1:453\n101#1:454\n101#1:455\n101#1:456\n102#1:457\n102#1:458\n102#1:459\n102#1:460\n102#1:461\n103#1:462\n103#1:463\n103#1:464\n103#1:465\n103#1:466\n104#1:467\n104#1:468\n104#1:469\n104#1:470\n104#1:471\n106#1:472\n106#1:473\n106#1:474\n106#1:475\n106#1:476\n107#1:477\n107#1:478\n107#1:479\n107#1:480\n107#1:481\n108#1:482\n108#1:483\n108#1:484\n108#1:485\n108#1:486\n109#1:487\n109#1:488\n109#1:489\n109#1:490\n109#1:491\n110#1:492\n110#1:493\n110#1:494\n110#1:495\n110#1:496\n111#1:497\n111#1:498\n111#1:499\n111#1:500\n111#1:501\n112#1:502\n112#1:503\n112#1:504\n112#1:505\n112#1:506\n113#1:507\n113#1:508\n113#1:509\n113#1:510\n113#1:511\n114#1:512\n114#1:513\n114#1:514\n114#1:515\n114#1:516\n115#1:517\n115#1:518\n115#1:519\n115#1:520\n115#1:521\n116#1:522\n116#1:523\n116#1:524\n116#1:525\n116#1:526\n117#1:527\n117#1:528\n117#1:529\n117#1:530\n117#1:531\n118#1:532\n118#1:533\n118#1:534\n118#1:535\n118#1:536\n119#1:537\n119#1:538\n119#1:539\n119#1:540\n119#1:541\n120#1:542\n120#1:543\n120#1:544\n120#1:545\n120#1:546\n121#1:547\n121#1:548\n121#1:549\n121#1:550\n121#1:551\n122#1:552\n122#1:553\n122#1:554\n122#1:555\n122#1:556\n123#1:557\n123#1:558\n123#1:559\n123#1:560\n123#1:561\n124#1:562\n124#1:563\n124#1:564\n124#1:565\n124#1:566\n125#1:567\n125#1:568\n125#1:569\n125#1:570\n125#1:571\n126#1:572\n126#1:573\n126#1:574\n126#1:575\n126#1:576\n127#1:577\n127#1:578\n127#1:579\n127#1:580\n127#1:581\n129#1:582\n129#1:583\n129#1:584\n129#1:585\n129#1:586\n129#1:587\n130#1:588\n130#1:589\n130#1:590\n130#1:591\n130#1:592\n130#1:593\n131#1:594\n131#1:595\n131#1:596\n131#1:597\n131#1:598\n131#1:599\n132#1:600\n132#1:601\n132#1:602\n132#1:603\n132#1:604\n132#1:605\n133#1:606\n133#1:607\n133#1:608\n133#1:609\n133#1:610\n133#1:611\n134#1:612\n134#1:613\n134#1:614\n134#1:615\n134#1:616\n134#1:617\n135#1:618\n135#1:619\n135#1:620\n135#1:621\n135#1:622\n135#1:623\n136#1:624\n136#1:625\n136#1:626\n136#1:627\n136#1:628\n136#1:629\n137#1:630\n137#1:631\n137#1:632\n137#1:633\n137#1:634\n137#1:635\n138#1:636\n138#1:637\n138#1:638\n138#1:639\n138#1:640\n138#1:641\n139#1:642\n139#1:643\n139#1:644\n139#1:645\n139#1:646\n139#1:647\n140#1:648\n140#1:649\n140#1:650\n140#1:651\n140#1:652\n140#1:653\n141#1:654\n141#1:655\n141#1:656\n141#1:657\n141#1:658\n141#1:659\n142#1:660\n142#1:661\n142#1:662\n142#1:663\n142#1:664\n142#1:665\n143#1:666\n143#1:667\n143#1:668\n143#1:669\n143#1:670\n143#1:671\n144#1:672\n144#1:673\n144#1:674\n144#1:675\n144#1:676\n144#1:677\n145#1:678\n145#1:679\n145#1:680\n145#1:681\n145#1:682\n145#1:683\n146#1:684\n146#1:685\n146#1:686\n146#1:687\n146#1:688\n146#1:689\n147#1:690\n147#1:691\n147#1:692\n147#1:693\n147#1:694\n147#1:695\n148#1:696\n148#1:697\n148#1:698\n148#1:699\n148#1:700\n148#1:701\n149#1:702\n149#1:703\n149#1:704\n149#1:705\n149#1:706\n149#1:707\n150#1:708\n150#1:709\n150#1:710\n150#1:711\n150#1:712\n150#1:713\n33#1:216,2\n35#1:228,2\n179#1:715,2\n*E\n"})
public final class ComponentUtil {
    @NotNull
    public static final Component getC(@Nullable String $this$c) {
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        return component;
    }

    @NotNull
    public static final Component getComponent(@Nullable String $this$component) {
        boolean $i$f$getComponent = false;
        String $this$c$iv = $this$component;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        return component;
    }

    @NotNull
    public static final MutableComponent plus(@NotNull MutableComponent $this$plus, @NotNull Component other) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        boolean $i$f$plus = false;
        MutableComponent mutableComponent = $this$plus.append(other);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"append(...)");
        return mutableComponent;
    }

    @NotNull
    public static final MutableComponent plus(@NotNull Component $this$plus, @NotNull Component other) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        boolean $i$f$plus = false;
        Component $this$mut$iv = $this$plus;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.append(other);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"append(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent plus(@NotNull String $this$plus, @NotNull Component other) {
        void $this$plus$iv;
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        boolean $i$f$plus = false;
        String $this$c$iv = $this$plus;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv = component;
        Component other$iv = other;
        boolean $i$f$plus2 = false;
        void $this$mut$iv$iv = $this$plus$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.append(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"append(...)");
        return mutableComponent3;
    }

    @NotNull
    public static final MutableComponent mut(@NotNull Component $this$mut) {
        Intrinsics.checkNotNullParameter((Object)$this$mut, (String)"<this>");
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut instanceof MutableComponent ? (MutableComponent)$this$mut : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        return mutableComponent;
    }

    @NotNull
    public static final MutableComponent with(@NotNull Component $this$with, @NotNull Function1<? super StyleConfigurator, Unit> other) {
        Intrinsics.checkNotNullParameter((Object)$this$with, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        boolean $i$f$with = false;
        StyleConfigurator styleConfigurator = new StyleConfigurator();
        other.invoke((Object)styleConfigurator);
        Component $this$mut$iv = $this$with;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        return styleConfigurator.apply(mutableComponent);
    }

    @NotNull
    public static final MutableComponent with(@NotNull String $this$with, @NotNull Function1<? super StyleConfigurator, Unit> other) {
        Intrinsics.checkNotNullParameter((Object)$this$with, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        boolean $i$f$with = false;
        StyleConfigurator styleConfigurator = new StyleConfigurator();
        other.invoke((Object)styleConfigurator);
        String $this$c$iv = $this$with;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$mut$iv = component;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        return styleConfigurator.apply(mutableComponent);
    }

    @NotNull
    public static final MutableComponent with(@NotNull Component $this$with, @NotNull ChatFormatting other) {
        Intrinsics.checkNotNullParameter((Object)$this$with, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        boolean $i$f$with = false;
        Component $this$mut$iv = $this$with;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    @NotNull
    public static final MutableComponent with(@NotNull String $this$with, @NotNull ChatFormatting other) {
        Intrinsics.checkNotNullParameter((Object)$this$with, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        boolean $i$f$with = false;
        String $this$c$iv = $this$with;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$mut$iv = component;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    @NotNull
    public static final MutableComponent with(@NotNull Component $this$with, @NotNull Collection<? extends ChatFormatting> other) {
        Intrinsics.checkNotNullParameter((Object)$this$with, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        boolean $i$f$with = false;
        Component $this$mut$iv = $this$with;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        Collection<? extends ChatFormatting> $this$toTypedArray$iv = other;
        boolean $i$f$toTypedArray = false;
        Collection<? extends ChatFormatting> thisCollection$iv = $this$toTypedArray$iv;
        ChatFormatting[] chatFormattingArray = thisCollection$iv.toArray(new ChatFormatting[0]);
        MutableComponent mutableComponent3 = mutableComponent.withStyle(Arrays.copyOf(chatFormattingArray, chatFormattingArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    @NotNull
    public static final MutableComponent with(@NotNull String $this$with, @NotNull Collection<? extends ChatFormatting> other) {
        Intrinsics.checkNotNullParameter((Object)$this$with, (String)"<this>");
        Intrinsics.checkNotNullParameter(other, (String)"other");
        boolean $i$f$with = false;
        String $this$c$iv = $this$with;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$mut$iv = component;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        Collection<? extends ChatFormatting> $this$toTypedArray$iv = other;
        boolean $i$f$toTypedArray = false;
        Collection<? extends ChatFormatting> thisCollection$iv = $this$toTypedArray$iv;
        ChatFormatting[] chatFormattingArray = thisCollection$iv.toArray(new ChatFormatting[0]);
        MutableComponent mutableComponent3 = mutableComponent.withStyle(Arrays.copyOf(chatFormattingArray, chatFormattingArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBlack(@NotNull Component $this$black) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$black, (String)"<this>");
        boolean $i$f$getBlack = false;
        Component component = $this$black;
        ChatFormatting other$iv = ChatFormatting.BLACK;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkBlue(@NotNull Component $this$darkBlue) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkBlue, (String)"<this>");
        boolean $i$f$getDarkBlue = false;
        Component component = $this$darkBlue;
        ChatFormatting other$iv = ChatFormatting.DARK_BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkGreen(@NotNull Component $this$darkGreen) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkGreen, (String)"<this>");
        boolean $i$f$getDarkGreen = false;
        Component component = $this$darkGreen;
        ChatFormatting other$iv = ChatFormatting.DARK_GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkAqua(@NotNull Component $this$darkAqua) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkAqua, (String)"<this>");
        boolean $i$f$getDarkAqua = false;
        Component component = $this$darkAqua;
        ChatFormatting other$iv = ChatFormatting.DARK_AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkRed(@NotNull Component $this$darkRed) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkRed, (String)"<this>");
        boolean $i$f$getDarkRed = false;
        Component component = $this$darkRed;
        ChatFormatting other$iv = ChatFormatting.DARK_RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkPurple(@NotNull Component $this$darkPurple) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkPurple, (String)"<this>");
        boolean $i$f$getDarkPurple = false;
        Component component = $this$darkPurple;
        ChatFormatting other$iv = ChatFormatting.DARK_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGold(@NotNull Component $this$gold) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$gold, (String)"<this>");
        boolean $i$f$getGold = false;
        Component component = $this$gold;
        ChatFormatting other$iv = ChatFormatting.GOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGray(@NotNull Component $this$gray) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$gray, (String)"<this>");
        boolean $i$f$getGray = false;
        Component component = $this$gray;
        ChatFormatting other$iv = ChatFormatting.GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkGray(@NotNull Component $this$darkGray) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkGray, (String)"<this>");
        boolean $i$f$getDarkGray = false;
        Component component = $this$darkGray;
        ChatFormatting other$iv = ChatFormatting.DARK_GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBlue(@NotNull Component $this$blue) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$blue, (String)"<this>");
        boolean $i$f$getBlue = false;
        Component component = $this$blue;
        ChatFormatting other$iv = ChatFormatting.BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGreen(@NotNull Component $this$green) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$green, (String)"<this>");
        boolean $i$f$getGreen = false;
        Component component = $this$green;
        ChatFormatting other$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getAqua(@NotNull Component $this$aqua) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$aqua, (String)"<this>");
        boolean $i$f$getAqua = false;
        Component component = $this$aqua;
        ChatFormatting other$iv = ChatFormatting.AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getRed(@NotNull Component $this$red) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$red, (String)"<this>");
        boolean $i$f$getRed = false;
        Component component = $this$red;
        ChatFormatting other$iv = ChatFormatting.RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getLightPurple(@NotNull Component $this$lightPurple) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$lightPurple, (String)"<this>");
        boolean $i$f$getLightPurple = false;
        Component component = $this$lightPurple;
        ChatFormatting other$iv = ChatFormatting.LIGHT_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getYellow(@NotNull Component $this$yellow) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$yellow, (String)"<this>");
        boolean $i$f$getYellow = false;
        Component component = $this$yellow;
        ChatFormatting other$iv = ChatFormatting.YELLOW;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getWhite(@NotNull Component $this$white) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$white, (String)"<this>");
        boolean $i$f$getWhite = false;
        Component component = $this$white;
        ChatFormatting other$iv = ChatFormatting.WHITE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getObfuscated(@NotNull Component $this$obfuscated) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$obfuscated, (String)"<this>");
        boolean $i$f$getObfuscated = false;
        Component component = $this$obfuscated;
        ChatFormatting other$iv = ChatFormatting.OBFUSCATED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBold(@NotNull Component $this$bold) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$bold, (String)"<this>");
        boolean $i$f$getBold = false;
        Component component = $this$bold;
        ChatFormatting other$iv = ChatFormatting.BOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getStrikethrough(@NotNull Component $this$strikethrough) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$strikethrough, (String)"<this>");
        boolean $i$f$getStrikethrough = false;
        Component component = $this$strikethrough;
        ChatFormatting other$iv = ChatFormatting.STRIKETHROUGH;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getUnderline(@NotNull Component $this$underline) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$underline, (String)"<this>");
        boolean $i$f$getUnderline = false;
        Component component = $this$underline;
        ChatFormatting other$iv = ChatFormatting.UNDERLINE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getItalic(@NotNull Component $this$italic) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$italic, (String)"<this>");
        boolean $i$f$getItalic = false;
        Component component = $this$italic;
        ChatFormatting other$iv = ChatFormatting.ITALIC;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getReset(@NotNull Component $this$reset) {
        void $this$with$iv;
        Intrinsics.checkNotNullParameter((Object)$this$reset, (String)"<this>");
        boolean $i$f$getReset = false;
        Component component = $this$reset;
        ChatFormatting other$iv = ChatFormatting.RESET;
        boolean $i$f$with = false;
        void $this$mut$iv$iv = $this$with$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBlack(@NotNull String $this$black) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$black, (String)"<this>");
        boolean $i$f$getBlack = false;
        String $this$c$iv = $this$black;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$black$iv = component;
        boolean $i$f$getBlack2 = false;
        Component component2 = $this$black$iv;
        ChatFormatting other$iv$iv = ChatFormatting.BLACK;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkBlue(@NotNull String $this$darkBlue) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkBlue, (String)"<this>");
        boolean $i$f$getDarkBlue = false;
        String $this$c$iv = $this$darkBlue;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$darkBlue$iv = component;
        boolean $i$f$getDarkBlue2 = false;
        Component component2 = $this$darkBlue$iv;
        ChatFormatting other$iv$iv = ChatFormatting.DARK_BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkGreen(@NotNull String $this$darkGreen) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkGreen, (String)"<this>");
        boolean $i$f$getDarkGreen = false;
        String $this$c$iv = $this$darkGreen;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$darkGreen$iv = component;
        boolean $i$f$getDarkGreen2 = false;
        Component component2 = $this$darkGreen$iv;
        ChatFormatting other$iv$iv = ChatFormatting.DARK_GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkAqua(@NotNull String $this$darkAqua) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkAqua, (String)"<this>");
        boolean $i$f$getDarkAqua = false;
        String $this$c$iv = $this$darkAqua;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$darkAqua$iv = component;
        boolean $i$f$getDarkAqua2 = false;
        Component component2 = $this$darkAqua$iv;
        ChatFormatting other$iv$iv = ChatFormatting.DARK_AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkRed(@NotNull String $this$darkRed) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkRed, (String)"<this>");
        boolean $i$f$getDarkRed = false;
        String $this$c$iv = $this$darkRed;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$darkRed$iv = component;
        boolean $i$f$getDarkRed2 = false;
        Component component2 = $this$darkRed$iv;
        ChatFormatting other$iv$iv = ChatFormatting.DARK_RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkPurple(@NotNull String $this$darkPurple) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkPurple, (String)"<this>");
        boolean $i$f$getDarkPurple = false;
        String $this$c$iv = $this$darkPurple;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$darkPurple$iv = component;
        boolean $i$f$getDarkPurple2 = false;
        Component component2 = $this$darkPurple$iv;
        ChatFormatting other$iv$iv = ChatFormatting.DARK_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGold(@NotNull String $this$gold) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$gold, (String)"<this>");
        boolean $i$f$getGold = false;
        String $this$c$iv = $this$gold;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$gold$iv = component;
        boolean $i$f$getGold2 = false;
        Component component2 = $this$gold$iv;
        ChatFormatting other$iv$iv = ChatFormatting.GOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGray(@NotNull String $this$gray) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$gray, (String)"<this>");
        boolean $i$f$getGray = false;
        String $this$c$iv = $this$gray;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$gray$iv = component;
        boolean $i$f$getGray2 = false;
        Component component2 = $this$gray$iv;
        ChatFormatting other$iv$iv = ChatFormatting.GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkGray(@NotNull String $this$darkGray) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkGray, (String)"<this>");
        boolean $i$f$getDarkGray = false;
        String $this$c$iv = $this$darkGray;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$darkGray$iv = component;
        boolean $i$f$getDarkGray2 = false;
        Component component2 = $this$darkGray$iv;
        ChatFormatting other$iv$iv = ChatFormatting.DARK_GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBlue(@NotNull String $this$blue) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$blue, (String)"<this>");
        boolean $i$f$getBlue = false;
        String $this$c$iv = $this$blue;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$blue$iv = component;
        boolean $i$f$getBlue2 = false;
        Component component2 = $this$blue$iv;
        ChatFormatting other$iv$iv = ChatFormatting.BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGreen(@NotNull String $this$green) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$green, (String)"<this>");
        boolean $i$f$getGreen = false;
        String $this$c$iv = $this$green;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$green$iv = component;
        boolean $i$f$getGreen2 = false;
        Component component2 = $this$green$iv;
        ChatFormatting other$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getAqua(@NotNull String $this$aqua) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$aqua, (String)"<this>");
        boolean $i$f$getAqua = false;
        String $this$c$iv = $this$aqua;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$aqua$iv = component;
        boolean $i$f$getAqua2 = false;
        Component component2 = $this$aqua$iv;
        ChatFormatting other$iv$iv = ChatFormatting.AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getRed(@NotNull String $this$red) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$red, (String)"<this>");
        boolean $i$f$getRed = false;
        String $this$c$iv = $this$red;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$red$iv = component;
        boolean $i$f$getRed2 = false;
        Component component2 = $this$red$iv;
        ChatFormatting other$iv$iv = ChatFormatting.RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getLightPurple(@NotNull String $this$lightPurple) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$lightPurple, (String)"<this>");
        boolean $i$f$getLightPurple = false;
        String $this$c$iv = $this$lightPurple;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$lightPurple$iv = component;
        boolean $i$f$getLightPurple2 = false;
        Component component2 = $this$lightPurple$iv;
        ChatFormatting other$iv$iv = ChatFormatting.LIGHT_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getYellow(@NotNull String $this$yellow) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$yellow, (String)"<this>");
        boolean $i$f$getYellow = false;
        String $this$c$iv = $this$yellow;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$yellow$iv = component;
        boolean $i$f$getYellow2 = false;
        Component component2 = $this$yellow$iv;
        ChatFormatting other$iv$iv = ChatFormatting.YELLOW;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getWhite(@NotNull String $this$white) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$white, (String)"<this>");
        boolean $i$f$getWhite = false;
        String $this$c$iv = $this$white;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$white$iv = component;
        boolean $i$f$getWhite2 = false;
        Component component2 = $this$white$iv;
        ChatFormatting other$iv$iv = ChatFormatting.WHITE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getObfuscated(@NotNull String $this$obfuscated) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$obfuscated, (String)"<this>");
        boolean $i$f$getObfuscated = false;
        String $this$c$iv = $this$obfuscated;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$obfuscated$iv = component;
        boolean $i$f$getObfuscated2 = false;
        Component component2 = $this$obfuscated$iv;
        ChatFormatting other$iv$iv = ChatFormatting.OBFUSCATED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBold(@NotNull String $this$bold) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$bold, (String)"<this>");
        boolean $i$f$getBold = false;
        String $this$c$iv = $this$bold;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$bold$iv = component;
        boolean $i$f$getBold2 = false;
        Component component2 = $this$bold$iv;
        ChatFormatting other$iv$iv = ChatFormatting.BOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getStrikethrough(@NotNull String $this$strikethrough) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$strikethrough, (String)"<this>");
        boolean $i$f$getStrikethrough = false;
        String $this$c$iv = $this$strikethrough;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$strikethrough$iv = component;
        boolean $i$f$getStrikethrough2 = false;
        Component component2 = $this$strikethrough$iv;
        ChatFormatting other$iv$iv = ChatFormatting.STRIKETHROUGH;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getUnderline(@NotNull String $this$underline) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$underline, (String)"<this>");
        boolean $i$f$getUnderline = false;
        String $this$c$iv = $this$underline;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$underline$iv = component;
        boolean $i$f$getUnderline2 = false;
        Component component2 = $this$underline$iv;
        ChatFormatting other$iv$iv = ChatFormatting.UNDERLINE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getItalic(@NotNull String $this$italic) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$italic, (String)"<this>");
        boolean $i$f$getItalic = false;
        String $this$c$iv = $this$italic;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$italic$iv = component;
        boolean $i$f$getItalic2 = false;
        Component component2 = $this$italic$iv;
        ChatFormatting other$iv$iv = ChatFormatting.ITALIC;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getReset(@NotNull String $this$reset) {
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$reset, (String)"<this>");
        boolean $i$f$getReset = false;
        String $this$c$iv = $this$reset;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$reset$iv = component;
        boolean $i$f$getReset2 = false;
        Component component2 = $this$reset$iv;
        ChatFormatting other$iv$iv = ChatFormatting.RESET;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBlack(@NotNull ResourceLocation $this$black) {
        void $this$with$iv$iv$iv;
        void $this$black$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$black, (String)"<this>");
        boolean $i$f$getBlack = false;
        String string = $this$black.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$black$iv = string;
        boolean $i$f$getBlack2 = false;
        String $this$c$iv$iv = $this$black$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getBlack3 = false;
        void var6_6 = $this$black$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BLACK;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkBlue(@NotNull ResourceLocation $this$darkBlue) {
        void $this$with$iv$iv$iv;
        void $this$darkBlue$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkBlue, (String)"<this>");
        boolean $i$f$getDarkBlue = false;
        String string = $this$darkBlue.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkBlue$iv = string;
        boolean $i$f$getDarkBlue2 = false;
        String $this$c$iv$iv = $this$darkBlue$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkBlue3 = false;
        void var6_6 = $this$darkBlue$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkGreen(@NotNull ResourceLocation $this$darkGreen) {
        void $this$with$iv$iv$iv;
        void $this$darkGreen$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkGreen, (String)"<this>");
        boolean $i$f$getDarkGreen = false;
        String string = $this$darkGreen.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkGreen$iv = string;
        boolean $i$f$getDarkGreen2 = false;
        String $this$c$iv$iv = $this$darkGreen$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkGreen3 = false;
        void var6_6 = $this$darkGreen$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkAqua(@NotNull ResourceLocation $this$darkAqua) {
        void $this$with$iv$iv$iv;
        void $this$darkAqua$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkAqua, (String)"<this>");
        boolean $i$f$getDarkAqua = false;
        String string = $this$darkAqua.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkAqua$iv = string;
        boolean $i$f$getDarkAqua2 = false;
        String $this$c$iv$iv = $this$darkAqua$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkAqua3 = false;
        void var6_6 = $this$darkAqua$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkRed(@NotNull ResourceLocation $this$darkRed) {
        void $this$with$iv$iv$iv;
        void $this$darkRed$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkRed, (String)"<this>");
        boolean $i$f$getDarkRed = false;
        String string = $this$darkRed.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkRed$iv = string;
        boolean $i$f$getDarkRed2 = false;
        String $this$c$iv$iv = $this$darkRed$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkRed3 = false;
        void var6_6 = $this$darkRed$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkPurple(@NotNull ResourceLocation $this$darkPurple) {
        void $this$with$iv$iv$iv;
        void $this$darkPurple$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkPurple, (String)"<this>");
        boolean $i$f$getDarkPurple = false;
        String string = $this$darkPurple.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkPurple$iv = string;
        boolean $i$f$getDarkPurple2 = false;
        String $this$c$iv$iv = $this$darkPurple$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkPurple3 = false;
        void var6_6 = $this$darkPurple$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGold(@NotNull ResourceLocation $this$gold) {
        void $this$with$iv$iv$iv;
        void $this$gold$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$gold, (String)"<this>");
        boolean $i$f$getGold = false;
        String string = $this$gold.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$gold$iv = string;
        boolean $i$f$getGold2 = false;
        String $this$c$iv$iv = $this$gold$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGold3 = false;
        void var6_6 = $this$gold$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGray(@NotNull ResourceLocation $this$gray) {
        void $this$with$iv$iv$iv;
        void $this$gray$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$gray, (String)"<this>");
        boolean $i$f$getGray = false;
        String string = $this$gray.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$gray$iv = string;
        boolean $i$f$getGray2 = false;
        String $this$c$iv$iv = $this$gray$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGray3 = false;
        void var6_6 = $this$gray$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkGray(@NotNull ResourceLocation $this$darkGray) {
        void $this$with$iv$iv$iv;
        void $this$darkGray$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkGray, (String)"<this>");
        boolean $i$f$getDarkGray = false;
        String string = $this$darkGray.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkGray$iv = string;
        boolean $i$f$getDarkGray2 = false;
        String $this$c$iv$iv = $this$darkGray$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkGray3 = false;
        void var6_6 = $this$darkGray$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBlue(@NotNull ResourceLocation $this$blue) {
        void $this$with$iv$iv$iv;
        void $this$blue$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$blue, (String)"<this>");
        boolean $i$f$getBlue = false;
        String string = $this$blue.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$blue$iv = string;
        boolean $i$f$getBlue2 = false;
        String $this$c$iv$iv = $this$blue$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getBlue3 = false;
        void var6_6 = $this$blue$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGreen(@NotNull ResourceLocation $this$green) {
        void $this$with$iv$iv$iv;
        void $this$green$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$green, (String)"<this>");
        boolean $i$f$getGreen = false;
        String string = $this$green.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$green$iv = string;
        boolean $i$f$getGreen2 = false;
        String $this$c$iv$iv = $this$green$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGreen3 = false;
        void var6_6 = $this$green$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getAqua(@NotNull ResourceLocation $this$aqua) {
        void $this$with$iv$iv$iv;
        void $this$aqua$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$aqua, (String)"<this>");
        boolean $i$f$getAqua = false;
        String string = $this$aqua.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$aqua$iv = string;
        boolean $i$f$getAqua2 = false;
        String $this$c$iv$iv = $this$aqua$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getAqua3 = false;
        void var6_6 = $this$aqua$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getRed(@NotNull ResourceLocation $this$red) {
        void $this$with$iv$iv$iv;
        void $this$red$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$red, (String)"<this>");
        boolean $i$f$getRed = false;
        String string = $this$red.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$red$iv = string;
        boolean $i$f$getRed2 = false;
        String $this$c$iv$iv = $this$red$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getRed3 = false;
        void var6_6 = $this$red$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getLightPurple(@NotNull ResourceLocation $this$lightPurple) {
        void $this$with$iv$iv$iv;
        void $this$lightPurple$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$lightPurple, (String)"<this>");
        boolean $i$f$getLightPurple = false;
        String string = $this$lightPurple.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$lightPurple$iv = string;
        boolean $i$f$getLightPurple2 = false;
        String $this$c$iv$iv = $this$lightPurple$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getLightPurple3 = false;
        void var6_6 = $this$lightPurple$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.LIGHT_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getYellow(@NotNull ResourceLocation $this$yellow) {
        void $this$with$iv$iv$iv;
        void $this$yellow$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$yellow, (String)"<this>");
        boolean $i$f$getYellow = false;
        String string = $this$yellow.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$yellow$iv = string;
        boolean $i$f$getYellow2 = false;
        String $this$c$iv$iv = $this$yellow$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getYellow3 = false;
        void var6_6 = $this$yellow$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.YELLOW;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getWhite(@NotNull ResourceLocation $this$white) {
        void $this$with$iv$iv$iv;
        void $this$white$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$white, (String)"<this>");
        boolean $i$f$getWhite = false;
        String string = $this$white.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$white$iv = string;
        boolean $i$f$getWhite2 = false;
        String $this$c$iv$iv = $this$white$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getWhite3 = false;
        void var6_6 = $this$white$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.WHITE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getObfuscated(@NotNull ResourceLocation $this$obfuscated) {
        void $this$with$iv$iv$iv;
        void $this$obfuscated$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$obfuscated, (String)"<this>");
        boolean $i$f$getObfuscated = false;
        String string = $this$obfuscated.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$obfuscated$iv = string;
        boolean $i$f$getObfuscated2 = false;
        String $this$c$iv$iv = $this$obfuscated$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getObfuscated3 = false;
        void var6_6 = $this$obfuscated$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.OBFUSCATED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBold(@NotNull ResourceLocation $this$bold) {
        void $this$with$iv$iv$iv;
        void $this$bold$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$bold, (String)"<this>");
        boolean $i$f$getBold = false;
        String string = $this$bold.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$bold$iv = string;
        boolean $i$f$getBold2 = false;
        String $this$c$iv$iv = $this$bold$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getBold3 = false;
        void var6_6 = $this$bold$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getStrikethrough(@NotNull ResourceLocation $this$strikethrough) {
        void $this$with$iv$iv$iv;
        void $this$strikethrough$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$strikethrough, (String)"<this>");
        boolean $i$f$getStrikethrough = false;
        String string = $this$strikethrough.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$strikethrough$iv = string;
        boolean $i$f$getStrikethrough2 = false;
        String $this$c$iv$iv = $this$strikethrough$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getStrikethrough3 = false;
        void var6_6 = $this$strikethrough$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.STRIKETHROUGH;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getUnderline(@NotNull ResourceLocation $this$underline) {
        void $this$with$iv$iv$iv;
        void $this$underline$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$underline, (String)"<this>");
        boolean $i$f$getUnderline = false;
        String string = $this$underline.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$underline$iv = string;
        boolean $i$f$getUnderline2 = false;
        String $this$c$iv$iv = $this$underline$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getUnderline3 = false;
        void var6_6 = $this$underline$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.UNDERLINE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getItalic(@NotNull ResourceLocation $this$italic) {
        void $this$with$iv$iv$iv;
        void $this$italic$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$italic, (String)"<this>");
        boolean $i$f$getItalic = false;
        String string = $this$italic.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$italic$iv = string;
        boolean $i$f$getItalic2 = false;
        String $this$c$iv$iv = $this$italic$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getItalic3 = false;
        void var6_6 = $this$italic$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.ITALIC;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getReset(@NotNull ResourceLocation $this$reset) {
        void $this$with$iv$iv$iv;
        void $this$reset$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$reset, (String)"<this>");
        boolean $i$f$getReset = false;
        String string = $this$reset.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$reset$iv = string;
        boolean $i$f$getReset2 = false;
        String $this$c$iv$iv = $this$reset$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getReset3 = false;
        void var6_6 = $this$reset$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.RESET;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBlack(@NotNull Number $this$black) {
        void $this$with$iv$iv$iv;
        void $this$black$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$black, (String)"<this>");
        boolean $i$f$getBlack = false;
        String $this$black$iv = $this$black.toString();
        boolean $i$f$getBlack2 = false;
        String $this$c$iv$iv = $this$black$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getBlack3 = false;
        void var6_6 = $this$black$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BLACK;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkBlue(@NotNull Number $this$darkBlue) {
        void $this$with$iv$iv$iv;
        void $this$darkBlue$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkBlue, (String)"<this>");
        boolean $i$f$getDarkBlue = false;
        String $this$darkBlue$iv = $this$darkBlue.toString();
        boolean $i$f$getDarkBlue2 = false;
        String $this$c$iv$iv = $this$darkBlue$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkBlue3 = false;
        void var6_6 = $this$darkBlue$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkGreen(@NotNull Number $this$darkGreen) {
        void $this$with$iv$iv$iv;
        void $this$darkGreen$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkGreen, (String)"<this>");
        boolean $i$f$getDarkGreen = false;
        String $this$darkGreen$iv = $this$darkGreen.toString();
        boolean $i$f$getDarkGreen2 = false;
        String $this$c$iv$iv = $this$darkGreen$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkGreen3 = false;
        void var6_6 = $this$darkGreen$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkAqua(@NotNull Number $this$darkAqua) {
        void $this$with$iv$iv$iv;
        void $this$darkAqua$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkAqua, (String)"<this>");
        boolean $i$f$getDarkAqua = false;
        String $this$darkAqua$iv = $this$darkAqua.toString();
        boolean $i$f$getDarkAqua2 = false;
        String $this$c$iv$iv = $this$darkAqua$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkAqua3 = false;
        void var6_6 = $this$darkAqua$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkRed(@NotNull Number $this$darkRed) {
        void $this$with$iv$iv$iv;
        void $this$darkRed$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkRed, (String)"<this>");
        boolean $i$f$getDarkRed = false;
        String $this$darkRed$iv = $this$darkRed.toString();
        boolean $i$f$getDarkRed2 = false;
        String $this$c$iv$iv = $this$darkRed$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkRed3 = false;
        void var6_6 = $this$darkRed$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkPurple(@NotNull Number $this$darkPurple) {
        void $this$with$iv$iv$iv;
        void $this$darkPurple$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkPurple, (String)"<this>");
        boolean $i$f$getDarkPurple = false;
        String $this$darkPurple$iv = $this$darkPurple.toString();
        boolean $i$f$getDarkPurple2 = false;
        String $this$c$iv$iv = $this$darkPurple$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkPurple3 = false;
        void var6_6 = $this$darkPurple$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGold(@NotNull Number $this$gold) {
        void $this$with$iv$iv$iv;
        void $this$gold$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$gold, (String)"<this>");
        boolean $i$f$getGold = false;
        String $this$gold$iv = $this$gold.toString();
        boolean $i$f$getGold2 = false;
        String $this$c$iv$iv = $this$gold$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGold3 = false;
        void var6_6 = $this$gold$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGray(@NotNull Number $this$gray) {
        void $this$with$iv$iv$iv;
        void $this$gray$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$gray, (String)"<this>");
        boolean $i$f$getGray = false;
        String $this$gray$iv = $this$gray.toString();
        boolean $i$f$getGray2 = false;
        String $this$c$iv$iv = $this$gray$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGray3 = false;
        void var6_6 = $this$gray$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getDarkGray(@NotNull Number $this$darkGray) {
        void $this$with$iv$iv$iv;
        void $this$darkGray$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$darkGray, (String)"<this>");
        boolean $i$f$getDarkGray = false;
        String $this$darkGray$iv = $this$darkGray.toString();
        boolean $i$f$getDarkGray2 = false;
        String $this$c$iv$iv = $this$darkGray$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkGray3 = false;
        void var6_6 = $this$darkGray$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBlue(@NotNull Number $this$blue) {
        void $this$with$iv$iv$iv;
        void $this$blue$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$blue, (String)"<this>");
        boolean $i$f$getBlue = false;
        String $this$blue$iv = $this$blue.toString();
        boolean $i$f$getBlue2 = false;
        String $this$c$iv$iv = $this$blue$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getBlue3 = false;
        void var6_6 = $this$blue$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getGreen(@NotNull Number $this$green) {
        void $this$with$iv$iv$iv;
        void $this$green$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$green, (String)"<this>");
        boolean $i$f$getGreen = false;
        String $this$green$iv = $this$green.toString();
        boolean $i$f$getGreen2 = false;
        String $this$c$iv$iv = $this$green$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGreen3 = false;
        void var6_6 = $this$green$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getAqua(@NotNull Number $this$aqua) {
        void $this$with$iv$iv$iv;
        void $this$aqua$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$aqua, (String)"<this>");
        boolean $i$f$getAqua = false;
        String $this$aqua$iv = $this$aqua.toString();
        boolean $i$f$getAqua2 = false;
        String $this$c$iv$iv = $this$aqua$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getAqua3 = false;
        void var6_6 = $this$aqua$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getRed(@NotNull Number $this$red) {
        void $this$with$iv$iv$iv;
        void $this$red$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$red, (String)"<this>");
        boolean $i$f$getRed = false;
        String $this$red$iv = $this$red.toString();
        boolean $i$f$getRed2 = false;
        String $this$c$iv$iv = $this$red$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getRed3 = false;
        void var6_6 = $this$red$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getLightPurple(@NotNull Number $this$lightPurple) {
        void $this$with$iv$iv$iv;
        void $this$lightPurple$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$lightPurple, (String)"<this>");
        boolean $i$f$getLightPurple = false;
        String $this$lightPurple$iv = $this$lightPurple.toString();
        boolean $i$f$getLightPurple2 = false;
        String $this$c$iv$iv = $this$lightPurple$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getLightPurple3 = false;
        void var6_6 = $this$lightPurple$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.LIGHT_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getYellow(@NotNull Number $this$yellow) {
        void $this$with$iv$iv$iv;
        void $this$yellow$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$yellow, (String)"<this>");
        boolean $i$f$getYellow = false;
        String $this$yellow$iv = $this$yellow.toString();
        boolean $i$f$getYellow2 = false;
        String $this$c$iv$iv = $this$yellow$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getYellow3 = false;
        void var6_6 = $this$yellow$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.YELLOW;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getWhite(@NotNull Number $this$white) {
        void $this$with$iv$iv$iv;
        void $this$white$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$white, (String)"<this>");
        boolean $i$f$getWhite = false;
        String $this$white$iv = $this$white.toString();
        boolean $i$f$getWhite2 = false;
        String $this$c$iv$iv = $this$white$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getWhite3 = false;
        void var6_6 = $this$white$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.WHITE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getObfuscated(@NotNull Number $this$obfuscated) {
        void $this$with$iv$iv$iv;
        void $this$obfuscated$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$obfuscated, (String)"<this>");
        boolean $i$f$getObfuscated = false;
        String $this$obfuscated$iv = $this$obfuscated.toString();
        boolean $i$f$getObfuscated2 = false;
        String $this$c$iv$iv = $this$obfuscated$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getObfuscated3 = false;
        void var6_6 = $this$obfuscated$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.OBFUSCATED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getBold(@NotNull Number $this$bold) {
        void $this$with$iv$iv$iv;
        void $this$bold$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$bold, (String)"<this>");
        boolean $i$f$getBold = false;
        String $this$bold$iv = $this$bold.toString();
        boolean $i$f$getBold2 = false;
        String $this$c$iv$iv = $this$bold$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getBold3 = false;
        void var6_6 = $this$bold$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getStrikethrough(@NotNull Number $this$strikethrough) {
        void $this$with$iv$iv$iv;
        void $this$strikethrough$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$strikethrough, (String)"<this>");
        boolean $i$f$getStrikethrough = false;
        String $this$strikethrough$iv = $this$strikethrough.toString();
        boolean $i$f$getStrikethrough2 = false;
        String $this$c$iv$iv = $this$strikethrough$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getStrikethrough3 = false;
        void var6_6 = $this$strikethrough$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.STRIKETHROUGH;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getUnderline(@NotNull Number $this$underline) {
        void $this$with$iv$iv$iv;
        void $this$underline$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$underline, (String)"<this>");
        boolean $i$f$getUnderline = false;
        String $this$underline$iv = $this$underline.toString();
        boolean $i$f$getUnderline2 = false;
        String $this$c$iv$iv = $this$underline$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getUnderline3 = false;
        void var6_6 = $this$underline$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.UNDERLINE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getItalic(@NotNull Number $this$italic) {
        void $this$with$iv$iv$iv;
        void $this$italic$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$italic, (String)"<this>");
        boolean $i$f$getItalic = false;
        String $this$italic$iv = $this$italic.toString();
        boolean $i$f$getItalic2 = false;
        String $this$c$iv$iv = $this$italic$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getItalic3 = false;
        void var6_6 = $this$italic$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.ITALIC;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final MutableComponent getReset(@NotNull Number $this$reset) {
        void $this$with$iv$iv$iv;
        void $this$reset$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$reset, (String)"<this>");
        boolean $i$f$getReset = false;
        String $this$reset$iv = $this$reset.toString();
        boolean $i$f$getReset2 = false;
        String $this$c$iv$iv = $this$reset$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getReset3 = false;
        void var6_6 = $this$reset$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.RESET;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getBlack(@NotNull ResourceKey<T> $this$black) {
        void $this$with$iv$iv$iv$iv;
        void $this$black$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$black, (String)"<this>");
        boolean $i$f$getBlack = false;
        ResourceLocation resourceLocation = $this$black.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$black$iv = resourceLocation;
        boolean $i$f$getBlack2 = false;
        String string = $this$black$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$black$iv$iv = string;
        boolean $i$f$getBlack3 = false;
        String $this$c$iv$iv$iv = $this$black$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getBlack4 = false;
        void var8_8 = $this$black$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.BLACK;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getDarkBlue(@NotNull ResourceKey<T> $this$darkBlue) {
        void $this$with$iv$iv$iv$iv;
        void $this$darkBlue$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$darkBlue, (String)"<this>");
        boolean $i$f$getDarkBlue = false;
        ResourceLocation resourceLocation = $this$darkBlue.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$darkBlue$iv = resourceLocation;
        boolean $i$f$getDarkBlue2 = false;
        String string = $this$darkBlue$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkBlue$iv$iv = string;
        boolean $i$f$getDarkBlue3 = false;
        String $this$c$iv$iv$iv = $this$darkBlue$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getDarkBlue4 = false;
        void var8_8 = $this$darkBlue$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.DARK_BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getDarkGreen(@NotNull ResourceKey<T> $this$darkGreen) {
        void $this$with$iv$iv$iv$iv;
        void $this$darkGreen$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$darkGreen, (String)"<this>");
        boolean $i$f$getDarkGreen = false;
        ResourceLocation resourceLocation = $this$darkGreen.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$darkGreen$iv = resourceLocation;
        boolean $i$f$getDarkGreen2 = false;
        String string = $this$darkGreen$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkGreen$iv$iv = string;
        boolean $i$f$getDarkGreen3 = false;
        String $this$c$iv$iv$iv = $this$darkGreen$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getDarkGreen4 = false;
        void var8_8 = $this$darkGreen$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.DARK_GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getDarkAqua(@NotNull ResourceKey<T> $this$darkAqua) {
        void $this$with$iv$iv$iv$iv;
        void $this$darkAqua$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$darkAqua, (String)"<this>");
        boolean $i$f$getDarkAqua = false;
        ResourceLocation resourceLocation = $this$darkAqua.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$darkAqua$iv = resourceLocation;
        boolean $i$f$getDarkAqua2 = false;
        String string = $this$darkAqua$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkAqua$iv$iv = string;
        boolean $i$f$getDarkAqua3 = false;
        String $this$c$iv$iv$iv = $this$darkAqua$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getDarkAqua4 = false;
        void var8_8 = $this$darkAqua$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.DARK_AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getDarkRed(@NotNull ResourceKey<T> $this$darkRed) {
        void $this$with$iv$iv$iv$iv;
        void $this$darkRed$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$darkRed, (String)"<this>");
        boolean $i$f$getDarkRed = false;
        ResourceLocation resourceLocation = $this$darkRed.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$darkRed$iv = resourceLocation;
        boolean $i$f$getDarkRed2 = false;
        String string = $this$darkRed$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkRed$iv$iv = string;
        boolean $i$f$getDarkRed3 = false;
        String $this$c$iv$iv$iv = $this$darkRed$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getDarkRed4 = false;
        void var8_8 = $this$darkRed$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.DARK_RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getDarkPurple(@NotNull ResourceKey<T> $this$darkPurple) {
        void $this$with$iv$iv$iv$iv;
        void $this$darkPurple$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$darkPurple, (String)"<this>");
        boolean $i$f$getDarkPurple = false;
        ResourceLocation resourceLocation = $this$darkPurple.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$darkPurple$iv = resourceLocation;
        boolean $i$f$getDarkPurple2 = false;
        String string = $this$darkPurple$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkPurple$iv$iv = string;
        boolean $i$f$getDarkPurple3 = false;
        String $this$c$iv$iv$iv = $this$darkPurple$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getDarkPurple4 = false;
        void var8_8 = $this$darkPurple$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.DARK_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getGold(@NotNull ResourceKey<T> $this$gold) {
        void $this$with$iv$iv$iv$iv;
        void $this$gold$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$gold, (String)"<this>");
        boolean $i$f$getGold = false;
        ResourceLocation resourceLocation = $this$gold.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$gold$iv = resourceLocation;
        boolean $i$f$getGold2 = false;
        String string = $this$gold$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$gold$iv$iv = string;
        boolean $i$f$getGold3 = false;
        String $this$c$iv$iv$iv = $this$gold$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getGold4 = false;
        void var8_8 = $this$gold$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.GOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getGray(@NotNull ResourceKey<T> $this$gray) {
        void $this$with$iv$iv$iv$iv;
        void $this$gray$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$gray, (String)"<this>");
        boolean $i$f$getGray = false;
        ResourceLocation resourceLocation = $this$gray.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$gray$iv = resourceLocation;
        boolean $i$f$getGray2 = false;
        String string = $this$gray$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$gray$iv$iv = string;
        boolean $i$f$getGray3 = false;
        String $this$c$iv$iv$iv = $this$gray$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getGray4 = false;
        void var8_8 = $this$gray$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getDarkGray(@NotNull ResourceKey<T> $this$darkGray) {
        void $this$with$iv$iv$iv$iv;
        void $this$darkGray$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$darkGray, (String)"<this>");
        boolean $i$f$getDarkGray = false;
        ResourceLocation resourceLocation = $this$darkGray.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$darkGray$iv = resourceLocation;
        boolean $i$f$getDarkGray2 = false;
        String string = $this$darkGray$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$darkGray$iv$iv = string;
        boolean $i$f$getDarkGray3 = false;
        String $this$c$iv$iv$iv = $this$darkGray$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getDarkGray4 = false;
        void var8_8 = $this$darkGray$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.DARK_GRAY;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getBlue(@NotNull ResourceKey<T> $this$blue) {
        void $this$with$iv$iv$iv$iv;
        void $this$blue$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$blue, (String)"<this>");
        boolean $i$f$getBlue = false;
        ResourceLocation resourceLocation = $this$blue.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$blue$iv = resourceLocation;
        boolean $i$f$getBlue2 = false;
        String string = $this$blue$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$blue$iv$iv = string;
        boolean $i$f$getBlue3 = false;
        String $this$c$iv$iv$iv = $this$blue$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getBlue4 = false;
        void var8_8 = $this$blue$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.BLUE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getGreen(@NotNull ResourceKey<T> $this$green) {
        void $this$with$iv$iv$iv$iv;
        void $this$green$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$green, (String)"<this>");
        boolean $i$f$getGreen = false;
        ResourceLocation resourceLocation = $this$green.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$green$iv = resourceLocation;
        boolean $i$f$getGreen2 = false;
        String string = $this$green$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$green$iv$iv = string;
        boolean $i$f$getGreen3 = false;
        String $this$c$iv$iv$iv = $this$green$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getGreen4 = false;
        void var8_8 = $this$green$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getAqua(@NotNull ResourceKey<T> $this$aqua) {
        void $this$with$iv$iv$iv$iv;
        void $this$aqua$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$aqua, (String)"<this>");
        boolean $i$f$getAqua = false;
        ResourceLocation resourceLocation = $this$aqua.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$aqua$iv = resourceLocation;
        boolean $i$f$getAqua2 = false;
        String string = $this$aqua$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$aqua$iv$iv = string;
        boolean $i$f$getAqua3 = false;
        String $this$c$iv$iv$iv = $this$aqua$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getAqua4 = false;
        void var8_8 = $this$aqua$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.AQUA;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getRed(@NotNull ResourceKey<T> $this$red) {
        void $this$with$iv$iv$iv$iv;
        void $this$red$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$red, (String)"<this>");
        boolean $i$f$getRed = false;
        ResourceLocation resourceLocation = $this$red.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$red$iv = resourceLocation;
        boolean $i$f$getRed2 = false;
        String string = $this$red$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$red$iv$iv = string;
        boolean $i$f$getRed3 = false;
        String $this$c$iv$iv$iv = $this$red$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getRed4 = false;
        void var8_8 = $this$red$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.RED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getLightPurple(@NotNull ResourceKey<T> $this$lightPurple) {
        void $this$with$iv$iv$iv$iv;
        void $this$lightPurple$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$lightPurple, (String)"<this>");
        boolean $i$f$getLightPurple = false;
        ResourceLocation resourceLocation = $this$lightPurple.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$lightPurple$iv = resourceLocation;
        boolean $i$f$getLightPurple2 = false;
        String string = $this$lightPurple$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$lightPurple$iv$iv = string;
        boolean $i$f$getLightPurple3 = false;
        String $this$c$iv$iv$iv = $this$lightPurple$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getLightPurple4 = false;
        void var8_8 = $this$lightPurple$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.LIGHT_PURPLE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getYellow(@NotNull ResourceKey<T> $this$yellow) {
        void $this$with$iv$iv$iv$iv;
        void $this$yellow$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$yellow, (String)"<this>");
        boolean $i$f$getYellow = false;
        ResourceLocation resourceLocation = $this$yellow.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$yellow$iv = resourceLocation;
        boolean $i$f$getYellow2 = false;
        String string = $this$yellow$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$yellow$iv$iv = string;
        boolean $i$f$getYellow3 = false;
        String $this$c$iv$iv$iv = $this$yellow$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getYellow4 = false;
        void var8_8 = $this$yellow$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.YELLOW;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getWhite(@NotNull ResourceKey<T> $this$white) {
        void $this$with$iv$iv$iv$iv;
        void $this$white$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$white, (String)"<this>");
        boolean $i$f$getWhite = false;
        ResourceLocation resourceLocation = $this$white.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$white$iv = resourceLocation;
        boolean $i$f$getWhite2 = false;
        String string = $this$white$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$white$iv$iv = string;
        boolean $i$f$getWhite3 = false;
        String $this$c$iv$iv$iv = $this$white$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getWhite4 = false;
        void var8_8 = $this$white$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.WHITE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getObfuscated(@NotNull ResourceKey<T> $this$obfuscated) {
        void $this$with$iv$iv$iv$iv;
        void $this$obfuscated$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$obfuscated, (String)"<this>");
        boolean $i$f$getObfuscated = false;
        ResourceLocation resourceLocation = $this$obfuscated.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$obfuscated$iv = resourceLocation;
        boolean $i$f$getObfuscated2 = false;
        String string = $this$obfuscated$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$obfuscated$iv$iv = string;
        boolean $i$f$getObfuscated3 = false;
        String $this$c$iv$iv$iv = $this$obfuscated$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getObfuscated4 = false;
        void var8_8 = $this$obfuscated$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.OBFUSCATED;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getBold(@NotNull ResourceKey<T> $this$bold) {
        void $this$with$iv$iv$iv$iv;
        void $this$bold$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$bold, (String)"<this>");
        boolean $i$f$getBold = false;
        ResourceLocation resourceLocation = $this$bold.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$bold$iv = resourceLocation;
        boolean $i$f$getBold2 = false;
        String string = $this$bold$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$bold$iv$iv = string;
        boolean $i$f$getBold3 = false;
        String $this$c$iv$iv$iv = $this$bold$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getBold4 = false;
        void var8_8 = $this$bold$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.BOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getStrikethrough(@NotNull ResourceKey<T> $this$strikethrough) {
        void $this$with$iv$iv$iv$iv;
        void $this$strikethrough$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$strikethrough, (String)"<this>");
        boolean $i$f$getStrikethrough = false;
        ResourceLocation resourceLocation = $this$strikethrough.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$strikethrough$iv = resourceLocation;
        boolean $i$f$getStrikethrough2 = false;
        String string = $this$strikethrough$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$strikethrough$iv$iv = string;
        boolean $i$f$getStrikethrough3 = false;
        String $this$c$iv$iv$iv = $this$strikethrough$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getStrikethrough4 = false;
        void var8_8 = $this$strikethrough$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.STRIKETHROUGH;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getUnderline(@NotNull ResourceKey<T> $this$underline) {
        void $this$with$iv$iv$iv$iv;
        void $this$underline$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$underline, (String)"<this>");
        boolean $i$f$getUnderline = false;
        ResourceLocation resourceLocation = $this$underline.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$underline$iv = resourceLocation;
        boolean $i$f$getUnderline2 = false;
        String string = $this$underline$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$underline$iv$iv = string;
        boolean $i$f$getUnderline3 = false;
        String $this$c$iv$iv$iv = $this$underline$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getUnderline4 = false;
        void var8_8 = $this$underline$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.UNDERLINE;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getItalic(@NotNull ResourceKey<T> $this$italic) {
        void $this$with$iv$iv$iv$iv;
        void $this$italic$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$italic, (String)"<this>");
        boolean $i$f$getItalic = false;
        ResourceLocation resourceLocation = $this$italic.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$italic$iv = resourceLocation;
        boolean $i$f$getItalic2 = false;
        String string = $this$italic$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$italic$iv$iv = string;
        boolean $i$f$getItalic3 = false;
        String $this$c$iv$iv$iv = $this$italic$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getItalic4 = false;
        void var8_8 = $this$italic$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.ITALIC;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> MutableComponent getReset(@NotNull ResourceKey<T> $this$reset) {
        void $this$with$iv$iv$iv$iv;
        void $this$reset$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$reset, (String)"<this>");
        boolean $i$f$getReset = false;
        ResourceLocation resourceLocation = $this$reset.location();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"location(...)");
        ResourceLocation $this$reset$iv = resourceLocation;
        boolean $i$f$getReset2 = false;
        String string = $this$reset$iv.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String $this$reset$iv$iv = string;
        boolean $i$f$getReset3 = false;
        String $this$c$iv$iv$iv = $this$reset$iv$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv$iv = component;
        boolean $i$f$getReset4 = false;
        void var8_8 = $this$reset$iv$iv$iv;
        ChatFormatting other$iv$iv$iv$iv = ChatFormatting.RESET;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv$iv = $this$with$iv$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        return mutableComponent3;
    }

    @Nullable
    public static final String getTranslationKey(@NotNull Component $this$translationKey) {
        Intrinsics.checkNotNullParameter((Object)$this$translationKey, (String)"<this>");
        ComponentContents componentContents = $this$translationKey.getContents();
        TranslatableContents translatableContents = componentContents instanceof TranslatableContents ? (TranslatableContents)componentContents : null;
        return translatableContents != null ? translatableContents.getKey() : null;
    }

    @Nullable
    public static final MutableComponent withReplacements(@NotNull Component $this$withReplacements, Object ... values) {
        MutableComponent mutableComponent;
        Intrinsics.checkNotNullParameter((Object)$this$withReplacements, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)values, (String)"values");
        String string = ComponentUtil.getTranslationKey($this$withReplacements);
        if (string != null) {
            String it = string;
            boolean bl = false;
            mutableComponent = Component.translatable((String)it, (Object[])Arrays.copyOf(values, values.length));
        } else {
            mutableComponent = null;
        }
        return mutableComponent;
    }

    @Nullable
    public static final MutableComponent format(@NotNull Component $this$format, @NotNull Object value) {
        MutableComponent mutableComponent;
        Intrinsics.checkNotNullParameter((Object)$this$format, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        String string = ComponentUtil.getTranslationKey($this$format);
        if (string != null) {
            String it = string;
            boolean bl = false;
            Object[] objectArray = new Object[]{value};
            mutableComponent = Component.translatable((String)it, (Object[])objectArray);
        } else {
            mutableComponent = null;
        }
        return mutableComponent;
    }

    @Nullable
    public static final MutableComponent format(@NotNull Component $this$format, @NotNull Collection<? extends Object> value) {
        MutableComponent mutableComponent;
        Intrinsics.checkNotNullParameter((Object)$this$format, (String)"<this>");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        String string = ComponentUtil.getTranslationKey($this$format);
        if (string != null) {
            String it = string;
            boolean bl = false;
            Collection<? extends Object> $this$toTypedArray$iv = value;
            boolean $i$f$toTypedArray = false;
            Collection<? extends Object> thisCollection$iv = $this$toTypedArray$iv;
            Object[] objectArray = thisCollection$iv.toArray(new Object[0]);
            mutableComponent = Component.translatable((String)it, (Object[])Arrays.copyOf(objectArray, objectArray.length));
        } else {
            mutableComponent = null;
        }
        return mutableComponent;
    }
}

