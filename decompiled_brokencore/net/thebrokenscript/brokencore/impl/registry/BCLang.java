/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.registry;

import kotlin.Metadata;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import net.thebrokenscript.brokencore.impl.registry.BCReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/impl/registry/BCLang;", "", "<init>", "()V", "COMMAND_DISCARD_ENTITY_SUCCESS", "Lnet/minecraft/network/chat/MutableComponent;", "getCOMMAND_DISCARD_ENTITY_SUCCESS", "()Lnet/minecraft/network/chat/MutableComponent;", "COMMAND_ERROR_NOT_PLAYER", "getCOMMAND_ERROR_NOT_PLAYER", "BC_CHASE", "getBC_CHASE", "brokencore-common"})
public final class BCLang {
    @NotNull
    public static final BCLang INSTANCE = new BCLang();
    @NotNull
    private static final MutableComponent COMMAND_DISCARD_ENTITY_SUCCESS = BCReg.INSTANCE.getData().getLang().set("commands.brokencore.discard_entity.success", "\u00a7aSuccessfully discarded \u00a7d%1$s\u00a7a entities!");
    @NotNull
    private static final MutableComponent COMMAND_ERROR_NOT_PLAYER = BCReg.INSTANCE.getData().getLang().set("commands.brokencore.not_player", "\u00a7cThis command must be executed by a player!");
    @NotNull
    private static final MutableComponent BC_CHASE = BCReg.INSTANCE.getData().getLang().set("soundCategory.bc_chase", "Chase Themes");

    private BCLang() {
    }

    @NotNull
    public final MutableComponent getCOMMAND_DISCARD_ENTITY_SUCCESS() {
        return COMMAND_DISCARD_ENTITY_SUCCESS;
    }

    @NotNull
    public final MutableComponent getCOMMAND_ERROR_NOT_PLAYER() {
        return COMMAND_ERROR_NOT_PLAYER;
    }

    @NotNull
    public final MutableComponent getBC_CHASE() {
        return BC_CHASE;
    }
}

