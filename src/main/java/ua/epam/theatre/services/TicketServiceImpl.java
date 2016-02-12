package ua.epam.theatre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.theatre.dao.TicketsDao;
import ua.epam.theatre.entity.Ticket;

/**
 * Created by Daria on 08.02.2016.
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketsDao ticketsDao;

    public void setTicketsDao(TicketsDao ticketsDao) {
        this.ticketsDao = ticketsDao;
    }

    public void save(Ticket ticket) {
        ticketsDao.save(ticket);
    }

    public void remove(Ticket ticket) {
        ticketsDao.remove(ticket);
    }
}
