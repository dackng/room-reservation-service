package com.backend.challenge.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.challenge.api.assembler.ReservationCreatedAssembler;
import com.backend.challenge.api.assembler.ReservationInfoAssembler;
import com.backend.challenge.api.resource.ReservationCreatedResource;
import com.backend.challenge.api.resource.ReservationInfoResource;
import com.backend.challenge.api.resource.ReservationRequest;
import com.backend.challenge.entity.Reservation;
import com.backend.challenge.entity.Room;
import com.backend.challenge.exception.RoomNotAvailableException;
import com.backend.challenge.repository.ReservationRepository;
import com.backend.challenge.repository.RoomRepository;
import com.backend.challenge.service.ReservationService;
import com.backend.challenge.util.AuditStatus;
import com.backend.challenge.util.RoomStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{

	final ReservationRepository reservationRepository;
	final RoomRepository roomRepository;
	
	@Transactional(readOnly = false)
	@Override
	public ReservationCreatedResource create(ReservationRequest request) {
		Room room = roomRepository.findRoom(RoomStatus.AVAILABLE, request.getRoomCode()
				, request.getHasMultimedia(), AuditStatus.ACTIVE.getValue())
				.orElseThrow(()-> new RoomNotAvailableException("No room available"));
		
		Reservation reservation = reservationRepository.save(ReservationCreatedAssembler.toEntity(request, room));
		room.setStatus(RoomStatus.RESERVED);
		
		return ReservationCreatedAssembler.toResource(reservation);
	}

	@Override
	public List<ReservationInfoResource> getReservations(LocalDate localDate) {
		return reservationRepository.findAllByStartDate(localDate.atStartOfDay(), localDate.plusDays(1).atStartOfDay()
				, AuditStatus.ACTIVE.getValue())
			.stream()
			.map(r -> ReservationInfoAssembler.toResource(r))
			.collect(Collectors.toList());
	}
}
