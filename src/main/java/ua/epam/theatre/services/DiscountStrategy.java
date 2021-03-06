package ua.epam.theatre.services;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.User;

import java.time.LocalDate;

/**
 * Created by Daria on 07.02.2016.
 */
public interface DiscountStrategy {
    double getDiscount(User user, Event event, LocalDate date);
}
