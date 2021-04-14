package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarManagerService {

    private CarRepository carRepository;

    public Car save(Car c){
        this.carRepository.save(c);
        return c;
    }

    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    public Car getCarByMark(String mark) {
        return carRepository.findByMark(mark);
    }
}
