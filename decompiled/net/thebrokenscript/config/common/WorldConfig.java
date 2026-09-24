/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  net.thebrokenscript.brokencore.api.config.Config
 *  net.thebrokenscript.brokencore.api.config.Config$ConfigBool
 *  net.thebrokenscript.brokencore.api.config.Config$ConfigInt
 *  net.thebrokenscript.brokencore.api.config.Config$SubGroup
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.config.common;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.thebrokenscript.brokencore.api.config.Config;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR+\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR+\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR+\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\nR+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u001d8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010%\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\f\u001a\u0004\b&\u0010\b\"\u0004\b'\u0010\nR+\u0010)\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\f\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\nR+\u0010-\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b0\u0010\f\u001a\u0004\b.\u0010\b\"\u0004\b/\u0010\n\u00a8\u00061"}, d2={"Lnet/thebrokenscript/config/common/WorldConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$SubGroup;", "<init>", "()V", "<set-?>", "", "removeDeepslate", "getRemoveDeepslate", "()Z", "setRemoveDeepslate", "(Z)V", "removeDeepslate$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "allowOldWorldGen", "getAllowOldWorldGen", "setAllowOldWorldGen", "allowOldWorldGen$delegate", "disableVoidHoles", "getDisableVoidHoles", "setDisableVoidHoles", "disableVoidHoles$delegate", "disableWorldEater", "getDisableWorldEater", "setDisableWorldEater", "disableWorldEater$delegate", "disableRandomStructures", "getDisableRandomStructures", "setDisableRandomStructures", "disableRandomStructures$delegate", "", "nightmareTeleportChance", "getNightmareTeleportChance", "()I", "setNightmareTeleportChance", "(I)V", "nightmareTeleportChance$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigInt;", "disableSeedChanger", "getDisableSeedChanger", "setDisableSeedChanger", "disableSeedChanger$delegate", "allowCorruptedWorldGeneration", "getAllowCorruptedWorldGeneration", "setAllowCorruptedWorldGeneration", "allowCorruptedWorldGeneration$delegate", "allowChunkYOffsetGeneration", "getAllowChunkYOffsetGeneration", "setAllowChunkYOffsetGeneration", "allowChunkYOffsetGeneration$delegate", "thebrokenscript-common"})
public final class WorldConfig
extends Config.SubGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final Config.ConfigBool removeDeepslate$delegate;
    @NotNull
    private final Config.ConfigBool allowOldWorldGen$delegate;
    @NotNull
    private final Config.ConfigBool disableVoidHoles$delegate;
    @NotNull
    private final Config.ConfigBool disableWorldEater$delegate;
    @NotNull
    private final Config.ConfigBool disableRandomStructures$delegate;
    @NotNull
    private final Config.ConfigInt nightmareTeleportChance$delegate;
    @NotNull
    private final Config.ConfigBool disableSeedChanger$delegate;
    @NotNull
    private final Config.ConfigBool allowCorruptedWorldGeneration$delegate;
    @NotNull
    private final Config.ConfigBool allowChunkYOffsetGeneration$delegate;

    public WorldConfig() {
        String[] stringArray = new String[]{"Remove deepslate."};
        this.removeDeepslate$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[0]);
        stringArray = new String[]{"Make World Generate Old Caves.\nthis adds Nostalgia Generation on world creation screen by default if allowed"};
        this.allowOldWorldGen$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[1]);
        stringArray = new String[]{"Disable spawning void holes."};
        this.disableVoidHoles$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[2]);
        stringArray = new String[]{"Disable world eating functionality."};
        this.disableWorldEater$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[3]);
        stringArray = new String[]{"Disable random structure spawning."};
        this.disableRandomStructures$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[4]);
        stringArray = new String[]{"Nightmare Teleport Chance by sleeping"};
        this.nightmareTeleportChance$delegate = (Config.ConfigInt)this.i(10, 0, 100, stringArray).provideDelegate((Object)this, $$delegatedProperties[5]);
        stringArray = new String[]{"Disable Seed Changer"};
        this.disableSeedChanger$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[6]);
        stringArray = new String[]{"Additional Corrupted Worldgen (shouldn't be played in regular gameplay), WARNING: MAY LAG.\nDO NOT MIX WITH RANDOM CHUNK Y OFFSET CONFIG. WORLD GEN WITH THIS IS IRREVERSIBLE"};
        this.allowCorruptedWorldGeneration$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[7]);
        stringArray = new String[]{"Additional random Chunk Y offset generation (shouldn't be played in regular gameplay). WARNING: VERY PERFORMANCE HEAVY, MAY LAG.\nDO NOT MIX WITH CORRUPTED WORLD GENERATION CONFIG. WORLD GEN WITH THIS IS IRREVERSIBLE"};
        this.allowChunkYOffsetGeneration$delegate = (Config.ConfigBool)this.b(false, stringArray).provideDelegate((Object)this, $$delegatedProperties[8]);
    }

    public final boolean getRemoveDeepslate() {
        return (Boolean)this.removeDeepslate$delegate.getValue((Config)this, $$delegatedProperties[0]);
    }

    public final void setRemoveDeepslate(boolean bl) {
        this.removeDeepslate$delegate.setValue((Config)this, $$delegatedProperties[0], (Object)bl);
    }

    public final boolean getAllowOldWorldGen() {
        return (Boolean)this.allowOldWorldGen$delegate.getValue((Config)this, $$delegatedProperties[1]);
    }

    public final void setAllowOldWorldGen(boolean bl) {
        this.allowOldWorldGen$delegate.setValue((Config)this, $$delegatedProperties[1], (Object)bl);
    }

    public final boolean getDisableVoidHoles() {
        return (Boolean)this.disableVoidHoles$delegate.getValue((Config)this, $$delegatedProperties[2]);
    }

    public final void setDisableVoidHoles(boolean bl) {
        this.disableVoidHoles$delegate.setValue((Config)this, $$delegatedProperties[2], (Object)bl);
    }

    public final boolean getDisableWorldEater() {
        return (Boolean)this.disableWorldEater$delegate.getValue((Config)this, $$delegatedProperties[3]);
    }

    public final void setDisableWorldEater(boolean bl) {
        this.disableWorldEater$delegate.setValue((Config)this, $$delegatedProperties[3], (Object)bl);
    }

    public final boolean getDisableRandomStructures() {
        return (Boolean)this.disableRandomStructures$delegate.getValue((Config)this, $$delegatedProperties[4]);
    }

    public final void setDisableRandomStructures(boolean bl) {
        this.disableRandomStructures$delegate.setValue((Config)this, $$delegatedProperties[4], (Object)bl);
    }

    public final int getNightmareTeleportChance() {
        return ((Number)this.nightmareTeleportChance$delegate.getValue((Config)this, $$delegatedProperties[5])).intValue();
    }

    public final void setNightmareTeleportChance(int n) {
        this.nightmareTeleportChance$delegate.setValue((Config)this, $$delegatedProperties[5], (Object)n);
    }

    public final boolean getDisableSeedChanger() {
        return (Boolean)this.disableSeedChanger$delegate.getValue((Config)this, $$delegatedProperties[6]);
    }

    public final void setDisableSeedChanger(boolean bl) {
        this.disableSeedChanger$delegate.setValue((Config)this, $$delegatedProperties[6], (Object)bl);
    }

    public final boolean getAllowCorruptedWorldGeneration() {
        return (Boolean)this.allowCorruptedWorldGeneration$delegate.getValue((Config)this, $$delegatedProperties[7]);
    }

    public final void setAllowCorruptedWorldGeneration(boolean bl) {
        this.allowCorruptedWorldGeneration$delegate.setValue((Config)this, $$delegatedProperties[7], (Object)bl);
    }

    public final boolean getAllowChunkYOffsetGeneration() {
        return (Boolean)this.allowChunkYOffsetGeneration$delegate.getValue((Config)this, $$delegatedProperties[8]);
    }

    public final void setAllowChunkYOffsetGeneration(boolean bl) {
        this.allowChunkYOffsetGeneration$delegate.setValue((Config)this, $$delegatedProperties[8], (Object)bl);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(WorldConfig.class, "removeDeepslate", "getRemoveDeepslate()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(WorldConfig.class, "allowOldWorldGen", "getAllowOldWorldGen()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(WorldConfig.class, "disableVoidHoles", "getDisableVoidHoles()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(WorldConfig.class, "disableWorldEater", "getDisableWorldEater()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(WorldConfig.class, "disableRandomStructures", "getDisableRandomStructures()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(WorldConfig.class, "nightmareTeleportChance", "getNightmareTeleportChance()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(WorldConfig.class, "disableSeedChanger", "getDisableSeedChanger()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(WorldConfig.class, "allowCorruptedWorldGeneration", "getAllowCorruptedWorldGeneration()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(WorldConfig.class, "allowChunkYOffsetGeneration", "getAllowChunkYOffsetGeneration()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}

