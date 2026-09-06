/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.block.model.ItemTransform$Deserializer
 *  org.joml.Vector3f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package compat.net.neoforged.neoforge.mixin;

import net.minecraft.client.renderer.block.model.ItemTransform;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ItemTransform.Deserializer.class})
public class ItemTransformDeserializerAccessor {
    @Accessor(value="DEFAULT_ROTATION")
    public static Vector3f brokencore$getDefaultRotation() {
        throw new AssertionError();
    }

    @Accessor(value="DEFAULT_TRANSLATION")
    public static Vector3f brokencore$getDefaultTranslation() {
        throw new AssertionError();
    }

    @Accessor(value="DEFAULT_SCALE")
    public static Vector3f brokencore$getDefaultScale() {
        throw new AssertionError();
    }
}

