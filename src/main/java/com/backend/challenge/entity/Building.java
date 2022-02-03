package com.backend.challenge.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Building extends Base implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String code;
	private String name;
	
	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
	private List<Floor> floors;
}
