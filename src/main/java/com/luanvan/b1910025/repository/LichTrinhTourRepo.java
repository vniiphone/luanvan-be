package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.LichTrinhTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichTrinhTourRepo extends JpaRepository<LichTrinhTour, Long> {

    List<LichTrinhTour> getLichTrinhTourByTourId(Long tourId);

    List<LichTrinhTour> findByTourId(Long tourID);

    //Kiểm tra tồn tại Brand trong Product
    Boolean existsByDiemDenId(Long id);


}