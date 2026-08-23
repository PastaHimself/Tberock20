/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.sound;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\b\u0010\tJ&\u0010\f\u001a\u00028\u00002\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0002\b\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J?\u0010\f\u001a\u00028\u00002\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0002\b\u00102\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0002\b\u0010H\u0016\u00a2\u0006\u0002\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/AudioEffectHolder;", "T", "Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "", "id", "Lnet/minecraft/resources/ResourceLocation;", "ctor", "Lkotlin/Function0;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lkotlin/jvm/functions/Function0;)V", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "create", "cb", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "filterCb", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lnet/thebrokenscript/brokencore/api/sound/fx/AudioEffect;", "brokencore-common"})
public class AudioEffectHolder<T extends AudioEffect<T>> {
    @NotNull
    private final ResourceLocation id;
    @NotNull
    private final Function0<T> ctor;

    public AudioEffectHolder(@NotNull ResourceLocation id, @NotNull Function0<? extends T> ctor) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
        this.id = id;
        this.ctor = ctor;
    }

    @NotNull
    public final ResourceLocation getId() {
        return this.id;
    }

    @NotNull
    public T create(@NotNull Function1<? super T, Unit> cb) {
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        Object object = this.ctor.invoke();
        AudioEffect $this$create_u24lambda_u240 = (AudioEffect)object;
        boolean bl = false;
        $this$create_u24lambda_u240.getCallbacks().add(cb);
        return (T)((AudioEffect)object);
    }

    @NotNull
    public T create(@NotNull Function1<? super T, Unit> cb, @NotNull Function1<? super T, Unit> filterCb) {
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        Intrinsics.checkNotNullParameter(filterCb, (String)"filterCb");
        Object object = this.ctor.invoke();
        AudioEffect $this$create_u24lambda_u241 = (AudioEffect)object;
        boolean bl = false;
        $this$create_u24lambda_u241.getCallbacks().add(cb);
        $this$create_u24lambda_u241.getFilterCallbacks().add(filterCb);
        return (T)((AudioEffect)object);
    }
}

