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
package net.thebrokenscript.brokencore.api.util.system;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/util/system/FileHelper;", "", "<init>", "()V", "fileExists", "", "path", "", "loc", "Lnet/minecraft/resources/ResourceLocation;", "getResourceAsPath", "brokencore-common"})
public final class FileHelper {
    @NotNull
    public static final FileHelper INSTANCE = new FileHelper();

    private FileHelper() {
    }

    @JvmStatic
    public static final boolean fileExists(@NotNull String path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        return FileHelper.class.getClassLoader().getResource(path) != null;
    }

    @JvmStatic
    public static final boolean fileExists(@NotNull ResourceLocation loc) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        return FileHelper.fileExists(FileHelper.getResourceAsPath(loc));
    }

    @JvmStatic
    @NotNull
    public static final String getResourceAsPath(@NotNull ResourceLocation loc) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        return "/assets/" + loc.getNamespace() + "/" + loc.getPath();
    }
}

