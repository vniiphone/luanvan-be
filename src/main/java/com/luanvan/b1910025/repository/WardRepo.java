package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepo extends JpaRepository<Ward, Long> {
    List<Ward> findAllByDistrict_Id(Long district_id);
}