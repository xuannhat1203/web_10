package com.demo1.dao;

import com.demo1.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;

public class BookingDaoImp implements BookingDao {
    @Override
    public boolean addBooking(String title, Date showTime, String seat, int totalAmount) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            String sql = "{call sp_insert_ticket (?, ?, ?, ?)}";
            cstmt = conn.prepareCall(sql);
            cstmt.setString(1, title);
            cstmt.setDate(2, new java.sql.Date(showTime.getTime()));
            cstmt.setString(3, seat);
            cstmt.setInt(4, totalAmount);
            return cstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }
}
