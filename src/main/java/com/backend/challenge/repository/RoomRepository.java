package com.backend.challenge.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.challenge.entity.Room;
import com.backend.challenge.util.RoomStatus;

public interface RoomRepository extends CrudRepository<Room, UUID> {

	@Query("SELECT r FROM Room r JOIN r.floor f "
			+ " WHERE r.status = :status "
			+ " AND ( :buildingCode IS NULL OR f.building.code = :buildingCode )"
			+ " ORDER BY r.maximumAllocation DESC")
	List<Room> findAllAvailableRooms(RoomStatus status, String buildingCode);
	
	@Query("SELECT r FROM Room r "
			+ " WHERE r.status = :status AND r.code = :code "
			+ " AND r.hasMultimedia = :hasMultimedia "
			+ " AND r.isActive = :isActive ")
	Optional<Room> findRoom(RoomStatus status, String code, Boolean hasMultimedia, Boolean isActive);
	
}
