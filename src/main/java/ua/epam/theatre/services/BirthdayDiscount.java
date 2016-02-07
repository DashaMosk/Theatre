package ua.epam.theatre.services;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.User;

import java.util.Date;

/**
 * Created by Daria on 07.02.2016.
 */
public class BirthdayDiscount implements DiscountStrategy {
    private double discPerCent;

    public BirthdayDiscount() {}

    public BirthdayDiscount(double discPerCent) {
        this.discPerCent = discPerCent;
    }

    private boolean hasBirthday(User user, Event event) {
        return user.getBirthDay() == Date.from(event.getStartTime().toInstant());
    }
    public double getDiscount(User user, Event event) {
        if(hasBirthday(user, event)) {
            return discPerCent;
        }
        return 0.0;
    }
}
