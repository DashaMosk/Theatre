package ua.epam.theatre.services;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Daria_Moskalenko on 2/6/2016.
 */
public interface DiscontService {
    List<DiscountStrategy> getDiscounts();
    void setDiscounts(List<DiscountStrategy> discounts);
    double getDiscount(User user, Event event, LocalDate date);
}
