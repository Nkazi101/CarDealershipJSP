package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Buyer;
import com.example.repository.BuyerRepository;
import com.example.service.AuthenticationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthenticationController {
    

     @Autowired
    private AuthenticationService authService;

    @Autowired
    private BuyerRepository buyerRepository;


    // @RequestMapping(value ="/sign-up", method = RequestMethod.GET)
    @GetMapping("/sign-up")
    public String signUp(Model model){

        return "sign-up";
    }

    @PostMapping("/sign-up")
    public ModelAndView signUp(@ModelAttribute Buyer buyer, Model model){

        buyerRepository.save(buyer);

        return new ModelAndView("sign-in", "buyer", new Buyer());
    }

      @GetMapping("/sign-in")
     public String signIn(Model model){
 
        model.addAttribute("buyer", new Buyer());
 
         return "sign-in";
 
     }
    
   
        // @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
        @PostMapping("/sign-in")
    public String signIn(@RequestParam("email") String email, 
                         @RequestParam("password") String password, 
                         HttpSession session) throws Exception {
        try {
            Object user = authService.signIn(email, password);
            session.setAttribute("user", user);
            session.setAttribute("userType", user.getClass().getSimpleName());
            return "redirect:/";
        } catch (RuntimeException e) {
            return "sign-in";
        }
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, HttpSession session, Model model){

        Object user = (Object) session.getAttribute("user");

        if(user == null){
            return "sign-in";
        }else
        {

        model.addAttribute("user", user);

        return "profile";
    }
}

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/sign-in";
    }
}

