/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.KeyMapping
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.platform;

import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.KeyMapping;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\b\u0010\u0007\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformKeyBindings;", "", "openCutsceneEditor", "Lkotlin/Lazy;", "Lnet/minecraft/client/KeyMapping;", "getOpenCutsceneEditor", "()Lkotlin/Lazy;", "addLang", "", "Companion", "brokencore-common"})
public interface PlatformKeyBindings {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.platform.PlatformKeyBindings$Companion.$$INSTANCE;

    @NotNull
    public Lazy<KeyMapping> getOpenCutsceneEditor();

    public void addLang();

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformKeyBindings$Companion;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformKeyBindings;", "<init>", "()V", "addLang", "", "openCutsceneEditor", "Lkotlin/Lazy;", "Lnet/minecraft/client/KeyMapping;", "getOpenCutsceneEditor", "()Lkotlin/Lazy;", "brokencore-common"})
    public static final class Companion
    implements PlatformKeyBindings {
        static final /* synthetic */ Companion $$INSTANCE;
        private final /* synthetic */ PlatformKeyBindings $$delegate_0;

        private Companion() {
            ServiceLoader<PlatformKeyBindings> serviceLoader = ServiceLoader.load(PlatformKeyBindings.class);
            Intrinsics.checkNotNullExpressionValue(serviceLoader, (String)"load(...)");
            this.$$delegate_0 = (PlatformKeyBindings)CollectionsKt.first((Iterable)serviceLoader);
        }

        @Override
        @NotNull
        public Lazy<KeyMapping> getOpenCutsceneEditor() {
            return this.$$delegate_0.getOpenCutsceneEditor();
        }

        @Override
        public void addLang() {
            this.$$delegate_0.addLang();
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

