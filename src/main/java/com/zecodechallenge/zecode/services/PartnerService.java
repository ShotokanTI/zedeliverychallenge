package com.zecodechallenge.zecode.services;

import com.zecodechallenge.zecode.entities.Partner;
import com.zecodechallenge.zecode.exceptions.PartnerException;
import com.zecodechallenge.zecode.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnerService {
    @Autowired
    private PartnerRepository repo;

    public Partner getPartnerById(Long id) throws PartnerException {
        Optional<Partner> optionalPartner = repo.findById(id);
        if (optionalPartner.isEmpty()) {
            if(id == null){
                id = Long.valueOf((Integer) 0);
            }
            throw new PartnerException(id);
        }
        return optionalPartner.get();
    }
}

