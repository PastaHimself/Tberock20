/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders.interfaces;

import kotlin.Metadata;
import kotlin.Pair;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/Localizer;", "", "localize", "Lkotlin/Pair;", "", "id", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
public interface Localizer {
    @NotNull
    public Pair<String, String> localize(@NotNull ResourceLocation var1);
}

