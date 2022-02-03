package com.backend.challenge.api;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.challenge.api.resource.ReservationCreatedResource;
import com.backend.challenge.api.resource.ReservationInfoResource;
import com.backend.challenge.api.resource.ReservationRequest;
import com.backend.challenge.service.ReservationService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET})
@RequiredArgsConstructor
@Api(tags = { "ReservationController" }, value = "/api/v1/reservation", produces = "application/json")
public class ReservationController {

	private final ReservationService reservationService;

	@PostMapping
	public ResponseEntity<ReservationCreatedResource> create(@Valid @RequestBody ReservationRequest request){
		return new ResponseEntity<>(reservationService.create(request), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ReservationInfoResource>> getReservations(
			@Valid @NotNull(message="Date is required") 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate date){
		return ResponseEntity.ok(reservationService.getReservations(date));
	}
}
