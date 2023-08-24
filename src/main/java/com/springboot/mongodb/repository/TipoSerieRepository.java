package com.springboot.mongodb.repository;

import com.springboot.mongodb.model.TipoSerie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoSerieRepository extends MongoRepository<TipoSerie, UUID> {
}
