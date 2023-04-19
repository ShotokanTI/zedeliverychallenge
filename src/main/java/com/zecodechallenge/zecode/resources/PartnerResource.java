package com.zecodechallenge.zecode.resources;

import com.zecodechallenge.zecode.entities.Partner;
import com.zecodechallenge.zecode.exceptions.PartnerException;
import com.zecodechallenge.zecode.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/partner")
@EnableWebMvc
public class PartnerResource {

    @Autowired
    private PartnerService service;

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getPartnerById(id));
    }
    @ExceptionHandler(PartnerException.class)
    public ResponseEntity<String> handlePartnerNotFoundException(PartnerException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
