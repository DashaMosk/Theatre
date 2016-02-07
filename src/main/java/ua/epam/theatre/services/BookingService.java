package ua.epam.theatre.services;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.entity.User;

import java.util.ArrayList;

/**
 * Created by Daria on 06.02.2016.
 */
public interface BookingService {
    double getTicketPrice(Event event, int seat);
    void bookTicket(User user, Ticket ticket);
    ArrayList<Ticket> getTicketsForEvent(Event event);
}
