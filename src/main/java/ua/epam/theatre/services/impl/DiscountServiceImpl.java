package ua.epam.theatre.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.User;
import ua.epam.theatre.services.DiscontService;
import ua.epam.theatre.services.DiscountStrategy;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
@Service
public class DiscountServiceImpl implements DiscontService {
    @Autowired
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
           double disc = d.getDiscount(user, event, date);
           if(pDisc < disc) {
               pDisc = disc;
           }
        }
        return pDisc;
    }
}
