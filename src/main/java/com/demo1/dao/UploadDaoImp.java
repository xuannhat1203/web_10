package com.demo1.dao;

import com.demo1.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;

public class UploadDaoImp implements UploadDao {
    @Override
    public boolean addUpload(String fileName, String description) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call add_new_file(?,?)}");
            cs.setString(1, fileName);
            cs.setString(2, description);
            return cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }
}
