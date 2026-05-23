/*
Parent class is called car
This class contains:
-Attributes
-Constructor full amd empty
-Methods
-Getter
-Setter
 */
package com.lorieenterprise;

public class Car {

    // Attribute
    private String brand;
    private String model;
    private int year;
    private double pricePerDay;
    private boolean isAvailable;

    // Full constructor
    public Car(String brand, String model, int year, double pricePerDay, boolean isAvailable) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
    }

    // Empty constructor
    public Car(){
        this.brand = "";
        this.model = "";
        this.year = 0;
        this.pricePerDay = 0;
        this.isAvailable = true;
    }

    // Methods
    public void displayCarInfo(){
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
        System.out.println("Price per day: " + this.pricePerDay);
        System.out.println("Available: " + this.isAvailable);
    }

    public double calculatePrice(int numberOfDays){
       return this.pricePerDay * numberOfDays;
    }

    public void rentCar(){
        this.isAvailable = false;
    }

    // Getter
    public String getBrand() {
        return brand;
    }
    public String getModel() {
       return model;
    }
    public int getYear() {
        return year;
    }
    public double getPricePerDay() {
        return pricePerDay;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}

