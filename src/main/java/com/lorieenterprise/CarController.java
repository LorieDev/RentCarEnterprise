/*
This class is called CarController

This class contains:
- REST API controller
- Home endpoint
- Save car to database endpoint
- Retrieve cars from database endpoint
- Update car endpoint
- Delete car endpoint
 */

package com.lorieenterprise;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Home endpoint
    @GetMapping("/")
    public String homePage(){
        logger.info("Home endpoint accessed");
        return "Welcome to RentCarEnterprise API";
    }

    // Save car to database
    @PostMapping("/cars")
    public CarEntity saveCar(@Valid @RequestBody CarEntity car){
        logger.info("Saving new car: {} {}", car.getBrand(), car.getModel());
        return carRepository.save(car);
    }

    // Retrieve cars from database
    @GetMapping("/cars")
    public List<CarEntity> getCars(){
        logger.info("Fetching all cars from database");
        return carRepository.findAll();
    }

    // Update car
    @PutMapping("/cars/{id}")
    public CarEntity updateCar(@PathVariable Long id, @Valid @RequestBody CarEntity updatedCar){

        logger.info("Updating car with ID: {}", id);

        CarEntity car = carRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Car not found with ID: {}", id);
                    return new RuntimeException("Car not found");
                });

        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setPrice(updatedCar.getPrice());
        car.setYear(updatedCar.getYear());
        car.setColor(updatedCar.getColor());
        car.setAvailable(updatedCar.isAvailable());

        logger.info("Car updated successfully with ID: {}", id);

        return carRepository.save(car);
    }

    // Delete car
    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable Long id){

        logger.info("Deleting car with ID: {}", id);

        carRepository.deleteById(id);

        logger.info("Car deleted successfully with ID: {}", id);

        return "Car deleted successfully!";
    }
}