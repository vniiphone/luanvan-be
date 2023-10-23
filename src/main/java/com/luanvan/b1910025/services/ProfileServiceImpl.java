package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.LoaiTour;
import com.luanvan.b1910025.models.Profile;
import com.luanvan.b1910025.models.Tour;
import com.luanvan.b1910025.models.User;
import com.luanvan.b1910025.payloads.requests.LoaiTourRequest;
import com.luanvan.b1910025.payloads.requests.ProfileRequest;
import com.luanvan.b1910025.repository.ProfileRepo;
import com.luanvan.b1910025.repository.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Override
    public Profile createProfile(ProfileRequest profileRequest) {
        User user  = userRepo.findById(profileRequest.getUser_id()).orElseThrow();

        Profile profile = new Profile(
                profileRequest.getName(),
                profileRequest.getLastName(),
                profileRequest.getAge(),
                profileRequest.getPhoneNumber(),
                profileRequest.getSoCCCD(),
                profileRequest.getDiaChiNha(),
                profileRequest.getPhuongXa(),
                profileRequest.getHuyenThi(),
                profileRequest.getTinhThanh(),
                user
        );
        return profileRepo.save(profile);
    }

    @Override
    public Optional<Profile> updateProfile(Long profileId, ProfileRequest profileRequest) {
        Optional<Profile> profile = profileRepo.findById(profileId);

        if (profile.isPresent()) {
            profile.get().setName(profileRequest.getName());
            profile.get().setLastName(profileRequest.getLastName());
            profile.get().setAge(profileRequest.getAge());
            profile.get().setPhoneNumber(profileRequest.getPhoneNumber());
            profile.get().setSoCCCD(profileRequest.getSoCCCD());
            profile.get().setDiaChiNha(profileRequest.getDiaChiNha());
            profile.get().setPhuongXa(profileRequest.getPhuongXa());
            profile.get().setHuyenThi(profileRequest.getHuyenThi());
            profile.get().setTinhThanh(profileRequest.getTinhThanh());
            profileRepo.save(profile.get());
            return  profile;
        }else {
            throw new InvalidConfigurationPropertyValueException("profileId", profileId, "Not found");
        }
    }

    @Override
    public void deleteProfile(Long profileId) {
        Optional<Profile> profile = profileRepo.findById(profileId);
        if (profile.isPresent()) {
//            profile.get().setVisible(false);
            profileRepo.deleteById(profileId);
        } else {
            throw new InvalidConfigurationPropertyValueException("profileId", profileId, "Not found");
        }
    }

    @Override
    public Profile getASingleProfile(Long profileId) {
        // TODO Auto-generated method stub
        return profileRepo.findById(profileId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("profileId: ", profileId, "Not found"));

    }

    @Override
    public List<Profile> getAllProfile() {
        return profileRepo.findAll();
    }

    @Override
    public List<Profile> getAllProfileByUserId(Long userId) {
        return profileRepo.findProfileByUser_Id(userId);
    }
}
