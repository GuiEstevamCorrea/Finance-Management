package com.gc.financemanagement.service;

import com.gc.financemanagement.model.CardModel;
import com.gc.financemanagement.repository.CardRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public CardModel saveCard(@NotNull CardModel cardModel) {
        if (cardRepository.existsByCardNumber(cardModel.getCardNumber())) {
            throw new RuntimeException("There is already a registered user with the same card number");
        }
        cardModel = cardRepository.save(cardModel);
        return cardModel;
    }

    public List<CardModel> getAllCards() {
        return this.cardRepository.findAll();
    }

    public Optional<CardModel> findByCardId(UUID cardId) {
        return this.cardRepository.findById(cardId);
    }

    public void deleteCard(CardModel cardModel) {
        cardRepository.delete(cardModel);
    }
}
