package com.kineCenter.controllers;




import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kineCenter.entities.Event;
import com.kineCenter.services.EventService;

@Controller
public class EventController {

	@Autowired
	EventService eventService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("event", new Event());
	return "createEvent";
	}
	
	@RequestMapping("/ListeEvents")
	public String listeEvents(ModelMap modelMap)
	{
	List<Event> evts = eventService.getAllEvent();
	modelMap.addAttribute("events", evts);
	return "listeEvents";
	}
	
	@RequestMapping("/saveEvent")
	public String saveEvent(@Valid Event event,  BindingResult bindingResult, ModelMap modelMap)
	{
	if (bindingResult.hasErrors()) return "createEvent";

	eventService.saveEvent(event);
	modelMap.addAttribute("msg", "Enregistrement évènement effectué avec succès");
	List<Event> evts = eventService.getAllEvent();
	modelMap.addAttribute("events", evts);
	return "listeEvents";
	}

	
	
	@RequestMapping("/supprimerEvent")
	public String supprimerEvent(@RequestParam("id") Long id,ModelMap modelMap)
	{
	eventService.deleteEventById(id);
	List<Event> evts = eventService.getAllEvent();
	modelMap.addAttribute("events", evts);
	return "listeEvents";
	}
	
	@RequestMapping("/modifierEvent")
	public String modifierEvent(@RequestParam("id") Long id,ModelMap modelMap) throws ParseException
	{
	Event e= eventService.getEvent(id);
	modelMap.addAttribute("evt", e);
	modelMap.addAttribute("localDate", LocalDate.now());
	//SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
	 //Date dateEvent = dateformat.format(e.getDateEvent());
	 
	 //e.setDateEvent(e.getDateEvent());
	 
		
	return "editerEvent";
	}
	
	
	@RequestMapping("updateEvent")
	public String updateEvent(@Valid Event evt, BindingResult bindingResult, ModelMap modelMap)
	{
	if (bindingResult.hasErrors()) return "editerEvent";

	eventService.updateEvent(evt);
	List<Event> evts = eventService.getAllEvent();
	modelMap.addAttribute("events", evts);
	return "listeEvents";
	}
	
	
}
