package com.gc.financemanagement.service;

import com.gc.financemanagement.model.TicketModel;
import com.gc.financemanagement.model.UserModel;
import com.gc.financemanagement.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Transactional
    public TicketModel saveTickets(@NotNull TicketModel ticketModel) {
        if (ticketRepository.existsByBarCode(ticketModel.getBarCode())) {
            throw new RuntimeException("There is already a registered user with the same CPF");
        }
        ticketModel = ticketRepository.save(ticketModel);
        return ticketModel;
    }

    public List<TicketModel> getAllTickets() {
        return this.ticketRepository.findAll();
    }

    public Optional<TicketModel> findByTicketId(UUID ticketId){
        return ticketRepository.findById(ticketId);
    }

    @Transactional
    public void deleteTicket(TicketModel ticketModel) {
        ticketRepository.delete(ticketModel);
    }
}
