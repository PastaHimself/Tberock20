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
package net.thebrokenscript.brokencore.api;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/BCApi;", "", "<init>", "()V", "MOD_ID", "", "id", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
public final class BCApi {
    @NotNull
    public static final BCApi INSTANCE = new BCApi();
    @NotNull
    public static final String MOD_ID = "brokencore";

    private BCApi() {
    }

    @JvmStatic
    @NotNull
    public static final ResourceLocation id(@NotNull String id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)MOD_ID, (String)id);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }
}

