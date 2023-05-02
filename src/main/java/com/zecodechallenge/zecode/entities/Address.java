package com.zecodechallenge.zecode.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zecodechallenge.zecode.enums.TypeGEO;
import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {
    @Id
    @JsonIgnore
    @Column(name = "id_address")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private TypeGEO type;

    @JsonIgnore
    private Point coordinates;

    @OneToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    public Address() {

    }

    public Address(Long id, TypeGEO type, Point coordinates, Partner partner) {
        this.id = id;
        this.type = type;
        this.coordinates = coordinates;
        this.partner = partner;
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

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", type=" + type +
                ", coordinates=" + coordinates +
                ", partner=" + partner +
                '}';
    }
}
