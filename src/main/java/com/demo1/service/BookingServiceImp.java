package com.demo1.service;

import com.demo1.dao.BookingDao;
import com.demo1.dao.BookingDaoImp;

import java.util.Date;

public class BookingServiceImp implements BookingService {
    public BookingDao bookingDao;
    public BookingServiceImp() {
        bookingDao = new BookingDaoImp();
    }
    @Override
    public boolean addBooking(String title, Date showTime, String seat, int totalAmount) {
        return bookingDao.addBooking(title, showTime, seat, totalAmount);
    }
}
