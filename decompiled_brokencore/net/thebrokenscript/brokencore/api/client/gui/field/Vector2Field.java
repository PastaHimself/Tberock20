/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2d
 *  org.joml.Vector2f
 *  org.joml.Vector2i
 */
package net.thebrokenscript.brokencore.api.client.gui.field;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.container.HBoxContainer;
import net.thebrokenscript.brokencore.api.client.gui.field.DecimalField;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2d;
import org.joml.Vector2f;
import org.joml.Vector2i;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fRJ\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R$\u0010)\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020(8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0002042\u0006\u0010\u001e\u001a\u0002048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/field/Vector2Field;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "bgTexture", "Lnet/minecraft/resources/ResourceLocation;", "bgScaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;)V", "box", "Lnet/thebrokenscript/brokencore/api/client/gui/container/HBoxContainer;", "getBox", "()Lnet/thebrokenscript/brokencore/api/client/gui/container/HBoxContainer;", "xField", "Lnet/thebrokenscript/brokencore/api/client/gui/field/DecimalField;", "getXField", "()Lnet/thebrokenscript/brokencore/api/client/gui/field/DecimalField;", "yField", "getYField", "changeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "getChangeCallback", "()Lkotlin/jvm/functions/Function2;", "setChangeCallback", "(Lkotlin/jvm/functions/Function2;)V", "v", "", "w", "getW", "()I", "setW", "(I)V", "h", "getH", "setH", "Lorg/joml/Vector2f;", "floatValue", "getFloatValue", "()Lorg/joml/Vector2f;", "setFloatValue", "(Lorg/joml/Vector2f;)V", "Lorg/joml/Vector2d;", "doubleValue", "getDoubleValue", "()Lorg/joml/Vector2d;", "setDoubleValue", "(Lorg/joml/Vector2d;)V", "Lorg/joml/Vector2i;", "intValue", "getIntValue", "()Lorg/joml/Vector2i;", "setIntValue", "(Lorg/joml/Vector2i;)V", "brokencore-common"})
public final class Vector2Field
extends AbstractGuiNode2D {
    @NotNull
    private final HBoxContainer box;
    @NotNull
    private final DecimalField xField;
    @NotNull
    private final DecimalField yField;
    @NotNull
    private Function2<? super String, ? super String, Unit> changeCallback;

    public Vector2Field(@NotNull ResourceLocation bgTexture, @NotNull SpriteScalingSettings bgScaling) {
        Intrinsics.checkNotNullParameter((Object)bgTexture, (String)"bgTexture");
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        super(0, 0, 0, 0, 15, null);
        this.box = (HBoxContainer)this.addChild((GuiElement)new HBoxContainer(2, false, 2, null));
        this.xField = (DecimalField)this.box.addChild((GuiElement)new DecimalField(bgTexture, bgScaling, "X"));
        this.yField = (DecimalField)this.box.addChild((GuiElement)new DecimalField(bgTexture, bgScaling, "Y"));
        this.xField.setChangeCallback((Function1<? super String, Unit>)((Function1)arg_0 -> Vector2Field._init_$lambda$0(this, arg_0)));
        this.yField.setChangeCallback((Function1<? super String, Unit>)((Function1)arg_0 -> Vector2Field._init_$lambda$1(this, arg_0)));
        this.changeCallback = Vector2Field::changeCallback$lambda$0;
    }

    @NotNull
    public final HBoxContainer getBox() {
        return this.box;
    }

    @NotNull
    public final DecimalField getXField() {
        return this.xField;
    }

    @NotNull
    public final DecimalField getYField() {
        return this.yField;
    }

    @NotNull
    public final Function2<String, String, Unit> getChangeCallback() {
        return this.changeCallback;
    }

    public final void setChangeCallback(@NotNull Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"<set-?>");
        this.changeCallback = function2;
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int v) {
        this.box.setW(v);
        super.setW(v);
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int v) {
        this.box.setH(v);
        super.setH(v);
    }

    @NotNull
    public final Vector2f getFloatValue() {
        return new Vector2f(this.xField.getFloatValue(), this.yField.getFloatValue());
    }

    public final void setFloatValue(@NotNull Vector2f v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.xField.setFloatValue(v.x);
        this.yField.setFloatValue(v.y);
    }

    @NotNull
    public final Vector2d getDoubleValue() {
        return new Vector2d(this.xField.getDoubleValue(), this.yField.getDoubleValue());
    }

    public final void setDoubleValue(@NotNull Vector2d v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.xField.setDoubleValue(v.x);
        this.yField.setDoubleValue(v.y);
    }

    @NotNull
    public final Vector2i getIntValue() {
        return new Vector2i(this.xField.getIntValue(), this.yField.getIntValue());
    }

    public final void setIntValue(@NotNull Vector2i v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.xField.setIntValue(v.x);
        this.yField.setIntValue(v.y);
    }

    private static final Unit _init_$lambda$0(Vector2Field this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.changeCallback.invoke((Object)it, (Object)this$0.yField.getText());
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(Vector2Field this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.changeCallback.invoke((Object)this$0.xField.getText(), (Object)it);
        return Unit.INSTANCE;
    }

    private static final Unit changeCallback$lambda$0(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"<unused var>");
        return Unit.INSTANCE;
    }
}

