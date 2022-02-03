package com.backend.challenge.api.resource;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "ReservationCreatedResource", description = "Reservation created")
public class ReservationCreatedResource {

	@ApiModelProperty(value = "reservation id")
	private UUID id;
	
	@ApiModelProperty(value = "start date")
	private LocalDateTime startDate;
	
	@ApiModelProperty(value = "time span")
	private Double timeSpan;
	
	@ApiModelProperty(value = "attendees number")
	private Integer attendeesNumber;
}
