package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.Profile;
import com.luanvan.b1910025.payloads.requests.LoaiTourRequest;
import com.luanvan.b1910025.payloads.requests.ProfileRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProfileService {


    Profile createProfile(ProfileRequest profileRequest);

    Optional<Profile> updateProfile(Long profileId, ProfileRequest profileRequest);

    void deleteProfile(Long profileId);

    Profile getASingleProfile(Long profileId);

    List<Profile> getAllProfile();

    List<Profile> getAllProfileByUserId(Long userId);
}
