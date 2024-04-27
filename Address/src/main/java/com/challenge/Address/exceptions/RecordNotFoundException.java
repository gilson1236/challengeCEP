package com.challenge.Address.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String id) {
        super("Atenção! " + id);
    }
}
