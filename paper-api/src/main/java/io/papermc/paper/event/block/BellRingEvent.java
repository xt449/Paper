package io.papermc.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Called when a bell is rung.
 *
 * @deprecated use {@link org.bukkit.event.block.BellRingEvent}
 */
@Deprecated(since = "1.19.4")
@NullMarked
public class BellRingEvent extends org.bukkit.event.block.BellRingEvent {

    @ApiStatus.Internal
    public BellRingEvent(final Block block, final BlockFace direction, final @Nullable Entity entity) {
        super(block, direction, entity);
    }
}
