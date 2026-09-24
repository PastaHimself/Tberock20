/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.llamalad7.mixinextras.sugar.ref.LocalRef
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.LevelChunkSection
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.world;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import java.util.Map;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.thebrokenscript.config.TBSConfigs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={LevelChunkSection.class})
public class SectionDeepslateRemovalMixin {
    @Unique
    private static final Map<Block, Block> DEEPSLATE_TO_NORMAL = Map.of(Blocks.DEEPSLATE_COAL_ORE, Blocks.COAL_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.IRON_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.COPPER_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.GOLD_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.EMERALD_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.LAPIS_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DIAMOND_ORE);

    @Inject(method={"setBlockState(IIILnet/minecraft/world/level/block/state/BlockState;Z)Lnet/minecraft/world/level/block/state/BlockState;"}, at={@At(value="HEAD")})
    public void tbs$replaceDeepslate(int x, int y, int z, BlockState state, boolean useLocks, CallbackInfoReturnable<BlockState> cir, @Local(argsOnly=true) LocalRef<BlockState> block) {
        Block replacement;
        if (!TBSConfigs.INSTANCE.getServer().getWorld().getRemoveDeepslate()) {
            return;
        }
        if (((BlockState)block.get()).is(Blocks.DEEPSLATE)) {
            block.set((Object)Blocks.STONE.defaultBlockState());
        }
        if ((replacement = DEEPSLATE_TO_NORMAL.get(((BlockState)block.get()).getBlock())) != null) {
            block.set((Object)replacement.defaultBlockState());
        }
    }
}

