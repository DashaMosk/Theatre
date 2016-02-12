package ua.epam.theatre.dao;

import org.springframework.stereotype.Repository;
import ua.epam.theatre.entity.Ticket;

/**
 * Created by Daria on 08.02.2016.
 */
@Repository
public class TicketsDaoImpl implements TicketsDao {
    public void save(Ticket ticket) {
        ticket.setId(TheatreDB.ticks.size()+1);
        TheatreDB.ticks.put(TheatreDB.ticks.size()+1, ticket);
    }

    public void remove(Ticket ticket) {
        TheatreDB.ticks.remove(ticket.getId());
    }
}
