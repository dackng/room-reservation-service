package com.backend.challenge.service;

import java.time.LocalDate;
import java.util.List;

import com.backend.challenge.api.resource.ReservationCreatedResource;
import com.backend.challenge.api.resource.ReservationInfoResource;
import com.backend.challenge.api.resource.ReservationRequest;

public interface ReservationService {

	ReservationCreatedResource create(ReservationRequest request);

	List<ReservationInfoResource> getReservations(LocalDate date);
}
