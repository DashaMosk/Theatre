package ua.epam.theatre.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.theatre.dao.EventDao;
import ua.epam.theatre.entity.Auditorium;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Schedule;
import ua.epam.theatre.services.EventService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Daria on 07.02.2016.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public void create(Event event) {
        eventDao.create(event);
        System.out.println("New event: "+event);
    }

    public void remove(Event event) {
        eventDao.remove(event);
        System.out.println("Remove "+ event);
    }

    public ArrayList<Event> getByName(String name) {
        return eventDao.getByName(name);
    }

    public Collection<Event> getAll() {
        return eventDao.getAll();

    }

    public void assignAuditorium(Event event, Auditorium auditorium, LocalDateTime date) {
        ArrayList<Schedule> schedules = event.getSchedule();
        for(Schedule s : schedules) {
            s.setAuditorium(auditorium);
        }
        System.out.println("Set auditorium "+auditorium.getName()+" for event "+event.getName());
    }
}
