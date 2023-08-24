package com.springboot.mongodb.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
@Document
@NoArgsConstructor
public class AlunoSerie {

    @Id
    private UUID id;

    @NotNull(message = "{error.validation.field.required}")
    private UUID alunoId;

    @NotNull(message = "{error.validation.field.required}")
    private UUID serieId;

    private LocalDateTime dataInsercao;

    private LocalDateTime dataAlteracao;

}
