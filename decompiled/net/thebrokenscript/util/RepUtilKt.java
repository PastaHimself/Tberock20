/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.util.RepTier;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0006"}, d2={"applyRep", "", "Lnet/minecraft/world/entity/player/Player;", "tier", "Lnet/thebrokenscript/util/RepTier;", "gainBackHalfLostRep", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nRepUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepUtil.kt\nnet/thebrokenscript/util/RepUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
public final class RepUtilKt {
    public static final void applyRep(@NotNull Player $this$applyRep, @NotNull RepTier tier) {
        Intrinsics.checkNotNullParameter((Object)$this$applyRep, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)((Object)tier), (String)"tier");
        PlayerExt.INSTANCE.updateVars($this$applyRep, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> RepUtilKt.applyRep$lambda$0(tier, arg_0)));
    }

    public static final void gainBackHalfLostRep(@NotNull Player $this$gainBackHalfLostRep) {
        Object v0;
        block2: {
            Intrinsics.checkNotNullParameter((Object)$this$gainBackHalfLostRep, (String)"<this>");
            Iterable iterable = (Iterable)RepTier.getEntries();
            for (Object t : iterable) {
                RepTier it = (RepTier)((Object)t);
                boolean bl = false;
                if (!(Intrinsics.areEqual((Object)it.name(), (Object)PlayerExt.INSTANCE.getVars($this$gainBackHalfLostRep).getLastRepInteraction()) && it.isLoss())) continue;
                v0 = t;
                break block2;
            }
            v0 = null;
        }
        RepTier repTier = v0;
        if (repTier == null) {
            return;
        }
        RepTier lastTier = repTier;
        PlayerExt.INSTANCE.updateVars($this$gainBackHalfLostRep, (Function1<? super PlayerVariables, Unit>)((Function1)arg_0 -> RepUtilKt.gainBackHalfLostRep$lambda$1(lastTier, arg_0)));
    }

    private static final Unit applyRep$lambda$0(RepTier $tier, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setEntityReputation($this$updateVars.getEntityReputation() + $tier.getAmount());
        $this$updateVars.setLastRepInteraction($tier.name());
        return Unit.INSTANCE;
    }

    private static final Unit gainBackHalfLostRep$lambda$1(RepTier $lastTier, PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setEntityReputation($this$updateVars.getEntityReputation() + -$lastTier.getAmount() / 2);
        $this$updateVars.setLastRepInteraction("REGAIN_HALF");
        return Unit.INSTANCE;
    }
}

