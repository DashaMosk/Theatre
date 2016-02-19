package ua.epam.theatre.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.epam.theatre.dao.UserDao;
import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.User;
import ua.epam.theatre.services.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria on 07.02.2016.
 */
@Service
@Transactional
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

    public List<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public List<Order> getBookedTickets(User user) {
        return userDao.getBookedTickets(user);
    }
}
