/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.impl.files;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.thebrokenscript.brokencore.api.files.PathUtil;
import net.thebrokenscript.brokencore.api.files.UserDirs;
import net.thebrokenscript.brokencore.api.util.system.Environ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/impl/files/LinuxUserDirs;", "Lnet/thebrokenscript/brokencore/api/files/UserDirs;", "<init>", "()V", "xdgDir", "Ljava/io/File;", "name", "", "home", "desktop", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nLinuxUserDirs.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LinuxUserDirs.kt\nnet/thebrokenscript/brokencore/impl/files/LinuxUserDirs\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1#2:24\n*E\n"})
public final class LinuxUserDirs
implements UserDirs {
    @NotNull
    public static final LinuxUserDirs INSTANCE = new LinuxUserDirs();

    private LinuxUserDirs() {
    }

    @Nullable
    public final File xdgDir(@NotNull String name) {
        File file;
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        String[] stringArray = new String[]{"xdg-user-dir", name};
        Process proc = new ProcessBuilder(stringArray).redirectOutput(ProcessBuilder.Redirect.PIPE).redirectError(ProcessBuilder.Redirect.PIPE).start();
        if (proc.waitFor() != 0) {
            return null;
        }
        byte[] byArray = proc.getInputStream().readAllBytes();
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readAllBytes(...)");
        byte[] byArray2 = byArray;
        Charset charset = Charsets.UTF_8;
        String content = ((Object)StringsKt.trim((CharSequence)new String(byArray2, charset))).toString();
        if (PathUtil.INSTANCE.isValid(content)) {
            file = new File(content);
        } else {
            String string = Environ.INSTANCE.get("XDG_DESKTOP_DIR");
            if (string != null) {
                String p0 = string;
                boolean bl = false;
                file = new File(p0);
            } else {
                file = null;
            }
        }
        return file;
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
        File file = this.xdgDir("DESKTOP");
        if (file == null) {
            file = FilesKt.resolve((File)this.home(), (String)"Desktop");
        }
        return file;
    }
}

