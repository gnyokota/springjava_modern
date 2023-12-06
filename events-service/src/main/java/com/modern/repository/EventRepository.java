package com.modern.repository;

import com.modern.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends MongoRepository<Event,String> {
    Optional<Event> findEventByName(String name);
}
