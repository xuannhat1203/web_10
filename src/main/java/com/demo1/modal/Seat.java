package com.demo1.modal;

public class Seat {
    private String row;
    private int number;
    private boolean isBooked;
    public Seat(String row, int number, boolean isBooked) {
        this.row = row;
        this.number = number;
        this.isBooked = isBooked;
    }
    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
