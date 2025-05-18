package com.demo1.service;

import com.demo1.dao.ProjectDao;
import com.demo1.dao.ProjectDaoImp;
import com.demo1.modal.Project;

public class ProjectServiceImp implements ProjectService {
    public ProjectDao projectDao;
    public ProjectServiceImp() {
        projectDao = new ProjectDaoImp();
    }
    @Override
    public boolean addProject(Project project) {
        return projectDao.addProject(project);
    }

    @Override
    public boolean addDocuments(String title, String description, String filePath, int projectId) {
        return projectDao.addDocuments(title, description, filePath, projectId);
    }

    @Override
    public int getProjectId(String title) {
        return projectDao.getProjectId(title);
    }
}
