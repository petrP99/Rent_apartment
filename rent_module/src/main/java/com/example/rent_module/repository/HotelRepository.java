package com.example.rent_module.repository;

import com.example.rent_module.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Address, Long> {

}
