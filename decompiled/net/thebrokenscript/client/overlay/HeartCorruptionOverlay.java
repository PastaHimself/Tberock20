/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.overlay;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/client/overlay/HeartCorruptionOverlay;", "", "<init>", "()V", "render", "", "graphics", "Lnet/minecraft/client/gui/GuiGraphics;", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class HeartCorruptionOverlay {
    @NotNull
    public static final HeartCorruptionOverlay INSTANCE = new HeartCorruptionOverlay();

    private HeartCorruptionOverlay() {
    }

    public final void render(@NotNull GuiGraphics graphics, @NotNull Player player) {
        int i;
        Intrinsics.checkNotNullParameter((Object)graphics, (String)"graphics");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        int maxHealth = (int)player.getMaxHealth();
        int health = (int)player.getHealth();
        RandomSource randomSource = player.getRandom();
        Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"getRandom(...)");
        RandomSource random = randomSource;
        int corruptedHearts = (20 - maxHealth) / 2;
        int x = graphics.guiWidth() / 2 - 91;
        int y = graphics.guiHeight() - 39;
        for (i = 0; i < corruptedHearts; ++i) {
            int randX = random.nextInt(-5, 5);
            int randY = random.nextInt(-5, 5);
            graphics.blit(ResourceLocation.withDefaultNamespace((String)""), x + i * 8 + randX, y + randY, 0.0f, 0.0f, 9, 9, 9, 9);
        }
        int n = health / 2;
        for (i = corruptedHearts; i < n; ++i) {
            int randX = random.nextInt(-5, 5);
            int randY = random.nextInt(-5, 5);
            graphics.blitSprite(ResourceLocation.withDefaultNamespace((String)"textures/gui/sprites/hud/heart/full.png"), x + i * 8 + randX, y + randY, 9, 9);
        }
    }
}

