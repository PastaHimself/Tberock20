/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableMap$Builder
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.Resource
 *  net.minecraft.server.packs.resources.ResourceManager
 *  net.minecraft.server.packs.resources.ResourceManagerReloadListener
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.impl.resources;

import com.google.common.collect.ImmutableMap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.thebrokenscript.brokencore.api.xcsf.XcsfLoader;
import net.thebrokenscript.brokencore.api.xcsf.XcsfStructure;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002R6\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/impl/resources/ReloadListener;", "Lnet/minecraft/server/packs/resources/ResourceManagerReloadListener;", "<init>", "()V", "value", "Lcom/google/common/collect/ImmutableMap;", "Lnet/minecraft/resources/ResourceLocation;", "Lnet/thebrokenscript/brokencore/api/xcsf/XcsfStructure;", "xcsfStructures", "getXcsfStructures", "()Lcom/google/common/collect/ImmutableMap;", "onResourceManagerReload", "", "resourceManager", "Lnet/minecraft/server/packs/resources/ResourceManager;", "getStructure", "id", "reloadXcsf", "manager", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nReloadListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReloadListener.kt\nnet/thebrokenscript/brokencore/impl/resources/ReloadListener\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,65:1\n126#2:66\n153#2,3:67\n*S KotlinDebug\n*F\n+ 1 ReloadListener.kt\nnet/thebrokenscript/brokencore/impl/resources/ReloadListener\n*L\n28#1:66\n28#1:67,3\n*E\n"})
public final class ReloadListener
implements ResourceManagerReloadListener {
    @NotNull
    public static final ReloadListener INSTANCE = new ReloadListener();
    @NotNull
    private static ImmutableMap<ResourceLocation, XcsfStructure> xcsfStructures;

    private ReloadListener() {
    }

    @NotNull
    public final ImmutableMap<ResourceLocation, XcsfStructure> getXcsfStructures() {
        return xcsfStructures;
    }

    public void onResourceManagerReload(@NotNull ResourceManager resourceManager) {
        Intrinsics.checkNotNullParameter((Object)resourceManager, (String)"resourceManager");
        this.reloadXcsf(resourceManager);
    }

    @Nullable
    public final XcsfStructure getStructure(@NotNull ResourceLocation id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        return (XcsfStructure)xcsfStructures.get((Object)id);
    }

    /*
     * WARNING - void declaration
     */
    private final void reloadXcsf(ResourceManager manager) {
        void $this$mapTo$iv$iv;
        Map map = manager.listResources("xcsf_structure", ReloadListener::reloadXcsf$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)map, (String)"listResources(...)");
        Map $this$map$iv = map;
        boolean $i$f$map = false;
        Map map22 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        boolean $i$f$mapTo = false;
        Iterator iterator = $this$mapTo$iv$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            void it;
            Map.Entry item$iv$iv;
            Map.Entry entry = item$iv$iv = iterator.next();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            ResourceLocation resourceLocation = (ResourceLocation)it.getKey();
            String string = ((ResourceLocation)it.getKey()).getPath();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
            collection.add(new Pair((Object)resourceLocation.withPath(StringsKt.removePrefix((String)StringsKt.replace$default((String)string, (String)".xcsf", (String)"", (boolean)false, (int)4, null), (CharSequence)"xcsf_structure/")), it.getValue()));
        }
        List found = (List)destination$iv$iv;
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (Map map22 : found) {
            XcsfStructure xcsfStructure;
            ResourceLocation id = (ResourceLocation)map22.component1();
            Resource res = (Resource)map22.component2();
            InputStream stream = res.open();
            byte[] raw = stream.readAllBytes();
            try {
                ByteBuf byteBuf = Unpooled.wrappedBuffer((byte[])raw);
                Intrinsics.checkNotNullExpressionValue((Object)byteBuf, (String)"wrappedBuffer(...)");
                xcsfStructure = XcsfLoader.decode(byteBuf);
            }
            catch (Exception exception) {
                xcsfStructure = null;
            }
            XcsfStructure data2 = xcsfStructure;
            if (data2 == null) {
                BrokenCore.LOGGER.error("Failed to decode XCSF Structure " + id + "!");
                stream.close();
                continue;
            }
            BrokenCore.LOGGER.info("Registering XCSF Structure " + id + "...");
            builder.put((Object)id, (Object)data2);
            stream.close();
        }
        ImmutableMap immutableMap = builder.build();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"build(...)");
        xcsfStructures = immutableMap;
    }

    private static final boolean reloadXcsf$lambda$0(ResourceLocation it) {
        String string = it.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        return StringsKt.endsWith$default((String)string, (String)".xcsf", (boolean)false, (int)2, null);
    }

    static {
        ImmutableMap immutableMap = ImmutableMap.of();
        Intrinsics.checkNotNullExpressionValue((Object)immutableMap, (String)"of(...)");
        xcsfStructures = immutableMap;
    }
}

