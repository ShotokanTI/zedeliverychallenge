package com.zecodechallenge.zecode.repository;

import com.zecodechallenge.zecode.entities.CoverageArea;
import com.zecodechallenge.zecode.entities.Partner;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverageAreaRepository extends JpaRepository<CoverageArea,Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE tb_coverage_area SET coordinates = :#{#coverageArea.coordinates} WHERE partner_id = :id",nativeQuery = true)
    void updateCoverageArea(@Param("coverageArea") CoverageArea coverageArea,@Param("id")Long id);
}
