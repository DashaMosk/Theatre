package ua.epam.theatre.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.entity.User;
import ua.epam.theatre.services.DiscountStrategy;
import ua.epam.theatre.services.UserService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Daria on 07.02.2016.
 */
@Component("free10thdiscount")
public class Free10ThDiscount implements DiscountStrategy {
    @Value("50.00")
    private double discPerCent;
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Free10ThDiscount() {}

    public Free10ThDiscount(double discPerCent) {
        this.discPerCent = discPerCent;
    }

    public double getDiscount(User user, Event event, LocalDate date) {
        List<Ticket> tickets = userService.getBookedTickets(user);
        if(tickets.size() == 9) {
            return discPerCent;
        }
        return 0.0;
    }
}
