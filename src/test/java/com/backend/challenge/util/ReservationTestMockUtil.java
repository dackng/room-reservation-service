package com.backend.challenge.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.backend.challenge.api.resource.ReservationCreatedResource;
import com.backend.challenge.api.resource.ReservationInfoResource;
import com.backend.challenge.api.resource.ReservationRequest;
import com.backend.challenge.api.resource.RoomInfoResource;
import com.backend.challenge.entity.Reservation;

public class ReservationTestMockUtil {

	public static List<ReservationInfoResource> getReservationsResourceMock() {
		List<ReservationInfoResource> reservations = new ArrayList<>();
		reservations.add(ReservationInfoResource.builder()
				.id(UUID.fromString("41626e9a-7ca4-4208-943f-75b54f4cfa36"))
				.startDate(DateTimeUtil.convert("2022-02-02 23:00:00"))
				.timeSpan(5.6)
				.attendeesNumber(200)
				.room(getRoomInfoResourceMock())
				.build());
		return reservations;
	}
	
	private static RoomInfoResource getRoomInfoResourceMock() {
		 return RoomInfoResource.builder()
				 .code("R003")
				 .name("ROOM 3")
				 .build();
	}
	
	public static ReservationRequest getReservationRequestMock() {
		return ReservationRequest.builder()
				.startDate("2022-02-02 23:00:00")
				.timeSpan(5.6)
				.attendeesNumber(200)
				.hasMultimedia(true)
				.roomCode("R003")
				.build();
	}
	
	public static ReservationCreatedResource getReservationCreatedResourceMock() {
		return ReservationCreatedResource.builder()
				.id(UUID.fromString("41626e9a-7ca4-4208-943f-75b54f4cfa36"))
				.startDate(DateTimeUtil.convert("2022-02-02 23:00:00"))
				.timeSpan(5.6)
				.attendeesNumber(200)
				.build();
	}
	
	public static Reservation getReservationMock() {
		return Reservation.builder()
				.id(UUID.fromString("41626e9a-7ca4-4208-943f-75b54f4cfa36"))
				.startDate(DateTimeUtil.convert("2022-02-02 23:00:00"))
				.timeSpan(5.6)
				.attendeesNumber(200)
				.build();
	}
	
	public static Reservation getReservationWithRoomMock() {
		return Reservation.builder()
				.id(UUID.fromString("41626e9a-7ca4-4208-943f-75b54f4cfa36"))
				.startDate(DateTimeUtil.convert("2022-02-02 23:00:00"))
				.timeSpan(5.6)
				.attendeesNumber(200)
				.room(RoomTestMockUtil.getRoomMock())
				.build();
	}
	
	public static List<Reservation> getReservationsMock(){
		List<Reservation> reservations = new ArrayList<>();
		reservations.add(getReservationWithRoomMock());
		return reservations;
	}
}
