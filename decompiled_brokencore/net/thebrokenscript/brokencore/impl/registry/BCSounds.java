/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.sounds.SoundEvent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.registry;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.brokencore.api.registry.builders.SoundBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import net.thebrokenscript.brokencore.impl.registry.BCReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/impl/registry/BCSounds;", "", "<init>", "()V", "VINE_BOOM", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/sounds/SoundEvent;", "getVINE_BOOM", "()Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "brokencore-common"})
public final class BCSounds {
    @NotNull
    public static final BCSounds INSTANCE = new BCSounds();
    @NotNull
    private static final RegistryEntry<SoundEvent, SoundEvent> VINE_BOOM = BCReg.INSTANCE.sound("vine_boom", BCSounds::VINE_BOOM$lambda$0);

    private BCSounds() {
    }

    @NotNull
    public final RegistryEntry<SoundEvent, SoundEvent> getVINE_BOOM() {
        return VINE_BOOM;
    }

    private static final void VINE_BOOM$lambda$0(SoundBuilder $this$sound) {
        Intrinsics.checkNotNullParameter((Object)$this$sound, (String)"$this$sound");
        SoundBuilder.simple$default($this$sound, false, 1, null);
        $this$sound.subtitle = "Fuck You";
    }
}

