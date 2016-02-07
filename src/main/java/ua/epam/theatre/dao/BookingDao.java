package ua.epam.theatre.dao;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.Ticket;

import java.util.ArrayList;

/**
 * Created by Daria on 06.02.2016.
 */
public interface BookingDao {
    void saveOrder(Order order);
    ArrayList<Ticket> getTicketsForEvent(Event event);
}
