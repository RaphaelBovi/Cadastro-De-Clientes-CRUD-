package com.cadastro.cliente.Endereco.service;

import com.cadastro.cliente.Endereco.model.dtos.EnderecoRequestDTO;
import com.cadastro.cliente.Endereco.model.dtos.EnderecoResponseDTO;
import com.cadastro.cliente.Endereco.model.entity.Endereco;
import com.cadastro.cliente.Endereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public EnderecoResponseDTO save(EnderecoRequestDTO endereco) {
        return EnderecoResponseDTO.from(repository.save(endereco.toModel()));
    }

    public EnderecoResponseDTO findById(Long id) {
        Endereco endereco = repository.findById(id).get();
        return EnderecoResponseDTO.from(endereco);
    }

    public EnderecoResponseDTO updateEndereco(Long id, EnderecoRequestDTO endereco) {
        Optional<Endereco> byId = repository.findById(id);
        if (byId.isPresent()) {
            Endereco edit = byId.get();
            edit.setId(id);
            return EnderecoResponseDTO.from(repository.save(endereco.update()));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possivel editar este endereço");
        }
    }

    public void findByRemove(Long id) {
        Optional<Endereco> byId = repository.findById(id);
        if (byId.isPresent()) {
            Endereco endereco = byId.get();
            removeId(endereco.getId());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado.");
        }
    }

    public List<EnderecoResponseDTO> listEndereco() {
        return repository.findAll()
                .stream().map(EnderecoResponseDTO::from)
                .collect(Collectors.toList());
    }

    public void removeId(Long id) {
        repository.deleteById(id);
    }


}
