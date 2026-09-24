/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/registry/TBSDimensions;", "", "<init>", "()V", "CLAN_VOID", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "NULL_TORTURE", "CORRUPTED_MOON", "NOWHERE", "LIMBO", "LUCID", "NOTHING", "PROTECTED_VOID", "LIBRARY", "CONCRETE", "STAGE2", "STAGE3", "ALL", "", "NIGHTMARES", "dim", "id", "", "thebrokenscript-common"})
public final class TBSDimensions {
    @NotNull
    public static final TBSDimensions INSTANCE = new TBSDimensions();
    @JvmField
    @NotNull
    public static final ResourceKey<Level> CLAN_VOID = INSTANCE.dim("clan_void");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> NULL_TORTURE = INSTANCE.dim("null_torture");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> CORRUPTED_MOON = INSTANCE.dim("the_moon");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> NOWHERE = INSTANCE.dim("nowhere");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> LIMBO = INSTANCE.dim("limbo");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> LUCID = INSTANCE.dim("lucid");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> NOTHING = INSTANCE.dim("nothing");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> PROTECTED_VOID = INSTANCE.dim("protected_void");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> LIBRARY = INSTANCE.dim("library");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> CONCRETE = INSTANCE.dim("concrete");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> STAGE2 = INSTANCE.dim("stage2");
    @JvmField
    @NotNull
    public static final ResourceKey<Level> STAGE3 = INSTANCE.dim("void_shadow");
    @JvmField
    @NotNull
    public static final List<ResourceKey<Level>> ALL;
    @JvmField
    @NotNull
    public static final List<ResourceKey<Level>> NIGHTMARES;

    private TBSDimensions() {
    }

    private final ResourceKey<Level> dim(String id) {
        ResourceKey resourceKey = ResourceKey.create((ResourceKey)Registries.DIMENSION, (ResourceLocation)TBSConstants.id(id));
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"create(...)");
        return resourceKey;
    }

    static {
        Object[] objectArray = new ResourceKey[]{CLAN_VOID, NULL_TORTURE, CORRUPTED_MOON, NOWHERE, LIMBO, NOTHING, PROTECTED_VOID, LIBRARY, CONCRETE, LUCID, STAGE2, STAGE3};
        ALL = CollectionsKt.listOf((Object[])objectArray);
        objectArray = new ResourceKey[]{LIBRARY, CONCRETE, LIMBO, NOTHING};
        NIGHTMARES = CollectionsKt.listOf((Object[])objectArray);
    }
}

