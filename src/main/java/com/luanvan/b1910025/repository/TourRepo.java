package com.luanvan.b1910025.repository;

import com.luanvan.b1910025.models.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepo extends JpaRepository<Tour, Long>{

    @Query(value = "SELECT * FROM tour WHERE name LIKE BINARY CONCAT('%',:text,'%')", nativeQuery = true)
    List<Tour> findByNameLike(@Param("text") String text);

    boolean existsByLoaiTourId(Long id);

//    @Query(value = "SELECT * FROM tour WHERE loai_tour_id LIKE BINARY CONCAT('%',:number,'%')", nativeQuery = true)
    List<Tour> findTourByLoaiTourId( Long id);

    @Query(value = "SELECT * FROM tour WHERE visible = 1", nativeQuery = true)
    List<Tour> findVisibleTours();

    @Query(value = "SELECT * FROM tour WHERE visible = 1", nativeQuery = true)
    Page<Tour> findVisibleToursView(Pageable pageable);

    @Query(value = "SELECT * FROM tour WHERE loai_tour_id = ?1 AND visible = 1", nativeQuery = true)
    List<Tour> findTourByLoaiTourIdAndVisible(Long loaiTourId);

}
