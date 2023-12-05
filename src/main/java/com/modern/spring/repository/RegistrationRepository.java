package com.modern.spring.repository;

import com.modern.spring.model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RegistrationRepository extends MongoRepository<Registration, Integer> {

    public Optional<Registration> findRegistrationByTicketCode(String ticketCode);
}
