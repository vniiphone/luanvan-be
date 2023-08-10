package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo extends JpaRepository<District, Long> {
    List<District> findAllByCity_Id(Long city_id);
}
