/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.thebrokenscript.block.PlushBlock;
import net.thebrokenscript.handlers.subs.LivingDeathSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSPlushies;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R/\u0010\u0004\u001a\u0016\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\b0\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/handlers/PlushDropHandler;", "", "<init>", "()V", "dropTable", "", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "Lnet/minecraft/world/item/ItemStack;", "getDropTable", "()Ljava/util/Map;", "dropTable$delegate", "Lkotlin/Lazy;", "thebrokenscript-common"})
public final class PlushDropHandler {
    @NotNull
    public static final PlushDropHandler INSTANCE = new PlushDropHandler();
    @NotNull
    private static final Lazy dropTable$delegate = LazyKt.lazy(PlushDropHandler::dropTable_delegate$lambda$0);

    private PlushDropHandler() {
    }

    private final Map<UUID, ItemStack> getDropTable() {
        Lazy lazy = dropTable$delegate;
        return (Map)lazy.getValue();
    }

    private static final Map dropTable_delegate$lambda$0() {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)UUID.fromString("ed8707c4-1682-4f2b-8012-084b6d0c939b"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.TEKKIT.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("37f98c22-d293-4c64-83cd-a11b08a02ef7"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.EBRIDGER.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("6ab51c91-ff69-4a14-831f-4b054659fe46"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.ELDRITCH.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("79e52617-1b09-422f-8a48-36e37ed1f654"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.EYAE.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("1c1f8991-0677-4a81-bc79-aedb0cdc907c"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.GARRETH.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("7852b781-518c-4e3e-8d76-eca585660d4d"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.DOMINIK.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("5519aae9-86ca-4492-85d3-0ba4fd0a4902"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.ZETOS.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("23088966-c1fd-40df-9620-8f435aa547bb"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.MOJI.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("e7252b66-80f2-4a52-b51b-49a0d1d4f6f4"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.HERMIT.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("e632f409-6cdf-459a-a6e9-f4d1c2f5fcd9"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.LOVEMIST.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("111dff66-087b-4948-bbd4-f47ed46af6ac"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.REDSTONE.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("72051012-1117-4c1c-a1b4-24a4d1fc6886"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.YHARIM.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("2f877994-ec35-47c4-8521-a41f894ae824"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.SHADOW.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("38714e47-bd84-42d3-bfe4-d2f78e8dbc68"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.JD.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("9b09a9da-5ba5-42d7-86d2-362c1a053258"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.RAEVANT.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("d556104f-bb17-466a-939a-aefc563c33cd"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.NAHBRO.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("e89c896c-ee77-4b44-a1ac-005c3a219242"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.WENDIGO.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("0849bc57-4d67-414b-a371-b71c45e02a14"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.STEVELOCKS.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("07febe18-4d28-4e54-bf02-b1a89a0d5058"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.PYRIT.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("6479c5ab-902a-4f50-952c-91eeb4552e05"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.MC.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("498d38a2-bf3c-4088-a866-be1854ed09f8"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.LOST.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("82aa54c4-c65a-4a66-8ef8-39388a612480"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.BERRY.getBlock().get())).asItem())), TuplesKt.to((Object)UUID.fromString("772de4f4-5391-4c45-9594-6db8f3e620c1"), (Object)new ItemStack((ItemLike)((PlushBlock)((Object)TBSPlushies.SKIE.getBlock().get())).asItem()))};
        return MapsKt.mapOf((Pair[])pairArray);
    }

    private static final Unit _init_$lambda$0(LivingEntity entity, DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"<unused var>");
        if (!(entity instanceof Player)) {
            return Unit.INSTANCE;
        }
        if (entity.level().isClientSide) {
            return Unit.INSTANCE;
        }
        ItemStack itemStack = INSTANCE.getDropTable().get(((Player)entity).getUUID());
        if (itemStack == null) {
            return Unit.INSTANCE;
        }
        ItemStack plush2 = itemStack;
        ItemEntity drop = new ItemEntity(entity.level(), ((Player)entity).getX(), ((Player)entity).getY(), ((Player)entity).getZ(), plush2);
        entity.level().addFreshEntity((Entity)drop);
        return Unit.INSTANCE;
    }

    static {
        LivingDeathSubscriber.INSTANCE.add((Function2<? super LivingEntity, ? super DamageSource, Unit>)((Function2)PlushDropHandler::_init_$lambda$0));
    }
}

