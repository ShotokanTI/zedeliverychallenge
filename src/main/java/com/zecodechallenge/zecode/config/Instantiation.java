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
	}

}
