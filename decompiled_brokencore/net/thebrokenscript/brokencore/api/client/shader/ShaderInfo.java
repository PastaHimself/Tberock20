/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexFormat
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.shader;

import com.mojang.blaze3d.vertex.VertexFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/client/shader/ShaderInfo;", "", "name", "Lnet/minecraft/resources/ResourceLocation;", "vertexFormat", "Lcom/mojang/blaze3d/vertex/VertexFormat;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lcom/mojang/blaze3d/vertex/VertexFormat;)V", "getName", "()Lnet/minecraft/resources/ResourceLocation;", "getVertexFormat", "()Lcom/mojang/blaze3d/vertex/VertexFormat;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
public final class ShaderInfo {
    @NotNull
    private final ResourceLocation name;
    @NotNull
    private final VertexFormat vertexFormat;

    public ShaderInfo(@NotNull ResourceLocation name, @NotNull VertexFormat vertexFormat) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)vertexFormat, (String)"vertexFormat");
        this.name = name;
        this.vertexFormat = vertexFormat;
    }

    @NotNull
    public final ResourceLocation getName() {
        return this.name;
    }

    @NotNull
    public final VertexFormat getVertexFormat() {
        return this.vertexFormat;
    }

    @NotNull
    public final ResourceLocation component1() {
        return this.name;
    }

    @NotNull
    public final VertexFormat component2() {
        return this.vertexFormat;
    }

    @NotNull
    public final ShaderInfo copy(@NotNull ResourceLocation name, @NotNull VertexFormat vertexFormat) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)vertexFormat, (String)"vertexFormat");
        return new ShaderInfo(name, vertexFormat);
    }

    public static /* synthetic */ ShaderInfo copy$default(ShaderInfo shaderInfo, ResourceLocation resourceLocation, VertexFormat vertexFormat, int n, Object object) {
        if ((n & 1) != 0) {
            resourceLocation = shaderInfo.name;
        }
        if ((n & 2) != 0) {
            vertexFormat = shaderInfo.vertexFormat;
        }
        return shaderInfo.copy(resourceLocation, vertexFormat);
    }

    @NotNull
    public String toString() {
        return "ShaderInfo(name=" + this.name + ", vertexFormat=" + this.vertexFormat + ")";
    }

    public int hashCode() {
        int result = this.name.hashCode();
        result = result * 31 + this.vertexFormat.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShaderInfo)) {
            return false;
        }
        ShaderInfo shaderInfo = (ShaderInfo)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)shaderInfo.name)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.vertexFormat, (Object)shaderInfo.vertexFormat);
    }
}

