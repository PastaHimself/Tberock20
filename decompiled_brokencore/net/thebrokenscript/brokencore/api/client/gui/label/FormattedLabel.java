/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.label;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractLabel;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelSettings;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\t\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00126\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR>\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038V@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/label/FormattedLabel;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractLabel;", "text", "", "settings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "formatter", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "char", "<init>", "(Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;Lkotlin/jvm/functions/Function2;)V", "v", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nFormattedLabel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FormattedLabel.kt\nnet/thebrokenscript/brokencore/api/client/gui/label/FormattedLabel\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,18:1\n1188#2,3:19\n*S KotlinDebug\n*F\n+ 1 FormattedLabel.kt\nnet/thebrokenscript/brokencore/api/client/gui/label/FormattedLabel\n*L\n12#1:19,3\n*E\n"})
public final class FormattedLabel
extends AbstractLabel {
    @NotNull
    private final Function2<Integer, Character, String> formatter;
    @NotNull
    private String text;

    public FormattedLabel(@NotNull String text, @NotNull LabelSettings settings, @NotNull Function2<? super Integer, ? super Character, String> formatter) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        Intrinsics.checkNotNullParameter(formatter, (String)"formatter");
        super(text, settings);
        this.formatter = formatter;
        this.text = text;
    }

    public /* synthetic */ FormattedLabel(String string, LabelSettings labelSettings, Function2 function2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = "";
        }
        this(string, labelSettings, (Function2<? super Integer, ? super Character, String>)function2);
    }

    @Override
    @NotNull
    public String getText() {
        return super.getText();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void setText(@NotNull String v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        Object str = null;
        str = "";
        CharSequence $this$forEachIndexed$iv = v;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (int i = 0; i < $this$forEachIndexed$iv.length(); ++i) {
            void ch;
            char item$iv = $this$forEachIndexed$iv.charAt(i);
            int n = index$iv++;
            char c = item$iv;
            int index = n;
            boolean bl = false;
            str = "" + str + this.formatter.invoke((Object)index, (Object)Character.valueOf((char)ch));
        }
        this.text = str;
        this.updateTextWidth();
    }
}

