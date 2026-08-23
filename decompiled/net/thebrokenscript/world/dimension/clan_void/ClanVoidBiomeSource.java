/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  com.mojang.serialization.codecs.RecordCodecBuilder$Instance
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.biome.Climate$Sampler
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.clan_void;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0010H\u0014J\u0010\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0012H\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/world/dimension/clan_void/ClanVoidBiomeSource;", "Lnet/minecraft/world/level/biome/BiomeSource;", "void", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/level/biome/Biome;", "dayA", "<init>", "(Lnet/minecraft/core/Holder;Lnet/minecraft/core/Holder;)V", "getNoiseBiome", "x", "", "y", "z", "sampler", "Lnet/minecraft/world/level/biome/Climate$Sampler;", "collectPossibleBiomes", "Ljava/util/stream/Stream;", "codec", "Lcom/mojang/serialization/MapCodec;", "Companion", "thebrokenscript-common"})
public final class ClanVoidBiomeSource
extends BiomeSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Holder<Biome> void;
    @NotNull
    private final Holder<Biome> dayA;
    @NotNull
    private static final MapCodec<ClanVoidBiomeSource> CODEC;

    public ClanVoidBiomeSource(@NotNull Holder<Biome> holder2, @NotNull Holder<Biome> dayA) {
        Intrinsics.checkNotNullParameter(holder2, (String)"void");
        Intrinsics.checkNotNullParameter(dayA, (String)"dayA");
        this.void = holder2;
        this.dayA = dayA;
    }

    @NotNull
    public Holder<Biome> getNoiseBiome(int x, int y, int z, @NotNull Climate.Sampler sampler) {
        Intrinsics.checkNotNullParameter((Object)sampler, (String)"sampler");
        return (62 <= y ? y < 81 : false) ? this.dayA : this.void;
    }

    @NotNull
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        Holder[] holderArray = new Holder[]{this.void, this.dayA};
        Stream<Holder<Biome>> stream = Stream.of(holderArray);
        Intrinsics.checkNotNullExpressionValue(stream, (String)"of(...)");
        return stream;
    }

    @NotNull
    protected MapCodec<? extends BiomeSource> codec() {
        return CODEC;
    }

    private static final App CODEC$lambda$0(RecordCodecBuilder.Instance instance) {
        return instance.group((App)Biome.CODEC.fieldOf("void").forGetter(ClanVoidBiomeSource::CODEC$lambda$0$0), (App)Biome.CODEC.fieldOf("day_a").forGetter(ClanVoidBiomeSource::CODEC$lambda$0$1)).apply((Applicative)instance, ClanVoidBiomeSource::new);
    }

    private static final Holder CODEC$lambda$0$0(ClanVoidBiomeSource it) {
        return it.void;
    }

    private static final Holder CODEC$lambda$0$1(ClanVoidBiomeSource it) {
        return it.dayA;
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(ClanVoidBiomeSource::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/clan_void/ClanVoidBiomeSource$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/clan_void/ClanVoidBiomeSource;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<ClanVoidBiomeSource> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

