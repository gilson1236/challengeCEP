package com.challenge.Address.service;

import com.challenge.Address.dto.CepDTO;
import com.challenge.Address.model.Cep;
import com.challenge.Address.repositories.CepRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CepService {

    private final CepRepository cepRepository;

    public CepService(CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }

    public Cep create(CepDTO cepDTO){

        Cep cep = new Cep();
        cep.setCep(cepDTO.getCep());
        cep.setCity(cepDTO.getCity());
        cep.setStreet(cepDTO.getStreet());
        cep.setState(cepDTO.getState());
        cep.setNeighborhood(cepDTO.getNeighborhood());
        cep.setService(cepDTO.getService());

        return cepRepository.save(cep);
    }

    public List<Cep> list(){
        return cepRepository.findAll();
    }

    public Optional<CepDTO> readCep(String cep) {
        Optional<Cep> find = cepRepository.findByCep(cep);

        CepDTO cepDTO;

        cepDTO = find.map(value -> new CepDTO(value.getCep(), value.getState(), value.getCity(),
                value.getNeighborhood(), value.getStreet(), value.getService())).orElseGet(CepDTO::new);

        return Optional.of(cepDTO);
    }
}
