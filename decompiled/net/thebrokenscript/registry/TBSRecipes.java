/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.registry.BrokenReg
 *  net.thebrokenscript.brokencore.api.registry.builders.ShapedRecipeBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.ShapelessRecipeBuilder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.ShapedRecipeBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.ShapelessRecipeBuilder;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/registry/TBSRecipes;", "", "<init>", "()V", "thebrokenscript-common"})
public final class TBSRecipes {
    @NotNull
    public static final TBSRecipes INSTANCE = new TBSRecipes();

    private TBSRecipes() {
    }

    private static final void _init_$lambda$0(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("  #");
        $this$shapedRecipe.row(" ##");
        $this$shapedRecipe.row("###");
        $this$shapedRecipe.key('#', TBSConstants.id("void_planks"));
    }

    private static final void _init_$lambda$1(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("###");
        $this$shapedRecipe.key('#', TBSConstants.id("void_planks"));
    }

    private static final void _init_$lambda$2(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("## ");
        $this$shapedRecipe.row("## ");
        $this$shapedRecipe.row("## ");
        $this$shapedRecipe.key('#', TBSConstants.id("void_planks"));
    }

    private static final void _init_$lambda$3(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("## ");
        $this$shapedRecipe.row("## ");
        $this$shapedRecipe.row("## ");
        $this$shapedRecipe.key('#', TBSConstants.id("void_log"));
    }

    private static final void _init_$lambda$4(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("$$ ");
        $this$shapedRecipe.row("$$ ");
        $this$shapedRecipe.key('$', TBSConstants.id("void_log"));
    }

    private static final void _init_$lambda$5(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("FFF");
        $this$shapedRecipe.row("F F");
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)"fire");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
        $this$shapedRecipe.key('F', resourceLocation);
    }

    private static final void _init_$lambda$6(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("F F");
        $this$shapedRecipe.row("FFF");
        $this$shapedRecipe.row("FFF");
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)"fire");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
        $this$shapedRecipe.key('F', resourceLocation);
    }

    private static final void _init_$lambda$7(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("FFF");
        $this$shapedRecipe.row("F F");
        $this$shapedRecipe.row("F F");
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)"fire");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
        $this$shapedRecipe.key('F', resourceLocation);
    }

    private static final void _init_$lambda$8(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("F F");
        $this$shapedRecipe.row("F F");
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)"fire");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
        $this$shapedRecipe.key('F', resourceLocation);
    }

    private static final void _init_$lambda$9(ShapedRecipeBuilder $this$shapedRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapedRecipe, (String)"$this$shapedRecipe");
        $this$shapedRecipe.row("###");
        $this$shapedRecipe.row("#A#");
        $this$shapedRecipe.row("###");
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)"gold_block");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
        $this$shapedRecipe.key('#', resourceLocation);
        ResourceLocation resourceLocation2 = ResourceLocation.withDefaultNamespace((String)"apple");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation2, (String)"withDefaultNamespace(...)");
        $this$shapedRecipe.key('A', resourceLocation2);
    }

    private static final void _init_$lambda$10(ShapelessRecipeBuilder $this$shapelessRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapelessRecipe, (String)"$this$shapelessRecipe");
        $this$shapelessRecipe.ingredients(TBSConstants.id("void_log"));
    }

    private static final void _init_$lambda$11(ShapelessRecipeBuilder $this$shapelessRecipe) {
        Intrinsics.checkNotNullParameter((Object)$this$shapelessRecipe, (String)"$this$shapelessRecipe");
        $this$shapelessRecipe.ingredients(TBSConstants.id("void_wood"));
    }

    static {
        TBSReg.INSTANCE.shapedRecipe("void_plank_stairs", TBSConstants.id("void_plank_stairs"), 4, TBSRecipes::_init_$lambda$0);
        TBSReg.INSTANCE.shapedRecipe("void_slabs_from_planks", TBSConstants.id("void_plank_slab"), 6, TBSRecipes::_init_$lambda$1);
        TBSReg.INSTANCE.shapedRecipe("void_plank_door", TBSConstants.id("void_plank_door"), 3, TBSRecipes::_init_$lambda$2);
        TBSReg.INSTANCE.shapedRecipe("void_log_door", TBSConstants.id("void_log_door"), 3, TBSRecipes::_init_$lambda$3);
        TBSReg.INSTANCE.shapedRecipe("void_wood_from_log", TBSConstants.id("void_wood"), 3, TBSRecipes::_init_$lambda$4);
        BrokenReg brokenReg = TBSReg.INSTANCE;
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)"chainmail_helmet");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
        BrokenReg.shapedRecipe$default((BrokenReg)brokenReg, (String)"chainmail_helmet", (ResourceLocation)resourceLocation, (int)0, TBSRecipes::_init_$lambda$5, (int)4, null);
        BrokenReg brokenReg2 = TBSReg.INSTANCE;
        ResourceLocation resourceLocation2 = ResourceLocation.withDefaultNamespace((String)"chainmail_chestplate");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation2, (String)"withDefaultNamespace(...)");
        BrokenReg.shapedRecipe$default((BrokenReg)brokenReg2, (String)"chainmail_chestplate", (ResourceLocation)resourceLocation2, (int)0, TBSRecipes::_init_$lambda$6, (int)4, null);
        BrokenReg brokenReg3 = TBSReg.INSTANCE;
        ResourceLocation resourceLocation3 = ResourceLocation.withDefaultNamespace((String)"chainmail_leggings");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation3, (String)"withDefaultNamespace(...)");
        BrokenReg.shapedRecipe$default((BrokenReg)brokenReg3, (String)"chainmail_leggings", (ResourceLocation)resourceLocation3, (int)0, TBSRecipes::_init_$lambda$7, (int)4, null);
        BrokenReg brokenReg4 = TBSReg.INSTANCE;
        ResourceLocation resourceLocation4 = ResourceLocation.withDefaultNamespace((String)"chainmail_boots");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation4, (String)"withDefaultNamespace(...)");
        BrokenReg.shapedRecipe$default((BrokenReg)brokenReg4, (String)"chainmail_boots", (ResourceLocation)resourceLocation4, (int)0, TBSRecipes::_init_$lambda$8, (int)4, null);
        BrokenReg brokenReg5 = TBSReg.INSTANCE;
        ResourceLocation resourceLocation5 = ResourceLocation.withDefaultNamespace((String)"enchanted_golden_apple");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation5, (String)"withDefaultNamespace(...)");
        BrokenReg.shapedRecipe$default((BrokenReg)brokenReg5, (String)"notch_apple", (ResourceLocation)resourceLocation5, (int)0, TBSRecipes::_init_$lambda$9, (int)4, null);
        TBSReg.INSTANCE.shapelessRecipe("void_planks_from_log", TBSConstants.id("void_planks"), 4, TBSRecipes::_init_$lambda$10);
        TBSReg.INSTANCE.shapelessRecipe("void_planks_from_wood", TBSConstants.id("void_planks"), 4, TBSRecipes::_init_$lambda$11);
    }
}

