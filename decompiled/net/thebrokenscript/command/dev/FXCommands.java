/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.FloatArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KMutableProperty1
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.commands.CommandDSL
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.command.dev;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.commands.CommandDSL;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.command.dev.FXCommands;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006J6\u0010\b\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002J6\u0010\u0011\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u000eH\u0002JJ\u0010\u0011\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013H\u0002\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/command/dev/FXCommands;", "", "<init>", "()V", "addFXCommands", "", "Lnet/thebrokenscript/brokencore/api/commands/CommandDSL;", "Lnet/minecraft/commands/CommandSourceStack;", "levelEffectCommands", "id", "", "name", "Lnet/minecraft/network/chat/Component;", "field", "Lkotlin/reflect/KMutableProperty1;", "Lnet/thebrokenscript/data/MapVariables;", "", "playerEffectCommands", "Lnet/thebrokenscript/data/PlayerVariables;", "", "min", "max", "thebrokenscript-common"})
public final class FXCommands {
    @NotNull
    public static final FXCommands INSTANCE = new FXCommands();

    private FXCommands() {
    }

    public final void addFXCommands(@NotNull CommandDSL<CommandSourceStack> $this$addFXCommands) {
        Intrinsics.checkNotNullParameter($this$addFXCommands, (String)"<this>");
        $this$addFXCommands.group("fx", FXCommands::addFXCommands$lambda$0);
    }

    private final void levelEffectCommands(CommandDSL<CommandSourceStack> $this$levelEffectCommands, String id, Component name, KMutableProperty1<MapVariables, Boolean> field) {
        $this$levelEffectCommands.group(id, arg_0 -> FXCommands.levelEffectCommands$lambda$0(field, name, arg_0));
    }

    private final void playerEffectCommands(CommandDSL<CommandSourceStack> $this$playerEffectCommands, String id, Component name, KMutableProperty1<PlayerVariables, Boolean> field) {
        $this$playerEffectCommands.group(id, arg_0 -> FXCommands.playerEffectCommands$lambda$0(field, name, arg_0));
    }

    private final void playerEffectCommands(CommandDSL<CommandSourceStack> $this$playerEffectCommands, String id, Component name, KMutableProperty1<PlayerVariables, Float> field, float min, float max) {
        $this$playerEffectCommands.group(id, arg_0 -> FXCommands.playerEffectCommands$lambda$1(min, max, field, name, arg_0));
    }

    static /* synthetic */ void playerEffectCommands$default(FXCommands fXCommands, CommandDSL commandDSL, String string, Component component, KMutableProperty1 kMutableProperty1, float f, float f2, int n, Object object) {
        if ((n & 8) != 0) {
            f = 0.0f;
        }
        if ((n & 0x10) != 0) {
            f2 = 1.0f;
        }
        fXCommands.playerEffectCommands((CommandDSL<CommandSourceStack>)commandDSL, string, component, (KMutableProperty1<PlayerVariables, Float>)kMutableProperty1, f, f2);
    }

    private static final void addFXCommands$lambda$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "aberration", (Component)TBSLang.INSTANCE.getFX_ABERRATION(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.1.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "vhs", (Component)TBSLang.INSTANCE.getFX_VHS(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.2.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "moon_glitch", (Component)TBSLang.INSTANCE.getFX_MOON_GLITCH(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.3.INSTANCE));
        FXCommands.playerEffectCommands$default(INSTANCE, $this$group, "text_glitch", (Component)TBSLang.INSTANCE.getFX_TEXT_GLITCH(), (KMutableProperty1)addFXCommands.1.4.INSTANCE, 0.0f, 0.0f, 24, null);
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "custom_sky", (Component)TBSLang.INSTANCE.getFX_CUSTOM_SKY(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.5.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "sky_blue", (Component)TBSLang.INSTANCE.getFX_SKY_BLUE(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.6.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "screen_dupe", (Component)TBSLang.INSTANCE.getFX_SCREEN_DUPE(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.7.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "lucid_blocks_effect", (Component)TBSLang.INSTANCE.getFX_LUCID_EFFECT(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.8.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "meta_paranoia", (Component)TBSLang.INSTANCE.getFX_META_PARANOIA(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.9.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "glitches", (Component)TBSLang.INSTANCE.getFX_GLITCHES(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.10.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "void_box", (Component)TBSLang.INSTANCE.getFX_VOID_BOX(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.11.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "dream", (Component)TBSLang.INSTANCE.getFX_DREAM(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.12.INSTANCE));
        INSTANCE.playerEffectCommands((CommandDSL<CommandSourceStack>)$this$group, "invert", (Component)TBSLang.INSTANCE.getFX_INVERT(), (KMutableProperty1<PlayerVariables, Boolean>)((KMutableProperty1)addFXCommands.1.13.INSTANCE));
        $this$group.group("custom_sky", FXCommands::addFXCommands$lambda$0$0);
    }

    private static final void addFXCommands$lambda$0$0(CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[3];
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer(), (String)"integer(...)");
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer(), (String)"integer(...)");
        Intrinsics.checkNotNullExpressionValue((Object)IntegerArgumentType.integer(), (String)"integer(...)");
        $this$group.add("set [r] [g] [b]", argumentTypeArray, FXCommands::addFXCommands$lambda$0$0$0);
    }

    private static final int addFXCommands$lambda$0$0$0(CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        int r = IntegerArgumentType.getInteger((CommandContext)it, (String)"r");
        int g = IntegerArgumentType.getInteger((CommandContext)it, (String)"g");
        int b = IntegerArgumentType.getInteger((CommandContext)it, (String)"b");
        double rd = (double)r / 255.0;
        double gd = (double)g / 255.0;
        double bd = (double)b / 255.0;
        Vec3 c = new Vec3(rd, gd, bd);
        ServerPlayer serverPlayer = ((CommandSourceStack)it.getSource()).getPlayerOrException();
        Intrinsics.checkNotNullExpressionValue((Object)serverPlayer, (String)"getPlayerOrException(...)");
        PlayerExt.INSTANCE.updateVars((Player)serverPlayer, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> FXCommands.addFXCommands$lambda$0$0$0$0(c, arg_0)));
        return 0;
    }

    private static final Unit addFXCommands$lambda$0$0$0$0(Vec3 $c, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setCustomSkyColor($c);
        return Unit.INSTANCE;
    }

    private static final void levelEffectCommands$lambda$0(KMutableProperty1 $field, Component $name, CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("toggle", arg_0 -> FXCommands.levelEffectCommands$lambda$0$0($field, $name, arg_0));
        $this$group.add("on", arg_0 -> FXCommands.levelEffectCommands$lambda$0$1($field, $name, arg_0));
        $this$group.add("off", arg_0 -> FXCommands.levelEffectCommands$lambda$0$2($field, $name, arg_0));
    }

    private static final int levelEffectCommands$lambda$0$0(KMutableProperty1 $field, Component $name, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel level = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNull((Object)level);
        MapVariables vars = LevelExt.INSTANCE.getVars((LevelAccessor)level);
        if (((Boolean)$field.get((Object)vars)).booleanValue()) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> FXCommands.levelEffectCommands$lambda$0$0$0($field, arg_0)));
            ((CommandSourceStack)it.getSource()).sendSuccess(() -> FXCommands.levelEffectCommands$lambda$0$0$1($name), true);
        } else {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> FXCommands.levelEffectCommands$lambda$0$0$2($field, arg_0)));
            ((CommandSourceStack)it.getSource()).sendSuccess(() -> FXCommands.levelEffectCommands$lambda$0$0$3($name), true);
        }
        return 0;
    }

    private static final Unit levelEffectCommands$lambda$0$0$0(KMutableProperty1 $field, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $field.set((Object)$this$updateVars, (Object)false);
        return Unit.INSTANCE;
    }

    private static final Component levelEffectCommands$lambda$0$0$1(Component $name) {
        Object[] objectArray = new Object[]{$name};
        return (Component)ComponentUtil.withReplacements((Component)((Component)TBSLang.INSTANCE.getFX_TOGGLE_OFF()), (Object[])objectArray);
    }

    private static final Unit levelEffectCommands$lambda$0$0$2(KMutableProperty1 $field, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $field.set((Object)$this$updateVars, (Object)true);
        return Unit.INSTANCE;
    }

    private static final Component levelEffectCommands$lambda$0$0$3(Component $name) {
        Object[] objectArray = new Object[]{$name};
        return (Component)ComponentUtil.withReplacements((Component)((Component)TBSLang.INSTANCE.getFX_TOGGLE_ON()), (Object[])objectArray);
    }

    private static final int levelEffectCommands$lambda$0$1(KMutableProperty1 $field, Component $name, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel level = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNull((Object)level);
        LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> FXCommands.levelEffectCommands$lambda$0$1$0($field, arg_0)));
        ((CommandSourceStack)it.getSource()).sendSuccess(() -> FXCommands.levelEffectCommands$lambda$0$1$1($name), true);
        return 0;
    }

    private static final Unit levelEffectCommands$lambda$0$1$0(KMutableProperty1 $field, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $field.set((Object)$this$updateVars, (Object)true);
        return Unit.INSTANCE;
    }

    private static final Component levelEffectCommands$lambda$0$1$1(Component $name) {
        Object[] objectArray = new Object[]{$name};
        return (Component)ComponentUtil.withReplacements((Component)((Component)TBSLang.INSTANCE.getFX_ON()), (Object[])objectArray);
    }

    private static final int levelEffectCommands$lambda$0$2(KMutableProperty1 $field, Component $name, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerLevel level = ((CommandSourceStack)it.getSource()).getLevel();
        Intrinsics.checkNotNull((Object)level);
        LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> FXCommands.levelEffectCommands$lambda$0$2$0($field, arg_0)));
        ((CommandSourceStack)it.getSource()).sendSuccess(() -> FXCommands.levelEffectCommands$lambda$0$2$1($name), true);
        return 0;
    }

    private static final Unit levelEffectCommands$lambda$0$2$0(KMutableProperty1 $field, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $field.set((Object)$this$updateVars, (Object)false);
        return Unit.INSTANCE;
    }

    private static final Component levelEffectCommands$lambda$0$2$1(Component $name) {
        Object[] objectArray = new Object[]{$name};
        return (Component)ComponentUtil.withReplacements((Component)((Component)TBSLang.INSTANCE.getFX_OFF()), (Object[])objectArray);
    }

    private static final void playerEffectCommands$lambda$0(KMutableProperty1 $field, Component $name, CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        $this$group.add("toggle", arg_0 -> FXCommands.playerEffectCommands$lambda$0$0($field, $name, arg_0));
        $this$group.add("on", arg_0 -> FXCommands.playerEffectCommands$lambda$0$1($field, $name, arg_0));
        $this$group.add("off", arg_0 -> FXCommands.playerEffectCommands$lambda$0$2($field, $name, arg_0));
    }

    private static final int playerEffectCommands$lambda$0$0(KMutableProperty1 $field, Component $name, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer player = ((CommandSourceStack)it.getSource()).getPlayer();
        if (player == null) {
            ((CommandSourceStack)it.getSource()).sendFailure((Component)TBSLang.INSTANCE.getCMD_ERROR_NOT_PLAYER());
            return -1;
        }
        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
        if (((Boolean)$field.get((Object)vars)).booleanValue()) {
            $field.set((Object)vars, (Object)false);
            vars.syncTo((Player)player);
            if (Intrinsics.areEqual((Object)$field, (Object)((Object)playerEffectCommands.1.1.1.INSTANCE))) {
                PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)FXCommands::playerEffectCommands$lambda$0$0$0));
            }
            ((CommandSourceStack)it.getSource()).sendSuccess(() -> FXCommands.playerEffectCommands$lambda$0$0$1($name), true);
        } else {
            $field.set((Object)vars, (Object)true);
            vars.syncTo((Player)player);
            ((CommandSourceStack)it.getSource()).sendSuccess(() -> FXCommands.playerEffectCommands$lambda$0$0$2($name), true);
        }
        return 0;
    }

    private static final Unit playerEffectCommands$lambda$0$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setMoonGlitchDuration(0.0);
        return Unit.INSTANCE;
    }

    private static final Component playerEffectCommands$lambda$0$0$1(Component $name) {
        Object[] objectArray = new Object[]{$name};
        return (Component)ComponentUtil.withReplacements((Component)((Component)TBSLang.INSTANCE.getFX_TOGGLE_OFF()), (Object[])objectArray);
    }

    private static final Component playerEffectCommands$lambda$0$0$2(Component $name) {
        Object[] objectArray = new Object[]{$name};
        return (Component)ComponentUtil.withReplacements((Component)((Component)TBSLang.INSTANCE.getFX_TOGGLE_ON()), (Object[])objectArray);
    }

    private static final int playerEffectCommands$lambda$0$1(KMutableProperty1 $field, Component $name, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer player = ((CommandSourceStack)it.getSource()).getPlayer();
        if (player == null) {
            ((CommandSourceStack)it.getSource()).sendFailure((Component)TBSLang.INSTANCE.getCMD_ERROR_NOT_PLAYER());
            return -1;
        }
        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
        $field.set((Object)vars, (Object)true);
        vars.syncTo((Player)player);
        ((CommandSourceStack)it.getSource()).sendSuccess(() -> FXCommands.playerEffectCommands$lambda$0$1$0($name), true);
        return 0;
    }

    private static final Component playerEffectCommands$lambda$0$1$0(Component $name) {
        Object[] objectArray = new Object[]{$name};
        return (Component)ComponentUtil.withReplacements((Component)((Component)TBSLang.INSTANCE.getFX_ON()), (Object[])objectArray);
    }

    private static final int playerEffectCommands$lambda$0$2(KMutableProperty1 $field, Component $name, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer player = ((CommandSourceStack)it.getSource()).getPlayer();
        if (player == null) {
            ((CommandSourceStack)it.getSource()).sendFailure((Component)TBSLang.INSTANCE.getCMD_ERROR_NOT_PLAYER());
            return -1;
        }
        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
        if (Intrinsics.areEqual((Object)$field, (Object)((Object)playerEffectCommands.1.3.1.INSTANCE))) {
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)FXCommands::playerEffectCommands$lambda$0$2$0));
        }
        $field.set((Object)vars, (Object)false);
        vars.syncTo((Player)player);
        ((CommandSourceStack)it.getSource()).sendSuccess(() -> FXCommands.playerEffectCommands$lambda$0$2$1($name), true);
        return 0;
    }

    private static final Unit playerEffectCommands$lambda$0$2$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setMoonGlitchDuration(0.0);
        return Unit.INSTANCE;
    }

    private static final Component playerEffectCommands$lambda$0$2$1(Component $name) {
        Object[] objectArray = new Object[]{$name};
        return (Component)ComponentUtil.withReplacements((Component)((Component)TBSLang.INSTANCE.getFX_OFF()), (Object[])objectArray);
    }

    private static final void playerEffectCommands$lambda$1(float $min, float $max, KMutableProperty1 $field, Component $name, CommandDSL $this$group) {
        Intrinsics.checkNotNullParameter((Object)$this$group, (String)"$this$group");
        ArgumentType[] argumentTypeArray = new ArgumentType[1];
        Intrinsics.checkNotNullExpressionValue((Object)FloatArgumentType.floatArg((float)$min, (float)$max), (String)"floatArg(...)");
        $this$group.add("set [value]", argumentTypeArray, arg_0 -> FXCommands.playerEffectCommands$lambda$1$0($field, $name, arg_0));
    }

    private static final int playerEffectCommands$lambda$1$0(KMutableProperty1 $field, Component $name, CommandContext it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ServerPlayer player = ((CommandSourceStack)it.getSource()).getPlayer();
        float value = FloatArgumentType.getFloat((CommandContext)it, (String)"value");
        if (player == null) {
            ((CommandSourceStack)it.getSource()).sendFailure((Component)TBSLang.INSTANCE.getCMD_ERROR_NOT_PLAYER());
            return -1;
        }
        PlayerVariables vars = PlayerExt.INSTANCE.getVars((Player)player);
        $field.set((Object)vars, (Object)Float.valueOf(value));
        vars.syncTo((Player)player);
        ((CommandSourceStack)it.getSource()).sendSuccess(() -> FXCommands.playerEffectCommands$lambda$1$0$0($name), true);
        return 0;
    }

    private static final Component playerEffectCommands$lambda$1$0$0(Component $name) {
        Object[] objectArray = new Object[]{$name};
        return (Component)ComponentUtil.withReplacements((Component)((Component)TBSLang.INSTANCE.getFX_OFF()), (Object[])objectArray);
    }
}

