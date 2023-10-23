package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.LichTrinhTour;
import com.luanvan.b1910025.models.Tour;
import com.luanvan.b1910025.payloads.requests.LichTrinhTourRequest;
import com.luanvan.b1910025.repository.DiemDenRepo;
import com.luanvan.b1910025.repository.LichTrinhTourRepo;
import com.luanvan.b1910025.repository.TourRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class LichTrinhTourServiceImpl implements LichTrinhTourService {

    @Autowired
    LichTrinhTourRepo lichTrinhTourRepo;

    @Autowired
    TourRepo tourRepo;

    @Autowired
    DiemDenRepo diemDenRepo;

    @Override
    @Transactional
    public LichTrinhTour createLTT(LichTrinhTourRequest lttRequest) {
        Tour tour = tourRepo.findById(lttRequest.getTour_id()).orElseThrow();
        LichTrinhTour LLtour = new LichTrinhTour(
                lttRequest.getPhuongTien(),
                lttRequest.getSttLichTrinh(),
                lttRequest.getTenLichTrinh(),
                lttRequest.getGhiChu(),
                lttRequest.getNameKhachSan(),
                lttRequest.getDiaChiKhachSan(),
                lttRequest.getGiaPhongKhachSan(),
                lttRequest.getPhoneKhachSan(),
                tour,
                lttRequest.getLichTrinhChiTiet(),
                new ArrayList<>()
        );

        log.info("Đã thêm LTT");

        return lichTrinhTourRepo.save(LLtour);
    }

    @Override
    public Optional<LichTrinhTour> updateLTT(Long lttID, LichTrinhTourRequest LTTRequest) {

        // Lấy LichTrinhTour cần cập nhật từ cơ sở dữ liệu
        Optional<LichTrinhTour> lttOptional = lichTrinhTourRepo.findById(lttID);
        log.info(("Update LTTid line 88 debug: " + lttOptional.get().getTenLichTrinh())); // check đúng rồi
        if (lttOptional.isPresent()) {
            Tour tour = tourRepo.findById(LTTRequest.getTour_id()).orElseThrow();
            log.info(("Update LTT object line 91 debug: "));
            lttOptional.get().setTenLichTrinh(LTTRequest.getTenLichTrinh());
            lttOptional.get().setSttLichTrinh(LTTRequest.getSttLichTrinh());
            lttOptional.get().setTour(tour);
            lttOptional.get().setLichTrinhChiTiet(LTTRequest.getLichTrinhChiTiet());
            lttOptional.get().setGhiChu(LTTRequest.getGhiChu());
            lttOptional.get().setPhuongTien(LTTRequest.getPhuongTien());
            lttOptional.get().setTenLichTrinh(LTTRequest.getTenLichTrinh());
            lttOptional.get().setVisible(LTTRequest.isVisible());
            lttOptional.get().setNameKhachSan(LTTRequest.getNameKhachSan());
            lttOptional.get().setDiaChiKhachSan(LTTRequest.getDiaChiKhachSan());
            lttOptional.get().setPhoneKhachSan(LTTRequest.getPhoneKhachSan());
            lttOptional.get().setGiaPhongKhachSan(LTTRequest.getGiaPhongKhachSan());
            log.info(("Update LTT object line 105 debug: "));
            lichTrinhTourRepo.save(lttOptional.get());
            return lttOptional;
        } else {
            log.info(("LTT Id: "+ lttID+ " Not found"));
            throw new InvalidConfigurationPropertyValueException("LTT Id", lttID, "Not found");
        }
    }

    @Override
    public void deleteLTT(Long lttID) {
        if (lichTrinhTourRepo.findById(lttID).get().getId().equals(lttID)) {
            lichTrinhTourRepo.deleteById(lttID);
        } else
            throw new InvalidConfigurationPropertyValueException("lttID", lttID, "Not found");

    }

    @Override
    public LichTrinhTour getASingleLichTrinhTour(Long lttID) {
        return lichTrinhTourRepo.findById(lttID)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("lttID", lttID, "Not found"));
    }

    @Override
    public List<LichTrinhTour> getAllLichTrinhTours() {
        return lichTrinhTourRepo.findAll();
    }

    @Override
    public List<LichTrinhTour> getLichTrinhTourByTourID(Long tourID) {
        return lichTrinhTourRepo.findByTourId(tourID);
    }

    @Override
    public Optional<LichTrinhTour> getLichTrinhTour(long lttID) {
        return lichTrinhTourRepo.findById(lttID);
    }
}
