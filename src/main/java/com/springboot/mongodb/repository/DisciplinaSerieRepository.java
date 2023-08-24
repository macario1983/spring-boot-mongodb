package com.springboot.mongodb.repository;

import com.springboot.mongodb.model.DisciplinaSerie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DisciplinaSerieRepository extends MongoRepository<DisciplinaSerie, UUID> {
}
