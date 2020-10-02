package com.pavolpodstreleny.CloudStorage.controller;

import com.pavolpodstreleny.CloudStorage.entity.Credential;
import com.pavolpodstreleny.CloudStorage.entity.CredentialForm;
import com.pavolpodstreleny.CloudStorage.service.CredentialService;
import com.pavolpodstreleny.CloudStorage.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/credentials")
public class CredentialController {

    private final UserService userService;

    private final CredentialService credentialService;

    public CredentialController(final UserService userService, final CredentialService credentialService) {
        this.userService = userService;
        this.credentialService = credentialService;
    }

    @GetMapping
    public String getNotesView(Principal principal, Model model, @ModelAttribute CredentialForm credentialForm) {
        List<Credential> credentials = credentialService.provideCredentials(userService.getCurrentUserId(principal));
        model.addAttribute("credentials", credentials);
        model.addAttribute("user", principal.getName());
        return "credential";
    }

    @PostMapping("delete")
    public String deleteNotePage(@RequestParam Integer credentialId, RedirectAttributes redirectAttributes,
            Principal principal) {
        int userId = userService.getCurrentUserId(principal);
        Credential credential = credentialService.provideCredential(userId, credentialId);
        if (credential != null) {
            final int dbFileId = credentialService.removeCredential(credentialId);
            if (dbFileId == -1) {
                redirectAttributes.addFlashAttribute("messageFail", "Problem occurred while deleting credential!");
            } else {
                redirectAttributes.addFlashAttribute("messageSuccess", "You successfully deleted credential!");
            }
        } else {
            redirectAttributes.addFlashAttribute("messageFail", "You are not allowed to delete this credential!");
        }
        return "redirect:/credentials";
    }

    @PostMapping
    public String credentialUploadPage(@Valid CredentialForm credentialForm, Errors errors, Model model,
            RedirectAttributes redirectAttributes, Principal principal) {

        if (errors.hasErrors()) {
            List<Credential> credentials = credentialService
                    .provideCredentials(userService.getCurrentUserId(principal));
            model.addAttribute("credentials", credentials);
            model.addAttribute("user", principal.getName());
            return "credential";
        }

        credentialForm.setUserId(userService.getCurrentUserId(principal));

        if (credentialForm.getId() == null) {
            // New note
            int resultId = credentialService.createCredential(credentialForm);
            if (resultId == -1) {
                redirectAttributes.addFlashAttribute("messageFail",
                        "Problem occurred while saving note into database! Please, try again.");
            } else {
                redirectAttributes.addFlashAttribute("messageSuccess", "Credential successfully saved!");
            }
        } else {
            // Updated note
            Credential credential = credentialService.provideCredential(credentialForm.getUserId(),
                    credentialForm.getId());
            if (credential != null) {
                int resultId = credentialService.updateCredential(credentialForm);
                if (resultId == -1) {
                    redirectAttributes.addFlashAttribute("messageFail",
                            "Problem occurred while updating credential in database! Please, try again.");
                } else {
                    redirectAttributes.addFlashAttribute("messageSuccess", "Credential successfully updated!");
                }
            } else {
                redirectAttributes.addFlashAttribute("messageFail", "You are not allowed to modify this credential.");
            }
        }

        return "redirect:/credentials";

    }

}