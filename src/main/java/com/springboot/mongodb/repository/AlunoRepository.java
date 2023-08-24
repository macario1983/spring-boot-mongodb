package com.springboot.mongodb.repository;

import com.springboot.mongodb.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, UUID> {
}
