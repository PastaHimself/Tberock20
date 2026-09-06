/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  net.minecraft.client.renderer.MultiBufferSource
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.debug;

import com.mojang.blaze3d.vertex.PoseStack;
import kotlin.Metadata;
import net.minecraft.client.renderer.MultiBufferSource;
import net.thebrokenscript.brokencore.api.debug.Debugger;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/debug/Debuggable;", "", "category", "", "getCategory", "()Ljava/lang/String;", "tickDebug", "", "renderDebug", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "debug", "free", "", "brokencore-common"})
public interface Debuggable {
    @NotNull
    public String getCategory();

    public void tickDebug();

    public void renderDebug(@NotNull PoseStack var1, @NotNull MultiBufferSource var2);

    public void debug();

    public boolean free();

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static void debug(@NotNull Debuggable $this) {
            if (Debugger.INSTANCE.getEnabled()) {
                Debugger.INSTANCE.getDebuggersToAdd().offer($this);
                Debugger.INSTANCE.getCategoriesToAdd().offer($this.getCategory());
            }
        }

        public static boolean free(@NotNull Debuggable $this) {
            return Debugger.INSTANCE.getDebuggables().remove($this);
        }
    }
}

