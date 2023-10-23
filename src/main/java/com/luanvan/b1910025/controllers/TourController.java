package com.luanvan.b1910025.controllers;

import com.luanvan.b1910025.models.LoaiTour;
import com.luanvan.b1910025.models.Tour;
import com.luanvan.b1910025.payloads.requests.TourRequest;
import com.luanvan.b1910025.payloads.responses.ApiResponse;
import com.luanvan.b1910025.repository.LoaiTourRepo;
import com.luanvan.b1910025.repository.TourRepo;
import com.luanvan.b1910025.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/", methods = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/tour")
public class TourController {

    @Autowired
    TourService tourService;

    @Autowired
    TourRepo tourRepo;

    @Autowired
    LoaiTourRepo loaiTourRepo;

//    @CrossOrigin(origins = "http://127.0.0.1:5173/", maxAge = 3600)
    @GetMapping("/Admin/")
    public ResponseEntity<Page<Tour>> getAllTours(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
        try {
            Page<Tour> tours = tourService.getAllTours(page, sortBy);
            return new ResponseEntity<>(tours, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")
    public ResponseEntity<Page<Tour>> getAllToursViewVisible(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
        try {
            Page<Tour> tours = tourService.getAllToursVisible(page, sortBy);
            return new ResponseEntity<>(tours, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // List Tour không phân trang
//    @CrossOrigin(origins = "http://127.0.0.1:5173/", maxAge = 3600)
    @GetMapping("/List")
    public ResponseEntity<List<Tour>> getAllToursNoPage(@RequestParam Optional<String> sortBy) {
        try {
            List<Tour> tours = tourService.getAllListTours();
            return new ResponseEntity<>(tours, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/TourFilterVisible")
    public ResponseEntity<List<Tour>> getTourVisibleList() {
        try {
            List<Tour> tours = tourService.getTourVisible();
            return new ResponseEntity<>(tours, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/TourByLT/{loaiTourId}")
    public ResponseEntity<List<Tour>> getTourByCategory(@PathVariable Long loaiTourId) {

        try {
            List<Tour> tours = tourService.getVisibleToursByLoaiTourId(loaiTourId);
            return new ResponseEntity<>(tours, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create3")
    public ResponseEntity<Tour> createTourVer2(@Valid @RequestBody TourRequest tourRq) {
        try {
//            LoaiTour loaiTour = loaiTourRepo.findById(tourRq.getLoaiTour_id()).orElseThrow();
            Tour t = tourService.createTour(tourRq);

            return new ResponseEntity<>(tourRepo.save(t), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   /* @PostMapping("/create2")
    public ResponseEntity<Tour> createTour2(@RequestBody TourRequest tourRequest) {
        try {
            LoaiTour loaiTour = loaiTourRepo.findById(tourRequest.getLoaiTourId()).orElseThrow();

            List<Image> imagesList = new ArrayList<>();
            for (ImageRequest imageRequest : tourRequest.getImagesList()) {
                Image image = new Image();
                image.setImage_url(imageRequest.getImageUrl());
                // Có thể thêm các thuộc tính khác của Images từ imageRequest
                imagesList.add(image);
            }

            List<LichTrinhTour> lichTrinhTourList = new ArrayList<>();
            for (LichTrinhTourRequest lichTrinhTourRequest : tourRequest.getLichTrinhTourList()) {
                LichTrinhTour lichTrinhTour = new LichTrinhTour();
                // Thiết lập các thuộc tính của lichTrinhTour từ lichTrinhTourRequest
                lichTrinhTourList.add(lichTrinhTour);
            }

            // Khởi tạo đối tượng Tour
            Tour tour = new Tour(
                    tourRequest.getName(),
                    loaiTour,
                    imagesList,
                    lichTrinhTourList,
                    tourRequest.getTomTat(),
                    tourRequest.getNgayGioXuatPhat(),
                    tourRequest.getNgayVe(),
                    tourRequest.getNoiKhoiHanh(),
                    tourRequest.getGiaThamKhao(),
                    tourRequest.getSoLuongVe());
            // Các thuộc tính khác của Tour từ tourRequest

            // Lưu đối tượng Tour vào cơ sở dữ liệu
            Tour savedTour = tourRepo.save(tour);

            if (savedTour != null) {
                return new ResponseEntity<>(savedTour, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
   /* @PostMapping("/create2")
    public ResponseEntity<?> createTour2(@RequestBody TourRequest tourRequest) {
        try {
            // Xác định đối tượng LoaiTour từ loaiTour_id
            LoaiTour loaiTour = loaiTourRepo.findById(tourRequest.getLoaiTourId()).orElseThrow();

       */
    /*     // Tạo danh sách Image từ ImageRequest
            List<Image> imagesList = new ArrayList<>();
            for (ImageRequest imageRequest : tourRequest.getImagesList()) {
                Image image = new Image();
                image.setImage_url(imageRequest.getImageUrl());
                // Có thể thêm các thuộc tính khác của Images từ imageRequest
                imagesList.add(image);
            }*/
    /*

            // Tạo danh sách LichTrinhTour từ LichTrinhTourRequest
            List<LichTrinhTour> lichTrinhTourList = new ArrayList<>();
            for (LichTrinhTourRequest lichTrinhTourRequest : tourRequest.getLichTrinhTourList()) {
                LichTrinhTour lichTrinhTour = new LichTrinhTour();
                // Thiết lập các thuộc tính của lichTrinhTour từ lichTrinhTourRequest
                lichTrinhTourList.add(lichTrinhTour);
            }

            // Tạo đối tượng Tour từ dữ liệu trong TourRequest
            Tour tour = new Tour(
                    tourRequest.getName(),
                    loaiTour,
                    imagesList,
                    lichTrinhTourList,
                    tourRequest.getTomTat(),
                    tourRequest.getNgayGioXuatPhat(),
                    tourRequest.getNgayVe(),
                    tourRequest.getNoiKhoiHanh(),
                    tourRequest.getGiaThamKhao(),
                    tourRequest.getSoLuongVe());

            // Lưu đối tượng Tour vào cơ sở dữ liệu
            Tour createdTour = tourRepo.save(tour);
            // Trả về đối tượng Tour đã tạo cùng với mã trạng thái CREATED
            return new ResponseEntity<>(createdTour, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred."+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


    @PostMapping("/create")
    public ResponseEntity<?> createTour(@RequestBody TourRequest tourRequest) {
        try {
            Tour createdTour = tourService.createTour(tourRequest);
            return ResponseEntity.ok(createdTour);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating tour: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable("id") Long id) {
        Tour tour = tourService.getASingleTour(id);
        return new ResponseEntity<>(tour, HttpStatus.OK);

    }

    @PutMapping(value = "/{id}", consumes = {"*/*"})
    public ResponseEntity<Optional<Tour>> updateTour(@PathVariable("id") Long id,
                                                     @RequestBody @Valid TourRequest tour) {
        return new ResponseEntity<>(tourService.updateTour(id, tour), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> deleteTour(@PathVariable("id") Long id) {
        try {
            tourService.deleteTour(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(value = "/show/{id}")
    public ResponseEntity<ApiResponse> showTour(@PathVariable("id") Long id) {
        try {
            tourService.showTour(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PutMapping("/setVisible/{id}")
    public ResponseEntity<ApiResponse> setTourVisible(@PathVariable("id") Long id) {
        try {
            tourService.setTourVisible(id);
            return new ResponseEntity<>(new ApiResponse(true, "success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false,"Failed to update tour visibility"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
