package com.zecodechallenge.zecode.repository;

import com.zecodechallenge.zecode.entities.Address;
import com.zecodechallenge.zecode.entities.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
