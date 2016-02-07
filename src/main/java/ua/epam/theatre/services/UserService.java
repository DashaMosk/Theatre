package ua.epam.theatre.services;

import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.User;

import java.util.ArrayList;

/**
 * Created by Daria on 06.02.2016.
 */
public interface UserService {
    void register(User user);
    void remove(User user);
    User getUserByEmail(String email);
    ArrayList<User> getUserByName(String name);
    ArrayList<Order> getBookedTickets(User user);
}
