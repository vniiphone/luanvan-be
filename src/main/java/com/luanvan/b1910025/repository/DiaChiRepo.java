package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiaChiRepo  extends JpaRepository<DiaChi, Long> {

    Optional<DiaChi> findById(Long id);

    List<DiaChi> findByUser_Id(Long userId);
}
