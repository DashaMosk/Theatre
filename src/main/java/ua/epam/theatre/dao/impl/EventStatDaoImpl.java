package ua.epam.theatre.dao.impl;

import org.springframework.stereotype.Repository;
import ua.epam.theatre.dao.EventStatDao;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.EventStat;

/**
 * Created by Daria on 14.02.2016.
 */
@Repository
public class EventStatDaoImpl implements EventStatDao {
    public void save(EventStat eventStat) {
        eventStat.setId(TheatreDB.eventStatMap.size() + 1);
        TheatreDB.eventStatMap.put(eventStat.getEvent(), eventStat);
    }

    public void remove(EventStat eventStat) {
        TheatreDB.eventStatMap.remove(eventStat.getEvent());
    }

    public EventStat findByEvent(Event event) {
        return TheatreDB.eventStatMap.get(event);
    }
}
