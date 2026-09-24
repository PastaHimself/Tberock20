/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ClientInformation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.stats.Stat
 *  net.minecraft.world.Container
 *  net.minecraft.world.MenuProvider
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.animal.horse.AbstractHorse
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.fake;

import com.mojang.authlib.GameProfile;
import java.util.OptionalInt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stat;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.fake.FakePlayerPacketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u00020\t2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\rH\u0016\u00a8\u0006."}, d2={"Lnet/thebrokenscript/brokencore/api/fake/FakePlayer;", "Lnet/minecraft/server/level/ServerPlayer;", "level", "Lnet/minecraft/server/level/ServerLevel;", "gameProfile", "Lcom/mojang/authlib/GameProfile;", "<init>", "(Lnet/minecraft/server/level/ServerLevel;Lcom/mojang/authlib/GameProfile;)V", "displayClientMessage", "", "chatComponent", "Lnet/minecraft/network/chat/Component;", "actionBar", "", "isInvisible", "setInvisible", "invisible", "awardStat", "stat", "Lnet/minecraft/stats/Stat;", "amount", "", "isInvulnerableTo", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "canHarmPlayer", "player", "Lnet/minecraft/world/entity/player/Player;", "die", "tick", "updateOptions", "info", "Lnet/minecraft/server/level/ClientInformation;", "openMenu", "Ljava/util/OptionalInt;", "menu", "Lnet/minecraft/world/MenuProvider;", "openHorseInventory", "horse", "Lnet/minecraft/world/entity/animal/horse/AbstractHorse;", "container", "Lnet/minecraft/world/Container;", "startRiding", "entity", "Lnet/minecraft/world/entity/Entity;", "force", "brokencore-common"})
public final class FakePlayer
extends ServerPlayer {
    public FakePlayer(@NotNull ServerLevel level, @NotNull GameProfile gameProfile) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)gameProfile, (String)"gameProfile");
        super(level.getServer(), level, gameProfile, ClientInformation.createDefault());
        MinecraftServer minecraftServer = this.server;
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"server");
        this.connection = new FakePlayerPacketListener(minecraftServer, this);
    }

    public void displayClientMessage(@NotNull Component chatComponent, boolean actionBar) {
        Intrinsics.checkNotNullParameter((Object)chatComponent, (String)"chatComponent");
    }

    public boolean isInvisible() {
        return true;
    }

    public void setInvisible(boolean invisible) {
        this.setSharedFlag(5, true);
    }

    public void awardStat(@NotNull Stat<?> stat, int amount) {
        Intrinsics.checkNotNullParameter(stat, (String)"stat");
    }

    public boolean isInvulnerableTo(@NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return true;
    }

    public boolean canHarmPlayer(@NotNull Player player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        return false;
    }

    public void die(@NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
    }

    public void tick() {
    }

    public void updateOptions(@NotNull ClientInformation info) {
        Intrinsics.checkNotNullParameter((Object)info, (String)"info");
    }

    @NotNull
    public OptionalInt openMenu(@Nullable MenuProvider menu) {
        OptionalInt optionalInt = OptionalInt.empty();
        Intrinsics.checkNotNullExpressionValue((Object)optionalInt, (String)"empty(...)");
        return optionalInt;
    }

    public void openHorseInventory(@NotNull AbstractHorse horse, @NotNull Container container) {
        Intrinsics.checkNotNullParameter((Object)horse, (String)"horse");
        Intrinsics.checkNotNullParameter((Object)container, (String)"container");
    }

    public boolean startRiding(@NotNull Entity entity, boolean force) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return false;
    }
}

