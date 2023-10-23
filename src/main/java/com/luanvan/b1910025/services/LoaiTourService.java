package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.LoaiTour;
import com.luanvan.b1910025.models.Tour;
import com.luanvan.b1910025.payloads.requests.LoaiTourRequest;
import com.luanvan.b1910025.payloads.requests.TourRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface LoaiTourService {

    LoaiTour createLoaiTour(LoaiTourRequest loaiTourRequest);

    Optional<LoaiTour> updateLoaiTour(Long loaiTourId, LoaiTourRequest loaiTourRequest);

    void deleteLTour(Long loaiTourId);

    LoaiTour getASingleLoaiTour(Long loaiTourId);

    List<LoaiTour> getAllLoaiTours();


}
