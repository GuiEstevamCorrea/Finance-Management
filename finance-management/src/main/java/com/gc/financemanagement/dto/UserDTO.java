package com.gc.financemanagement.dto;

import com.gc.financemanagement.model.CardModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record UserDTO(@NotBlank  String firstName, @NotBlank String lastName, @NotBlank String cpf, LocalDate birthDate, @NotBlank String password, List<CardModel> cards) {
}
