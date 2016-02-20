package ua.epam.theatre.dao;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.EventStat;

import java.util.List;

/**
 * Created by Daria on 14.02.2016.
 */
public interface EventStatDao {
    void save(EventStat eventStat);
    void remove(EventStat eventStat);
    EventStat findByEvent(Event event);
    List<EventStat> getAll();
}
