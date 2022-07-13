package com.cadastro.cliente.Endereco.model.entity;

import com.cadastro.cliente.Cliente.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "endereco")
public class Endereco {

    public Endereco(String cep, String cidade, String estado, String bairro, String rua, String numero, String referencia) {
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.referencia = referencia;
    }

    public String getEnderecoEscrito() {
        return this.rua + ", " + this.numero + ", " + this.bairro + ", " + this.cidade + ", " + this.estado;
    }

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "endereco_id", nullable = false)
    private Long id;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "referencia", nullable = false)
    private String referencia;

    @OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Cliente cliente;

}
