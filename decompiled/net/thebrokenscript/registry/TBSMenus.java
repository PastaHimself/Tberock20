/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.thebrokenscript.brokencore.api.registry.builders.MenuBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.interfaces.ScreenFactory
 *  net.thebrokenscript.brokencore.api.registry.objects.MenuEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.registry.builders.MenuBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.ScreenFactory;
import net.thebrokenscript.brokencore.api.registry.objects.MenuEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSMenus;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.world.inventory.CommandBlockGuiMenu;
import net.thebrokenscript.world.inventory.FakeDisconnectMenu;
import net.thebrokenscript.world.inventory.LibraryBookMenu;
import net.thebrokenscript.world.inventory.NullInterface2Menu;
import net.thebrokenscript.world.inventory.NullInterface3Menu;
import net.thebrokenscript.world.inventory.NullInterfaceMenu;
import net.thebrokenscript.world.inventory.NulledGuiMenu;
import net.thebrokenscript.world.inventory.PolaroidMenu;
import net.thebrokenscript.world.inventory.TornPaperMenu;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/registry/TBSMenus;", "", "<init>", "()V", "NULL_INTERFACE", "Lnet/thebrokenscript/brokencore/api/registry/objects/MenuEntry;", "Lnet/thebrokenscript/world/inventory/NullInterfaceMenu;", "NULL_INTERFACE_2", "Lnet/thebrokenscript/world/inventory/NullInterface2Menu;", "NULL_INTERFACE_3", "Lnet/thebrokenscript/world/inventory/NullInterface3Menu;", "NULLED_GUI", "Lnet/thebrokenscript/world/inventory/NulledGuiMenu;", "COMMAND_GUI", "Lnet/thebrokenscript/world/inventory/CommandBlockGuiMenu;", "COMMAND_CONFIRM_GUI", "POLAROID_GUI", "Lnet/thebrokenscript/world/inventory/PolaroidMenu;", "TORN_PAPER_GUI", "Lnet/thebrokenscript/world/inventory/TornPaperMenu;", "LIBRARY_BOOK_GUI", "Lnet/thebrokenscript/world/inventory/LibraryBookMenu;", "FAKE_DISCONNECT", "Lnet/thebrokenscript/world/inventory/FakeDisconnectMenu;", "thebrokenscript-common"})
public final class TBSMenus {
    @NotNull
    public static final TBSMenus INSTANCE = new TBSMenus();
    @JvmField
    @NotNull
    public static final MenuEntry<NullInterfaceMenu> NULL_INTERFACE = TBSReg.INSTANCE.menu("nullinterface", NULL_INTERFACE.1.INSTANCE, TBSMenus::NULL_INTERFACE$lambda$0);
    @JvmField
    @NotNull
    public static final MenuEntry<NullInterface2Menu> NULL_INTERFACE_2 = TBSReg.INSTANCE.menu("null_interface_2", NULL_INTERFACE_2.1.INSTANCE, TBSMenus::NULL_INTERFACE_2$lambda$0);
    @JvmField
    @NotNull
    public static final MenuEntry<NullInterface3Menu> NULL_INTERFACE_3 = TBSReg.INSTANCE.menu("null_interface_3", NULL_INTERFACE_3.1.INSTANCE, TBSMenus::NULL_INTERFACE_3$lambda$0);
    @JvmField
    @NotNull
    public static final MenuEntry<NulledGuiMenu> NULLED_GUI = TBSReg.INSTANCE.menu("nulled_gui", NULLED_GUI.1.INSTANCE, TBSMenus::NULLED_GUI$lambda$0);
    @JvmField
    @NotNull
    public static final MenuEntry<CommandBlockGuiMenu> COMMAND_GUI = TBSReg.INSTANCE.menu("command", COMMAND_GUI.1.INSTANCE, TBSMenus::COMMAND_GUI$lambda$0);
    @JvmField
    @NotNull
    public static final MenuEntry<CommandBlockGuiMenu> COMMAND_CONFIRM_GUI = TBSReg.INSTANCE.menu("command_confirm", COMMAND_CONFIRM_GUI.1.INSTANCE, TBSMenus::COMMAND_CONFIRM_GUI$lambda$0);
    @JvmField
    @NotNull
    public static final MenuEntry<PolaroidMenu> POLAROID_GUI = TBSReg.INSTANCE.menu("polaroid_gui", POLAROID_GUI.1.INSTANCE, TBSMenus::POLAROID_GUI$lambda$0);
    @JvmField
    @NotNull
    public static final MenuEntry<TornPaperMenu> TORN_PAPER_GUI = TBSReg.INSTANCE.menu("paper_gui", TORN_PAPER_GUI.1.INSTANCE, TBSMenus::TORN_PAPER_GUI$lambda$0);
    @JvmField
    @NotNull
    public static final MenuEntry<LibraryBookMenu> LIBRARY_BOOK_GUI = TBSReg.INSTANCE.menu("library_book_gui", LIBRARY_BOOK_GUI.1.INSTANCE, TBSMenus::LIBRARY_BOOK_GUI$lambda$0);
    @JvmField
    @NotNull
    public static final MenuEntry<FakeDisconnectMenu> FAKE_DISCONNECT = TBSReg.INSTANCE.menu("fake_disconnect", FAKE_DISCONNECT.1.INSTANCE, TBSMenus::FAKE_DISCONNECT$lambda$0);

    private TBSMenus() {
    }

    private static final void NULL_INTERFACE$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::NULL_INTERFACE$lambda$0$0);
    }

    private static final Function0 NULL_INTERFACE$lambda$0$0() {
        return TBSMenus::NULL_INTERFACE$lambda$0$0$0;
    }

    private static final ScreenFactory NULL_INTERFACE$lambda$0$0$0() {
        return NULL_INTERFACE.2.1.1.1.INSTANCE;
    }

    private static final void NULL_INTERFACE_2$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::NULL_INTERFACE_2$lambda$0$0);
    }

    private static final Function0 NULL_INTERFACE_2$lambda$0$0() {
        return TBSMenus::NULL_INTERFACE_2$lambda$0$0$0;
    }

    private static final ScreenFactory NULL_INTERFACE_2$lambda$0$0$0() {
        return NULL_INTERFACE_2.2.1.1.1.INSTANCE;
    }

    private static final void NULL_INTERFACE_3$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::NULL_INTERFACE_3$lambda$0$0);
    }

    private static final Function0 NULL_INTERFACE_3$lambda$0$0() {
        return TBSMenus::NULL_INTERFACE_3$lambda$0$0$0;
    }

    private static final ScreenFactory NULL_INTERFACE_3$lambda$0$0$0() {
        return NULL_INTERFACE_3.2.1.1.1.INSTANCE;
    }

    private static final void NULLED_GUI$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::NULLED_GUI$lambda$0$0);
    }

    private static final Function0 NULLED_GUI$lambda$0$0() {
        return TBSMenus::NULLED_GUI$lambda$0$0$0;
    }

    private static final ScreenFactory NULLED_GUI$lambda$0$0$0() {
        return NULLED_GUI.2.1.1.1.INSTANCE;
    }

    private static final void COMMAND_GUI$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::COMMAND_GUI$lambda$0$0);
    }

    private static final Function0 COMMAND_GUI$lambda$0$0() {
        return TBSMenus::COMMAND_GUI$lambda$0$0$0;
    }

    private static final ScreenFactory COMMAND_GUI$lambda$0$0$0() {
        return COMMAND_GUI.2.1.1.1.INSTANCE;
    }

    private static final void COMMAND_CONFIRM_GUI$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::COMMAND_CONFIRM_GUI$lambda$0$0);
    }

    private static final Function0 COMMAND_CONFIRM_GUI$lambda$0$0() {
        return TBSMenus::COMMAND_CONFIRM_GUI$lambda$0$0$0;
    }

    private static final ScreenFactory COMMAND_CONFIRM_GUI$lambda$0$0$0() {
        return COMMAND_CONFIRM_GUI.2.1.1.1.INSTANCE;
    }

    private static final void POLAROID_GUI$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::POLAROID_GUI$lambda$0$0);
    }

    private static final Function0 POLAROID_GUI$lambda$0$0() {
        return TBSMenus::POLAROID_GUI$lambda$0$0$0;
    }

    private static final ScreenFactory POLAROID_GUI$lambda$0$0$0() {
        return POLAROID_GUI.2.1.1.1.INSTANCE;
    }

    private static final void TORN_PAPER_GUI$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::TORN_PAPER_GUI$lambda$0$0);
    }

    private static final Function0 TORN_PAPER_GUI$lambda$0$0() {
        return TBSMenus::TORN_PAPER_GUI$lambda$0$0$0;
    }

    private static final ScreenFactory TORN_PAPER_GUI$lambda$0$0$0() {
        return TORN_PAPER_GUI.2.1.1.1.INSTANCE;
    }

    private static final void LIBRARY_BOOK_GUI$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::LIBRARY_BOOK_GUI$lambda$0$0);
    }

    private static final Function0 LIBRARY_BOOK_GUI$lambda$0$0() {
        return TBSMenus::LIBRARY_BOOK_GUI$lambda$0$0$0;
    }

    private static final ScreenFactory LIBRARY_BOOK_GUI$lambda$0$0$0() {
        return LIBRARY_BOOK_GUI.2.1.1.1.INSTANCE;
    }

    private static final void FAKE_DISCONNECT$lambda$0(MenuBuilder $this$menu) {
        Intrinsics.checkNotNullParameter((Object)$this$menu, (String)"$this$menu");
        $this$menu.setScreen(TBSMenus::FAKE_DISCONNECT$lambda$0$0);
    }

    private static final Function0 FAKE_DISCONNECT$lambda$0$0() {
        return TBSMenus::FAKE_DISCONNECT$lambda$0$0$0;
    }

    private static final ScreenFactory FAKE_DISCONNECT$lambda$0$0$0() {
        return FAKE_DISCONNECT.2.1.1.1.INSTANCE;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)"gui.thebrokenscript.nulled_gui.label_empty", (Object)"=)"), TuplesKt.to((Object)"gui.thebrokenscript.nulled_gui.label_null", (Object)"Good luck."), TuplesKt.to((Object)"gui.thebrokenscript.nullinterface.label_behind_you", (Object)"behind you"), TuplesKt.to((Object)"gui.thebrokenscript.nullinterface_3.label_help", (Object)"help"), TuplesKt.to((Object)"gui.thebrokenscript.command.header", (Object)"Input Code"), TuplesKt.to((Object)"gui.thebrokenscript.command.header1", (Object)"Leave"), TuplesKt.to((Object)"gui.thebrokenscript.command.header2", (Object)"You Still Have Time"), TuplesKt.to((Object)"gui.thebrokenscript.command.confirm.header_1", (Object)"Are you sure you want to do this?"), TuplesKt.to((Object)"gui.thebrokenscript.command.confirm.header_2", (Object)"The world won't be yours anymore..."), TuplesKt.to((Object)"gui.thebrokenscript.pc_gui.button_confirm_execute", (Object)"Yes"), TuplesKt.to((Object)"gui.thebrokenscript.tabb.label_null", (Object)"null"), TuplesKt.to((Object)"gui.thebrokenscript.pc_gui.button_execute", (Object)"Execute"), TuplesKt.to((Object)"gui.thebrokenscript.pc_gui.pcline1", (Object)"")};
        TBSReg.INSTANCE.getData().getLang().plusAssign(pairArray);
    }
}

