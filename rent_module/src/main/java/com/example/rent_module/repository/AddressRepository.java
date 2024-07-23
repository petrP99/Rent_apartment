package com.example.rent_module.repository;

import com.example.rent_module.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByCityAndStreet(String city, String street);
}
