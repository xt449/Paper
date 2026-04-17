package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called when a block teleports from one location to another.
 * Currently only called for dragon eggs.
 * <p>
 * If this event is cancelled, the block will not move.
 */
public class BlockTeleportEvent extends BlockEvent implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Block toBlock;

    private boolean cancelled;

    @ApiStatus.Internal
    public BlockTeleportEvent(@NotNull final Block block, @NotNull final Block toBlock) {
        super(block);
        this.toBlock = toBlock;
    }

    /**
     * Gets the block at the position that this block intents to move to
     *
     * @return Block to me moved to
     */
    @Nullable
    public Block getToBlock() {
        return this.toBlock;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static @NotNull HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
