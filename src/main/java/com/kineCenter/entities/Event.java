package com.kineCenter.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

//import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvent;
	
	@NotNull
	@Size (min = 4,max = 50)
	private String nomEvent;
	
	private String descEvent;
	
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date dateEvent;
	
	@NotNull
	private String lieuEvent;
	
	//Constructeurs
	
	public Event() {
		super();
	}
	
	public Event(String nomEvent, String descEvent, Date dateEvent, String lieuEvent) {
		super();
		this.nomEvent = nomEvent;
		this.descEvent = descEvent;
		this.dateEvent = dateEvent;
		this.lieuEvent = lieuEvent;
	} 
	
	//getters and setters
	public Long getIdEvent() {
		return idEvent;
	}
	
	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}
	public String getNomEvent() {
		return nomEvent;
	}
	public void setNomEvent(String nomEvent) {
		this.nomEvent = nomEvent;
	}
	public String getDescEvent() {
		return descEvent;
	}
	public void setDescEvent(String descEvent) {
		this.descEvent = descEvent;
	}
	public Date getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
	public String getLieuEvent() {
		return lieuEvent;
	}
	public void setLieuEvent(String lieuEvent) {
		this.lieuEvent = lieuEvent;
	}

	//toString
	@Override
	public String toString() {
		return "event [idEvent=" + idEvent + ", nomEvent=" + nomEvent + ", descEvent=" + descEvent + ", dateEvent="
				+ dateEvent + ", lieuEvent=" + lieuEvent + "]";
	}
	
}
