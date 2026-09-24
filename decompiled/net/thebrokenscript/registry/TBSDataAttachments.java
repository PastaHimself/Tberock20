/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  net.thebrokenscript.brokencore.api.data.DataAttachment
 *  net.thebrokenscript.brokencore.api.learner.util.PlayerBase
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.thebrokenscript.brokencore.api.data.DataAttachment;
import net.thebrokenscript.brokencore.api.learner.util.PlayerBase;
import net.thebrokenscript.data.CircuitInhabited;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDataAttachments;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.util.InteractionTracker;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/registry/TBSDataAttachments;", "", "<init>", "()V", "PLAYER_VARIABLES", "Lnet/thebrokenscript/brokencore/api/data/DataAttachment;", "Lnet/thebrokenscript/data/PlayerVariables;", "INTERACTION_TRACKER", "Lnet/thebrokenscript/util/InteractionTracker;", "PLAYER_BASE", "Lnet/thebrokenscript/brokencore/api/learner/util/PlayerBase;", "CIRCUIT_INHABITED", "Lnet/thebrokenscript/data/CircuitInhabited;", "thebrokenscript-common"})
public final class TBSDataAttachments {
    @NotNull
    public static final TBSDataAttachments INSTANCE = new TBSDataAttachments();
    @JvmField
    @NotNull
    public static final DataAttachment<PlayerVariables> PLAYER_VARIABLES = TBSReg.INSTANCE.dataAttachment("player_vars", PLAYER_VARIABLES.2.INSTANCE);
    @JvmField
    @NotNull
    public static final DataAttachment<InteractionTracker> INTERACTION_TRACKER = TBSReg.INSTANCE.dataAttachment("interaction_tracker", INTERACTION_TRACKER.1.INSTANCE);
    @JvmField
    @NotNull
    public static final DataAttachment<PlayerBase> PLAYER_BASE = TBSReg.INSTANCE.dataAttachment("player_base", PLAYER_BASE.2.INSTANCE);
    @JvmField
    @NotNull
    public static final DataAttachment<CircuitInhabited> CIRCUIT_INHABITED = TBSReg.INSTANCE.dataAttachment("circuit_inhabited", CIRCUIT_INHABITED.2.INSTANCE);

    private TBSDataAttachments() {
    }
}

