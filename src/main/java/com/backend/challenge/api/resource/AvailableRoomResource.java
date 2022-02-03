package com.backend.challenge.api.resource;

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
@ApiModel(value = "AvailableRoomResource", description = "Available room")
public class AvailableRoomResource {
	
	@ApiModelProperty(value = "room code")
	private String code;
	
	@ApiModelProperty(value = "room name")
	private String name;
	
	@ApiModelProperty(value = "maximum allocation")
	private Integer maximumAllocation;
	
	@ApiModelProperty(value = "boolean to know if the room has multimedia")
	private Boolean hasMultimedia;
	
	@ApiModelProperty(value = "clean up time")
	private Integer cleanUpTime;
}
