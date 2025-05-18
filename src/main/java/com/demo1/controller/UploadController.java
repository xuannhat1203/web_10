package com.demo1.controller;

import com.demo1.modal.UploadFile;
import com.demo1.service.UploadServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    public UploadServiceImp uploadServiceImp = new UploadServiceImp();
    @GetMapping("/upload")
    public String showForm(Model model) {
        model.addAttribute("uploadFile", new UploadFile());
        return "uploadForm";
    }
    @PostMapping("/upload")
    public String processUpload(@ModelAttribute("uploadFile") UploadFile uploadFile,Model model) throws IOException {
        MultipartFile file = uploadFile.getFile();
        if (!file.isEmpty()) {
            String uploadDir = "D:/uploads";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String uploadPath = uploadDir + File.separator + file.getOriginalFilename();
            file.transferTo(new File(uploadPath));
            uploadServiceImp.addUpload(uploadPath,uploadFile.getDescription());
            model.addAttribute("message", "Upload thành công: " + file.getOriginalFilename());
        } else {
            model.addAttribute("message", "Vui lòng chọn file.");
        }
        return "uploadForm";
    }
}
