/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.NativeImage
 *  com.mojang.blaze3d.platform.NativeImage$Format
 *  com.mojang.blaze3d.platform.TextureUtil
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.texture.AbstractTexture
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.Resource
 *  net.minecraft.server.packs.resources.ResourceManager
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.client;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.TextureUtil;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/impl/client/JpgLoader;", "Lnet/minecraft/client/renderer/texture/AbstractTexture;", "location", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;)V", "load", "", "manager", "Lnet/minecraft/server/packs/resources/ResourceManager;", "uploadFromStream", "stream", "Ljava/io/InputStream;", "Companion", "brokencore-common"})
public final class JpgLoader
extends AbstractTexture {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation location;

    public JpgLoader(@NotNull ResourceLocation location) {
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        this.location = location;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void load(@NotNull ResourceManager manager) {
        Intrinsics.checkNotNullParameter((Object)manager, (String)"manager");
        Resource resource = (Resource)manager.getResource(this.location).orElseThrow(() -> JpgLoader.load$lambda$0(this));
        Closeable closeable = resource.open();
        Throwable throwable = null;
        try {
            InputStream stream = (InputStream)closeable;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)stream);
            this.uploadFromStream(stream);
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
    }

    private final void uploadFromStream(InputStream stream) {
        BufferedImage bufferedImage = ImageIO.read(stream);
        Intrinsics.checkNotNullExpressionValue((Object)bufferedImage, (String)"read(...)");
        BufferedImage image = bufferedImage;
        int width = image.getWidth();
        int height = image.getHeight();
        NativeImage nativeImage = new NativeImage(NativeImage.Format.RGBA, width, height, false);
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                int argb = image.getRGB(x, y);
                int a = argb >> 24 & 0xFF;
                int r = argb >> 16 & 0xFF;
                int g = argb >> 8 & 0xFF;
                int b = argb & 0xFF;
                int abgr = a << 24 | b << 16 | g << 8 | r;
                nativeImage.setPixelRGBA(x, y, abgr);
            }
        }
        TextureUtil.prepareImage((int)this.getId(), (int)width, (int)height);
        nativeImage.upload(0, 0, 0, false);
        nativeImage.close();
    }

    private static final FileNotFoundException load$lambda$0(JpgLoader this$0) {
        return new FileNotFoundException("Could not find texture: " + this$0.location);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/impl/client/JpgLoader$Companion;", "", "<init>", "()V", "loadJpg", "", "location", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public final void loadJpg(@NotNull ResourceLocation location) {
            Intrinsics.checkNotNullParameter((Object)location, (String)"location");
            TextureManager manager = ClientDSLKt.getMC().getTextureManager();
            if (manager.getTexture(location, null) == null) {
                manager.register(location, (AbstractTexture)new JpgLoader(location));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

