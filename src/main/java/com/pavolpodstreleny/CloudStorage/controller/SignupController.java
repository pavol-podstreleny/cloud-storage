package com.pavolpodstreleny.CloudStorage.controller;

import javax.validation.Valid;

import com.pavolpodstreleny.CloudStorage.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/signup")
@Slf4j
public class SignupController {

    @GetMapping
    public String getSignupPage(@ModelAttribute User user) {
        return "signup";
    }

    @PostMapping
    public String submitUserForm(@Valid User user, Errors errors, RedirectAttributes redirectAttributes) {
        log.info(user.toString());
        if (errors.hasErrors()) {
            return "signup";
        }

        // Succesfully sign in
        redirectAttributes.addAttribute("signup-success", true);

        return "redirect:/login";
    }

}