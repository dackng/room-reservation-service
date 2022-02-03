package com.backend.challenge.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Floor extends Base implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private UUID id;
	private String code;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "building_id")
	private Building building;
	
	private String name;
	
	@OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
	private List<Room> rooms;
}
