package com.modern.repository;


import com.modern.model.Organizer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface OrganizerRepository extends MongoRepository<Organizer,String> {
}
