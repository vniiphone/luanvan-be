package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.Tour;
import com.luanvan.b1910025.models.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepo extends JpaRepository<Tour, Long>, JpaSpecificationExecutor<Tour> {
}
