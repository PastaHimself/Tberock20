/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.EquipmentSlotGroup
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.item.AxeItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Tiers
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.handlers.subs.ItemAttributeModifierSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/AxeDamageHandler;", "", "<init>", "()V", "AXE_DAMAGE", "", "Lnet/minecraft/world/item/Tiers;", "", "thebrokenscript-common"})
public final class AxeDamageHandler {
    @NotNull
    public static final AxeDamageHandler INSTANCE = new AxeDamageHandler();
    @NotNull
    private static final Map<Tiers, Double> AXE_DAMAGE;

    private AxeDamageHandler() {
    }

    private static final Unit _init_$lambda$0(ItemStack itemStack, Function2 removeModifier, Function3 addModifier) {
        Intrinsics.checkNotNullParameter((Object)itemStack, (String)"itemStack");
        Intrinsics.checkNotNullParameter((Object)removeModifier, (String)"removeModifier");
        Intrinsics.checkNotNullParameter((Object)addModifier, (String)"addModifier");
        if (TBSConfigs.INSTANCE.getServer().getDanger().getDisableAttackCooldown()) {
            double d;
            Item item = itemStack.getItem();
            if (!(item instanceof AxeItem)) {
                return Unit.INSTANCE;
            }
            Double d2 = AXE_DAMAGE.get(((AxeItem)item).getTier());
            if (d2 != null) {
                d = d2;
            } else {
                Double d3 = AXE_DAMAGE.get(Tiers.WOOD);
                Intrinsics.checkNotNull((Object)d3);
                d = ((Number)d3).doubleValue();
            }
            double damage = d;
            Holder holder2 = Attributes.ATTACK_DAMAGE;
            Intrinsics.checkNotNullExpressionValue((Object)holder2, (String)"ATTACK_DAMAGE");
            ResourceLocation resourceLocation = Item.BASE_ATTACK_DAMAGE_ID;
            Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"BASE_ATTACK_DAMAGE_ID");
            removeModifier.invoke((Object)holder2, (Object)resourceLocation);
            Holder holder3 = Attributes.ATTACK_DAMAGE;
            Intrinsics.checkNotNullExpressionValue((Object)holder3, (String)"ATTACK_DAMAGE");
            addModifier.invoke((Object)holder3, (Object)new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, damage, AttributeModifier.Operation.ADD_VALUE), (Object)EquipmentSlotGroup.MAINHAND);
        }
        return Unit.INSTANCE;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)Tiers.WOOD, (Object)2.0), TuplesKt.to((Object)Tiers.GOLD, (Object)2.0), TuplesKt.to((Object)Tiers.STONE, (Object)3.0), TuplesKt.to((Object)Tiers.IRON, (Object)4.0), TuplesKt.to((Object)Tiers.DIAMOND, (Object)5.0), TuplesKt.to((Object)Tiers.NETHERITE, (Object)6.0)};
        AXE_DAMAGE = MapsKt.mapOf((Pair[])pairArray);
        ItemAttributeModifierSubscriber.INSTANCE.add((Function3<? super ItemStack, ? super Function2<? super Holder<Attribute>, ? super ResourceLocation, Unit>, ? super Function3<? super Holder<Attribute>, ? super AttributeModifier, ? super EquipmentSlotGroup, Unit>, Unit>)((Function3)AxeDamageHandler::_init_$lambda$0));
    }
}

