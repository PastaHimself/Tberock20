/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  me.shedaniel.rei.api.client.plugins.REIClientPlugin
 *  me.shedaniel.rei.api.client.registry.entry.EntryRegistry
 *  me.shedaniel.rei.api.common.entry.EntryStack
 *  me.shedaniel.rei.forge.REIPluginClient
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.neoforge.compat.rei;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.forge.REIPluginClient;
import org.jetbrains.annotations.NotNull;

@REIPluginClient
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/neoforge/compat/rei/TBSReiPlugin;", "Lme/shedaniel/rei/api/client/plugins/REIClientPlugin;", "<init>", "()V", "registerEntries", "", "reg", "Lme/shedaniel/rei/api/client/registry/entry/EntryRegistry;", "thebrokenscript-neoforge"})
public final class TBSReiPlugin
implements REIClientPlugin {
    public void registerEntries(@NotNull EntryRegistry reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.removeEntryIf(TBSReiPlugin::registerEntries$lambda$0);
    }

    private static final boolean registerEntries$lambda$0(EntryStack it) {
        return Intrinsics.areEqual((Object)it.getType().getId().getNamespace(), (Object)"thebrokenscript");
    }
}

