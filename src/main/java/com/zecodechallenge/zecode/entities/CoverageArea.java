package com.zecodechallenge.zecode.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zecodechallenge.zecode.enums.TypeGEO;
import com.zecodechallenge.zecode.util.MultiPolygonSerializer;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.spatial.dialect.postgis.PGGeometryJdbcType;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
