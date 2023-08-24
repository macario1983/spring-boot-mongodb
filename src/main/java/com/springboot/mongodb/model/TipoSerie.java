package com.springboot.mongodb.model;

import jakarta.validation.constraints.NotBlank;
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
public class TipoSerie {

    @Id
    private UUID id;

    @NotBlank(message = "{error.validation.field.required}")
    private String nome;

    private LocalDateTime dataInsercao;

    private LocalDateTime dataAlteracao;

}
