package com.zecodechallenge.zecode.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.zecodechallenge.zecode.entities.Address;
import com.zecodechallenge.zecode.entities.CoverageArea;
import com.zecodechallenge.zecode.entities.Partner;
import com.zecodechallenge.zecode.enums.TypeGEO;
import com.zecodechallenge.zecode.repository.AddressRepository;
import com.zecodechallenge.zecode.repository.CoverageAreaRepository;
import com.zecodechallenge.zecode.repository.PartnerRepository;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PartnerRepository partnerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CoverageAreaRepository coverageAreaRepository;

	@Override
	public void run(String... args) throws Exception, IOException {

		partnerRepository.deleteAll();
		coverageAreaRepository.deleteAll();
		addressRepository.deleteAll();

		/*partnerRepository.deleteAll();
		coverageAreaRepository.deleteAll();
		addressRepository.deleteAll();

		WKTReader reader = new WKTReader();
		Geometry geometry = null;

		try {
			Polygon[] polygons = new Polygon[2];

			polygons[0] = (Polygon) reader.read("POLYGON((30 20, 45 40, 10 40, 30 20))");
			polygons[1] = (Polygon) reader.read("POLYGON((15 5, 40 10, 10 20, 5 10, 15 5))");
			MultiPolygon multi = new MultiPolygon(polygons, new org.locationtech.jts.geom.GeometryFactory());
			geometry = multi;
		} catch (ParseException e) {
			e.printStackTrace();
		};

		Partner p = new Partner(null,"Adega Osasco","Ze da Ambev","02.453.716/000170");

		CoverageArea ca1 = new CoverageArea(null,TypeGEO.MultiPolygon,geometry,p);

		Coordinate[] coords = new Coordinate[] {
				new Coordinate(-42.2277138, -17.7777359)
		};
		CoordinateArraySequence coordSeq = new CoordinateArraySequence(coords);

		Point point = new Point(coordSeq, new org.locationtech.jts.geom.GeometryFactory());

		Address ad1 = new Address(null,TypeGEO.Point,point,p);


		partnerRepository.saveAll(List.of(p));
		coverageAreaRepository.saveAll(List.of(ca1));
		addressRepository.saveAll(List.of(ad1));*/
	}

}
