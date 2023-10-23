package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.DiemDen;
import com.luanvan.b1910025.payloads.requests.DiemDenRequest;
import com.luanvan.b1910025.payloads.requests.HanhKhachRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DiemDenService {
    DiemDen createDiemDen(DiemDenRequest diemDenRequest);

    Optional<DiemDen> updateDiemDen(Long diemDenId, DiemDenRequest diemDenRequest);

    void deleteDiemDen(Long diemDenId);

    DiemDen getASingleDiemDen(Long diemDenId);

    List<DiemDen> getAllDiemDen();

    List<DiemDen> getDiemDenByLichTrinhTour(Long lttID);

}
