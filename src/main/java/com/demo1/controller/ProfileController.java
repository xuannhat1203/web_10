package com.demo1.controller;

import com.demo1.modal.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @PostMapping("/uploadAvatar")
    public String uploadAvatar(@ModelAttribute("userProfile") UserProfile userProfile, Model model) {
        MultipartFile file = userProfile.getAvatar();
        String uploadDir = "D:/uploads";
        String fileName = file.getOriginalFilename();
        try {
            if (file != null && !file.isEmpty()) {
                file.transferTo(new File(uploadDir + fileName));
                model.addAttribute("avatarPath", "/uploads/" + fileName);
            }
        } catch (IOException e) {
            model.addAttribute("message", "File upload failed!");
            return "uploadForm";
        }
        model.addAttribute("username", userProfile.getUsername());
        model.addAttribute("message", "Avatar uploaded successfully!");
        return "uploadForm";
    }
}

