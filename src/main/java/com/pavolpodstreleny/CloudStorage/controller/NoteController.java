package com.pavolpodstreleny.CloudStorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;
import com.pavolpodstreleny.CloudStorage.entity.Note;
import com.pavolpodstreleny.CloudStorage.entity.NoteForm;
import com.pavolpodstreleny.CloudStorage.service.NoteService;
import com.pavolpodstreleny.CloudStorage.service.UserService;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    @GetMapping
    public String getNotesView(Principal principal, Model model, @ModelAttribute NoteForm noteForm) {
        List<Note> notes = noteService.provideNotes(userService.getCurrentUserId(principal));
        model.addAttribute("notes", notes);
        model.addAttribute("user", principal.getName());
        return "note";
    }

    @PostMapping("delete")
    public String deleteNotePage(@RequestParam Integer noteId, RedirectAttributes redirectAttributes,
            Principal principal) {

        int userId = userService.getCurrentUserId(principal);
        Note note = noteService.provideNote(userId, noteId);
        if (note != null) {
            final int dbFileId = noteService.removeNote(noteId);
            if (dbFileId == -1) {
                redirectAttributes.addFlashAttribute("messageFail", "Problem occurred while deleting note!");
            } else {
                redirectAttributes.addFlashAttribute("messageSuccess", "You successfully deleted note!");
            }
        } else {
            redirectAttributes.addFlashAttribute("messageFail", "You are not allowed to delete this note!");
        }
        return "redirect:/notes";
    }

    @PostMapping
    public String noteUpload(@Valid NoteForm noteForm, Errors errors, Model model,
            RedirectAttributes redirectAttributes, Principal principal) {

        noteForm.setUserId(userService.getCurrentUserId(principal));
        if (errors.hasErrors()) {
            List<Note> notes = noteService.provideNotes(userService.getCurrentUserId(principal));
            model.addAttribute("notes", notes);
            model.addAttribute("user", principal.getName());
            return "note";
        }

        // Note does not exists yet
        if (noteForm.getId() == null) {
            int resultId = noteService.createNote(noteForm);
            if (resultId == -1) {
                redirectAttributes.addFlashAttribute("messageFail",
                        "Problem occurred while saving note into database! Please, try again.");
            } else {
                redirectAttributes.addFlashAttribute("messageSuccess", "Note successfully saved!");
            }
        } else {
            // Note id exists update
            Note notedb = noteService.provideNote(noteForm.getUserId(), noteForm.getId());
            if (notedb != null) {
                int resultId = noteService.updateNote(noteForm);
                if (resultId == -1) {
                    redirectAttributes.addFlashAttribute("messageFail",
                            "Problem occurred while updating note in database! Please, try again.");
                } else {
                    redirectAttributes.addFlashAttribute("messageSuccess", "Note successfully updated!");
                }
            } else {
                redirectAttributes.addFlashAttribute("messageFail", "You are not allowed to modify this note.");
            }
        }
        return "redirect:/notes";
    }
}