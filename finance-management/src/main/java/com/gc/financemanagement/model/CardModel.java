package com.gc.financemanagement.model;

import com.gc.financemanagement.enums.CardType;
import jakarta.persistence.*;
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
    private Long cardNumber;
    private String cvv;
    private LocalDate validDate;
    private CardType cardType;
    private Integer price;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel userId;

}
