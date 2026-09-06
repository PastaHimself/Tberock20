/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.synchronization.ArgumentTypeInfo
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.registry;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.thebrokenscript.brokencore.api.commands.arguments.EnumArgument;
import net.thebrokenscript.brokencore.api.commands.arguments.ResourceLocationSetArgument;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import net.thebrokenscript.brokencore.impl.registry.BCReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R>\u0010\u0004\u001a2\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003 \u0007*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t0\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003 \u0007*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/impl/registry/BCArgumentTypes;", "", "<init>", "()V", "ENUM_COMMAND_ARGUMENT_TYPE", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/commands/synchronization/ArgumentTypeInfo;", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Info;", "", "RESOURCE_LOCATION_ARGUMENT_TYPE", "Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info;", "brokencore-common"})
public final class BCArgumentTypes {
    @NotNull
    public static final BCArgumentTypes INSTANCE = new BCArgumentTypes();
    @NotNull
    private static final RegistryEntry<ArgumentTypeInfo<?, ?>, EnumArgument.Info<? extends Enum<?>>> ENUM_COMMAND_ARGUMENT_TYPE;
    @NotNull
    private static final RegistryEntry<ArgumentTypeInfo<?, ?>, ResourceLocationSetArgument.Info> RESOURCE_LOCATION_ARGUMENT_TYPE;

    private BCArgumentTypes() {
    }

    private static final EnumArgument.Info ENUM_COMMAND_ARGUMENT_TYPE$lambda$0() {
        return EnumArgument.Companion.register();
    }

    private static final ResourceLocationSetArgument.Info RESOURCE_LOCATION_ARGUMENT_TYPE$lambda$0() {
        return ResourceLocationSetArgument.Companion.register();
    }

    static {
        ResourceKey resourceKey = Registries.COMMAND_ARGUMENT_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"COMMAND_ARGUMENT_TYPE");
        ENUM_COMMAND_ARGUMENT_TYPE = BCReg.INSTANCE.generic(resourceKey, "enum", BCArgumentTypes::ENUM_COMMAND_ARGUMENT_TYPE$lambda$0);
        ResourceKey resourceKey2 = Registries.COMMAND_ARGUMENT_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"COMMAND_ARGUMENT_TYPE");
        RESOURCE_LOCATION_ARGUMENT_TYPE = BCReg.INSTANCE.generic(resourceKey2, "resource_location", BCArgumentTypes::RESOURCE_LOCATION_ARGUMENT_TYPE$lambda$0);
    }
}

