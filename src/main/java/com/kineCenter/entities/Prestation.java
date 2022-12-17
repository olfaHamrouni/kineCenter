package com.kineCenter.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prestation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPresta;
	
	@NotNull
	private String libellePresta;
	@NotNull
	private String dureePresta;
	@NotNull
	private int prixPresta;
	@NotNull
	private String categPresta;

}
