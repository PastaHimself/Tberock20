/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  compat.net.neoforged.neoforge.client.model.generators.ItemModelBuilder
 *  compat.net.neoforged.neoforge.client.model.generators.ModelFile
 *  compat.net.neoforged.neoforge.client.model.generators.ModelFile$UncheckedModelFile
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.thebrokenscript.brokencore.api.datagen.providers.BCBlockItemModelProvider
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockEntityBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockItemBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.SoundBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntry
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.renderer.GeoBlockRenderer
 */
package net.thebrokenscript.registry;

import compat.net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import compat.net.neoforged.neoforge.client.model.generators.ModelFile;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.thebrokenscript.block.PlushBlock;
import net.thebrokenscript.block.entity.PlushBlockEntity;
import net.thebrokenscript.brokencore.api.datagen.providers.BCBlockItemModelProvider;
import net.thebrokenscript.brokencore.api.registry.builders.BlockBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockEntityBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.BlockItemBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.SoundBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntityEntry;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.client.renderer.block.GlowPlushBlockRenderer;
import net.thebrokenscript.client.renderer.block.PlushBlockRenderer;
import net.thebrokenscript.item.PlushItem;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.DevPlush;
import net.thebrokenscript.registry.TBSCreativeTabs;
import net.thebrokenscript.registry.TBSPlushies;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020%H\u0002R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2={"Lnet/thebrokenscript/registry/TBSPlushies;", "", "<init>", "()V", "BENNIE", "Lnet/thebrokenscript/registry/DevPlush;", "DOMINIK", "EBRIDGER", "GARRETH", "JD", "LOVEMIST", "MOJI", "NAHBRO", "RAEVANT", "REDSTONE", "SHADOW", "STEVELOCKS", "TEKKIT", "WENDIGO", "YHARIM", "ZETOS", "EYAE", "ELDRITCH", "ELDERLY", "SKIE", "HERMIT", "RDH", "MC", "PYRIT", "LOST", "BERRY", "plush", "name", "", "display", "sound", "glow", "", "thebrokenscript-common"})
public final class TBSPlushies {
    @NotNull
    public static final TBSPlushies INSTANCE = new TBSPlushies();
    @JvmField
    @NotNull
    public static final DevPlush BENNIE = TBSPlushies.plush$default(INSTANCE, "bennie", null, null, false, 14, null);
    @JvmField
    @NotNull
    public static final DevPlush DOMINIK = TBSPlushies.plush$default(INSTANCE, "dominik", null, "plush/dominik", false, 8, null);
    @JvmField
    @NotNull
    public static final DevPlush EBRIDGER = TBSPlushies.plush$default(INSTANCE, "ebridger", null, "plush/ebridger", false, 8, null);
    @JvmField
    @NotNull
    public static final DevPlush GARRETH = INSTANCE.plush("garreth", null, "plush/garreth", true);
    @JvmField
    @NotNull
    public static final DevPlush JD = TBSPlushies.plush$default(INSTANCE, "jd", "JD Plush", null, false, 12, null);
    @JvmField
    @NotNull
    public static final DevPlush LOVEMIST = TBSPlushies.plush$default(INSTANCE, "lovemist", "L0V3M1ST Plush", "plush/l0v3m1st", false, 8, null);
    @JvmField
    @NotNull
    public static final DevPlush MOJI = TBSPlushies.plush$default(INSTANCE, "moji", null, null, false, 14, null);
    @JvmField
    @NotNull
    public static final DevPlush NAHBRO = TBSPlushies.plush$default(INSTANCE, "nahbro", "NahBro Plush", "plush/nahbro", false, 8, null);
    @JvmField
    @NotNull
    public static final DevPlush RAEVANT = TBSPlushies.plush$default(INSTANCE, "raevant", null, null, false, 14, null);
    @JvmField
    @NotNull
    public static final DevPlush REDSTONE = INSTANCE.plush("redstone", null, "plush/redstone", true);
    @JvmField
    @NotNull
    public static final DevPlush SHADOW = INSTANCE.plush("shadow", "shadowmaster435 Plush", null, true);
    @JvmField
    @NotNull
    public static final DevPlush STEVELOCKS = INSTANCE.plush("stevelocks", null, "plush/stevelocks", true);
    @JvmField
    @NotNull
    public static final DevPlush TEKKIT = TBSPlushies.plush$default(INSTANCE, "tekkit", null, "plush/tekkit", false, 8, null);
    @JvmField
    @NotNull
    public static final DevPlush WENDIGO = TBSPlushies.plush$default(INSTANCE, "wendigo", null, null, false, 14, null);
    @JvmField
    @NotNull
    public static final DevPlush YHARIM = INSTANCE.plush("yharim", null, null, true);
    @JvmField
    @NotNull
    public static final DevPlush ZETOS = INSTANCE.plush("zetos", null, "plush/zetos", true);
    @JvmField
    @NotNull
    public static final DevPlush EYAE = INSTANCE.plush("eyae", null, "plush/eyae", true);
    @JvmField
    @NotNull
    public static final DevPlush ELDRITCH = INSTANCE.plush("eldritch", "Prime Eldritch", null, true);
    @JvmField
    @NotNull
    public static final DevPlush ELDERLY = INSTANCE.plush("elderly", "Current Elderly", null, true);
    @JvmField
    @NotNull
    public static final DevPlush SKIE = TBSPlushies.plush$default(INSTANCE, "skie", null, null, false, 14, null);
    @JvmField
    @NotNull
    public static final DevPlush HERMIT = INSTANCE.plush("hermit", "Hermit Plushie", "plush/hermit", true);
    @JvmField
    @NotNull
    public static final DevPlush RDH = INSTANCE.plush("rdh", "rdh plushie", null, true);
    @JvmField
    @NotNull
    public static final DevPlush MC = INSTANCE.plush("mc", "MC_3699 Plushie", null, true);
    @JvmField
    @NotNull
    public static final DevPlush PYRIT = TBSPlushies.plush$default(INSTANCE, "pyrit", "Pyrit Plushie", "plush/pyrit", false, 8, null);
    @JvmField
    @NotNull
    public static final DevPlush LOST = INSTANCE.plush("lost", "LostNeedMap Plushie", "plush/lost", true);
    @JvmField
    @NotNull
    public static final DevPlush BERRY = TBSPlushies.plush$default(INSTANCE, "berry", "ChoosingBerry Plushie", null, false, 12, null);

    private TBSPlushies() {
    }

    private final DevPlush plush(String name, String display, String sound, boolean glow) {
        RegistryEntry registryEntry;
        Ref.ObjectRef entity = new Ref.ObjectRef();
        String string = sound;
        if (string != null) {
            String it = string;
            boolean bl = false;
            registryEntry = TBSReg.INSTANCE.sound("plush." + name + ".squish", arg_0 -> TBSPlushies.plush$lambda$0$0(it, arg_0));
        } else {
            registryEntry = null;
        }
        RegistryEntry sound2 = registryEntry;
        BlockEntry block = TBSReg.INSTANCE.block(name + "_plush", arg_0 -> TBSPlushies.plush$lambda$1(entity, sound2, arg_0), arg_0 -> TBSPlushies.plush$lambda$2(display, name, sound2, arg_0));
        entity.element = TBSReg.INSTANCE.blockEntity(name + "_plush", plush.1.INSTANCE, arg_0 -> TBSPlushies.plush$lambda$3(block, glow, name, arg_0));
        return new DevPlush((BlockEntry<PlushBlock>)block, (BlockEntityEntry<PlushBlockEntity>)((BlockEntityEntry)entity.element));
    }

    static /* synthetic */ DevPlush plush$default(TBSPlushies tBSPlushies, String string, String string2, String string3, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            string2 = null;
        }
        if ((n & 4) != 0) {
            string3 = null;
        }
        if ((n & 8) != 0) {
            bl = false;
        }
        return tBSPlushies.plush(string, string2, string3, bl);
    }

    private static final void plush$lambda$0$0(String $it, SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.file$default((SoundBuilder)$this$sound, (String)$it, null, (int)2, null);
        $this$sound.subtitle = "Plush Squishes";
    }

    private static final PlushBlock plush$lambda$1(Ref.ObjectRef $entity, RegistryEntry $sound, BlockBehaviour.Properties p) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Object object = $entity.element;
        Intrinsics.checkNotNull((Object)object);
        return new PlushBlock((BlockEntityEntry<? extends PlushBlockEntity>)((BlockEntityEntry)object), p, (RegistryEntry<SoundEvent, SoundEvent>)$sound);
    }

    private static final void plush$lambda$2(String $display, String $name, RegistryEntry $sound, BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSPlushies::plush$lambda$2$0);
        $this$block.item(arg_0 -> TBSPlushies.plush$lambda$2$1($display, $name, $sound, arg_0));
        if ($display != null) {
            $this$block.lang = $display;
        }
        $this$block.simpleLoot();
    }

    private static final void plush$lambda$2$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.sound(SoundType.WOOL);
        $this$props.noOcclusion();
    }

    private static final void plush$lambda$2$1(String $display, String $name, RegistryEntry $sound, BlockItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.setCtor(arg_0 -> TBSPlushies.plush$lambda$2$1$0($name, $this$item, $sound, arg_0));
        $this$item.model(arg_0 -> TBSPlushies.plush$lambda$2$1$1($this$item, arg_0));
        if ($display != null) {
            $this$item.lang = $display;
        }
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final PlushItem plush$lambda$2$1$0(String $name, BlockItemBuilder $this_item, RegistryEntry $sound, Item.Properties p) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        return new PlushItem($name, $this_item.getBlock(), p, (RegistryEntry<SoundEvent, SoundEvent>)$sound);
    }

    private static final void plush$lambda$2$1$1(BlockItemBuilder $this_item, BCBlockItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        ((ItemModelBuilder)$this$model.getBuilder($this_item.getId())).parent((ModelFile)new ModelFile.UncheckedModelFile("builtin/entity"));
    }

    private static final void plush$lambda$3(BlockEntry $block, boolean $glow, String $name, BlockEntityBuilder $this$blockEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$blockEntity, (String)"$this$blockEntity");
        ((Collection)$this$blockEntity.getValidBlocks()).add($block);
        $this$blockEntity.setRenderer(() -> TBSPlushies.plush$lambda$3$0($glow, $name));
    }

    private static final Function1 plush$lambda$3$0(boolean $glow, String $name) {
        return arg_0 -> TBSPlushies.plush$lambda$3$0$0($glow, $name, arg_0);
    }

    private static final GeoBlockRenderer plush$lambda$3$0$0(boolean $glow, String $name, BlockEntityRendererProvider.Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"<unused var>");
        return $glow ? (GeoBlockRenderer)new GlowPlushBlockRenderer($name) : (GeoBlockRenderer)new PlushBlockRenderer($name);
    }
}

