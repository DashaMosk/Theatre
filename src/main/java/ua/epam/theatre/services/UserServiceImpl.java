package ua.epam.theatre.services;

import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.User;
import ua.epam.theatre.dao.UserDao;

import java.util.ArrayList;

/**
 * Created by Daria on 07.02.2016.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(User user) {
        userDao.register(user);
        System.out.println("New user: "+ user);
    }

    public void remove(User user) {
        userDao.remove(user);
        System.out.println("Remove user "+user.getName());
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public ArrayList<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public ArrayList<Order> getBookedTickets(User user) {
        return userDao.getBookedTickets(user);
    }
}
