package com.carona.abc.caronabc.controller;

import com.carona.abc.caronabc.user.User;
import com.carona.abc.caronabc.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ModelAndView viewHomePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView showRegistrationForm(Model model) {

        model.addAttribute("user", new User());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup_form");
        return modelAndView;
    }

    @PostMapping("/process_register")
    public ModelAndView processRegister(User user) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register_success");
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView listUsers(Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        return modelAndView;
    }
}
