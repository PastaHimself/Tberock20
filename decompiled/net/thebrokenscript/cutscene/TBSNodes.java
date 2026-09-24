/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType
 *  net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodes
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.cutscene;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodes;
import net.thebrokenscript.cutscene.TentacleNode;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/cutscene/TBSNodes;", "", "<init>", "()V", "TENTACLE", "Lnet/thebrokenscript/cutscene/TentacleNode$Type;", "thebrokenscript-common"})
public final class TBSNodes {
    @NotNull
    public static final TBSNodes INSTANCE = new TBSNodes();
    @JvmField
    @NotNull
    public static final TentacleNode.Type TENTACLE = (TentacleNode.Type)CutsceneNodes.INSTANCE.register((CutsceneNodeType)TentacleNode.Type.INSTANCE);

    private TBSNodes() {
    }
}

