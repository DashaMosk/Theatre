package ua.epam.theatre.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.epam.theatre.dao.BookingDao;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Orders;
import ua.epam.theatre.entity.Ticket;

import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
@Repository
public class BookingDaoImpl implements BookingDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrder(Orders order) {
        getSession().persist(order);
    }

    public List<Ticket> getTicketsForEvent(Event event) {
        Query query = getSession().createQuery("from Ticket where event= :event");
        query.setEntity("event", event);
        List<Ticket> tickets = query.list();
        return tickets;
    }

}
