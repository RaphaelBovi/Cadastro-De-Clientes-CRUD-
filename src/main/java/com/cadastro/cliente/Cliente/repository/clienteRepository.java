package com.cadastro.cliente.Cliente.repository;

import com.cadastro.cliente.Cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<Cliente, Long> {
}
