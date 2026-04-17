package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a fluid attempts to flow in the given direction.
 * <p>
 * If this event is cancelled, the liquid will not flow.
 */
public class FluidFlowEvent extends BlockEvent implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final BlockFace direction;

    private boolean cancelled;

    @ApiStatus.Internal
    public FluidFlowEvent(@NotNull Block fluid, @NotNull BlockFace direction) {
        super(fluid);
        this.direction = direction;
    }

    /**
     * Gets the BlockFace that the fluid is moving to.
     *
     * @return The BlockFace that the fluid is moving to
     */
    @NotNull
    public BlockFace getDirection() {
        return this.direction;
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
