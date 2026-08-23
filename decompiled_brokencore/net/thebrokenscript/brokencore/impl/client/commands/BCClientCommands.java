/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.commands.SharedSuggestionProvider
 *  net.minecraft.commands.arguments.coordinates.RotationArgument
 *  net.minecraft.commands.arguments.coordinates.Vec3Argument
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.impl.client.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.coordinates.RotationArgument;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.client.cutscene.CameraOverrides;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.miximpl.CameraExtImplKt;
import net.thebrokenscript.brokencore.api.util.math.Transform;
import net.thebrokenscript.brokencore.impl.client.commands.ClientInspectCommands;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/impl/client/commands/BCClientCommands;", "", "<init>", "()V", "register", "", "S", "Lnet/minecraft/commands/SharedSuggestionProvider;", "dispatcher", "Lcom/mojang/brigadier/CommandDispatcher;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBCClientCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BCClientCommands.kt\nnet/thebrokenscript/brokencore/impl/client/commands/BCClientCommands\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,77:1\n70#2:78\n15#2:79\n47#2:80\n29#2:81\n24#2:82\n70#2:83\n15#2:84\n47#2:85\n29#2:86\n24#2:87\n70#2:88\n15#2:89\n47#2:90\n29#2:91\n24#2:92\n70#2:93\n15#2:94\n47#2:95\n29#2:96\n24#2:97\n70#2:98\n15#2:99\n47#2:100\n29#2:101\n24#2:102\n*S KotlinDebug\n*F\n+ 1 BCClientCommands.kt\nnet/thebrokenscript/brokencore/impl/client/commands/BCClientCommands\n*L\n27#1:78\n27#1:79\n27#1:80\n27#1:81\n27#1:82\n34#1:83\n34#1:84\n34#1:85\n34#1:86\n34#1:87\n46#1:88\n46#1:89\n46#1:90\n46#1:91\n46#1:92\n57#1:93\n57#1:94\n57#1:95\n57#1:96\n57#1:97\n69#1:98\n69#1:99\n69#1:100\n69#1:101\n69#1:102\n*E\n"})
public final class BCClientCommands {
    @NotNull
    public static final BCClientCommands INSTANCE = new BCClientCommands();

    private BCClientCommands() {
    }

    public final <S extends SharedSuggestionProvider> void register(@NotNull CommandDispatcher<S> dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
        new CommandDSL(dispatcher, null, BCClientCommands::register$lambda$0, 2, null);
    }

    private static final void register$lambda$0(CommandDSL $this$CommandDSL) {
        Intrinsics.checkNotNullParameter((Object)$this$CommandDSL, (String)"$this$CommandDSL");
        $this$CommandDSL.group("bcc", BCClientCommands::register$lambda$0$0);
    }

    private static final void register$lambda$0$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ClientInspectCommands.INSTANCE.addClientInspectCommands($this$group);
        $this$group.group("camera", BCClientCommands::register$lambda$0$0$0);
    }

    private static final void register$lambda$0$0$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("on", BCClientCommands::register$lambda$0$0$0$0);
        $this$group.add("off", BCClientCommands::register$lambda$0$0$0$1);
        $this$group.add("toggle", BCClientCommands::register$lambda$0$0$0$2);
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)Vec3Argument.vec3(), (String)"vec3(...)");
        $this$group.add("position [pos]", argumentTypeArray, BCClientCommands::register$lambda$0$0$0$3);
        argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)RotationArgument.rotation(), (String)"rotation(...)");
        $this$group.add("rotation [rot]", argumentTypeArray, BCClientCommands::register$lambda$0$0$0$4);
    }

    /*
     * WARNING - void declaration
     */
    private static final int register$lambda$0$0$0$0(CommandContext it) {
        void $this$with$iv$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides(camera).setActive(true);
        Minecraft minecraft = ClientDSLKt.getMC();
        String $this$green$iv = "Turned camera override on!";
        boolean $i$f$getGreen = false;
        String $this$c$iv$iv = $this$green$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$green$iv$iv = component;
        boolean $i$f$getGreen2 = false;
        Component component2 = $this$green$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        ClientDSLKt.chat(minecraft, (Component)mutableComponent3);
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int register$lambda$0$0$0$1(CommandContext it) {
        void $this$with$iv$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides(camera).setActive(false);
        Minecraft minecraft = ClientDSLKt.getMC();
        String $this$green$iv = "Turned camera override off!";
        boolean $i$f$getGreen = false;
        String $this$c$iv$iv = $this$green$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Component $this$green$iv$iv = component;
        boolean $i$f$getGreen2 = false;
        Component component2 = $this$green$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        ClientDSLKt.chat(minecraft, (Component)mutableComponent3);
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int register$lambda$0$0$0$2(CommandContext it) {
        void $this$with$iv$iv$iv;
        void $this$green$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraOverrides ov = CameraExtImplKt.getOverrides(camera);
        ov.setActive(!ov.getActive());
        String status = ov.getActive() ? "on" : "off";
        Minecraft minecraft = ClientDSLKt.getMC();
        String $this$green$iv = "Toggled camera override to " + status + "!";
        boolean $i$f$getGreen = false;
        String $this$c$iv$iv = $this$green$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGreen2 = false;
        void var7_7 = $this$green$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        ClientDSLKt.chat(minecraft, (Component)mutableComponent3);
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int register$lambda$0$0$0$3(CommandContext it) {
        void $this$with$iv$iv$iv;
        void $this$green$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        CommandContext cx = it;
        Vec3 pos = Vec3Argument.getVec3((CommandContext)cx, (String)"pos");
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        Transform transform2 = CameraExtImplKt.getOverrides(camera).getTransform();
        Vector3f vector3f = pos.toVector3f();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"toVector3f(...)");
        transform2.setPosition(vector3f);
        Camera camera2 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera2, (String)"getMainCamera(...)");
        CameraExtImplKt.updateOverrides(camera2);
        Minecraft minecraft = ClientDSLKt.getMC();
        String $this$green$iv = "Set camera position to " + pos + "!";
        boolean $i$f$getGreen = false;
        String $this$c$iv$iv = $this$green$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGreen2 = false;
        void var7_7 = $this$green$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        ClientDSLKt.chat(minecraft, (Component)mutableComponent3);
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static final int register$lambda$0$0$0$4(CommandContext it) {
        void $this$with$iv$iv$iv;
        void $this$green$iv$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        CommandContext cx = it;
        Vec2 rot = RotationArgument.getRotation((CommandContext)cx, (String)"rot").getRotation((CommandSourceStack)cx.getSource());
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides(camera).getTransform().getRotation().setPitch(rot.x);
        Camera camera2 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera2, (String)"getMainCamera(...)");
        CameraExtImplKt.getOverrides(camera2).getTransform().getRotation().setYaw(rot.y);
        Camera camera3 = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera3, (String)"getMainCamera(...)");
        CameraExtImplKt.updateOverrides(camera3);
        Minecraft minecraft = ClientDSLKt.getMC();
        String $this$green$iv = "Set camera position to " + rot.x + ", " + rot.y + "!";
        boolean $i$f$getGreen = false;
        String $this$c$iv$iv = $this$green$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGreen2 = false;
        void var7_7 = $this$green$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        ClientDSLKt.chat(minecraft, (Component)mutableComponent3);
        return 0;
    }
}

