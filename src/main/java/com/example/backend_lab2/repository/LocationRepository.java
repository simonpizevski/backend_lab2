package com.example.backend_lab2.repository;

import com.example.backend_lab2.entity.Location;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByIsPublicTrue();

    @Query("SELECT l FROM Location l WHERE l.category.id = :categoryId AND l.isPublic = true")
    List<Location> findByCategoryIdAndIsPublic(Long categoryId);

    @Query("SELECT l FROM Location l WHERE l.userId = :userId")
    List<Location> findByUserId(Long userId);

    @Query("SELECT l FROM Location l WHERE ST_Distance(l.coordinate, :center) <= :radius")
    List<Location> findWithinRadius(Point<G2D> center, double radius);
}