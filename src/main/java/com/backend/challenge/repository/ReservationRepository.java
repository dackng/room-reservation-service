package com.backend.challenge.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.challenge.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, UUID>{
	
	@Query("SELECT r FROM Reservation r JOIN r.room ro "
			+ "WHERE r.startDate BETWEEN :startDate AND :endDate"
			+ " AND r.isActive = :isActive ")
	List<Reservation> findAllByStartDate(LocalDateTime startDate, LocalDateTime endDate, Boolean isActive);
}
