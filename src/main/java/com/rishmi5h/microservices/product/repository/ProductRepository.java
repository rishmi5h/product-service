package com.rishmi5h.microservices.product.repository;

import com.rishmi5h.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
