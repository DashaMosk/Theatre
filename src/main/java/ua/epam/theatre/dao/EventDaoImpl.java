package ua.epam.theatre.dao;

import ua.epam.theatre.entity.Auditorium;
import ua.epam.theatre.entity.Event;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Daria on 07.02.2016.
 */
public class EventDaoImpl implements EventDao {
    public void create(Event event) {
        event.setId(TheatreDB.eventMap.size()+1);
        TheatreDB.eventMap.put(TheatreDB.eventMap.size()+1, event);
    }

    public void remove(Event event) {
        TheatreDB.eventMap.remove(event.getId());
    }

    public ArrayList<Event> getByName(String name) {
        ArrayList<Event> events = new ArrayList<Event>();
        for(Event e : TheatreDB.eventMap.values()) {
            if(e.getName().equals(name)) {
                events.add(e);
            }
        }
        return events;
    }

    public Collection<Event> getAll() {
        return  TheatreDB.eventMap.values();
    }

    public void assignAuditorium(Event event, Auditorium auditorium) {
        event.setAuditorium(auditorium);
    }
}
