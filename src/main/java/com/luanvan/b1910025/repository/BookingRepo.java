package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findByUser_Id(Long userId);

//    Booking findById(Long id);

    Booking findByUser_IdAndTour_IdAndStatusDat(Long userId, Long tourId, int statusDat);

    boolean existsById(Long id);

}
