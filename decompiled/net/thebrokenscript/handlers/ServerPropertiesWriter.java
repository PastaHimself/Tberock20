/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.files.UserDirs
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.files.UserDirs;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.handlers.subs.LevelLoadSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/ServerPropertiesWriter;", "", "<init>", "()V", "onWorldLoad", "", "level", "Lnet/minecraft/world/level/Level;", "thebrokenscript-common"})
public final class ServerPropertiesWriter {
    @NotNull
    public static final ServerPropertiesWriter INSTANCE = new ServerPropertiesWriter();

    private ServerPropertiesWriter() {
    }

    private final void onWorldLoad(Level level) {
        if (!level.isClientSide) {
            return;
        }
        if (!TBSConfigs.INSTANCE.getClient().getEnableFileCreation()) {
            return;
        }
        if (!PlatformUtil.Companion.isProduction()) {
            return;
        }
        try {
            String content = "\u2603K\u0338\u0300\u034b\u030b\u0311\u0301\u030c\u031c\u0326I\u0337\u0303\u0311\u033d\u0315\u0305\u0318\u034eL\u0337\u0309\u030a\u0341\u031b\u030c\u0312\u0345\u0349L\u0334\u0315\u0343\u035d\u0308\u030d\u032b\u0329 \u0336\u0311\u030a\u0351\u030d\u0344\u0323\u0321\u0355\u0320\u032eH\u0338\u0303\u033e\u0306\u0302\u0344\u033b\u0322\u0349\u0317\u0348I\u0335\u0340\u0315\u032fM\u0335\u034c\u0310\u030a\u0346\u0359\u031e";
            FilesKt.writeText((File)FilesKt.resolve((File)UserDirs.Companion.desktop(), (String)"serverproperties.txt"), (String)content, (Charset)Charsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        LevelLoadSubscriber.INSTANCE.add((Function1<? super Level, Unit>)((Function1)new Function1<Level, Unit>((Object)INSTANCE){

            public final void invoke(Level p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((ServerPropertiesWriter)this.receiver).onWorldLoad(p0);
            }
        }));
    }
}

