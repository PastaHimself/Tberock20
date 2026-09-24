/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.field;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractTextField;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017H\u0016R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u001d8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006("}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/field/DecimalField;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractTextField;", "bgTexture", "Lnet/minecraft/resources/ResourceLocation;", "bgScaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "previewText", "", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Ljava/lang/String;)V", "v", "", "floatValue", "getFloatValue", "()F", "setFloatValue", "(F)V", "", "doubleValue", "getDoubleValue", "()D", "setDoubleValue", "(D)V", "", "intValue", "getIntValue", "()I", "setIntValue", "(I)V", "", "longValue", "getLongValue", "()J", "setLongValue", "(J)V", "isCharacterValid", "", "char", "", "cursorPos", "brokencore-common"})
public final class DecimalField
extends AbstractTextField {
    public DecimalField(@NotNull ResourceLocation bgTexture, @NotNull SpriteScalingSettings bgScaling, @NotNull String previewText) {
        Intrinsics.checkNotNullParameter((Object)bgTexture, (String)"bgTexture");
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        Intrinsics.checkNotNullParameter((Object)previewText, (String)"previewText");
        super(bgTexture, bgScaling, previewText);
        this.setTooltip("Decimal Value");
    }

    public /* synthetic */ DecimalField(ResourceLocation resourceLocation, SpriteScalingSettings spriteScalingSettings, String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            string = "";
        }
        this(resourceLocation, spriteScalingSettings, string);
    }

    public final float getFloatValue() {
        Float f = StringsKt.toFloatOrNull((String)this.getText());
        return f != null ? f.floatValue() : 0.0f;
    }

    public final void setFloatValue(float v) {
        this.setText(String.valueOf(v));
    }

    public final double getDoubleValue() {
        Double d = StringsKt.toDoubleOrNull((String)this.getText());
        return d != null ? d : 0.0;
    }

    public final void setDoubleValue(double v) {
        this.setText(String.valueOf(v));
    }

    public final int getIntValue() {
        Integer n = StringsKt.toIntOrNull((String)this.getText());
        return n != null ? n : 0;
    }

    public final void setIntValue(int v) {
        this.setText(String.valueOf(v));
    }

    public final long getLongValue() {
        Long l = StringsKt.toLongOrNull((String)this.getText());
        return l != null ? l : 0L;
    }

    public final void setLongValue(long v) {
        this.setText(String.valueOf(v));
    }

    @Override
    public boolean isCharacterValid(char c, int cursorPos) {
        CharSequence charSequence;
        if (Intrinsics.compare((int)c, (int)47) > 0 && Intrinsics.compare((int)c, (int)58) < 0) {
            return true;
        }
        if (c == '-' && !StringsKt.contains$default((CharSequence)this.getText(), (char)'-', (boolean)false, (int)2, null) && cursorPos == 0) {
            return true;
        }
        return c == '.' && !StringsKt.contains$default((CharSequence)this.getText(), (char)'.', (boolean)false, (int)2, null) && new Regex("[0-9]").containsMatchIn(charSequence = (CharSequence)this.getText());
    }
}

