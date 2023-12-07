package com.gc.financemanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name ="TB_USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "userId")
public class UserModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserModel(String userId) {
        this.userId = UUID.fromString(userId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String firstName;
    private String lastName;
    private String cpf;
    private LocalDate birthDate;
    private String password;


}
