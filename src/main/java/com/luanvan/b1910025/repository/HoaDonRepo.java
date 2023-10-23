package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, Long> {
    List<HoaDon> findByUser_Id(Long userId);

    List<HoaDon> findAllByOrderByTimeCreateDesc();

    @Query(value = "SELECT IFNULL(SUM(total_price),0) FROM Hoa_Don WHERE was_pay=true", nativeQuery = true)
    double tongDoanhThu();

    // Câu truy vấn để lấy HoaDon bằng id và fetch luôn thông tin Tour liên quan
    @Query("SELECT hd FROM HoaDon hd JOIN FETCH hd.tour WHERE hd.id = :hoaDonId")
    HoaDon findHoaDonWithTour(@Param("hoaDonId") Long hoaDonId);


}