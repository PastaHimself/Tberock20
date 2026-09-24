/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.label;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractLabel;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelSettings;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/label/Label;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractLabel;", "text", "", "settings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "<init>", "(Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;)V", "brokencore-common"})
public final class Label
extends AbstractLabel {
    public Label(@NotNull String text, @NotNull LabelSettings settings) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(text, settings);
    }

    public /* synthetic */ Label(String string, LabelSettings labelSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = "";
        }
        this(string, labelSettings);
    }
}

