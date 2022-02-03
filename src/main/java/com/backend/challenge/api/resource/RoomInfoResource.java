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
@ApiModel(value = "RoomInfoResource", description = "Room info resource")
public class RoomInfoResource {
	@ApiModelProperty(value = "code")
	private String code;
	@ApiModelProperty(value = "name")
	private String name;
}
