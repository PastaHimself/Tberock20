/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerEntity
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.entity.multipart;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020!J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0014J\u0010\u0010,\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0014J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u0002032\u0006\u0010&\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\bH\u0016R\u0013\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u00069"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntityPart;", "T", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;", "Lnet/minecraft/world/entity/Entity;", "parent", "name", "", "width", "", "height", "<init>", "(Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;Ljava/lang/String;FF)V", "getParent", "()Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;", "Lnet/thebrokenscript/brokencore/api/entity/multipart/MultipartEntity;", "getName", "()Ljava/lang/String;", "dimensions", "Lnet/minecraft/world/entity/EntityDimensions;", "getDimensions", "()Lnet/minecraft/world/entity/EntityDimensions;", "offset", "Lnet/minecraft/world/phys/Vec3;", "getOffset", "()Lnet/minecraft/world/phys/Vec3;", "setOffset", "(Lnet/minecraft/world/phys/Vec3;)V", "moved", "x", "", "y", "z", "updatePosition", "", "getPickResult", "Lnet/minecraft/world/item/ItemStack;", "is", "", "entity", "shouldBeSaved", "isPickable", "addAdditionalSaveData", "tag", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "pose", "Lnet/minecraft/world/entity/Pose;", "getAddEntityPacket", "", "Lnet/minecraft/server/level/ServerEntity;", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "brokencore-common"})
public class MultipartEntityPart<T extends MultipartEntity>
extends Entity {
    @NotNull
    private final T parent;
    @NotNull
    private final String name;
    @NotNull
    private final EntityDimensions dimensions;
    @NotNull
    private Vec3 offset;

    public MultipartEntityPart(@NotNull T parent, @NotNull String name, float width, float height) {
        Intrinsics.checkNotNullParameter(parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        super(((Entity)parent).getType(), ((Entity)parent).level());
        this.parent = parent;
        this.name = name;
        EntityDimensions entityDimensions = EntityDimensions.scalable((float)width, (float)height);
        Intrinsics.checkNotNullExpressionValue((Object)entityDimensions, (String)"scalable(...)");
        this.dimensions = entityDimensions;
        this.offset = new Vec3(0.0, 0.0, 0.0);
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
    public EntityDimensions getDimensions() {
        return this.dimensions;
    }

    @NotNull
    public final Vec3 getOffset() {
        return this.offset;
    }

    public final void setOffset(@NotNull Vec3 vec3) {
        Intrinsics.checkNotNullParameter((Object)vec3, (String)"<set-?>");
        this.offset = vec3;
    }

    @NotNull
    public final MultipartEntityPart<T> moved(@NotNull Number x, @NotNull Number y, @NotNull Number z) {
        MultipartEntityPart multipartEntityPart;
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)z, (String)"z");
        MultipartEntityPart $this$moved_u24lambda_u240 = multipartEntityPart = this;
        boolean bl = false;
        $this$moved_u24lambda_u240.offset = new Vec3(x.doubleValue(), y.doubleValue(), z.doubleValue());
        return multipartEntityPart;
    }

    public final void updatePosition() {
        double yawRad = Math.toRadians(((MultipartEntity)this.parent).yBodyRot);
        double rotatedX = this.offset.x * Math.cos(yawRad) - this.offset.z * Math.sin(yawRad);
        double rotatedZ = this.offset.x * Math.sin(yawRad) + this.offset.z * Math.cos(yawRad);
        this.setPos(((Entity)this.parent).getX() + rotatedX, ((Entity)this.parent).getY() + this.offset.y, ((Entity)this.parent).getZ() + rotatedZ);
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

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return this.isInvulnerableTo(source) ? false : ((LivingEntity)this.parent).hurt(source, amount);
    }
}

