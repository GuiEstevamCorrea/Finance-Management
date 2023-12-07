package com.gc.financemanagement.model;

import com.gc.financemanagement.enums.CardType;
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
@Table(name ="TB_CARDS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cardId")
public class CardModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID cardId;

    @Size(min = 16, max = 16, message = "O número do cartão deve ter exatamente 16 caracteres")
    @Column(name = "card_number")
    private Long cardNumber;

    @Size(min = 3, max = 3, message = "O CVV deve ter exatamente 3 caracteres")
    private String cvv;

    @Future(message = "A data de validade deve ser no futuro")
    @Column(name = "valid_date")
    private LocalDate validDate;

    @NotNull(message = "O tipo do cartão não pode ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    @NotNull(message = "O preço não pode ser nulo")
    @Min(value = 0, message = "O preço não pode ser menor que 0")
    private Integer price;

    @NotNull(message = "O usuário não pode ser nulo")
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel userId;

}
