package com.gc.financemanagement.dto;

import com.gc.financemanagement.model.UserModel;

import java.time.LocalDate;

public record TicketDTO(String barCode, Integer price, LocalDate dueDate, UserModel userId) {
}
