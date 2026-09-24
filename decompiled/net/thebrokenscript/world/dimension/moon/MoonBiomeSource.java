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
package net.thebrokenscript.world.dimension.moon;

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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0017H\u0014J\u0010\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0019H\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/world/dimension/moon/MoonBiomeSource;", "Lnet/minecraft/world/level/biome/BiomeSource;", "moon", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/level/biome/Biome;", "stereogenicGrowth", "dysaphyticWen", "<init>", "(Lnet/minecraft/core/Holder;Lnet/minecraft/core/Holder;Lnet/minecraft/core/Holder;)V", "cellSize", "", "radius", "rarity", "hashCell", "cx", "cz", "getNoiseBiome", "x", "y", "z", "sampler", "Lnet/minecraft/world/level/biome/Climate$Sampler;", "collectPossibleBiomes", "Ljava/util/stream/Stream;", "codec", "Lcom/mojang/serialization/MapCodec;", "Companion", "thebrokenscript-common"})
public final class MoonBiomeSource
extends BiomeSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Holder<Biome> moon;
    @NotNull
    private final Holder<Biome> stereogenicGrowth;
    @NotNull
    private final Holder<Biome> dysaphyticWen;
    private final int cellSize;
    private final int radius;
    private final int rarity;
    @NotNull
    private static final MapCodec<MoonBiomeSource> CODEC;

    public MoonBiomeSource(@NotNull Holder<Biome> moon, @NotNull Holder<Biome> stereogenicGrowth, @NotNull Holder<Biome> dysaphyticWen) {
        Intrinsics.checkNotNullParameter(moon, (String)"moon");
        Intrinsics.checkNotNullParameter(stereogenicGrowth, (String)"stereogenicGrowth");
        Intrinsics.checkNotNullParameter(dysaphyticWen, (String)"dysaphyticWen");
        this.moon = moon;
        this.stereogenicGrowth = stereogenicGrowth;
        this.dysaphyticWen = dysaphyticWen;
        this.cellSize = 32;
        this.radius = 20;
        this.rarity = 150;
    }

    public final int hashCell(int cx, int cz) {
        int h = cx * 0x1F1F1F1F ^ cz;
        h ^= h >>> 16;
        h *= -2128831035;
        h ^= h >>> 13;
        return Math.floorMod(h, this.rarity);
    }

    @NotNull
    public Holder<Biome> getNoiseBiome(int x, int y, int z, @NotNull Climate.Sampler sampler) {
        Intrinsics.checkNotNullParameter((Object)sampler, (String)"sampler");
        int cellX = Math.floorDiv(x, this.cellSize);
        int cellZ = Math.floorDiv(z, this.cellSize);
        int cx = cellX - 1;
        int n = cellX + 1;
        if (cx <= n) {
            while (true) {
                int n2;
                int cz;
                if ((cz = cellZ - 1) <= (n2 = cellZ + 1)) {
                    while (true) {
                        int hash;
                        if ((hash = this.hashCell(cx, cz)) == 0) {
                            int offsetZ;
                            int centerZ;
                            int dz;
                            int randumb = Math.floorMod(cx * 8330 + cz * 9111, 2);
                            Holder<Biome> biome = randumb == 0 ? this.stereogenicGrowth : this.dysaphyticWen;
                            int offsetX = Math.floorMod(cx * 5329 + cz * 3911, this.cellSize);
                            int centerX = cx * this.cellSize + offsetX;
                            int dx = x - centerX;
                            if (dx * dx + (dz = z - (centerZ = cz * this.cellSize + (offsetZ = Math.floorMod(cx * 7213 + cz * 2719, this.cellSize)))) * dz < this.radius * this.radius) {
                                return biome;
                            }
                        }
                        if (cz == n2) break;
                        ++cz;
                    }
                }
                if (cx == n) break;
                ++cx;
            }
        }
        return this.moon;
    }

    @NotNull
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        Holder[] holderArray = new Holder[]{this.moon, this.stereogenicGrowth, this.dysaphyticWen};
        Stream<Holder<Biome>> stream = Stream.of(holderArray);
        Intrinsics.checkNotNullExpressionValue(stream, (String)"of(...)");
        return stream;
    }

    @NotNull
    protected MapCodec<? extends BiomeSource> codec() {
        return CODEC;
    }

    private static final App CODEC$lambda$0(RecordCodecBuilder.Instance instance) {
        return instance.group((App)Biome.CODEC.fieldOf("moon").forGetter(MoonBiomeSource::CODEC$lambda$0$0), (App)Biome.CODEC.fieldOf("stereogenic_growth").forGetter(MoonBiomeSource::CODEC$lambda$0$1), (App)Biome.CODEC.fieldOf("dysaphytic_wen").forGetter(MoonBiomeSource::CODEC$lambda$0$2)).apply((Applicative)instance, MoonBiomeSource::new);
    }

    private static final Holder CODEC$lambda$0$0(MoonBiomeSource it) {
        return it.moon;
    }

    private static final Holder CODEC$lambda$0$1(MoonBiomeSource it) {
        return it.stereogenicGrowth;
    }

    private static final Holder CODEC$lambda$0$2(MoonBiomeSource it) {
        return it.dysaphyticWen;
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(MoonBiomeSource::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/moon/MoonBiomeSource$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/moon/MoonBiomeSource;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<MoonBiomeSource> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

