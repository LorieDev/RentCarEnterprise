/*
This class called EconomyCar, is the first child class.
This class contains:
-Attribute
-Full Constructor and Call the super class
_ Also we add Override so it can get its own price.
 */

package com.lorieenterprise;

public class EconomyCar extends Car {

    // Attribute
    double discountPercent;

    // Full constructor and call the parent class
    public EconomyCar(String brand, String model, int year, double pricePerDay, boolean isAvailable, double discountPercent) {
        super(brand, model, year, pricePerDay, isAvailable);
        this.discountPercent = discountPercent;
    }

    // Override method
    @Override
    public double calculatePrice(int numberOfDays){
        double originalPrice = this.getPricePerDay() * numberOfDays;
        double discountAmount = originalPrice * discountPercent;
        return originalPrice - discountAmount;
    }



}
