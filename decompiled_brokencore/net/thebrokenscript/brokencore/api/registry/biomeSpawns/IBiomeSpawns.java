/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.biome.Biome
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.biomeSpawns;

import kotlin.Metadata;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\f\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/biomeSpawns/IBiomeSpawns;", "", "spawnBiomeTag", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/level/biome/Biome;", "getSpawnBiomeTag", "()Lnet/minecraft/tags/TagKey;", "spawnWeight", "", "getSpawnWeight", "()I", "spawnMinCount", "getSpawnMinCount", "spawnMaxCount", "getSpawnMaxCount", "entityType", "Lnet/minecraft/world/entity/EntityType;", "brokencore-common"})
public interface IBiomeSpawns {
    @NotNull
    public TagKey<Biome> getSpawnBiomeTag();

    public int getSpawnWeight();

    public int getSpawnMinCount();

    public int getSpawnMaxCount();

    @NotNull
    public EntityType<?> entityType();
}

