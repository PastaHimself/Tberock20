/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.world;

import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSEasterEggItems;
import net.thebrokenscript.registry.TBSItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Block.class})
public class BlockMixin {
    @Unique
    private static Set<Block> tbs$getLucidBlocks() {
        return Set.of(Blocks.WHITE_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.LIME_CONCRETE, Blocks.PINK_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.RED_CONCRETE);
    }

    @Inject(method={"dropResources(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$dropResources(BlockState state, Level level, BlockPos pos, CallbackInfo ci) {
        ItemStack drop;
        if (level.dimension() == TBSDimensions.LUCID && BlockMixin.tbs$getLucidBlocks().contains(state.getBlock())) {
            if ((double)level.random.nextFloat() < 0.1 && !level.isClientSide) {
                drop = new ItemStack(TBSEasterEggItems.GLAGGLE);
                Block.popResource((Level)level, (BlockPos)pos, (ItemStack)drop);
            }
            ci.cancel();
        }
        if (level.dimension() == TBSDimensions.LIBRARY && state.is(TBSBlocks.MONOCHROME_BOOKSHELF)) {
            if ((double)level.random.nextFloat() < 0.2 && !level.isClientSide) {
                drop = new ItemStack(TBSItems.LIBRARY_BOOK);
                Block.popResource((Level)level, (BlockPos)pos, (ItemStack)drop);
            }
            ci.cancel();
        }
    }

    @Inject(method={"dropResources(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$dropResources2(BlockState state, LevelAccessor level, BlockPos pos, BlockEntity blockEntity, CallbackInfo ci) {
        if (level instanceof Level) {
            ItemStack drop;
            Level lvl = (Level)level;
            if (lvl.dimension() == TBSDimensions.LUCID && BlockMixin.tbs$getLucidBlocks().contains(state.getBlock())) {
                if ((double)lvl.random.nextFloat() < 0.1 && !lvl.isClientSide) {
                    drop = new ItemStack(TBSEasterEggItems.GLAGGLE);
                    Block.popResource((Level)lvl, (BlockPos)pos, (ItemStack)drop);
                }
                ci.cancel();
            }
            if (lvl.dimension() == TBSDimensions.LIBRARY && state.is(TBSBlocks.MONOCHROME_BOOKSHELF)) {
                if ((double)lvl.random.nextFloat() < 0.2 && !lvl.isClientSide) {
                    drop = new ItemStack(TBSItems.LIBRARY_BOOK);
                    Block.popResource((Level)lvl, (BlockPos)pos, (ItemStack)drop);
                }
                ci.cancel();
            }
        }
    }

    @Inject(method={"dropResources(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/item/ItemStack;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$dropResources3(BlockState state, Level level, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack tool, CallbackInfo ci) {
        ItemStack drop;
        if (level.dimension() == TBSDimensions.LUCID && BlockMixin.tbs$getLucidBlocks().contains(state.getBlock())) {
            if ((double)level.random.nextFloat() < 0.1 && !level.isClientSide) {
                drop = new ItemStack(TBSEasterEggItems.GLAGGLE);
                Block.popResource((Level)level, (BlockPos)pos, (ItemStack)drop);
            }
            ci.cancel();
        }
        if (level.dimension() == TBSDimensions.LIBRARY && state.is(TBSBlocks.MONOCHROME_BOOKSHELF)) {
            if ((double)level.random.nextFloat() < 0.2 && !level.isClientSide) {
                drop = new ItemStack(TBSItems.LIBRARY_BOOK);
                Block.popResource((Level)level, (BlockPos)pos, (ItemStack)drop);
            }
            ci.cancel();
        }
    }
}

