package com.demo1.controller;

import com.demo1.modal.Document;
import com.demo1.service.DocumentService;
import com.demo1.service.DocumentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class DocumentController {
    public DocumentServiceImp documentService = new DocumentServiceImp();
    @GetMapping("/uploadDocument")
    public String showUploadForm(Model model) {
        model.addAttribute("document", new Document());
        return "documentForm";
    }
    @PostMapping("/uploadDocument")
    public String handleFileUpload(@ModelAttribute("document") Document document, Model model) throws IOException {
        MultipartFile file = document.getFile();
        if (!file.isEmpty()) {
            String uploadDir = "D:/uploads";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String uploadPath = uploadDir + File.separator + file.getOriginalFilename();
            file.transferTo(new File(uploadPath));

            documentService.addDocument(document.getTitle(), document.getDescription(), uploadPath);
            model.addAttribute("message", "Upload thành công: " + file.getOriginalFilename());
        } else {
            model.addAttribute("message", "Vui lòng chọn file.");
        }
        return "documentForm";
    }

}
