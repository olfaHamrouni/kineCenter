package com.kineCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kineCenter.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
