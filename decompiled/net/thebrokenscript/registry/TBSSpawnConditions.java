/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  net.thebrokenscript.brokencore.api.entity.SpawnConditions
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSReg;
import net.thebrokenscript.registry.TBSSpawnConditions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/registry/TBSSpawnConditions;", "", "<init>", "()V", "DEFAULT", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "CORRUPTION_CONDITIONS", "ENTITY", "TBE", "TBE_AMBUSH", "MAZE_CHASER", "SILUET", "CIRCUIT_STALK", "CIRCUIT_MINESHAFT", "MAZE_SHADOW", "EERIE", "NULL_CONDITIONS", "ANOMALY", "ANOMALY2", "NIW", "OBLIT", "FARAWAY", "FEVER_STALK_CONDITIONS", "FRACTURED_CONDITIONS", "CHUNK", "NOTHING_WATCHER", "CURVED_CONDITIONS", "NAME_TAG", "HEROBRINE_CONDITIONS", "thebrokenscript-common"})
public final class TBSSpawnConditions {
    @NotNull
    public static final TBSSpawnConditions INSTANCE = new TBSSpawnConditions();
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> DEFAULT = TBSReg.INSTANCE.spawnConditions("default", DEFAULT.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> CORRUPTION_CONDITIONS = TBSReg.INSTANCE.spawnConditions("corruption_conditions", CORRUPTION_CONDITIONS.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> ENTITY = TBSReg.INSTANCE.spawnConditions("entity", ENTITY.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> TBE = TBSReg.INSTANCE.spawnConditions("tbe", TBE.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> TBE_AMBUSH = TBSReg.INSTANCE.spawnConditions("tbe_ambush", TBE_AMBUSH.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> MAZE_CHASER = TBSReg.INSTANCE.spawnConditions("maze", MAZE_CHASER.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> SILUET = TBSReg.INSTANCE.spawnConditions("siluet", SILUET.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> CIRCUIT_STALK = TBSReg.INSTANCE.spawnConditions("circuit_stalk", CIRCUIT_STALK.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> CIRCUIT_MINESHAFT = TBSReg.INSTANCE.spawnConditions("circuit_mineshaft", CIRCUIT_MINESHAFT.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> MAZE_SHADOW = TBSReg.INSTANCE.spawnConditions("maze_shadow", MAZE_SHADOW.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> EERIE = TBSReg.INSTANCE.spawnConditions("eerie", EERIE.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> NULL_CONDITIONS = TBSReg.INSTANCE.spawnConditions("null", NULL_CONDITIONS.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> ANOMALY = TBSReg.INSTANCE.spawnConditions("anomaly", ANOMALY.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> ANOMALY2 = TBSReg.INSTANCE.spawnConditions("anomaly2", ANOMALY2.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> NIW = TBSReg.INSTANCE.spawnConditions("niw", NIW.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> OBLIT = TBSReg.INSTANCE.spawnConditions("oblit", OBLIT.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> FARAWAY = TBSReg.INSTANCE.spawnConditions("faraway", FARAWAY.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> FEVER_STALK_CONDITIONS = TBSReg.INSTANCE.spawnConditions("fever_stalk", FEVER_STALK_CONDITIONS.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> FRACTURED_CONDITIONS = TBSReg.INSTANCE.spawnConditions("fractured", FRACTURED_CONDITIONS.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> CHUNK = TBSReg.INSTANCE.spawnConditions("chunk", CHUNK.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> NOTHING_WATCHER = TBSReg.INSTANCE.spawnConditions("nothing_watcher", NOTHING_WATCHER.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> CURVED_CONDITIONS = TBSReg.INSTANCE.spawnConditions("curved_spawn_cond", CURVED_CONDITIONS.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> NAME_TAG = TBSReg.INSTANCE.spawnConditions("name_tag", NAME_TAG.1.INSTANCE);
    @JvmField
    @NotNull
    public static final RegistryEntry<SpawnConditions, SpawnConditions> HEROBRINE_CONDITIONS = TBSReg.INSTANCE.spawnConditions("herobrine_cond", HEROBRINE_CONDITIONS.1.INSTANCE);

    private TBSSpawnConditions() {
    }
}

