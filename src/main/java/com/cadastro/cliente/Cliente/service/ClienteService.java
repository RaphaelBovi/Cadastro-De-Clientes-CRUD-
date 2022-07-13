package com.cadastro.cliente.Cliente.service;

import com.cadastro.cliente.Cliente.model.dtos.ClienteRequestDTO;
import com.cadastro.cliente.Cliente.model.dtos.ClienteResponseDTO;
import com.cadastro.cliente.Cliente.model.entity.Cliente;
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
        return ClienteResponseDTO.from(repository.save(cliente.toModel()));
    }

    public ClienteResponseDTO findById(Long id) {
        Cliente cliente = repository.findById(id).get();
        return ClienteResponseDTO.from(cliente);
    }

    public ClienteResponseDTO update(Long id, ClienteRequestDTO cliente) {
        Optional<Cliente> byId = repository.findById(id);
        if (byId.isPresent()) {
            Cliente edit = byId.get();
            edit.setId(id);
            return ClienteResponseDTO.from(repository.save(cliente.update()));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel editar este cliente");
        }
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
                .stream().map(ClienteResponseDTO::from)
                .collect(Collectors.toList());
    }

    public void removeId(Long id) {
        repository.deleteById(id);
    }

}
