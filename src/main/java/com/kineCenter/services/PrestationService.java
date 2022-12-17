package com.kineCenter.services;

import java.util.List;

import com.kineCenter.entities.Prestation;

public interface PrestationService {
	Prestation savePrestation(Prestation p);
	Prestation updatePrestation(Prestation p);
	void deletePrestation(Prestation p);
	 void deletePrestationById(Long id);
	 Prestation getPrestation(Long id);
	List<Prestation> getAllPrestation();
	List<Prestation> findByCategPresta (String categ);

}
