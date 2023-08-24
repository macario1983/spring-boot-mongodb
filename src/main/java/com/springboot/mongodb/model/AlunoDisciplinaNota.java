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
public class AlunoDisciplinaNota {

    @Id
    private UUID id;

    @NotNull(message = "{error.validation.field.required}")
    private UUID alunoSerieId;

    @NotNull(message = "{error.validation.field.required}")
    private UUID disciplinaSerieId;

    @NotNull(message = "{error.validation.field.required}")
    @DecimalMin(value = "0.0", inclusive = true, message = "{error.validation.field.min}")
    @DecimalMax(value = "10.0", inclusive = true, message = "{error.validation.field.max}")
    private Double nota;

    @Positive
    @NotNull(message = "{error.validation.field.required}")
    @Min(value = 1, message = "{error.validation.field.min}")
    @Max(value = 4, message = "{error.validation.field.max}")
    private int periodo;

    @NotBlank(message = "{error.validation.field.required}")
    private String descricao;

    private LocalDateTime dataInsercao;

    private LocalDateTime dataAlteracao;

}
