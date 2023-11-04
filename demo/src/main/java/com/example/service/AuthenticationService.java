package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Buyer;
import com.example.model.Seller;
import com.example.repository.BuyerRepository;
import com.example.repository.SellerRepository;

@Service
public class AuthenticationService {
    

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public Object signIn(String email, String password) throws Exception{

        //create a variable called loginBuyer of the Optional Class
        //
        Optional<Buyer> loginBuyer = buyerRepository.findbyEmail(email);
        if(loginBuyer.isPresent() && loginBuyer.get().getPassword().equals(password)){
        return loginBuyer.get();
        }
    Optional<Seller> loginSeller = sellerRepository.findByEmail(email);
    if(loginSeller.isPresent() && loginSeller.get().getPassword().equals(password)){
        return loginSeller.get();
    }

    throw new RuntimeException("Invalid credentials");
}

}