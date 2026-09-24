/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.Brain$Provider
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.brain.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.brain.util.BuiltBrain;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0014R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/impl/MonsterWithBrain;", "Lnet/minecraft/world/entity/monster/Monster;", "builtBrain", "Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "brainProvider", "Lnet/minecraft/world/entity/ai/Brain$Provider;", "Lnet/minecraft/world/entity/LivingEntity;", "brokencore-common"})
public abstract class MonsterWithBrain
extends Monster {
    @NotNull
    private final BuiltBrain<?> builtBrain;

    public MonsterWithBrain(@NotNull BuiltBrain<?> builtBrain, @NotNull EntityType<? extends Monster> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(builtBrain, (String)"builtBrain");
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
        this.builtBrain = builtBrain;
        this.builtBrain.addTo((LivingEntity)this);
    }

    @NotNull
    protected Brain.Provider<? extends LivingEntity> brainProvider() {
        return this.builtBrain.provider();
    }
}

