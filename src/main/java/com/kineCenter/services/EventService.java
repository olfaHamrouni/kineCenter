package com.kineCenter.services;

import java.util.List;

import com.kineCenter.entities.Event;


public interface EventService {

	Event saveEvent(Event e);
	Event updateEvent(Event e);
	void deleteEvent(Event e);
	 void deleteEventById(Long id);
	 Event getEvent(Long id);
	List<Event> getAllEvent();
	
}
