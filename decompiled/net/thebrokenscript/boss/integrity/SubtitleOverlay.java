/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/boss/integrity/SubtitleOverlay;", "", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "start", "", "render", "gg", "Lnet/minecraft/client/gui/GuiGraphics;", "thebrokenscript-common"})
public final class SubtitleOverlay {
    @NotNull
    public static final SubtitleOverlay INSTANCE = new SubtitleOverlay();
    private static boolean show = true;
    @Nullable
    private static String text;

    private SubtitleOverlay() {
    }

    public final boolean getShow() {
        return show;
    }

    public final void setShow(boolean bl) {
        show = bl;
    }

    @Nullable
    public final String getText() {
        return text;
    }

    public final void setText(@Nullable String string) {
        text = string;
    }

    public final void start() {
    }

    public final void render(@NotNull GuiGraphics gg) {
        Intrinsics.checkNotNullParameter((Object)gg, (String)"gg");
        if (text != null) {
            // empty if block
        }
    }
}

