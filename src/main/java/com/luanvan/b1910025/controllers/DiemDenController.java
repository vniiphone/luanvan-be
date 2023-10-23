package com.luanvan.b1910025.controllers;

import com.luanvan.b1910025.models.DiemDen;
import com.luanvan.b1910025.models.LichTrinhTour;
import com.luanvan.b1910025.models.Tour;
import com.luanvan.b1910025.payloads.requests.DiemDenRequest;
import com.luanvan.b1910025.payloads.requests.LichTrinhTourRequest;
import com.luanvan.b1910025.payloads.requests.TourRequest;
import com.luanvan.b1910025.repository.DiemDenRepo;
import com.luanvan.b1910025.repository.LichTrinhTourRepo;
import com.luanvan.b1910025.services.DiemDenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8088", maxAge = 3600)
@RestController
@RequestMapping("/api/Diem-Den")
public class DiemDenController {

    @Autowired
    DiemDenRepo diemDenRepo;
    @Autowired
    DiemDenService diemDenService;

    @Autowired
    LichTrinhTourRepo lichTrinhTourRepo;

    @GetMapping("")
    public ResponseEntity<List<DiemDen>> getAllListDiemDen(@RequestParam Optional<String> sortBy) {
        try {
            List<DiemDen> diemDens = diemDenService.getAllDiemDen();
            return new ResponseEntity<>(diemDens, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDiemDen(@RequestBody DiemDenRequest diemDenRequest) {
        try {
            DiemDen createDiemDen = diemDenService.createDiemDen(diemDenRequest);
            return ResponseEntity.ok(createDiemDen);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating DiemDen: " + e.getMessage());
        }
    }
    @PostMapping("/create-diemden")
    public ResponseEntity<?> createDiemDens(@RequestBody List<DiemDenRequest> diemDenRequests) {
        List<DiemDen> createDDList = new ArrayList<>();
        try {
            for (DiemDenRequest diemDenRequest : diemDenRequests) {
                DiemDen createAlone = diemDenService.createDiemDen(diemDenRequest);
                createDDList.add(createAlone);
            }
            return ResponseEntity.ok(createDDList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating Diem Den: " + e.getMessage());
        }
    }



}
