/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.mojang.blaze3d.Blaze3D
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.Button
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.gui.screens.TitleScreen
 *  net.minecraft.network.chat.Component
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  org.apache.commons.io.IOUtils
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.gui;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.blaze3d.Blaze3D;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.client.gui.StartupScreen;
import net.thebrokenscript.client.gui.WarningScreen;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSLang;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0014J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0006\u0010\u001c\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/client/gui/TesterBuildScreen;", "Lnet/thebrokenscript/client/gui/StartupScreen;", "<init>", "()V", "leOtherButton", "Lnet/minecraft/client/gui/components/Button;", "setShowAgain", "", "value", "", "wasAbleToAccessJson", "getWasAbleToAccessJson", "()Z", "setWasAbleToAccessJson", "(Z)V", "afterClose", "init", "render", "cx", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "delta", "", "mouseClicked", "", "button", "checkForDRM", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTesterBuildScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TesterBuildScreen.kt\nnet/thebrokenscript/client/gui/TesterBuildScreen\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,111:1\n15#2:112\n*S KotlinDebug\n*F\n+ 1 TesterBuildScreen.kt\nnet/thebrokenscript/client/gui/TesterBuildScreen\n*L\n47#1:112\n*E\n"})
public final class TesterBuildScreen
extends StartupScreen {
    private Button leOtherButton;
    private boolean wasAbleToAccessJson;

    public TesterBuildScreen() {
        super((Component)TBSLang.INSTANCE.getTESTER_TITLE());
    }

    @Override
    public void setShowAgain(boolean value) {
    }

    public final boolean getWasAbleToAccessJson() {
        return this.wasAbleToAccessJson;
    }

    public final void setWasAbleToAccessJson(boolean bl) {
        this.wasAbleToAccessJson = bl;
    }

    @Override
    public void afterClose() {
        block4: {
            block3: {
                if (PlatformUtil.Companion.isProduction()) {
                    if (!this.checkForDRM()) {
                        TheBrokenScript.LOGGER.info("{}, {}", (Object)Minecraft.getInstance().getUser().getProfileId(), (Object)this.wasAbleToAccessJson);
                        Blaze3D.youJustLostTheGame();
                    } else {
                        TheBrokenScript.LOGGER.info("{}, {}", (Object)Minecraft.getInstance().getUser().getProfileId(), (Object)this.wasAbleToAccessJson);
                    }
                }
                if (!TBSConfigs.INSTANCE.getClient().getAccessibility().getShowPhotosensitivityWarning()) break block3;
                Minecraft minecraft = this.minecraft;
                if (minecraft == null) break block4;
                minecraft.setScreen((Screen)new WarningScreen());
                break block4;
            }
            Minecraft minecraft = this.minecraft;
            if (minecraft == null) break block4;
            minecraft.setScreen((Screen)new TitleScreen());
        }
    }

    @Override
    protected void init() {
        String $this$c$iv = "I understand";
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        GuiEventListener guiEventListener = this.addRenderableWidget((GuiEventListener)Button.builder((Component)component, arg_0 -> TesterBuildScreen.init$lambda$0(this, arg_0)).bounds((this.width - 200) / 2, this.height / 2 + 75, 200, 20).build());
        Intrinsics.checkNotNullExpressionValue((Object)guiEventListener, (String)"addRenderableWidget(...)");
        this.leOtherButton = (Button)guiEventListener;
    }

    public void render(@NotNull GuiGraphics cx, int mouseX, int mouseY, float delta) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        this.renderBackground(cx, mouseX, mouseY, delta);
        super.render(cx, mouseX, mouseY, delta);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getTESTER_TITLE(), this.width / 2, this.height / 2 - 60, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getTESTER_LINE_1(), this.width / 2, this.height / 2 - 40, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getTESTER_LINE_2(), this.width / 2, this.height / 2 - 30, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getTESTER_LINE_3(), this.width / 2, this.height / 2 - 20, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getTESTER_LINE_4(), this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getTESTER_LINE_5(), this.width / 2, this.height / 2, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getTESTER_LINE_6(), this.width / 2, this.height / 2 + 10, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getTESTER_LINE_7(), this.width / 2, this.height / 2 + 20, 0xFFFFFF);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        Button button2 = this.leOtherButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"leOtherButton");
            button2 = null;
        }
        if (button2.mouseClicked(mouseX, mouseY, button)) {
            this.afterClose();
            return true;
        }
        return false;
    }

    public final boolean checkForDRM() {
        String raw = null;
        boolean isAuthorized = false;
        try {
            String string = IOUtils.toString((URI)URI.create("https://git.thebrokenscript.net/Writers-of-the-Script/Meta/raw/branch/main/capes.json"), (Charset)StandardCharsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
            raw = string;
            this.wasAbleToAccessJson = true;
        }
        catch (IOException iOException) {
            this.wasAbleToAccessJson = false;
            return false;
        }
        JsonArray uuids = JsonParser.parseString((String)raw).getAsJsonArray();
        boolean matches = false;
        Iterator iterator = uuids.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"iterator(...)");
        Iterator iterator2 = iterator;
        while (iterator2.hasNext()) {
            UUID playerUUID;
            JsonElement item = (JsonElement)iterator2.next();
            JsonObject obj = item.getAsJsonObject();
            UUID uuid = UUID.fromString(obj.get("uuid").getAsString());
            if (Minecraft.getInstance().getUser().getProfileId() == null) {
                return false;
            }
            matches = false;
            if (!Intrinsics.areEqual((Object)uuid, (Object)playerUUID)) continue;
            isAuthorized = true;
            matches = true;
        }
        return isAuthorized;
    }

    private static final void init$lambda$0(TesterBuildScreen this$0, Button it) {
        block0: {
            Minecraft minecraft = this$0.minecraft;
            if (minecraft == null) break block0;
            minecraft.setScreen((Screen)new TitleScreen());
        }
    }
}

