package com.modern.spring.controller;

import com.modern.spring.model.Event;
import com.modern.spring.model.Organizer;
import com.modern.spring.repository.EventRepository;
import com.modern.spring.repository.OrganizerRepository;
import com.modern.spring.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EventController {
    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;

    public EventController(OrganizerRepository organizerRepository,
                           EventRepository eventRepository,
                           ProductRepository productRepository) {
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
        this.productRepository = productRepository;
    }

    @RequestMapping("/organizers")
    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }

    @RequestMapping("/events/{organizerId}")
    public List<Event> getEventsByOrganizer(@PathVariable("organizerId") int organizerId) {
        return eventRepository.findEventByOrganizerId(organizerId);
    }

    @GetMapping("/events/{eventId}")
    public Event getEventById(@PathVariable("eventId") int eventId) {
        return eventRepository.findById(eventId).orElseThrow(
                () -> new NoSuchElementException("Event with id " + eventId + " not found!")
        );
    }
}

