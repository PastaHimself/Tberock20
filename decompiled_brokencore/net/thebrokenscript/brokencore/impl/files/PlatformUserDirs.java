/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  net.minecraft.Util
 *  net.minecraft.Util$OS
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.files;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import net.minecraft.Util;
import net.thebrokenscript.brokencore.api.files.UserDirs;
import net.thebrokenscript.brokencore.impl.files.LinuxUserDirs;
import net.thebrokenscript.brokencore.impl.files.MacUserDirs;
import net.thebrokenscript.brokencore.impl.files.WindowsUserDirs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/impl/files/PlatformUserDirs;", "", "<init>", "()V", "detect", "Lnet/thebrokenscript/brokencore/api/files/UserDirs;", "brokencore-common"})
public final class PlatformUserDirs {
    @NotNull
    public static final PlatformUserDirs INSTANCE = new PlatformUserDirs();

    private PlatformUserDirs() {
    }

    @NotNull
    public final UserDirs detect() {
        Util.OS oS = Util.getPlatform();
        return switch (oS == null ? -1 : WhenMappings.$EnumSwitchMapping$0[oS.ordinal()]) {
            case 1, 2 -> LinuxUserDirs.INSTANCE;
            case 3 -> MacUserDirs.INSTANCE;
            case 4 -> WindowsUserDirs.INSTANCE;
            case 5 -> throw new IllegalArgumentException("Unsupported OS: " + Util.getPlatform());
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Util.OS.values().length];
            try {
                nArray[Util.OS.LINUX.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Util.OS.SOLARIS.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Util.OS.OSX.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Util.OS.WINDOWS.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Util.OS.UNKNOWN.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

