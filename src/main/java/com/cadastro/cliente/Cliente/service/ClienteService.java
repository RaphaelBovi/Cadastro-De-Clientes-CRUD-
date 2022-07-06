package com.cadastro.cliente.Cliente.service;

import com.cadastro.cliente.Cliente.controller.dtos.ClienteRequestDTO;
import com.cadastro.cliente.Cliente.controller.dtos.ClienteResponseDTO;
import com.cadastro.cliente.Cliente.entity.Cliente;
import com.cadastro.cliente.Cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void findByRemove(Long id) {
        Optional<Cliente> byId = repository.findById(id);
        if (byId.isPresent()) {
            Cliente cliente = byId.get();
            removeId(cliente.getId());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
        }
    }


    public List<ClienteResponseDTO> listCliente() {
        return repository.findAll()
                .stream().map(cliente -> ClienteResponseDTO.from(cliente))
                .collect(Collectors.toList());
    }

    public void removeId(Long id) {
        repository.deleteById(id);
    }

}
