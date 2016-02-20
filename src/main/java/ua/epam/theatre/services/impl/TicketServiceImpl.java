package ua.epam.theatre.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.epam.theatre.dao.TicketsDao;
import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.services.TicketService;

/**
 * Created by Daria on 08.02.2016.
 */
@Service
@Transactional
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

    public void update(Ticket ticket) {
        ticketsDao.update(ticket);
    }
}
