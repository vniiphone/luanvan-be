package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.Tour;
import com.luanvan.b1910025.payloads.requests.TourRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TourService {

    Tour createTour(TourRequest tourRequest);

    Optional<Tour> updateTour(Long tourId, TourRequest tourRequest);

    void deleteTour(Long tourId);

    Tour getASingleTour(Long tourId);

    Page<Tour> getAllTours(Optional<Integer> page, Optional<String> sortBy);
    Page<Tour> getAllToursVisible(Optional<Integer> page, Optional<String> sortBy);


    List<Tour> getAllListTours();

    List<Tour> getTourByCategory(Long categoryID);

    List<Tour> getTourVisible();

   List<Tour> getVisibleToursByLoaiTourId(Long loaiTourId) ;

}
