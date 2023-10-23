package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.LichTrinhTour;
import com.luanvan.b1910025.models.LoaiTour;
import com.luanvan.b1910025.payloads.requests.KhachSanRequest;
import com.luanvan.b1910025.payloads.requests.LichTrinhTourRequest;
import com.luanvan.b1910025.payloads.requests.LoaiTourRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface LichTrinhTourService {

    LichTrinhTour createLTT(LichTrinhTourRequest LTTRequest);

    Optional<LichTrinhTour> updateLTT(Long lttID, LichTrinhTourRequest LTTRequest);

    void deleteLTT(Long lttID);

    LichTrinhTour getASingleLichTrinhTour(Long lttID);

    List<LichTrinhTour> getAllLichTrinhTours();

    List<LichTrinhTour> getLichTrinhTourByTourID(Long tourID);

    Optional<LichTrinhTour> getLichTrinhTour(long lttID);
}
