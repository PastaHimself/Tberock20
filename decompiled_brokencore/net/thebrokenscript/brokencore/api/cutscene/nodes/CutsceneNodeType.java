/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.cutscene.nodes;

import io.wispforest.endec.Endec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0012\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "T", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "", "id", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;)V", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "endec", "Lio/wispforest/endec/Endec;", "getEndec", "()Lio/wispforest/endec/Endec;", "name", "Lnet/minecraft/network/chat/Component;", "getName", "()Lnet/minecraft/network/chat/Component;", "create", "()Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "interpolate", "delta", "", "a", "b", "(FLnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;)Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "brokencore-common"})
public abstract class CutsceneNodeType<T extends CutsceneNode> {
    @NotNull
    private final ResourceLocation id;

    public CutsceneNodeType(@NotNull ResourceLocation id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        this.id = id;
    }

    @NotNull
    public final ResourceLocation getId() {
        return this.id;
    }

    @NotNull
    public abstract Endec<T> getEndec();

    @NotNull
    public abstract Component getName();

    @NotNull
    public abstract T create();

    @NotNull
    public abstract T interpolate(float var1, @NotNull T var2, @NotNull T var3);
}

