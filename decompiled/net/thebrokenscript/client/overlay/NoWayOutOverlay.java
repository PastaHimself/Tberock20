/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.overlay;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseCircuitEntity;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/client/overlay/NoWayOutOverlay;", "", "<init>", "()V", "render", "", "graphics", "Lnet/minecraft/client/gui/GuiGraphics;", "w", "", "h", "thebrokenscript-common"})
public final class NoWayOutOverlay {
    @NotNull
    public static final NoWayOutOverlay INSTANCE = new NoWayOutOverlay();

    private NoWayOutOverlay() {
    }

    public final void render(@NotNull GuiGraphics graphics, int w, int h) {
        PlayerVariables vars;
        block19: {
            block18: {
                Intrinsics.checkNotNullParameter((Object)graphics, (String)"graphics");
                LocalPlayer localPlayer = Minecraft.getInstance().player;
                if (localPlayer == null) {
                    return;
                }
                LocalPlayer player = localPlayer;
                Level level = player.level();
                vars = PlayerExt.INSTANCE.getVars((Player)player);
                int n = vars.getNoWayOutFrame();
                boolean bl = 1 <= n ? n < 6 : false;
                if (!bl) break block18;
                Intrinsics.checkNotNull((Object)level);
                LevelAccessor levelAccessor = (LevelAccessor)level;
                Vec3 vec3 = player.position();
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                if (EntityFinder.hasEntitiesInRange((LevelAccessor)levelAccessor, BaseCircuitEntity.class, (Vec3)vec3, (Number)Float.valueOf(200.0f))) break block19;
            }
            return;
        }
        int offsetX = switch (vars.getNoWayOutFrame()) {
            case 1 -> -567;
            case 2 -> -378;
            case 3 -> -459;
            case 4 -> -468;
            case 5 -> -720;
            default -> 0;
        };
        int offsetY = switch (vars.getNoWayOutFrame()) {
            case 1 -> -76;
            case 2 -> -121;
            case 3 -> 5;
            case 4 -> -121;
            case 5 -> -76;
            default -> 0;
        };
        graphics.blit(TBSConstants.id("textures/screens/textvhs1.png"), w / 2 + offsetX, h / 2 + offsetY, 0.0f, 0.0f, 750, 150, 750, 150);
    }
}

