package ua.epam.theatre.dao;

import ua.epam.theatre.entity.Event;

import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
public interface EventDao {
    void create(Event event);
    void remove(Event event);
    List<Event> getByName(String name);
    List<Event> getAll();
}
