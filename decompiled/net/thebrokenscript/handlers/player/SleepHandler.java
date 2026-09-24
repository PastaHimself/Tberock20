/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.handlers.player;

import java.lang.constant.Constable;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseSiluetEntity;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.entity.NoTextureEntity;
import net.thebrokenscript.entity.nullent.NullFlyingEntity;
import net.thebrokenscript.entity.nullent.NullWatchingEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndEntity;
import net.thebrokenscript.entity.tbe.TheBrokenEndStalkEntity;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/handlers/player/SleepHandler;", "", "<init>", "()V", "easterEggMessages", "", "", "onPlayerInBed", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nSleepHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SleepHandler.kt\nnet/thebrokenscript/handlers/player/SleepHandler\n+ 2 EntityFinderDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/EntityFinder\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n107#2:66\n107#2:67\n1761#3,3:68\n*S KotlinDebug\n*F\n+ 1 SleepHandler.kt\nnet/thebrokenscript/handlers/player/SleepHandler\n*L\n45#1:66\n46#1:67\n52#1:68,3\n*E\n"})
public final class SleepHandler {
    @NotNull
    public static final SleepHandler INSTANCE = new SleepHandler();
    @NotNull
    private static final Map<String, String> easterEggMessages;

    private SleepHandler() {
    }

    @JvmStatic
    @Nullable
    public static final String onPlayerInBed(@NotNull ServerLevel level, @NotNull ServerPlayer player) {
        String string;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = player.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        Class[] classArray = new Class[]{NullWatchingEntity.class, NullFlyingEntity.class};
        if (EntityFinder.hasEntitiesInRange((LevelAccessor)levelAccessor, (Vec3)vec3, (Number)512, (Class[])classArray)) {
            string = "err.null";
        } else {
            Vec3 base$iv;
            Constable[] $this$hasEntitiesInRange$iv;
            classArray = (Class[])level;
            Vec3 vec32 = player.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
            Vec3 vec33 = vec32;
            Number radius$iv = 512;
            boolean $i$f$hasEntitiesInRange = false;
            Class[] classArray2 = new Class[]{NoTextureEntity.class};
            if (EntityFinder.hasEntitiesInRange((LevelAccessor)$this$hasEntitiesInRange$iv, (Vec3)base$iv, (Number)radius$iv, (Class[])classArray2)) {
                string = "err.texture";
            } else {
                $this$hasEntitiesInRange$iv = (Class[])level;
                Vec3 vec34 = player.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec34, (String)"position(...)");
                base$iv = vec34;
                radius$iv = 512;
                $i$f$hasEntitiesInRange = false;
                classArray2 = new Class[]{BaseSiluetEntity.class};
                if (EntityFinder.hasEntitiesInRange((LevelAccessor)$this$hasEntitiesInRange$iv, (Vec3)base$iv, (Number)radius$iv, (Class[])classArray2)) {
                    string = "err.soul";
                } else {
                    LevelAccessor levelAccessor2 = (LevelAccessor)level;
                    Vec3 vec35 = player.position();
                    Intrinsics.checkNotNullExpressionValue((Object)vec35, (String)"position(...)");
                    $this$hasEntitiesInRange$iv = new Class[]{TheBrokenEndStalkEntity.class, TheBrokenEndEntity.class};
                    if (EntityFinder.hasEntitiesInRange((LevelAccessor)levelAccessor2, (Vec3)vec35, (Number)512, (Class[])$this$hasEntitiesInRange$iv)) {
                        string = "err.endisnear";
                    } else {
                        boolean bl;
                        block16: {
                            $this$hasEntitiesInRange$iv = new Integer[]{4, 5, 6, 7};
                            Iterable $this$any$iv = CollectionsKt.listOf((Object[])$this$hasEntitiesInRange$iv);
                            boolean $i$f$any = false;
                            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                bl = false;
                            } else {
                                for (Object element$iv : $this$any$iv) {
                                    int it = ((Number)element$iv).intValue();
                                    boolean bl2 = false;
                                    if (!(level.dimensionType().moonPhase(level.dayTime()) == it)) continue;
                                    bl = true;
                                    break block16;
                                }
                                bl = false;
                            }
                        }
                        if (bl && LevelExt.INSTANCE.getVars((LevelAccessor)level).getMoonStage() != 0) {
                            if (level.random.nextBoolean()) {
                                String string2 = player.getGameProfile().getId().toString();
                                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
                                String uuid = string2;
                                String message = easterEggMessages.get(uuid);
                                string = message;
                                if (string == null) {
                                    string = "err.themoon";
                                }
                            } else {
                                string = "err.themoon";
                            }
                        } else {
                            string = null;
                        }
                    }
                }
            }
        }
        return string;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)"d597eaf2-d68e-410b-870f-5f71e5ad7457", (Object)"err.editing"), TuplesKt.to((Object)"2a89d17b-3ce5-4d1a-ab75-bff97b3df012", (Object)"err.shattered"), TuplesKt.to((Object)"d32a4454-ee1f-4611-ae7c-dcb6f9859fea", (Object)"err.fatter"), TuplesKt.to((Object)"572e10b1-a0ef-46bd-a2f2-cdc445ac8f2e", (Object)"err.fatter"), TuplesKt.to((Object)"d4bb4431-7daf-4642-bb14-a1f8fe9ae101", (Object)"err.swag"), TuplesKt.to((Object)"9530cc77-3c6b-42ea-a208-006dc773f395", (Object)"err.rock_on"), TuplesKt.to((Object)"797f1e70-3828-408a-bcbf-60807585a650", (Object)"err.abandoned"), TuplesKt.to((Object)"78ab2f13-2362-4d09-a0c1-0de13a5f3e89", (Object)"err.pmo")};
        easterEggMessages = MapsKt.mapOf((Pair[])pairArray);
    }
}

