package ua.epam.theatre.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.epam.theatre.dao.TicketsDao;
import ua.epam.theatre.entity.Ticket;

/**
 * Created by Daria on 08.02.2016.
 */
@Repository
public class TicketsDaoImpl implements TicketsDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Ticket ticket) {
        getSession().persist(ticket);
    }

    public void remove(Ticket ticket) {
        getSession().delete(ticket);
    }

    @Override
    public void update(Ticket ticket) {
        getSession().merge(ticket);
    }
}
