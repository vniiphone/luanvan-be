package com.luanvan.b1910025.controllers;

import com.luanvan.b1910025.models.*;
import com.luanvan.b1910025.payloads.requests.DiaChiRequest;
import com.luanvan.b1910025.repository.*;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8088")
@RestController
@RequestMapping("/api/address")
public class DiaChiController {
    @Autowired
    DiaChiRepo addressRepo;
    @Autowired
    CityRepo cityRepo;
    @Autowired
    DistrictRepo districtRepo;
    @Autowired
    WardRepo wardRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping("/city")
    public ResponseEntity<List<City>> getCities() {
        try {
            List<City> cities = cityRepo.findAll();
            return new ResponseEntity<>(cities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/district")
    public ResponseEntity<List<District>> getDistricts(@RequestParam Optional<Long> city_id) {
        try {
            List<District> districts;
            if (city_id.isPresent()) {
                districts = districtRepo.findAllByCity_Id(city_id.get());
            } else
                districts = districtRepo.findAll();

            return new ResponseEntity<>(districts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ward")
    public ResponseEntity<List<Ward>> getWards(@RequestParam Optional<Long> district_id) {
        try {
            List<Ward> wards;
            if (district_id.isPresent()) {
                wards = wardRepo.findAllByDistrict_Id(district_id.get());
            } else
                wards = wardRepo.findAll();

            return new ResponseEntity<>(wards, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<DiaChi>> getAddresses(@PathVariable("id") Long user_id) {
        try {
            List<DiaChi> addresses = addressRepo.findByUser_Id(user_id);
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/create", consumes = { "*/*" })
    public ResponseEntity<DiaChi> createAddress(@Valid @RequestBody DiaChiRequest address) {
        try {
            Ward w = wardRepo.findById(address.getWard_id()).get();
            User u = userRepo.findById(address.getUser_id()).get();
            DiaChi a = new DiaChi(address.getAddress(), address.getPhone(),w, u );
            return new ResponseEntity<>(addressRepo.save(a), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = { "*/*" })
    public ResponseEntity<DiaChi> createAddress(
            @Valid @RequestBody DiaChiRequest address,
            @PathVariable("id") Long id) {
        try {
            Optional<DiaChi> a = addressRepo.findById(id);

            if (a.isPresent()) {
                Ward w = wardRepo.findById(address.getWard_id()).get();
                a.get().setWard(w);
                a.get().setPhone(address.getPhone());
                a.get().setDiaChi(address.getAddress());

                return new ResponseEntity<>(addressRepo.save(a.get()), HttpStatus.OK);

            } else {
                throw new InvalidConfigurationPropertyValueException("DiaChi_ID", id, "Not found");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", consumes = { "*/*" })
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long id) {
        try {
            if (addressRepo.findById(id).get().getId().equals(id)) {
                addressRepo.deleteById(id);
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            } else
                throw new InvalidConfigurationPropertyValueException("id", id, "Not found");
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
