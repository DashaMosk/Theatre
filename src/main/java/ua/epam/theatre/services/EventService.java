package ua.epam.theatre.services;

import ua.epam.theatre.entity.Auditorium;
import ua.epam.theatre.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
public interface EventService {
    void create(Event event);
    void remove(Event event);
    List<Event> getByName(String name);
    List<Event> getAll();
    void assignAuditorium(Event event, Auditorium auditorium, LocalDateTime date);
}
