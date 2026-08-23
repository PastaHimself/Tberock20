/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.DefaultedRegistry
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.sensing.Sensor
 *  net.minecraft.world.entity.ai.sensing.SensorType
 *  net.minecraft.world.entity.schedule.Activity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.brain.util;

import com.mojang.serialization.Codec;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.impl.mixin.features.brain.ActivityInvoker;
import net.thebrokenscript.brokencore.impl.mixin.features.brain.SensorTypeInvoker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006J(\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\r\"\u0004\b\u0000\u0010\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000fJ(\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\r\"\u0004\b\u0000\u0010\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00070\rJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/util/BrainRegistryHelper;", "", "<init>", "()V", "registerSensor", "Lnet/minecraft/world/entity/ai/sensing/SensorType;", "Lnet/minecraft/world/entity/ai/sensing/Sensor;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "name", "Lnet/minecraft/resources/ResourceLocation;", "sensor", "registerMemory", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "codec", "Lcom/mojang/serialization/Codec;", "memoryModuleType", "registerActivity", "Lnet/minecraft/world/entity/schedule/Activity;", "brokencore-common"})
public final class BrainRegistryHelper {
    @NotNull
    public static final BrainRegistryHelper INSTANCE = new BrainRegistryHelper();

    private BrainRegistryHelper() {
    }

    @NotNull
    public final <T extends LivingEntity> SensorType<Sensor<T>> registerSensor(@NotNull ResourceLocation name, @NotNull Sensor<T> sensor) {
        SensorType sensorType;
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(sensor, (String)"sensor");
        if (PlatformUtil.Companion.isDataGen()) {
            SensorType sensorType2 = SensorTypeInvoker.bc$newType(() -> BrainRegistryHelper.registerSensor$lambda$0(sensor));
            sensorType = sensorType2;
            Intrinsics.checkNotNullExpressionValue(sensorType2, (String)"bc$newType(...)");
        } else {
            DefaultedRegistry defaultedRegistry = BuiltInRegistries.SENSOR_TYPE;
            Intrinsics.checkNotNullExpressionValue((Object)defaultedRegistry, (String)"SENSOR_TYPE");
            SensorType sensorType3 = (SensorType)MiscExt.getOrNull(defaultedRegistry, name);
            if (sensorType3 == null) {
                BrainRegistryHelper $this$registerSensor_u24lambda_u241 = this;
                boolean bl = false;
                sensorType3 = (SensorType)Registry.register((Registry)((Registry)BuiltInRegistries.SENSOR_TYPE), (ResourceLocation)name, SensorTypeInvoker.bc$newType(() -> BrainRegistryHelper.registerSensor$lambda$1$0(sensor)));
            }
            sensorType = sensorType3;
            Intrinsics.checkNotNull((Object)sensorType3, (String)"null cannot be cast to non-null type net.minecraft.world.entity.ai.sensing.SensorType<net.minecraft.world.entity.ai.sensing.Sensor<T of net.thebrokenscript.brokencore.api.brain.util.BrainRegistryHelper.registerSensor>>");
        }
        return sensorType;
    }

    @NotNull
    public final <T> MemoryModuleType<T> registerMemory(@NotNull ResourceLocation name, @NotNull Codec<T> codec) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(codec, (String)"codec");
        DefaultedRegistry key = BuiltInRegistries.MEMORY_MODULE_TYPE;
        Intrinsics.checkNotNull((Object)key);
        MemoryModuleType memoryModuleType = (MemoryModuleType)MiscExt.getOrNull(key, name);
        if (memoryModuleType == null) {
            memoryModuleType = PlatformUtil.Companion.isDataGen() ? new MemoryModuleType(Optional.of(codec)) : (MemoryModuleType)Registry.register((Registry)((Registry)key), (ResourceLocation)name, (Object)new MemoryModuleType(Optional.of(codec)));
        }
        Intrinsics.checkNotNull((Object)memoryModuleType, (String)"null cannot be cast to non-null type net.minecraft.world.entity.ai.memory.MemoryModuleType<T of net.thebrokenscript.brokencore.api.brain.util.BrainRegistryHelper.registerMemory>");
        return memoryModuleType;
    }

    @NotNull
    public final <T> MemoryModuleType<T> registerMemory(@NotNull ResourceLocation name, @NotNull MemoryModuleType<T> memoryModuleType) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(memoryModuleType, (String)"memoryModuleType");
        DefaultedRegistry key = BuiltInRegistries.MEMORY_MODULE_TYPE;
        Object object = Registry.register((Registry)((Registry)key), (ResourceLocation)name, memoryModuleType);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (MemoryModuleType)object;
    }

    @NotNull
    public final Activity registerActivity(@NotNull ResourceLocation name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Activity activity = (Activity)BuiltInRegistries.ACTIVITY.get(name);
        if (activity == null) {
            if (PlatformUtil.Companion.isDataGen()) {
                Activity activity2 = ActivityInvoker.bc$newActivity(name.getNamespace() + ":" + name.getPath());
                activity = activity2;
                Intrinsics.checkNotNullExpressionValue((Object)activity2, (String)"bc$newActivity(...)");
            } else {
                Activity activity3 = Activity.register((String)(name.getNamespace() + ":" + name.getPath()));
                activity = activity3;
                Intrinsics.checkNotNullExpressionValue((Object)activity3, (String)"register(...)");
            }
        }
        return activity;
    }

    private static final Sensor registerSensor$lambda$0(Sensor $sensor) {
        return $sensor;
    }

    private static final Sensor registerSensor$lambda$1$0(Sensor $sensor) {
        return $sensor;
    }
}

