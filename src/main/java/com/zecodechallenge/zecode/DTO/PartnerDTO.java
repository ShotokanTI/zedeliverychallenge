package com.zecodechallenge.zecode.DTO;

import java.util.ArrayList;
import java.util.List;

public class PartnerDTO {
    private Long id;

    private String tradingName;

    private String ownerName;
    private String document;
    private CoverageAreaDTO coverageArea;

    private AddressDTO address;

    @Override
    public String toString() {
        return "PartnerDTO{" +
                "tradingName='" + tradingName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", document='" + document + '\'' +
                ", coverageArea=" + coverageArea +
                ", address=" + address +
                '}';
    }

    public PartnerDTO(){

    }

    public PartnerDTO(Long id, String tradingName, String ownerName, String document, CoverageAreaDTO coverageArea, AddressDTO address) {
        this.id = id;
        this.tradingName = tradingName;
        this.ownerName = ownerName;
        this.document = document;
        this.coverageArea = coverageArea;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
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

    public CoverageAreaDTO getCoverageArea() {
        return coverageArea;
    }

    public void setCoverageArea(CoverageAreaDTO coverageArea) {
        this.coverageArea = coverageArea;
    }


}
