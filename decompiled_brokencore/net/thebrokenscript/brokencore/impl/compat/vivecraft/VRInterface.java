/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.impl.compat.vivecraft;

import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/vivecraft/VRInterface;", "", "isVrEnabled", "", "Companion", "brokencore-common"})
public interface VRInterface {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.impl.compat.vivecraft.VRInterface$Companion.$$INSTANCE;

    public boolean isVrEnabled();

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/vivecraft/VRInterface$Companion;", "", "<init>", "()V", "instance", "Lnet/thebrokenscript/brokencore/impl/compat/vivecraft/VRInterface;", "getInstance", "()Lnet/thebrokenscript/brokencore/impl/compat/vivecraft/VRInterface;", "setInstance", "(Lnet/thebrokenscript/brokencore/impl/compat/vivecraft/VRInterface;)V", "brokencore-common"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @Nullable
        private static VRInterface instance;

        private Companion() {
        }

        @Nullable
        public final VRInterface getInstance() {
            return instance;
        }

        public final void setInstance(@Nullable VRInterface vRInterface) {
            instance = vRInterface;
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

