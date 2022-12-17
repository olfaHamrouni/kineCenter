package com.kineCenter.controllers;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kineCenter.entities.Produit;

import com.kineCenter.services.ProduitService;


@Controller
public class ProduitController {

	
	@Autowired
	ProduitService produitService;
	
	
	
	@RequestMapping("/showProduit")
	public String showProduit(ModelMap modelMap)
	{
	modelMap.addAttribute("produit", new Produit());
	return "createProduit";
	}
	
	
	
	@RequestMapping("/saveProduit")
	public String saveProduit(@Valid Produit produit,  BindingResult bindingResult, ModelMap modelMap,
			@RequestParam(name="picture") MultipartFile file) throws IllegalStateException, IOException
	{
		
	if (bindingResult.hasErrors()) return "createProduit";
	if (!file.isEmpty()) {
				
				produit.setPhotoProduit(file.getOriginalFilename());
				produitService.saveProduit(produit);
				file.transferTo(new File(System.getProperty("user.home")+"/produits/"+produit.getIdProduit()+
						file.getOriginalFilename()));
	}
	else 
	{modelMap.addAttribute("msg", "Photo obligatoire");
		return "createProduit";
	}
	
	modelMap.addAttribute("msg", "Ajout effectué avec succès");
	return "createProduit";
	
	}
	
	@RequestMapping("/listeProduits")
	public String listeProduits(ModelMap modelMap)
	{
	List<Produit> prods = produitService.getAllProduit();
	modelMap.addAttribute("prods", prods);
	return "listeProduits";
	}
	
	@RequestMapping("/getPhoto")
	@ResponseBody
	public byte[] getPhoto(String NP, Long id) throws FileNotFoundException, IOException
	{
		File f = new File(System.getProperty("user.home")+"/produits/"+id+NP);
		return IOUtils.toByteArray(new FileInputStream(f));
		
		
	}
	
	
	
	
	@RequestMapping("/supprimerProduit")
	public String supprimerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	produitService.deleteProduitById(id);
	List<Produit> prods = produitService.getAllProduit();
	modelMap.addAttribute("prods", prods);
	return "listeProduits";
	}
	
	@RequestMapping("/changerEtatProduit")
	public String changerEtatProduit(@RequestParam("id") Long id, @RequestParam("e") boolean e, ModelMap modelMap)
	{
		boolean ee = !e;
			Produit produit = produitService.getProduit(id);
			produit.setEtatProduit(ee);
			produitService.saveProduit(produit);
				
	List<Produit> prods = produitService.getAllProduit();
	modelMap.addAttribute("prods", prods);
	return "listeProduits";
	}
	
	@RequestMapping("/modifierProduit")
	public String modifierProduit(@RequestParam("id") Long id,ModelMap modelMap) throws ParseException
	{
	Produit prod = produitService.getProduit(id);
	modelMap.addAttribute("prod", prod);
	return "editProduit";
	}
	
	@RequestMapping("/updateProduit")
	public String updateProduit(@Valid Produit prod,  BindingResult bindingResult, ModelMap modelMap,
			@RequestParam(name="nf") String nf, @RequestParam(name="picture") MultipartFile file) throws IllegalStateException, IOException
	{
		
		if (bindingResult.hasErrors()) return "editProduit";
		
		if (!file.isEmpty()) {
					
					prod.setPhotoProduit(file.getOriginalFilename());
					produitService.saveProduit(prod);
					file.transferTo(new File(System.getProperty("user.home")+"/produits/"+prod.getIdProduit()+
							file.getOriginalFilename()));
					
		}
		else
		{
			prod.setPhotoProduit(nf);
		produitService.saveProduit(prod);
		}
		
		List<Produit> prods = produitService.getAllProduit();
		modelMap.addAttribute("prods", prods);
		return "listeProduits";
	
	}
	
	
	/*
	@RequestMapping("/modifier")
	public String modifier(@RequestParam("id") Long id, @RequestParam("lib") String lib, ModelMap modelMap) 
	{
		Produit prod1 = produitService.getProduit(id);
		prod1.setLibelleProduit(lib);
		produitService.saveProduit(prod1);
		List<Produit> prods = produitService.getAllProduit();
		modelMap.addAttribute("prods", prods);
		return "listeProduits";
	}
	
	
	@RequestMapping("updateProduit")
	public String updateProduit(@Valid Produit prod, BindingResult bindingResult, ModelMap modelMap,
			@RequestParam(name="picture") MultipartFile file) throws IllegalStateException, IOException
	{
	if (bindingResult.hasErrors()) return "editProduit";
	Produit p1 = produitService.getProduit(prod.getIdProduit());
	p1.setLibelleProduit(prod.getLibelleProduit());
	p1.setPrixProduit(prod.getPrixProduit());
	p1.setQteStock(prod.getQteStock());
	p1.setEtatProduit(prod.getEtatProduit());
	
	if (!file.isEmpty()) {
		p1.setPhotoProduit(file.getOriginalFilename());
		produitService.saveProduit(prod);
		file.transferTo(new File(System.getProperty("user.home")+"/produits/"+prod.getIdProduit()+"2"+
				file.getOriginalFilename()));
	}
	else 
			return "editProduit";
	
	produitService.saveProduit(p1);
	List<Produit> prods = produitService.getAllProduit();
	modelMap.addAttribute("prods", prods);
	return "listeProduit";
	}
	
	*/
	
}