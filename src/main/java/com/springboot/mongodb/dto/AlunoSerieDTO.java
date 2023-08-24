package com.springboot.mongodb.dto;


import jakarta.validation.constraints.NotNull;

public record AlunoSerieDTO(
        String id,
        @NotNull(message = "{error.validation.field.required}")
        AlunoDTO aluno,
        @NotNull(message = "{error.validation.field.required}")
        SerieDTO serie) {
}
