/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.files;

import java.nio.file.Paths;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/files/PathUtil;", "", "<init>", "()V", "isValid", "", "path", "", "brokencore-common"})
public final class PathUtil {
    @NotNull
    public static final PathUtil INSTANCE = new PathUtil();

    private PathUtil() {
    }

    public final boolean isValid(@Nullable String path) {
        boolean bl;
        if (path == null) {
            return false;
        }
        try {
            Paths.get(path, new String[0]);
            bl = true;
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }
}

