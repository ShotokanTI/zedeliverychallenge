package com.zecodechallenge.zecode.repository;

import com.zecodechallenge.zecode.entities.Address;
import com.zecodechallenge.zecode.entities.Partner;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE tb_address SET coordinates = :#{#address.coordinates} WHERE partner_id = :id", nativeQuery = true)
    void updateAddress(@Param("address") Address address,@Param("id")Long id);
}
