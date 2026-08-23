/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.CharsKt
 *  kotlin.text.StringsKt
 *  net.minecraft.core.component.DataComponentMap
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.network.Filterable
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.component.WrittenBookContent
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.event.StoryEvent
 *  net.thebrokenscript.brokencore.api.util.time.Time
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.story;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.Filterable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.WrittenBookContent;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.event.StoryEvent;
import net.thebrokenscript.brokencore.api.util.time.Time;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/events/story/NullBookStoryEvent;", "Lnet/thebrokenscript/brokencore/api/event/StoryEvent;", "<init>", "()V", "execute", "", "server", "Lnet/minecraft/server/MinecraftServer;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNullBookStoryEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullBookStoryEvent.kt\nnet/thebrokenscript/events/story/NullBookStoryEvent\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n15#2:64\n1869#3,2:65\n*S KotlinDebug\n*F\n+ 1 NullBookStoryEvent.kt\nnet/thebrokenscript/events/story/NullBookStoryEvent\n*L\n42#1:64\n59#1:65,2\n*E\n"})
public final class NullBookStoryEvent
extends StoryEvent {
    public NullBookStoryEvent() {
        Number[] numberArray = new Number[]{Time.INSTANCE.days(12) + 1000};
        super(numberArray);
    }

    protected void execute(@NotNull MinecraftServer server) {
        Object object;
        Object object2;
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        List pages = new ArrayList();
        Filterable filterable = Filterable.passThrough((Object)TBSLang.INSTANCE.getNULL_BOOK_CONTENT());
        Intrinsics.checkNotNullExpressionValue((Object)filterable, (String)"passThrough(...)");
        pages.add(filterable);
        ServerLevel level = server.overworld();
        Intrinsics.checkNotNull((Object)level);
        int coordX = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)level).getClanVoidX(), 16) * 16 + 8;
        int coordZ = Math.floorDiv(LevelExt.INSTANCE.getVars((LevelAccessor)level).getClanVoidZ(), 16) * 16 + 8;
        if (coordX < 0) {
            String string = Integer.toString(-coordX, CharsKt.checkRadix((int)2));
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
            object2 = "-" + string;
        } else {
            String string = Integer.toString(coordX, CharsKt.checkRadix((int)2));
            object2 = string;
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        }
        String xBinary = object2;
        if (coordZ < 0) {
            String string = Integer.toString(-coordZ, CharsKt.checkRadix((int)2));
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
            object = "-" + string;
        } else {
            String string = Integer.toString(coordZ, CharsKt.checkRadix((int)2));
            object = string;
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        }
        String zBinary = object;
        String $this$c$iv = StringsKt.trimMargin$default((String)("X: \n                    |" + xBinary + "\n                    |\n                    |Y: \n                    |201\n                    |\n                    |Z: \n                    |" + zBinary + "\n                    |\n                    |CV"), null, (int)1, null);
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        Filterable filterable2 = Filterable.passThrough((Object)component);
        Intrinsics.checkNotNullExpressionValue((Object)filterable2, (String)"passThrough(...)");
        pages.add(filterable2);
        WrittenBookContent content = new WrittenBookContent(Filterable.passThrough((Object)"null"), "null", 0, pages, true);
        ItemStack item = new ItemStack((ItemLike)Items.WRITTEN_BOOK, 1);
        item.applyComponents(DataComponentMap.builder().set(DataComponents.WRITTEN_BOOK_CONTENT, (Object)content).build());
        List list = server.getPlayerList().getPlayers();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getPlayers(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            player.addItem(item);
        }
    }
}

