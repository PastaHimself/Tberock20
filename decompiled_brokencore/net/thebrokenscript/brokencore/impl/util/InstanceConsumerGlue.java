/*
 * Decompiled with CFR 0.152.
 */
package net.thebrokenscript.brokencore.impl.util;

import net.thebrokenscript.brokencore.api.util.InstanceConsumer;

public class InstanceConsumerGlue {
    public static <I> void accept(I inst, InstanceConsumer<I> cons) {
        cons.accept(inst);
    }
}

