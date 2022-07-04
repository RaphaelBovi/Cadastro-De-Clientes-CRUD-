package com.cadastro.cliente.Cliente.service;

import com.cadastro.cliente.Cliente.controller.dtos.ClienteResponseDTO;
import com.cadastro.cliente.Cliente.entity.Cliente;
import com.cadastro.cliente.Cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteResponseDTO findById(Long id){
        Cliente cliente = repository.findById(id).get();
        return ClienteResponseDTO.from(cliente);
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> listaCliente() {
        return repository.findAll();
    }


}
