/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.files;

import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.files.UserDirs;
import net.thebrokenscript.brokencore.api.util.system.Environ;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/impl/files/MacUserDirs;", "Lnet/thebrokenscript/brokencore/api/files/UserDirs;", "<init>", "()V", "home", "Ljava/io/File;", "desktop", "brokencore-common"})
public final class MacUserDirs
implements UserDirs {
    @NotNull
    public static final MacUserDirs INSTANCE = new MacUserDirs();

    private MacUserDirs() {
    }

    @Override
    @NotNull
    public File home() {
        String string = Environ.INSTANCE.get("HOME");
        Intrinsics.checkNotNull((Object)string);
        return new File(string);
    }

    @Override
    @NotNull
    public File desktop() {
        return FilesKt.resolve((File)this.home(), (String)"Desktop");
    }
}

