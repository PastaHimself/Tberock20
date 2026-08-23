/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.ProjectileUtil
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.item;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.registry.TBSDamageTypes;
import net.thebrokenscript.registry.TBSDataComponents;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/item/HandCannonItem;", "Lnet/minecraft/world/item/Item;", "properties", "Lnet/minecraft/world/item/Item$Properties;", "<init>", "(Lnet/minecraft/world/item/Item$Properties;)V", "inventoryTick", "", "stack", "Lnet/minecraft/world/item/ItemStack;", "level", "Lnet/minecraft/world/level/Level;", "entity", "Lnet/minecraft/world/entity/Entity;", "slotId", "", "isSelected", "", "use", "Lnet/minecraft/world/InteractionResultHolder;", "player", "Lnet/minecraft/world/entity/player/Player;", "usedHand", "Lnet/minecraft/world/InteractionHand;", "Companion", "thebrokenscript-common"})
public final class HandCannonItem
extends Item {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final double BEAM_LENGTH = 100.0;
    @NotNull
    private static final UUID OWNER;
    @NotNull
    private static final String BOGOS_BINTED = "HUUHRRAAAHHHHRR";

    public HandCannonItem(@NotNull Item.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int slotId, boolean isSelected) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (!level.isClientSide && entity instanceof Player) {
            Boolean isPermitted = (Boolean)stack.getOrDefault((DataComponentType)TBSDataComponents.INSTANCE.getADMINISTRATIVE_OVERRIDE().invoke(), (Object)false);
            boolean isOwner = ((Player)entity).getUUID().equals(OWNER);
            if (isOwner) {
                return;
            }
            if (isPermitted.booleanValue()) {
                return;
            }
            entity.sendSystemMessage((Component)Component.literal((String)"This doesn't belong to you!").withColor(0xAA0000));
            stack.shrink(stack.getCount());
        }
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)usedHand, (String)"usedHand");
        Vec3 start = player.getEyePosition();
        Vec3 lookDirection = player.getLookAngle();
        Vec3 end = start.add(lookDirection.scale(100.0));
        level.playSound(null, player.getX(), player.getY(), player.getZ(), (Holder)TBSSounds.TEKKIT_GUN_SFX, player.getSoundSource(), 1.5f, 1.0f);
        AABB boundingBox = player.getBoundingBox().expandTowards(lookDirection.scale(100.0)).inflate(1.0);
        EntityHitResult result = ProjectileUtil.getEntityHitResult((Level)level, (Entity)((Entity)player), (Vec3)start, (Vec3)end, (AABB)boundingBox, HandCannonItem::use$lambda$0);
        if (result != null) {
            float damage = 25.0f;
            DamageSource fingerDamage = new DamageSource((Holder)result.getEntity().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(TBSDamageTypes.HAND_CANNON_DAMAGE.getKey()));
            result.getEntity().hurt(fingerDamage, damage);
            result.getEntity().invulnerableTime = 0;
        }
        InteractionResultHolder interactionResultHolder = super.use(level, player, usedHand);
        Intrinsics.checkNotNullExpressionValue((Object)interactionResultHolder, (String)"use(...)");
        return interactionResultHolder;
    }

    private static final boolean use$lambda$0(Entity entity) {
        return !entity.isSpectator();
    }

    static {
        UUID uUID = UUID.fromString("ed8707c4-1682-4f2b-8012-084b6d0c939b");
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"fromString(...)");
        OWNER = uUID;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/item/HandCannonItem$Companion;", "", "<init>", "()V", "BEAM_LENGTH", "", "OWNER", "Ljava/util/UUID;", "BOGOS_BINTED", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

