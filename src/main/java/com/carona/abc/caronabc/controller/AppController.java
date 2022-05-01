package com.carona.abc.caronabc.controller;

import com.carona.abc.caronabc.user.UserDAO;
import com.carona.abc.caronabc.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class AppController {

    private final UserService userService;

    @RequestMapping
    public ModelAndView getUsers(ModelMap modelMap) {
        List<UserDAO> userList = userService.getUsers();
        modelMap.addAttribute("users", userList);
        modelMap.addAttribute("userDAO", new UserDAO());
        return new ModelAndView("index");
    }

    @PostMapping
    public ModelAndView createUser(ModelMap modelMap, @ModelAttribute UserDAO userDAO) {
        UserDAO user = userService.createUser(userDAO);
        return new ModelAndView("index");
    }
}
