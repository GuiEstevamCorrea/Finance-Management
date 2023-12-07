package com.gc.financemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
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

    @NotBlank(message = "O email não pode estar em branco")
    @Size(max = 255, message = "O email deve ter no máximo 255 caracteres")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "O primeiro nome não pode estar em branco")
    @Size(max = 255, message = "O primeiro nome deve ter no máximo 255 caracteres")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "O último nome não pode estar em branco")
    @Size(max = 255, message = "O último nome deve ter no máximo 255 caracteres")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "O CPF não pode estar em branco")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 caracteres")
    private String cpf;

    @NotNull(message = "A data de nascimento não pode ser nula")
    @Past(message = "A data de nascimento deve ser no passado")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotBlank(message = "A senha não pode estar em branco")
    private String password;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<CardModel> cards;

    public UserModel(UUID userId) {
        this.userId = userId;
    }
}

