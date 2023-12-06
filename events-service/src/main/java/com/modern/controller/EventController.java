package com.modern.controller;


import com.modern.model.Event;
import com.modern.model.Organizer;
import com.modern.model.Product;
import com.modern.repository.EventRepository;
import com.modern.repository.OrganizerRepository;
import com.modern.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EventController {
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;

    public EventController(EventRepository eventRepository,
                           ProductRepository productRepository) {
        this.eventRepository = eventRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/event")
    public Event CreateEvents(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/event")
    public Event getEventByName(@RequestParam("name") String name) {
        return eventRepository.findEventByName(name).orElseThrow(
                () -> new NoSuchElementException("Event with name " + name + " not found!")
        );
    }

    @PostMapping("/products")
    public Product createProducts(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductByEventId(@PathVariable("id") String id) {
        return productRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Product with id " + id + " not found!")
        );
    }
}

