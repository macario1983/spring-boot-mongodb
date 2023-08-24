package com.springboot.mongodb.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.mongodb.model.Aluno;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ChangeUnit(id = "aluno-changelog", order = "3")
public class AlunoChangelog {

    public static final String COLLECTION_NAME = "aluno";

    @Execution
    public void insertInitial(MongoTemplate mongoTemplate) {

        try {

            mongoTemplate.createCollection(COLLECTION_NAME);
            insertBatch(mongoTemplate, convertToObject(getJsonContent()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getJsonContent() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("json/aluno.json");
        return StreamUtils.copyToString(classPathResource.getInputStream(), StandardCharsets.UTF_8);
    }

    private List<Aluno> convertToObject(String json) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        return Arrays.stream(objectMapper.readValue(json, Aluno[].class)).peek(aluno -> {
            aluno.setId(UUID.randomUUID());
            aluno.setDataInsercao(LocalDateTime.now());
            aluno.setDataAlteracao(LocalDateTime.now());
        }).toList();
    }

    private void insertBatch(MongoTemplate mongoTemplate, List<Aluno> dados) {

        List<Aluno> batch = new ArrayList<>();

        for (int i = 0; i < dados.size(); i++) {
            batch.add(dados.get(i));
            if (i > 0 && i % batch.size() == 0) {
                bulkInsert(mongoTemplate, batch);
                batch.clear();
            }
        }

        if (!batch.isEmpty()) {
            bulkInsert(mongoTemplate, batch);
        }
    }

    private void bulkInsert(MongoTemplate mongoTemplate, List<Aluno> dados) {
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.ORDERED, COLLECTION_NAME);
        bulkOperations.insert(dados);
        bulkOperations.execute();
    }

    @RollbackExecution
    public void rollback(MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection(COLLECTION_NAME);
    }

}
