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
@ApiModel(value = "ReservationInfoResource", description = "Reservation info")
public class ReservationInfoResource {
	
	@ApiModelProperty(value = "reservation id")
	private UUID id;
	
	@ApiModelProperty(value = "room")
	private RoomInfoResource room;
	
	@ApiModelProperty(value = "reserved start date")
	private LocalDateTime startDate;
	
	@ApiModelProperty(value = "time span")
	private Double timeSpan;
	
	@ApiModelProperty(value = "attendees number")
	private Integer attendeesNumber;
}
