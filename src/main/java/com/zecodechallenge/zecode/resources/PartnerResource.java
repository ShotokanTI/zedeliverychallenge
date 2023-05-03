package com.zecodechallenge.zecode.resources;

import com.zecodechallenge.zecode.DTO.PartnerDTO;
import com.zecodechallenge.zecode.entities.Partner;
import com.zecodechallenge.zecode.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping(value = "/partner")
@EnableWebMvc
public class PartnerResource {

    @Autowired
    private PartnerService service;

    @GetMapping("/{id}")
    public ResponseEntity<Partner> GetPartnerById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getPartnerById(id));
    }

    @GetMapping
    public ResponseEntity<List<Partner>> getAllPartners(){
        return ResponseEntity.ok().body(service.getAllPartners());
    }

    @PostMapping
    public ResponseEntity<PartnerDTO> SavePartner(@RequestBody PartnerDTO partner){
            service.SavePartner(partner);
        return ResponseEntity.ok().body(partner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeletePartner(@PathVariable Long id){
            service.DeletePartner(id);
        return ResponseEntity.ok().body("ID DELETED: " + id);
    }
    @PutMapping
    public ResponseEntity<PartnerDTO> UpdatePartner(@RequestBody PartnerDTO partner){
            service.UpdatePartner(partner);
        return ResponseEntity.ok().body(partner);
    }

}
