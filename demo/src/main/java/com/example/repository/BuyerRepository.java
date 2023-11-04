package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.model.Buyer;
import java.util.List;
import java.util.Optional;


@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Long> {

    // @Query("SELECT u FROM Buyer u WHERE u.email = :email and u.password = :password")
    // public Buyer signIn(String email, String password);

    @Query(value="select * from buyer where email =?1", nativeQuery=true)
    public Optional<Buyer> findbyEmail(String email);

    
}
