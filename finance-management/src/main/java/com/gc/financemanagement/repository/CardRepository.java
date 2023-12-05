package com.gc.financemanagement.repository;

import com.gc.financemanagement.model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<CardModel, UUID> {
    boolean existsByCardNumber(Long cardNumber);
}
