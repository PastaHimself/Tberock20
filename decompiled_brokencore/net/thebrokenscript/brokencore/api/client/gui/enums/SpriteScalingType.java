/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.functions.Function8
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.renderer.texture.SpriteContents
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.enums;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.SpriteContents;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.settings.NinePatchSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u00a3\u0002\b\u0002\u0012`\u0010\u0002\u001a\\\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u00b5\u0001\u0010\u000f\u001a\u00b0\u0001\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0011JF\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012Rh\u0010\u0002\u001a\\\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u00bd\u0001\u0010\u000f\u001a\u00b0\u0001\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/enums/SpriteScalingType;", "", "renderFunc", "Lkotlin/Function4;", "Lnet/minecraft/client/gui/GuiGraphics;", "Lkotlin/ParameterName;", "name", "guiGraphics", "Lnet/minecraft/resources/ResourceLocation;", "sprite", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "node2D", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings;", "ninePatchSettings", "", "nodelessRenderFunc", "Lkotlin/Function8;", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "", "x", "y", "zIndex", "w", "h", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function8;)V", "KEEP", "KEEP_ASPECT", "STRETCH", "TILE", "NINE_PATCH", "render", "scaling", "Companion", "brokencore-common"})
public final class SpriteScalingType
extends Enum<SpriteScalingType> {
    @NotNull
    private static final Companion Companion;
    @NotNull
    private final Function4<GuiGraphics, ResourceLocation, AbstractGuiNode2D, NinePatchSettings, Unit> renderFunc;
    @NotNull
    private final Function8<GuiGraphics, ResourceLocation, SpriteScalingSettings, Integer, Integer, Integer, Integer, Integer, Unit> nodelessRenderFunc;
    public static final /* enum */ SpriteScalingType KEEP;
    public static final /* enum */ SpriteScalingType KEEP_ASPECT;
    public static final /* enum */ SpriteScalingType STRETCH;
    public static final /* enum */ SpriteScalingType TILE;
    public static final /* enum */ SpriteScalingType NINE_PATCH;
    private static final /* synthetic */ SpriteScalingType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private SpriteScalingType(Function4<? super GuiGraphics, ? super ResourceLocation, ? super AbstractGuiNode2D, ? super NinePatchSettings, Unit> renderFunc, Function8<? super GuiGraphics, ? super ResourceLocation, ? super SpriteScalingSettings, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> nodelessRenderFunc) {
        this.renderFunc = renderFunc;
        this.nodelessRenderFunc = nodelessRenderFunc;
    }

    public final void render(@NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation sprite, @NotNull AbstractGuiNode2D node2D, @NotNull SpriteScalingSettings scaling) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        Intrinsics.checkNotNullParameter((Object)node2D, (String)"node2D");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"scaling");
        this.renderFunc.invoke((Object)guiGraphics, (Object)sprite, (Object)node2D, (Object)scaling.getNinePatchSettings());
    }

    public final void render(@NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation sprite, @NotNull SpriteScalingSettings scaling, int x, int y, int zIndex, int w, int h) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"scaling");
        this.nodelessRenderFunc.invoke((Object)guiGraphics, (Object)sprite, (Object)scaling, (Object)x, (Object)y, (Object)zIndex, (Object)w, (Object)h);
    }

    public static SpriteScalingType[] values() {
        return (SpriteScalingType[])$VALUES.clone();
    }

    public static SpriteScalingType valueOf(String value) {
        return Enum.valueOf(SpriteScalingType.class, value);
    }

    @NotNull
    public static EnumEntries<SpriteScalingType> getEntries() {
        return $ENTRIES;
    }

    private static final Unit _init_$lambda$0(GuiGraphics a, ResourceLocation b, AbstractGuiNode2D c, NinePatchSettings d) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        Intrinsics.checkNotNullParameter((Object)d, (String)"d");
        SpriteScalingType.Companion.keep(a, b, c, d);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(GuiGraphics a, ResourceLocation b, SpriteScalingSettings c, int d, int e, int f, int g, int h) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        SpriteScalingType.Companion.keep(a, b, c, d, e, f, g, h);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(GuiGraphics a, ResourceLocation b, AbstractGuiNode2D c, NinePatchSettings d) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        Intrinsics.checkNotNullParameter((Object)d, (String)"d");
        SpriteScalingType.Companion.keepAspect(a, b, c, d);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$3(GuiGraphics a, ResourceLocation b, SpriteScalingSettings c, int d, int e, int f, int g, int h) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        SpriteScalingType.Companion.keepAspect(a, b, c, d, e, f, g, h);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$4(GuiGraphics a, ResourceLocation b, AbstractGuiNode2D c, NinePatchSettings d) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        Intrinsics.checkNotNullParameter((Object)d, (String)"d");
        SpriteScalingType.Companion.stretch(a, b, c, d);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(GuiGraphics a, ResourceLocation b, SpriteScalingSettings c, int d, int e, int f, int g, int h) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        SpriteScalingType.Companion.stretch(a, b, c, d, e, f, g, h);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(GuiGraphics a, ResourceLocation b, AbstractGuiNode2D c, NinePatchSettings d) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        Intrinsics.checkNotNullParameter((Object)d, (String)"d");
        SpriteScalingType.Companion.tile(a, b, c, d);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(GuiGraphics a, ResourceLocation b, SpriteScalingSettings c, int d, int e, int f, int g, int h) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        SpriteScalingType.Companion.tile(a, b, c, d, e, f, g, h);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(GuiGraphics a, ResourceLocation b, AbstractGuiNode2D c, NinePatchSettings d) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        Intrinsics.checkNotNullParameter((Object)d, (String)"d");
        SpriteScalingType.Companion.ninePatch(a, b, c, d);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(GuiGraphics a, ResourceLocation b, SpriteScalingSettings c, int d, int e, int f, int g, int h) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        Intrinsics.checkNotNullParameter((Object)c, (String)"c");
        SpriteScalingType.Companion.ninePatch(a, b, c, d, e, f, g, h);
        return Unit.INSTANCE;
    }

    static {
        KEEP = new SpriteScalingType((Function4<? super GuiGraphics, ? super ResourceLocation, ? super AbstractGuiNode2D, ? super NinePatchSettings, Unit>)((Function4)SpriteScalingType::_init_$lambda$0), (Function8<? super GuiGraphics, ? super ResourceLocation, ? super SpriteScalingSettings, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit>)((Function8)SpriteScalingType::_init_$lambda$1));
        KEEP_ASPECT = new SpriteScalingType((Function4<? super GuiGraphics, ? super ResourceLocation, ? super AbstractGuiNode2D, ? super NinePatchSettings, Unit>)((Function4)SpriteScalingType::_init_$lambda$2), (Function8<? super GuiGraphics, ? super ResourceLocation, ? super SpriteScalingSettings, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit>)((Function8)SpriteScalingType::_init_$lambda$3));
        STRETCH = new SpriteScalingType((Function4<? super GuiGraphics, ? super ResourceLocation, ? super AbstractGuiNode2D, ? super NinePatchSettings, Unit>)((Function4)SpriteScalingType::_init_$lambda$4), (Function8<? super GuiGraphics, ? super ResourceLocation, ? super SpriteScalingSettings, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit>)((Function8)SpriteScalingType::_init_$lambda$5));
        TILE = new SpriteScalingType((Function4<? super GuiGraphics, ? super ResourceLocation, ? super AbstractGuiNode2D, ? super NinePatchSettings, Unit>)((Function4)SpriteScalingType::_init_$lambda$6), (Function8<? super GuiGraphics, ? super ResourceLocation, ? super SpriteScalingSettings, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit>)((Function8)SpriteScalingType::_init_$lambda$7));
        NINE_PATCH = new SpriteScalingType((Function4<? super GuiGraphics, ? super ResourceLocation, ? super AbstractGuiNode2D, ? super NinePatchSettings, Unit>)((Function4)SpriteScalingType::_init_$lambda$8), (Function8<? super GuiGraphics, ? super ResourceLocation, ? super SpriteScalingSettings, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit>)((Function8)SpriteScalingType::_init_$lambda$9));
        $VALUES = spriteScalingTypeArray = new SpriteScalingType[]{SpriteScalingType.KEEP, SpriteScalingType.KEEP_ASPECT, SpriteScalingType.STRETCH, SpriteScalingType.TILE, SpriteScalingType.NINE_PATCH};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        Companion = new Companion(null);
    }

    @ForceRuntimeInit
    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0083\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002JH\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J(\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002JH\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002JH\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002JH\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J(\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/enums/SpriteScalingType$Companion;", "", "<init>", "()V", "keep", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "sprite", "Lnet/minecraft/resources/ResourceLocation;", "scaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "x", "", "y", "zIndex", "w", "h", "node2D", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "ninePatchSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings;", "keepAspect", "stretch", "tile", "ninePatch", "brokencore-common"})
    private static final class Companion {
        private Companion() {
        }

        private final void keep(GuiGraphics guiGraphics, ResourceLocation sprite, SpriteScalingSettings scaling, int x, int y, int zIndex, int w, int h) {
            guiGraphics.blitSprite(sprite, x, y, zIndex, w, h);
        }

        private final void keep(GuiGraphics guiGraphics, ResourceLocation sprite, AbstractGuiNode2D node2D, NinePatchSettings ninePatchSettings) {
            int x = node2D.getGlobalX();
            int y = node2D.getGlobalY();
            SpriteContents contents = ClientDSLKt.getMC().getGuiSprites().getSprite(sprite).contents();
            int w = contents.width();
            int h = contents.height();
            guiGraphics.blitSprite(sprite, x, y, node2D.getZIndex(), w, h);
        }

        private final void keepAspect(GuiGraphics guiGraphics, ResourceLocation sprite, SpriteScalingSettings scaling, int x, int y, int zIndex, int w, int h) {
            float ratio;
            SpriteContents contents = ClientDSLKt.getMC().getGuiSprites().getSprite(sprite).contents();
            int spriteW = contents.width();
            int spriteH = contents.height();
            if (w == spriteW && h == spriteH) {
                guiGraphics.blitSprite(sprite, x, y, w, h);
            }
            boolean scaleVertical = h < w;
            float f = ratio = scaleVertical ? (float)spriteH / (float)spriteW : (float)spriteW / (float)spriteH;
            if (scaleVertical) {
                guiGraphics.blitSprite(sprite, x, y, zIndex, w, (int)((float)h * ratio));
            } else {
                guiGraphics.blitSprite(sprite, x, y, zIndex, (int)((float)w * ratio), h);
            }
        }

        private final void keepAspect(GuiGraphics guiGraphics, ResourceLocation sprite, AbstractGuiNode2D node2D, NinePatchSettings ninePatchSettings) {
            float ratio;
            int x = node2D.getGlobalX();
            int y = node2D.getGlobalY();
            SpriteContents contents = ClientDSLKt.getMC().getGuiSprites().getSprite(sprite).contents();
            int spriteW = contents.width();
            int spriteH = contents.height();
            int nodeW = node2D.getW();
            int nodeH = node2D.getH();
            if (nodeW == spriteW && nodeH == spriteH) {
                guiGraphics.blitSprite(sprite, x, y, nodeW, nodeH);
            }
            boolean scaleVertical = nodeH < nodeW;
            float f = ratio = scaleVertical ? (float)spriteH / (float)spriteW : (float)spriteW / (float)spriteH;
            if (scaleVertical) {
                guiGraphics.blitSprite(sprite, x, y, node2D.getZIndex(), nodeW, (int)((float)nodeH * ratio));
            } else {
                guiGraphics.blitSprite(sprite, x, y, node2D.getZIndex(), (int)((float)nodeW * ratio), nodeH);
            }
        }

        private final void stretch(GuiGraphics guiGraphics, ResourceLocation sprite, SpriteScalingSettings scaling, int x, int y, int zIndex, int w, int h) {
            guiGraphics.blitSprite(sprite, x, y, zIndex, w, h);
        }

        private final void stretch(GuiGraphics guiGraphics, ResourceLocation sprite, AbstractGuiNode2D node2D, NinePatchSettings ninePatchSettings) {
            int x = node2D.getGlobalX();
            int y = node2D.getGlobalY();
            guiGraphics.blitSprite(sprite, x, y, node2D.getZIndex(), node2D.getW(), node2D.getH());
        }

        private final void tile(GuiGraphics guiGraphics, ResourceLocation sprite, AbstractGuiNode2D node2D, NinePatchSettings ninePatchSettings) {
            int x = node2D.getGlobalX();
            int y = node2D.getGlobalY();
            SpriteContents contents = ClientDSLKt.getMC().getGuiSprites().getSprite(sprite).contents();
            int w = contents.width();
            int h = contents.height();
            ClientMixinBridge.INSTANCE.blitTiled(guiGraphics, sprite, x, y, node2D.getZIndex(), node2D.getW(), node2D.getH(), 0, 0, w, h, w, h);
        }

        private final void tile(GuiGraphics guiGraphics, ResourceLocation sprite, SpriteScalingSettings scaling, int x, int y, int zIndex, int w, int h) {
            SpriteContents contents = ClientDSLKt.getMC().getGuiSprites().getSprite(sprite).contents();
            int spriteWidth = contents.width();
            int spriteHeight = contents.height();
            ClientMixinBridge.INSTANCE.blitTiled(guiGraphics, sprite, x, y, zIndex, w, h, 0, 0, spriteWidth, spriteHeight, spriteWidth, spriteHeight);
        }

        private final void ninePatch(GuiGraphics guiGraphics, ResourceLocation sprite, SpriteScalingSettings scaling, int x, int y, int zIndex, int w, int h) {
            NinePatchSettings ninePatchPadding = scaling.getNinePatchSettings();
            ClientMixinBridge.INSTANCE.blitNineSliced(guiGraphics, sprite, x, y, zIndex, w, h, ninePatchPadding.getW(), ninePatchPadding.getH(), ninePatchPadding.getL(), ninePatchPadding.getR(), ninePatchPadding.getT(), ninePatchPadding.getB());
        }

        private final void ninePatch(GuiGraphics guiGraphics, ResourceLocation sprite, AbstractGuiNode2D node2D, NinePatchSettings ninePatchSettings) {
            int x = node2D.getGlobalX();
            int y = node2D.getGlobalY();
            ClientMixinBridge.INSTANCE.blitNineSliced(guiGraphics, sprite, x, y, node2D.getZIndex(), node2D.getW(), node2D.getH(), ninePatchSettings.getW(), ninePatchSettings.getH(), ninePatchSettings.getL(), ninePatchSettings.getR(), ninePatchSettings.getT(), ninePatchSettings.getB());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

