package com.example.backend_lab2.repository;

import com.example.backend_lab2.entity.Location;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l FROM Location l WHERE l.isPublic = true AND l.deleted = false")
    List<Location> findAllPublicLocations();

    @Query("SELECT l FROM Location l WHERE l.isPublic = true AND l.categoryId = :categoryId AND l.deleted = false")
    List<Location> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT l FROM Location l WHERE l.userId = :userId AND l.deleted = false")
    List<Location> findAllByUserId(@Param("userId") String userId);

    @Query("SELECT l FROM Location l WHERE ST_Distance(l.coordinate, :center) <= :radius AND l.deleted = false")
    List<Location> findAllWithinRadius(@Param("center") Point<G2D> center, @Param("radius") double radius);
}