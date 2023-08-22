package com.softdyze.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softdyze.entity.User;
import com.softdyze.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/signup")
    public String loadSignUpPage(Model model) {
        model.addAttribute("user", new User()); // Create a User instance to bind form data
        return "signup";
    }

    @PostMapping("/signup")
    public ModelAndView createUser(User user) {
        userService.createUser(user);
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("message", "User created successfully");
        return modelAndView;
    }

    @GetMapping("/login")
    public String loadLoginPage(Model model) {
        model.addAttribute("user", new User()); // Create a User instance to bind form data
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(User user, HttpSession session, Model model) {
        User foundUser = userService.loginUser(user.getUsername(), user.getPassword());

        if (foundUser != null) {
            session.setAttribute("loggedInUser", foundUser);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Stay on login page with an error message
        }
    }

    @GetMapping("/home")
    public String homePage(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        model.addAttribute("loggedInUser", loggedInUser);
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
