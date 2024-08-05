package com.example.rent_module.repository;

import com.example.rent_module.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    List<Apartment> findByStatus(Boolean status);

}
