/*
 * Copyright (C) JimiIT92 - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jimi, December 2017
 *
 */
package com.universeguard.event;

import com.universeguard.utils.LogUtils;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.block.CollideBlockEvent;
import org.spongepowered.api.event.block.NotifyNeighborBlockEvent;
import org.spongepowered.api.event.block.TickBlockEvent;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;
import org.spongepowered.api.event.entity.CollideEntityEvent;
import org.spongepowered.api.event.entity.ConstructEntityEvent;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.event.entity.TargetEntityEvent;
import org.spongepowered.api.event.network.ChannelRegistrationEvent;
import org.spongepowered.api.event.world.LoadWorldEvent;
import org.spongepowered.api.event.world.SaveWorldEvent;
import org.spongepowered.api.event.world.chunk.LoadChunkEvent;
import org.spongepowered.api.event.world.chunk.UnloadChunkEvent;
import org.spongepowered.api.text.format.TextColors;

/**
 * Debug class, used to log events
 * @author Jimi
 *
 */
public class EventListener {
	@Listener
	public void onEvent(Event event) {
		if(!(event instanceof LoadChunkEvent) && !(event instanceof LoadWorldEvent) &&
				!(event instanceof UnloadChunkEvent) && !(event instanceof SaveWorldEvent) &&
				!(event instanceof ChannelRegistrationEvent) && !(event instanceof CollideEntityEvent) && !(event instanceof CollideBlockEvent) && !(event instanceof ConstructEntityEvent) &&
				!(event instanceof ChangeBlockEvent.Pre) && !(event instanceof ChangeBlockEvent.Post) && !(event instanceof ChangeBlockEvent.Decay)
				&& !(event instanceof SpawnEntityEvent.ChunkLoad) && !(event instanceof ChangeBlockEvent.Modify)
				&& !(event instanceof ChangeBlockEvent.Place) && !(event instanceof SpawnEntityEvent.Spawner)
				&& !(event instanceof TickBlockEvent) && !(event instanceof TargetEntityEvent)
				&& !(event instanceof NotifyNeighborBlockEvent) && !(event instanceof ChangeDataHolderEvent.ValueChange)
				&& !(event.getClass().getSimpleName().startsWith("PlaySoundEvent")))
			LogUtils.print(TextColors.GREEN, event.getClass().getSimpleName(), "event listener");
	}
}
