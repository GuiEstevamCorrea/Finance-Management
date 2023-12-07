package com.gc.financemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Size(min = 25, max = 30, message = "O número do cartão deve ter no minimo 25 e no máximo 30 números")
    @Column(name = "bar_Code")
    private Long barCode;

    @NotNull(message = "O preço não pode ser nulo")
    @Min(value = 0, message = "O preço não pode ser menor que 0")
    private Integer price;

    @Future(message = "A data de validade deve ser no futuro")
    @Column(name = "due_date")
    private LocalDate dueDate;

    @NotNull(message = "O usuário não pode ser nulo")
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel userId;

}
