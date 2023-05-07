package com.zecodechallenge.zecode.config;

import com.zecodechallenge.zecode.repository.AddressRepository;
import com.zecodechallenge.zecode.repository.CoverageAreaRepository;
import com.zecodechallenge.zecode.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableScheduling
public class DatabaseCleaner {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private CoverageAreaRepository coverageAreaRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Scheduled(fixedDelay = 3600000) // Executa a cada 1 hora
    public void cleanDatabase() {
        partnerRepository.deleteAll();
        coverageAreaRepository.deleteAll();
        addressRepository.deleteAll();
    }
}

