/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.CrashReport
 *  net.minecraft.client.Minecraft
 *  net.thebrokenscript.brokencore.api.util.system.FileHelper
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.misc;

import java.io.File;
import kotlin.Metadata;
import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;
import net.thebrokenscript.brokencore.api.util.system.FileHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/api/misc/FunnyChecker;", "", "<init>", "()V", "TITLE", "", "FILE", "check", "", "thebrokenscript-common"})
public final class FunnyChecker {
    @NotNull
    public static final FunnyChecker INSTANCE = new FunnyChecker();
    @NotNull
    private static final String TITLE = "They're so joyous...";
    @NotNull
    private static final String FILE = "/assets/thebrokenscript/textures/entities/circuit_dance.gif";

    private FunnyChecker() {
    }

    public final void check() {
        if (!FileHelper.fileExists((String)FILE)) {
            Exception ex = new Exception("Get it, circy! Crash their game!");
            CrashReport report = Minecraft.getInstance().fillReport(new CrashReport(TITLE, (Throwable)ex));
            Minecraft.crash((Minecraft)Minecraft.getInstance(), (File)Minecraft.getInstance().gameDirectory, (CrashReport)report);
        }
    }
}

