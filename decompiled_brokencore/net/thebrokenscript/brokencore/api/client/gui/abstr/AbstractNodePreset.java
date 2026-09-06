/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlinx.serialization.json.JsonObject
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlinx.serialization.json.JsonObject;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&\u00a2\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractNodePreset;", "T", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode;", "", "<init>", "()V", "load", "", "node", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "(Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode;Lkotlinx/serialization/json/JsonObject;)V", "save", "(Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode;)Lkotlinx/serialization/json/JsonObject;", "brokencore-common"})
public abstract class AbstractNodePreset<T extends AbstractGuiNode> {
    public abstract void load(@NotNull T var1, @NotNull JsonObject var2);

    @NotNull
    public abstract JsonObject save(@NotNull T var1);
}

