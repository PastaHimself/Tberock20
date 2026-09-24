/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.RandomUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.PlatformTags
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.circuit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.RandomUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.PlatformTags;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.handlers.subs.BlockBreakSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/circuit/CircuitBlockBreakHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class CircuitBlockBreakHandler {
    @NotNull
    public static final CircuitBlockBreakHandler INSTANCE = new CircuitBlockBreakHandler();

    private CircuitBlockBreakHandler() {
    }

    private static final Unit _init_$lambda$0(Level level, BlockPos pos, BlockState state, Entity entity) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            if (!state.is(PlatformTags.Companion.getOres())) break block2;
            RandomSource randomSource = level.random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
            if (RandomUtil.nextDouble((RandomSource)randomSource, (double)0.0, (double)100.0) <= TBSConfigs.INSTANCE.getServer().getEntities().getDisguisedCircuitOreChance() && LevelExt.INSTANCE.getVars((LevelAccessor)level).isNullHere()) {
                Entity entity2 = EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.CIRCUIT.get()), (LevelAccessor)((LevelAccessor)level), (BlockPos)pos);
                if (entity2 != null) {
                    EntityUtil.applyRandomRotation((Entity)entity2);
                }
            }
        }
        return Unit.INSTANCE;
    }

    static {
        BlockBreakSubscriber.INSTANCE.add((Function4<? super Level, ? super BlockPos, ? super BlockState, ? super Entity, Unit>)((Function4)CircuitBlockBreakHandler::_init_$lambda$0));
    }
}

