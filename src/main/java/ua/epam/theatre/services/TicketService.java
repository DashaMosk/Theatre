package ua.epam.theatre.services;

import ua.epam.theatre.entity.Ticket;

/**
 * Created by Daria on 08.02.2016.
 */
public interface TicketService {
    void save(Ticket ticket);
    void remove(Ticket ticket);
}
