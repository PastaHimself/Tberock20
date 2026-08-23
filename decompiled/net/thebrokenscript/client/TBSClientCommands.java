/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.BoolArgumentType
 *  com.mojang.brigadier.arguments.FloatArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.suggestion.SuggestionProvider
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.commands.SharedSuggestionProvider
 *  net.minecraft.commands.arguments.ResourceLocationArgument
 *  net.minecraft.commands.synchronization.SuggestionProviders
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.sounds.SoundEvent
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.commands.SuggestingArgument
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.commands.synchronization.SuggestionProviders;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.boss.integrity.FinalCutsceneHandler;
import net.thebrokenscript.boss.jimmy.Jimbo;
import net.thebrokenscript.boss.jimmy.MoonRiseAmbience;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.commands.SuggestingArgument;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.client.TBSClient;
import net.thebrokenscript.client.window.FigureWin;
import net.thebrokenscript.mixinterfaces.CameraZAxisKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/client/TBSClientCommands;", "", "<init>", "()V", "register", "", "S", "Lnet/minecraft/commands/SharedSuggestionProvider;", "dispatcher", "Lcom/mojang/brigadier/CommandDispatcher;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTBSClientCommands.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TBSClientCommands.kt\nnet/thebrokenscript/client/TBSClientCommands\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,94:1\n72#2:95\n15#2:96\n49#2:97\n29#2:98\n24#2:99\n*S KotlinDebug\n*F\n+ 1 TBSClientCommands.kt\nnet/thebrokenscript/client/TBSClientCommands\n*L\n45#1:95\n45#1:96\n45#1:97\n45#1:98\n45#1:99\n*E\n"})
public final class TBSClientCommands {
    @NotNull
    public static final TBSClientCommands INSTANCE = new TBSClientCommands();

    private TBSClientCommands() {
    }

    public final <S extends SharedSuggestionProvider> void register(@NotNull CommandDispatcher<S> dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, (String)"dispatcher");
        new CommandDSL(dispatcher, null, TBSClientCommands::register$lambda$0, 2, null);
    }

    private static final void register$lambda$0(CommandDSL $this$CommandDSL) {
        Intrinsics.checkNotNullParameter((Object)$this$CommandDSL, (String)"$this$CommandDSL");
        $this$CommandDSL.group("tbsc", TBSClientCommands::register$lambda$0$0);
    }

    private static final void register$lambda$0$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[5];
        ResourceLocationArgument resourceLocationArgument = ResourceLocationArgument.id();
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocationArgument, (String)"id(...)");
        ArgumentType argumentType = (ArgumentType)resourceLocationArgument;
        SuggestionProvider suggestionProvider = SuggestionProviders.AVAILABLE_SOUNDS;
        Intrinsics.checkNotNullExpressionValue((Object)suggestionProvider, (String)"AVAILABLE_SOUNDS");
        argumentTypeArray[0] = new SuggestingArgument(argumentType, suggestionProvider);
        Intrinsics.checkNotNullExpressionValue((Object)BoolArgumentType.bool(), (String)"bool(...)");
        Intrinsics.checkNotNullExpressionValue((Object)FloatArgumentType.floatArg(), (String)"floatArg(...)");
        Intrinsics.checkNotNullExpressionValue((Object)FloatArgumentType.floatArg(), (String)"floatArg(...)");
        Intrinsics.checkNotNullExpressionValue((Object)FloatArgumentType.floatArg(), (String)"floatArg(...)");
        $this$group.add("test [sound] [loop] [volume] [pitch] [gain]", argumentTypeArray, TBSClientCommands::register$lambda$0$0$0);
        $this$group.group("camera", TBSClientCommands::register$lambda$0$0$1);
        $this$group.add("figure", TBSClientCommands::register$lambda$0$0$2);
        $this$group.group("moonrise", TBSClientCommands::register$lambda$0$0$3);
        $this$group.group("boss_end", TBSClientCommands::register$lambda$0$0$4);
    }

    /*
     * WARNING - void declaration
     */
    private static final int register$lambda$0$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ResourceLocation soundId = (ResourceLocation)it.getArgument("sound", ResourceLocation.class);
        SoundEvent sound = (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(soundId);
        boolean loop = BoolArgumentType.getBool((CommandContext)it, (String)"loop");
        float volume = FloatArgumentType.getFloat((CommandContext)it, (String)"volume");
        float pitch = FloatArgumentType.getFloat((CommandContext)it, (String)"pitch");
        float gain = FloatArgumentType.getFloat((CommandContext)it, (String)"gain");
        if (sound == null) {
            void $this$with$iv$iv$iv;
            void $this$red$iv$iv;
            Minecraft minecraft = Minecraft.getInstance();
            Intrinsics.checkNotNullExpressionValue((Object)minecraft, (String)"getInstance(...)");
            String $this$red$iv = "Cannot find sound!";
            boolean $i$f$getRed = false;
            String $this$c$iv$iv = $this$red$iv;
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            $this$c$iv$iv = component;
            boolean $i$f$getRed2 = false;
            void var11_11 = $this$red$iv$iv;
            ChatFormatting other$iv$iv$iv = ChatFormatting.RED;
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
            ClientDSLKt.chat((Minecraft)minecraft, (Component)((Component)mutableComponent3));
            return 1;
        }
        FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)sound, null, (float)volume, (float)pitch, (boolean)loop, null, (int)34, null).setGain(gain);
        return 0;
    }

    private static final void register$lambda$0$0$1(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)FloatArgumentType.floatArg(), (String)"floatArg(...)");
        $this$group.add("z [value]", argumentTypeArray, TBSClientCommands::register$lambda$0$0$1$0);
    }

    private static final int register$lambda$0$0$1$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
        CameraZAxisKt.setAngle(camera, FloatArgumentType.getFloat((CommandContext)it, (String)"value"));
        return 0;
    }

    private static final int register$lambda$0$0$2(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        TBSClient.INSTANCE.setWin(new FigureWin());
        return 0;
    }

    private static final void register$lambda$0$0$3(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("init", TBSClientCommands::register$lambda$0$0$3$0);
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer((int)0, (int)3), (String)"integer(...)");
        $this$group.add("stage [stage]", argumentTypeArray, TBSClientCommands::register$lambda$0$0$3$1);
    }

    private static final int register$lambda$0$0$3$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Jimbo.INSTANCE.setMOONRISE(new MoonRiseAmbience());
        return 0;
    }

    private static final int register$lambda$0$0$3$1(CommandContext it) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            MoonRiseAmbience moonRiseAmbience = Jimbo.INSTANCE.getMOONRISE();
            if (moonRiseAmbience == null) break block0;
            moonRiseAmbience.applyStage(IntegerArgumentType.getInteger((CommandContext)it, (String)"stage"));
        }
        return 0;
    }

    private static final void register$lambda$0$0$4(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("start", TBSClientCommands::register$lambda$0$0$4$0);
        $this$group.add("end", TBSClientCommands::register$lambda$0$0$4$1);
    }

    private static final int register$lambda$0$0$4$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        FinalCutsceneHandler.CUTSCENE.start();
        return 0;
    }

    private static final int register$lambda$0$0$4$1(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        FinalCutsceneHandler.CUTSCENE.end();
        return 0;
    }
}

