/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.properties.ReadOnlyProperty
 *  kotlin.reflect.KFunction
 *  kotlin.reflect.KProperty
 *  net.neoforged.fml.config.ModConfig$Type
 *  net.thebrokenscript.brokencore.api.config.Config
 *  net.thebrokenscript.brokencore.api.config.Config$Base
 *  net.thebrokenscript.brokencore.api.config.Config$ConfigBool
 *  net.thebrokenscript.brokencore.api.config.Config$ConfigEnum
 *  net.thebrokenscript.brokencore.api.config.Config$SubGroup
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.config;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import net.neoforged.fml.config.ModConfig;
import net.thebrokenscript.brokencore.api.config.Config;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.config.client.AccessibilityConfig;
import net.thebrokenscript.config.client.MenuMode;
import net.thebrokenscript.registry.TBSDimensionFX;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000208H\u0016J\b\u0010:\u001a\u000208H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00178F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0012\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R+\u0010#\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b&\u0010\u0012\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R+\u0010'\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b*\u0010\u0012\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R+\u0010+\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b.\u0010\u0012\u001a\u0004\b,\u0010\u000e\"\u0004\b-\u0010\u0010R+\u0010/\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b2\u0010\u0012\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R+\u00103\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b6\u0010\u0012\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u0010\u0010\u00a8\u0006;"}, d2={"Lnet/thebrokenscript/config/ClientConfig;", "Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "<init>", "()V", "accessibility", "Lnet/thebrokenscript/config/client/AccessibilityConfig;", "getAccessibility", "()Lnet/thebrokenscript/config/client/AccessibilityConfig;", "accessibility$delegate", "Lkotlin/properties/ReadOnlyProperty;", "<set-?>", "", "enableVhsOverlay", "getEnableVhsOverlay", "()Z", "setEnableVhsOverlay", "(Z)V", "enableVhsOverlay$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigBool;", "enableMoonGlitch", "getEnableMoonGlitch", "setEnableMoonGlitch", "enableMoonGlitch$delegate", "Lnet/thebrokenscript/config/client/MenuMode;", "mainMenuMode", "getMainMenuMode", "()Lnet/thebrokenscript/config/client/MenuMode;", "setMainMenuMode", "(Lnet/thebrokenscript/config/client/MenuMode;)V", "mainMenuMode$delegate", "Lnet/thebrokenscript/brokencore/api/config/Config$ConfigEnum;", "enableHudText", "getEnableHudText", "setEnableHudText", "enableHudText$delegate", "enableFileCreation", "getEnableFileCreation", "setEnableFileCreation", "enableFileCreation$delegate", "enableMenuMusic", "getEnableMenuMusic", "setEnableMenuMusic", "enableMenuMusic$delegate", "enableVoidFog", "getEnableVoidFog", "setEnableVoidFog", "enableVoidFog$delegate", "fancyRendering", "getFancyRendering", "setFancyRendering", "fancyRendering$delegate", "shaderBasedMoon", "getShaderBasedMoon", "setShaderBasedMoon", "shaderBasedMoon$delegate", "onReload", "", "onUnload", "onLoad", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nClientConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClientConfig.kt\nnet/thebrokenscript/config/ClientConfig\n+ 2 Config.kt\nnet/thebrokenscript/brokencore/api/config/Config\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n176#2:61\n177#2,2:64\n295#3,2:62\n*S KotlinDebug\n*F\n+ 1 ClientConfig.kt\nnet/thebrokenscript/config/ClientConfig\n*L\n12#1:61\n12#1:64,2\n12#1:62,2\n*E\n"})
public final class ClientConfig
extends Config.Base {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final ReadOnlyProperty accessibility$delegate;
    @NotNull
    private final Config.ConfigBool enableVhsOverlay$delegate;
    @NotNull
    private final Config.ConfigBool enableMoonGlitch$delegate;
    @NotNull
    private final Config.ConfigEnum mainMenuMode$delegate;
    @NotNull
    private final Config.ConfigBool enableHudText$delegate;
    @NotNull
    private final Config.ConfigBool enableFileCreation$delegate;
    @NotNull
    private final Config.ConfigBool enableMenuMusic$delegate;
    @NotNull
    private final Config.ConfigBool enableVoidFog$delegate;
    @NotNull
    private final Config.ConfigBool fancyRendering$delegate;
    @NotNull
    private final Config.ConfigBool shaderBasedMoon$delegate;

    /*
     * WARNING - void declaration
     */
    public ClientConfig() {
        void comment$iv;
        void this_$iv;
        Object v0;
        String[] stringArray;
        block2: {
            super(ModConfig.Type.CLIENT);
            stringArray = (String[])this;
            String[] stringArray2 = new String[]{"Accessibility settings.", "", "These will break the intended experience of the mod!", "Use at your own risk!"};
            ClientConfig clientConfig = this;
            boolean $i$f$nested = false;
            Iterable $this$firstOrNull$iv$iv = Reflection.getOrCreateKotlinClass(AccessibilityConfig.class).getConstructors();
            boolean $i$f$firstOrNull = false;
            for (Object element$iv$iv : $this$firstOrNull$iv$iv) {
                KFunction it$iv = (KFunction)element$iv$iv;
                boolean bl = false;
                if (!it$iv.getParameters().isEmpty()) continue;
                v0 = element$iv$iv;
                break block2;
            }
            v0 = null;
        }
        KFunction kFunction = v0;
        if (kFunction == null) {
            throw new IllegalArgumentException("ConfigSubGroup " + Reflection.getOrCreateKotlinClass(AccessibilityConfig.class) + " must have a single empty constructor");
        }
        KFunction constructor$iv = kFunction;
        clientConfig.accessibility$delegate = (ReadOnlyProperty)Config.access$nested((Config)this_$iv, (Function0)((Function0)new Function0<AccessibilityConfig>(constructor$iv){
            final /* synthetic */ KFunction $constructor;
            {
                this.$constructor = $constructor;
            }

            public final AccessibilityConfig invoke() {
                return (Config.SubGroup)this.$constructor.call(new Object[0]);
            }
        }), (String[])((String[])Arrays.copyOf(comment$iv, ((void)comment$iv).length))).provideDelegate((Object)this, $$delegatedProperties[0]);
        stringArray = new String[]{"Enable the VHS overlay."};
        this.enableVhsOverlay$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[1]);
        stringArray = new String[]{"Enable having a render distance effect during the moon glitch event."};
        this.enableMoonGlitch$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[2]);
        stringArray = new String[]{"Control how the mod will modify the main menu."};
        this.mainMenuMode$delegate = (Config.ConfigEnum)this.e(PlatformUtil.Companion.isProduction() ? MenuMode.FANART : MenuMode.VANILLA, stringArray).provideDelegate((Object)this, $$delegatedProperties[3]);
        stringArray = new String[]{"Enable the HUD Text. You may miss out on important Stuff if you disable this!"};
        this.enableHudText$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[4]);
        stringArray = new String[]{"Let the mod create a file on your desktop."};
        this.enableFileCreation$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[5]);
        stringArray = new String[]{"Enable the custom main menu music."};
        this.enableMenuMusic$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[6]);
        stringArray = new String[]{"Enable the void fog."};
        this.enableVoidFog$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[7]);
        stringArray = new String[]{"Turns ON/OFF fancy (but higher performance cost) rendering features."};
        this.fancyRendering$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[8]);
        stringArray = new String[]{"Turns ON/OFF shader based skybox on the moon."};
        this.shaderBasedMoon$delegate = (Config.ConfigBool)this.b(true, stringArray).provideDelegate((Object)this, $$delegatedProperties[9]);
    }

    @NotNull
    public final AccessibilityConfig getAccessibility() {
        return (AccessibilityConfig)((Object)this.accessibility$delegate.getValue((Object)this, $$delegatedProperties[0]));
    }

    public final boolean getEnableVhsOverlay() {
        return (Boolean)this.enableVhsOverlay$delegate.getValue((Config)this, $$delegatedProperties[1]);
    }

    public final void setEnableVhsOverlay(boolean bl) {
        this.enableVhsOverlay$delegate.setValue((Config)this, $$delegatedProperties[1], (Object)bl);
    }

    public final boolean getEnableMoonGlitch() {
        return (Boolean)this.enableMoonGlitch$delegate.getValue((Config)this, $$delegatedProperties[2]);
    }

    public final void setEnableMoonGlitch(boolean bl) {
        this.enableMoonGlitch$delegate.setValue((Config)this, $$delegatedProperties[2], (Object)bl);
    }

    @NotNull
    public final MenuMode getMainMenuMode() {
        return (MenuMode)((Object)this.mainMenuMode$delegate.getValue((Config)this, $$delegatedProperties[3]));
    }

    public final void setMainMenuMode(@NotNull MenuMode menuMode) {
        Intrinsics.checkNotNullParameter((Object)((Object)menuMode), (String)"<set-?>");
        this.mainMenuMode$delegate.setValue((Config)this, $$delegatedProperties[3], (Object)menuMode);
    }

    public final boolean getEnableHudText() {
        return (Boolean)this.enableHudText$delegate.getValue((Config)this, $$delegatedProperties[4]);
    }

    public final void setEnableHudText(boolean bl) {
        this.enableHudText$delegate.setValue((Config)this, $$delegatedProperties[4], (Object)bl);
    }

    public final boolean getEnableFileCreation() {
        return (Boolean)this.enableFileCreation$delegate.getValue((Config)this, $$delegatedProperties[5]);
    }

    public final void setEnableFileCreation(boolean bl) {
        this.enableFileCreation$delegate.setValue((Config)this, $$delegatedProperties[5], (Object)bl);
    }

    public final boolean getEnableMenuMusic() {
        return (Boolean)this.enableMenuMusic$delegate.getValue((Config)this, $$delegatedProperties[6]);
    }

    public final void setEnableMenuMusic(boolean bl) {
        this.enableMenuMusic$delegate.setValue((Config)this, $$delegatedProperties[6], (Object)bl);
    }

    public final boolean getEnableVoidFog() {
        return (Boolean)this.enableVoidFog$delegate.getValue((Config)this, $$delegatedProperties[7]);
    }

    public final void setEnableVoidFog(boolean bl) {
        this.enableVoidFog$delegate.setValue((Config)this, $$delegatedProperties[7], (Object)bl);
    }

    public final boolean getFancyRendering() {
        return (Boolean)this.fancyRendering$delegate.getValue((Config)this, $$delegatedProperties[8]);
    }

    public final void setFancyRendering(boolean bl) {
        this.fancyRendering$delegate.setValue((Config)this, $$delegatedProperties[8], (Object)bl);
    }

    public final boolean getShaderBasedMoon() {
        return (Boolean)this.shaderBasedMoon$delegate.getValue((Config)this, $$delegatedProperties[9]);
    }

    public final void setShaderBasedMoon(boolean bl) {
        this.shaderBasedMoon$delegate.setValue((Config)this, $$delegatedProperties[9], (Object)bl);
    }

    public void onReload() {
        super.onReload();
        ClientDSLKt.getMC().execute(ClientConfig::onReload$lambda$0);
    }

    public void onUnload() {
        super.onUnload();
        ClientDSLKt.getMC().execute(ClientConfig::onUnload$lambda$0);
    }

    public void onLoad() {
        super.onLoad();
        ClientDSLKt.getMC().execute(ClientConfig::onLoad$lambda$0);
    }

    private static final void onReload$lambda$0() {
        TBSDimensionFX.INSTANCE.applyMoonSkyConfig();
    }

    private static final void onUnload$lambda$0() {
        TBSDimensionFX.INSTANCE.applyMoonSkyConfig();
    }

    private static final void onLoad$lambda$0() {
        TBSDimensionFX.INSTANCE.applyMoonSkyConfig();
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(ClientConfig.class, "accessibility", "getAccessibility()Lnet/thebrokenscript/config/client/AccessibilityConfig;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "enableVhsOverlay", "getEnableVhsOverlay()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "enableMoonGlitch", "getEnableMoonGlitch()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "mainMenuMode", "getMainMenuMode()Lnet/thebrokenscript/config/client/MenuMode;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "enableHudText", "getEnableHudText()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "enableFileCreation", "getEnableFileCreation()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "enableMenuMusic", "getEnableMenuMusic()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "enableVoidFog", "getEnableVoidFog()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "fancyRendering", "getFancyRendering()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ClientConfig.class, "shaderBasedMoon", "getShaderBasedMoon()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
    }
}

