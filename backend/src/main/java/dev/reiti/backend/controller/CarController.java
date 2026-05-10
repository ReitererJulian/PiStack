package dev.reiti.backend.controller;

import dev.reiti.backend.model.Car;
import dev.reiti.backend.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable UUID id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found: " + id));
    }
}
