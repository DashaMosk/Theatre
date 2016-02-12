package ua.epam.theatre.dao;

import org.springframework.stereotype.Repository;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Schedule;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Daria on 07.02.2016.
 */
@Repository
public class EventDaoImpl implements EventDao {
    public void create(Event event) {
        event.setId(TheatreDB.eventMap.size()+1);
        for (Schedule s : event.getSchedule()) {
            s.setId(TheatreDB.scheduleMap.size()+1);
            TheatreDB.scheduleMap.put(TheatreDB.scheduleMap.size()+1, s);
        }

        TheatreDB.eventMap.put(TheatreDB.eventMap.size()+1, event);
    }

    public void remove(Event event) {
        TheatreDB.eventMap.remove(event.getId());
        for (Schedule s : event.getSchedule()) {
            TheatreDB.scheduleMap.remove(s.getId());
        }
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

}
