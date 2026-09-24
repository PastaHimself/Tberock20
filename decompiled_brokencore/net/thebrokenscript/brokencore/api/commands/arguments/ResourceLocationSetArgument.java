/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
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
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.commands.CommandBuildContext
 *  net.minecraft.commands.SharedSuggestionProvider
 *  net.minecraft.commands.synchronization.ArgumentTypeInfo
 *  net.minecraft.commands.synchronization.ArgumentTypeInfo$Template
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.commands.arguments;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.commands.ArgumentTypeRegistration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u0015\u00a2\u0006\u0002\b\u00160\u0014H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument;", "Lcom/mojang/brigadier/arguments/ArgumentType;", "Lnet/minecraft/resources/ResourceLocation;", "ids", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "parse", "reader", "Lcom/mojang/brigadier/StringReader;", "listSuggestions", "Ljava/util/concurrent/CompletableFuture;", "Lcom/mojang/brigadier/suggestion/Suggestions;", "S", "context", "Lcom/mojang/brigadier/context/CommandContext;", "builder", "Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;", "getExamples", "", "", "Lkotlin/jvm/internal/EnhancedNullability;", "Info", "Registrar", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nResourceLocationSetArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceLocationSetArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1563#2:96\n1634#2,3:97\n1563#2:100\n1634#2,3:101\n*S KotlinDebug\n*F\n+ 1 ResourceLocationSetArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument\n*L\n36#1:96\n36#1:97,3\n39#1:100\n39#1:101,3\n*E\n"})
public final class ResourceLocationSetArgument
implements ArgumentType<ResourceLocation> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Function0<Collection<ResourceLocation>> ids;
    @NotNull
    private static final Dynamic2CommandExceptionType INVALID_VALUE = new Dynamic2CommandExceptionType(ResourceLocationSetArgument::INVALID_VALUE$lambda$0);

    public ResourceLocationSetArgument(@NotNull Function0<? extends Collection<ResourceLocation>> ids) {
        Intrinsics.checkNotNullParameter(ids, (String)"ids");
        this.ids = ids;
    }

    @NotNull
    public ResourceLocation parse(@NotNull StringReader reader) {
        Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
        ResourceLocation value = ResourceLocation.read((StringReader)reader);
        if (((Collection)this.ids.invoke()).contains(value)) {
            Intrinsics.checkNotNull((Object)value);
            return value;
        }
        CommandSyntaxException commandSyntaxException = INVALID_VALUE.createWithContext((ImmutableStringReader)reader, (Object)value, (Object)CollectionsKt.joinToString$default((Iterable)((Iterable)this.ids.invoke()), (CharSequence)",", null, null, (int)0, null, ResourceLocationSetArgument::parse$lambda$0, (int)30, null));
        Intrinsics.checkNotNullExpressionValue((Object)commandSyntaxException, (String)"createWithContext(...)");
        throw (Throwable)commandSyntaxException;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public <S> CompletableFuture<Suggestions> listSuggestions(@NotNull CommandContext<S> context, @NotNull SuggestionsBuilder builder) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Iterable $this$map$iv = (Iterable)this.ids.invoke();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ResourceLocation resourceLocation = (ResourceLocation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.toString());
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
        Iterable $this$map$iv = (Iterable)this.ids.invoke();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            ResourceLocation resourceLocation = (ResourceLocation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.toString());
        }
        return (List)destination$iv$iv;
    }

    private static final CharSequence parse$lambda$0(ResourceLocation it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String string = it.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    private static final Message INVALID_VALUE$lambda$0(Object found, Object constants) {
        return (Message)Component.literal((String)("ResourceLocation must be one of " + constants + ", found " + found));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Companion;", "", "<init>", "()V", "INVALID_VALUE", "Lcom/mojang/brigadier/exceptions/Dynamic2CommandExceptionType;", "getINVALID_VALUE", "()Lcom/mojang/brigadier/exceptions/Dynamic2CommandExceptionType;", "idSet", "Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument;", "ids", "Lkotlin/Function0;", "", "Lnet/minecraft/resources/ResourceLocation;", "register", "Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Dynamic2CommandExceptionType getINVALID_VALUE() {
            return INVALID_VALUE;
        }

        @NotNull
        public final ResourceLocationSetArgument idSet(@NotNull Function0<? extends Collection<ResourceLocation>> ids) {
            Intrinsics.checkNotNullParameter(ids, (String)"ids");
            return new ResourceLocationSetArgument(ids);
        }

        @NotNull
        public final Info register() {
            return new Registrar().register();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0018\u00010\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\f\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info;", "Lnet/minecraft/commands/synchronization/ArgumentTypeInfo;", "Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument;", "Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info$Template;", "<init>", "()V", "serializeToNetwork", "", "template", "buffer", "Lnet/minecraft/network/FriendlyByteBuf;", "deserializeFromNetwork", "serializeToJson", "json", "Lcom/google/gson/JsonObject;", "unpack", "argument", "Template", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nResourceLocationSetArgument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceLocationSetArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1#2:96\n1869#3,2:97\n*S KotlinDebug\n*F\n+ 1 ResourceLocationSetArgument.kt\nnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info\n*L\n69#1:97,2\n*E\n"})
    public static final class Info
    implements ArgumentTypeInfo<ResourceLocationSetArgument, Template> {
        public void serializeToNetwork(@NotNull Template template, @NotNull FriendlyByteBuf buffer) {
            Intrinsics.checkNotNullParameter((Object)template, (String)"template");
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
            Collection ids = (Collection)template.getIds().invoke();
            buffer.writeInt(ids.size());
            for (ResourceLocation id : ids) {
                buffer.writeUtf(id.toString());
            }
        }

        @Nullable
        public Template deserializeFromNetwork(@NotNull FriendlyByteBuf buffer) {
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
            try {
                int count = buffer.readInt();
                List all = new ArrayList();
                int n = CollectionsKt.count((Iterable)((Iterable)RangesKt.until((int)0, (int)count)));
                int n2 = 0;
                while (n2 < n) {
                    int it = n2++;
                    boolean bl = false;
                    ResourceLocation resourceLocation = ResourceLocation.parse((String)buffer.readUtf());
                    Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"parse(...)");
                    all.add(resourceLocation);
                }
                return new Template((Function0<? extends Collection<ResourceLocation>>)((Function0)() -> Info.deserializeFromNetwork$lambda$1(all)));
            }
            catch (ClassNotFoundException classNotFoundException) {
                return null;
            }
        }

        /*
         * WARNING - void declaration
         */
        public void serializeToJson(@NotNull Template template, @NotNull JsonObject json) {
            JsonArray jsonArray;
            Intrinsics.checkNotNullParameter((Object)template, (String)"template");
            Intrinsics.checkNotNullParameter((Object)json, (String)"json");
            JsonArray jsonArray2 = jsonArray = new JsonArray();
            String string = "ids";
            JsonObject jsonObject = json;
            boolean bl = false;
            Iterable $this$forEach$iv = (Iterable)template.getIds().invoke();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                void $this$serializeToJson_u24lambda_u240;
                ResourceLocation it = (ResourceLocation)element$iv;
                boolean bl2 = false;
                $this$serializeToJson_u24lambda_u240.add(it.toString());
            }
            Unit unit = Unit.INSTANCE;
            jsonObject.add(string, (JsonElement)jsonArray);
        }

        @NotNull
        public Template unpack(@NotNull ResourceLocationSetArgument argument) {
            Intrinsics.checkNotNullParameter((Object)argument, (String)"argument");
            return new Template((Function0<? extends Collection<ResourceLocation>>)argument.ids);
        }

        private static final Collection deserializeFromNetwork$lambda$1(List $all) {
            return $all;
        }

        @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\b\u0000\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info$Template;", "Lnet/minecraft/commands/synchronization/ArgumentTypeInfo$Template;", "Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument;", "ids", "Lkotlin/Function0;", "", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info;Lkotlin/jvm/functions/Function0;)V", "getIds", "()Lkotlin/jvm/functions/Function0;", "instantiate", "cx", "Lnet/minecraft/commands/CommandBuildContext;", "type", "Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info;", "brokencore-common"})
        public final class Template
        implements ArgumentTypeInfo.Template<ResourceLocationSetArgument> {
            @NotNull
            private final Function0<Collection<ResourceLocation>> ids;

            public Template(Function0<? extends Collection<ResourceLocation>> ids) {
                Intrinsics.checkNotNullParameter(ids, (String)"ids");
                this.ids = ids;
            }

            @NotNull
            public final Function0<Collection<ResourceLocation>> getIds() {
                return this.ids;
            }

            @NotNull
            public ResourceLocationSetArgument instantiate(@NotNull CommandBuildContext cx) {
                Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
                return new ResourceLocationSetArgument(this.ids);
            }

            @NotNull
            public Info type() {
                return Info.this;
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Registrar;", "", "<init>", "()V", "register", "Lnet/thebrokenscript/brokencore/api/commands/arguments/ResourceLocationSetArgument$Info;", "brokencore-common"})
    private static final class Registrar {
        @NotNull
        public final Info register() {
            return (Info)ArgumentTypeRegistration.registerByClass(ResourceLocationSetArgument.class, (ArgumentTypeInfo)new Info());
        }
    }
}

