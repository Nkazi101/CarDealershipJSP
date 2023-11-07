package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Car;
import com.example.repository.CarRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;
    

    public List<Car> findAvailableCars(){

        //select * from car
        return carRepository.findAll();
    }

    public Car getCar(Long id){
        return carRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Car Not Found"));
    }

    public List<Car> findCarsByModel(String makeModel){
        return carRepository.findByMakeModel(makeModel);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void editCar(Car car) {
        carRepository.save(car);
    }

    // public List<Car> findDiscountedAvailableCars(){
        
    //     List<Car> dicountedCars = new ArrayList<>();

    //     LocalDate cutoffDate = LocalDate.now().minusDays(120);

    //     for(Car car: carRepository.findAll()){

    //     }
    }

