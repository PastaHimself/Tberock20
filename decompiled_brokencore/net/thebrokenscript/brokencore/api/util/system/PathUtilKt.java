/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util.system;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u001c\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\b"}, d2={"join", "", "Lnet/minecraft/resources/ResourceLocation;", "with", "assetPath", "category", "ext", "modelPath", "brokencore-common"})
public final class PathUtilKt {
    @NotNull
    public static final String join(@NotNull ResourceLocation $this$join, @NotNull String with) {
        Intrinsics.checkNotNullParameter((Object)$this$join, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)with, (String)"with");
        return $this$join.getNamespace() + with + $this$join.getPath();
    }

    @NotNull
    public static final String assetPath(@NotNull ResourceLocation $this$assetPath, @NotNull String category, @NotNull String ext) {
        Intrinsics.checkNotNullParameter((Object)$this$assetPath, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)category, (String)"category");
        Intrinsics.checkNotNullParameter((Object)ext, (String)"ext");
        return "assets/" + $this$assetPath.getNamespace() + "/" + category + "/" + $this$assetPath.getPath() + ext;
    }

    public static /* synthetic */ String assetPath$default(ResourceLocation resourceLocation, String string, String string2, int n, Object object) {
        if ((n & 2) != 0) {
            string2 = "";
        }
        return PathUtilKt.assetPath(resourceLocation, string, string2);
    }

    @NotNull
    public static final String modelPath(@NotNull ResourceLocation $this$modelPath) {
        Intrinsics.checkNotNullParameter((Object)$this$modelPath, (String)"<this>");
        return PathUtilKt.assetPath($this$modelPath, "models", ".json");
    }
}

