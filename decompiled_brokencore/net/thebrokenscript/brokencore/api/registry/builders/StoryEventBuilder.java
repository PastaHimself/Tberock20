/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.event.StoryEvent;
import net.thebrokenscript.brokencore.api.registry.BCRegistries;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.Localizers;
import net.thebrokenscript.brokencore.api.registry.builders.SimpleLocalizedBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import org.jetbrains.annotations.NotNull;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/StoryEventBuilder;", "T", "Lnet/thebrokenscript/brokencore/api/event/StoryEvent;", "Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleLocalizedBuilder;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "name", "", "ctor", "Lkotlin/Function0;", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "brokencore-common"})
public final class StoryEventBuilder<T extends StoryEvent>
extends SimpleLocalizedBuilder<StoryEventBuilder<T>, StoryEvent, T> {
    public StoryEventBuilder(@NotNull BrokenReg parent, @NotNull String name, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        super(parent, BCRegistries.STORY_EVENTS_KEY, name, ctor, Localizers.EVENT);
    }
}

