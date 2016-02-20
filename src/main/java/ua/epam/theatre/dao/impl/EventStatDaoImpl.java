package ua.epam.theatre.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.epam.theatre.dao.EventStatDao;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.EventStat;

import java.util.List;

/**
 * Created by Daria on 14.02.2016.
 */
@Repository
public class EventStatDaoImpl implements EventStatDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(EventStat eventStat) {
        getSession().persist(eventStat);
    }

    public void remove(EventStat eventStat) {
        getSession().delete(eventStat);
    }

    public EventStat findByEvent(Event event) {
        Query query = getSession().createQuery("from EventStat where eventId= :eventid");
        query.setLong("eventid", event.getId());
        EventStat stat = (EventStat)query.uniqueResult();
        return stat;
    }

    @Override
    public List<EventStat> getAll() {
        Query query = getSession().createQuery("from EventStat");
        List<EventStat> events = query.list();
        return events;
    }
}
