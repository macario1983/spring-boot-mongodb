package com.springboot.mongodb.repository;

import com.springboot.mongodb.model.TipoAtividade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoAtividadeRepository extends MongoRepository<TipoAtividade, UUID> {
}
