package com.example.demo;

import org.springframework.stereotype.Service;


@Service
public class CarManagerService {

    private CarRepository carRepository;

    public Car save(Car c){
        this.carRepository.save(c);
        return c;
    }
}
