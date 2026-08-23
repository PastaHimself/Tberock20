/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.mojang.brigadier.ImmutableStringReader
 *  com.mojang.brigadier.Message
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 *  com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType
 *  com.mojang.brigadier.suggestion.Suggestions
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.commands.CommandBuildContext
 *  net.minecraft.commands.SharedSuggestionProvider
 *  net.minecraft.commands.synchronization.ArgumentTypeInfo
 *  net.minecraft.commands.synchronization.ArgumentTypeInfo$Template
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.chat.Component
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.commands.arguments;

import com.google.gson.JsonObject;
import com.mojang.brigadier.ImmutableStringReader;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.thebrokenscript.brokencore.api.commands.ArgumentTypeRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u0019*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0003\u0017\u0018\u0019B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0004\b\u0001\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument;", "T", "", "Lcom/mojang/brigadier/arguments/ArgumentType;", "enumClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "parse", "reader", "Lcom/mojang/brigadier/StringReader;", "(Lcom/mojang/brigadier/StringReader;)Ljava/lang/Enum;", "listSuggestions", "Ljava/util/concurrent/CompletableFuture;", "Lcom/mojang/brigadier/suggestion/Suggestions;", "S", "context", "Lcom/mojang/brigadier/context/CommandContext;", "builder", "Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;", "getExamples", "", "", "Info", "Registrar", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEnumArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnumArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,82:1\n11561#2:83\n11896#2,3:84\n11561#2:89\n11896#2,3:90\n11561#2:93\n11896#2,3:94\n37#3,2:87\n*S KotlinDebug\n*F\n+ 1 EnumArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument\n*L\n26#1:83\n26#1:84,3\n34#1:89\n34#1:90,3\n37#1:93\n37#1:94,3\n26#1:87,2\n*E\n"})
public final class EnumArgument<T extends Enum<T>>
implements ArgumentType<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Class<T> enumClass;
    @NotNull
    private static final Dynamic2CommandExceptionType INVALID_ENUM = new Dynamic2CommandExceptionType(EnumArgument::INVALID_ENUM$lambda$0);

    public EnumArgument(@NotNull Class<T> enumClass) {
        Intrinsics.checkNotNullParameter(enumClass, (String)"enumClass");
        this.enumClass = enumClass;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public T parse(@NotNull StringReader reader) {
        Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
        String name = reader.readUnquotedString();
        try {
            T t = Enum.valueOf(this.enumClass, name);
            Intrinsics.checkNotNull(t, (String)"null cannot be cast to non-null type T of net.thebrokenscript.brokencore.api.commands.arguments.EnumArgument");
            return t;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            void $this$toTypedArray$iv;
            Collection<String> collection;
            void $this$mapTo$iv$iv;
            Collection $this$map$iv;
            ImmutableStringReader immutableStringReader = (ImmutableStringReader)reader;
            T[] TArray = this.enumClass.getEnumConstants();
            Intrinsics.checkNotNullExpressionValue(TArray, (String)"getEnumConstants(...)");
            T[] TArray2 = TArray;
            String string = name;
            ImmutableStringReader immutableStringReader2 = immutableStringReader;
            Dynamic2CommandExceptionType dynamic2CommandExceptionType = INVALID_ENUM;
            boolean $i$f$map = false;
            void var7_9 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(((void)$this$map$iv).length);
            boolean $i$f$mapTo = false;
            for (void item$iv$iv : $this$mapTo$iv$iv) {
                void p0;
                Enum enum_ = (Enum)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl = false;
                collection.add(p0.name());
            }
            collection = (List)destination$iv$iv;
            $this$map$iv = collection;
            boolean $i$f$toTypedArray = false;
            void thisCollection$iv = $this$toTypedArray$iv;
            CommandSyntaxException commandSyntaxException = dynamic2CommandExceptionType.createWithContext(immutableStringReader2, (Object)string, (Object)thisCollection$iv.toArray(new String[0]));
            Intrinsics.checkNotNullExpressionValue((Object)commandSyntaxException, (String)"createWithContext(...)");
            throw (Throwable)commandSyntaxException;
        }
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public <S> CompletableFuture<Suggestions> listSuggestions(@NotNull CommandContext<S> context, @NotNull SuggestionsBuilder builder) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        T[] TArray = this.enumClass.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(TArray, (String)"getEnumConstants(...)");
        T[] $this$map$iv = TArray;
        boolean $i$f$map = false;
        T[] TArray2 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        for (void item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            Enum enum_ = (Enum)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(p0.name());
        }
        CompletableFuture completableFuture = SharedSuggestionProvider.suggest((Iterable)((List)destination$iv$iv), (SuggestionsBuilder)builder);
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"suggest(...)");
        return completableFuture;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<String> getExamples() {
        void $this$mapTo$iv$iv;
        T[] TArray = this.enumClass.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(TArray, (String)"getEnumConstants(...)");
        T[] $this$map$iv = TArray;
        boolean $i$f$map = false;
        T[] TArray2 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        for (void item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            Enum enum_ = (Enum)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(p0.name());
        }
        return CollectionsKt.toMutableList((Collection)((List)destination$iv$iv));
    }

    private static final Message INVALID_ENUM$lambda$0(Object found, Object constants) {
        return (Message)Component.literal((String)("Enum constant must be one of " + constants + ", found " + found));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u000e\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Companion;", "", "<init>", "()V", "INVALID_ENUM", "Lcom/mojang/brigadier/exceptions/Dynamic2CommandExceptionType;", "getINVALID_ENUM", "()Lcom/mojang/brigadier/exceptions/Dynamic2CommandExceptionType;", "enumArgument", "Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument;", "R", "", "enumClass", "Ljava/lang/Class;", "register", "Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Info;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Dynamic2CommandExceptionType getINVALID_ENUM() {
            return INVALID_ENUM;
        }

        @NotNull
        public final <R extends Enum<R>> EnumArgument<R> enumArgument(@NotNull Class<R> enumClass) {
            Intrinsics.checkNotNullParameter(enumClass, (String)"enumClass");
            return new EnumArgument<R>(enumClass);
        }

        @NotNull
        public final Info<? extends Enum<?>> register() {
            return new Registrar().register();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u000e\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u000e\u0012\f0\u0005R\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0003:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f0\u0005R\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u000e\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u000e\u001a\u00020\t2\u0010\u0010\n\u001a\f0\u0005R\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\f0\u0005R\b\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0016\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Info;", "T", "", "Lnet/minecraft/commands/synchronization/ArgumentTypeInfo;", "Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument;", "Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Info$Template;", "<init>", "()V", "serializeToNetwork", "", "template", "buffer", "Lnet/minecraft/network/FriendlyByteBuf;", "deserializeFromNetwork", "serializeToJson", "json", "Lcom/google/gson/JsonObject;", "unpack", "argument", "Template", "brokencore-common"})
    public static final class Info<T extends Enum<T>>
    implements ArgumentTypeInfo<EnumArgument<T>, Template> {
        public void serializeToNetwork(@NotNull Template template, @NotNull FriendlyByteBuf buffer) {
            Intrinsics.checkNotNullParameter((Object)template, (String)"template");
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
            buffer.writeUtf(template.getEnumClass().getName());
        }

        @Nullable
        public Template deserializeFromNetwork(@NotNull FriendlyByteBuf buffer) {
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
            try {
                String name = buffer.readUtf();
                Class<?> clazz = Class.forName(name);
                Intrinsics.checkNotNull(clazz, (String)"null cannot be cast to non-null type java.lang.Class<T of net.thebrokenscript.brokencore.api.commands.arguments.EnumArgument.Info>");
                return new Template(clazz);
            }
            catch (ClassNotFoundException classNotFoundException) {
                return null;
            }
        }

        public void serializeToJson(@NotNull Template template, @NotNull JsonObject json) {
            Intrinsics.checkNotNullParameter((Object)template, (String)"template");
            Intrinsics.checkNotNullParameter((Object)json, (String)"json");
            json.addProperty("enum", template.getEnumClass().getName());
        }

        @NotNull
        public Template unpack(@NotNull EnumArgument<T> argument) {
            Intrinsics.checkNotNullParameter(argument, (String)"argument");
            return new Template(((EnumArgument)argument).enumClass);
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0001B\u0017\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Info$Template;", "Lnet/minecraft/commands/synchronization/ArgumentTypeInfo$Template;", "Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument;", "enumClass", "Ljava/lang/Class;", "<init>", "(Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Info;Ljava/lang/Class;)V", "getEnumClass", "()Ljava/lang/Class;", "instantiate", "cx", "Lnet/minecraft/commands/CommandBuildContext;", "type", "Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Info;", "brokencore-common"})
        public final class Template
        implements ArgumentTypeInfo.Template<EnumArgument<T>> {
            @NotNull
            private final Class<T> enumClass;

            public Template(Class<T> enumClass) {
                Intrinsics.checkNotNullParameter(enumClass, (String)"enumClass");
                this.enumClass = enumClass;
            }

            @NotNull
            public final Class<T> getEnumClass() {
                return this.enumClass;
            }

            @NotNull
            public EnumArgument<T> instantiate(@NotNull CommandBuildContext cx) {
                Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
                return new EnumArgument(this.enumClass);
            }

            @NotNull
            public Info<T> type() {
                return Info.this;
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u000e\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Registrar;", "T", "", "", "<init>", "()V", "register", "Lnet/thebrokenscript/brokencore/api/commands/arguments/EnumArgument$Info;", "brokencore-common"})
    private static final class Registrar<T extends Enum<T>> {
        @NotNull
        public final Info<T> register() {
            return (Info)ArgumentTypeRegistration.registerByClass(EnumArgument.class, (ArgumentTypeInfo)new Info());
        }
    }
}

