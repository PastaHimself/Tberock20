/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  net.minecraft.sounds.SoundSource
 *  net.thebrokenscript.brokencore.api.registry.SoundCategoryRegistry
 *  net.thebrokenscript.brokencore.api.sound.SoundSourceFactory
 *  net.thebrokenscript.brokencore.impl.SoundCategory
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import net.minecraft.sounds.SoundSource;
import net.thebrokenscript.brokencore.api.registry.SoundCategoryRegistry;
import net.thebrokenscript.brokencore.api.sound.SoundSourceFactory;
import net.thebrokenscript.brokencore.impl.SoundCategory;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@SoundCategory
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/registry/TBSSoundCategories;", "Lnet/thebrokenscript/brokencore/api/registry/SoundCategoryRegistry;", "<init>", "()V", "TBS_MUSIC", "Lnet/minecraft/sounds/SoundSource;", "thebrokenscript-common"})
public final class TBSSoundCategories
extends SoundCategoryRegistry {
    @NotNull
    public static final TBSSoundCategories INSTANCE = new TBSSoundCategories();
    @JvmField
    @NotNull
    public static final SoundSource TBS_MUSIC = SoundSourceFactory.createSoundSourceCategory((String)"tbs_ambience");

    private TBSSoundCategories() {
    }
}

