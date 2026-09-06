/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.InputConstants$Type
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  net.minecraft.client.KeyMapping
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import com.mojang.blaze3d.platform.InputConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.KeyMapping;
import net.thebrokenscript.brokencore.api.platform.PlatformKeyBindings;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.registry.BCReg;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformKeyBindingsImpl;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformKeyBindings;", "<init>", "()V", "openCutsceneEditor", "Lkotlin/Lazy;", "Lnet/minecraft/client/KeyMapping;", "getOpenCutsceneEditor", "()Lkotlin/Lazy;", "addLang", "", "Companion", "brokencore-neoforge"})
public final class PlatformKeyBindingsImpl
implements PlatformKeyBindings {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String CATEGORY = "keys.brokencore.editor";
    @NotNull
    public static final String OPEN_CUTSCENE_EDITOR_NAME = "key.brokencore.editor.cutscene";
    @NotNull
    private static final Lazy<KeyMapping> OPEN_CUTSCENE_EDITOR = LazyKt.lazy(PlatformKeyBindingsImpl::OPEN_CUTSCENE_EDITOR$lambda$0);

    @Override
    @NotNull
    public Lazy<KeyMapping> getOpenCutsceneEditor() {
        return OPEN_CUTSCENE_EDITOR;
    }

    @Override
    public void addLang() {
        BCReg.INSTANCE.getData().getLang().set(CATEGORY, "BrokenCore - Editors");
        BCReg.INSTANCE.getData().getLang().set(OPEN_CUTSCENE_EDITOR_NAME, "Open Cutscene Editor");
    }

    private static final KeyMapping OPEN_CUTSCENE_EDITOR$lambda$0() {
        return new KeyMapping(OPEN_CUTSCENE_EDITOR_NAME, InputConstants.Type.KEYSYM, 297, CATEGORY);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformKeyBindingsImpl$Companion;", "", "<init>", "()V", "CATEGORY", "", "OPEN_CUTSCENE_EDITOR_NAME", "OPEN_CUTSCENE_EDITOR", "Lkotlin/Lazy;", "Lnet/minecraft/client/KeyMapping;", "getOPEN_CUTSCENE_EDITOR", "()Lkotlin/Lazy;", "brokencore-neoforge"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Lazy<KeyMapping> getOPEN_CUTSCENE_EDITOR() {
            return OPEN_CUTSCENE_EDITOR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

