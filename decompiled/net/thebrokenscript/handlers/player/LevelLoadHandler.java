/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.TicketType
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.fake.CustomPlayerManager
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import com.mojang.authlib.GameProfile;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.fake.CustomPlayerManager;
import net.thebrokenscript.handlers.player.LevelLoadHandler;
import net.thebrokenscript.handlers.subs.LevelLoadSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.misc.GameProfiles;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/player/LevelLoadHandler;", "", "<init>", "()V", "thebrokenscript-common"})
public final class LevelLoadHandler {
    @NotNull
    public static final LevelLoadHandler INSTANCE = new LevelLoadHandler();

    private LevelLoadHandler() {
    }

    private static final Unit _init_$lambda$0(Level it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if (!(it instanceof ServerLevel)) {
            return Unit.INSTANCE;
        }
        TicketType ticketType = TicketType.create((String)"initial_fever", Comparator.comparingLong(arg_0 -> LevelLoadHandler.lambda$0$0(1.initialFever.1.INSTANCE, arg_0)), (int)20);
        Intrinsics.checkNotNullExpressionValue((Object)ticketType, (String)"create(...)");
        TicketType initialFever2 = ticketType;
        if (LevelExt.INSTANCE.getVars((LevelAccessor)it).isNullHere()) {
            CustomPlayerManager.add((ServerLevel)((ServerLevel)it), (GameProfile)GameProfiles.NULL_GAME_PROFILE);
        }
        if (Intrinsics.areEqual((Object)it.dimension(), TBSDimensions.LIMBO)) {
            ((ServerLevel)it).getChunkSource().addRegionTicket(initialFever2, new ChunkPos(0, 0), 8, (Object)new ChunkPos(0, 0));
            ((ServerLevel)it).getChunk(0, 0);
            EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.FEVER.get()), (LevelAccessor)((LevelAccessor)it), (Vec3)new Vec3(0.0, 10.0, 0.0));
        }
        return Unit.INSTANCE;
    }

    private static final long lambda$0$0(Function1 $tmp0, Object p0) {
        return ((Number)$tmp0.invoke(p0)).longValue();
    }

    static {
        LevelLoadSubscriber.INSTANCE.add((Function1<? super Level, Unit>)((Function1)LevelLoadHandler::_init_$lambda$0));
    }
}

