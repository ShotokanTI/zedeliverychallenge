package com.zecodechallenge.zecode.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zecodechallenge.zecode.util.MultiPolygonSerializer;
import jakarta.persistence.*;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Polygon;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "tb_partner")
public class Partner implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tradingName;
    @Column(nullable = false)
    private String ownerName;

    @Column(unique = true,nullable = false)
    private String document;

    @OneToOne(mappedBy = "partner_coverage_area",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private CoverageArea coverageArea;
    @OneToOne(mappedBy = "partner",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Address address;

    public Partner() {

    }


    public Partner(Long id, String tradingName, String ownerName, String document) {
        this.id = id;
        this.tradingName = tradingName;
        this.ownerName = ownerName;
        this.document = document;
    }
    @JsonProperty("address")
    public Map<String,Object> jsonAddress() {
        Map<String,Object> address = new HashMap<>();
        address.put("type", this.address.getType());

        Double[] cord = new Double[]{this.address.getCoordinates().getCoordinate().getX(), this.address.getCoordinates().getCoordinate().getY()};

        address.put("coordinates",cord);
        return address;
    }

    @JsonProperty("coverageArea")
    public Map<String, Object> jsonMultiPolygon(){
        Map<String, Object> coverageArea = new HashMap<>();
        coverageArea.put("type", "MultiPolygon");

        List<List<List<Double[]>>> coordinates = new ArrayList<>();

        for (int i = 0; i < this.coverageArea.getMultiPolygon().getNumGeometries(); i++) {
            Polygon polygon = (Polygon) this.coverageArea.getMultiPolygon().getGeometryN(i);
            Coordinate[] polygonCoordinates = polygon.getCoordinates();

            List<List<Double[]>> polygonList = new ArrayList<>();
            List<Double[]> exteriorRing = new ArrayList<>();
            for (Coordinate coordinate : polygonCoordinates) {
                Double[] point = new Double[]{coordinate.getX(), coordinate.getY()};
                exteriorRing.add(point);
            }
            polygonList.add(exteriorRing);
            coordinates.add(polygonList);
        }

        coverageArea.put("coordinates", coordinates);
        return coverageArea;
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

    public void setCoverageArea(CoverageArea coverageArea) {
        this.coverageArea = coverageArea;
    }

    public CoverageArea getCoverageArea() {
        return coverageArea;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
