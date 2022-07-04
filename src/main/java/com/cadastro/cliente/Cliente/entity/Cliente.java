package com.cadastro.cliente.Cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @CPF
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dataNascimento", nullable = false)
    private LocalDateTime dataNascimento;


    public Cliente() {

    }


}
