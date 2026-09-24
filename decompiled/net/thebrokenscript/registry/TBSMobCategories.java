/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  fuzs.extensibleenums.api.v2.BuiltInEnumFactories
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.MobCategory
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import fuzs.extensibleenums.api.v2.BuiltInEnumFactories;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.MobCategory;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/registry/TBSMobCategories;", "", "<init>", "()V", "MOBS", "Lnet/minecraft/world/entity/MobCategory;", "thebrokenscript-common"})
public final class TBSMobCategories {
    @NotNull
    public static final TBSMobCategories INSTANCE = new TBSMobCategories();
    @JvmField
    @NotNull
    public static final MobCategory MOBS;

    private TBSMobCategories() {
    }

    static {
        MobCategory mobCategory = BuiltInEnumFactories.INSTANCE.createMobCategory(TBSConstants.id("mobs"), "thebrokenscript:mobs", 20, false, false, 128);
        Intrinsics.checkNotNullExpressionValue((Object)mobCategory, (String)"createMobCategory(...)");
        MOBS = mobCategory;
    }
}

