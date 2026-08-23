/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Rarity
 *  net.thebrokenscript.brokencore.api.datagen.providers.BCItemModelProvider
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  net.thebrokenscript.brokencore.api.registry.builders.ItemBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.item.RecipeBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.item.ShapelessCraftingBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.ItemEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.datagen.providers.BCItemModelProvider;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.registry.builders.ItemBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.item.RecipeBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.item.ShapelessCraftingBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import net.thebrokenscript.item.GoreItem;
import net.thebrokenscript.item.HandCannonItem;
import net.thebrokenscript.item.LibraryBookItem;
import net.thebrokenscript.item.LinkerItem;
import net.thebrokenscript.item.NItem;
import net.thebrokenscript.item.PolaroidItem;
import net.thebrokenscript.item.TornPaperItem;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSItems;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.registry.TBSSongs;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/registry/TBSItems;", "", "<init>", "()V", "SERIAL_DESIGNATION_N", "Lnet/thebrokenscript/brokencore/api/registry/objects/ItemEntry;", "Lnet/thebrokenscript/item/NItem;", "TORN_PIECE_1", "Lnet/minecraft/world/item/Item;", "TORN_PIECE_2", "TORN_PIECE_3", "TORN_PIECE_4", "TORN_PIECE_5", "POLAROID", "Lnet/thebrokenscript/item/PolaroidItem;", "TORN_PAPER", "Lnet/thebrokenscript/item/TornPaperItem;", "GORE", "Lnet/thebrokenscript/item/GoreItem;", "RECORD_17", "RECORD_14", "RECORD_15", "RECORD_16", "INSTABILITY", "INSTABILITYV2", "INSTABILITYV3", "INSTABILITY_MUSIC_BOX", "ATTRIBUTE_MUTILATION", "CREDITS", "LINKER", "Lnet/thebrokenscript/item/LinkerItem;", "LIBRARY_BOOK", "Lnet/thebrokenscript/item/LibraryBookItem;", "INTEGRITY_FIREBALL", "HAND_CANNON", "Lnet/thebrokenscript/item/HandCannonItem;", "thebrokenscript-common"})
public final class TBSItems {
    @NotNull
    public static final TBSItems INSTANCE = new TBSItems();
    @JvmField
    @NotNull
    public static final ItemEntry<NItem> SERIAL_DESIGNATION_N = TBSReg.INSTANCE.item("n", SERIAL_DESIGNATION_N.1.INSTANCE, TBSItems::SERIAL_DESIGNATION_N$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> TORN_PIECE_1 = TBSReg.INSTANCE.defaultItem("piece_1", TBSItems::TORN_PIECE_1$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> TORN_PIECE_2 = TBSReg.INSTANCE.defaultItem("piece_2", TBSItems::TORN_PIECE_2$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> TORN_PIECE_3 = TBSReg.INSTANCE.defaultItem("piece_3", TBSItems::TORN_PIECE_3$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> TORN_PIECE_4 = TBSReg.INSTANCE.defaultItem("piece_4", TBSItems::TORN_PIECE_4$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> TORN_PIECE_5 = TBSReg.INSTANCE.defaultItem("piece_5", TBSItems::TORN_PIECE_5$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<PolaroidItem> POLAROID = TBSReg.INSTANCE.item("polaroid", POLAROID.1.INSTANCE, TBSItems::POLAROID$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<TornPaperItem> TORN_PAPER = TBSReg.INSTANCE.item("torn_paper", TORN_PAPER.1.INSTANCE, TBSItems::TORN_PAPER$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<GoreItem> GORE = TBSReg.INSTANCE.item("gore", GORE.1.INSTANCE, TBSItems::GORE$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> RECORD_17 = TBSReg.INSTANCE.defaultItem("record_17", TBSItems::RECORD_17$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> RECORD_14 = TBSReg.INSTANCE.defaultItem("record_14", TBSItems::RECORD_14$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> RECORD_15 = TBSReg.INSTANCE.defaultItem("record_15", TBSItems::RECORD_15$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> RECORD_16 = TBSReg.INSTANCE.defaultItem("record_16", TBSItems::RECORD_16$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> INSTABILITY = TBSReg.INSTANCE.defaultItem("instability", TBSItems::INSTABILITY$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> INSTABILITYV2 = TBSReg.INSTANCE.defaultItem("instabilityv2", TBSItems::INSTABILITYV2$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> INSTABILITYV3 = TBSReg.INSTANCE.defaultItem("instabilityv3", TBSItems::INSTABILITYV3$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> INSTABILITY_MUSIC_BOX = TBSReg.INSTANCE.defaultItem("instability_music_box", TBSItems::INSTABILITY_MUSIC_BOX$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> ATTRIBUTE_MUTILATION = TBSReg.INSTANCE.defaultItem("attribute_mutilation", TBSItems::ATTRIBUTE_MUTILATION$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> CREDITS = TBSReg.INSTANCE.defaultItem("credits", TBSItems::CREDITS$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<LinkerItem> LINKER = TBSReg.INSTANCE.item("portal_linker", LINKER.1.INSTANCE, TBSItems::LINKER$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<LibraryBookItem> LIBRARY_BOOK = TBSReg.INSTANCE.item("book", LIBRARY_BOOK.1.INSTANCE, TBSItems::LIBRARY_BOOK$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<Item> INTEGRITY_FIREBALL = TBSReg.INSTANCE.defaultItem("integrity_fireball", TBSItems::INTEGRITY_FIREBALL$lambda$0);
    @JvmField
    @NotNull
    public static final ItemEntry<HandCannonItem> HAND_CANNON = TBSReg.INSTANCE.item("hand_cannon", HAND_CANNON.1.INSTANCE, TBSItems::HAND_CANNON$lambda$0);

    private TBSItems() {
    }

    private static final void SERIAL_DESIGNATION_N$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "name.null";
        $this$item.props(TBSItems::SERIAL_DESIGNATION_N$lambda$0$0);
        $this$item.model(TBSItems::SERIAL_DESIGNATION_N$lambda$0$1);
    }

    private static final void SERIAL_DESIGNATION_N$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(64);
        $this$props.rarity(Rarity.COMMON);
    }

    private static final void SERIAL_DESIGNATION_N$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void TORN_PIECE_1$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Polaroid Piece 1";
        if (PlatformUtil.Companion.isProduction()) {
            $this$item.noTab();
        }
        $this$item.props(TBSItems::TORN_PIECE_1$lambda$0$0);
        $this$item.model(TBSItems::TORN_PIECE_1$lambda$0$1);
    }

    private static final void TORN_PIECE_1$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.UNCOMMON);
        $this$props.fireResistant();
    }

    private static final void TORN_PIECE_1$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void TORN_PIECE_2$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Polaroid Piece 2";
        if (PlatformUtil.Companion.isProduction()) {
            $this$item.noTab();
        }
        $this$item.props(TBSItems::TORN_PIECE_2$lambda$0$0);
        $this$item.model(TBSItems::TORN_PIECE_2$lambda$0$1);
    }

    private static final void TORN_PIECE_2$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.UNCOMMON);
        $this$props.fireResistant();
    }

    private static final void TORN_PIECE_2$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void TORN_PIECE_3$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Polaroid Piece 3";
        if (PlatformUtil.Companion.isProduction()) {
            $this$item.noTab();
        }
        $this$item.props(TBSItems::TORN_PIECE_3$lambda$0$0);
        $this$item.model(TBSItems::TORN_PIECE_3$lambda$0$1);
    }

    private static final void TORN_PIECE_3$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.UNCOMMON);
        $this$props.fireResistant();
    }

    private static final void TORN_PIECE_3$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void TORN_PIECE_4$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Polaroid Piece 4";
        if (PlatformUtil.Companion.isProduction()) {
            $this$item.noTab();
        }
        $this$item.props(TBSItems::TORN_PIECE_4$lambda$0$0);
        $this$item.model(TBSItems::TORN_PIECE_4$lambda$0$1);
    }

    private static final void TORN_PIECE_4$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.UNCOMMON);
        $this$props.fireResistant();
    }

    private static final void TORN_PIECE_4$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void TORN_PIECE_5$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Polaroid Piece 5";
        if (PlatformUtil.Companion.isProduction()) {
            $this$item.noTab();
        }
        $this$item.props(TBSItems::TORN_PIECE_5$lambda$0$0);
        $this$item.model(TBSItems::TORN_PIECE_5$lambda$0$1);
    }

    private static final void TORN_PIECE_5$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.UNCOMMON);
        $this$props.fireResistant();
    }

    private static final void TORN_PIECE_5$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void POLAROID$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "The Polaroid";
        if (PlatformUtil.Companion.isProduction()) {
            $this$item.noTab();
        }
        $this$item.props(TBSItems::POLAROID$lambda$0$0);
        $this$item.model(TBSItems::POLAROID$lambda$0$1);
        $this$item.recipe(TBSItems::POLAROID$lambda$0$2);
    }

    private static final void POLAROID$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.RARE);
        $this$props.fireResistant();
    }

    private static final void POLAROID$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final Unit POLAROID$lambda$0$2(RecipeBuilder $this$recipe) {
        Intrinsics.checkNotNullParameter((Object)$this$recipe, (String)"$this$recipe");
        $this$recipe.shapeless(TBSItems::POLAROID$lambda$0$2$0);
        return Unit.INSTANCE;
    }

    private static final Unit POLAROID$lambda$0$2$0(ShapelessCraftingBuilder $this$shapeless) {
        Intrinsics.checkNotNullParameter((Object)$this$shapeless, (String)"$this$shapeless");
        $this$shapeless.ingredient((Holder)TORN_PIECE_1);
        $this$shapeless.ingredient((Holder)TORN_PIECE_2);
        $this$shapeless.ingredient((Holder)TORN_PIECE_3);
        $this$shapeless.ingredient((Holder)TORN_PIECE_4);
        $this$shapeless.ingredient((Holder)TORN_PIECE_5);
        return Unit.INSTANCE;
    }

    private static final void TORN_PAPER$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Torn Paper";
        if (PlatformUtil.Companion.isProduction()) {
            $this$item.noTab();
        }
        $this$item.props(TBSItems::TORN_PAPER$lambda$0$0);
        $this$item.model(TBSItems::TORN_PAPER$lambda$0$1);
    }

    private static final void TORN_PAPER$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.UNCOMMON);
        $this$props.fireResistant();
    }

    private static final void TORN_PAPER$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void GORE$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "name.revuxor";
        $this$item.props(TBSItems::GORE$lambda$0$0);
        $this$item.model(TBSItems::GORE$lambda$0$1);
    }

    private static final void GORE$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(64);
        $this$props.rarity(Rarity.COMMON);
    }

    private static final void GORE$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void RECORD_17$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::RECORD_17$lambda$0$0);
        $this$item.model(TBSItems::RECORD_17$lambda$0$1);
    }

    private static final void RECORD_17$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.RARE);
        $this$props.jukeboxPlayable(TBSSongs.DISC_17_SILENCED.getKey());
    }

    private static final void RECORD_17$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem(), TBSConstants.id("item/revuxor_disc"));
    }

    private static final void RECORD_14$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::RECORD_14$lambda$0$0);
        $this$item.model(TBSItems::RECORD_14$lambda$0$1);
    }

    private static final void RECORD_14$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.RARE);
        $this$props.jukeboxPlayable(TBSSongs.DISC_14.getKey());
    }

    private static final void RECORD_14$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem(), $this$model.mcLoc("item/music_disc_13"));
    }

    private static final void RECORD_15$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::RECORD_15$lambda$0$0);
        $this$item.model(TBSItems::RECORD_15$lambda$0$1);
    }

    private static final void RECORD_15$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.RARE);
        $this$props.jukeboxPlayable(TBSSongs.DISC_15_BETRAY.getKey());
    }

    private static final void RECORD_15$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem(), $this$model.mcLoc("item/music_disc_cat"));
    }

    private static final void RECORD_16$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::RECORD_16$lambda$0$0);
        $this$item.model(TBSItems::RECORD_16$lambda$0$1);
    }

    private static final void RECORD_16$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.RARE);
        $this$props.jukeboxPlayable(TBSSongs.DISC_16_YOUCANT.getKey());
    }

    private static final void RECORD_16$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem(), $this$model.mcLoc("item/music_disc_11"));
    }

    private static final void INSTABILITY$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::INSTABILITY$lambda$0$0);
        $this$item.model(TBSItems::INSTABILITY$lambda$0$1);
    }

    private static final void INSTABILITY$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.RARE);
        $this$props.jukeboxPlayable(TBSSongs.INSTABILITY.getKey());
    }

    private static final void INSTABILITY$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.musicDisc($this$model.getItem());
    }

    private static final void INSTABILITYV2$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::INSTABILITYV2$lambda$0$0);
        $this$item.model(TBSItems::INSTABILITYV2$lambda$0$1);
    }

    private static final void INSTABILITYV2$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.EPIC);
        $this$props.jukeboxPlayable(TBSSongs.INSTABILITYV2.getKey());
    }

    private static final void INSTABILITYV2$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.musicDisc($this$model.getItem());
    }

    private static final void INSTABILITYV3$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::INSTABILITYV3$lambda$0$0);
        $this$item.model(TBSItems::INSTABILITYV3$lambda$0$1);
    }

    private static final void INSTABILITYV3$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.EPIC);
        $this$props.jukeboxPlayable(TBSSongs.INSTABILITYV3.getKey());
    }

    private static final void INSTABILITYV3$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.musicDisc($this$model.getItem());
    }

    private static final void INSTABILITY_MUSIC_BOX$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::INSTABILITY_MUSIC_BOX$lambda$0$0);
        $this$item.model(TBSItems::INSTABILITY_MUSIC_BOX$lambda$0$1);
    }

    private static final void INSTABILITY_MUSIC_BOX$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.RARE);
        $this$props.jukeboxPlayable(TBSSongs.INSTABILITY_MUSIC_BOX.getKey());
    }

    private static final void INSTABILITY_MUSIC_BOX$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.musicDisc($this$model.getItem());
    }

    private static final void ATTRIBUTE_MUTILATION$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::ATTRIBUTE_MUTILATION$lambda$0$0);
        $this$item.model(TBSItems::ATTRIBUTE_MUTILATION$lambda$0$1);
    }

    private static final void ATTRIBUTE_MUTILATION$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.RARE);
        $this$props.jukeboxPlayable(TBSSongs.JIMBOB.getKey());
    }

    private static final void ATTRIBUTE_MUTILATION$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.musicDisc($this$model.getItem());
    }

    private static final void CREDITS$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Music Disc";
        $this$item.props(TBSItems::CREDITS$lambda$0$0);
        $this$item.model(TBSItems::CREDITS$lambda$0$1);
    }

    private static final void CREDITS$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
        $this$props.rarity(Rarity.RARE);
        $this$props.jukeboxPlayable(TBSSongs.CREDITS.getKey());
    }

    private static final void CREDITS$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem(), $this$model.mcLoc("item/music_disc_11"));
    }

    private static final void LINKER$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.props(TBSItems::LINKER$lambda$0$0);
        $this$item.model(TBSItems::LINKER$lambda$0$1);
    }

    private static final void LINKER$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
    }

    private static final void LINKER$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void LIBRARY_BOOK$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.noTab();
        $this$item.props(TBSItems::LIBRARY_BOOK$lambda$0$0);
        $this$item.lang = "Book";
    }

    private static final void LIBRARY_BOOK$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
    }

    private static final void INTEGRITY_FIREBALL$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "This is an item for dev purposes lol. You shouldn't have this...";
        $this$item.noTab();
        $this$item.props(TBSItems::INTEGRITY_FIREBALL$lambda$0$0);
        $this$item.model(TBSItems::INTEGRITY_FIREBALL$lambda$0$1);
    }

    private static final void INTEGRITY_FIREBALL$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
    }

    private static final void INTEGRITY_FIREBALL$lambda$0$1(BCItemModelProvider $this$model) {
        Intrinsics.checkNotNullParameter((Object)$this$model, (String)"$this$model");
        $this$model.basicItem($this$model.getItem());
    }

    private static final void HAND_CANNON$lambda$0(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.lang = "Tekkit's Hand Cannon";
        $this$item.noTab();
        $this$item.props(TBSItems::HAND_CANNON$lambda$0$0);
    }

    private static final void HAND_CANNON$lambda$0$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.stacksTo(1);
    }
}

