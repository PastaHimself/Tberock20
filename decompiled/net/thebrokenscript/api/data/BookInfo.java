/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty1
 *  net.minecraft.core.component.DataComponentMap
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.server.network.Filterable
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.component.WrittenBookContent
 *  net.minecraft.world.level.ItemLike
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.data;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty1;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.network.Filterable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.WrittenBookContent;
import net.minecraft.world.level.ItemLike;
import net.thebrokenscript.api.data.BookInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/api/data/BookInfo;", "", "author", "", "pages", "", "Lnet/minecraft/network/chat/MutableComponent;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getAuthor", "()Ljava/lang/String;", "getPages", "()Ljava/util/List;", "content", "Lnet/minecraft/world/item/component/WrittenBookContent;", "getContent", "()Lnet/minecraft/world/item/component/WrittenBookContent;", "make", "Lnet/minecraft/world/item/ItemStack;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nBookInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookInfo.kt\nnet/thebrokenscript/api/data/BookInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1563#2:46\n1634#2,3:47\n*S KotlinDebug\n*F\n+ 1 BookInfo.kt\nnet/thebrokenscript/api/data/BookInfo\n*L\n23#1:46\n23#1:47,3\n*E\n"})
public final class BookInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String author;
    @NotNull
    private final List<MutableComponent> pages;
    @NotNull
    private static final Endec<MutableComponent> STRING_COMPONENT;
    @NotNull
    private static final StructEndec<BookInfo> ENDEC;

    public BookInfo(@NotNull String author, @NotNull List<? extends MutableComponent> pages) {
        Intrinsics.checkNotNullParameter((Object)author, (String)"author");
        Intrinsics.checkNotNullParameter(pages, (String)"pages");
        this.author = author;
        this.pages = pages;
    }

    @NotNull
    public final String getAuthor() {
        return this.author;
    }

    @NotNull
    public final List<MutableComponent> getPages() {
        return this.pages;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final WrittenBookContent getContent() {
        Collection<Filterable> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Iterable iterable = this.pages;
        int n = 1;
        String string = this.author;
        Filterable filterable = Filterable.passThrough((Object)"Custom Book");
        boolean $i$f$map = false;
        void var3_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            MutableComponent mutableComponent = (MutableComponent)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(Filterable.passThrough((Object)it));
        }
        collection = (List)destination$iv$iv;
        boolean bl = true;
        Collection<Filterable> collection2 = collection;
        int n2 = n;
        String string2 = string;
        Filterable filterable2 = filterable;
        return new WrittenBookContent(filterable2, string2, n2, collection2, bl);
    }

    @NotNull
    public final ItemStack make() {
        ItemStack item = new ItemStack((ItemLike)Items.WRITTEN_BOOK, 1);
        item.applyComponents(DataComponentMap.builder().set(DataComponents.WRITTEN_BOOK_CONTENT, (Object)this.getContent()).build());
        return item;
    }

    private static final MutableComponent STRING_COMPONENT$lambda$0(String it) {
        return Component.literal((String)it);
    }

    private static final String STRING_COMPONENT$lambda$1(MutableComponent it) {
        return it.getString();
    }

    private static final String ENDEC$lambda$0(KProperty1 $tmp0, BookInfo p0) {
        return (String)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final List ENDEC$lambda$1(KProperty1 $tmp0, BookInfo p0) {
        return (List)((Function1)$tmp0).invoke((Object)p0);
    }

    static {
        Endec endec2 = Endec.STRING.xmap(BookInfo::STRING_COMPONENT$lambda$0, BookInfo::STRING_COMPONENT$lambda$1);
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"xmap(...)");
        STRING_COMPONENT = endec2;
        StructEndec structEndec = StructEndecBuilder.of((StructField)Endec.STRING.fieldOf("author", arg_0 -> BookInfo.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)STRING_COMPONENT.listOf().fieldOf("pages", arg_0 -> BookInfo.ENDEC$lambda$1((KProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), BookInfo::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/api/data/BookInfo$Companion;", "", "<init>", "()V", "STRING_COMPONENT", "Lio/wispforest/endec/Endec;", "Lnet/minecraft/network/chat/MutableComponent;", "getSTRING_COMPONENT", "()Lio/wispforest/endec/Endec;", "ENDEC", "Lio/wispforest/endec/StructEndec;", "Lnet/thebrokenscript/api/data/BookInfo;", "getENDEC", "()Lio/wispforest/endec/StructEndec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<MutableComponent> getSTRING_COMPONENT() {
            return STRING_COMPONENT;
        }

        @NotNull
        public final StructEndec<BookInfo> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

