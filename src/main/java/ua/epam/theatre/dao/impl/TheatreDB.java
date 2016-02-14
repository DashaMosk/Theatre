package ua.epam.theatre.dao.impl;

import org.springframework.stereotype.Component;
import ua.epam.theatre.entity.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daria on 07.02.2016.
 */
@Component
public class TheatreDB {
    public static Map<Integer, Order> orders;
    public static Map<Integer, Ticket> ticks;
    public static Map<String, User> users;
    public static Map<Integer, Event> eventMap;
    public static Map<Integer,Schedule> scheduleMap;
    public static Map<Event, EventStat> eventStatMap;

    public TheatreDB() {
        orders = new HashMap<Integer, Order>();
        ticks = new HashMap<Integer, Ticket>();
        users = new HashMap<String, User>();
        eventMap = new HashMap<Integer, Event>();
        scheduleMap = new HashMap<Integer, Schedule>();
        eventStatMap = new HashMap<Event, EventStat>();
    }
}
