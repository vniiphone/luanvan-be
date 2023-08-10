package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.DiaChi;
import com.luanvan.b1910025.models.KhachSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhachSanRepo extends JpaRepository<KhachSan, Long> {

    Optional<KhachSan> findById(Long id);

//    List<KhachSan> findAllByKhachSan_id(Long KhachSan_Id);
}
