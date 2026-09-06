/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.lwjgl.openal.AL11
 */
package net.thebrokenscript.brokencore.api.sound;

import kotlin.Metadata;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import org.lwjgl.openal.AL11;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u00a8\u0006\u0002"}, d2={"checkALError", "", "brokencore-common"})
public final class ALUtilKt {
    public static final void checkALError() {
        int err = AL11.alGetError();
        if (err != 0) {
            String report = "OpenAL error: " + AL11.alGetString((int)err);
            BrokenCore.LOGGER.error(report);
            throw new IllegalStateException(report);
        }
    }
}

