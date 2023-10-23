package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.DiemDen;
import com.luanvan.b1910025.models.LichTrinhTour;
import com.luanvan.b1910025.payloads.requests.DiemDenRequest;
import com.luanvan.b1910025.repository.DiemDenRepo;
import com.luanvan.b1910025.repository.LichTrinhTourRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class DiemDenServiceImpl implements DiemDenService {

    @Autowired
    DiemDenRepo diemDenRepo;

    @Autowired
    LichTrinhTourRepo lichTrinhTourRepo;


    @Override
    public DiemDen createDiemDen(DiemDenRequest diemDenRequest) {

        LichTrinhTour LTTour = lichTrinhTourRepo.findById(diemDenRequest.getLichTrinhTour_Id()).orElseThrow();

        DiemDen dd = new DiemDen(
                diemDenRequest.getName(),
                diemDenRequest.getDiaChi(),
                diemDenRequest.getNoiDung(),
                diemDenRequest.getGiaVeThamQuan(),
                LTTour
        );

        return diemDenRepo.save(dd);
    }

    @Override
    public Optional<DiemDen> updateDiemDen(Long diemDenId, DiemDenRequest diemDenRequest) {
        return Optional.empty();
    }

    @Override
    public void deleteDiemDen(Long diemDenId) {
        boolean hasExist = diemDenRepo.existsById(diemDenId);
        if (hasExist) {
            diemDenRepo.deleteById(diemDenId);
            log.error("Delete Diem Den: " + diemDenId);
        } else throw new InvalidConfigurationPropertyValueException("diemDenRepo", diemDenRepo, "Not Found");

    }

    @Override
    public DiemDen getASingleDiemDen(Long diemDenId) {
        return diemDenRepo.findById(diemDenId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("diemDenId: ", diemDenId, "Not found"));
    }

    @Override
    public List<DiemDen> getAllDiemDen() {
        return diemDenRepo.findAll();
    }

    @Override
    public List<DiemDen> getDiemDenByLichTrinhTour(Long lttID) {
        return diemDenRepo.findByLichTrinhTour_Id(lttID);
    }
}
