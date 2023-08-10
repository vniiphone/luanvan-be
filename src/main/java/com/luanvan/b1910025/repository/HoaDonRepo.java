package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HoaDonRepo extends JpaRepository<HoaDon, Long> {
    List<HoaDon> findByUser_Id(Long userId);

    List<HoaDon> findAllByOrderByNgayGioTaoDesc();

    @Query(value = "SELECT IFNULL(SUM(total_price),0) FROM Invoice WHERE was_pay=true", nativeQuery = true)
    double tongDoanhThu();

}