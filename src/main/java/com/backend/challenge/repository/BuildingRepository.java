package com.backend.challenge.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.backend.challenge.entity.Building;

public interface BuildingRepository extends CrudRepository<Building, UUID>{
	
	
	List<Building> findAll();
}
