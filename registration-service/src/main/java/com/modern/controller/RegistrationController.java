package com.modern.controller;

import com.modern.model.Registration;
import com.modern.repository.RegistrationRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration createRegistration(@RequestBody @Valid Registration registration){
        return registrationRepository.save(registration);
    }

    @GetMapping("/{ticketCode}")
    public Registration getRegistration(@PathVariable String ticketCode) {
        return registrationRepository.findRegistrationByTicketCode(ticketCode).orElseThrow(
                () -> new NoSuchElementException("Registration with ticket code: " + ticketCode));
    }
}
