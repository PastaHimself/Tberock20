/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.alert;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/alert/AlertWindow;", "", "title", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "show", "", "makeJar", "Companion", "brokencore-common"})
public final class AlertWindow {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String title;
    @NotNull
    private final String message;
    private static final Path file;

    public AlertWindow(@NotNull String title, @NotNull String message) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        this.title = title;
        this.message = message;
    }

    public final void show() {
        if (!PlatformUtil.Companion.isClientSide()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue((Object)file, (String)"file");
        String[] stringArray = file;
        LinkOption[] linkOptionArray = new LinkOption[]{};
        if (!Files.exists((Path)stringArray, Arrays.copyOf(linkOptionArray, linkOptionArray.length))) {
            this.makeJar();
        }
        stringArray = new String[]{AlertWindow.Companion.getJava(), "-jar", ((Object)file.toAbsolutePath()).toString(), this.title, this.message};
        new ProcessBuilder(stringArray).inheritIO().start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void makeJar() {
        Object object = new String[]{"net/thebrokenscript/brokencore/impl/alert/AlertWindowInner.class", "lwjgl.png"};
        List resourceList = CollectionsKt.listOf((Object[])object);
        Path path = file;
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"file");
        object = path;
        Object object2 = new OpenOption[]{};
        OutputStream outputStream = Files.newOutputStream((Path)object, Arrays.copyOf(object2, ((OpenOption[])object2).length));
        Intrinsics.checkNotNullExpressionValue((Object)outputStream, (String)"newOutputStream(...)");
        object = new JarOutputStream(outputStream);
        object2 = null;
        try {
            JarOutputStream jar = (JarOutputStream)object;
            boolean bl = false;
            jar.putNextEntry(new JarEntry("META-INF/MANIFEST.MF"));
            byte[] byArray = "Main-Class: net.thebrokenscript.brokencore.impl.alert.AlertWindowInner\n".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBytes(...)");
            jar.write(byArray);
            jar.closeEntry();
            for (String resource : resourceList) {
                jar.putNextEntry(new JarEntry(resource));
                Closeable closeable = this.getClass().getClassLoader().getResourceAsStream(resource);
                Throwable throwable = null;
                try {
                    InputStream it = (InputStream)closeable;
                    boolean bl2 = false;
                    if (it == null) {
                        throw new IOException("Resource " + resource + " not found in classpath");
                    }
                    long l = ByteStreamsKt.copyTo$default((InputStream)it, (OutputStream)jar, (int)0, (int)2, null);
                }
                catch (Throwable throwable2) {
                    throwable = throwable2;
                    throw throwable2;
                }
                finally {
                    CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                }
            }
            jar.flush();
            Unit unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            object2 = throwable;
            throw throwable;
        }
        finally {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        }
        Path path2 = file;
        Intrinsics.checkNotNullExpressionValue((Object)path2, (String)"file");
        object = path2;
        object2 = new LinkOption[]{};
        if (!Files.exists((Path)object, (LinkOption[])Arrays.copyOf(object2, ((OpenOption[])object2).length))) {
            throw new IOException("Failed to create JAR file at " + file.toAbsolutePath());
        }
    }

    static {
        Path path;
        Companion = new Companion(null);
        Path it = path = Files.createTempFile("alert-window", ".jar", new FileAttribute[0]);
        boolean bl = false;
        Intrinsics.checkNotNull((Object)it);
        Files.delete(it);
        it.toFile().deleteOnExit();
        file = path;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/alert/AlertWindow$Companion;", "", "<init>", "()V", "java", "", "getJava", "()Ljava/lang/String;", "file", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        private final String getJava() {
            String string = ProcessHandle.current().info().command().orElse("java");
            Intrinsics.checkNotNull((Object)string);
            return string;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

