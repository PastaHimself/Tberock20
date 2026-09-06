/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.HitResult
 *  org.jetbrains.annotations.NotNull
 *  snownee.jade.api.Accessor
 *  snownee.jade.api.EntityAccessor
 *  snownee.jade.api.IWailaClientRegistration
 *  snownee.jade.api.IWailaCommonRegistration
 *  snownee.jade.api.IWailaPlugin
 *  snownee.jade.api.WailaPlugin
 */
package net.thebrokenscript.compat.jade;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.thebrokenscript.compat.jade.FakePlayerJade;
import net.thebrokenscript.compat.jade.TBSJadePlugin;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import org.jetbrains.annotations.NotNull;
import snownee.jade.api.Accessor;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/compat/jade/TBSJadePlugin;", "Lsnownee/jade/api/IWailaPlugin;", "<init>", "()V", "register", "", "reg", "Lsnownee/jade/api/IWailaCommonRegistration;", "registerClient", "Lsnownee/jade/api/IWailaClientRegistration;", "Companion", "thebrokenscript-common"})
public final class TBSJadePlugin
implements IWailaPlugin {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Map<FakePlayerEntity, FakePlayerJade> fakePlayerCache = new LinkedHashMap();

    public void register(@NotNull IWailaCommonRegistration reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
    }

    public void registerClient(@NotNull IWailaClientRegistration reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.addRayTraceCallback((arg_0, arg_1, arg_2) -> TBSJadePlugin.registerClient$lambda$0(reg, arg_0, arg_1, arg_2));
    }

    private static final Accessor registerClient$lambda$0(IWailaClientRegistration $reg, HitResult hit, Accessor acc, Accessor orig) {
        Entity entity;
        if (acc instanceof EntityAccessor && (entity = ((EntityAccessor)acc).getEntity()) instanceof FakePlayerEntity && ((FakePlayerEntity)entity).getGameProfile() != null) {
            return (Accessor)$reg.entityAccessor().from((EntityAccessor)acc).player((Player)fakePlayerCache.computeIfAbsent((FakePlayerEntity)entity, arg_0 -> TBSJadePlugin.registerClient$lambda$0$0(registerClient.1.1.INSTANCE, arg_0))).build();
        }
        return acc;
    }

    private static final FakePlayerJade registerClient$lambda$0$0(Function1 $tmp0, Object p0) {
        return (FakePlayerJade)((Object)$tmp0.invoke(p0));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/compat/jade/TBSJadePlugin$Companion;", "", "<init>", "()V", "fakePlayerCache", "", "Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "Lnet/thebrokenscript/compat/jade/FakePlayerJade;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

