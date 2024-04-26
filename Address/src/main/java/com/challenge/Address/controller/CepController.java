package com.challenge.Address.controller;

import com.challenge.Address.dto.CepDTO;
import com.challenge.Address.model.Cep;
import com.challenge.Address.service.CepService;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cep/v1")
public class CepController {

    @Autowired
    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> save(@RequestBody CepDTO cepDTO){

        Optional<CepDTO> optionalCep = cepService.readCep(cepDTO.getCep());

        if (optionalCep.isEmpty() || optionalCep.get().getCep() == null){
            return ResponseEntity.status(HttpStatus.CREATED).body(cepService.create(cepDTO));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Já Existe um cep com esse número no cadastro!");

    }

    @GetMapping
    public List<Cep> list(){
        return cepService.list();
    }

    @GetMapping(value = "/{cep}", produces="application/json")
    public Optional<CepDTO> readCep(@PathVariable String cep) {
        return cepService.readCep(cep);
    }
}
