package com.example.rent_module.repository;

import com.example.rent_module.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    @Query("select ap from Apartment ap left join fetch ap.address ad " +
           "where ad.city = :city and ap.status = true " +
           "order by ap.price asc")
    List<Apartment> findAllByAddressCityOrderByPrice(String city);

}
