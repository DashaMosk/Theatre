package ua.epam.theatre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;

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
        ArrayList<Order> ord = userService.getBookedTickets(user);
        int count = 0;
        for(Order o : ord) {
            count += o.getTickets().size();
        }
        if(count == 9) {
            return discPerCent;
        }
        return 0.0;
    }
}
