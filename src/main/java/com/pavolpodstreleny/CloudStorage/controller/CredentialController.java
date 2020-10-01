package com.pavolpodstreleny.CloudStorage.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.pavolpodstreleny.CloudStorage.entity.Credential;
import com.pavolpodstreleny.CloudStorage.entity.CredentialForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/credential")
public class CredentialController {

    @GetMapping
    public String getNotesView(Principal principal, Model model, @ModelAttribute CredentialForm credentialForm) {
        List<Credential> credentials = new ArrayList<Credential>();
        credentials.add(new Credential(1, "http://skuska.sk", "Palo", "key", "Super password", 1));
        model.addAttribute("credentials", credentials);
        model.addAttribute("user", principal.getName());
        return "credential";

    }

}