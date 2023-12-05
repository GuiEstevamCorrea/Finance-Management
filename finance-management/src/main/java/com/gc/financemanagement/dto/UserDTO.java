package com.gc.financemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserDTO(@NotBlank  String firstName, @NotBlank String lastName, @NotBlank String cpf, LocalDate birthDate, @NotNull Long password) {
}
