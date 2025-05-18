package com.demo1.dao;

import com.demo1.modal.Project;
import com.demo1.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class ProjectDaoImp implements ProjectDao {
    @Override
    public boolean addProject(Project project) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call add_new_project(?,?)}");
            cstmt.setString(1, project.getName());
            cstmt.setString(2, project.getDescription());
            return cstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addDocuments(String title, String description, String filePath, int projectId) {
        Connection con = null;
        CallableStatement cs = null;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call add_new_documents(?,?,?,?)}");
            cs.setString(1, title);
            cs.setString(2, description);
            cs.setString(3, filePath);
            cs.setInt(4, projectId);
            return cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }

    @Override
    public int getProjectId(String title) {
        Connection con = null;
        CallableStatement cs = null;
        int id = 0;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call get_id_project(?)}");
            cs.setString(1, title);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return id;
    }
}
