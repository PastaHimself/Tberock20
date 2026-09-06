/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.network.EndecPacket
 *  net.thebrokenscript.brokencore.api.network.PacketHandlerContext
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Endec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.network.EndecPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import net.thebrokenscript.entity.boss.VoidTentacleEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityP3GroundArmEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/network/TentacleHitPacket;", "Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "handle", "", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTentacleHitPacket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TentacleHitPacket.kt\nnet/thebrokenscript/network/TentacleHitPacket\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,53:1\n774#2:54\n865#2,2:55\n*S KotlinDebug\n*F\n+ 1 TentacleHitPacket.kt\nnet/thebrokenscript/network/TentacleHitPacket\n*L\n28#1:54\n28#1:55,2\n*E\n"})
public final class TentacleHitPacket
extends EndecPacket<TentacleHitPacket, Integer> {
    @NotNull
    private final ResourceLocation id;

    public TentacleHitPacket() {
        Endec endec2 = Endec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"INT");
        super(endec2);
        this.id = TBSConstants.id("tentacle_hit");
    }

    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    public void handle(int data, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (!cx.isServerbound) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> TentacleHitPacket.handle$lambda$0(cx, data));
    }

    /*
     * WARNING - void declaration
     */
    private static final void handle$lambda$0(PacketHandlerContext $cx, int $data) {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        Player player = $cx.getPlayer();
        if (player == null || (player = player.level()) == null) {
            return;
        }
        Player level = player;
        Object object = level.getEntity($data);
        VoidTentacleEntity voidTentacleEntity = object instanceof VoidTentacleEntity ? (VoidTentacleEntity)((Object)object) : null;
        if (voidTentacleEntity == null) {
            return;
        }
        VoidTentacleEntity entity = voidTentacleEntity;
        List playersInRange = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)level), (Vec3)entity.getPos(), (Number)((double)6 * (entity.getAttributes().getBaseValue(Attributes.SCALE) * 0.7)));
        object = playersInRange;
        VoidTentacleEntity voidTentacleEntity2 = entity;
        boolean $i$f$filter = false;
        void var7_9 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Player it = (Player)element$iv$iv;
            boolean bl = false;
            if (!it.onGround()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        voidTentacleEntity2.setEntityList(CollectionsKt.toMutableList((Collection)((List)destination$iv$iv)));
        entity.hurtMultipleTargets(12.0f);
        IntegrityPhase3Entity integ = (IntegrityPhase3Entity)EntityFinder.findClosestEntityInRange((LevelAccessor)((LevelAccessor)level), IntegrityPhase3Entity.class, (Vec3)entity.getPos(), (Number)((double)6 * (entity.getAttributes().getBaseValue(Attributes.SCALE) * 0.7)));
        if (integ != null) {
            integ.setStuck(true);
            entity.queueDiscard(60L);
            return;
        }
        IntegrityP3GroundArmEntity integrityP3GroundArmEntity = (IntegrityP3GroundArmEntity)EntityFinder.findClosestEntityInRange((LevelAccessor)((LevelAccessor)level), IntegrityP3GroundArmEntity.class, (Vec3)entity.getPos(), (Number)((double)6 * (entity.getAttributes().getBaseValue(Attributes.SCALE) * 0.7)));
        if (integrityP3GroundArmEntity == null) {
            return;
        }
        IntegrityP3GroundArmEntity integrityArm = integrityP3GroundArmEntity;
        integrityArm.setStuck(true);
    }
}

