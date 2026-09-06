/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.ext.JomlVecExtKt
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 */
package net.thebrokenscript.network;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.ext.JomlVecExtKt;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.network.FracturedEndecData;
import net.thebrokenscript.registry.TBSDamageTypes;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/JimmyBigStompPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "Lnet/thebrokenscript/network/FracturedEndecData;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nJimmyBigStompPacket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JimmyBigStompPacket.kt\nnet/thebrokenscript/network/JimmyBigStompPacket\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,30:1\n774#2:31\n865#2,2:32\n*S KotlinDebug\n*F\n+ 1 JimmyBigStompPacket.kt\nnet/thebrokenscript/network/JimmyBigStompPacket\n*L\n25#1:31\n25#1:32,2\n*E\n"})
public final class JimmyBigStompPacket
extends EndecPacket<JimmyBigStompPacket, FracturedEndecData> {
    @NotNull
    private final ResourceLocation id = TBSConstants.id("big_stomp");

    public JimmyBigStompPacket() {
        super(FracturedEndecData.Companion.getENDEC());
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(@NotNull FracturedEndecData data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isServerbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> JimmyBigStompPacket.handle$lambda$0(cx, data));
    }

    /*
     * WARNING - void declaration
     */
    private static final void handle$lambda$0(PacketHandlerContext $cx, FracturedEndecData $data) {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        Player player = $cx.getPlayer();
        if (player == null || (player = player.level()) == null) {
            return;
        }
        Player level = player;
        Object object = level.getEntity($data.getFractured());
        FracturedEntity fracturedEntity = object instanceof FracturedEntity ? (FracturedEntity)((Object)object) : null;
        if (fracturedEntity == null) {
            return;
        }
        FracturedEntity entity = fracturedEntity;
        List playersInRange = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)level), (Vec3)JomlVecExtKt.toVec3((Vector3d)$data.getStartPos()), (Number)64);
        object = playersInRange;
        FracturedEntity fracturedEntity2 = entity;
        boolean $i$f$filter = false;
        void var7_8 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Player it = (Player)element$iv$iv;
            boolean bl = false;
            if (!it.onGround()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        fracturedEntity2.setEntityList(CollectionsKt.toMutableList((Collection)((List)destination$iv$iv)));
        DamageSource damageSource = entity.damageSources().source(TBSDamageTypes.JIMMY_STOMP.getKey());
        Intrinsics.checkNotNullExpressionValue((Object)damageSource, (String)"source(...)");
        entity.hurtMultipleTargets(12.0f, 5.0, damageSource);
    }
}

