package ua.epam.theatre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.theatre.dao.UserDao;
import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.User;

import java.util.ArrayList;

/**
 * Created by Daria on 07.02.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
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
