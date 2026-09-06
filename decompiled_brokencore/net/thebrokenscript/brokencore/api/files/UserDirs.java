/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.files;

import java.io.File;
import kotlin.Metadata;
import net.thebrokenscript.brokencore.impl.files.PlatformUserDirs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/files/UserDirs;", "", "home", "Ljava/io/File;", "desktop", "Companion", "brokencore-common"})
public interface UserDirs {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.files.UserDirs$Companion.$$INSTANCE;

    @NotNull
    public File home();

    @NotNull
    public File desktop();

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/files/UserDirs$Companion;", "Lnet/thebrokenscript/brokencore/api/files/UserDirs;", "<init>", "()V", "desktop", "Ljava/io/File;", "home", "brokencore-common"})
    public static final class Companion
    implements UserDirs {
        static final /* synthetic */ Companion $$INSTANCE;
        private final /* synthetic */ UserDirs $$delegate_0;

        private Companion() {
            this.$$delegate_0 = PlatformUserDirs.INSTANCE.detect();
        }

        @Override
        @NotNull
        public File home() {
            return this.$$delegate_0.home();
        }

        @Override
        @NotNull
        public File desktop() {
            return this.$$delegate_0.desktop();
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

