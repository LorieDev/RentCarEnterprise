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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Home endpoint
    @GetMapping("/")
    public String homePage(){
        return "Welcome to RentCarEnterprise API";
    }

    // Save car to database
    @PostMapping("/cars")
    public CarEntity saveCar(@Valid @RequestBody CarEntity car){
        return carRepository.save(car);
    }

    // Retrieve cars from database
    @GetMapping("/cars")
    public List<CarEntity> getCars(){
        return carRepository.findAll();
    }

    // Update car
    @PutMapping("/cars/{id}")
    public CarEntity updateCar(@PathVariable Long id, @Valid @RequestBody CarEntity updatedCar){

        CarEntity car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setPrice(updatedCar.getPrice());
        car.setYear(updatedCar.getYear());      // 🔥 NEW
        car.setColor(updatedCar.getColor());    // 🔥 NEW
        car.setAvailable(updatedCar.isAvailable());

        return carRepository.save(car);
    }

    // Delete car
    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable Long id){

        carRepository.deleteById(id);

        return "Car deleted successfully!";
    }
}