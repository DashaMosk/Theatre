package ua.epam.theatre.services;

import ua.epam.theatre.dao.BookingDao;
import ua.epam.theatre.entity.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Daria on 06.02.2016.
 */
public class BookingServiceImpl implements BookingService {

    private BookingDao bookingDao;
    private DiscountServiceImpl discountService;

    public void setBookingDao(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public void setDiscountService(DiscountServiceImpl discountService) {
        this.discountService = discountService;
    }

    private void applyDiscount(Ticket ticket, double discont) {
        double newPrice = ticket.getPrice() * discont / 100.0;
        ticket.setPrice(newPrice);
    }
    public double getTicketPrice(Event event, int seat, Timestamp dateTime) {
        double price = event.getBasePrice();
        if(event.getRating() ==  Rating.HIGH) {
            price = price * 1.2;
        }
        ArrayList<Schedule> schedules = event.getSchedule();

        for(Schedule s : schedules){
            if(s.getStartTime().equals(dateTime)) {
                if(s.getAuditorium().getVip().contains(seat)) {
                    price = price * 2;
                }
            }
        }
        System.out.println("Calculate price for event: "+event+", seat "+seat+", price "+price);
        return price;
    }

    public void bookTicket(User user, Ticket ticket) {
        Order order = new Order();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Schedule sc = ticket.getSchedule();
        LocalDateTime date = sc.getStartTime().toLocalDateTime();
        double disc = discountService.getDiscount(user, ticket.getEvent(), date.toLocalDate());
        if (disc > 0.0) {
            applyDiscount(ticket, disc);
            System.out.println("Discount for "+user.getName()+ " is "+disc);
        }
        tickets.add(ticket);
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setUser(user);
        order.setTickets(tickets);
        System.out.println("Book ticket: ");
        System.out.println(ticket);
        bookingDao.saveOrder(order);
    }

    public ArrayList<Ticket> getTicketsForEvent(Event event) {
        return bookingDao.getTicketsForEvent(event);
    }
}
