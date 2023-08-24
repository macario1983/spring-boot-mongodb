package com.springboot.mongodb.repository;

import com.springboot.mongodb.model.Disciplina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DisciplinaRepository extends MongoRepository<Disciplina, UUID> {
}
