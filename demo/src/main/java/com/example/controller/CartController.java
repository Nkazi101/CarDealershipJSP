package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Cart;
import com.example.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
    

    @Autowired
    CartService cartService;


    @GetMapping
    public String viewCart(Model model, HttpSession session){
        Cart cart = cartService.getCart(session);
        model.addAttribute("cartItems", cart.getItemsinCart());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addtoCart(@PathVariable Long id, HttpSession session){

        cartService.addtoCart(id, session);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, HttpSession session) {
        cartService.removeFromCart(id, session);
        return "redirect:/cart";
    }

}
