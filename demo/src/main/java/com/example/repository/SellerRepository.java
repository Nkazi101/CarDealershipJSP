package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Buyer;
import com.example.model.Seller;

import java.util.List;
import java.util.Optional;


@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {
    
    @Query(value="select * from sellers where email = :email", nativeQuery=true)
    public Optional<Seller> findByEmail(String email);
}

