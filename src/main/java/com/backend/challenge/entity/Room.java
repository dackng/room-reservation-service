package com.backend.challenge.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.backend.challenge.util.RoomStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Room extends Base implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
	@Id
	private String id;
	private String code;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "floor_id")
	private Floor floor;
    private String name;
	private Integer maximumAllocation;
	
	@Enumerated(EnumType.STRING)
	private RoomStatus status;
	
	private Boolean hasMultimedia;
	private Integer cleanUpTime; //in minutes

}
