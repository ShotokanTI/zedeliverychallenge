package com.zecodechallenge.zecode.exceptions;

public class PartnerException extends RuntimeException {
    public PartnerException(Long id){
        super("Partner not found with id: " + id);
    }
}
