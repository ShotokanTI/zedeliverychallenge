package com.zecodechallenge.zecode.repository;

import com.zecodechallenge.zecode.entities.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
    @Override
    @Query(value = "SELECT * FROM tb_partner p " +
            "JOIN tb_coverage_area ca on p.id = ca.partner_id " +
            "JOIN tb_address ad on p.id = ad.partner_id " +
            "WHERE p.id = :idPartner",nativeQuery = true)
    Optional<Partner> findById(@Param("idPartner") Long id);
}
