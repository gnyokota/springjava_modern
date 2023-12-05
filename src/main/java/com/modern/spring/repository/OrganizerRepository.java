package com.modern.spring.repository;

import com.modern.spring.model.Organizer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends MongoRepository<Organizer,Integer> {
}
