package com.backend.challenge.service;

import java.util.List;

import com.backend.challenge.api.resource.AvailableRoomResource;

public interface RoomService {

	List<AvailableRoomResource> getAvailableRooms(String buildingCode);

}
