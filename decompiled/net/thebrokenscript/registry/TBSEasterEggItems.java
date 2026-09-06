/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.food.FoodProperties$Builder
 *  net.minecraft.world.food.Foods
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Rarity
 *  net.thebrokenscript.brokencore.api.datagen.providers.BCItemModelProvider
 *  net.thebrokenscript.brokencore.api.ext.PropertiesExt
 *  net.thebrokenscript.brokencore.api.registry.builders.ItemBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.ItemEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.thebrokenscript.brokencore.api.datagen.providers.BCItemModelProvider;
import net.thebrokenscript.brokencore.api.ext.PropertiesExt;
import net.thebrokenscript.brokencore.api.registry.builders.ItemBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import net.thebrokenscript.item.GlaggleItem;
import net.thebrokenscript.item.LillyDiscItem;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSCreativeTabs;
import net.thebrokenscript.registry.TBSEasterEggItems;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.registry.TBSSongs;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/registry/TBSEasterEggItems;", "", "<init>", "()V", "cod", "Lnet/thebrokenscript/brokencore/api/registry/objects/ItemEntry;", "Lnet/minecraft/world/item/Item;", "id", "", "name", "NULL_BREAD", "CIRCUIT_BREAD", "NULL_COD", "REVUXORFISH", "FARAWAY_SALMON", "GLAGGLE", "Lnet/thebrokenscript/item/GlaggleItem;", "BENNIE_COD", "V1_COD", "SHADOWMASTER_COD", "REDSTONE_COD", "CORRUPT_EBRIDGER_COD", "DOMINIK_COD", "EBRIDGER_COD", "ELDRITCH_COD", "EVIL_CODSTONE_COD", "EYAE_COD", "GARRETH_COD", "JD_COD", "LOST_NEED_COD", "PENCIL_COD", "V2_COD", "TEKKIT_COD", "ZETOS_COD", "LILLY", "Lnet/thebrokenscript/item/LillyDiscItem;", "LILLY_V2", "thebrokenscript-common"})
public final class TBSEasterEggItems {
    @NotNull
    public static final TBSEasterEggItems INSTANCE = new TBSEasterEggItems();
    @JvmField
    @NotNull
    public static final ItemEntry<Item> NULL_BREAD = TBSReg.INSTANCE.defaultItem("null_bread", TBSEasterEggItems::NULL_BREAD$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> CIRCUIT_BREAD = TBSReg.INSTANCE.defaultItem("circuit_bread", TBSEasterEggItems::CIRCUIT_BREAD$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> NULL_COD = TBSReg.INSTANCE.defaultItem("null_cod", TBSEasterEggItems::NULL_COD$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> REVUXORFISH = TBSReg.INSTANCE.defaultItem("revuxorfish", TBSEasterEggItems::REVUXORFISH$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> FARAWAY_SALMON = TBSReg.INSTANCE.defaultItem("faraway_salmon", TBSEasterEggItems::FARAWAY_SALMON$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<GlaggleItem> GLAGGLE = TBSReg.INSTANCE.item("glaggle", GLAGGLE.1.INSTANCE, TBSEasterEggItems::GLAGGLE$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> BENNIE_COD = TBSEasterEggItems.cod("bennie_cod", "Bennie Cod");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> V1_COD = TBSEasterEggItems.cod("v1_cod", "C1");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> SHADOWMASTER_COD = TBSEasterEggItems.cod("shadowmaster_cod", "Codmaster435");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> REDSTONE_COD = TBSEasterEggItems.cod("redstone_cod", "Codstone");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> CORRUPT_EBRIDGER_COD = TBSEasterEggItems.cod("corrupt_ebridger_cod", "Corrupted Ebricod");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> DOMINIK_COD = TBSEasterEggItems.cod("dominik_cod", "DominikCOD");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> EBRIDGER_COD = TBSEasterEggItems.cod("ebridger_cod", "Ebricod");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> ELDRITCH_COD = TBSEasterEggItems.cod("eldritch_cod", "EldritchTheCod");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> EVIL_CODSTONE_COD = TBSEasterEggItems.cod("evil_codstone_cod", "Evil Codstone");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> EYAE_COD = TBSEasterEggItems.cod("eyae_cod", "Eyae Cod");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> GARRETH_COD = TBSEasterEggItems.cod("garreth_cod", "GareCod");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> JD_COD = TBSEasterEggItems.cod("jd_cod", "JDCod");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> LOST_NEED_COD = TBSEasterEggItems.cod("lost_need_cod", "LostNeedCod");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> PENCIL_COD = TBSEasterEggItems.cod("pencil_cod", "Mehish");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> V2_COD = TBSEasterEggItems.cod("v2_cod", "C2");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> TEKKIT_COD = TBSEasterEggItems.cod("tekkit_cod", "Tekcod Dooood");
    @JvmField
    @NotNull
    public static final ItemEntry<Item> ZETOS_COD = TBSEasterEggItems.cod("zetos_cod", "Zecod");
    @JvmField
    @NotNull
    public static final ItemEntry<LillyDiscItem> LILLY = TBSReg.INSTANCE.item("lilly", LILLY.1.INSTANCE, TBSEasterEggItems::LILLY$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<LillyDiscItem> LILLY_V2 = TBSReg.INSTANCE.item("lilly_v2", LILLY_V2.1.INSTANCE, TBSEasterEggItems::LILLY_V2$lambda$0);

    private TBSEasterEggItems() {
    }

    @JvmStatic
    @NotNull
    public static final ItemEntry<Item> cod(@NotNull String id, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return TBSReg.INSTANCE.item(id, cod.1.INSTANCE, arg_0 -> TBSEasterEggItems.cod$lambda$0(name, arg_0));
    }

    private static final void cod$lambda$0(String $name, ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.props(TBSEasterEggItems::cod$lambda$0$0);
        $this$item.model(TBSEasterEggItems::cod$lambda$0$1);
        $this$item.lang = $name;
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final void cod$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.food(Foods.COD);
    }

    private static final void cod$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void NULL_BREAD$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.props(TBSEasterEggItems::NULL_BREAD$lambda$0$0);
        $this$item.model(TBSEasterEggItems::NULL_BREAD$lambda$0$1);
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final void NULL_BREAD$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.foodProps($this$props, TBSEasterEggItems::NULL_BREAD$lambda$0$0$0);
    }

    private static final Unit NULL_BREAD$lambda$0$0$0(FoodProperties.Builder $this$foodProps) {
        Intrinsics.checkNotNullParameter((Object)$this$foodProps, (String)"$this$foodProps");
        $this$foodProps.alwaysEdible();
        $this$foodProps.fast();
        $this$foodProps.nutrition(-2);
        return Unit.INSTANCE;
    }

    private static final void NULL_BREAD$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void CIRCUIT_BREAD$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.props(TBSEasterEggItems::CIRCUIT_BREAD$lambda$0$0);
        $this$item.model(TBSEasterEggItems::CIRCUIT_BREAD$lambda$0$1);
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final void CIRCUIT_BREAD$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.foodProps($this$props, TBSEasterEggItems::CIRCUIT_BREAD$lambda$0$0$0);
    }

    private static final Unit CIRCUIT_BREAD$lambda$0$0$0(FoodProperties.Builder $this$foodProps) {
        Intrinsics.checkNotNullParameter((Object)$this$foodProps, (String)"$this$foodProps");
        $this$foodProps.alwaysEdible();
        $this$foodProps.fast();
        $this$foodProps.nutrition(-10);
        return Unit.INSTANCE;
    }

    private static final void CIRCUIT_BREAD$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void NULL_COD$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.props(TBSEasterEggItems::NULL_COD$lambda$0$0);
        $this$item.model(TBSEasterEggItems::NULL_COD$lambda$0$1);
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final void NULL_COD$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.foodProps($this$props, TBSEasterEggItems::NULL_COD$lambda$0$0$0);
    }

    private static final Unit NULL_COD$lambda$0$0$0(FoodProperties.Builder $this$foodProps) {
        Intrinsics.checkNotNullParameter((Object)$this$foodProps, (String)"$this$foodProps");
        $this$foodProps.alwaysEdible();
        $this$foodProps.nutrition(-3);
        return Unit.INSTANCE;
    }

    private static final void NULL_COD$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void REVUXORFISH$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.props(TBSEasterEggItems::REVUXORFISH$lambda$0$0);
        $this$item.model(TBSEasterEggItems::REVUXORFISH$lambda$0$1);
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final void REVUXORFISH$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.foodProps($this$props, TBSEasterEggItems::REVUXORFISH$lambda$0$0$0);
    }

    private static final Unit REVUXORFISH$lambda$0$0$0(FoodProperties.Builder $this$foodProps) {
        Intrinsics.checkNotNullParameter((Object)$this$foodProps, (String)"$this$foodProps");
        $this$foodProps.alwaysEdible();
        $this$foodProps.nutrition(-100);
        $this$foodProps.effect(new MobEffectInstance(MobEffects.WITHER, 240, 4), 1.0f);
        return Unit.INSTANCE;
    }

    private static final void REVUXORFISH$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void FARAWAY_SALMON$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Faraway Salmon";
        $this$item.props(TBSEasterEggItems::FARAWAY_SALMON$lambda$0$0);
        $this$item.model(TBSEasterEggItems::FARAWAY_SALMON$lambda$0$1);
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final void FARAWAY_SALMON$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        PropertiesExt.INSTANCE.foodProps($this$props, TBSEasterEggItems::FARAWAY_SALMON$lambda$0$0$0);
    }

    private static final Unit FARAWAY_SALMON$lambda$0$0$0(FoodProperties.Builder $this$foodProps) {
        Intrinsics.checkNotNullParameter((Object)$this$foodProps, (String)"$this$foodProps");
        $this$foodProps.alwaysEdible();
        $this$foodProps.nutrition(-100000);
        $this$foodProps.effect(new MobEffectInstance(MobEffects.HARM, 2, 5), 1.0f);
        $this$foodProps.effect(new MobEffectInstance(MobEffects.WITHER, 1000, 100), 1.0f);
        return Unit.INSTANCE;
    }

    private static final void FARAWAY_SALMON$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void GLAGGLE$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.props(TBSEasterEggItems::GLAGGLE$lambda$0$0);
        $this$item.model(TBSEasterEggItems::GLAGGLE$lambda$0$1);
        $this$item.lang = "Glaggle Token";
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final void GLAGGLE$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(16);
    }

    private static final void GLAGGLE$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void LILLY$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Foreign Music Disc";
        $this$item.props(TBSEasterEggItems::LILLY$lambda$0$0);
        $this$item.model(TBSEasterEggItems::LILLY$lambda$0$1);
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final void LILLY$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.EPIC);
        $this$props.jukeboxPlayable(TBSSongs.LILLY_THEME.getKey());
    }

    private static final void LILLY$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.musicDisc($this$model.getItem());
    }

    private static final void LILLY_V2$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Foreign Music Disc";
        $this$item.props(TBSEasterEggItems::LILLY_V2$lambda$0$0);
        $this$item.model(TBSEasterEggItems::LILLY_V2$lambda$0$1);
        $this$item.tab(TBSCreativeTabs.EASTER_EGGS.getKey());
    }

    private static final void LILLY_V2$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.EPIC);
        $this$props.jukeboxPlayable(TBSSongs.LILLY_THEME_V2.getKey());
    }

    private static final void LILLY_V2$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.musicDisc($this$model.getItem());
    }
}

