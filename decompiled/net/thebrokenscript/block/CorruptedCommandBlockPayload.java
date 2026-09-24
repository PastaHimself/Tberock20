/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  net.minecraft.core.BlockPos
 *  net.thebrokenscript.brokencore.api.util.serde.KClassEndec
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import net.minecraft.core.BlockPos;
import net.thebrokenscript.brokencore.api.util.serde.KClassEndec;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/block/CorruptedCommandBlockPayload;", "", "command", "", "position", "Lnet/minecraft/core/BlockPos;", "<init>", "(Ljava/lang/String;Lnet/minecraft/core/BlockPos;)V", "getCommand", "()Ljava/lang/String;", "getPosition", "()Lnet/minecraft/core/BlockPos;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCorruptedCommandBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CorruptedCommandBlock.kt\nnet/thebrokenscript/block/CorruptedCommandBlockPayload\n+ 2 KClassEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/KClassEndecKt\n*L\n1#1,170:1\n14#2:171\n*S KotlinDebug\n*F\n+ 1 CorruptedCommandBlock.kt\nnet/thebrokenscript/block/CorruptedCommandBlockPayload\n*L\n159#1:171\n*E\n"})
public final class CorruptedCommandBlockPayload {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String command;
    @NotNull
    private final BlockPos position;
    @NotNull
    private static final KClassEndec<CorruptedCommandBlockPayload> ENDEC;

    public CorruptedCommandBlockPayload(@NotNull String command, @NotNull BlockPos position) {
        Intrinsics.checkNotNullParameter((Object)command, (String)"command");
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        this.command = command;
        this.position = position;
    }

    public /* synthetic */ CorruptedCommandBlockPayload(String string, BlockPos blockPos, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = "";
        }
        if ((n & 2) != 0) {
            blockPos = new BlockPos(0, 0, 0);
        }
        this(string, blockPos);
    }

    @NotNull
    public final String getCommand() {
        return this.command;
    }

    @NotNull
    public final BlockPos getPosition() {
        return this.position;
    }

    public CorruptedCommandBlockPayload() {
        this(null, null, 3, null);
    }

    static {
        KClass $this$endec$iv = Reflection.getOrCreateKotlinClass(CorruptedCommandBlockPayload.class);
        boolean $i$f$getEndec = false;
        ENDEC = new KClassEndec($this$endec$iv);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/block/CorruptedCommandBlockPayload$Companion;", "", "<init>", "()V", "ENDEC", "Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec;", "Lnet/thebrokenscript/block/CorruptedCommandBlockPayload;", "getENDEC", "()Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KClassEndec<CorruptedCommandBlockPayload> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

