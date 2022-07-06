package com.cadastro.cliente.Cliente.controller.dtos;

import com.cadastro.cliente.Cliente.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String telefone;

    private LocalDate dataDeNascimento;

    public static ClienteResponseDTO from(Cliente cliente) {
        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getDataDeNascimento());
    }
}


