package ua.epam.theatre.dao;

import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.User;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Daria on 07.02.2016.
 */
public class UserDaoImpl implements UserDao {
    public void register(User user) {
        user.setId(TheatreDB.users.size()+1);
        TheatreDB.users.put(user.getEmail(), user);
    }

    public void remove(User user) {
        TheatreDB.users.remove(user.getEmail());
    }

    public User getUserByEmail(String email) {
        return TheatreDB.users.get(email);
    }

    public ArrayList<User> getUserByName(String name) {
        ArrayList<User> usr = new ArrayList<User>();
        for (User u : TheatreDB.users.values()) {
            if(u.getName().equals(name)) {
                usr.add(u);
            }
        }
        return usr;
    }

    public ArrayList<Order> getBookedTickets(User user) {
        ArrayList<Order> ord = new ArrayList<Order>();
        for (Order o : TheatreDB.orders.values()) {
            if(o.getUser().equals(user)) {
                ord.add(o);
            }
        }
        return ord;
    }
}
