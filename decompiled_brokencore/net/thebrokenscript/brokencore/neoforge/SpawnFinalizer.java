/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/SpawnFinalizer;", "", "<init>", "()V", "callFinalizeSpawn", "", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "event", "Lnet/neoforged/neoforge/event/entity/living/FinalizeSpawnEvent;", "handleFinalizeSpawn", "brokencore-neoforge"})
public final class SpawnFinalizer {
    @NotNull
    public static final SpawnFinalizer INSTANCE = new SpawnFinalizer();

    private SpawnFinalizer() {
    }

    private final void callFinalizeSpawn(FinalizedSpawn $this$callFinalizeSpawn, FinalizeSpawnEvent event) {
        block0: {
            ServerLevelAccessor serverLevelAccessor = event.getLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevelAccessor, (String)"getLevel(...)");
            DifficultyInstance difficultyInstance = event.getDifficulty();
            Intrinsics.checkNotNullExpressionValue((Object)difficultyInstance, (String)"getDifficulty(...)");
            MobSpawnType mobSpawnType = event.getSpawnType();
            Intrinsics.checkNotNullExpressionValue((Object)mobSpawnType, (String)"getSpawnType(...)");
            SpawnGroupData spawnGroupData = $this$callFinalizeSpawn.onFinalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, event.getSpawnData(), new CancelProxy((Function1<? super Boolean, Unit>)((Function1)new Function1<Boolean, Unit>((Object)event){

                public final void invoke(boolean p0) {
                    ((FinalizeSpawnEvent)this.receiver).setSpawnCancelled(p0);
                }
            }), (Function0<Boolean>)((Function0)new Function0<Boolean>((Object)event){

                public final Boolean invoke() {
                    return ((FinalizeSpawnEvent)this.receiver).isSpawnCancelled();
                }
            })));
            if (spawnGroupData == null) break block0;
            SpawnGroupData it = spawnGroupData;
            boolean bl = false;
            event.setSpawnData(it);
        }
    }

    @JvmStatic
    @SubscribeEvent
    public static final void handleFinalizeSpawn(@NotNull FinalizeSpawnEvent event) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)event, (String)"event");
            Mob mob = event.getEntity();
            FinalizedSpawn finalizedSpawn = mob instanceof FinalizedSpawn ? (FinalizedSpawn)mob : null;
            if (finalizedSpawn == null) break block0;
            INSTANCE.callFinalizeSpawn(finalizedSpawn, event);
        }
    }
}

