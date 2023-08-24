package com.springboot.mongodb.repository;

import com.springboot.mongodb.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SerieRepository extends MongoRepository<Serie, UUID> {
}
