package com.backend.challenge.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.backend.challenge.api.assembler.RoomAssembler;
import com.backend.challenge.api.resource.AvailableRoomResource;
import com.backend.challenge.repository.RoomRepository;
import com.backend.challenge.service.RoomService;
import com.backend.challenge.util.RoomStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
	
	final RoomRepository roomRepository;

	@Override
	public List<AvailableRoomResource> getAvailableRooms(String buildingCode) {
		return roomRepository.findAllAvailableRooms(RoomStatus.AVAILABLE, buildingCode)
			.stream()
			.map(r -> RoomAssembler.toResource(r))
			.collect(Collectors.toList());
	}
	
	
}
