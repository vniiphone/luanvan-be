package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.LoaiTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiTourRepo extends JpaRepository<LoaiTour, Long> {

    boolean existsById(Long id);
}
