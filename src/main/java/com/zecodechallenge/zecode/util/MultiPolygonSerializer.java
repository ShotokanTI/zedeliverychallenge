package com.zecodechallenge.zecode.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;

import java.io.IOException;

public class MultiPolygonSerializer extends JsonSerializer<MultiPolygon> {

    @Override
    public void serialize(MultiPolygon value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeFieldName("coordinates");
        gen.writeStartArray();
        for (int i = 0; i < value.getNumGeometries(); i++) {
            Polygon polygon = (Polygon) value.getGeometryN(i);
            gen.writeStartArray();
            for (Coordinate coordinate : polygon.getExteriorRing().getCoordinates()) {
                gen.writeArray(new double[] { coordinate.getX(), coordinate.getY() }, 0, 2);
            }
            gen.writeEndArray();
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }

}

