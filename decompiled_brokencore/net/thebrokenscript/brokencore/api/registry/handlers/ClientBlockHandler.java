/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.color.block.BlockColor
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.handlers;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.color.block.BlockColor;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR*\u0010\u0004\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockHandler;", "", "<init>", "()V", "colorHandlers", "", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "Lkotlin/Function0;", "Lnet/minecraft/client/color/block/BlockColor;", "getColorHandlers$brokencore_common", "()Ljava/util/Map;", "apply", "", "cons", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockHandler$Consumer;", "pushColorHandlers", "Consumer", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nClientBlockHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientBlockHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockHandler\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,38:1\n216#2,2:39\n216#2,2:41\n*S KotlinDebug\n*F\n+ 1 ClientBlockHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockHandler\n*L\n21#1:39,2\n28#1:41,2\n*E\n"})
public final class ClientBlockHandler {
    @NotNull
    public static final ClientBlockHandler INSTANCE = new ClientBlockHandler();
    @NotNull
    private static final Map<BlockEntry<?>, Function0<BlockColor>> colorHandlers = new LinkedHashMap();

    private ClientBlockHandler() {
    }

    @NotNull
    public final Map<BlockEntry<?>, Function0<BlockColor>> getColorHandlers$brokencore_common() {
        return colorHandlers;
    }

    public final void apply(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        Map<BlockEntry<?>, Function0<BlockColor>> $this$forEach$iv = colorHandlers;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<BlockEntry<?>, Function0<BlockColor>>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<BlockEntry<?>, Function0<BlockColor>> element$iv;
            Map.Entry<BlockEntry<?>, Function0<BlockColor>> entry = element$iv = iterator.next();
            boolean bl = false;
            BlockEntry<?> entry2 = entry.getKey();
            Function0<BlockColor> handler = entry.getValue();
            cons.color(entry2, handler);
        }
    }

    public final void pushColorHandlers(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        Map<BlockEntry<?>, Function0<BlockColor>> $this$forEach$iv = colorHandlers;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<BlockEntry<?>, Function0<BlockColor>>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<BlockEntry<?>, Function0<BlockColor>> element$iv;
            Map.Entry<BlockEntry<?>, Function0<BlockColor>> entry = element$iv = iterator.next();
            boolean bl = false;
            BlockEntry<?> entry2 = entry.getKey();
            Function0<BlockColor> handler = entry.getValue();
            cons.color(entry2, handler);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ClientBlockHandler$Consumer;", "", "color", "", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "handler", "Lkotlin/Function0;", "Lnet/minecraft/client/color/block/BlockColor;", "brokencore-common"})
    public static interface Consumer {
        public void color(@NotNull BlockEntry<?> var1, @NotNull Function0<? extends BlockColor> var2);
    }
}

