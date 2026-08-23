/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.LevelAccessor
 *  net.thebrokenscript.brokencore.api.event.StoryEvent
 *  net.thebrokenscript.brokencore.api.util.time.Time
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.story;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.event.StoryEvent;
import net.thebrokenscript.brokencore.api.util.time.Time;
import net.thebrokenscript.data.MapVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0014\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/events/story/MoonCorruptionStoryEvent;", "Lnet/thebrokenscript/brokencore/api/event/StoryEvent;", "<init>", "()V", "canExecute", "", "server", "Lnet/minecraft/server/MinecraftServer;", "execute", "", "thebrokenscript-common"})
public final class MoonCorruptionStoryEvent
extends StoryEvent {
    public MoonCorruptionStoryEvent() {
        Number[] numberArray = new Number[]{Time.INSTANCE.days(24) + 1000, Time.INSTANCE.days(32) + 1000, Time.INSTANCE.days(38) + 1000, Time.INSTANCE.days(48) + 1000};
        super(numberArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean canExecute(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        if (!super.canExecute(server)) return false;
        ServerLevel serverLevel = server.overworld();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"overworld(...)");
        if (LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel).getHasMoonCorrupted()) return false;
        return true;
    }

    protected void execute(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        ServerLevel serverLevel = server.overworld();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"overworld(...)");
        LevelExt.INSTANCE.updateVars((LevelAccessor)serverLevel, (Function1<? super MapVariables, Unit>)((Function1)MoonCorruptionStoryEvent::execute$lambda$0));
    }

    private static final Unit execute$lambda$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        int n = $this$updateVars.getMoonStage();
        $this$updateVars.setMoonStage(n + 1);
        $this$updateVars.setMoonShouldChange(false);
        return Unit.INSTANCE;
    }
}

