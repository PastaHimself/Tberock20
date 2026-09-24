/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerEntity
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.entity.multipart;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020&H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u0002072\u0006\u0010*\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\bH\u0016R\u0013\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2={"Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartSubEntity;", "T", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;", "Lnet/minecraft/world/entity/Entity;", "parent", "name", "", "width", "", "height", "offset", "Lnet/minecraft/world/phys/Vec3;", "<init>", "(Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;Ljava/lang/String;FFLnet/minecraft/world/phys/Vec3;)V", "getParent", "()Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;", "getName", "()Ljava/lang/String;", "getOffset", "()Lnet/minecraft/world/phys/Vec3;", "dimensions", "Lnet/minecraft/world/entity/EntityDimensions;", "getDimensions", "()Lnet/minecraft/world/entity/EntityDimensions;", "gravityMultiplier", "", "getGravityMultiplier", "()D", "setGravityMultiplier", "(D)V", "init", "", "tick", "", "igniteForTicks", "ticks", "isOnFire", "", "getPickResult", "Lnet/minecraft/world/item/ItemStack;", "is", "entity", "shouldBeSaved", "isPickable", "addAdditionalSaveData", "tag", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "pose", "Lnet/minecraft/world/entity/Pose;", "getAddEntityPacket", "", "Lnet/minecraft/server/level/ServerEntity;", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "brokencore-common"})
public class MultipartSubEntity<T extends MultipartEntity>
extends Entity {
    @NotNull
    private final T parent;
    @NotNull
    private final String name;
    @NotNull
    private final Vec3 offset;
    @NotNull
    private final EntityDimensions dimensions;
    private double gravityMultiplier;
    private int init;

    public MultipartSubEntity(@NotNull T parent, @NotNull String name, float width, float height, @NotNull Vec3 offset) {
        Intrinsics.checkNotNullParameter(parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)offset, (String)"offset");
        super(((Entity)parent).getType(), ((Entity)parent).level());
        this.parent = parent;
        this.name = name;
        this.offset = offset;
        EntityDimensions entityDimensions = EntityDimensions.scalable((float)width, (float)height);
        Intrinsics.checkNotNullExpressionValue((Object)entityDimensions, (String)"scalable(...)");
        this.dimensions = entityDimensions;
        this.gravityMultiplier = 1.0;
        this.refreshDimensions();
    }

    @NotNull
    public final T getParent() {
        return this.parent;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final Vec3 getOffset() {
        return this.offset;
    }

    @NotNull
    public EntityDimensions getDimensions() {
        return this.dimensions;
    }

    public final double getGravityMultiplier() {
        return this.gravityMultiplier;
    }

    public final void setGravityMultiplier(double d) {
        this.gravityMultiplier = d;
    }

    public void tick() {
        super.tick();
        this.setDeltaMovement(this.getDeltaMovement().with(Direction.Axis.Y, this.getDeltaMovement().y - 0.08 * this.gravityMultiplier));
        this.move(MoverType.SELF, this.getDeltaMovement());
        if (this.init < 2) {
            this.setPos(((BaseMonster)((Object)this.parent)).getPos().add(this.offset));
            ++this.init;
        }
    }

    public void igniteForTicks(int ticks) {
        ((LivingEntity)this.parent).igniteForTicks(ticks);
    }

    public boolean isOnFire() {
        return ((Entity)this.parent).isOnFire();
    }

    @Nullable
    public ItemStack getPickResult() {
        return ((Mob)this.parent).getPickResult();
    }

    public boolean is(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return Intrinsics.areEqual((Object)((Object)this), (Object)entity) || Intrinsics.areEqual(this.parent, (Object)entity);
    }

    public boolean shouldBeSaved() {
        return false;
    }

    public boolean isPickable() {
        return true;
    }

    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
    }

    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
    }

    @NotNull
    public EntityDimensions getDimensions(@NotNull Pose pose) {
        Intrinsics.checkNotNullParameter((Object)pose, (String)"pose");
        return this.getDimensions();
    }

    @NotNull
    public Void getAddEntityPacket(@NotNull ServerEntity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        throw new UnsupportedOperationException("Multipart entity parts should never be added!");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.isInvulnerableTo(source)) {
            return false;
        }
        ((MultipartEntity)this.parent).setHitViaPart(true);
        try {
            boolean bl = ((LivingEntity)this.parent).hurt(source, amount);
            return bl;
        }
        finally {
            ((MultipartEntity)this.parent).setHitViaPart(false);
        }
    }
}

