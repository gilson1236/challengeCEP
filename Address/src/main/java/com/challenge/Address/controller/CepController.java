package com.challenge.Address.controller;

import com.challenge.Address.dto.CepDTO;
import com.challenge.Address.model.Cep;
import com.challenge.Address.service.CepService;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void save(@RequestBody CepDTO cepDTO){

        cepService.create(cepDTO);
    }

    @GetMapping
    public List<Cep> list(){
        return cepService.list();
    }

    @GetMapping(value = "/{cep}", produces="application/json")
    public CepDTO readCep(@PathVariable String cep) {
        return cepService.readCep(cep);
    }
}
