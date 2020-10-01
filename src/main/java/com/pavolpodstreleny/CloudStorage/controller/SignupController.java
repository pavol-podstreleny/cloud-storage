package com.pavolpodstreleny.CloudStorage.controller;

import javax.validation.Valid;

import com.pavolpodstreleny.CloudStorage.entity.User;
import com.pavolpodstreleny.CloudStorage.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getSignupPage(@ModelAttribute User user) {
        return "signup";
    }

    @PostMapping
    public String submitUserForm(@Valid User user, Errors errors, RedirectAttributes redirectAttributes, Model model) {
        // Check validation error
        if (errors.hasErrors()) {
            return "signup";
        }

        // Check if username already exists -> 2 users are not allowed to have the same
        // username
        if (!userService.isUsernameAvailable(user.getUsername())) {
            model.addAttribute("errorUserExists", "Username already exists.");
            return "signup";
        }

        // Save user
        int rowsAdded = userService.createUser(user);

        // Check save
        if (rowsAdded < 0) {
            model.addAttribute("errorUndefined", "Something went wrong. Try again please.");
            return "signup";
        }

        // Succesfull sign up
        redirectAttributes.addFlashAttribute("signupSuccess", true);
        return "redirect:/login";
    }

}