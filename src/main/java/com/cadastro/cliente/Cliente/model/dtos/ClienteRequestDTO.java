package com.cadastro.cliente.Cliente.model.dtos;

import com.cadastro.cliente.Cliente.model.entity.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDeNascimento;

    public Cliente toModel() {
        return new Cliente(this.nome, this.email, this.cpf, this.telefone, this.dataDeNascimento);
    }

}
