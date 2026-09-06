/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.block.Block
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.builders.interfaces;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.util.VanillaTagBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/VanillaBlockTagEnum;", "", "tag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/block/Block;", "getTag", "()Lnet/minecraft/tags/TagKey;", "add", "", "owner", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "block", "brokencore-common"})
public interface VanillaBlockTagEnum {
    @Nullable
    public TagKey<Block> getTag();

    public void add(@NotNull BrokenReg var1, @NotNull Block var2);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static void add(@NotNull VanillaBlockTagEnum $this, @NotNull BrokenReg owner, @NotNull Block block2) {
            block0: {
                Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
                Intrinsics.checkNotNullParameter((Object)block2, (String)"block");
                TagKey<Block> tagKey = $this.getTag();
                if (tagKey == null) break block0;
                TagKey<Block> tag = tagKey;
                boolean bl = false;
                ResourceKey resourceKey = Registries.BLOCK;
                Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"BLOCK");
                String string = tag.location().getPath();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
                owner.vanillaTag(resourceKey, string, arg_0 -> DefaultImpls.add$lambda$0$0(block2, arg_0));
            }
        }

        private static void add$lambda$0$0(Block $block, VanillaTagBuilder $this$vanillaTag) {
            Intrinsics.checkNotNullParameter((Object)$this$vanillaTag, (String)"$this$vanillaTag");
            Block[] blockArray = new Block[]{$block};
            $this$vanillaTag.add(blockArray);
        }
    }
}

