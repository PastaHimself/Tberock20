/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.registry.builders.interfaces.Localizer;
import net.thebrokenscript.brokencore.api.util.LangUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/Localizers;", "", "<init>", "()V", "prefixed", "Lnet/thebrokenscript/brokencore/api/registry/builders/interfaces/Localizer;", "prefix", "", "EVENT", "CHAT_RESPONSE", "brokencore-common"})
public final class Localizers {
    @NotNull
    public static final Localizers INSTANCE = new Localizers();
    @JvmField
    @NotNull
    public static final Localizer EVENT = INSTANCE.prefixed("event");
    @JvmField
    @NotNull
    public static final Localizer CHAT_RESPONSE = INSTANCE.prefixed("chat_response");

    private Localizers() {
    }

    @NotNull
    public final Localizer prefixed(@NotNull String prefix) {
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        return arg_0 -> Localizers.prefixed$lambda$0(prefix, arg_0);
    }

    private static final Pair prefixed$lambda$0(String $prefix, ResourceLocation id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        return TuplesKt.to((Object)($prefix + "." + id.getNamespace() + "." + id.getPath()), (Object)LangUtil.INSTANCE.getAutomaticName(id));
    }
}

