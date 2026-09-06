/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.responses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.ext.MinecraftServerExtKt;
import net.thebrokenscript.brokencore.api.ext.StringExtKt;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0019J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0016\u0010!\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\"\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0$H\u0004R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/brokencore/api/responses/ChatResponse;", "", "<init>", "()V", "level", "Lnet/minecraft/server/level/ServerLevel;", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "lastResponseTime", "", "getLastResponseTime", "()J", "setLastResponseTime", "(J)V", "delay", "getDelay", "caseSensitive", "", "getCaseSensitive", "()Z", "isFullMessage", "ignorePunctuation", "getIgnorePunctuation", "triggers", "", "", "getTriggers", "()Ljava/util/List;", "check", "message", "respond", "", "shouldExecute", "execute", "afterTicks", "action", "Lkotlin/Function0;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nChatResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChatResponse.kt\nnet/thebrokenscript/brokencore/api/responses/ChatResponse\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1563#2:149\n1634#2,3:150\n1563#2:153\n1634#2,3:154\n1761#2,3:157\n1563#2:160\n1634#2,3:161\n1761#2,3:164\n*S KotlinDebug\n*F\n+ 1 ChatResponse.kt\nnet/thebrokenscript/brokencore/api/responses/ChatResponse\n*L\n78#1:149\n78#1:150,3\n81#1:153\n81#1:154,3\n83#1:157,3\n84#1:160\n84#1:161,3\n85#1:164,3\n*E\n"})
public abstract class ChatResponse {
    private ServerLevel level;
    private ServerPlayer sender;
    private long lastResponseTime;

    protected final long getLastResponseTime() {
        return this.lastResponseTime;
    }

    protected final void setLastResponseTime(long l) {
        this.lastResponseTime = l;
    }

    public long getDelay() {
        return 0L;
    }

    public boolean getCaseSensitive() {
        return false;
    }

    public boolean isFullMessage() {
        return false;
    }

    public boolean getIgnorePunctuation() {
        return true;
    }

    @NotNull
    public abstract List<String> getTriggers();

    public final boolean check(@NotNull String message) {
        boolean bl;
        block17: {
            List triggers;
            String p0;
            Collection collection;
            Object item$iv$iv;
            Iterator iterator;
            Object $this$mapTo$iv$iv;
            boolean $i$f$mapTo;
            Collection destination$iv$iv;
            boolean $i$f$map;
            Iterable $this$map$iv;
            String msg;
            Intrinsics.checkNotNullParameter((Object)message, (String)"message");
            String string = msg = this.getIgnorePunctuation() ? StringExtKt.getClean(message) : message;
            if (this.getIgnorePunctuation()) {
                $this$map$iv = this.getTriggers();
                $i$f$map = false;
                Iterable iterable = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                iterator = $this$mapTo$iv$iv.iterator();
                while (iterator.hasNext()) {
                    item$iv$iv = iterator.next();
                    String string2 = (String)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl2 = false;
                    collection.add(StringExtKt.getClean(p0));
                }
                v1 = (List)destination$iv$iv;
            } else {
                v1 = triggers = this.getTriggers();
            }
            if (this.isFullMessage()) {
                if (this.getCaseSensitive()) {
                    bl = triggers.contains(msg);
                } else {
                    $this$map$iv = triggers;
                    $i$f$map = false;
                    $this$mapTo$iv$iv = $this$map$iv;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    $i$f$mapTo = false;
                    iterator = $this$mapTo$iv$iv.iterator();
                    while (iterator.hasNext()) {
                        item$iv$iv = iterator.next();
                        p0 = (String)item$iv$iv;
                        collection = destination$iv$iv;
                        boolean bl3 = false;
                        String string3 = it.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
                        collection.add(string3);
                    }
                    List list = (List)destination$iv$iv;
                    String string4 = msg.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"toLowerCase(...)");
                    bl = list.contains(string4);
                }
            } else if (this.getCaseSensitive()) {
                $this$any$iv = triggers;
                $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        String it = (String)element$iv;
                        boolean bl4 = false;
                        if (!StringsKt.contains$default((CharSequence)msg, (CharSequence)it, (boolean)false, (int)2, null)) continue;
                        bl = true;
                        break block17;
                    }
                    bl = false;
                }
            } else {
                $this$any$iv = triggers;
                $i$f$map = false;
                $this$mapTo$iv$iv = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                Iterator bl4 = $this$mapTo$iv$iv.iterator();
                while (bl4.hasNext()) {
                    item$iv$iv = bl4.next();
                    it = (String)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl5 = false;
                    String string5 = it.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"toLowerCase(...)");
                    collection.add(string5);
                }
                $this$map$iv = (List)destination$iv$iv;
                $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        String it = (String)element$iv;
                        boolean bl6 = false;
                        String string6 = msg.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue((Object)string6, (String)"toLowerCase(...)");
                        if (!StringsKt.contains$default((CharSequence)string6, (CharSequence)it, (boolean)false, (int)2, null)) continue;
                        bl = true;
                        break block17;
                    }
                    bl = false;
                }
            }
        }
        return bl;
    }

    protected long getDelay(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        return this.getDelay();
    }

    protected void respond(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        this.lastResponseTime = level.getGameTime();
    }

    protected boolean shouldExecute(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        return true;
    }

    public final void execute(@NotNull ServerLevel level, @NotNull ServerPlayer sender) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        MinecraftServer minecraftServer = level.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        MinecraftServerExtKt.getQueue(minecraftServer).add(BCConfigs.INSTANCE.getServer().getChat().getForceFastResponses() ? 1L : this.getDelay(level, sender), (Function0<Unit>)((Function0)() -> ChatResponse.execute$lambda$0(this, level, sender)));
    }

    protected final void afterTicks(long afterTicks, @NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, (String)"action");
        ServerLevel serverLevel = this.level;
        if (serverLevel == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"level");
            serverLevel = null;
        }
        MinecraftServer minecraftServer = serverLevel.getServer();
        Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
        MinecraftServerExtKt.getQueue(minecraftServer).add(afterTicks, (Function0<Unit>)((Function0)() -> ChatResponse.afterTicks$lambda$0(action)));
    }

    private static final Unit execute$lambda$0(ChatResponse this$0, ServerLevel $level, ServerPlayer $sender) {
        this$0.level = $level;
        this$0.sender = $sender;
        if (this$0.shouldExecute($level, $sender)) {
            this$0.respond($level, $sender);
        }
        return Unit.INSTANCE;
    }

    private static final Unit afterTicks$lambda$0(Function0 $action) {
        $action.invoke();
        return Unit.INSTANCE;
    }
}

