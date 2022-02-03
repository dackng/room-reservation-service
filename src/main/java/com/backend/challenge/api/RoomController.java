package com.backend.challenge.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.challenge.api.resource.AvailableRoomResource;
import com.backend.challenge.service.RoomService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/room")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET})
@RequiredArgsConstructor
@Api(tags = { "RoomController" }, value = "/api/v1/room", produces = "application/json")
public class RoomController {
	
	private final RoomService roomService;
	
	@GetMapping
	public ResponseEntity<List<AvailableRoomResource>> getAvailableRooms(
			@RequestParam(required = false) @Valid @NotNull String buildingCode){
		return ResponseEntity.ok(roomService.getAvailableRooms(buildingCode));
	}

}
