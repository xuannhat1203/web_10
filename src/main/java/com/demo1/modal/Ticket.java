package com.demo1.modal;
import java.util.Date;
import java.util.List;
public class Ticket {
    private String movieTitle;
    private Date showTime;
    private List<Seat> seats;
    private double totalAmount;

    public Ticket(String movieTitle, Date showTime, List<Seat> seats, double totalAmount) {
        this.movieTitle = movieTitle;
        this.showTime = showTime;
        this.seats = seats;
        this.totalAmount = totalAmount;
    }

    public Ticket() {

    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public CharSequence getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "movieTitle='" + movieTitle + '\'' +
                ", showTime=" + showTime +
                ", seats=" + seats +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
