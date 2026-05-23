/*
This class called EnterpriseApp, is the main start program.
This class contains:
-
-
-
-
 */
package com.lorieenterprise;

public class EnterpriseApp {

    public static void main(String[] args) {

        // Create EconomyCar object
        EconomyCar economy1 = new EconomyCar(
                "Toyota",
                "Corolla",
                2023,
                45.0,
                true,
                0.10
        );

        // Create LuxuryCar object
        LuxuryCar luxury1 = new LuxuryCar(
                "BMW",
                "M4",
                2025,
                150.0,
                true,
                "2 Door Coupe"
        );

        // Polymorphism array
        Car[] cars = {economy1, luxury1};

        // Loop through array
        for(Car car : cars){

            car.displayCarInfo();

            System.out.println("Rental Price for 3 days: "
                    + car.calculatePrice(3));

            System.out.println("----------------------");
        }

    }

}
