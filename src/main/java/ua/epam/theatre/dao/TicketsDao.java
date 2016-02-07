package ua.epam.theatre.dao;

import ua.epam.theatre.entity.Ticket;

/**
 * Created by Daria on 08.02.2016.
 */
public interface TicketsDao {
    void save(Ticket ticket);
    void remove(Ticket ticket);
}
