package com.cadastro.cliente.Endereco.model.dtos;

import com.cadastro.cliente.Cliente.model.entity.Cliente;
import com.cadastro.cliente.Endereco.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequestDTO {

    private Long id;

    private String cep;

    private String cidade;

    private String estado;

    private String bairro;

    private String rua;

    private String numero;

    private String referencia;

    private Long clienteId;

    public Endereco toModel() {
        return new Endereco(this.cep, this.cidade, this.estado, this.bairro, this.rua, this.numero, this.referencia);
    }

}
