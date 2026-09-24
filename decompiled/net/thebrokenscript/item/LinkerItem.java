/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.item;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.thebrokenscript.block.portal.PortalControllerBlockEntity;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/item/LinkerItem;", "Lnet/minecraft/world/item/Item;", "properties", "Lnet/minecraft/world/item/Item$Properties;", "<init>", "(Lnet/minecraft/world/item/Item$Properties;)V", "target", "Lnet/minecraft/core/BlockPos;", "getTarget", "()Lnet/minecraft/core/BlockPos;", "setTarget", "(Lnet/minecraft/core/BlockPos;)V", "useOn", "Lnet/minecraft/world/InteractionResult;", "context", "Lnet/minecraft/world/item/context/UseOnContext;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nLinkerItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LinkerItem.kt\nnet/thebrokenscript/item/LinkerItem\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,46:1\n15#2:47\n49#2:48\n29#2:49\n24#2:50\n15#2:51\n47#2:52\n29#2:53\n24#2:54\n15#2:55\n47#2:56\n29#2:57\n24#2:58\n*S KotlinDebug\n*F\n+ 1 LinkerItem.kt\nnet/thebrokenscript/item/LinkerItem\n*L\n24#1:47\n24#1:48\n24#1:49\n24#1:50\n30#1:51\n30#1:52\n30#1:53\n30#1:54\n42#1:55\n42#1:56\n42#1:57\n42#1:58\n*E\n"})
public final class LinkerItem
extends Item {
    @Nullable
    private BlockPos target;

    public LinkerItem(@NotNull Item.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    @Nullable
    public final BlockPos getTarget() {
        return this.target;
    }

    public final void setTarget(@Nullable BlockPos blockPos) {
        this.target = blockPos;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public InteractionResult useOn(@NotNull UseOnContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        if (context.getLevel().isClientSide) {
            return InteractionResult.PASS;
        }
        Player player = context.getPlayer();
        if (!(player != null ? player.isShiftKeyDown() : false)) {
            return InteractionResult.PASS;
        }
        BlockPos pos = context.getClickedPos();
        BlockEntity block = context.getLevel().getBlockEntity(pos);
        if (!(block instanceof PortalControllerBlockEntity)) {
            Player player2 = context.getPlayer();
            if (player2 != null) {
                void $this$with$iv$iv;
                void $this$red$iv;
                String $this$c$iv = "Invalid clicked position! Must be a PortalControllerBlockEntity!";
                boolean $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                $this$c$iv = component;
                boolean $i$f$getRed = false;
                void var6_11 = $this$red$iv;
                ChatFormatting other$iv$iv = ChatFormatting.RED;
                boolean $i$f$with = false;
                void $this$mut$iv$iv$iv = $this$with$iv$iv;
                boolean $i$f$mut = false;
                MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
                if (mutableComponent == null) {
                    MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
                    mutableComponent = mutableComponent2;
                    Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
                }
                MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
                player2.sendSystemMessage((Component)mutableComponent3);
            }
            return InteractionResult.FAIL;
        }
        if (this.target == null) {
            this.target = pos;
            Player player3 = context.getPlayer();
            if (player3 != null) {
                void $this$green$iv;
                String $this$c$iv = "Successfully bound to " + pos.toShortString() + "!";
                boolean $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                $this$c$iv = component;
                boolean $i$f$getGreen = false;
                void $this$with$iv$iv = $this$green$iv;
                ChatFormatting other$iv$iv = ChatFormatting.GREEN;
                boolean $i$f$with = false;
                void $this$mut$iv$iv$iv = $this$with$iv$iv;
                boolean $i$f$mut = false;
                MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
                if (mutableComponent == null) {
                    MutableComponent mutableComponent4 = $this$mut$iv$iv$iv.copy();
                    mutableComponent = mutableComponent4;
                    Intrinsics.checkNotNullExpressionValue((Object)mutableComponent4, (String)"copy(...)");
                }
                MutableComponent mutableComponent5 = mutableComponent.withStyle(other$iv$iv);
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"withStyle(...)");
                player3.sendSystemMessage((Component)mutableComponent5);
            }
            return InteractionResult.PASS;
        }
        PortalControllerBlockEntity portalControllerBlockEntity = (PortalControllerBlockEntity)block;
        BlockPos blockPos = this.target;
        Intrinsics.checkNotNull((Object)blockPos);
        portalControllerBlockEntity.setLinked(blockPos.subtract((Vec3i)((PortalControllerBlockEntity)block).getBlockPos()));
        BlockUtil.setDirty((BlockEntity)block);
        Level level = context.getLevel();
        BlockPos blockPos2 = this.target;
        Intrinsics.checkNotNull((Object)blockPos2);
        BlockEntity $this$green$iv = level.getBlockEntity(blockPos2);
        PortalControllerBlockEntity portalControllerBlockEntity2 = $this$green$iv instanceof PortalControllerBlockEntity ? (PortalControllerBlockEntity)$this$green$iv : null;
        if (portalControllerBlockEntity2 != null) {
            PortalControllerBlockEntity it = portalControllerBlockEntity2;
            boolean bl = false;
            it.setLinked(pos.subtract((Vec3i)it.getBlockPos()));
            BlockUtil.setDirty((BlockEntity)it);
        }
        Player player4 = context.getPlayer();
        if (player4 != null) {
            void $this$with$iv$iv;
            BlockPos blockPos3 = this.target;
            Intrinsics.checkNotNull((Object)blockPos3);
            String $this$c$iv = "Successfully bound portals! A: " + blockPos3.toShortString() + "; B: " + pos.toShortString() + "!";
            boolean $i$f$getC = false;
            Component component = Component.nullToEmpty((String)$this$c$iv);
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
            $this$c$iv = component;
            boolean $i$f$getGreen = false;
            BlockEntity bl = $this$green$iv;
            ChatFormatting other$iv$iv = ChatFormatting.GREEN;
            boolean $i$f$with = false;
            void $this$mut$iv$iv$iv = $this$with$iv$iv;
            boolean $i$f$mut = false;
            MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
            if (mutableComponent == null) {
                MutableComponent mutableComponent6 = $this$mut$iv$iv$iv.copy();
                mutableComponent = mutableComponent6;
                Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"copy(...)");
            }
            MutableComponent mutableComponent7 = mutableComponent.withStyle(other$iv$iv);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"withStyle(...)");
            player4.sendSystemMessage((Component)mutableComponent7);
        }
        this.target = null;
        return InteractionResult.PASS;
    }
}

