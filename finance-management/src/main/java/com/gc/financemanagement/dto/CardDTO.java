package com.gc.financemanagement.dto;

import com.gc.financemanagement.enums.CardType;
import com.gc.financemanagement.model.UserModel;

import java.time.LocalDate;

public record CardDTO(Long cardNumber, String cvv, LocalDate validDate, CardType cardType, Integer price, UserModel userId){
}
