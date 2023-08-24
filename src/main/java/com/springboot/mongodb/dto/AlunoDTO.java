package com.springboot.mongodb.dto;


import jakarta.validation.constraints.*;

public record AlunoDTO(String id,
                       @NotBlank(message = "{error.validation.field.required}")
                       String nome,
                       @Positive
                       @Min(value = 3, message = "{error.validation.field.min}")
                       @Max(value = 17, message = "{error.validation.field.max}")
                       @NotNull(message = "{error.validation.field.required}")
                       int idade,
                       @Email(message = "{error.validation.field.email}")
                       String email,
                       @NotBlank(message = "{error.validation.field.required}")
                       @Pattern(regexp = "^(M|F)$", message = "{error.validation.field.sexo}")
                       String sexo) {
}
