package com.demo1.dao;

import com.demo1.modal.Project;

public interface ProjectDao {
    boolean addProject(Project project);
    boolean addDocuments(String title, String description, String filePath,int projectId);
    int getProjectId(String title);
}
