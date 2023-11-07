package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Car;
import com.example.repository.CarRepository;
import com.example.service.CarService;

@Controller

public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    public String carInventory(Model model){

        List<Car> car = carService.findAvailableCars();

        model.addAttribute("cars", car);


        return "availablecars";
    }

    @GetMapping("/addcar")
    public String addCar(Model model){

        model.addAttribute("car", new Car());

        return "addcar";
    }


    @PostMapping("/addcar")
    public String addCar(@ModelAttribute Car car, Model model){

        carRepository.save(car);

        model.addAttribute("car", new Car());

        return "availablecars";
        
        
    }

    @GetMapping("/{id}")
    public String carDetails(@PathVariable Long id, Model model){

       Car car = carService.getCar(id);

        model.addAttribute("car", car);

        return "cardetails";
    }

    @GetMapping("/searchCar")
public String searchCar(@RequestParam("makeModel") String makeModel, Model model){
    List<Car> cars = carService.findCarsByModel(makeModel);
    model.addAttribute("cars", cars);
    return "availablecars"; 
}

@GetMapping("/editcar/{id}")
public String editCarForm(@PathVariable Long id, Model model) {
    Car car = carService.findById(id);
    if (car != null) {
        model.addAttribute("car", car);
        return "editcar";
    } else {
        return "redirect:/cars";
    }
}

    @PostMapping("/editcar")
    public String editCar(@ModelAttribute Car car, Model model) {
        carService.editCar(car);
        return "redirect:/cars";
    }


    
    
}
