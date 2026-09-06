/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  oshi.util.FileUtil
 */
package net.thebrokenscript.brokencore.impl.mixin.devtool;

import java.util.Objects;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import oshi.util.FileUtil;

@Mixin(value={FileUtil.class})
public class FileUtilMixin {
    @Shadow
    @Final
    private static String READING_LOG;

    @Redirect(method={"readFile(Ljava/lang/String;Z)Ljava/util/List;", "readAllBytes(Ljava/lang/String;Z)[B", "getLongFromFile", "getUnsignedLongFromFile", "getIntFromFile", "getStringFromFile", "getKeyValueMapFromFile"}, at=@At(value="INVOKE", target="Lorg/slf4j/Logger;debug(Ljava/lang/String;Ljava/lang/Object;)V"))
    private static void bc$silenceDebugOutput(Logger instance, String s, Object o) {
        if (Objects.equals(s, READING_LOG)) {
            return;
        }
        instance.debug(s, o);
    }
}

