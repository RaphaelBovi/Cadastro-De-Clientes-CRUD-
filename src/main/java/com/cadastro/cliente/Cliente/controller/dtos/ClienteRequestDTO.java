package com.cadastro.cliente.Cliente.controller.dtos;

import com.cadastro.cliente.Cliente.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    private LocalDateTime dataDeNascimento;

    public Cliente toModel(){
        return new Cliente(
                this.id,
                this.nome,
                this.email,
                this.cpf,
                this.telefone,
                this.dataDeNascimento);
    }

}
