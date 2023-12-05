package com.gc.financemanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name ="TB_TICKETS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "ticketId")
public class TicketModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ticketId;
    private Long barCode;
    private Integer price;
    private LocalDate dueDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel userId;

}
