/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.entity.ai.attributes.AttributeMap
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.compat.jade;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/compat/jade/FakePlayerJade;", "Lnet/minecraft/world/entity/player/Player;", "parent", "Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "<init>", "(Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;)V", "getGameProfile", "Lcom/mojang/authlib/GameProfile;", "getHealth", "", "getMainHandItem", "Lnet/minecraft/world/item/ItemStack;", "getOffhandItem", "getArmorValue", "", "getArmorSlots", "", "getDisplayName", "Lnet/minecraft/network/chat/Component;", "getName", "getUUID", "Ljava/util/UUID;", "getStringUUID", "", "getScoreboardName", "getCustomName", "position", "Lnet/minecraft/world/phys/Vec3;", "blockPosition", "Lnet/minecraft/core/BlockPos;", "getAttributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeMap;", "isSpectator", "", "isCreative", "thebrokenscript-common"})
public final class FakePlayerJade
extends Player {
    @Nullable
    private final FakePlayerEntity parent;

    public FakePlayerJade(@Nullable FakePlayerEntity parent) {
        FakePlayerEntity fakePlayerEntity = parent;
        FakePlayerEntity fakePlayerEntity2 = parent;
        FakePlayerEntity fakePlayerEntity3 = parent;
        FakePlayerEntity fakePlayerEntity4 = parent;
        super((Level)(fakePlayerEntity != null ? fakePlayerEntity.getLevel() : null), (BlockPos)(fakePlayerEntity2 != null ? fakePlayerEntity2.getBlockPos() : null), fakePlayerEntity3 != null ? fakePlayerEntity3.getYRot() : 0.0f, (GameProfile)(fakePlayerEntity4 != null ? fakePlayerEntity4.getGameProfile() : null));
        this.parent = parent;
    }

    @NotNull
    public GameProfile getGameProfile() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        if (fakePlayerEntity == null || (fakePlayerEntity = fakePlayerEntity.getGameProfile()) == null) {
            GameProfile gameProfile = super.getGameProfile();
            fakePlayerEntity = gameProfile;
            Intrinsics.checkNotNullExpressionValue((Object)gameProfile, (String)"getGameProfile(...)");
        }
        return fakePlayerEntity;
    }

    public float getHealth() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        return fakePlayerEntity != null ? fakePlayerEntity.getHealth() : super.getHealth();
    }

    @NotNull
    public ItemStack getMainHandItem() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        if (fakePlayerEntity == null || (fakePlayerEntity = fakePlayerEntity.getMainHandItem()) == null) {
            ItemStack itemStack = super.getMainHandItem();
            fakePlayerEntity = itemStack;
            Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"getMainHandItem(...)");
        }
        return fakePlayerEntity;
    }

    @NotNull
    public ItemStack getOffhandItem() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        if (fakePlayerEntity == null || (fakePlayerEntity = fakePlayerEntity.getOffhandItem()) == null) {
            ItemStack itemStack = super.getOffhandItem();
            fakePlayerEntity = itemStack;
            Intrinsics.checkNotNullExpressionValue((Object)itemStack, (String)"getOffhandItem(...)");
        }
        return fakePlayerEntity;
    }

    public int getArmorValue() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        return fakePlayerEntity != null ? fakePlayerEntity.getArmorValue() : super.getArmorValue();
    }

    @NotNull
    public Iterable<ItemStack> getArmorSlots() {
        Object object = this.parent;
        if (object == null || (object = object.getArmorSlots()) == null) {
            Iterable iterable = super.getArmorSlots();
            object = iterable;
            Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"getArmorSlots(...)");
        }
        return object;
    }

    @Nullable
    public Component getDisplayName() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        if (fakePlayerEntity == null || (fakePlayerEntity = fakePlayerEntity.getDisplayName()) == null) {
            fakePlayerEntity = super.getDisplayName();
        }
        return fakePlayerEntity;
    }

    @NotNull
    public Component getName() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        if (fakePlayerEntity == null || (fakePlayerEntity = fakePlayerEntity.getName()) == null) {
            Component component = super.getName();
            fakePlayerEntity = component;
            Intrinsics.checkNotNullExpressionValue((Object)component, (String)"getName(...)");
        }
        return fakePlayerEntity;
    }

    @NotNull
    public UUID getUUID() {
        Object object = this.parent;
        if (object == null || (object = object.getUUID()) == null) {
            UUID uUID = this.uuid;
            object = uUID;
            Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"uuid");
        }
        return object;
    }

    @NotNull
    public String getStringUUID() {
        Object object = this.parent;
        if (object == null || (object = object.getStringUUID()) == null) {
            String string = this.stringUUID;
            object = string;
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"stringUUID");
        }
        return object;
    }

    @NotNull
    public String getScoreboardName() {
        Object object = this.parent;
        if (object == null || (object = object.getScoreboardName()) == null) {
            String string = super.getScoreboardName();
            object = string;
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getScoreboardName(...)");
        }
        return object;
    }

    @Nullable
    public Component getCustomName() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        if (fakePlayerEntity == null || (fakePlayerEntity = fakePlayerEntity.getCustomName()) == null) {
            fakePlayerEntity = super.getCustomName();
        }
        return fakePlayerEntity;
    }

    @NotNull
    public Vec3 position() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        if (fakePlayerEntity == null || (fakePlayerEntity = fakePlayerEntity.getPos()) == null) {
            Vec3 vec3 = super.position();
            fakePlayerEntity = vec3;
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        }
        return fakePlayerEntity;
    }

    @NotNull
    public BlockPos blockPosition() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        if (fakePlayerEntity == null || (fakePlayerEntity = fakePlayerEntity.blockPosition()) == null) {
            BlockPos blockPos = super.blockPosition();
            fakePlayerEntity = blockPos;
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"blockPosition(...)");
        }
        return fakePlayerEntity;
    }

    @NotNull
    public AttributeMap getAttributes() {
        FakePlayerEntity fakePlayerEntity = this.parent;
        if (fakePlayerEntity == null || (fakePlayerEntity = fakePlayerEntity.getAttributes()) == null) {
            AttributeMap attributeMap = super.getAttributes();
            fakePlayerEntity = attributeMap;
            Intrinsics.checkNotNullExpressionValue((Object)attributeMap, (String)"getAttributes(...)");
        }
        return fakePlayerEntity;
    }

    public boolean isSpectator() {
        return false;
    }

    public boolean isCreative() {
        return false;
    }
}

