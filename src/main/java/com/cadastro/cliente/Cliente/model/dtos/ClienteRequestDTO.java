package com.cadastro.cliente.Cliente.model.dtos;

import com.cadastro.cliente.Cliente.model.entity.Cliente;
import com.cadastro.cliente.Endereco.model.dtos.EnderecoRequestDTO;
import com.cadastro.cliente.Endereco.model.entity.Endereco;
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

    private EnderecoRequestDTO endereco;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDeNascimento;

    public Cliente toModel(Endereco endereco) {
        return new Cliente(this.nome, this.email, this.cpf, this.telefone, this.dataDeNascimento, endereco);
    }

}
