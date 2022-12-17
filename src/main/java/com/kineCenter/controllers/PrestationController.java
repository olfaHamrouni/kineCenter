package com.kineCenter.controllers;



import java.text.ParseException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.kineCenter.entities.Prestation;
import com.kineCenter.services.PrestationService;

@Controller
public class PrestationController {

	@Autowired
	PrestationService prestationService;
	
	@RequestMapping("/showPrestation")
	public String showPrestation(ModelMap modelMap)
	{
	modelMap.addAttribute("prestation", new Prestation());
	return "createPrestation";
	}
	
	@RequestMapping("/savePrestation")
	public String savePrestation(@Valid Prestation prestation,  BindingResult bindingResult, ModelMap modelMap)
	{
	if (bindingResult.hasErrors()) return "createPrestation";

	prestationService.savePrestation(prestation);
	modelMap.addAttribute("msg", "Enregistrement prestation effectué avec succès");
	List<Prestation> prestas1 = prestationService.findByCategPresta("Soin de visage");
	modelMap.addAttribute("prestas1", prestas1);
	List<Prestation> prestas2 = prestationService.findByCategPresta("Cure d'amincissement");
	modelMap.addAttribute("prestas2", prestas2);
	List<Prestation> prestas3 = prestationService.findByCategPresta("Massages");
	modelMap.addAttribute("prestas3", prestas3);
	return "listePrestations";
	}
	
	@RequestMapping("/ListePrestations")
	public String ListePrestations(ModelMap modelMap)
	{
	List<Prestation> prestas1 = prestationService.findByCategPresta("Soin de visage");
	modelMap.addAttribute("prestas1", prestas1);
	List<Prestation> prestas2 = prestationService.findByCategPresta("Cure d'amincissement");
	modelMap.addAttribute("prestas2", prestas2);
	List<Prestation> prestas3 = prestationService.findByCategPresta("Massages");
	modelMap.addAttribute("prestas3", prestas3);
	return "listePrestations";
	}
	
	@RequestMapping("/supprimerPrestation")
	public String supprimerPrestation(@RequestParam("id") Long id,ModelMap modelMap)
	{
		prestationService.deletePrestationById(id);
		List<Prestation> prestas1 = prestationService.findByCategPresta("Soin de visage");
		modelMap.addAttribute("prestas1", prestas1);
		List<Prestation> prestas2 = prestationService.findByCategPresta("Cure d'amincissement");
		modelMap.addAttribute("prestas2", prestas2);
		List<Prestation> prestas3 = prestationService.findByCategPresta("Massages");
		modelMap.addAttribute("prestas3", prestas3);
		return "listePrestations";
	}
	
	@RequestMapping("/modifierPrestation")
	public String modifierPrestation(@RequestParam("id") Long id,ModelMap modelMap) throws ParseException
	{
		Prestation p= prestationService.getPrestation(id);
		modelMap.addAttribute("presta", p);
		return "editerPrestation";
	}
	
	
	@RequestMapping("updatePrestation")
	public String updatePrestation(@Valid Prestation presta, BindingResult bindingResult, ModelMap modelMap)
	{
	if (bindingResult.hasErrors()) return "editerPrestation";

	prestationService.updatePrestation(presta);
	List<Prestation> prestas1 = prestationService.findByCategPresta("Soin de visage");
	modelMap.addAttribute("prestas1", prestas1);
	List<Prestation> prestas2 = prestationService.findByCategPresta("Cure d'amincissement");
	modelMap.addAttribute("prestas2", prestas2);
	List<Prestation> prestas3 = prestationService.findByCategPresta("Massages");
	modelMap.addAttribute("prestas3", prestas3);
	return "listePrestations";
	}
}
