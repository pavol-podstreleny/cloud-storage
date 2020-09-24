package com.pavolpodstreleny.CloudStorage.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import com.pavolpodstreleny.CloudStorage.entity.File;
import com.pavolpodstreleny.CloudStorage.service.FileService;
import com.pavolpodstreleny.CloudStorage.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/files")
@Slf4j
public class FileController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @GetMapping
    public String getFileView(Principal principal, Model model) {
        final int currentUserId = userService.getCurrentUserId(principal);
        model.addAttribute("files", fileService.provideFiles(currentUserId));
        model.addAttribute("user", principal.getName());
        log.info(model.getAttribute("files").toString());
        return "file";
    }

    @PostMapping
    public String uploadFile(@RequestParam("uploadFile") MultipartFile uploadedFile, Principal principal,
            RedirectAttributes redirect) {

        final String originalFileName = uploadedFile.getOriginalFilename();

        if (originalFileName.equals("")) {
            redirect.addFlashAttribute("messageFail", "You have to specify name of file to upload!");
            return "redirect:/files";
        }

        // Check if user does not have file with same name
        int userId = userService.getCurrentUserId(principal);
        File file = fileService.provideFile(originalFileName, userId);
        if (file != null) {
            redirect.addFlashAttribute("messageFail", "You can not upload file with the same name!");
        } else {
            final int fileId = fileService.uploadFile(uploadedFile, userId);
            if (fileId == -1) {
                redirect.addFlashAttribute("messageFail", "Problem occurred while saving " + originalFileName + "!");
            } else {
                redirect.addFlashAttribute("messageSuccess", "You successfully uploaded " + originalFileName + "!");
            }
        }
        return "redirect:/files";
    }

    @PostMapping("delete")
    public String deleteFilePage(@RequestParam Integer fileID, RedirectAttributes redirectAttributes,
            Principal principal) {
        int userId = userService.getCurrentUserId(principal);
        File file = fileService.provideFile(fileID, userId);
        if (file != null) {
            final int dbFileId = fileService.removeFile(fileID);
            if (dbFileId == -1) {
                redirectAttributes.addFlashAttribute("messageFail", "Problem occurred while deleting file!");
            } else {
                redirectAttributes.addFlashAttribute("messageSuccess", "You successfully deleted file!");
            }
        } else {
            redirectAttributes.addFlashAttribute("messageFail", "You are not allowed to delete this file!");
        }

        return "redirect:/files";
    }

    @GetMapping("{fileName}")
    public StreamingResponseBody downloadFile(HttpServletResponse response, @PathVariable String fileName,
            Principal principal) {

        int userId = userService.getCurrentUserId(principal);

        File file = fileService.provideFile(fileName, userId);

        response.setContentType(file.getContentType());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFileName() + "\"");

        return outputStream -> {
            outputStream.write(file.getData(), 0, file.getData().length);
        };
    }

}
