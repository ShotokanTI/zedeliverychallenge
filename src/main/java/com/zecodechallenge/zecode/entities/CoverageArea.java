package com.zecodechallenge.zecode.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zecodechallenge.zecode.enums.TypeGEO;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.spatial.dialect.postgis.PGGeometryJdbcType;
import org.locationtech.jts.geom.Geometry;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;

import java.io.Serializable;


@Entity
@Table(name = "tb_coverage_area")
public class CoverageArea implements Serializable {
    @Id
    @JsonIgnore
    @Column(name = "id_coverage_area")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private TypeGEO type;
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Geometry coordinates;

    @OneToOne
    @JoinColumn(name = "partner_id")
    private Partner partner_coverage_area;
    public CoverageArea(){
        
    }

    public CoverageArea(Long id, TypeGEO type, Geometry coordinates, Partner partner_coverage_area) {
        this.id = id;
        this.type = type;
        this.coordinates = coordinates;
        this.partner_coverage_area = partner_coverage_area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoverageArea(Long id, TypeGEO type, Geometry coordinates) {
        this.id = id;
        this.type = type;
        this.coordinates = coordinates;
    }

    public CoverageArea(TypeGEO type, Geometry coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public TypeGEO getType() {
        return type;
    }
    public void setType(TypeGEO type) {
        this.type = type;
    }
    public Geometry getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Geometry coordinates) {
        this.coordinates = coordinates;
    }

    
}
