package com.example.rent_module.repository;

import com.example.rent_module.entity.Address;
import com.example.rent_module.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByCityAndStreet(String city, String street);

    List<Address> findByCity(String city);

    Optional<Address> findById(Long id);




}
