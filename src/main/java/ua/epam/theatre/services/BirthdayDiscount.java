package ua.epam.theatre.services;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.User;

import java.time.LocalDate;

/**
 * Created by Daria on 07.02.2016.
 */
public class BirthdayDiscount implements DiscountStrategy {
    private double discPerCent;

    public BirthdayDiscount() {}

    public BirthdayDiscount(double discPerCent) {
        this.discPerCent = discPerCent;
    }

    private boolean hasBirthday(User user, LocalDate date) {
        return user.getBirthDay() == date;
    }
    public double getDiscount(User user, Event event, LocalDate date) {
        if(hasBirthday(user, date)) {
            return discPerCent;
        }
        return 0.0;
    }
}
