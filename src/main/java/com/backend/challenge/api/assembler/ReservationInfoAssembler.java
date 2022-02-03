package com.backend.challenge.api.assembler;

import com.backend.challenge.api.resource.ReservationInfoResource;
import com.backend.challenge.api.resource.RoomInfoResource;
import com.backend.challenge.entity.Reservation;
import com.backend.challenge.entity.Room;

public class ReservationInfoAssembler {
	
	public static ReservationInfoResource toResource(Reservation reservation) {
		return ReservationInfoResource
                .builder()
                .id(reservation.getId())
                .room(toResource(reservation.getRoom()))
                .startDate(reservation.getStartDate())
                .timeSpan(reservation.getTimeSpan())
                .attendeesNumber(reservation.getAttendeesNumber())
                .build();
    }
	
	public static RoomInfoResource toResource(Room room) {
		return RoomInfoResource
                .builder()
                .code(room.getCode())
                .name(room.getName())
                .build();
    }
}
