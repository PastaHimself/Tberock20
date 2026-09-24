/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import net.thebrokenscript.brokencore.impl.registry.BCReg;
import net.thebrokenscript.brokencore.impl.registry.BCSpawnConditions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/impl/registry/BCSpawnConditions;", "", "<init>", "()V", "BASIC", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "brokencore-common"})
public final class BCSpawnConditions {
    @NotNull
    public static final BCSpawnConditions INSTANCE = new BCSpawnConditions();
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> BASIC = BCReg.INSTANCE.spawnConditions("basic", (Function0<? extends SpawnConditions>)((Function0)BASIC.1.INSTANCE));

    private BCSpawnConditions() {
    }
}

