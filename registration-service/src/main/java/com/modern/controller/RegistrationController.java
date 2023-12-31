package com.modern.controller;

import com.modern.client.EventsClient;
import com.modern.model.Event;
import com.modern.model.Product;
import com.modern.model.Registration;
import com.modern.repository.RegistrationRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final WebClient webClient;

    private final EventsClient eventsClient;
    private final RegistrationRepository registrationRepository;

    public RegistrationController(WebClient webClient, EventsClient eventsClient, RegistrationRepository registrationRepository) {
        this.webClient = webClient;
        this.eventsClient = eventsClient;
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration createRegistration(@RequestBody Registration registration) {
        Product product = webClient.get()
                .uri("/products/{id}", registration.productId())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> {
                    throw new NoSuchElementException(response.toString());
                })
                .bodyToMono(Product.class)
                .block();


                Event event = eventsClient.getEventByName(product.name());

                return registrationRepository.save(new Registration(
                        null, registration.productId(), event.name(), product.price(),
                        UUID.randomUUID().toString(), registration.attendeeName()
                ));
    }

    @GetMapping("/{ticketCode}")
    public Registration getRegistration(@PathVariable String ticketCode) {
        return registrationRepository.findRegistrationByTicketCode(ticketCode).orElseThrow(
                () -> new NoSuchElementException("Registration with ticket code: " + ticketCode));
    }
}
