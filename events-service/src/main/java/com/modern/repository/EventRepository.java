package com.modern.repository;

import com.modern.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event,Integer> {
    public List<Event> findEventByOrganizerId(int organizerId);
}
