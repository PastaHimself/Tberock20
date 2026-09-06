/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.json.JsonArray
 *  kotlinx.serialization.json.JsonArrayBuilder
 *  kotlinx.serialization.json.JsonElement
 *  kotlinx.serialization.json.JsonElementBuildersKt
 *  kotlinx.serialization.json.JsonElementKt
 *  kotlinx.serialization.json.JsonPrimitive
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.settings;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.enums.SpriteScalingType;
import net.thebrokenscript.brokencore.api.client.gui.settings.NinePatchSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u00010B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J>\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rJ<\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'J$\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020!2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020!J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u000f\u00a8\u00061"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "", "type", "Lnet/thebrokenscript/brokencore/api/client/gui/enums/SpriteScalingType;", "ninePatchSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/enums/SpriteScalingType;Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings;)V", "getType", "()Lnet/thebrokenscript/brokencore/api/client/gui/enums/SpriteScalingType;", "getNinePatchSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings;", "l", "", "getL", "()I", "r", "getR", "t", "getT", "b", "getB", "w", "getW", "h", "getH", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "sprite", "Lnet/minecraft/resources/ResourceLocation;", "node2D", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "x", "y", "zIndex", "clip", "func", "Lkotlin/Function0;", "node", "enableChildClipping", "equals", "", "other", "toJson", "Lkotlinx/serialization/json/JsonArray;", "hashCode", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nSpriteScalingSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpriteScalingSettings.kt\nnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings\n+ 2 JsonElementBuilders.kt\nkotlinx/serialization/json/JsonElementBuildersKt\n*L\n1#1,95:1\n52#2,3:96\n*S KotlinDebug\n*F\n+ 1 SpriteScalingSettings.kt\nnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings\n*L\n55#1:96,3\n*E\n"})
public final class SpriteScalingSettings {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SpriteScalingType type;
    @NotNull
    private final NinePatchSettings ninePatchSettings;
    @NotNull
    private static final SpriteScalingSettings KEEP = new SpriteScalingSettings(SpriteScalingType.KEEP, null, 2, null);
    @NotNull
    private static final SpriteScalingSettings KEEP_ASPECT = new SpriteScalingSettings(SpriteScalingType.KEEP_ASPECT, null, 2, null);
    @NotNull
    private static final SpriteScalingSettings STRETCH = new SpriteScalingSettings(SpriteScalingType.STRETCH, null, 2, null);
    @NotNull
    private static final SpriteScalingSettings TILE = new SpriteScalingSettings(SpriteScalingType.TILE, null, 2, null);

    private SpriteScalingSettings(SpriteScalingType type, NinePatchSettings ninePatchSettings) {
        this.type = type;
        this.ninePatchSettings = ninePatchSettings;
    }

    /* synthetic */ SpriteScalingSettings(SpriteScalingType spriteScalingType, NinePatchSettings ninePatchSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            ninePatchSettings = NinePatchSettings.Companion.getNONE();
        }
        this(spriteScalingType, ninePatchSettings);
    }

    @NotNull
    public final SpriteScalingType getType() {
        return this.type;
    }

    @NotNull
    public final NinePatchSettings getNinePatchSettings() {
        return this.ninePatchSettings;
    }

    public final int getL() {
        return this.ninePatchSettings.getL();
    }

    public final int getR() {
        return this.ninePatchSettings.getT();
    }

    public final int getT() {
        return this.ninePatchSettings.getT();
    }

    public final int getB() {
        return this.ninePatchSettings.getB();
    }

    public final int getW() {
        return this.getL() + this.getR();
    }

    public final int getH() {
        return this.getT() + this.getB();
    }

    public final void render(@NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation sprite, @NotNull AbstractGuiNode2D node2D) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        Intrinsics.checkNotNullParameter((Object)node2D, (String)"node2D");
        this.type.render(guiGraphics, sprite, node2D, this);
    }

    public final void render(@NotNull GuiGraphics guiGraphics, @NotNull ResourceLocation sprite, int x, int y, int zIndex, int w, int h) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)sprite, (String)"sprite");
        this.type.render(guiGraphics, sprite, this, x, y, zIndex, w, h);
    }

    public final void clip(@NotNull GuiGraphics guiGraphics, int x, int y, int w, int h, @NotNull Function0<Unit> func) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter(func, (String)"func");
        guiGraphics.enableScissor(x + this.getL(), y + this.getT(), x + w - this.getR(), x + h - this.getB());
        func.invoke();
        guiGraphics.disableScissor();
    }

    public final void clip(@NotNull GuiGraphics guiGraphics, @NotNull AbstractGuiNode2D node, @NotNull Function0<Unit> func) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter(func, (String)"func");
        this.clip(guiGraphics, node.getGlobalX(), node.getGlobalY(), node.getW(), node.getH(), func);
    }

    public final void enableChildClipping(@NotNull AbstractGuiNode2D node) {
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        node.enableChildClipping(node.getX() + this.getL(), node.getY() + this.getT(), node.getX() + node.getW() - this.getR(), node.getX() + node.getH() - this.getB());
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        Object object = other;
        if (!Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null)) {
            return false;
        }
        Object object2 = other;
        Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings");
        SpriteScalingSettings cfr_ignored_0 = (SpriteScalingSettings)object2;
        if (this.type != ((SpriteScalingSettings)other).type) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.ninePatchSettings, (Object)((SpriteScalingSettings)other).ninePatchSettings);
    }

    @NotNull
    public final JsonArray toJson() {
        JsonArrayBuilder builder$iv;
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u240 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u240, (Number)this.type.ordinal());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u240, (Number)this.ninePatchSettings.getL());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u240, (Number)this.ninePatchSettings.getR());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u240, (Number)this.ninePatchSettings.getT());
        JsonElementBuildersKt.add((JsonArrayBuilder)$this$toJson_u24lambda_u240, (Number)this.ninePatchSettings.getB());
        return builder$iv.build();
    }

    public int hashCode() {
        int result = this.type.hashCode();
        result = 31 * result + this.ninePatchSettings.hashCode();
        return result;
    }

    public /* synthetic */ SpriteScalingSettings(SpriteScalingType type, NinePatchSettings ninePatchSettings, DefaultConstructorMarker $constructor_marker) {
        this(type, ninePatchSettings);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings$Companion;", "", "<init>", "()V", "KEEP", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "getKEEP", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "KEEP_ASPECT", "getKEEP_ASPECT", "STRETCH", "getSTRETCH", "TILE", "getTILE", "createNinePatch", "ninePatchSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/NinePatchSettings;", "fromJson", "jsonArray", "Lkotlinx/serialization/json/JsonArray;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SpriteScalingSettings getKEEP() {
            return KEEP;
        }

        @NotNull
        public final SpriteScalingSettings getKEEP_ASPECT() {
            return KEEP_ASPECT;
        }

        @NotNull
        public final SpriteScalingSettings getSTRETCH() {
            return STRETCH;
        }

        @NotNull
        public final SpriteScalingSettings getTILE() {
            return TILE;
        }

        @NotNull
        public final SpriteScalingSettings createNinePatch(@NotNull NinePatchSettings ninePatchSettings) {
            Intrinsics.checkNotNullParameter((Object)ninePatchSettings, (String)"ninePatchSettings");
            return new SpriteScalingSettings(SpriteScalingType.NINE_PATCH, ninePatchSettings, null);
        }

        @NotNull
        public final SpriteScalingSettings fromJson(@NotNull JsonArray jsonArray) {
            Intrinsics.checkNotNullParameter((Object)jsonArray, (String)"jsonArray");
            SpriteScalingType type = (SpriteScalingType)((Object)SpriteScalingType.getEntries().get(JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)jsonArray.get(0)))));
            return switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1 -> this.createNinePatch(new NinePatchSettings(JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)jsonArray.get(1))), JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)jsonArray.get(2))), JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)jsonArray.get(3))), JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)jsonArray.get(4)))));
                case 2 -> this.getSTRETCH();
                case 3 -> this.getTILE();
                case 4 -> this.getKEEP();
                case 5 -> this.getKEEP_ASPECT();
                default -> throw new NoWhenBranchMatchedException();
            };
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 1, 0}, k=3, xi=48)
        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[SpriteScalingType.values().length];
                try {
                    nArray[SpriteScalingType.NINE_PATCH.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[SpriteScalingType.STRETCH.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[SpriteScalingType.TILE.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[SpriteScalingType.KEEP.ordinal()] = 4;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[SpriteScalingType.KEEP_ASPECT.ordinal()] = 5;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }
}

