package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Car;
import com.example.model.Cart;
import com.example.repository.CarRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {
    
    @Autowired
    CarRepository carRepository;


    public Cart getCart(HttpSession session){
        Cart cart = (Cart)session.getAttribute("cart");
        if (cart == null){
            cart = new Cart();
        session.setAttribute("cart", cart);
        }
        return cart;
    }

    public void addtoCart(Long id, HttpSession session){
        Cart cart = getCart(session);
        Car carToAdd = carRepository.findById(id).orElse(null);
        if (carToAdd != null){
            cart.getItemsinCart().add(carToAdd);
            
        }
    }

    public void removeFromCart(Long id, HttpSession session) {
        Cart cart = getCart(session);
        List<Car> itemsToRemove = new ArrayList<>();
        for (Car car : cart.getItemsinCart()) {
            if (car.getId().equals(id)) {
                itemsToRemove.add(car);
            }
        }
        cart.getItemsinCart().removeAll(itemsToRemove);
    }
}
