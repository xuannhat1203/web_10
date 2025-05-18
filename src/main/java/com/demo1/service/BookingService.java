package com.demo1.service;

import java.util.Date;

public interface BookingService {
    boolean addBooking(String title, Date showTime, String seat, int totalAmount);
}
