package com.lorieenterprise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    public void testEconomyCarPrice() {

        // Arrange
        EconomyCar economyCar = new EconomyCar(
                "Toyota",
                "Corolla",
                2024,
                50.0,
                true,
                0.10
        );

        // Act
        double totalPrice = economyCar.calculatePrice(2);

        // Assert
        assertEquals(90.0, totalPrice);

    }

    @Test
    public void testLuxuryCarStyle() {

        // Arrange
        LuxuryCar luxuryCar = new LuxuryCar(
                "BMW",
                "M4",
                2025,
                150.0,
                true,
                "2 Door Coupe"
        );

        // Act
        String style = luxuryCar.getCarStyle();

        // Assert
        assertEquals("2 Door Coupe", style);

    }

}
