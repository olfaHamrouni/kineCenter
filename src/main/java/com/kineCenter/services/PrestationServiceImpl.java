package com.kineCenter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kineCenter.entities.Prestation;

import com.kineCenter.repository.PrestationRepository;

@Service
public class PrestationServiceImpl implements PrestationService {
	
	@Autowired
	private PrestationRepository prestaRepository;

	@Override
	public Prestation savePrestation(Prestation p) {
		return prestaRepository.save(p);
	}

	@Override
	public Prestation updatePrestation(Prestation p) {
		return prestaRepository.save(p);
	}

	@Override
	public void deletePrestation(Prestation p) {
		prestaRepository.delete(p);
		
	}

	@Override
	public void deletePrestationById(Long id) {
		prestaRepository.deleteById(id);

		
	}

	@Override
	public Prestation getPrestation(Long id) {
		return prestaRepository.findById(id).get();
	}

	@Override
	public List<Prestation> getAllPrestation() {
		return prestaRepository.findAll();
	}

	@Override
	public List<Prestation> findByCategPresta (String categ)
	{return prestaRepository.findByCategPresta(categ);}
}
