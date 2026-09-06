/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 *  org.joml.Vector3f
 *  org.joml.Vector3i
 */
package net.thebrokenscript.brokencore.api.client.gui.field;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.container.HBoxContainer;
import net.thebrokenscript.brokencore.api.client.gui.field.DecimalField;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector3i;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR_\u0010\u0014\u001aG\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R$\u0010,\u001a\u00020+2\u0006\u0010!\u001a\u00020+8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\u0002012\u0006\u0010!\u001a\u0002018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0002072\u0006\u0010!\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006="}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/field/Vector3Field;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "bgTexture", "Lnet/minecraft/resources/ResourceLocation;", "bgScaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;)V", "box", "Lnet/thebrokenscript/brokencore/api/client/gui/container/HBoxContainer;", "getBox", "()Lnet/thebrokenscript/brokencore/api/client/gui/container/HBoxContainer;", "xField", "Lnet/thebrokenscript/brokencore/api/client/gui/field/DecimalField;", "getXField", "()Lnet/thebrokenscript/brokencore/api/client/gui/field/DecimalField;", "yField", "getYField", "zField", "getZField", "changeCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "x", "y", "z", "", "getChangeCallback", "()Lkotlin/jvm/functions/Function3;", "setChangeCallback", "(Lkotlin/jvm/functions/Function3;)V", "v", "", "w", "getW", "()I", "setW", "(I)V", "h", "getH", "setH", "Lorg/joml/Vector3f;", "floatValue", "getFloatValue", "()Lorg/joml/Vector3f;", "setFloatValue", "(Lorg/joml/Vector3f;)V", "Lorg/joml/Vector3d;", "doubleValue", "getDoubleValue", "()Lorg/joml/Vector3d;", "setDoubleValue", "(Lorg/joml/Vector3d;)V", "Lorg/joml/Vector3i;", "intValue", "getIntValue", "()Lorg/joml/Vector3i;", "setIntValue", "(Lorg/joml/Vector3i;)V", "brokencore-common"})
public final class Vector3Field
extends AbstractGuiNode2D {
    @NotNull
    private final HBoxContainer box;
    @NotNull
    private final DecimalField xField;
    @NotNull
    private final DecimalField yField;
    @NotNull
    private final DecimalField zField;
    @NotNull
    private Function3<? super String, ? super String, ? super String, Unit> changeCallback;

    public Vector3Field(@NotNull ResourceLocation bgTexture, @NotNull SpriteScalingSettings bgScaling) {
        Intrinsics.checkNotNullParameter((Object)bgTexture, (String)"bgTexture");
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        super(0, 0, 0, 0, 15, null);
        this.box = (HBoxContainer)this.addChild((GuiElement)new HBoxContainer(2, false, 2, null));
        this.xField = (DecimalField)this.box.addChild((GuiElement)new DecimalField(bgTexture, bgScaling, "X"));
        this.yField = (DecimalField)this.box.addChild((GuiElement)new DecimalField(bgTexture, bgScaling, "Y"));
        this.zField = (DecimalField)this.box.addChild((GuiElement)new DecimalField(bgTexture, bgScaling, "Z"));
        this.xField.setChangeCallback((Function1<? super String, Unit>)((Function1)arg_0 -> Vector3Field._init_$lambda$0(this, arg_0)));
        this.yField.setChangeCallback((Function1<? super String, Unit>)((Function1)arg_0 -> Vector3Field._init_$lambda$1(this, arg_0)));
        this.zField.setChangeCallback((Function1<? super String, Unit>)((Function1)arg_0 -> Vector3Field._init_$lambda$2(this, arg_0)));
        this.changeCallback = Vector3Field::changeCallback$lambda$0;
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
    public final DecimalField getZField() {
        return this.zField;
    }

    @NotNull
    public final Function3<String, String, String, Unit> getChangeCallback() {
        return this.changeCallback;
    }

    public final void setChangeCallback(@NotNull Function3<? super String, ? super String, ? super String, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, (String)"<set-?>");
        this.changeCallback = function3;
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
    public final Vector3f getFloatValue() {
        return new Vector3f(this.xField.getFloatValue(), this.yField.getFloatValue(), this.zField.getFloatValue());
    }

    public final void setFloatValue(@NotNull Vector3f v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.xField.setFloatValue(v.x);
        this.yField.setFloatValue(v.y);
        this.zField.setFloatValue(v.z);
    }

    @NotNull
    public final Vector3d getDoubleValue() {
        return new Vector3d(this.xField.getDoubleValue(), this.yField.getDoubleValue(), this.zField.getDoubleValue());
    }

    public final void setDoubleValue(@NotNull Vector3d v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.xField.setDoubleValue(v.x);
        this.yField.setDoubleValue(v.y);
        this.zField.setDoubleValue(v.z);
    }

    @NotNull
    public final Vector3i getIntValue() {
        return new Vector3i(this.xField.getIntValue(), this.yField.getIntValue(), this.zField.getIntValue());
    }

    public final void setIntValue(@NotNull Vector3i v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.xField.setIntValue(v.x);
        this.yField.setIntValue(v.y);
        this.zField.setIntValue(v.z);
    }

    private static final Unit _init_$lambda$0(Vector3Field this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.changeCallback.invoke((Object)it, (Object)this$0.yField.getText(), (Object)this$0.zField.getText());
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(Vector3Field this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.changeCallback.invoke((Object)this$0.xField.getText(), (Object)it, (Object)this$0.zField.getText());
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(Vector3Field this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.changeCallback.invoke((Object)this$0.xField.getText(), (Object)this$0.yField.getText(), (Object)it);
        return Unit.INSTANCE;
    }

    private static final Unit changeCallback$lambda$0(String string, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"<unused var>");
        return Unit.INSTANCE;
    }
}

