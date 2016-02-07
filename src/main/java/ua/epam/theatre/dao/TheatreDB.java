package ua.epam.theatre.dao;

import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Daria on 07.02.2016.
 */
public class TheatreDB {
    public static Map<Integer, Order> orders;
    public static Map<Integer, Ticket> ticks;
    public static Map<String, User> users;
    public static Map<Integer, Event> eventMap;

    public TheatreDB() {
        orders = new HashMap<Integer, Order>();
        ticks = new HashMap<Integer, Ticket>();
        users = new HashMap<String, User>();
        eventMap = new HashMap<Integer, Event>();
    }
}
