package com.luanvan.b1910025.controllers;


import com.luanvan.b1910025.models.LoaiTour;
import com.luanvan.b1910025.payloads.requests.LoaiTourRequest;
import com.luanvan.b1910025.payloads.responses.ResourceNotFoundException;
import com.luanvan.b1910025.repository.LoaiTourRepo;
import com.luanvan.b1910025.repository.TourRepo;
import com.luanvan.b1910025.services.LoaiTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping("/api/loai-tour")
public class LoaiTourController {

    @Autowired
    private LoaiTourRepo loaiTourRepo;

    @Autowired
    private LoaiTourService loaiTourService;

    @Autowired
    private TourRepo tourRepo;

    //Get All Loai tour
    @GetMapping("")
    public List<LoaiTour> getAllLoaiTour() {
        return loaiTourRepo.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLoaiTour(@RequestBody LoaiTourRequest loaiTourRequest) {
        try {
            LoaiTour createdLoaiTour = loaiTourService.createLoaiTour(loaiTourRequest);
            return ResponseEntity.ok(loaiTourRequest); //
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating Loai tour: " + e.getMessage());
        }

    }


    // get Loại Tour by ID
    @GetMapping("/{id}")
    public ResponseEntity<LoaiTour> getLoaiTourById(@PathVariable Long id) {
        LoaiTour loaiTour = loaiTourRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loại Tour not exist with id :" + id));
        return ResponseEntity.ok(loaiTour);
    }


    // update Loại Tour rest api
    @PutMapping("/{id}")
    public ResponseEntity<LoaiTour> updateLoaiTour(@PathVariable Long id, @RequestBody LoaiTourRequest loaiTourDetails) {
        LoaiTour loaiTour = loaiTourRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loại Tur not exist with id :" + id));
        loaiTour.setName(loaiTourDetails.getName());
        loaiTour.setNoiDung(loaiTourDetails.getNoiDung());

        LoaiTour updatedLoaiTour = loaiTourRepo.save(loaiTour);
        return ResponseEntity.ok(updatedLoaiTour);
    }

    // delete Loại Tour rest api
    @DeleteMapping(value = "/{id}", consumes = {"*/*"})
    public ResponseEntity<String> deleteLoaiTour(@PathVariable("id") Long id) {
        boolean hasCategory = loaiTourRepo.existsById(id);
        boolean hasExits = tourRepo.existsByLoaiTourId(id);

        if (hasCategory) {
            System.out.print("Id not exits");
            if (!hasExits) {
                loaiTourRepo.deleteById(id);
                return new ResponseEntity<>("Delete", HttpStatus.BAD_REQUEST);
            } else {
                System.out.println("Tồn tại Loại tour trong danh sách tour");
                return new ResponseEntity<>("Vẫn còn tồn tại trong tour du lịch", HttpStatus.BAD_REQUEST);
            }
        } else if (!hasCategory) {
            System.out.println("Id not exits");
            return new ResponseEntity<>("ID " + id + " not found", HttpStatus.NOT_FOUND);
        } else {
            System.out.println("Lỗi 500 INTERNAL SERVER ERRROR");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
