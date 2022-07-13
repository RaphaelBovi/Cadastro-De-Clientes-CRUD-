package com.cadastro.cliente.Endereco.repository;

import com.cadastro.cliente.Endereco.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
