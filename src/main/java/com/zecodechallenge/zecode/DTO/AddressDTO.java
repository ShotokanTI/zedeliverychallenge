package com.zecodechallenge.zecode.DTO;

import com.zecodechallenge.zecode.enums.TypeGEO;

import java.util.ArrayList;
import java.util.List;

public class AddressDTO {
    private TypeGEO type;
    private List<Double> coordinates = new ArrayList<>();

    public AddressDTO(){

    }

    public TypeGEO getType() {
        return type;
    }

    public void setType(TypeGEO type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public AddressDTO(TypeGEO type, List<Double> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }
}
