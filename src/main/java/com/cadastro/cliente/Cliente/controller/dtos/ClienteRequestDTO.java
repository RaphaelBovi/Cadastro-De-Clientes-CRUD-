package com.cadastro.cliente.Cliente.controller.dtos;

import com.cadastro.cliente.Cliente.entity.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeNascimento;

    public Cliente toModel() {
        return new Cliente(this.nome, this.email, this.cpf, this.telefone, this.dataDeNascimento);
    }


}
