package com.demo1.dao;

import com.demo1.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;

public class DocumentDaoImp implements DocumentDao {
    @Override
    public boolean addDocument(String title, String description, String filePath) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.openConnection();
            String sql = "{call add_new_document(?, ?, ?)}";
            cs = conn.prepareCall(sql);
            cs.setString(1, title);
            cs.setString(2, description);
            cs.setString(3, filePath);
            return cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }
}
