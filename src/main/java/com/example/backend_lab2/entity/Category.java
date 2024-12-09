package com.example.backend_lab2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "category", schema = "backend_lab2")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @Size(max = 255)
    @NotNull
    @Column
    private String symbol;

    @Size(max = 500)
    @NotNull
    @Column(length = 500, nullable = false)
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

    public @NotNull String getSymbol() {
        return symbol;
    }

    public void setSymbol(@NotNull String symbol) {
        this.symbol = symbol;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }
}
