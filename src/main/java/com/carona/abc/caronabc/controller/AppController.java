package com.carona.abc.caronabc.controller;

import com.carona.abc.caronabc.user.UserDAO;
import com.carona.abc.caronabc.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final UserService userService;

    @GetMapping("/registro")
    public ModelAndView getUsers(ModelMap modelMap) {
        List<UserDAO> userList = userService.getUsers();
        modelMap.addAttribute("users", userList);
        modelMap.addAttribute("userDAO", new UserDAO());
        return new ModelAndView("index");
    }

    @PostMapping("/registro")
    public ModelAndView createUser(ModelMap modelMap, @ModelAttribute UserDAO userDAO) {
        UserDAO user = userService.createUser(userDAO);
        return new ModelAndView("index");
    }
}
