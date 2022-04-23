package com.carona.abc.caronabc.controller;

import com.carona.abc.caronabc.user.User;
import com.carona.abc.caronabc.user.UserRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class AppController {

    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        log.info("User: {}", user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup_form");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView setTravelInformation(String initialAddress,
                                             String finalAddress) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
