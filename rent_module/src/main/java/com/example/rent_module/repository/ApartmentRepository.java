package com.example.rent_module.repository;

import com.example.rent_module.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    Optional<Apartment> findByStatus (Boolean status);

}
