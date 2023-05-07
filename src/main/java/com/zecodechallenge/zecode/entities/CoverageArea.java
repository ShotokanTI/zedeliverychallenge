package com.zecodechallenge.zecode.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zecodechallenge.zecode.enums.TypeGEO;
import jakarta.persistence.*;
import org.locationtech.jts.geom.MultiPolygon;

import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "tb_coverage_area")
public class CoverageArea implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @JsonIgnore
    @Column(name = "id_coverage_area")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private TypeGEO type;
    @JsonIgnore
    private MultiPolygon coordinates;

    @OneToOne
    @JoinColumn(name = "partner_id")
    @JsonIgnore
    private Partner partner_coverage_area;

    public CoverageArea(){

    }
    public CoverageArea(Long id, TypeGEO type, MultiPolygon multiPolygon, Partner partner_coverage_area) {
        this.id = id;
        this.type = type;
        this.coordinates = multiPolygon;
        this.partner_coverage_area = partner_coverage_area;
    }

    public MultiPolygon getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(MultiPolygon coordinates) {
        this.coordinates = coordinates;
    }

    public MultiPolygon getMultiPolygon() {
        return coordinates;
    }

    public void setMultiPolygon(MultiPolygon multiPolygon) {
        this.coordinates = multiPolygon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeGEO getType() {
        return type;
    }

    public void setType(TypeGEO type) {
        this.type = type;
    }

    public Partner getPartner_coverage_area() {
        return partner_coverage_area;
    }

    public void setPartner_coverage_area(Partner partner_coverage_area) {
        this.partner_coverage_area = partner_coverage_area;
    }
}
