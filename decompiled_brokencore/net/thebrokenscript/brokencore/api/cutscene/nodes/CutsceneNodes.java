/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.cutscene.nodes;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType;
import net.thebrokenscript.brokencore.api.cutscene.nodes.TransformNode;
import net.thebrokenscript.brokencore.api.util.serde.TaggedEndec;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J-\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000f*\u00020\u0006\"\u000e\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000f0\n2\u0006\u0010\u0010\u001a\u0002H\u000e\u00a2\u0006\u0002\u0010\u0011R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodes;", "", "<init>", "()V", "ENDEC", "Lnet/thebrokenscript/brokencore/api/util/serde/TaggedEndec;", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "TYPES", "", "Lnet/minecraft/resources/ResourceLocation;", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "TRANSFORM", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode$Type;", "register", "T", "N", "ty", "(Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;)Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "brokencore-common"})
public final class CutsceneNodes {
    @NotNull
    public static final CutsceneNodes INSTANCE = new CutsceneNodes();
    @JvmField
    @NotNull
    public static final TaggedEndec<CutsceneNode> ENDEC = new TaggedEndec();
    @JvmField
    @NotNull
    public static final Map<ResourceLocation, CutsceneNodeType<?>> TYPES = new LinkedHashMap();
    @JvmField
    @NotNull
    public static final TransformNode.Type TRANSFORM = (TransformNode.Type)INSTANCE.register((CutsceneNodeType)TransformNode.Type.INSTANCE);

    private CutsceneNodes() {
    }

    @NotNull
    public final <N extends CutsceneNode, T extends CutsceneNodeType<N>> T register(@NotNull T ty) {
        Intrinsics.checkNotNullParameter(ty, (String)"ty");
        String string = ty.getId().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        ENDEC.register(string, ty.getEndec());
        TYPES.put(ty.getId(), ty);
        return ty;
    }
}

