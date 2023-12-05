package com.modern.spring.repository;

import com.modern.spring.model.Venue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends MongoRepository<Venue,Integer> {
}
