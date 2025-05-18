package com.demo1.dao;

import java.util.Date;

public interface BookingDao {
    boolean addBooking(String title, Date showTime, String seat, int totalAmount);
}
