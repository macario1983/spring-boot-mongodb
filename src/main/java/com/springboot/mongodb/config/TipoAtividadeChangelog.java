package com.springboot.mongodb.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.mongodb.model.TipoAtividade;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ChangeUnit(id = "tipo-atividade-changelog", order = "2")
public class TipoAtividadeChangelog {

    public static final String COLLECTION_NAME = "tipo_atividade";

    @Execution
    public void insertInitial(MongoTemplate mongoTemplate) {

        try {

            mongoTemplate.createCollection(COLLECTION_NAME);
            bulkInsert(mongoTemplate, convertToObject(getJsonContent()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getJsonContent() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("json/tipo_atividade.json");
        return StreamUtils.copyToString(classPathResource.getInputStream(), StandardCharsets.UTF_8);
    }

    private List<TipoAtividade> convertToObject(String json) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        return Arrays.stream(objectMapper.readValue(json, TipoAtividade[].class)).peek(tipoAtividade -> {
            tipoAtividade.setId(UUID.randomUUID());
            tipoAtividade.setDataInsercao(LocalDateTime.now());
            tipoAtividade.setDataAlteracao(LocalDateTime.now());
        }).toList();
    }

    private void bulkInsert(MongoTemplate mongoTemplate, List<TipoAtividade> dados) {
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.ORDERED, COLLECTION_NAME);
        bulkOperations.insert(dados);
        bulkOperations.execute();
    }

    @RollbackExecution
    public void rollback(MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection(COLLECTION_NAME);
    }

}
