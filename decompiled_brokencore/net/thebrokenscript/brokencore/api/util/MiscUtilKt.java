/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2d
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2d;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"cursorPos", "Lorg/joml/Vector2d;", "getCursorPos", "()Lorg/joml/Vector2d;", "brokencore-common"})
public final class MiscUtilKt {
    @NotNull
    public static final Vector2d getCursorPos() {
        return new Vector2d(ClientDSLKt.getMC().mouseHandler.xpos(), ClientDSLKt.getMC().mouseHandler.ypos());
    }
}

