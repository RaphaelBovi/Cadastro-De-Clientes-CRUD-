package com.cadastro.cliente.Cliente.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "cliente")
public class Cliente {

    public Cliente(String nome, String email, String cpf, String telefone, LocalDate dataDeNascimento) {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataDeNascimento = dataDeNascimento;
    }

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "dataDeNascimento", nullable = false)
    private LocalDate dataDeNascimento;

}
