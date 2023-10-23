package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.DiaChi;
import com.luanvan.b1910025.models.Profile;
import com.luanvan.b1910025.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile, Long> {

    Optional<Profile> findById(Long id);

    List<Profile> findByUser_Id(Long userId);

    List<Profile> findProfileByUser_Id(Long id);
}
