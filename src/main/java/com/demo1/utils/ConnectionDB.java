package com.demo1.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_sesstion10?createDatabaseIfNotExist=true&useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456$";

    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            System.out.println("Kết nối thất bại");
            e.fillInStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement callSt){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callSt != null) {
            try {
                callSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}