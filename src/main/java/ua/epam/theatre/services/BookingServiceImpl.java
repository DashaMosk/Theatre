package ua.epam.theatre.services;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.entity.User;
import ua.epam.theatre.dao.BookingDao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Daria on 06.02.2016.
 */
public class BookingServiceImpl implements BookingService {

    private BookingDao bookingDao;
    private DiscountService discountService;

    private double priceRating;

    public void setBookingDao(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public void setPriceRating(double priceRating) {
        this.priceRating = priceRating;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    private void applyDiscount(Ticket ticket, double discont) {
        double newPrice = ticket.getPrice() * discont / 100.0;
        ticket.setPrice(newPrice);
    }
    public double getTicketPrice(Event event, int seat) {
        double price = event.getBasePrice();
        if(event.getRating() > priceRating) {
            price = price * 1.2;
        }
        if(event.getAuditorium().getVip().contains(seat)) {
            price = price * 2;
        }
        System.out.println("Calculate price for event: "+event+", seat "+seat+", price "+price);
        return price;
    }

    public void bookTicket(User user, Ticket ticket) {
        Order order = new Order();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        double disc = discountService.getDiscount(user, ticket.getEvent());
        if (disc > 0.0) {
            applyDiscount(ticket, disc);
            System.out.println("Discount for "+user.getName()+ " is "+disc);
        }
        tickets.add(ticket);
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setUser(user);
        order.setTickets(tickets);
        System.out.println("book ticket: ");
        System.out.println(ticket);
        bookingDao.saveOrder(order);
    }

    public ArrayList<Ticket> getTicketsForEvent(Event event) {
        return bookingDao.getTicketsForEvent(event);
    }
}
