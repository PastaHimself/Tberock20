/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.Renderable
 *  net.minecraft.client.gui.navigation.ScreenPosition
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  net.minecraft.world.phys.AABB
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2i
 *  org.joml.Vector3d
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.navigation.ScreenPosition;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.util.HierarchyScreen;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.BoundingBoxExtKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;
import org.joml.Vector3d;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0018\u001a\u00020\bH\u0007\u00a2\u0006\u0002\b@J\r\u0010\u001c\u001a\u00020\bH\u0007\u00a2\u0006\u0002\bAJ\r\u0010\u001f\u001a\u00020\bH\u0007\u00a2\u0006\u0002\bBJ\u0006\u0010C\u001a\u00020\bJ\u0006\u0010D\u001a\u00020\bJ\u0006\u0010E\u001a\u00020\bJ\u0015\u0010\u0019\u001a\u00020F2\u0006\u0010\u0016\u001a\u00020\bH\u0007\u00a2\u0006\u0002\bGJ\u0015\u0010\u001d\u001a\u00020F2\u0006\u0010\u0016\u001a\u00020\bH\u0007\u00a2\u0006\u0002\bHJ\u0015\u0010 \u001a\u00020F2\u0006\u0010\u0016\u001a\u00020\bH\u0007\u00a2\u0006\u0002\bIJ\u000e\u0010J\u001a\u00020F2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010K\u001a\u00020F2\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010L\u001a\u00020F2\u0006\u0010\u0016\u001a\u00020\bJ&\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020TJ@\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u00106\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bH\u0016J\u0018\u0010U\u001a\u00020V2\u0006\u0010P\u001a\u00020W2\u0006\u0010R\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020]H\u0016J\n\u0010^\u001a\u00020**\u00020*J\u0019\u00106\u001a\u00020\b\"\b\b\u0000\u0010_*\u00020W*\u0002H_\u00a2\u0006\u0002\u0010`J\u0019\u00108\u001a\u00020\b\"\b\b\u0000\u0010_*\u00020W*\u0002H_\u00a2\u0006\u0002\u0010`J\u0019\u0010:\u001a\u00020\b\"\b\b\u0000\u0010_*\u00020W*\u0002H_\u00a2\u0006\u0002\u0010`J\n\u0010a\u001a\u00020**\u00020*J\u0019\u0010b\u001a\u00020\b\"\b\b\u0000\u0010_*\u00020W*\u0002H_\u00a2\u0006\u0002\u0010`J\u0019\u0010c\u001a\u00020\b\"\b\b\u0000\u0010_*\u00020W*\u0002H_\u00a2\u0006\u0002\u0010`J\u0019\u0010d\u001a\u00020\b\"\b\b\u0000\u0010_*\u00020W*\u0002H_\u00a2\u0006\u0002\u0010`R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0084\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\u001aR$\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\u001aR$\u0010!\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\u001aR$\u0010$\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\u001aR$\u0010'\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010\u001aR$\u0010+\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020*8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0002002\u0006\u0010\u0016\u001a\u0002008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000bR\u001e\u00108\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\u000bR\u001e\u0010:\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000bR\u0011\u0010<\u001a\u00020=\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010?\u00a8\u0006e"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode3D;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode;", "Lnet/minecraft/client/gui/components/Renderable;", "screen", "Lnet/thebrokenscript/brokencore/api/client/gui/util/HierarchyScreen;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/util/HierarchyScreen;)V", "value", "", "internalX", "getInternalX", "()D", "internalY", "getInternalY", "internalZ", "getInternalZ", "internalW", "getInternalW", "internalH", "getInternalH", "internalL", "getInternalL", "v", "x", "getX", "setX", "(D)V", "y", "getY", "setY", "z", "getZ", "setZ", "w", "getW", "setW", "h", "getH", "setH", "l", "getL", "setL", "Lorg/joml/Vector3d;", "position", "getPosition", "()Lorg/joml/Vector3d;", "setPosition", "(Lorg/joml/Vector3d;)V", "Lorg/joml/Vector3f;", "positionF", "getPositionF", "()Lorg/joml/Vector3f;", "setPositionF", "(Lorg/joml/Vector3f;)V", "globalX", "getGlobalX", "globalY", "getGlobalY", "globalZ", "getGlobalZ", "aabb", "Lnet/minecraft/world/phys/AABB;", "getAabb", "()Lnet/minecraft/world/phys/AABB;", "funGetX", "funGetY", "funGetZ", "getWidth", "getHeight", "getLength", "", "funSetX", "funSetY", "funSetZ", "setWidth", "setHeight", "setLength", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTick", "", "isMouseOver", "", "", "getScreenRect", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "getScreenPos", "Lnet/minecraft/client/gui/navigation/ScreenPosition;", "getScreenSize", "Lorg/joml/Vector2i;", "globalize", "T", "(Ljava/lang/Number;)D", "localize", "localX", "localY", "localZ", "brokencore-common"})
public abstract class AbstractGuiNode3D
extends AbstractGuiNode
implements Renderable {
    @NotNull
    private final HierarchyScreen screen;
    private double internalX;
    private double internalY;
    private double internalZ;
    private double internalW;
    private double internalH;
    private double internalL;
    private double globalX;
    private double globalY;
    private double globalZ;
    @NotNull
    private final AABB aabb;

    public AbstractGuiNode3D(@NotNull HierarchyScreen screen) {
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        this.screen = screen;
        this.internalW = 1.0;
        this.internalH = 1.0;
        this.internalL = 1.0;
        this.globalX = this.getX();
        this.globalY = this.getY();
        this.globalZ = this.getZ();
        this.aabb = new AABB(this.getX(), this.getY(), this.getZ(), this.getX() + this.getW(), this.getY() + this.getH(), this.getZ() + this.getL());
    }

    protected final double getInternalX() {
        return this.internalX;
    }

    protected final double getInternalY() {
        return this.internalY;
    }

    protected final double getInternalZ() {
        return this.internalZ;
    }

    protected final double getInternalW() {
        return this.internalW;
    }

    protected final double getInternalH() {
        return this.internalH;
    }

    protected final double getInternalL() {
        return this.internalL;
    }

    public double getX() {
        return this.funGetX();
    }

    public void setX(double v) {
        this.funSetX(v);
    }

    public double getY() {
        return this.funGetY();
    }

    public void setY(double v) {
        this.funSetY(v);
    }

    public double getZ() {
        return this.funGetZ();
    }

    public void setZ(double v) {
        this.funSetZ(v);
    }

    public double getW() {
        return this.getWidth();
    }

    public void setW(double v) {
        this.setWidth(v);
    }

    public double getH() {
        return this.getHeight();
    }

    public void setH(double v) {
        this.setHeight(v);
    }

    public double getL() {
        return this.getLength();
    }

    public void setL(double v) {
        this.setLength(v);
    }

    @NotNull
    public final Vector3d getPosition() {
        return new Vector3d(this.getX(), this.getY(), this.getZ());
    }

    public final void setPosition(@NotNull Vector3d v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.setX(v.x);
        this.setY(v.y);
        this.setZ(v.z);
    }

    @NotNull
    public final Vector3f getPositionF() {
        return new Vector3f((float)this.getX(), (float)this.getY(), (float)this.getZ());
    }

    public final void setPositionF(@NotNull Vector3f v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.setX(v.x);
        this.setY(v.y);
        this.setZ(v.z);
    }

    public final double getGlobalX() {
        return this.globalX;
    }

    public final double getGlobalY() {
        return this.globalY;
    }

    public final double getGlobalZ() {
        return this.globalZ;
    }

    @NotNull
    public final AABB getAabb() {
        return this.aabb;
    }

    @JvmName(name="funGetX")
    public final double funGetX() {
        return this.internalX;
    }

    @JvmName(name="funGetY")
    public final double funGetY() {
        return this.internalY;
    }

    @JvmName(name="funGetZ")
    public final double funGetZ() {
        return this.internalZ;
    }

    public final double getWidth() {
        return this.internalW;
    }

    public final double getHeight() {
        return this.internalH;
    }

    public final double getLength() {
        return this.internalL;
    }

    @JvmName(name="funSetX")
    public final void funSetX(double v) {
        this.internalX = v;
    }

    @JvmName(name="funSetY")
    public final void funSetY(double v) {
        this.internalY = v;
    }

    @JvmName(name="funSetZ")
    public final void funSetZ(double v) {
        this.internalZ = v;
    }

    public final void setWidth(double v) {
        this.internalW = v;
    }

    public final void setHeight(double v) {
        this.internalH = v;
    }

    public final void setLength(double v) {
        this.internalL = v;
    }

    public final void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        guiGraphics.pose().pushPose();
        this.render(guiGraphics, mouseX, mouseY, partialTick, this.globalX, this.globalY, this.globalZ);
        guiGraphics.pose().popPose();
        this.forEachChild((Function1<? super GuiElement, Unit>)((Function1)arg_0 -> AbstractGuiNode3D.render$lambda$0(guiGraphics, mouseX, mouseY, partialTick, this, arg_0)));
    }

    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, double globalX, double globalY, double globalZ) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
    }

    public boolean isMouseOver(@NotNull Number mouseX, @NotNull Number mouseY) {
        Intrinsics.checkNotNullParameter((Object)mouseX, (String)"mouseX");
        Intrinsics.checkNotNullParameter((Object)mouseY, (String)"mouseY");
        return this.getScreenRect().containsPoint(mouseX.intValue(), mouseY.intValue());
    }

    @NotNull
    public ScreenRectangle getScreenRect() {
        return BoundingBoxExtKt.toScreenRect(this.aabb, this.screen.getModelMat(), this.screen.getProjMat(), this.screen.getCameraQuaternion(), ClientDSLKt.getMC().getWindow().getGuiScaledWidth(), ClientDSLKt.getMC().getWindow().getGuiScaledHeight());
    }

    @NotNull
    public ScreenPosition getScreenPos() {
        ScreenPosition screenPosition = this.getScreenRect().position();
        Intrinsics.checkNotNullExpressionValue((Object)screenPosition, (String)"position(...)");
        return screenPosition;
    }

    @NotNull
    public Vector2i getScreenSize() {
        ScreenPosition rect = this.getScreenRect().position();
        return new Vector2i(rect.x(), rect.y());
    }

    @NotNull
    public final Vector3d globalize(@NotNull Vector3d $this$globalize) {
        Intrinsics.checkNotNullParameter((Object)$this$globalize, (String)"<this>");
        return new Vector3d($this$globalize.x + this.globalX, $this$globalize.y + this.globalY, $this$globalize.z + this.globalZ);
    }

    public final <T extends Number> double globalX(@NotNull T $this$globalX) {
        Intrinsics.checkNotNullParameter($this$globalX, (String)"<this>");
        return $this$globalX.doubleValue() + this.globalX;
    }

    public final <T extends Number> double globalY(@NotNull T $this$globalY) {
        Intrinsics.checkNotNullParameter($this$globalY, (String)"<this>");
        return $this$globalY.doubleValue() + this.globalY;
    }

    public final <T extends Number> double globalZ(@NotNull T $this$globalZ) {
        Intrinsics.checkNotNullParameter($this$globalZ, (String)"<this>");
        return $this$globalZ.doubleValue() + this.globalZ;
    }

    @NotNull
    public final Vector3d localize(@NotNull Vector3d $this$localize) {
        Intrinsics.checkNotNullParameter((Object)$this$localize, (String)"<this>");
        return new Vector3d($this$localize.x - this.globalX, $this$localize.y - this.globalY, $this$localize.z - this.globalZ);
    }

    public final <T extends Number> double localX(@NotNull T $this$localX) {
        Intrinsics.checkNotNullParameter($this$localX, (String)"<this>");
        return $this$localX.doubleValue() - this.globalX;
    }

    public final <T extends Number> double localY(@NotNull T $this$localY) {
        Intrinsics.checkNotNullParameter($this$localY, (String)"<this>");
        return $this$localY.doubleValue() - this.globalY;
    }

    public final <T extends Number> double localZ(@NotNull T $this$localZ) {
        Intrinsics.checkNotNullParameter($this$localZ, (String)"<this>");
        return $this$localZ.doubleValue() - this.globalZ;
    }

    private static final Unit render$lambda$0(GuiGraphics $guiGraphics, int $mouseX, int $mouseY, float $partialTick, AbstractGuiNode3D this$0, GuiElement it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $guiGraphics.pose().pushPose();
        if (it instanceof Renderable) {
            ((Renderable)it).render($guiGraphics, $mouseX, $mouseY, $partialTick);
        }
        if (it instanceof AbstractGuiNode3D) {
            ((AbstractGuiNode3D)it).globalX = ((AbstractGuiNode3D)it).getX() + this$0.globalX;
            ((AbstractGuiNode3D)it).globalY = ((AbstractGuiNode3D)it).getY() + this$0.globalY;
            ((AbstractGuiNode3D)it).globalZ = ((AbstractGuiNode3D)it).getZ() + this$0.globalZ;
        }
        $guiGraphics.pose().popPose();
        return Unit.INSTANCE;
    }
}

