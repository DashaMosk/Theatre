package ua.epam.theatre.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.epam.theatre.dao.EventDao;
import ua.epam.theatre.entity.Event;

import java.util.List;

/**
 * Created by Daria on 07.02.2016.
 */
@Repository
public class EventDaoImpl implements EventDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void create(Event event) {
        getSession().persist(event);
    }

    public void remove(Event event) {
        getSession().delete(event);
    }

    public List<Event> getByName(String name) {
        Query query = getSession().createQuery("from Event where name= :name");
        query.setString("name", name);
        List<Event> events = query.list();
        return events;
    }

    public List<Event> getAll() {
        Query query = getSession().createQuery("from Event");
        List<Event> events = query.list();
        return events;
    }
}
