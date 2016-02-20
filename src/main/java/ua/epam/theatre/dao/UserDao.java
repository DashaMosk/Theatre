package ua.epam.theatre.dao;

import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.entity.User;

import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
public interface UserDao {
    void register(User user);
    void remove(User user);
    User getUserByEmail(String email);
    List<User> getUserByName(String name);
    List<Ticket> getBookedTickets(User user);
}
