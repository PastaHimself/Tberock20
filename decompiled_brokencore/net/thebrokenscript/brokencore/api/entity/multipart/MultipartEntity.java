/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 */
package net.thebrokenscript.brokencore.api.entity.multipart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartSubEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimatableManager;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J2\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020 J\b\u0010'\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020 H\u0002J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0016R\u001b\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "parts", "", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntityPart;", "getParts", "()Ljava/util/List;", "subEntities", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartSubEntity;", "getSubEntities", "part", "name", "", "width", "", "height", "subEntity", "defaultOffset", "Lnet/minecraft/world/phys/Vec3;", "hitViaPart", "", "getHitViaPart", "()Z", "setHitViaPart", "(Z)V", "doAiStep", "", "recreateFromPacket", "packet", "Lnet/minecraft/network/protocol/game/ClientboundAddEntityPacket;", "aiStep", "lastYBodyRot", "", "tick", "updatePartPositions", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nMultipartEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultipartEntity.kt\nnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,72:1\n1#2:73\n1869#3,2:74\n1869#3,2:76\n*S KotlinDebug\n*F\n+ 1 MultipartEntity.kt\nnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity\n*L\n47#1:74,2\n66#1:76,2\n*E\n"})
public class MultipartEntity
extends UwuableMonster {
    @NotNull
    private final List<MultipartEntityPart<?>> parts;
    @NotNull
    private final List<MultipartSubEntity<?>> subEntities;
    private boolean hitViaPart;
    private float lastYBodyRot;

    public MultipartEntity(@NotNull EntityType<? extends MultipartEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.parts = new ArrayList();
        this.subEntities = new ArrayList();
    }

    @NotNull
    public final List<MultipartEntityPart<?>> getParts() {
        return this.parts;
    }

    @NotNull
    public final List<MultipartSubEntity<?>> getSubEntities() {
        return this.subEntities;
    }

    @NotNull
    public final MultipartEntityPart<MultipartEntity> part(@NotNull String name, @NotNull Number width, @NotNull Number height) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)width, (String)"width");
        Intrinsics.checkNotNullParameter((Object)height, (String)"height");
        MultipartEntityPart<MultipartEntity> multipartEntityPart = new MultipartEntityPart<MultipartEntity>(this, name, width.floatValue(), height.floatValue());
        List<MultipartEntityPart<?>> list = this.parts;
        MultipartEntityPart<MultipartEntity> p0 = multipartEntityPart;
        boolean bl = false;
        list.add(p0);
        return multipartEntityPart;
    }

    @NotNull
    public MultipartSubEntity<? extends MultipartEntity> subEntity(@NotNull String name, @NotNull Number width, @NotNull Number height, @NotNull Vec3 defaultOffset) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)width, (String)"width");
        Intrinsics.checkNotNullParameter((Object)height, (String)"height");
        Intrinsics.checkNotNullParameter((Object)defaultOffset, (String)"defaultOffset");
        MultipartSubEntity<MultipartEntity> multipartSubEntity = new MultipartSubEntity<MultipartEntity>(this, name, width.floatValue(), height.floatValue(), defaultOffset);
        List<MultipartSubEntity<?>> list = this.subEntities;
        MultipartSubEntity<MultipartEntity> p0 = multipartSubEntity;
        boolean bl = false;
        list.add(p0);
        return multipartSubEntity;
    }

    public static /* synthetic */ MultipartSubEntity subEntity$default(MultipartEntity multipartEntity, String string, Number number, Number number2, Vec3 vec3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subEntity");
        }
        if ((n & 8) != 0) {
            Vec3 vec32 = Vec3.ZERO;
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"ZERO");
            vec3 = vec32;
        }
        return multipartEntity.subEntity(string, number, number2, vec3);
    }

    public final boolean getHitViaPart() {
        return this.hitViaPart;
    }

    public final void setHitViaPart(boolean bl) {
        this.hitViaPart = bl;
    }

    public void doAiStep() {
        super.aiStep();
    }

    public void recreateFromPacket(@NotNull ClientboundAddEntityPacket packet) {
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        super.recreateFromPacket(packet);
        int n = ((Collection)this.parts).size();
        for (int idx = 0; idx < n; ++idx) {
            this.parts.get(idx).setId(idx + packet.getId());
        }
    }

    public final void aiStep() {
        if (!this.isNoAi()) {
            this.doAiStep();
        }
        this.updatePartPositions();
    }

    public void tick() {
        super.tick();
        Iterable $this$forEach$iv = this.subEntities;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MultipartSubEntity p0 = (MultipartSubEntity)((Object)element$iv);
            boolean bl = false;
            p0.tick();
        }
        if (!(this.yBodyRot == this.lastYBodyRot)) {
            this.updatePartPositions();
            this.lastYBodyRot = this.yBodyRot;
        }
    }

    private final void updatePartPositions() {
        int n = ((Collection)this.parts).size();
        for (int idx = 0; idx < n; ++idx) {
            this.parts.get((int)idx).xo = this.parts.get(idx).getX();
            this.parts.get((int)idx).yo = this.parts.get(idx).getY();
            this.parts.get((int)idx).zo = this.parts.get(idx).getZ();
            this.parts.get((int)idx).xOld = this.parts.get(idx).getX();
            this.parts.get((int)idx).yOld = this.parts.get(idx).getY();
            this.parts.get((int)idx).zOld = this.parts.get(idx).getZ();
        }
        Iterable $this$forEach$iv = this.parts;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            MultipartEntityPart p0 = (MultipartEntityPart)((Object)element$iv);
            boolean bl = false;
            p0.updatePosition();
        }
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
    }
}

