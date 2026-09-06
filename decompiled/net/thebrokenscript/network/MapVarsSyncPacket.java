/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  net.thebrokenscript.brokencore.api.util.serde.Endecs
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Endec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.brokencore.api.util.serde.Endecs;
import net.thebrokenscript.data.MapVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002 \u0012\u0004\u0012\u00020\u0000\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J*\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/network/MapVarsSyncPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lkotlin/Pair;", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "Lnet/thebrokenscript/data/MapVariables;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
public final class MapVarsSyncPacket
extends EndecPacket<MapVarsSyncPacket, Pair<? extends ResourceKey<Level>, ? extends MapVariables>> {
    @NotNull
    private final ResourceLocation id;

    public MapVarsSyncPacket() {
        ResourceKey resourceKey = Registries.DIMENSION;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"DIMENSION");
        super((Endec)Endecs.INSTANCE.pair(Endecs.INSTANCE.resourceKey(resourceKey), MapVariables.ENDEC));
        this.id = TBSConstants.id("map_vars_sync");
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull Pair<? extends ResourceKey<Level>, MapVariables> data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isClientbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> MapVarsSyncPacket.handle$lambda$0(data));
    }

    private static final void handle$lambda$0(Pair $data) {
        MapVariables.CLIENT_VARS.put((ResourceKey<Level>)$data.getFirst(), (MapVariables)((Object)$data.getSecond()));
    }
}

