package com.pavolpodstreleny.CloudStorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @GetMapping
    public String getNotesView(Principal principal, Model model) {
        List<String> empty = new ArrayList<String>();
        model.addAttribute("nodes", empty);
        model.addAttribute("user", principal.getName());
        return "note";
    }

}