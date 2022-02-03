package com.backend.challenge.util;

import java.util.ArrayList;
import java.util.List;

import com.backend.challenge.api.resource.AvailableRoomResource;
import com.backend.challenge.entity.Room;

public class RoomTestMockUtil {
	
	public static List<AvailableRoomResource> getAvailableRoomsResourceMock() {
		List<AvailableRoomResource> rooms = new ArrayList<>();
		rooms.add(AvailableRoomResource.builder()
				.code("R003")
				.name("ROOM 3")
				.maximumAllocation(200)
				.hasMultimedia(true)
				.cleanUpTime(205)
				.build());
		return rooms;
	}
	
	public static List<Room> getAvailableRoomsMock() {
		List<Room> rooms = new ArrayList<>();
		rooms.add(getRoomMock());
		return rooms;
	}
	
	public static Room getRoomMock() {
		return Room.builder()
				.code("R003")
				.name("ROOM 3")
				.maximumAllocation(200)
				.hasMultimedia(true)
				.cleanUpTime(205)
				.build();
	}
}
