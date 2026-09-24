/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.AbstractWidget
 *  net.minecraft.client.gui.components.Button
 *  net.minecraft.client.gui.components.Button$OnPress
 *  net.minecraft.client.gui.components.Renderable
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.layouts.FrameLayout
 *  net.minecraft.client.gui.layouts.GridLayout
 *  net.minecraft.client.gui.layouts.LayoutElement
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.gui.screens.ShareToLanScreen
 *  net.minecraft.client.gui.screens.achievement.StatsScreen
 *  net.minecraft.client.gui.screens.advancements.AdvancementsScreen
 *  net.minecraft.client.gui.screens.multiplayer.ServerLinksScreen
 *  net.minecraft.client.gui.screens.options.OptionsScreen
 *  net.minecraft.client.gui.screens.social.SocialInteractionsScreen
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.sounds.SimpleSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.CommonComponents
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.ServerLinks
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.lang.invoke.LambdaMetafactory;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.layouts.FrameLayout;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.ShareToLanScreen;
import net.minecraft.client.gui.screens.achievement.StatsScreen;
import net.minecraft.client.gui.screens.advancements.AdvancementsScreen;
import net.minecraft.client.gui.screens.multiplayer.ServerLinksScreen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.client.gui.screens.social.SocialInteractionsScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.ServerLinks;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.client.gui.FakeExitButton;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0007J\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0016J(\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001a\u0010,\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001a\u0010/\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104\u00a8\u0006?"}, d2={"Lnet/thebrokenscript/client/gui/FakePauseScreen;", "Lnet/minecraft/client/gui/screens/Screen;", "<init>", "()V", "showPauseMenu", "", "disconnectButton", "Lnet/minecraft/client/gui/components/Button;", "fakeExitButton", "Lnet/thebrokenscript/client/gui/FakeExitButton;", "renderablesFixMaybe", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "init", "", "isPauseScreen", "createPauseMenu", "startBreakAnim", "widget", "openScreenButton", "message", "Lnet/minecraft/network/chat/Component;", "screenSupplier", "Ljava/util/function/Supplier;", "glitchTitle", "", "rand", "Ljava/util/Random;", "tick", "rot", "", "getRot", "()F", "setRot", "(F)V", "sclX", "getSclX", "setSclX", "sclY", "getSclY", "setSclY", "ofsX", "getOfsX", "setOfsX", "ofsY", "getOfsY", "setOfsY", "col", "", "getCol", "()I", "setCol", "(I)V", "redGlitchFrames", "getRedGlitchFrames", "setRedGlitchFrames", "render", "cx", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTick", "Companion", "thebrokenscript-common"})
public final class FakePauseScreen
extends Screen {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean showPauseMenu;
    @Nullable
    private Button disconnectButton;
    @NotNull
    private FakeExitButton fakeExitButton = new FakeExitButton();
    private Field renderablesFixMaybe;
    @NotNull
    private String glitchTitle;
    @NotNull
    private final Random rand;
    private float rot;
    private float sclX;
    private float sclY;
    private float ofsX;
    private float ofsY;
    private int col;
    private int redGlitchFrames;
    @NotNull
    private static final Component RETURN_TO_GAME;
    @NotNull
    private static final Component ADVANCEMENTS;
    @NotNull
    private static final Component STATS;
    @NotNull
    private static final Component SERVER_LINKS;
    @NotNull
    private static final Component OPTIONS;
    @NotNull
    private static final Component SHARE_TO_LAN;
    @NotNull
    private static final Component PLAYER_REPORTING;
    @NotNull
    private static final Component RETURN_TO_MENU;
    @NotNull
    private static final String BASE_TITLE = "Paused";

    /*
     * WARNING - void declaration
     */
    public FakePauseScreen() {
        super((Component)Component.literal((String)""));
        void $this$renderablesFixMaybe_u24lambda_u240;
        Field field;
        Field field2 = field = Screen.class.getDeclaredField("renderables");
        FakePauseScreen fakePauseScreen = this;
        boolean bl = false;
        $this$renderablesFixMaybe_u24lambda_u240.setAccessible(true);
        fakePauseScreen.renderablesFixMaybe = field;
        this.glitchTitle = BASE_TITLE;
        this.rand = new Random();
        this.sclX = 1.0f;
        this.sclY = 1.0f;
        this.col = 0xFFFFFF;
    }

    protected void init() {
        this.createPauseMenu();
    }

    public boolean isPauseScreen() {
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private final void createPauseMenu() {
        v0 = this.minecraft;
        Intrinsics.checkNotNull((Object)v0);
        mc = v0;
        layout = new GridLayout();
        layout.defaultCellSetting().padding(4, 4, 4, 0);
        row = layout.createRowHelper(2);
        row.addChild((LayoutElement)Button.builder((Component)FakePauseScreen.RETURN_TO_GAME, (Button.OnPress)(Button.OnPress)LambdaMetafactory.metafactory(null, null, null, (Lnet/minecraft/client/gui/components/Button;)V, createPauseMenu$lambda$0(net.minecraft.client.Minecraft net.minecraft.client.gui.components.Button ), (Lnet/minecraft/client/gui/components/Button;)V)((Minecraft)mc)).width(204).build(), 2, layout.newCellSettings().paddingTop(50));
        row.addChild((LayoutElement)this.openScreenButton(FakePauseScreen.ADVANCEMENTS, (Supplier<Screen>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, createPauseMenu$lambda$1(net.minecraft.client.Minecraft net.thebrokenscript.client.gui.FakePauseScreen ), ()Lnet/minecraft/client/gui/screens/Screen;)((Minecraft)mc, (FakePauseScreen)this)));
        row.addChild((LayoutElement)this.openScreenButton(FakePauseScreen.STATS, (Supplier<Screen>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, createPauseMenu$lambda$2(net.thebrokenscript.client.gui.FakePauseScreen net.minecraft.client.Minecraft ), ()Lnet/minecraft/client/gui/screens/Screen;)((FakePauseScreen)this, (Minecraft)mc)));
        v1 = mc.player;
        Intrinsics.checkNotNull((Object)v1);
        links = v1.connection.serverLinks();
        if (!links.isEmpty()) {
            row.addChild((LayoutElement)this.openScreenButton(FakePauseScreen.SERVER_LINKS, (Supplier<Screen>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, createPauseMenu$lambda$3(net.thebrokenscript.client.gui.FakePauseScreen net.minecraft.server.ServerLinks ), ()Lnet/minecraft/client/gui/screens/Screen;)((FakePauseScreen)this, (ServerLinks)links)));
        }
        row.addChild((LayoutElement)this.openScreenButton(FakePauseScreen.OPTIONS, (Supplier<Screen>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, createPauseMenu$lambda$4(net.thebrokenscript.client.gui.FakePauseScreen net.minecraft.client.Minecraft ), ()Lnet/minecraft/client/gui/screens/Screen;)((FakePauseScreen)this, (Minecraft)mc)));
        if (!mc.hasSingleplayerServer()) ** GOTO lbl-1000
        v2 = mc.getSingleplayerServer();
        Intrinsics.checkNotNull((Object)v2);
        if (!v2.isPublished()) {
            v3 = (Button)row.addChild((LayoutElement)this.openScreenButton(FakePauseScreen.SHARE_TO_LAN, (Supplier<Screen>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, createPauseMenu$lambda$5(net.thebrokenscript.client.gui.FakePauseScreen ), ()Lnet/minecraft/client/gui/screens/Screen;)((FakePauseScreen)this)));
        } else lbl-1000:
        // 2 sources

        {
            v3 = (Button)row.addChild((LayoutElement)this.openScreenButton(FakePauseScreen.PLAYER_REPORTING, (Supplier<Screen>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, createPauseMenu$lambda$6(net.thebrokenscript.client.gui.FakePauseScreen ), ()Lnet/minecraft/client/gui/screens/Screen;)((FakePauseScreen)this)));
        }
        row.addChild((LayoutElement)Button.builder((Component)((Component)Component.translatable((String)"fml.menu.mods")), (Button.OnPress)(Button.OnPress)LambdaMetafactory.metafactory(null, null, null, (Lnet/minecraft/client/gui/components/Button;)V, createPauseMenu$lambda$7(net.minecraft.client.gui.components.Button ), (Lnet/minecraft/client/gui/components/Button;)V)()).width(204).build(), 2);
        component = mc.isLocalServer() != false ? FakePauseScreen.RETURN_TO_MENU : CommonComponents.GUI_DISCONNECT;
        v4 = row.addChild((LayoutElement)Button.builder((Component)component, (Button.OnPress)(Button.OnPress)LambdaMetafactory.metafactory(null, null, null, (Lnet/minecraft/client/gui/components/Button;)V, createPauseMenu$lambda$8(net.thebrokenscript.client.gui.FakePauseScreen net.minecraft.client.gui.components.Button ), (Lnet/minecraft/client/gui/components/Button;)V)((FakePauseScreen)this)).width(204).build(), 2);
        Intrinsics.checkNotNull((Object)v4, (String)"null cannot be cast to non-null type net.minecraft.client.gui.components.Button");
        this.disconnectButton = (Button)v4;
        layout.arrangeElements();
        FrameLayout.alignInRectangle((LayoutElement)((LayoutElement)layout), (int)0, (int)0, (int)this.width, (int)this.height, (float)0.5f, (float)0.25f);
        layout.visitWidgets((Consumer<AbstractWidget>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, createPauseMenu$lambda$9(net.thebrokenscript.client.gui.FakePauseScreen net.minecraft.client.gui.components.AbstractWidget ), (Lnet/minecraft/client/gui/components/AbstractWidget;)V)((FakePauseScreen)this));
    }

    public final void startBreakAnim(@NotNull Button widget) {
        Intrinsics.checkNotNullParameter((Object)widget, (String)"widget");
        widget.visible = false;
        widget.active = false;
        this.fakeExitButton.setStarted(true);
        ClientDSLKt.getMC().getSoundManager().play((SoundInstance)SimpleSoundInstance.forUI((Holder)((Holder)TBSSounds.QUIT_BUTTON_BREAK), (float)1.0f));
    }

    private final Button openScreenButton(Component message, Supplier<Screen> screenSupplier) {
        Button button = Button.builder((Component)message, arg_0 -> FakePauseScreen.openScreenButton$lambda$0(this, screenSupplier, arg_0)).width(98).build();
        Intrinsics.checkNotNullExpressionValue((Object)button, (String)"build(...)");
        return button;
    }

    public void tick() {
        char glitchChar;
        super.tick();
        char[] cArray = BASE_TITLE.toCharArray();
        Intrinsics.checkNotNullExpressionValue((Object)cArray, (String)"toCharArray(...)");
        char[] chars = cArray;
        int idx = this.rand.nextInt(chars.length);
        chars[idx] = glitchChar = (char)(33 + this.rand.nextInt(94));
        this.glitchTitle = new String(chars);
    }

    public final float getRot() {
        return this.rot;
    }

    public final void setRot(float f) {
        this.rot = f;
    }

    public final float getSclX() {
        return this.sclX;
    }

    public final void setSclX(float f) {
        this.sclX = f;
    }

    public final float getSclY() {
        return this.sclY;
    }

    public final void setSclY(float f) {
        this.sclY = f;
    }

    public final float getOfsX() {
        return this.ofsX;
    }

    public final void setOfsX(float f) {
        this.ofsX = f;
    }

    public final float getOfsY() {
        return this.ofsY;
    }

    public final void setOfsY(float f) {
        this.ofsY = f;
    }

    public final int getCol() {
        return this.col;
    }

    public final void setCol(int n) {
        this.col = n;
    }

    public final int getRedGlitchFrames() {
        return this.redGlitchFrames;
    }

    public final void setRedGlitchFrames(int n) {
        this.redGlitchFrames = n;
    }

    public void render(@NotNull GuiGraphics cx, int mouseX, int mouseY, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        super.renderBackground(cx, mouseX, mouseY, partialTick);
        if (this.fakeExitButton.getStarted()) {
            Button button = this.disconnectButton;
            Intrinsics.checkNotNull((Object)button);
            int n = button.getX();
            Button button2 = this.disconnectButton;
            Intrinsics.checkNotNull((Object)button2);
            this.fakeExitButton.render(cx, n, button2.getY());
        }
        Object object = this.renderablesFixMaybe.get((Object)this);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type kotlin.collections.List<net.minecraft.client.gui.components.Renderable>");
        List renderables = (List)object;
        for (Renderable widget : renderables) {
            if (!(widget instanceof Button)) continue;
            int dx = this.rand.nextInt(2) - 3;
            int dy = this.rand.nextInt(2) - 3;
            cx.pose().pushPose();
            cx.pose().translate((float)dx, (float)dy, 0.0f);
            ((Button)widget).render(cx, mouseX - dx, mouseY - dy, partialTick);
            cx.pose().popPose();
        }
        if (this.redGlitchFrames <= 0) {
            this.rot = 0.0f;
            this.sclX = 1.0f;
            this.sclY = 1.0f;
            this.ofsX = 0.0f;
            this.col = 0xFFFFFF;
            this.ofsY = 0.0f;
        }
        if (Math.random() < 0.025 && this.redGlitchFrames <= 0) {
            this.col = 0xFF0000;
            this.ofsX = this.rand.nextFloat(-4.0f, 4.0f);
            this.ofsY = this.rand.nextFloat(-4.0f, 4.0f);
            this.rot = this.rand.nextFloat(-0.5f, 0.5f);
            this.sclX = this.rand.nextFloat(0.6f, 1.2f);
            this.sclY = this.rand.nextFloat(0.6f, 1.2f);
            this.redGlitchFrames = this.rand.nextInt(1, 5);
        } else {
            --this.redGlitchFrames;
        }
        PoseStack ps = cx.pose();
        ps.pushPose();
        ps.translate(this.ofsX, this.ofsY, 0.0f);
        ps.translate((double)(this.width / 2), (double)(this.height / 4 - 10), 0.0);
        ps.mulPose(Axis.ZP.rotation(this.rot));
        ps.scale(this.sclX, this.sclY, 1.0f);
        ps.translate(-((double)(this.width / 2)), -((double)(this.height / 4 - 10)), 0.0);
        cx.drawCenteredString(this.font, this.glitchTitle, this.width / 2, this.height / 4 - 10, this.col);
        ps.popPose();
    }

    private static final void createPauseMenu$lambda$0(Minecraft $mc, Button it) {
        $mc.setScreen(null);
        $mc.mouseHandler.grabMouse();
    }

    private static final Screen createPauseMenu$lambda$1(Minecraft $mc, FakePauseScreen this$0) {
        LocalPlayer localPlayer = $mc.player;
        Intrinsics.checkNotNull((Object)localPlayer);
        return (Screen)new AdvancementsScreen(localPlayer.connection.getAdvancements(), (Screen)this$0);
    }

    private static final Screen createPauseMenu$lambda$2(FakePauseScreen this$0, Minecraft $mc) {
        Screen screen = this$0;
        LocalPlayer localPlayer = $mc.player;
        Intrinsics.checkNotNull((Object)localPlayer);
        return (Screen)new StatsScreen(screen, localPlayer.getStats());
    }

    private static final Screen createPauseMenu$lambda$3(FakePauseScreen this$0, ServerLinks $links) {
        return (Screen)new ServerLinksScreen((Screen)this$0, $links);
    }

    private static final Screen createPauseMenu$lambda$4(FakePauseScreen this$0, Minecraft $mc) {
        return (Screen)new OptionsScreen((Screen)this$0, $mc.options);
    }

    private static final Screen createPauseMenu$lambda$5(FakePauseScreen this$0) {
        return (Screen)new ShareToLanScreen((Screen)this$0);
    }

    private static final Screen createPauseMenu$lambda$6(FakePauseScreen this$0) {
        return (Screen)new SocialInteractionsScreen((Screen)this$0);
    }

    private static final void createPauseMenu$lambda$7(Button it) {
    }

    private static final void createPauseMenu$lambda$8(FakePauseScreen this$0, Button it) {
        Intrinsics.checkNotNull((Object)it);
        this$0.startBreakAnim(it);
    }

    private static final void createPauseMenu$lambda$9(FakePauseScreen this$0, AbstractWidget it) {
        this$0.addRenderableWidget((GuiEventListener)it);
    }

    private static final void openScreenButton$lambda$0(FakePauseScreen this$0, Supplier $screenSupplier, Button it) {
        block0: {
            Minecraft minecraft = this$0.minecraft;
            if (minecraft == null) break block0;
            minecraft.setScreen((Screen)$screenSupplier.get());
        }
    }

    static {
        MutableComponent mutableComponent = Component.translatable((String)"menu.returnToGame");
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
        RETURN_TO_GAME = (Component)mutableComponent;
        MutableComponent mutableComponent2 = Component.translatable((String)"gui.advancements");
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"translatable(...)");
        ADVANCEMENTS = (Component)mutableComponent2;
        MutableComponent mutableComponent3 = Component.translatable((String)"gui.stats");
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"translatable(...)");
        STATS = (Component)mutableComponent3;
        MutableComponent mutableComponent4 = Component.translatable((String)"menu.server_links");
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent4, (String)"translatable(...)");
        SERVER_LINKS = (Component)mutableComponent4;
        MutableComponent mutableComponent5 = Component.translatable((String)"menu.options");
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"translatable(...)");
        OPTIONS = (Component)mutableComponent5;
        MutableComponent mutableComponent6 = Component.translatable((String)"menu.shareToLan");
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"translatable(...)");
        SHARE_TO_LAN = (Component)mutableComponent6;
        MutableComponent mutableComponent7 = Component.translatable((String)"menu.playerReporting");
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"translatable(...)");
        PLAYER_REPORTING = (Component)mutableComponent7;
        MutableComponent mutableComponent8 = Component.translatable((String)"menu.returnToMenu");
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent8, (String)"translatable(...)");
        RETURN_TO_MENU = (Component)mutableComponent8;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/client/gui/FakePauseScreen$Companion;", "", "<init>", "()V", "RETURN_TO_GAME", "Lnet/minecraft/network/chat/Component;", "ADVANCEMENTS", "STATS", "SERVER_LINKS", "OPTIONS", "SHARE_TO_LAN", "PLAYER_REPORTING", "RETURN_TO_MENU", "BASE_TITLE", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

