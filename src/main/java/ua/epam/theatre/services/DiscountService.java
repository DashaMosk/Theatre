package ua.epam.theatre.services;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.User;

import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
public class DiscountService {
    List<DiscountStrategy> discounts;

    public List<DiscountStrategy> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountStrategy> discounts) {
        this.discounts = discounts;
    }

    double getDiscount(User user, Event event) {
        double pDisc = 0.0;
        for(DiscountStrategy d : discounts) {
            pDisc += d.getDiscount(user, event);
        }
        return (pDisc < 100.0)?pDisc:100.0;
    }
}
