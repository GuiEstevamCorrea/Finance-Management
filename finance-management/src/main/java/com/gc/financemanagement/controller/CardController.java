package com.gc.financemanagement.controller;

import com.gc.financemanagement.dto.CardDTO;
import com.gc.financemanagement.dto.TicketDTO;
import com.gc.financemanagement.model.CardModel;
import com.gc.financemanagement.model.TicketModel;
import com.gc.financemanagement.service.CardService;
import com.gc.financemanagement.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping
    public ResponseEntity<CardModel> saveCard(@RequestBody @Valid CardDTO cardDTO){
        var cardModel = new CardModel();
        BeanUtils.copyProperties(cardDTO, cardModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.saveCard(cardModel));
    }

    @GetMapping
    public ResponseEntity<List<CardModel>> getAllCards(){
        List<CardModel> cards = this.cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<Object> getOneCard(@PathVariable(value = "cardId") UUID cardId){

        Optional<CardModel> cardModelOptional = cardService.findByCardId(cardId);

        if (!cardModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not  found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cardModelOptional.get());
    }


    @DeleteMapping("/{cardId}")
    public ResponseEntity<Object> deleteCard(@PathVariable(value = "cardId") UUID cardId){

        Optional<CardModel> cardModelOptional = cardService.findByCardId(cardId);

        if (cardModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not  found!");
        }
        cardService.deleteCard(cardModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(cardModelOptional.get());
    }
}
