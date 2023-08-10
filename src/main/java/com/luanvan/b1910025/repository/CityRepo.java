package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    List<City> findAll();
}
