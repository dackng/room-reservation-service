package com.backend.challenge.api.assembler;


import java.util.UUID;

import com.backend.challenge.api.resource.ReservationRequest;
import com.backend.challenge.api.resource.ReservationCreatedResource;
import com.backend.challenge.entity.Reservation;
import com.backend.challenge.entity.Room;
import com.backend.challenge.util.DateTimeUtil;

public class ReservationCreatedAssembler {
		
	public static Reservation toEntity(ReservationRequest request, Room room) {
		return Reservation
                .builder()
                .id(UUID.randomUUID())
                .room(room)
                .startDate(DateTimeUtil.convert(request.getStartDate()))
                .timeSpan(request.getTimeSpan())
                .attendeesNumber(request.getAttendeesNumber())
                .build();
    }
	
	public static ReservationCreatedResource toResource(Reservation reservation) {
		return ReservationCreatedResource
                .builder()
                .id(reservation.getId())
                .startDate(reservation.getStartDate())
                .timeSpan(reservation.getTimeSpan())
                .attendeesNumber(reservation.getAttendeesNumber())
                .build();
    } 
}
