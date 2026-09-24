/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.data.CachedOutput
 *  net.minecraft.data.DataProvider
 *  net.minecraft.data.PackOutput
 *  net.minecraft.data.PackOutput$PathProvider
 *  net.minecraft.data.PackOutput$Target
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.biomeSpawns.IBiomeSpawns;
import net.thebrokenscript.brokencore.impl.registry.BCTags;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/BiomeSpawnGenerator;", "Lnet/minecraft/data/DataProvider;", "output", "Lnet/minecraft/data/PackOutput;", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "<init>", "(Lnet/minecraft/data/PackOutput;Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;)V", "pathProvider", "Lnet/minecraft/data/PackOutput$PathProvider;", "kotlin.jvm.PlatformType", "run", "Ljava/util/concurrent/CompletableFuture;", "cache", "Lnet/minecraft/data/CachedOutput;", "getName", "", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nBiomeSpawnGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BiomeSpawnGenerator.kt\nnet/thebrokenscript/brokencore/neoforge/BiomeSpawnGenerator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,51:1\n1869#2,2:52\n37#3,2:54\n*S KotlinDebug\n*F\n+ 1 BiomeSpawnGenerator.kt\nnet/thebrokenscript/brokencore/neoforge/BiomeSpawnGenerator\n*L\n22#1:52,2\n47#1:54,2\n*E\n"})
public final class BiomeSpawnGenerator
implements DataProvider {
    @NotNull
    private final BrokenReg reg;
    private final PackOutput.PathProvider pathProvider;

    public BiomeSpawnGenerator(@NotNull PackOutput output, @NotNull BrokenReg reg) {
        Intrinsics.checkNotNullParameter((Object)output, (String)"output");
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        this.reg = reg;
        this.pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "neoforge/biome_modifier");
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public CompletableFuture<?> run(@NotNull CachedOutput cache) {
        Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
        List futures = new ArrayList();
        Iterable $this$forEach$iv = this.reg.getBiomeSpawns();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            void $this$run_u24lambda_u240_u240_u242_u240;
            void $this$run_u24lambda_u240_u240_u242;
            JsonObject jsonObject;
            JsonObject $this$run_u24lambda_u240_u240_u241;
            JsonObject jsonObject2;
            String string;
            JsonObject jsonObject3;
            Unit unit;
            JsonObject jsonObject4;
            String string2;
            JsonObject jsonObject5;
            JsonObject jsonObject6;
            ResourceLocation loc;
            IBiomeSpawns entry = (IBiomeSpawns)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNullExpressionValue((Object)BuiltInRegistries.ENTITY_TYPE.getKey(entry.entityType()), (String)"getKey(...)");
            Path path = this.pathProvider.json(ResourceLocation.fromNamespaceAndPath((String)loc.getNamespace(), (String)("spawns/" + loc.getPath())));
            JsonObject $this$run_u24lambda_u240_u240 = jsonObject6 = new JsonObject();
            boolean bl2 = false;
            $this$run_u24lambda_u240_u240.addProperty("type", "neoforge:add_spawns");
            JsonObject jsonObject7 = $this$run_u24lambda_u240_u240;
            if (Intrinsics.areEqual(entry.getSpawnBiomeTag(), BCTags.ANY_BIOME)) {
                JsonObject jsonObject8 = jsonObject5 = new JsonObject();
                string2 = "biomes";
                jsonObject4 = jsonObject7;
                boolean bl3 = false;
                $this$run_u24lambda_u240_u240_u240.addProperty("type", "neoforge:any");
                unit = Unit.INSTANCE;
                jsonObject3 = jsonObject4;
                string = string2;
                jsonObject2 = jsonObject5;
            } else {
                $this$run_u24lambda_u240_u240_u240 = jsonObject5 = new JsonObject();
                string2 = "biomes";
                jsonObject4 = jsonObject7;
                boolean bl4 = false;
                $this$run_u24lambda_u240_u240_u241.addProperty("#", entry.getSpawnBiomeTag().location().toString());
                unit = Unit.INSTANCE;
                jsonObject3 = jsonObject4;
                string = string2;
                jsonObject2 = jsonObject5;
            }
            jsonObject3.add(string, (JsonElement)jsonObject2);
            $this$run_u24lambda_u240_u240_u241 = jsonObject5 = new JsonArray();
            string2 = "spawners";
            jsonObject4 = $this$run_u24lambda_u240_u240;
            boolean bl5 = false;
            JsonObject jsonObject9 = jsonObject = new JsonObject();
            void var22_24 = $this$run_u24lambda_u240_u240_u242;
            boolean bl6 = false;
            $this$run_u24lambda_u240_u240_u242_u240.addProperty("type", loc.toString());
            $this$run_u24lambda_u240_u240_u242_u240.addProperty("weight", (Number)entry.getSpawnWeight());
            $this$run_u24lambda_u240_u240_u242_u240.addProperty("minCount", (Number)entry.getSpawnMinCount());
            $this$run_u24lambda_u240_u240_u242_u240.addProperty("maxCount", (Number)entry.getSpawnMaxCount());
            var22_24.add((JsonElement)jsonObject);
            unit = Unit.INSTANCE;
            jsonObject4.add(string2, (JsonElement)jsonObject5);
            JsonObject json = jsonObject6;
            CompletableFuture completableFuture = DataProvider.saveStable((CachedOutput)cache, (JsonElement)((JsonElement)json), (Path)path);
            Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"saveStable(...)");
            futures.add(completableFuture);
        }
        Collection $this$toTypedArray$iv = futures;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        CompletableFuture[] completableFutureArray = thisCollection$iv.toArray(new CompletableFuture[0]);
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(Arrays.copyOf(completableFutureArray, completableFutureArray.length));
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"allOf(...)");
        return completableFuture;
    }

    @NotNull
    public String getName() {
        return "Biome Spawn Generator (" + this.reg.getModId() + ")";
    }
}

