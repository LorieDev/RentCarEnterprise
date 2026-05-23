/*
This class called LuxuryCar, is a second child class.
This class contains:
- Attribute
- Full Constructor and call supper class
- Override method and display info
 */
package com.lorieenterprise;

public class LuxuryCar extends Car {

    //Attribute
    private String carStyle;

    // Full constructor and call the parent class
    public LuxuryCar(String brand, String model, int year, double pricePerDay, boolean isAvailable, String carStyle) {
        super(brand, model, year, pricePerDay, isAvailable);
        this.carStyle = carStyle;
    }

    // Method
    public String getCarStyle() {
        return carStyle;
    }
    public void setCarStyle(String carStyle) {}

    // Override method
    public void displayCarInfo(){

        System.out.println("Luxury Car Information");
        System.out.println("Brand: " + this.getBrand());
        System.out.println("Model: " + this.getModel());
        System.out.println("Year: " + this.getYear());
        System.out.println("Price Per Day: " + this.getPricePerDay());
        System.out.println("Available: " + this.isAvailable());
        System.out.println("Car Style: " + this.carStyle);

    }


}
