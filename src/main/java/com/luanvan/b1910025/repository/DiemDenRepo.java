package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.DiemDen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiemDenRepo extends JpaRepository<DiemDen, Long> {

    List<DiemDen> findByLichTrinhTour_Id(Long LichTrinhTour_Id);
//    List<DiemDen> get
}