package com.challenge.Address.service;

import com.challenge.Address.dto.CepDTO;
import com.challenge.Address.model.Cep;
import com.challenge.Address.repositories.CepRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CepService {

    private final CepRepository cepRepository;

    public CepService(CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }

    public void create(CepDTO cepDTO){

        Cep cep = new Cep();
        cep.setCep(cepDTO.getCep());
        cep.setCity(cepDTO.getCity());
        cep.setStreet(cepDTO.getStreet());
        cep.setState(cepDTO.getState());
        cep.setNeighborhood(cepDTO.getNeighborhood());
        cep.setService(cepDTO.getService());

        cepRepository.save(cep);
    }

    public List<Cep> list(){
        return cepRepository.findAll();
    }

    public CepDTO readCep(String cep) {
        Cep find = cepRepository.findByCep(cep);

        //answer.setId(find.getId());

        return new CepDTO(find.getCep(), find.getState(), find.getCity(),
                find.getNeighborhood(), find.getStreet(), find.getService());
    }
}
