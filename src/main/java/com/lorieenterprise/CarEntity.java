/*
This class is called CarEntity

This class contains:
- JPA entity
- Fields for car data
- Validation constraints for input data
*/

package com.lorieenterprise;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Car brand (cannot be empty)
    @NotBlank
    private String brand;

    // Car model (cannot be empty)
    @NotBlank
    private String model;

    // Car price (must be positive)
    @Positive
    private double price;

    // Car year (must be positive)
    @Positive
    private int year;

    // Car color (cannot be empty)
    @NotBlank
    private String color;

    // Car availability (default = true)
    private boolean available = true;

    // Default constructor
    public CarEntity() {}

    // Constructor with parameters
    public CarEntity(String brand, String model, double price, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.year = year;
        this.color = color;
    }

    // Get car ID
    public Long getId() {
        return id;
    }

    // Get car brand
    public String getBrand() {
        return brand;
    }

    // Set car brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Get car model
    public String getModel() {
        return model;
    }

    // Set car model
    public void setModel(String model) {
        this.model = model;
    }

    // Get car price
    public double getPrice() {
        return price;
    }

    // Set car price
    public void setPrice(double price) {
        this.price = price;
    }

    // Get car year
    public int getYear() {
        return year;
    }

    // Set car year
    public void setYear(int year) {
        this.year = year;
    }

    // Get car color
    public String getColor() {
        return color;
    }

    // Set car color
    public void setColor(String color) {
        this.color = color;
    }

    // Get car availability
    public boolean isAvailable() {
        return available;
    }

    // Set car availability
    public void setAvailable(boolean available) {
        this.available = available;
    }
}