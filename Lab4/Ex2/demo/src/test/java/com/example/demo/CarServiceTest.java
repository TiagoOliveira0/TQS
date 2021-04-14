package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock( lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carManagerService;

    @BeforeEach
    public void setUp() {
        Car c1 = new Car("ford", "fiesta");
        c1.setId(111L);

        Car c2 = new Car("seat", "ibiza");
        Car c3 = new Car("mercedes", "benz");

        List<Car> allCars = Arrays.asList(c1, c2, c3);

        Mockito.when(carRepository.findByMark(c1.getMark())).thenReturn(c1);
        Mockito.when(carRepository.findByMark(c2.getMark())).thenReturn(c2);
        Mockito.when(carRepository.findByMark("wrong_name")).thenReturn(null);
        Mockito.when(carRepository.findById(c1.getId())).thenReturn(Optional.of(c1));
        Mockito.when(carRepository.findAll()).thenReturn(allCars);
        Mockito.when(carRepository.findById(-99L)).thenReturn(Optional.empty());
    }

    @Test
    public void whenValidMark_thenECarShouldBeFound() {
        String mark = "ford";
        Car found = carManagerService.getCarByMark(mark);

        assertThat(found.getMark()).isEqualTo(mark);
    }
}
