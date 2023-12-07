package com.gc.financemanagement.repository;

import com.gc.financemanagement.model.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel, UUID> {
    boolean existsByBarCode(String barCode);
}
