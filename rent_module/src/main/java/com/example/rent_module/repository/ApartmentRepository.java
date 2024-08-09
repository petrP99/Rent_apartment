package com.example.rent_module.repository;

import com.example.rent_module.entity.Address;
import com.example.rent_module.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    @Query("select a from Apartment a where a.status=TRUE and a.address.id=:id")
    List<Apartment> findAllByAddressId(Long id);


}
