/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.Camera
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.sounds.SoundEvent
 *  net.thebrokenscript.brokencore.api.client.util.WindowExtKt
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.ext.PoseStackExt
 *  net.thebrokenscript.brokencore.api.ext.miximpl.CameraExtImplKt
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.client.util.WindowExtKt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.PoseStackExt;
import net.thebrokenscript.brokencore.api.ext.miximpl.CameraExtImplKt;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.misc.CreditClassesKt;
import net.thebrokenscript.misc.CreditInfo;
import net.thebrokenscript.misc.Credits;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020!H\u0016J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J \u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J(\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020!H\u0016J\b\u00101\u001a\u00020$H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0007\u00a8\u00063"}, d2={"Lnet/thebrokenscript/client/gui/CreditsGui;", "Lnet/minecraft/client/gui/screens/Screen;", "<init>", "()V", "yOffset", "", "getYOffset", "()F", "setYOffset", "(F)V", "speed", "getSpeed", "setSpeed", "credits", "Lnet/thebrokenscript/misc/Credits;", "getCredits", "()Lnet/thebrokenscript/misc/Credits;", "lines", "", "Lkotlin/Pair;", "Lnet/minecraft/network/chat/Component;", "Lnet/thebrokenscript/misc/CreditInfo;", "getLines", "()Ljava/util/List;", "sound", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "getSound", "()Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "setSound", "(Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;)V", "defaultSpeed", "getDefaultSpeed", "init", "", "onClose", "keyPressed", "", "keyCode", "", "scanCode", "modifiers", "keyReleased", "render", "cx", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "delta", "tick", "shouldCloseOnEsc", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCreditsGui.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreditsGui.kt\nnet/thebrokenscript/client/gui/CreditsGui\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n15#2:139\n1#3:140\n1374#4:141\n1460#4,2:142\n1563#4:144\n1634#4,3:145\n1462#4,3:148\n*S KotlinDebug\n*F\n+ 1 CreditsGui.kt\nnet/thebrokenscript/client/gui/CreditsGui\n*L\n22#1:139\n39#1:141\n39#1:142,2\n39#1:144\n39#1:145,3\n39#1:148,3\n*E\n"})
public final class CreditsGui
extends Screen {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private float yOffset;
    private float speed;
    @NotNull
    private final Credits credits;
    @NotNull
    private final List<Pair<Component, CreditInfo>> lines;
    @Nullable
    private FancySoundInstance sound;
    public static final int BASE_Y = 140;
    public static final int Y_OFFS = 10;
    public static final float DEFAULT_SPEED = 19.0f;
    public static final float SHIFT_SPEED = 38.0f;
    public static final float CTRL_SPEED = 76.0f;

    /*
     * WARNING - void declaration
     */
    public CreditsGui() {
        void $this$flatMapTo$iv$iv;
        void $this$flatMap$iv;
        String string;
        void $this$credits_u24lambda_u240;
        Object $this$c$iv = "Credits";
        boolean $i$f$getC22 = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        super(component);
        this.speed = this.getDefaultSpeed();
        BufferedReader $i$f$getC22 = ClientDSLKt.getMC().getResourceManager().getResourceOrThrow(TBSConstants.id("credits.json")).openAsReader();
        CreditsGui creditsGui = this;
        boolean $i$a$-run-CreditsGui$credits$22 = false;
        Intrinsics.checkNotNull((Object)$this$credits_u24lambda_u240);
        String it = string = TextStreamsKt.readText((Reader)((Reader)$this$credits_u24lambda_u240));
        boolean bl = false;
        $this$credits_u24lambda_u240.close();
        creditsGui.credits = CreditClassesKt.loadCredits(string);
        $this$c$iv = this.credits.getCredits();
        creditsGui = this;
        boolean $i$f$flatMap = false;
        void $i$a$-run-CreditsGui$credits$22 = $this$flatMap$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$flatMapTo = false;
        for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
            void $this$mapTo$iv$iv;
            CreditInfo it2 = (CreditInfo)element$iv$iv;
            boolean bl2 = false;
            Iterable $this$map$iv = it2.render();
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void t;
                Component component2 = (Component)item$iv$iv;
                Collection collection = destination$iv$iv2;
                boolean bl3 = false;
                collection.add(TuplesKt.to((Object)t, (Object)it2));
            }
            Iterable list$iv$iv = (List)destination$iv$iv2;
            CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
        }
        creditsGui.lines = (List)destination$iv$iv;
    }

    public final float getYOffset() {
        return this.yOffset;
    }

    public final void setYOffset(float f) {
        this.yOffset = f;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final void setSpeed(float f) {
        this.speed = f;
    }

    @NotNull
    public final Credits getCredits() {
        return this.credits;
    }

    @NotNull
    public final List<Pair<Component, CreditInfo>> getLines() {
        return this.lines;
    }

    @Nullable
    public final FancySoundInstance getSound() {
        return this.sound;
    }

    public final void setSound(@Nullable FancySoundInstance fancySoundInstance) {
        this.sound = fancySoundInstance;
    }

    public final float getDefaultSpeed() {
        return WindowExtKt.getWindow().getGuiScale() > 3.0 ? 33.0f : 19.0f;
    }

    protected void init() {
        super.init();
        if (this.sound != null) {
            return;
        }
        this.yOffset = (float)this.height / 2.0f;
        this.sound = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.CREDITS.get()), null, (float)0.0f, (float)0.0f, (boolean)false, null, (int)62, null);
    }

    public void onClose() {
        super.onClose();
        FancySoundInstance fancySoundInstance = this.sound;
        if (fancySoundInstance != null) {
            FancySoundInstance fancySoundInstance2 = fancySoundInstance;
            FancyAudio fancyAudio = FancyAudio.INSTANCE;
            FancySoundInstance p0 = fancySoundInstance2;
            boolean bl = false;
            fancyAudio.stop(p0);
        }
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides((Camera)camera).setActive(false);
        Camera camera2 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera2, (String)"getMainCamera(...)");
        CameraExtImplKt.updateOverrides((Camera)camera2);
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (Intrinsics.areEqual((Object)(localPlayer != null && (localPlayer = localPlayer.level()) != null ? localPlayer.dimension() : null), TBSDimensions.STAGE3)) {
            PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.PLAYER_TP_FROM_BOSS, new CustomPacketPayload[0]);
        }
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        block4: {
            switch (keyCode) {
                case 340: {
                    this.speed = Math.max(this.speed, 38.0f);
                    break;
                }
                case 341: {
                    this.speed = Math.max(this.speed, 76.0f);
                }
            }
            FancySoundInstance fancySoundInstance = this.sound;
            if (fancySoundInstance == null) break block4;
            fancySoundInstance.setPitch(this.speed / 19.0f);
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        block3: {
            if (keyCode == 340 && this.speed == 38.0f) {
                this.speed = this.getDefaultSpeed();
            } else if (keyCode == 341 && this.speed == 76.0f) {
                this.speed = this.getDefaultSpeed();
            }
            FancySoundInstance fancySoundInstance = this.sound;
            if (fancySoundInstance == null) break block3;
            fancySoundInstance.setPitch(this.speed / 19.0f);
        }
        return super.keyReleased(keyCode, scanCode, modifiers);
    }

    public void render(@NotNull GuiGraphics cx, int mouseX, int mouseY, float delta) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        this.renderBackground(cx, mouseX, mouseY, delta);
        super.render(cx, mouseX, mouseY, delta);
        if (!(this.speed == this.getDefaultSpeed() || this.speed == 38.0f || this.speed == 76.0f)) {
            this.speed = this.getDefaultSpeed();
        }
        float start = -10.0f + (float)this.font.lineHeight;
        int rendered = 0;
        Iterator iterator = ((Iterable)this.lines).iterator();
        int n = 0;
        while (iterator.hasNext()) {
            int i = n++;
            Pair item = (Pair)iterator.next();
            Component line = (Component)item.component1();
            CreditInfo info = (CreditInfo)item.component2();
            float height = (float)this.font.lineHeight * info.scale();
            int baseY = WindowExtKt.getWindow().getGuiScale() > 3.0 ? 20 : 140;
            float y = (start += (float)10 + height + (float)info.spacing()) + (float)baseY - (float)(i == 0 ? info.spacing() : 0) + this.yOffset;
            if (y + height < 0.0f || y > (float)this.height) continue;
            cx.pose().pushPose();
            cx.pose().setIdentity();
            cx.pose().translate((float)this.width / 2.0f, y, 0.0f);
            PoseStack poseStack = cx.pose();
            Intrinsics.checkNotNullExpressionValue((Object)poseStack, (String)"pose(...)");
            PoseStackExt.INSTANCE.scale(poseStack, (Number)Float.valueOf(info.scale()));
            cx.drawCenteredString(this.font, line, 0, 0, 0xFFFFFF);
            cx.pose().popPose();
            ++rendered;
        }
        if (rendered == 0) {
            Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
            Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
            CameraExtImplKt.getOverrides((Camera)camera).setActive(false);
            Camera camera2 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
            Intrinsics.checkNotNullExpressionValue((Object)camera2, (String)"getMainCamera(...)");
            CameraExtImplKt.updateOverrides((Camera)camera2);
            FancySoundInstance fancySoundInstance = this.sound;
            if (fancySoundInstance != null) {
                FancySoundInstance fancySoundInstance2 = fancySoundInstance;
                FancyAudio fancyAudio = FancyAudio.INSTANCE;
                FancySoundInstance p0 = fancySoundInstance2;
                boolean bl = false;
                fancyAudio.stop(p0);
            }
            ClientDSLKt.getMC().setScreen(null);
        }
    }

    public void tick() {
        super.tick();
        this.yOffset -= this.speed * 0.05f;
    }

    public boolean shouldCloseOnEsc() {
        return true;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/client/gui/CreditsGui$Companion;", "", "<init>", "()V", "BASE_Y", "", "Y_OFFS", "DEFAULT_SPEED", "", "SHIFT_SPEED", "CTRL_SPEED", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

