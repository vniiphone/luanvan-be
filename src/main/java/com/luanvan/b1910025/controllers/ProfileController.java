package com.luanvan.b1910025.controllers;

import com.luanvan.b1910025.models.Profile;
import com.luanvan.b1910025.payloads.requests.ProfileRequest;
import com.luanvan.b1910025.repository.ProfileRepo;
import com.luanvan.b1910025.repository.UserRepo;
import com.luanvan.b1910025.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/", methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ProfileService profileService;

    @GetMapping("/")
    public ResponseEntity<List<Profile>> getAllProfile() {
        try {
            List<Profile> profiles = profileService.getAllProfile();
            return new ResponseEntity<>(profiles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/create", consumes = {"*/*"})
    public ResponseEntity<?> createProfile(@Valid @RequestBody ProfileRequest profileRequest) {
        try {
            Profile createdProfile = profileService.createProfile(profileRequest);
            return ResponseEntity.ok(profileRequest); //
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating profile: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("id") Long id) {
        try {
            Profile profile = profileService.getASingleProfile(id);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Profile>> getAllProfileByUser(@PathVariable("userId") Long id) {
        try {
            List<Profile> profile = profileService.getAllProfileByUserId(id);
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") Long id) {
        Profile profile = profileService.getASingleProfile(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }*/

    @PutMapping(value = "/user/{profileId}", consumes = {"*/*"})
    public ResponseEntity<Profile> updateProfile(
            @Valid @RequestBody ProfileRequest profileRequest,
            @PathVariable("profileId") Long profileId) {
        try {
            Optional<Profile> p = profileRepo.findById(profileId);
            if (p.isPresent()) {

                p.get().setName(profileRequest.getName());
                p.get().setLastName(profileRequest.getLastName());
                p.get().setAge(profileRequest.getAge());
                p.get().setPhoneNumber(profileRequest.getPhoneNumber());
                p.get().setSoCCCD(profileRequest.getSoCCCD());
                p.get().setDiaChiNha(profileRequest.getDiaChiNha());
                p.get().setPhuongXa(profileRequest.getPhuongXa());
                p.get().setHuyenThi(profileRequest.getHuyenThi());
                p.get().setTinhThanh(profileRequest.getTinhThanh());


                return new ResponseEntity<>(profileRepo.save(p.get()), HttpStatus.OK);
            } else {
                throw new InvalidConfigurationPropertyValueException("profileId", profileId, "Not found");
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping(value = "/{id}", consumes = {"*/*"})
    public ResponseEntity<String> deleteProfile(@PathVariable("id") Long id) {
        try {
            if (profileRepo.findById(id).get().getId().equals(id)) {
                profileRepo.deleteById(id);
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            } else
                throw new InvalidConfigurationPropertyValueException("id", id, "Not found");
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
