/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.math.MathKt
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KAnnotatedElement
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KProperty1
 *  kotlin.reflect.full.KClasses
 *  kotlin.text.CharsKt
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.AbstractSelectionList$Entry
 *  net.minecraft.client.gui.components.AbstractSliderButton
 *  net.minecraft.client.gui.components.AbstractWidget
 *  net.minecraft.client.gui.components.Button
 *  net.minecraft.client.gui.components.Checkbox
 *  net.minecraft.client.gui.components.ContainerObjectSelectionList
 *  net.minecraft.client.gui.components.ContainerObjectSelectionList$Entry
 *  net.minecraft.client.gui.components.CycleButton
 *  net.minecraft.client.gui.components.EditBox
 *  net.minecraft.client.gui.components.StringWidget
 *  net.minecraft.client.gui.components.Tooltip
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.narration.NarratableEntry
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.network.chat.CommonComponents
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.neoforged.fml.config.ModConfig$Type
 *  net.neoforged.neoforge.common.ModConfigSpec$Range
 *  net.neoforged.neoforge.common.ModConfigSpec$ValueSpec
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.config;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.thebrokenscript.brokencore.api.client.config.UI;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.config.ConfigContainer;
import net.thebrokenscript.brokencore.api.registry.BCRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 z2\u00020\u0001:\bstuvwxyzB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010!\u001a\u00020\"H\u0014J(\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0016J \u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'H\u0016J\b\u0010/\u001a\u00020\"H\u0016J\b\u00100\u001a\u00020\"H\u0002J\b\u00101\u001a\u00020\"H\u0002J\b\u00102\u001a\u00020\"H\u0002J\b\u00103\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\"H\u0002J\u0018\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\fH\u0002J\u0010\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\"H\u0002J\b\u0010<\u001a\u00020\"H\u0002J\u0010\u0010=\u001a\u00020\"2\u0006\u00107\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0010\u0010C\u001a\u00020\"2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0018\u0010D\u001a\u00020B2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010E\u001a\u00020 H\u0002J\u0018\u0010F\u001a\u00020B2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010E\u001a\u00020'H\u0002J\u0018\u0010G\u001a\u00020B2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010E\u001a\u00020HH\u0002J\u0018\u0010I\u001a\u00020B2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010E\u001a\u00020JH\u0002J\u001c\u0010K\u001a\u00020B2\u0006\u0010@\u001a\u00020\u00112\n\u0010E\u001a\u0006\u0012\u0002\b\u00030LH\u0002J\u0018\u0010M\u001a\u00020\"2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u0017H\u0002J\u0018\u0010N\u001a\u00020\"2\u0006\u0010O\u001a\u00020\f2\u0006\u00107\u001a\u00020>H\u0002J\u001e\u0010P\u001a\u00020Q2\u0014\u0010R\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020>\u0012\u0002\b\u0003\u0018\u00010SH\u0002J\b\u0010T\u001a\u00020\u0006H\u0002J\u0010\u0010U\u001a\u00020V2\u0006\u00106\u001a\u00020\u000bH\u0002J\u0018\u0010W\u001a\u00020 2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\fH\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0012\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u001e\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u00010]2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u001e\u0010^\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010]2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0018\u0010_\u001a\u00020 2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u0017H\u0002J\u0016\u0010`\u001a\b\u0012\u0002\b\u0003\u0018\u00010a2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0010\u0010b\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0016\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002J\u001e\u0010d\u001a\u00020\"2\u0014\u0010e\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002J4\u0010f\u001a\u00020\"2\u0014\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0014\u0010h\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002J4\u0010i\u001a\u00020 2\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0014\u0010k\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002J\b\u0010l\u001a\u00020 H\u0002J\b\u0010m\u001a\u00020 H\u0002J\b\u0010n\u001a\u00020\"H\u0002J\u0010\u0010o\u001a\u00020V2\u0006\u0010p\u001a\u00020VH\u0002J\u0014\u0010q\u001a\u0004\u0018\u00010\u00172\b\u0010E\u001a\u0004\u0018\u00010\u0017H\u0002J\u001c\u0010r\u001a\u00020 2\b\u0010j\u001a\u0004\u0018\u00010\u00172\b\u0010k\u001a\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00110\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006{"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen;", "Lnet/minecraft/client/gui/screens/Screen;", "container", "Lnet/thebrokenscript/brokencore/api/config/ConfigContainer;", "parent", "rootTitle", "Lnet/minecraft/network/chat/Component;", "<init>", "(Lnet/thebrokenscript/brokencore/api/config/ConfigContainer;Lnet/minecraft/client/gui/screens/Screen;Lnet/minecraft/network/chat/Component;)V", "configs", "Ljava/util/SortedMap;", "Lnet/neoforged/fml/config/ModConfig$Type;", "Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "stack", "", "Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$StackNode;", "bindings", "Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$ValueBinding;", "bindingByPath", "", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "originalSnapshot", "", "", "lastSavedSnapshot", "list", "Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$ConfigTreeList;", "backButton", "Lnet/minecraft/client/gui/components/Button;", "primaryButton", "cancelButton", "closing", "", "init", "", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTick", "", "keyPressed", "keyCode", "scanCode", "modifiers", "onClose", "onPrimaryPressed", "applyChanges", "cancelAndClose", "closeDone", "goBack", "openType", "type", "config", "openGroup", "group", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigGroup;", "rebuildRows", "addRootRows", "addConfigRows", "Lnet/thebrokenscript/brokencore/api/config/Config;", "addEventToggleRows", "binding", "createEditor", "Lnet/minecraft/client/gui/components/AbstractWidget;", "openEventToggleList", "createBooleanEditor", "value", "createIntEditor", "createLongEditor", "", "createDoubleEditor", "", "createEnumEditor", "", "setValue", "collectBindings", "root", "resolveUiHint", "Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$UiHint;", "property", "Lkotlin/reflect/KProperty1;", "currentTitle", "typeLabel", "", "canOpenType", "valueTooltip", "Lnet/minecraft/client/gui/components/Tooltip;", "valueSpec", "Lnet/neoforged/neoforge/common/ModConfigSpec$ValueSpec;", "intRange", "Lkotlin/Pair;", "doubleRange", "rangeAllows", "rangeOf", "Lnet/neoforged/neoforge/common/ModConfigSpec$Range;", "currentValue", "snapshotCurrent", "restoreSnapshot", "snapshot", "saveChangedRoots", "before", "after", "snapshotsDiffer", "a", "b", "hasUnsavedChanges", "hasAnyChanges", "refreshActionButtons", "prettyName", "raw", "deepCopy", "valuesEqual", "StackNode", "UiHint", "ValueBinding", "ConfigTreeList", "ConfigRow", "IntSliderWidget", "DoubleSliderWidget", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBrokenConfigScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrokenConfigScreen.kt\nnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 KAnnotatedElements.kt\nkotlin/reflect/full/KAnnotatedElements\n*L\n1#1,742:1\n1869#2,2:743\n808#2,11:758\n1208#2,2:773\n1236#2,4:775\n295#2,2:780\n774#2:786\n865#2,2:787\n1563#2:789\n1634#2,3:790\n1563#2:793\n1634#2,3:794\n1193#2,2:797\n1267#2,4:799\n808#2,11:803\n15#3:745\n15#3:746\n15#3:747\n15#3:749\n15#3:750\n15#3:751\n15#3:752\n15#3:756\n15#3:757\n15#3:769\n15#3:770\n15#3:771\n15#3:772\n15#3:782\n15#3:783\n15#3:784\n15#3:785\n15#3:814\n1#4:748\n3919#5:753\n4434#5,2:754\n20#6:779\n*S KotlinDebug\n*F\n+ 1 BrokenConfigScreen.kt\nnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen\n*L\n63#1:743,2\n250#1:758,11\n403#1:773,2\n403#1:775,4\n421#1:780,2\n556#1:786\n556#1:787,2\n574#1:789\n574#1:790,3\n575#1:793\n575#1:794,3\n576#1:797,2\n576#1:799,4\n254#1:803,11\n28#1:745\n72#1:746\n86#1:747\n200#1:749\n205#1:750\n206#1:751\n220#1:752\n226#1:756\n234#1:757\n253#1:769\n263#1:770\n271#1:771\n282#1:772\n427#1:782\n445#1:783\n535#1:784\n540#1:785\n383#1:814\n224#1:753\n224#1:754,2\n421#1:779\n*E\n"})
public final class BrokenConfigScreen
extends Screen {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ConfigContainer container;
    @NotNull
    private final Screen parent;
    @NotNull
    private final Component rootTitle;
    @NotNull
    private final SortedMap<ModConfig.Type, Config.Base> configs;
    @NotNull
    private final List<StackNode> stack;
    @NotNull
    private final List<ValueBinding> bindings;
    @NotNull
    private final Map<Config.CValue<?, ?>, ValueBinding> bindingByPath;
    @NotNull
    private Map<ValueBinding, ? extends Object> originalSnapshot;
    @NotNull
    private Map<ValueBinding, ? extends Object> lastSavedSnapshot;
    private ConfigTreeList list;
    private Button backButton;
    private Button primaryButton;
    private Button cancelButton;
    private boolean closing;
    private static final int ROW_WIDTH = 310;
    private static final int ROW_HEIGHT = 24;
    private static final int LEFT_COLUMN_WIDTH = 150;
    private static final int RIGHT_COLUMN_WIDTH = 150;
    private static final int COLUMN_GAP = 10;
    private static final int BUTTON_WIDTH = 74;
    private static final int BUTTON_SPACING = 4;
    private static final int SIDE_PADDING = 10;
    private static final int ERROR_TEXT_COLOR = -65536;
    @NotNull
    private static final Regex DOUBLE_INPUT = new Regex("^-?(\\d+)?(\\.\\d*)?$");

    public BrokenConfigScreen(@NotNull ConfigContainer container, @NotNull Screen parent, @NotNull Component rootTitle) {
        Intrinsics.checkNotNullParameter((Object)container, (String)"container");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)rootTitle, (String)"rootTitle");
        super(rootTitle);
        this.container = container;
        this.parent = parent;
        this.rootTitle = rootTitle;
        this.configs = MapsKt.toSortedMap(this.container.all(), (Comparator)new Comparator(){

            public final int compare(T a, T b) {
                ModConfig.Type it = (ModConfig.Type)a;
                boolean bl = false;
                Comparable comparable = Integer.valueOf(it.ordinal());
                it = (ModConfig.Type)b;
                Comparable comparable2 = comparable;
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Integer.valueOf(it.ordinal()));
            }
        });
        this.stack = new ArrayList();
        this.bindings = new ArrayList();
        this.bindingByPath = new LinkedHashMap();
        this.originalSnapshot = MapsKt.emptyMap();
        this.lastSavedSnapshot = MapsKt.emptyMap();
        Collection<Config.Base> collection = this.configs.values();
        Intrinsics.checkNotNullExpressionValue(collection, (String)"<get-values>(...)");
        Iterable $this$forEach$iv = collection;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Config.Base it = (Config.Base)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
            this.collectBindings(it, it);
        }
        this.originalSnapshot = this.snapshotCurrent();
        this.lastSavedSnapshot = this.originalSnapshot;
    }

    public /* synthetic */ BrokenConfigScreen(ConfigContainer configContainer, Screen screen, Component component, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            String $this$c$iv = configContainer.getId() + " Configuration";
            boolean $i$f$getC = false;
            Component component2 = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
            component = component2;
        }
        this(configContainer, screen, component);
    }

    protected void init() {
        super.init();
        String $this$c$iv = "<";
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        GuiEventListener guiEventListener = this.addRenderableWidget((GuiEventListener)Button.builder((Component)component, arg_0 -> BrokenConfigScreen.init$lambda$0(this, arg_0)).bounds(8, 8, 20, 20).build());
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener, (String)"addRenderableWidget(...)");
        this.backButton = (Button)guiEventListener;
        int listTop = 36;
        int listHeight = RangesKt.coerceAtLeast((int)(this.height - listTop - 38), (int)64);
        GuiEventListener guiEventListener2 = this.addRenderableWidget((GuiEventListener)new ConfigTreeList(listTop, listHeight));
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener2, (String)"addRenderableWidget(...)");
        this.list = (ConfigTreeList)guiEventListener2;
        int buttonY = this.height - 28;
        int cancelX = this.width - 10 - 74;
        int primaryX = cancelX - 4 - 74;
        String $this$c$iv2 = "Apply";
        boolean $i$f$getC2 = false;
        Component component2 = Component.nullToEmpty((String)$this$c$iv2);
        Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
        GuiEventListener guiEventListener3 = this.addRenderableWidget((GuiEventListener)Button.builder((Component)component2, arg_0 -> BrokenConfigScreen.init$lambda$1(this, arg_0)).bounds(primaryX, buttonY, 74, 20).build());
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener3, (String)"addRenderableWidget(...)");
        this.primaryButton = (Button)guiEventListener3;
        GuiEventListener guiEventListener4 = this.addRenderableWidget((GuiEventListener)Button.builder((Component)CommonComponents.GUI_CANCEL, arg_0 -> BrokenConfigScreen.init$lambda$2(this, arg_0)).bounds(cancelX, buttonY, 74, 20).build());
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener4, (String)"addRenderableWidget(...)");
        this.cancelButton = (Button)guiEventListener4;
        this.rebuildRows();
    }

    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(this.font, this.currentTitle(), this.width / 2, 14, 0xFFFFFF);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) {
            if (!((Collection)this.stack).isEmpty()) {
                this.goBack();
            } else {
                this.cancelAndClose();
            }
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public void onClose() {
        if (!this.closing) {
            this.cancelAndClose();
        }
    }

    private final void onPrimaryPressed() {
        if (!this.hasAnyChanges()) {
            return;
        }
        if (this.hasUnsavedChanges()) {
            this.applyChanges();
        } else {
            this.closeDone();
        }
    }

    private final void applyChanges() {
        Map<ValueBinding, Object> current = this.snapshotCurrent();
        this.saveChangedRoots(this.lastSavedSnapshot, current);
        this.lastSavedSnapshot = current;
        this.refreshActionButtons();
    }

    private final void cancelAndClose() {
        Map<ValueBinding, Object> restored;
        if (this.closing) {
            return;
        }
        Map<ValueBinding, Object> current = this.snapshotCurrent();
        if (this.snapshotsDiffer(current, this.originalSnapshot)) {
            this.restoreSnapshot(this.originalSnapshot);
        }
        if (this.snapshotsDiffer(this.lastSavedSnapshot, restored = this.snapshotCurrent())) {
            this.saveChangedRoots(this.lastSavedSnapshot, restored);
        }
        this.closeDone();
    }

    private final void closeDone() {
        block1: {
            if (this.closing) {
                return;
            }
            this.closing = true;
            Minecraft minecraft = this.minecraft;
            if (minecraft == null) break block1;
            minecraft.setScreen(this.parent);
        }
    }

    private final void goBack() {
        if (!((Collection)this.stack).isEmpty()) {
            this.stack.removeLast();
            this.rebuildRows();
        }
    }

    private final void openType(ModConfig.Type type, Config.Base config) {
        if (!this.canOpenType(type, config)) {
            return;
        }
        ((Collection)this.stack).add(new StackNode(this.typeLabel(type), config, null, 4, null));
        this.rebuildRows();
    }

    private final void openGroup(Config.ConfigGroup group) {
        ((Collection)this.stack).add(new StackNode(this.prettyName(group.getName()), group.getConfig(), null, 4, null));
        this.rebuildRows();
    }

    private final void rebuildRows() {
        Button button;
        ConfigTreeList configTreeList = this.list;
        if (configTreeList == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"list");
            configTreeList = null;
        }
        configTreeList.clearRows();
        StackNode current = (StackNode)CollectionsKt.lastOrNull(this.stack);
        if (current == null) {
            this.addRootRows();
        } else {
            ValueBinding valueBinding = current.getEventToggleList();
            if (valueBinding != null) {
                ValueBinding p0 = valueBinding;
                boolean bl = false;
                this.addEventToggleRows(p0);
            } else {
                Config config = current.getConfig();
                if (config != null) {
                    Config p0 = config;
                    boolean bl = false;
                    this.addConfigRows(p0);
                }
            }
        }
        if ((button = this.backButton) == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"backButton");
            button = null;
        }
        button.active = !((Collection)this.stack).isEmpty();
        this.refreshActionButtons();
    }

    private final void addRootRows() {
        for (Map.Entry entry : ((Map)this.configs).entrySet()) {
            Tooltip tooltip;
            ModConfig.Type type = (ModConfig.Type)entry.getKey();
            Config.Base cfg = (Config.Base)entry.getValue();
            Intrinsics.checkNotNull((Object)type);
            String $this$c$iv = this.typeLabel(type);
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            Button button = Button.builder((Component)component, arg_0 -> BrokenConfigScreen.addRootRows$lambda$0(this, type, cfg, arg_0)).width(310).build();
            if (!cfg.getSpecification().isLoaded()) {
                String $this$c$iv2 = "Config is not loaded yet.";
                $i$f$getC = false;
                Component component2 = Component.nullToEmpty((String)$this$c$iv2);
                Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
                tooltip = Tooltip.create((Component)component2);
            } else {
                Intrinsics.checkNotNull((Object)cfg);
                if (!this.canOpenType(type, cfg)) {
                    String $this$c$iv3 = "Server configuration is only available while in a world.";
                    $i$f$getC = false;
                    Component component3 = Component.nullToEmpty((String)$this$c$iv3);
                    Intrinsics.checkNotNullExpressionValue((Object)component3, (String)"nullToEmpty(...)");
                    tooltip = Tooltip.create((Component)component3);
                } else {
                    tooltip = null;
                }
            }
            Tooltip tooltip2 = tooltip;
            button.active = tooltip2 == null;
            button.setTooltip(tooltip2);
            ConfigTreeList configTreeList = this.list;
            if (configTreeList == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"list");
                configTreeList = null;
            }
            Intrinsics.checkNotNull((Object)button);
            ConfigTreeList.addRow$default(configTreeList, (AbstractWidget)button, null, 2, null);
        }
    }

    /*
     * WARNING - void declaration
     */
    private final void addConfigRows(Config config) {
        for (Config.ConfigPath path : config.values()) {
            ValueBinding binding;
            String $this$c$iv;
            Config.ConfigPath configPath = path;
            if (configPath instanceof Config.ConfigGroup) {
                ConfigTreeList configTreeList;
                void $this$filterTo$iv$iv;
                String $this$c$iv2 = this.prettyName(path.getName());
                boolean $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv2);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                Button button = Button.builder((Component)component, arg_0 -> BrokenConfigScreen.addConfigRows$lambda$0(this, path, arg_0)).width(310).build();
                String[] $this$filter$iv = ((Config.ConfigGroup)path).getComment();
                boolean $i$f$filter = false;
                String[] stringArray = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                int n = ((void)$this$filterTo$iv$iv).length;
                for (int i = 0; i < n; ++i) {
                    void element$iv$iv;
                    void it = element$iv$iv = $this$filterTo$iv$iv[i];
                    boolean bl = false;
                    boolean bl2 = !StringsKt.isBlank((CharSequence)((CharSequence)it));
                    if (!bl2) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                String groupComment = CollectionsKt.joinToString$default((Iterable)((List)destination$iv$iv), (CharSequence)"\n", null, null, (int)0, null, null, (int)62, null);
                if (!StringsKt.isBlank((CharSequence)groupComment)) {
                    $this$c$iv = groupComment;
                    boolean $i$f$getC2 = false;
                    Component component2 = Component.nullToEmpty((String)$this$c$iv);
                    Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
                    button.setTooltip(Tooltip.create((Component)component2));
                }
                if ((configTreeList = this.list) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"list");
                    configTreeList = null;
                }
                Intrinsics.checkNotNull((Object)button);
                ConfigTreeList.addRow$default(configTreeList, (AbstractWidget)button, null, 2, null);
                continue;
            }
            if (!(configPath instanceof Config.CValue) || this.bindingByPath.get(path) == null) continue;
            $this$c$iv = this.prettyName(path.getName());
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            StringWidget label = new StringWidget(150, 20, component, this.font).alignLeft();
            Tooltip tooltip = this.valueTooltip(binding);
            if (tooltip != null) {
                label.setTooltip(tooltip);
            }
            AbstractWidget widget = this.createEditor(binding);
            widget.setTooltip(tooltip);
            ConfigTreeList configTreeList = this.list;
            if (configTreeList == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"list");
                configTreeList = null;
            }
            Intrinsics.checkNotNull((Object)label);
            configTreeList.addRow((AbstractWidget)label, widget);
        }
    }

    /*
     * WARNING - void declaration
     */
    private final void addEventToggleRows(ValueBinding binding) {
        List list;
        List list2;
        Object object = this.currentValue(binding);
        List list3 = object instanceof List ? (List)object : null;
        if (list3 != null) {
            void $this$filterIsInstanceTo$iv$iv;
            Iterable $this$filterIsInstance$iv = list3;
            boolean $i$f$filterIsInstance = false;
            Iterable iterable = $this$filterIsInstance$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterIsInstanceTo = false;
            for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                if (!(element$iv$iv instanceof String)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            list2 = (List)destination$iv$iv;
        } else {
            list2 = list = null;
        }
        if (list2 == null) {
            list = CollectionsKt.emptyList();
        }
        Set disabled = CollectionsKt.toSet((Iterable)list);
        for (ResourceLocation event : BCRegistries.EVENT.keySet()) {
            String id;
            Intrinsics.checkNotNullExpressionValue((Object)event.toString(), (String)"toString(...)");
            ConfigTreeList configTreeList = this.list;
            if (configTreeList == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"list");
                configTreeList = null;
            }
            String $this$c$iv = id;
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            ConfigTreeList.addRow$default(configTreeList, (AbstractWidget)new Checkbox(0, 0, 310, component, this.font, !disabled.contains(id), (arg_0, arg_1) -> BrokenConfigScreen.addEventToggleRows$lambda$0(this, binding, id, arg_0, arg_1)), null, 2, null);
        }
    }

    private final AbstractWidget createEditor(ValueBinding binding) {
        AbstractWidget abstractWidget;
        if (!binding.getRoot().getSpecification().isLoaded()) {
            Button button;
            String $this$c$iv = "Unavailable";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            Button it = button = Button.builder((Component)component, BrokenConfigScreen::createEditor$lambda$0).width(150).build();
            boolean bl = false;
            it.active = false;
            Button button2 = button;
            Intrinsics.checkNotNullExpressionValue((Object)button2, (String)"also(...)");
            return (AbstractWidget)button2;
        }
        Object raw = this.currentValue(binding);
        if (binding.getHint().getMode() == UI.Mode.EVENTS && raw instanceof List) {
            String $this$c$iv = "Configure";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            Button button = Button.builder((Component)component, arg_0 -> BrokenConfigScreen.createEditor$lambda$2(this, binding, arg_0)).width(150).build();
            Intrinsics.checkNotNullExpressionValue((Object)button, (String)"build(...)");
            return (AbstractWidget)button;
        }
        Object object = raw;
        if (object instanceof Boolean) {
            abstractWidget = this.createBooleanEditor(binding, (Boolean)raw);
        } else if (object instanceof Integer) {
            abstractWidget = this.createIntEditor(binding, ((Number)raw).intValue());
        } else if (object instanceof Long) {
            abstractWidget = this.createLongEditor(binding, ((Number)raw).longValue());
        } else if (object instanceof Double) {
            abstractWidget = this.createDoubleEditor(binding, ((Number)raw).doubleValue());
        } else if (object instanceof Enum) {
            abstractWidget = this.createEnumEditor(binding, (Enum)raw);
        } else {
            Button button;
            String $this$c$iv = raw.toString();
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            Button it = button = Button.builder((Component)component, BrokenConfigScreen::createEditor$lambda$3).width(150).build();
            boolean bl = false;
            it.active = false;
            Button button3 = button;
            Intrinsics.checkNotNullExpressionValue((Object)button3, (String)"also(...)");
            abstractWidget = (AbstractWidget)button3;
        }
        return abstractWidget;
    }

    private final void openEventToggleList(ValueBinding binding) {
        ((Collection)this.stack).add(new StackNode(this.prettyName(binding.getPath().getName()), null, binding, 2, null));
        this.rebuildRows();
    }

    private final AbstractWidget createBooleanEditor(ValueBinding binding, boolean value) {
        return switch (WhenMappings.$EnumSwitchMapping$0[binding.getHint().getMode().ordinal()]) {
            case 1, 2 -> {
                CycleButton v0 = CycleButton.onOffBuilder((boolean)value).displayOnlyValue().create(0, 0, 150, 20, (Component)Component.empty(), (arg_0, arg_1) -> BrokenConfigScreen.createBooleanEditor$lambda$0(this, binding, arg_0, arg_1));
                Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"create(...)");
                yield (AbstractWidget)v0;
            }
            default -> (AbstractWidget)new Checkbox(0, 0, 150, (Component)Component.empty(), this.font, value, (arg_0, arg_1) -> BrokenConfigScreen.createBooleanEditor$lambda$1(this, binding, arg_0, arg_1));
        };
    }

    private final AbstractWidget createIntEditor(ValueBinding binding, int value) {
        boolean wantSlider;
        Pair<Integer, Integer> range = this.intRange(binding);
        switch (WhenMappings.$EnumSwitchMapping$0[binding.getHint().getMode().ordinal()]) {
            case 3: {
                boolean bl = true;
                break;
            }
            case 4: {
                boolean bl = false;
                break;
            }
            default: {
                boolean bl;
                if (range != null) {
                    int n = ((Number)range.getSecond()).intValue() - ((Number)range.getFirst()).intValue();
                    boolean bl2 = 1 <= n ? n < 257 : false;
                    if (bl2) {
                        bl = true;
                        break;
                    }
                }
                bl = wantSlider = false;
            }
        }
        if (wantSlider && range != null) {
            int step = RangesKt.coerceAtLeast((int)MathKt.roundToInt((double)binding.getHint().getSliderStep()), (int)1);
            return (AbstractWidget)new IntSliderWidget(value, ((Number)range.getFirst()).intValue(), ((Number)range.getSecond()).intValue(), step, (Function1<? super Integer, Unit>)((Function1)arg_0 -> BrokenConfigScreen.createIntEditor$lambda$0(this, binding, arg_0)));
        }
        EditBox box = new EditBox(this.font, 0, 0, 150, 20, (Component)Component.empty());
        box.setFilter(BrokenConfigScreen::createIntEditor$lambda$1);
        box.setValue(String.valueOf(value));
        box.setResponder(arg_0 -> BrokenConfigScreen.createIntEditor$lambda$2(this, binding, box, arg_0));
        return (AbstractWidget)box;
    }

    private final AbstractWidget createLongEditor(ValueBinding binding, long value) {
        EditBox box = new EditBox(this.font, 0, 0, 150, 20, (Component)Component.empty());
        box.setFilter(BrokenConfigScreen::createLongEditor$lambda$0);
        box.setValue(String.valueOf(value));
        box.setResponder(arg_0 -> BrokenConfigScreen.createLongEditor$lambda$1(this, binding, box, arg_0));
        return (AbstractWidget)box;
    }

    private final AbstractWidget createDoubleEditor(ValueBinding binding, double value) {
        boolean wantSlider;
        Pair<Double, Double> range = this.doubleRange(binding);
        switch (WhenMappings.$EnumSwitchMapping$0[binding.getHint().getMode().ordinal()]) {
            case 3: {
                boolean bl = true;
                break;
            }
            case 4: {
                boolean bl = false;
                break;
            }
            default: {
                boolean bl = wantSlider = false;
            }
        }
        if (wantSlider && range != null) {
            return (AbstractWidget)new DoubleSliderWidget(value, ((Number)range.getFirst()).doubleValue(), ((Number)range.getSecond()).doubleValue(), binding.getHint().getSliderStep(), (Function1<? super Double, Unit>)((Function1)arg_0 -> BrokenConfigScreen.createDoubleEditor$lambda$0(this, binding, arg_0)));
        }
        EditBox box = new EditBox(this.font, 0, 0, 150, 20, (Component)Component.empty());
        box.setFilter(BrokenConfigScreen::createDoubleEditor$lambda$1);
        box.setValue(String.valueOf(value));
        box.setResponder(arg_0 -> BrokenConfigScreen.createDoubleEditor$lambda$2(this, binding, box, arg_0));
        return (AbstractWidget)box;
    }

    private final AbstractWidget createEnumEditor(ValueBinding binding, Enum<?> value) {
        Object[] objectArray = value.getClass().getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(objectArray, (String)"getEnumConstants(...)");
        List entries2 = ArraysKt.toList((Object[])objectArray);
        CycleButton cycleButton = CycleButton.builder(arg_0 -> BrokenConfigScreen.createEnumEditor$lambda$0(this, arg_0)).withValues((Collection)entries2).withInitialValue(value).displayOnlyValue().create(0, 0, 150, 20, (Component)Component.empty(), (arg_0, arg_1) -> BrokenConfigScreen.createEnumEditor$lambda$1(this, binding, arg_0, arg_1));
        Intrinsics.checkNotNullExpressionValue((Object)cycleButton, (String)"create(...)");
        return (AbstractWidget)cycleButton;
    }

    private final void setValue(ValueBinding binding, Object value) {
        Config.CValue<?, ?> cValue = binding.getPath();
        Intrinsics.checkNotNull(cValue, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.config.Config.CValue<kotlin.Any, net.neoforged.neoforge.common.ModConfigSpec.ConfigValue<kotlin.Any>>");
        Config.CValue<?, ?> path = cValue;
        Object current = this.currentValue(binding);
        if (this.valuesEqual(current, value)) {
            return;
        }
        path.set(value);
        this.refreshActionButtons();
    }

    /*
     * WARNING - void declaration
     */
    private final void collectBindings(Config.Base root, Config config) {
        void $this$associateByTo$iv$iv;
        Iterable $this$associateBy$iv = KClasses.getMemberProperties((KClass)Reflection.getOrCreateKotlinClass(config.getClass()));
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateBy$iv, (int)10)), (int)16);
        Iterable iterable = $this$associateBy$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv : $this$associateByTo$iv$iv) {
            void it;
            KProperty1 kProperty1 = (KProperty1)element$iv$iv;
            Map map = destination$iv$iv;
            boolean bl = false;
            map.put(it.getName(), element$iv$iv);
        }
        Map properties = destination$iv$iv;
        for (Config.ConfigPath path : config.values()) {
            Config.ConfigPath configPath = path;
            if (configPath instanceof Config.ConfigGroup) {
                this.collectBindings(root, ((Config.ConfigGroup)path).getConfig());
                continue;
            }
            if (!(configPath instanceof Config.CValue)) continue;
            KProperty1 property = (KProperty1)properties.get(path.getName());
            UiHint hint = this.resolveUiHint(property);
            ValueBinding binding = new ValueBinding(root, (Config.CValue)path, hint);
            ((Collection)this.bindings).add(binding);
            this.bindingByPath.put((Config.CValue<?, ?>)path, binding);
        }
    }

    private final UiHint resolveUiHint(KProperty1<? extends Config, ?> property) {
        Object v0;
        block3: {
            if (property == null) {
                return new UiHint(null, 0.0, 3, null);
            }
            KAnnotatedElement $this$findAnnotation$iv = (KAnnotatedElement)property;
            boolean $i$f$findAnnotation = false;
            Iterable $this$firstOrNull$iv$iv = $this$findAnnotation$iv.getAnnotations();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv$iv : $this$firstOrNull$iv$iv) {
                Annotation it$iv = (Annotation)element$iv$iv;
                boolean bl = false;
                if (!(it$iv instanceof UI)) continue;
                v0 = element$iv$iv;
                break block3;
            }
            v0 = null;
        }
        UI uI = (UI)((Annotation)v0);
        if (uI == null) {
            return new UiHint(null, 0.0, 3, null);
        }
        UI ui = uI;
        return new UiHint(ui.mode(), ui.sliderStep());
    }

    private final Component currentTitle() {
        if (this.stack.isEmpty()) {
            return this.rootTitle;
        }
        String $this$c$iv = CollectionsKt.joinToString$default((Iterable)this.stack, (CharSequence)" / ", null, null, (int)0, null, BrokenConfigScreen::currentTitle$lambda$0, (int)30, null);
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        return component;
    }

    private final String typeLabel(ModConfig.Type type) {
        return switch (WhenMappings.$EnumSwitchMapping$1[type.ordinal()]) {
            case 1 -> "Client";
            case 2 -> "Server";
            case 3 -> "Server";
            case 4 -> "Startup";
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    private final boolean canOpenType(ModConfig.Type type, Config.Base config) {
        if (!config.getSpecification().isLoaded()) {
            return false;
        }
        if (type == ModConfig.Type.SERVER) {
            Minecraft minecraft = this.minecraft;
            if ((minecraft != null ? minecraft.level : null) == null) {
                return false;
            }
        }
        return true;
    }

    private final Tooltip valueTooltip(ValueBinding binding) {
        Tooltip tooltip;
        String comment;
        String string;
        Object object = this.valueSpec(binding);
        if ((object != null && (object = object.getComment()) != null ? ((Object)StringsKt.trim((CharSequence)((CharSequence)object))).toString() : (string = null)) == null) {
            string = "";
        }
        if (StringsKt.isBlank((CharSequence)(comment = string))) {
            tooltip = null;
        } else {
            String $this$c$iv = comment;
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            tooltip = Tooltip.create((Component)component);
        }
        return tooltip;
    }

    private final ModConfigSpec.ValueSpec valueSpec(ValueBinding binding) {
        Object object;
        Object object2 = this;
        try {
            BrokenConfigScreen $this$valueSpec_u24lambda_u240 = object2;
            boolean bl = false;
            object = Result.constructor-impl((Object)binding.getPath().getValue$brokencore_common().getSpec());
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        return (ModConfigSpec.ValueSpec)(Result.isFailure-impl((Object)object2) ? null : object2);
    }

    private final Pair<Integer, Integer> intRange(ValueBinding binding) {
        ModConfigSpec.Range<?> range = this.rangeOf(binding);
        if (range == null) {
            return null;
        }
        ModConfigSpec.Range<?> range2 = range;
        Comparable comparable = range2.getMin();
        Number number = comparable instanceof Number ? (Number)((Number)((Object)comparable)) : (Number)null;
        if (number == null) {
            return null;
        }
        int min = number.intValue();
        Comparable comparable2 = range2.getMax();
        Number number2 = comparable2 instanceof Number ? (Number)((Number)((Object)comparable2)) : (Number)null;
        if (number2 == null) {
            return null;
        }
        int max = number2.intValue();
        return max > min ? TuplesKt.to((Object)min, (Object)max) : null;
    }

    private final Pair<Double, Double> doubleRange(ValueBinding binding) {
        ModConfigSpec.Range<?> range = this.rangeOf(binding);
        if (range == null) {
            return null;
        }
        ModConfigSpec.Range<?> range2 = range;
        Comparable comparable = range2.getMin();
        Number number = comparable instanceof Number ? (Number)((Number)((Object)comparable)) : (Number)null;
        if (number == null) {
            return null;
        }
        double min = number.doubleValue();
        Comparable comparable2 = range2.getMax();
        Number number2 = comparable2 instanceof Number ? (Number)((Number)((Object)comparable2)) : (Number)null;
        if (number2 == null) {
            return null;
        }
        double max = number2.doubleValue();
        return max > min && Math.abs(min) <= Double.MAX_VALUE && Math.abs(max) <= Double.MAX_VALUE ? TuplesKt.to((Object)min, (Object)max) : null;
    }

    private final boolean rangeAllows(ValueBinding binding, Object value) {
        Object object;
        ModConfigSpec.Range<?> range = this.rangeOf(binding);
        if (range == null) {
            return true;
        }
        ModConfigSpec.Range<?> range2 = range;
        Object object2 = this;
        try {
            BrokenConfigScreen $this$rangeAllows_u24lambda_u240 = object2;
            boolean bl = false;
            object = Result.constructor-impl((Object)range2.test(value));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        object = true;
        return (Boolean)(Result.isFailure-impl((Object)object2) ? object : object2);
    }

    private final ModConfigSpec.Range<?> rangeOf(ValueBinding binding) {
        Object object;
        ModConfigSpec.ValueSpec valueSpec = this.valueSpec(binding);
        if (valueSpec == null) {
            return null;
        }
        ModConfigSpec.ValueSpec spec = valueSpec;
        Object object2 = this;
        try {
            BrokenConfigScreen $this$rangeOf_u24lambda_u240 = object2;
            boolean bl = false;
            Object object3 = spec.getClass().getMethod("getRange", new Class[0]).invoke((Object)spec, new Object[0]);
            object = Result.constructor-impl((Object)(object3 instanceof ModConfigSpec.Range ? (ModConfigSpec.Range)object3 : null));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        return (ModConfigSpec.Range)(Result.isFailure-impl((Object)object2) ? null : object2);
    }

    private final Object currentValue(ValueBinding binding) {
        BrokenConfigScreen brokenConfigScreen;
        Object $this$currentValue_u24lambda_u240;
        Config.CValue<?, ?> cValue = binding.getPath();
        Intrinsics.checkNotNull(cValue, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.config.Config.CValue<kotlin.Any, net.neoforged.neoforge.common.ModConfigSpec.ConfigValue<kotlin.Any>>");
        Config.CValue<?, ?> path = cValue;
        BrokenConfigScreen brokenConfigScreen2 = this;
        try {
            $this$currentValue_u24lambda_u240 = brokenConfigScreen2;
            boolean bl = false;
            $this$currentValue_u24lambda_u240 = Result.constructor-impl(path.get());
        }
        catch (Throwable bl) {
            $this$currentValue_u24lambda_u240 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
        }
        brokenConfigScreen2 = $this$currentValue_u24lambda_u240;
        Throwable throwable = Result.exceptionOrNull-impl((Object)((Object)brokenConfigScreen2));
        if (throwable == null) {
            brokenConfigScreen = brokenConfigScreen2;
        } else {
            Throwable it = throwable;
            boolean bl = false;
            brokenConfigScreen = path.getDefault();
        }
        return brokenConfigScreen;
    }

    private final Map<ValueBinding, Object> snapshotCurrent() {
        LinkedHashMap map = new LinkedHashMap(this.bindings.size());
        for (ValueBinding binding : this.bindings) {
            ((Map)map).put(binding, this.deepCopy(this.currentValue(binding)));
        }
        return map;
    }

    private final void restoreSnapshot(Map<ValueBinding, ? extends Object> snapshot) {
        for (ValueBinding binding : this.bindings) {
            Config.CValue<?, ?> path;
            Object target;
            if (!binding.getRoot().getSpecification().isLoaded() || snapshot.get(binding) == null) continue;
            Intrinsics.checkNotNull(binding.getPath(), (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.config.Config.CValue<kotlin.Any, net.neoforged.neoforge.common.ModConfigSpec.ConfigValue<kotlin.Any>>");
            Object object = this.deepCopy(target);
            Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlin.Any");
            path.set(object);
        }
    }

    private final void saveChangedRoots(Map<ValueBinding, ? extends Object> before, Map<ValueBinding, ? extends Object> after) {
        LinkedHashSet changedRoots = new LinkedHashSet();
        for (ValueBinding binding : this.bindings) {
            if (this.valuesEqual(before.get(binding), after.get(binding))) continue;
            ((Collection)changedRoots).add(binding.getRoot());
        }
        Iterator iterator = changedRoots.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, (String)"iterator(...)");
        Iterator<ValueBinding> iterator2 = iterator;
        while (iterator2.hasNext()) {
            Object object;
            ValueBinding valueBinding = iterator2.next();
            Intrinsics.checkNotNullExpressionValue((Object)valueBinding, (String)"next(...)");
            Config.Base root = (Config.Base)((Object)valueBinding);
            if (!root.getSpecification().isLoaded()) continue;
            BrokenConfigScreen brokenConfigScreen = this;
            try {
                BrokenConfigScreen $this$saveChangedRoots_u24lambda_u240 = brokenConfigScreen;
                boolean bl = false;
                root.getSpecification().save();
                object = Result.constructor-impl((Object)Unit.INSTANCE);
            }
            catch (Throwable throwable) {
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
        }
    }

    private final boolean snapshotsDiffer(Map<ValueBinding, ? extends Object> a, Map<ValueBinding, ? extends Object> b) {
        for (ValueBinding binding : this.bindings) {
            if (this.valuesEqual(a.get(binding), b.get(binding))) continue;
            return true;
        }
        return false;
    }

    private final boolean hasUnsavedChanges() {
        return this.snapshotsDiffer(this.snapshotCurrent(), this.lastSavedSnapshot);
    }

    private final boolean hasAnyChanges() {
        return this.snapshotsDiffer(this.snapshotCurrent(), this.originalSnapshot);
    }

    private final void refreshActionButtons() {
        Button button;
        if (this.primaryButton == null || this.cancelButton == null) {
            return;
        }
        boolean anyChanges = this.hasAnyChanges();
        boolean unsavedChanges = this.hasUnsavedChanges();
        if (!anyChanges) {
            Button button2 = this.primaryButton;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"primaryButton");
                button2 = null;
            }
            String $this$c$iv = "Apply";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            button2.setMessage(component);
            Button button3 = this.primaryButton;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"primaryButton");
                button3 = null;
            }
            button3.active = false;
        } else if (unsavedChanges) {
            Button button4 = this.primaryButton;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"primaryButton");
                button4 = null;
            }
            String $this$c$iv = "Apply";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            button4.setMessage(component);
            Button button5 = this.primaryButton;
            if (button5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"primaryButton");
                button5 = null;
            }
            button5.active = true;
        } else {
            Button button6 = this.primaryButton;
            if (button6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"primaryButton");
                button6 = null;
            }
            button6.setMessage(CommonComponents.GUI_DONE);
            Button button7 = this.primaryButton;
            if (button7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"primaryButton");
                button7 = null;
            }
            button7.active = true;
        }
        if ((button = this.cancelButton) == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"cancelButton");
            button = null;
        }
        button.active = true;
    }

    /*
     * WARNING - void declaration
     */
    private final String prettyName(String raw) {
        void $this$filterTo$iv$iv;
        CharSequence charSequence = raw;
        Regex regex = new Regex("(?=[A-Z])|\\.|_");
        int n = 0;
        Iterable $this$filter$iv = regex.split(charSequence, n);
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            String it = (String)element$iv$iv;
            boolean bl = false;
            boolean bl2 = !StringsKt.isBlank((CharSequence)it);
            if (!bl2) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return CollectionsKt.joinToString$default((Iterable)((List)destination$iv$iv), (CharSequence)" ", null, null, (int)0, null, BrokenConfigScreen::prettyName$lambda$1, (int)30, null);
    }

    /*
     * WARNING - void declaration
     */
    private final Object deepCopy(Object value) {
        Object object;
        Object object2 = value;
        if (object2 == null) {
            object = null;
        } else if (object2 instanceof byte[]) {
            object = ((byte[])value).clone();
        } else if (object2 instanceof int[]) {
            object = ((int[])value).clone();
        } else if (object2 instanceof long[]) {
            object = ((long[])value).clone();
        } else if (object2 instanceof double[]) {
            object = ((double[])value).clone();
        } else if (object2 instanceof float[]) {
            object = ((float[])value).clone();
        } else if (object2 instanceof short[]) {
            object = ((short[])value).clone();
        } else if (object2 instanceof boolean[]) {
            object = ((boolean[])value).clone();
        } else if (object2 instanceof char[]) {
            object = ((char[])value).clone();
        } else if (object2 instanceof List) {
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv = (Iterable)value;
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            Iterator iterator = $this$mapTo$iv$iv.iterator();
            while (iterator.hasNext()) {
                void p0;
                Object item$iv$iv;
                Object t = item$iv$iv = iterator.next();
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(this.deepCopy(p0));
            }
            object = (List)destination$iv$iv;
        } else if (object2 instanceof Set) {
            Iterable $this$map$iv = (Iterable)value;
            boolean $i$f$map = false;
            Iterable $this$mapTo$iv$iv = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            Iterator iterator = $this$mapTo$iv$iv.iterator();
            while (iterator.hasNext()) {
                Object item$iv$iv;
                Object p0 = item$iv$iv = iterator.next();
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(this.deepCopy(p0));
            }
            object = CollectionsKt.toSet((Iterable)((List)destination$iv$iv));
        } else if (object2 instanceof Map) {
            void $this$associateTo$iv$iv;
            Iterable $this$associate$iv = ((Map)value).entrySet();
            boolean $i$f$associate = false;
            int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associate$iv, (int)10)), (int)16);
            Iterable destination$iv$iv = $this$associate$iv;
            Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
            boolean $i$f$associateTo = false;
            for (Object element$iv$iv : $this$associateTo$iv$iv) {
                Map map = destination$iv$iv2;
                Map.Entry it = (Map.Entry)element$iv$iv;
                boolean bl = false;
                Pair pair = TuplesKt.to((Object)this.deepCopy(it.getKey()), (Object)this.deepCopy(it.getValue()));
                map.put(pair.getFirst(), pair.getSecond());
            }
            object = destination$iv$iv2;
        } else {
            object = value;
        }
        return object;
    }

    private final boolean valuesEqual(Object a, Object b) {
        return a instanceof byte[] && b instanceof byte[] ? Arrays.equals((byte[])a, (byte[])b) : (a instanceof int[] && b instanceof int[] ? Arrays.equals((int[])a, (int[])b) : (a instanceof long[] && b instanceof long[] ? Arrays.equals((long[])a, (long[])b) : (a instanceof double[] && b instanceof double[] ? Arrays.equals((double[])a, (double[])b) : (a instanceof float[] && b instanceof float[] ? Arrays.equals((float[])a, (float[])b) : (a instanceof short[] && b instanceof short[] ? Arrays.equals((short[])a, (short[])b) : (a instanceof boolean[] && b instanceof boolean[] ? Arrays.equals((boolean[])a, (boolean[])b) : (a instanceof char[] && b instanceof char[] ? Arrays.equals((char[])a, (char[])b) : Intrinsics.areEqual((Object)a, (Object)b))))))));
    }

    private static final void init$lambda$0(BrokenConfigScreen this$0, Button it) {
        this$0.goBack();
    }

    private static final void init$lambda$1(BrokenConfigScreen this$0, Button it) {
        this$0.onPrimaryPressed();
    }

    private static final void init$lambda$2(BrokenConfigScreen this$0, Button it) {
        this$0.cancelAndClose();
    }

    private static final void addRootRows$lambda$0(BrokenConfigScreen this$0, ModConfig.Type $type, Config.Base $cfg, Button it) {
        Intrinsics.checkNotNull((Object)$type);
        Intrinsics.checkNotNull((Object)$cfg);
        this$0.openType($type, $cfg);
    }

    private static final void addConfigRows$lambda$0(BrokenConfigScreen this$0, Config.ConfigPath $path, Button it) {
        this$0.openGroup((Config.ConfigGroup)$path);
    }

    /*
     * WARNING - void declaration
     */
    private static final void addEventToggleRows$lambda$0(BrokenConfigScreen this$0, ValueBinding $binding, String $id, Checkbox checkbox, boolean enabled) {
        Collection<String> collection;
        block4: {
            block3: {
                void $this$filterIsInstanceTo$iv$iv;
                Object object = this$0.currentValue($binding);
                collection = object instanceof List ? (List)object : null;
                if (collection == null) break block3;
                Iterable $this$filterIsInstance$iv = collection;
                boolean $i$f$filterIsInstance = false;
                Iterable iterable = $this$filterIsInstance$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterIsInstanceTo = false;
                for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
                    if (!(element$iv$iv instanceof String)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                collection = CollectionsKt.toMutableSet((Iterable)((List)destination$iv$iv));
                if (collection != null) break block4;
            }
            collection = new LinkedHashSet();
        }
        Collection<String> updated = collection;
        boolean bl = enabled ? updated.remove($id) : updated.add($id);
        this$0.setValue($binding, CollectionsKt.toList((Iterable)updated));
    }

    private static final void createEditor$lambda$0(Button button) {
    }

    private static final void createEditor$lambda$2(BrokenConfigScreen this$0, ValueBinding $binding, Button it) {
        this$0.openEventToggleList($binding);
    }

    private static final void createEditor$lambda$3(Button button) {
    }

    private static final void createBooleanEditor$lambda$0(BrokenConfigScreen this$0, ValueBinding $binding, CycleButton cycleButton, Boolean newValue) {
        Intrinsics.checkNotNull((Object)newValue);
        this$0.setValue($binding, newValue);
    }

    private static final void createBooleanEditor$lambda$1(BrokenConfigScreen this$0, ValueBinding $binding, Checkbox checkbox, boolean newValue) {
        this$0.setValue($binding, newValue);
    }

    private static final Unit createIntEditor$lambda$0(BrokenConfigScreen this$0, ValueBinding $binding, int it) {
        this$0.setValue($binding, it);
        return Unit.INSTANCE;
    }

    private static final boolean createIntEditor$lambda$1(String it) {
        Intrinsics.checkNotNull((Object)it);
        return ((CharSequence)it).length() == 0 || Intrinsics.areEqual((Object)it, (Object)"-") || StringsKt.toIntOrNull((String)it) != null;
    }

    private static final void createIntEditor$lambda$2(BrokenConfigScreen this$0, ValueBinding $binding, EditBox $box, String text) {
        Intrinsics.checkNotNull((Object)text);
        Integer parsed = StringsKt.toIntOrNull((String)text);
        if (parsed != null && this$0.rangeAllows($binding, parsed)) {
            this$0.setValue($binding, parsed);
            $box.setTextColor(0xE0E0E0);
        } else {
            $box.setTextColor(-65536);
        }
    }

    private static final boolean createLongEditor$lambda$0(String it) {
        Intrinsics.checkNotNull((Object)it);
        return ((CharSequence)it).length() == 0 || Intrinsics.areEqual((Object)it, (Object)"-") || StringsKt.toLongOrNull((String)it) != null;
    }

    private static final void createLongEditor$lambda$1(BrokenConfigScreen this$0, ValueBinding $binding, EditBox $box, String text) {
        Intrinsics.checkNotNull((Object)text);
        Long parsed = StringsKt.toLongOrNull((String)text);
        if (parsed != null && this$0.rangeAllows($binding, parsed)) {
            this$0.setValue($binding, parsed);
            $box.setTextColor(0xE0E0E0);
        } else {
            $box.setTextColor(-65536);
        }
    }

    private static final Unit createDoubleEditor$lambda$0(BrokenConfigScreen this$0, ValueBinding $binding, double it) {
        this$0.setValue($binding, it);
        return Unit.INSTANCE;
    }

    private static final boolean createDoubleEditor$lambda$1(String it) {
        Intrinsics.checkNotNull((Object)it);
        return ((CharSequence)it).length() == 0 || Intrinsics.areEqual((Object)it, (Object)"-") || Intrinsics.areEqual((Object)it, (Object)".") || Intrinsics.areEqual((Object)it, (Object)"-.") || DOUBLE_INPUT.matches((CharSequence)it);
    }

    private static final void createDoubleEditor$lambda$2(BrokenConfigScreen this$0, ValueBinding $binding, EditBox $box, String text) {
        Intrinsics.checkNotNull((Object)text);
        Double parsed = StringsKt.toDoubleOrNull((String)text);
        if (parsed != null && this$0.rangeAllows($binding, parsed)) {
            this$0.setValue($binding, parsed);
            $box.setTextColor(0xE0E0E0);
        } else {
            $box.setTextColor(-65536);
        }
    }

    private static final Component createEnumEditor$lambda$0(BrokenConfigScreen this$0, Enum it) {
        String string = it.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toLowerCase(...)");
        String $this$c$iv = this$0.prettyName(string);
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        return component;
    }

    private static final void createEnumEditor$lambda$1(BrokenConfigScreen this$0, ValueBinding $binding, CycleButton cycleButton, Enum newValue) {
        Intrinsics.checkNotNull((Object)newValue);
        this$0.setValue($binding, newValue);
    }

    private static final CharSequence currentTitle$lambda$0(StackNode it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getLabel();
    }

    /*
     * WARNING - void declaration
     */
    private static final CharSequence prettyName$lambda$1(String it) {
        String string;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String string2 = it;
        if (((CharSequence)string2).length() > 0) {
            void c;
            char c2 = string2.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl = false;
            StringBuilder stringBuilder2 = stringBuilder.append((Object)(Character.isLowerCase((char)c) ? CharsKt.titlecase((char)c) : String.valueOf((char)c)));
            String string3 = string2;
            int n = 1;
            String string4 = string3.substring(n);
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"substring(...)");
            string = stringBuilder2.append(string4).toString();
        } else {
            string = string2;
        }
        return string;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$Companion;", "", "<init>", "()V", "ROW_WIDTH", "", "ROW_HEIGHT", "LEFT_COLUMN_WIDTH", "RIGHT_COLUMN_WIDTH", "COLUMN_GAP", "BUTTON_WIDTH", "BUTTON_SPACING", "SIDE_PADDING", "ERROR_TEXT_COLOR", "DOUBLE_INPUT", "Lkotlin/text/Regex;", "normalize", "", "value", "min", "max", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        private final double normalize(int value, int min, int max) {
            if (max <= min) {
                return 0.0;
            }
            return RangesKt.coerceIn((double)((double)(value - min) / (double)(max - min)), (double)0.0, (double)1.0);
        }

        private final double normalize(double value, double min, double max) {
            if (max <= min) {
                return 0.0;
            }
            return RangesKt.coerceIn((double)((value - min) / (max - min)), (double)0.0, (double)1.0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0000R\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007JX\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001a0\tH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$ConfigRow;", "Lnet/minecraft/client/gui/components/ContainerObjectSelectionList$Entry;", "Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen;", "left", "Lnet/minecraft/client/gui/components/AbstractWidget;", "right", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen;Lnet/minecraft/client/gui/components/AbstractWidget;Lnet/minecraft/client/gui/components/AbstractWidget;)V", "children", "", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "index", "", "top", "leftPos", "width", "height", "mouseX", "mouseY", "hovering", "", "partialTick", "", "Lnet/minecraft/client/gui/components/events/GuiEventListener;", "narratables", "Lnet/minecraft/client/gui/narration/NarratableEntry;", "brokencore-common"})
    private final class ConfigRow
    extends ContainerObjectSelectionList.Entry<ConfigRow> {
        @NotNull
        private final AbstractWidget left;
        @Nullable
        private final AbstractWidget right;
        @NotNull
        private final List<AbstractWidget> children;

        public ConfigRow(@Nullable AbstractWidget left, AbstractWidget right) {
            List list;
            Intrinsics.checkNotNullParameter((Object)left, (String)"left");
            this.left = left;
            this.right = right;
            if (this.right == null) {
                list = CollectionsKt.listOf((Object)this.left);
            } else {
                Object[] objectArray = new AbstractWidget[]{this.left, this.right};
                list = CollectionsKt.listOf((Object[])objectArray);
            }
            this.children = list;
        }

        public void render(@NotNull GuiGraphics guiGraphics, int index, int top, int leftPos, int width, int height, int mouseX, int mouseY, boolean hovering, float partialTick) {
            block0: {
                Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
                int baseX = BrokenConfigScreen.this.width / 2 - 155;
                this.left.setPosition(baseX, top);
                this.left.render(guiGraphics, mouseX, mouseY, partialTick);
                AbstractWidget abstractWidget = this.right;
                if (abstractWidget == null) break block0;
                AbstractWidget it = abstractWidget;
                boolean bl = false;
                it.setPosition(baseX + 150 + 10, top);
                it.render(guiGraphics, mouseX, mouseY, partialTick);
            }
        }

        @NotNull
        public List<GuiEventListener> children() {
            return this.children;
        }

        @NotNull
        public List<NarratableEntry> narratables() {
            return this.children;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$ConfigTreeList;", "Lnet/minecraft/client/gui/components/ContainerObjectSelectionList;", "Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$ConfigRow;", "Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen;", "y", "", "height", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen;II)V", "getRowWidth", "addRow", "", "left", "Lnet/minecraft/client/gui/components/AbstractWidget;", "right", "clearRows", "brokencore-common"})
    private final class ConfigTreeList
    extends ContainerObjectSelectionList<ConfigRow> {
        public ConfigTreeList(int y, int height) {
            Minecraft minecraft = BrokenConfigScreen.this.minecraft;
            Intrinsics.checkNotNull((Object)minecraft);
            super(minecraft, BrokenConfigScreen.this.width, height, y, 24);
            this.centerListVertically = false;
        }

        public int getRowWidth() {
            return 310;
        }

        public final void addRow(@NotNull AbstractWidget left, @Nullable AbstractWidget right) {
            Intrinsics.checkNotNullParameter((Object)left, (String)"left");
            this.addEntry((AbstractSelectionList.Entry)new ConfigRow(left, right));
        }

        public static /* synthetic */ void addRow$default(ConfigTreeList configTreeList, AbstractWidget abstractWidget, AbstractWidget abstractWidget2, int n, Object object) {
            if ((n & 2) != 0) {
                abstractWidget2 = null;
            }
            configTreeList.addRow(abstractWidget, abstractWidget2);
        }

        public final void clearRows() {
            this.clearEntries();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000e\u001a\u00020\tH\u0014J\b\u0010\u000f\u001a\u00020\tH\u0014J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$DoubleSliderWidget;", "Lnet/minecraft/client/gui/components/AbstractSliderButton;", "value", "", "min", "max", "step", "callback", "Lkotlin/Function1;", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen;DDDDLkotlin/jvm/functions/Function1;)V", "sliderStep", "current", "updateMessage", "applyValue", "denormalize", "normalized", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBrokenConfigScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrokenConfigScreen.kt\nnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$DoubleSliderWidget\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,742:1\n15#2:743\n*S KotlinDebug\n*F\n+ 1 BrokenConfigScreen.kt\nnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$DoubleSliderWidget\n*L\n698#1:743\n*E\n"})
    private final class DoubleSliderWidget
    extends AbstractSliderButton {
        private final double min;
        private final double max;
        @NotNull
        private final Function1<Double, Unit> callback;
        private final double sliderStep;
        private double current;

        public DoubleSliderWidget(double value, double min, double max, @NotNull double step, Function1<? super Double, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, (String)"callback");
            super(0, 0, 150, 20, (Component)Component.empty(), Companion.normalize(value, min, max));
            this.min = min;
            this.max = max;
            this.callback = callback;
            this.sliderStep = step > 0.0 && Math.abs(step) <= Double.MAX_VALUE ? step : 0.1;
            this.current = value;
            this.updateMessage();
        }

        protected void updateMessage() {
            String string = "%s";
            Object[] objectArray = new Object[]{this.current};
            String string2 = String.format(string, Arrays.copyOf(objectArray, objectArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"format(...)");
            String $this$c$iv = string2;
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            this.setMessage(component);
        }

        protected void applyValue() {
            double next = this.denormalize(this.value);
            if (!(next == this.current)) {
                this.current = next;
                this.callback.invoke((Object)next);
            }
            this.updateMessage();
        }

        private final double denormalize(double normalized) {
            if (this.max <= this.min) {
                return this.min;
            }
            double raw = this.min + RangesKt.coerceIn((double)normalized, (double)0.0, (double)1.0) * (this.max - this.min);
            double snapped = Math.rint((raw - this.min) / this.sliderStep) * this.sliderStep + this.min;
            return RangesKt.coerceIn((double)snapped, (double)this.min, (double)this.max);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$IntSliderWidget;", "Lnet/minecraft/client/gui/components/AbstractSliderButton;", "value", "", "min", "max", "step", "callback", "Lkotlin/Function1;", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen;IIIILkotlin/jvm/functions/Function1;)V", "current", "updateMessage", "applyValue", "denormalize", "normalized", "", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nBrokenConfigScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrokenConfigScreen.kt\nnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$IntSliderWidget\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,742:1\n15#2:743\n*S KotlinDebug\n*F\n+ 1 BrokenConfigScreen.kt\nnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$IntSliderWidget\n*L\n662#1:743\n*E\n"})
    private final class IntSliderWidget
    extends AbstractSliderButton {
        private final int min;
        private final int max;
        private final int step;
        @NotNull
        private final Function1<Integer, Unit> callback;
        private int current;

        public IntSliderWidget(int value, int min, int max, @NotNull int step, Function1<? super Integer, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, (String)"callback");
            super(0, 0, 150, 20, (Component)Component.empty(), Companion.normalize(value, min, max));
            this.min = min;
            this.max = max;
            this.step = step;
            this.callback = callback;
            this.current = value;
            this.updateMessage();
        }

        protected void updateMessage() {
            String $this$c$iv = String.valueOf(this.current);
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            this.setMessage(component);
        }

        protected void applyValue() {
            int next = this.denormalize(this.value);
            if (next != this.current) {
                this.current = next;
                this.callback.invoke((Object)next);
            }
            this.updateMessage();
        }

        private final int denormalize(double normalized) {
            if (this.max <= this.min) {
                return this.min;
            }
            int span = this.max - this.min;
            int snapped = MathKt.roundToInt((double)(normalized * (double)span / (double)this.step)) * this.step + this.min;
            return RangesKt.coerceIn((int)snapped, (int)this.min, (int)this.max);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$StackNode;", "", "label", "", "config", "Lnet/thebrokenscript/brokencore/api/config/Config;", "eventToggleList", "Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$ValueBinding;", "<init>", "(Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/config/Config;Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$ValueBinding;)V", "getLabel", "()Ljava/lang/String;", "getConfig", "()Lnet/thebrokenscript/brokencore/api/config/Config;", "getEventToggleList", "()Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$ValueBinding;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "brokencore-common"})
    private static final class StackNode {
        @NotNull
        private final String label;
        @Nullable
        private final Config config;
        @Nullable
        private final ValueBinding eventToggleList;

        public StackNode(@NotNull String label, @Nullable Config config, @Nullable ValueBinding eventToggleList) {
            Intrinsics.checkNotNullParameter((Object)label, (String)"label");
            this.label = label;
            this.config = config;
            this.eventToggleList = eventToggleList;
        }

        public /* synthetic */ StackNode(String string, Config config, ValueBinding valueBinding, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                config = null;
            }
            if ((n & 4) != 0) {
                valueBinding = null;
            }
            this(string, config, valueBinding);
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final Config getConfig() {
            return this.config;
        }

        @Nullable
        public final ValueBinding getEventToggleList() {
            return this.eventToggleList;
        }

        @NotNull
        public final String component1() {
            return this.label;
        }

        @Nullable
        public final Config component2() {
            return this.config;
        }

        @Nullable
        public final ValueBinding component3() {
            return this.eventToggleList;
        }

        @NotNull
        public final StackNode copy(@NotNull String label, @Nullable Config config, @Nullable ValueBinding eventToggleList) {
            Intrinsics.checkNotNullParameter((Object)label, (String)"label");
            return new StackNode(label, config, eventToggleList);
        }

        public static /* synthetic */ StackNode copy$default(StackNode stackNode, String string, Config config, ValueBinding valueBinding, int n, Object object) {
            if ((n & 1) != 0) {
                string = stackNode.label;
            }
            if ((n & 2) != 0) {
                config = stackNode.config;
            }
            if ((n & 4) != 0) {
                valueBinding = stackNode.eventToggleList;
            }
            return stackNode.copy(string, config, valueBinding);
        }

        @NotNull
        public String toString() {
            return "StackNode(label=" + this.label + ", config=" + this.config + ", eventToggleList=" + this.eventToggleList + ")";
        }

        public int hashCode() {
            int result = this.label.hashCode();
            result = result * 31 + (this.config == null ? 0 : this.config.hashCode());
            result = result * 31 + (this.eventToggleList == null ? 0 : this.eventToggleList.hashCode());
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StackNode)) {
                return false;
            }
            StackNode stackNode = (StackNode)other;
            if (!Intrinsics.areEqual((Object)this.label, (Object)stackNode.label)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.config, (Object)stackNode.config)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.eventToggleList, (Object)stackNode.eventToggleList);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$UiHint;", "", "mode", "Lnet/thebrokenscript/brokencore/api/client/config/UI$Mode;", "sliderStep", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/config/UI$Mode;D)V", "getMode", "()Lnet/thebrokenscript/brokencore/api/client/config/UI$Mode;", "getSliderStep", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
    private static final class UiHint {
        @NotNull
        private final UI.Mode mode;
        private final double sliderStep;

        public UiHint(@NotNull UI.Mode mode, double sliderStep) {
            Intrinsics.checkNotNullParameter((Object)((Object)mode), (String)"mode");
            this.mode = mode;
            this.sliderStep = sliderStep;
        }

        public /* synthetic */ UiHint(UI.Mode mode, double d, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 1) != 0) {
                mode = UI.Mode.AUTO;
            }
            if ((n & 2) != 0) {
                d = 1.0;
            }
            this(mode, d);
        }

        @NotNull
        public final UI.Mode getMode() {
            return this.mode;
        }

        public final double getSliderStep() {
            return this.sliderStep;
        }

        @NotNull
        public final UI.Mode component1() {
            return this.mode;
        }

        public final double component2() {
            return this.sliderStep;
        }

        @NotNull
        public final UiHint copy(@NotNull UI.Mode mode, double sliderStep) {
            Intrinsics.checkNotNullParameter((Object)((Object)mode), (String)"mode");
            return new UiHint(mode, sliderStep);
        }

        public static /* synthetic */ UiHint copy$default(UiHint uiHint, UI.Mode mode, double d, int n, Object object) {
            if ((n & 1) != 0) {
                mode = uiHint.mode;
            }
            if ((n & 2) != 0) {
                d = uiHint.sliderStep;
            }
            return uiHint.copy(mode, d);
        }

        @NotNull
        public String toString() {
            return "UiHint(mode=" + this.mode + ", sliderStep=" + this.sliderStep + ")";
        }

        public int hashCode() {
            int result = this.mode.hashCode();
            result = result * 31 + Double.hashCode(this.sliderStep);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UiHint)) {
                return false;
            }
            UiHint uiHint = (UiHint)other;
            if (this.mode != uiHint.mode) {
                return false;
            }
            return Double.compare(this.sliderStep, uiHint.sliderStep) == 0;
        }

        public UiHint() {
            this(null, 0.0, 3, null);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$ValueBinding;", "", "root", "Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "path", "Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "hint", "Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$UiHint;", "<init>", "(Lnet/thebrokenscript/brokencore/api/config/Config$Base;Lnet/thebrokenscript/brokencore/api/config/Config$CValue;Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$UiHint;)V", "getRoot", "()Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "getPath", "()Lnet/thebrokenscript/brokencore/api/config/Config$CValue;", "getHint", "()Lnet/thebrokenscript/brokencore/api/client/config/BrokenConfigScreen$UiHint;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
    private static final class ValueBinding {
        @NotNull
        private final Config.Base root;
        @NotNull
        private final Config.CValue<?, ?> path;
        @NotNull
        private final UiHint hint;

        public ValueBinding(@NotNull Config.Base root, @NotNull Config.CValue<?, ?> path, @NotNull UiHint hint) {
            Intrinsics.checkNotNullParameter((Object)root, (String)"root");
            Intrinsics.checkNotNullParameter(path, (String)"path");
            Intrinsics.checkNotNullParameter((Object)hint, (String)"hint");
            this.root = root;
            this.path = path;
            this.hint = hint;
        }

        @NotNull
        public final Config.Base getRoot() {
            return this.root;
        }

        @NotNull
        public final Config.CValue<?, ?> getPath() {
            return this.path;
        }

        @NotNull
        public final UiHint getHint() {
            return this.hint;
        }

        @NotNull
        public final Config.Base component1() {
            return this.root;
        }

        @NotNull
        public final Config.CValue<?, ?> component2() {
            return this.path;
        }

        @NotNull
        public final UiHint component3() {
            return this.hint;
        }

        @NotNull
        public final ValueBinding copy(@NotNull Config.Base root, @NotNull Config.CValue<?, ?> path, @NotNull UiHint hint) {
            Intrinsics.checkNotNullParameter((Object)root, (String)"root");
            Intrinsics.checkNotNullParameter(path, (String)"path");
            Intrinsics.checkNotNullParameter((Object)hint, (String)"hint");
            return new ValueBinding(root, path, hint);
        }

        public static /* synthetic */ ValueBinding copy$default(ValueBinding valueBinding, Config.Base base, Config.CValue cValue, UiHint uiHint, int n, Object object) {
            if ((n & 1) != 0) {
                base = valueBinding.root;
            }
            if ((n & 2) != 0) {
                cValue = valueBinding.path;
            }
            if ((n & 4) != 0) {
                uiHint = valueBinding.hint;
            }
            return valueBinding.copy(base, cValue, uiHint);
        }

        @NotNull
        public String toString() {
            return "ValueBinding(root=" + this.root + ", path=" + this.path + ", hint=" + this.hint + ")";
        }

        public int hashCode() {
            int result = this.root.hashCode();
            result = result * 31 + this.path.hashCode();
            result = result * 31 + this.hint.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValueBinding)) {
                return false;
            }
            ValueBinding valueBinding = (ValueBinding)other;
            if (!Intrinsics.areEqual((Object)this.root, (Object)valueBinding.root)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.path, valueBinding.path)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.hint, (Object)valueBinding.hint);
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[UI.Mode.values().length];
            try {
                nArray[UI.Mode.SWITCH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[UI.Mode.ON_OFF.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[UI.Mode.SLIDER.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[UI.Mode.TEXT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[ModConfig.Type.values().length];
            try {
                nArray[ModConfig.Type.CLIENT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ModConfig.Type.COMMON.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ModConfig.Type.SERVER.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ModConfig.Type.STARTUP.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

