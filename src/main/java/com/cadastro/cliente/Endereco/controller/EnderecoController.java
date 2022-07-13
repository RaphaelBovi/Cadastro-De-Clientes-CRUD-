package com.cadastro.cliente.Endereco.controller;

import com.cadastro.cliente.Endereco.model.dtos.EnderecoRequestDTO;
import com.cadastro.cliente.Endereco.model.dtos.EnderecoResponseDTO;
import com.cadastro.cliente.Endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoResponseDTO save(@RequestBody EnderecoRequestDTO endereco) {
        return this.service.save(endereco);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EnderecoResponseDTO> findAll() {
        return service.listEndereco();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoResponseDTO update(@RequestBody EnderecoRequestDTO endereco, @PathVariable Long id) {
        return service.updateEndereco(id, endereco);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCliente(@PathVariable("id") Long id) {
        service.findByRemove(id);
    }




}
