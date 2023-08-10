package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findByUser_Id(Long userId);

    Booking findByUser_IdAndTour_IdAndStatusDat(int userId, Long tourId, int statusDat);
}
