package com.zecodechallenge.zecode.services;

import com.zecodechallenge.zecode.DTO.PartnerDTO;
import com.zecodechallenge.zecode.entities.Partner;
import com.zecodechallenge.zecode.exceptions.PartnerCoordinatesLessThanFourException;
import com.zecodechallenge.zecode.exceptions.PartnerNotFoundById;
import com.zecodechallenge.zecode.repository.AddressRepository;
import com.zecodechallenge.zecode.repository.CoverageAreaRepository;
import com.zecodechallenge.zecode.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.zecodechallenge.zecode.util.PartnerHelper.ConvertPartner;
import static com.zecodechallenge.zecode.util.PartnerHelper.OnlySaveIfCoordinatesIsGreaterThanFour;

@Service
public class PartnerService {
    @Autowired
    private PartnerRepository repo;

    @Autowired
    private CoverageAreaRepository coverageRepository;
    @Autowired
    private AddressRepository addressRepository;

    public void SavePartner(PartnerDTO partner){

       Partner convertedPartner = ConvertPartner(partner);

       if(!OnlySaveIfCoordinatesIsGreaterThanFour(partner.getCoverageArea())) {
            throw new PartnerCoordinatesLessThanFourException();
       }else{
           repo.save(convertedPartner);
       }
    }

    public void UpdatePartner(PartnerDTO partner){

       Partner convertedPartner = ConvertPartner(partner);

       convertedPartner.setId(partner.getId());

       if(!OnlySaveIfCoordinatesIsGreaterThanFour(partner.getCoverageArea())) {
            throw new PartnerCoordinatesLessThanFourException();
       }else{
           Optional<Partner> result = repo.findById(convertedPartner.getId());
           if(result.isEmpty()){
               throw new PartnerNotFoundById(convertedPartner.getId());
           }else{
               repo.updatePartnerById(convertedPartner);
               addressRepository.updateAddress(convertedPartner.getAddress(), convertedPartner.getId());
               coverageRepository.updateCoverageArea(convertedPartner.getCoverageArea(), convertedPartner.getId());
           }
       }
    }
    public void DeletePartner(Long id){
        addressRepository.deleteById(id);
        coverageRepository.deleteById(id);
        repo.deleteById(id);
    }

    public List<Partner> getAllPartners(){
        Optional<List<Partner>> partner = Optional.of(repo.findAll());
        return partner.get();
    }

    public Partner getPartnerById(Long id) {
        Optional<Partner> optionalPartner = repo.findById(id);
        if (optionalPartner.isEmpty()) {
            if(id == null){
                id = Long.valueOf((Integer) 0);
            }
            throw new PartnerNotFoundById(id);
        }
        return optionalPartner.get();
    }
}

