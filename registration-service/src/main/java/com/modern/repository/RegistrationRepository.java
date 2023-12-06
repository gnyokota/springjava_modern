package com.modern.repository;

import com.modern.model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

;import java.util.Optional;

public interface RegistrationRepository extends MongoRepository<Registration, Integer> {

    public Optional<Registration> findRegistrationByTicketCode(String ticketCode);
}
