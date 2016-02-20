package ua.epam.theatre.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.epam.theatre.dao.BookingDao;
import ua.epam.theatre.entity.*;
import ua.epam.theatre.services.BookingService;
import ua.epam.theatre.services.TicketService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private DiscountServiceImpl discountService;
    @Autowired
    private TicketService ticketService;

    private void applyDiscount(Ticket ticket, double discont) {
        double newPrice = ticket.getPrice() -  ticket.getPrice() * discont / 100.0;
        ticket.setPrice(newPrice);
    }
    public double getTicketPrice(Event event, int seat, Timestamp dateTime) {
        double price = event.getBasePrice();
        if(event.getRating() ==  Rating.HIGH) {
            price = price * 1.2;
        }
        List<Schedule> schedules = event.getSchedule();

        for(Schedule s : schedules){
            if(s.getStartTime().equals(dateTime)) {
                if(s.getAuditorium().getVip().contains(seat)) {
                    price = price * 2;
                }
            }
        }
        System.out.println("> Calculate price for event: "+event+", seat "+seat+", price "+price);
        return price;
    }

    public void bookLuckyTicket(User user, Ticket ticket) {
        Orders order = new Orders();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Schedule sc = ticket.getSchedule();
        ticket.setPrice(0.0);
        tickets.add(ticket);
        user.addMessage("You are lucky! Free ticket for you");
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setUser(user);
        tickets.add(ticket);
        order.setTickets(tickets);
        bookingDao.saveOrder(order);
        ticket.setOrder(order);
        ticketService.update(ticket);
        System.out.println("> Book ticket: ");
        System.out.println(ticket);
    }

    public void bookTicket(User user, Ticket ticket) {
        Orders order = new Orders();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Schedule sc = ticket.getSchedule();
        LocalDateTime date = sc.getStartTime().toLocalDateTime();
        double disc = discountService.getDiscount(user, ticket.getEvent(), date.toLocalDate());
        if (disc > 0.0) {
            applyDiscount(ticket, disc);
            System.out.println("> Discount for "+user.getName()+ " is "+disc);
        }
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setUser(user);
        tickets.add(ticket);
        order.setTickets(tickets);
        bookingDao.saveOrder(order);
        ticket.setOrder(order);
        ticketService.update(ticket);
        System.out.println("> Book ticket: ");
        System.out.println(ticket);
    }

    public List<Ticket> getTicketsForEvent(Event event) {
        return bookingDao.getTicketsForEvent(event);
    }
}
