package com.backend.challenge.api.assembler;

import com.backend.challenge.api.resource.AvailableRoomResource;
import com.backend.challenge.entity.Room;

public class RoomAssembler {
	
	public static AvailableRoomResource toResource(Room room) {
		return AvailableRoomResource
                .builder()
                .code(room.getCode())
                .name(room.getName())
                .maximumAllocation(room.getMaximumAllocation())
                .hasMultimedia(room.getHasMultimedia())
                .cleanUpTime(room.getCleanUpTime())
                .build();
    } 
}
