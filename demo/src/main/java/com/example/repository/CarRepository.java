package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    
    List<Car> findByMakeModel(String makeModel);
}
