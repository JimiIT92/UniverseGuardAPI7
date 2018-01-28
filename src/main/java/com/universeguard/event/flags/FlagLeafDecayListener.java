/* 
 * Copyright (C) JimiIT92 - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jimi, December 2017
 * 
 */
package com.universeguard.event.flags;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import com.universeguard.region.enums.EnumRegionFlag;
import com.universeguard.region.enums.RegionEventType;
import com.universeguard.utils.RegionUtils;

/**
 * Handler for the leafdecay flag
 * @author Jimi
 *
 */
public class FlagLeafDecayListener {
	
	@Listener
	public void onLeafDecay(ChangeBlockEvent.Decay event) {
		if(!event.getTransactions().isEmpty()) {
			BlockSnapshot block = event.getTransactions().get(0).getOriginal();
			BlockType type = block.getState().getType();
			if(type.equals(BlockTypes.LEAVES) || type.equals(BlockTypes.LEAVES2))
				this.handleEvent(event, block.getLocation().get(), null);
		}
	}
	
	/*@Listener
	public void onLeafDrop(SpawnEntityEvent event, @Root BlockSpawnCause cause) {
		BlockType type = cause.getBlockSnapshot().getState().getType();
		if(cause.getType().equals(SpawnTypes.DROPPED_ITEM) && (type.equals(BlockTypes.LEAVES) || type.equals(BlockTypes.LEAVES2)))
			this.handleEvent(event, cause.getBlockSnapshot().getLocation().get(), null);
	}
*/
	private boolean handleEvent(Cancellable event, Location<World> location, Player player) {
		return RegionUtils.handleEvent(event, EnumRegionFlag.LEAF_DECAY, location, player, RegionEventType.GLOBAL);
	}
}
