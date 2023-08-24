package com.springboot.mongodb.model;

import jakarta.validation.constraints.*;
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
public class Serie {

    @Id
    private UUID id;

    @NotBlank(message = "{error.validation.field.required}")
    private String nome;

    @Positive
    @Min(value = 3, message = "{error.validation.field.min}")
    @Max(value = 17, message = "{error.validation.field.max}")
    @NotNull(message = "{error.validation.field.required}")
    private int idade;

    @NotNull(message = "{error.validation.field.required}")
    private UUID tipoSerieId;

    private LocalDateTime dataInsercao;

    private LocalDateTime dataAlteracao;

}

