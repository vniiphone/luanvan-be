package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.LichTrinhTour;
import com.luanvan.b1910025.models.LoaiTour;
import com.luanvan.b1910025.models.Tour;
import com.luanvan.b1910025.payloads.requests.TourRequest;
import com.luanvan.b1910025.repository.DiemDenRepo;
import com.luanvan.b1910025.repository.LichTrinhTourRepo;
import com.luanvan.b1910025.repository.LoaiTourRepo;
import com.luanvan.b1910025.repository.TourRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class TourServiceImpl implements TourService {
    @Autowired
    LoaiTourRepo loaiTourRepo;
    @Autowired
    TourRepo tourRepo;

    @Autowired
    DiemDenRepo diemDenRepo;


    @Autowired
    LichTrinhTourRepo lichTrinhTourRepo;


    @Override
    @Transactional
    public Tour createTour(TourRequest tourRequest) {
        LoaiTour loaiTour = loaiTourRepo.findById(tourRequest.getLoaiTour_id()).orElseThrow();

        // Khởi tạo đối tượng Tour trước khi sử dụng trong vòng lặp
        Tour tour = new Tour(
                tourRequest.getName(),
                tourRequest.getImageUrls(),
                tourRequest.getImagePublicIds(),
                loaiTour,
                new ArrayList<>(), // Không cần khởi tạo danh sách lịch trình ở đây
                tourRequest.getTomTat(),
                tourRequest.getNgayGioXuatPhat(),
                tourRequest.getNgayVe(),
                tourRequest.getNoiKhoiHanh(),
                tourRequest.getGiaThamKhao(),
                tourRequest.getSoLuongVe(),
                "",
                tourRequest.getVisible());

        // Khởi tạo danh sách lịch trình Tour
        List<LichTrinhTour> lichTrinhTours = new ArrayList<>();
        /*for (LichTrinhTourRequest lichTrinhTourRequest : tourRequest.getLichTrinhTourList()) {
            LichTrinhTour lichTrinhTour = new LichTrinhTour();
            lichTrinhTour.setPhuongTien(lichTrinhTourRequest.getPhuongTien());
            lichTrinhTour.setSttLichTrinh(lichTrinhTourRequest.getSttLichTrinh());
            lichTrinhTour.setTenLichTrinh(lichTrinhTourRequest.getTenLichTrinh());
            lichTrinhTour.setGhiChu(lichTrinhTourRequest.getGhiChu());
            lichTrinhTour.setLichTrinhChiTiet(lichTrinhTourRequest.getLichTrinhChiTiet());

            // Set tour cho lịch trình tour
            lichTrinhTour.setTour(tour);

            // Khởi tạo đối tượng KhachSan và liên kết với LichTrinhTour
            KhachSanRequest khachSanRequest = new KhachSanRequest();
            KhachSan khachSan = new KhachSan(
                    khachSanRequest.getName(),
                    khachSanRequest.getPhone(),
                    khachSanRequest.getDiaChiKsan(),
                    khachSanRequest.getGiaPhong(),
                    lichTrinhTour);

            lichTrinhTour.setKhachSan(khachSan);


            lichTrinhTours.add(lichTrinhTour);
        }*/


        // Gán danh sách lịch trình cho tour
        tour.setLichTrinhTours(lichTrinhTours);
// Tạo mã tour dựa trên định dạng và đặt giá trị cho tourCode
        String tourCode = generateTourCode(tour);

        tour.setTourCode(tourCode);
        // Lưu tour vào cơ sở dữ liệu
        log.info("Đã thêm Tour");
        return tourRepo.save(tour);

    }

    // Phương thức tạo mã tour dựa trên định dạng
    private String generateTourCode(Tour tour) {
        // có thể thay đổi định dạng dựa trên yêu cầu
        String codeFormat = "TOUR-%d-%02d"; // Ví dụ: TOUR-2023-001
        String formattedCode = String.format(codeFormat, LocalDate.now().getYear(), tour.getId());
        return formattedCode;
    }

    @Override
    public Optional<Tour> updateTour(Long tourId, TourRequest tourRequest) {
        Optional<Tour> tour = tourRepo.findById(tourId);
        if (tour.isPresent()) {
            // Thiếu thuộc tính khi sửa
            LoaiTour loaiTour = loaiTourRepo.findById(tourRequest.getLoaiTour_id()).orElseThrow();
            tour.get().setName(tourRequest.getName());
            tour.get().setLoaiTour(loaiTour);
            tour.get().setGiaThamKhao(tourRequest.getGiaThamKhao());
            tour.get().setNgayGioXuatPhat(tourRequest.getNgayGioXuatPhat());
            tour.get().setNgayVe(tourRequest.getNgayVe());
            tour.get().setNoiKhoiHanh(tourRequest.getNoiKhoiHanh());
            tour.get().setTomTat(tourRequest.getTomTat());
            tour.get().setSoLuongVe(tourRequest.getSoLuongVe());
            tour.get().setVisible(tourRequest.getVisible());
            tour.get().setImageUrls(tourRequest.getImageUrls());
            tourRepo.save(tour.get());
            return tour;
        } else {
            throw new InvalidConfigurationPropertyValueException("tourId", tourId, "Not found");
        }
    }

    @Override
    public void deleteTour(Long tourId) {
        Optional<Tour> tour = tourRepo.findById(tourId);
        if (tour.isPresent()) {
            tour.get().setVisible(false);
        } else {
            throw new InvalidConfigurationPropertyValueException("tourId", tourId, "Not found");
        }
    }

    @Override
    public Tour getASingleTour(Long tourId) {
        // TODO Auto-generated method stub
        return tourRepo.findById(tourId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("tourId", tourId, "Not found"));
    }

    @Override
    public Page<Tour> getAllTours(Optional<Integer> page, Optional<String> sortBy) {
        // TODO Auto-generated method stub
        return tourRepo.findAll(PageRequest.of(page.orElse(0), 20, Sort.Direction.ASC, sortBy.orElse("id")));
    }

    @Override
    public Page<Tour> getAllToursVisible(Optional<Integer> page, Optional<String> sortBy) {
        return tourRepo.findVisibleToursView(PageRequest.of(page.orElse(0), 20, Sort.Direction.ASC, sortBy.orElse("id")));
    }

    @Override
    public List<Tour> getAllListTours() {
        return tourRepo.findAll();
    }

    @Override
    public List<Tour> getTourByCategory(Long categoryID) {
        return tourRepo.findTourByLoaiTourId(categoryID);
    }

    @Override
    public List<Tour> getTourVisible() {
        return tourRepo.findVisibleTours();
    }

    @Override
    public List<Tour> getVisibleToursByLoaiTourId(Long loaiTourId) {
        return tourRepo.findTourByLoaiTourIdAndVisible(loaiTourId);
    }
}
