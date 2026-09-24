/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.color.item.ItemColor
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
import net.minecraft.client.color.item.ItemColor;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR*\u0010\u0004\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ItemHandler;", "", "<init>", "()V", "colorHandlers", "", "Lnet/thebrokenscript/brokencore/api/registry/objects/ItemEntry;", "Lkotlin/Function0;", "Lnet/minecraft/client/color/item/ItemColor;", "getColorHandlers$brokencore_common", "()Ljava/util/Map;", "apply", "", "cons", "Lnet/thebrokenscript/brokencore/api/registry/handlers/ItemHandler$Consumer;", "Consumer", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nItemHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ItemHandler\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,33:1\n216#2,2:34\n*S KotlinDebug\n*F\n+ 1 ItemHandler.kt\nnet/thebrokenscript/brokencore/api/registry/handlers/ItemHandler\n*L\n20#1:34,2\n*E\n"})
public final class ItemHandler {
    @NotNull
    public static final ItemHandler INSTANCE = new ItemHandler();
    @NotNull
    private static final Map<ItemEntry<?>, Function0<ItemColor>> colorHandlers = new LinkedHashMap();

    private ItemHandler() {
    }

    @NotNull
    public final Map<ItemEntry<?>, Function0<ItemColor>> getColorHandlers$brokencore_common() {
        return colorHandlers;
    }

    public final void apply(@NotNull Consumer cons) {
        Intrinsics.checkNotNullParameter((Object)cons, (String)"cons");
        Map<ItemEntry<?>, Function0<ItemColor>> $this$forEach$iv = colorHandlers;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<ItemEntry<?>, Function0<ItemColor>>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<ItemEntry<?>, Function0<ItemColor>> element$iv;
            Map.Entry<ItemEntry<?>, Function0<ItemColor>> entry = element$iv = iterator.next();
            boolean bl = false;
            ItemEntry<?> entry2 = entry.getKey();
            Function0<ItemColor> handler = entry.getValue();
            cons.color(entry2, handler);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/handlers/ItemHandler$Consumer;", "", "color", "", "entry", "Lnet/thebrokenscript/brokencore/api/registry/objects/ItemEntry;", "handler", "Lkotlin/Function0;", "Lnet/minecraft/client/color/item/ItemColor;", "brokencore-common"})
    public static interface Consumer {
        public void color(@NotNull ItemEntry<?> var1, @NotNull Function0<? extends ItemColor> var2);
    }
}

