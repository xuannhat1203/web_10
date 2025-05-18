package com.demo1.service;

import com.demo1.modal.Project;

public interface ProjectService {
    boolean addProject(Project project);
    boolean addDocuments(String title, String description, String filePath,int projectId);
    int getProjectId(String title);
}
