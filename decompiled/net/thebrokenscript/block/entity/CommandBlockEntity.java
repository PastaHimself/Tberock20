/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.Nameable
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.sound.FancyPositionedSoundInstance
 *  net.thebrokenscript.brokencore.api.sound.fx.AudioEffect
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.block.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.block.CorruptedCommandBlock;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.sound.FancyPositionedSoundInstance;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSMenus;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.world.inventory.CommandBlockGuiMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R&\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/block/entity/CommandBlockEntity;", "Lnet/minecraft/world/level/block/entity/BlockEntity;", "Lnet/minecraft/world/MenuProvider;", "Lnet/minecraft/world/Nameable;", "type", "Lnet/minecraft/world/level/block/entity/BlockEntityType;", "position", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "<init>", "(Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V", "ambientSound", "Lnet/thebrokenscript/brokencore/api/sound/FancyPositionedSoundInstance;", "getAmbientSound$annotations", "()V", "getAmbientSound", "()Lnet/thebrokenscript/brokencore/api/sound/FancyPositionedSoundInstance;", "setAmbientSound", "(Lnet/thebrokenscript/brokencore/api/sound/FancyPositionedSoundInstance;)V", "getName", "Lnet/minecraft/network/chat/Component;", "getDisplayName", "createMenu", "Lnet/minecraft/world/inventory/AbstractContainerMenu;", "id", "", "inventory", "Lnet/minecraft/world/entity/player/Inventory;", "player", "Lnet/minecraft/world/entity/player/Player;", "setRemoved", "", "Companion", "thebrokenscript-common"})
public final class CommandBlockEntity
extends BlockEntity
implements MenuProvider,
Nameable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private FancyPositionedSoundInstance ambientSound;

    public CommandBlockEntity(@NotNull BlockEntityType<CommandBlockEntity> type, @NotNull BlockPos position, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        super(type, position, state);
    }

    @Nullable
    public final FancyPositionedSoundInstance getAmbientSound() {
        return this.ambientSound;
    }

    public final void setAmbientSound(@Nullable FancyPositionedSoundInstance fancyPositionedSoundInstance) {
        this.ambientSound = fancyPositionedSoundInstance;
    }

    @SideOnly(side=Side.CLIENT)
    public static /* synthetic */ void getAmbientSound$annotations() {
    }

    @NotNull
    public Component getName() {
        MutableComponent mutableComponent = Component.literal((String)"command");
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"literal(...)");
        return (Component)mutableComponent;
    }

    @NotNull
    public Component getDisplayName() {
        return (Component)TBSLang.INSTANCE.getCOMMAND_NAME();
    }

    @NotNull
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)inventory, (String)"inventory");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Object object = this.level;
        Boolean coded = object != null && (object = LevelExt.INSTANCE.getVars((LevelAccessor)object)) != null ? Boolean.valueOf(((MapVariables)((Object)object)).getCodeApplied()) : null;
        return coded != null && coded == false ? (AbstractContainerMenu)new CommandBlockGuiMenu((MenuType<CommandBlockGuiMenu>)((MenuType)TBSMenus.COMMAND_GUI.get()), id, inventory) : (AbstractContainerMenu)new CommandBlockGuiMenu((MenuType<CommandBlockGuiMenu>)((MenuType)TBSMenus.COMMAND_CONFIRM_GUI.get()), id, inventory);
    }

    public void setRemoved() {
        super.setRemoved();
        Level level = this.level;
        boolean bl = level != null ? level.isClientSide : false;
        if (bl) {
            FancyPositionedSoundInstance fancyPositionedSoundInstance = this.ambientSound;
            if (fancyPositionedSoundInstance != null) {
                fancyPositionedSoundInstance.stopSFX();
            }
            this.ambientSound = null;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/block/entity/CommandBlockEntity$Companion;", "", "<init>", "()V", "tick", "", "level", "Lnet/minecraft/world/level/Level;", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "blockEntity", "Lnet/thebrokenscript/block/entity/CommandBlockEntity;", "serverTick", "Lnet/minecraft/server/level/ServerLevel;", "clientTick", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public final void tick(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull CommandBlockEntity blockEntity) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Intrinsics.checkNotNullParameter((Object)((Object)blockEntity), (String)"blockEntity");
            if (level.isClientSide) {
                this.clientTick(level, pos, state, blockEntity);
            } else {
                this.serverTick((ServerLevel)level, pos, state, blockEntity);
            }
        }

        private final void serverTick(ServerLevel level, BlockPos pos, BlockState state, CommandBlockEntity blockEntity) {
            if (LevelExt.INSTANCE.getVars((LevelAccessor)level).getCodeApplied() && !((Boolean)state.getValue((Property)CorruptedCommandBlock.Companion.getCODE())).booleanValue()) {
                level.setBlock(pos, (BlockState)state.setValue((Property)CorruptedCommandBlock.Companion.getCODE(), (Comparable)Boolean.valueOf(true)), 2);
            }
        }

        private final void clientTick(Level level, BlockPos pos, BlockState state, CommandBlockEntity blockEntity) {
            if (LevelExt.INSTANCE.getVars((LevelAccessor)level).getCodeApplied()) {
                if (blockEntity.getAmbientSound() != null) {
                    FancyPositionedSoundInstance fancyPositionedSoundInstance = blockEntity.getAmbientSound();
                    if (fancyPositionedSoundInstance != null) {
                        fancyPositionedSoundInstance.stopSFX();
                    }
                    blockEntity.setAmbientSound(null);
                }
                return;
            }
            FancyPositionedSoundInstance sound = blockEntity.getAmbientSound();
            if (sound == null || !sound.isActive()) {
                FancyPositionedSoundInstance fancyPositionedSoundInstance;
                SoundEvent soundEvent = (SoundEvent)TBSSounds.CCB_AMBIENT.get();
                Vec3 vec3 = Vec3.atCenterOf((Vec3i)((Vec3i)pos));
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"atCenterOf(...)");
                RandomSource randomSource = level.random;
                Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
                FancyPositionedSoundInstance $this$clientTick_u24lambda_u240 = fancyPositionedSoundInstance = new FancyPositionedSoundInstance(soundEvent, SoundSource.BLOCKS, 2.5f, 1.0f, vec3, true, randomSource);
                boolean bl = false;
                $this$clientTick_u24lambda_u240.setPositionSupplier(() -> Companion.clientTick$lambda$0$0(level, pos));
                $this$clientTick_u24lambda_u240.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_MOOD_HELL, null, (int)1, null));
                $this$clientTick_u24lambda_u240.setAttenuation(1.0f, 3.0f, 8.0f);
                $this$clientTick_u24lambda_u240.setGain(2.0f);
                sound = fancyPositionedSoundInstance;
                ClientDSLKt.getMC().getSoundManager().play((SoundInstance)sound);
                blockEntity.setAmbientSound(sound);
            }
        }

        private static final Vec3 clientTick$lambda$0$0(Level $level, BlockPos $pos) {
            BlockEntity blockEntity = $level.getBlockEntity($pos);
            CommandBlockEntity be = blockEntity instanceof CommandBlockEntity ? (CommandBlockEntity)blockEntity : null;
            return be == null || be.isRemoved() ? null : Vec3.atCenterOf((Vec3i)((Vec3i)$pos));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

