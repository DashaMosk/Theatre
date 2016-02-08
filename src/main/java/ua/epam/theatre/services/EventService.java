package ua.epam.theatre.services;

import ua.epam.theatre.entity.Auditorium;
import ua.epam.theatre.entity.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Daria on 06.02.2016.
 */
public interface EventService {
    void create(Event event);
    void remove(Event event);
    ArrayList<Event> getByName(String name);
    Collection<Event> getAll();
    void assignAuditorium(Event event, Auditorium auditorium, LocalDateTime date);
}
