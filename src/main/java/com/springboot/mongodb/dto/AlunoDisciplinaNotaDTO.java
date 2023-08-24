package com.springboot.mongodb.dto;


import jakarta.validation.constraints.*;

public record AlunoDisciplinaNotaDTO(
        String id,
        @NotNull(message = "{error.validation.field.required}")
        AlunoSerieDTO alunoSerie,
        @NotNull(message = "{error.validation.field.required}")
        DisciplinaSerieDTO disciplinaSerie,
        @NotNull(message = "{error.validation.field.required}")
        @DecimalMin(value = "0.0", inclusive = true, message = "{error.validation.field.min}")
        @DecimalMax(value = "10.0", inclusive = true, message = "{error.validation.field.max}")
        Double nota,
        @Positive
        @NotNull(message = "{error.validation.field.required}")
        @Min(value = 1, message = "{error.validation.field.min}")
        @Max(value = 4, message = "{error.validation.field.max}")
        int periodo,
        @NotBlank(message = "{error.validation.field.required}")
        String descricao) {
}
