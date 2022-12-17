package com.kineCenter.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

//import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	
	@NotNull
	@Size (min = 4,max = 50)
	private String libelleProduit;
	
	@NotNull
	private int prixProduit;
	
	@NotNull
	private int qteStock;
	@Size(min=5)
	private String photoProduit;
	
	private Boolean etatProduit;
	
	
	
	
	
}
