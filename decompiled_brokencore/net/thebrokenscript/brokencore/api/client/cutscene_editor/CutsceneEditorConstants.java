/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.ClosedRange
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene_editor;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.container.ScrollContainer;
import net.thebrokenscript.brokencore.api.client.gui.field.DecimalField;
import net.thebrokenscript.brokencore.api.client.gui.field.IntField;
import net.thebrokenscript.brokencore.api.client.gui.field.TextField;
import net.thebrokenscript.brokencore.api.client.gui.field.Vector3Field;
import net.thebrokenscript.brokencore.api.client.gui.misc.DropdownList;
import net.thebrokenscript.brokencore.api.client.gui.misc.GuiSprite;
import net.thebrokenscript.brokencore.api.client.gui.range.CurveEditor;
import net.thebrokenscript.brokencore.api.client.gui.range.VSlider;
import net.thebrokenscript.brokencore.api.client.gui.settings.DropdownListSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelButtonSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.NinePatchSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.ScrollContainerSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SliderSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteButtonSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.TextPanelButtonSettings;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010:\u001a\u00020;Jo\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u000e\b\u0000\u0010>*\b\u0012\u0004\u0012\u0002H>0?2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002H>0A2\u0006\u0010B\u001a\u0002H>26\u0010C\u001a2\u0012\u0013\u0012\u0011H>\u00a2\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110H\u00a2\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020J0D\u00a2\u0006\u0002\u0010KJo\u0010L\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u000e\b\u0000\u0010>*\b\u0012\u0004\u0012\u0002H>0?2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002H>0A2\u0006\u0010B\u001a\u0002H>26\u0010C\u001a2\u0012\u0013\u0012\u0011H>\u00a2\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110H\u00a2\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020J0D\u00a2\u0006\u0002\u0010KJ\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u00020RJ\u0006\u0010S\u001a\u00020TJ\u0006\u0010U\u001a\u00020VJ\u0006\u0010W\u001a\u00020XJ)\u0010Y\u001a\u00020Z2!\u0010C\u001a\u001d\u0012\u0013\u0012\u00110\\\u00a2\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020J0[R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0011\u0010\u001e\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0011\u0010 \u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0011\u0010\"\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0011\u0010$\u001a\u00020%\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020%\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010*\u001a\u00020+\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020/\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u000203\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u000207\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109\u00a8\u0006^"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/CutsceneEditorConstants;", "", "<init>", "()V", "COMMON_NINE_PATCH_SCALING", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "getCOMMON_NINE_PATCH_SCALING", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "BUTTON", "Lnet/minecraft/resources/ResourceLocation;", "getBUTTON", "()Lnet/minecraft/resources/ResourceLocation;", "BUTTON_PRESSED", "getBUTTON_PRESSED", "BUTTON_HOVERED", "getBUTTON_HOVERED", "BUTTON_PRESSED_HOVERED", "getBUTTON_PRESSED_HOVERED", "GENERIC_BACKGROUND", "getGENERIC_BACKGROUND", "GENERIC_PANEL", "getGENERIC_PANEL", "SCROLLBAR_H", "getSCROLLBAR_H", "SCROLLBAR_H_HOVERED", "getSCROLLBAR_H_HOVERED", "SCROLLBAR_H_PRESSED", "getSCROLLBAR_H_PRESSED", "SCROLLBAR_V", "getSCROLLBAR_V", "SCROLLBAR_V_HOVERED", "getSCROLLBAR_V_HOVERED", "SCROLLBAR_V_PRESSED", "getSCROLLBAR_V_PRESSED", "TEXT_BOX", "getTEXT_BOX", "V_SLIDER_SETTINGS", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;", "getV_SLIDER_SETTINGS", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;", "H_SLIDER_SETTINGS", "getH_SLIDER_SETTINGS", "SPRITE_BUTTON_SETTINGS", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteButtonSettings;", "getSPRITE_BUTTON_SETTINGS", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteButtonSettings;", "TEXT_PANEL_SETTINGS", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/TextPanelButtonSettings;", "getTEXT_PANEL_SETTINGS", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/TextPanelButtonSettings;", "SCROLL_CONTAINER_SETTINGS", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/ScrollContainerSettings;", "getSCROLL_CONTAINER_SETTINGS", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/ScrollContainerSettings;", "DROPDOWN_LIST_SETTINGS", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/DropdownListSettings;", "getDROPDOWN_LIST_SETTINGS", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/DropdownListSettings;", "createGenericBackground", "Lnet/thebrokenscript/brokencore/api/client/gui/misc/GuiSprite;", "createHorizontalScrollbar", "Lnet/thebrokenscript/brokencore/api/client/gui/range/VSlider;", "T", "", "range", "Lkotlin/ranges/ClosedRange;", "stepSize", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "newValue", "", "delta", "", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Comparable;Lkotlin/jvm/functions/Function2;)Lnet/thebrokenscript/brokencore/api/client/gui/range/VSlider;", "createVerticalScrollbar", "createTextField", "Lnet/thebrokenscript/brokencore/api/client/gui/field/TextField;", "createIntField", "Lnet/thebrokenscript/brokencore/api/client/gui/field/IntField;", "createDecimalField", "Lnet/thebrokenscript/brokencore/api/client/gui/field/DecimalField;", "createVec3Field", "Lnet/thebrokenscript/brokencore/api/client/gui/field/Vector3Field;", "createCurveEditor", "Lnet/thebrokenscript/brokencore/api/client/gui/range/CurveEditor;", "createScrollContainer", "Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollContainer;", "createPresetDropdownList", "Lnet/thebrokenscript/brokencore/api/client/gui/misc/DropdownList;", "Lkotlin/Function1;", "", "selectedText", "brokencore-common"})
public final class CutsceneEditorConstants {
    @NotNull
    public static final CutsceneEditorConstants INSTANCE = new CutsceneEditorConstants();
    @NotNull
    private static final SpriteScalingSettings COMMON_NINE_PATCH_SCALING = SpriteScalingSettings.Companion.createNinePatch(new NinePatchSettings(1, 1, 1, 1, 64, 64));
    @NotNull
    private static final ResourceLocation BUTTON = BrokenCore.id("cutscene_editor/button");
    @NotNull
    private static final ResourceLocation BUTTON_PRESSED = BrokenCore.id("cutscene_editor/button_pressed");
    @NotNull
    private static final ResourceLocation BUTTON_HOVERED = BrokenCore.id("cutscene_editor/button_hovered");
    @NotNull
    private static final ResourceLocation BUTTON_PRESSED_HOVERED = BrokenCore.id("cutscene_editor/button_pressed_hovered");
    @NotNull
    private static final ResourceLocation GENERIC_BACKGROUND = BrokenCore.id("cutscene_editor/generic_background");
    @NotNull
    private static final ResourceLocation GENERIC_PANEL = BrokenCore.id("cutscene_editor/generic_panel");
    @NotNull
    private static final ResourceLocation SCROLLBAR_H = BrokenCore.id("cutscene_editor/scrollbarh");
    @NotNull
    private static final ResourceLocation SCROLLBAR_H_HOVERED = BrokenCore.id("cutscene_editor/scrollbarh_hovered");
    @NotNull
    private static final ResourceLocation SCROLLBAR_H_PRESSED = BrokenCore.id("cutscene_editor/scrollbarh_pressed");
    @NotNull
    private static final ResourceLocation SCROLLBAR_V = BrokenCore.id("cutscene_editor/scrollbarv");
    @NotNull
    private static final ResourceLocation SCROLLBAR_V_HOVERED = BrokenCore.id("cutscene_editor/scrollbarv_hovered");
    @NotNull
    private static final ResourceLocation SCROLLBAR_V_PRESSED = BrokenCore.id("cutscene_editor/scrollbarv_pressed");
    @NotNull
    private static final ResourceLocation TEXT_BOX = BrokenCore.id("cutscene_editor/text_box");
    @NotNull
    private static final SliderSettings V_SLIDER_SETTINGS = new SliderSettings(COMMON_NINE_PATCH_SCALING, GENERIC_PANEL, COMMON_NINE_PATCH_SCALING, SCROLLBAR_V, SCROLLBAR_V_HOVERED, SCROLLBAR_V_PRESSED);
    @NotNull
    private static final SliderSettings H_SLIDER_SETTINGS = new SliderSettings(COMMON_NINE_PATCH_SCALING, GENERIC_PANEL, COMMON_NINE_PATCH_SCALING, SCROLLBAR_H, SCROLLBAR_H_HOVERED, SCROLLBAR_H_PRESSED);
    @NotNull
    private static final SpriteButtonSettings SPRITE_BUTTON_SETTINGS = new SpriteButtonSettings(COMMON_NINE_PATCH_SCALING, BUTTON, BUTTON_HOVERED, BUTTON_PRESSED, BUTTON_PRESSED_HOVERED);
    @NotNull
    private static final TextPanelButtonSettings TEXT_PANEL_SETTINGS = new TextPanelButtonSettings(SPRITE_BUTTON_SETTINGS, LabelButtonSettings.Companion.getDEFAULT());
    @NotNull
    private static final ScrollContainerSettings SCROLL_CONTAINER_SETTINGS = new ScrollContainerSettings(H_SLIDER_SETTINGS, V_SLIDER_SETTINGS, 8, 8);
    @NotNull
    private static final DropdownListSettings DROPDOWN_LIST_SETTINGS = new DropdownListSettings(GENERIC_BACKGROUND, COMMON_NINE_PATCH_SCALING, 16, TEXT_PANEL_SETTINGS, LabelButtonSettings.Companion.getDEFAULT(), SCROLL_CONTAINER_SETTINGS);

    private CutsceneEditorConstants() {
    }

    @NotNull
    public final SpriteScalingSettings getCOMMON_NINE_PATCH_SCALING() {
        return COMMON_NINE_PATCH_SCALING;
    }

    @NotNull
    public final ResourceLocation getBUTTON() {
        return BUTTON;
    }

    @NotNull
    public final ResourceLocation getBUTTON_PRESSED() {
        return BUTTON_PRESSED;
    }

    @NotNull
    public final ResourceLocation getBUTTON_HOVERED() {
        return BUTTON_HOVERED;
    }

    @NotNull
    public final ResourceLocation getBUTTON_PRESSED_HOVERED() {
        return BUTTON_PRESSED_HOVERED;
    }

    @NotNull
    public final ResourceLocation getGENERIC_BACKGROUND() {
        return GENERIC_BACKGROUND;
    }

    @NotNull
    public final ResourceLocation getGENERIC_PANEL() {
        return GENERIC_PANEL;
    }

    @NotNull
    public final ResourceLocation getSCROLLBAR_H() {
        return SCROLLBAR_H;
    }

    @NotNull
    public final ResourceLocation getSCROLLBAR_H_HOVERED() {
        return SCROLLBAR_H_HOVERED;
    }

    @NotNull
    public final ResourceLocation getSCROLLBAR_H_PRESSED() {
        return SCROLLBAR_H_PRESSED;
    }

    @NotNull
    public final ResourceLocation getSCROLLBAR_V() {
        return SCROLLBAR_V;
    }

    @NotNull
    public final ResourceLocation getSCROLLBAR_V_HOVERED() {
        return SCROLLBAR_V_HOVERED;
    }

    @NotNull
    public final ResourceLocation getSCROLLBAR_V_PRESSED() {
        return SCROLLBAR_V_PRESSED;
    }

    @NotNull
    public final ResourceLocation getTEXT_BOX() {
        return TEXT_BOX;
    }

    @NotNull
    public final SliderSettings getV_SLIDER_SETTINGS() {
        return V_SLIDER_SETTINGS;
    }

    @NotNull
    public final SliderSettings getH_SLIDER_SETTINGS() {
        return H_SLIDER_SETTINGS;
    }

    @NotNull
    public final SpriteButtonSettings getSPRITE_BUTTON_SETTINGS() {
        return SPRITE_BUTTON_SETTINGS;
    }

    @NotNull
    public final TextPanelButtonSettings getTEXT_PANEL_SETTINGS() {
        return TEXT_PANEL_SETTINGS;
    }

    @NotNull
    public final ScrollContainerSettings getSCROLL_CONTAINER_SETTINGS() {
        return SCROLL_CONTAINER_SETTINGS;
    }

    @NotNull
    public final DropdownListSettings getDROPDOWN_LIST_SETTINGS() {
        return DROPDOWN_LIST_SETTINGS;
    }

    @NotNull
    public final GuiSprite createGenericBackground() {
        return new GuiSprite(GENERIC_BACKGROUND, COMMON_NINE_PATCH_SCALING);
    }

    @NotNull
    public final <T extends Comparable<? super T>> VSlider<T> createHorizontalScrollbar(@NotNull ClosedRange<T> range, @NotNull T stepSize, @NotNull Function2<? super T, ? super Float, Unit> callback) {
        Intrinsics.checkNotNullParameter(range, (String)"range");
        Intrinsics.checkNotNullParameter(stepSize, (String)"stepSize");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        return new VSlider<T>(range, stepSize, H_SLIDER_SETTINGS, callback);
    }

    @NotNull
    public final <T extends Comparable<? super T>> VSlider<T> createVerticalScrollbar(@NotNull ClosedRange<T> range, @NotNull T stepSize, @NotNull Function2<? super T, ? super Float, Unit> callback) {
        Intrinsics.checkNotNullParameter(range, (String)"range");
        Intrinsics.checkNotNullParameter(stepSize, (String)"stepSize");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        return new VSlider<T>(range, stepSize, V_SLIDER_SETTINGS, callback);
    }

    @NotNull
    public final TextField createTextField() {
        return new TextField(TEXT_BOX, COMMON_NINE_PATCH_SCALING, null, 4, null);
    }

    @NotNull
    public final IntField createIntField() {
        return new IntField(TEXT_BOX, COMMON_NINE_PATCH_SCALING, null, 4, null);
    }

    @NotNull
    public final DecimalField createDecimalField() {
        return new DecimalField(TEXT_BOX, COMMON_NINE_PATCH_SCALING, null, 4, null);
    }

    @NotNull
    public final Vector3Field createVec3Field() {
        return new Vector3Field(TEXT_BOX, COMMON_NINE_PATCH_SCALING);
    }

    @NotNull
    public final CurveEditor createCurveEditor() {
        return new CurveEditor(TEXT_BOX, COMMON_NINE_PATCH_SCALING, null, 4, null);
    }

    @NotNull
    public final ScrollContainer createScrollContainer() {
        return SCROLL_CONTAINER_SETTINGS.create();
    }

    @NotNull
    public final DropdownList createPresetDropdownList(@NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        return DROPDOWN_LIST_SETTINGS.create("Preset", callback);
    }
}

