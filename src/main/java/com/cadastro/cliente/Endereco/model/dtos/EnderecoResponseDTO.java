package com.cadastro.cliente.Endereco.model.dtos;

import com.cadastro.cliente.Endereco.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponseDTO {

    private Long id;

    private String cep;

    private String cidade;

    private String estado;

    private String bairro;

    private String rua;

    private String numero;

    private String referencia;

    public static EnderecoResponseDTO from(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getBairro(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getReferencia());
    }

}
