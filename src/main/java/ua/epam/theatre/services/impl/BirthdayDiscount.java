package ua.epam.theatre.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.User;
import ua.epam.theatre.services.DiscountStrategy;

import java.time.LocalDate;

/**
 * Created by Daria on 07.02.2016.
 */
@Component("birthdaydiscount")
public class BirthdayDiscount implements DiscountStrategy {
    @Value("5.00")
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
