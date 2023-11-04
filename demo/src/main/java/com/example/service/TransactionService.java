package com.example.service;

import com.example.model.Cart;
import com.example.model.Transaction;
import com.example.model.Car;
import com.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository; // You should create this repository interface

    public boolean createTransaction(Cart cart) {
        // Here you would convert the Cart into an Order entity and save it using the OrderRepository.
        // For now, let's assume we are creating and saving a simple order with today's date as the order date.
        
        // Assuming Order is an entity similar to Car that has an order date, total amount, etc.
        Transaction transaction = new Transaction();
        transaction.setDate(LocalDate.now());
        transaction.setTotalAmount(calculateTotalAmount(cart));
        transaction.setItems(cart.getItemsinCart()); // Assuming Cart has a list of items, which are Cars
        
        // Save the order to the database
        transactionRepository.save(transaction);
        return true;
    }
    
    private BigDecimal calculateTotalAmount(Cart cart) {
        // Logic to sum up the total price of cars in the cart
        BigDecimal total = BigDecimal.ZERO;
        for (Car car : cart.getItemsinCart()) {
            total = total.add(car.getPrice());
        }
        return total;
    }
}
