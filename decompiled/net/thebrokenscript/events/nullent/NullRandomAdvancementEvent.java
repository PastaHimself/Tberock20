/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.advancements.AdvancementHolder
 *  net.minecraft.advancements.AdvancementProgress
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.PlayerAdvancements
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.nullent;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.OnlyNullEvent;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.misc.GameProfiles;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/events/nullent/NullRandomAdvancementEvent;", "Lnet/thebrokenscript/api/event/OnlyNullEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "Companion", "thebrokenscript-common"})
public final class NullRandomAdvancementEvent
extends OnlyNullEvent {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final List<ResourceLocation> advancements;
    @NotNull
    private static final ResourceLocation mobKill;
    @NotNull
    private static final ResourceLocation sleeping;

    public NullRandomAdvancementEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (!Intrinsics.areEqual((Object)player.getGameProfile(), (Object)GameProfiles.NULL_GAME_PROFILE)) {
            return;
        }
        PlayerAdvancements progressManager = player.getAdvancements();
        if (level.isNight()) {
            AdvancementHolder advancementHolder = level.getServer().getAdvancements().get(mobKill);
            if (advancementHolder == null) {
                return;
            }
            AdvancementHolder adv = advancementHolder;
            if (level.random.nextBoolean() && !player.getAdvancements().getOrStartProgress(adv).isDone()) {
                PlayerUtil.awardAdvancement((Player)((Player)player), (ResourceLocation)mobKill);
            } else {
                PlayerUtil.awardAdvancement((Player)((Player)player), (ResourceLocation)sleeping);
            }
            return;
        }
        for (ResourceLocation advLoc : advancements) {
            AdvancementHolder adv;
            AdvancementProgress progress;
            if (level.getServer().getAdvancements().get(advLoc) == null || (progress = progressManager.getOrStartProgress(adv)).isDone()) continue;
            Player player2 = (Player)player;
            Intrinsics.checkNotNull((Object)advLoc);
            PlayerUtil.awardAdvancement((Player)player2, (ResourceLocation)advLoc);
            return;
        }
    }

    static {
        Object[] objectArray = new ResourceLocation[]{ResourceLocation.withDefaultNamespace((String)"story/mine_stone"), ResourceLocation.withDefaultNamespace((String)"story/smelt_iron"), ResourceLocation.withDefaultNamespace((String)"story/iron_tools"), ResourceLocation.withDefaultNamespace((String)"story/obtain_armor"), ResourceLocation.withDefaultNamespace((String)"story/mine_diamond")};
        advancements = CollectionsKt.listOf((Object[])objectArray);
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace((String)"adventure/kill_a_mob");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withDefaultNamespace(...)");
        mobKill = resourceLocation;
        ResourceLocation resourceLocation2 = ResourceLocation.withDefaultNamespace((String)"adventure/sleep_in_bed");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation2, (String)"withDefaultNamespace(...)");
        sleeping = resourceLocation2;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/events/nullent/NullRandomAdvancementEvent$Companion;", "", "<init>", "()V", "advancements", "", "Lnet/minecraft/resources/ResourceLocation;", "kotlin.jvm.PlatformType", "getAdvancements", "()Ljava/util/List;", "mobKill", "getMobKill", "()Lnet/minecraft/resources/ResourceLocation;", "sleeping", "getSleeping", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List<ResourceLocation> getAdvancements() {
            return advancements;
        }

        @NotNull
        public final ResourceLocation getMobKill() {
            return mobKill;
        }

        @NotNull
        public final ResourceLocation getSleeping() {
            return sleeping;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

