package com.example.backend_lab2.dto;

import jakarta.validation.constraints.NotNull;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

public class LocationDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long categoryId;

    @NotNull
    private Boolean isPublic;

    @NotNull
    private Point<G2D> coordinate;

    @NotNull
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull Long categoryId) {
        this.categoryId = categoryId;
    }

    public @NotNull Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(@NotNull Boolean aPublic) {
        isPublic = aPublic;
    }

    public @NotNull Point<G2D> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(@NotNull Point<G2D> coordinate) {
        this.coordinate = coordinate;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }
}
