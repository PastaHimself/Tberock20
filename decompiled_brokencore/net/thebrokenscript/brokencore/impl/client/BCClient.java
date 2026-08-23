/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.client;

import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.platform.PlatformKeyBindings;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.client.OverlayLayer;
import net.thebrokenscript.brokencore.impl.compat.vivecraft.NoopVRInterface;
import net.thebrokenscript.brokencore.impl.compat.vivecraft.RealVRInterface;
import net.thebrokenscript.brokencore.impl.compat.vivecraft.VRInterface;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/impl/client/BCClient;", "", "<init>", "()V", "queue", "Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "getQueue", "()Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "init", "", "tick", "brokencore-common"})
public final class BCClient {
    @NotNull
    public static final BCClient INSTANCE = new BCClient();
    @NotNull
    private static final WorkQueue queue = new WorkQueue(null, 1, null);

    private BCClient() {
    }

    @NotNull
    public final WorkQueue getQueue() {
        return queue;
    }

    public final void init() {
        PlatformKeyBindings.Companion.addLang();
    }

    public final void tick() {
        queue.tick();
        OverlayLayer.INSTANCE.tick();
        if (PlatformUtil.Companion.isModLoaded("vivecraft")) {
            VRInterface.Companion.setInstance(new RealVRInterface());
        } else {
            VRInterface.Companion.setInstance(new NoopVRInterface());
        }
    }
}

