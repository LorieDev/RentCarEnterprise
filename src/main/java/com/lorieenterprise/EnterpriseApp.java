/*
This class called EnterpriseApp, is the main start program.
This class contains:
- Application entry point
- Object creation
- Polymorphism demonstration
- Logging for application flow
 */

package com.lorieenterprise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnterpriseApp {

    private static final Logger logger = LoggerFactory.getLogger(EnterpriseApp.class);

    public static void main(String[] args) {

        logger.info("EnterpriseApp started");

        // Create EconomyCar object
        EconomyCar economy1 = new EconomyCar(
                "Toyota",
                "Corolla",
                2023,
                45.0,
                true,
                0.10
        );

        logger.info("Created EconomyCar: {} {}", economy1.getBrand(), economy1.getModel());

        // Create LuxuryCar object
        LuxuryCar luxury1 = new LuxuryCar(
                "BMW",
                "M4",
                2025,
                150.0,
                true,
                "2 Door Coupe"
        );

        logger.info("Created LuxuryCar: {} {}", luxury1.getBrand(), luxury1.getModel());

        // Polymorphism array
        Car[] cars = {economy1, luxury1};

        logger.info("Processing cars...");

        // Loop through array
        for(Car car : cars){

            car.displayCarInfo();

            double price = car.calculatePrice(3);

            logger.info("Calculated price for {} {}: {}",
                    car.getBrand(),
                    car.getModel(),
                    price
            );

            System.out.println("Rental Price for 3 days: " + price);
            System.out.println("----------------------");
        }

        logger.info("EnterpriseApp finished execution");
    }
}