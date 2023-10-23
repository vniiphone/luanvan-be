package com.luanvan.b1910025.controllers;


import com.luanvan.b1910025.models.LichTrinhTour;
import com.luanvan.b1910025.payloads.requests.LichTrinhTourRequest;
import com.luanvan.b1910025.payloads.responses.MsgResponse;
import com.luanvan.b1910025.repository.LichTrinhTourRepo;
import com.luanvan.b1910025.repository.TourRepo;
import com.luanvan.b1910025.services.LichTrinhTourService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8088", maxAge = 3600)

@Log4j2
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/", methods = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/lichtrinh-tour")
public class LichTrinhTourController {

    /*
    Xong
    Create - Update - Read - Delete
    */
    @Autowired
    LichTrinhTourRepo lichTrinhTourRepo;

    @Autowired
    LichTrinhTourService lichTrinhTourService;

    @Autowired
    TourRepo tourRepo;

    @GetMapping("")
    public ResponseEntity<List<LichTrinhTour>> getAllListLTT(@RequestParam Optional<String> sortBy) {
        try {
            List<LichTrinhTour> lichTrinhTours = lichTrinhTourService.getAllLichTrinhTours();
            return new ResponseEntity<>(lichTrinhTours, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lichtrinhTour-chitiet/{id}")
    public ResponseEntity<List<LichTrinhTour>> getLTTbyTourID(@PathVariable("id") Long tourId) {
        log.info("getLTTbyTourID: " + tourId);
        try {
            List<LichTrinhTour> lichTrinhTours = lichTrinhTourService.getLichTrinhTourByTourID(tourId);
            return new ResponseEntity<>(lichTrinhTours, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/ltt-chitiet/{id}")
    public ResponseEntity<LichTrinhTour> getLTTbyLttID(@PathVariable("id") Long LttId) {
        log.info("getLTTbyLttID: " + LttId);
        try {
            LichTrinhTour lichTrinhTour = lichTrinhTourService.getASingleLichTrinhTour(LttId);
            if (lichTrinhTour != null) {
                return new ResponseEntity<>(lichTrinhTour, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Trả về HTTP 404 nếu không tìm thấy dữ liệu
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createLTT(@RequestBody LichTrinhTourRequest lichTrinhTourRequest) {
        try {
            LichTrinhTour createLTT = lichTrinhTourService.createLTT(lichTrinhTourRequest);
            return ResponseEntity.ok(createLTT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating LTT: " + e.getMessage());
        }
    }
    @PostMapping("/create-ltts")
    public ResponseEntity<?> createLichTrinhTours(@RequestBody LichTrinhTourRequest lttRequests) {
        try {
                LichTrinhTour createdLTT = lichTrinhTourService.createLTT(lttRequests);
            return ResponseEntity.ok(createdLTT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating Lich Trinh Tours: " + e.getMessage());
        }
    }
/*    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<LichTrinhTour>> updateLichTrinhTour(
            @PathVariable Long id,
            @RequestBody LichTrinhTourRequest lichTrinh) {
        log.info("Update LTT: " + id);
        try {
            Optional<LichTrinhTour> updateLTT = lichTrinhTourService.updateLTT(id, lichTrinh);
            log.info("Update LTT object: " + lichTrinh);
            return ResponseEntity.ok((updateLTT));
        } catch (Exception e) {
            log.info("Update LTT Failed Catch: " + e.getMessage());
            return (ResponseEntity<Optional<LichTrinhTour>>) ResponseEntity.badRequest();
        }
    }*/

    @PutMapping(value = "/update/{id}", consumes = { "*/*" })
    public ResponseEntity<Optional<LichTrinhTour>> updateLichTrinhTour(
            @PathVariable("id") Long id,
            @RequestBody @Valid LichTrinhTourRequest lichTrinh) {
        return new ResponseEntity<>(lichTrinhTourService.updateLTT(id, lichTrinh), HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateLichTrinhTour2(
//            @PathVariable Long lttID,
//            @RequestBody LichTrinhTourRequest LTTRequest
//    ) {
//        Optional<LichTrinhTour> updatedLTT = lichTrinhTourService.updateLTT(lttID, LTTRequest);
//
//        if (updatedLTT.isPresent()) {
//            return ResponseEntity.ok(updatedLTT.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    /*@PostMapping("/create-ltts")
    public ResponseEntity<?> createLichTrinhTours(@RequestBody List<LichTrinhTourRequest> lttRequests, KhachSanRequest khachSanRequest) {
        List<LichTrinhTour> createdLTTS = new ArrayList<>();
        try {
            for (LichTrinhTourRequest lttRequest : lttRequests) {
                LichTrinhTour createdLTT = lichTrinhTourService.createLTT(lttRequest,lttRequest);
                createdLTTS.add(createdLTT);
            }
            return ResponseEntity.ok(createdLTTS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating Lich Trinh Tours: " + e.getMessage());
        }
    }*/

 /*   @PostMapping("/create-ltts")
    public ResponseEntity<?> createLichTrinhTours(@RequestBody List<LichTrinhTourRequest> lttRequests) {
        List<LichTrinhTour> createdLTTS = new ArrayList<>();
        try {
            for (LichTrinhTourRequest lttRequest : lttRequests) {
                LichTrinhTour createdLTT = lichTrinhTourService.createLTT(lttRequest);
                createdLTTS.add(createdLTT);
            }
            return ResponseEntity.ok(createdLTTS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating Lich Trinh Tours: " + e.getMessage());
        }
    } */



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MsgResponse> deleteProduct(@PathVariable("id") Long id) {
        try {
            lichTrinhTourService.deleteLTT(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
