package com.challenge.Address.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "cep")
public class Cep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Length(min = 3, max = 10)
    //@Column(length = 10, nullable = false)
    private String cep;

    //@Length(min = 3, max = 30)
    //@Column(length = 30, nullable = false)
    private String state;

    //@Length(min = 3, max = 100)
    //@Column(length = 100, nullable = false)
    private String city;

    //@Length(min = 3, max = 100)
    //@Column(length = 100, nullable = false)
    private String neighborhood;

    //@Length(min = 3, max = 100)
    //@Column(length = 100, nullable = false)
    private String street;

    //@Length(min = 3, max = 10)
    //@Column(length = 100, nullable = false)
    private String service;


    public Cep(){}

    public Cep(Long id, String cep, String state, String city, String neighborhood, String street, String service) {
        this.id = id;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
