package com.zecodechallenge.zecode.exceptions;

public class PartnerNotFoundById extends RuntimeException  {

    private Long id;

    public PartnerNotFoundById(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
