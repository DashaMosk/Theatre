package ua.epam.theatre.services;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.User;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
public class DiscountServiceImpl implements DiscontService{
    List<DiscountStrategy> discounts;

    public List<DiscountStrategy> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountStrategy> discounts) {
        this.discounts = discounts;
    }

    public double getDiscount(User user, Event event, LocalDate date) {
        double pDisc = 0.0;
        for(DiscountStrategy d : discounts) {
            pDisc += d.getDiscount(user, event, date);
        }
        return (pDisc < 100.0)?pDisc:100.0;
    }
}
