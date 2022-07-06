package com.cadastro.cliente.Cliente.controller;

import com.cadastro.cliente.Cliente.controller.dtos.ClienteRequestDTO;
import com.cadastro.cliente.Cliente.controller.dtos.ClienteResponseDTO;
import com.cadastro.cliente.Cliente.entity.Cliente;
import com.cadastro.cliente.Cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteRequestDTO save(@RequestBody ClienteRequestDTO cliente) {
        this.service.save(cliente);
        return cliente;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> findAll() {
        return service.listCliente();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCliente(@PathVariable("id") Long id) {
        service.findByRemove(id)
                .map(cliente -> {
                    service.removeId(cliente.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

}
