package com.gc.financemanagement.controller;

import com.gc.financemanagement.dto.TicketDTO;
import com.gc.financemanagement.dto.UserDTO;
import com.gc.financemanagement.model.TicketModel;
import com.gc.financemanagement.model.UserModel;
import com.gc.financemanagement.service.TicketService;
import com.gc.financemanagement.service.UserService;
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
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketModel> saveTicket(@RequestBody @Valid TicketDTO ticketDTO){
        var ticketModel = new TicketModel();
        BeanUtils.copyProperties(ticketDTO, ticketModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.saveTickets(ticketModel));
    }

    @GetMapping
    public ResponseEntity<List<TicketModel>> getAllTickets(){
        List<TicketModel> tickets = this.ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Object> getOneTicket(@PathVariable(value = "ticketId") UUID ticketId){

        Optional<TicketModel> ticketModelOptional = ticketService.findByTicketId(ticketId);

        if (!ticketModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not  found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ticketModelOptional.get());
    }


    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Object> deleteTicket(@PathVariable(value = "ticketId") UUID ticketId){

        Optional<TicketModel> ticketModelOptional = ticketService.findByTicketId(ticketId);

        if (ticketModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not  found!");
        }
        ticketService.deleteTicket(ticketModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(ticketModelOptional.get());
    }
}
