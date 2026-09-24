/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 *  com.mojang.brigadier.exceptions.SimpleCommandExceptionType
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  net.minecraft.commands.CommandBuildContext
 *  net.minecraft.commands.synchronization.ArgumentTypeInfo
 *  net.minecraft.commands.synchronization.ArgumentTypeInfo$Template
 *  net.minecraft.network.FriendlyByteBuf
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.commands.arguments;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.network.FriendlyByteBuf;
import net.thebrokenscript.brokencore.api.commands.ArgumentTypeRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0003\n\u000b\fB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument;", "Lcom/mojang/brigadier/arguments/ArgumentType;", "", "", "list", "<init>", "(Ljava/util/List;)V", "parse", "reader", "Lcom/mojang/brigadier/StringReader;", "Info", "Registrar", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nDoubleListArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoubleListArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1869#2,2:113\n*S KotlinDebug\n*F\n+ 1 DoubleListArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument\n*L\n33#1:113,2\n*E\n"})
public final class DoubleListArgument
implements ArgumentType<List<? extends Double>> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<Double> list;

    public DoubleListArgument(@NotNull List<Double> list) {
        Intrinsics.checkNotNullParameter(list, (String)"list");
        this.list = list;
    }

    @NotNull
    public List<Double> parse(@NotNull StringReader reader) {
        String string;
        Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
        reader.expect('(');
        try {
            string = reader.readStringUntil(')');
        }
        catch (Exception exception) {
            CommandSyntaxException commandSyntaxException = new SimpleCommandExceptionType(DoubleListArgument::parse$lambda$0).create();
            Intrinsics.checkNotNullExpressionValue((Object)commandSyntaxException, (String)"create(...)");
            throw (Throwable)commandSyntaxException;
        }
        String str = string;
        Intrinsics.checkNotNull((Object)str);
        String[] exception = (String[])str;
        Object object = new Regex("[^0-9.-]");
        String string2 = "";
        CharSequence charSequence = object.replace((CharSequence)exception, string2);
        exception = new String[]{","};
        List split = StringsKt.split$default((CharSequence)charSequence, (String[])exception, (boolean)false, (int)0, (int)6, null);
        Ref.ObjectRef lastDoubleStr = new Ref.ObjectRef();
        try {
            object = CollectionsKt.createListBuilder();
            Regex $this$parse_u24lambda_u241 = object;
            boolean bl = false;
            int i = 0;
            i = 1;
            Iterable $this$forEach$iv = split;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String)element$iv;
                boolean bl2 = false;
                lastDoubleStr.element = new Pair((Object)i, (Object)it);
                $this$parse_u24lambda_u241.add(Double.parseDouble(it));
                ++i;
            }
            object = CollectionsKt.build((List)object);
        }
        catch (Exception <unused var>2) {
            CommandSyntaxException commandSyntaxException = new SimpleCommandExceptionType(() -> DoubleListArgument.parse$lambda$2(lastDoubleStr)).create();
            Intrinsics.checkNotNullExpressionValue((Object)commandSyntaxException, (String)"create(...)");
            throw (Throwable)commandSyntaxException;
        }
        return object;
    }

    private static final String parse$lambda$0() {
        return "Missing Ending ')' for double list";
    }

    private static final String parse$lambda$2(Ref.ObjectRef $lastDoubleStr) {
        Object object = $lastDoubleStr.element;
        Intrinsics.checkNotNull((Object)object);
        return "Couldn't parse double at arg: " + ((Pair)object).getFirst() + ", string: " + ((Pair)$lastDoubleStr.element).getSecond();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Companion;", "", "<init>", "()V", "read", "", "", "str", "", "register", "Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Info;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nDoubleListArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoubleListArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1869#2,2:113\n*S KotlinDebug\n*F\n+ 1 DoubleListArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Companion\n*L\n105#1:113,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List<Double> read(@NotNull String str) {
            Intrinsics.checkNotNullParameter((Object)str, (String)"str");
            Object object = (String[])str;
            Regex regex = new Regex("\\(\\)\\s");
            String string = "";
            CharSequence charSequence = regex.replace((CharSequence)object, string);
            object = new String[]{","};
            List split = StringsKt.split$default((CharSequence)charSequence, (String[])object, (boolean)false, (int)0, (int)6, null);
            Object $this$read_u24lambda_u240 = object = CollectionsKt.createListBuilder();
            boolean bl = false;
            Iterable $this$forEach$iv = split;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String)element$iv;
                boolean bl2 = false;
                $this$read_u24lambda_u240.add(Double.parseDouble(it));
            }
            return CollectionsKt.build((List)object);
        }

        @NotNull
        public final Info register() {
            return new Registrar().register();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0018\u00010\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\f\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Info;", "Lnet/minecraft/commands/synchronization/ArgumentTypeInfo;", "Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument;", "Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Info$Template;", "<init>", "()V", "serializeToNetwork", "", "template", "buffer", "Lnet/minecraft/network/FriendlyByteBuf;", "deserializeFromNetwork", "serializeToJson", "json", "Lcom/google/gson/JsonObject;", "unpack", "argument", "Template", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nDoubleListArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoubleListArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Info\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,112:1\n1869#2,2:113\n1869#2,2:117\n13833#3,2:115\n*S KotlinDebug\n*F\n+ 1 DoubleListArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Info\n*L\n49#1:113,2\n77#1:117,2\n65#1:115,2\n*E\n"})
    public static final class Info
    implements ArgumentTypeInfo<DoubleListArgument, Template> {
        /*
         * WARNING - void declaration
         */
        public void serializeToNetwork(@NotNull Template template, @NotNull FriendlyByteBuf buffer) {
            List list;
            Intrinsics.checkNotNullParameter((Object)template, (String)"template");
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
            List list2 = list = CollectionsKt.createListBuilder();
            FriendlyByteBuf friendlyByteBuf = buffer;
            boolean bl = false;
            Iterable $this$forEach$iv = template.getList();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                void $this$serializeToNetwork_u24lambda_u240;
                double it = ((Number)element$iv).doubleValue();
                boolean bl2 = false;
                $this$serializeToNetwork_u24lambda_u240.add(Double.doubleToRawLongBits(it));
            }
            friendlyByteBuf.writeBitSet(BitSet.valueOf(CollectionsKt.toLongArray((Collection)CollectionsKt.build((List)list))));
        }

        /*
         * WARNING - void declaration
         */
        @Nullable
        public Template deserializeFromNetwork(@NotNull FriendlyByteBuf buffer) {
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
            try {
                List list;
                long[] bitSet = buffer.readBitSet().toLongArray();
                List list2 = list = CollectionsKt.createListBuilder();
                Info info = this;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)bitSet);
                long[] $this$forEach$iv = bitSet;
                boolean $i$f$forEach = false;
                int n = $this$forEach$iv.length;
                for (int i = 0; i < n; ++i) {
                    void $this$deserializeFromNetwork_u24lambda_u240;
                    long element$iv;
                    long it = element$iv = $this$forEach$iv[i];
                    boolean bl2 = false;
                    $this$deserializeFromNetwork_u24lambda_u240.add(Double.longBitsToDouble(it));
                }
                List list3 = CollectionsKt.build((List)list);
                Info info2 = info;
                return info2.new Template(list3);
            }
            catch (ClassNotFoundException classNotFoundException) {
                return null;
            }
        }

        public void serializeToJson(@NotNull Template template, @NotNull JsonObject json) {
            Intrinsics.checkNotNullParameter((Object)template, (String)"template");
            Intrinsics.checkNotNullParameter((Object)json, (String)"json");
            Info info = this;
            String string = "values";
            JsonObject jsonObject = json;
            boolean bl = false;
            JsonArray arr = new JsonArray();
            Iterable $this$forEach$iv = template.getList();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                double it = ((Number)element$iv).doubleValue();
                boolean bl2 = false;
                arr.add((Number)it);
            }
            JsonArray jsonArray = arr;
            jsonObject.add(string, (JsonElement)jsonArray);
        }

        @NotNull
        public Template unpack(@NotNull DoubleListArgument argument) {
            Intrinsics.checkNotNullParameter((Object)argument, (String)"argument");
            return new Template(argument.list);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Info$Template;", "Lnet/minecraft/commands/synchronization/ArgumentTypeInfo$Template;", "Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument;", "list", "", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Info;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "instantiate", "cx", "Lnet/minecraft/commands/CommandBuildContext;", "type", "Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Info;", "brokencore-common"})
        public final class Template
        implements ArgumentTypeInfo.Template<DoubleListArgument> {
            @NotNull
            private final List<Double> list;

            public Template(List<Double> list) {
                Intrinsics.checkNotNullParameter(list, (String)"list");
                this.list = list;
            }

            @NotNull
            public final List<Double> getList() {
                return this.list;
            }

            @NotNull
            public DoubleListArgument instantiate(@NotNull CommandBuildContext cx) {
                Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
                return new DoubleListArgument(this.list);
            }

            @NotNull
            public Info type() {
                return Info.this;
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Registrar;", "", "<init>", "()V", "register", "Lnet/thebrokenscript/brokencore/api/commands/arguments/DoubleListArgument$Info;", "brokencore-common"})
    private static final class Registrar {
        @NotNull
        public final Info register() {
            return (Info)ArgumentTypeRegistration.registerByClass(DoubleListArgument.class, (ArgumentTypeInfo)new Info());
        }
    }
}

