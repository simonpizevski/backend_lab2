package com.example.backend_lab2.dto;

import jakarta.validation.constraints.NotNull;

public class CategoryDTO {

    public CategoryDTO(Long id, String name, String symbol, String description) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
    }

    private Long id;

    @NotNull
    private String name;

    private String description;

    private String symbol;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
