/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.biome.Biomes
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.thebrokenscript.brokencore.api.registry.util.TagBuilder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.registry.util.TagBuilder;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eR&\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\r0\r0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000f0\u000f0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00110\u00110\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\r0\r0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\r0\r0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000f0\u000f0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/registry/TBSTags;", "", "<init>", "()V", "DESPAWNABLE", "Lnet/minecraft/tags/TagKey;", "Lnet/minecraft/world/entity/EntityType;", "kotlin.jvm.PlatformType", "NOT_INHABITABLE", "LOOKABLE", "MODERN_MOBS", "TBS_CHASERS", "ROOT_REPLACEABLE", "Lnet/minecraft/world/level/block/Block;", "CREEPY_DISCS", "Lnet/minecraft/world/item/Item;", "ALLOWED_BIOMES_BOSS", "Lnet/minecraft/world/level/biome/Biome;", "TERRAIN_CORRUPT_REPLACE", "META_PARANOIA_TRIGGERS_CORRUPT", "META_PARANOIA_TRIGGERS_GLITCH", "META_PARANOIA_TRIGGERS", "VOID_FLORA_MINEABLE", "CAN_BE_USED_FOR_VOID_FLORA", "CIRCUIT_BREAKABLE", "NIW_BREAKABLE", "NULL_BREAKABLE", "id", "Lnet/minecraft/resources/ResourceLocation;", "namespace", "", "loc", "thebrokenscript-common"})
public final class TBSTags {
    @NotNull
    public static final TBSTags INSTANCE = new TBSTags();
    @JvmField
    @NotNull
    public static final TagKey<EntityType<?>> DESPAWNABLE;
    @JvmField
    @NotNull
    public static final TagKey<EntityType<?>> NOT_INHABITABLE;
    @JvmField
    @NotNull
    public static final TagKey<EntityType<?>> LOOKABLE;
    @JvmField
    @NotNull
    public static final TagKey<EntityType<?>> MODERN_MOBS;
    @JvmField
    @NotNull
    public static final TagKey<EntityType<?>> TBS_CHASERS;
    @JvmField
    @NotNull
    public static final TagKey<Block> ROOT_REPLACEABLE;
    @JvmField
    @NotNull
    public static final TagKey<Item> CREEPY_DISCS;
    @JvmField
    @NotNull
    public static final TagKey<Biome> ALLOWED_BIOMES_BOSS;
    @JvmField
    @NotNull
    public static final TagKey<Block> TERRAIN_CORRUPT_REPLACE;
    @JvmField
    @NotNull
    public static final TagKey<EntityType<?>> META_PARANOIA_TRIGGERS_CORRUPT;
    @JvmField
    @NotNull
    public static final TagKey<EntityType<?>> META_PARANOIA_TRIGGERS_GLITCH;
    @JvmField
    @NotNull
    public static final TagKey<EntityType<?>> META_PARANOIA_TRIGGERS;
    @JvmField
    @NotNull
    public static final TagKey<Block> VOID_FLORA_MINEABLE;
    @JvmField
    @NotNull
    public static final TagKey<Item> CAN_BE_USED_FOR_VOID_FLORA;
    @JvmField
    @NotNull
    public static final TagKey<Block> CIRCUIT_BREAKABLE;
    @JvmField
    @NotNull
    public static final TagKey<Block> NIW_BREAKABLE;
    @JvmField
    @NotNull
    public static final TagKey<Block> NULL_BREAKABLE;

    private TBSTags() {
    }

    @NotNull
    public final ResourceLocation id(@NotNull String namespace, @NotNull String loc) {
        Intrinsics.checkNotNullParameter((Object)namespace, (String)"namespace");
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)namespace, (String)loc);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    private static final void DESPAWNABLE$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Object[] objectArray = new EntityType[17];
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.SKELETON, (String)"SKELETON");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.SKELETON_HORSE, (String)"SKELETON_HORSE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ZOMBIE, (String)"ZOMBIE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ZOMBIE_HORSE, (String)"ZOMBIE_HORSE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ZOMBIE_VILLAGER, (String)"ZOMBIE_VILLAGER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.CREEPER, (String)"CREEPER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BAT, (String)"BAT");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.CAVE_SPIDER, (String)"CAVE_SPIDER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.SPIDER, (String)"SPIDER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ENDERMAN, (String)"ENDERMAN");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.WITCH, (String)"WITCH");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.STRAY, (String)"STRAY");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.DROWNED, (String)"DROWNED");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BOGGED, (String)"BOGGED");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.HUSK, (String)"HUSK");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.SLIME, (String)"SLIME");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BREEZE, (String)"BREEZE");
        $this$tag.plusAssign(objectArray);
    }

    private static final void NOT_INHABITABLE$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Holder[] holderArray = new Holder[]{TBSEntities.CIRCUIT, TBSEntities.HE, TBSEntities.THE_BROKEN_END_CURIOUS, TBSEntities.THE_OBLITERATION, TBSEntities.THE_BROKEN_END, TBSEntities.THE_BROKEN_END_STALK, TBSEntities.HETZER, TBSEntities.BAN, TBSEntities.CIRCUIT_MINESHAFT_FLEE, TBSEntities.CIRCUIT_STALK, TBSEntities.CIRCUIT_STARE, TBSEntities.CIRCUIT_MINESHAFT_WALK, TBSEntities.CIRCUIT_MINESHAFT_STARE, TBSEntities.CURVED, TBSEntities.DECEIVER, TBSEntities.EERIE_NOISE, TBSEntities.FAKE_PLAYER, TBSEntities.FARAWAY, TBSEntities.FOLLOW, TBSEntities.FRACTURED, TBSEntities.HEROBRINE, TBSEntities.HE_CHASE, TBSEntities.HE_HALLUCINATION, TBSEntities.SILUET, TBSEntities.SILUET_CHASE, TBSEntities.SILUET_STARE, TBSEntities.SILUET_HALLUCINATION, TBSEntities.INTEGRITY_PHASE_1, TBSEntities.CORRUPTION, TBSEntities.MURDERFUR, TBSEntities.CHUNK_REMOVER, TBSEntities.MAZE_SHADOWS, TBSEntities.NOTHING_IS_WATCHING, TBSEntities.NOTHING_IS_WATCHING_CHASE, TBSEntities.NULL_CHASE, TBSEntities.NULL_COD, TBSEntities.NULL_MAZE, TBSEntities.NULL_SCARE, TBSEntities.NULL_FLYING, TBSEntities.NULL_ENDGAME, TBSEntities.NULL_INVADE_BASE, TBSEntities.NULL_IS_HERE, TBSEntities.NULL_MINING, TBSEntities.NULL_UNBEATABLE_BOSSFIGHT, TBSEntities.NULL_WATCHING, TBSEntities.PHANTOM_PLAYER, TBSEntities.STARE, TBSEntities.SUB_ANOMALY_1, TBSEntities.SUB_ANOMALY_2, TBSEntities.XXRAM_2DIE, TBSEntities.INTEGRITY_PHASE_2, TBSEntities.INTEGRITY_PHASE_3, TBSEntities.INTEG_FIREBALL, TBSEntities.VOID_TENTACLE};
        $this$tag.plusAssign(holderArray);
    }

    private static final void LOOKABLE$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Object[] objectArray = new EntityType[24];
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.COW, (String)"COW");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.SHEEP, (String)"SHEEP");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.CHICKEN, (String)"CHICKEN");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.CAT, (String)"CAT");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.VILLAGER, (String)"VILLAGER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ZOMBIE, (String)"ZOMBIE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ZOMBIE_HORSE, (String)"ZOMBIE_HORSE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ZOMBIE_VILLAGER, (String)"ZOMBIE_VILLAGER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ZOMBIFIED_PIGLIN, (String)"ZOMBIFIED_PIGLIN");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BAT, (String)"BAT");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BEE, (String)"BEE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BLAZE, (String)"BLAZE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.CREEPER, (String)"CREEPER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.DONKEY, (String)"DONKEY");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.DROWNED, (String)"DROWNED");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ELDER_GUARDIAN, (String)"ELDER_GUARDIAN");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.SKELETON, (String)"SKELETON");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.SKELETON_HORSE, (String)"SKELETON_HORSE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.WITHER_SKELETON, (String)"WITHER_SKELETON");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.WITCH, (String)"WITCH");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.HORSE, (String)"HORSE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.PIG, (String)"PIG");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.PIGLIN, (String)"PIGLIN");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.PIGLIN_BRUTE, (String)"PIGLIN_BRUTE");
        $this$tag.plusAssign(objectArray);
    }

    private static final void MODERN_MOBS$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Object[] objectArray = new EntityType[28];
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BAT, (String)"BAT");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.DROWNED, (String)"DROWNED");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.GLOW_SQUID, (String)"GLOW_SQUID");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.PHANTOM, (String)"PHANTOM");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BEE, (String)"BEE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ALLAY, (String)"ALLAY");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.FOX, (String)"FOX");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.CAT, (String)"CAT");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.GOAT, (String)"GOAT");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.TROPICAL_FISH, (String)"TROPICAL_FISH");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.PANDA, (String)"PANDA");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.PUFFERFISH, (String)"PUFFERFISH");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.DOLPHIN, (String)"DOLPHIN");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.TRADER_LLAMA, (String)"TRADER_LLAMA");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.WANDERING_TRADER, (String)"WANDERING_TRADER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.TURTLE, (String)"TURTLE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.HOGLIN, (String)"HOGLIN");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.PIGLIN, (String)"PIGLIN");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.PIGLIN_BRUTE, (String)"PIGLIN_BRUTE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.SNIFFER, (String)"SNIFFER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.PILLAGER, (String)"PILLAGER");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.FROG, (String)"FROG");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.ARMADILLO, (String)"ARMADILLO");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.AXOLOTL, (String)"AXOLOTL");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BOGGED, (String)"BOGGED");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.BREEZE, (String)"BREEZE");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.CAMEL, (String)"CAMEL");
        Intrinsics.checkNotNullExpressionValue((Object)EntityType.TADPOLE, (String)"TADPOLE");
        $this$tag.plusAssign(objectArray);
    }

    private static final void TBS_CHASERS$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Holder[] holderArray = new Holder[]{TBSEntities.CIRCUIT, TBSEntities.NULL_CHASE, TBSEntities.SILUET_CHASE, TBSEntities.HE_CHASE, TBSEntities.THE_BROKEN_END, TBSEntities.NULL_MAZE, TBSEntities.NULL_IS_HERE, TBSEntities.FEVER};
        $this$tag.plusAssign(holderArray);
    }

    private static final void ROOT_REPLACEABLE$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Object[] objectArray = new TagKey[11];
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.COAL_ORES, (String)"COAL_ORES");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.IRON_ORES, (String)"IRON_ORES");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.GOLD_ORES, (String)"GOLD_ORES");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.DIAMOND_ORES, (String)"DIAMOND_ORES");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.EMERALD_ORES, (String)"EMERALD_ORES");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.LAPIS_ORES, (String)"LAPIS_ORES");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.REDSTONE_ORES, (String)"REDSTONE_ORES");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.COPPER_ORES, (String)"COPPER_ORES");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.SCULK_REPLACEABLE, (String)"SCULK_REPLACEABLE");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.DIRT, (String)"DIRT");
        Intrinsics.checkNotNullExpressionValue((Object)BlockTags.ICE, (String)"ICE");
        $this$tag.plusAssign((TagKey[])objectArray);
        objectArray = new Block[6];
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.DIRT_PATH, (String)"DIRT_PATH");
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.FARMLAND, (String)"FARMLAND");
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.SNOW_BLOCK, (String)"SNOW_BLOCK");
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.POWDER_SNOW, (String)"POWDER_SNOW");
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.WATER, (String)"WATER");
        Intrinsics.checkNotNullExpressionValue((Object)Blocks.ANCIENT_DEBRIS, (String)"ANCIENT_DEBRIS");
        $this$tag.plusAssign(objectArray);
        objectArray = new Holder[]{TBSBlocks.OBSIDIAN, TBSBlocks.R_3};
        $this$tag.plusAssign((Holder[])objectArray);
    }

    private static final void CREEPY_DISCS$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Object[] objectArray = new Item[3];
        Intrinsics.checkNotNullExpressionValue((Object)Items.MUSIC_DISC_11, (String)"MUSIC_DISC_11");
        Intrinsics.checkNotNullExpressionValue((Object)Items.MUSIC_DISC_13, (String)"MUSIC_DISC_13");
        Intrinsics.checkNotNullExpressionValue((Object)Items.MUSIC_DISC_5, (String)"MUSIC_DISC_5");
        $this$tag.plusAssign(objectArray);
    }

    private static final void ALLOWED_BIOMES_BOSS$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        ResourceKey[] resourceKeyArray = new ResourceKey[2];
        Intrinsics.checkNotNullExpressionValue((Object)Biomes.PLAINS, (String)"PLAINS");
        Intrinsics.checkNotNullExpressionValue((Object)Biomes.FOREST, (String)"FOREST");
        $this$tag.add(resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "fir_clearing")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "crag")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "field")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "grasslands")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "lavender_fields")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "marsh")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "origin_valey")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "overgrown_greens")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "pasture")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "prairie")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "pumpkin_patch")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "rocky_shrubland")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomesoplenty", "shrubland")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomeswevegone", "allium_shrubland")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomeswevegone", "amaranth_grassland")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomeswevegone", "basalt_barrera")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomeswevegone", "coconino_meadow")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomeswevegone", "orchard")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomeswevegone", "prairie")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomeswevegone", "pumpkin_valley")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("biomeswevegone", "rose_fields")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("nomansland", "lavender_field")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
        resourceKeyArray = new ResourceLocation[]{INSTANCE.id("nomansland", "prairie")};
        $this$tag.addOptional((ResourceLocation[])resourceKeyArray);
    }

    private static final void TERRAIN_CORRUPT_REPLACE$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Holder[] holderArray = new Holder[]{TBSBlocks.OBSIDIAN, TBSBlocks.R_3, TBSBlocks.VOID_ROOT, TBSBlocks.TEETH};
        $this$tag.plusAssign(holderArray);
    }

    private static final void META_PARANOIA_TRIGGERS_CORRUPT$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Holder[] holderArray = new Holder[]{TBSEntities.CIRCUIT, TBSEntities.THE_BROKEN_END};
        $this$tag.plusAssign(holderArray);
    }

    private static final void META_PARANOIA_TRIGGERS_GLITCH$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Holder[] holderArray = new Holder[]{TBSEntities.NULL_CHASE, TBSEntities.HE_CHASE, TBSEntities.NULL_MAZE, TBSEntities.SILUET_CHASE};
        $this$tag.plusAssign(holderArray);
    }

    private static final void META_PARANOIA_TRIGGERS$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        TagKey[] tagKeyArray = new TagKey[]{META_PARANOIA_TRIGGERS_CORRUPT, META_PARANOIA_TRIGGERS_GLITCH};
        $this$tag.plusAssign(tagKeyArray);
    }

    private static final void VOID_FLORA_MINEABLE$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Holder[] holderArray = new Holder[]{TBSBlocks.VOID_SPROUT, TBSBlocks.VOID_BUD, TBSBlocks.VOID_BUDDING, TBSBlocks.VOID_BLOOM, TBSBlocks.VOID_BLOSSOM, TBSBlocks.VOID_VINE, TBSBlocks.VOID_GRASS};
        $this$tag.plusAssign(holderArray);
    }

    private static final void CAN_BE_USED_FOR_VOID_FLORA$lambda$0(TagBuilder $this$tag) {
        Intrinsics.checkNotNullParameter((Object)$this$tag, (String)"$this$tag");
        Object[] objectArray = new Item[1];
        Intrinsics.checkNotNullExpressionValue((Object)Items.SHEARS, (String)"SHEARS");
        $this$tag.add(objectArray);
    }

    static {
        ResourceKey resourceKey = Registries.ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"ENTITY_TYPE");
        DESPAWNABLE = TBSReg.INSTANCE.tag(resourceKey, "despawnable", TBSTags::DESPAWNABLE$lambda$0);
        ResourceKey resourceKey2 = Registries.ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"ENTITY_TYPE");
        NOT_INHABITABLE = TBSReg.INSTANCE.tag(resourceKey2, "not_inhabitable", TBSTags::NOT_INHABITABLE$lambda$0);
        ResourceKey resourceKey3 = Registries.ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey3, (String)"ENTITY_TYPE");
        LOOKABLE = TBSReg.INSTANCE.tag(resourceKey3, "lookable", TBSTags::LOOKABLE$lambda$0);
        ResourceKey resourceKey4 = Registries.ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey4, (String)"ENTITY_TYPE");
        MODERN_MOBS = TBSReg.INSTANCE.tag(resourceKey4, "modern_mobs", TBSTags::MODERN_MOBS$lambda$0);
        ResourceKey resourceKey5 = Registries.ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey5, (String)"ENTITY_TYPE");
        TBS_CHASERS = TBSReg.INSTANCE.tag(resourceKey5, "chaser", TBSTags::TBS_CHASERS$lambda$0);
        ResourceKey resourceKey6 = Registries.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey6, (String)"BLOCK");
        ROOT_REPLACEABLE = TBSReg.INSTANCE.tag(resourceKey6, "root_replaceable", TBSTags::ROOT_REPLACEABLE$lambda$0);
        ResourceKey resourceKey7 = Registries.ITEM;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey7, (String)"ITEM");
        CREEPY_DISCS = TBSReg.INSTANCE.tag(resourceKey7, "creepy_discs", TBSTags::CREEPY_DISCS$lambda$0);
        ResourceKey resourceKey8 = Registries.BIOME;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey8, (String)"BIOME");
        ALLOWED_BIOMES_BOSS = TBSReg.INSTANCE.tag(resourceKey8, "allowed_boss_biomes", TBSTags::ALLOWED_BIOMES_BOSS$lambda$0);
        ResourceKey resourceKey9 = Registries.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey9, (String)"BLOCK");
        TERRAIN_CORRUPT_REPLACE = TBSReg.INSTANCE.tag(resourceKey9, "terrain_corrupt_replace", TBSTags::TERRAIN_CORRUPT_REPLACE$lambda$0);
        ResourceKey resourceKey10 = Registries.ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey10, (String)"ENTITY_TYPE");
        META_PARANOIA_TRIGGERS_CORRUPT = TBSReg.INSTANCE.tag(resourceKey10, "meta_paranoia_triggers_corrupt", TBSTags::META_PARANOIA_TRIGGERS_CORRUPT$lambda$0);
        ResourceKey resourceKey11 = Registries.ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey11, (String)"ENTITY_TYPE");
        META_PARANOIA_TRIGGERS_GLITCH = TBSReg.INSTANCE.tag(resourceKey11, "meta_paranoia_triggers_glitch", TBSTags::META_PARANOIA_TRIGGERS_GLITCH$lambda$0);
        ResourceKey resourceKey12 = Registries.ENTITY_TYPE;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey12, (String)"ENTITY_TYPE");
        META_PARANOIA_TRIGGERS = TBSReg.INSTANCE.tag(resourceKey12, "meta_paranoia_triggers", TBSTags::META_PARANOIA_TRIGGERS$lambda$0);
        ResourceKey resourceKey13 = Registries.BLOCK;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey13, (String)"BLOCK");
        VOID_FLORA_MINEABLE = TBSReg.INSTANCE.tag(resourceKey13, "void_flora_mineable", TBSTags::VOID_FLORA_MINEABLE$lambda$0);
        ResourceKey resourceKey14 = Registries.ITEM;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey14, (String)"ITEM");
        CAN_BE_USED_FOR_VOID_FLORA = TBSReg.INSTANCE.tag(resourceKey14, "can_be_used_for_void_flora", TBSTags::CAN_BE_USED_FOR_VOID_FLORA$lambda$0);
        TagKey tagKey = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)TBSConstants.id("circuitbreakable"));
        Intrinsics.checkNotNullExpressionValue((Object)tagKey, (String)"create(...)");
        CIRCUIT_BREAKABLE = tagKey;
        TagKey tagKey2 = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)TBSConstants.id("nothingiswatchingbreakable"));
        Intrinsics.checkNotNullExpressionValue((Object)tagKey2, (String)"create(...)");
        NIW_BREAKABLE = tagKey2;
        TagKey tagKey3 = TagKey.create((ResourceKey)Registries.BLOCK, (ResourceLocation)TBSConstants.id("nullbreakablefixed"));
        Intrinsics.checkNotNullExpressionValue((Object)tagKey3, (String)"create(...)");
        NULL_BREAKABLE = tagKey3;
    }
}

