package com.cadastro.cliente.Cliente.service;

import com.cadastro.cliente.Cliente.controller.dtos.ClienteRequestDTO;
import com.cadastro.cliente.Cliente.controller.dtos.ClienteResponseDTO;
import com.cadastro.cliente.Cliente.entity.Cliente;
import com.cadastro.cliente.Cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteResponseDTO save(ClienteRequestDTO cliente) {
        return ClienteResponseDTO.from(this.repository.save(cliente.toModel()));
    }

    public ClienteResponseDTO findById(Long id) {
        Cliente cliente = repository.findById(id).get();
        return ClienteResponseDTO.from(cliente);
    }

    public Optional<Cliente> findByRemove(Long id) {
        return repository.findById(id);
    }


    public List<Cliente> listCliente() {
        return repository.findAll();
    }

    public void removeId(Long id) {
        repository.deleteById(id);
    }

}
