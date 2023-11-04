package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Buyer;
import com.example.repository.BuyerRepository;

@Service
public class BuyerService {


    @Autowired
    BuyerRepository buyerRepository;

    public Buyer signUp(Buyer buyer){

        return buyerRepository.save(buyer);


    }
}
