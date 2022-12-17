package com.kineCenter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kineCenter.entities.Event;
import com.kineCenter.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	
	@Override
	public Event saveEvent(Event e) {
		return eventRepository.save(e);
	}

	@Override
	public Event updateEvent(Event e) {
		return eventRepository.save(e);
	}

	@Override
	public void deleteEvent(Event e) {
		 eventRepository.delete(e);
		
	}

	@Override
	public void deleteEventById(Long id) {
		eventRepository.deleteById(id);
		
	}

	@Override
	public Event getEvent(Long id) {
		return eventRepository.findById(id).get();
	}

	@Override
	public List<Event> getAllEvent() {
			//return eventRepository.findAll(Sort.by("dateEvent").descending());
		return eventRepository.findAll();
	}

}
