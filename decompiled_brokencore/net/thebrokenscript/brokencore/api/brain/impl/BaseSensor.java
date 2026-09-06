/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.sensing.Sensor
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.brain.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.sensing.Sensor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/impl/BaseSensor;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "Lnet/minecraft/world/entity/ai/sensing/Sensor;", "scanTime", "", "<init>", "(I)V", "register", "", "location", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
public abstract class BaseSensor<T extends LivingEntity>
extends Sensor<T> {
    public BaseSensor(int scanTime) {
        super(scanTime);
    }

    public /* synthetic */ BaseSensor(int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            n = 20;
        }
        this(n);
    }

    public abstract void register(@NotNull ResourceLocation var1);

    public BaseSensor() {
        this(0, 1, null);
    }
}

