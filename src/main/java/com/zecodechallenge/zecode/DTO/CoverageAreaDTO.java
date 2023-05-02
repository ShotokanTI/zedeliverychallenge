package com.zecodechallenge.zecode.DTO;

import com.zecodechallenge.zecode.enums.TypeGEO;

import java.util.ArrayList;
import java.util.List;

public class CoverageAreaDTO {
    private TypeGEO type;

    private List<List<List<Double[]>>> coordinates = new ArrayList<>();

    public CoverageAreaDTO(){

    }

    public CoverageAreaDTO(TypeGEO type, List<List<List<Double[]>>> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public TypeGEO getType() {
        return type;
    }

    public void setType(TypeGEO type) {
        this.type = type;
    }

    public List<List<List<Double[]>>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<List<Double[]>>> coordinates) {
        this.coordinates = coordinates;
    }
}
