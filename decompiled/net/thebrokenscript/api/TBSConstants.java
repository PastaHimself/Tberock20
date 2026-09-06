/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/api/TBSConstants;", "", "<init>", "()V", "MOD_ID", "", "MAP_DATA_VERSION", "", "PLAYER_DATA_VERSION", "VOID_ENTITIES", "id", "Lnet/minecraft/resources/ResourceLocation;", "path", "IS_TEST_BUILD", "", "thebrokenscript-common"})
public final class TBSConstants {
    @NotNull
    public static final TBSConstants INSTANCE = new TBSConstants();
    @NotNull
    public static final String MOD_ID = "thebrokenscript";
    public static final int MAP_DATA_VERSION = 3;
    public static final int PLAYER_DATA_VERSION = 2;
    @NotNull
    public static final String VOID_ENTITIES = "made of wires";
    public static final boolean IS_TEST_BUILD = false;

    private TBSConstants() {
    }

    @JvmStatic
    @NotNull
    public static final ResourceLocation id(@NotNull String path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)MOD_ID, (String)path);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }
}

