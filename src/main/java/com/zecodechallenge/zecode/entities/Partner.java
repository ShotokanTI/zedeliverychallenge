package com.zecodechallenge.zecode.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_partner")
public class Partner implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tradingName;
    private String ownerName;
    private String document;
    @OneToOne(mappedBy = "partner_coverage_area",cascade = CascadeType.ALL, orphanRemoval = true)
    private CoverageArea coverageArea;
    @OneToOne(mappedBy = "partner",cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    public Partner() {

    }


    public Partner(Long id, String tradingName, String ownerName, String document) {
        this.id = id;
        this.tradingName = tradingName;
        this.ownerName = ownerName;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public CoverageArea getCoverageArea() {
        return coverageArea;
    }

    public void setCoverageArea(CoverageArea coverageArea) {
        this.coverageArea = coverageArea;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
