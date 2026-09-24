/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.Brain$Provider
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.brain.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.brain.util.BuiltBrain;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bH\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/impl/LivingEntityWithBrain;", "Lnet/minecraft/world/entity/LivingEntity;", "builtBrain", "Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "brainProvider", "Lnet/minecraft/world/entity/ai/Brain$Provider;", "brokencore-common"})
public abstract class LivingEntityWithBrain
extends LivingEntity {
    @NotNull
    private final BuiltBrain<LivingEntityWithBrain> builtBrain;

    public LivingEntityWithBrain(@NotNull BuiltBrain<LivingEntityWithBrain> builtBrain, @NotNull EntityType<? extends LivingEntity> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(builtBrain, (String)"builtBrain");
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
        this.builtBrain = builtBrain;
        this.builtBrain.addTo(this);
    }

    @NotNull
    protected Brain.Provider<LivingEntityWithBrain> brainProvider() {
        return this.builtBrain.provider();
    }
}

