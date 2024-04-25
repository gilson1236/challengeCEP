package com.challenge.Address.dto;

public class CepDTO {

    //private Long id;
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;

    public CepDTO(){}

    public CepDTO(String cep, String state, String city, String neighborhood, String street, String service) {
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.service = service;

    }

/*    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
*/
    public String getCep() {
        return cep;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public String getService(){
        return service;
    }
}
