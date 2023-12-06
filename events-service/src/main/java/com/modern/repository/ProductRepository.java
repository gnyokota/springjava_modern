package com.modern.repository;

import com.modern.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {
}
