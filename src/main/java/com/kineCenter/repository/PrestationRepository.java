package com.kineCenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kineCenter.entities.Prestation;


public interface PrestationRepository extends JpaRepository<Prestation, Long> {
	
	List<Prestation> findByCategPresta (String categ);

}
