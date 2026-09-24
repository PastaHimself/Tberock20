/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.integrity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/boss/integrity/SubtitleEntry;", "", "id", "", "time", "", "endTime", "text", "", "<init>", "(IFFLjava/lang/String;)V", "getId", "()I", "getTime", "()F", "getEndTime", "getText", "()Ljava/lang/String;", "key", "getKey", "ticks", "getTicks", "endTicks", "getEndTicks", "component", "Lnet/minecraft/network/chat/MutableComponent;", "getComponent", "()Lnet/minecraft/network/chat/MutableComponent;", "thebrokenscript-common"})
public final class SubtitleEntry {
    private final int id;
    private final float time;
    private final float endTime;
    @NotNull
    private final String text;
    @NotNull
    private final String key;
    private final float ticks;
    private final float endTicks;
    @NotNull
    private final MutableComponent component;

    public SubtitleEntry(int id, float time, float endTime, @NotNull String text) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        this.id = id;
        this.time = time;
        this.endTime = endTime;
        this.text = text;
        this.key = "subtitles.thebrokenscript.integrity_speech." + this.id;
        this.ticks = this.time * (float)20;
        this.endTicks = this.endTime * (float)20;
        MutableComponent mutableComponent = Component.translatable((String)this.key);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
        this.component = mutableComponent;
    }

    public final int getId() {
        return this.id;
    }

    public final float getTime() {
        return this.time;
    }

    public final float getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final float getTicks() {
        return this.ticks;
    }

    public final float getEndTicks() {
        return this.endTicks;
    }

    @NotNull
    public final MutableComponent getComponent() {
        return this.component;
    }
}

