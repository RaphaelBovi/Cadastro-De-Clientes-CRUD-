package com.cadastro.cliente.Cliente.controller;

import com.cadastro.cliente.Cliente.model.dtos.ClienteRequestDTO;
import com.cadastro.cliente.Cliente.model.dtos.ClienteResponseDTO;
import com.cadastro.cliente.Cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO save(@RequestBody ClienteRequestDTO cliente) {
        return this.service.save(cliente);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponseDTO> findAll() {
        return service.listCliente();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO update(@RequestBody ClienteRequestDTO cliente, @PathVariable Long id) {
        return service.update(id, cliente);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCliente(@PathVariable("id") Long id) {
        service.findByRemove(id);
    }

}
