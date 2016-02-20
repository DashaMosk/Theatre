package ua.epam.theatre.dao;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Orders;
import ua.epam.theatre.entity.Ticket;

import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
public interface BookingDao {
    void saveOrder(Orders order);
    List<Ticket> getTicketsForEvent(Event event);
}
