package com.demo1.controller;

import com.demo1.modal.Ticket;
import com.demo1.service.BookingService;
import com.demo1.service.BookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {
    public BookingServiceImp bookingServiceImp = new BookingServiceImp();
    @GetMapping
    public String showBookingForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "bookingForm";
    }

    @PostMapping
    public String bookTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
        String seats = String.join(",", ticket.getSeats());
        bookingServiceImp.addBooking(ticket.getMovieTitle(), ticket.getShowTime(), seats, ticket.getTotalAmount());
        model.addAttribute("ticket", ticket);
        return "ticketSummary";
    }
}

