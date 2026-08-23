/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoBlockRenderer
 *  software.bernie.geckolib.renderer.GeoRenderer
 *  software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer
 *  software.bernie.geckolib.renderer.layer.GeoRenderLayer
 */
package net.thebrokenscript.client.renderer.block;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.block.entity.PlushBlockEntity;
import net.thebrokenscript.client.model.plush.BasePlushModel;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/client/renderer/block/GlowPlushBlockRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoBlockRenderer;", "Lnet/thebrokenscript/block/entity/PlushBlockEntity;", "name", "", "<init>", "(Ljava/lang/String;)V", "thebrokenscript-common"})
public final class GlowPlushBlockRenderer
extends GeoBlockRenderer<PlushBlockEntity> {
    public GlowPlushBlockRenderer(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        super((GeoModel)new BasePlushModel(name));
        this.addRenderLayer((GeoRenderLayer)new AutoGlowingGeoLayer((GeoRenderer)this));
    }
}

