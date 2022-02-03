package com.backend.challenge.api.resource;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "ReservationRequest", description = "Reservation request to create")
public class ReservationRequest {

	@NotNull(message = "Start date must not be null")
	@ApiModelProperty(value = "start date")
	private String startDate;
	
	@NotNull(message = "Time span must not be null")
	@ApiModelProperty(value = "time span")
	private Double timeSpan;
	
	@NotNull(message = "Attendees number must not be null")
	@ApiModelProperty(value = "attendees number")
	private Integer attendeesNumber;
	
	@NotNull(message = "Multimedia feature must not be null")
	@ApiModelProperty(value = "boolean to know if the room has multimedia")
	private Boolean hasMultimedia;
	
	@NotNull(message = "Room code must not be null")
	@ApiModelProperty(value = "room code")
	private String roomCode;
}
