package com.zecodechallenge.zecode.util;
import com.zecodechallenge.zecode.DTO.CoverageAreaDTO;
import com.zecodechallenge.zecode.DTO.PartnerDTO;
import com.zecodechallenge.zecode.entities.Address;
import com.zecodechallenge.zecode.entities.CoverageArea;
import com.zecodechallenge.zecode.entities.Partner;
import com.zecodechallenge.zecode.enums.TypeGEO;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PartnerHelper {

    public PartnerHelper() {

    }

    // Create a list of Coordinates from a list of points
    public static Coordinate[] CreateListCoordinateFromPartner(List<Double[]> points) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (Double[] point : points) {
            // Add a new Coordinate to the list of Coordinates
            coordinates.add(new Coordinate(point[0], point[1]));
        }
        // Get the first and last Coordinate from the list of Coordinates
        Coordinate firstCoordinate = coordinates.get(0);
        Coordinate lastCoordinate = coordinates.get(coordinates.size() - 1);
        // Check if the first and last Coordinates are not equal
        if (firstCoordinate.getX() != lastCoordinate.getX()
                || coordinates.get(1).getY() != lastCoordinate.getY()) {
            // If they are not equal, add the first Coordinate to the end of the list
            coordinates.add(new Coordinate(firstCoordinate.getX(), firstCoordinate.getY()));
        }
        return coordinates.toArray(new Coordinate[0]);
    }

    public static Polygon[] CreateListOfPolygonFromPartner(PartnerDTO partner) {
        List<Polygon> poligonos = new ArrayList<Polygon>();
        GeometryFactory gf = new GeometryFactory();

        for (List<List<Double[]>> layer : partner.getCoverageArea().getCoordinates()) {
            for (List<Double[]> points : layer) {
                Coordinate[] cord = CreateListCoordinateFromPartner(points);
                try {
                    LinearRing linearRing = gf.createLinearRing(cord);
                    Polygon polygon = gf.createPolygon(linearRing, null);
                    poligonos.add(polygon);
                } catch (IllegalArgumentException e) {
                    // Handle invalid geometry
                    System.err.println("Invalid geometry: " + e.getMessage());
                }
            }
        }
        return poligonos.toArray(new Polygon[0]);
    }

    public static boolean OnlySaveIfCoordinatesIsGreaterThanFour(CoverageAreaDTO coverageArea){
        long quantity = coverageArea.getCoordinates().stream()
                .flatMap(List::stream)
                .flatMap(List::stream)
                .count();

        return quantity >= 4;
    }

    public static Partner ConvertPartner(PartnerDTO partner) {

            MultiPolygon geometry = (MultiPolygon) CreateMultiPolygonFromPartner(partner);

            Partner instancePartner = new Partner(null, partner.getTradingName(), partner.getOwnerName(), partner.getDocument());

            CoverageArea area = new CoverageArea(null, TypeGEO.MultiPolygon,geometry, instancePartner);

            // Create a Coordinate array to store the coordinates of the partner's address
            Coordinate[] coords = new Coordinate[1];
            // Get the coordinates from the partner's address and store them in the Coordinate array


            coords[0] = new Coordinate(partner.getAddress().getCoordinates().get(0), partner.getAddress().getCoordinates().get(1));

            CoordinateArraySequence locationPartner = new CoordinateArraySequence(coords);

            Point point = new Point(locationPartner, new org.locationtech.jts.geom.GeometryFactory());

            Address address = new Address(null, TypeGEO.Point, point, instancePartner);


        instancePartner.setCoverageArea(area);
        instancePartner.setAddress(address);

        return instancePartner;
    }

    public static MultiPolygon CreateMultiPolygonFromPartner(PartnerDTO partner) {
        GeometryFactory gf = new GeometryFactory();
        Polygon[] poligons = CreateListOfPolygonFromPartner(partner);
        MultiPolygon geometry = gf.createMultiPolygon(poligons);
        return geometry;
    }
}
