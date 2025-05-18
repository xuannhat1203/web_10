package com.demo1.controller;

import com.demo1.modal.Project;
import com.demo1.service.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ProjectController {

    public ProjectServiceImp projectService = new ProjectServiceImp();

    @GetMapping("/project")
    public String project(Model model) {
        model.addAttribute("project", new Project());
        return "projectForm";
    }

    @PostMapping("/project")
    public String projectSubmit(@ModelAttribute("project") Project project,
                                @RequestParam("files") MultipartFile[] files,
                                Model model) throws IOException {

        projectService.addProject(project);

        int id = projectService.getProjectId(project.getName());

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                File dir = new File("D:/uploads");
                if (!dir.exists()) dir.mkdirs();

                String uploadPath = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();
                file.transferTo(new File(uploadPath));

                projectService.addDocuments(project.getName(), file.getOriginalFilename(), uploadPath, id);
            }
        }

        model.addAttribute("message", "Dự án đã được tạo thành công!");
        return "projectForm";
    }
}
