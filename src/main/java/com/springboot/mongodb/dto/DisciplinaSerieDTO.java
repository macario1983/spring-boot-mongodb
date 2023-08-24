package com.springboot.mongodb.dto;


import jakarta.validation.constraints.NotNull;

public record DisciplinaSerieDTO(
        String id,
        @NotNull(message = "{error.validation.field.required}")
        DisciplinaDTO disciplina,
        @NotNull(message = "{error.validation.field.required}")
        SerieDTO serie) {
}
