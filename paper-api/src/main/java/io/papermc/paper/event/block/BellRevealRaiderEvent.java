package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Raider;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

/**
 * Called when a {@link Raider} is revealed by a bell.
 *
 * @deprecated use {@link org.bukkit.event.block.BellResonateEvent}
 */
@Deprecated(since = "1.19.4")
@NullMarked
public class BellRevealRaiderEvent extends BlockEvent implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Raider raider;
    private boolean cancelled;

    @ApiStatus.Internal
    public BellRevealRaiderEvent(final Block bell, final Raider raider) {
        super(bell);
        this.raider = raider;
    }

    /**
     * Gets the raider that the bell revealed.
     *
     * @return The raider
     */
    public Raider getEntity() {
        return this.raider;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This does not cancel the particle effects shown on the bell, only the entity.
     */
    @Override
    public void setCancelled(final boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
