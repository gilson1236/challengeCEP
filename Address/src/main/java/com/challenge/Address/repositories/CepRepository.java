package com.challenge.Address.repositories;

import com.challenge.Address.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CepRepository extends JpaRepository<Cep,Long> {

    @Query(value = "SELECT * FROM cep WHERE cep=?1",nativeQuery = true)
    Optional<Cep> findByCep(String cep);

}
